/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;

import org.eclipse.core.runtime.IProgressMonitor;

import eu.celar.core.reporting.ProblemException;


/**
 * This is the base interface that all implementation of a Cloud Provider have
 * to implement. 
 */
public interface ICloudProvider extends ICloudContainer, ISerializableElement {
  
  @Override
  public String getName();
  
  /**
   * @return The Cloud Provider ID
   */
  public String getId();
  
  /**
   * @return Cloud Provider free text description
   */
  public String getDescription();
  
  /**
   * Returns a user-friendly string denoting the type of this VO. This string
   * has to be a singleton for each implementation. So each object
   * of a specific implementation has to return the same type name.
   * 
   * @return An implementation-specific type name.
   * @see #getId()
   */
  public String getTypeName();
  /**
   * Returns the ID of the wizard which should be used to edit VOs of this type.
   * 
   * @return ID of the wizard to edit the VO.
   */
  public String getWizardId();
  
  /**
   * Gets a list of all job submission services that are available for
   * this virtual organization.
   * 
   * @param monitor Used to monitor the progress.
   * @return A list of all currently available job submission services.
   * @throws ProblemException If an error occurs while retrieving
   * the services.
   */
  public ICloudDeploymentService[] getDeploymentServices( final IProgressMonitor monitor ) throws ProblemException;
  
  
}
