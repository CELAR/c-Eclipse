/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
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
  }

  @Override
  public boolean canFinish() {
    //return ( firstPage.isPageComplete() && basicPage.isPageComplete() );
    return firstPage.isPageComplete();
    //return super.canFinish();
  }

  public boolean createFile() {
    String fileName = this.firstPage.getFileName();
    IPath path = new Path( fileName );
    fileName = path.removeFileExtension()
      .addFileExtension( "tosca" )
      .lastSegment();
    this.firstPage.setFileName( fileName );
    this.file = firstPage.createNewFile();        
    
    //Tosca files must be under Application Descriptions folder    
    String toscaFilePath = this.file.getParent().getLocation().lastSegment();
    
    if (toscaFilePath.compareTo( "Application Descriptions" )!=0){
      String cloudProjectPath = (this.file).getFullPath().segment( 0 );
      IProgressMonitor monitor = null;
      try {
        this.file.move( new Path("/"+cloudProjectPath+ "/Application Descriptions/" + fileName), true, monitor );
      } catch( IllegalStateException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch( CoreException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
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
    String appName = this.firstPage.getFileName().replace( ".tosca", "" );
    toscaResource.setApplicationName( appName );
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
