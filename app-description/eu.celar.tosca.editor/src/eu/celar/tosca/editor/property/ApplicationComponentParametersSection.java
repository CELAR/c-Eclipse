/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.property;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

// Application Component Properties - Parameters Tab
public class ApplicationComponentParametersSection extends GFPropertySection
  implements ITabbedPropertyConstants
{

  Section sectionInput;
  Section sectionOutput;
  private Table tableInputParameters;
  private Button removeInput;
  private Button addInput;
  TableViewer tableInputParametersViewer;
  private Table tableOutputParameters;
  private Button removeOutput;
  private Button addOutput;
  TableViewer tableOutputParametersViewer;
  List<String> appComponentInputParameters = new ArrayList<String>();
  List<String> appComponentOutputParameters = new ArrayList<String>();

  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    // TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    // Application Component Input Parameters Section
    this.sectionInput = toolkit.createSection( parent, Section.TITLE_BAR );
    this.sectionInput.setText( "Input Parameters" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( sectionInput, SWT.WRAP );
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
    this.tableInputParameters = new Table( client1, SWT.BORDER
                                                    | SWT.VIRTUAL
                                                    | SWT.MULTI
                                                    | SWT.FULL_SELECTION );
    this.tableInputParameters.setHeaderVisible( true );
    this.tableInputParameters.setLinesVisible( false );
    this.tableInputParameters.getHorizontalBar().setEnabled( false );
    gd = new GridData( 300, this.tableInputParameters.getItemHeight() * 4 );
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    this.tableInputParameters.setLayoutData( gd );
    TableLayout tableLayout = new TableLayout();
    this.tableInputParameters.setLayout( tableLayout );
    TableColumn nameColumn = new TableColumn( this.tableInputParameters,
                                              SWT.CENTER );
    nameColumn.setText( "Name" ); //$NON-NLS-1$
    nameColumn.setWidth( 200 );
    ColumnLayoutData data = new ColumnWeightData( 200 );
    tableLayout.addColumnData( data );
    // Input Add Button
    this.addInput = new Button( client2, SWT.PUSH );
    this.addInput.setText( "Add" ); //$NON-NLS-1$
    this.addInput.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        addNewInputParameter( getSelectedInputParameter() );
      }

      @Override
      public void widgetDefaultSelected( SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    gd = new GridData();
    gd.widthHint = 60;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.addInput.setLayoutData( gd );
    // Input Remove Button
    this.removeInput = new Button( client2, SWT.PUSH );
    this.removeInput.setText( "Remove" ); //$NON-NLS-1$
    this.removeInput.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        removeInputParameter( getSelectedInputParameter() );
      }

      @Override
      public void widgetDefaultSelected( SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    gd = new GridData();
    gd.widthHint = 60;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.removeInput.setLayoutData( gd );
    // Add section components to the toolkit
    toolkit.adapt( this.tableInputParameters, true, true );
    toolkit.adapt( this.addInput, true, true );
    toolkit.adapt( this.removeInput, true, true );
    sectionInput.setClient( client );
    // Application Component Output Parameters Section
    this.sectionOutput = toolkit.createSection( parent, Section.TITLE_BAR );
    this.sectionOutput.setText( "Output Parameters" ); //$NON-NLS-1$
    Composite clientRA = toolkit.createComposite( sectionOutput, SWT.WRAP );
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
    this.tableOutputParameters = new Table( clientRA1, SWT.BORDER
                                                       | SWT.VIRTUAL
                                                       | SWT.MULTI
                                                       | SWT.FULL_SELECTION );
    this.tableOutputParameters.setHeaderVisible( true );
    this.tableOutputParameters.setLinesVisible( false );
    this.tableOutputParameters.getHorizontalBar().setEnabled( false );
    GridData gdRA;
    gdRA = new GridData( 300, this.tableOutputParameters.getItemHeight() * 4 );
    gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdRA.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    this.tableOutputParameters.setLayoutData( gdRA );
    TableLayout tableLayoutRA = new TableLayout();
    this.tableOutputParameters.setLayout( tableLayoutRA );
    TableColumn nameColumnRA = new TableColumn( this.tableOutputParameters,
                                                SWT.CENTER );
    nameColumnRA.setText( "Name" ); //$NON-NLS-1$
    nameColumnRA.setWidth( 200 );
    ColumnWeightData dataRA = new ColumnWeightData( 200 );
    tableLayoutRA.addColumnData( dataRA );
    // Output Add Button
    this.addOutput = new Button( clientRA2, SWT.PUSH );
    this.addOutput.setText( "Add" ); //$NON-NLS-1$
    this.addOutput.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
      }

      @Override
      public void widgetDefaultSelected( SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    gdRA = new GridData();
    gdRA.widthHint = 60;
    gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.addOutput.setLayoutData( gdRA );
    // Output Remove Button
    this.removeOutput = new Button( clientRA2, SWT.PUSH );
    this.removeOutput.setText( "Remove" ); //$NON-NLS-1$
    this.removeOutput.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        removeOutputParameter( getSelectedOutputParameter() );
      }

      @Override
      public void widgetDefaultSelected( SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    gdRA = new GridData();
    gdRA.widthHint = 60;
    gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.removeOutput.setLayoutData( gdRA );
    // Add section components to the toolkit
    toolkit.adapt( this.tableOutputParameters, true, true );
    toolkit.adapt( this.addOutput, true, true );
    toolkit.adapt( this.removeOutput, true, true );
    sectionOutput.setClient( clientRA );
  }

  // Add new Input Parameter to table
  TableItem addNewInputParameter( final String selectedObject ) {
    TableItem item = new TableItem( this.tableInputParameters, SWT.NONE );
    this.tableInputParameters.setSelection( item );
    return item;
  }

  // Removes Input Parameter from TOSCA
  void removeInputParameter( final String selectedObject ) {
  }

  // Removes Output Parameter from TOSCA
  void removeOutputParameter( final String selectedObject ) {
  }

  // Return the selected Input Parameter
  String getSelectedInputParameter() {
    String result = null;
    IStructuredSelection selection = ( IStructuredSelection )this.tableInputParametersViewer.getSelection();
    Object obj = selection.getFirstElement();
    result = ( String )obj;
    return result;
  }

  // Return the selected Output Parameter
  String getSelectedOutputParameter() {
    String result = null;
    IStructuredSelection selection = ( IStructuredSelection )this.tableOutputParametersViewer.getSelection();
    Object obj = selection.getFirstElement();
    result = ( String )obj;
    return result;
  }

  // Refresh Tab
  @Override
  public void refresh() {
  }
}
