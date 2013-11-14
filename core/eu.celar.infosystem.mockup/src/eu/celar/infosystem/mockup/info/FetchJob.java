/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.infosystem.mockup.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

import eu.celar.infosystem.model.base.InfoSystemFactory;
import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.infosystem.model.base.SoftwareDependency;
import eu.celar.infosystem.model.base.UserApplication;
import eu.celar.infosystem.model.base.VirtualMachineImage;
import eu.celar.infosystem.model.base.VirtualMachineImageType;


/**
 * @author Nicholas Loulloudes
 *
 */
public class FetchJob extends Job {

  private Connection con = null;
  final static private String url = "jdbc:mysql://cs7649.in.cs.ucy.ac.cy:3306/"; //$NON-NLS-1$
  final static private String db = "celarDB"; //$NON-NLS-1$
  final static private String driver = "com.mysql.jdbc.Driver"; //$NON-NLS-1$
  final static private String user = "CelarMockUpUser"; //$NON-NLS-1$
  final static private String pass = "!CelarMockUpPass2013!"; //$NON-NLS-1$
  private static FetchJob instance = null;
  
  private ArrayList<VirtualMachineImage> base_images = new ArrayList<VirtualMachineImage>();
  private ArrayList<VirtualMachineImage> custom_images = new ArrayList<VirtualMachineImage>();
  private ArrayList<SoftwareDependency> software_dependencies = new ArrayList<SoftwareDependency>();
  private ArrayList<MonitoringProbe> monitor_probes = new ArrayList<MonitoringProbe>();
  private ArrayList<ResizingAction> resize_actions = new ArrayList<ResizingAction>();
  private ArrayList<UserApplication> user_apps = new ArrayList<UserApplication>();

  /**
   * @param name
   */
  private FetchJob( final String name ) {
    super( name );
  }
 
  /**
   * Get a singleton instance of FetchJob
   * @param name the name that will be displayed in the progress view
   * @return a FetchJob
   */
  public static FetchJob getInstance (final String name) {
    if (instance == null) {
      instance = new FetchJob( name );
    }
    return instance;
  }
  
  @Override
  protected IStatus run( final IProgressMonitor monitor ) {
           
    IProgressMonitor localMonitor
    = ( monitor != null )
      ? monitor
      : new NullProgressMonitor();
   
    localMonitor.beginTask( "Retrieving information", 6 * 10 ); //$NON-NLS-1$

    //createStaticCelarDB();
    
    /*
     * Connect to the database
     */
    this.con = getDbConnection();  

    
    try {
      fetchBaseMachineImages( localMonitor );
      fetchCustomMachineImages( localMonitor );      
      fetchSwDependencies( localMonitor );
      fetchMonitorProbes( localMonitor );
      fetchResizingActions (localMonitor );
      fetchUserApps (localMonitor );
    } catch( SQLException e ) {     
      e.printStackTrace();
    } finally {
      if (this.con != null) {
        try {
          this.con.close();
        } catch( SQLException e ) {
          e.printStackTrace();
        }  
      }      
    }
      
    
    localMonitor.done();
    Status status = new Status( IStatus.OK,
                         "eu.celar.infosystem", //$NON-NLS-1$
                         "Information data fetched successfully." ); //$NON-NLS-1$
    return status;
  }
 
    
  
