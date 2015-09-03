package eu.celar.ui.wizards;

import java.net.URL;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.impl.GenericCloudProvider;
import eu.celar.core.model.impl.GenericCloudProviderCreator;
import eu.celar.ui.internal.Activator;


/**
 * Wizard page for the {@link GenericCloudProvider}.
 */
public class GenericCloudProviderWizardPage
    extends WizardPage {
  
  private GenericCloudProvider initialCloudProvider;
  
  private Text nameText;
  
  /** A pattern for matching the VO name */
  private Pattern cpNamePattern = Pattern.compile( "^[\\w.-]+$" ); //$NON-NLS-1$

  private Text uriText;

  private Text portText;
  
  
  /**
   * Standard constructor.
   */
  public GenericCloudProviderWizardPage() {
    super( "genericCOPage", //$NON-NLS-1$
           "Generic Cloud Provider",
           null );
    setDescription( "Specify the attributes of your Cloud Provider" );
    URL imgUrl = Activator.getDefault().getBundle().getEntry( "icons/wizban/vo_wiz.gif" ); //$NON-NLS-1$
    setImageDescriptor( ImageDescriptor.createFromURL( imgUrl ) );
  }

  public void createControl( final Composite parent ) {
    
    GridData gData;
    
    Composite mainComp = new Composite( parent, SWT.NONE );
    mainComp.setLayout( new GridLayout( 2, false ) );
    
    Label nameLabel = new Label( mainComp, SWT.NULL );
    nameLabel.setText( "&Cloud Provider Name:" );
    gData = new GridData();
    nameLabel.setLayoutData( gData );
    
    this.nameText = new Text( mainComp, SWT.BORDER );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.nameText.setLayoutData( gData );
    
    Label uriLabel = new Label( mainComp, SWT.NULL );
    uriLabel.setText( "&Cloud Provider URI:" );
    gData = new GridData();
    uriLabel.setLayoutData( gData );
    
    this.uriText = new Text( mainComp, SWT.BORDER );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.uriText.setLayoutData( gData );
    
    Label portLabel = new Label( mainComp, SWT.NULL );
    portLabel.setText( "&Cloud Provider Port:" );
    gData = new GridData();
    portLabel.setLayoutData( gData );
    
    this.portText = new Text( mainComp, SWT.BORDER );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.portText.setLayoutData( gData );
    
    if ( this.initialCloudProvider != null ) {
      initVo( this.initialCloudProvider );
    }
    
    setControl( mainComp );
    
  }
  
  public IStatus apply( final GenericCloudProviderCreator creator ) {
    
    IStatus result = Status.OK_STATUS;
    
    String name = this.nameText.getText();
    if ( ! validateVoName( name ) ) {
      result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, "You have to specify a valid Cloud Provider name" );
    } else if ( ( this.initialCloudProvider == null )
        && ( CloudModel.getCloudProviderManager().findChild( name ) != null ) ) {
      result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, "A Cloud Provider with the same name already exists" );
    } else {
      String uri = this.uriText.getText();
      String port = this.portText.getText();
      creator.setVoName( name );
      creator.setVoURI( uri );
      creator.setVoPort( port );
    }
    
    return result;
    
  }
  
  /**
   * Initializes the controls of this wizard page with the attributes
   * of the specified CP.
   * 
   * @param cp The  Cloud Provider whose attributes should be set to the page's controls.
   */
  protected void initVo( final GenericCloudProvider cp ) {
    this.nameText.setText( cp != null ? cp.getName() : "" ); //$NON-NLS-1$
    this.nameText.setEnabled( cp == null );
    this.uriText.setText( cp != null ? cp.getUri() : "" ); //$NON-NLS-1$
    this.uriText.setEnabled( true );
    this.portText.setText( cp != null ? cp.getPort() : "" ); //$NON-NLS-1$
    this.portText.setEnabled( true );
  }
  
  /**
   * Set the specified VO as initial CP. This means that the controls
   * of the page will be initialized with the attributes of the specified
   * VO.
   * 
   * @param cp The initial Cloud Provider.
   */
  protected void setInitialVo( final GenericCloudProvider cp ) {
    this.initialCloudProvider = cp;
  }
  
  /**
   * Helper method to validate the VO name entered by the user.
   * 
   * @param voName the VO name to validate
   * @return true if the VO name matches the allowed pattern
   */
  private boolean validateVoName( final String voName ) {
    return this.cpNamePattern.matcher( voName ).matches();
  }

}
