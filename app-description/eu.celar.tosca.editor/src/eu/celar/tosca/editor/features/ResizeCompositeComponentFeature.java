package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

import eu.celar.tosca.elasticity.TServiceTemplateExtension;


public class ResizeCompositeComponentFeature extends DefaultResizeShapeFeature{

  public ResizeCompositeComponentFeature( IFeatureProvider fp ) {
    super( fp );
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public boolean canResizeShape(IResizeShapeContext context) {

     return true;
    
  }
  
  @Override
  public void resizeShape(IResizeShapeContext context) {
    Shape shape = context.getShape();
    int x = context.getX();
    int y = context.getY();
    
    int width = context.getWidth();
    int height = context.getHeight();

    if (shape.getGraphicsAlgorithm() != null) {
        Graphiti.getGaService().setLocationAndSize(shape.getGraphicsAlgorithm(), x, y, width, height);
    }
    
    layoutPictogramElement(shape);
    
    TServiceTemplateExtension serviceTemplate = (TServiceTemplateExtension) getBusinessObjectForPictogramElement( shape );
    serviceTemplate.setX(x);
    serviceTemplate.setY(y);
    serviceTemplate.setWidth( width );
    serviceTemplate.setHeight( height );
      
  }
}
