/************************************************************
 * Copyright (C), 2013 CELAR Consortium 
 * http://www.celarcloud.eu
 * 
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation
 *      Stalo Sofokleous - implementation extension
 ************************************************************/
package eu.celar.tosca.editor.diagram;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.util.EList;
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
import org.eclipse.graphiti.palette.IToolEntry;
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
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.features.CreateMonitorProbeFeature;
import eu.celar.tosca.editor.features.CreateResizeActionFeature;
import eu.celar.tosca.editor.features.CreateSoftwareDependencyFeature;
import eu.celar.tosca.editor.features.CreateUserApplicationFeature;
import eu.celar.tosca.editor.features.CreateVMIFeature;
import eu.celar.tosca.editor.features.RenameApplicationComponentFeature;

public class ToscaToolBehaviorProvider extends DefaultToolBehaviorProvider {

  public ToscaToolBehaviorProvider( final IDiagramTypeProvider dtp ) {
    super( dtp );
  }

  @Override
  public IContextButtonPadData getContextButtonPad( IPictogramElementContext context )
  {
    IContextButtonPadData data = super.getContextButtonPad( context );
    PictogramElement pe = context.getPictogramElement();
    // set the generic context buttons
    // note, that we do not add 'remove' (just as an example)
    setGenericContextButtons( data, pe, CONTEXT_BUTTON_DELETE
                                        | CONTEXT_BUTTON_UPDATE );
    CreateConnectionContext ccc = new CreateConnectionContext();
    ccc.setSourcePictogramElement( pe );
    Anchor anchor = null;
    if( pe instanceof Anchor ) {
      anchor = ( Anchor )pe;
    } else if( pe instanceof AnchorContainer ) {
      // assume, that our shapes always have chopbox anchors
      anchor = Graphiti.getPeService().getChopboxAnchor( ( AnchorContainer )pe );
    }
    ccc.setSourceAnchor( anchor );
    // create context button and add all applicable features
    ContextButtonEntry button = new ContextButtonEntry( null, context );
    button.setText( "Create connection" ); //$NON-NLS-1$      
    ICreateConnectionFeature[] features = getFeatureProvider().getCreateConnectionFeatures();
    for( ICreateConnectionFeature feature : features ) {
      if( feature.isAvailable( ccc ) && feature.canStartConnection( ccc ) )
        button.addDragAndDropFeature( feature );
    }
    // add context button, if it contains at least one feature
    if( button.getDragAndDropFeatures().size() > 0 ) {
      data.getDomainSpecificContextButtons().add( button );
    }
    return data;
  }

  // Creates the Palette. Palette entries are retrieved from an SQL database.
  @Override
  public IPaletteCompartmentEntry[] getPalette() {
    List<IPaletteCompartmentEntry> ret = new ArrayList<IPaletteCompartmentEntry>();
    // add compartments from super class - connections and objects
    IPaletteCompartmentEntry[] superCompartments = super.getPalette();
    for( int i = 0; i < superCompartments.length; i++ ) {
      ret.add( superCompartments[ i ] );
    }
    addBaseMachineImageCompartment( ret );
    addCustomMachineImageCompartment( ret );
    addUserAppsCompartment( ret );
    addSoftwareDependenciesCompartment( ret );
    addResizeActionsCompartment( ret );
    addMonitorProbeCompartment( ret );
    // Only Application Component in Objects compartment
    IToolEntry te = ret.get( 1 ).getToolEntries().get( 0 );
    IToolEntry te2 = ret.get( 1 ).getToolEntries().get( 7 );
    ret.get( 1 ).getToolEntries().clear();
    ret.get( 1 ).getToolEntries().add( te );
    ret.get( 1 ).getToolEntries().add( te2 );
    return ret.toArray( new IPaletteCompartmentEntry[ ret.size() ] );
  }

  // Create Palette compartment for VM Images
  private void addBaseMachineImageCompartment( List<IPaletteCompartmentEntry> ret )
  {
    ArrayList<VirtualMachineImage> vmis = MockUpInfoSystem.getInstance()
      .getBaseMachineImages();
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Base Images", null ); //$NON-NLS-1$
    ret.add( compartmentEntry );
    for( VirtualMachineImage vmi : vmis ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( vmi.getName(),
                                              vmi.getName(),
                                              null );
      compartmentEntry.addToolEntry( stackEntry );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateVMIFeature ) {
          CreateVMIFeature vmiCF = ( CreateVMIFeature )cf;
          
          //vmiCF.setContextObject( vmi );
          
          ///////////////////////////////////////////
          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( vmi.getName() );
          deploymentArtifact.setArtifactType( new QName( "VMI" ) );
          vmiCF.setContextObject( deploymentArtifact );
          ///////////////////////////////////////////
          
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
      for( ICreateConnectionFeature cf : createConnectionFeatures ) {
        ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry( vmi.getName(),
                                                                                                   cf.getName(),
                                                                                                   cf.getCreateImageId(),
                                                                                                   cf.getCreateLargeImageId() );
        connectionCreationToolEntry.addCreateConnectionFeature( cf );
        stackEntry.addCreationToolEntry( connectionCreationToolEntry );
      }
    }
  }

