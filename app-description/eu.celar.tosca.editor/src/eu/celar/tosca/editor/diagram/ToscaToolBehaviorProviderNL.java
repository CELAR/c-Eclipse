/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation Stalo Sofokleous -
 * implementation extension
 ************************************************************/
package eu.celar.tosca.editor.diagram;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.namespace.QName;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
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
import eu.celar.infosystem.model.base.InfoSystemFactory;
import eu.celar.infosystem.model.base.KeyPair;
import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.infosystem.model.base.SoftwareDependency;
import eu.celar.infosystem.model.base.UserApplication;
import eu.celar.infosystem.model.base.VirtualMachineImage;
import eu.celar.infosystem.model.base.VirtualMachineImageType;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ToscaDiagramEditor;
import eu.celar.tosca.editor.features.CreateKeyPairFeature;
import eu.celar.tosca.editor.features.CreateMonitorProbeFeature;
import eu.celar.tosca.editor.features.CreateResizeActionFeature;
import eu.celar.tosca.editor.features.CreateSoftwareDependencyFeature;
import eu.celar.tosca.editor.features.CreateUserApplicationFeature;
import eu.celar.tosca.editor.features.CreateVMIFeature;
import eu.celar.tosca.editor.features.RenameApplicationComponentFeature;

public class ToscaToolBehaviorProviderNL extends DefaultToolBehaviorProvider {

