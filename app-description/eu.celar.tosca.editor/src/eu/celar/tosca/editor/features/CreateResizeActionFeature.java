/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
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

import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.ToscaFactory;



/**
 * @author Nicholas Loulloudes
 *
 */
public class CreateResizeActionFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  /**
   * @param fp
   */
  public CreateResizeActionFeature( final IFeatureProvider fp )
  {
    super( fp, "Resizing Action", "Resizing Action"); //$NON-NLS-1$ //$NON-NLS-2$
  }
  
  /**
   * @param obj The Context Object
   */
  public void setContextObject (final Object obj)
  {
    this.contextObject   = obj;
  }


  /* (non-Javadoc)
   * @see org.eclipse.graphiti.func.ICreate#canCreate(org.eclipse.graphiti.features.context.ICreateContext)
   */
  @Override
  public boolean canCreate( final ICreateContext context ) {
    return context.getTargetContainer() instanceof Diagram;
  }

  /* (non-Javadoc)
   * @see org.eclipse.graphiti.func.ICreate#create(org.eclipse.graphiti.features.context.ICreateContext)
   */
  @Override
  public Object[] create( final ICreateContext context ) {
    MessageConsole myConsole = findConsole("MyConsole");
    MessageConsoleStream out = myConsole.newMessageStream();    
    TNodeTemplate tNode = ToscaFactory.eINSTANCE.createTNodeTemplate();
    
    if( this.contextObject != null ) {
      ResizingAction ra = ( ResizingAction ) this.contextObject;
      out.println( "create Resizing Action: " + ra.getName() );
      
      
      // Add model element to resource.
      // We add the model element to the resource of the diagram for
      // simplicity's sake. Normally, a customer would use its own
      // model persistence layer for storing the business model separately.
      getDiagram().eResource().getContents().add( tNode );
      // Use the following instead of the above line to store the model
      // data in a seperate file parallel to the diagram file
      // try {
      // try {
      // TutorialUtil.saveToModelFile(newClass, getDiagram());
      // } catch (IOException e) {
      // e.printStackTrace();
      // }
      // } catch (CoreException e) {
      // e.printStackTrace();
      // }
      
      // do the add
      addGraphicalRepresentation( context, ra );
      // activate direct editing after object creation
      getFeatureProvider().getDirectEditingInfo().setActive( true );
    }
    // return newly created business object(s)
    return new Object[] { tNode };      
  }
  
  private MessageConsole findConsole(String name) {
    ConsolePlugin plugin = ConsolePlugin.getDefault();
    IConsoleManager conMan = plugin.getConsoleManager();
    IConsole[] existing = conMan.getConsoles();
    for (int i = 0; i < existing.length; i++)
       if (name.equals(existing[i].getName()))
          return (MessageConsole) existing[i];
    //no console found, so create a new one
    MessageConsole myConsole = new MessageConsole(name, null);
    conMan.addConsoles(new IConsole[]{myConsole});
    return myConsole;
 }
}
