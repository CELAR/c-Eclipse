package eu.celar.core.reporting;

/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
/**
 * @author Nicholas Loulloudes
 *
 */
public interface ISolution extends ISolver{
  
  public String getID();
  
  public boolean isActive();
  
  public String getDescription();
}
