/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.dialog;

/**
 * @author stalo
 */


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import eu.celar.infosystem.mockup.info.MockUpInfoSystem;
import eu.celar.infosystem.model.base.InfoSystemFactory;
import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.tosca.DocumentRoot;
import eu.celar.tosca.PoliciesType1;
import eu.celar.tosca.TBoundaryDefinitions;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.editor.ToscaModelLayer;
import eu.celar.tosca.elasticity.ElasticityRequirementCategory;
import eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension;

public class ElasticityConditionDialog extends Dialog {


  private Label lblCondition;
  private CCombo cmbCondition;
  private boolean conditionSelected;
  private Label lblCondition2;
  private CCombo cmbCondition2;
  private boolean conditionSelected2;
  private ToscaModelLayer model;
  private String condition;

  
  protected Text typeText;
  protected Text valueText;
  protected boolean editMode = false;
  protected boolean addMode = false;
  protected String newType;
  protected String elasticityRequirement;
  private CCombo cmbGlobalElasticityReq;
  private CCombo cmbOperator;
  private String component;
  private Label unitLabel;

  private String unit;

  private String strategyName;
  private Label strategyLabel;
  
  /**
   * @param parentShell
   * @param pe 
   * @param existingDataStage
   */
  public ElasticityConditionDialog( final Shell parentShell,  String component,
		  ToscaModelLayer model, String strategyName
                                        )
  {
    super( parentShell );
    this.conditionSelected = false;
    this.conditionSelected2 = false;
    this.model = model;
    this.component = component;
    this.strategyName = strategyName;
  }

  @Override
  protected void configureShell( final Shell shell ) {
    super.configureShell( shell );
    shell.setText( "Apply Strategy Under Condition" );
    shell.setSize( 330, 400 );
 
  }

