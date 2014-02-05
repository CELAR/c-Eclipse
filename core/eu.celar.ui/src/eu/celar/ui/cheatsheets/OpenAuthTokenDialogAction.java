package eu.celar.ui.cheatsheets;

import org.eclipse.help.ILiveHelpAction;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.cheatsheets.ICheatSheetAction;
import org.eclipse.ui.cheatsheets.ICheatSheetManager;

import eu.celar.ui.UIAuthTokenProvider;

/**
 * Action for opening the authentication token dialog from cheat sheets and
 * html help files.
 */
public class OpenAuthTokenDialogAction extends Action implements 
  ILiveHelpAction, ICheatSheetAction {

  /* (non-Javadoc)
   * @see org.eclipse.help.ILiveHelpAction#setInitializationString(java.lang.String)
   */
  public void setInitializationString( final String data ) {
    // not needed
  }

  public void run( final String[] params, final ICheatSheetManager manager ) {
    Display display = Display.getDefault();
    if ( ! display.isDisposed() ) {
      display.syncExec( new Runnable() {
        public void run() {
          UIAuthTokenProvider tokenProvider
            = new UIAuthTokenProvider( Display.getDefault().getActiveShell() );
          boolean success = tokenProvider.showNewTokenWizard( null, false, null );
          notifyResult(success);
        }
      } );
    }
  }
  
  @Override
  public void run() {
    run( null, null );
  }

}
