/************************************************************
 * Copyright (C), 2013 CELAR Consortium 
 * http://www.celarcloud.eu
 * 
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation
 *      Stalo Sofokleous - implementation extension
 ************************************************************/
package eu.celar.tosca.editor.diagram;

import javax.xml.namespace.QName;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import eu.celar.core.model.impl.ResourceCloudElement;
import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.tosca.TArtifactTemplate;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TRelationshipTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.features.AddApplicationComponentFeature;
import eu.celar.tosca.editor.features.AddDirectedRelationFeature;
import eu.celar.tosca.editor.features.AddGroupFeature;
import eu.celar.tosca.editor.features.AddKeyPairFeature;
import eu.celar.tosca.editor.features.AddMonitorProbeFeature;
import eu.celar.tosca.editor.features.AddResizingActionFeature;
import eu.celar.tosca.editor.features.AddServiceTemplateFeature;
import eu.celar.tosca.editor.features.AddSoftwareDependencyFeature;
import eu.celar.tosca.editor.features.AddUserApplicationFeature;
import eu.celar.tosca.editor.features.AddVirtualMachineFeature;
import eu.celar.tosca.editor.features.CreateApplicationComponentFeature;
import eu.celar.tosca.editor.features.CreateDirectedRelationFeature;
import eu.celar.tosca.editor.features.CreateGroupFeature;
import eu.celar.tosca.editor.features.CreateKeyPairFeature;
import eu.celar.tosca.editor.features.CreateMonitorProbeFeature;
import eu.celar.tosca.editor.features.CreateResizeActionFeature;
import eu.celar.tosca.editor.features.CreateServiceTemplateFeature;
import eu.celar.tosca.editor.features.CreateSoftwareDependencyFeature;
import eu.celar.tosca.editor.features.CreateUserApplicationFeature;
import eu.celar.tosca.editor.features.CreateVMIFeature;
import eu.celar.tosca.editor.features.DeleteApplicationComponentFeature;
import eu.celar.tosca.editor.features.DeleteArtifactTemplateFeature;
import eu.celar.tosca.editor.features.DeleteDeploymentArtifactFeature;
import eu.celar.tosca.editor.features.DeleteGroupFeature;
import eu.celar.tosca.editor.features.DirectEditApplicationComponentFeature;
import eu.celar.tosca.editor.features.DirectEditCompositeComponentFeature;
import eu.celar.tosca.editor.features.LayoutApplicationComponentFeature;
import eu.celar.tosca.editor.features.LayoutServiceTemplateFeature;
import eu.celar.tosca.editor.features.MoveApplicationComponentFeature;
import eu.celar.tosca.editor.features.MoveCompositeComponentFeature;
import eu.celar.tosca.editor.features.RenameApplicationComponentFeature;
import eu.celar.tosca.editor.features.RenameCompositeComponentFeature;
import eu.celar.tosca.editor.features.ResizeApplicationComponentFeature;
import eu.celar.tosca.editor.features.ResizeCompositeComponentFeature;
import eu.celar.tosca.editor.features.UpdateApplicationComponentFeature;
import eu.celar.tosca.editor.features.UpdateCompositeComponentFeature;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

public class ToscaFeatureProvider extends DefaultFeatureProvider {
  
  private String imageType = Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getImageArtifactPropertiesType().getName();

  public ToscaFeatureProvider( final IDiagramTypeProvider dtp ) {
    super( dtp );
  }

  // Returns the add feature for the context
  @Override
  public IAddFeature getAddFeature( final IAddContext context ) {    
    if( context.getNewObject() instanceof TNodeTemplate ) {
      return new AddApplicationComponentFeature( this );
    } 
    else if( context.getNewObject() instanceof TRelationshipTemplate ) {
      return new AddDirectedRelationFeature( this );
    } else if( context.getNewObject() instanceof TDeploymentArtifact ) {
      if (((TDeploymentArtifact)context.getNewObject()).getArtifactType().toString().compareTo( "UA" )==0)
          return new AddUserApplicationFeature( this );
      else if (((TDeploymentArtifact)context.getNewObject()).getArtifactType().getLocalPart().compareTo( imageType )==0)
        return new AddVirtualMachineFeature( this );
      else if (((TDeploymentArtifact)context.getNewObject()).getArtifactType().toString().compareTo( "KeyPair" )==0)
        return new AddKeyPairFeature( this );
      else if (((TDeploymentArtifact)context.getNewObject()).getArtifactType().toString().compareTo( "MonitoringProbe" )==0)
        return new AddMonitorProbeFeature( this );
      
    }else if (context.getNewObject() instanceof TArtifactTemplate){
      if (((TArtifactTemplate)context.getNewObject()).getName()!=null && ((TArtifactTemplate)context.getNewObject()).getName().contains( "SD" ))
        return new AddSoftwareDependencyFeature( this );
    }
    
    else if( context.getNewObject() instanceof ResourceCloudElement) {
            
      return getIFileFeature(context);
    }
    else if( context.getNewObject() instanceof ResizingAction ) {
      return new AddResizingActionFeature( this );
    } 
    // its a substitutional Service Template
    else if( context.getNewObject() instanceof TServiceTemplate
        && ( ( TServiceTemplate )context.getNewObject() ).getSubstitutableNodeType() != null )
    {
      return new AddGroupFeature( this );
    } else if( context.getNewObject() instanceof TServiceTemplate ) {
      return new AddServiceTemplateFeature( this );
    } 
    return super.getAddFeature( context );
  }

