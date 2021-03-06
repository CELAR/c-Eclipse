/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.internal.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;


/**
 * @author Nicholas Loulloudes
 *
 */
public class RefreshAction extends BaseSelectionListenerAction {
  
  /**
   * The refresh action used to delegate non-virtual elements to.
   */
  private org.eclipse.ui.actions.RefreshAction resourcesRefresh;
  
  private List< ICloudElement > virtualElements;
  
  /**
   * Construct a new refresh action.
   * 
   * @param shell The Shell for this action.
   */
  protected RefreshAction( final Shell shell ) {
    super( Messages.getString("RefreshAction.refresh") ); //$NON-NLS-1$
    this.resourcesRefresh = new org.eclipse.ui.actions.RefreshAction( shell );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    
    if ( this.resourcesRefresh.isEnabled() ) {
      this.resourcesRefresh.run();
    }
    
    if ( ! this.virtualElements.isEmpty() ) {
      refreshElements( this.virtualElements );
    }
    
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.BaseSelectionListenerAction#updateSelection(org.eclipse.jface.viewers.IStructuredSelection)
   */
  @Override
  protected boolean updateSelection( final IStructuredSelection selection ) {
    
    boolean result = false;
    
    List< IResource > resources = new ArrayList< IResource >();
    this.virtualElements = new ArrayList< ICloudElement >();
    result = filterSelection( selection, resources, this.virtualElements );
    
    if ( result ) {
      
      if ( ! resources.isEmpty() || ( resources.isEmpty() && this.virtualElements.isEmpty() ) ) {
        this.resourcesRefresh.selectionChanged( new StructuredSelection( resources ) );
        result = this.resourcesRefresh.isEnabled();
      }
      
      result |= resources.isEmpty() && ! this.virtualElements.isEmpty();
      
    }
    
    return result;
    
  }
  
  private boolean filterSelection( final IStructuredSelection selection,
                                   final List< IResource > resources,
                                   final List< ICloudElement > elements ) {
    
    Iterator< ? > iter = selection.iterator();
    
    while ( iter.hasNext() ) {
      Object o = iter.next();
      IResource resource = getResource( o );
      if ( resource != null ) {
        resources.add( resource );
      } else if ( o instanceof ICloudElement ) {
        elements.add( ( ICloudElement ) o );
      }
    }
    
    return ( resources.size() + elements.size() ) == selection.size();
    
  }
  
  private void refreshElements( final List< ICloudElement > elements ) {
    
    WorkspaceJob job = new WorkspaceJob( "Element Refresh" ) { //$NON-NLS-1$
     
      @Override
      public IStatus runInWorkspace( final IProgressMonitor monitor )
          throws CoreException {
        
        SubMonitor sMonitor = SubMonitor.convert( monitor, "Refreshing virtual Cloud elements", elements.size() ); //$NON-NLS-1$
          
        for ( ICloudElement element : elements ) {
          if ( element instanceof ICloudContainer ) {
            ICloudContainer container = ( ICloudContainer ) element;
            container.setDirty();
            container.refresh( sMonitor.newChild( 1 ) );
          }
        }
        
        return Status.OK_STATUS;
        
      }
      
    };
    
    job.schedule();
    
  }

  
  /**
   * Try to obtain an {@link IResource} from the specified object.
   * 
   * @param o The object from which to obtain a resource.
   * @return An {@link IResource} or <code>null</code> if no resource
   * could be retrieved from the object.
   */
  private IResource getResource( final Object o ) {
    IResource resource = null;
    if ( o instanceof IResource ) {
      resource = ( IResource ) o;
    } else if ( o instanceof IAdaptable ) {
      resource = ( IResource )( ( IAdaptable ) o ).getAdapter( IResource.class );
    }
    return resource;
  }
}
