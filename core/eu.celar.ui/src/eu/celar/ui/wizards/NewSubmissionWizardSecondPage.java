package eu.celar.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


public class NewSubmissionWizardSecondPage extends WizardPage implements ModifyListener {
  
  private CCombo cmbCloudProvider;
  Composite container;

  protected NewSubmissionWizardSecondPage( String pageName ) {
    super( pageName );
    setPageComplete(false);
  }

  @Override
  public void createControl( Composite parent ) {

    container = new Composite( parent, SWT.NONE );
    GridLayout gLayout = new GridLayout( 2, false );
    gLayout.horizontalSpacing = 10;
    gLayout.verticalSpacing = 12;
    container.setLayout( gLayout );
    
    // Optimization Policy Label
    Label lblOptimizationPolicy = new Label( container,
                                             GridData.HORIZONTAL_ALIGN_BEGINNING
                                                 | GridData.VERTICAL_ALIGN_CENTER );
    lblOptimizationPolicy.setText( Messages.getString( "NewSubmissionWizardSecondPage.cloudProviderLabel" ) ); //$NON-NLS-1$
    GridData layout = new GridData();
    layout.horizontalAlignment = GridData.FILL;
    lblOptimizationPolicy.setLayoutData( layout );
    // Combo - Policy
    this.cmbCloudProvider = new CCombo( container, SWT.BORDER );
    this.cmbCloudProvider.setEnabled( true );
    layout = new GridData();
    layout.horizontalAlignment = GridData.FILL;
    layout.horizontalSpan = 2;
    this.cmbCloudProvider.setLayoutData( layout );
    this.cmbCloudProvider.add( Messages.getString( "NewSubmissionWizardSecondPage.cmbFlexiant" ), 0 ); //$NON-NLS-1$
    this.cmbCloudProvider.add( Messages.getString( "NewSubmissionWizardSecondPage.cmbOkeanos" ), 1 ); //$NON-NLS-1$
    this.cmbCloudProvider.setEditable( false );
    
    this.cmbCloudProvider.addModifyListener( this );
    
    setControl( container );
  }
  
  protected boolean validatePage() {
    boolean result = !( this.cmbCloudProvider.getText().equals( "" ) );
    if( result ) {
      setPageComplete( true );
      getContainer().updateButtons();
    }
    return result;
  }
  
  @Override
  public void modifyText( ModifyEvent e ) {
    if( e.widget == this.cmbCloudProvider )
      validatePage();
  }
  
  /**
   * @return the Cloud Provider
   */
  public String getCloudProvider() {
    return this.cmbCloudProvider.getText();
  }
}
