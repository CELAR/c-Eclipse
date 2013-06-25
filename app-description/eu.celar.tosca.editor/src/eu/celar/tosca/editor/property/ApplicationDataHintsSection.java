package eu.celar.tosca.editor.property;

import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


public class ApplicationDataHintsSection extends GFPropertySection
implements ITabbedPropertyConstants
{

private CCombo cmbDataHint;
private CCombo cmbLoadHint;

@Override
public void createControls( Composite parent,
                            TabbedPropertySheetPage tabbedPropertySheetPage )
{
  super.createControls( parent, tabbedPropertySheetPage );
  TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
  
  
  FormToolkit toolkit = new FormToolkit(parent.getDisplay());
  Section section = toolkit.createSection(parent, Section.TITLE_BAR);
  section.setText("Data/Load Properties"); //$NON-NLS-1$
  Composite client = toolkit.createComposite(section, SWT.WRAP);
  GridLayout layout = new GridLayout();
  layout.numColumns = 2;
  layout.marginTop = 15;
  layout.verticalSpacing = 15;
  layout.marginWidth = 2;
  layout.marginHeight = 2;
  client.setLayout(layout);
  
  GridData gd;
  
  //Data Hints
  
  CLabel dataHintsLabel = factory.createCLabel(client, "Data Hints:"); //$NON-NLS-1$
  gd = new GridData();
  gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
  gd.verticalAlignment=GridData.VERTICAL_ALIGN_CENTER;
  //gd.widthHint=STANDARD_LABEL_WIDTH;
  dataHintsLabel.setLayoutData( gd );
  
  // Combo - data Hints
 
  this.cmbDataHint = new CCombo( client, SWT.BORDER );
  this.cmbDataHint.setEnabled( true );
  this.cmbDataHint.add( "JSON" );
  this.cmbDataHint.setEditable( false );
  
  gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
  gd.verticalAlignment=GridData.VERTICAL_ALIGN_CENTER;
  gd.widthHint=140;
  this.cmbDataHint.setLayoutData( gd );
  
  
  //Load Hints
  
  CLabel loadHintsLabel = factory.createCLabel(client, "Load Hints:"); //$NON-NLS-1$
  gd = new GridData();
  gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
  gd.verticalAlignment=GridData.VERTICAL_ALIGN_CENTER;
  //gd.widthHint=STANDARD_LABEL_WIDTH;
  loadHintsLabel.setLayoutData( gd );
  
  // Combo - load Hints
 
  this.cmbLoadHint = new CCombo( client, SWT.BORDER );
  this.cmbLoadHint.setEnabled( true );
  this.cmbLoadHint.add( "Write Heavy" );
  this.cmbLoadHint.setEditable( false );
  
  gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
  gd.verticalAlignment=GridData.VERTICAL_ALIGN_CENTER;
  gd.widthHint=140;
  this.cmbLoadHint.setLayoutData( gd );
  
  toolkit.adapt(dataHintsLabel);
  toolkit.adapt(cmbDataHint);
  toolkit.adapt(loadHintsLabel);
  toolkit.adapt(cmbLoadHint);
  
  section.setClient(client);

}

@Override
public void refresh() {

}
}