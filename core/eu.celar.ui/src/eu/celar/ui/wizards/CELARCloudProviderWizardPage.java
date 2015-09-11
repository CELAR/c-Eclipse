package eu.celar.ui.wizards;

import java.net.URL;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
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

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.impl.GenericCloudProvider;
import eu.celar.core.model.impl.GenericCloudProviderCreator;
import eu.celar.ui.internal.Activator;



/**
 * Wizard page for the {@link GenericCloudProvider}.
 */
public class CELARCloudProviderWizardPage
    extends WizardPage {
      
      private GenericCloudProvider initialCloudProvider;
        
      /** A pattern for matching the VO name */
      private Pattern cpNamePattern = Pattern.compile( "^[\\w.-]+$" ); //$NON-NLS-1$
      
      /** The name of the CloudProvider. */
      private Text cpNameText;
      
      /** Text widget to hold the cloud provider access id. */
      private Text uriText;
      
      /** Text widget to hold the cloud provider endpoint URL. */
      private Text portText;
      
      /**
       * Standard constructor.
       */
      public CELARCloudProviderWizardPage() {
        super( "CELARCOPage", //$NON-NLS-1$
               "CELAR Cloud Provider",
               null );
        setDescription( "Specify the attributes of the CELAR Cloud Provider" );
        URL imgUrl = Activator.getDefault().getBundle().getEntry( "icons/wizban/vo_wiz.gif" ); //$NON-NLS-1$
        setImageDescriptor( ImageDescriptor.createFromURL( imgUrl ) );
      }

      public void createControl( final Composite parent ) {
        
        GridData gData;

        Composite mainComp = new Composite( parent, SWT.NONE );
        mainComp.setLayout( new GridLayout( 1, false ) );

        // general cloud provider information
        Group settingsGroup = new Group( mainComp, SWT.NONE );
        settingsGroup.setLayout( new GridLayout( 2, false ) );
        settingsGroup.setText( Messages.getString( "CELARCloudProviderWizardPage.label_cp_settings" )); //$NON-NLS-1$
        gData = new GridData( GridData.FILL_HORIZONTAL );
        gData.grabExcessHorizontalSpace = true;
        settingsGroup.setLayoutData( gData );

        Label nameLabel = new Label( settingsGroup, SWT.LEFT );
        nameLabel.setText( Messages.getString( "CELARCloudProviderWizardPage.label_cp_name" ) + "            "  ); //$NON-NLS-1$
        nameLabel.setLayoutData( new GridData() );
        
        this.cpNameText = new Text( settingsGroup, SWT.LEFT
                                                   | SWT.SINGLE
                                                   | SWT.BORDER );
        gData = new GridData( GridData.FILL_HORIZONTAL );
        gData.grabExcessHorizontalSpace = true;
        this.cpNameText.setLayoutData( gData );
        this.cpNameText.addModifyListener( new ModifyListener() {
    
          public void modifyText( final ModifyEvent e ) {
            validateInput();
          }
    
        } );

        Label uriLabel = new Label( settingsGroup, SWT.LEFT );
        uriLabel.setText( Messages.getString( "CELARCloudProviderWizardPage.label_url" ) ); 
        uriLabel.setLayoutData( new GridData() );

        this.uriText = new Text( settingsGroup, SWT.LEFT
                                                        | SWT.SINGLE
                                                        | SWT.BORDER );
        gData = new GridData( GridData.FILL_HORIZONTAL );
        gData.grabExcessHorizontalSpace = true;
        this.uriText.setLayoutData( gData );
        this.uriText.addModifyListener( new ModifyListener() {

          public void modifyText( final ModifyEvent e ) {
            validateInput();
          }

        } );
        
        Label portLabel = new Label( settingsGroup, SWT.LEFT );
        portLabel.setText( Messages.getString( "CELARCloudProviderWizardPage.label_port" ) ); //$NON-NLS-1$
        portLabel.setLayoutData( new GridData() );

        this.portText = new Text( settingsGroup, SWT.LEFT
                                                        | SWT.SINGLE
                                                        | SWT.BORDER );
        gData = new GridData( GridData.FILL_HORIZONTAL );
        gData.grabExcessHorizontalSpace = true;
        this.portText.setLayoutData( gData );
        this.portText.addModifyListener( new ModifyListener() {

          public void modifyText( final ModifyEvent e ) {
            validateInput();
          }

        } );

        setControl( mainComp );
        
      }
      
      public IStatus apply( final GenericCloudProviderCreator creator ) {
        
        IStatus result = Status.OK_STATUS;
        
        String name = this.cpNameText.getText();
        String uri = this.uriText.getText();
        String port = this.portText.getText();
                
        if ( ! validateVoName( name ) ) {
          result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, "You have to specify a valid Cloud Provider name" );
        } else if ( ( this.initialCloudProvider == null )
            && ( CloudModel.getCloudProviderManager().findChild( name ) != null ) ) {
          result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, "A Cloud Provider with the same name already exists" );
        } else {
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
        this.cpNameText.setText( cp != null ? cp.getName() : "" ); //$NON-NLS-1$
        this.cpNameText.setEnabled( cp == null );
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
      
      /**
       * Check if the input of the form is valid.
       */
      protected void validateInput() {
        String name = this.cpNameText.getText().trim();
        if( name.length() == 0 ) {
          setErrorMessage( Messages.getString( "CELARWizardPage.error_cp_name_required" ) ); //$NON-NLS-1$
          setPageComplete( false );
        } else if ( ( this.initialCloudProvider == null )
            && ( CloudModel.getCloudProviderManager().findChild( name ) != null ) ) {
          setErrorMessage( Messages.getString( "CELARWizardPage.error_cp_already_exists" ) ); //$NON-NLS-1$
          setPageComplete( false );
        } else if( this.uriText.getText().trim().length() == 0 ) {
          setErrorMessage( Messages.getString( "CELARCloudProviderWizardPage.error_access_endpoint_required" ) ); //$NON-NLS-1$
          setPageComplete( false );
        } else if( this.portText.getText().trim().length() == 0 ) {
          setErrorMessage( Messages.getString( "CELARCloudProviderWizardPage.error_access_port_required" ) ); //$NON-NLS-1$
          setPageComplete( false );
        } else {
          setErrorMessage( null );
          setPageComplete( true );
        }
      }

}