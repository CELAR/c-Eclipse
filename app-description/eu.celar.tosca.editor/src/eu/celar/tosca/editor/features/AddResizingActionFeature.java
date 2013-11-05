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

import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.tosca.editor.property.ApplicationComponentElasticityRequirementsSection;

public class AddResizingActionFeature extends AbstractFeature
  implements IAddFeature
{

  public AddResizingActionFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  // Checks whether a Resizing Action can be added to the target object
  @Override
  public boolean canAdd( final IAddContext context ) {
    boolean result = false;
    boolean isDiagramInstance = context.getTargetContainer() instanceof Diagram
                                                                               ? true
                                                                               : false;
    if( context.getNewObject() instanceof ResizingAction && !isDiagramInstance )
    {
      result = true;
    }
    return result;
  }

  // No figure for Resizing Action required
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