  // Create Palette compartment for Custom Images
  private void addCustomMachineImageCompartment( List<IPaletteCompartmentEntry> ret )
  {
    ArrayList<VirtualMachineImage> vmis = MockUpInfoSystem.getInstance()
      .getCustomMachineImages();
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Custom Images", null ); //$NON-NLS-1$
    ret.add( compartmentEntry );
    for( VirtualMachineImage vmi : vmis ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( vmi.getName(),
                                              vmi.getName(),
                                              null );
      compartmentEntry.addToolEntry( stackEntry );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateVMIFeature ) {
          CreateVMIFeature vmiCF = ( CreateVMIFeature )cf;
          
          //vmiCF.setContextObject( vmi );
          
          ///////////////////////////////////////////
          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( vmi.getName() );
          deploymentArtifact.setArtifactType( new QName( "VMI" ) );
          vmiCF.setContextObject( deploymentArtifact );
          ///////////////////////////////////////////
          
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
      for( ICreateConnectionFeature cf : createConnectionFeatures ) {
        ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry( vmi.getName(),
                                                                                                   cf.getName(),
                                                                                                   cf.getCreateImageId(),
                                                                                                   cf.getCreateLargeImageId() );
        connectionCreationToolEntry.addCreateConnectionFeature( cf );
        stackEntry.addCreationToolEntry( connectionCreationToolEntry );
      }
    }
  }

  // Create Palette compartment for Software Dependencies
  private void addSoftwareDependenciesCompartment( List<IPaletteCompartmentEntry> ret )
  {
    ArrayList<SoftwareDependency> swds = MockUpInfoSystem.getInstance()
      .getSoftwareDependencies();
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Software Dependencies", null ); //$NON-NLS-1$
    ret.add( compartmentEntry );
    for( SoftwareDependency swd : swds ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( swd.getName(),
                                              swd.getName(),
                                              null );
      compartmentEntry.addToolEntry( stackEntry );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateSoftwareDependencyFeature ) {
          CreateSoftwareDependencyFeature swdCF = ( CreateSoftwareDependencyFeature )cf;
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
      for( ICreateConnectionFeature cf : createConnectionFeatures ) {
        ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry( swd.getName(),
                                                                                                   swd.getName(),
                                                                                                   cf.getCreateImageId(),
                                                                                                   cf.getCreateLargeImageId() );
        connectionCreationToolEntry.addCreateConnectionFeature( cf );
        stackEntry.addCreationToolEntry( connectionCreationToolEntry );
      }
    }
  }

  // Create Palette compartment for Monitoring Probes
  private void addMonitorProbeCompartment( List<IPaletteCompartmentEntry> ret )
  {
    ArrayList<MonitoringProbe> mps = MockUpInfoSystem.getInstance()
      .getMonitoringProbes();
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Monitor Probes", null ); //$NON-NLS-1$
    ret.add( compartmentEntry );
    for( MonitoringProbe mp : mps ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( mp.getName(), mp.getName(), null );
      compartmentEntry.addToolEntry( stackEntry );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateMonitorProbeFeature ) {
          CreateMonitorProbeFeature mpCF = ( CreateMonitorProbeFeature )cf;
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
      for( ICreateConnectionFeature cf : createConnectionFeatures ) {
        ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry( mp.getName(),
                                                                                                   cf.getName(),
                                                                                                   cf.getCreateImageId(),
                                                                                                   cf.getCreateLargeImageId() );
        connectionCreationToolEntry.addCreateConnectionFeature( cf );
        stackEntry.addCreationToolEntry( connectionCreationToolEntry );
      }
    }
  }

