/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.internal.actions;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionGroup;


/**
 * @author Nicholas Loulloudes
 *
 */
public class TreeViewerActions extends ActionGroup {
  /**
   * The collapse all action.
   */
  private CollapseAllAction collapseAllAction;
  
  /**
   * Construct a <code>StandardTreeViewerActions</code> for the
   * specified {@link TreeViewer}.
   * 
   * @param viewer The tree viewer for which to create this action
   * group.
   */
  public TreeViewerActions( final TreeViewer viewer ) {
    this.collapseAllAction = new CollapseAllAction( viewer );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
   */
  @Override
  public void fillActionBars( final IActionBars actionBars ) {
    IToolBarManager manager = actionBars.getToolBarManager();
    manager.add( this.collapseAllAction );
  }
  
}
