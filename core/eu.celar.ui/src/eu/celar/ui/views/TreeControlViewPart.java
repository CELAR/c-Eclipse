/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.views;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.ui.comparators.TreeColumnComparator;
import eu.celar.ui.listeners.TreeColumnListener;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class TreeControlViewPart extends CloudModelViewPart {
  
  @Override
  public void refreshViewer( final ICloudElement element ) {
    if ( ( element != null ) && ( element instanceof ICloudContainer ) ) {
      final ICloudContainer container = ( ICloudContainer ) element;
      if ( container.isLazy() && container.isDirty() ) {
        Control control = this.viewer.getControl();
        if ( ! control.isDisposed() ) {
          Display display = control.getDisplay();
          display.syncExec( new Runnable() {
            public void run() {
              TreeViewer tViewer = ( TreeViewer ) getViewer();
              tViewer.setChildCount( container, container.getChildCount() );
            }
          } );
        }
      }
    }
    super.refreshViewer( element );
  }

  /* (non-Javadoc)
   * @see eu.celar.ui.views.CloudModelViewPart#createViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected StructuredViewer createViewer( final Composite parent ) {
    TreeViewer tViewer = new TreeViewer( parent, SWT.VIRTUAL | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL );
    Tree tree = tViewer.getTree();
    boolean hasColumns = createTreeColumns( tree );
    if ( hasColumns ) {
      tree.setHeaderVisible( true );

      // Add listener for column sorting
      TreeColumnListener columnListener = new TreeColumnListener( tViewer );
      for ( TreeColumn column : tree.getColumns() ) {
        column.addSelectionListener( columnListener );
      }
      
      // Initially sort by the first column, ascending
      TreeColumn firstColumn = tree.getColumn( 0 );
      tree.setSortColumn( firstColumn );
      tree.setSortDirection( SWT.UP );
      // Set also the first column as fallback sorting column
      tViewer.setComparator( new TreeColumnComparator( firstColumn ) );
    }
    
    return tViewer;
  }
  
  protected boolean createTreeColumns( @SuppressWarnings("unused") final Tree tree )
  {
    return false;
  }
  
}
