/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model.impl;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.PlatformObject;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudProject;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class AbstractCloudElement extends PlatformObject implements ICloudElement {

  
  private static final String HIDDEN_PREFIX = "."; //$NON-NLS-1$
  
  /* (non-Javadoc)
   * @see org.eclipse.core.runtime.PlatformObject#getAdapter(java.lang.Class)
   */
  @Override
  @SuppressWarnings("unchecked")
  public Object getAdapter( final Class adapter ) {
    Object result = null;
    if ( adapter.isAssignableFrom( getClass() ) ) {
      result = this;
    } else if ( adapter.isAssignableFrom( IResource.class ) ) {
      result = getResource();
    }
    if ( result == null ) {
      result = super.getAdapter( adapter );
    }
    return result;
  }
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getProject()
   */
  @Override
  public ICloudProject getProject() {
    ICloudContainer parent = getParent();
    return parent == null ? null : parent.getProject();
  }
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#isHidden()
   */
  @Override
  public boolean isHidden() {
    String name = getName();
    return ( name != null ) && ( getName().startsWith( HIDDEN_PREFIX ) );
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#isVirtual()
   */
  @Override
  public boolean isVirtual() {
    return getResource() == null;
  }
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#dispose()
   */
  @Override
  public void dispose() {
    // empty implementation
  }
}
