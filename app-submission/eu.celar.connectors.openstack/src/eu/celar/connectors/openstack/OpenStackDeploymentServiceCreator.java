/*******************************************************************************
 * Copyright (c) 2014 CELAR Consortium.
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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package eu.celar.connectors.openstack;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICreatorSourceMatcher;
import eu.celar.core.model.impl.AbstractCloudElementCreator;
import eu.celar.core.reporting.ProblemException;

/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenStackDeploymentServiceCreator extends AbstractCloudElementCreator implements ICreatorSourceMatcher {

  public ICloudElement create( final ICloudContainer parent )
    throws ProblemException
  {
    OpenStackApplicationDeploymentService result = null;
    Object object = getSource();
    result = new OpenStackApplicationDeploymentService( parent );
    return result;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICreatorSourceMatcher#canCreate(java.lang.Object)
   */
  @Override
  public boolean canCreate( Object source ) {
    return false;
  }

}