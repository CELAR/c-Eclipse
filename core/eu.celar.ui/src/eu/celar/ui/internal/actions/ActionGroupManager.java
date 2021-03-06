package eu.celar.ui.internal.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionGroup;


public class ActionGroupManager extends ActionGroup {
  
  /**
   * Internal list of currently available action groups.
   */
  private List< ActionGroup > groups;
  
  /**
   * Standard constructor.
   */
  public ActionGroupManager() {
    this.groups = new ArrayList< ActionGroup >();
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#dispose()
   */
  @Override
  public void dispose() {
    for ( ActionGroup group : this.groups ) {
      group.dispose();
    }
    super.dispose();
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#setContext(org.eclipse.ui.actions.ActionContext)
   */
  @Override
  public void setContext( final ActionContext context ) {
    super.setContext( context );
    for ( ActionGroup group : this.groups ) {
      group.setContext( context );
    }
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
   */
  @Override
  public void fillActionBars( final IActionBars actionBars ) {
    super.fillActionBars( actionBars );
    for ( ActionGroup group : this.groups ) {
      group.fillActionBars( actionBars );
    }
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
   */
  @Override
  public void fillContextMenu( final IMenuManager menu ) {
    super.fillContextMenu( menu );
    for ( ActionGroup group : this.groups ) {
      group.fillContextMenu( menu );
    }
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#updateActionBars()
   */
  @Override
  public void updateActionBars() {
    super.updateActionBars();
    for ( ActionGroup group : this.groups ) {
      group.updateActionBars();
    }
  }
 
  /**
   * Adds an {@link ActionGroup} to this <code>ActionGroupManager</code>.
   * 
   * @param group The {@link ActionGroup} to be added.
   */
  public void addGroup( final ActionGroup group ) {
    this.groups.add( group );
  }
  
  /**
   * Get a list of all currently available action groups that are
   * managed by this manager.
   * 
   * @return All currently managed action groups.
   */
  public List< ActionGroup > getGroups() {
    return this.groups;
  }
  
}
