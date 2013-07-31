/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.internal;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import eu.celar.core.reporting.ISolution;
import eu.celar.core.reporting.ProblemException;
import eu.celar.ui.internal.dialogs.ProblemReportDialog;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ReportProblemSolution implements ISolution {

  /**
   * The throwable to be reported.
   */
  private Throwable exc;
  
  /**
   * The constructor. It will create a full error report if the parameter
   * is a {@link ProblemException}, a simpler one for generic throwables.
   * 
   * @param throwable the exception which has to be reported.
   */
  public ReportProblemSolution( final Throwable throwable ) {
    this.exc = throwable;
  }
  
  /* (non-Javadoc)
   * @see eu.celar.core.reporting.ISolution#getDescription()
   */
  @Override
  public String getDescription() {
    return "Create problem report"; //$NON-NLS-1$
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
    return this.exc != null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.reporting.ISolver#solve()
   */
  @Override
  public void solve() {
    ProblemReportDialog dialog = new ProblemReportDialog( getShell(), this.exc );
    dialog.open();
  }
  
  private Shell getShell() {
    
    Shell result = null;
    
    IWorkbench workbench = PlatformUI.getWorkbench();
    IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
    
    if ( window != null ) { 
      result = window.getShell();
    }

    return result;
    
  }
}
