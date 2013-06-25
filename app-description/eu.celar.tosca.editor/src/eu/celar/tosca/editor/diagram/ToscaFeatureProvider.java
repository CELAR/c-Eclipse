/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.tosca.editor.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.infosystem.model.base.SoftwareDependency;
import eu.celar.infosystem.model.base.UserApplication;
import eu.celar.infosystem.model.base.VirtualMachineImage;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TRelationshipTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.editor.features.AddApplicationComponentFeature;
import eu.celar.tosca.editor.features.AddBidirectionalRelationFeature;
import eu.celar.tosca.editor.features.AddMonitorProbeFeature;
import eu.celar.tosca.editor.features.AddResizingActionFeature;
import eu.celar.tosca.editor.features.AddServiceTemplateFeature;
import eu.celar.tosca.editor.features.AddSoftwareDependencyFeature;
import eu.celar.tosca.editor.features.AddUserApplicationFeature;
import eu.celar.tosca.editor.features.AddVirtualMachineFeature;
import eu.celar.tosca.editor.features.CreateApplicationComponentFeature;
import eu.celar.tosca.editor.features.CreateBidirectionalRelationFeature;
import eu.celar.tosca.editor.features.CreateDirectedRelationFeature;
import eu.celar.tosca.editor.features.CreateGroupFeature;
import eu.celar.tosca.editor.features.CreateMonitorProbeFeature;
import eu.celar.tosca.editor.features.CreateResizeActionFeature;
import eu.celar.tosca.editor.features.CreateServiceTemplateFeature;
import eu.celar.tosca.editor.features.CreateSoftwareDependencyFeature;
import eu.celar.tosca.editor.features.CreateUserApplicationFeature;
import eu.celar.tosca.editor.features.CreateVMIFeature;
import eu.celar.tosca.editor.features.DirectEditApplicationComponentFeature;
import eu.celar.tosca.editor.features.LayoutApplicationComponentFeature;
import eu.celar.tosca.editor.features.MoveApplicationComponentFeature;
import eu.celar.tosca.editor.features.RenameApplicationComponentFeature;
import eu.celar.tosca.editor.features.AddDirectedRelationFeature;
import eu.celar.tosca.editor.features.UpdateApplicationComponentFeature;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ToscaFeatureProvider extends DefaultFeatureProvider {

  /**
   * @param dtp The Diagram Type Provider
   */
  public ToscaFeatureProvider( final IDiagramTypeProvider dtp ) {
    super( dtp );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.graphiti.features.impl.AbstractFeatureProvider#getAddFeature(org.eclipse.graphiti.features.context.IAddContext)
   */
  @Override
  public IAddFeature getAddFeature (final IAddContext context) {
    
    if( context.getNewObject() instanceof TNodeTemplate ) {
      return new AddApplicationComponentFeature( this );
    } else if( context.getNewObject() instanceof TRelationshipTemplate && ( ( TRelationshipTemplate )context.getNewObject() ).getName() == "Relation" ) {
      return new AddBidirectionalRelationFeature( this );
    } else if( context.getNewObject() instanceof TRelationshipTemplate ) {
      return new AddDirectedRelationFeature( this );
    } else if( context.getNewObject() instanceof VirtualMachineImage ) {
      return new AddVirtualMachineFeature( this );
    } else if( context.getNewObject() instanceof SoftwareDependency ) {
      return new AddSoftwareDependencyFeature( this );
    } else if( context.getNewObject() instanceof MonitoringProbe ) {
      return new AddMonitorProbeFeature( this );
    } else if( context.getNewObject() instanceof ResizingAction ) {
      return new AddResizingActionFeature( this );
    } else if( context.getNewObject() instanceof TServiceTemplate ) {
      return new AddServiceTemplateFeature( this );
    } else if( context.getNewObject() instanceof UserApplication ) {
      return new AddUserApplicationFeature( this );
    }
    return super.getAddFeature( context );
  }
  
  
  
  @Override
  public ICreateFeature[] getCreateFeatures() {
    return new ICreateFeature[]{
      new CreateApplicationComponentFeature( this ),
      new CreateVMIFeature( this ),
      new CreateSoftwareDependencyFeature( this ),
      new CreateMonitorProbeFeature( this ),
      new CreateServiceTemplateFeature( this ),
      new CreateResizeActionFeature( this ),
      new CreateUserApplicationFeature( this ),

    };
  }
  
  @Override
  public IDirectEditingFeature getDirectEditingFeature(final IDirectEditingContext context) {
      PictogramElement pe = context.getPictogramElement();
      Object bo = getBusinessObjectForPictogramElement(pe);
      if (bo instanceof TNodeTemplate) {
          return new DirectEditApplicationComponentFeature(this);
      } 
      return super.getDirectEditingFeature(context);
  }
  
  @Override
  public ILayoutFeature getLayoutFeature(final ILayoutContext context) {
      PictogramElement pictogramElement = context.getPictogramElement();
      Object bo = getBusinessObjectForPictogramElement(pictogramElement);
      if (bo instanceof TNodeTemplate) {
          return new LayoutApplicationComponentFeature(this);
      }
      return super.getLayoutFeature(context);
  }
  
  @Override
  public IUpdateFeature getUpdateFeature(final IUpdateContext context ) {
    PictogramElement pictogramElement = context.getPictogramElement();
    if( pictogramElement instanceof ContainerShape ) {
      Object bo = getBusinessObjectForPictogramElement( pictogramElement );
      if( bo instanceof TNodeTemplate ) {
        return new UpdateApplicationComponentFeature( this );
      }
    }
    return super.getUpdateFeature( context );
  }
  
  @Override
  public IMoveShapeFeature getMoveShapeFeature(final IMoveShapeContext context) {
      Shape shape = context.getShape();
      Object bo = getBusinessObjectForPictogramElement(shape);
      if (bo instanceof TNodeTemplate) {
          return new MoveApplicationComponentFeature(this);
      }
      return super.getMoveShapeFeature(context);
  }
  
  @Override
  public ICustomFeature[] getCustomFeatures( ICustomContext context ) {
    return new ICustomFeature[]{
      new RenameApplicationComponentFeature( this ),
      //new CreateGroupFeature( this )
      
//      new TutorialDrillDownEClassFeature( this ),
//      new TutorialAssociateDiagramEClassFeature( this ),
//      new TutorialCollapseDummyFeature( this ),
//      new TutorialChangeColorEClassFeature( this )
    };
  }
  
  /**
   * DEMO
   */
  @Override
  public ICreateConnectionFeature[] getCreateConnectionFeatures() {
  return new ICreateConnectionFeature[]{
    new CreateDirectedRelationFeature( this ),
    new CreateBidirectionalRelationFeature(this)
  };
  }

}
