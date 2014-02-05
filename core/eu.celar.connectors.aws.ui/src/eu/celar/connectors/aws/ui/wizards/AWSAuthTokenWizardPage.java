package eu.celar.connectors.aws.ui.wizards;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import eu.celar.connectors.aws.AWSCloudProvider;
import eu.celar.connectors.aws.auth.AWSAuthToken;
import eu.celar.connectors.aws.auth.AWSAuthTokenDescription;
import eu.celar.connectors.aws.ui.Messages;
import eu.celar.connectors.aws.ui.internal.Activator;
import eu.celar.core.auth.PasswordManager;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.reporting.ProblemException;
import eu.celar.ui.wizards.CloudProviderSelectionWizardPage;


/**
 * This wizard page provides the form elements to input the details required to
 * create an {@link AWSAuthToken}.
 * 
 * @author Moritz Post
 */
public class AWSAuthTokenWizardPage extends WizardPage {

  /** The ID of the wizard page. */
  private static final String WIZARD_PAGE_ID = "eu.celar.connectors.aws.ui.awsAuthTokenWizardPage"; //$NON-NLS-1$

  /** The {@link Text} widget to hold the access id. */
  private Text accessIdText;

  /** The {@link Text} widget to hold the secret id. */
  private Text secretIdText;

  /** The initial datasource for the token. */
  private AWSAuthTokenDescription awsAuthTokenDesc;

  /** The parent {@link Wizard} of this page. */
  private AWSAuthTokenWizard authTokenWizard;

  /**
   * Create a new {@link AWSAuthTokenWizardPage} and provide initial content via
   * the awsAuthTokenDesc
   * 
   * @param authTokenWizard the parent {@link Wizard}
   * @param awsAuthTokenDesc the initial {@link AWSAuthTokenDescription}
   */
  protected AWSAuthTokenWizardPage( final AWSAuthTokenWizard authTokenWizard,
                                    final AWSAuthTokenDescription awsAuthTokenDesc )
  {
    super( AWSAuthTokenWizardPage.WIZARD_PAGE_ID,
           Messages.getString( "AWSAuthTokenWizardPage.wizard_page_title" ), //$NON-NLS-1$
           null );

    this.awsAuthTokenDesc = awsAuthTokenDesc;
    this.authTokenWizard = authTokenWizard;

    setDescription( Messages.getString( "AWSAuthTokenWizardPage.wizard_page_description" ) ); //$NON-NLS-1$
    URL imgUrl = Activator.getDefault()
      .getBundle()
      .getEntry( "icons/wizban/credentials_wiz.gif" ); //$NON-NLS-1$
    setImageDescriptor( ImageDescriptor.createFromURL( imgUrl ) );

  }

  @Override
  public void setVisible( final boolean visible ) {
    super.setVisible( visible );
    this.authTokenWizard.setCanFinish( true );
    if( visible ) {
      initPage();
    }
  }

  public void createControl( final Composite parent ) {

    GridData gData;

    Composite mainComp = new Composite( parent, SWT.NONE );
    mainComp.setLayout( new GridLayout( 1, false ) );

    // credentials group
    Group credentialsGroup = new Group( mainComp, SWT.NONE );
    credentialsGroup.setLayout( new GridLayout( 2, false ) );
    credentialsGroup.setText( Messages.getString( "AWSAuthTokenWizardPage.group_credentials_title" ) ); //$NON-NLS-1$
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    credentialsGroup.setLayoutData( gData );

    // access id text
    Label accessIdLabel = new Label( credentialsGroup, SWT.LEFT );
    accessIdLabel.setText( Messages.getString( "AWSAuthTokenWizardPage.label_access_id" ) ); //$NON-NLS-1$
    gData = new GridData();
    accessIdLabel.setLayoutData( gData );

    this.accessIdText = new Text( credentialsGroup, SWT.LEFT
                                                    | SWT.SINGLE
                                                    | SWT.BORDER
                                                    | SWT.READ_ONLY );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.accessIdText.setLayoutData( gData );

    // secret id
    Label secretIdLabel = new Label( credentialsGroup, SWT.LEFT );
    secretIdLabel.setText( Messages.getString( "AWSAuthTokenWizardPage.label_secret_id" ) ); //$NON-NLS-1$
    gData = new GridData();
    secretIdLabel.setLayoutData( gData );

    this.secretIdText = new Text( credentialsGroup, SWT.LEFT
                                                    | SWT.SINGLE
                                                    | SWT.BORDER
                                                    | SWT.PASSWORD );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.secretIdText.setLayoutData( gData );

    setControl( mainComp );
  }

