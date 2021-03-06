/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.infosystem.mockup.info;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;

import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.infosystem.model.base.SoftwareDependency;
import eu.celar.infosystem.model.base.UserApplication;
import eu.celar.infosystem.model.base.VirtualMachineImage;
import eu.celar.infosystem.model.base.VirtualMachineImageFlavor;



/**
 * @author Nicholas Loulloudes
 * MockUpInfoSystem - v1.0.1
 * another doc
 */
public class MockUpInfoSystem  {
  
  private static MockUpInfoSystem instance = null;
//  private AmazonAWSFetch resourceFetcher;
//  private OpenStackFetch resourceFetcher;
  private FetchJob resourceFetcher;
  
  /**
   * @return The Mockup Information System
   */
  public static MockUpInfoSystem getInstance () {
    if (instance == null) {
      instance = new MockUpInfoSystem();      
    }    
    return instance;
  }
  
  private MockUpInfoSystem () {
    this.resourceFetcher = FetchJob.getInstance( "Mockup Resource Fetcher" ); //$NON-NLS-1$
//    this.resourceFetcher = AmazonAWSFetch.getInstance( "AWS Resource Fetcher" ); //$NON-NLS-1$
//    this.resourceFetcher = OpenStackFetch.getInstance( "OpenStack Resource Fetcher" ); //$NON-NLS-1$
    this.resourceFetcher.schedule();    
  }
  
  
  public static MockUpInfoSystem getInstance (IFile toscaFile) {
    if (instance == null) {
      instance = new MockUpInfoSystem(toscaFile);      
    }    
    return instance;
  }
  
  private MockUpInfoSystem (IFile toscaFile) {
    this.resourceFetcher = FetchJob.getInstance( "Mockup Resource Fetcher" ); //$NON-NLS-1$
//    this.resourceFetcher = AmazonAWSFetch.getInstance( "AWS Resource Fetcher" ); //$NON-NLS-1$
//    this.resourceFetcher = OpenStackFetch.getInstance( "OpenStack Resource Fetcher" ); //$NON-NLS-1$
    this.resourceFetcher.schedule();    
  }
  
  /**
   * @return A list of available base machine images
   */
  public ArrayList<VirtualMachineImage> getBaseMachineImages () {
    return this.resourceFetcher.getBaseMachineImages();
  } 
  
  /**
   * @return A list of available monitoring probes
   */
  public ArrayList<MonitoringProbe> getMonitoringProbes () {
    return this.resourceFetcher.getMonitoringProbes();
  }
  
  /**
   * @return A list of available resizing actions
   */
  public ArrayList<ResizingAction> getResizingActions () {
    return this.resourceFetcher.getResizingActions();
  }
  
  
  // TODO - nickl Reflect this to the infosystem model
  public ArrayList<VirtualMachineImageFlavor> getInstanceTypes () {
    return this.resourceFetcher.getInstanceTypes();
  }
  
}