  @Override
  protected Control createDialogArea( final Composite parent ) {
    Composite composite = ( Composite )super.createDialogArea( parent );
    composite.setLayout( new GridLayout( 1, false ) );
    composite.setLayoutData( new GridData( GridData.FILL_BOTH ) );

    this.strategyLabel = new Label( composite, SWT.NONE );
    this.strategyLabel.setText( this.strategyName );
    
    GridData gd = new GridData( GridData.FILL_BOTH );
    gd.verticalIndent = 7;
    gd.heightHint = 10;
    this.strategyLabel.setLayoutData( gd );
    

    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    Group newConstraintGroup = new Group( composite, SWT.NONE );
    newConstraintGroup.setLayout( new GridLayout( 1, false ) );
    newConstraintGroup.setText( "&Specify New Condition" );
    GridData gData = new GridData( SWT.FILL, SWT.FILL, true, true );
    newConstraintGroup.setLayoutData( gData );
    
    
    
    Composite newConstraintComposite = new Composite( newConstraintGroup, SWT.NONE );
    newConstraintComposite.setLayout( new GridLayout( 1, false ) );
    //GridLayout gLayout = new GridLayout( 2, false );
    newConstraintComposite.setLayout( new GridLayout( 1, false ) );
    gData = new GridData( GridData.FILL_BOTH );
    //gData.grabExcessHorizontalSpace = true;
    //gData.grabExcessVerticalSpace = true;
    newConstraintComposite.setLayoutData( gData );
    

   
    
    Composite typeComposite = new Composite( newConstraintComposite, SWT.NONE );
    GridLayout gLayout = new GridLayout( 2, false );
    typeComposite.setLayout( gLayout );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    //gData.grabExcessHorizontalSpace = true;
    //gData.grabExcessVerticalSpace = true;
    typeComposite.setLayoutData( gData );
    
    Label typeLabel = new Label( typeComposite, SWT.LEAD );
    typeLabel.setText( "Type" ); //$NON-NLS-1$
    gd = new GridData( 50, 20 );
    typeLabel.setLayoutData( gd );
    // Combo - GlobalElasticityReq
    this.cmbGlobalElasticityReq = new CCombo( typeComposite, SWT.BORDER );
    this.cmbGlobalElasticityReq.setEnabled( true );
    gd = new GridData( 112, 20 );
    this.cmbGlobalElasticityReq.setLayoutData( gd );

    ArrayList<MonitoringProbe> mps = getMetrics();
    for (MonitoringProbe mp : mps){
      this.cmbGlobalElasticityReq.add( mp.getName() );
    }

    Composite valueComposite = new Composite( newConstraintComposite, SWT.NONE );
    gLayout = new GridLayout( 4, false );
    valueComposite.setLayout( gLayout );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    //gData.grabExcessHorizontalSpace = true;
    //gData.grabExcessVerticalSpace = true;
    valueComposite.setLayoutData( gData );
    
    Label valueLabel = new Label( valueComposite, SWT.LEAD );
    valueLabel.setText( "Value" ); //$NON-NLS-1$
    gd = new GridData( 50, 20 );
    valueLabel.setLayoutData( gd );
    
    // Combo - Operator
    this.cmbOperator = new CCombo( valueComposite, SWT.BORDER );
    this.cmbOperator.setEnabled( true );
    gd = new GridData( 40, 20 );
    this.cmbOperator.setLayoutData( gd );
    this.cmbOperator.add( "=" ); //$NON-NLS-1$
    this.cmbOperator.add( "<" ); //$NON-NLS-1$
    this.cmbOperator.add( ">" );  //$NON-NLS-1$
    this.cmbOperator.setText( this.cmbOperator.getItem( 0 ) );  
    
    this.valueText = new Text( valueComposite, SWT.BORDER );
    gd = new GridData( 112, 20 );
    this.valueText.setLayoutData( gd );
    // metric unit label
    this.unitLabel = new Label( valueComposite, SWT.NONE );
    gd = new GridData( GridData.FILL_HORIZONTAL, 20 );
    this.unitLabel.setLayoutData( gd );

    this.cmbGlobalElasticityReq.setEditable( false );
    this.cmbGlobalElasticityReq.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        
        ElasticityConditionDialog.this.cmbCondition.setEnabled( false );
        ElasticityConditionDialog.this.cmbCondition2.setEnabled( false );
        
        ElasticityConditionDialog.this.newType = ElasticityConditionDialog.this.cmbGlobalElasticityReq.getText();
        // set metric unit
        ElasticityConditionDialog.this.unit = ""; //$NON-NLS-1$
        if( ElasticityConditionDialog.this.newType.compareTo( "ResponseTime" ) == 0 ) //$NON-NLS-1$
        {
          ElasticityConditionDialog.this.unit = "s"; //$NON-NLS-1$
        } else if( ElasticityConditionDialog.this.newType.compareTo( "Bandwidth" ) == 0 ) //$NON-NLS-1$
        {
          ElasticityConditionDialog.this.unit = "MB/s"; //$NON-NLS-1$
        } else if( ElasticityConditionDialog.this.newType.compareTo( "Cost" ) == 0 ) //$NON-NLS-1$
        {
          ElasticityConditionDialog.this.unit = "$"; //$NON-NLS-1$
        } else if( ElasticityConditionDialog.this.newType.compareTo( "Latency" ) == 0 ) //$NON-NLS-1$
        {
          ElasticityConditionDialog.this.unit = "ms"; //$NON-NLS-1$
        } else if( ElasticityConditionDialog.this.newType.compareTo( "Throughput" ) == 0 ) //$NON-NLS-1$
        {
          ElasticityConditionDialog.this.unit = "s"; //$NON-NLS-1$
        } else if( ElasticityConditionDialog.this.newType.compareTo( "CPU_Usage" ) == 0 ) //$NON-NLS-1$
        {
            ElasticityConditionDialog.this.unit = "%"; //$NON-NLS-1$
          }else {
          ElasticityConditionDialog.this.unit = ""; //$NON-NLS-1$
        }
        String unitLabelText = "  ( " + ElasticityConditionDialog.this.unit + " )"; //$NON-NLS-1$ //$NON-NLS-2$
        ElasticityConditionDialog.this.unitLabel.setText( unitLabelText );
      }
    } );
 
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    Group constraintGroup = new Group( composite, SWT.NONE );
    constraintGroup.setLayout( new GridLayout( 1, false ) );
    constraintGroup.setText( "&Select Constraint" );
    gData = new GridData( SWT.FILL, SWT.FILL, true, true );
    constraintGroup.setLayoutData( gData );
    
    Composite constraintComposite = new Composite( constraintGroup, SWT.NONE );
    constraintComposite.setLayout( new GridLayout( 1, false ) );
    gData = new GridData( GridData.GRAB_HORIZONTAL );
    //gData.grabExcessHorizontalSpace = true;
    //gData.grabExcessVerticalSpace = true;
    constraintComposite.setLayoutData( gData );
    
    
    // Condition label
    this.lblCondition = new Label( constraintComposite, SWT.NONE );
    this.lblCondition.setText( "When fulfilled Constraint:" );
    gd = new GridData( GridData.FILL_HORIZONTAL );
    gd.widthHint = 280;
    this.lblCondition.setLayoutData( gd );

    // Combo - Condition
    this.cmbCondition = new CCombo( constraintComposite, SWT.BORDER );
    this.cmbCondition.setEnabled( true );
    gd = new GridData( GridData.FILL_HORIZONTAL );
    gd.widthHint = 280;
    this.cmbCondition.setLayoutData( gd );
    this.cmbCondition.setEnabled( false );

    
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
    this.lblCondition2 = new Label( constraintComposite, SWT.NONE );
    this.lblCondition2.setText( "When violated Constraint:" );
    gd = new GridData( GridData.FILL_HORIZONTAL );
    gd.widthHint = 280;
    this.lblCondition2.setLayoutData( gd );

    // Combo - Condition
    this.cmbCondition2 = new CCombo( constraintComposite, SWT.BORDER );
    this.cmbCondition2.setEnabled( true );
    gd.widthHint = 280;
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

  public ArrayList<MonitoringProbe> getMetrics(){
    
    ArrayList<MonitoringProbe> mps = MockUpInfoSystem.getInstance()
        .getMonitoringProbes();
        
        ArrayList<MonitoringProbe> mpsCopy = ( ArrayList<MonitoringProbe> )mps.clone();
        
    IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
    IProject monitoringProbesProject = workspaceRoot.getProject( "MonitoringProbe" );

    if( monitoringProbesProject.exists() ) {
      IFolder srcFolder = monitoringProbesProject.getFolder( "src" );
      IResource[] artifactsResource = null;
      try {
        artifactsResource = srcFolder.members();
      } catch( CoreException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      for( IResource tempResource : artifactsResource ) {
        if( tempResource instanceof IFile ) {
          MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
          mp.setUID( tempResource.getName().replaceFirst( ".java", "" ));
          mp.setName( tempResource.getName().replaceFirst( ".java", "" ));
          mp.setDescription( "h" );
          mp.setURL( "h" );
          // add new probe to monitoring list
          mpsCopy.add( mp );
        }
      }
    }
    
    return mpsCopy;
  }
  
  // Returns all global, composite and component level elasticity constraints;
  private ArrayList<String> getAllConstraints(){
	  
	  ArrayList<String> constraints = new ArrayList<String>();
	  
	  DocumentRoot toscaRoot = this.model.getDocumentRoot();
	  EList<TServiceTemplate> toscaServiceTemplates = toscaRoot.getDefinitions().getServiceTemplate();
	  EList<TNodeTemplate> tempNodeTemplates;
	  for ( TServiceTemplate tempServiceTemplate : toscaServiceTemplates ){
		  
		  //TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension ) tempServiceTemplate.getBoundaryDefinitions();
		  
	    TBoundaryDefinitions boundaryDef = ( TBoundaryDefinitions ) tempServiceTemplate.getBoundaryDefinitions();
	    
		  if ( boundaryDef != null ){
	
			  PoliciesType1 globalPolicies = boundaryDef.getPolicies();
			  
			  if ( globalPolicies != null ){
			
				  for ( int k=0; k<globalPolicies.getPolicy().size(); k++){
						  
					  if ( globalPolicies.getPolicy().get(k).getPolicyType().toString().contains( "Constraint" ) ){
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
						  
						  if (tempNodeTemplate.getPolicies().getPolicy().get(j).getPolicyType().toString().contains( "Constraint" ) ){
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

