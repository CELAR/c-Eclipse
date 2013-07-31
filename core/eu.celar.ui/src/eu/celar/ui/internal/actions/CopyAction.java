package eu.celar.ui.internal.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import eu.celar.core.model.ICloudElement;


public class CopyAction extends TransferAction {
  /**
   * Create a new copy action using the specified clipboard.
   * 
   * @param clipboard The {@link Clipboard} used by this copy
   * action.
   */
  protected CopyAction( final Clipboard clipboard ) {
    super( Messages.getString("CopyAction.copy_action_text"), clipboard ); //$NON-NLS-1$
    ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
    ImageDescriptor pasteImage = sharedImages.getImageDescriptor( ISharedImages.IMG_TOOL_COPY );
    setImageDescriptor( pasteImage );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    IStructuredSelection selection = getStructuredSelection();
    LocalSelectionTransfer transfer = LocalSelectionTransfer.getTransfer();
    transfer.setSelection( selection );
    Object[] data = new Object[] { selection };
    Transfer[] dataTypes = new Transfer[] { transfer };
    Clipboard clipboard = getClipboard();
    clipboard.setContents( data, dataTypes );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.BaseSelectionListenerAction#updateSelection(org.eclipse.jface.viewers.IStructuredSelection)
   */
  @Override
  protected boolean updateSelection( final IStructuredSelection selection ) {
    
    boolean enabled = super.updateSelection( selection );
    
    if ( enabled ) {
     
      for ( Object o : selection.toList() ) {
        if ( o instanceof ICloudElement ) {
          enabled = !( ( ICloudElement ) o ).isVirtual();
        } else {
          enabled = false;
        }
      }
      
    }
    
    return enabled;
    
  }
  
  
}
