/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model;

import eu.celar.core.reporting.ProblemException;


/**
* A <code>IShareableElement</code> defines methods to share
* an element.
*/
public interface IShareableElement {
  
  public void share() throws ProblemException;
}
