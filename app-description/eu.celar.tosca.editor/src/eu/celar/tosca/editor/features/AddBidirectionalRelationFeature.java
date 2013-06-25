package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import eu.celar.tosca.TRelationshipTemplate;
import eu.celar.tosca.editor.StyleUtil;


public class AddBidirectionalRelationFeature extends AbstractAddFeature {

  public AddBidirectionalRelationFeature( IFeatureProvider fp ) {
    super( fp );
  }

  @Override
  public boolean canAdd( IAddContext context ) {
    // return true if given business object is a TRelationshipType
    // note, that the context must be an instance of IAddConnectionContext
    if( context instanceof IAddConnectionContext
        && context.getNewObject() instanceof TRelationshipTemplate )
    {
      return true;
    }
    return false;
  }

  @Override
  public PictogramElement add( IAddContext context ) {
    IAddConnectionContext addConContext = ( IAddConnectionContext )context;
    TRelationshipTemplate addedEReference = ( TRelationshipTemplate )context.getNewObject();
    IPeCreateService peCreateService = Graphiti.getPeCreateService();
    
    // CONNECTION WITH POLYLINE
    Connection connection = peCreateService.createFreeFormConnection( getDiagram() );
    connection.setStart( addConContext.getSourceAnchor() );
    connection.setEnd( addConContext.getTargetAnchor() );
    IGaService gaService = Graphiti.getGaService();
    Polyline polyline = gaService.createPlainPolyline( connection );
    polyline.setStyle( StyleUtil.getStyleForEClass( getDiagram() ) );
    
    // create link and wire it
    link( connection, addedEReference );
    
    // add dynamic text decorator for the reference name
    ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator( connection,
                                                                                   true,
                                                                                   0.5,
                                                                                   true );
    Text text = gaService.createPlainText( textDecorator );
    text.setStyle( StyleUtil.getStyleForTextDecorator( ( getDiagram() ) ) );
    gaService.setLocation( text, 10, 0 );
    
    // set reference name in the text decorator
    TRelationshipTemplate eReference = ( TRelationshipTemplate )context.getNewObject();
    text.setValue( eReference.getName() );
    // add static graphical decorators (composition and navigable)
    ConnectionDecorator cd;
    cd = peCreateService.createConnectionDecorator( connection,
                                                    false,
                                                    1.0,
                                                    true );
    createArrow( cd );
    ConnectionDecorator cd2;
    cd2 = peCreateService.createConnectionDecorator( connection, false, 0, true );
    createInverseArrow( cd2 );
    return connection;
  }
  
  private Polyline createArrow( GraphicsAlgorithmContainer gaContainer ) {
    Polyline polyline = Graphiti.getGaCreateService()
      .createPlainPolyline( gaContainer, new int[]{
        -15, 10, 0, 0, -15, -10
      } );
    polyline.setStyle( StyleUtil.getStyleForEClass( getDiagram() ) );
    return polyline;
  }
  
  private Polyline createInverseArrow( GraphicsAlgorithmContainer gaContainer ) {
    Polyline polyline = Graphiti.getGaCreateService()
      .createPlainPolyline( gaContainer, new int[]{
        -15, -10, 0, 0, -15, 10
      } );
    polyline.setStyle( StyleUtil.getStyleForEClass( getDiagram() ) );
    return polyline;
  }
}
