/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.infosystem.mockup.info;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.Image;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

import eu.celar.connectors.aws.AWSCloudProvider;
import eu.celar.connectors.aws.EC2Client;
import eu.celar.connectors.aws.auth.AWSAuthToken;
import eu.celar.connectors.aws.auth.AWSAuthTokenDescription;
import eu.celar.connectors.aws.operation.EC2OpDescribeImages;
import eu.celar.connectors.aws.operation.EC2OpDescribeMetrics;
import eu.celar.connectors.aws.operation.OperationExecuter;
import eu.celar.core.auth.AbstractAuthTokenProvider;
import eu.celar.core.auth.AuthTokenRequest;
import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudProviderManager;
import eu.celar.core.reporting.ProblemException;
import eu.celar.infosystem.model.base.InfoSystemFactory;
import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.infosystem.model.base.SoftwareDependency;
import eu.celar.infosystem.model.base.UserApplication;
import eu.celar.infosystem.model.base.VirtualMachineImage;


/**
 * @author Nicholas Loulloudes
 *
 */
public class AmazonAWSFetch extends Job  {  
    
  private AmazonEC2 ec2;
  private ArrayList<VirtualMachineImage> base_images = null;
  private ArrayList<VirtualMachineImage> custom_images = null;
  private ArrayList<SoftwareDependency> software_dependencies = new ArrayList<SoftwareDependency>();
  private ArrayList<MonitoringProbe> monitor_probes = new ArrayList<MonitoringProbe>();
  private ArrayList<ResizingAction> resize_actions = new ArrayList<ResizingAction>();
  private ArrayList<UserApplication> user_apps = new ArrayList<UserApplication>();
  
  private String metrics[] = null;
  private String units[] = null;
  
  /**
   * @param name
   */
  public AmazonAWSFetch( final String name ) {
    super( name );
  }

