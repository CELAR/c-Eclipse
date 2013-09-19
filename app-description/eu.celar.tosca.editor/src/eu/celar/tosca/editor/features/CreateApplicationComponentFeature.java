/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.TTopologyTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;

public class CreateApplicationComponentFeature extends AbstractCreateFeature {

  public CreateApplicationComponentFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Application Component", "Create an Application Component" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  // Checks if user can create an application component object in the target
  // business object
  @Override
  public boolean canCreate( final ICreateContext context ) {
    if( context.getTargetContainer() instanceof Diagram )
      return false;
    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    if( parentBo instanceof TServiceTemplate || parentBo instanceof EClass ) {
      return true;
    }
    return false;
  }

  // Creates the business object for the application component
  @Override
  public Object[] create( final ICreateContext context ) {
    // create Application Component
    TNodeTemplateExtension newClass = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
        
    // initialize Application Component
    newClass.setMinInstances( Integer.parseInt( "1" ) );
    newClass.setMaxInstances( ( BigInteger )BigInteger.valueOf( Integer.parseInt( "1" ) ) );
    newClass.setId( ( ( Integer )newClass.hashCode() ).toString() );
    // create the node template
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    model.getDocumentRoot()
      .getDefinitions()
      .getServiceTemplate()
      .get( 0 )
      .getTopologyTemplate()
      .getNodeTemplate()
      .add( newClass );
    Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    TServiceTemplate serviceTemplate = null;
    if( parentObject == null )
      return null;
    if( parentObject instanceof TServiceTemplate ) {
      serviceTemplate = ( TServiceTemplate )parentObject;
    }
    TTopologyTemplate topology = null;
    if( serviceTemplate.getTopologyTemplate() == null ) {
      topology = ToscaFactory.eINSTANCE.createTTopologyTemplate();
      serviceTemplate.setTopologyTemplate( topology );
    } else {
      topology = serviceTemplate.getTopologyTemplate();
    }
    topology.getNodeTemplate().add( newClass );
    // do the add
    addGraphicalRepresentation( context, newClass );
    // activate direct editing after object creation
    getFeatureProvider().getDirectEditingInfo().setActive( true );
    // return newly created business object(s)
    return new Object[]{
      newClass
    };
  }
}
