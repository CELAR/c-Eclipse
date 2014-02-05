package eu.celar.connectors.aws.ui.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import eu.celar.connectors.aws.auth.AWSAuthToken;
import eu.celar.connectors.aws.auth.AWSAuthTokenDescription;
import eu.celar.core.auth.AuthenticationException;
import eu.celar.core.auth.AuthenticationTokenManager;
import eu.celar.core.auth.IAuthenticationToken;
import eu.celar.core.auth.IAuthenticationTokenDescription;

/**
 * This {@link IRunnableWithProgress} object encapsulates the token creation
 * process of an {@link AWSAuthToken}. The creation and validation is confined
 * within its own runnable container. Any failures in creating the
 * {@link AWSAuthToken} result in a {@link AuthenticationException}, bound to
 * the problem <code>eu.geclipse.aws.ec2.problem.auth.authFailed</code>.
 * 
 * @author Moritz Post
 */
public class AWSKeyStoreCreationOperation implements IRunnableWithProgress {

  /**
   * The {@link IAuthenticationTokenDescription} to create the
   * {@link IAuthenticationToken} from
   */
  private AWSAuthTokenDescription description;

  /**
   * The constructor takes an {@link AWSAuthTokenDescription} object, which is
   * able to create the desired {@link AWSAuthToken}.
   * 
   * @param description the {@link IAuthenticationTokenDescription} to create
   *            the {@link IAuthenticationToken} from
   */
  public AWSKeyStoreCreationOperation( final AWSAuthTokenDescription description )
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
