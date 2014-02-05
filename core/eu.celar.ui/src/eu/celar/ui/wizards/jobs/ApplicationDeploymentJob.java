/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.wizards.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

import eu.celar.ui.wizards.Messages;



/**
 * @author Nicholas Loulloudes
 *
 */
public class ApplicationDeploymentJob extends Job {
  

  /**
   * @param name
   */
  public ApplicationDeploymentJob( ) {
    super( Messages.getString( "NewDeploymentWizard.jobName" ) ); //$NON-NLS-1$
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected IStatus run( final IProgressMonitor monitor ) {
    boolean closeWizard = true;
//    Cloud
    return null;
  }
}
