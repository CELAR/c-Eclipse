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
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class ApplicationComponentImageSection extends GFPropertySection implements ITabbedPropertyConstants {

	private Text nameText;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

		Composite composite = factory.createFlatFormComposite(parent);
		FormData data;

		this.nameText = factory.createText(composite, ""); //$NON-NLS-1$
		this.nameText.setEditable(false);
		data = new FormData();
    data.left = new FormAttachment( 0, STANDARD_LABEL_WIDTH + 60 );
    data.right = new FormAttachment( 40, 0 );
		data.top = new FormAttachment(0, VSPACE);
		this.nameText.setLayoutData(data);

		CLabel valueLabel = factory.createCLabel(composite, "Image:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(this.nameText, -HSPACE);
		data.top = new FormAttachment(this.nameText, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);

	}

	@Override
	public void refresh() {
//		PictogramElement pe = getSelectedPictogramElement();
//		if (pe != null) {
//			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
//			// the filter assured, that it is a EClass
//			if (bo == null)
//				return;
//			String name = ((EClass) bo).getInstanceClassName();
//			nameText.setText(name == null ? "" : name); //$NON-NLS-1$
//		}

	}
}

