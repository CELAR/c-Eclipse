/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.tosca.editor.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.MarqueeSelectionTool;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.StackEntry;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;

import eu.celar.infosystem.mockup.info.MockUpInfoSystem;
import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.infosystem.model.base.SoftwareDependency;
import eu.celar.infosystem.model.base.UserApplication;
import eu.celar.infosystem.model.base.VirtualMachineImage;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.editor.features.CreateMonitorProbeFeature;
import eu.celar.tosca.editor.features.CreateResizeActionFeature;
import eu.celar.tosca.editor.features.CreateSoftwareDependencyFeature;
import eu.celar.tosca.editor.features.CreateUserApplicationFeature;
import eu.celar.tosca.editor.features.CreateVMIFeature;
import eu.celar.tosca.editor.features.RenameApplicationComponentFeature;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ToscaToolBehaviorProvider extends DefaultToolBehaviorProvider {

  /**
   * @param dtp Diagram Type Provider
   */
  public ToscaToolBehaviorProvider( final IDiagramTypeProvider dtp ) {
    super( dtp );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.graphiti.tb.DefaultToolBehaviorProvider#getContextButtonPad(org.eclipse.graphiti.features.context.IPictogramElementContext)
   */
  @Override
  public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
      IContextButtonPadData data = super.getContextButtonPad(context);
      PictogramElement pe = context.getPictogramElement();

      // 1. set the generic context buttons
      // note, that we do not add 'remove' (just as an example)
      setGenericContextButtons(data, pe, CONTEXT_BUTTON_DELETE | CONTEXT_BUTTON_UPDATE);

//      // 2. set the collapse button
//      // simply use a dummy custom feature (senseless example)
//      CustomContext cc = new CustomContext(new PictogramElement[] { pe });
//      ICustomFeature[] cf = getFeatureProvider().getCustomFeatures(cc);
//      for (int i = 0; i < cf.length; i++) {
//          ICustomFeature iCustomFeature = cf[i];
//          if (iCustomFeature instanceof TutorialCollapseDummyFeature) {
//              IContextButtonEntry collapseButton = ContextEntryHelper.createCollapseContextButton(true, iCustomFeature, cc);
//              data.setCollapseContextButton(collapseButton);
//              break;
//          }
//      }

      // 3. add one domain specific context-button, which offers all
      // available connection-features as drag&drop features...

      // 3.a. create new CreateConnectionContext
      CreateConnectionContext ccc = new CreateConnectionContext();
      ccc.setSourcePictogramElement(pe);
      Anchor anchor = null;
      if (pe instanceof Anchor) {
          anchor = (Anchor) pe;
      } else if (pe instanceof AnchorContainer) {
          // assume, that our shapes always have chopbox anchors
          anchor = Graphiti.getPeService().getChopboxAnchor((AnchorContainer) pe);
      }
      ccc.setSourceAnchor(anchor);

      // 3.b. create context button and add all applicable features
      ContextButtonEntry button = new ContextButtonEntry(null, context);
      button.setText("Create connection"); //$NON-NLS-1$      
      ICreateConnectionFeature[] features = getFeatureProvider().getCreateConnectionFeatures();
      for (ICreateConnectionFeature feature : features) {
          if (feature.isAvailable(ccc) && feature.canStartConnection(ccc))
              button.addDragAndDropFeature(feature);
      }

      // 3.c. add context button, if it contains at least one feature
      if (button.getDragAndDropFeatures().size() > 0) {
          data.getDomainSpecificContextButtons().add(button);
      }

      return data;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.graphiti.tb.DefaultToolBehaviorProvider#getPalette()
   */
  @Override
  public IPaletteCompartmentEntry[] getPalette() {
    
      List<IPaletteCompartmentEntry> ret = new ArrayList<IPaletteCompartmentEntry>();

      // add compartments from super class
      IPaletteCompartmentEntry[] superCompartments = super.getPalette();
      for (int i = 0; i < superCompartments.length; i++)
          ret.add(superCompartments[i]);
           
      addGroupingCompartment(ret);
      addBaseMachineImageCompartment (ret);
      addCustomMachineImageCompartment (ret);
      addUserAppsCompartment( ret );
      addSoftwareDependenciesCompartment( ret );
      addMonitorProbeCompartment( ret );
      addResizeActionsCompartment( ret );
       
      return ret.toArray(new IPaletteCompartmentEntry[ret.size()]);
  }
  
  private void addGroupingCompartment(List<IPaletteCompartmentEntry> ret){
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry("Grouping", null); //$NON-NLS-1$
    ret.add(compartmentEntry);
    
    compartmentEntry.addToolEntry(new CustomMarqueSelectionTool());
  }
  
  private void addBaseMachineImageCompartment( List<IPaletteCompartmentEntry> ret ) {
    ArrayList<VirtualMachineImage> vmis = MockUpInfoSystem.getInstance().getBaseMachineImages();

    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry("Base Images", null); //$NON-NLS-1$
    ret.add(compartmentEntry);
    
    for (VirtualMachineImage vmi : vmis) {      
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry(vmi.getName(), vmi.getName(), null);      
      compartmentEntry.addToolEntry(stackEntry);

      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();      
      for (ICreateFeature cf : createFeatures)
      {
        if( cf instanceof CreateVMIFeature ) {
          CreateVMIFeature vmiCF = (CreateVMIFeature) cf;
          vmiCF.setContextObject( vmi );
          ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( vmi.getName(),
                                                                                         vmiCF.getDescription(),
                                                                                         vmiCF.getCreateImageId(),
                                                                                         vmiCF.getCreateLargeImageId(),
                                                                                         vmiCF );
          stackEntry.addCreationToolEntry( objectCreationToolEntry );
        }
          
      }

      // add all create-connection-features to the new stack-entry
      ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
      for (ICreateConnectionFeature cf : createConnectionFeatures) {
          ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry(vmi.getName(),
                  cf.getName(), cf.getCreateImageId(), cf.getCreateLargeImageId());
          connectionCreationToolEntry.addCreateConnectionFeature(cf);
          stackEntry.addCreationToolEntry(connectionCreationToolEntry);
      }

    }
  }
  
  private void addCustomMachineImageCompartment( List<IPaletteCompartmentEntry> ret ) {
    ArrayList<VirtualMachineImage> vmis = MockUpInfoSystem.getInstance().getCustomMachineImages();

    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry("Custom Images", null); //$NON-NLS-1$
    ret.add(compartmentEntry);
    
    for (VirtualMachineImage vmi : vmis) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry(vmi.getName(), vmi.getName(), null);        
      compartmentEntry.addToolEntry(stackEntry);

      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();      
      for (ICreateFeature cf : createFeatures)
      {
        if( cf instanceof CreateVMIFeature ) {
          CreateVMIFeature vmiCF = (CreateVMIFeature) cf;
          vmiCF.setContextObject( vmi );
          ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( vmi.getName(),
                                                                                         vmiCF.getDescription(),
                                                                                         vmiCF.getCreateImageId(),
                                                                                         vmiCF.getCreateLargeImageId(),
                                                                                         vmiCF );
          stackEntry.addCreationToolEntry( objectCreationToolEntry );
        }
          
      }

      // add all create-connection-features to the new stack-entry
      ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
      for (ICreateConnectionFeature cf : createConnectionFeatures) {
          ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry(vmi.getName(),
                  cf.getName(), cf.getCreateImageId(), cf.getCreateLargeImageId());
          connectionCreationToolEntry.addCreateConnectionFeature(cf);
          stackEntry.addCreationToolEntry(connectionCreationToolEntry);
      }

    }
  }
  
  private void addSoftwareDependenciesCompartment( List<IPaletteCompartmentEntry> ret ) {
    ArrayList<SoftwareDependency> swds = MockUpInfoSystem.getInstance().getSoftwareDependencies();

    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry("Software Dependencies", null); //$NON-NLS-1$
    ret.add(compartmentEntry);
    
    for (SoftwareDependency swd : swds) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry(swd.getName(), swd.getName(), null);        
      compartmentEntry.addToolEntry(stackEntry);

      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      
      for (ICreateFeature cf : createFeatures)
      {
        if( cf instanceof CreateSoftwareDependencyFeature ) {
          CreateSoftwareDependencyFeature swdCF = (CreateSoftwareDependencyFeature) cf;
          swdCF.setContextObject( swd );
          ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( swd.getName(),
                                                                                         swdCF.getDescription(),
                                                                                         swdCF.getCreateImageId(),
                                                                                         swdCF.getCreateLargeImageId(),
                                                                                         swdCF );
          stackEntry.addCreationToolEntry( objectCreationToolEntry );
        }
          
      }

      // add all create-connection-features to the new stack-entry
      ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
      for (ICreateConnectionFeature cf : createConnectionFeatures) {
          ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry(swd.getName(),
                  swd.getName(), cf.getCreateImageId(), cf.getCreateLargeImageId());
          connectionCreationToolEntry.addCreateConnectionFeature(cf);
          stackEntry.addCreationToolEntry(connectionCreationToolEntry);
      }

    }
  }
  
  private void addMonitorProbeCompartment( List<IPaletteCompartmentEntry> ret ) {
    ArrayList<MonitoringProbe> mps = MockUpInfoSystem.getInstance().getMonitoringProbes();

    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry("Monitor Probes", null); //$NON-NLS-1$
    ret.add(compartmentEntry);
    
    for (MonitoringProbe mp : mps) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry(mp.getName(), mp.getName(), null);        
      compartmentEntry.addToolEntry(stackEntry);

      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();      
      for (ICreateFeature cf : createFeatures)
      {
        if( cf instanceof CreateMonitorProbeFeature ) {
          CreateMonitorProbeFeature mpCF = (CreateMonitorProbeFeature) cf;
          mpCF.setContextObject( mp );
          ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( mp.getName(),
                                                                                         mpCF.getDescription(),
                                                                                         mpCF.getCreateImageId(),
                                                                                         mpCF.getCreateLargeImageId(),
                                                                                         mpCF );
          stackEntry.addCreationToolEntry( objectCreationToolEntry );
        }
          
      }
      
      // add all create-connection-features to the new stack-entry
      ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
      for (ICreateConnectionFeature cf : createConnectionFeatures) {
          ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry(mp.getName(),
                  cf.getName(), cf.getCreateImageId(), cf.getCreateLargeImageId());
          connectionCreationToolEntry.addCreateConnectionFeature(cf);
          stackEntry.addCreationToolEntry(connectionCreationToolEntry);
      }

    }
  }
  
  private void addUserAppsCompartment(List<IPaletteCompartmentEntry> ret) {
    ArrayList<UserApplication> uApps = MockUpInfoSystem.getInstance().getUserApplications();
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry("User Applications", null); //$NON-NLS-1$
    ret.add(compartmentEntry);
    for (UserApplication app : uApps) {
        // add new stack entry to new compartment
        StackEntry stackEntry = new StackEntry(app.getName(), app.getName(), null);
        compartmentEntry.addToolEntry(stackEntry);
        // add all create-features to the new stack-entry
        IFeatureProvider featureProvider = getFeatureProvider();
        ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
        for (ICreateFeature cf : createFeatures) {
            if (cf instanceof CreateUserApplicationFeature) {
                CreateUserApplicationFeature uaCF = (CreateUserApplicationFeature) cf;

                uaCF.setContextObject(app);
                ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(app.getName(),
                        uaCF.getDescription(), uaCF.getCreateImageId(), uaCF.getCreateLargeImageId(), uaCF);
                stackEntry.addCreationToolEntry(objectCreationToolEntry);
            }
        }
        // add all create-connection-features to the new stack-entry
        ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
        for (ICreateConnectionFeature cf : createConnectionFeatures) {
            ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry(
                    app.getName(), app.getName(), cf.getCreateImageId(), cf.getCreateLargeImageId());
            connectionCreationToolEntry.addCreateConnectionFeature(cf);
            stackEntry.addCreationToolEntry(connectionCreationToolEntry);
        }

    }
}
  
  private void addResizeActionsCompartment( List<IPaletteCompartmentEntry> ret ) {
    ArrayList<ResizingAction> ras = MockUpInfoSystem.getInstance().getResizingActions();

    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry("Resizing Actions", null); //$NON-NLS-1$
    ret.add(compartmentEntry);
    
    for (ResizingAction ra : ras) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry(ra.getName(), ra.getName(), null);        
      compartmentEntry.addToolEntry(stackEntry);

      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();      
      for (ICreateFeature cf : createFeatures)
      {
        if( cf instanceof CreateResizeActionFeature ) {
          CreateResizeActionFeature raCF = (CreateResizeActionFeature) cf;
          raCF.setContextObject( ra );
          ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( ra.getName(),
                                                                                         raCF.getDescription(),
                                                                                         raCF.getCreateImageId(),
                                                                                         raCF.getCreateLargeImageId(),
                                                                                         raCF );
          stackEntry.addCreationToolEntry( objectCreationToolEntry );
        }
          
      }
      
      // add all create-connection-features to the new stack-entry
      ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
      for (ICreateConnectionFeature cf : createConnectionFeatures) {
          ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry(ra.getName(),
                  cf.getName(), cf.getCreateImageId(), cf.getCreateLargeImageId());
          connectionCreationToolEntry.addCreateConnectionFeature(cf);
          stackEntry.addCreationToolEntry(connectionCreationToolEntry);
      }

    }
  }
  
  
  /* (non-Javadoc)
   * @see org.eclipse.graphiti.tb.DefaultToolBehaviorProvider#getContextMenu(org.eclipse.graphiti.features.context.ICustomContext)
   */
  @Override
  public IContextMenuEntry[] getContextMenu(final ICustomContext context) {
      // create a sub-menu for all custom features
      ContextMenuEntry subMenu = new ContextMenuEntry(null, context);
      subMenu.setText("Cu&stom"); //$NON-NLS-1$
      subMenu.setDescription("Custom features submenu"); //$NON-NLS-1$
      // display sub-menu hierarchical or flat
      subMenu.setSubmenu(true);

      // create a menu-entry in the sub-menu for each custom feature
      ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
      for (int i = 0; i < customFeatures.length; i++) {
          ICustomFeature customFeature = customFeatures[i];
          if (customFeature.isAvailable(context)) {
              ContextMenuEntry menuEntry = new ContextMenuEntry(customFeature, context);
              subMenu.add(menuEntry);
          }
      }

      IContextMenuEntry ret[] = new IContextMenuEntry[] { subMenu };
      return ret;
  } 
  
  /* (non-Javadoc)
   * @see org.eclipse.graphiti.tb.DefaultToolBehaviorProvider#getDecorators(org.eclipse.graphiti.mm.pictograms.PictogramElement)
   */
  @Override
  public IDecorator[] getDecorators(final PictogramElement pe) {
      IFeatureProvider featureProvider = getFeatureProvider();
      Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);
      if (bo instanceof TNodeTemplate) {
        TNodeTemplate eClass = (TNodeTemplate) bo;
          String name = eClass.getName();
          if (name != null && name.length() > 0 && !(name.charAt(0) >= 'A' && name.charAt(0) <= 'Z')) {
              IDecorator imageRenderingDecorator = new ImageDecorator(IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK);
              imageRenderingDecorator.setMessage("Name should start with upper case letter"); //$NON-NLS-1$
              return new IDecorator[] { imageRenderingDecorator };
          }
      }

      return super.getDecorators(pe);
  }
  
  @Override
  public ICustomFeature getDoubleClickFeature(final IDoubleClickContext context) { 
    
    ICustomFeature customFeature = new RenameApplicationComponentFeature(getFeatureProvider());
    // canExecute() tests especially if the context contains a EClass
    if (customFeature.canExecute(context)) {
        return customFeature;
    }
    
    return super.getDoubleClickFeature(context);
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.graphiti.tb.DefaultToolBehaviorProvider#getClickArea(org.eclipse.graphiti.mm.pictograms.PictogramElement)
   */
  @Override
  public GraphicsAlgorithm[] getClickArea(final PictogramElement pe) {
      IFeatureProvider featureProvider = getFeatureProvider();
      Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);
      if (bo instanceof TNodeTemplate) {
          GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
          GraphicsAlgorithm rectangle = invisible.getGraphicsAlgorithmChildren().get(0);
          return new GraphicsAlgorithm[] { rectangle };
      }
      return super.getClickArea(pe);
  }

  /* (non-Javadoc)
   * @see org.eclipse.graphiti.tb.DefaultToolBehaviorProvider#getSelectionBorder(org.eclipse.graphiti.mm.pictograms.PictogramElement)
   */
  @Override
  public GraphicsAlgorithm getSelectionBorder(final PictogramElement pe) {
      if (pe instanceof ContainerShape) {
          GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
          if (!invisible.getLineVisible().booleanValue()) {
              EList<GraphicsAlgorithm> graphicsAlgorithmChildren = invisible.getGraphicsAlgorithmChildren();
              if (!graphicsAlgorithmChildren.isEmpty()) {
                  return graphicsAlgorithmChildren.get(0);
              }
          }
      }
      return super.getSelectionBorder(pe);
  }
}