  // Create Palette compartment for User Applications
  private void addUserAppsCompartment( List<IPaletteCompartmentEntry> ret ) {
    ArrayList<UserApplication> uApps = MockUpInfoSystem.getInstance()
      .getUserApplications();
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "User Applications", null ); //$NON-NLS-1$
    ret.add( compartmentEntry );
    for( UserApplication app : uApps ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( app.getName(),
                                              app.getName(),
                                              null );
      compartmentEntry.addToolEntry( stackEntry );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateUserApplicationFeature ) {
          CreateUserApplicationFeature uaCF = ( CreateUserApplicationFeature )cf;
          uaCF.setContextObject( app );
          ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( app.getName(),
                                                                                         uaCF.getDescription(),
                                                                                         uaCF.getCreateImageId(),
                                                                                         uaCF.getCreateLargeImageId(),
                                                                                         uaCF );
          stackEntry.addCreationToolEntry( objectCreationToolEntry );
        }
      }
      // add all create-connection-features to the new stack-entry
      ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
      for( ICreateConnectionFeature cf : createConnectionFeatures ) {
        ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry( app.getName(),
                                                                                                   app.getName(),
                                                                                                   cf.getCreateImageId(),
                                                                                                   cf.getCreateLargeImageId() );
        connectionCreationToolEntry.addCreateConnectionFeature( cf );
        stackEntry.addCreationToolEntry( connectionCreationToolEntry );
      }
    }
  }

  // Create Palette compartment for Resizing Actions
  private void addResizeActionsCompartment( List<IPaletteCompartmentEntry> ret )
  {
    ArrayList<ResizingAction> ras = MockUpInfoSystem.getInstance()
      .getResizingActions();
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Elasticity Actions", null ); //$NON-NLS-1$
    ret.add( compartmentEntry );
    for( ResizingAction ra : ras ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( ra.getName(), ra.getName(), null );
      compartmentEntry.addToolEntry( stackEntry );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateResizeActionFeature ) {
          CreateResizeActionFeature raCF = ( CreateResizeActionFeature )cf;
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
      for( ICreateConnectionFeature cf : createConnectionFeatures ) {
        ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry( ra.getName(),
                                                                                                   cf.getName(),
                                                                                                   cf.getCreateImageId(),
                                                                                                   cf.getCreateLargeImageId() );
        connectionCreationToolEntry.addCreateConnectionFeature( cf );
        stackEntry.addCreationToolEntry( connectionCreationToolEntry );
      }
    }
  }

  @Override
  public IContextMenuEntry[] getContextMenu( final ICustomContext context ) {
    // create a sub-menu for all custom features
    ContextMenuEntry subMenu = new ContextMenuEntry( null, context );
    subMenu.setText( "Cu&stom" ); //$NON-NLS-1$
    subMenu.setDescription( "Custom features submenu" ); //$NON-NLS-1$
    // display sub-menu hierarchical or flat
    subMenu.setSubmenu( true );
    // create a menu-entry in the sub-menu for each custom feature
    ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures( context );
    for( int i = 0; i < customFeatures.length; i++ ) {
      ICustomFeature customFeature = customFeatures[ i ];
      if( customFeature.isAvailable( context ) ) {
        ContextMenuEntry menuEntry = new ContextMenuEntry( customFeature,
                                                           context );
        subMenu.add( menuEntry );
      }
    }
    IContextMenuEntry ret[] = new IContextMenuEntry[]{
      subMenu
    };
    return ret;
  }

  @Override
  public IDecorator[] getDecorators( final PictogramElement pe ) {
    IFeatureProvider featureProvider = getFeatureProvider();
    Object bo = featureProvider.getBusinessObjectForPictogramElement( pe );
    if( bo instanceof TNodeTemplate ) {
      TNodeTemplate eClass = ( TNodeTemplate )bo;
      String name = eClass.getName();
      if( name != null
          && name.length() > 0
          && !( name.charAt( 0 ) >= 'A' && name.charAt( 0 ) <= 'Z' ) )
      {
        IDecorator imageRenderingDecorator = new ImageDecorator( IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK );
        imageRenderingDecorator.setMessage( "Name should start with upper case letter" ); //$NON-NLS-1$
        return new IDecorator[]{
          imageRenderingDecorator
        };
      }
    }
    return super.getDecorators( pe );
  }

  @Override
  public ICustomFeature getDoubleClickFeature( final IDoubleClickContext context )
  {
    ICustomFeature customFeature = new RenameApplicationComponentFeature( getFeatureProvider() );
    // canExecute() tests especially if the context contains a EClass
    if( customFeature.canExecute( context ) ) {
      return customFeature;
    }
    return super.getDoubleClickFeature( context );
  }

  @Override
  public GraphicsAlgorithm[] getClickArea( final PictogramElement pe ) {
    IFeatureProvider featureProvider = getFeatureProvider();
    Object bo = featureProvider.getBusinessObjectForPictogramElement( pe );
    if( bo instanceof TNodeTemplate ) {
      GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
      GraphicsAlgorithm rectangle = invisible.getGraphicsAlgorithmChildren()
        .get( 0 );
      return new GraphicsAlgorithm[]{
        rectangle
      };
    }
    return super.getClickArea( pe );
  }

  @Override
  public GraphicsAlgorithm getSelectionBorder( final PictogramElement pe ) {
    if( pe instanceof ContainerShape ) {
      GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
      if( !invisible.getLineVisible().booleanValue() ) {
        EList<GraphicsAlgorithm> graphicsAlgorithmChildren = invisible.getGraphicsAlgorithmChildren();
        if( !graphicsAlgorithmChildren.isEmpty() ) {
          return graphicsAlgorithmChildren.get( 0 );
        }
      }
    }
    return super.getSelectionBorder( pe );
  }
}
