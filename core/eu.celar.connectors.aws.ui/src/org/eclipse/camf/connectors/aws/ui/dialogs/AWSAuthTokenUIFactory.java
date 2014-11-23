package org.eclipse.camf.connectors.aws.ui.dialogs;

import org.eclipse.camf.connectors.aws.auth.AWSAuthTokenDescription;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.camf.core.auth.IAuthenticationToken;
import org.eclipse.camf.core.auth.IAuthenticationTokenDescription;
import org.eclipse.camf.ui.AbstractAuthTokenUIFactory;
import org.eclipse.camf.ui.dialogs.AuthTokenInfoDialog;


/**
 * This {@link IAuthTokenUIFactory} provides the {@link AWSAuthTokenInfoDialog}
 * {@link Composite} used to provide custom information for the
 * {@link AWSAuthToken} info dialog.
 * 
 * @author Moritz Post
 */
public class AWSAuthTokenUIFactory extends AbstractAuthTokenUIFactory {

  /** A dummy aws access id. */
  private static final String DEFAULT = "default"; //$NON-NLS-1$

  /**
   * Default constructor
   */
  public AWSAuthTokenUIFactory() {
    // nothing to do here
  }

  public AuthTokenInfoDialog getInfoDialog( final IAuthenticationToken token,
                                            final Shell parentShell )
  {
    return new AWSAuthTokenInfoDialog( token, parentShell );
  }

  public IAuthenticationTokenDescription getSupportedDescription() {
    return new AWSAuthTokenDescription( AWSAuthTokenUIFactory.DEFAULT );
  }

}
