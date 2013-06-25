package eu.celar.tosca.editor.property;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.celar.tosca.TNodeTemplate;

public class ApplicationComponentNameSection extends GFPropertySection implements ITabbedPropertyConstants, ModifyListener {

	private Text nameText;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

		Composite composite = factory.createFlatFormComposite(parent);
		FormData data;

		nameText = factory.createText(composite, ""); //$NON-NLS-1$
		nameText.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH + 60);
		data.right = new FormAttachment(40, 0);
		data.top = new FormAttachment(0, VSPACE);
		nameText.setLayoutData(data);
		nameText.addModifyListener(this);

		CLabel valueLabel = factory.createCLabel(composite, "Name:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(nameText, -HSPACE);
		data.top = new FormAttachment(nameText, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);

	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a EClass
			if (bo == null || ((TNodeTemplate) bo).getName()==null)
				return;
			
			String name = ((TNodeTemplate) bo).getName();
	        nameText.setText(name == null ? "" : name); //$NON-NLS-1$
		}
	}

	@Override
	public void modifyText(ModifyEvent e) {
		 PictogramElement pe = getSelectedPictogramElement();
		 
		 if (pe != null) {
    		 final Object bo =
    		 Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
    		 // the filter assured, that it is a TNodeTemplate
		 if (bo == null)
		   return;
				
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
		editingDomain.getCommandStack().execute( new RecordingCommand(editingDomain) {
		 protected void doExecute(){
		     ((TNodeTemplate) bo).setName(nameText.getText());
		   }
		});
		 		
		 }
	}
}
