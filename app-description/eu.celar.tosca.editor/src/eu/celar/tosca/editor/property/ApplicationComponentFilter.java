/************************************************************
 * Copyright (C), 2013 CELAR Consortium 
 * http://www.celarcloud.eu
 * 
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

import eu.celar.tosca.TNodeTemplate;

// Filters out all other object than TNodeTemplate (application component) for
// displaying properties
public class ApplicationComponentFilter extends AbstractPropertySectionFilter {

  @Override
  protected boolean accept( PictogramElement pe ) {
    EObject bo = Graphiti.getLinkService()
      .getBusinessObjectForLinkedPictogramElement( pe );
    if( bo instanceof TNodeTemplate ) {
      return true;
    }
    return false;
  }
}
