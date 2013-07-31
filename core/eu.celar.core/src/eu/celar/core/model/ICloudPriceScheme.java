/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;


/**
 * Interface for the Cloud pricing schemes
 * 
 */
public interface ICloudPriceScheme extends ICloudApplicationComponent {
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getName()
   */
  @Override
  public String getName();
  
  /**
   * @return The scheme description
   */
  public String getDescription();
  
  /**
   * @return The scheme UID
   */
  public String getUID();
}
