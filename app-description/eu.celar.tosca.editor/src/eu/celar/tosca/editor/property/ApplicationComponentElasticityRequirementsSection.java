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
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.celar.tosca.editor.dialog.ElasticityRequirementsDialog;
import eu.celar.tosca.editor.dialog.GlobalElasticityRequirement;
import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1;
import eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;

public class ApplicationComponentElasticityRequirementsSection
  extends GFPropertySection implements ITabbedPropertyConstants
{

  Composite composite;
  private Table table;
  private Button addButton;
  private Button editButton;
  private Button removeButton;
  TableViewer tableViewer;
  List<GlobalElasticityRequirement> appComponentElasticityRequirements = new ArrayList<GlobalElasticityRequirement>();
  
  protected Tosca_Elasticity_ExtensionsFactory elasticityFactory = Tosca_Elasticity_ExtensionsFactory.eINSTANCE;

  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    composite = factory.createFlatFormComposite( parent );
    FormData dataF;



    this.table = new Table( composite, SWT.BORDER
                                       | SWT.VIRTUAL
                                       | SWT.MULTI
                                       | SWT.FULL_SELECTION );
    this.table.setHeaderVisible( true );
    this.table.setLinesVisible( true );
    dataF = new FormData();
    dataF.left = new FormAttachment( 0, STANDARD_LABEL_WIDTH + 60 );
    dataF.right = new FormAttachment( 40, 0 );
    dataF.top = new FormAttachment( 0, VSPACE );
    dataF.height = 50;
    dataF.width = 200;
    this.table.setLayoutData( dataF );

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
    TableColumn typeColumn = new TableColumn( this.table, SWT.LEFT );
    typeColumn.setText( "Value" ); //$NON-NLS-1$
    this.tableViewer = new TableViewer( this.table );
    IStructuredContentProvider contentProvider = new GlobalElasticityRequirementsContentProvider();
    this.tableViewer.setContentProvider( contentProvider );
    this.tableViewer.setLabelProvider( new GlobalElasticityRequirementsContentLabelProvider() );
    this.tableViewer.setInput( this.appComponentElasticityRequirements );

    this.addButton = new Button( composite, SWT.PUSH );

    this.addButton.setText( "Add" ); //$NON-NLS-1$
    dataF = new FormData();
    dataF.left = new FormAttachment( this.table, +HSPACE );
    dataF.top = new FormAttachment( 0, VSPACE );
    this.addButton.setLayoutData( dataF );
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
    this.editButton = new Button( composite, SWT.PUSH );
    this.editButton.setText( "Edit" ); //$NON-NLS-1$
    dataF = new FormData();
    dataF.left = new FormAttachment( this.addButton, +HSPACE );
    dataF.top = new FormAttachment( 0, VSPACE );
    this.editButton.setLayoutData( dataF );
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
    this.removeButton = new Button( composite, SWT.PUSH );
    this.removeButton.setText( "Remove" ); //$NON-NLS-1$

    dataF = new FormData();
    dataF.left = new FormAttachment( this.editButton, +HSPACE );
    dataF.top = new FormAttachment( 0, VSPACE );
    this.removeButton.setLayoutData( dataF );
    this.removeButton.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        removeApplicationComponentElasticityRequirement( getSelectedObject() );
      }

      @Override
      public void widgetDefaultSelected( SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );


    // Elasticity Requirements Label
    CLabel valueLabel = factory.createCLabel( composite,
                                              "Elasticity Requirements:" ); //$NON-NLS-1$
    dataF = new FormData();
    dataF.left = new FormAttachment( 0, 0 );
    dataF.right = new FormAttachment( this.table, -HSPACE );
    dataF.top = new FormAttachment( this.table, 0, SWT.CENTER );
    valueLabel.setLayoutData( dataF );
  }

  void editDataStagingEntry( final GlobalElasticityRequirement selectedObject )
  {
    ElasticityRequirementsDialog dialog;
    if( selectedObject == null ) {
      dialog = new ElasticityRequirementsDialog( composite.getShell(), "Application Component" );
      if( dialog.open() == Window.OK ) {
        GlobalElasticityRequirement newElasticityRequirement = dialog.getDataStageInList();
        if( newElasticityRequirement != null ) {
                    
          //Add the new application component elasticity requirement to TOSCA
          
          PictogramElement pe = getSelectedPictogramElement();
          Object bo = null;
          
          if (pe!=null){
            bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
          }
                             
          TNodeTemplateExtension nodeTemplate = ( TNodeTemplateExtension ) bo;
                 
          final ApplicationComponentElasticityRequirementsType1 applicationComponentElasticityRequirementsList = nodeTemplate.getApplicationComponentElasticityRequirements();
          final TApplicationComponentElasticityRequirement requirement = this.elasticityFactory.createTApplicationComponentElasticityRequirement();
          
          requirement.setName( newElasticityRequirement.type );
          requirement.setValue( newElasticityRequirement.value );
          
          TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
          editingDomain.getCommandStack().execute( new RecordingCommand(editingDomain) {
           protected void doExecute(){
             applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements().add( requirement );
             }
          });
          
          //add the new application component elasticity requirement to temp list
          
          this.appComponentElasticityRequirements.add( newElasticityRequirement );
          this.tableViewer.refresh();
        } else {
        }
      }
    } else {
      
      //Edit button is pressed
      
      dialog = new ElasticityRequirementsDialog( composite.getShell(),
                                                 selectedObject, "Application Component" );
      if( dialog.open() == Window.OK ) {
        GlobalElasticityRequirement newElasticityRequirement = dialog.getDataStageInList();
        if( newElasticityRequirement != null ) {
          
          //Add the edited application component elasticity requirement to TOSCA
          
          PictogramElement pe = getSelectedPictogramElement();
          Object bo = null;
          
          if (pe!=null){
            bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
          }
                             
          TNodeTemplateExtension nodeTemplate = ( TNodeTemplateExtension ) bo;
                 
          final ApplicationComponentElasticityRequirementsType1 applicationComponentElasticityRequirementsList = nodeTemplate.getApplicationComponentElasticityRequirements();
          final TApplicationComponentElasticityRequirement requirement = this.elasticityFactory.createTApplicationComponentElasticityRequirement();
          
          requirement.setName( newElasticityRequirement.type );
          requirement.setValue( newElasticityRequirement.value );
          
          TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
          editingDomain.getCommandStack().execute( new RecordingCommand(editingDomain) {
           protected void doExecute(){
             applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements().add( requirement );
             }
          });
          
          this.appComponentElasticityRequirements.add( newElasticityRequirement );
          
          //Remove the edited global elasticity requirement from TOSCA
          
          editingDomain.getCommandStack().execute( new RecordingCommand(editingDomain) {
            protected void doExecute(){
              for (int i=0; i<applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements().size();i++){
                if (applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements().get( i ).getName()==selectedObject.type){
                  applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements().remove( i );
                }
              }
              }
           });
          
          this.appComponentElasticityRequirements.remove( selectedObject );
          this.tableViewer.refresh();
        } else {
        }
      }
    }
  }

  void removeApplicationComponentElasticityRequirement( final GlobalElasticityRequirement selectedObject )
  {
    PictogramElement pe = getSelectedPictogramElement();
    Object bo = null;
    
    if (pe!=null){
      bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
    }
                       
    TNodeTemplateExtension nodeTemplate = ( TNodeTemplateExtension ) bo;
           
    final ApplicationComponentElasticityRequirementsType1 applicationComponentElasticityRequirementsList = nodeTemplate.getApplicationComponentElasticityRequirements();
        
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
    editingDomain.getCommandStack().execute( new RecordingCommand(editingDomain) {
      protected void doExecute(){
        for (int i=0; i<applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements().size();i++){
          if (applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements().get( i ).getName()==selectedObject.type){
            applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements().remove( i );
          }
        }
        }
     });
    
    this.appComponentElasticityRequirements.remove( selectedObject );
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
    PictogramElement pe = getSelectedPictogramElement();
    if (pe != null) {
  
        TNodeTemplateExtension bo = (TNodeTemplateExtension) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        
        if (bo == null)
            return;
             
        this.appComponentElasticityRequirements.clear();
        ApplicationComponentElasticityRequirementsType1 applicationComponentElasticityRequirementsList = bo.getApplicationComponentElasticityRequirements();
        
        for (int i=0; i<applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements().size();i++){
          TApplicationComponentElasticityRequirement eReq = applicationComponentElasticityRequirementsList.getApplicationComponentElasticityRequirements().get( i );
          GlobalElasticityRequirement req = new GlobalElasticityRequirement(eReq.getName(),eReq.getValue());
          this.appComponentElasticityRequirements.add( req );
        }
       
        this.tableViewer.refresh();
    }
    
  }
}

class GlobalElasticityRequirementsContentProvider
  implements IStructuredContentProvider
{

  @Override
  public void dispose() {
    // TODO Auto-generated method stub
  }

  @Override
  public void inputChanged( Viewer viewer, Object oldInput, Object newInput ) {
    // TODO Auto-generated method stub
  }

  @Override
  public Object[] getElements( Object inputElement ) {
    GlobalElasticityRequirement[] elements = new GlobalElasticityRequirement[ 0 ];
    elements = (eu.celar.tosca.editor.dialog.GlobalElasticityRequirement[] )( ( List )inputElement ).toArray( new GlobalElasticityRequirement[ 0 ] );
    return elements;
  }
}

class GlobalElasticityRequirementsContentLabelProvider extends LabelProvider
  implements ITableLabelProvider
{

  @Override
  public Image getColumnImage( Object element, int columnIndex ) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getColumnText( Object element, int columnIndex ) {
    String result = null;
    if( element != null ) {
      GlobalElasticityRequirement var = ( GlobalElasticityRequirement )element;
      switch( columnIndex ) {
        case 0:
          // TODO type, value must not be public
          result = var.type;
        break;
        case 1:
          result = var.value;
        break;
      }
    }
    return result;
  }



}

