/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.xml.type.internal.QName;
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
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import eu.celar.tosca.TPolicy;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.elasticity.ApplicationPolicyCategory;
import eu.celar.tosca.editor.dialog.ElasticityConstraintDialog;

public class ApplicationDescriptionBasicPage extends WizardPage
  implements ModifyListener
{

  private Text txtAppName;
  private Text txtElasticityRequirement;
  private CCombo cmbOptimizationPolicy;
  Composite container;
  TableViewer tableViewer;
  List<TPolicy> globalElasticityRequirements = new ArrayList<TPolicy>();
  private Table table;
  private Button addButton;
  private Button removeButton;

  protected ApplicationDescriptionBasicPage( final String pageName ) {
    super( pageName );
    setPageComplete( false );
  }

  @Override
  public void createControl( final Composite parent ) {
    container = new Composite( parent, SWT.NONE );
    GridLayout gLayout = new GridLayout( 3, false );
    gLayout.horizontalSpacing = 10;
    gLayout.verticalSpacing = 12;
    container.setLayout( gLayout );
    // Application Name Label
    GridData layout = new GridData();
    Label lblApplicationName = new Label( container,
                                          GridData.HORIZONTAL_ALIGN_BEGINNING
                                              | GridData.VERTICAL_ALIGN_CENTER );
    lblApplicationName.setText( Messages.getString( "NewApplicationDescriptionBasicPage.applicationNameLabel" ) ); //$NON-NLS-1$
    layout = new GridData();
    layout.widthHint = 160;
    layout.horizontalAlignment = GridData.FILL;
    lblApplicationName.setLayoutData( layout );
    // Application Name Text box
    this.txtAppName = new Text( container, SWT.BORDER );
    layout = new GridData( GridData.FILL_HORIZONTAL
                           | GridData.GRAB_HORIZONTAL
                           | GridData.VERTICAL_ALIGN_CENTER );
    layout.horizontalAlignment = GridData.FILL;
    layout.horizontalSpan = 2;
    this.txtAppName.setLayoutData( layout );
    this.txtAppName.addModifyListener( this );
    // Optimization Policy Label
    Label lblOptimizationPolicy = new Label( container,
                                             GridData.HORIZONTAL_ALIGN_BEGINNING
                                                 | GridData.VERTICAL_ALIGN_CENTER );
    lblOptimizationPolicy.setText( Messages.getString( "NewApplicationDescriptionBasicPage.optimizationPolicyLabel" ) ); //$NON-NLS-1$
    layout = new GridData();
    layout.horizontalAlignment = GridData.FILL;
    lblOptimizationPolicy.setLayoutData( layout );
    // Combo - Policy
    this.cmbOptimizationPolicy = new CCombo( container, SWT.BORDER );
    this.cmbOptimizationPolicy.setEnabled( true );
    layout = new GridData();
    layout.horizontalAlignment = GridData.FILL;
    layout.horizontalSpan = 2;
    this.cmbOptimizationPolicy.setLayoutData( layout );
    
    
    List<ApplicationPolicyCategory> categories = ApplicationPolicyCategory.VALUES;
    for( ApplicationPolicyCategory tempCat : categories ){
      this.cmbOptimizationPolicy.add( tempCat.toString() );
    }
    

    this.cmbOptimizationPolicy.setEditable( false );
    // Global Elasticity Requirements Label
    Label lblGlobalElasticityReq = new Label( container,
                                              GridData.HORIZONTAL_ALIGN_BEGINNING
                                                  | GridData.VERTICAL_ALIGN_CENTER );
    lblGlobalElasticityReq.setText( Messages.getString( "NewApplicationDescriptionBasicPage.globalElasticityReqLabel" ) ); //$NON-NLS-1$
    layout = new GridData();
    layout.horizontalAlignment = GridData.FILL;
    layout.horizontalSpan = 3;
    layout.verticalIndent = 20;
    lblGlobalElasticityReq.setLayoutData( layout );
    GridLayout gLayoutT;
    GridData gData = new GridData( GridData.FILL_BOTH
                                   | GridData.GRAB_HORIZONTAL );
    this.table = new Table( container, SWT.BORDER
                                       | SWT.VIRTUAL
                                       | SWT.MULTI
                                       | SWT.FULL_SELECTION );
    this.table.setHeaderVisible( true );
    this.table.setLinesVisible( true );
    gData = new GridData( GridData.FILL_BOTH );
    gData.grabExcessVerticalSpace = true;
    gData.widthHint = 400;
    gData.heightHint = 100;
    gData.horizontalSpan = 2;
    this.table.setLayoutData( gData );
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
    this.tableViewer = new TableViewer( this.table );
    IStructuredContentProvider contentProvider = new GlobalElasticityRequirementsContentProvider();
    this.tableViewer.setContentProvider( contentProvider );
    this.tableViewer.setLabelProvider( new GlobalElasticityRequirementsContentLabelProvider() );
    this.tableViewer.setInput( this.globalElasticityRequirements );
    Composite buttonsComp = new Composite( container, SWT.NONE );
    gLayoutT = new GridLayout( 1, true );
    buttonsComp.setLayout( gLayoutT );
    this.addButton = new Button( buttonsComp, SWT.PUSH );
    gData = new GridData( GridData.VERTICAL_ALIGN_BEGINNING
                          | GridData.HORIZONTAL_ALIGN_BEGINNING );
    buttonsComp.setLayoutData( gData );
    gData = new GridData( GridData.FILL_BOTH );
    this.addButton.setLayoutData( gData );
    this.addButton.setText( "Add" ); //$NON-NLS-1$
    this.addButton.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        editDataStagingEntry( null );
      }

      @Override
      public void widgetDefaultSelected( SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );

    this.removeButton = new Button( buttonsComp, SWT.PUSH );
    gData = new GridData( GridData.FILL_BOTH );
    this.removeButton.setLayoutData( gData );
    this.removeButton.setText( "Remove" ); //$NON-NLS-1$
    this.removeButton.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        removeGlobalElasticityConstraints( getSelectedObject() );
      }

      @Override
      public void widgetDefaultSelected( SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    setControl( container );
    // setPageComplete(validatePage());
  }

  protected boolean validatePage() {
    boolean result = !( this.txtAppName.getText().equals( "" ) );
    if( result ) {
      setPageComplete( true );
      getContainer().updateButtons();
    }
    return result;
  }

  /**
   * @return the Application Name
   */
  public String getApplicationName() {
    return this.txtAppName.getText();
  }

  /**
   * @return the Optimization Policy
   */
  public String getOptimizationPolicy() {
    return this.cmbOptimizationPolicy.getText();
  }

  /**
   * @return the Global Elasticity Requirements list
   */
  public List<TPolicy> getGlobalElasticityConstraints(){
    return this.globalElasticityRequirements;
  }
  /**
   * @return the Value of the Global Elasticity Requirement
   */
  public String getGlobalElasticityRequirementValue() {
    return this.txtElasticityRequirement.getText();
  }

  @Override
  public void modifyText( ModifyEvent e ) {
    if( e.widget == this.txtAppName )
      validatePage();
  }

  void editDataStagingEntry( final TPolicy selectedObject )
  {
    ElasticityConstraintDialog dialog;
    if( selectedObject == null ) {
      dialog = new ElasticityConstraintDialog( container.getShell(),
                                                 "Application" );
      if( dialog.open() == Window.OK ) {
        String newElasticityConstraint = dialog.getElasticityConstraint();
        if( newElasticityConstraint != null ) {
          TPolicy newPolicy = ToscaFactory.eINSTANCE.createTPolicy();
          
          final String policyUniqueName = "G" + this.globalElasticityRequirements.size();
          
          newPolicy.setPolicyType( new QName("SYBLConstraint") );          
          
          newPolicy.setName( policyUniqueName + ": CONSTRAINT " + newElasticityConstraint );
        
          this.globalElasticityRequirements.add( newPolicy );
          this.tableViewer.refresh();
          
        }
          
        } else {
        }
      }
    } 

  void removeGlobalElasticityConstraints( final TPolicy selectedObject )
  {
    this.globalElasticityRequirements.remove( selectedObject );
    this.tableViewer.refresh();
  }

  TPolicy getSelectedObject() {
    TPolicy result = null;
    IStructuredSelection selection = ( IStructuredSelection )this.tableViewer.getSelection();
    Object obj = selection.getFirstElement();
    result = ( TPolicy )obj;
    return result;
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
  public void inputChanged( final Viewer viewer, final Object oldInput, final Object newInput )
  {
    // TODO Auto-generated method stub
  }

  @Override
  public Object[] getElements( Object inputElement ) {
    return ((List<TPolicy>) inputElement).toArray();
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
      TPolicy var = ( TPolicy )element;
      switch( columnIndex ) {
        case 0:
          // TODO type, value must not be public
          result = var.getName();
        break;
      }
    }
    return result;
  }
}

