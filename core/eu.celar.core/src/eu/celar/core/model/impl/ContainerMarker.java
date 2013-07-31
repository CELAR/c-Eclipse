/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model.impl;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;

import eu.celar.core.model.ICloudContainer;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ContainerMarker extends AbstractCloudElement {
  
  /**
   * The type of this marker. May have influence how the marker
   * will be presented in the UI,
   */
  public static enum MarkerType {
    
    /**
     * Tag for an info marker.
     */
    INFO,
    
    /**
     * Tag for an error marker. 
     */
    ERROR
    
  }
  
  private ICloudContainer container;
  
  private MarkerType type;
  
  private String message;
  
  public ContainerMarker( final ICloudContainer container, final MarkerType type, final String message ) {
    this.container = container;
    this.type = type;
    this.message = message;
  }
  
  public static ContainerMarker getEmptyFolderMarker( final ICloudContainer container ) {
    return new ContainerMarker( container, MarkerType.INFO, "Folder is empty" );
  }
  
  public static ContainerMarker getErrorMarker( final ICloudContainer container, final Throwable t ) {
    return new ContainerMarker( container, MarkerType.ERROR, t.getLocalizedMessage() );
  }
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    return null;
  }
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
    return this.message;
  }
  
  public ICloudContainer getParent() {
    return this.container;
  }
  
  public IPath getPath() {
    return getParent().getPath().append( getName() );
  }
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return null;
  }
  
  /**
   * Get the type of this marker.
   * 
   * @return The marker's type.
   */
  public MarkerType getType() {
    return this.type;
  }
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return true;
  }
  
}
