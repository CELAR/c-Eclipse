/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.infosystem.mockup.info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import eu.celar.infosystem.model.base.InfoSystemFactory;
import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.infosystem.model.base.SoftwareDependency;
import eu.celar.infosystem.model.base.UserApplication;
import eu.celar.infosystem.model.base.VirtualMachineImage;
import eu.celar.infosystem.model.base.VirtualMachineImageType;


/**
 * @authors Nicholas Loulloudes, Stalo Sofokleous
 *
 */
public class FetchJob extends Job {

  private Connection con = null;

  private static FetchJob instance = null;
  
  private ArrayList<VirtualMachineImage> base_images = new ArrayList<VirtualMachineImage>();
  private ArrayList<MonitoringProbe> monitor_probes = new ArrayList<MonitoringProbe>();
  private ArrayList<ResizingAction> resize_actions = new ArrayList<ResizingAction>();

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
    
    try {
      try {
        fetchBaseMachineImages( localMonitor );
        fetchMonitorProbes( localMonitor );
        fetchResizingActions (localMonitor );
      } catch( JSONException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

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
 
    
  
  private void fetchBaseMachineImages (final IProgressMonitor monitor) throws SQLException, JSONException {
    
    //CELAR Manager call : Get VM Images
    String celarManagerURL = "http://83.212.107.38:8080/resources/";
    URL url = null;
    HttpURLConnection connection = null;
    BufferedReader in = null;
    String inputLine = null;
    
    String images = "";
    try {
      url = new URL (celarManagerURL + "images/");
  
      connection = (HttpURLConnection) url.openConnection();
      connection.setDoInput( true );
      connection.setRequestProperty("Accept", "application/json");
      connection.setRequestMethod( "GET" );
              
      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      while ((inputLine = in.readLine()) != null) {
          images = images + inputLine;
      }
      in.close();
      System.out.println(images);
      
      connection.disconnect();
    } catch( MalformedURLException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if ( images.equals( "" ) == false ) {

      images = "{\"images\":" + images + "}";
      String output_json = images;
      JSONObject obj = new JSONObject( output_json );
      JSONArray images_array = obj.getJSONArray( "images" ); //$NON-NLS-1$

      if ( images_array != null ){
        for (int i=0; i < images_array.length(); i++){
          VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
          /*
           * get the necessary vmi fields
           */
  
          vmi.setDescription( "h" );
          vmi.setURL( "h" );

          vmi.setUID( images_array.getJSONObject( i ).getString( "name" ) );
          vmi.setName( images_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
          
          vmi.setType( VirtualMachineImageType.BASE_IMAGE );
         
          //add new vmi to images list
         instance.base_images.add( vmi ); 
        }
      }
    }
  }

  private void fetchMonitorProbes (final IProgressMonitor monitor) throws SQLException, JSONException {
    
    //CELAR Manager call : Get Monitoring Probes
    String celarManagerURL = "http://83.212.107.38:8080/resources/";
    URL url = null;
    HttpURLConnection connection = null;
    BufferedReader in = null;
    String inputLine = null;
    
    String probes = "";
    try {
      url = new URL (celarManagerURL + "probes/");
  
      connection = (HttpURLConnection) url.openConnection();
      connection.setDoInput( true );
      connection.setRequestProperty("Accept", "application/json");
      connection.setRequestMethod( "GET" );
              
      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      while ((inputLine = in.readLine()) != null) {
        probes = probes + inputLine;
      }
      in.close();
      System.out.println(probes);
      
      connection.disconnect();
    } catch( MalformedURLException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if ( probes.equals( "" ) == false ) {
      
      probes = "{\"probes\":" + probes + "}";
      String output_json = probes;
      JSONObject obj = new JSONObject( output_json );
      JSONArray probes_array = obj.getJSONArray( "probes" ); //$NON-NLS-1$
     
      if ( probes_array != null ){
        for (int i=0; i < probes_array.length(); i++){
          MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
          /*
           * get the necessary mp fields
           */
          mp.setName( probes_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
          mp.setDescription( probes_array.getJSONObject( i ).getString( "metrics" ) );
          
          System.out.println(mp.getName());
          System.out.println(mp.getDescription());
          
          //add new monitor probe to probes list
          instance.monitor_probes.add( mp ); 
        }
      }
    }    
  }
  
  private void fetchResizingActions (final IProgressMonitor monitor) throws SQLException, JSONException {
    
    //CELAR Manager call : Get Resizing Actions
    String celarManagerURL = "http://83.212.107.38:8080/resources/";
    URL url = null;
    HttpURLConnection connection = null;
    BufferedReader in = null;
    String inputLine = null;
    
    String actions = "";
    try {
      url = new URL (celarManagerURL + "actions/");
  
      connection = (HttpURLConnection) url.openConnection();
      connection.setDoInput( true );
      connection.setRequestProperty("Accept", "application/json");
      connection.setRequestMethod( "GET" );
              
      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      while ((inputLine = in.readLine()) != null) {
        actions = actions + inputLine;
      }
      in.close();
      System.out.println(actions);
      
      connection.disconnect();
    } catch( MalformedURLException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if ( actions.equals( "" ) == false ) {
      
      actions = "{\"actions\":" + actions + "}";
      String output_json = actions;
      JSONObject obj = new JSONObject( output_json );
      JSONArray actions_array = obj.getJSONArray( "actions" ); //$NON-NLS-1$
     
      if ( actions_array != null ){
        for (int i=0; i < actions_array.length(); i++){
          ResizingAction ra = InfoSystemFactory.eINSTANCE.createResizingAction();
          /*
           * get the necessary ra fields
           */
          ra.setName( actions_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
         
          //add new ra to resizing_actions list
          instance.resize_actions.add( ra ); 
        }
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
   VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();      
   vmi.setUID( "1" );
   vmi.setName( "Ubuntu-12.04.3-64bit" );
   vmi.setDescription( "h" );
   vmi.setURL( "h" );
   vmi.setType( VirtualMachineImageType.BASE_IMAGE );
   instance.base_images.add( vmi ); 
  
   vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();      
   vmi.setUID( "1" );
   vmi.setName( "Ubuntu-12.04-32bit" );
   vmi.setDescription( "h" );
   vmi.setURL( "h" );
   vmi.setType( VirtualMachineImageType.BASE_IMAGE );
   instance.base_images.add( vmi ); 
   
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
