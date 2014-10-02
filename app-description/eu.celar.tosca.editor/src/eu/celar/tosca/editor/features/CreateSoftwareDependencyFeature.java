/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import java.io.File;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
//import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import eu.celar.tosca.ArtifactReferencesType;
import eu.celar.tosca.DefinitionsType;
import eu.celar.tosca.ImplementationArtifactType;
import eu.celar.tosca.PropertiesType;
import eu.celar.tosca.TArtifactReference;
import eu.celar.tosca.TArtifactTemplate;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TImplementationArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TNodeTypeImplementation;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;
import eu.celar.tosca.elasticity.ScriptArtifactPropertiesType;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

public class CreateSoftwareDependencyFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateSoftwareDependencyFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Software Dependency", "Software Dependency" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if user can create a software dependency object in the target
  // business object
  @Override
  public boolean canCreate( final ICreateContext context ) {
    return !( context.getTargetContainer() instanceof Diagram );
  }

  // Creates the business object for the software dependency
  @Override
  public Object[] create( final ICreateContext context ) {
	  
	    if( this.contextObject == null )
	        return null;

	      Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
	      TNodeTemplate tNode = null;
	      if( parentObject == null )
	        return null;
	      if( parentObject instanceof TNodeTemplate ) {
	        tNode = ( TNodeTemplate )parentObject;
	      }

	      if( tNode.getDeploymentArtifacts() == null ) {
	        
	        final TNodeTemplate node = tNode;
	        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	        editingDomain.getCommandStack()
	          .execute( new RecordingCommand( editingDomain ) {

	            protected void doExecute() {
	              node.setDeploymentArtifacts( ToscaFactory.eINSTANCE.createTDeploymentArtifacts() );
	            }
	          } );
	        
	      } 
	            
	      
	      // Add the new deployment artifact to the list
	      final TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
	      TDeploymentArtifact tempDeploymentArtifact = ( TDeploymentArtifact )this.contextObject;
	      
	      TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
	      deploymentArtifact.setName( tempDeploymentArtifact.getName() );
	      deploymentArtifact.setArtifactType( tempDeploymentArtifact.getArtifactType() );
	      deploymentArtifact.setArtifactRef( new QName (tNode.getName() + "Script" ));
	          
	      final TDeploymentArtifact tempArtifact = deploymentArtifact;
	      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	      editingDomain.getCommandStack()
	        .execute( new RecordingCommand( editingDomain ) {

	          protected void doExecute() {
	            deploymentArtifacts.getDeploymentArtifact().add( tempArtifact );
	          }
	        } );
	      
	      
	      addGraphicalRepresentation( context, deploymentArtifact );

	      //Create Image Artifact Template
	      createArtifactTemplate(tNode.getName(), tempDeploymentArtifact.getName());
	      
	      //Create Implementation Artifact
	      createImplementationArtifact( tempDeploymentArtifact.getName(), new QName(tNode.getName()));

	      // activate direct editing after object creation
	      getFeatureProvider().getDirectEditingInfo().setActive( true );
	      // return newly created business object(s)
	      return new Object[]{
	        deploymentArtifact
	      };

  }
  
  private void createArtifactTemplate(String nodeName, String artifactName){
    
    //Create Artifact Template
    final TArtifactTemplate artifactTemplate = ToscaFactory.eINSTANCE.createTArtifactTemplate();
    
    //Create Script Artifact Properties
    ScriptArtifactPropertiesType scriptProperties = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createScriptArtifactPropertiesType();
    scriptProperties.setLanguage( "Shell" );
    
    // Set the Properties of the Policy Template    
    PropertiesType properties = ToscaFactory.eINSTANCE.createPropertiesType();   
    
    // Add the SYBL Policy to the FeatureMap of the Policy's Properties element
    Entry e = FeatureMapUtil.createEntry(     Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getDocumentRoot_ScriptArtifactProperties(),  scriptProperties );
    properties.getAny().add( e );      
    
    artifactTemplate.setProperties( properties );
    
    artifactTemplate.setId( nodeName + "Script" );
    
    
    // Set artifact ref
    TArtifactReference artifactRef = ToscaFactory.eINSTANCE.createTArtifactReference();
    artifactRef.setReference( "Scripts"+ File.separator + artifactName);

    ArtifactReferencesType artifactRefType = ToscaFactory.eINSTANCE.createArtifactReferencesType();
    artifactRefType.getArtifactReference().add( artifactRef );
    
    artifactTemplate.setArtifactReferences( artifactRefType );
    
    // Add the new Artifact Template to the TOSCA Definitions element
    
    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    
    DefinitionsType definitions = model.getDocumentRoot().getDefinitions();
       
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( definitions );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          model.getDocumentRoot().getDefinitions().getArtifactTemplate().add( artifactTemplate );
          
        }
      } );

  }
  
  
  //Creates the install implementation artifact
  private void createImplementationArtifact(String artifactName, QName nodeType){
    
    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    
    final DefinitionsType definitions = model.getDocumentRoot().getDefinitions();
    
    TNodeTypeImplementation nodeTypeImplementation = null;
    
    //Test if NodeTypeImplementation for nodeType already exists
    for ( TNodeTypeImplementation tempNodeTypeImplementation : definitions.getNodeTypeImplementation() ){
      if ( tempNodeTypeImplementation.getNodeType().toString().equals(nodeType.toString()) ){
        //NodeTypeImplementation already exists
        //We are going to add the artifact to the existing implementation
        nodeTypeImplementation = tempNodeTypeImplementation;
      }
    }
    
    if ( nodeTypeImplementation == null ){
      //NodeTypeImplementation does not exists
      final TNodeTypeImplementation newNodeTypeImplementation = ToscaFactory.eINSTANCE.createTNodeTypeImplementation();
      newNodeTypeImplementation.setNodeType( nodeType );
      TImplementationArtifacts implementationArtifacts = ToscaFactory.eINSTANCE.createTImplementationArtifacts();
      newNodeTypeImplementation.setImplementationArtifacts( implementationArtifacts );
      
      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( definitions );
      editingDomain.getCommandStack()
        .execute( new RecordingCommand( editingDomain ) {

          @Override
          protected void doExecute() {
            definitions.getNodeTypeImplementation().add( newNodeTypeImplementation );
            
          }
        } );
      nodeTypeImplementation = newNodeTypeImplementation;
    }

    //Create Implementation Artifact
    final ImplementationArtifactType installArtifactType = ToscaFactory.eINSTANCE.createImplementationArtifactType();
    installArtifactType.setArtifactType( new QName("ScriptArtifact") );
    installArtifactType.setArtifactRef( new QName(artifactName) );
    installArtifactType.setInterfaceName( "Lifecycle" );
    installArtifactType.setOperationName( "install" );
    
    final TNodeTypeImplementation nodeImplementation = nodeTypeImplementation;
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nodeTypeImplementation );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          nodeImplementation.getImplementationArtifacts().getImplementationArtifact().add( installArtifactType );
          
        }
      } );    

  }
}
