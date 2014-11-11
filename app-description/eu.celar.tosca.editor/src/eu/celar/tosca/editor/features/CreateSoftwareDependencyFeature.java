/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import java.io.File;

import javax.xml.namespace.QName;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
// import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;

import eu.celar.tosca.ArtifactReferencesType;
import eu.celar.tosca.DefinitionsType;
import eu.celar.tosca.ImplementationArtifactType;
import eu.celar.tosca.PropertiesType;
import eu.celar.tosca.TArtifactReference;
import eu.celar.tosca.TArtifactTemplate;
import eu.celar.tosca.TImplementationArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TNodeTypeImplementation;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;
import eu.celar.tosca.elasticity.ScriptArtifactPropertiesType;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import eu.celar.tosca.elementCreators.CreateArtifactTemplate;

public class CreateSoftwareDependencyFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateSoftwareDependencyFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Software Dependency", "Software Dependency" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if user can create a software dependency object in the target
  // business object
  @Override
  public boolean canCreate( final ICreateContext context ) {
    return !( context.getTargetContainer() instanceof Diagram );
  }

  // Creates the business object for the software dependency
  @Override
  public Object[] create( final ICreateContext context ) {
    if( this.contextObject == null )
      return null;
    Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    TNodeTemplate tNode = null;
    if( parentObject == null )
      return null;
    if( parentObject instanceof TNodeTemplate ) {
      tNode = ( TNodeTemplate )parentObject;
    }
    if( tNode.getName() == null ) {
      MessageDialog.openError( null,
                               "Error",
                               "Give a Name to the selected Component and try again." );
      return null;
    }
    TArtifactTemplate artifactTemplate = ( TArtifactTemplate )this.contextObject;
    // Create Script Artifact Template
    CreateArtifactTemplate artTempl = new CreateArtifactTemplate(artifactTemplate.getId(), ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) ));
    TArtifactTemplate newArtifactTemplate = artTempl.getNewArtifactTemplate();
    
    // Create Implementation Artifact
    createImplementationArtifact( new QName( tNode.getName() ),
                                  new QName( artifactTemplate.getId()) );
            
    //addGraphicalRepresentation( context, artifactTemplate );
    addGraphicalRepresentation( context, newArtifactTemplate );
    
    // activate direct editing after object creation
    getFeatureProvider().getDirectEditingInfo().setActive( true );
    // return newly created business object(s)
    return new Object[]{
      newArtifactTemplate
    };
  }

  // Creates the install implementation artifact
  private void createImplementationArtifact( QName nodeType,
                                                                   QName artifactID )
  {

    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    DefinitionsType definitions = model.getDocumentRoot().getDefinitions();
    
    TNodeTypeImplementation nodeTypeImplementation = null;
    // Test if NodeTypeImplementation for nodeType already exists
    for( TNodeTypeImplementation tempNodeTypeImplementation : definitions.getNodeTypeImplementation() )
    {
      if( tempNodeTypeImplementation.getNodeType()
        .toString()
        .equals( nodeType.toString() ) )
      {
        // NodeTypeImplementation already exists
        // We are going to add the artifact to the existing implementation
        nodeTypeImplementation = tempNodeTypeImplementation;
      }
    }
    if( nodeTypeImplementation == null ) {
      // NodeTypeImplementation does not exists
      final TNodeTypeImplementation newNodeTypeImplementation = ToscaFactory.eINSTANCE.createTNodeTypeImplementation();
      newNodeTypeImplementation.setNodeType( nodeType );
      newNodeTypeImplementation.setName( "name" );
      TImplementationArtifacts implementationArtifacts = ToscaFactory.eINSTANCE.createTImplementationArtifacts();
      newNodeTypeImplementation.setImplementationArtifacts( implementationArtifacts );
      
      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( definitions );
      editingDomain.getCommandStack()
        .execute( new RecordingCommand( editingDomain ) {

          @Override
          protected void doExecute() {
            model.getDocumentRoot().getDefinitions().getNodeTypeImplementation()
              .add( newNodeTypeImplementation );
          }
        } );
      
      nodeTypeImplementation = newNodeTypeImplementation;
    }
    // Create Implementation Artifact
    final ImplementationArtifactType installArtifactType = ToscaFactory.eINSTANCE.createImplementationArtifactType();
    installArtifactType.setArtifactType( new QName( "ScriptArtifact" ) );
    installArtifactType.setArtifactRef( artifactID );
    installArtifactType.setInterfaceName( "Lifecycle" );
    installArtifactType.setOperationName( "execute" );
    final TNodeTypeImplementation nodeImplementation = nodeTypeImplementation;
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nodeTypeImplementation );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          nodeImplementation.getImplementationArtifacts()
            .getImplementationArtifact()
            .add( installArtifactType );
        }
      } );
  }
}
