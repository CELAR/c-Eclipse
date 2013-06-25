/*******************************************************************************
 * <copyright> Copyright (c) 2005, 2011 SAP AG. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: SAP AG -
 * initial API, implementation and documentation </copyright>
 *******************************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.editor.StyleUtil;

public class AddApplicationComponentFeature extends AbstractAddShapeFeature {

  // the additional size of the invisible rectangle at the right border
  // (this also equals the half width of the anchor to paint there)
  public static final int INVISIBLE_RECT_RIGHT = 6;

  public AddApplicationComponentFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  @Override
  public boolean canAdd( final IAddContext context ) {
    // check if user wants to add a TNodeTemplate
    boolean result = false;
    if( context.getNewObject() instanceof TNodeTemplate ) {
      Object parentObject = getBusinessObjectForPictogramElement( context.getTargetContainer() );
      if( parentObject instanceof TServiceTemplate ) {
        result = true;
      }
    }
    return result;
  }

  @Override
  public PictogramElement add( final IAddContext context ) {
     
    final TNodeTemplate addedClass = (TNodeTemplate) context.getNewObject();

    final ContainerShape targetDiagram = context.getTargetContainer();

    // 1 CONTAINER SHAPE WITH ROUNDED RECTANGLE
    final IPeCreateService peCreateService = Graphiti.getPeCreateService();
    final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

    // 2 check whether the context has a size (e.g. from a create feature)
    // otherwise define a default size for the shape
    // final int width = context.getWidth() <= 0 ? 100 : context.getWidth();
    // final int height = context.getHeight() <= 0 ? 50 :
    // context.getHeight();


    final IGaService gaService = Graphiti.getGaService();
    RoundedRectangle roundedRectangle; // need to access it later
    {
        // 3 create invisible outer rectangle expanded by
        // the width needed for the anchor
        final Rectangle invisibleRectangle = gaService.createInvisibleRectangle(containerShape);
        gaService.setLocationAndSize(invisibleRectangle, context.getX(), context.getY(),
                StyleUtil.APP_COMPONENT_WIDTH + INVISIBLE_RECT_RIGHT, StyleUtil.APP_COMPONENT_HEIGHT);
        
        
        // 4 create and set visible rectangle inside invisible rectangle
        roundedRectangle = gaService.createPlainRoundedRectangle(invisibleRectangle, 5, 5);
        roundedRectangle.setStyle(StyleUtil.getStyleForEClass(getDiagram()));
        gaService.setLocationAndSize(roundedRectangle, 0, 0, StyleUtil.APP_COMPONENT_WIDTH,
                StyleUtil.APP_COMPONENT_HEIGHT);

        // 5 if addedClass has no resource we add it to the resource of the diagram
        // in a real scenario the business model would have its own resource
        if (addedClass.eResource() == null) {
            getDiagram().eResource().getContents().add(addedClass);
        }

        // create link and wire it
        link(containerShape, addedClass);
    }

    // /////////////////////////////////////////////////////////////////////////////////////////

    final Shape shapeSD = peCreateService.createShape(containerShape, false);
    shapeSD.setVisible(false);

    final Rectangle roundedRectangleSD = gaService.createPlainRectangle(shapeSD);
    // 6 final Rectangle roundedRectangleSD =
    // gaService.createPlainRectangle(roundedRectangle);


    roundedRectangleSD.setStyle(StyleUtil.getStyleForEClass(getDiagram()));
    gaService.setLocationAndSize(roundedRectangleSD,
            (StyleUtil.APP_COMPONENT_WIDTH - StyleUtil.SOFT_DEPENDENCIES_COMP_WIDTH) / 2, 40, 50,
            StyleUtil.SOFT_DEPENDENCIES_COMP_INIT_HEIGHT);

    // ///////////////////////////////////////////////////////////////////////////////////////

    // 7 SHAPE WITH LINE
    {
        // create shape for line
        final Shape shape = peCreateService.createShape(containerShape, false);

        // create and set graphics algorithm
        final Polyline polyline = gaService.createPlainPolyline(shape, new int[] { 0, 20,
                StyleUtil.APP_COMPONENT_WIDTH, 20 });
        polyline.setStyle(StyleUtil.getStyleForEClass(getDiagram()));
    }

    // 8 SHAPE WITH TEXT
    {
        // create shape for text
        final Shape shape = peCreateService.createShape(containerShape, false);

        // create and set text graphics algorithm
        final Text text = gaService.createPlainText(shape, addedClass.getName());
        text.setStyle(StyleUtil.getStyleForEClassText(getDiagram()));
        gaService.setLocationAndSize(text, 0, 0, StyleUtil.APP_COMPONENT_WIDTH, 20);

        // create link and wire it
        link(shape, addedClass);

        // provide information to support direct-editing directly
        // after object creation (must be activated additionally)
        final IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
        // set container shape for direct editing after object creation
        directEditingInfo.setMainPictogramElement(containerShape);
        // set shape and graphics algorithm where the editor for
        // direct editing shall be opened after object creation
        directEditingInfo.setPictogramElement(shape);
        directEditingInfo.setGraphicsAlgorithm(text);
    }

    //9  add a chopbox anchor to the shape
    peCreateService.createChopboxAnchor(containerShape);

    // create an additional box relative anchor at middle-right
    final BoxRelativeAnchor boxAnchor = peCreateService.createBoxRelativeAnchor(containerShape);
    boxAnchor.setRelativeWidth(1.0);
    boxAnchor.setRelativeHeight(0.38); // Use golden section

    boxAnchor.setVisible(false);

    // anchor references visible rectangle instead of invisible rectangle
    boxAnchor.setReferencedGraphicsAlgorithm(roundedRectangle);

    // assign a graphics algorithm for the box relative anchor
    final Ellipse ellipse = gaService.createPlainEllipse(boxAnchor);

    // anchor is located on the right border of the visible rectangle
    // and touches the border of the invisible rectangle
    final int w = INVISIBLE_RECT_RIGHT;
    gaService.setLocationAndSize(ellipse, -w, -w, 2 * w, 2 * w);
    ellipse.setStyle(StyleUtil.getStyleForEClass(getDiagram()));

    // call the layout feature
    layoutPictogramElement(containerShape);

    return containerShape;
  }
}
