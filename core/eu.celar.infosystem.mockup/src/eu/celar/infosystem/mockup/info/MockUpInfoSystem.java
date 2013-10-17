/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.infosystem.mockup.info;

import java.util.ArrayList;

import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.infosystem.model.base.SoftwareDependency;
import eu.celar.infosystem.model.base.UserApplication;
import eu.celar.infosystem.model.base.VirtualMachineImage;



/**
 * @author Nicholas Loulloudes
 * MockUpInfoSystem - v1.0
 */
public class MockUpInfoSystem  {
  
  private static MockUpInfoSystem instance = null;
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
    this.resourceFetcher.schedule();    
  }
  
  /**
   * @return A list of available base machine images
   */
  public ArrayList<VirtualMachineImage> getBaseMachineImages () {
    return this.resourceFetcher.getBaseMachineImages();
  }
  
  /**
   * @return A list of available custom machine images
   */
  public ArrayList<VirtualMachineImage> getCustomMachineImages () {
    return this.resourceFetcher.getCustomMachineImages();
  }
  
  
  /**
   * @return A list of available software dependencies
   */
  public ArrayList<SoftwareDependency> getSoftwareDependencies () {
    return this.resourceFetcher.getSoftwareDependencies();
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
  
  /**
   * @return A list of available software dependencies
   */
  public ArrayList<UserApplication> getUserApplications () {
    return this.resourceFetcher.getUserApplications();
  }
   
  
}
