/*******************************************************************************
 * <copyright> Copyright (c) 2005, 2010 SAP AG. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: SAP AG -
 * initial API, implementation and documentation </copyright>
 *******************************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;

import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.elasticity.TServiceTemplateExtension;

//Tests whether a service template can be moved
public class MoveCompositeComponentFeature extends DefaultMoveShapeFeature {

  public MoveCompositeComponentFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  @Override
  public boolean canMoveShape( final IMoveShapeContext context ) {
    
    boolean canMove = super.canMoveShape( context );
    Shape shape = context.getShape();
    Object bo = getBusinessObjectForPictogramElement( shape );
    if( bo instanceof TServiceTemplate ) {
      if (((TServiceTemplate) bo).getSubstitutableNodeType() != null && ((TServiceTemplate) bo).getSubstitutableNodeType().toString().equals( "substituteNode" )){
        //it is a Group feature
        canMove = true;
      }else{
        //it is the application service
        canMove = false;
      }
    }

    return canMove;
    
  }
  
  @Override
  protected void postMoveShape(IMoveShapeContext context) {
              
    Shape shape = context.getShape();
    TServiceTemplateExtension groupComponent = (TServiceTemplateExtension) getBusinessObjectForPictogramElement( shape );
    groupComponent.setX(context.getX());
    groupComponent.setY(context.getY());


  }
}
