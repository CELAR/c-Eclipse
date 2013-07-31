/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.internal.actions;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.ResourceUtil;

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudRoot;
import eu.celar.ui.internal.Activator;
import eu.celar.ui.views.CloudModelViewPart;


/**
 * @author Nicholas Loulloudes
 *
 */
public class LinkWithEditorAction extends Action {
  
  private CloudModelViewPart view;

  protected LinkWithEditorAction( final CloudModelViewPart view ) {
    super( Messages.getString("LinkWithEditorAction.link_with_editor_action_text"), IAction.AS_CHECK_BOX ); //$NON-NLS-1$
    this.view = view;
    URL imgUrl = Activator.getDefault().getBundle().getEntry( "icons/elcl16/synced.gif" ); //$NON-NLS-1$
    setImageDescriptor( ImageDescriptor.createFromURL( imgUrl ) );
  }

  @Override
  public void run() {
    if ( isChecked() ) {
      IWorkbenchPage workbenchPage = this.view.getViewSite().getPage();
      if ( workbenchPage.isPartVisible( this.view ) ) {
        IEditorPart editor = workbenchPage.getActiveEditor();
        if ( editor != null ) {
          IEditorInput input = editor.getEditorInput();
          IFile file = ResourceUtil.getFile(input);
          if (file != null) {
            ICloudRoot CloudRoot = CloudModel.getRoot();
            ICloudElement CloudElement = CloudRoot.findElement( file );
            if ( CloudElement != null ) {
              StructuredViewer viewer = this.view.getViewer();
              ISelection selection = new StructuredSelection( CloudElement );
              viewer.setSelection( selection );
            }
          }
        }
      }
    }
  }
  
}
