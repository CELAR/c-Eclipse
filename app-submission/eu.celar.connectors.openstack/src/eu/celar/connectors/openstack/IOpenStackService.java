package eu.celar.connectors.openstack;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudResourceCategory;


public interface IOpenStackService extends ICloudContainer {


  /**
   * Provides an array of categories contributing to the OpenStack Cloud Provider subfolders.
   * 
   * @return an array of categories
   */
  public ICloudResourceCategory[] getSupportedResources();

}