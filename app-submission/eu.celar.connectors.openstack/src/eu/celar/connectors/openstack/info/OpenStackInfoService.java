/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.connectors.openstack.info;

import java.net.URI;
import java.util.ArrayList;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import eu.celar.connectors.openstack.OpenStackApplicationDeploymentService;
import eu.celar.connectors.openstack.OpenStackCloudProvider;
import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.ICloudResource;
import eu.celar.core.model.ICloudResourceCategory;
import eu.celar.core.model.ICloudService;
import eu.celar.core.model.impl.AbstractCloudInfoSystem;
import eu.celar.core.model.impl.CloudResourceCategoryFactory;
import eu.celar.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenStackInfoService extends AbstractCloudInfoSystem {
  
  private OpenStackCloudProvider osCP;
  
  
  public OpenStackInfoService (final OpenStackCloudProvider cp) {
    this.osCP = cp;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudResource#getURI()
   */
  @Override
  public URI getURI() throws ProblemException {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getPath()
   */
  @Override
  public IPath getPath() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.IShareableElement#share()
   */
  @Override
  public void share() throws ProblemException {
    // TODO Auto-generated method stub
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudInfoService#fetchResources(eu.celar.core.model.ICloudContainer, eu.celar.core.model.ICloudProvider, boolean, java.lang.Class, org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudResource[] fetchResources( final ICloudContainer parent,
                                          final ICloudProvider cp,
                                          final ICloudResourceCategory category,
                                          final boolean exclusive,
                                          final Class<? extends ICloudResource> typeFilter,
                                          final IProgressMonitor monitor )
    throws ProblemException
  {
    ICloudResource[] result = null;
    
    IProgressMonitor lMonitor
      = monitor == null
      ? new NullProgressMonitor()
      : monitor;
    
    
    if (!lMonitor.isCanceled())
    {
      if ( category.equals( CloudResourceCategoryFactory.
                            getCategory( CloudResourceCategoryFactory.ID_DEPLOYMENT_SERVICES ) ) ) {
        result = fetchDeploymentServices( parent, cp, lMonitor );
      }  
    }
    
    if ( ( result != null ) && ( typeFilter != null ) ) {
      result = filterResources( result, typeFilter, false );
    }
    
    if (result == null)
      result = new ICloudResource[0];
      
    return result;
  }
  
  private ICloudService[] fetchDeploymentServices( final ICloudContainer parent,
                                            final ICloudProvider cp,
                                            IProgressMonitor monitor )
  {
    ArrayList<ICloudService> servicesList = new ArrayList<ICloudService>();
        
    if( monitor == null ) {
      monitor = new NullProgressMonitor();
    }
    
    monitor.beginTask( "Fetching OpenStack Deployment Service", 1 );
    OpenStackApplicationDeploymentService deploymentService = new OpenStackApplicationDeploymentService( parent );
    servicesList.add( deploymentService );
    monitor.worked( 2 );
    monitor.done();
    
    return servicesList.toArray( new ICloudService[servicesList.size()] );
    
  }
  
}
