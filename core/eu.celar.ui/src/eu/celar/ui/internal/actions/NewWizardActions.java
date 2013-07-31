/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.internal.actions;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.actions.NewWizardMenu;


/**
 * @author Nicholas Loulloudes
 *
 */
public class NewWizardActions extends ActionGroup {
  /**
   * The workbench window of this action group.
   */
  private IWorkbenchWindow window;
  
  /**
   * Create a new action for the specified workbench window.
   * 
   * @param window The {@link IWorkbenchWindow} for which to create
   * this action group.
   */
  public NewWizardActions( final IWorkbenchWindow window ) {
    super();
    this.window = window;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
   */
  @Override
  public void fillContextMenu( final IMenuManager menu ) {
    super.fillContextMenu( menu );
    ISelection selection= getContext().getSelection();
    if (selection instanceof IStructuredSelection) {
      IStructuredSelection sselection= ( IStructuredSelection ) selection;
      if ( sselection.size() <= 1 ) {
        IMenuManager submenu = new MenuManager( Messages.getString( "NewWizardActions.new_action_group" ) ); //$NON-NLS-1$
        menu.appendToGroup( IContextMenuConstants.GROUP_NEW, submenu );
        submenu.add( new NewWizardMenu( this.window ) );
      }
    }
  }
}
