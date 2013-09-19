/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.dialog;

/**
 * @author stalo
 */


import org.eclipse.emf.common.util.EList;
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

import eu.celar.tosca.TPolicy;

public class ElasticityConditionDialog extends Dialog {

  protected String newType;
  private Label lblCondition;
  private CCombo cmbCondition;
  private boolean conditionSelected;
  EList<TPolicy> elasticityPolicies;
  private String condition;
  

  /**
   * @param parentShell
   * @param pe 
   * @param existingDataStage
   */
  public ElasticityConditionDialog( final Shell parentShell,  
                                    EList<TPolicy> elasticityPolicies
                                        )
  {
    super( parentShell );
    this.conditionSelected = false;
    this.elasticityPolicies = elasticityPolicies;
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

  
    // Condition label
    this.lblCondition = new Label( composite, SWT.NONE );
    this.lblCondition.setText( "When violated Constraint:" );
    GridData gd = new GridData( GridData.FILL_HORIZONTAL );
    this.lblCondition.setLayoutData( gd );

    // Combo - Condition
    this.cmbCondition = new CCombo( composite, SWT.BORDER );
    this.cmbCondition.setEnabled( true );
    gd = new GridData( GridData.FILL_HORIZONTAL );
    this.cmbCondition.setLayoutData( gd );
    
    if( this.elasticityPolicies != null ){
      
      for( TPolicy policy : this.elasticityPolicies )
      {
        if( policy.getPolicyType().toString().compareTo( "SYBLConstraint" ) == 0 ) //$NON-NLS-1$
          this.cmbCondition.add( policy.getName() );
      }
    }
    this.cmbCondition.setText( "" );
    
    this.cmbCondition.addModifyListener( new ModifyListener() {

      @Override
      public void modifyText( ModifyEvent e ) {
        if (ElasticityConditionDialog.this.cmbCondition.getText() != ""){
          ElasticityConditionDialog.this.conditionSelected = true;
        }
        
      }
      
    });
    return composite;
  }

  /**
   * Access to the List of Data Stage-In elements.
   * 
   * @return DataStage-In list set by the user.
   */
  public String getSelectedCondition() {
    return ElasticityConditionDialog.this.condition;
  }

  @SuppressWarnings("boxing")
  @Override
  protected void okPressed() {
           
    if ( this.conditionSelected ){
      ElasticityConditionDialog.this.condition = " WHEN Violated ( " + this.cmbCondition.getText().split( ":" )[0] + " )";
    }
    else ElasticityConditionDialog.this.condition = "";
                                                                                             
    super.okPressed();
  }
}

