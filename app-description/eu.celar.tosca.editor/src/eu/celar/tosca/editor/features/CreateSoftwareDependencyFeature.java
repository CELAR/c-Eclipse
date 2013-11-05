/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.ToscaFactory;

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
	      
//	      VirtualMachineImage vmi = ( VirtualMachineImage )this.contextObject;
//	      TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
//	      deploymentArtifact.setName( vmi.getName() );
//	      deploymentArtifact.setArtifactType( new QName( "VMI" ) );


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
	      
	      
//	      else {
//	        
//	        // Check whether a VM image has been specified for the component
//	        TDeploymentArtifact artifact;
//	        TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
//	        for( int i=0; i<deploymentArtifacts.getDeploymentArtifact().size(); i++ )
//	        {
//	          artifact = deploymentArtifacts.getDeploymentArtifact().get( i );
//	          if( artifact.getArtifactType().toString().compareTo( "VMI" ) == 0 ) //$NON-NLS-1$
//	            deploymentArtifacts.getDeploymentArtifact().remove( artifact );
//	          
//	        }
//	      }
	      
	      
	      // Add the new deployment artifact to the list
	      final TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
	      TDeploymentArtifact tempDeploymentArtifact = ( TDeploymentArtifact )this.contextObject;
	      
	      TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
	      deploymentArtifact.setName( tempDeploymentArtifact.getName() );
	      deploymentArtifact.setArtifactType( tempDeploymentArtifact.getArtifactType() );
	      
	          
	      final TDeploymentArtifact tempArtifact = deploymentArtifact;
	      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	      editingDomain.getCommandStack()
	        .execute( new RecordingCommand( editingDomain ) {

	          protected void doExecute() {
	            deploymentArtifacts.getDeploymentArtifact().add( tempArtifact );
	          }
	        } );
	      
	      //addGraphicalRepresentation( context, vmi );
	      
	      /////////////////////////////////////////////
	      addGraphicalRepresentation( context, deploymentArtifact );
	      /////////////////////////////////////////////

	      // activate direct editing after object creation
	      getFeatureProvider().getDirectEditingInfo().setActive( true );
	      // return newly created business object(s)
	      return new Object[]{
	        deploymentArtifact
	      };

  }

}
