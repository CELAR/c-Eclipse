/************************************************************
 * Copyright (C), 2013 CELAR Consortium 
 * http://www.celarcloud.eu
 * 
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.property;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.editor.dialog.ElasticityRequirementsDialog;
import eu.celar.tosca.editor.dialog.GlobalElasticityRequirement;
import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1;
import eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;

/** 
 * Application Component Properties - Elasticity Tab
 */
public class ApplicationComponentElasticityRequirementsSection
  extends GFPropertySection implements ITabbedPropertyConstants
{

  Composite client;
  Section section;
  private Table table;
  private Button addButton;
  private Button editButton;
  private Button removeButton;
  TableViewer tableViewer;
  List<GlobalElasticityRequirement> appComponentElasticityRequirements = new ArrayList<GlobalElasticityRequirement>();
  Section sectionRA;
  private Table tableResizingActions;
  private Button removeButtonRA;
  TableViewer tableResizingActionsViewer;
  List<String> appComponentResizingActions = new ArrayList<String>();
  protected Tosca_Elasticity_ExtensionsFactory elasticityFactory = Tosca_Elasticity_ExtensionsFactory.eINSTANCE;

  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    // Application Component Elasticity Requirements Section
    this.section = toolkit.createSection( parent, Section.TITLE_BAR );
    this.section.setText( "Application Component Elasticity Requirements" ); //$NON-NLS-1$
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
    nameColumn.setText( "Elasticity Requirement" ); //$NON-NLS-1$
    nameColumn.setWidth( 200 );
    TableColumn typeColumn = new TableColumn( this.table, SWT.LEFT );
    typeColumn.setText( "Value" ); //$NON-NLS-1$
    typeColumn.setWidth( 100 );
    this.tableViewer = new TableViewer( this.table );
    ElasticityRequirementsProvider ERProvider = new ElasticityRequirementsProvider();
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
    this.editButton = new Button( client2, SWT.PUSH );
    this.editButton.setText( "Edit" ); //$NON-NLS-1$
    gd = new GridData();
    gd.widthHint = 60;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.editButton.setLayoutData( gd );
    // Listener for Edit button
    this.editButton.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( final SelectionEvent e ) {
        editDataStagingEntry( getSelectedObject() );
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
    toolkit.adapt( this.editButton, true, true );
    toolkit.adapt( this.removeButton, true, true );
    this.section.setClient( client );
    // Application Component Elasticity Actions Section
    this.sectionRA = toolkit.createSection( parent, Section.TITLE_BAR );
    this.sectionRA.setText( "Elasticity Actions" ); //$NON-NLS-1$
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
    nameColumnRA.setText( "Action" ); //$NON-NLS-1$
    nameColumnRA.setWidth( 200 );
    ColumnWeightData dataRA = new ColumnWeightData( 200 );
    tableLayoutRA.addColumnData( dataRA );
    // Set the Elasticity Actions table viewer
    ResizingActionsProvider RAProvider = new ResizingActionsProvider();
    this.tableResizingActionsViewer = new TableViewer( this.tableResizingActions );
    IStructuredContentProvider contentProviderRA = RAProvider.RAContentProvider;
    this.tableResizingActionsViewer.setContentProvider( contentProviderRA );
    this.tableResizingActionsViewer.setLabelProvider( RAProvider.RAContentLabelProvider );
    this.tableResizingActionsViewer.setInput( this.appComponentResizingActions );
    this.removeButtonRA = new Button( clientRA2, SWT.PUSH );
    this.removeButtonRA.setText( "Remove" ); //$NON-NLS-1$
    // Listener for Remove Elasticity Action button
    this.removeButtonRA.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( final SelectionEvent e ) {
        removeApplicationComponentResizingAction( getSelectedResizingAction() );
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
    // Add section components to the toolkit
    toolkit.adapt( this.tableResizingActions, true, true );
    toolkit.adapt( this.removeButtonRA, true, true );
    this.sectionRA.setClient( clientRA );
  }

  // Add or Edit Application Component Elasticity Requirement
  void editDataStagingEntry( final GlobalElasticityRequirement selectedObject )
  {
    ElasticityRequirementsDialog dialog;
    if( selectedObject == null ) {
      // Add button is pressed
      dialog = new ElasticityRequirementsDialog( this.section.getShell(),
                                                 "Application Component" ); //$NON-NLS-1$
      if( dialog.open() == Window.OK ) {
        GlobalElasticityRequirement newElasticityRequirement = dialog.getElasticityRequirement();
        if( newElasticityRequirement != null ) {
          // Add Application Component Elasticity Requirement to TOSCA
          PictogramElement pe = getSelectedPictogramElement();
          Object bo = null;
          if( pe != null ) {
            bo = Graphiti.getLinkService()
              .getBusinessObjectForLinkedPictogramElement( pe );
          }
          TNodeTemplateExtension nodeTemplate = ( TNodeTemplateExtension )bo;
          final ApplicationComponentElasticityRequirementsType1 applicationComponentElasticityRequirementsList = nodeTemplate.getApplicationComponentElasticityRequirements();
          final TApplicationComponentElasticityRequirement requirement = this.elasticityFactory.createTApplicationComponentElasticityRequirement();
          requirement.setName( newElasticityRequirement.type );
          requirement.setValue( newElasticityRequirement.value );
          TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
          editingDomain.getCommandStack()
            .execute( new RecordingCommand( editingDomain ) {

              @Override
              protected void doExecute() {
                applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements()
                  .add( requirement );
              }
            } );
          // Add Application Component Elasticity Requirement to temp list
          this.appComponentElasticityRequirements.add( newElasticityRequirement );
          this.tableViewer.refresh();
        } else {
        }
      }
    } else {
      // Edit button is pressed
      dialog = new ElasticityRequirementsDialog( this.section.getShell(),
                                                 selectedObject,
                                                 "Application Component" ); //$NON-NLS-1$
      if( dialog.open() == Window.OK ) {
        GlobalElasticityRequirement newElasticityRequirement = dialog.getElasticityRequirement();
        if( newElasticityRequirement != null ) {
          // Add the edited Application Component Elasticity Requirement to
          // TOSCA
          PictogramElement pe = getSelectedPictogramElement();
          Object bo = null;
          if( pe != null ) {
            bo = Graphiti.getLinkService()
              .getBusinessObjectForLinkedPictogramElement( pe );
          }
          TNodeTemplateExtension nodeTemplate = ( TNodeTemplateExtension )bo;
          final ApplicationComponentElasticityRequirementsType1 applicationComponentElasticityRequirementsList = nodeTemplate.getApplicationComponentElasticityRequirements();
          final TApplicationComponentElasticityRequirement requirement = this.elasticityFactory.createTApplicationComponentElasticityRequirement();
          requirement.setName( newElasticityRequirement.type );
          requirement.setValue( newElasticityRequirement.value );
          TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
          editingDomain.getCommandStack()
            .execute( new RecordingCommand( editingDomain ) {

              @Override
              protected void doExecute() {
                applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements()
                  .add( requirement );
              }
            } );
          this.appComponentElasticityRequirements.add( newElasticityRequirement );
          // Remove the edited Application Component Elasticity Requirement from
          // TOSCA
          editingDomain.getCommandStack()
            .execute( new RecordingCommand( editingDomain ) {

              @Override
              protected void doExecute() {
                for( int i = 0; i < applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements()
                  .size(); i++ )
                {
                  if( applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements()
                    .get( i )
                    .getName() == selectedObject.type )
                  {
                    applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements()
                      .remove( i );
                  }
                }
              }
            } );
          this.appComponentElasticityRequirements.remove( selectedObject );
          this.tableViewer.refresh();
        } else {
        }
      }
    }
  }

  // Remove the selected Application Component Elasticity Requirement from TOSCA
  void removeApplicationComponentElasticityRequirement( final GlobalElasticityRequirement selectedObject )
  {
    PictogramElement pe = getSelectedPictogramElement();
    Object bo = null;
    if( pe != null ) {
      bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
    }
    TNodeTemplateExtension nodeTemplate = ( TNodeTemplateExtension )bo;
    final ApplicationComponentElasticityRequirementsType1 applicationComponentElasticityRequirementsList = nodeTemplate.getApplicationComponentElasticityRequirements();
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          for( int i = 0; i < applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements()
            .size(); i++ )
          {
            if( applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements()
              .get( i )
              .getName() == selectedObject.type )
            {
              applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements()
                .remove( i );
            }
          }
        }
      } );
    this.appComponentElasticityRequirements.remove( selectedObject );
    this.tableViewer.refresh();
  }

  // Return the selected Elasticity Requirement
  GlobalElasticityRequirement getSelectedObject() {
    GlobalElasticityRequirement result = null;
    IStructuredSelection selection = ( IStructuredSelection )this.tableViewer.getSelection();
    Object obj = selection.getFirstElement();
    result = ( GlobalElasticityRequirement )obj;
    return result;
  }

  // Return the selected Elasticity Action
  String getSelectedResizingAction() {
    String result = null;
    IStructuredSelection selection = ( IStructuredSelection )this.tableResizingActionsViewer.getSelection();
    Object obj = selection.getFirstElement();
    result = ( String )obj;
    return result;
  }

  /**
   * Get Application Component Elasticity Actions
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
    TNodeTemplate appComponent = ( TNodeTemplate )bo;
    TDeploymentArtifacts deploymentArtifacts = appComponent.getDeploymentArtifacts();
    if( deploymentArtifacts == null )
      return;
    for( TDeploymentArtifact artifact : deploymentArtifacts.getDeploymentArtifact() )
    {
      if( artifact.getArtifactType().toString().compareTo( "ResizingAction" ) == 0 ) //$NON-NLS-1$
        this.appComponentResizingActions.add( artifact.getName() );
    }
  }

  // Remove Application Component Elasticity Action
  void removeApplicationComponentResizingAction( final String selectedObject ) {
    PictogramElement pe = getSelectedPictogramElement();
    Object bo = null;
    if( pe != null ) {
      bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
    }
    TNodeTemplateExtension nodeTemplate = ( TNodeTemplateExtension )bo;
    final TDeploymentArtifacts deploymentArtifacts = nodeTemplate.getDeploymentArtifacts();
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          for( TDeploymentArtifact artifact : deploymentArtifacts.getDeploymentArtifact() )
          {
            if( artifact.getArtifactType()
              .toString()
              .compareTo( "ResizingAction" ) == 0 ) //$NON-NLS-1$
              if( artifact.getName() == selectedObject ) {
                deploymentArtifacts.getDeploymentArtifact().remove( artifact );
                break;
              }
          }
        }
      } );
    this.appComponentResizingActions.remove( selectedObject );
    this.tableResizingActionsViewer.refresh();
  }

  /*
   *  Refresh Elasticity Tab(non-Javadoc)
   * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
   */
  @Override
  public void refresh() {
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      TNodeTemplateExtension bo = ( TNodeTemplateExtension )Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      if( bo == null )
        return;
      this.appComponentElasticityRequirements.clear();
      ApplicationComponentElasticityRequirementsType1 applicationComponentElasticityRequirementsList = bo.getApplicationComponentElasticityRequirements();
      for( int i = 0; i < applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements()
        .size(); i++ )
      {
        TApplicationComponentElasticityRequirement eReq = applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements()
          .get( i );
        GlobalElasticityRequirement req = new GlobalElasticityRequirement( eReq.getName(),
                                                                           eReq.getValue() );
        this.appComponentElasticityRequirements.add( req );
      }
      this.tableViewer.refresh();
      // Refresh Elasticity Actions
      this.appComponentResizingActions.clear();
      getResizingActions();
      this.tableResizingActionsViewer.refresh();
    }
  }
}
