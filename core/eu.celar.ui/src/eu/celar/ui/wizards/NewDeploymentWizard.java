package eu.celar.ui.wizards;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
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
import eu.celar.core.reporting.ProblemException;
import eu.celar.tosca.DocumentRoot;
import eu.celar.tosca.core.TOSCAModel;
import eu.celar.tosca.core.TOSCAResource;
import eu.celar.tosca.editor.ToscaDiagramEditor;

import org.eclipse.ui.browser.IWebBrowser;

/**
 * @author Nicholas Loulloudes, Stalo Sofokleous
 */
public class NewDeploymentWizard extends Wizard implements INewWizard {

  private TOSCAResource deploymentFile = null;
  private IStructuredSelection selection = null;
  private NewSubmissionWizardSecondPage secondPage = null;
  private TOSCAModel toscaModel;
  private File csar;

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
    // Open IS browser in c-Eclipse
    openISbrowser();
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

    this.csar = new File ( System.getProperty("user.home") + File.separator + "Desktop" + File.separator + csarName.replace( "tosca", "csar" ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    
    FileOutputStream fos = new FileOutputStream( csar );
    ZipOutputStream zos = new ZipOutputStream( fos );
    // File names
    String metaFile = "TOSCA.meta"; //$NON-NLS-1$
    String defFileName = "Application.tosca"; //$NON-NLS-1$
    String keyFileName = "celar.pub"; //$NON-NLS-1$
    // Create dummy TOSCA meta
    addToCSARFile( "TOSCA-Metadata", metaFile, getMetaContent( defFileName ), zos ); //$NON-NLS-1$
    // Create Valid TOSCA
    DocumentRoot toscaDescription = toscaModel.getDocumentRoot();
    addToCSARFile( "Definitions", defFileName, convertToXml( toscaDescription ), zos ); //$NON-NLS-1$
    // Create a dummy SSH public key-pair file
    addToCSARFile( "Keys", keyFileName, getKeyPair(), zos ); //$NON-NLS-1$
    
    
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    IFolder scriptsFolder = activeProject.getFolder( new Path(File.separator + "Artifacts" + File.separator +"Deployment Scripts" )); //$NON-NLS-1$ //$NON-NLS-2$
    IResource[] scriptFiles = scriptsFolder.members();
    for (IResource resource : scriptFiles){
      IFile tempFile = (IFile) resource;
      String fileName = tempFile.getName();
      String content = getFileContents( tempFile );

      addToCSARFile("Scripts", fileName, content, zos ); //$NON-NLS-1$
    }   
    
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

  /**
   * @param dir
   * @param fileName
   * @param content
   * @param zos
   * @throws FileNotFoundException
   * @throws IOException
   */
  public static void addToCSARFile( final String dir,
                                    final String fileName,
                                    final String content,
                                    final ZipOutputStream zos )
    throws FileNotFoundException, IOException
  {
    System.out.println( "Writing '" + dir + File.separator + fileName + "' to CSAR file" ); //$NON-NLS-1$ //$NON-NLS-2$
    String tmpDir = System.getProperty("java.io.tmpdir") + File.separator; //$NON-NLS-1$
    System.out.println( "O/S Temp Dir: " + tmpDir ); //$NON-NLS-1$
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
    ZipEntry zipEntry = new ZipEntry( dir + File.separator + fileName );
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
    sb.append( "Name: Definitions" + File.separator + defFile + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
    sb.append( "Content-Type: application/vnd.oasis.tosca.definitions\n" ); //$NON-NLS-1$
    return sb.toString();
  }

  /**
   * @return
   */
  public ICloudDeploymentService getDeploymentService() {
    return this.secondPage.getCloudDeploymentService();
  }

  //
  // public void exportCSAR() throws IOException, CoreException{
  //
  // //Export monitoring probes to jar files
  // IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
  // IProject monitoringProbesProject = workspaceRoot.getProject(
  // "MonitoringProbe" );
  // IFolder srcFolder = monitoringProbesProject.getFolder( "src" );
  // IResource[] monitoringProbes = srcFolder.members();
  //
  //
  // //Create CSAR
  //
  //    this.csar = new File( "C:\\Users\\stalo.cs8526\\Desktop\\app.csar" ); //$NON-NLS-1$
  //
  // FileOutputStream fos = new FileOutputStream( csar );
  // ZipOutputStream zos = new ZipOutputStream( fos );
  //
  // // File names
  //    String metaFile = "TOSCA.meta"; //$NON-NLS-1$
  //    String defFileName = "Application.tosca"; //$NON-NLS-1$
  //
  //
  // // Create dummy TOSCA meta
  //    addToCSARFile( "TOSCA-Metadata", metaFile, getMetaContent( defFileName ), zos ); //$NON-NLS-1$
  //
  // File typesFile = new File(
  // "C:\\Users\\stalo.cs8526\\Desktop\\YCSB_Cassandra.xml" );
  // String text = Files.toString(typesFile, Charsets.UTF_8);
  //    addToCSARFile( "Definitions", defFileName, text, zos ); //$NON-NLS-1$
  //
  //
  // typesFile = new File(
  // "C:\\Users\\stalo.cs8526\\Desktop\\CELAR-SpecificTypes-Definitions.xml" );
  // text = Files.toString(typesFile, Charsets.UTF_8);
  //    addToCSARFile( "Definitions", typesFile.getName().replaceFirst( ".xml", ".tosca" ), text, zos ); //$NON-NLS-1$
  //
  // typesFile = new File(
  // "C:\\Users\\stalo.cs8526\\Desktop\\scripts\\Cassandra_Node.sh" );
  // text = Files.toString(typesFile, Charsets.UTF_8);
  //    addToCSARFile( "Scripts", typesFile.getName(), text, zos ); //$NON-NLS-1$
  //
  // typesFile = new File(
  // "C:\\Users\\stalo.cs8526\\Desktop\\scripts\\Cassandra_SeedNode.sh" );
  // text = Files.toString(typesFile, Charsets.UTF_8);
  //    addToCSARFile( "Scripts", typesFile.getName(), text, zos ); //$NON-NLS-1$
  //
  //
  // typesFile = new File(
  // "C:\\Users\\stalo.cs8526\\Desktop\\scripts\\YCSB_Client.sh" );
  // text = Files.toString(typesFile, Charsets.UTF_8);
  //    addToCSARFile( "Scripts", typesFile.getName(), text, zos ); //$NON-NLS-1$
  //
  // typesFile = new File(
  // "C:\\Users\\stalo.cs8526\\Desktop\\scripts\\README.txt" );
  // text = Files.toString(typesFile, Charsets.UTF_8);
  //    addToCSARFile( "Scripts", typesFile.getName(), text, zos ); //$NON-NLS-1$
  //
  // zos.close();
  // fos.close();
  // }
  
  // ICWE demo deployment process
  private void ICWEdemoDeployment() {
    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost( "http://localhost:8080/ToscaContainer/rest/cloud/actions/deployCSAR" ); //$NON-NLS-1$
    MultipartEntity entity = new MultipartEntity();
    entity.addPart( "file", new FileBody( this.csar ) ); //$NON-NLS-1$
    post.setEntity( entity );
    try {
      client.execute( post );
      // if( response.getStatusLine().getStatusCode()!= 201 ) {
      //    throw new RuntimeException( "Failed : HTTP error code : " //$NON-NLS-1$
      // + response.getStatusLine().getStatusCode() );
      // }
    } catch( ClientProtocolException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
