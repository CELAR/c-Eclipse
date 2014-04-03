package eu.celar.connectors.openstack.ui.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import eu.celar.connectors.openstack.OpenStackCloudProvider;
import eu.celar.connectors.openstack.ui.Messages;
import eu.celar.ui.wizards.wizardselection.IInitializableWizard;

/**
 * This {@link Wizard} creates a new {@link OpenStackCloudProvider}.
 * 
 * @author Moritz Post
 */
public class OpenStackCloudProviderWizard extends Wizard implements IInitializableWizard {

  /** The {@link WizardPage} providing the form elements. */
  private OpenStackCloudProviderWizardPage wizardPage;

  /** The initial Cloud Provider. */
  private OpenStackCloudProvider initialCloudProvider;

  @Override
  public boolean performFinish() {
    return this.wizardPage.createCloudProvider();
  }

  public boolean init( final Object data ) {
    if( data instanceof OpenStackCloudProvider ) {
      this.initialCloudProvider = ( OpenStackCloudProvider )data;
      return true;
    }
    return false;
  }

  @Override
  public String getWindowTitle() {
    return Messages.getString( "OpenStackCloudProviderWizard.wizard_title" ); //$NON-NLS-1$
  }

  @Override
  public void addPages() {
    this.wizardPage = new OpenStackCloudProviderWizardPage();

    if( this.initialCloudProvider != null ) {
      this.wizardPage.setInitialCloudProvider( this.initialCloudProvider );
    }
    addPage( this.wizardPage );
  }
}
