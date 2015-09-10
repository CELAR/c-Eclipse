/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.dialog;

/**
 * @author stalo
 */
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * @author Nicholas Loulloudes
 *
 */
public class ElasticityStrategyDialog extends Dialog {

  protected boolean editMode = false;
  protected boolean addMode = false;
  protected String newType;
  protected String elasticityStrategy;
  protected String preScaleAction;
  protected String postScaleAction;
  private CCombo cmbStrategy;
  private CCombo cmbMetric;
  private CCombo cmbElasticityAction;
  private String nodeName;
  protected Text preScaleText;
  protected Text postScaleText;
  private Button preScaleBtn;
  private Button postScaleBtn;

  /**
   * @param parentShell
   * @param component 
   * @param nodeName 
   */
  public ElasticityStrategyDialog( final Shell parentShell, final String component, final String nodeName ) {
    super( parentShell );
    this.addMode = true;
    this.nodeName = nodeName;
  }

  @Override
  protected void configureShell( final Shell shell ) {
    super.configureShell( shell );
    shell.setText( "Add Elasticity Strategy" ); //$NON-NLS-1$
    shell.setSize( 450, 380);
  }

  @Override
  protected Control createDialogArea( final Composite parent ) {
    Composite composite = ( Composite )super.createDialogArea( parent );
    composite.setLayout( new GridLayout( 1, false ) );
    composite.setLayoutData( new GridData( GridData.FILL_BOTH ) );
    
    // Choose from Supported Elasticity Actions Group
    Group elasticityActionsGroup = new Group( composite, SWT.NONE );
    elasticityActionsGroup.setLayout( new GridLayout( 1, false ) );
    elasticityActionsGroup.setText( "&Select Strategy" ); //$NON-NLS-1$
    GridData gData = new GridData( SWT.FILL, SWT.FILL, true, true );
    elasticityActionsGroup.setLayoutData( gData );
    
    // Combo - GlobalElasticityReq
    this.cmbElasticityAction = new CCombo( elasticityActionsGroup, SWT.BORDER );
    this.cmbElasticityAction.setEnabled( true );
    gData = new GridData( GridData.FILL_BOTH );
    this.cmbElasticityAction.setLayoutData( gData );
//    this.cmbElasticityAction.add( "AddVM" );
//    this.cmbElasticityAction.add( "RemoveVM" );
    this.cmbElasticityAction.add( "scaleIn" ); //$NON-NLS-1$
    this.cmbElasticityAction.add( "scaleOut" ); //$NON-NLS-1$
    this.cmbElasticityAction.add( "attachDisk" ); //$NON-NLS-1$
    this.cmbElasticityAction.add( "detachDisk" ); //$NON-NLS-1$
    this.cmbElasticityAction.add( "vmResize" ); //$NON-NLS-1$
    this.cmbElasticityAction.setText( this.cmbElasticityAction.getItem( 0 ) );
    this.cmbElasticityAction.setEditable( false );
    
    // Create New Strategy Group
    Group customStrategyGroup = new Group( composite, SWT.NONE );
    customStrategyGroup.setLayout( new GridLayout( 1, false ) );
    customStrategyGroup.setText( "&Specify New Strategy" ); //$NON-NLS-1$
//    gData = new GridData( SWT.FILL, SWT.FILL, true, true );
    gData = new GridData( GridData.FILL_BOTH );
    customStrategyGroup.setLayoutData( gData );
    // Combo - GlobalElasticityReq
    this.cmbStrategy = new CCombo( customStrategyGroup, SWT.BORDER );
    this.cmbStrategy.setEnabled( true );
//    gd = new GridData( GridData.FILL_HORIZONTAL );
    gData = new GridData( GridData.FILL_BOTH );
    this.cmbStrategy.setLayoutData( gData );
    this.cmbStrategy.add( "Maximize" ); //$NON-NLS-1$
    this.cmbStrategy.add( "Minimize" ); //$NON-NLS-1$
    this.cmbStrategy.setText( this.cmbStrategy.getItem( 0 ) );
    this.cmbStrategy.setEditable( false );
    // Combo - Metric
    this.cmbMetric = new CCombo( customStrategyGroup, SWT.BORDER );
    this.cmbMetric.setEnabled( true );
    this.cmbMetric.setEditable( false );
    gData = new GridData( GridData.FILL_BOTH );
    this.cmbMetric.setLayoutData( gData );
    this.cmbMetric.add( "&Cost" ); //$NON-NLS-1$
    this.cmbMetric.add( "&Throughput" ); //$NON-NLS-1$
    this.cmbMetric.add( "&Response Time" ); //$NON-NLS-1$
    
    Group scaleActionsGroup = new Group( composite, SWT.NONE );
    scaleActionsGroup.setLayout( new GridLayout( 3, false ) );
    scaleActionsGroup.setText( "&Scale Actions" ); //$NON-NLS-1$
    gData = new GridData( GridData.FILL_BOTH );
    scaleActionsGroup.setLayoutData( gData );
       
            
    Image imageAdd = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);

