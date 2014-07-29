package eu.celar.tosca.editor.features;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TPolicy;
import eu.celar.tosca.TPolicyTemplate;
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
    
    Object deletedObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getPictogramElement() );
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    TServiceTemplate deletedServiceTemplate = (TServiceTemplate) deletedObject;
    
    // Find the substitute TNodeTemplate
    TNodeTemplate substituteNode = null;

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
    
    // Delete Policy Templates
    TNodeTemplate deletedNodeTemplate = substituteNode;

    for( TPolicy tempPolicy : deletedNodeTemplate.getPolicies().getPolicy() )
      for( TPolicyTemplate tempPolicyTemplate : model.getDocumentRoot()
        .getDefinitions()
        .getPolicyTemplate() )
      {
        if( tempPolicy.getPolicyRef()
          .toString()
          .compareTo( tempPolicyTemplate.getId() ) == 0 )
        {
          model.getDocumentRoot()
            .getDefinitions()
            .getPolicyTemplate()
            .remove( tempPolicyTemplate );
        }
      }
    
    // Delete the substitute TNodeTemplate
    model.getDocumentRoot()
    .getDefinitions()
    .getServiceTemplate()
    .get( 0 )
    .getTopologyTemplate()
    .getNodeTemplate().remove( substituteNode );
    
    
  }
}
