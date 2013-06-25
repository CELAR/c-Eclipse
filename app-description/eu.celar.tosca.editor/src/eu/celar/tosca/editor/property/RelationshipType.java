package eu.celar.tosca.editor.property;

import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class RelationshipType extends GFPropertySection implements ITabbedPropertyConstants {

  private CCombo cmbRelationshipType;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);

    FormData data;
    // Combo - RelationshipType
    this.cmbRelationshipType = new CCombo( composite, SWT.BORDER );
    this.cmbRelationshipType.setEnabled( true );
    this.cmbRelationshipType.add( "Master - Slave" );
    this.cmbRelationshipType.add( "Peer - Peer" );
    this.cmbRelationshipType.add( "Producer - Consumer" );
    this.cmbRelationshipType.setEditable( false );
    data = new FormData();
    data.left = new FormAttachment( 0, STANDARD_LABEL_WIDTH + 60 );
    data.right = new FormAttachment( 40, 0 );
    data.top = new FormAttachment( 0, VSPACE );
    this.cmbRelationshipType.setLayoutData( data );

    // RelationshipType Label
    CLabel valueLabel = factory.createCLabel( composite,
                                              "Relationship Type:" ); //$NON-NLS-1$
    data = new FormData();
    data.left = new FormAttachment( 0, 0 );
    data.right = new FormAttachment( this.cmbRelationshipType, -HSPACE );
    data.top = new FormAttachment( this.cmbRelationshipType, 0, SWT.CENTER );
    valueLabel.setLayoutData( data );

    }

    @Override
    public void refresh() {

    }
}

