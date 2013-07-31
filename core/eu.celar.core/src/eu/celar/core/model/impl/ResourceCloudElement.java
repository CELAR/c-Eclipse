/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model.impl;

import java.net.URI;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.IFileSystem;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ResourceCloudElement extends AbstractCloudElement {
  
  private IResource resource;

  
  protected ResourceCloudElement( final IResource resource ) {
    Assert.isNotNull( resource );
    this.resource = resource;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
    return this.resource.getName();
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    URI uri = this.resource.getLocationURI();
    IFileSystem fileSystem = EFS.getLocalFileSystem();
    IFileStore fileStore = fileSystem.getStore( uri );
    return fileStore;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getPath()
   */
  @Override
  public IPath getPath() {
    return this.resource.getFullPath();
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return this.resource;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    ICloudContainer parent = null;
    IPath parentPath = getPath().removeLastSegments( 1 );
    ICloudElement parentElement = CloudModel.getRoot().findElement( parentPath );
    if ( parentElement instanceof ICloudContainer ) {
      parent = ( ICloudContainer ) parentElement;
    }
    return parent;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return true;
  }
}
