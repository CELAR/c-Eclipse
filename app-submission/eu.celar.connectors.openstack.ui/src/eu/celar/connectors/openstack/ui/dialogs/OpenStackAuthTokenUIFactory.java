package eu.celar.connectors.openstack.ui.dialogs;

import java.net.URI;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import eu.celar.connectors.openstack.auth.OpenStackAuthToken;
import eu.celar.connectors.openstack.auth.OpenStackAuthTokenDescription;
import eu.celar.core.auth.IAuthenticationToken;
import eu.celar.core.auth.IAuthenticationTokenDescription;
import eu.celar.ui.AbstractAuthTokenUIFactory;
import eu.celar.ui.IAuthTokenUIFactory;
import eu.celar.ui.dialogs.AuthTokenInfoDialog;


/**
 * This {@link IAuthTokenUIFactory} provides the {@link OpenStackAuthTokenInfoDialog}
 * {@link Composite} used to provide custom information for the
 * {@link OpenStackAuthToken} info dialog.
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackAuthTokenUIFactory extends AbstractAuthTokenUIFactory {

  /** A dummy openstack access id. */
  private static final String DEFAULT = "default"; //$NON-NLS-1$
  /** A dummy openstack endpoint URI. */
  private static final URI DEFAULT_ENDPOINT = URI.create( "http://localhost" ); //$NON-NLS-1$

  /**
   * Default constructor
   */
  public OpenStackAuthTokenUIFactory() {
    // nothing to do here
  }

  public AuthTokenInfoDialog getInfoDialog( final IAuthenticationToken token,
                                            final Shell parentShell )
  {
    return new OpenStackAuthTokenInfoDialog( token, parentShell );
  }

  public IAuthenticationTokenDescription getSupportedDescription() {
    return new OpenStackAuthTokenDescription( OpenStackAuthTokenUIFactory.DEFAULT,
                                              OpenStackAuthTokenUIFactory.DEFAULT_ENDPOINT );
  }

}
