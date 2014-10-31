package eu.celar.connectors.aws;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import eu.celar.connectors.aws.info.IAWSServiceCreator;
import eu.celar.connectors.aws.internal.Activator;
import eu.celar.core.Extensions;
import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudElementCreator;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.ICreatorSourceMatcher;
import eu.celar.core.model.impl.AbstractCloudElementCreator;
import eu.celar.core.reporting.ProblemException;

/**
 * This {@link ICloudElementCreator} is able to create an
 * {@link AWSCloudProvider} from the input provided via its setter
 * methods. The currently required element is the {@link #providerName} to identify
 * the {@link AWSCloudProvider}. This input value is usually provided by
 * the user via some wizard page.
 * <p>
 * To make this {@link AWSCloudProviderCreator} available to the CELAR infrastructure
 * the extension point <code>eu.celar.core.cloudElementCreator</code> is
 * extended.
 * 
 * @author Moritz Post
 * @see AWSCloudProvider
 * @see AWSCloudProviderProperties
 */
public class AWSCloudProviderCreator
    extends AbstractCloudElementCreator
    implements ICreatorSourceMatcher {

  /**
   * The list of {@link IAWSServiceCreator}s which are able to create an
   * {@link IAWSService}.
   */
  private static List<IAWSServiceCreator> serviceCreatorList;

  /** The creators extension ID. */
  private static final String EXTENSION_ID = "eu.celar.connectors.aws.awsCpCreator"; //$NON-NLS-1$

  /**
   * The name of the {@link ICloudProvider} which this
   * {@link ICloudElementCreator} is able to create.
   */
  private String providerName;

  /**
   * The AWS access id associated the {@link ICloudProvider} with an AWS
   * account.
   */
  private String awsAccessId;

  /**
   * Default constructor used for initialization.
   */
  public AWSCloudProviderCreator() {
    // nothing to do here
  }

  @Override
  public boolean canCreate( final Object source ) {
      
    boolean result = false;

    if ( source instanceof IFileStore ) {
      IFileStore propertiesStore = ( ( IFileStore ) source ).getChild( AWSCloudProviderProperties.STORAGE_NAME );
      IFileInfo propertiesInfo = propertiesStore.fetchInfo();
      result = propertiesInfo.exists();
    }

    return result;

  }

  @Override
  public ICloudElement create( final ICloudContainer parent )
    throws ProblemException
  {
    AWSCloudProvider vo = null;
    Object source = getSource();
    if ( source == null ) {
      vo = new AWSCloudProvider( this );
    } else if ( source instanceof IFileStore ){
      vo = new AWSCloudProvider( ( IFileStore ) source );
    }
    return vo;
  }

  /**
   * This static method retrieves a list of all installed
   * {@link ICloudElementCreator}s (actually {@link IAWSServiceCreator}s),
   * which are able to produce {@link IAWSService} objects.
   * <p>
   * Additionally the {@link IAWSServiceCreator}s are initialized with the name
   * and default source pattern attribute as declared in the
   * <code>eu.celar.core.cloudElementCreator</code> extension point.
   * 
   * @return the list of configured and instantiated {@link IAWSServiceCreator}s
   *         or an empty {@link List}
   */
  public static synchronized List<IAWSServiceCreator> getAWSServiceCreators() {
    if( AWSCloudProviderCreator.serviceCreatorList == null ) {
      AWSCloudProviderCreator.serviceCreatorList = new ArrayList<IAWSServiceCreator>();

      // add registered IAwsServices to creator
      IAWSServiceCreator serviceCreator;
      List<IConfigurationElement> configurationElements
        = CloudModel.getCreatorRegistry().getConfigurations( null, IAWSService.class );
      for( IConfigurationElement configElem : configurationElements ) {
        try {
          // create element creator
          serviceCreator = ( IAWSServiceCreator )configElem.createExecutableExtension( Extensions.CLOUD_ELEMENT_CREATOR_EXECUTABLE );
          IConfigurationElement[] sourceChildern = configElem.getChildren( Extensions.CLOUD_ELEMENT_CREATOR_SOURCE_ELEMENT );

          // fetch default source element
          for( IConfigurationElement sourceElement : sourceChildern ) {
            String defaultSource = sourceElement.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_SOURCE_DEFAULT_ATTRIBUTE );
            boolean isDefaultSource = Boolean.parseBoolean( defaultSource );
            if( isDefaultSource ) {
              // set properties on creator
              serviceCreator.setServiceURL( sourceElement.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_SOURCE_PATTERN_ATTRIBUTE ) );
              serviceCreator.setName( configElem.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_NAME_ATTRIBUTE ) );
            }
          }
          AWSCloudProviderCreator.serviceCreatorList.add( serviceCreator );
        } catch( CoreException coreEx ) {
          Activator.log( "Could not create AWS service creator from extension definition: " //$NON-NLS-1$
                             + configElem.getValue(),
                         coreEx );
        } catch( ClassCastException castEx ) {
          Activator.log( "Given creator is not an instance of IAWSServiceCreator: " //$NON-NLS-1$
                             + configElem.getValue(),
                         castEx );
        }
      }
    }
    return AWSCloudProviderCreator.serviceCreatorList;
  }

  /**
   * A getter for the {@link #providerName}.
   * 
   * @return the name of future {@link ICloudProvider}s
   */
  public String getCloudProviderName() {
    return this.providerName;
  }

  /**
   * A setter for the {@link #providerName}.
   * 
   * @param providerName the name to be set for future {@link ICloudProvider}s
   */
  public void setProvider( final String providerName ) {
    this.providerName = providerName;
  }

  /**
   * Transfers the details ({@link #providerName} of this {@link AWSCloudProviderCreator} to the
   * provided {@link AWSCloudProvider}.
   * 
   * @param awsVo the {@link AWSCloudProvider} to populate
   */
  public void apply( final AWSCloudProvider awsVo ) {
    try {
      awsVo.apply( this );
    } catch ( ProblemException problemEx ) {
      Activator.log( "Could not populate AWSCloudProvider with the data from the AWSCloudProviderCreator", //$NON-NLS-1$
                     problemEx );
    }
  }

  public String getExtensionID() {
    return AWSCloudProviderCreator.EXTENSION_ID;
  }

  /**
   * A getter for the {@link #awsAccessId}.
   * 
   * @return the awsAccessId
   */
  public String getAwsAccessId() {
    return this.awsAccessId;
  }

  /**
   * A setter for the {@link #awsAccessId}.
   * 
   * @param awsAccessId the awsAccessId to set
   */
  public void setAwsAccessId( final String awsAccessId ) {
    this.awsAccessId = awsAccessId;
  }
}
