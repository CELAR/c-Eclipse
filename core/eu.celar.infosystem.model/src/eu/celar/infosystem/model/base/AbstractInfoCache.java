/**
 * 
 */
package eu.celar.infosystem.model.base;

import java.util.ArrayList;

import eu.celar.core.model.ICloudProvider;


/**
 * @author nickl
 *
 */
public abstract class AbstractInfoCache {
  
  public AbstractInfoCache (final ArrayList<ICloudProvider> providers) {
    setProviderList( providers );
  }

  public abstract void setProviderList( ArrayList<ICloudProvider> providers );
}
