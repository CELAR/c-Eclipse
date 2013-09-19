/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.dialog;

/**
 * @author stalo
 */
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory;
import eu.celar.tosca.elasticity.ElasticityRequirementCategory;


public class ElasticityStrategyDialog extends Dialog {

  protected Text typeText;
  protected Text valueText;
  protected boolean editMode = false;
  protected boolean addMode = false;
  protected String newType;
  protected String elasticityStrategy;
  private CCombo cmbStrategy;
  private CCombo cmbMetric;
  private String component;
  
  /**
   * @param parentShell
   */
  public ElasticityStrategyDialog( final Shell parentShell, String component )
  {
    super( parentShell );
    this.addMode = true;
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


    // Combo - GlobalElasticityReq
    this.cmbStrategy = new CCombo( composite, SWT.BORDER );
    this.cmbStrategy.setEnabled( true );
    GridData gd = new GridData( GridData.FILL_HORIZONTAL );
    this.cmbStrategy.setLayoutData( gd );

    this.cmbStrategy.add( "Maximize" );
    this.cmbStrategy.add( "Minimize" );
    this.cmbStrategy.setText( this.cmbStrategy.getItem( 0 ) );  
    
    this.cmbStrategy.setEditable( false );
        
    // Combo - Metric

    this.cmbMetric = new CCombo( composite, SWT.BORDER );
    this.cmbMetric.setEnabled( true );
    GridData gdMetric = new GridData( GridData.FILL_HORIZONTAL );
    this.cmbMetric.setLayoutData( gdMetric );
    
    if( this.component.compareTo( "Application" ) == 0 ) {
      List<ElasticityRequirementCategory> categories = ElasticityRequirementCategory.VALUES;
      for( ElasticityRequirementCategory tempCat : categories ) {
        this.cmbMetric.add( tempCat.toString() );
      }
    } 
    else if( this.component.compareTo( "Application Component" ) == 0 ) {
      List<ApplicationComponentElasticityRequirementCategory> categories = ApplicationComponentElasticityRequirementCategory.VALUES;
      for( ApplicationComponentElasticityRequirementCategory tempCat : categories )
      {
        this.cmbMetric.add( tempCat.toString() );
      }
    }

    return composite;
  }

  /**
   * Access to the List of Data Stage-In elements.
   * 
   * @return DataStage-In list set by the user.
   */
  public String getElasticityStrategy() {
    return ElasticityStrategyDialog.this.elasticityStrategy;
  }

  @SuppressWarnings("boxing")
  @Override
  protected void okPressed() {

    ElasticityStrategyDialog.this.elasticityStrategy = this.cmbStrategy.getText() + " " + this.cmbMetric.getText();
                                                                                             
    super.okPressed();
  }
}

