/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;

/**
 * This a base interface for all resize action that can be performed
 * on a Cloud application
 *
 */
public interface ICloudResizeAction extends ICloudApplicationComponent {
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getName()
   */
  @Override
  public String getName();
  
  /**
   * @return free text describing the resize action
   */
  public String getDescription();
  
  /**
   * @return the resize action UID.
   */
  public String getUID();
}
