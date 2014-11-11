/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes, Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.jface.dialogs.MessageDialog;

import eu.celar.tosca.DefinitionsType;
import eu.celar.tosca.PropertiesType;
import eu.celar.tosca.TArtifactTemplate;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;
import eu.celar.tosca.elasticity.ImageArtifactPropertiesType;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

public class CreateVMIFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateVMIFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Base Image", "Base Image" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if user can create a VM image object in the target business object
  @Override
  public boolean canCreate( final ICreateContext context ) {
    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    if( parentBo instanceof TNodeTemplate || parentBo instanceof TServiceTemplate ) {
      return true;
    }
    //return false;
    return true;
  }

  // Creates the business object for the VM image
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

    if (tNode.getName()==null){
      MessageDialog.openError(null, "Error", "Give a Name to the selected Component and try again.");
      return null;
    }
    
    if( tNode.getDeploymentArtifacts() == null ) {
      //deploymentArtifacts = ToscaFactory.eINSTANCE.createTDeploymentArtifacts();
      //tNode.setDeploymentArtifacts( deploymentArtifacts );
      
      final TNodeTemplate node = tNode;
      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
      editingDomain.getCommandStack()
        .execute( new RecordingCommand( editingDomain ) {

          protected void doExecute() {
            node.setDeploymentArtifacts( ToscaFactory.eINSTANCE.createTDeploymentArtifacts() );
          }
        } );
      
      
    } 
    
    
//    else {
//      
//      // Check whether a VM image has been specified for the component
//      TDeploymentArtifact artifact;
//      TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
//      for( int i=0; i<deploymentArtifacts.getDeploymentArtifact().size(); i++ )
//      {
//        artifact = deploymentArtifacts.getDeploymentArtifact().get( i );
//        if( artifact.getArtifactType().toString().compareTo( "VMI" ) == 0 ) //$NON-NLS-1$
//          deploymentArtifacts.getDeploymentArtifact().remove( artifact );
//        
//      }
//    }
    
    
    // Add the new deployment artifact to the list
    final TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
    TDeploymentArtifact tempDeploymentArtifact = ( TDeploymentArtifact )this.contextObject;
    
    TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
    deploymentArtifact.setName( tempDeploymentArtifact.getName() );
    deploymentArtifact.setArtifactType( tempDeploymentArtifact.getArtifactType() );
    deploymentArtifact.setArtifactRef( tempDeploymentArtifact.getArtifactRef() );
    
        
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
   
    createArtifactTemplate("not_specified", tempDeploymentArtifact.getArtifactRef().toString());
    
    // activate direct editing after object creation
    getFeatureProvider().getDirectEditingInfo().setActive( true );
    // return newly created business object(s)
    return new Object[]{
      deploymentArtifact
    };
  }
  
  private void createArtifactTemplate(String description, String imageId){
    
    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    
    for (TArtifactTemplate tempArtifactTemplate : model.getDocumentRoot()
        .getDefinitions()
        .getArtifactTemplate()){
      if (tempArtifactTemplate.getId().equals( imageId ))
        return;
    }
  
    //Create Artifact Template
    final TArtifactTemplate artifactTemplate = ToscaFactory.eINSTANCE.createTArtifactTemplate();
    
    //Create Image Artifact Properties
    ImageArtifactPropertiesType imageProperties = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createImageArtifactPropertiesType();
    imageProperties.setDescription( description );
    
    if (imageId!=null){
      imageProperties.setId( imageId );
    }
    
    // Set the Properties of the Policy Template    
    PropertiesType properties = ToscaFactory.eINSTANCE.createPropertiesType();   
    
    // Add the SYBL Policy to the FeatureMap of the Policy's Properties element
    Entry e = FeatureMapUtil.createEntry(     Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getDocumentRoot_ImageArtifactProperties(),  imageProperties );
    properties.getAny().add( e );   
    
    artifactTemplate.setProperties( properties );
 
    artifactTemplate.setId( imageId );
    
    // Add the new Artifact Template to the TOSCA Definitions element
    
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
}
