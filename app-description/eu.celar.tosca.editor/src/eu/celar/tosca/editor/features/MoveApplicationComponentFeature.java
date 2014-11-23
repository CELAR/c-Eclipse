/*******************************************************************************
 * Copyright (c) 2013 CELAR Consortium.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 *   Stalo Sofokleous - initial API and implementation
 *   Nicholas Loulloudes - API and implementation extensions
 *   
 *******************************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;

import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.TTopologyTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;

public class MoveApplicationComponentFeature extends DefaultMoveShapeFeature {

  public MoveApplicationComponentFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  @Override
  public boolean canMoveShape( final IMoveShapeContext context ) {
    
    boolean canMove = super.canMoveShape( context );
    Shape shape = context.getShape();
    Object bo = getBusinessObjectForPictogramElement( shape );
    if( bo instanceof TNodeTemplate ) {
      canMove = true;
    }

    return canMove;
    
  }
  
  @Override
  protected void postMoveShape(IMoveShapeContext context) {
	  
	    
    Shape shape = context.getShape();
    TNodeTemplateExtension applicationComponent = (TNodeTemplateExtension) getBusinessObjectForPictogramElement( shape );
    applicationComponent.setX(context.getX());
    applicationComponent.setY(context.getY());
    
    Object targetObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    
    Object sourceObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getSourceContainer() );
    
    if (targetObject == sourceObject)
      return;
        
    // Move application component to the target composite component
    if (targetObject instanceof TServiceTemplate
             && ( ( TServiceTemplate )targetObject ).getName() == null){

      TServiceTemplate compositeComponent = (TServiceTemplate) targetObject;
      
      //Shape shape = context.getShape();
      //TNodeTemplate applicationComponent = (TNodeTemplate) getBusinessObjectForPictogramElement( shape );
      
      TTopologyTemplate topology = null;
      if( compositeComponent.getTopologyTemplate() == null ) {
        topology = ToscaFactory.eINSTANCE.createTTopologyTemplate();
        compositeComponent.setTopologyTemplate( topology );
      } else {
        topology = compositeComponent.getTopologyTemplate();
      }
      
      topology.getNodeTemplate().add( applicationComponent );
    }
    
    // Move application component from the source composite component to the application service template
    else if (targetObject instanceof TServiceTemplate
        && ( ( TServiceTemplate )targetObject ).getName() != null){
      
      TServiceTemplate applicationServiceTemplate = (TServiceTemplate) targetObject;
      
      //Shape shape = context.getShape();
      //TNodeTemplate applicationComponent = (TNodeTemplate) getBusinessObjectForPictogramElement( shape );
      
      TTopologyTemplate topology = applicationServiceTemplate.getTopologyTemplate();
      
      topology.getNodeTemplate().add( applicationComponent );
      
    }

    
  }
}
