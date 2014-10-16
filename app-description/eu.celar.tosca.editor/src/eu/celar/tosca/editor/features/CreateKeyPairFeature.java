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
import org.eclipse.jface.dialogs.MessageDialog;

import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.ToscaFactory;

public class CreateKeyPairFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateKeyPairFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Key Pair", "Create Key Pair" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if user can create a user application object in the target
  // business object
  @Override
  public boolean canCreate( final ICreateContext context ) {
    if( context.getTargetContainer() instanceof Diagram )
      return false;
    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    if( parentBo instanceof TNodeTemplate ) {
      return true;
    }
    return false;
  }

  // Creates the business object for the user application
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
    TDeploymentArtifact tempDeploymentArtifact = ( TDeploymentArtifact ) this.contextObject;
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
    // ///////////////////////////////////////////
    addGraphicalRepresentation( context, deploymentArtifact );
    // ///////////////////////////////////////////
    // activate direct editing after object creation
    getFeatureProvider().getDirectEditingInfo().setActive( true );
    // return newly created business object(s)
    return new Object[]{
      deploymentArtifact
    };
  }
}
