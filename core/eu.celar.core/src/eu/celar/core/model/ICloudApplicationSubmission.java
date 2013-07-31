/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;

import java.util.Date;

import org.eclipse.core.runtime.IProgressMonitor;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ICloudApplicationSubmission extends ICloudContainer, IManageable {
  
  public ICloudSubmissionID getID();
  
  public String getApplicationName();
  
  public Date getSubmissionTime();
  
  public ICloudSubmissionStatus getStatus(final IProgressMonitor monitor);
  
}
