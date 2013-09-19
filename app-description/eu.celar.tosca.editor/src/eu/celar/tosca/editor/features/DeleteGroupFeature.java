package eu.celar.tosca.editor.features;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;


public class DeleteGroupFeature extends DefaultDeleteFeature {

  public DeleteGroupFeature( IFeatureProvider fp ) {
    super( fp );
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public void preDelete(IDeleteContext context) {
    
    // Find and delete the substitute TNodeTemplate
    Object deletedObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getPictogramElement() );  
    
    TServiceTemplate deletedServiceTemplate = (TServiceTemplate) deletedObject;
    
    TNodeTemplate substituteNode = null;
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    for (TNodeTemplate tempNodeTemplate : model.getDocumentRoot()
      .getDefinitions()
      .getServiceTemplate()
      .get( 0 )
      .getTopologyTemplate()
      .getNodeTemplate()){
       
      if (tempNodeTemplate.getType() ==  deletedServiceTemplate.getSubstitutableNodeType() )
      {
        substituteNode = tempNodeTemplate;
        break;
      }
    }

    model.getDocumentRoot()
    .getDefinitions()
    .getServiceTemplate()
    .get( 0 )
    .getTopologyTemplate()
    .getNodeTemplate().remove( substituteNode );
    
    
  }
}