  public ToscaToolBehaviorProviderNL( final IDiagramTypeProvider dtp ) {
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

  /**
   * 
   */
  private void fetchResources() {
    Job job = new Job( "Resource Fetching" ) { //$NON-NLS-1$

      @Override
      protected IStatus run( final IProgressMonitor monitor ) {
        monitor.beginTask( "Fetching Resources from Cloud Provider", 100 );
        MockUpInfoSystem.getInstance();
        for( int i = 0; i < 5; i++ ) {
          try {
            // sleep a second
            TimeUnit.SECONDS.sleep( 1 );
            monitor.subTask( "Resource bundle #" + i );
            // report that 20 additional units are done
            monitor.worked( 20 );
          } catch( InterruptedException e1 ) {
            e1.printStackTrace();
            return Status.CANCEL_STATUS;
          }
        }
        System.out.println( "Called save" );
        return Status.OK_STATUS;
      }
    };
    job.schedule();
  }

  // Creates the Palette. Palette entries are retrieved from an SQL database.
  @Override
  public IPaletteCompartmentEntry[] getPalette() {
    //    Job job = new Job("Resource Fetching") { //$NON-NLS-1$
    //
    // @Override
    // protected IStatus run( final IProgressMonitor monitor ) {
    //
    // monitor.beginTask("Fetching Resources from Cloud Provider", 100);
    // MockUpInfoSystem.getInstance();
    // for (int i = 0; i < 5; i++) {
    // try {
    // // sleep a second
    // TimeUnit.SECONDS.sleep(1);
    //
    // monitor.subTask("Resource bundle #" + i);
    //
    // // report that 20 additional units are done
    // monitor.worked(20);
    // } catch (InterruptedException e1) {
    // e1.printStackTrace();
    // return Status.CANCEL_STATUS;
    // }
    // }
    // return Status.OK_STATUS;
    // }
    // };
    // job.setUser( true );
    // job.schedule();
    // // TODO nickl - Workaround for resource fetcher in UI. should be done in
    // the background
    // fetchResources();
    // MockUpInfoSystem.getInstance();
    List<IPaletteCompartmentEntry> ret = new ArrayList<IPaletteCompartmentEntry>();
    // add compartments from super class - connections and objects
    IPaletteCompartmentEntry[] superCompartments = super.getPalette();
    for( int i = 0; i < superCompartments.length; i++ ) {
      if( superCompartments[ i ].getLabel().equals( "Objects" ) ) {
        PaletteCompartmentEntry appCompartment = getApplicationComponentCompartment( ret );
        appCompartment.getToolEntries()
          .addAll( superCompartments[ i ].getToolEntries() );
        ret.add( appCompartment );
      } else {
        ret.add( superCompartments[ i ] );
      }
    }
    // addBaseMachineImageCompartment( ret );
    addCustomMachineImageCompartment( ret );
    addUserAppsCompartment( ret );
    // addSoftwareDependenciesCompartment( ret );
    addKeyPairCompartment( ret );
    addDeployScriptCompartment( ret );
    addMonitorProbeCompartment( ret );
    addResizeActionsCompartment( ret );
    // Only Application Component in Objects compartment
    IToolEntry te = ret.get( 1 ).getToolEntries().get( 0 );
    IToolEntry te2 = ret.get( 1 ).getToolEntries().get( 7 );
    ret.get( 1 ).getToolEntries().clear();
    ret.get( 1 ).getToolEntries().add( te );
    ret.get( 1 ).getToolEntries().add( te2 );
    return ret.toArray( new IPaletteCompartmentEntry[ ret.size() ] );
  }

  /**
   * @param ret
   */
  private PaletteCompartmentEntry getApplicationComponentCompartment( final List<IPaletteCompartmentEntry> ret )
  {
    return new PaletteCompartmentEntry( "Components", null ); //$NON-NLS-1$
  }

  /**
   * @param ret
   */
  private void addDeployScriptCompartment( List<IPaletteCompartmentEntry> ret )
  {
    ArrayList<SoftwareDependency> deployScriptsList = new ArrayList<SoftwareDependency>();
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    if( activeProject != null ) {
      IFolder artifactsFolder = activeProject.getFolder( "/Artifacts/Deployment Scripts" );
      IResource[] artifactsResource = null;
      try {
        artifactsResource = artifactsFolder.members();
      } catch( CoreException e ) {
        e.printStackTrace();
      }
      for( IResource tempResource : artifactsResource ) {
        if( tempResource instanceof IFile ) {
          IFile file = ( IFile )tempResource;
          if( !file.getFileExtension().equals( "sh" ) )
            continue;
          SoftwareDependency sd = InfoSystemFactory.eINSTANCE.createSoftwareDependency();
          sd.setName( file.getName() );
          sd.setURL( file.getFullPath().toString() );
          sd.setDescription( file.getName() );
          // add new keypair to list
          deployScriptsList.add( sd );
        }
      }
      // add new compartment at the end of the existing compartments
      PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Deployment Scripts", null ); //$NON-NLS-1$
      ret.add( compartmentEntry );
      // TODO - nickl: Fix below. It should be Scripts and not Software
      // dependency. Maybe update sysinfo model.
      for( SoftwareDependency script : deployScriptsList ) {
        // add all create-features to the new stack-entry
        IFeatureProvider featureProvider = getFeatureProvider();
        ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
        for( ICreateFeature cf : createFeatures ) {
          if( cf instanceof CreateSoftwareDependencyFeature ) {
            CreateSoftwareDependencyFeature sdCF = ( CreateSoftwareDependencyFeature )cf;
            // /////////////////////////////////////////
            TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
            deploymentArtifact.setName( script.getName() );
            deploymentArtifact.setArtifactType( new QName( "SD" ) );
            sdCF.setContextObject( deploymentArtifact );
            // add new stack entry to new compartment
            IToolEntry entry = new ObjectCreationToolEntry( script.getName(),
                                                            script.getDescription(),
                                                            null,
                                                            null,
                                                            sdCF );
            compartmentEntry.addToolEntry( entry );
          }
        }
      }
    }
  }

  /**
   * @param ret
   */
  private void addKeyPairCompartment( List<IPaletteCompartmentEntry> ret ) {
    ArrayList<KeyPair> keyPairList = new ArrayList<KeyPair>();
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    if( activeProject != null ) {
      IFolder artifactsFolder = activeProject.getFolder( "/Artifacts/Deployment Scripts" );
      IResource[] artifactsResource = null;
      try {
        artifactsResource = artifactsFolder.members();
      } catch( CoreException e ) {
        e.printStackTrace();
      }
      for( IResource tempResource : artifactsResource ) {
        if( tempResource instanceof IFile ) {
          IFile file = ( IFile )tempResource;
          if( !file.getFileExtension().equals( "pub" ) )
            continue;
          KeyPair kp = InfoSystemFactory.eINSTANCE.createKeyPair();
          kp.setName( file.getName() );
          kp.setURL( file.getFullPath().toString() );
          kp.setDescription( file.getName() );
          // add new keypair to list
          keyPairList.add( kp );
        }
      }
      // add new compartment at the end of the existing compartments
      PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Key Pairs", null ); //$NON-NLS-1$
      ret.add( compartmentEntry );
      for( KeyPair keyPair : keyPairList ) {
        // add all create-features to the new stack-entry
        IFeatureProvider featureProvider = getFeatureProvider();
        ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
        for( ICreateFeature cf : createFeatures ) {
          if( cf instanceof CreateKeyPairFeature ) {
            CreateKeyPairFeature kpCF = ( CreateKeyPairFeature )cf;
            // /////////////////////////////////////////
            TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
            deploymentArtifact.setName( keyPair.getName() );
            deploymentArtifact.setArtifactType( new QName( "KeyPair" ) );
            kpCF.setContextObject( deploymentArtifact );
            // ///////////////////////////////////////////
            // ObjectCreationToolEntry objectCreationToolEntry = new
            // ObjectCreationToolEntry( kpCF.getName(),
            // kpCF.getDescription(),
            // kpCF.getCreateImageId(),
            // kpCF.getCreateLargeImageId(),
            // kpCF );
            // add new stack entry to new compartment
            IToolEntry entry = new ObjectCreationToolEntry( keyPair.getName(),
                                                            keyPair.getDescription(),
                                                            null,
                                                            null,
                                                            kpCF );
            compartmentEntry.addToolEntry( entry );
          }
        }
      }
    }
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
      compartmentEntry.setInitiallyOpen( false );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateVMIFeature ) {
          CreateVMIFeature vmiCF = ( CreateVMIFeature )cf;
          // vmiCF.setContextObject( vmi );
          // /////////////////////////////////////////
          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( vmi.getName() );
          deploymentArtifact.setArtifactType( new QName( "VMI" ) );
          vmiCF.setContextObject( deploymentArtifact );
          // /////////////////////////////////////////
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
    ArrayList<VirtualMachineImage> vmisCopy = ( ArrayList<VirtualMachineImage> )vmis.clone();
    // Add custom images from project explorer
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    if( activeProject != null ) {
      IFolder artifactsFolder = activeProject.getFolder( "/Artifacts/Virtual Machine Images" );
      IResource[] artifactsResource = null;
      try {
        artifactsResource = artifactsFolder.members();
      } catch( CoreException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      for( IResource tempResource : artifactsResource ) {
        if( tempResource instanceof IFile ) {
          VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
          vmi.setUID( "1" );
          vmi.setName( tempResource.getName() );
          vmi.setDescription( "h" );
          vmi.setURL( "h" );
          vmi.setType( VirtualMachineImageType.BASE_IMAGE );
          // add new base vmi to images list
          vmisCopy.add( vmi );
        }
      }
    }
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Images", null ); //$NON-NLS-1$
    compartmentEntry.setInitiallyOpen( false );
    ret.add( compartmentEntry );
    for( VirtualMachineImage vmi : vmisCopy ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( vmi.getUID(), vmi.getName(), null );
      compartmentEntry.addToolEntry( stackEntry );
      compartmentEntry.setInitiallyOpen( true );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateVMIFeature ) {
          CreateVMIFeature vmiCF = ( CreateVMIFeature )cf;
          // vmiCF.setContextObject( vmi );
          // /////////////////////////////////////////
          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( vmi.getUID() );
          deploymentArtifact.setArtifactType( new QName( "VMI" ) );
          vmiCF.setContextObject( deploymentArtifact );
          // /////////////////////////////////////////
          ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( vmi.getUID(),
                                                                                         vmiCF.getName(),
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
      compartmentEntry.setInitiallyOpen( false );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateSoftwareDependencyFeature ) {
          CreateSoftwareDependencyFeature swdCF = ( CreateSoftwareDependencyFeature )cf;
          // /////////////////////////////////////////
          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( swd.getName() );
          deploymentArtifact.setArtifactType( new QName( "SD" ) );
          swdCF.setContextObject( deploymentArtifact );
          // /////////////////////////////////////////
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
                                                                                                   cf.getName(),
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
      compartmentEntry.setInitiallyOpen( false );
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
  private void addUserAppsCompartment( final List<IPaletteCompartmentEntry> ret )
  {
    ArrayList<UserApplication> uApps = MockUpInfoSystem.getInstance()
      .getUserApplications();
    ArrayList<UserApplication> uAppsCopy = ( ArrayList<UserApplication> )uApps.clone();
    // Add custom images from project explorer
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    if( activeProject != null ) {
      IFolder artifactsFolder = activeProject.getFolder( "/Artifacts/Applications" );
      IResource[] artifactsResource = null;
      try {
        artifactsResource = artifactsFolder.members();
      } catch( CoreException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      for( IResource tempResource : artifactsResource ) {
        if( tempResource instanceof IFile ) {
          UserApplication ua = InfoSystemFactory.eINSTANCE.createUserApplication();
          ua.setUID( "1" );
          ua.setName( tempResource.getName() );
          ua.setDescription( "h" );
          ua.setURL( "h" );
          ua.setType( "UA" );
          // add new base vmi to images list
          uAppsCopy.add( ua );
        }
      }
    }
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "User Applications", null ); //$NON-NLS-1$
    ret.add( compartmentEntry );
    for( UserApplication app : uAppsCopy ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( app.getName(),
                                              app.getName(),
                                              null );
      compartmentEntry.addToolEntry( stackEntry );
      compartmentEntry.setInitiallyOpen( true );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateUserApplicationFeature ) {
          CreateUserApplicationFeature uaCF = ( CreateUserApplicationFeature )cf;
          // /////////////////////////////////////////
          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( app.getName() );
          deploymentArtifact.setArtifactType( new QName( "UA" ) );
          uaCF.setContextObject( deploymentArtifact );
          // /////////////////////////////////////////
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
                                                                                                   cf.getName(),
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
      compartmentEntry.setInitiallyOpen( false );
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