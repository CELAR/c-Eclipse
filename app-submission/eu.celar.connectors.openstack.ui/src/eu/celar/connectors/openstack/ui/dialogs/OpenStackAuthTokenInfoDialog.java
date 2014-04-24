package eu.celar.connectors.openstack.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import eu.celar.connectors.openstack.auth.OpenStackAuthToken;
import eu.celar.connectors.openstack.auth.OpenStackAuthTokenDescription;
import eu.celar.connectors.openstack.ui.Messages;
import eu.celar.core.auth.IAuthenticationToken;
import eu.celar.ui.dialogs.AuthTokenInfoDialog;

/**
 * This Dialog extension show details specific to the {@link OpenStackAuthToken}.
 * 
 * @author Moritz Post
 */
public class OpenStackAuthTokenInfoDialog extends AuthTokenInfoDialog {

  /**
   * Create a new {@link OpenStackAuthTokenInfoDialog} with the given token as its
   * information host.
   * 
   * @param token the token to take the information from
   * @param parentShell the shell to open the dialog with
   */
  public OpenStackAuthTokenInfoDialog( final IAuthenticationToken token,
                                 final Shell parentShell )
  {
    super( token, parentShell );
  }

  @Override
  protected Control createInfoArea( final Composite parent ) {

    OpenStackAuthTokenDescription desc = ( OpenStackAuthTokenDescription )getToken().getDescription();
    GridData gData;

    Label spacerLabel = new Label( parent, SWT.LEFT );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    gData.horizontalSpan = 2;
    spacerLabel.setLayoutData( gData );

    // access id text
    Label accessIdLabel = new Label( parent, SWT.LEFT );
    accessIdLabel.setText( Messages.getString( "OpenStackAuthTokenInfoDialog.label_os_access_id" ) ); //$NON-NLS-1$
    gData = new GridData();
    accessIdLabel.setLayoutData( gData );

    Text accessIdText = new Text( parent, SWT.LEFT
                                          | SWT.SINGLE
                                          | SWT.BORDER
                                          | SWT.READ_ONLY );
    accessIdText.setText( desc.getOpenStackAccessId() );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    accessIdText.setLayoutData( gData );
    
    // endpoint text
    Label endpointLabel = new Label( parent, SWT.LEFT );
    endpointLabel.setText( Messages.getString( "OpenStackAuthTokenInfoDialog.label_os_endpoint" ) ); //$NON-NLS-1$
    gData = new GridData();
    endpointLabel.setLayoutData( gData );

    Text endpointText = new Text( parent, SWT.LEFT
                                          | SWT.SINGLE
                                          | SWT.BORDER
                                          | SWT.READ_ONLY );
    accessIdText.setText( desc.getOpenStackEndPoint().toString() );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    accessIdText.setLayoutData( gData );

    // secret id
    Label secretIdLabel = new Label( parent, SWT.LEFT );
    secretIdLabel.setText( Messages.getString( "OpenStackAuthTokenInfoDialog.label_os_secret_id" ) ); //$NON-NLS-1$
    gData = new GridData();
    secretIdLabel.setLayoutData( gData );

    Text secretIdText = new Text( parent, SWT.LEFT
                                          | SWT.SINGLE
                                          | SWT.BORDER
                                          | SWT.PASSWORD
                                          | SWT.READ_ONLY );
    secretIdText.setText( desc.getOpenStackSecretId() );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    secretIdText.setLayoutData( gData );

    return parent;
  }
}