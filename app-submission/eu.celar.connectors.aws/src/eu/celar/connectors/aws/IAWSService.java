package eu.celar.connectors.aws;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudResourceCategory;


/**
 * The {@link IAWSService} is the interface which allows to contribute an Amazon
 * Webservice (EC2, S3, DevPay...) to the AWS base Vo. The services use the
 * authentication infrastructure provided by the AWS plugin.
 * 
 * @author Moritz Post
 */
public interface IAWSService extends ICloudContainer {


  /**
   * Provides an array of categories contributing to the AWS VO subfolders.
   * 
   * @return an array of categories
   */
  public ICloudResourceCategory[] getSupportedResources();

}