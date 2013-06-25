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
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.editor.dialog.ElasticityRequirementsDialog;
import eu.celar.tosca.editor.dialog.GlobalElasticityRequirement;
import eu.celar.tosca.elasticity.GlobalElasticityRequirementsType1;
import eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension;
import eu.celar.tosca.elasticity.TGlobalElasticityRequirement;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;


public class ApplicationGlobalElasticityReqSection
extends GFPropertySection implements ITabbedPropertyConstants
{

Composite client;
Section section;
private Table table;
private Button addButton;
private Button editButton;
private Button removeButton;
TableViewer tableViewer;
List<GlobalElasticityRequirement> globalElasticityRequirements = new ArrayList<GlobalElasticityRequirement>();

protected Tosca_Elasticity_ExtensionsFactory elasticityFactory = Tosca_Elasticity_ExtensionsFactory.eINSTANCE;

public void getWizardGlobalElasticityRequirements(){
  //initiate global elasticity requirement list with requirements from description wizard
  
  PictogramElement pe = getSelectedPictogramElement();
  Object bo = null;
  
  if (pe!=null){
    bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
  }
   
  TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )(((TServiceTemplate) bo).getBoundaryDefinitions());
          
  final GlobalElasticityRequirementsType1 globalElasticityRequirementsList = boundaryDef.getGlobalElasticityRequirements();
  
  String type, value;
  
  for (int i=0; i<globalElasticityRequirementsList.getGlobalElasticityRequirements().size();i++){
    type = globalElasticityRequirementsList.getGlobalElasticityRequirements().get( i ).getName();
    value = globalElasticityRequirementsList.getGlobalElasticityRequirements().get( i ).getValue();
    GlobalElasticityRequirement newElasticityRequirement = new GlobalElasticityRequirement(type, value);
    this.globalElasticityRequirements.add(newElasticityRequirement);
  }
}

@Override
public void createControls( Composite parent,
                            TabbedPropertySheetPage tabbedPropertySheetPage )
{
  super.createControls( parent, tabbedPropertySheetPage );
  
  //TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
  
  FormToolkit toolkit = new FormToolkit(parent.getDisplay());
  this.section = toolkit.createSection(parent, Section.TITLE_BAR);
  section.setText("Application Elasticity Requirements"); //$NON-NLS-1$
  Composite client = toolkit.createComposite(section, SWT.WRAP);
  Composite client1 = toolkit.createComposite( client, SWT.WRAP );
  Composite client2 = toolkit.createComposite( client, SWT.WRAP );
  GridLayout layout = new GridLayout();
  layout.numColumns = 2;
  layout.marginTop = 15;
  layout.verticalSpacing = 15;
  layout.marginWidth = 2;
  layout.marginHeight = 2;
  client.setLayout(layout);
  
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
  this.table.setLinesVisible( true );
  
  gd = new GridData();
  gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
  gd.verticalAlignment=GridData.VERTICAL_ALIGN_CENTER;
  gd.widthHint = 300;
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
  IStructuredContentProvider contentProvider = new GlobalElasticityRequirementsContentProvider();
  this.tableViewer.setContentProvider( contentProvider );
  this.tableViewer.setLabelProvider( new GlobalElasticityRequirementsContentLabelProvider() );
  this.tableViewer.setInput( this.globalElasticityRequirements );

  this.addButton = new Button( client2, SWT.PUSH );

  this.addButton.setText( "Add" ); //$NON-NLS-1$
  
  gd = new GridData();
  gd.widthHint = 60;
  gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
  this.addButton.setLayoutData( gd );
  

  this.addButton.addSelectionListener( new SelectionListener() {

          @Override
          public void widgetSelected(SelectionEvent e) {
              editDataStagingEntry(null);
          }

          @Override
          public void widgetDefaultSelected(SelectionEvent e) {
              // TODO Auto-generated method stub
          }
  } );
  this.editButton = new Button( client2, SWT.PUSH );
  this.editButton.setText( "Edit" ); //$NON-NLS-1$
  
  gd = new GridData();
  gd.widthHint = 60;
  gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
  this.editButton.setLayoutData( gd );
  

  this.editButton.addSelectionListener( new SelectionListener() {

    @Override
    public void widgetSelected( SelectionEvent e ) {
      editDataStagingEntry( getSelectedObject() );
    }

    @Override
    public void widgetDefaultSelected( SelectionEvent e ) {
      // TODO Auto-generated method stub
    }
  } );
  this.removeButton = new Button( client2, SWT.PUSH );
  this.removeButton.setText( "Remove" ); //$NON-NLS-1$
  
  gd = new GridData();
  gd.widthHint = 60;
  gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
  this.removeButton.setLayoutData( gd );


  this.removeButton.addSelectionListener( new SelectionListener() {

    @Override
    public void widgetSelected( SelectionEvent e ) {
      removeGlobalElasticityRequirement( getSelectedObject() );
    }

    @Override
    public void widgetDefaultSelected( SelectionEvent e ) {
      // TODO Auto-generated method stub
    }
  } );

  toolkit.adapt( this.table, true, true );
  toolkit.adapt( this.addButton, true, true );
  toolkit.adapt( this.editButton, true, true );
  toolkit.adapt( this.removeButton, true, true );
  section.setClient(client);
  
}

