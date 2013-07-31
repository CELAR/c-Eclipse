/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;

import java.net.URI;

import eu.celar.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ICloudSoftwareDependency extends ICloudApplicationComponent {
  
  public String getName();
  
  public String getDescription();
  
  public String getType();
  
  public String getUID();
  
  public URI getURI() throws ProblemException;
}
