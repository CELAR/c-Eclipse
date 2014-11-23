/*******************************************************************************
 * Copyright (c) 2013 CELAR Consortium.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 *   Stalo Sofokleous - initial API and implementation
 *   Nicholas Loulloudes - API and implementation extensions
 *   
 *******************************************************************************/
package eu.celar.tosca.editor.features;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import eu.celar.tosca.TArtifactTemplate;
import eu.celar.tosca.TImplementationArtifact;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TNodeTypeImplementation;
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
    //Delete NodeTypeImplementations
    if (model.getDocumentRoot()
        .getDefinitions()
        .getNodeTypeImplementation() != null){
    QName[] artifactTemplatesIDs = new QName[1];
    for( TNodeTypeImplementation tempNodeTypeImplementation : model.getDocumentRoot()
        .getDefinitions()
        .getNodeTypeImplementation() )
      {
        if ( tempNodeTypeImplementation.getNodeType().toString().equals( deletedNodeTemplate.getName()) ){
          //Find Artifact Templates to be Deleted
          {
            for (TImplementationArtifact tempImplementationArtifact: tempNodeTypeImplementation.getImplementationArtifacts().getImplementationArtifact()){
              artifactTemplatesIDs[artifactTemplatesIDs.length-1]=tempImplementationArtifact.getArtifactRef();
            }
          }
          //Delete NodeTypeImplementation
            {
              model.getDocumentRoot()
              .getDefinitions()
              .getNodeTypeImplementation()
                .remove( tempNodeTypeImplementation );
            }
          } 
      }
    
    //Delete ArtifactTemplates
    for( TArtifactTemplate tempArtifactTemplate : model.getDocumentRoot()
        .getDefinitions().getArtifactTemplate()){
      for (QName tempArtifactTemplateID : artifactTemplatesIDs){
        if (tempArtifactTemplate.getId().equals( tempArtifactTemplateID.toString() )){
          //Delete Artifact Template
          {
            model.getDocumentRoot()
            .getDefinitions()
            .getArtifactTemplate()
              .remove( tempArtifactTemplate );
          }
        }
      }
    }
  }
  }
}
