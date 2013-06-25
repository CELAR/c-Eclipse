/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.infosystem.model.base.VirtualMachineImage;
import eu.celar.tosca.TArtifactType;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;



/**
 * @author Nicholas Loulloudes
 *
 */
public class CreateMonitorProbeFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  /**
   * @param fp
   */
  public CreateMonitorProbeFeature( final IFeatureProvider fp )
  {
    super( fp, "Monitor Probe", "Monitor Probe"); //$NON-NLS-1$ //$NON-NLS-2$
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
   if (context.getTargetContainer() instanceof Diagram)
     return false;

   Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement(context.getTargetContainer());
   if (parentBo instanceof EClass) {
     return true;
   }

   return false;
 }

  /* (non-Javadoc)
   * @see org.eclipse.graphiti.func.ICreate#create(org.eclipse.graphiti.features.context.ICreateContext)
   */
/* (non-Javadoc)
 * @see org.eclipse.graphiti.func.ICreate#create(org.eclipse.graphiti.features.context.ICreateContext)
 */
@Override
public Object[] create( final ICreateContext context ) {       
//  ToscaModelLayer model = ModelHandler.getModel(EcoreUtil.getURI(getDiagram()));
//  
//  Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement(context.getTargetContainer());
//  
//  TNodeTemplate tNode = null;
//  TDeploymentArtifact artifact = null;
//  
//  if( this.contextObject != null ) {
//    
//    if (parentObject == null)
//      return null;
//    
//    if (parentObject instanceof TNodeTemplate) {
//      tNode = (TNodeTemplate) parentObject;
//    }
//          
//    ContainerShape containerShape = ( ContainerShape )getFeatureProvider().getPictogramElementForBusinessObject( parentObject );
//    
//    MonitoringProbe mp = ( MonitoringProbe )this.contextObject;
//    
//    // Create Artifact Type
//    TArtifactType artifactType = ToscaFactory.eINSTANCE.createTArtifactType();
//    artifactType.setName( "MonitorProbe" ); //$NON-NLS-1$
//    
//    EList<TArtifactType> artifactTypes = model.getDocumentRoot().getDefinitions().getArtifactType();
//    
//    boolean defined = false;
//    for (TArtifactType aT : artifactTypes) {
//      if (aT.getName().equals( artifactType.getName() ) )
//        defined = true;
//    }
//    
//    if (!defined)
//      artifactTypes.add( artifactType );
//    
//    // Create Artifact
//    artifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
//    artifact.setName( mp.getName() );      
//    
//    TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
//    deploymentArtifact.setName( mp.getName() );      
//    
//    TDeploymentArtifacts deploymentArtifacts = null;
//    
//    if (tNode.getDeploymentArtifacts() == null) {        
//      deploymentArtifacts = ToscaFactory.eINSTANCE.createTDeploymentArtifacts();
//      deploymentArtifacts.getDeploymentArtifact().add( deploymentArtifact );
//      
//    }
//    
//    tNode.setDeploymentArtifacts( deploymentArtifacts );
//    
//    AddContext addContext = new AddContext();
//    addContext.setNewObject( artifact );
//    addContext.setTargetContainer( containerShape );
//    // do the add
//    addGraphicalRepresentation( context, artifact );
//    getFeatureProvider().addIfPossible(addContext);
//    
//    // activate direct editing after object creation
//    getFeatureProvider().getDirectEditingInfo().setActive( true );     
//  }
//  // return newly created business object(s)
//  return new Object[] { artifact };
  /**
   * DEMO
   */
  TNodeTemplate tNode = ToscaFactory.eINSTANCE.createTNodeTemplate();

  if( this.contextObject != null ) {
    MonitoringProbe mp = ( MonitoringProbe ) this.contextObject;
    
    
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
    addGraphicalRepresentation( context, mp );
    // activate direct editing after object creation
    getFeatureProvider().getDirectEditingInfo().setActive( true );
  }
  // return newly created business object(s)
  return new Object[] { tNode };   
} 
}
