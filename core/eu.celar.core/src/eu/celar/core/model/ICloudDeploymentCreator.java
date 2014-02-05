/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;

import eu.celar.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ICloudDeploymentCreator extends ICloudElementCreator {
  /**
   * Test if this creator can create a job from the specified job description.
   * 
   * @param description The description from which to create the job.
   * @return True if a job can be created from the specified description.
   */
  public boolean canCreate( final ICloudApplicationDescription description );
  
  /**
   * Creates ApplicationDeploymentJob and add this to CloudProjectView. This method is called
   * after successful application deployment.
   * 
   * @param parent - The parent node in GridProjectView
   * @param id - Identifier of deployment
   * @param deploymentService 
   * @param deploymentName - name under which job should be stored in the workspace
   * @return created deployment
   * @throws ProblemException
   */
  public ICloudDeployment create( final ICloudContainer parent, ICloudDeploymentID id, final ICloudDeploymentService deploymentService, final String deploymentName )
    throws ProblemException;
  
  
}
