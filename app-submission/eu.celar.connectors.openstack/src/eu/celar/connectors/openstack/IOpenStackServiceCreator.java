package eu.celar.connectors.openstack;

import java.net.URL;

import eu.celar.core.model.ICloudElementCreator;


/**
 * This interface acts as a gateway to an service creator. The decisive factor
 * is to fetch the services name and the corresponding service {@link URL}. A
 * common scenario is to extract these details from this
 * <code>eu.celar.core.cloudElementCreator</code> extension point defining
 * the {@link ICloudElementCreator}.
 * 

 */
public interface IOpenStackServiceCreator extends ICloudElementCreator {

  /**
   * Set the name of the service creator.
   * 
   * @param name the name to set
   */
  public void setName( String name );

  /**
   * Get the name of the service creator
   * 
   * @return the name of the creator
   */
  public String getName();

  /**
   * Set the url the service interacts with.
   * 
   * @param url the url to set
   */
  public void setServiceURL( String url );

  /**
   * Gets the service url of the service to be created.
   * 
   * @return the service url to get
   */
  public String getServiceURL();
}
