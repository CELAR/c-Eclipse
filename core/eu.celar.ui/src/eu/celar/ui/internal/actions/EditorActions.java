/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.internal.actions;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionGroup;

import eu.celar.ui.views.CloudModelViewPart;


/**
 * @author Nicholas Loulloudes
 *
 */
public class EditorActions extends ActionGroup {
  
  private CloudModelViewPart view;
  
  /**
   * The link with editor action.
   */
  private LinkWithEditorAction linkWithEditorAction;
  
  /**
   * Construct a new editor actions group.
   * 
   * @param view The view this group belongs to.
   */
  public EditorActions( final CloudModelViewPart view ) {
    this.view = view;
    this.linkWithEditorAction = new LinkWithEditorAction( view );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
   */
  @Override
  public void fillActionBars( final IActionBars actionBars ) {
    IToolBarManager manager = actionBars.getToolBarManager();
    manager.add( this.linkWithEditorAction );
  }
  
  /**
   * Get the associated view of this editor actions.
   * 
   * @return The associated view.
   */
  public CloudModelViewPart getView() {
    return this.view;
  }
  
  /**
   * Delegate a link editor action to the associated action's
   * run method.
   */
  public void delegateLinkEditorAction() {
    this.linkWithEditorAction.run();
  }
  
}
