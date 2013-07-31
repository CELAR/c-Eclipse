/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes, Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import javax.xml.namespace.QName;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.celar.infosystem.model.base.MonitoringProbe;

import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.ToscaFactory;

import eu.celar.tosca.elasticity.MonitoringProbesType1;
import eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension;

import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;

public class CreateMonitorProbeFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateMonitorProbeFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Monitor Probe", "Monitor Probe" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if user can create a monitoring probe object in the target
  // business object
  @Override
  public boolean canCreate( final ICreateContext context ) {
    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    if( parentBo instanceof TNodeTemplate
        || parentBo instanceof TServiceTemplate )
    {
      return true;
    }
    return false;
  }

  // Creates the business object for the monitoring probe
  @Override
  public Object[] create( final ICreateContext context ) {
    if( this.contextObject == null )
      return null;
    Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    MonitoringProbe mp = ( MonitoringProbe )this.contextObject;
    if( parentObject == null )
      return null;
    if( parentObject instanceof TNodeTemplate ) {
      TNodeTemplate tNode = null;
      tNode = ( TNodeTemplate )parentObject;
      TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
      deploymentArtifact.setName( mp.getName() );
      deploymentArtifact.setArtifactType( new QName( "MonitoringProbe" ) );
      TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
      if( deploymentArtifacts == null ) {
        deploymentArtifacts = ToscaFactory.eINSTANCE.createTDeploymentArtifacts();
      }
      // Add the new deployment artifact to the list
      deploymentArtifacts.getDeploymentArtifact().add( deploymentArtifact );
      tNode.setDeploymentArtifacts( deploymentArtifacts );
      // do the add
      addGraphicalRepresentation( context, mp );
      // activate direct editing after object creation
      getFeatureProvider().getDirectEditingInfo().setActive( true );
      // return newly created business object(s)
      return new Object[]{
        deploymentArtifact
      };
    } else if( parentObject instanceof TServiceTemplate ) {
      TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )( ( ( TServiceTemplate )parentObject ).getBoundaryDefinitions() );
      MonitoringProbesType1 monitoringProbesList = boundaryDef.getMonitoringProbes();
      if( monitoringProbesList == null ) {
        monitoringProbesList = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createMonitoringProbesType1();
      }
      // final TMonitoringProbe monitoringProbe =
      // Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTMonitoringProbe();
      //
      // monitoringProbe.setName( mp.getName() );
      monitoringProbesList.getMonitoringProbes().add( mp.getName() );
      boundaryDef.setMonitoringProbes( monitoringProbesList );
      return null;
    } else
      return null;
  }
}
