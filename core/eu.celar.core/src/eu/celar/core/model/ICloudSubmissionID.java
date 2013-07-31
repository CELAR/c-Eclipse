/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;


/**
 * The submission ID is (for each cloud provider) a unique identifier for an
 * application that has been submitted for deployment.
 */
public interface ICloudSubmissionID {
  
  /**
   * Gets the submission's unique ID.
   * 
   * @return A string containing the unique identifier for a cloud application
   * submission. 
   */
  public String getSubmissionID();
}
