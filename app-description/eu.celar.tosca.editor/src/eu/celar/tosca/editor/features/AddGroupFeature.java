/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.editor.StyleUtil;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;

public class AddGroupFeature extends AbstractAddShapeFeature {

  public static final int INVISIBLE_RECT_RIGHT = 6;

  public AddGroupFeature( IFeatureProvider fp ) {
    super( fp );
  }

  // Checks whether a Group figure can be added to the target object
  @Override
  public boolean canAdd( IAddContext context ) {
    return true;
  }

  // Adds a group figure to the target object
  @Override
  public PictogramElement add( IAddContext context ) {
    final TServiceTemplate addedClass = ( TServiceTemplate )context.getNewObject();
    final ContainerShape targetDiagram = context.getTargetContainer();
    // CONTAINER SHAPE WITH ROUNDED RECTANGLE
    final IPeCreateService peCreateService = Graphiti.getPeCreateService();
    final ContainerShape containerShape = peCreateService.createContainerShape( targetDiagram,
                                                                                true );
    final IGaService gaService = Graphiti.getGaService();
    RoundedRectangle roundedRectangle;
    {
      // create invisible outer rectangle expanded by
      // the width needed for the anchor
      final Rectangle invisibleRectangle = gaService.createInvisibleRectangle( containerShape );
      gaService.setLocationAndSize( invisibleRectangle,
                                    context.getX(),
                                    context.getY(),
                                    StyleUtil.APP_COMPONENT_WIDTH
                                        * 3
                                        + INVISIBLE_RECT_RIGHT,
                                    StyleUtil.APP_COMPONENT_WIDTH * 2 );
      // create and set visible rectangle inside invisible rectangle
      roundedRectangle = gaService.createPlainRoundedRectangle( invisibleRectangle,
                                                                5,
                                                                5 );
      // roundedRectangle.setStyle(StyleUtil.getStyleForEClass(getDiagram()));
      roundedRectangle.setBackground( manageColor( new ColorConstant( 255,
                                                                      255,
                                                                      255 ) ) );
      // roundedRectangle.setForeground(manageColor( new ColorConstant( 255,
      // 255, 255 )) );
      roundedRectangle.setLineWidth( 1 );
      gaService.setLocationAndSize( roundedRectangle,
                                    0,
                                    0,
                                    StyleUtil.APP_COMPONENT_WIDTH * 3,
                                    StyleUtil.APP_COMPONENT_WIDTH * 2 );
      // if addedClass has no resource we add it to the resource of the diagram
      // in a real scenario the business model would have its own resource
      if( addedClass.eResource() == null ) {
        getDiagram().eResource().getContents().add( addedClass );
      }
      // create link and wire it
      containerShape.getGraphicsAlgorithm().setX( context.getX() );
      containerShape.getGraphicsAlgorithm().setY( context.getY() );
      link( containerShape, addedClass );
    }
    // call the layout feature
    layoutPictogramElement( containerShape );
    return containerShape;
  }
}
