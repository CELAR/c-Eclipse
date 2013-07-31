/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes, Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.celar.infosystem.model.base.VirtualMachineImage;

import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;

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
    if( parentBo instanceof TNodeTemplate ) {
      return true;
    }
    return false;
  }

  // Creates the business object for the VM image
  @Override
  public Object[] create( final ICreateContext context ) {
    if( this.contextObject == null )
      return null;
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    TNodeTemplate tNode = null;
    if( parentObject == null )
      return null;
    if( parentObject instanceof TNodeTemplate ) {
      tNode = ( TNodeTemplate )parentObject;
    }
    VirtualMachineImage vmi = ( VirtualMachineImage )this.contextObject;
    TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
    deploymentArtifact.setName( vmi.getName() );
    deploymentArtifact.setArtifactType( new QName( "VMI" ) );
    TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
    if( deploymentArtifacts == null ) {
      deploymentArtifacts = ToscaFactory.eINSTANCE.createTDeploymentArtifacts();
    }
    // Add the new deployment artifact to the list
    deploymentArtifacts.getDeploymentArtifact().add( deploymentArtifact );
    tNode.setDeploymentArtifacts( deploymentArtifacts );
    // do the add
    addGraphicalRepresentation( context, vmi );
    // activate direct editing after object creation
    getFeatureProvider().getDirectEditingInfo().setActive( true );
    // return newly created business object(s)
    return new Object[]{
      deploymentArtifact
    };
  }
}