void editDataStagingEntry( final GlobalElasticityRequirement selectedObject )
{
ElasticityRequirementsDialog dialog;
  
  if( selectedObject == null ) {
    
    //add button is pressed
    dialog = new ElasticityRequirementsDialog( section.getShell(), "Application" );
    if( dialog.open() == Window.OK ) {
      GlobalElasticityRequirement newElasticityRequirement = dialog.getDataStageInList();
      if( newElasticityRequirement != null ) {
                
        //Add the new global elasticity requirement to TOSCA
        
        PictogramElement pe = getSelectedPictogramElement();
        Object bo = null;
        
        if (pe!=null){
          bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        }
        
        TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )(((TServiceTemplate) bo).getBoundaryDefinitions());
                
        final GlobalElasticityRequirementsType1 globalElasticityRequirementsList = boundaryDef.getGlobalElasticityRequirements();
        
        final TGlobalElasticityRequirement requirement = this.elasticityFactory.createTGlobalElasticityRequirement();
        
        requirement.setName( newElasticityRequirement.type );
        requirement.setValue( newElasticityRequirement.value );
        
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack().execute( new RecordingCommand(editingDomain) {
         protected void doExecute(){
           globalElasticityRequirementsList.getGlobalElasticityRequirements().add( requirement );
           }
        });
       
        //add the new global elasticity requirement to temp list
        this.globalElasticityRequirements.add( newElasticityRequirement );
        
        this.tableViewer.refresh();
      } else {
      }
    }
  } else {
    
    //Edit button is pressed
    dialog = new ElasticityRequirementsDialog( section.getShell(),
                                               selectedObject, "Application" );
    if( dialog.open() == Window.OK ) {
      final GlobalElasticityRequirement newElasticityRequirement = dialog.getDataStageInList();
      if( newElasticityRequirement != null ) {
        
        //Add the edited global elasticity requirement to TOSCA
        
        PictogramElement pe = getSelectedPictogramElement();
        Object bo = null;
        
        if (pe!=null){
          bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        }
        
        TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )(((TServiceTemplate) bo).getBoundaryDefinitions());
                
        final GlobalElasticityRequirementsType1 globalElasticityRequirementsList = boundaryDef.getGlobalElasticityRequirements();
        
        final TGlobalElasticityRequirement requirement = this.elasticityFactory.createTGlobalElasticityRequirement();
        
        requirement.setName( newElasticityRequirement.type );
        requirement.setValue( newElasticityRequirement.value );
        
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack().execute( new RecordingCommand(editingDomain) {
         protected void doExecute(){
           globalElasticityRequirementsList.getGlobalElasticityRequirements().add( requirement );
           }
        });
        
        
        //Remove the edited global elasticity requirement from TOSCA
               
        editingDomain.getCommandStack().execute( new RecordingCommand(editingDomain) {
         protected void doExecute(){
           for (int i=0; i<globalElasticityRequirementsList.getGlobalElasticityRequirements().size();i++){
             if (globalElasticityRequirementsList.getGlobalElasticityRequirements().get( i ).getName()==selectedObject.type){
               globalElasticityRequirementsList.getGlobalElasticityRequirements().remove( i );
             }
           }
           }
        });
        
        this.globalElasticityRequirements.add( newElasticityRequirement );
        this.globalElasticityRequirements.remove( selectedObject );
        
        this.tableViewer.refresh();
      } else {
      }
    }
  }
}

void removeGlobalElasticityRequirement( final GlobalElasticityRequirement selectedObject )
{
  
  PictogramElement pe = getSelectedPictogramElement();
  Object bo = null;
  
  if (pe!=null){
    bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
  }
  
  TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )(((TServiceTemplate) bo).getBoundaryDefinitions());
  
  final GlobalElasticityRequirementsType1 globalElasticityRequirementsList = boundaryDef.getGlobalElasticityRequirements();
  
  TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
  editingDomain.getCommandStack().execute( new RecordingCommand(editingDomain) {
    protected void doExecute(){
      for (int i=0; i<globalElasticityRequirementsList.getGlobalElasticityRequirements().size();i++){
        if (globalElasticityRequirementsList.getGlobalElasticityRequirements().get( i ).getName()==selectedObject.type){
          globalElasticityRequirementsList.getGlobalElasticityRequirements().remove( i );
        }
      }
      }
   });
  
  
  this.globalElasticityRequirements.remove( selectedObject );
  this.tableViewer.refresh();
}

GlobalElasticityRequirement getSelectedObject() {
  GlobalElasticityRequirement result = null;
  IStructuredSelection selection = ( IStructuredSelection )this.tableViewer.getSelection();
  Object obj = selection.getFirstElement();
  result = ( GlobalElasticityRequirement )obj;
  return result;
}

@Override
public void refresh() {
  
  if (this.globalElasticityRequirements.size()==0)
    getWizardGlobalElasticityRequirements();
  
  PictogramElement pe = getSelectedPictogramElement();
  if (pe != null) {
      TServiceTemplate bo = (TServiceTemplate) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
      // the filter assured, that it is a EClass
      if (bo == null)
          return;
           
      //this.globalElasticityRequirements.add( new GlobalElasticityRequirement("Minimum Response Time", "2") );

      this.tableViewer.refresh();
  }
}
}


