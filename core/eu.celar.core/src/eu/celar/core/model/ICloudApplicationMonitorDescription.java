/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;

import java.util.List;


/**
 * An element that describes a Cloud application monitoring details.
 * Such descriptions are used for presenting monitoring details of
 * a particular application and getting probe details.
 *
 */
public interface ICloudApplicationMonitorDescription extends ICloudContainer {
  
  /**
   * @return free text of the application's name
   */
  public String getApplicationName();
  
  /**
   * @return free text of the current monitoring description version
   */
  public String getVersion();
  
  /**
   * @return number of monitoring probes.
   */
  public int getProbeCount();
  
  /**
   * @return list of {@link ICloudMonitorProbe}s
   */
  public List<ICloudMonitorProbe> getMonitorProbes();
}
