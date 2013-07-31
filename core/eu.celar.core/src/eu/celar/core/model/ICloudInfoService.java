/*****************************************************************************
 * Copyright (c) 2006-2008 g-Eclipse Consortium 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the
 * g-Eclipse project founded by European Union
 * project number: FP6-IST-034327  http://www.geclipse.eu/
 *
 * Contributors:
 *    Mathias Stuempert - initial API and implementation
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package eu.celar.core.model;

import org.eclipse.core.runtime.IProgressMonitor;

import eu.celar.core.model.impl.AbstractInfoStore;
import eu.celar.core.reporting.ProblemException;


/**
 * An info service provides access to an information service
 * of a specific Cloud Provider
 */
public interface ICloudInfoService extends ICloudResource {
  
  
  public AbstractInfoStore getInfoStore();
  
  /**
   * 
   * @param cp The Cloud provide
   */
  public void setCloudProvider (final ICloudProvider cp);
  
  public void scheduleFetch (final IProgressMonitor monitor);
  
  public ICloudResource[] fetchResources( final ICloudContainer parent,
                                          final ICloudProvider cp,
                                          final IProgressMonitor monitor )
    throws ProblemException;
  
  public ICloudResource[] fetchResources( final ICloudContainer parent,
                                         final ICloudProvider cp,
                                         final boolean exclusive,
                                         final Class< ? extends ICloudResource > typeFilter,
                                         final IProgressMonitor monitor ) 
  throws ProblemException;
  
  
  
}
