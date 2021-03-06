package eu.celar.tosca.editor.features;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TPolicy;
import eu.celar.tosca.TPolicyTemplate;
import eu.celar.tosca.TRelationshipTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;


public class DeleteGroupFeature extends DefaultDeleteFeature {

  public DeleteGroupFeature( IFeatureProvider fp ) {
    super( fp );
    // TODO Auto-generated constructor stub
  }

    @Override
    public boolean canDelete(IDeleteContext context) {
        // TODO Auto-generated method stub
        
        TServiceTemplate deletedObject = (TServiceTemplate) getFeatureProvider().getBusinessObjectForPictogramElement( context.getPictogramElement() );
        
        if (deletedObject.getSubstitutableNodeType() == null)
            return false;
        
        return true;
    }
    
  @Override
  public void preDelete(IDeleteContext context) {
    
    Object deletedObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getPictogramElement() );
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    TServiceTemplate deletedServiceTemplate = (TServiceTemplate) deletedObject;

    
//    // Delete Policy Templates

//
//    for( TPolicy tempPolicy : deletedNodeTemplate.getPolicies().getPolicy() )
//      for( TPolicyTemplate tempPolicyTemplate : model.getDocumentRoot()
//        .getDefinitions()
//        .getPolicyTemplate() )
//      {
//        if( tempPolicy.getPolicyRef()
//          .toString()
//          .compareTo( tempPolicyTemplate.getId() ) == 0 )
//        {
//          model.getDocumentRoot()
//            .getDefinitions()
//            .getPolicyTemplate()
//            .remove( tempPolicyTemplate );
//        }
//      }
    
    
    // Delete Relationships
    for( TServiceTemplate tempServiceTemplate : model.getDocumentRoot()
      .getDefinitions()
      .getServiceTemplate() )
    {
      if ( tempServiceTemplate.getTopologyTemplate() != null ){
        for( TRelationshipTemplate tempRelationshipTemplate : tempServiceTemplate.getTopologyTemplate()
          .getRelationshipTemplate() )
        {
          if( tempRelationshipTemplate.getSourceElement()
            .getRef()
            .compareTo( deletedServiceTemplate.getId() ) == 0
              || tempRelationshipTemplate.getTargetElement()
                .getRef()
                .compareTo( deletedServiceTemplate.getId() ) == 0 )
          {
            tempServiceTemplate.getTopologyTemplate()
              .getRelationshipTemplate()
              .remove( tempRelationshipTemplate );
          }
        }
      }
    }
   
    
    // Find the substitute TNodeTemplate
    TNodeTemplate substituteNode = null;

    for (TNodeTemplate tempNodeTemplate : model.getDocumentRoot()
      .getDefinitions()
      .getServiceTemplate()
      .get( 0 )
      .getTopologyTemplate()
      .getNodeTemplate()){
       
      if (tempNodeTemplate.getId() ==  deletedServiceTemplate.getId() )
      {
        substituteNode = tempNodeTemplate;
        break;
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
