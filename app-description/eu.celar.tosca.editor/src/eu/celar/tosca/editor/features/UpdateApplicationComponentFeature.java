/*******************************************************************************
 * <copyright> Copyright (c) 2005, 2010 SAP AG. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: SAP AG -
 * initial API, implementation and documentation </copyright>
 *******************************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import eu.celar.tosca.TNodeTemplate;

public class UpdateApplicationComponentFeature extends AbstractUpdateFeature {

  public UpdateApplicationComponentFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  @Override
  public boolean canUpdate( final IUpdateContext context ) {
    // return true, if linked business object is an EClass
    Object bo = getBusinessObjectForPictogramElement( context.getPictogramElement() );
    return ( bo instanceof TNodeTemplate );
  }

  @Override
  public IReason updateNeeded( final IUpdateContext context ) {
    // retrieve name from pictogram model
    String pictogramName = null;
    PictogramElement pictogramElement = context.getPictogramElement();
    if( pictogramElement instanceof ContainerShape ) {
      ContainerShape cs = ( ContainerShape )pictogramElement;
      for( Shape shape : cs.getChildren() ) {
        if( shape.getGraphicsAlgorithm() instanceof Text ) {
          Text text = ( Text )shape.getGraphicsAlgorithm();
          pictogramName = text.getValue();
        }
      }
    }
    // retrieve name from business model
    String businessName = null;
    Object bo = getBusinessObjectForPictogramElement( pictogramElement );
    TNodeTemplate tNode = ( TNodeTemplate )bo;
    businessName = tNode.getName();
    // update needed, if names are different
    boolean updateNameNeeded = ( ( pictogramName == null && businessName != null ) || ( pictogramName != null && !pictogramName.equals( businessName ) ) );
    if( updateNameNeeded ) {
      return Reason.createTrueReason( "Name is out of date" ); //$NON-NLS-1$
    } else {
      return Reason.createFalseReason();
    }
  }

  @Override
  public boolean update( final IUpdateContext context ) {
    // retrieve name from business model
    String businessName = null;
    PictogramElement pictogramElement = context.getPictogramElement();
    Object bo = getBusinessObjectForPictogramElement( pictogramElement );
    TNodeTemplate tNode = ( TNodeTemplate )bo;
    businessName = tNode.getName();
    // Set name in pictogram model
    if( pictogramElement instanceof ContainerShape ) {
      ContainerShape cs = ( ContainerShape )pictogramElement;
      for( Shape shape : cs.getChildren() ) {
        if( shape.getGraphicsAlgorithm() instanceof Text ) {
          Text text = ( Text )shape.getGraphicsAlgorithm();
          text.setValue( businessName );
          return true;
        }
      }
    }
    return false;
  }
}
