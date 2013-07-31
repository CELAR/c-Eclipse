/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;

import java.net.URI;

import eu.celar.core.reporting.ProblemException;


/**
 * 
 * An interface for Cloud Monitor probes
 */
public interface ICloudMonitorProbe extends ICloudApplicationComponent {
  
  public String getName();
  
  /**
   * @return The UID of the monitor probe.
   */
  public String getUID();
  
  /**
   * @return Free text of the probe description.
   */
  public String getDescription();
  
  /**
   * @return the probe refresh interval
   */
  public int getRefreshInterval();
  
  /**
   * @return the probe alert interval
   */
  public int getAlertInterval();
  
  /**
   * @return is this a user developed probe
   */
  public boolean isCustomProbe();
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudResource#getURI()
   */
  @Override
  public URI getURI() throws ProblemException;
}
