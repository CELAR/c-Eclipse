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
