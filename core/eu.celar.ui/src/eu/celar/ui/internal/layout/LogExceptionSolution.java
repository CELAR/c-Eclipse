/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.internal.layout;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import eu.celar.core.reporting.ISolution;
import eu.celar.ui.internal.Activator;


/**
 * @author Nicholas Loulloudes
 *
 */
public class LogExceptionSolution implements ISolution {

  /**
   * The ID of the PDE log view.
   */
  public static final String LOG_VIEW_ID = "org.eclipse.pde.runtime.LogView"; //$NON-NLS-1$
  
  private Throwable exception;
  
  public LogExceptionSolution( final Throwable exc ) {
    this.exception = exc;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.reporting.ISolution#getDescription()
   */
  @Override
  public String getDescription() {
    return "Log exception"; //$NON-NLS-1$
  }
  
  /* (non-Javadoc)
   * @see eu.celar.core.reporting.ISolution#getID()
   */
  @Override
  public String getID() {
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.reporting.ISolution#isActive()
   */
  @Override
  public boolean isActive() {
    return true;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.reporting.ISolver#solve()
   */
  @Override
  public void solve() {
    
    Activator.logException( this.exception );
    
    IWorkbench workbench = PlatformUI.getWorkbench();
    IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
    IWorkbenchPage page = window.getActivePage();
  
    try {
      page.showView( LOG_VIEW_ID );
    } catch ( PartInitException piExc ) {
      Activator.logException( piExc );
    }
    
  }
}
