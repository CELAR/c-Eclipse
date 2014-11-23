/*******************************************************************************
 * Copyright (c) 2013 CELAR Consortium.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 *   Nicholas Loulloudes - initial API and implementation
 *   
 *******************************************************************************/
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
