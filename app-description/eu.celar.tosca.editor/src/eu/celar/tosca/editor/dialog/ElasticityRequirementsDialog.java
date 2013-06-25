/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation 
 ************************************************************/
package eu.celar.tosca.editor.dialog;


/**
 * @author stalo
 *
 */

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory;
import eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory;

public class ElasticityRequirementsDialog extends Dialog {

  protected Text typeText;
  protected Text valueText;
  protected boolean editMode = false;
  protected boolean addMode = false;
  protected String newType;
  protected String newValue; 
  protected GlobalElasticityRequirement elasticityRequirement;
  private CCombo cmbGlobalElasticityReq;
  private boolean modifiedValue = false;
  private String component;
  private  Label unitLabel;
 
  /**
   * @param parentShell
   */
  public ElasticityRequirementsDialog( final Shell parentShell, String component ) {
    super( parentShell );
    this.elasticityRequirement = null;
    this.addMode = true;
    this.component = component;
  }


  /**
   * @param parentShell
   * @param existingDataStage 
   * 
   */
  public ElasticityRequirementsDialog( final Shell parentShell,                              
                              final GlobalElasticityRequirement existingElasticityRequirement, String component )
                              
  {
    super( parentShell );
    this.editMode = true;
    this.elasticityRequirement = existingElasticityRequirement;
    this.component = component;
  }

  @Override
  protected void configureShell( final Shell shell ) {
    super.configureShell( shell );
    shell.setText( "Global Elasticity Requirements" ); 
    shell.setSize( 300, 170 );
  
  }

  @Override
  protected Control createDialogArea( final Composite parent ) {
    Composite composite = ( Composite )super.createDialogArea( parent );
    composite.setLayout( new GridLayout( 1, false ) );
    composite.setLayoutData( new GridData( GridData.FILL_BOTH ) );
//    Composite panel = new Composite( composite, SWT.NONE );
//    initializeDialogUnits( composite );
//    GridData gd;
//    GridLayout gLayout = new GridLayout( 3, false );
//    panel.setLayout( gLayout );
//    gd = new GridData( GridData.FILL_HORIZONTAL );
//    panel.setLayoutData( gd );
    
    
    Composite typeComposite = new Composite(composite, SWT.NONE);
    GridLayout gLayout = new GridLayout( 2, false );
    typeComposite.setLayout( gLayout );
    
    Label typeLabel = new Label( typeComposite, SWT.LEAD );
    typeLabel.setText( "Type" ); 
    GridData gd = new GridData(50, 20);
    typeLabel.setLayoutData( gd );
    
    
    // Combo - GlobalElasticityReq
    this.cmbGlobalElasticityReq = new CCombo( typeComposite, SWT.BORDER );
    this.cmbGlobalElasticityReq.setEnabled( true );
    gd = new GridData( 212, 20 );
    this.cmbGlobalElasticityReq.setLayoutData( gd );

        
    if (this.component.compareTo( "Application" )==0){
      List <GlobalElasticityRequirementCategory> categories = GlobalElasticityRequirementCategory.VALUES;
      
      for (GlobalElasticityRequirementCategory tempCat : categories){
        this.cmbGlobalElasticityReq.add(tempCat.toString());
      }      
    }
    else if (this.component.compareTo( "Application Component" )==0){
      List <ApplicationComponentElasticityRequirementCategory> categories = ApplicationComponentElasticityRequirementCategory.VALUES;
      
      for (ApplicationComponentElasticityRequirementCategory tempCat : categories){
        this.cmbGlobalElasticityReq.add(tempCat.toString());
      }
    }

    
    Composite valueComposite = new Composite(composite, SWT.NONE);
    gLayout = new GridLayout( 3, false );
    valueComposite.setLayout( gLayout );
    
    Label valueLabel = new Label( valueComposite, SWT.LEAD );
    valueLabel.setText( "Value" ); 
    gd = new GridData(50, 20);
    valueLabel.setLayoutData( gd );
    
    this.valueText = new Text( valueComposite, SWT.BORDER );
    gd = new GridData( 152, 20 );
    this.valueText.setLayoutData( gd );
    
    //metric unit label
    unitLabel = new Label( valueComposite, SWT.NONE );
     
    gd = new GridData(GridData.FILL_HORIZONTAL, 20);
    unitLabel.setLayoutData( gd );
    
    //instead of
    //this.cmbGlobalElasticityReq.add( Messages.getString( "NewApplicationDescriptionBasicPage.cmbMaxCost" ), 0 ); //$NON-NLS-1$
    //this.cmbGlobalElasticityReq.add( Messages.getString( "NewApplicationDescriptionBasicPage.cmbMinResponseTime" ), 1 ); //$NON-NLS-1$
        
    this.cmbGlobalElasticityReq.setEditable( false );
    this.cmbGlobalElasticityReq.addModifyListener( new ModifyListener(){

      public void modifyText( final ModifyEvent e ) {
        
        ElasticityRequirementsDialog.this.newType = ElasticityRequirementsDialog.this.cmbGlobalElasticityReq.getText();
        
        // set metric unit
        String unit = null;
        if( ElasticityRequirementsDialog.this.newType.compareTo( "Minimum Response Time" ) == 0 )
        {
          unit = "  ( s )";
        } else if( ElasticityRequirementsDialog.this.newType.compareTo( "Bandwidth" ) == 0 )
        {
          unit = "  ( MB/s )";
        } else if( ElasticityRequirementsDialog.this.newType.compareTo( "Minimun Cost" ) == 0 )
        {
          unit = "  ( $ )";
        } else if( ElasticityRequirementsDialog.this.newType.compareTo( "Maximum Cost" ) == 0 )
        {
          unit = "  ( $ )";
        } else {
          unit = "";
        }

        ElasticityRequirementsDialog.this.unitLabel.setText( unit );
          
      }
    });
         
        
    if( this.elasticityRequirement != null ) {
      this.cmbGlobalElasticityReq.setText(this.elasticityRequirement.type);
      this.valueText.setText( this.elasticityRequirement.value); 
    }
    
    
    this.valueText.addModifyListener( new ModifyListener(){

      public void modifyText( final ModifyEvent e ) {
        
        modifiedValue = true;
        
        ElasticityRequirementsDialog.this.newValue = ElasticityRequirementsDialog.this.valueText.getText();      
      }
    });
    
    return composite;
  }


  
  
  /**
   * Access to the List of Data Stage-In elements.
   * 
   * @return DataStage-In list set by the user.
   */
  public GlobalElasticityRequirement getDataStageInList(){
    return ElasticityRequirementsDialog.this.elasticityRequirement;
  }

  
  
  @SuppressWarnings("boxing")
  @Override
  protected void okPressed() {

    if (modifiedValue == false)
      this.newValue = this.elasticityRequirement.value;
    
    ElasticityRequirementsDialog.this.elasticityRequirement = new GlobalElasticityRequirement(this.newType, this.newValue);
    
    super.okPressed();
  
  }
  
  
}

