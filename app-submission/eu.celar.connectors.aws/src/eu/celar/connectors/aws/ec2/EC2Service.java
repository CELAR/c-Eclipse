package eu.celar.connectors.aws.ec2;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;

import eu.celar.connectors.aws.AWSCloudProvider;
import eu.celar.connectors.aws.IAWSService;
import eu.celar.connectors.aws.internal.Activator;
import eu.celar.core.ICoreProblems;
import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudInfoService;
import eu.celar.core.model.ICloudResourceCategory;
import eu.celar.core.model.ISerializableElement;
import eu.celar.core.model.impl.AbstractCloudContainer;
import eu.celar.core.model.impl.CloudResourceCategoryFactory;
import eu.celar.core.reporting.ProblemException;

/**
 * The {@link EC2Service} is a concrete implementation of an {@link IAWSService}
 * . It encapsulates the properties ({@link EC2ServiceProperties}) and
 * functionality ({@link EC2InfoService}) needed to interact with the Amazon
 * Elastic Computing Cloud (EC2) Webservices.
 * <p>
 * The {@link EC2Service} obtains its initial configuration directives from its
 * creator, the {@link EC2ServiceCreator}.
 * 
 * @author Moritz Post
 * @see EC2ServiceCreator
 */
public class EC2Service extends AbstractCloudContainer
  implements IAWSService, ISerializableElement
{

  /** Name to reference the service. */
  public static final String STORAGE_NAME = "eu.celar.connectors.aws.ec2.service.ec2ServiceCreator"; //$NON-NLS-1$

  /** The {@link AWSCloudProvider} this service is based on. */
  private AWSCloudProvider awsCP;

  /** The categories introduced by this {@link IAWSService}. */
  public static ICloudResourceCategory[] standardResources = new ICloudResourceCategory[]{
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_IMAGES ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_IMAGES_ALL ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_IMAGES_MY_OWNED ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_IMAGES_MY_ACCESSIBLE ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_SECURITY_GROUPS ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_KEYPAIRS ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_ELASTIC_IP )
  };

  /**
   * Create a new {@link EC2Service} with the service creator acting as the
   * source of initial configuration directives.
   * 
   * @param serviceCreator the initial configuration
   * @param cp the Vo to use for authentication
   */
  public EC2Service( final EC2ServiceCreator serviceCreator,
                     final AWSCloudProvider cp )
  {
    this.awsCP = cp;
    try {
      addElement( new EC2InfoService( cp, this ) );
      apply( serviceCreator );
    } catch( ProblemException problemEx ) {
      Activator.log( "Could not populate EC2Service with data from provided EC2 service creator and the infoservice", //$NON-NLS-1$
                     problemEx );
    }
  }

  /**
   * Creates a new {@link EC2Service} where the properties are loaded from the
   * local storage.
   * 
   * @param cp the Vo to use for authentication
   */
  public EC2Service( final AWSCloudProvider cp ) {
    this.awsCP = cp;
    try {
      EC2ServiceProperties serviceProperties = new EC2ServiceProperties( this );
      serviceProperties.deserialize();
      addElement( serviceProperties );
      addElement( new EC2InfoService( cp, this ) );
    } catch( ProblemException e ) {
      Activator.log( "Could not load the ec2 service details from the filestore", //$NON-NLS-1$
                     e );
    }
  }

  @Override
  public boolean canContain( final ICloudElement element ) {
    return element instanceof EC2ServiceProperties
           || element instanceof EC2InfoService;
  }

  /**
   * This Method transfers the name and the properties of the
   * {@link EC2ServiceCreator} to the {@link EC2Service}.
   * 
   * @param serviceCreator the {@link EC2ServiceCreator} to apply the data from
   * @throws ProblemException
   */
  public void apply( final EC2ServiceCreator serviceCreator )
    throws ProblemException
  {
    EC2ServiceProperties properties = new EC2ServiceProperties( this,
                                                                serviceCreator );
    // add properties to this service, replacing the existing properties
    addElement( properties );
  }

  public ICloudResourceCategory[] getSupportedResources() {
    return EC2Service.standardResources;
  }

  public String getHostName() {
    EC2ServiceProperties properties = null;
    try {
      properties = getProperties();
    } catch( ProblemException e ) {
      Activator.log( "Could not load the properties of the ec2 service", e ); //$NON-NLS-1$
    }
    if( properties != null ) {
      return properties.getEc2Url();
    }
    return null;
  }

  public URI getURI() {
    String hostName = getHostName();
    try {
      if( hostName != null ) {
        return new URI( hostName );
      }
    } catch( URISyntaxException e ) {
      Activator.log( "Could not create EC2 service URI from " + hostName, e ); //$NON-NLS-1$
    }
    return null;
  }

  public IFileStore getFileStore() {
    return getParent().getFileStore().getChild( EC2Service.STORAGE_NAME );
  }

  public String getName() {
    EC2ServiceProperties properties = null;
    try {
      properties = getProperties();
    } catch( ProblemException gridModelEx ) {
      Activator.log( "Could not load the properties of the ec2 service", gridModelEx ); //$NON-NLS-1$
    }
    if( properties != null ) {
      return properties.getServiceName();
    }
    return null;
  }

  public ICloudContainer getParent() {
    return this.awsCP;
  }

  public IPath getPath() {
    return getParent().getPath().append( EC2Service.STORAGE_NAME );
  }

  public IResource getResource() {
    return null;
  }

  public boolean isLocal() {
    return true;
  }

  public boolean isLazy() {
    return false;
  }

  @Override
  public boolean equals( final Object obj ) {
    boolean result = false;
    if( obj instanceof EC2Service ) {
      result = equals( ( EC2Service )obj );
    }
    return result;
  }

  /**
   * A comparison method using the {@link EC2Service#voName} as comparison
   * criteria.
   * 
   * @param service the {@link EC2Service} to compare with
   * @return if the two services are equal in regards to their name
   */
  private boolean equals( final EC2Service service ) {
    return getName().equals( service.getName() );
  }

  /**
   * Find the {@link EC2ServiceProperties} in the list of children of this
   * service.
   * 
   * @return this services properties or <code>null</code> if no properties
   *         could be retrieved
   * @throws ProblemException if an error occurs while fetching the properties.
   */
  public EC2ServiceProperties getProperties() throws ProblemException {
    EC2ServiceProperties properties = null;
    ICloudElement[] children = getChildren( null );

    for( ICloudElement child : children ) {
      if( child instanceof EC2ServiceProperties ) {
        properties = ( EC2ServiceProperties )child;
        break;
      }
    }
    return properties;
  }

  public ICloudInfoService getInfoService() {
    ICloudInfoService infoService = null;
    try {
      ICloudElement[] children = getChildren( null );
      for( ICloudElement child : children ) {
        if( child instanceof ICloudInfoService ) {
          infoService = ( EC2InfoService )child;
          break;
        }
      }
    } catch( ProblemException cloudModelEx ) {
      Activator.log( "Could not get info service from EC2Service", cloudModelEx ); //$NON-NLS-1$
    }
    return infoService;
  }

  public void deserialize() throws ProblemException {
    deleteAll();
    addElement( new EC2InfoService( this.awsCP, this ) );
    IFileStore fileStore = getFileStore();
    try {
      IFileStore[] childStores = fileStore.childStores( EFS.NONE, null );
      for( IFileStore child : childStores ) {

        if( child.getName().equals( EC2ServiceProperties.STORAGE_NAME ) ) {
          EC2ServiceProperties serviceProperties = new EC2ServiceProperties( this );
          serviceProperties.deserialize();
          addElement( serviceProperties );
        }
      }
    } catch( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    }
  }

  public void serialize() throws ProblemException {
    // create own storage directory
    IFileStore fileStore = getFileStore();
    if( !fileStore.fetchInfo().exists() ) {
      try {
        fileStore.mkdir( EFS.NONE, new NullProgressMonitor() );
      } catch( CoreException e ) {
        Activator.log( "Could not create storage dir for ec2Service", e ); //$NON-NLS-1$
        return;
      }
    }

    // save children
    ICloudElement[] children = getChildren( null );
    for( ICloudElement child : children ) {
      if( child instanceof ISerializableElement ) {
        ( ( ISerializableElement )child ).serialize();
      }
    }
  }

@Override
public void share() throws ProblemException {
	// TODO Auto-generated method stub
	
}

}