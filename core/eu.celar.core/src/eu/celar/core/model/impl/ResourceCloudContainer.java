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
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import eu.celar.core.internal.Activator;
import eu.celar.core.internal.model.notify.CloudElementLifecycleManager;
import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudElementCreator;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ResourceCloudContainer extends AbstractCloudContainer {
  
  private IResource resource;
  
  protected ResourceCloudContainer( final IResource resource ) {
    Assert.isNotNull( resource );
    this.resource = resource;
    fetchChildren( null );
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudContainer#isLazy()
   */
  @Override
  public boolean isLazy() {
    return false;
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
  
  protected IStatus fetchChildren( final IProgressMonitor monitor ) {
    
    IProgressMonitor localMonitor
      = monitor != null
      ? monitor
      : new NullProgressMonitor();

    IStatus result = Status.CANCEL_STATUS;
    
    deleteAll();
    if ( ( this.resource != null ) && ( this.resource instanceof IContainer ) ) {
      lock();
      try {
        IResource[] members = ( ( IContainer ) this.resource ).members();
        localMonitor.beginTask( Messages.getString( "AbstractCloudContainer.load_progress" ), members.length ); //$NON-NLS-1$
        for ( IResource member : members ) {
          try {
            ICloudElementCreator creator = findCreator( member );
            if ( creator != null ) {
              create( creator );
            }
  
            localMonitor.worked( 1 );
            if ( localMonitor.isCanceled() ) {
              break;
            }
          } catch ( Throwable throwable ) {
            Activator.logException( throwable );
          }
        }
        result = Status.OK_STATUS;
      } catch ( CoreException cExc ) {
        Activator.logException( cExc );
        result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, Messages.getString( "AbstractCloudContainer.fetch_error"), cExc ); //$NON-NLS-1$
      } finally {
        unlock();
      }
    }

    localMonitor.done();

    return result;
  }
  
  protected ICloudElementCreator findCreator( final IResource res ) {
    return CloudElementLifecycleManager.findCreator( res );
  }
}
