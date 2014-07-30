/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import javax.xml.namespace.QName;

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

import eu.celar.core.model.impl.ResourceCloudElement;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.StyleUtil;

public class AddKeyPairFeature extends AbstractAddShapeFeature {

  private static final IColorConstant E_CLASS_TEXT_FOREGROUND = IColorConstant.BLACK;
  private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant( 98,
                                                                              131,
                                                                              167 );
  private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant( 255,
                                                                              255,
                                                                              0 );

  public AddKeyPairFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  // Checks whether a KeyPair can be added to the target object
  @Override
  public boolean canAdd( final IAddContext context ) {
    boolean result = false;
    boolean diagraminstance = context.getTargetContainer() instanceof Diagram;

    if( context.getNewObject() instanceof TDeploymentArtifact
        && !diagraminstance )
    {
      if( ( ( TDeploymentArtifact )context.getNewObject() ).getArtifactType()
        .toString()
        .compareTo( "KeyPair" ) == 0 )
        result = true;
    } else if (context.getNewObject() instanceof ResourceCloudElement && !diagraminstance) {
      System.out.println("reseource_element");
      ResourceCloudElement file = (ResourceCloudElement) context.getNewObject();
      if (file.getResource().getFileExtension().equals( "pub" )){
      
        result = true;
      }
        
    } 
    return result;
  }

  // Adds a KeyPair figure to the target object
  @Override
  public PictogramElement add( final IAddContext context ) {
    
    TDeploymentArtifact addedClass;
    if (context.getNewObject() instanceof ResourceCloudElement) {
      ResourceCloudElement ce = (ResourceCloudElement) context.getNewObject();      
      addedClass = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
      addedClass.setName( ce.getName() );
      addedClass.setArtifactType( new QName( "KeyPair" ) );
    } else {
      addedClass = ( TDeploymentArtifact )context.getNewObject();
    }
    
    
    ContainerShape targetDiagram = ( ContainerShape )context.getTargetContainer();
    // CONTAINER SHAPE WITH ROUNDED RECTANGLE
    IPeCreateService peCreateService = Graphiti.getPeCreateService();
    ContainerShape containerShape = peCreateService.createContainerShape( targetDiagram,
                                                                          true );
    final int width = StyleUtil.APP_COMPONENT_WIDTH;
    final int height = 20;
    IGaService gaService = Graphiti.getGaService();
    RoundedRectangle roundedRectangle;
    {
      // create and set graphics algorithm
      roundedRectangle = gaService.createRoundedRectangle( containerShape, 5, 5 );
      roundedRectangle.setForeground( manageColor( E_CLASS_FOREGROUND ) );
      roundedRectangle.setBackground( manageColor( E_CLASS_BACKGROUND ) );
      roundedRectangle.setLineWidth( 2 );
      gaService.setLocationAndSize( roundedRectangle,
                                    0,
                                    StyleUtil.APP_COMPONENT_HEIGHT - 40,
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
    // call the layout feature
    layoutPictogramElement( containerShape );
    return containerShape;
  }
}
