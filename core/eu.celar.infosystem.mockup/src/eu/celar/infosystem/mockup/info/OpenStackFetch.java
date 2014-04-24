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
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.domain.Image;
import eu.celar.connectors.openstack.OpenStackClient;
import eu.celar.connectors.openstack.operation.OpenStackOpDescribeImages;
import eu.celar.connectors.openstack.operation.OperationExecuter;
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
public class OpenStackFetch extends Job  {  
    
  private ComputeService computeService;
  private ArrayList<VirtualMachineImage> base_images = null;
  private ArrayList<VirtualMachineImage> custom_images = null;
  private ArrayList<SoftwareDependency> software_dependencies = new ArrayList<SoftwareDependency>();
  private ArrayList<MonitoringProbe> monitor_probes = new ArrayList<MonitoringProbe>();
  private ArrayList<ResizingAction> resize_actions = new ArrayList<ResizingAction>();
  private ArrayList<UserApplication> user_apps = new ArrayList<UserApplication>();
  /**
   * @param name
   */
  public OpenStackFetch( final String name ) {
    super( name );
  }

  private static OpenStackFetch instance = null;
  
  
  /**
   * @param name
   * @return
   */
  public static OpenStackFetch getInstance ( final String name) {
    if (instance == null) {
      instance = new OpenStackFetch( name );
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
    localMonitor.beginTask( "Authenticating with OpenStack endpoint", 4 ); //$NON-NLS-1$
    try {
      
//      localMonitor.beginTask( "Creating OpenStack client", 1 ); //$NON-NLS-1$      
      this.computeService = OpenStackClient.getInstance().getComputeService();
      localMonitor.worked( 1 );
      
      OpenStackOpDescribeImages operation = new OpenStackOpDescribeImages( this.computeService );
      new OperationExecuter().execOp( operation );
      localMonitor.worked( 2 );
      
      if( operation.getException() == null ) {
        int size = operation.getResult().size();
        System.out.println("Size: " + size); //$NON-NLS-1$
        this.custom_images = new ArrayList<VirtualMachineImage>( size );
        
        for( Image ami : operation.getResult() ) {
//          if( ami.getName() == null ) {
//            continue;
//          }
          VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
          vmi.setUID( ami.getId() );
          vmi.setDescription( ami.getDescription() );
          vmi.setName( ami.getName() );
          vmi.setURL( ami.getLocation().toString() );
          this.custom_images.add( vmi );
        }
        
        localMonitor.worked( 3 );
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
    
//    InstanceType types = null;
    
//    InstanceType[] vals = InstanceType.values();
//    
//    ArrayList<String> availTypes = new ArrayList<String>();
//    for (InstanceType t : vals) {
//      availTypes.add( t.toString() );
//    }
    
    return null;
  }

  
}
