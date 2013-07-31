/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;

/**
 * This is the base interface that all Cloud script should implement.
 *
 */
public interface ICloudScript extends ICloudContainer {
  
  /**
   * @return The script name
   */
  public String getScriptName();
  
  /**
   * @return free text of what the script does
   */
  public String getScriptDescription();
  
  /**
   * @return the script version
   */
  public String getScriptVersion();  
}