  /**
   * Initializes the pages form based on either a provided
   * {@link AWSAuthTokenDescription} or the {@link AWSVirtualOrganization}
   * selected in the previous wizard page.
   */
  private void initPage() {
    // populate fields if possible
    String emptyString = ""; //$NON-NLS-1$
    this.accessIdText.setText( emptyString );
    this.secretIdText.setText( emptyString );

    if( this.awsAuthTokenDesc != null ) {
      String awsAccessId = this.awsAuthTokenDesc.getAwsAccessId();
      if( awsAccessId != null ) {
        String awsSecretId = PasswordManager.getPassword( AWSAuthTokenDescription.SECURE_STORAGE_NODE
                                                          + awsAccessId );

        this.accessIdText.setText( awsAccessId );
        if( awsSecretId != null ) {
          this.secretIdText.setText( awsSecretId );
        } else {
          this.secretIdText.setFocus();
        }
      }
    } else {
      ICloudProvider[] selectedCPs = getCPSelectionPage().getSelectedCloudProviders();

      if( selectedCPs[ 0 ] != null ) {
        AWSCloudProvider awsVo = ( AWSCloudProvider )selectedCPs[ 0 ];
        try {
          String awsAccessId = awsVo.getProperties().getAwsAccessId();
          this.accessIdText.setText( awsAccessId );
          String awsSecretId = PasswordManager.getPassword( AWSAuthTokenDescription.SECURE_STORAGE_NODE
                                                            + awsAccessId );
          if( awsSecretId != null ) {
            this.secretIdText.setText( awsSecretId );
          } else {
            this.secretIdText.setFocus();
          }
        } catch( ProblemException problemEx ) {
          Activator.log( "Could not extract aws access id from aws vo properties", //$NON-NLS-1$
                         problemEx );
        }
      } else {
        this.accessIdText.setEnabled( true );
        this.accessIdText.setFocus();
      }

    }
  }

  /**
   * Construct an {@link AWSAuthTokenDescription} from the specified settings of
   * the UI components.
   * 
   * @return A token description that holds the values that were specified using
   *         the UI components.
   */
  public AWSAuthTokenDescription getTokenDescription() {
    String accessId = this.accessIdText.getText().trim();
    String secretId = this.secretIdText.getText().trim();

    AWSCloudProvider awsCP = null;
    if( this.awsAuthTokenDesc == null
        || this.awsAuthTokenDesc.getAwsVo() == null )
    {
      ICloudProvider[] selectedCPs = getCPSelectionPage().getSelectedCloudProviders();

      for( ICloudProvider cloudProvider : selectedCPs ) {
        awsCP = ( AWSCloudProvider ) cloudProvider;
      }
    } else {
      awsCP = this.awsAuthTokenDesc.getAwsVo();
    }

    AWSAuthTokenDescription authTokenDesc = new AWSAuthTokenDescription( awsCP );
    PasswordManager.registerPassword( AWSAuthTokenDescription.SECURE_STORAGE_NODE
                                          + accessId,
                                      secretId );

    return authTokenDesc;
  }

  /**
   * Validate the input of this form. Check if the secret id and the access id
   * is present.
   * 
   * @return if this pages form data is valid or not
   */
  public boolean isValid() {
    String error = null;
    if( this.accessIdText.getText().trim().length() == 0 ) {
      error = Messages.getString( "AWSAuthTokenWizardPage.form_error_access_id_required" ); //$NON-NLS-1$
    }
    if( this.secretIdText.getText().trim().length() == 0 ) {
      error = Messages.getString( "AWSAuthTokenWizardPage.form_error_secret_id_required" ); //$NON-NLS-1$
    }
    if( error != null ) {
      setErrorMessage( error );
      this.authTokenWizard.setCanFinish( false );
      getWizard().getContainer().updateButtons();
      return false;
    }
    setErrorMessage( null );
    this.authTokenWizard.setCanFinish( true );
    getWizard().getContainer().updateButtons();
    return true;

  }

  /**
   * Fetch the vo selection page to choose a VO.
   * 
   * @return the {@link VoSelectionWizardPage}
   */
  private CloudProviderSelectionWizardPage getCPSelectionPage() {
    IWizardPage page = getPreviousPage();
    while( page != null && !( page instanceof CloudProviderSelectionWizardPage ) ) {
      page = page.getPreviousPage();
    }
    return ( CloudProviderSelectionWizardPage )page;
  }

  /**
   * Register listeners on the form input fields so that after a first press of
   * the "Finish" button, any subsequent key strokes trigger validation of the
   * {@link Text} input widgets.
   */
  public void registerFormListener() {
    this.accessIdText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        isValid();
      }
    } );

    this.secretIdText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        isValid();
      }
    } );
  }
}
