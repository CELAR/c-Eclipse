/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
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

/**
 * @author Nicholas Loulloudes
 *
 */
public class CreateServiceTemplateFeature extends AbstractCreateFeature {
  

  private Object contextObject = null;

  /**
   * @param fp
   */
  public CreateServiceTemplateFeature( final IFeatureProvider fp )
  {
    super( fp, "Service Template", "Add a Service Template"); //$NON-NLS-1$ //$NON-NLS-2$
  }
  
  /**
   * @param obj The Context Object
   */
  public void setContextObject (final Object obj)
  {
    this.contextObject  = obj;
  }

  /* (non-Javadoc)
   * @see org.eclipse.graphiti.func.ICreate#canCreate(org.eclipse.graphiti.features.context.ICreateContext)
   */
  @Override
  public boolean canCreate( final ICreateContext context ) {
    if (context.getTargetContainer() instanceof Diagram)
      return true;

    return false;
  }

  /* (non-Javadoc)
   * @see org.eclipse.graphiti.func.ICreate#create(org.eclipse.graphiti.features.context.ICreateContext)
   */
  @Override
  public Object[] create( final ICreateContext context ) {    
    TServiceTemplate tService = ToscaFactory.eINSTANCE.createTServiceTemplate();
    
      // Add model element to resource.
      // We add the model element to the resource of the diagram for
      // simplicity's sake. Normally, a customer would use its own
      // model persistence layer for storing the business model separately.
      ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );      
      model.getDocumentRoot().getDefinitions().getServiceTemplate().add( tService );
      
      // do the add
      addGraphicalRepresentation( context, tService );
      // activate direct editing after object creation
      getFeatureProvider().getDirectEditingInfo().setActive( true );
      
    // return newly created business object(s)
    return new Object[] { tService };
  }  
}
