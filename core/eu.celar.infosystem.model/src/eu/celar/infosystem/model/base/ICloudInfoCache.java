/**
 * 
 */
package eu.celar.infosystem.model.base;


/**
 * @author nickl
 *
 */
public interface ICloudInfoCache {
  
  
  public void addListener( final ICloudInfoCacheListener listener );
  
  public void removeListener (final ICloudInfoCacheListener listener);
  
  public void removeAllListeners();
  
  public void notifyListeners();
}
