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


/**
 * Interface for the Cloud pricing schemes
 * 
 */
public interface ICloudPriceScheme extends ICloudApplicationComponent {
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getName()
   */
  @Override
  public String getName();
  
  /**
   * @return The scheme description
   */
  public String getDescription();
  
  /**
   * @return The scheme UID
   */
  public String getUID();
}
