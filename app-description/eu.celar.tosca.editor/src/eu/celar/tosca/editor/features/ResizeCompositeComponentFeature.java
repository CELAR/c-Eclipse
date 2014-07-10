package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;


public class ResizeCompositeComponentFeature extends DefaultResizeShapeFeature{

  public ResizeCompositeComponentFeature( IFeatureProvider fp ) {
    super( fp );
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public boolean canResizeShape(IResizeShapeContext context) {

     return true;
    
  }
}
