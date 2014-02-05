package eu.celar.ui.wizards;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

import eu.celar.connectors.aws.EC2Client;
import eu.celar.connectors.aws.operation.EC2OpDeployApplication;
import eu.celar.connectors.aws.operation.OperationExecuter;
import eu.celar.core.model.ICloudApplicationDescription;
import eu.celar.core.model.ICloudDeploymentCreator;
import eu.celar.tosca.core.TOSCAModel;
import eu.celar.tosca.core.TOSCAResource;
import eu.celar.tosca.editor.Activator;
import eu.celar.ui.wizards.wizardselection.IInitializableWizard;


public abstract class OldDeploymentWizard extends Wizard implements IInitializableWizard, IExecutableExtension{

  private IStructuredSelection selection;
  private NewSubmissionWizardSecondPage secondPage;
  
  private ICloudDeploymentCreator creator;
  private TOSCAResource deploymentFile;
  private String deploymentString;
  private WrapperInitObject initObject;
  private ArrayList<ICloudApplicationDescription> applicationDescriptions;
  
  
  protected OldDeploymentWizard () {
    setNeedsProgressMonitor( true );
  }
  
//  @Override
//  public void init( final IWorkbench workbench, final IStructuredSelection selection ) {
//    setWindowTitle( Messages.getString( "NewApplicationSubmissionWizard.windowTitle" ) ); //$NON-NLS-1$
//    this.selection = selection;    
//    if (this.selection.getFirstElement() instanceof TOSCAResource) {
//      this.deploymentFile = (TOSCAResource) selection;  
//    }
//    
//  }
  
  @Override
  public void addPages() {
    
    this.secondPage = new NewSubmissionWizardSecondPage( Messages.getString( "NewSubmissionWizardSecondPage.pageName" )); //$NON-NLS-1$
    this.secondPage.setTitle( Messages.getString( "NewSubmissionWizardSecondPage.pageTitle" ) ); //$NON-NLS-1$
    this.secondPage.setDescription( Messages.getString( "NewSubmissionWizardSecondPage.pageDescription" ) ); //$NON-NLS-1$
    addPage( this.secondPage );
  }
  
  @Override
  public boolean performFinish() {
	  
    //Convert Deployment file to String
//    TOSCAModel toscaModel = this.deploymentFile.getTOSCAModel();
	    
//    EC2OpDeployApplication deployOperation = new EC2OpDeployApplication( EC2Client.getEC2(), toscaModel );
//	new OperationExecuter().execOp( deployOperation );
//	      localMonitor.worked( 1 );
//	    
//	    //Convert TOSCA Application Description file to String
//	    BufferedReader br = null;
//	    StringBuilder sb = new StringBuilder();
//	    String line;
//	    
//	    try {
//	      br = new BufferedReader(new InputStreamReader(this.deploymentFile.getContents()));
//	    } catch( CoreException e1 ) {
//	      e1.printStackTrace();
//	    }
//
//	    try {
//	      while ((line = br.readLine()) != null) {
//	          sb.append(line);
//	      }
//	    } catch( IOException e1 ) {
//	      e1.printStackTrace();
//	    }
//	    
//	    this.deploymentString = sb.toString();
//    
//	    String ycsbPattern = "ycsbmulti="+"\"";
//	    String[] ycsb = this.deploymentString.split(ycsbPattern);
//	    Integer ycsbMulti1 = Integer.parseInt(ycsb[1].substring(0, ycsb[1].indexOf("\"")));
//	    Integer ycsbMulti2 = Integer.parseInt(ycsb[2].substring(0, ycsb[2].indexOf("\"")));    
//	    Integer ycsbMulti;
//	    if (ycsbMulti1!=1)
//	    	ycsbMulti = ycsbMulti1;
//	    else if (ycsbMulti2!=1)
//	    	ycsbMulti = ycsbMulti2;
//	    else
//	    	ycsbMulti = 1;
//	    
//	    String casPattern = "casmulti="+"\"";
//	    String[] cas = this.deploymentString.split(casPattern);
//	    Integer casMulti1 = Integer.parseInt(cas[1].substring(0, cas[1].indexOf("\"")));
//	    Integer casMulti2 = Integer.parseInt(cas[2].substring(0, cas[2].indexOf("\"")));   
//	    Integer casMulti;
//	    if (casMulti1!=1)
//	    	casMulti = casMulti1;
//	    else if (casMulti2!=1)
//	    	casMulti = casMulti2;
//	    else
//	    	casMulti = 1;
//	    
//    //Deploy Cassandra application using HTTP
//    URL url = null;
//    HttpURLConnection connection = null;
//    try {
//      url = new URL ("http://83.212.116.50:8080/celar-server-api/deployment/deploy/?" + "casmulti=" + casMulti + "&ycsbmulti=" + ycsbMulti);
//  
//      connection = (HttpURLConnection) url.openConnection();
//
//      connection.setRequestMethod( "GET" );
//      
//      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//      String inputLine;
//      while ((inputLine = in.readLine()) != null) {
//          System.out.println(inputLine);
//      }
//      in.close();
//      
//      connection.disconnect();
//      
//    } catch( MalformedURLException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch( IOException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }

    return true;
    
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String, java.lang.Object)
   */
  @Override
  public void setInitializationData( final IConfigurationElement config,
                                     final String propertyName,
                                     final Object data ) throws CoreException
  {
    IConfigurationElement[] elements = config.getDeclaringExtension()
        .getConfigurationElements();
      for( IConfigurationElement element : elements ) {
        if( "job_creator".equals( element.getName() ) ) { //$NON-NLS-1$
          Object obj = element.createExecutableExtension( "class" ); //$NON-NLS-1$
          if( !( obj instanceof ICloudDeploymentCreator ) ) {
            String errorMessage = "Deployment Creator configured in class atribute for deployment_creator " //$NON-NLS-1$
                                  + "element in eu.celar.ui.wizards.NewDeploymentWizard " //$NON-NLS-1$
                                  + "is not implementing ICloudDeploymentCreator interface"; //$NON-NLS-1$
            Status status = new Status( IStatus.ERROR,
                                        Activator.PLUGIN_ID,
                                        IStatus.OK,
                                        errorMessage,
                                        null );
            throw new CoreException( status );
          }
          this.creator = ( ICloudDeploymentCreator )obj;
        }
      }    
  }

  /* (non-Javadoc)
   * @see eu.celar.ui.wizards.wizardselection.IInitializableWizard#init(java.lang.Object)
   */
  @Override
  public boolean init( final Object data ) {
    boolean result = false;
    if( data instanceof WrapperInitObject ) {
      this.initObject = ( WrapperInitObject )data;
      this.applicationDescriptions = new ArrayList<ICloudApplicationDescription>( this.initObject.getApplicationDescriptions() );
//      this.jobNames = new ArrayList<String>( this.initObject.getJobNames() );
      result = true;
    }
    return result;
  }
  
  private Shell getWizardShell() {
    Shell shell = null;
    if( getContainer() != null ) {
      shell = getContainer().getShell();
    }
    return shell;
  }

}
