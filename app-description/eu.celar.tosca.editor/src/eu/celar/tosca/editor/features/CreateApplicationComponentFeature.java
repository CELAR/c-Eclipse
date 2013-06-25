/*******************************************************************************
 * <copyright> Copyright (c) 2005, 2010 SAP AG. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: SAP AG -
 * initial API, implementation and documentation </copyright>
 *******************************************************************************/
package eu.celar.tosca.editor.features;


import java.math.BigInteger;

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
import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;

public class CreateApplicationComponentFeature extends AbstractCreateFeature {

  public CreateApplicationComponentFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Application Component", "Create an Application Component" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  @Override
  public boolean canCreate( final ICreateContext context ) {
    if (context.getTargetContainer() instanceof Diagram)
      return false;

    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement(context.getTargetContainer());
    if (parentBo instanceof TServiceTemplate) {
      return true;
    }

    return false;
  }

  @Override
  public Object[] create( final ICreateContext context ) {
    
    // create Application Component
    TNodeTemplateExtension newClass = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
    ApplicationComponentElasticityRequirementsType1 reqList = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createApplicationComponentElasticityRequirementsType1();
    newClass.setApplicationComponentElasticityRequirements( reqList );
    
    //initialize Application Component
    newClass.setMinInstances(Integer.parseInt("1"));
    newClass.setMaxInstances((BigInteger) BigInteger.valueOf( Integer.parseInt("1")));
    
    newClass.setId( ((Integer) newClass.hashCode()).toString() );
    
    // Add model element to resource.
    // We add the model element to the resource of the diagram for
    // simplicity's sake. Normally, a customer would use its own
    // model persistence layer for storing the business model separately.
    getDiagram().eResource().getContents().add( newClass );

    //      Use the following instead of the above line to store the model
    //      data in a seperate file parallel to the diagram file
    //      try {
    //          try {
    //              TutorialUtil.saveToModelFile(newClass, getDiagram());
    //          } catch (IOException e) {
    //              e.printStackTrace();
    //          }
    //      } catch (CoreException e) {
    //          e.printStackTrace();
    //      }
    
    //create the node template
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    
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
    addGraphicalRepresentation(context, newClass);

    // activate direct editing after object creation
    getFeatureProvider().getDirectEditingInfo().setActive(true);
    // return newly created business object(s)
    return new Object[] { newClass };

  }
}
