/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.internal.actions;

import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;

import eu.celar.ui.internal.Activator;


/**
 * @author Nicholas Loulloudes
 *
 */
public class CollapseAllAction extends Action {
  /**
   * The viewer that is the target of this action.
   */
  TreeViewer viewer;
  
  /**
   * Construct a new collapse all action for the specified tree viewer.
   * 
   * @param viewer The tree viewer that is the target of this action. 
   */
  public CollapseAllAction( final TreeViewer viewer ) {
    super( Messages.getString("CollapseAllAction.collapse_all_action_text") ); //$NON-NLS-1$
    this.viewer = viewer;
    URL imgUrl = Activator.getDefault().getBundle().getEntry( "icons/elcl16/collapseall.gif" ); //$NON-NLS-1$
    setImageDescriptor( ImageDescriptor.createFromURL( imgUrl ) );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    Display display = this.viewer.getControl().getDisplay();
    display.asyncExec( new Runnable() {
      public void run() {
        CollapseAllAction.this.viewer.collapseAll();
      }
    } );
  }
  
}
