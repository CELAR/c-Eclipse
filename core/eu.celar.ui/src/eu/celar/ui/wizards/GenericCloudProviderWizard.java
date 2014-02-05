package eu.celar.ui.wizards;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.ICloudProviderManager;
import eu.celar.core.model.impl.GenericCloudProvider;
import eu.celar.core.model.impl.GenericCloudProviderCreator;
import eu.celar.core.reporting.ProblemException;
import eu.celar.ui.internal.Activator;
import eu.celar.ui.wizards.wizardselection.IInitializableWizard;



public class GenericCloudProviderWizard
    extends Wizard
    implements IInitializableWizard {
  
  private GenericCloudProvider initialVo;
  
  private GenericCloudProviderWizardPage cpPage;
  
//  private VoServiceSelectionPage servicePage;
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.wizard.Wizard#addPages()
   */
  @Override
  public void addPages() {
    
    this.cpPage = new GenericCloudProviderWizardPage();
//    this.servicePage = new VoServiceSelectionPage();
    
    if ( this.initialVo != null ) {
      this.cpPage.setInitialVo( this.initialVo );
//      this.servicePage.setInitialVo( this.initialVo );
    }
    
    addPage( this.cpPage );
//    addPage( this.servicePage );
    
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.wizard.Wizard#getWindowTitle()
   */
  @Override
  public String getWindowTitle() {
    return "Generic VO";
  }
  
  public boolean init( final Object initialData ) {
    boolean result = false;
    if ( initialData instanceof GenericCloudProvider ) {
      this.initialVo = ( GenericCloudProvider ) initialData;
      result = true;
    }
    return result;
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.wizard.Wizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    
    GenericCloudProviderCreator creator = new GenericCloudProviderCreator();
    
    IStatus result = this.cpPage.apply( creator );
    
    if ( result.isOK() ) {
//      result = this.servicePage.apply( creator );
    }
    
    if ( result.isOK() ) {
      result = createVo( creator );
    }
    
    if ( ! result.isOK() ) {
      ( ( WizardPage ) getContainer().getCurrentPage() ).setErrorMessage( result.getMessage() );
    }
    
    return result.isOK();
    
  }
  
  private IStatus createVo( final GenericCloudProviderCreator creator ) {
    
    IStatus result = Status.OK_STATUS;
    
    GenericCloudProvider vo = null;
    ICloudProviderManager manager = CloudModel.getCloudProviderManager();
    
    try {
      if ( this.initialVo != null ) {
        creator.apply( this.initialVo );
      } else {
        vo = ( GenericCloudProvider ) manager.create( creator );
      }
    } catch ( ProblemException pExc ) {
      result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, pExc.getLocalizedMessage(), pExc );
    }
    
    if ( ! result.isOK() && ( vo != null ) ) {
      try {
        manager.delete( vo );
      } catch ( ProblemException pExc ) {
        Activator.logException( pExc );
      }
    }
    
    return result;
    
  }
  
}
