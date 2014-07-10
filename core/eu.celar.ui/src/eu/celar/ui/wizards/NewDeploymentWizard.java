package eu.celar.ui.wizards;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.http.HttpResponse;
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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import eu.celar.core.model.CloudModel;
//import eu.celar.connectors.openstack.OpenStackClient;
//import eu.celar.connectors.openstack.operation.OpenStackOpDeployApplication;
//import eu.celar.connectors.openstack.operation.OperationExecuter;
import eu.celar.core.model.ICloudDeploymentService;
import eu.celar.core.model.ICloudProject;
import eu.celar.core.reporting.ProblemException;
import eu.celar.tosca.DocumentRoot;
import eu.celar.tosca.core.TOSCAModel;
import eu.celar.tosca.core.TOSCAResource;
import eu.celar.tosca.editor.ToscaDiagramEditor;


/**
 * @author Nicholas Loulloudes
 */
public class NewDeploymentWizard extends Wizard implements INewWizard {

  private List<ICloudDeploymentService> deploymentServices = null;
  private TOSCAResource deploymentFile = null;
  private IStructuredSelection selection = null;
  private NewSubmissionWizardSecondPage secondPage = null;
  private TOSCAModel toscaModel;
  private String deploymentString;
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
    
    try {
      exportCSAR();
    } catch( IOException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch( CoreException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    
    
    //Convert Deployment file to String
    TOSCAModel toscaModel = this.deploymentFile.getTOSCAModel();
//    EC2OpDeployApplication deployOperation = new EC2OpDeployApplication( EC2Client.getEC2(), toscaModel );
//  new OperationExecuter().execOp( deployOperation );
//        localMonitor.worked( 1 );
        

    
//    String resourceURI = "http://localhost:8080/ToscaContainer/rest/cloud/actions/deployCSAR"; //$NON-NLS-1$
//    Client client = Client.create();
//    WebResource wr = client.resource( resourceURI );
//    
//    FileDataBodyPart bodyPart = new FileDataBodyPart( "file", csar, MediaType.APPLICATION_OCTET_STREAM_TYPE); //$NON-NLS-1$
//    FormDataMultiPart formPart = new FormDataMultiPart();
//    
//    formPart.bodyPart( bodyPart );
//    
//    
//    ClientResponse response = wr.type( MediaType.MULTIPART_FORM_DATA ).accept( MediaType.TEXT_PLAIN )
//      .post( ClientResponse.class, formPart );
//    if( response.getStatus() != 201 ) {
//      throw new RuntimeException( "Failed : HTTP error code : " //$NON-NLS-1$
//                                  + response.getStatus() );
//    }
//    
//    
//    System.out.println( "Response from Server .... \n" ); //$NON-NLS-1$
//    String output = response.getEntity( String.class );
//    System.out.println( output );
//    csar.delete();
    
    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost("http://localhost:8080/ToscaContainer/rest/cloud/actions/deployCSAR");

    MultipartEntity entity = new MultipartEntity();
    entity.addPart("file", new FileBody(this.csar));
    post.setEntity(entity);

    try {
      client.execute(post);
//      if( response.getStatusLine().getStatusCode()!= 201 ) {
//      throw new RuntimeException( "Failed : HTTP error code : " //$NON-NLS-1$
//                                  + response.getStatusLine().getStatusCode() );
//    }
    } catch( ClientProtocolException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    
    
//    //Deploy application using HTTP / CELAR Manager API
//    URL url = null;
//    HttpURLConnection connection = null;
//    try {
//      //url = new URL ("http://83.212.116.50:8080/celar-server-api/deployment/deploy/?" + "casmulti=1" + "&ycsbmulti=1" );
//      //connection.setRequestMethod( "GET" );
//      
//      url = new URL ("http://cs7649.in.cs.ucy.ac.cy:8080/ToscaContainer/rest/cloud/actions/deploy");
//      
//      connection = (HttpURLConnection) url.openConnection();
//      connection.setDoOutput( true );
//      
//      connection.setRequestMethod( "POST" );
//      
//      connection.setRequestProperty("Content-type", "text/xml; charset=utf-8");
//      
//      OutputStream reqStream = connection.getOutputStream();
//      reqStream.write(this.deploymentString.getBytes());
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


//  /*
//   * (non-Javadoc)
//   * @see org.eclipse.jface.wizard.Wizard#performFinish()
//   */
//  @Override
//  public boolean performFinish() {
//    
//    try {
//      getContainer().run( false, false, new IRunnableWithProgress() {
//
//        @Override
//        public void run( final IProgressMonitor monitor )
//          throws InvocationTargetException, InterruptedException
//        {
//          EC2OpDeployApplication deployOperation = null;
////          OpenStackOpDeployApplication deployOperation = null;
//          try {
//            monitor.beginTask( "Deploying VMIs", 2 );
//            deployOperation = new EC2OpDeployApplication( EC2Client.getEC2(),
//                                                          NewDeploymentWizard.this.deploymentFile );
//            
////          deployOperation = new OpenStackOpDeployApplication( OpenStackClient.getInstance(),
////          NewDeploymentWizard.this.deploymentFile );
//            if( deployOperation.getException() != null ) {
//              throw deployOperation.getException();
//            }
//            new OperationExecuter().execOp( deployOperation );
//          } catch( Exception e ) {
//            e.printStackTrace( );
//            
//          } finally {
//            monitor.done();
//          }
//        }
//      } );
//    } catch (final Exception ex) {
//      ex.printStackTrace();
////      Display display = PlatformUI.getWorkbench().getDisplay();
////      display.asyncExec( new Runnable() {
////
////        public void run() {
////          IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench()
////            .getActiveWorkbenchWindow();
////          ProblemDialog.openProblem( workbenchWindow.getShell(),
////                                     Messages.getString("AddAttributeWizard.problem_granting_access_permission_title"), //$NON-NLS-1$
////                                     Messages.getString("AddAttributeWizard.problem_granting_access_permission_description"), //$NON-NLS-1$
////                                     ex );
////        }
////      } );
//      return false;
//    }
//
//    return true;
//  }

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
  
  public void exportCSAR() throws IOException, CoreException{
    
//    //Export monitoring probes to jar files
//    IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
//    IProject monitoringProbesProject = workspaceRoot.getProject( "MonitoringProbe" );
//    IFolder srcFolder = monitoringProbesProject.getFolder( "src" );
//    IResource[] monitoringProbes = srcFolder.members();
//    
//    for (IResource monitoringProbeFile : monitoringProbes)
//      exportProbe((IFile) monitoringProbeFile);
    
    //Create CSAR
    
    this.csar = new File( "/Users/nicholas/Desktop/app.csar" ); //$NON-NLS-1$
          
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
    addToCSARFile( "Keys",keyFileName, getKeyPair(), zos ); //$NON-NLS-1$
    
    zos.close();
    fos.close();
  }
  
  private static String getKeyPair (){
    return "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAgQCn3TzXwzRDtoPRUyRm784Wwa61EhhEd7rvr9qrLVjNvvCv/JP80sgE43LzxlEx7uiHEbzhhQdVHvTozTA2WEzyhVfYEhDhqt5xVl2Xf0skbAc3qLP42hguYXZ7NPtCUEUbQqN0Oo4WafUo4sRG+FNIu+nO66DbZEcmRBv3YYtcOw== AWS-RSA-1024"; //$NON-NLS-1$
  }
  
  void exportProbe( IFile file ) throws IOException {
    
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    IFolder monitoringFolder = activeProject.getFolder( "Monitoring" );
    IPath jarFilePath = monitoringFolder.getRawLocation()
      .append( file.getName() )
      .removeFileExtension()
      .addFileExtension( "jar" );
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
    jarAdd = new JarEntry( "ProbePack.jar" );
    out.putNextEntry( jarAdd );
    // Write file to archive
    in = new FileInputStream( "C:\\Users\\stalo.cs8526\\Desktop\\ProbePack.jar" );
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

    System.out.println("Writing '" + dir + "/" + fileName + "' to CSAR file"); //$NON-NLS-1$ //$NON-NLS-2$

    String tmpDir = "/tmp" + File.separator ; //$NON-NLS-1$
        
    System.out.println(tmpDir);
    
    File file = new File(tmpDir + fileName);
    
    if( !file.exists() ) {
      file.createNewFile();
    }
    
    FileOutputStream fos = new FileOutputStream( file );

    byte[] contentInBytes = content.getBytes();
    fos.write( contentInBytes );
    fos.flush();
    fos.close();
    
    FileInputStream fis = new FileInputStream(file);
    ZipEntry zipEntry = new ZipEntry(dir + "/" + fileName);
    zos.putNextEntry(zipEntry);

    byte[] bytes = new byte[1024];
    int length;
    while ((length = fis.read(bytes)) >= 0) {
        zos.write(bytes, 0, length);
    }

    zos.closeEntry();
    fis.close();
  }
  
  
  /**
   * @param defFile
   * @return Meta Content
   */
  public static String getMetaContent(String defFile){
    StringBuilder sb = new StringBuilder();
   
    sb.append( "TOSCA-Meta-Version: 1.0\n" ); //$NON-NLS-1$
    sb.append( "CSAR-Version: 1.0\n" ); //$NON-NLS-1$
    sb.append( "Created-By: c-Eclipse\n\n" ); //$NON-NLS-1$
    sb.append( "Name: Definitions" + "/" + defFile+"\n"   ); //$NON-NLS-1$ //$NON-NLS-2$
    sb.append( "Content-Type: application/vnd.oasis.tosca.definitions\n" ); //$NON-NLS-1$
    return sb.toString();
    
  }

  /**
   * @return
   */
  public ICloudDeploymentService getDeploymentService() {
    return this.secondPage.getCloudDeploymentService();
  }
}
