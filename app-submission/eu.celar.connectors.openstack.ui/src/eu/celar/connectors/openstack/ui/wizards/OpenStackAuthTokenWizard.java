package eu.celar.connectors.openstack.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import eu.celar.connectors.openstack.OpenStackCloudProvider;
import eu.celar.connectors.openstack.auth.OpenStackAuthToken;
import eu.celar.connectors.openstack.auth.OpenStackAuthTokenDescription;
import eu.celar.connectors.openstack.ui.Messages;
import eu.celar.connectors.openstack.ui.internal.OpenStackKeyStoreCreationOperation;
import eu.celar.core.reporting.IProblem;
import eu.celar.ui.dialogs.ProblemDialog;
import eu.celar.ui.wizards.CloudProviderSelectionWizardPage;
import eu.celar.ui.wizards.wizardselection.IInitializableWizard;


/**
 * A Wizard providing the infrastructure to create an {@link OpenStackAuthToken}. The
 * data input takes place in the {@link OpenStackAuthTokenWizardPage}. If the Wizard
 * is not able to create a {@link OpenStackAuthToken} with the provided details, an
 * {@link IProblem} with the id
 * <code>eu.celar.connectors.openstack.problem.auth.authFailed</code> is evaluated and
 * displayed in a {@link ProblemDialog}.
 * 
 * @author Nicholas Loulloudes
 * @see OpenStackAuthTokenWizardPage
 */
public class OpenStackAuthTokenWizard extends Wizard implements IInitializableWizard {

  /**
   * The {@link IAuthenticationTokenDescription} to generate the
   * {@link OpenStackAuthToken} from.
   */
  private OpenStackAuthTokenDescription authTokenDesc;

  /** The wizard page, which provides the form elements. */
  private OpenStackAuthTokenWizardPage authTokenWizardPage;

  /** The wizard page to select a Cloud Provider. */
  private CloudProviderSelectionWizardPage cpSelectionPage;

  /** A flag denoting if all the fields in the wizard are correctly filed. */
  private boolean canFinish;

  /**
   * The default constructor initializes the Wizard as unfinished.
   */
  public OpenStackAuthTokenWizard() {
    setCanFinish( false );
  }

  @Override
  public void addPages() {

    // show VO selection page if no vo is registered yet
    if( this.authTokenDesc != null ) {
      if( this.authTokenDesc.getOpenStackCloudProvider() == null ) {
        this.cpSelectionPage = new CloudProviderSelectionWizardPage( false,
                                                          OpenStackCloudProvider.class );
        addPage( this.cpSelectionPage );
      }
      this.authTokenWizardPage = new OpenStackAuthTokenWizardPage( this,
                                                             this.authTokenDesc );
      addPage( this.authTokenWizardPage );
    } else {
      this.cpSelectionPage = new CloudProviderSelectionWizardPage( false,
                                                                   OpenStackCloudProvider.class );
      this.authTokenWizardPage = new OpenStackAuthTokenWizardPage( this, null );
      addPage( this.cpSelectionPage );
      addPage( this.authTokenWizardPage );
    }
    setNeedsProgressMonitor( true );
  }

  @Override
  public String getWindowTitle() {
    return Messages.getString( "OpenStackAuthTokenWizard.wizard_title" ); //$NON-NLS-1$
  }

  @Override
  public boolean performFinish() {

    WizardPage currentPage = ( WizardPage )getContainer().getCurrentPage();
    if( currentPage == this.authTokenWizardPage ) {
      if( !this.authTokenWizardPage.isValid() ) {
        this.authTokenWizardPage.registerFormListener();
        return false;
      }
    }
    OpenStackAuthTokenDescription tokenDesc = this.authTokenWizardPage.getTokenDescription();
    OpenStackKeyStoreCreationOperation op = new OpenStackKeyStoreCreationOperation( tokenDesc );

    try {
      getContainer().run( false, false, op );
    } catch( InvocationTargetException itExc ) {
      Throwable cause = itExc.getCause();
      ProblemDialog.openProblem( getShell(),
                                 Messages.getString( "OpenStackAuthTokenWizard.problem_dialog_title" ), //$NON-NLS-1$
                                 Messages.getString( "OpenStackAuthTokenWizard.problem_dialog_description" ), //$NON-NLS-1$
                                 cause );
      currentPage.setErrorMessage( cause.getLocalizedMessage() );
    } catch( InterruptedException intExc ) {
      currentPage.setErrorMessage( intExc.getLocalizedMessage() );
    }

    String errorMessage = currentPage.getErrorMessage();

    if( errorMessage == null || errorMessage.length() == 0 ) {
      return true;
    }
    return false;
  }

  public boolean init( final Object data ) {
    if( data instanceof OpenStackAuthTokenDescription ) {
      this.authTokenDesc = ( OpenStackAuthTokenDescription )data;
    }
    return true;
  }

  @Override
  public boolean canFinish() {
    return this.canFinish;
  }

  /**
   * Sets the flag whether this wizard page can be finished.
   * 
   * @param canFinish the flag to set
   */
  public void setCanFinish( final boolean canFinish ) {
    this.canFinish = canFinish;
  }

}
