/**
 * 
 */
package org.eclipse.camf.connectors.aws.ec2;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.eclipse.camf.connectors.aws.AWSCloudProvider;
import org.eclipse.camf.connectors.aws.EC2Client;
import org.eclipse.camf.connectors.aws.info.AWSInfoCache;
import org.eclipse.camf.connectors.aws.internal.Activator;
import org.eclipse.camf.connectors.aws.internal.Messages;
import org.eclipse.camf.connectors.aws.operation.AbstractEC2OpDescribeImages;
import org.eclipse.camf.connectors.aws.operation.EC2OpDescribeImages;
import org.eclipse.camf.connectors.aws.operation.OperationExecuter;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudResource;
import org.eclipse.camf.core.model.ICloudResourceCategory;
import org.eclipse.camf.core.model.impl.AbstractCloudInfoSystem;
import org.eclipse.camf.core.model.impl.CloudResourceCategoryFactory;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.infosystem.model.base.AbstractInfoCache;
import org.eclipse.camf.infosystem.model.base.IExtendedInfoService;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.VMI;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.jclouds.ec2.domain.Image;

/**
 * @author nickl
 */
public class EC2InfoService extends AbstractCloudInfoSystem implements IExtendedInfoService {

  /** The name of the file to save this cloud element in. */
  public static String STORAGE_NAME = ".ec2InfoService"; //$NON-NLS-1$
  private AWSCloudProvider awsCP;
  private EC2Service ec2Service;
  public static AWSInfoCache infoCache = null;
  

  public EC2InfoService( final AWSCloudProvider cp, final EC2Service ec2Service ) {
    this.awsCP = cp;
    this.ec2Service = ec2Service;
  }
  
  public String getHostName() {
    try {
      EC2ServiceProperties properties = this.ec2Service.getProperties();
      if( properties != null ) {
        return properties.getEc2Url();
      }
    } catch( ProblemException problemEx ) {
      Activator.log( "Could not load properties from ec2Service", problemEx ); //$NON-NLS-1$
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudResource#getURI()
   */
  @Override
  public URI getURI() throws ProblemException {
    String hostName = getHostName();
    try {
      if( hostName != null ) {
        return new URI( hostName );
      }
    } catch( URISyntaxException uriEx ) {
      Activator.log( "Could not creat URI from " + hostName, uriEx ); //$NON-NLS-1$
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
    return EC2InfoService.STORAGE_NAME;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    return getParent().getFileStore().getChild( EC2InfoService.STORAGE_NAME );
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getPath()
   */
  @Override
  public IPath getPath() {
    return getParent().getPath().append( EC2InfoService.STORAGE_NAME );
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return null;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    return this.ec2Service;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return false;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.IShareableElement#share()
   */
  @Override
  public void share() throws ProblemException {
    // TODO Auto-generated method stub
  }

  /*
   * (non-Javadoc)
   * @see
   * org.eclipse.camf.core.model.ICloudInfoService#fetchResources(org.eclipse.camf.core.model
   * .ICloudContainer, org.eclipse.camf.core.model.ICloudProvider,
   * org.eclipse.camf.core.model.ICloudResourceCategory, boolean, java.lang.Class,
   * org.eclipse.core.runtime.IProgressMonitor)
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
    
    initInfoCache();
    
    ICloudResource[] result = null;
    
    if( category.equals( CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_IMAGES ) ) )
    {

      result = fetchImages( parent,
                            cp,
                            monitor,
                            new EC2OpDescribeImages( getEc2() ) );
    }


    if (result == null)
      result = new ICloudResource[0];

    return result;
  }
  
  private void initInfoCache() {
    
    ArrayList<ICloudProvider> cloudProviders = new ArrayList<ICloudProvider>();
    try {
      ICloudElement[] projectElements = CloudModel.getRoot().getChildren( null );
      for( ICloudElement element : projectElements ) {
        ICloudProject icp = ( ICloudProject )element;
        if( icp.isOpen() && icp.getCloudProvider() != null ) {
          cloudProviders.add( icp.getCloudProvider() );
        }
      }
      
      infoCache = new AWSInfoCache( cloudProviders ) ;
        
    } catch ( ProblemException e ) {
      Activator.logException( e );
    }
  }

  /**
   * Fetches the available AMIs of the EC2 service using the owner as a filter.
   * 
   * @param parent the parent of this {@link IGridInfoService}
   * @param vo the vo initiating the query
   * @param monitor the monitor to notify of progress
   * @param operation the operation to execute
   * @return an array of {@link EC2AMIImage}s.
   */
  public ICloudResource[] fetchImages( final ICloudContainer parent,
                                      final ICloudProvider cp,
                                      IProgressMonitor monitor,
                                      final AbstractEC2OpDescribeImages operation )
  {
    if( monitor == null ) {
      monitor = new NullProgressMonitor();
    }

    // fetch existing AMI images from EC2 service
    monitor.beginTask( Messages.getString( "EC2InfoService.monitor_task_description" ), //$NON-NLS-1$
                       2 );

    new OperationExecuter().execOp( operation );

    monitor.worked( 1 );
    if( operation.getException() == null ) {
      // transform answer into gEclipse format
      ArrayList<ICloudResource> resultCloudService = new ArrayList<ICloudResource>( operation.getResult()
        .size() );

      for( Image ami : operation.getResult() ) {
        VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
        vmi.setUID( ami.getId() );
        vmi.setDescription( ami.getDescription() );
        vmi.setName( ami.getName() );
        vmi.setURL( ami.getImageLocation() );
        resultCloudService.add( new VMI( parent, vmi ) );
      }

      monitor.worked( 2 );
      monitor.done();
      return resultCloudService.toArray( new ICloudResource[ resultCloudService.size() ] );
    }
    return null;
  }
  
  private EC2Client getEc2() {
    return EC2Client.getInstance();
 }

  @Override
  public AbstractInfoCache getInfoCache() {
    return infoCache;
  }

  
}
