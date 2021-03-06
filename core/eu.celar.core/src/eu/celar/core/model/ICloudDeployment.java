package eu.celar.core.model;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import eu.celar.core.reporting.ProblemException;


/**
 * Base interface for all cloud provider specific implementations of
 * application deployments.
 */
public interface ICloudDeployment
    extends ICloudContainer, IManageable {
  
  /**
   * Cancel this deployment if it is already running.
   */
  public void cancel();
  
  /**
   * Deletes the deployment from the Cloud provider.
   * 
   * @param monitor Use to monitor the progress. May be <code>null</code>.
   * @throws ProblemException if an error occurs while deleting the deployment.
   */
  public void deleteDeployment( IProgressMonitor monitor ) throws ProblemException;

  /**
   * Gets the current status of this deployment, without contacting the services.
   * 
   * @return This deployment latest known status.
   */
  public ICloudDeploymentStatus getDeploymentStatus();

  /**
   * Updates the deployment status. The implementation of this method should ask
   * the cloud provider for the up-to-date deployment status.
   * 
   * @param monitor Use to monitor the progress. May be <code>null</code>.
   * @param fullStatus <code>true</code> if all available information about
   *          deployment should be downloaded, <code>false</code> if only basic
   *          info about status should be downloaded (only those available from
   *          {@link ICloudDeploymentStatus})
   * @return This deployment's current status.
   */
  public ICloudDeploymentStatus updateDeploymentStatus( IProgressMonitor monitor, boolean fullStatus );
  
  /**
   * Gets the unique id of this deployment. This id may be used to query
   * for deployment information.
   * 
   * @return The unique id of this deployment.
   */
  public ICloudDeploymentID getID();

  /**
   * Gets the deployment name.
   * 
   * @return The name of this deployment without additional decorations,
   *         file extensions, etc.
   */
  public String getDeploymentName();

  /**
   * Gets the application description used to create the deployment.
   * 
   * @return The application description used to create this deployment.
   */
  public ICloudApplicationDescription getApplicationDescription();

  /**
   * Gets the date and time of deployment. 
   * 
   * @return A <code>Date</code> object with the submission time.
   */
  public Date getSubmissionTime();
  
  /**
   * Scan folder "Input Files" in submitted deployment and return list of input files
   * @return list of URI points to input files used by deployment
   * @throws ProblemException
   */
  public List<URI> getInputStagers() throws ProblemException;
  
  /**
   * Scan folder "Output Files" in submitted deployment and return list of output files
   * @return list of URI points to output files produced by deployment
   * @throws ProblemException
   */
  public List<URI> getOutputStagers() throws ProblemException;
}