  private static AmazonAWSFetch instance = null;
  
  
  /**
   * @param name
   * @return
   */
  public static AmazonAWSFetch getInstance ( final String name) {
    if (instance == null) {
      instance = new AmazonAWSFetch( name );
    }
    return instance;
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected IStatus run( final IProgressMonitor monitor ) {
    IProgressMonitor localMonitor = ( monitor != null )
                                                       ? monitor
                                                       : new NullProgressMonitor();
    localMonitor.beginTask( "Authenticating with AWS", 3 ); //$NON-NLS-1$
    try {
      
      localMonitor.beginTask( "Creating AWS EC2 client", 6 * 10 ); //$NON-NLS-1$
      this.ec2 = EC2Client.getEC2();
      
      EC2OpDescribeImages imagesOperation = new EC2OpDescribeImages( this.ec2 );
      new OperationExecuter().execOp( imagesOperation );
      localMonitor.worked( 1 );
      
      if( imagesOperation.getException() == null ) {
        int size = imagesOperation.getResult().size();
        System.out.println("Images Size: " + size); //$NON-NLS-1$
        this.custom_images = new ArrayList<VirtualMachineImage>( size );
        
        for( Image ami : imagesOperation.getResult() ) {
//          if( ami.getName() == null ) {
//            continue;
//          }
          VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
          vmi.setUID( ami.getImageId() );
          vmi.setDescription( ami.getDescription() );
          vmi.setName( ami.getName() );
          vmi.setURL( ami.getImageLocation() );
          this.custom_images.add( vmi );
        }
        
        localMonitor.worked( 2 );
      }  else {
        throw new Exception(imagesOperation.getException());
      }
      
      EC2OpDescribeMetrics metricsOperation = new EC2OpDescribeMetrics( this.ec2 );
      new OperationExecuter().execOp( metricsOperation );
      localMonitor.worked( 3 );
      
      if( metricsOperation.getException() == null ) {
        int size = metricsOperation.getResult().size();
        System.out.println("Metrics Size: " + size); //$NON-NLS-1$
        this.monitor_probes = new ArrayList<MonitoringProbe>( size );
        
//        for( Metric metric : metricsOperation.getResult() ) {
//
//          MonitoringProbe probe = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
//          probe.setName( metric.getMetricName() );                    
//          this.monitor_probes.add( probe );
//        }
        
        //Add JCatascopia probe metrics
        getMetricsInfo();
        if (metrics != null ){
          for (int i=0; i<metrics.length; i++){
            MonitoringProbe probe = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
            probe.setUID( metrics[i] );
            probe.setName( metrics[i] );
            probe.setDescription( units[i] );
            this.monitor_probes.add( probe );
          }
        }
        
        localMonitor.worked( 2 );
      }  else {
        throw new Exception(imagesOperation.getException());
      }
      
      
      
      
    } catch( Exception e ) {
      e.printStackTrace();
    }
    localMonitor.done();
    Status status = new Status( IStatus.OK, "eu.celar.infosystem", //$NON-NLS-1$
                                "Information data fetched successfully." ); //$NON-NLS-1$
    return status;
  }

  /**
   * @throws ProblemException 
   * 
   */
  private AWSCredentials getAWSAuthCredentials()  {
    AWSCredentials awsCredentials = null;
    ICloudProviderManager cpManager = CloudModel.getCloudProviderManager();
    ICloudElement[] children;
    try {
      children = cpManager.getChildren( new NullProgressMonitor() );
      String accessId = null;
      for( ICloudElement CloudElement : children ) {
        if( CloudElement instanceof AWSCloudProvider ) {
          AWSCloudProvider awsCp = ( AWSCloudProvider )CloudElement;
          accessId = awsCp.getProperties().getAwsAccessId();
        }
      }
      if( accessId != null ) {
        // get the auth token
        AWSAuthTokenDescription awsAuthTokenDesc = new AWSAuthTokenDescription( accessId );
        AuthTokenRequest request = new AuthTokenRequest( awsAuthTokenDesc,
                                                         "AmazonAWSFetch", //$NON-NLS-1$
                                                         "Fectch AWS Info" ); //$NON-NLS-1$
        AWSAuthToken awsAuthToken = ( AWSAuthToken )AbstractAuthTokenProvider.staticRequestToken( request );
        if( awsAuthToken != null ) {
          awsCredentials = new BasicAWSCredentials( awsAuthTokenDesc.getAwsAccessId(),
                                                    awsAuthTokenDesc.getAwsSecretId() );
        }
      }
    } catch( ProblemException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    
    return awsCredentials;
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
    
    SoftwareDependency swd = InfoSystemFactory.eINSTANCE.createSoftwareDependency();
    swd.setUID( "" );
    swd.setName( "Decommission.sh" );
    swd.setType( "" );        
    swd.setDescription( "" );        
    instance.software_dependencies.add( swd );
    
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

  /**
   * @return
   */
  public ArrayList<String> getInstanceTypes() {
    
    InstanceType types = null;
    
    InstanceType[] vals = InstanceType.values();
    
    ArrayList<String> availTypes = new ArrayList<String>();
    for (InstanceType t : vals) {
      availTypes.add( t.toString() );
    }
    
    return availTypes;
  }
  
  public void getMetricsInfo() throws JSONException {

    String output_json = getEntity();
    JSONObject obj = new JSONObject( output_json );
    JSONArray metrics_array = obj.getJSONArray( "metrics" ); //$NON-NLS-1$
   
    if( metrics_array != null ) {
      metrics = new String[metrics_array.length()];
      units = new String[metrics_array.length()];
    }
   
    for (int i=0; i < metrics_array.length(); i++){
      metrics[i] = metrics_array.getJSONObject( i ).getString( "name" ); //$NON-NLS-1$
      units[i] = metrics_array.getJSONObject( i ).getString( "units" ); //$NON-NLS-1$
      //System.out.println(metrics[i] + " " + units[i]);
    }
  }
  
  public String getEntity(){
    
    return "{\"metrics\":[{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesSent\",\"name\":\"bytesSent\",\"units\":\"Bytes\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memFree\",\"name\":\"memFree\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:arch\",\"name\":\"arch\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memTotal\",\"name\":\"memTotal\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuTotal\",\"name\":\"cpuTotal\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memCache\",\"name\":\"memCache\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:requestThroughput\",\"name\":\"requestThroughput\",\"units\":\"req/s\",\"type\":\"DOUBLE\",\"group\":\"Tomcat\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:maxThreads\",\"name\":\"maxThreads\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netPacketsOut\",\"name\":\"netPacketsOut\",\"units\":\"packets/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:errorCount\",\"name\":\"errorCount\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netBytesIN\",\"name\":\"netBytesIN\",\"units\":\"bytes/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:diskUsed\",\"name\":\"diskUsed\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"Disk\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuIdle\",\"name\":\"cpuIdle\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"b9ba52a9826e4c48b1976fdecdc592ab:currentSessions\",\"name\":\"currentSessions\",\"units\":\"\",\"type\":\"INTEGER\",\"group\":\"HAProxy\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuIOwait\",\"name\":\"cpuIOwait\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memSwapFree\",\"name\":\"memSwapFree\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuUser\",\"name\":\"cpuUser\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:diskTotal\",\"name\":\"diskTotal\",\"units\":\"MB\",\"type\":\"LONG\",\"group\":\"Disk\"},{\"metricID\":\"b9ba52a9826e4c48b1976fdecdc592ab:servers\",\"name\":\"servers\",\"units\":\"\",\"type\":\"INTEGER\",\"group\":\"HAProxy\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:iotime\",\"name\":\"iotime\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"DiskStats\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memUsed\",\"name\":\"memUsed\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:requestCount\",\"name\":\"requestCount\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:currentThreadCount\",\"name\":\"currentThreadCount\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memUsedPercent\",\"name\":\"memUsedPercent\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:os\",\"name\":\"os\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netPacketsIN\",\"name\":\"netPacketsIN\",\"units\":\"packets/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuNum\",\"name\":\"cpuNum\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuSystem\",\"name\":\"cpuSystem\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:btime\",\"name\":\"btime\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:processingTime\",\"name\":\"processingTime\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memSwapTotal\",\"name\":\"memSwapTotal\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:readkbps\",\"name\":\"readkbps\",\"units\":\"KB/s\",\"type\":\"DOUBLE\",\"group\":\"DiskStats\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:diskFree\",\"name\":\"diskFree\",\"units\":\"MB\",\"type\":\"LONG\",\"group\":\"Disk\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:currentThreadsBusy\",\"name\":\"currentThreadsBusy\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesReceived\",\"name\":\"bytesReceived\",\"units\":\"Bytes\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:writekbps\",\"name\":\"writekbps\",\"units\":\"KB/s\",\"type\":\"DOUBLE\",\"group\":\"DiskStats\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netBytesOUT\",\"name\":\"netBytesOUT\",\"units\":\"bytes/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"}]}";
    
  }

  
}
