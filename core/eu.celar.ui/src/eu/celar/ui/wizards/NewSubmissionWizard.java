package eu.celar.ui.wizards;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.attribute.UserDefinedFileAttributeView;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.framework.adaptor.FilePath;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.reporting.ProblemException;
import eu.celar.tosca.DocumentRoot;
import eu.celar.tosca.core.TOSCAModel;
import eu.celar.tosca.core.TOSCAResource;
import eu.celar.tosca.elasticity.ServicePropertiesType;


public class NewSubmissionWizard extends Wizard implements INewWizard{

  private IStructuredSelection selection;
  private NewSubmissionWizardFirstPage firstPage;
  private CloudProviderSelectionWizardPage secondPage;
  private IFile toscaFile;
  private CloudProviderSelectionWizardPage providersWizard;

  @Override
  public void init( final IWorkbench workbench, final IStructuredSelection selection ) {
    setWindowTitle( Messages.getString( "NewApplicationSubmissionWizard.windowTitle" ) ); //$NON-NLS-1$
    this.selection = selection;
  }
  
  @Override
  public void addPages() {

    this.firstPage = new NewSubmissionWizardFirstPage( Messages.getString( "NewSubmissionWizardFirstPage.pageName" ), this.selection ); //$NON-NLS-1$
    this.firstPage.setTitle( Messages.getString( "NewSubmissionWizardFirstPage.pageTitle" ) ); //$NON-NLS-1$
    this.firstPage.setDescription( Messages.getString( "NewSubmissionWizardFirstPage.pageDescription" ) ); //$NON-NLS-1$
    
    providersWizard = this.secondPage = new CloudProviderSelectionWizardPage( true );
    this.secondPage.setTitle( "Cloud Provider Selection" ); //$NON-NLS-1$
    this.secondPage.setDescription( "Select the target Cloud Provider for the Application" );
    addPage( this.firstPage );
    addPage( this.secondPage );

  }
  
  @Override
  public boolean performFinish() {
    
//    // Validate Application Description file
//    Boolean validTOSCA = false;
//    try {
//      validTOSCA = validateTOSCA();
//    } catch( IOException e1 ) {
//      // TODO Auto-generated catch block
//      e1.printStackTrace();
//    } catch( SAXException e1 ) {
//      // TODO Auto-generated catch block
//      e1.printStackTrace();
//    }
//    if ( !validTOSCA )
//      return false;

	  
    Object obj = this.selection.getFirstElement();
    
    if( obj instanceof TOSCAResource )  {
      
      TOSCAResource tosca = (TOSCAResource) obj;

      // Create Application Deployment file
      createDeploymentFile( tosca );
    }
    
    return true;
    
  }
  
  // Creates the Application Deployment file
  public boolean createDeploymentFile( final TOSCAResource resource ) {
    
    String fileName = this.firstPage.getFileName();
    IPath path = new Path( fileName );
    fileName = path.removeFileExtension()
      .addFileExtension( "tosca" ) //$NON-NLS-1$
      .lastSegment();
    
    this.firstPage.setFileName( fileName );
    
    //////////////////////////////////////////////
    
//    IProgressMonitor monitor = null;
//    IProject project = resource.getProject().getResource().getProject();
//    String cloudProjectPath = project.getFullPath().segment( 0 );
//
//    try {
//      resource.getResource().copy( new Path(File.separator+cloudProjectPath+ System.getProperty( "file.separator" )+ "Application Submissions" +File.separator+ fileName), true, monitor );
//    } catch( CoreException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//
//    try {
//      CloudModel.getRoot().refresh( monitor );
//    } catch( ProblemException e ) {
//      e.printStackTrace();
//    }
//    
//    return true;
    
    //////////////////////////////////////////////
    
  boolean fileCreated = false;
     
  IProject project = resource.getProject().getResource().getProject();
  
  IFile file = project.getFile( System.getProperty( "file.separator" ) + "Application Submissions" + System.getProperty( "file.separator" ) + fileName ); //$NON-NLS-1$
  
  try {
    IResource resourceName = resource.getResource();
    this.toscaFile = (IFile) resourceName;
    
    DocumentRoot model = TOSCAModel.loadModelFromFile( this.toscaFile );
       
    //Add providers' selection to tosca submission file
    ICloudProvider[] providers = providersWizard.getSelectedCloudProviders();
    ServicePropertiesType serviceProperties = (ServicePropertiesType) model.getDefinitions().getServiceTemplate().get( 0 ).getBoundaryDefinitions().getProperties().getAny().get( 0 ).getValue();
    for (ICloudProvider provider : providers){
      serviceProperties.getHostingEnvironment().add( provider.getName() );
    }
    
    TOSCAModel.saveModelToFile( file, model );  
  } catch( Exception e ) {
    e.printStackTrace();
  }
  
  IProgressMonitor monitor = null;
  try {
    CloudModel.getRoot().refresh( monitor );
  } catch( ProblemException e ) {
    e.printStackTrace();
  }  
  return fileCreated;
  
  }
    
//  // Validates TOSCA file before passing it to CELAR Server
//  boolean validateTOSCA() throws IOException, SAXException{
//    // 1. Specify you want a factory for RELAX NG
//    SchemaFactory factory 
//     = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//    
//    // Load the specific schema you want. 
//    
//    File schemaLocation = new File("/Users/stalo.cs8526/git/c-Eclipse/app-description/eu.celar.tosca/model/NewXMLSchema.xsd");
//    // Compile the schema.
//    Schema schema = factory.newSchema(schemaLocation);
//    
//    //URL schemaFile = new URL("http://docs.oasis-open.org/tosca/TOSCA/v1.0/cs01/schemas/TOSCA-v1.0.xsd");
//    //Schema schema = factory.newSchema(schemaFile);
//
//    // Get a validator from the schema.
//    Validator validator = schema.newValidator();
//    
//    // Parse the document you want to check.
//    IFile ifile = this.toscaFile; 
//    
//    File input = new File(ifile.getLocation().toOSString());
//
//    // Check the document
//    try {
//        validator.validate( new StreamSource( input) );
//        System.out.println("TOSCA is valid.");
//    }
//    catch (SAXException ex) {
//        System.out.println("TOSCA is not valid because ");
//        System.out.println(ex.getMessage());
//        return false;
//    }  
//    return true;
//  }
}
