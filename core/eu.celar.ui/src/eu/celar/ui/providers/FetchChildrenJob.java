/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.providers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Shell;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.reporting.ProblemException;
import eu.celar.core.util.MasterMonitor;
import eu.celar.ui.dialogs.ProblemDialog;


/**
 * @author Nicholas Loulloudes
 *
 */
public class FetchChildrenJob extends Job {

  private ICloudContainer container;
  
  private IProgressMonitor externalMonitor;
  
  private Shell shell;
  
  /**
   * @param container
   * @param shell
   */
  public FetchChildrenJob( final ICloudContainer container, final Shell shell ) {
    super( "Fetching Children of " + container.getName() ); //$NON-NLS-1$
    this.container = container;
    this.shell = shell;
  }
  
  /**
   * @param monitor
   */
  public void setExternalMonitor( final IProgressMonitor monitor ) {
    this.externalMonitor = monitor;
  }

  @Override
  protected IStatus run( final IProgressMonitor monitor ) {

    IStatus result = Status.OK_STATUS;
    MasterMonitor mMonitor = new MasterMonitor( monitor, this.externalMonitor );
    
    try {
      this.container.setDirty();
      this.container.getChildren( mMonitor );
      result = Status.OK_STATUS;
    } catch ( ProblemException pExc ) {
      ProblemDialog.openProblem( this.shell,
                                 "Fetch Error", //$NON-NLS-1$
                                 "Error while fetching children of " + this.container.getName(), //$NON-NLS-1$
                                 pExc );
    } finally {
      mMonitor.done();
    }
    
    return result;
    
  }

}
