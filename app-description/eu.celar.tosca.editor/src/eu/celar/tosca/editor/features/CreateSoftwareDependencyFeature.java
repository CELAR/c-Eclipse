/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import eu.celar.infosystem.model.base.SoftwareDependency;
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
    MessageConsole myConsole = findConsole( "MyConsole" );
    MessageConsoleStream out = myConsole.newMessageStream();
    TNodeTemplate tNode = ToscaFactory.eINSTANCE.createTNodeTemplate();
    if( this.contextObject != null ) {
      SoftwareDependency swd = ( SoftwareDependency )this.contextObject;
      out.println( "create Software Dependency: " + swd.getName() );
      getDiagram().eResource().getContents().add( tNode );
      // do the add
      addGraphicalRepresentation( context, swd );
      // activate direct editing after object creation
      getFeatureProvider().getDirectEditingInfo().setActive( true );
      // return newly created business object(s)
    }
    return new Object[]{
      tNode
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
