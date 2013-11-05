/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.dialog;

/**
 * @author stalo
 */


import java.util.ArrayList;

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

import eu.celar.tosca.DocumentRoot;

import eu.celar.tosca.PoliciesType1;
import eu.celar.tosca.TNodeTemplate;

import eu.celar.tosca.TServiceTemplate;

import eu.celar.tosca.editor.ToscaModelLayer;
import eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension;

public class ElasticityConditionDialog extends Dialog {

  protected String newType;
  private Label lblCondition;
  private CCombo cmbCondition;
  private boolean conditionSelected;
  private Label lblCondition2;
  private CCombo cmbCondition2;
  private boolean conditionSelected2;
  private ToscaModelLayer model;
  private String condition;


  /**
   * @param parentShell
   * @param pe 
   * @param existingDataStage
   */
  public ElasticityConditionDialog( final Shell parentShell,  
		  ToscaModelLayer model
                                        )
  {
    super( parentShell );
    this.conditionSelected = false;
    this.conditionSelected2 = false;
    this.model = model;
  }

  @Override
  protected void configureShell( final Shell shell ) {
    super.configureShell( shell );
    shell.setText( "Add Elasticity Condition" );
    shell.setSize( 300, 200 );
 
  }

  @Override
  protected Control createDialogArea( final Composite parent ) {
    Composite composite = ( Composite )super.createDialogArea( parent );
    composite.setLayout( new GridLayout( 1, false ) );
    composite.setLayoutData( new GridData( GridData.FILL_BOTH ) );

  
    // Condition label
    this.lblCondition = new Label( composite, SWT.NONE );
    this.lblCondition.setText( "When fulfilled Constraint:" );
    GridData gd = new GridData( GridData.FILL_HORIZONTAL );
    this.lblCondition.setLayoutData( gd );

    // Combo - Condition
    this.cmbCondition = new CCombo( composite, SWT.BORDER );
    this.cmbCondition.setEnabled( true );
    gd = new GridData( GridData.FILL_HORIZONTAL );
    this.cmbCondition.setLayoutData( gd );

    
    ArrayList<String> elasticityConstraints = getAllConstraints();
    
    if ( elasticityConstraints.size() > 0 ){
    	for ( String constraint : elasticityConstraints ){
    		this.cmbCondition.add(constraint);
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

    // Condition label
    this.lblCondition2 = new Label( composite, SWT.NONE );
    this.lblCondition2.setText( "When violated Constraint:" );
    gd = new GridData( GridData.FILL_HORIZONTAL );
    this.lblCondition2.setLayoutData( gd );

    // Combo - Condition
    this.cmbCondition2 = new CCombo( composite, SWT.BORDER );
    this.cmbCondition2.setEnabled( true );
    gd = new GridData( GridData.FILL_HORIZONTAL );
    this.cmbCondition2.setLayoutData( gd );
    
    if ( elasticityConstraints.size() > 0 ){
    	for ( String constraint : elasticityConstraints ){
    		this.cmbCondition2.add(constraint);
    	}
    }  
    
    this.cmbCondition2.setText( "" );
    
    this.cmbCondition2.addModifyListener( new ModifyListener() {

      @Override
      public void modifyText( ModifyEvent e ) {
        if (ElasticityConditionDialog.this.cmbCondition2.getText() != ""){
          ElasticityConditionDialog.this.conditionSelected2 = true;
        }
        
      }
      
    });
    
    return composite;
  }

  
  // Returns all global, composite and component level elasticity constraints;
  private ArrayList<String> getAllConstraints(){
	  
	  ArrayList<String> constraints = new ArrayList<String>();
	  
	  DocumentRoot toscaRoot = this.model.getDocumentRoot();
	  EList<TServiceTemplate> toscaServiceTemplates = toscaRoot.getDefinitions().getServiceTemplate();
	  EList<TNodeTemplate> tempNodeTemplates;
	  for ( TServiceTemplate tempServiceTemplate : toscaServiceTemplates ){
		  
		  TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension ) tempServiceTemplate.getBoundaryDefinitions();
		  
		  if ( boundaryDef != null ){
	
			  PoliciesType1 globalPolicies = boundaryDef.getPolicies();
			  
			  if ( globalPolicies != null ){
			
				  for ( int k=0; k<globalPolicies.getPolicy().size(); k++){
						  
					  if ( globalPolicies.getPolicy().get(k).getPolicyType().toString().compareTo( "SYBLConstraint" ) == 0 ){
						  constraints.add(globalPolicies.getPolicy().get(k).getName());
					  }
				  }

			  }
		  }
		  
		  if ( tempServiceTemplate.getTopologyTemplate() != null && tempServiceTemplate.getTopologyTemplate().getNodeTemplate() != null ){
			  
			  tempNodeTemplates = tempServiceTemplate.getTopologyTemplate().getNodeTemplate();
	
			  for ( final TNodeTemplate tempNodeTemplate : tempNodeTemplates ){
				  
				  if ( tempNodeTemplate.getPolicies() != null && tempNodeTemplate.getPolicies().getPolicy() != null ){
					  for ( int j=0; j<tempNodeTemplate.getPolicies().getPolicy().size(); j++){
						  
						  if (tempNodeTemplate.getPolicies().getPolicy().get(j).getPolicyType().toString().compareTo( "SYBLConstraint" ) == 0 ){
							  constraints.add(tempNodeTemplate.getPolicies().getPolicy().get(j).getName());
						  }
					  }
				  }
			  }

			  
		  }

	  }
	  
	  return constraints;

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
      ElasticityConditionDialog.this.condition = "CASE fulfilled(" + this.cmbCondition.getText().split( ":" )[0] + "):";
    }
    else if ( this.conditionSelected2 ){
    	ElasticityConditionDialog.this.condition = "CASE violated(" + this.cmbCondition2.getText().split( ":" )[0] + "):";
    }
    else ElasticityConditionDialog.this.condition = "";
                                                                                             
    super.okPressed();
  }
}