  private void fetchBaseMachineImages (final IProgressMonitor monitor) throws SQLException {
    IProgressMonitor subMonitor = null;
    
    if ( monitor != null ) {
      subMonitor = new SubProgressMonitor( monitor, 1);
    }
    
    if (this.con != null) {
      String selectSQL = "SELECT uid, Name, Description, URL FROM BaseImages"; //$NON-NLS-1$
      Statement pStatement = this.con.createStatement();     

      // execute SQL statement
      ResultSet rs = pStatement.executeQuery(selectSQL);
      if (subMonitor != null) {
        subMonitor.beginTask( "Retrieving Base Machine Images", rs.getFetchSize() ); //$NON-NLS-1$
      }
      while (rs.next())
      {
        VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
        /*
         * get the necessary vmi fields
         */
        String uid = rs.getString( "uid" ); //$NON-NLS-1$        
        vmi.setUID( uid );
        String name = rs.getString( "Name" ); //$NON-NLS-1$
        vmi.setName( name );
        String descr = rs.getString( "Description" ); //$NON-NLS-1$
        vmi.setDescription( descr );
        String imageURL = rs.getString( "URL" ); //$NON-NLS-1$
        vmi.setURL( imageURL );
        
        vmi.setType( VirtualMachineImageType.BASE_IMAGE );
       
        //add new vmi to images list
       instance.base_images.add( vmi ); 
      }
      
      if ( subMonitor != null ) {
        subMonitor.worked( 1 );
      }
      
      if (pStatement != null) {
        pStatement.close();
      }
    }
    
  }
  
  private void fetchCustomMachineImages (final IProgressMonitor monitor) throws SQLException {
    IProgressMonitor subMonitor = null;
    
    if ( monitor != null ) {
      subMonitor = new SubProgressMonitor( monitor, 1);
    }
    
    if (this.con != null) {
      String selectSQL = "SELECT uid, Name, Description FROM CustomImages"; //$NON-NLS-1$
      Statement pStatement = this.con.createStatement();     
      
      // execute SQL statement
      ResultSet rs = pStatement.executeQuery(selectSQL);
      if (subMonitor != null) {
        subMonitor.beginTask( "Retrieving Custom Machine Images", rs.getFetchSize() ); //$NON-NLS-1$
      }
      while (rs.next())
      {        
        VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();        /*
         * get the necessary vmi fields
         */
        String uid = rs.getString( "uid" ); //$NON-NLS-1$
        vmi.setUID( uid );
        String name = rs.getString( "Name" ); //$NON-NLS-1$
        vmi.setName( name );
        String descr = rs.getString( "Description" ); //$NON-NLS-1$
        vmi.setDescription( descr );
        
        vmi.setType( VirtualMachineImageType.CUSTOM_IMAGE );
        
        //add new base vmi to images list
       instance.custom_images.add( vmi ); 
      }
      
//      // Add custom images from project explorer
//      
//      IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
//      //IProject project = workspaceRoot.getProject( "test" );
//      //String projectName = MockUpInfoSystem.getInstanceProjectName();
//      //String projectName = this.project.getName();
//      String projectName = "test";
//      if ( projectName != null ){
//        IProject project = workspaceRoot.getProject( projectName );
//
//        IFolder artifactsFolder = project.getFolder( "/Artifacts/Virtual Machine Images" );
//        IResource[] artifactsResource = null;
//        try {
//          artifactsResource = artifactsFolder.members();
//        } catch( CoreException e ) {
//          // TODO Auto-generated catch block
//          e.printStackTrace();
//        }
//        for ( IResource tempResource : artifactsResource ){
//          if ( tempResource instanceof IFile){
//            VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();      
//            vmi.setUID( "1" );
//            vmi.setName( tempResource.getName() );
//            vmi.setDescription( "h" );
//            vmi.setURL( "h" );
//            vmi.setType( VirtualMachineImageType.BASE_IMAGE );
//            //add new base vmi to images list
//            instance.custom_images.add( vmi ); 
//          }
//        }
//      }
      
      if ( subMonitor != null ) {
        subMonitor.worked( 1 );
      }
      
      if (pStatement != null) {
        pStatement.close();
      }
    }
    
  }
  