    Label preScaleLabel = new Label( scaleActionsGroup, SWT.NONE );
    preScaleLabel.setText( "Pre-Scale" ); //$NON-NLS-1$
    
    this.preScaleText = new Text( scaleActionsGroup, SWT.BORDER );
    gData = new GridData( GridData.FILL_BOTH );
    this.preScaleText.setLayoutData( gData);
    this.preScaleText.addModifyListener( new ModifyListener() {
      
      @Override
      public void modifyText( ModifyEvent e ) {
        ElasticityStrategyDialog.this.preScaleAction = ElasticityStrategyDialog.this.preScaleText.getText();
      }
    } );
    
    this.preScaleBtn = new Button( scaleActionsGroup, SWT.PUSH );
    this.preScaleBtn.setImage( imageAdd );
    gData = new GridData();
    this.preScaleBtn.setLayoutData( gData );
    this.preScaleBtn.addSelectionListener( new SelectionListener() {
      
      @Override
      public void widgetSelected( final SelectionEvent e ) {
        handleSelectScaleAction( parent, "Pre-", ElasticityStrategyDialog.this.preScaleText ); //$NON-NLS-1$
      }
      
      @Override
      public void widgetDefaultSelected( final SelectionEvent e ) {
        // Do Nothing
      }
    } );
    
    Label postScaleLabel = new Label( scaleActionsGroup, SWT.NONE );
    postScaleLabel.setText( "Post-Scale" ); //$NON-NLS-1$
    gData = new GridData( GridData.FILL_VERTICAL );
    postScaleLabel.setLayoutData( gData );
    
    this.postScaleText = new Text( scaleActionsGroup, SWT.BORDER );
    gData = new GridData( GridData.FILL_BOTH );
    this.postScaleText.setLayoutData( gData);
    this.postScaleText.addModifyListener( new ModifyListener() {
      
      @Override
      public void modifyText( ModifyEvent e ) {
        ElasticityStrategyDialog.this.postScaleAction = ElasticityStrategyDialog.this.postScaleText.getText();
      }
    } );
    
    this.postScaleBtn = new Button( scaleActionsGroup, SWT.PUSH );
    this.postScaleBtn.setImage( imageAdd );
    gData = new GridData();
    this.postScaleBtn.setLayoutData( gData );
    this.postScaleBtn.addSelectionListener( new SelectionListener() {
      
      @Override
      public void widgetSelected( final SelectionEvent e ) {
        handleSelectScaleAction( parent, "Post-", ElasticityStrategyDialog.this.postScaleText ); //$NON-NLS-1$
      }
      
      @Override
      public void widgetDefaultSelected( final SelectionEvent e ) {
        // Do Nothing
      }
    } );
    
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
  
  /**
   * @return The Pre-Scale elasticity action script
   */
  public String getPreScaleAction(){
    return this.preScaleAction;
  }
  
  /**
   * @return The Post-Scale elasticity action script
   */
  public String getPostScaleAction() {
    return this.postScaleAction;
  }
  
  protected void handleSelectScaleAction( final Composite composite,
                                          final String action,
                                          final Text text )
  {
    ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog( composite.getShell(),
                                                                        new WorkbenchLabelProvider(),
                                                                        new BaseWorkbenchContentProvider() );
    dialog.setTitle( action + "Scale Action Selection" ); //$NON-NLS-1$
    dialog.setMessage( "Select the scale script:" ); //$NON-NLS-1$
    dialog.setInput( ResourcesPlugin.getWorkspace().getRoot() );
    if( dialog.open() == IDialogConstants.OK_ID ) {
      IResource resource = ( IResource )dialog.getFirstResult();
      String name = resource.getName();
      text.setText( name );
    }
  }
  
  @Override
  protected void okPressed() {
    if( !( this.cmbMetric.getText().equals( "" ) ) ) { //$NON-NLS-1$
      ElasticityStrategyDialog.this.elasticityStrategy = this.cmbStrategy.getText()
                                                         + " (" //$NON-NLS-1$
                                                         + this.cmbMetric.getText()
                                                         + ")"; //$NON-NLS-1$
    } else {
      //ElasticityStrategyDialog.this.elasticityStrategy = this.cmbElasticityAction.getText();
      ElasticityStrategyDialog.this.elasticityStrategy = this.cmbElasticityAction.getText()
          + " (" //$NON-NLS-1$
          + this.nodeName
          + ")"; //$NON-NLS-1$
    }
    super.okPressed();
  }
}
