/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes, Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import javax.xml.namespace.QName;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.ToscaFactory;

public class CreateResizeActionFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateResizeActionFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Resizing Action", "Resizing Action" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if user can create an elasticity action object in the target
  // business object
  @Override
  public boolean canCreate( final ICreateContext context ) {
    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    if( parentBo instanceof TNodeTemplate ) {
      return true;
    }
    return false;
  }

  // Creates the business object for the elasticity action
  @Override
  public Object[] create( final ICreateContext context ) {
    // MessageConsole myConsole = findConsole("MyConsole");
    // MessageConsoleStream out = myConsole.newMessageStream();
    if( this.contextObject == null )
      return null;
    Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    TNodeTemplate tNode = null;
    if( parentObject == null )
      return null;
    if( parentObject instanceof TNodeTemplate ) {
      tNode = ( TNodeTemplate )parentObject;
    }
    ResizingAction ra = ( ResizingAction )this.contextObject;
    TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
    deploymentArtifact.setName( ra.getName() );
    deploymentArtifact.setArtifactType( new QName( "ResizingAction" ) );
    TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
    if( deploymentArtifacts == null ) {
      deploymentArtifacts = ToscaFactory.eINSTANCE.createTDeploymentArtifacts();
    }
    // Add the new deployment artifact to the list
    deploymentArtifacts.getDeploymentArtifact().add( deploymentArtifact );
    tNode.setDeploymentArtifacts( deploymentArtifacts );
    // do the add
    addGraphicalRepresentation( context, ra );
    // activate direct editing after object creation
    getFeatureProvider().getDirectEditingInfo().setActive( true );
    // return newly created business object(s)
    return new Object[]{
      deploymentArtifact
    };
  }

  private MessageConsole findConsole( String name ) {
    ConsolePlugin plugin = ConsolePlugin.getDefault();
    IConsoleManager conMan = plugin.getConsoleManager();
    IConsole[] existing = conMan.getConsoles();
    for( int i = 0; i < existing.length; i++ )
      if( name.equals( existing[ i ].getName() ) )
        return ( MessageConsole )existing[ i ];
    // no console found, so create a new one
    MessageConsole myConsole = new MessageConsole( name, null );
    conMan.addConsoles( new IConsole[]{
      myConsole
    } );
    return myConsole;
  }
}
