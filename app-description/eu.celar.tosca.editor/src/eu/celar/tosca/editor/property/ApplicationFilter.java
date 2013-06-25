package eu.celar.tosca.editor.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

import eu.celar.tosca.TServiceTemplate;


public class ApplicationFilter extends AbstractPropertySectionFilter {


  @Override
  protected boolean accept( PictogramElement pe ) {
    EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
    if( bo instanceof TServiceTemplate ) {
            return true;
        }
        return false;
  }
}
