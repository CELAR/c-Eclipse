/************************************************************
 * Copyright (C), 2013 CELAR Consortium 
 * http://www.celarcloud.eu
 * 
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.property;

import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 *  Application Component Properties - Data/Load Tab
 */
public class ApplicationComponentDataHintsSection extends GFPropertySection
  implements ITabbedPropertyConstants
{

  Section sectionDH;
  Section sectionLH;


  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    // Application Component Data Hints Section
    Section section = toolkit.createSection( parent, Section.TITLE_BAR );
    section.setText( "System-Level Requirements" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( section, SWT.WRAP );
    GridLayout layout = new GridLayout();
    layout.numColumns = 4;
    layout.marginTop = 15;
    layout.verticalSpacing = 15;
    layout.marginWidth = 2;
    layout.marginHeight = 2;
    client.setLayout( layout );
  
    GridData gd;
    gd = new GridData();
    CLabel valueLabel1 = factory.createCLabel( client, "" ); //$NON-NLS-1$
    CLabel valueLabel2 = factory.createCLabel( client, "Min" ); //$NON-NLS-1$
    CLabel valueLabel3 = factory.createCLabel( client, "Max" ); //$NON-NLS-1$
    CLabel valueLabel4 = factory.createCLabel( client, "Unit" ); //$NON-NLS-1$
    valueLabel1.setLayoutData( gd );
    valueLabel2.setLayoutData( gd );
    valueLabel3.setLayoutData( gd );
    valueLabel4.setLayoutData( gd );
    toolkit.adapt( valueLabel1, true, true );
    toolkit.adapt( valueLabel2, true, true );
    toolkit.adapt( valueLabel3, true, true );
    toolkit.adapt( valueLabel4, true, true );
    
    CLabel cpuLabel = factory.createCLabel( client, "CPU:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 60;
    cpuLabel.setLayoutData( gd );
    // Minimun num of cpus  text
    Text minCpuText = factory.createText( client, "" ); //$NON-NLS-1$
    minCpuText.setEditable( true );
    
    // Maximum num of cpus  text
    Text maxCpuText = factory.createText( client, "" ); //$NON-NLS-1$
    maxCpuText.setEditable( true );
    
    CLabel coresLabel = factory.createCLabel( client, "vCores" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 60;
    coresLabel.setLayoutData( gd );
    
    // Add section components to the toolkit
    toolkit.adapt( cpuLabel, true, true );
    toolkit.adapt( minCpuText, true, true );
    toolkit.adapt( maxCpuText, true, true );
    toolkit.adapt( coresLabel, true, true );
    
    //RAM
    CLabel ramLabel = factory.createCLabel( client, "RAM:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 60;
    ramLabel.setLayoutData( gd );
    // Minimun num of RAM  text
    Text minRamText = factory.createText( client, "" ); //$NON-NLS-1$
    minRamText.setEditable( true );
    
    // Maximum num of RAM  text
    Text maxRamText = factory.createText( client, "" ); //$NON-NLS-1$
    maxRamText.setEditable( true );
    
    CLabel mbLabel = factory.createCLabel( client, "MB" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 60;
    mbLabel.setLayoutData( gd );
    
    // Add section components to the toolkit
    toolkit.adapt( ramLabel, true, true );
    toolkit.adapt( minRamText, true, true );
    toolkit.adapt( maxRamText, true, true );
    toolkit.adapt( mbLabel, true, true );
    
    //DISK
    CLabel diskLabel = factory.createCLabel( client, "DISK:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 60;
    diskLabel.setLayoutData( gd );
    // Minimun num of disk  text
    Text minDiskText = factory.createText( client, "" ); //$NON-NLS-1$
    minDiskText.setEditable( true );
    
    // Maximum num of disk  text
    Text maxDiskText = factory.createText( client, "" ); //$NON-NLS-1$
    maxDiskText.setEditable( true );
    
    CLabel gbLabel = factory.createCLabel( client, "GB" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 60;
    gbLabel.setLayoutData( gd );
    
    // Add section components to the toolkit
    toolkit.adapt( diskLabel, true, true );
    toolkit.adapt( minDiskText, true, true );
    toolkit.adapt( maxDiskText, true, true );
    toolkit.adapt( gbLabel, true, true );
    
    
    section.setClient( client );
 
  }

  /*
   *  Refresh Tab(non-Javadoc)
   * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
   */
  @Override
  public void refresh() {
  }
}
