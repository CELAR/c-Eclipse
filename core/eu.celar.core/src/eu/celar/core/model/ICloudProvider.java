/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;


/**
 * This is the base interface that all implementation of a Cloud Provider have
 * to implement. 
 */
public interface ICloudProvider extends ICloudContainer, ISerializableElement {
  
  @Override
  public String getName();
  
  /**
   * @return The Cloud Provider ID
   */
  public String getId();
  
  /**
   * @return Cloud Provider free text description
   */
  public String getDescription();
  
  public String getTypeName();
  
  
}
