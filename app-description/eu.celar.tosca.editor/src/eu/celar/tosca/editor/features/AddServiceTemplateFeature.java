/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import eu.celar.tosca.TServiceTemplate;

public class AddServiceTemplateFeature extends AbstractAddShapeFeature {

  private static final IColorConstant E_CLASS_TEXT_FOREGROUND = IColorConstant.BLACK;
  private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant( 98,
                                                                              131,
                                                                              167 );
  private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant( 255,
                                                                              250,
                                                                              240 );

  public AddServiceTemplateFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  // Checks whether a Service Template can be added to the target object
  @Override
  public boolean canAdd( final IAddContext context ) {
    boolean result = false;
    if( context.getNewObject() instanceof TServiceTemplate
        && context.getTargetContainer() instanceof Diagram )
    {
      result = true;
    }
    return result;
  }

  // Adds a Service Template figure to the diagram
  @Override
  public PictogramElement add( final IAddContext context ) {
    TServiceTemplate addedClass = ( TServiceTemplate )context.getNewObject();
    Diagram targetDiagram = ( Diagram )context.getTargetContainer();
    // CONTAINER SHAPE WITH ROUNDED RECTANGLE
    IPeCreateService peCreateService = Graphiti.getPeCreateService();
    ContainerShape containerShape = peCreateService.createContainerShape( targetDiagram,
                                                                          true );
    final int width = targetDiagram.getGraphicsAlgorithm().getWidth() - 10;
    final int height = targetDiagram.getGraphicsAlgorithm().getHeight() - 10;
    IGaService gaService = Graphiti.getGaService();
    RoundedRectangle roundedRectangle; 
    {
      // create and set graphics algorithm
      roundedRectangle = gaService.createRoundedRectangle( containerShape, 5, 5 );
      roundedRectangle.setForeground( manageColor( E_CLASS_FOREGROUND ) );
      roundedRectangle.setBackground( manageColor( E_CLASS_BACKGROUND ) );
      roundedRectangle.setLineWidth( 2 );
      gaService.setLocationAndSize( roundedRectangle,
                                    context.getX(),
                                    context.getY(),
                                    width,
                                    height );
      if( addedClass.eResource() == null ) {
        getDiagram().eResource().getContents().add( addedClass );
      }
      // create link and wire it
      link( containerShape, addedClass );
    }
    // SHAPE WITH LINE
    {
      // create shape for line
      Shape shape = peCreateService.createShape( containerShape, false );
      // create and set graphics algorithm
      Polyline polyline = gaService.createPolyline( shape, new int[]{
        0, 20, width, 20
      } );
      polyline.setForeground( manageColor( E_CLASS_FOREGROUND ) );
      polyline.setLineWidth( 2 );
    }
    // SHAPE WITH TEXT
    {
      // create shape for text
      Shape shape = peCreateService.createShape( containerShape, false );
      // create and set text graphics algorithm
      Text text = gaService.createText( shape, addedClass.getName() );
      text.setForeground( manageColor( E_CLASS_TEXT_FOREGROUND ) );
      text.setHorizontalAlignment( Orientation.ALIGNMENT_CENTER );
      // vertical alignment has as default value "center"
      text.setFont( gaService.manageDefaultFont( getDiagram(), false, true ) );
      gaService.setLocationAndSize( text, 0, 0, width, 20 );
      // create link and wire it
      link( shape, addedClass );
    }
    return containerShape;
  }
}
