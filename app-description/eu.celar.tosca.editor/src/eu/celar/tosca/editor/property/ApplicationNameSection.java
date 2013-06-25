package eu.celar.tosca.editor.property;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
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

import eu.celar.tosca.TServiceTemplate;


public class ApplicationNameSection extends GFPropertySection implements ITabbedPropertyConstants {

  private Text nameText;
  private Text optPolicyText;

  @Override
  public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
      super.createControls(parent, tabbedPropertySheetPage);

      TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
      
      FormToolkit toolkit = new FormToolkit(parent.getDisplay());
      Section section = toolkit.createSection(parent, Section.TITLE_BAR);
      section.setText("Application Properties"); //$NON-NLS-1$
      Composite client = toolkit.createComposite(section, SWT.WRAP);
      GridLayout layout = new GridLayout();
      layout.numColumns = 2;
      layout.marginTop = 15;
      layout.verticalSpacing = 15;
      layout.marginWidth = 2;
      layout.marginHeight = 2;
      client.setLayout(layout);
      
      GridData gd;
      
      CLabel valueLabel = factory.createCLabel(client, "Name:"); //$NON-NLS-1$
      gd = new GridData();
      gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
      gd.verticalAlignment=GridData.VERTICAL_ALIGN_CENTER;
      //gd.widthHint=STANDARD_LABEL_WIDTH;
      valueLabel.setLayoutData( gd );
      
      nameText = factory.createText(client, ""); //$NON-NLS-1$
      nameText.setEditable(true);
      gd = new GridData();
      gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
      gd.verticalAlignment=GridData.VERTICAL_ALIGN_CENTER;
      gd.widthHint=140;
      nameText.setLayoutData( gd );
   
      CLabel optPolicyLabel = factory.createCLabel(client, "Optimization Policy:"); //$NON-NLS-1$
      gd = new GridData();
      gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
      gd.verticalAlignment=GridData.VERTICAL_ALIGN_CENTER;
      //gd.widthHint=STANDARD_LABEL_WIDTH;
      optPolicyLabel.setLayoutData( gd );
      
      optPolicyText = factory.createText(client, ""); //$NON-NLS-1$
      optPolicyText.setEditable(true);
      gd = new GridData();
      gd.horizontalAlignment=GridData.HORIZONTAL_ALIGN_BEGINNING;
      gd.verticalAlignment=GridData.VERTICAL_ALIGN_CENTER;
      gd.widthHint=140;
      optPolicyText.setLayoutData( gd );


      toolkit.adapt( valueLabel, true, true );
      toolkit.adapt( nameText, true, true );
      toolkit.adapt( optPolicyLabel, true, true );
      toolkit.adapt( optPolicyText, true, true );
      section.setClient(client);
      
  }

    @Override
    public void refresh() {
      PictogramElement pe = getSelectedPictogramElement();
      if (pe != null) {
          Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
          // the filter assured, that it is a EClass
          if (bo == null)
              return;
          String name = ((TServiceTemplate) bo).getName();
          nameText.setText(name == null ? "" : name); //$NON-NLS-1$
          
          String optPolicy = ((TServiceTemplate) bo).getBoundaryDefinitions().getPolicies().getPolicy().get( 0 ).getName();
          optPolicyText.setText(optPolicy == null ? "" : optPolicy); //$NON-NLS-1$
      }
  }
}
