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
* A <code>IStorableElement</code> defines methods to serialize
* an element to an <code>OutputStream</code> and to load it
* from an <code>InputStream</code>. That makes that element
* persistent.
*/
public interface ISerializableElement extends ICloudElement {
  

  public void serialize() throws ProblemException;
  
  public void deserialize() throws ProblemException;
}
