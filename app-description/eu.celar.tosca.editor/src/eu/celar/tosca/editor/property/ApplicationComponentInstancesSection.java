package eu.celar.tosca.editor.property;

import java.math.BigInteger;

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

public class ApplicationComponentInstancesSection extends GFPropertySection implements ITabbedPropertyConstants, ModifyListener {

	private Text minInstancesText;
	private Text maxInstancesText;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		CLabel valueLabelInstances = factory.createCLabel(composite, "Num of Instances"); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        //data.right = new FormAttachment(nameText, -HSPACE);
        //data.top = new FormAttachment(nameText, 0, SWT.CENTER);
        valueLabelInstances.setLayoutData(data);
        
        		
        minInstancesText = factory.createText(composite, ""); //$NON-NLS-1$
        minInstancesText.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH + 60);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(valueLabelInstances, 0, SWT.BOTTOM);
		minInstancesText.setLayoutData(data);
		minInstancesText.setText( "1" );
		minInstancesText.addModifyListener(this);

		CLabel valueLabel = factory.createCLabel(composite, "Min:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(10, 0);
		//data.right = new FormAttachment(nameText, -HSPACE);
		data.top = new FormAttachment(valueLabelInstances, 0, SWT.BOTTOM);
		valueLabel.setLayoutData(data);
		

	    CLabel valueLabel2 = factory.createCLabel(composite, "Max:"); //$NON-NLS-1$
	    data = new FormData();
	    data.left = new FormAttachment(minInstancesText);
	    //data.right = new FormAttachment(nameText, 20);
	    data.top = new FormAttachment(valueLabelInstances, 0, SWT.BOTTOM);
	    valueLabel2.setLayoutData(data);
	    
	    maxInstancesText = factory.createText(composite, ""); //$NON-NLS-1$
	    maxInstancesText.setEditable(true);
        data = new FormData();
        data.left = new FormAttachment(valueLabel2);
        data.right = new FormAttachment(40, 3);
        data.top = new FormAttachment(valueLabelInstances, 0, SWT.BOTTOM);
        maxInstancesText.setLayoutData(data);
        maxInstancesText.setText( "1" );
        maxInstancesText.addModifyListener(this);
	}

	@Override
	public void refresh() {
	  
	  PictogramElement pe = getSelectedPictogramElement();
      if (pe != null) {
          Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
          // the filter assured, that it is a EClass
          if (bo == null)
              return;
          
          String minInstances = ((Integer) ((TNodeTemplate) bo).getMinInstances()).toString();
          String maxInstances = (((TNodeTemplate) bo).getMaxInstances()).toString();
          
          if (minInstances.compareTo( "1" )==0 && maxInstances.compareTo( "1" )==0){
            return;
          }
          
          minInstancesText.setText(minInstances); //$NON-NLS-1$
          maxInstancesText.setText(maxInstances); //$NON-NLS-1$
      }

	}

	@Override
	public void modifyText(ModifyEvent e) {
		 PictogramElement pe = getSelectedPictogramElement();
		 if (pe != null) {
		 Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		 // the filter assured, that it is a EClass
		 if (bo == null)
		   return;
		
		 final TNodeTemplate nodeTemplate = (TNodeTemplate) bo;
		 
		 if( e.widget == this.minInstancesText ){
		   TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
	        editingDomain.getCommandStack().execute( new RecordingCommand(editingDomain) {
	         protected void doExecute(){
	           nodeTemplate.setMinInstances(Integer.parseInt(minInstancesText.getText()));
	           }
	        });
		   
		 }
		
		 else if( e.widget == this.maxInstancesText ){
		   TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
           editingDomain.getCommandStack().execute( new RecordingCommand(editingDomain) {
            protected void doExecute(){
              nodeTemplate.setMaxInstances((BigInteger) BigInteger.valueOf( Integer.parseInt(maxInstancesText.getText())));
              }
           });
		   
		 }
		
		 }
	}
}

