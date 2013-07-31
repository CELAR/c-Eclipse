/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import eu.celar.infosystem.model.base.UserApplication;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.ToscaFactory;

public class CreateUserApplicationFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateUserApplicationFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "User Application", "Create User Application" ); //$NON-NLS-1$ //$NON-NLS-2$
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
    TNodeTemplate tNode = ToscaFactory.eINSTANCE.createTNodeTemplate();
    if( this.contextObject != null ) {
      UserApplication uA = ( UserApplication )this.contextObject;
      getDiagram().eResource().getContents().add( tNode );
      // do the add
      addGraphicalRepresentation( context, uA );
      // activate direct editing after object creation
      getFeatureProvider().getDirectEditingInfo().setActive( true );
    }
    // return newly created business object(s)
    return new Object[]{
      tNode
    };
  }
}
