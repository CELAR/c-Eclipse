package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

import eu.celar.tosca.editor.StyleUtil;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;


public class ResizeApplicationComponentFeature extends DefaultResizeShapeFeature{

  public ResizeApplicationComponentFeature( IFeatureProvider fp ) {
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
    
    //Application Component Width cannot be changed
    int width = StyleUtil.APP_COMPONENT_WIDTH;
    
    int height = context.getHeight();

    if (shape.getGraphicsAlgorithm() != null) {
        Graphiti.getGaService().setLocationAndSize(shape.getGraphicsAlgorithm(), x, y, width, height);
    }

    
    layoutPictogramElement(shape);
    
    TNodeTemplateExtension applicationComponent = (TNodeTemplateExtension) getBusinessObjectForPictogramElement( shape );
    applicationComponent.setX(x);
    applicationComponent.setY(y);
    applicationComponent.setWidth( width );
    applicationComponent.setHeight( height );
    
        
}
}