  private void fetchSwDependencies (final IProgressMonitor monitor) throws SQLException {
    IProgressMonitor subMonitor = null;
    
    if ( monitor != null ) {
      subMonitor = new SubProgressMonitor( monitor, 1);
    }
    
    if (this.con != null) {
      String selectSQL = "SELECT uid, Name, Type, Description FROM SwDependencies"; //$NON-NLS-1$
      Statement pStatement = this.con.createStatement();     

      // execute SQL statement
      ResultSet rs = pStatement.executeQuery(selectSQL);
      if (subMonitor != null) {
        subMonitor.beginTask( "Retrieving Software Dependencies", rs.getFetchSize() ); //$NON-NLS-1$
      }
      while (rs.next())
      {        
        SoftwareDependency swd = InfoSystemFactory.eINSTANCE.createSoftwareDependency();
        /*
         * get the necessary vmi fields
         */
        String uid = rs.getString( "uid" ); //$NON-NLS-1$
        swd.setUID( uid );
        String name = rs.getString( "Name" ); //$NON-NLS-1$
        swd.setName( name );
        String type = rs.getString( "Type" ); //$NON-NLS-1$
        swd.setType( type );        
        String descr = rs.getString( "Description" ); //$NON-NLS-1$
        swd.setDescription( descr );        
        //add new software dependency to swd list
       instance.software_dependencies.add( swd ); 
      }
      
      if ( subMonitor != null ) {
        subMonitor.worked( 1 );
      }
      
      if (pStatement != null) {
        pStatement.close();
      }
    }
    
  }
  
  private void fetchUserApps (final IProgressMonitor monitor) throws SQLException {
    IProgressMonitor subMonitor = null;
    
    if ( monitor != null ) {
      subMonitor = new SubProgressMonitor( monitor, 1);
    }
    
    if (this.con != null) {
      String selectSQL = "SELECT uid, Name, Description FROM UserApplications"; //$NON-NLS-1$
      Statement pStatement = this.con.createStatement();     

      // execute SQL statement
      ResultSet rs = pStatement.executeQuery(selectSQL);
      if (subMonitor != null) {
        subMonitor.beginTask( "Retrieving User Applications", rs.getFetchSize() ); //$NON-NLS-1$
      }
      while (rs.next())
      {        
        UserApplication uA = InfoSystemFactory.eINSTANCE.createUserApplication();
        /*
         * get the necessary vmi fields
         */
        String uid = rs.getString( "uid" ); //$NON-NLS-1$
        uA.setUID( uid );
        String name = rs.getString( "Name" ); //$NON-NLS-1$
        uA.setName( name );        
        String descr = rs.getString( "Description" ); //$NON-NLS-1$
        uA.setDescription( descr );        
        //add new software dependency to swd list
       instance.user_apps.add( uA ); 
      }
      
      if ( subMonitor != null ) {
        subMonitor.worked( 1 );
      }
      
      if (pStatement != null) {
        pStatement.close();
      }
    }
    
  }
  
  private static Connection getDbConnection() {
    Connection dbConnection = null;
    try {
      Class.forName( driver );
    } catch( ClassNotFoundException e ) {
      System.out.println( e.getMessage() );
    }
    try {
      dbConnection = DriverManager.getConnection( url + db,
                                                  user,
                                                  pass );
      return dbConnection;
    } catch( SQLException e ) {
      System.out.println( e.getMessage() );
    }
    return dbConnection;
  }
  
  private void fetchMonitorProbes (final IProgressMonitor monitor) throws SQLException {
    IProgressMonitor subMonitor = null;
    
    if ( monitor != null ) {
      subMonitor = new SubProgressMonitor( monitor, 1);
    }
    
    if (this.con != null) {
      String selectSQL = "SELECT uid, Name, Description FROM MonitorProbes"; //$NON-NLS-1$
      Statement pStatement = this.con.createStatement();
      
      // execute SQL statement
      ResultSet rs = pStatement.executeQuery(selectSQL);
      if (subMonitor != null) {
        subMonitor.beginTask( "Retrieving Monitor Probes", rs.getFetchSize() ); //$NON-NLS-1$
      }
      while (rs.next())
      {        
        MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
        /*
         * get the necessary vmi fields
         */
        String uid = rs.getString( "uid" ); //$NON-NLS-1$
        mp.setUID( uid );
        String name = rs.getString( "Name" ); //$NON-NLS-1$
        mp.setName( name );
        String descr = rs.getString( "Description" ); //$NON-NLS-1$
        mp.setDescription( descr );        
        //add new monitor probe to probes list
       instance.monitor_probes.add( mp ); 
      }
      
      if ( subMonitor != null ) {
        subMonitor.worked( 1 );
      }
      
      if (pStatement != null) {
        pStatement.close();
      }
    }
    
  }
  
