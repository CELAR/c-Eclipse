/************************************************************
 * Copyright (C), 2013 CELAR Consortium 
 * http://www.celarcloud.eu
 * 
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.property;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.celar.tosca.TRelationshipTemplate;

// Relationship Properties - Connection Tab
public class RelationshipGeneralSection extends GFPropertySection
  implements ITabbedPropertyConstants
{

  private Text nameText;
  private CCombo cmbRelationshipType;

  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    Section section = toolkit.createSection( parent, Section.TITLE_BAR );
    section.setText( "Relationship Properties" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( section, SWT.WRAP );
    GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    layout.marginTop = 15;
    layout.verticalSpacing = 15;
    layout.marginWidth = 2;
    layout.marginHeight = 2;
    client.setLayout( layout );
    GridData gd;
    // Relationship Name
    CLabel valueLabel = factory.createCLabel( client, "Name:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    valueLabel.setLayoutData( gd );
    // Text - Relationship Type
    this.nameText = factory.createText( client, "" ); //$NON-NLS-1$
    this.nameText.setEditable( true );
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 140;
    this.nameText.setLayoutData( gd );
    // Relationship Type
    CLabel relationshipTypeLabel = factory.createCLabel( client,
                                                         "Relationship Type:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    relationshipTypeLabel.setLayoutData( gd );
    // Combo - Relationship Type
    this.cmbRelationshipType = new CCombo( client, SWT.BORDER );
    this.cmbRelationshipType.setEnabled( true );
    this.cmbRelationshipType.add( "Master - Slave" ); //$NON-NLS-1$
    this.cmbRelationshipType.add( "Peer - Peer" ); //$NON-NLS-1$
    this.cmbRelationshipType.add( "Producer - Consumer" ); //$NON-NLS-1$
    this.cmbRelationshipType.setEditable( false );
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 140;
    this.cmbRelationshipType.setLayoutData( gd );
    // Add section components to the toolkit
    toolkit.adapt( valueLabel, true, true );
    toolkit.adapt( this.nameText, true, true );
    toolkit.adapt( relationshipTypeLabel, true, true );
    toolkit.adapt( this.cmbRelationshipType, true, true );
    section.setClient( client );
  }

  // Refresh Tab
  @Override
  public void refresh() {
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      if( bo == null )
        return;
      String name = ( ( TRelationshipTemplate )bo ).getName();
      this.nameText.setText( name == null
                                    ? "" : name ); //$NON-NLS-1$
    }
  }
}
