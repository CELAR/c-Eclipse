package eu.celar.tosca.editor.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

import eu.celar.tosca.TRelationshipTemplate;

/**
 * Filters out all other object than {@link EReference}s that get selected in
 * the {@link DiagramEditor} for displaying properties.
 */
public class RelationshipFilter extends AbstractPropertySectionFilter {

	@Override
	protected boolean accept(PictogramElement pe) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		if (bo instanceof TRelationshipTemplate) {
			return true;
		}
		return false;
	}
}
