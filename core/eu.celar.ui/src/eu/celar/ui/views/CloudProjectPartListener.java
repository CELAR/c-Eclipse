/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.views;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;

import eu.celar.ui.internal.actions.EditorActions;


public class CloudProjectPartListener implements IPartListener2 {

private EditorActions editorActions;
  
  protected CloudProjectPartListener( final EditorActions editorActions ) {
    this.editorActions = editorActions;
  }

  public void partActivated( final IWorkbenchPartReference partRef ) {
    if ( partRef.getPart( true ) instanceof IEditorPart ) {
      this.editorActions.delegateLinkEditorAction();
    }
  }

  public void partBroughtToTop( final IWorkbenchPartReference partRef ) {
    if ( partRef.getPart( true ) == this.editorActions.getView() ) {
      this.editorActions.delegateLinkEditorAction();
    }
  }

  public void partClosed( final IWorkbenchPartReference partRef ) {
    // empty implementation
  }

  public void partDeactivated( final IWorkbenchPartReference partRef ) {
    // empty implementation
  }

  public void partHidden( final IWorkbenchPartReference partRef ) {
    // empty implementation
  }

  public void partInputChanged( final IWorkbenchPartReference partRef ) {
    // empty implementation
  }

  public void partOpened( final IWorkbenchPartReference partRef ) {
    if ( partRef.getPart( true ) == this.editorActions.getView() ) {
      this.editorActions.delegateLinkEditorAction();
    }
  }

  public void partVisible( final IWorkbenchPartReference partRef ) {
    if ( partRef.getPart( true ) == this.editorActions.getView() ) {
      this.editorActions.delegateLinkEditorAction();
    }
  }
  
}
