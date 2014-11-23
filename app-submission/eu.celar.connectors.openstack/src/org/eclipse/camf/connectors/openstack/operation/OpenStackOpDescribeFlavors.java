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
package org.eclipse.camf.connectors.openstack.operation;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.camf.connectors.openstack.OpenStackClient;
import org.jclouds.compute.ComputeService;
import org.jclouds.openstack.nova.v2_0.features.FlavorApi;
import org.jclouds.openstack.v2_0.domain.Resource;

/**
 * This {@link IOperation} implementation uses the {@link ComputeService} to send a query
 * to the Amazon Webservice. It fetches all executable amazon machine images,
 * which we can be execute
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackOpDescribeFlavors extends AbstractOpenStackOpFlavors {

  private final FlavorApi flavorApi;
  /**
   * Creates a new {@link OpenStackOpDescribeFlavors} with the given owners as
   * parameter.
   * 
   */
  public OpenStackOpDescribeFlavors() {
    this.flavorApi = OpenStackClient.getInstance().getFlavorApi();
  }
 

	@Override
	public void run() {
		setResult(null);
		setException(null);
		try {

			Set<Resource> flavors = this.flavorApi.list().concat().toSet();

			setResult(new ArrayList<Resource>(flavors));
		} catch (Exception ex) {
			setException(ex);
		}

	}

}
