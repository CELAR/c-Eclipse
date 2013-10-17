package eu.celar.ui.wizards;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.xml.sax.SAXException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import eu.celar.core.model.CloudModel;
import eu.celar.core.reporting.ProblemException;


public class NewSubmissionWizard extends Wizard implements INewWizard{

  private IStructuredSelection selection;
  private NewSubmissionWizardFirstPage firstPage;
  private NewSubmissionWizardSecondPage secondPage;
  
  //private IFile deploymentfile;
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
    
    // Validate Application Description file
    Boolean validTOSCA = false;
    try {
      validTOSCA = validateTOSCA();
    } catch( IOException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch( SAXException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    if ( !validTOSCA )
      return false;
    
    
    // Create Application Deployment file
    createFile();
    
    //Convert TOSCA Application Description file to String
    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();
    String line;
    
    try {
      br = new BufferedReader(new InputStreamReader(this.toscaFile.getContents()));
    } catch( CoreException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    try {
      while ((line = br.readLine()) != null) {
          sb.append(line);
      }
    } catch( IOException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
    String toscaString = sb.toString();
    
    //Send Application Description to CELAR Server over HTTP
    URL url = null;
    HttpURLConnection connection = null;
    try {
      url = new URL ("http://83.212.124.172:8080/celar-server-api/application/describe/");

      String httpParameters = "description=" + URLEncoder.encode( toscaString, "UTF-8" );
      
      connection = (HttpURLConnection) url.openConnection();
      connection.setDoOutput( true );
      connection.setDoInput( true );
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      connection.setRequestProperty("Content-Length", "" + Integer.toString(httpParameters.getBytes().length));
      connection.setRequestMethod( "POST" );
      
      OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
      out.write(httpParameters);
      out.close();
      
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
          System.out.println(inputLine);
      }
      in.close();
      
      connection.disconnect();
      
    } catch( MalformedURLException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
    
  }
  
  // Creates the Application Deployment file
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
    
  }
  
  // Validates TOSCA file before passing it to CELAR Server
  boolean validateTOSCA() throws IOException, SAXException{
    // 1. Specify you want a factory for RELAX NG
    SchemaFactory factory 
     = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    
    // Load the specific schema you want. 
    
    File schemaLocation = new File("/Users/stalo.cs8526/git/c-Eclipse/app-description/eu.celar.tosca/model/NewXMLSchema.xsd");
    // Compile the schema.
    Schema schema = factory.newSchema(schemaLocation);
    
    //URL schemaFile = new URL("http://docs.oasis-open.org/tosca/TOSCA/v1.0/cs01/schemas/TOSCA-v1.0.xsd");
    //Schema schema = factory.newSchema(schemaFile);

    // Get a validator from the schema.
    Validator validator = schema.newValidator();
    
    // Parse the document you want to check.
    IFile ifile = this.toscaFile; 
    
    File input = new File(ifile.getLocation().toOSString());

    // Check the document
    try {
        validator.validate( new StreamSource( input) );
        System.out.println("TOSCA is valid.");
    }
    catch (SAXException ex) {
        System.out.println("TOSCA is not valid because ");
        System.out.println(ex.getMessage());
        return false;
    }  
    return true;
  }
}
