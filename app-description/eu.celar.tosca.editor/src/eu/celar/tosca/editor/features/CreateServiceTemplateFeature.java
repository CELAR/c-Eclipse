/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;

public class CreateServiceTemplateFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateServiceTemplateFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Service Template", "Add a Service Template" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if a service template business object can be created
  @Override
  public boolean canCreate( final ICreateContext context ) {
    if( context.getTargetContainer() instanceof Diagram )
      return true;
    return false;
  }

  // Creates the business object for the service template
  @Override
  public Object[] create( final ICreateContext context ) {
    TServiceTemplate tService = ToscaFactory.eINSTANCE.createTServiceTemplate();

    // Add object to domain model
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    model.getDocumentRoot()
      .getDefinitions()
      .getServiceTemplate()
      .add( tService );

    // Add object to diagram model
    //getDiagram().eResource().getContents().add(tService);
    
    
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
