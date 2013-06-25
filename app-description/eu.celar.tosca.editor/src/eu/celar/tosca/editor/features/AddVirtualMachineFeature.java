/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.emf.ecore.EClass;
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

import eu.celar.infosystem.model.base.VirtualMachineImage;
import eu.celar.tosca.editor.StyleUtil;

/**
 * @author Nicholas Loulloudes
 */
public class AddVirtualMachineFeature extends AbstractAddShapeFeature {

  private static final IColorConstant E_CLASS_TEXT_FOREGROUND = IColorConstant.BLACK;
  private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant( 98,
                                                                              131,
                                                                              167 );
  private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant( 32,
                                                                              178,
                                                                              170 );

  /**
   * @param fp
   */
  public AddVirtualMachineFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  /*
   * (non-Javadoc)
   * @see
   * org.eclipse.graphiti.func.IAdd#canAdd(org.eclipse.graphiti.features.context
   * .IAddContext)
   */
  @Override
  public boolean canAdd( final IAddContext context ) {
    
//    boolean result = false;
//    if( context.getNewObject() instanceof TDeploymentArtifact ) {
//      Object parentObject = getBusinessObjectForPictogramElement( context.getTargetContainer() );
//      if( parentObject instanceof TNodeTemplate ) {
//        result = true;
//      }
//    }
//    return result;
    
    /**
     * DEMO
     */
    
    boolean result = false;

    boolean diagraminstance = context.getTargetContainer() instanceof Diagram;

    if (context.getNewObject() instanceof VirtualMachineImage && !diagraminstance) {
        result = true;
    }

    return result;
  }

  /*
   * (non-Javadoc)
   * @see
   * org.eclipse.graphiti.func.IAdd#add(org.eclipse.graphiti.features.context
   * .IAddContext)
   */
  @Override
  public PictogramElement add( final IAddContext context ) {
    
//    TDeploymentArtifact artifact = ( TDeploymentArtifact )context.getNewObject();
//    
//    ContainerShape target = context.getTargetContainer();
//    // CONTAINER SHAPE WITH ROUNDED RECTANGLE
//    IPeCreateService peCreateService = Graphiti.getPeCreateService();
//    ContainerShape containerShape = peCreateService.createContainerShape( target,
//                                                                          true );
//    // check whether the context has a size (e.g. from a create feature)
//    // otherwise define a default size for the shape
//    final int width = 200;
//    final int height = 20;
//    IGaService gaService = Graphiti.getGaService();
//    RoundedRectangle roundedRectangle; // need to access it later
//    {
//      // create and set graphics algorithm
//      roundedRectangle = gaService.createRoundedRectangle( containerShape, 5, 5 );
//      roundedRectangle.setForeground( manageColor( E_CLASS_FOREGROUND ) );
//      roundedRectangle.setBackground( manageColor( E_CLASS_BACKGROUND ) );
//      roundedRectangle.setLineWidth( 2 );
//      // gaService.setLocationAndSize(roundedRectangle,
//      // context.getX(), context.getY(), width, height);
//      
//      gaService.setLocationAndSize(roundedRectangle, 0, 180, width, height);
//
//      // if added Class has no resource we add it to the resource
//      // of the diagram
//      // in a real scenario the business model would have its own resource
//      if( artifact.eResource() == null ) {
//        getDiagram().eResource().getContents().add( artifact );
//      }
//      // create link and wire it
//      link( containerShape, artifact );
//    }
//    
//    // SHAPE WITH LINE
//    {
//      // create shape for line
//      Shape shape = peCreateService.createShape( containerShape, false );
//      // create and set graphics algorithm
//      Polyline polyline = gaService.createPolyline( shape, new int[]{
//        0, 20, width, 20
//      } );
//      polyline.setForeground( manageColor( E_CLASS_FOREGROUND ) );
//      polyline.setLineWidth( 2 );
//    }
//    
//    // SHAPE WITH TEXT
//    {
//      // create shape for text
//      Shape shape = peCreateService.createShape( containerShape, false );
//      
//      // create and set text graphics algorithm
//      Text text = gaService.createText( shape, artifact.getName() );
//      text.setForeground( manageColor( E_CLASS_TEXT_FOREGROUND ) );
//      text.setHorizontalAlignment( Orientation.ALIGNMENT_CENTER );
//      
//      // vertical alignment has as default value "center"
//      text.setFont( gaService.manageDefaultFont( getDiagram(), false, true ) );
//      gaService.setLocationAndSize( text, 0, 0, width, 20 );
//      
//      // create link and wire it
//      link( shape, artifact );
//    }
//    return containerShape;
    
    /**
     * DEMO
     */
    
  VirtualMachineImage addedClass = (VirtualMachineImage) context.getNewObject();
  ContainerShape targetDiagram = (ContainerShape) context.getTargetContainer();

  // CONTAINER SHAPE WITH ROUNDED RECTANGLE
  IPeCreateService peCreateService = Graphiti.getPeCreateService();
  ContainerShape containerShape =
       peCreateService.createContainerShape(targetDiagram, true);

  // check whether the context has a size (e.g. from a create feature)
  // otherwise define a default size for the shape
  // final int width = context.getWidth() <= 0 ? 100 : context.getWidth();
  // final int height = context.getHeight() <= 0 ? 50 :
  // context.getHeight();

  final int width = StyleUtil.APP_COMPONENT_WIDTH;
  final int height = 20;

  IGaService gaService = Graphiti.getGaService();
  RoundedRectangle roundedRectangle; // need to access it later

  {
      // create and set graphics algorithm
      roundedRectangle =
          gaService.createRoundedRectangle(containerShape, 5, 5);
      roundedRectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
      roundedRectangle.setBackground(manageColor(E_CLASS_BACKGROUND));
      roundedRectangle.setLineWidth(2);
      // gaService.setLocationAndSize(roundedRectangle,
      // context.getX(), context.getY(), width, height);

        gaService.setLocationAndSize(roundedRectangle,
0, StyleUtil.APP_COMPONENT_HEIGHT-20, width, height);

        // if added Class has no resource we add it to the resource 
      // of the diagram
      // in a real scenario the business model would have its own resource
      if (addedClass.eResource() == null) {
               getDiagram().eResource().getContents().add(addedClass);
      }
      // create link and wire it        
      link(containerShape, addedClass);
  }

  // SHAPE WITH LINE
  {
      // create shape for line
      Shape shape = peCreateService.createShape(containerShape, false);

      // create and set graphics algorithm
      Polyline polyline =
          gaService.createPolyline(shape, new int[] { 0, 20, width, 20 });
      polyline.setForeground(manageColor(E_CLASS_FOREGROUND));
      polyline.setLineWidth(2);
  }

  // SHAPE WITH TEXT
  {
      // create shape for text
      Shape shape = peCreateService.createShape(containerShape, false);
      // create and set text graphics algorithm
      Text text = gaService.createText(shape, addedClass.getName());
      text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
      text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER ); 
      // vertical alignment has as default value "center"
      text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));

      gaService.setLocationAndSize(text, 0, 0, width, 20);

      // create link and wire it
      link(shape, addedClass);
  }

  return containerShape;
  }  
}
