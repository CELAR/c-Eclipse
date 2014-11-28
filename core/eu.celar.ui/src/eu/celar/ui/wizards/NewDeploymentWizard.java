package eu.celar.ui.wizards;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudDeploymentService;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudProject;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.ICloudProviderManager;
import eu.celar.core.model.impl.GenericCloudProvider;
import eu.celar.core.reporting.ProblemException;
import eu.celar.tosca.DocumentRoot;
import eu.celar.tosca.core.TOSCAModel;
import eu.celar.tosca.core.TOSCAResource;
import eu.celar.tosca.editor.ToscaDiagramEditor;

import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Nicholas Loulloudes, Stalo Sofokleous
 */
public class NewDeploymentWizard extends Wizard implements INewWizard {

  private TOSCAResource deploymentFile = null;
  private IStructuredSelection selection = null;
  private NewSubmissionWizardSecondPage secondPage = null;
  private TOSCAModel toscaModel;
  private File csar;
  private IFile deploymentIFile;
  private String deploymentURI;
  private GenericCloudProvider genericSelectedProvider = null;
  private ArrayList<String> zipEntries = new ArrayList<String>();

  public NewDeploymentWizard() {
    setNeedsProgressMonitor( true );
    setForcePreviousAndNextButtons( true );
    
    this.deploymentURI = null;
    
    final ICloudProviderManager manager = CloudModel.getCloudProviderManager();
    ICloudProvider selectedProvider = ( ICloudProvider ) manager.getDefault();
    
    if (selectedProvider != null){
      
      this.genericSelectedProvider = (GenericCloudProvider) selectedProvider;
      
      String uri = this.genericSelectedProvider.getUri();
      if (uri!=null){
        if (uri.endsWith( "/" )){
          uri = uri.substring( 0, uri.length()-1 );
        }
        this.deploymentURI = uri;
      }
      else{
        return;
      }
      
      String port = this.genericSelectedProvider.getPort();
      if ( port!=null){
        if (port.endsWith( "/" )){
          port = port.substring( 0, port.length()-1 );
        }
        this.deploymentURI = this.deploymentURI + ":" + port;
      }

    }

  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.wizard.Wizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    
    if (this.genericSelectedProvider == null)
      return true;
    
    // Export CSAR file
    try {
      exportCSAR();
    } catch( IOException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch( CoreException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

      //openISbrowser();
      
      MessageConsole myConsole = findConsole("MyConsole");
      MessageConsoleStream out = myConsole.newMessageStream();
      out.println("Starting deployment procedure...");
    
      String applicationId = describeApplication();
      
      String deploymentId = null;
      if (applicationId!=null){
        deploymentId = deployApplication(applicationId);
      }
      
      if (deploymentId!=null){
        getDeploymentState(deploymentId);
        //terminateDeployment(deploymentId);
      }
      
    return true;
  }
  
  // Call CELAR Manager to submit application description
  private String describeApplication(){

    URL url = null;
    HttpURLConnection connection = null;
    
    String applicationId = null;
    
    try {
      
      //url = new URL ("http://83.212.107.38:8080/application/describe/");
      
      url = new URL (this.deploymentURI + "/application/describe/");
      
      connection = (HttpURLConnection) url.openConnection();
      
      connection.setDoOutput( true );
      connection.setDoInput( true );
      
      connection.setRequestMethod( "POST" );
      
      connection.setRequestProperty("Content-type", "application/octet-stream");
      
      OutputStream reqStream = connection.getOutputStream();
      FileInputStream fis = new FileInputStream( this.csar );
      
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      byte[] buf = new byte[1024];
      try {
          for (int readNum; (readNum = fis.read(buf)) != -1;) {
              bos.write(buf, 0, readNum);
          }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      
      fis.close();
      reqStream.write( bos.toByteArray() );
      
      int responseCode = connection.getResponseCode();
      System.out.println("Response is: "+responseCode);
      
      MessageConsole myConsole = findConsole("MyConsole");
      MessageConsoleStream out = myConsole.newMessageStream();
      out.println("Describing application: HTTP Response is " + responseCode);
      
      
      InputStream inputStream = connection.getInputStream();

      
//      BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//      String inputLine;
//      while ((inputLine = in.readLine()) != null) {
//          System.out.println(inputLine);
//      }
//      in.close();
      
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = null;
      try {
        db = dbf.newDocumentBuilder();
      } catch( ParserConfigurationException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      try {
        Document doc = db.parse(inputStream);
        NodeList nList = doc.getElementsByTagName( "application" );
        for (int i=0; i< nList.getLength(); i++){
          Node nNode = nList.item(i);
   
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
   
              Element eElement = (Element) nNode;
   
              applicationId = eElement.getElementsByTagName("id").item(0).getTextContent();
              
              break;
          }
        }
      } catch( SAXException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      System.out.println("Application Id is: "+applicationId);

      
      connection.disconnect();

  } catch (IOException ex) {
    ex.printStackTrace();
  }
    
    return applicationId;
  }
  
  // Call CELAR Manager to deploy described application
  private String deployApplication(String applicationId){

    URL url = null;
    HttpURLConnection connection = null;
    String deploymentId = null;
    try {
      
      //url = new URL ("http://83.212.107.38:8080/application/" + applicationId +"/deploy/");
      
      url = new URL (this.deploymentURI + "/application/" + applicationId +"/deploy/");
      
      connection = (HttpURLConnection) url.openConnection();
      
      connection.setDoOutput( true );
      connection.setDoInput( true );
      
      connection.setRequestMethod( "POST" );
      
      connection.setRequestProperty("Content-type", "application/octet-stream");
      
      OutputStream reqStream = connection.getOutputStream();
      FileInputStream fis = new FileInputStream( this.csar );
      
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      byte[] buf = new byte[1024];
      try {
          for (int readNum; (readNum = fis.read(buf)) != -1;) {
              bos.write(buf, 0, readNum);
          }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      
      fis.close();
      reqStream.write( bos.toByteArray() );
      
      int responseCode = connection.getResponseCode();
      System.out.println("Response is: "+responseCode);
      
      MessageConsole myConsole = findConsole("MyConsole");
      MessageConsoleStream out = myConsole.newMessageStream();
      out.println("Deploying application: HTTP Response is " + responseCode);
      
      InputStream inputStream = connection.getInputStream();
      
//      BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//      String inputLine;
//      while ((inputLine = in.readLine()) != null) {
//          System.out.println(inputLine);
//      }
//      in.close();
      
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = null;
      try {
        db = dbf.newDocumentBuilder();
      } catch( ParserConfigurationException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      try {
        Document doc = db.parse(inputStream);
        NodeList nList = doc.getElementsByTagName( "deployment" );
        for (int i=0; i< nList.getLength(); i++){
          Node nNode = nList.item(i);
   
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
   
              Element eElement = (Element) nNode;
   
              deploymentId = eElement.getElementsByTagName("deploymentID").item(0).getTextContent();
              
              break;
          }
        }
      } catch( SAXException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      System.out.println("Deployment Id is: "+deploymentId);

      
      connection.disconnect();

  } catch (IOException ex) {
    ex.printStackTrace();
  }
    
    return deploymentId;
  }
  
  // Get deployment state
  private boolean getDeploymentState(String deploymentId){
    URL url = null;
    HttpURLConnection connection = null;

    try {
      
      //url = new URL ("http://83.212.107.38:8080/deployment/" + deploymentId);
      
      url = new URL (this.deploymentURI + "/deployment/" + deploymentId);
      
      connection = (HttpURLConnection) url.openConnection();
      
      connection.setDoOutput( false );
      connection.setDoInput( true );
      
      connection.setRequestMethod( "GET" );
            
      
      int responseCode = connection.getResponseCode();
      System.out.println("Response is: "+responseCode);
      
      MessageConsole myConsole = findConsole("MyConsole");
      MessageConsoleStream out = myConsole.newMessageStream();
      out.println("Getting deployment status: HTTP Response is " + responseCode);
      
      InputStream inputStream = connection.getInputStream();
      
//      BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//      String inputLine;
//      while ((inputLine = in.readLine()) != null) {
//          System.out.println(inputLine);
//      }
//      in.close();
      

      BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
          out.println(inputLine);
      }
      in.close();
      
//      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//      DocumentBuilder db = null;
//      try {
//        db = dbf.newDocumentBuilder();
//      } catch( ParserConfigurationException e ) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//      }
//
//      try {
//        Document doc = db.parse(inputStream);
//        NodeList nList = doc.getElementsByTagName( "deployment" );
//        for (int i=0; i< nList.getLength(); i++){
//          Node nNode = nList.item(i);
//   
//          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//   
//              Element eElement = (Element) nNode;
//   
//              deploymentId = eElement.getElementsByTagName("deploymentID").item(0).getTextContent();
//              
//              break;
//          }
//        }
//      } catch( SAXException e ) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//      }
//      
//      System.out.println("Deployment Id is: "+deploymentId);

      
      connection.disconnect();

  } catch (IOException ex) {
    ex.printStackTrace();
  }
    
    return true;
  }
  
  // Terminate deployment
  private boolean terminateDeployment(String deploymentId){
    URL url = null;
    HttpURLConnection connection = null;

    try {
      
      //url = new URL ("http://83.212.107.38:8080/deployment/" + deploymentId + "/terminate");
      
      url = new URL (this.deploymentURI + "/deployment/" + deploymentId + "/terminate");
      
      connection = (HttpURLConnection) url.openConnection();
      
      connection.setDoOutput( false );
      connection.setDoInput( true );
      
      connection.setRequestMethod( "POST" );
            
      
      int responseCode = connection.getResponseCode();
      System.out.println("Response is: "+responseCode);
      
      InputStream inputStream = connection.getInputStream();
      
      BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
          System.out.println(inputLine);
      }
      in.close();
      
//      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//      DocumentBuilder db = null;
//      try {
//        db = dbf.newDocumentBuilder();
//      } catch( ParserConfigurationException e ) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//      }
//
//      try {
//        Document doc = db.parse(inputStream);
//        NodeList nList = doc.getElementsByTagName( "deployment" );
//        for (int i=0; i< nList.getLength(); i++){
//          Node nNode = nList.item(i);
//   
//          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//   
//              Element eElement = (Element) nNode;
//   
//              deploymentId = eElement.getElementsByTagName("deploymentID").item(0).getTextContent();
//              
//              break;
//          }
//        }
//      } catch( SAXException e ) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//      }
//      
//      System.out.println("Deployment Id is: "+deploymentId);

      
      connection.disconnect();

  } catch (IOException ex) {
    ex.printStackTrace();
  }
    
    return true;
  }
  
  // Opens an internal browser displaying the Information System
  private void openISbrowser() {
    URL ISbrowser = null;
    try {
      ISbrowser = new URL( "http://snf-354013.vm.okeanos.grnet.gr:8080/webFrontend/application/version/deployment/?deplID=9876&tab=monitoring" ); //$NON-NLS-1$
    } catch( MalformedURLException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    IWebBrowser browser;
    try {
      browser = PlatformUI.getWorkbench()
        .getBrowserSupport()
        .createBrowser( "id" ); //$NON-NLS-1$
      browser.openURL( ISbrowser );
    } catch( PartInitException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static String convertToXml( final DocumentRoot eObject )
    throws IOException
  {
    XMLResourceImpl resource = new XMLResourceImpl();
    XMLProcessor processor = new XMLProcessor();
    resource.getDefaultSaveOptions()
      .put( XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE );
    resource.setEncoding( "UTF-8" ); //$NON-NLS-1$
    resource.getContents().add( eObject );
    return processor.saveToString( resource, null );
  }

  @Override
  public void addPages() {
    this.secondPage = new NewSubmissionWizardSecondPage( Messages.getString( "NewSubmissionWizardSecondPage.pageName" ) ); //$NON-NLS-1$
    this.secondPage.setTitle( Messages.getString( "NewSubmissionWizardSecondPage.pageTitle" ) ); //$NON-NLS-1$
    this.secondPage.setDescription( Messages.getString( "NewSubmissionWizardSecondPage.pageDescription" ) ); //$NON-NLS-1$
    addPage( this.secondPage );
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
      
      IResource resourceName = (( TOSCAResource )obj).getResource();
      this.deploymentIFile = (IFile) resourceName;
    }
     if (obj instanceof IFile){
     IFile file = (IFile) obj;
     ICloudElement element = CloudModel.getRoot().findElement( file );
    
     if( element instanceof TOSCAResource ) {
     this.deploymentFile = ( TOSCAResource )element;
     this.toscaModel = this.deploymentFile.getTOSCAModel();
     }
     }
     
  }

  public void exportCSAR() throws IOException, CoreException {
        
    // Export monitoring probes to jar files
//    IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
//    IProject monitoringProbesProject = workspaceRoot.getProject( "MonitoringProbe" );
//    IFolder srcFolder = monitoringProbesProject.getFolder( "src" );
//    IResource[] monitoringProbes = srcFolder.members();  
//    for( IResource monitoringProbeFile : monitoringProbes )
//      exportProbe( ( IFile )monitoringProbeFile );
    
    // Create CSAR
    String csarName = this.deploymentFile.getName();

    this.csar = new File ( System.getProperty("user.home") + System.getProperty( "file.separator" ) + "Desktop" + System.getProperty( "file.separator" ) + csarName.replace( "tosca", "csar" ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    
    FileOutputStream fos = new FileOutputStream( csar );
    ZipOutputStream zos = new ZipOutputStream( fos );
    // File names
    String metaFile = "TOSCA.meta"; //$NON-NLS-1$
    String defFileName = "Application.tosca"; //$NON-NLS-1$
    String keyFileName = "celar.pub"; //$NON-NLS-1$
    // Create dummy TOSCA meta
    addToCSARFile( "TOSCA-Metadata", metaFile, getMetaContent( defFileName ), zos ); //$NON-NLS-1$
    // Create Valid TOSCA
//    DocumentRoot toscaDescription = toscaModel.getDocumentRoot();
//    addToCSARFile( "Definitions", defFileName, convertToXml( toscaDescription ), zos ); //$NON-NLS-1$
    addToCSARFile("Definitions", defFileName, getFileContents(this.deploymentIFile), zos);
    // Create a dummy SSH public key-pair file
    addToCSARFile( "Keys", keyFileName, getKeyPair(), zos ); //$NON-NLS-1$   
    
    IProject activeProject = null;
    Object submissionFile = this.selection.getFirstElement();
    if (submissionFile instanceof TOSCAResource){
      ICloudProject cloudProject = ((TOSCAResource) submissionFile).getProject();
      activeProject = ( IProject )cloudProject.getResource();
    }
    
    //IProject activeProject = ToscaDiagramEditor.getActiveProject();
    IFolder scriptsFolder = activeProject.getFolder( new Path(System.getProperty( "file.separator" ) + "Artifacts" + System.getProperty( "file.separator" ) +"Deployment Scripts" )); //$NON-NLS-1$ //$NON-NLS-2$
    IResource[] scriptFiles = scriptsFolder.members();
    for (IResource resource : scriptFiles){
      IFile tempFile = (IFile) resource;
      String fileName = tempFile.getName();
      if (this.zipEntries.contains( fileName )){
        System.out.println("zip entry exists");
      }
      else{
        this.zipEntries.add( fileName );
        String content = getFileContents( tempFile );
        addToCSARFile("Scripts", fileName, content, zos ); //$NON-NLS-1$
      }
    }   
    
    IFolder resizingScriptsFolder = activeProject.getFolder( new Path(System.getProperty( "file.separator" ) + "Artifacts" + System.getProperty( "file.separator" ) +"Reconfiguration Scripts" )); //$NON-NLS-1$ //$NON-NLS-2$
    scriptFiles = resizingScriptsFolder.members();
    for (IResource resource : scriptFiles){
      IFile tempFile = (IFile) resource;
      String fileName = tempFile.getName();
      if (this.zipEntries.contains( fileName )){
        System.out.println("zip entry exists");
      }
      else{
        String content = getFileContents( tempFile );
        addToCSARFile("Scripts", fileName, content, zos ); //$NON-NLS-1$
      }

    }   
    
    //addToCSARFile("TUW", "CompositionRules", getFileFromGit("https://raw.githubusercontent.com/CELAR/c-Eclipse/master/pom.xml", "pom.xml"), zos);
    
    zos.close();
    fos.close();
  }

  private static String getFileContents(IFile file) {
    
    InputStream in = null;
    try {
      in = file.getContents();
    } catch( CoreException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    InputStreamReader is = new InputStreamReader(in);
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(is);

    String read;
    try {
      read = br.readLine();
     
      while(read != null) {
          sb.append(read);
          sb.append(System.getProperty("line.separator"));
          read = br.readLine();

      }
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return sb.toString();
    
  }
  
  private static String getKeyPair() {
    return "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAgQCn3TzXwzRDtoPRUyRm784Wwa61EhhEd7rvr9qrLVjNvvCv/JP80sgE43LzxlEx7uiHEbzhhQdVHvTozTA2WEzyhVfYEhDhqt5xVl2Xf0skbAc3qLP42hguYXZ7NPtCUEUbQqN0Oo4WafUo4sRG+FNIu+nO66DbZEcmRBv3YYtcOw== AWS-RSA-1024"; //$NON-NLS-1$
  }

//  void exportProbe( IFile file ) throws IOException {
//    IProject activeProject = ToscaDiagramEditor.getActiveProject();
//    IFolder monitoringFolder = activeProject.getFolder( "Monitoring" );
//    IPath jarFilePath = monitoringFolder.getRawLocation()
//      .append( file.getName() )
//      .removeFileExtension()
//      .addFileExtension( "jar" );
//    byte buffer[] = new byte[ 10240 ];
//    // Open archive file
//    FileOutputStream stream = new FileOutputStream( jarFilePath.toString() );
//    JarOutputStream out = new JarOutputStream( stream, new Manifest() );
//    // Add probe file archive entry
//    JarEntry jarAdd = new JarEntry( file.getName() );
//    out.putNextEntry( jarAdd );
//    // Write file to archive
//    FileInputStream in = new FileInputStream( file.getRawLocation().toString() );
//    while( true ) {
//      int nRead = in.read( buffer, 0, buffer.length );
//      if( nRead <= 0 )
//        break;
//      out.write( buffer, 0, nRead );
//    }
//    in.close();
//    out.closeEntry();
//    // Add ProbePack.jar file archive entry
//    jarAdd = new JarEntry( "ProbePack.jar" );
//    out.putNextEntry( jarAdd );
//    // Write file to archive
//
//    in = new FileInputStream( "C:\\Users\\stalo.cs8526\\Desktop\\ProbePack.jar" );
//    while( true ) {
//      int nRead = in.read( buffer, 0, buffer.length );
//      if( nRead <= 0 )
//        break;
//      out.write( buffer, 0, nRead );
//    }
//    in.close();
//    out.closeEntry();
//    out.close();
//    stream.close();
//    // Refresh Cloud Model
//    IProgressMonitor monitor = null;
//    try {
//      CloudModel.getRoot().refresh( monitor );
//    } catch( ProblemException e2 ) {
//      e2.printStackTrace();
//    }
//  }
  void exportProbe( IFile file ) throws IOException {
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    IFolder monitoringFolder = activeProject.getFolder( "Monitoring" ); //$NON-NLS-1$
    IPath jarFilePath = monitoringFolder.getRawLocation()
      .append( file.getName() )
      .removeFileExtension()
      .addFileExtension( "jar" ); //$NON-NLS-1$
    byte buffer[] = new byte[ 10240 ];
    // Open archive file
    FileOutputStream stream = new FileOutputStream( jarFilePath.toString() );
    JarOutputStream out = new JarOutputStream( stream, new Manifest() );
    // Add probe file archive entry
    JarEntry jarAdd = new JarEntry( file.getName() );
    out.putNextEntry( jarAdd );
    // Write file to archive
    FileInputStream in = new FileInputStream( file.getRawLocation().toString() );
    while( true ) {
      int nRead = in.read( buffer, 0, buffer.length );
      if( nRead <= 0 )
        break;
      out.write( buffer, 0, nRead );
    }
    in.close();
    out.closeEntry();
    // Add ProbePack.jar file archive entry
    jarAdd = new JarEntry( "ProbePack.jar" ); //$NON-NLS-1$
    out.putNextEntry( jarAdd );
    // Write file to archive

    in = new FileInputStream( "C:\\Users\\stalo.cs8526\\Desktop\\ProbePack.jar" ); //$NON-NLS-1$
    while( true ) {
      int nRead = in.read( buffer, 0, buffer.length );
      if( nRead <= 0 )
        break;
      out.write( buffer, 0, nRead );
    }
    in.close();
    out.closeEntry();
    out.close();
    stream.close();
    // Refresh Cloud Model
    IProgressMonitor monitor = null;
    try {
      CloudModel.getRoot().refresh( monitor );
    } catch( ProblemException e2 ) {
      e2.printStackTrace();
    }
  }

  private boolean isRedirected( Map<String, List<String>> header ) {
    for( String hv : header.get( null )) {
       if(   hv.contains( " 301 " )
          || hv.contains( " 302 " )) return true;
    }
    return false;
  }
  
  private String getFileFromGit(String link, String fileName) throws IOException{
     URL               url  = new URL( link );
     HttpURLConnection http = (HttpURLConnection)url.openConnection();
     Map< String, List< String >> header = http.getHeaderFields();
     while( isRedirected( header )) {
        link = header.get( "Location" ).get( 0 );
        url    = new URL( link );
        http   = (HttpURLConnection)url.openConnection();
        header = http.getHeaderFields();
     }
     InputStream  input  = http.getInputStream();
     
     String fileContents="";
     BufferedReader in = new BufferedReader(new InputStreamReader(input));
     String inputLine;
     while ((inputLine = in.readLine()) != null) {
         fileContents = fileContents + inputLine + System.getProperty("line.separator");
         //System.out.println(inputLine);
     }
     in.close();
     return fileContents;
  }
  
  
  /**
   * @param dir
   * @param fileName
   * @param content
   * @param zos
   * @throws FileNotFoundException
   * @throws IOException
   */
  public void addToCSARFile( final String dir,
                                    final String fileName,
                                    final String content,
                                    final ZipOutputStream zos )
    throws FileNotFoundException, IOException
  {

    String tmpDir = System.getProperty("java.io.tmpdir") + System.getProperty( "file.separator" ); //$NON-NLS-1$
    File file = new File( tmpDir + fileName );
    if( !file.exists() ) {
      file.createNewFile();
    }
    FileOutputStream fos = new FileOutputStream( file );
    byte[] contentInBytes = content.getBytes();
    fos.write( contentInBytes );
    fos.flush();
    fos.close();
    FileInputStream fis = new FileInputStream( file );
    ZipEntry zipEntry = new ZipEntry( dir + "/" + fileName );    
    zos.putNextEntry( zipEntry );
    byte[] bytes = new byte[ 1024 ];
    int length;
    while( ( length = fis.read( bytes ) ) >= 0 ) {
      zos.write( bytes, 0, length );
    }
    zos.closeEntry();
    fis.close();
  }

  /**
   * @param defFile
   * @return Meta Content
   */
  public static String getMetaContent( String defFile ) {
    StringBuilder sb = new StringBuilder();
    sb.append( "TOSCA-Meta-Version: 1.0\n" ); //$NON-NLS-1$
    sb.append( "CSAR-Version: 1.0\n" ); //$NON-NLS-1$
    sb.append( "Created-By: c-Eclipse\n\n" ); //$NON-NLS-1$
    sb.append( "Name: Definitions" + System.getProperty( "file.separator" ) + defFile + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
    sb.append( "Content-Type: application/vnd.oasis.tosca.definitions\n" ); //$NON-NLS-1$
    return sb.toString();
  }

  /**
   * @return
   */
  public ICloudDeploymentService getDeploymentService() {
    return this.secondPage.getCloudDeploymentService();
  }

  private MessageConsole findConsole( String name ) {
    ConsolePlugin plugin = ConsolePlugin.getDefault();
    IConsoleManager conMan = plugin.getConsoleManager();
    IConsole[] existing = conMan.getConsoles();
    for( int i = 0; i < existing.length; i++ )
      if( name.equals( existing[ i ].getName() ) )
        return ( MessageConsole )existing[ i ];
    // no console found, so create a new one
    MessageConsole myConsole = new MessageConsole( name, null );
    conMan.addConsoles( new IConsole[]{
      myConsole
    } );
    return myConsole;
  }
}
