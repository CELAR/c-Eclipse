/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.editor.ImageProvider;
import eu.celar.tosca.editor.StyleUtil;

public class AddMonitorProbeFeature extends AbstractFeature
  implements IAddFeature
{

  public AddMonitorProbeFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  // Checks whether a Monitoring Probe can be added to the target object
  public boolean canAdd( final IAddContext context ) {
    boolean result = false;
    boolean isDiagramInstance = context.getTargetContainer() instanceof Diagram
                                                                               ? true
                                                                               : false;
//    if( context.getNewObject() instanceof MonitoringProbe && !isDiagramInstance )
//    {
//      result = true;
//    }
    
    boolean monitoringProbe = false;
    monitoringProbe = context.getNewObject() instanceof TDeploymentArtifact && ((TDeploymentArtifact)context.getNewObject()).getArtifactType().toString().compareTo( "MonitoringProbe" )==0;
  
    if( monitoringProbe && !isDiagramInstance )
    {
      result = true;
    }
    
    return result;
  }

  // No figure for Monitoring Probe required
  @Override
  public PictogramElement add( final IAddContext context ) {
    
    ContainerShape targetDiagram = context.getTargetContainer();
    
    // Check if monitoring icon already exists
    Object[] targetDiagrams = targetDiagram.getChildren().toArray();
    for( int i = 0; i < targetDiagrams.length; i++ ) {
      if( ( ( Shape )targetDiagrams[ i ] ).getGraphicsAlgorithm() instanceof Image )
        return null;
    }
  
    // Add monitoring icon into the target application component
    IPeCreateService peCreateService = Graphiti.getPeCreateService();
    ContainerShape containerShapeImg = peCreateService.createContainerShape( targetDiagram,
                                                                          true );    
    IGaService gaService = Graphiti.getGaService();
    String imageId = ImageProvider.IMG_MONITORING;
    Image image = gaService.createImage( containerShapeImg, imageId );
    gaService.setLocationAndSize( image, StyleUtil.APP_COMPONENT_WIDTH-15, 5, 10, 10 );
    
    containerShapeImg.setVisible( true );
    
    return null;
  }

  @Override
  public boolean canExecute( final IContext context ) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void execute( final IContext context ) {
    // TODO Auto-generated method stub
  }
}
