package eu.celar.connectors.aws;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import eu.celar.connectors.aws.info.AWSInfoService;
import eu.celar.connectors.aws.internal.Activator;
import eu.celar.connectors.aws.internal.Messages;
import eu.celar.core.Extensions;
import eu.celar.core.ICoreProblems;
import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudElementCreator;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.ICloudProviderManager;
import eu.celar.core.model.ICloudResourceCategory;
import eu.celar.core.model.ISerializableElement;
import eu.celar.core.model.impl.AbstractCloudProvider;
import eu.celar.core.reporting.ProblemException;



/**
 * This {@link AWSCloudProvider} is an {@link ICloudProvider}
 * implementation for the Amazon Webservices ({@link http://www.amazonaws.com/}
 * ). The VO encapsulates the {@link URL} to the webservice address and provides
 * an entry point to provide services to interact with the AWS technologies.
 * <p>
 * The {@link AWSCloudProvider} is created by the {@link ICloudProviderManager} and a
 * corresponding {@link AWSCloudProviderCreator}.
 * <p>
 * To facilitate physically present Amazon services, additional plugins have
 * provide an {@link ICloudElement} in the form of an {@link IAWSService}. The
 * {@link AWSCloudProvider} acts as a container for all these Services and
 * manages their displaying in the grid project.
 * 
 * @author Moritz Post
 * @see AWSCloudProviderCreator
 * @see AWSCloudProviderProperties
 */
public class AWSCloudProvider extends AbstractCloudProvider {

  /**
   * The id of the wizard to use for VO creation as specified in the
   * <code>plugin.xml</code>.
   */
  private static final String AWS_VO_WIZARD_ID = "eu.celar.connectors.aws.ui.wizard.awsCloudProviderWizard"; //$NON-NLS-1$

  /**
   * The type name of this VO implementation.
   */
  private static final String VO_TYPE_NAME = Messages.getString( "AWSCloudProvider.cp_type_name" ); //$NON-NLS-1$

  /**
   * Name of this Cloud Provider used in the {@link IFileStore}.
   */
  private String cpName;


  /**
   * Standard constructor used to Instantiate VO in the wizard.
   */
  public AWSCloudProvider() {
    // nothing to do here
  }

  /**
   * This constructor takes an {@link IFileStore} handle which contains a
   * reference to a {@link AWSCloudProviderCreator}. The content of the creator is loaded
   * and thereby populating this {@link AWSCloudProvider}.
   * 
   * @param fileStore the {@link AWSCloudProviderCreator} to obtain the data from
   */
  public AWSCloudProvider( final IFileStore fileStore ) {
    if( fileStore != null ) {

      this.cpName = fileStore.getName();
      try {
        deserialize();
        addElement( new AWSInfoService( this ) );
      } catch( ProblemException e ) {
        Activator.log( "Could not load the awsVo details from the filestore", e ); //$NON-NLS-1$
      }
    } else {
      Activator.log( "Could not populate AWSVirtualOrganization with data from fileStore" //$NON-NLS-1$
                     + " since given filestore was 'null'" ); //$NON-NLS-1$
    }
  }

  /**
   * This constructor takes an {@link AWSCloudProviderCreator} with the
   * {@link AWSCloudProvider} specific data. The details of the
   * {@linkplain AWSCloudProviderCreator creator} are {@linkplain #apply(AWSCloudProviderCreator)
   * applied} to this {@link AWSCloudProvider}.
   * 
   * @param voCreator the {@link AWSCloudProviderCreator} to get the data from
   */
  protected AWSCloudProvider( final AWSCloudProviderCreator voCreator ) {
    try {
      apply( voCreator );
      addElement( new AWSInfoService( this ) );
    } catch( ProblemException e ) {
      Activator.log( "Could not populate awsVo with data from provided AWSVo creator", //$NON-NLS-1$
                     e );
    }
  }

  /**
   * This Method transfers the name and the properties of the
   * {@link AWSCloudProviderCreator} to the {@link AWSCloudProvider}.
   * 
   * @param voCreator the {@link AWSCloudProviderCreator} to apply the data from
   * @throws GridModelExc8eption arises when interaction with the
   *           {@link GridModel} fails
   */
  void apply( final AWSCloudProviderCreator voCreator ) throws ProblemException {
    this.cpName = voCreator.getCloudProviderName();
    AWSCloudProviderProperties voProperties = new AWSCloudProviderProperties( this, voCreator );
    // add properties to this vo, replacing the existing props
    addElement( voProperties );

    List<IAWSServiceCreator> serviceCreators = AWSCloudProviderCreator.getAWSServiceCreators();
    for( IAWSServiceCreator serviceCreator : serviceCreators ) {
      create( serviceCreator );
    }
  }

