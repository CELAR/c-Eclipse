/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model.impl;

import eu.celar.core.model.ICloudProvider;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class AbstractInfoCache {
  
  /**
   * @param cp
   */
  public AbstractInfoCache (final ICloudProvider cp) {
    setCloudProvider (cp);
  }

  /**
   * @param cp
   */
  public abstract void setCloudProvider( final ICloudProvider cp );
}
