/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;


/**
 * An element that describes a Cloud application and its properties.
 * Such descriptions are used to submit and deploy applications to
 * one ore more Cloud providers.  
 *
 */
public interface ICloudApplicationDescription extends ICloudContainer {
  
  /**
   * @return Free text of the application's name
   */
  public String getApplicationName();
  
  /**
   * @return Free text of the application's description
   */
  public String getApplicationDescription();
  
  /**
   * @return free text of the application version
   */
  public String getApplicationVersion();
  
  /**
   * @return free text of the application executable
   */
  public String getApplicationExecutable();
}
