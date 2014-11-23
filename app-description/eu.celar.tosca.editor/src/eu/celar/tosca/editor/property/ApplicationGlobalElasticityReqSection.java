/*******************************************************************************
 * Copyright (c) 2013 CELAR Consortium.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 *   Stalo Sofokleous - initial API and implementation
 *   Nicholas Loulloudes - API and implementation extensions
 *   
 *******************************************************************************/
package eu.celar.tosca.editor.property;

import java.util.ArrayList;
import java.util.List;

import org.example.sybl.ConditionType;
import org.example.sybl.SyblElasticityRequirementsDescription;
import org.example.sybl.SyblPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import eu.celar.tosca.DefinitionsType;
import eu.celar.tosca.PoliciesType;
import eu.celar.tosca.PoliciesType1;
import eu.celar.tosca.PropertiesType;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TPolicy;
import eu.celar.tosca.TPolicyTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;
import eu.celar.tosca.editor.dialog.ElasticityConditionDialog;
import eu.celar.tosca.editor.dialog.ElasticityConstraintDialog;
import eu.celar.tosca.editor.dialog.ElasticityStrategyDialog;
import eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;

/**
 * Application Properties - Elasticity Tab
 */
public class ApplicationGlobalElasticityReqSection
  extends GFPropertySection implements ITabbedPropertyConstants
{

  Composite client;
  Section section;
  private Table table;
  private Button addButton;
  private Button removeButton;
  TableViewer tableViewer;
  List<TPolicy> appComponentElasticityRequirements = new ArrayList<TPolicy>();
  Section sectionRA;
  private Table tableResizingActions;
  private Button removeButtonRA;
  private Button addButtonRA;
  private Button conditionButtonRA;
  TableViewer tableResizingActionsViewer;
  List<TPolicy> appComponentResizingActions = new ArrayList<TPolicy>();
  protected Tosca_Elasticity_ExtensionsFactory elasticityFactory = Tosca_Elasticity_ExtensionsFactory.eINSTANCE;

  @Override
  public void createControls( final Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    // Application Component Elasticity Requirements Section
    this.section = toolkit.createSection( parent, Section.TITLE_BAR );
    this.section.setText( "Application Component Elasticity Constraints" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( this.section, SWT.WRAP );
    Composite client1 = toolkit.createComposite( client, SWT.WRAP );
    Composite client2 = toolkit.createComposite( client, SWT.WRAP );
    GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    layout.marginTop = 15;
    layout.verticalSpacing = 15;
    layout.marginWidth = 2;
    layout.marginHeight = 2;
    client.setLayout( layout );
    layout = new GridLayout();
    layout.numColumns = 1;
    client1.setLayout( layout );
    layout = new GridLayout();
    layout.numColumns = 1;
    client2.setLayout( layout );
    GridData gd;
    this.table = new Table( client1, SWT.BORDER
                                     | SWT.VIRTUAL
                                     | SWT.MULTI
                                     | SWT.FULL_SELECTION );
    this.table.setHeaderVisible( true );
    this.table.setLinesVisible( false );
    this.table.getHorizontalBar().setEnabled( false );
    gd = new GridData( 300, this.table.getItemHeight() * 4 );
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    this.table.setLayoutData( gd );
    TableLayout tableLayout = new TableLayout();
    this.table.setLayout( tableLayout );
    TableColumn nameColumn = new TableColumn( this.table, SWT.CENTER );
    ColumnLayoutData data = new ColumnWeightData( 100 );
    tableLayout.addColumnData( data );
    data = new ColumnWeightData( 100 );
    tableLayout.addColumnData( data );
    data = new ColumnWeightData( 150 );
    tableLayout.addColumnData( data );
    nameColumn.setText( "Constraint" ); //$NON-NLS-1$
    this.tableViewer = new TableViewer( this.table );
    ElasticityConstraintsProvider ERProvider = new ElasticityConstraintsProvider();
    IStructuredContentProvider contentProvider = ERProvider.ERContentProvider;
    this.tableViewer.setContentProvider( contentProvider );
    this.tableViewer.setLabelProvider( ERProvider.ERContentLabelProvider );
    this.tableViewer.setInput( this.appComponentElasticityRequirements );
    this.addButton = new Button( client2, SWT.PUSH );
    this.addButton.setText( "Add" ); //$NON-NLS-1$
    gd = new GridData();
    gd.widthHint = 60;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.addButton.setLayoutData( gd );
    // Listener for Add button
    this.addButton.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        editDataStagingEntry( null );
      }

      @Override
      public void widgetDefaultSelected( final SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    this.removeButton = new Button( client2, SWT.PUSH );
    this.removeButton.setText( "Remove" ); //$NON-NLS-1$
    gd = new GridData();
    gd.widthHint = 60;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.removeButton.setLayoutData( gd );
    // Listener for Remove button
    this.removeButton.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( final SelectionEvent e ) {
        removeApplicationComponentElasticityRequirement( getSelectedObject() );
      }

      @Override
      public void widgetDefaultSelected( final SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    // Add section components to the toolkit
    toolkit.adapt( this.table, true, true );
    toolkit.adapt( this.addButton, true, true );
    toolkit.adapt( this.removeButton, true, true );
    this.section.setClient( client );
    // Application Component Elasticity Actions Section
    this.sectionRA = toolkit.createSection( parent, Section.TITLE_BAR );
    this.sectionRA.setText( "Elasticity Strategies" ); //$NON-NLS-1$
    Composite clientRA = toolkit.createComposite( this.sectionRA, SWT.WRAP );
    Composite clientRA1 = toolkit.createComposite( clientRA, SWT.WRAP );
    Composite clientRA2 = toolkit.createComposite( clientRA, SWT.WRAP );
    GridLayout layoutRA;
    layoutRA = new GridLayout();
    layoutRA.numColumns = 2;
    layoutRA.marginTop = 15;
    layoutRA.verticalSpacing = 15;
    layoutRA.marginWidth = 2;
    layoutRA.marginHeight = 2;
    clientRA.setLayout( layoutRA );
    layoutRA = new GridLayout();
    layoutRA.numColumns = 1;
    clientRA1.setLayout( layoutRA );
    layoutRA = new GridLayout();
    layoutRA.numColumns = 1;
    clientRA2.setLayout( layoutRA );
    this.tableResizingActions = new Table( clientRA1, SWT.BORDER
                                                      | SWT.VIRTUAL
                                                      | SWT.MULTI
                                                      | SWT.FULL_SELECTION );
    this.tableResizingActions.setHeaderVisible( true );
    this.tableResizingActions.setLinesVisible( false );
    this.tableResizingActions.getHorizontalBar().setEnabled( false );
    GridData gdRA;
    gdRA = new GridData( 300, this.tableResizingActions.getItemHeight() * 4 );
    gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdRA.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    this.tableResizingActions.setLayoutData( gdRA );
    TableLayout tableLayoutRA = new TableLayout();
    this.tableResizingActions.setLayout( tableLayoutRA );
    TableColumn nameColumnRA = new TableColumn( this.tableResizingActions,
                                                SWT.CENTER );
    nameColumnRA.setText( "Strategy" ); //$NON-NLS-1$
    nameColumnRA.setWidth( 100 );
    ColumnWeightData dataRA = new ColumnWeightData( 100 );
    tableLayoutRA.addColumnData( dataRA );
    // Set the Elasticity Actions table viewer
    ResizingActionsProvider RAProvider = new ResizingActionsProvider();
    this.tableResizingActionsViewer = new TableViewer( this.tableResizingActions );
    IStructuredContentProvider contentProviderRA = RAProvider.RAContentProvider;
    this.tableResizingActionsViewer.setContentProvider( contentProviderRA );
    this.tableResizingActionsViewer.setLabelProvider( RAProvider.RAContentLabelProvider );
    this.tableResizingActionsViewer.setInput( this.appComponentResizingActions );
    // Add Elasticity Strategy button
    this.addButtonRA = new Button( clientRA2, SWT.PUSH );
    this.addButtonRA.setText( "Add" ); //$NON-NLS-1$
    // Listener for Adding Elasticity Strategy button
    this.addButtonRA.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( final SelectionEvent e ) {
        editDataStagingEntryRA( getSelectedObject() );
      }

      @Override
      public void widgetDefaultSelected( final SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    gdRA = new GridData();
    gdRA.widthHint = 60;
    gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.addButtonRA.setLayoutData( gdRA );
    this.removeButtonRA = new Button( clientRA2, SWT.PUSH );
    this.removeButtonRA.setText( "Remove" ); //$NON-NLS-1$
    // Listener for Remove Elasticity Strategy button
    this.removeButtonRA.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( final SelectionEvent e ) {
        removeApplicationComponentResizingAction( getSelectedElasticityStrategy() );
      }

      @Override
      public void widgetDefaultSelected( final SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    gdRA = new GridData();
    gdRA.widthHint = 60;
    gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.removeButtonRA.setLayoutData( gdRA );
    this.conditionButtonRA = new Button( clientRA2, SWT.PUSH );
    this.conditionButtonRA.setText( "Condition" ); //$NON-NLS-1$
    // Listener for Remove Elasticity Strategy button
    this.conditionButtonRA.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( final SelectionEvent e ) {
        addStrategyCondition( getSelectedElasticityStrategy() );
      }

      @Override
      public void widgetDefaultSelected( final SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    gdRA = new GridData();
    gdRA.widthHint = 60;
    gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.conditionButtonRA.setLayoutData( gdRA );
    // Add section components to the toolkit
    toolkit.adapt( this.tableResizingActions, true, true );
    toolkit.adapt( this.removeButtonRA, true, true );
    toolkit.adapt( this.addButtonRA, true, true );
    // toolkit.adapt( this.uploadButtonRA, true, true );
    toolkit.adapt( this.conditionButtonRA, true, true );
    this.sectionRA.setClient( clientRA );
  }

  // Add Application Component Elasticity Requirement
  void editDataStagingEntry( final TPolicy selectedObject ) {
    ElasticityConstraintDialog dialog;
    if( selectedObject == null ) {
      // Add button is pressed
      dialog = new ElasticityConstraintDialog( this.section.getShell(),
                                               "Application" ); //$NON-NLS-1$
      if( dialog.open() == Window.OK ) {
        String newElasticityConstraint = dialog.getElasticityConstraint();
        
        if (newElasticityConstraint.contains( "<" )){
          String[] cond = newElasticityConstraint.split( "<" );
          newElasticityConstraint = cond[0] + "&lt;" + cond[1];
        }
        else if (newElasticityConstraint.contains( ">" )){
          String[] cond = newElasticityConstraint.split( ">" );
          newElasticityConstraint = cond[0] + "&gt;" + cond[1];
        }      
        
        
        SyblElasticityRequirementsDescription newSYBLConstraint = dialog.getSYBLConstraint();
        if( newElasticityConstraint != null ) {
          // Add Application Component Elasticity Requirement to TOSCA
          PictogramElement pe = getSelectedPictogramElement();
          Object bo = null;
          if( pe != null ) {
            bo = Graphiti.getLinkService()
              .getBusinessObjectForLinkedPictogramElement( pe );
          }
          final TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )( ( ( TServiceTemplate )bo ).getBoundaryDefinitions() );        
          
          
          if ( boundaryDef.getPolicies() == null ){
            
            final PoliciesType1 boundaryPolicies = ToscaFactory.eINSTANCE.createPoliciesType1();
            
            TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
            editingDomain.getCommandStack()
              .execute( new RecordingCommand( editingDomain ) {

                @Override
                protected void doExecute() {
                  boundaryDef.setPolicies( boundaryPolicies );
                }
              } );
            
           
          }
          
          PoliciesType1 nodePolicyList = boundaryDef.getPolicies();

          final EList<TPolicy> policy = nodePolicyList.getPolicy();
          final TPolicy newPolicy = createNewPolicy( "Constraint",
                                                     newElasticityConstraint, newSYBLConstraint );
          TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
          editingDomain.getCommandStack()
            .execute( new RecordingCommand( editingDomain ) {

              @Override
              protected void doExecute() {
                policy.add( newPolicy );
              }
            } );
          // Add Application Component Elasticity Requirement to temp list
          this.appComponentElasticityRequirements.add( newPolicy );
          this.tableViewer.refresh();
        } else {
        }
      }
    }
  }

  void editDataStagingEntryRA( final TPolicy selectedObject ) {
    ElasticityStrategyDialog dialog;
    if( selectedObject == null ) {
      // Add button is pressed
      dialog = new ElasticityStrategyDialog( this.section.getShell(),
                                             "Application" ); //$NON-NLS-1$
      if( dialog.open() == Window.OK ) {
        String newElasticityStrategy = dialog.getElasticityStrategy();
        SyblElasticityRequirementsDescription newSYBLStrategy = dialog.getSYBLStrategy();
        if( newElasticityStrategy != null ) {
          // Add Application Component Elasticity Strategy to TOSCA
          PictogramElement pe = getSelectedPictogramElement();
          Object bo = null;
          if( pe != null ) {
            bo = Graphiti.getLinkService()
              .getBusinessObjectForLinkedPictogramElement( pe );
          }
          final TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )( ( ( TServiceTemplate )bo ).getBoundaryDefinitions() );        
          
          if ( boundaryDef.getPolicies() == null ){
            
            final PoliciesType1 boundaryPolicies = ToscaFactory.eINSTANCE.createPoliciesType1();
            
            TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
            editingDomain.getCommandStack()
              .execute( new RecordingCommand( editingDomain ) {

                @Override
                protected void doExecute() {
                  boundaryDef.setPolicies( boundaryPolicies );
                }
              } );
          }
          
          PoliciesType1 nodePolicyList = boundaryDef.getPolicies();
          final EList<TPolicy> policy = nodePolicyList.getPolicy();
          final TPolicy newPolicy = createNewPolicy( "Strategy",
                                                     newElasticityStrategy, newSYBLStrategy );
          TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
          editingDomain.getCommandStack()
            .execute( new RecordingCommand( editingDomain ) {

              @Override
              protected void doExecute() {
                policy.add( newPolicy );
              }
            } );
          this.appComponentResizingActions.add( newPolicy );
          this.tableResizingActionsViewer.refresh();
        } else {
          // Edit
        }
      }
    }
  }


  // type is either "Constraint" or "Strategy"
  TPolicy createNewPolicy(String type, String policyName, SyblElasticityRequirementsDescription syblPolicy){

    // Create Policy Template 
    
    final TPolicyTemplate newPolicyTemplate = ToscaFactory.eINSTANCE.createTPolicyTemplate();
    
    QName policyTypeName = new QName( "http://www.example.org/SYBL", type, null );
    
    newPolicyTemplate.setType( policyTypeName );
    
    String id = "A" + ( ( Integer )newPolicyTemplate.hashCode() ).toString();
    
    newPolicyTemplate.setId( id );

    
    // Set the Properties of the Policy Template    
    
    PropertiesType properties = ToscaFactory.eINSTANCE.createPropertiesType();    
  
    // Add the SYBL Policy to the FeatureMap of the Policy's Properties element
    Entry e = FeatureMapUtil.createEntry(     SyblPackage.eINSTANCE.getDocumentRoot_SYBLElasticityRequirementsDescription(),  syblPolicy );
    properties.getAny().add( e );      
    
    newPolicyTemplate.setProperties( properties );
        
    // Add the new Policy Template to the TOSCA Definitions element
    
    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    
    DefinitionsType definitions = model.getDocumentRoot().getDefinitions();
       
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( definitions );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          model.getDocumentRoot().getDefinitions().getPolicyTemplate().add( newPolicyTemplate );
          
        }
      } );
    
    // Assign the created Policy Template to the new Policy
    
    TPolicy newPolicy = ToscaFactory.eINSTANCE.createTPolicy();
    
    QName qnamePolicyTemplate = new QName( newPolicyTemplate.getId() );
    
    newPolicy.setPolicyType( policyTypeName );  
    
    newPolicy.setPolicyRef( qnamePolicyTemplate );
    
    newPolicy.setName( type.toUpperCase() + " " + policyName );
    
    return newPolicy;
  }
  
  void addStrategyCondition( final TPolicy selectedObject ) {
    if( selectedObject == null )
      return;
    
    TServiceTemplate serviceTemplate = null;
    
    if (getSelectedPictogramElement() != null) 
      serviceTemplate = (TServiceTemplate) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
    
    ElasticityConditionDialog dialog;
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    dialog = new ElasticityConditionDialog( this.section.getShell(),
                                            "Application Component",
                                            model,
                                            selectedObject.getName() ); //$NON-NLS-1$
    String newElasticityCondition = null;
    ConditionType policyCondition = null;
    if( dialog.open() == Window.OK ) {
      newElasticityCondition = dialog.getSelectedCondition();
      policyCondition = dialog.getSYBLCondition();
    }
    if( newElasticityCondition == null )
      return;

    String newCond = newElasticityCondition;
    
    if (newCond.contains( "<" )){
      String[] cond = newCond.split( "<" );
      newCond = cond[0] + "&lt;" + cond[1];
    }
    else if (newCond.contains( ">" )){
      String[] cond = newCond.split( ">" );
      newCond = cond[0] + "&gt;" + cond[1];
    }
    
    final String condition = newCond;
    
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( serviceTemplate );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          String[] strategy = selectedObject.getName().split( "STRATEGY" );
          selectedObject.setName( strategy[ 0 ]
                                  + "STRATEGY "
                                  + condition + " :" 
                                  + strategy[ 1 ] );
        }
      } );
    this.tableResizingActionsViewer.refresh();
    
    //addPolicyCondition( selectedObject, policyCondition);
  }
  
