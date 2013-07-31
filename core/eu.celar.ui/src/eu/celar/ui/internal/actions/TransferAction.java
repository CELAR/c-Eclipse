/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.internal.actions;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.ui.actions.SelectionListenerAction;


/**
 * @author Nicholas Loulloudes
 *
 */
public class TransferAction extends SelectionListenerAction {
  /**
   * The clipboard used for the transfer.
   */
  private Clipboard clipboard;
  
  /**
   * Construct a new transfer action with the specified title that
   * uses the specified clipboard.
   * 
   * @param text The title of the action.
   * @param clipboard The {@link Clipboard} to be used for transfers.
   */
  protected TransferAction( final String text,
                            final Clipboard clipboard ) {
    super( text );
    this.clipboard = clipboard;
  }
  
  /**
   * Get the clipboard that is used for transfer within this action.
   * 
   * @return The {@link Clipboard} used for transfers.
   */
  public Clipboard getClipboard() {
    return this.clipboard;
  }
}
