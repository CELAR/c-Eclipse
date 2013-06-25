/*******************************************************************************
 * <copyright> Copyright (c) 2005, 2010 SAP AG. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: SAP AG -
 * initial API, implementation and documentation </copyright>
 *******************************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class MoveApplicationComponentFeature extends DefaultMoveShapeFeature {

  public MoveApplicationComponentFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  @Override
  public boolean canMoveShape( final IMoveShapeContext context ) {
    boolean canMove = super.canMoveShape( context );
    Shape shape = context.getShape();
    Object bo = getBusinessObjectForPictogramElement( shape );
    if( bo instanceof EClass ) {
      canMove = true;
    }
    // perform further check only if move allowed by default feature
    // if (canMove) {
    // // don't allow move if the class name has the length of 1
    // Shape shape = context.getShape();
    // Object bo = getBusinessObjectForPictogramElement(shape);
    // if (bo instanceof EClass) {
    // EClass c = (EClass) bo;
    // if (c.getName() != null && c.getName().length() == 1) {
    // canMove = false;
    // }
    // }
    // }
    return canMove;
  }
}