  private void fetchResizingActions (final IProgressMonitor monitor) throws SQLException {
    IProgressMonitor subMonitor = null;
    
    if ( monitor != null ) {
      subMonitor = new SubProgressMonitor( monitor, 1);
    }
    
    if (this.con != null) {
      String selectSQL = "SELECT uid, Name, Description FROM ResizeActions"; //$NON-NLS-1$
      Statement pStatement = this.con.createStatement();
      
      // execute SQL statement
      ResultSet rs = pStatement.executeQuery(selectSQL);
      if (subMonitor != null) {
        subMonitor.beginTask( "Retrieving Resizing Actions", rs.getFetchSize() ); //$NON-NLS-1$
      }
      while (rs.next())
      {        
        ResizingAction ra = InfoSystemFactory.eINSTANCE.createResizingAction();
        /*
         * get the necessary vmi fields
         */
        String uid = rs.getString( "uid" ); //$NON-NLS-1$
        ra.setUID( uid );
        String name = rs.getString( "Name" ); //$NON-NLS-1$
        ra.setName( name );
        String descr = rs.getString( "Description" ); //$NON-NLS-1$
        ra.setDescription( descr );        
        //add new monitor probe to probes list
       instance.resize_actions.add( ra ); 
      }
      
      if ( subMonitor != null ) {
        subMonitor.worked( 1 );
      }
      
      if (pStatement != null) {
        pStatement.close();
      }
    }
    
  }
  
  /**
   * @return A list with the available Base Machine Images
   */
  public ArrayList<VirtualMachineImage> getBaseMachineImages () {
    return instance.base_images;
  }
  
  /**
   * @return A list with the available Custom Machine Images
   */
  public ArrayList<VirtualMachineImage> getCustomMachineImages () {
    return instance.custom_images;
  }
  
  /**
   * @return A list with the available Software Dependencies
   */
  public ArrayList<SoftwareDependency> getSoftwareDependencies () {
    return instance.software_dependencies;
  }
  
  /**
   * @return A list with available Monitoring Probes
   */
  public ArrayList<MonitoringProbe> getMonitoringProbes () {
    return instance.monitor_probes;
  }
  
  /**
   * @return A list with available Resizing Actions
   */
  public ArrayList<ResizingAction> getResizingActions () {
    return instance.resize_actions;
  }
  
  /**
   * @return A list with the available User Applications
   */
  public ArrayList<UserApplication> getUserApplications () {
    return instance.user_apps;
  }
  
  private MessageConsole findConsole(String name) {
    ConsolePlugin plugin = ConsolePlugin.getDefault();
    IConsoleManager conMan = plugin.getConsoleManager();
    IConsole[] existing = conMan.getConsoles();
    for (int i = 0; i < existing.length; i++)
       if (name.equals(existing[i].getName()))
          return (MessageConsole) existing[i];
    //no console found, so create a new one
    MessageConsole myConsole = new MessageConsole(name, null);
    conMan.addConsoles(new IConsole[]{myConsole});
    return myConsole;
 }
   
