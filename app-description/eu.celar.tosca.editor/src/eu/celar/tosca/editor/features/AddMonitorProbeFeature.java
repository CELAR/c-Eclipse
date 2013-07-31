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
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import eu.celar.infosystem.model.base.MonitoringProbe;

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
    if( context.getNewObject() instanceof MonitoringProbe && !isDiagramInstance )
    {
      result = true;
    }
    return result;
  }

  // No figure for Monitoring Probe required
  @Override
  public PictogramElement add( final IAddContext context ) {
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