  /**
   * @return
   */
  private AbstractAddShapeFeature getIFileFeature(final IAddContext context) {
    ResourceCloudElement element = (ResourceCloudElement) context.getNewObject();
    AbstractAddShapeFeature result = null;
    
    String extension = element.getResource().getFileExtension();
    System.out.println(extension);

    if (extension.equals( "pub" )) { //$NON-NLS-1$
      // Call the Create User Application Feature to create a deployment artifact for the deployment script and add it to the artifacts list 
      CreateKeyPairFeature createKPFeature = new CreateKeyPairFeature( new ToscaFeatureProvider(getDiagramTypeProvider()) );
      
      TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
      deploymentArtifact.setName( element.getName() );
      deploymentArtifact.setArtifactType( new QName( "KeyPair" ) );  
      
      createKPFeature.setContextObject( deploymentArtifact );
      
      CreateContext createContext = new CreateContext();
      createContext.setTargetContainer( context.getTargetContainer()  );
      
      if ( createKPFeature.canCreate( createContext )){
        createKPFeature.create( createContext );
      }
      
    }
    
    return result;
  }
  

  // Initializes all create features
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
      new CreateGroupFeature( this ),
      new CreateKeyPairFeature( this )
    };
  }

  // Custom delete feature for application components and composite components
  @Override
  public IDeleteFeature getDeleteFeature(IDeleteContext context){
    PictogramElement pictogramElement = context.getPictogramElement();
    Object bo = getBusinessObjectForPictogramElement( pictogramElement );
    if( bo instanceof TServiceTemplate ) {
      //TServiceTemplate representing Composite Component
      return new DeleteGroupFeature( this );
    }
    else if (bo instanceof TNodeTemplate){
      return new DeleteApplicationComponentFeature( this );
    }
    else if ( bo instanceof TDeploymentArtifact){
      return new DeleteDeploymentArtifactFeature( this );
    }else if (bo instanceof TArtifactTemplate){
      if (((TArtifactTemplate)bo).getName()!=null && ((TArtifactTemplate)bo).getName().contains( "SD" ))
        return new DeleteArtifactTemplateFeature( this );
    }
      
    return super.getDeleteFeature( context );
  }
  
  // Enables direct editing
  @Override
  public IDirectEditingFeature getDirectEditingFeature( final IDirectEditingContext context )
  {
    PictogramElement pe = context.getPictogramElement();
    Object bo = getBusinessObjectForPictogramElement( pe );
    if( bo instanceof TNodeTemplate ) {
      return new DirectEditApplicationComponentFeature( this );
    }
    else if( bo instanceof TServiceTemplate ) {
      return new DirectEditCompositeComponentFeature( this );
    }
    return super.getDirectEditingFeature( context );
  }

  // Returns layout features
  @Override
  public ILayoutFeature getLayoutFeature( final ILayoutContext context ) {
    PictogramElement pictogramElement = context.getPictogramElement();
    Object bo = getBusinessObjectForPictogramElement( pictogramElement );
    if( bo instanceof TNodeTemplate ) {
      return new LayoutApplicationComponentFeature( this );
    }
    if ( bo instanceof TServiceTemplate ){
      return new LayoutServiceTemplateFeature( this );
    }
    return super.getLayoutFeature( context );
  }

  // Enables update features
  @Override
  public IUpdateFeature getUpdateFeature( final IUpdateContext context ) {
    PictogramElement pictogramElement = context.getPictogramElement();
    if( pictogramElement instanceof ContainerShape ) {
      Object bo = getBusinessObjectForPictogramElement( pictogramElement );
      if( bo instanceof TNodeTemplate ) {
        return new UpdateApplicationComponentFeature( this );
      }
      else if( bo instanceof TServiceTemplate ) {
        return new UpdateCompositeComponentFeature( this );
      }
    }
    return super.getUpdateFeature( context );
  }

  // Enables moving of figures
  @Override
  public IMoveShapeFeature getMoveShapeFeature( final IMoveShapeContext context )
  {
    Shape shape = context.getShape();
    Object bo = getBusinessObjectForPictogramElement( shape );
    if( bo instanceof TNodeTemplate ) {
      return new MoveApplicationComponentFeature( this );
    }
    if ( bo instanceof TServiceTemplate ){
      return new MoveCompositeComponentFeature( this );
    }
    return super.getMoveShapeFeature( context );
  }

  // Feature for renaming application components
  @Override
  public ICustomFeature[] getCustomFeatures( ICustomContext context ) {
    return new ICustomFeature[]{
      new RenameApplicationComponentFeature( this ),
      new RenameCompositeComponentFeature( this ),
    };
  }

  // Initializes relationships' create features
  @Override
  public ICreateConnectionFeature[] getCreateConnectionFeatures() {
    return new ICreateConnectionFeature[]{
      new CreateDirectedRelationFeature( this )
//      ,
//      new CreateBidirectionalRelationFeature( this )
    };
  }
  
  @Override
  public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
      Shape shape = context.getShape();
      Object bo = getBusinessObjectForPictogramElement(shape);
      if (bo instanceof TNodeTemplate) {
        return new ResizeApplicationComponentFeature(this);
      }
      if (bo instanceof TServiceTemplate){
        return new ResizeCompositeComponentFeature(this);
      }
      return super.getResizeShapeFeature(context);
  }
}
