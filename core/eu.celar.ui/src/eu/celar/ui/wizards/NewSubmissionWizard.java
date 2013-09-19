package eu.celar.ui.wizards;


import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.reporting.ProblemException;
import eu.celar.tosca.core.TOSCAResource;


public class NewSubmissionWizard extends Wizard implements INewWizard{

  private IStructuredSelection selection;
  private NewSubmissionWizardFirstPage firstPage;
  private NewSubmissionWizardSecondPage secondPage;
  
  private IFile deploymentfile;
  private IFile toscaFile;

  @Override
  public void init( IWorkbench workbench, IStructuredSelection selection ) {
    setWindowTitle( Messages.getString( "NewApplicationSubmissionWizard.windowTitle" ) ); //$NON-NLS-1$
    this.selection = selection;
  }
  
  @Override
  public void addPages() {

    this.firstPage = new NewSubmissionWizardFirstPage( Messages.getString( "NewSubmissionWizardFirstPage.pageName" ), selection ); //$NON-NLS-1$
    this.firstPage.setTitle( Messages.getString( "NewSubmissionWizardFirstPage.pageTitle" ) ); //$NON-NLS-1$
    this.firstPage.setDescription( Messages.getString( "NewSubmissionWizardFirstPage.pageDescription" ) ); //$NON-NLS-1$
    addPage( this.firstPage );
    
    this.secondPage = new NewSubmissionWizardSecondPage( Messages.getString( "NewSubmissionWizardSecondPage.pageName" )); //$NON-NLS-1$
    this.secondPage.setTitle( Messages.getString( "NewSubmissionWizardSecondPage.pageTitle" ) ); //$NON-NLS-1$
    this.secondPage.setDescription( Messages.getString( "NewSubmissionWizardSecondPage.pageDescription" ) ); //$NON-NLS-1$
    addPage( this.secondPage );

  }
  
  @Override
  public boolean performFinish() {
  
    //Send Application Description to CELAR Server over HTTP
      
        
    
    return createFile();
    
  }
  
  public boolean createFile() {
         
    String fileName = this.firstPage.getFileName();
    IPath path = new Path( fileName );
    fileName = path.removeFileExtension()
      .addFileExtension( "deployment" )
      .lastSegment();
    this.firstPage.setFileName( fileName );
    
    //this.deploymentfile = firstPage.createNewFile();

    Object tempFile = this.selection.getFirstElement();
    this.toscaFile = (IFile) tempFile;
    String cloudProjectPath = (this.toscaFile).getFullPath().segment( 0 );
    
    boolean fileCreated = false; 
        
    String targetPath =  Platform.getLocation() + "/" + cloudProjectPath + "/Application Submissions/" +  fileName;
    File tmp = new File( targetPath );
    try {
      fileCreated = tmp.createNewFile();
    } catch( IOException e ) {
      e.printStackTrace();
    }
   
    IProgressMonitor monitor = null;
    try {
      CloudModel.getRoot().refresh( monitor );
    } catch( ProblemException e ) {
      e.printStackTrace();
    }
    return fileCreated;
    
//    TOSCAResource toscaResource = null;
//    ICloudElement element = CloudModel.getRoot().findElement( this.file );
//    if( element instanceof TOSCAResource ) {
//      toscaResource = ( TOSCAResource )element;
//    }
//    if( toscaResource != null ) {
//      //setInitialModel( toscaResource );
//      toscaResource.save();
//    }
//    return true;
  }
}
