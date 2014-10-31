/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.connectors.aws.info;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import eu.celar.connectors.aws.AWSApplicationDeploymentService;
import eu.celar.connectors.aws.AWSCloudProvider;
import eu.celar.connectors.aws.IAWSService;
import eu.celar.connectors.aws.internal.Activator;
import eu.celar.connectors.aws.internal.Messages;
import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudInfoService;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.ICloudResource;
import eu.celar.core.model.ICloudResourceCategory;
import eu.celar.core.model.ICloudService;
import eu.celar.core.model.impl.AbstractCloudInfoSystem;
import eu.celar.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public class AWSInfoService extends AbstractCloudInfoSystem {
  
  /** The name of the file to save this grid element in. */
  public static String STORAGE_NAME = ".awsInfoService"; //$NON-NLS-1$
	
  private AWSCloudProvider awsCP;
  
  private AWSInfoCache infoCache = null;
  
  public AWSInfoService (final AWSCloudProvider cp) {	
    this.awsCP = cp;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudResource#getURI()
   */
	@Override
	public URI getURI() throws ProblemException {
		try {
			return new URI(Messages.getString("AWSInfoService.aws_uri")); //$NON-NLS-1$
		} catch (URISyntaxException e) {
			return null;
		}
	}

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
	  String result = "AWS @ ";
	  try {
		result += getURI();
	} catch (ProblemException e) {
		e.printStackTrace();
	} //$NON-NLS-1$
	  return result;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    return getParent().getFileStore().getChild( AWSInfoService.STORAGE_NAME );
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getPath()
   */
  @Override
  public IPath getPath() {
	  return getParent().getPath().append( AWSInfoService.STORAGE_NAME );
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    return this.awsCP;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return true;
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
	  
	  List<IAWSService> awsServices = null;
	  
	  try {
		awsServices = this.awsCP.getChildren(monitor, IAWSService.class);	
	} catch (ProblemException e) {
		Activator.log("Could not load child services", e);
	}
	  
	  
	  ArrayList<ICloudResource> resourceList = null;
	  
	  if (awsServices != null) {
		  resourceList = new ArrayList<ICloudResource>();
		  
		  for (IAWSService service : awsServices) {
			  ICloudInfoService infoService = service.getInfoService();
			  if (infoService != null) {
				  ICloudResource[] cloudResources = infoService.fetchResources(parent, cp, category, exclusive, typeFilter, monitor);
				  Collections.addAll(resourceList, cloudResources);
 			  }
		  }
	  }
	  
	  if ( resourceList != null) {
		  return resourceList.toArray( new ICloudResource[resourceList.size()]);
	  }
	  
//    ICloudResource[] result = null;
//    
//    IProgressMonitor lMonitor
//      = monitor == null
//      ? new NullProgressMonitor()
//      : monitor;
//    
//    
//    if (!lMonitor.isCanceled())
//    {
//      if ( category.equals( CloudResourceCategoryFactory.
//                            getCategory( CloudResourceCategoryFactory.ID_DEPLOYMENT_SERVICES ) ) ) {
//        result = fetchDeploymentServices( parent, cp, lMonitor );
//      }  
//    }
//    
//    if ( ( result != null ) && ( typeFilter != null ) ) {
//      result = filterResources( result, typeFilter, false );
//    }
//    
//    if (result == null)
//      result = new ICloudResource[0];
      
    return new ICloudResource[0];
  }
  
  private ICloudService[] fetchDeploymentServices( final ICloudContainer parent,
                                            final ICloudProvider cp,
                                            IProgressMonitor monitor )
  {
    ArrayList<ICloudService> servicesList = new ArrayList<ICloudService>();
        
    if( monitor == null ) {
      monitor = new NullProgressMonitor();
    }
    
    monitor.beginTask( "Fetching AWS Deployment Service", 1 );
    AWSApplicationDeploymentService deploymentService = new AWSApplicationDeploymentService( parent );
    servicesList.add( deploymentService );
    monitor.worked( 2 );
    monitor.done();
    
    return servicesList.toArray( new ICloudService[servicesList.size()] );
    
  }
  
}