//  void addPolicyCondition(final TPolicy selectedPolicy, final ConditionType policyCondition){
//    
//    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
//    EList<TPolicyTemplate> policyTemplates = model.getDocumentRoot().getDefinitions().getPolicyTemplate();
//    TPolicyTemplate policyTemplate = null;
//    for ( TPolicyTemplate tempPolicyTemplate : policyTemplates ){
//      if (tempPolicyTemplate.getId().toString().equals(selectedPolicy.getPolicyRef().toString())){
//        policyTemplate = tempPolicyTemplate;
//        break;
//      }      
//    }
//    
//    final SyblElasticityRequirementsDescription syblPolicy = (SyblElasticityRequirementsDescription) policyTemplate.getProperties().getAny().get(0).getValue();
//    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( policyTemplate );
//    editingDomain.getCommandStack()
//      .execute( new RecordingCommand( editingDomain ) {
//
//        @Override
//        protected void doExecute() {
//          syblPolicy.getSYBLSpecification().get( 0 ).getStrategy().get( 0 ).setCondition( policyCondition );
//        }
//      } );
//  }

  // Remove the selected Application Component Elasticity Requirement from TOSCA
  void removeApplicationComponentElasticityRequirement( final TPolicy selectedObject )
  {
    PictogramElement pe = getSelectedPictogramElement();
    Object bo = null;
    if( pe != null ) {
      bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
    }
    
    final TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )( ( ( TServiceTemplate )bo ).getBoundaryDefinitions() );        
    
    PoliciesType1 nodePolicyList = boundaryDef.getPolicies();
    
    final EList<TPolicy> policy = nodePolicyList.getPolicy();
    
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          for( TPolicy tempPolicy : policy ) {
            if( tempPolicy.getPolicyType().toString().contains( "Constraint" ) ) //$NON-NLS-1$
              if( tempPolicy.getName().compareTo( selectedObject.getName() ) == 0 )
              {
                policy.remove( tempPolicy );
                if( policy.size() == 0 )
                  boundaryDef.setPolicies( null );
                // remove corresponding Policy Template
                String removedPolicyId = tempPolicy.getPolicyRef().toString();
                ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
                DefinitionsType toscaDefinitions = model.getDocumentRoot()
                  .getDefinitions();
                final EList<TPolicyTemplate> policyTemplate = toscaDefinitions.getPolicyTemplate();
                for( TPolicyTemplate tempPolicyTemplate : policyTemplate ) {
                  if( tempPolicyTemplate.getId().equals( removedPolicyId ) ) {
                    policyTemplate.remove( tempPolicyTemplate );
                  }
                }
                break;
              }
          }
        }
      } );
    this.appComponentElasticityRequirements.remove( selectedObject );
    this.tableViewer.refresh();
  }

  // Return the selected Elasticity Requirement
  TPolicy getSelectedObject() {
    TPolicy result = null;
    IStructuredSelection selection = ( IStructuredSelection )this.tableViewer.getSelection();
    Object obj = selection.getFirstElement();
    result = ( TPolicy )obj;
    return result;
  }

  // Return the selected Elasticity Action
  TPolicy getSelectedElasticityStrategy() {
    TPolicy result = null;
    IStructuredSelection selection = ( IStructuredSelection )this.tableResizingActionsViewer.getSelection();
    Object obj = selection.getFirstElement();
    result = ( TPolicy )obj;
    return result;
  }

  /**
   * Get Application Elasticity Actions
   */
  public void getResizingActions() {
    // initiate global elasticity requirement list with requirements from
    // description wizard
    PictogramElement pe = getSelectedPictogramElement();
    Object bo = null;
    if( pe != null ) {
      bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
    }
    TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )( ( ( TServiceTemplate )bo ).getBoundaryDefinitions() );        
    
    PoliciesType1 nodePolicyList = boundaryDef.getPolicies();
    
    if( nodePolicyList == null )
      return;
    
    for( TPolicy tempPolicy : nodePolicyList.getPolicy() )
    {
      if( tempPolicy.getPolicyType().toString().contains( "Strategy" ) ) //$NON-NLS-1$
        this.appComponentResizingActions.add( tempPolicy );
    }
    
  }

  
  /**
   * Get Application Elasticity Constraints
   */
  public void getElasticityConstraints() {
    // initiate global elasticity requirement list with requirements from
    // description wizard
    PictogramElement pe = getSelectedPictogramElement();
    Object bo = null;
    if( pe != null ) {
      bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
    }
    TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )( ( ( TServiceTemplate )bo ).getBoundaryDefinitions() );        
    
    PoliciesType1 nodePolicyList = boundaryDef.getPolicies();
    
    if( nodePolicyList == null )
      return;
    
    for( TPolicy tempPolicy : nodePolicyList.getPolicy() )
    {
      if( tempPolicy.getPolicyType().toString().contains( "Constraint" ) ) //$NON-NLS-1$
        this.appComponentElasticityRequirements.add( tempPolicy );
    }
    
  }

  // Remove Application Component Elasticity Action
  void removeApplicationComponentResizingAction( final TPolicy selectedObject )
  {
    PictogramElement pe = getSelectedPictogramElement();
    Object bo = null;
    if( pe != null ) {
      bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
    }
    final TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )( ( ( TServiceTemplate )bo ).getBoundaryDefinitions() );        
    
    PoliciesType1 nodePolicyList = boundaryDef.getPolicies();
    
    final EList<TPolicy> policy = nodePolicyList.getPolicy();
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          for( TPolicy tempPolicy : policy ) {
            if( tempPolicy.getPolicyType().toString().contains( "Strategy" ) ) //$NON-NLS-1$
              if( tempPolicy.getName().compareTo( selectedObject.getName() ) == 0 )
              {
                policy.remove( tempPolicy );
                if( policy.size() == 0 )
                  boundaryDef.setPolicies( null );
                // remove corresponding Policy Template
                String removedPolicyId = tempPolicy.getPolicyRef().toString();
                ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
                DefinitionsType toscaDefinitions = model.getDocumentRoot()
                  .getDefinitions();
                final EList<TPolicyTemplate> policyTemplate = toscaDefinitions.getPolicyTemplate();
                for( TPolicyTemplate tempPolicyTemplate : policyTemplate ) {
                  if( tempPolicyTemplate.getId().equals( removedPolicyId ) ) {
                    policyTemplate.remove( tempPolicyTemplate );
                  }
                }
                break;
              }
          }
        }
      } );
    this.appComponentResizingActions.remove( selectedObject );
    this.tableResizingActionsViewer.refresh();
  }

  /*
   * Refresh Elasticity Tab(non-Javadoc)
   * @see
   * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
   */
  @Override
  public void refresh() {
    // Refresh Elasticity Constraints
    this.appComponentElasticityRequirements.clear();
    getElasticityConstraints();
    this.tableViewer.refresh();
    // Refresh Elasticity Actions
    this.appComponentResizingActions.clear();
    getResizingActions();
    this.tableResizingActionsViewer.refresh();
  }
}
