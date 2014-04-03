package eu.celar.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import eu.celar.connectors.aws.EC2Client;
import eu.celar.connectors.aws.operation.EC2OpDeployApplication;
import eu.celar.connectors.aws.operation.OperationExecuter;
//import eu.celar.connectors.openstack.OpenStackClient;
//import eu.celar.connectors.openstack.operation.OpenStackOpDeployApplication;
//import eu.celar.connectors.openstack.operation.OperationExecuter;
import eu.celar.core.model.ICloudDeploymentService;
import eu.celar.core.model.ICloudProject;
import eu.celar.core.reporting.ProblemException;
import eu.celar.tosca.core.TOSCAModel;
import eu.celar.tosca.core.TOSCAResource;

/**
 * @author Nicholas Loulloudes
 */
public class NewDeploymentWizard extends Wizard implements INewWizard {

  private List<ICloudDeploymentService> deploymentServices = null;
  private TOSCAResource deploymentFile = null;
  private IStructuredSelection selection = null;
  private NewSubmissionWizardSecondPage secondPage = null;
  private TOSCAModel toscaModel;

  public NewDeploymentWizard() {
    setNeedsProgressMonitor( true );
    setForcePreviousAndNextButtons( true );
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.wizard.Wizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    try {
      getContainer().run( false, false, new IRunnableWithProgress() {

        @Override
        public void run( final IProgressMonitor monitor )
          throws InvocationTargetException, InterruptedException
        {
          EC2OpDeployApplication deployOperation = null;
//          OpenStackOpDeployApplication deployOperation = null;
          try {
            monitor.beginTask( "Deploying VMIs", 2 );
            deployOperation = new EC2OpDeployApplication( EC2Client.getEC2(),
                                                          NewDeploymentWizard.this.deploymentFile );
            
//          deployOperation = new OpenStackOpDeployApplication( OpenStackClient.getInstance(),
//          NewDeploymentWizard.this.deploymentFile );
            if( deployOperation.getException() != null ) {
              throw deployOperation.getException();
            }
            new OperationExecuter().execOp( deployOperation );
          } catch( Exception e ) {
            e.printStackTrace( );
            
          } finally {
            monitor.done();
          }
        }
      } );
    } catch (final Exception ex) {
      ex.printStackTrace();
//      Display display = PlatformUI.getWorkbench().getDisplay();
//      display.asyncExec( new Runnable() {
//
//        public void run() {
//          IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench()
//            .getActiveWorkbenchWindow();
//          ProblemDialog.openProblem( workbenchWindow.getShell(),
//                                     Messages.getString("AddAttributeWizard.problem_granting_access_permission_title"), //$NON-NLS-1$
//                                     Messages.getString("AddAttributeWizard.problem_granting_access_permission_description"), //$NON-NLS-1$
//                                     ex );
//        }
//      } );
      return false;
    }

    return true;
  }

  @Override
  public void addPages() {
    this.deploymentServices = new ArrayList<ICloudDeploymentService>();
    getDeploymentServicesJob();
    this.secondPage = new NewSubmissionWizardSecondPage( Messages.getString( "NewSubmissionWizardSecondPage.pageName" ) ); //$NON-NLS-1$
    this.secondPage.setTitle( Messages.getString( "NewSubmissionWizardSecondPage.pageTitle" ) ); //$NON-NLS-1$
    this.secondPage.setDescription( Messages.getString( "NewSubmissionWizardSecondPage.pageDescription" ) ); //$NON-NLS-1$
    addPage( this.secondPage );
  }

  /**
   * 
   */
  private void getDeploymentServicesJob() {
    Job job = new Job( "Retrieving list of job services" ) {

      @Override
      protected IStatus run( final IProgressMonitor monitor ) {
        // assert JobCreatorSelectionWizard.this.jobDescriptions != null;
        // assert JobCreatorSelectionWizard.this.jobDescriptions.get( 0 ) !=
        // null;
        ICloudDeploymentService[] allServices = null;
        ICloudProject project = NewDeploymentWizard.this.deploymentFile.getProject();
        assert project != null;
        assert project.getCloudProvider() != null;
        try {
          allServices = project.getCloudProvider().getDeploymentServices( null );
          boolean valid;
          for( ICloudDeploymentService service : allServices ) {
            valid = true;
            if( !service.canDeploy( NewDeploymentWizard.this.deploymentFile ) )
            {
              valid = false;
            }
            if( valid == true ) {
              NewDeploymentWizard.this.deploymentServices.add( service );
            }
          }
          IWorkbench workbench = PlatformUI.getWorkbench();
          Display display = workbench.getDisplay();
          display.syncExec( new Runnable() {

            public void run() {
              // List<IGridJobService> synchronizedList =
              // Collections.synchronizedList( jobServices );
              NewDeploymentWizard.this.secondPage.setServices( NewDeploymentWizard.this.deploymentServices );
            }
          } );
        } catch( ProblemException e ) {
          return Status.CANCEL_STATUS;
        }
        return Status.OK_STATUS;
      }
    };
    job.setUser( true );
    job.schedule();
  }

  @Override
  public boolean canFinish() {
    return super.canFinish();
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
   * org.eclipse.jface.viewers.IStructuredSelection)
   */
  @Override
  public void init( final IWorkbench workbench,
                    final IStructuredSelection selection )
  {
    setWindowTitle( Messages.getString( "NewApplicationSubmissionWizard.windowTitle" ) ); //$NON-NLS-1$
    this.selection = selection;
    Object obj = this.selection.getFirstElement();
    if( obj instanceof TOSCAResource ) {
      this.deploymentFile = ( TOSCAResource )obj;
      this.toscaModel = this.deploymentFile.getTOSCAModel();
    }
    // if (obj instanceof IFile){
    // IFile file = (IFile) obj;
    // ICloudElement element = CloudModel.getRoot().findElement( file );
    //
    // if( element instanceof TOSCAResource ) {
    // this.deploymentFile = ( TOSCAResource )element;
    // this.toscaModel = this.deploymentFile.getTOSCAModel();
    // }
    // }
  }

  /**
   * @return
   */
  public ICloudDeploymentService getDeploymentService() {
    return this.secondPage.getCloudDeploymentService();
  }
}
