package eu.celar.connectors.openstack.auth;

import java.net.URI;

import eu.celar.connectors.openstack.OpenStackCloudProvider;
import eu.celar.connectors.openstack.internal.Activator;
import eu.celar.connectors.openstack.internal.Messages;
import eu.celar.core.auth.AuthenticationException;
import eu.celar.core.auth.IAuthenticationToken;
import eu.celar.core.auth.IAuthenticationTokenDescription;
import eu.celar.core.auth.PasswordManager;
import eu.celar.core.reporting.ProblemException;

/**
 * This {@link IAuthenticationTokenDescription} provides the authentication
 * credentials for the OpenStack services. It creates {@link OpenStackAuthToken} instances
 * to use for the actual connection.
 * 
 * @author Nicholas Loulloudes
 * @see OpenStackAuthToken
 */
public class OpenStackAuthTokenDescription implements IAuthenticationTokenDescription
{

  /** The path for OpenStack related secure storage data. */
  public static final String SECURE_STORAGE_NODE = "/eu/celar/connectors/openstack/"; //$NON-NLS-1$

  /** The token type name. */
  private static final String TOKEN_TYPE_NAME = Messages.getString( "OSAuthTokenDescription.token_type_name" ); //$NON-NLS-1$

  /** The ID of the AWS authentication token wizard. */
  private static final String WIZARD_ID = "eu.celar.connectors.openstack.ui.wizards.openstackAuthTokenWizard"; //$NON-NLS-1$

  /** The ID of the problem regarding VO settings. */
  private static final String PROBLEM_CHECK_VO_SETTINGS_ID = "eu.celar.core.solution.auth.checkVoSettings"; //$NON-NLS-1$

  /**
   * The OpenStack access id to use when contacting the OpenStack services.
   */
  private String openstackAccessId;

  /** The OpenStack secret id to use when contacting the OpenStack services. */
  private String openstackSecretId;
  
  /** The OpenStack URI endpoint to use when contacting the OpenStack services. */
  private URI openstackEndPoint;

  /** The OpenStack Cloud Provider providing the services. */
  private OpenStackCloudProvider openstackCp;

  /**
   * Create a new {@link OpenStackAuthTokenDescription} with the data from the OpenStackCP
   * 
   * @param openstackCP
   */
  public OpenStackAuthTokenDescription( final OpenStackCloudProvider openstackCP ) {
    if( openstackCP != null ) {
      this.openstackCp = openstackCP;
      try {
        this.openstackAccessId = openstackCP.getProperties().getOpenStackAccessId();
        this.openstackEndPoint = openstackCP.getProperties().getOpenStackEndpoint();
      } catch( ProblemException problemEx ) {
        Activator.log( "Could not obtain openstack properties", problemEx ); //$NON-NLS-1$
      }
    }
  }

  /**
   * Creates an new {@link OpenStackAuthTokenDescription} with the given openstack access id
   * as its initial value.
   * 
   * @param openstackAccessId the openstack access id to use as the basis of the auth token
   */
  public OpenStackAuthTokenDescription( final String openstackAccessId, final URI openStackEndPoint ) {
    this.openstackAccessId = openstackAccessId;
    this.openstackEndPoint = openStackEndPoint;
  }

  public IAuthenticationToken createToken() throws AuthenticationException {
    if( this.openstackCp == null ) {
      throw new AuthenticationException( OpenStackAuthTokenDescription.PROBLEM_CHECK_VO_SETTINGS_ID,
                                         Messages.getString( "OSAuthTokenDescription.problem_description_no_openstack_cp" ), //$NON-NLS-1$
                                         Activator.PLUGIN_ID );
    }
    return new OpenStackAuthToken( this );
  }

  public String getTokenTypeName() {
    return OpenStackAuthTokenDescription.TOKEN_TYPE_NAME;
  }

  public String getWizardId() {
    return OpenStackAuthTokenDescription.WIZARD_ID;
  }

  public boolean matches( final IAuthenticationTokenDescription otherToken ) {

    boolean result = true;

    if( otherToken instanceof OpenStackAuthTokenDescription ) {
      OpenStackAuthTokenDescription openstackAuthTokenDesc = ( OpenStackAuthTokenDescription )otherToken;

      if( this.openstackAccessId != null
          && !this.openstackAccessId.equals( openstackAuthTokenDesc.getOpenStackAccessId() ) )
      {
        result = false;
      }
      if( this.openstackSecretId != null
          && !this.openstackSecretId.equals( openstackAuthTokenDesc.getOpenStackSecretId() ) )
      {
        result = false;
      }      
      if( this.openstackEndPoint != null
          && this.openstackEndPoint != openstackAuthTokenDesc.getOpenStackEndPoint() )
      {
        result = false;
      }
    } else {
      result = false;
    }
    return result;
  }

  /**
   * @return
   */
  public URI getOpenStackEndPoint() {    
    return this.openstackEndPoint;
  }

  /**
   * Getter for the openstackAccessId used to authenticate against the OpenStack
   * service.
   * 
   * @return the access id
   */
  public String getOpenStackAccessId() {
    return this.openstackAccessId;
  }

  /**
   * Getter for the openstack secret id used to authenticate against the OpenStack
   * services. At first an attempt is started to fetch the secret id from the
   * {@link PasswordManager}. If no secret id is found the secret id in this
   * {@link OpenStackAuthTokenDescription} is returned.
   * 
   * @return the secret id or <code>null</code> if none is specified
   */
  public String getOpenStackSecretId() {
    if( this.openstackAccessId != null ) {
      String secretId = PasswordManager.getPassword( OpenStackAuthTokenDescription.SECURE_STORAGE_NODE
                                                     + this.openstackAccessId + this.openstackEndPoint.getHost() );
      if( secretId != null ) {
        return secretId;
      }
    }
    return this.openstackSecretId;
  }

  /**
   * Getter for the {@link #openstackCp} field.
   * 
   * @return the openstackCp
   */
  public OpenStackCloudProvider getOpenStackCloudProvider() {
    return this.openstackCp;
  }

  /**
   * @param openstackCp the awsVo to set
   */
  public void setOpenStackCP( final OpenStackCloudProvider openstackCp ) {
    this.openstackCp = openstackCp;
  }

}
