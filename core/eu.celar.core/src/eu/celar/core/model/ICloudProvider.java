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
   * Gets the info service of this VO.
   * 
   * @return The info service that can be queried for VO related
   * information. 
   * @throws ProblemException If an error occurs while the service
   * is fetched.
   */
  public ICloudInfoService getInfoService() throws ProblemException;
  
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
  
  /**
   * Gets all available resources of the specified resource category.
   *  
   * @param category The resource category.
   * @param exclusive If <code>true<code> only resources are returned that
   * directly match the specified category. Otherwise also resource are
   * returned that match any child category of the specified resource
   * category.
   * @param monitor Use to monitor the progress.
   * @return An array of available resources.
   * @throws ProblemException If for any reason the resources could not
   * be fetched from the underlying information service.
   * @see IGridInfoService#fetchResources(IGridContainer, IVirtualOrganization, IGridResourceCategory, IProgressMonitor)
   */
  public ICloudResource[] getAvailableResources( final ICloudResourceCategory category,
                                                final boolean exclusive,
                                                final IProgressMonitor monitor )
      throws ProblemException;
  
  /**
   * Gets the resource categories that are supported by this VO.
   * 
   * @return The {@link IGridResourceCategory} instances supported by
   * this VO.
   */
  public ICloudResourceCategory[] getSupportedCategories();
  
  
}
