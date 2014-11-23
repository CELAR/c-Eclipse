package org.eclipse.camf.connectors.aws.ui.wizards;

import org.eclipse.camf.connectors.aws.AWSCloudProvider;
import org.eclipse.camf.connectors.aws.ui.Messages;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.camf.ui.wizards.wizardselection.IInitializableWizard;

/**
 * This {@link Wizard} creates a new {@link AWSCloudProvider}.
 * 
 * @author Moritz Post
 */
public class AWSCloudProviderWizard extends Wizard implements IInitializableWizard {

  /** The {@link WizardPage} providing the form elements. */
  private AWSCloudProviderWizardPage wizardPage;

  /** The initial Cloud Provider. */
  private AWSCloudProvider initialCloudProvider;

  @Override
  public boolean performFinish() {
    return this.wizardPage.createCloudProvider();
  }

  public boolean init( final Object data ) {
    if( data instanceof AWSCloudProvider ) {
      this.initialCloudProvider = ( AWSCloudProvider )data;
      return true;
    }
    return false;
  }

  @Override
  public String getWindowTitle() {
    return Messages.getString( "AWSCloudProviderWizard.wizard_title" ); //$NON-NLS-1$
  }

  @Override
  public void addPages() {
    this.wizardPage = new AWSCloudProviderWizardPage();

    if( this.initialCloudProvider != null ) {
      this.wizardPage.setInitialVo( this.initialCloudProvider );
    }
    addPage( this.wizardPage );
  }
}
