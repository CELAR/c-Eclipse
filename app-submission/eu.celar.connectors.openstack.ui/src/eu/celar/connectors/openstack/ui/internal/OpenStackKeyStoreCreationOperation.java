package eu.celar.connectors.openstack.ui.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import eu.celar.connectors.openstack.auth.OpenStackAuthToken;
import eu.celar.connectors.openstack.auth.OpenStackAuthTokenDescription;
import eu.celar.core.auth.AuthenticationException;
import eu.celar.core.auth.AuthenticationTokenManager;
import eu.celar.core.auth.IAuthenticationToken;


/**
 * This {@link IRunnableWithProgress} object encapsulates the token creation
 * process of an {@link OpenStackAuthToken}. The creation and validation is confined
 * within its own runnable container. Any failures in creating the
 * {@link OpenStackAuthToken} result in a {@link AuthenticationException}, bound to
 * the problem <code>eu.celar.connectors.openstack.problem.auth.authFailed</code>.
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackKeyStoreCreationOperation implements IRunnableWithProgress {

  /**
   * The {@link IAuthenticationTokenDescription} to create the
   * {@link IAuthenticationToken} from
   */
  private OpenStackAuthTokenDescription description;

  /**
   * The constructor takes an {@link OpenStackAuthTokenDescription} object, which is
   * able to create the desired {@link OpenStackAuthToken}.
   * 
   * @param description the {@link IAuthenticationTokenDescription} to create
   *            the {@link IAuthenticationToken} from
   */
  public OpenStackKeyStoreCreationOperation( final OpenStackAuthTokenDescription description )
  {
    this.description = description;
  }

  public void run( final IProgressMonitor monitor )
    throws InvocationTargetException, InterruptedException
  {

    // create the new token and validate it if the creation was successful
    AuthenticationTokenManager manager = AuthenticationTokenManager.getManager();
    IAuthenticationToken token = null;
    try {
      token = manager.createToken( this.description );
      if( token != null ) {
        token.validate( monitor );
      }
    } catch( AuthenticationException authEx ) {
      if( token != null ) {
        try {
          manager.destroyToken( token );
        } catch( AuthenticationException authExDestroy ) {
          Activator.log( "Problems destroying invalid token", authExDestroy ); //$NON-NLS-1$
        }
      }
      throw new InvocationTargetException( authEx );
    }

  }

}
