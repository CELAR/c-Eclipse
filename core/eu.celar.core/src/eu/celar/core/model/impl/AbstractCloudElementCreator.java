/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model.impl;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudElementCreator;
import eu.celar.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class AbstractCloudElementCreator implements ICloudElementCreator {
  
  /**
   * The source object for the element creation.
   */
  private Object internalSource;

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElementCreator#create(eu.celar.core.model.ICloudContainer, java.lang.Object)
   */
  @Override
  public ICloudElement create( final ICloudContainer parent, final Object source ) throws ProblemException {
    setSource( source );
    return create( parent );
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElementCreator#getSource()
   */
  @Override
  public Object getSource() {
    return this.internalSource;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElementCreator#setSource(java.lang.Object)
   */
  @Override
  public void setSource( final Object source ) {
    this.internalSource = source;
  }
}
