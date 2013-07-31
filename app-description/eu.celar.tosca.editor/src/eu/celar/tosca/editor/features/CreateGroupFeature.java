/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;

public class CreateGroupFeature extends AbstractCreateFeature {

  public CreateGroupFeature( IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Group", "Create Group" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  // Checks if user can create a group component object in the target
  // business object
  @Override
  public boolean canCreate( ICreateContext context ) {
    // return context.getTargetContainer() instanceof TServiceTemplate;
    return true;
  }

  // Creates the business object for the group component
  @Override
  public Object[] create( ICreateContext context ) {
    // create substitutableNodeType
    TServiceTemplate tService = ToscaFactory.eINSTANCE.createTServiceTemplate();
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    model.getDocumentRoot()
      .getDefinitions()
      .getServiceTemplate()
      .add( tService );
    // do the add
    addGraphicalRepresentation( context, tService );
    // activate direct editing after object creation
    getFeatureProvider().getDirectEditingInfo().setActive( true );
    // return newly created business object(s)
    return new Object[]{
      tService
    };
  }
}
