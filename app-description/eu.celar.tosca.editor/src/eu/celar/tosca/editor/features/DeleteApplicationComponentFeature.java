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

public class DeleteApplicationComponentFeature extends DefaultDeleteFeature {

  public DeleteApplicationComponentFeature( IFeatureProvider fp ) {
    super( fp );
    // TODO Auto-generated constructor stub
  }

  @Override
  public void preDelete( IDeleteContext context ) {
    // Removes the relationships related to the deleted application component
    Object deletedObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getPictogramElement() );
    TNodeTemplate deletedNodeTemplate = ( TNodeTemplate )deletedObject;
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    // Delete Policy Templates
    if ( deletedNodeTemplate.getPolicies() != null )
    {
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
    }
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
            .compareTo( deletedNodeTemplate.getId() ) == 0
              || tempRelationshipTemplate.getTargetElement()
                .getRef()
                .compareTo( deletedNodeTemplate.getId() ) == 0 )
          {
            tempServiceTemplate.getTopologyTemplate()
              .getRelationshipTemplate()
              .remove( tempRelationshipTemplate );
          }
        }
      }
    }
  }
}