 private void createStaticCelarDB() {
//   VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();      
//   vmi.setUID( "1" );
//   vmi.setName( "Ubuntu-12.04.3-64bit" );
//   vmi.setDescription( "h" );
//   vmi.setURL( "h" );
//   vmi.setType( VirtualMachineImageType.BASE_IMAGE );
//   instance.base_images.add( vmi ); 
//   
//   vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();      
//   vmi.setUID( "1" );
//   vmi.setName( "Ubuntu-12.04-32bit" );
//   vmi.setDescription( "h" );
//   vmi.setURL( "h" );
//   vmi.setType( VirtualMachineImageType.BASE_IMAGE );
//   instance.base_images.add( vmi ); 
   
   VirtualMachineImage bvmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();       
   bvmi.setUID( "1" );
   bvmi.setName( "Ubuntu-12.04-64bit" );
   bvmi.setDescription( "h" );   
   bvmi.setType( VirtualMachineImageType.CUSTOM_IMAGE );
   instance.custom_images.add( bvmi ); 
   
   bvmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();       
   bvmi.setUID( "1" );
   bvmi.setName( "Ubuntu-12.04-32bit" );
   bvmi.setDescription( "h" );   
   bvmi.setType( VirtualMachineImageType.CUSTOM_IMAGE );
   instance.custom_images.add( bvmi ); 
   
   SoftwareDependency swd = InfoSystemFactory.eINSTANCE.createSoftwareDependency();
   swd.setUID( "" );
   swd.setName( "Cassandra" );
   swd.setType( "" );        
   swd.setDescription( "" );        
   instance.software_dependencies.add( swd ); 
   
   swd = InfoSystemFactory.eINSTANCE.createSoftwareDependency();
   swd.setUID( "" );
   swd.setName( "Apache Server" );
   swd.setType( "" );        
   swd.setDescription( "" );        
   instance.software_dependencies.add( swd );
   
   swd = InfoSystemFactory.eINSTANCE.createSoftwareDependency();
   swd.setUID( "" );
   swd.setName( "Hadoop" );
   swd.setType( "" );        
   swd.setDescription( "" );        
   instance.software_dependencies.add( swd );
   
   swd = InfoSystemFactory.eINSTANCE.createSoftwareDependency();
   swd.setUID( "" );
   swd.setName( "Hive" );
   swd.setType( "" );        
   swd.setDescription( "" );        
   instance.software_dependencies.add( swd );
   
   swd = InfoSystemFactory.eINSTANCE.createSoftwareDependency();
   swd.setUID( "" );
   swd.setName( "Apache_LB" );
   swd.setType( "" );        
   swd.setDescription( "" );        
   instance.software_dependencies.add( swd );
   
//   UserApplication uA = InfoSystemFactory.eINSTANCE.createUserApplication();
//   uA.setUID( "" );
//   uA.setName( "DataQuery.jar" );        
//   uA.setDescription( "" );        
//   instance.user_apps.add( uA ); 
//   
//   uA = InfoSystemFactory.eINSTANCE.createUserApplication();
//   uA.setUID( "" );
//   uA.setName( "DataReceiver.py" );        
//   uA.setDescription( "" );        
//   instance.user_apps.add( uA ); 
   
   MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
   mp.setUID( "" );
   mp.setName( "CPU Usage" );
   mp.setDescription( "" );        
   instance.monitor_probes.add( mp ); 
   
   mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
   mp.setUID( "" );
   mp.setName( "Memory Usage" );
   mp.setDescription( "" );        
   instance.monitor_probes.add( mp ); 
   
   ResizingAction ra = InfoSystemFactory.eINSTANCE.createResizingAction();
   ra.setUID( "" );
   ra.setName( "Add VM" );
   ra.setDescription( "" );        
   instance.resize_actions.add( ra ); 
   
   ra = InfoSystemFactory.eINSTANCE.createResizingAction();
   ra.setUID( "" );
   ra.setName( "Remove VM" );
   ra.setDescription( "" );        
   instance.resize_actions.add( ra ); 
 }
}
