/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import eu.celar.core.model.ICloudElement;


/**
 * @author Nicholas Loulloudes
 *
 */
public class CloudElementSelectionAdapter
  implements ISelectionProvider, ISelectionChangedListener
{

  /**
  * List of all {@link ISelectionChangedListener} listening
  * this {@link ISelectionProvider}.
  */
 private List< ISelectionChangedListener > listeners = new ArrayList< ISelectionChangedListener >();
 
 /**
  * The current selection.
  */
 private ISelection currentSelection;

 /* (non-Javadoc)
  * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
  */
 public void addSelectionChangedListener( final ISelectionChangedListener listener ) {
   if ( ! this.listeners.contains( listener ) ) {
     this.listeners.add( listener );
   }
 }

 /* (non-Javadoc)
  * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
  */
 public ISelection getSelection() {
   return
     this.currentSelection == null
     ? StructuredSelection.EMPTY
     : this.currentSelection;
 }

 /* (non-Javadoc)
  * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
  */
 public void removeSelectionChangedListener( final ISelectionChangedListener listener ) {
   this.listeners.remove( listener );
 }
 
 /* (non-Javadoc)
  * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
  */
 public void selectionChanged( final SelectionChangedEvent event ) {
   setSelection( event.getSelection() );
 }

 /* (non-Javadoc)
  * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
  */
 public void setSelection( final ISelection selection ) {
   if ( selection instanceof IStructuredSelection ) {
     setSelection( ( IStructuredSelection ) selection ); 
   }
 }
 
 /**
  * Sets the current selection and notifies all {@link ISelectionChangedListener}s
  * that the selection has changed.
  * 
  * @param selection The new {@link IStructuredSelection}.
  */
 public void setSelection( final IStructuredSelection selection ) {
   this.currentSelection = remapSelection( selection );
   fireSelectionChanged();
 }
 
 /**
  * Notifies all registered {@link ISelectionChangedListener}s
  * that the current selection has changed.
  */
 protected void fireSelectionChanged() {
   
   SelectionChangedEvent event
     = new SelectionChangedEvent( this, getSelection() );
   
   for ( ISelectionChangedListener listener : this.listeners ) {
     listener.selectionChanged( event );
   }
   
 }
 
 /**
  * Construct a new selection from the specified selection. The newly
  * created selection is guaranteed to only contain {@link IResource}s.
  * If no {@link IResource} can be created from a element of the original
  * selection this element will not be contained in the newly created
  * selection. So it may happen that even if the specified selection
  * is not empty the returned selection may be empty.
  * 
  * @param selection The selection to be remapped.
  * @return A new selection that only holds {@link IResource}s.
  */
 protected IStructuredSelection remapSelection( final IStructuredSelection selection ) {
   
   List< IResource > resources = new ArrayList< IResource >();
   
   for ( Object o : selection.toList() ) {
     IResource resource = remapObject( o );
     if ( resource != null ) {
       resources.add( resource );
     }
   }
   
   return new StructuredSelection( resources );
   
 }
 
 /**
  * Get an {@link IResource} from the specified {@link ICloudElement}.
  * 
  * @param e The element to be remapped.
  * @return An {@link IResource} or <code>null</code> if no
  * {@link IResource} could be retrieved from the specified element.
  * @see ICloudElement#getResource()
  */
 private IResource remapCloudElement( final ICloudElement e ) {
   return e.getResource();
 }
 
 /**
  * Remap the specified object to an {@link IResource} if possible.
  * This method first checks if the specified object already is an
  * {@link IResource}. In that case the original object is just casted
  * and returned. Furthermore the object is tested if it is an
  * {@link ICloudElement}. In that case {@link #remapCloudElement(ICloudElement)}
  * is called. In all other cases it is tested if the object is an
  * instance of {@link IAdaptable}. If all this fails <code>null</code>
  * will be returned.
  * 
  * @param o The object to be remapped.
  * @return An {@link IResource} or <code>null</code> if the object
  * could not be remapped.
  */
 private IResource remapObject( final Object o ) {
   
   IResource resource = null;
   
   if ( o instanceof IResource ) {
     resource = ( IResource ) o;
   } else if ( o instanceof ICloudElement ) {
     resource = remapCloudElement( ( ICloudElement ) o );
   } else if ( o instanceof IAdaptable ) {
     resource = ( IResource )( ( IAdaptable ) o ).getAdapter( IResource.class );
   }
   
   return resource;
   
 }
}
