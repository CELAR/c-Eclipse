/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;

import java.util.Date;


/**
 * This interface defines some informational fields related to the status of
 * submissions on a Cloud provider.
 */
public interface ICloudSubmissionStatus {
  
  public String getName();
  
  public int getStatus();
  
  public Date getLastUpdateTime();
}
