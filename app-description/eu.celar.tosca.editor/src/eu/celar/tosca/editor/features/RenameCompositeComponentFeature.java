/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes, Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.editor.ModelHandler;
import eu.celar.tosca.editor.ToscaModelLayer;

public class RenameCompositeComponentFeature extends AbstractCustomFeature {

  private boolean hasDoneChanges = false;

  public RenameCompositeComponentFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  @Override
  public String getName() {
    return "Re&name Composite Component"; //$NON-NLS-1$
  }

  @Override
  public String getDescription() {
    return "Change the name of the Composite Component"; //$NON-NLS-1$
  }

  @Override
  public boolean canExecute( final ICustomContext context ) {
    // allow rename if exactly one pictogram element
    // representing an EClass is selected
    boolean ret = false;
    PictogramElement[] pes = context.getPictogramElements();
    if( pes != null && pes.length == 1 ) {
      Object bo = getBusinessObjectForPictogramElement( pes[ 0 ] );
      if( bo instanceof TServiceTemplate ) {
        ret = true;
      }
    }
    return ret;
  }

  // Open rename Application Component Name Dialog
  @Override
  public void execute( final ICustomContext context ) {
    PictogramElement[] pes = context.getPictogramElements();
    if( pes != null && pes.length == 1 ) {
      Object bo = getBusinessObjectForPictogramElement( pes[ 0 ] );
      TServiceTemplate tServiceTemplate = ( TServiceTemplate )bo;
      String currentName = tServiceTemplate.getName();
      // ask user for a new application component name
      String newName = null;
      Shell shell = PlatformUI.getWorkbench()
        .getActiveWorkbenchWindow()
        .getShell();
      InputDialog inputDialog = new InputDialog( shell,
                                                 "Rename Composite Component",
                                                 getDescription(),
                                                 currentName,
                                                 null );
      int newNameDialog = inputDialog.open();
      if( newNameDialog == Window.OK ) {
        newName = inputDialog.getValue();
      }
      if( newName != null && !newName.equals( currentName ) ) {
        this.hasDoneChanges = true;
        tServiceTemplate.setName( newName );

        tServiceTemplate.setSubstitutableNodeType(new QName("substituteNode_"+newName));
        
        // Find the substitute TNodeTemplate
        TNodeTemplate substituteNode = null;
        ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
        for (TNodeTemplate tempNodeTemplate : model.getDocumentRoot()
          .getDefinitions()
          .getServiceTemplate()
          .get( 0 )
          .getTopologyTemplate()
          .getNodeTemplate()){
           
          if (tempNodeTemplate.getId().equals( tServiceTemplate.getId()) )
          {
            substituteNode = tempNodeTemplate;
            break;
          }

        }
        
        substituteNode.setType(new QName("substituteNode_"+newName));
        
        updatePictogramElement( pes[ 0 ] );
      }
    }
  }

  @Override
  public boolean hasDoneChanges() {
    return this.hasDoneChanges;
  }
}
