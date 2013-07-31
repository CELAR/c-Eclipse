/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.listeners;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;


/**
 * @author Nicholas Loulloudes
 *
 */
public class TreeColumnListener implements SelectionListener {

  private TreeViewer treeViewer;
  private Tree tree;
  
  /**
   * Construct a <code>SelectionListener</code> for the given <code>TreeViewer</code>.
   * 
   * @param viewer The <code>TreeViewer</code> whose entries need to be sorted.
   */
  public TreeColumnListener( final TreeViewer viewer ) {
    this.treeViewer = viewer;
    this.tree = this.treeViewer.getTree();
  }
  
  public void widgetSelected( final SelectionEvent e ) {
    // This listener is only for the columns of a tree
    assert e.getSource() instanceof TreeColumn
      : "This listener should only be used for Trees"; //$NON-NLS-1$
    
    TreeColumn clickedColumn = (TreeColumn) e.getSource();
    TreeColumn oldSortingColumn = this.tree.getSortColumn();
    
    if ( clickedColumn == oldSortingColumn ) {
      this.tree.setSortDirection( this.tree.getSortDirection() == SWT.UP
                                     ? SWT.DOWN
                                     : SWT.UP );
    } else {
      this.tree.setSortColumn( clickedColumn );
      this.tree.setSortDirection( SWT.UP );
    }
    this.treeViewer.refresh();
  }

  public void widgetDefaultSelected( final SelectionEvent e ) {
    // Empty implementation
  }
}