  @Override
  public void deserialize() throws ProblemException {
    deleteAll();
    IFileStore fileStore = getFileStore();
    List<IConfigurationElement> configurationElements = CloudModel.getCreatorRegistry()
      .getConfigurations( null, IAWSService.class );
    try {
      IFileStore[] childStores = fileStore.childStores( EFS.NONE, null );

      for( IFileStore child : childStores ) {
        ICloudElement cloudElement = null;
        String childName = child.getName();

        if( childName.equals( AWSCloudProviderProperties.STORAGE_NAME ) ) {
          AWSCloudProviderProperties properties = new AWSCloudProviderProperties( this );
          properties.deserialize();
          cloudElement = properties;
        } else {
          for( IConfigurationElement configElement : configurationElements ) {
            String creatorId = configElement.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_ID_ATTRIBUTE );
            if( childName.equals( creatorId ) ) {
              ICloudElementCreator serviceCreator = ( ICloudElementCreator )configElement.createExecutableExtension( Extensions.CLOUD_ELEMENT_CREATOR_EXECUTABLE );
              cloudElement = serviceCreator.create( this );
              if( cloudElement instanceof ISerializableElement ) {
                ( ( ISerializableElement )cloudElement ).deserialize();
              }
            }
          }
        }

        if( cloudElement != null ) {
          addElement( cloudElement );
        }
      }
    } catch( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    }
  }

  @Override
  public ICloudResourceCategory[] getSupportedCategories() {
    ArrayList<ICloudResourceCategory> categoriesList = new ArrayList<ICloudResourceCategory>();
    try {
      List<IAWSService> awsServices = getChildren( new NullProgressMonitor(),
                                                   IAWSService.class );

      for( IAWSService service : awsServices ) {
        ICloudResourceCategory[] supportedResources = service.getSupportedResources();
        if( supportedResources != null ) {
          Collections.addAll( categoriesList, supportedResources );
        }
      }
    } catch( ProblemException problemEx ) {
      Activator.log( "Could not fetch the AWSServices from the AWS VO", //$NON-NLS-1$
                     problemEx );
    }

//    Collections.addAll( categoriesList,
//                        AWSCloudProvider.STANDARD_RESOURCE_CATEGORIES );
    return categoriesList.toArray( new ICloudResourceCategory[ categoriesList.size() ] );
  }

  /**
   * This method is not used. The entire loading procedure happens in
   * {@link #load()};
   */
  @Override
  protected ICloudElement loadChild( final String childName ) {
    return null;
  }

  @Override
  public boolean canContain( final ICloudElement element ) {
    return super.canContain( element ) || element instanceof AWSCloudProviderProperties;
  }

  public String getTypeName() {
    return AWSCloudProvider.VO_TYPE_NAME;
  }

  public String getWizardId() {
    return AWSCloudProvider.AWS_VO_WIZARD_ID;
  }

  public boolean isLazy() {
    return false;
  }

  public String getName() {
    return this.cpName;
  }

  @Override
  public boolean equals( final Object obj ) {
    boolean result = false;
    if( obj instanceof AWSCloudProvider ) {
      result = equals( ( AWSCloudProvider )obj );
    }
    return result;
  }

  /**
   * A comparison method using the {@link AWSCloudProvider#cpName} as
   * comparison criteria.
   * 
   * @param vo the {@link AWSCloudProvider} to compare with
   * @return if the two VOs are equal in regards to their name
   */
  private boolean equals( final AWSCloudProvider vo ) {
    return getName().equals( vo.getName() );
  }

  /**
   * Find the {@link AWSCloudProviderProperties} in the list of children of this VO.
   * 
   * @return This VO's properties.
   * @throws ProblemException if an error occurs while fetching the list of
   *           children.
   */
  public AWSCloudProviderProperties getProperties() throws ProblemException {
    AWSCloudProviderProperties properties = null;
    ICloudElement[] children = getChildren( null );

    for( ICloudElement child : children ) {
      if( child instanceof AWSCloudProviderProperties ) {
        properties = ( AWSCloudProviderProperties )child;
        break;
      }
    }
    return properties;
  }

  /**
   * Gets all the children in this {@link ICloudContainer}, which are an instance
   * of the passed elementType.
   * <p>
   * Method is defined not to check type conversions because it is ensured via
   * {@link Class#isInstance(Object)}.
   * 
   * @param <T> the type extending the {@link ICloudElement}
   * @param monitor the monitor to track progress
   * @param elementType the element type to filter by
   * @return a list of {@link ICloudElement}s which are an implementation of
   *         <code>&lt;T&gt;</code> or an empty {@link List}
   *         <code>&lt;T&gt;</code>
   * @throws ProblemException when the extraction of the children was not
   *           successful
   */
  @SuppressWarnings("unchecked")
  public <T extends ICloudElement> List<T> getChildren( final IProgressMonitor monitor,
                                                       final Class<T> elementType )
    throws ProblemException
  {
    ICloudElement[] children = getChildren( monitor );
    List<T> childrenList = new ArrayList<T>();
    if( elementType != null ) {
      for( ICloudElement cloudElement : children ) {
        if( elementType.isInstance( cloudElement ) ) {
          childrenList.add( ( T )cloudElement );
        }
      }
    }
    return childrenList;
  }

  public String getId() {
    return this.getClass().getName();
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProvider#getDescription()
   */
  @Override
  public String getDescription() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
