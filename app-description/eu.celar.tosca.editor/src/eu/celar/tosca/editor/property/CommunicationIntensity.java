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

public class CommunicationIntensity extends GFPropertySection implements ITabbedPropertyConstants {

  private CCombo cmbCommunicationIntensity;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);

    FormData data;
    // Combo - RelationshipType
    this.cmbCommunicationIntensity = new CCombo( composite, SWT.BORDER );
    this.cmbCommunicationIntensity.setEnabled( true );
    this.cmbCommunicationIntensity.add( "Master - Slave" );
    this.cmbCommunicationIntensity.add( "Peer - Peer" );
    this.cmbCommunicationIntensity.add( "Producer - Consumer" );
    this.cmbCommunicationIntensity.setEditable( false );
    data = new FormData();
    data.left = new FormAttachment( 0, STANDARD_LABEL_WIDTH + 60 );
    data.right = new FormAttachment( 40, 0 );
    data.top = new FormAttachment( 0, VSPACE );
    this.cmbCommunicationIntensity.setLayoutData( data );

    // RelationshipType Label
    CLabel valueLabel = factory.createCLabel( composite,
                                              "Communication Intensity:" ); //$NON-NLS-1$
    data = new FormData();
    data.left = new FormAttachment( 0, 0 );
    data.right = new FormAttachment( this.cmbCommunicationIntensity, -HSPACE );
    data.top = new FormAttachment( this.cmbCommunicationIntensity, 0, SWT.CENTER );
    valueLabel.setLayoutData( data );

    }

    @Override
    public void refresh() {

    }
}

