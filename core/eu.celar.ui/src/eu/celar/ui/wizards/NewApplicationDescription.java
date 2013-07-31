/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.tosca.core.TOSCAResource;
import eu.celar.tosca.editor.ToscaDiagramCreator;
import eu.celar.tosca.editor.ToscaFileService;
import eu.celar.ui.internal.Activator;

public class NewApplicationDescription extends Wizard implements INewWizard {

  private IStructuredSelection selection;
  private ApplicationDescriptionFirstPage firstPage;
  private ApplicationDescriptionBasicPage basicPage;
  private IFile file;

  @Override
  public void init( IWorkbench workbench, IStructuredSelection selection ) {
    setWindowTitle( Messages.getString( "NewApplicationDescriptionWizard.windowTitle" ) ); //$NON-NLS-1$
    this.selection = selection;
    setNeedsProgressMonitor( true );
  }

  @Override
  public boolean performFinish() {
    // TODO Stalo
    boolean creationResult = createFile();
    // openFile();
    // Open TOSCA Editor
    if( creationResult ) {
      IRunnableWithProgress op = new IRunnableWithProgress() {

        @Override
        public void run( IProgressMonitor monitor )
          throws InvocationTargetException
        {
          try {
            IPath path = NewApplicationDescription.this.file.getFullPath();
            // get or create the corresponding temporary folder
            final IFolder tempFolder = ToscaFileService.getOrCreateTempFolder( path );
            // finally get the diagram file that corresponds to the data file
            final IFile diagramFile = ToscaFileService.getTemporaryDiagramFile( path,
                                                                                tempFolder );
            ToscaDiagramCreator creator = new ToscaDiagramCreator();
            creator.createToscaDiagram( NewApplicationDescription.this.file,
                                        diagramFile,
                                        null,
                                        true );
          } catch( Exception e ) {
            e.printStackTrace();
          } finally {
            monitor.done();
          }
        }
      };
      try {
        getContainer().run( true, false, op );
      } catch( InterruptedException e ) {
        return false;
      } catch( InvocationTargetException e ) {
        Throwable realException = e.getTargetException();
        MessageDialog.openError( getShell(),
                                 "Error",
                                 realException.getMessage() );
        return false;
      }
      return true;
    }
    return true;
  }

  @Override
  public void addPages() {
    this.firstPage = new ApplicationDescriptionFirstPage( Messages.getString( "NewApplicationDescriptionWizard.pageName" ), selection ); //$NON-NLS-1$
    this.firstPage.setTitle( Messages.getString( "NewApplicationDescriptionFirstPage.pageTitle" ) ); //$NON-NLS-1$
    this.firstPage.setDescription( Messages.getString( "NewApplicationDescriptionFirstPage.pageDescription" ) ); //$NON-NLS-1$
    addPage( this.firstPage );
    this.basicPage = new ApplicationDescriptionBasicPage( Messages.getString( "NewApplicationDescriptionBasicPage.pageName" ) ); //$NON-NLS-1$
    this.basicPage.setTitle( Messages.getString( "NewApplicationDescriptionBasicPage.pageTitle" ) ); //$NON-NLS-1$
    this.basicPage.setDescription( Messages.getString( "NewApplicationDescriptionBasicPage.pageDescription" ) ); //$NON-NLS-1$
    addPage( this.basicPage );
  }

  @Override
  public boolean canFinish() {
    // TODO Auto-generated method stub
    return ( firstPage.isPageComplete() && basicPage.isPageComplete() );
    // return super.canFinish();
  }

  public boolean createFile() {
    // TODO Stalo
    String fileName = this.firstPage.getFileName();
    IPath path = new Path( fileName );
    fileName = path.removeFileExtension()
      .addFileExtension( "tosca" )
      .lastSegment();
    this.firstPage.setFileName( fileName );
    this.file = firstPage.createNewFile();
    TOSCAResource toscaResource = null;
    ICloudElement element = CloudModel.getRoot().findElement( this.file );
    if( element instanceof TOSCAResource ) {
      toscaResource = ( TOSCAResource )element;
    }
    if( toscaResource != null ) {
      setInitialModel( toscaResource );
      toscaResource.save();
    }
    return true;
  }

  private void setInitialModel( final TOSCAResource toscaResource ) {
    toscaResource.setUpBasicTOSCAStructure();
    String appName = this.basicPage.getApplicationName();
    toscaResource.setApplicationName( appName );
    String optimizationPolicy = this.basicPage.getOptimizationPolicy();
    toscaResource.setOptimizationPolicy( optimizationPolicy );
    Hashtable<String, String> requirementList = this.basicPage.getGlobalElasticityRequirement();
    toscaResource.setGlobalElasticityRequirements( requirementList );
  }

  private void openFile() {
    try {
      if( this.file.exists() ) {
        IDE.openEditor( Activator.getDefault()
          .getWorkbench()
          .getActiveWorkbenchWindow()
          .getActivePage(), this.file, true );
      }
    } catch( PartInitException partInitException ) {
      partInitException.printStackTrace();
    }
  }
}
