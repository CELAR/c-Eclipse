package eu.celar.tosca.editor.features;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import eu.celar.tosca.TArtifactTemplate;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;

public class DeleteDeploymentArtifactFeature extends DefaultDeleteFeature{
  
  private boolean deleteDeploymentArtifact = false;
  private TNodeTemplate parentNodeTemplate;

  public DeleteDeploymentArtifactFeature( IFeatureProvider fp ) {
    super( fp );
  }
  
  @Override
  public void preDelete(IDeleteContext context) {
    // Checks whether the node template contained only the deleted deployment artifact  
     
    PictogramElement parentPE = Graphiti.getPeService().getPictogramElementParent( context.getPictogramElement() );
    
    TNodeTemplate parentNodeTemplate = ( TNodeTemplate ) getFeatureProvider().getBusinessObjectForPictogramElement( parentPE );
    
    if ( parentNodeTemplate.getDeploymentArtifacts().getDeploymentArtifact().size() == 1 ){
      this.deleteDeploymentArtifact = true;
      this.parentNodeTemplate = parentNodeTemplate;
    }
    
    //Delete corresponding TArtifactTemplate
    Object deletedObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getPictogramElement() );
    TDeploymentArtifact deletedDeploymentArtifact = (TDeploymentArtifact) deletedObject;
    String deletedDeploymentArtifactId = deletedDeploymentArtifact.getArtifactRef().toString();
    
    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    
    for ( TArtifactTemplate tempArtifactTemplate : model.getDocumentRoot().getDefinitions().getArtifactTemplate() ){
      if (tempArtifactTemplate.getId().compareTo( deletedDeploymentArtifactId )==0){
        model.getDocumentRoot().getDefinitions().getArtifactTemplate().remove( tempArtifactTemplate );
      }
    }
  }
  
  @Override
  public void postDelete(IDeleteContext context) {
    // Removes the deployment artifacts element if no more artifacts left 
     
    if ( this.deleteDeploymentArtifact == true )
      this.parentNodeTemplate.setDeploymentArtifacts( null );
  }

}
