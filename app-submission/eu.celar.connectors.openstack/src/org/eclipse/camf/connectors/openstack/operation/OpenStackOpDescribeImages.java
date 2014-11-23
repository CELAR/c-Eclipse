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
import java.util.List;
import java.util.Set;

import org.eclipse.camf.connectors.openstack.OpenStackClient;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.domain.Image;

/**
 * This {@link IOperation} implementation uses the {@link ComputeService} to send a query
 * to the Amazon Webservice. It fetches all executable amazon machine images,
 * which we can be execute
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackOpDescribeImages extends AbstractOpenStackOpDescribeImages {

  private final ComputeService computeService;
  /**
   * Creates a new {@link OpenStackOpDescribeImages} with the given owners as
   * parameter.
   * 
   * @param computeService the {@link ComputeService} to obtain data from
   */
  public OpenStackOpDescribeImages( final ComputeService computeService ) {
    this.computeService = computeService;
  }
 

  @Override
  public void run() {
    setResult( null );
    setException( null );
    try {

      Set<Image> images = ( Set<Image> )this.computeService.listImages();
      setResult( new ArrayList<Image>(images) );
    } catch( Exception ex ) {
      setException( ex );
    }

  }

}
