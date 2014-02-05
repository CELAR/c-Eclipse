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
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.Image;
import com.amazonaws.services.ec2.model.InstanceType;

import eu.celar.connectors.aws.AWSCloudProvider;
import eu.celar.connectors.aws.EC2Client;
import eu.celar.connectors.aws.auth.AWSAuthToken;
import eu.celar.connectors.aws.auth.AWSAuthTokenDescription;
import eu.celar.connectors.aws.operation.EC2OpDescribeImages;
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
      
      EC2OpDescribeImages operation = new EC2OpDescribeImages( this.ec2 );
      new OperationExecuter().execOp( operation );
      localMonitor.worked( 1 );
      
      if( operation.getException() == null ) {
        int size = operation.getResult().size();
        System.out.println("Size: " + size); //$NON-NLS-1$
        this.custom_images = new ArrayList<VirtualMachineImage>( size );
        
        for( Image ami : operation.getResult() ) {
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
        throw new Exception(operation.getException());
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

  
}
