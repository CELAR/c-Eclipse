/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.infosystem.mockup.info;

import java.net.URI;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudVirtualMachineImage;


/**
 * @author Nicholas Loulloudes
 *
 */
public class OldVirtualMachineImage extends ApplicationComponent implements ICloudVirtualMachineImage {

  private URI uri;
  private String name;
  private String uid;
  private String descr;
  /**
   * @param parent The parent Cloud Container
   */
  public OldVirtualMachineImage( final ICloudContainer parent ) {
    super( parent );
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudVirtualMachineImage#getDescription()
   */
  @Override
  public String getDescription() {
    return this.descr;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudVirtualMachineImage#getUID()
   */
  @Override
  public String getUID() {
    return this.uid;
  }
  
  
  /**
   * @param uri
   */
  public void setURI(final URI uri) {
    this.uri = uri;
  }
    
  /**
   * @param description
   */
  public void setDescription( final String description ) {
    this.descr = description;
  }

  
  /**
   * @param uid
   */
  public void setUID( final String uid ) {
    this.uid = uid;
  }
  
  /**
   * 
   */
  @Override
  public URI getURI() {
    return this.uri;
  }
  
  /* (non-Javadoc)
   * @see eu.celar.mockup.info.ApplicationComponent#getName()
   */
  @Override
  public String getName() {
    return this.name;
  }
  
  /**
   * @param name
   */
  public void setName(final String name) {
    this.name = name;
  }
  
}
