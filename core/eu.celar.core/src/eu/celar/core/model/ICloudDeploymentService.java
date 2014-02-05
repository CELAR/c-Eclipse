/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;

import org.eclipse.core.runtime.IProgressMonitor;

import eu.celar.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ICloudDeploymentService extends ICloudService {
  
  public boolean canDeploy( final ICloudApplicationDescription desc );

  public ICloudDeploymentID deployApplication( final ICloudApplicationDescription description,
                                               final IProgressMonitor monitor )
    throws ProblemException;

  public ICloudDeploymentID deployApplication( final ICloudApplicationDescription description,
                                               final ICloudProvider vo,
                                               final IProgressMonitor monitor )
    throws ProblemException;

  public ICloudDeploymentStatus getDeploymentStatus( final ICloudDeploymentID id,
                                                     final IProgressMonitor vo,
                                                     boolean fullStatus,
                                                     final IProgressMonitor monitor )
    throws ProblemException;
}
