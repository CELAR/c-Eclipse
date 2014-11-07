package eu.celar.core.internal.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudResource;
import eu.celar.core.model.ICloudResourceCategory;
import eu.celar.core.model.ICloudResourceContainer;
import eu.celar.core.model.impl.ContainerMarker;
import eu.celar.core.reporting.ProblemException;


/**
 * Internal implementation of the {@link IGridResourceContainer} interface.
 */
public class ResourceCategoryContainer
    extends VirtualCloudContainer
    implements ICloudResourceContainer {
  
  /**
   * The container's category.
   */
  private ICloudResourceCategory category;
  
  /**
   * List of permanent children of the container, i.e. child resource
   * containers.
   */
  private List< ICloudElement > permanentChildren
    = new ArrayList< ICloudElement >();
  
  /**
   * Create a new resource category container.
   * 
   * @param parent The parent container of this container.
   * @param category The category corresponding to this container.
   */
  protected ResourceCategoryContainer( final ICloudContainer parent,
                                       final ICloudResourceCategory category ) {
    super( parent, category.getName() );
    this.category = category;
    if ( parent instanceof ResourceCategoryContainer ) {
      ( ( ResourceCategoryContainer ) parent ).permanentChildren.add( this );
    }
  }
  
  /**
   * Add the specified {@link ResourceCategoryContainer} as a permanent child
   * to this container. To remove a child container use
   * {@link #delete(IGridElement)}.
   * 
   * @param child The new child of this container.
   * @throws ProblemException If the child could not be added.
   */
  public void addChild( final ResourceCategoryContainer child )
      throws ProblemException {
    addElement( child );
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.impl.AbstractGridContainer#canContain(eu.geclipse.core.model.IGridElement)
   */
  @Override
  public boolean canContain( final ICloudElement element ) {
    return ( element instanceof ICloudResource )
      || ( element instanceof ResourceCategoryContainer )
      || ( element instanceof ContainerMarker );
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IGridResourceContainer#getCategory()
   */
  public ICloudResourceCategory getCategory() {
    return this.category;
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IGridElement#isLocal()
   */
  public boolean isLocal() {
    return true;
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.impl.AbstractGridContainer#fetchChildren(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected IStatus fetchChildren( final IProgressMonitor monitor )
      throws ProblemException {
  
    for ( ICloudElement permantenChild : this.permanentChildren ) {
      addElement( permantenChild );
    }
    
    if ( this.category.isActive() ) {

      ICloudResource[] resources
        = getProject().getCloudProvider().getAvailableResources( this.category, true, monitor);

      if ( ( resources != null ) && ( resources.length > 0 ) ) {
        lock();
        try {
          for ( ICloudElement resource : resources ) {
            addElement( resource );
          }
        } finally {
          unlock();
        }
      } else {
        addElement( new ContainerMarker( this,
                                         ContainerMarker.MarkerType.INFO,
                                         Messages.getString("ResourceCategoryContainer.no_matching_elements_error") ) ); //$NON-NLS-1$
      }
    }
    
    return Status.OK_STATUS;
  }

}