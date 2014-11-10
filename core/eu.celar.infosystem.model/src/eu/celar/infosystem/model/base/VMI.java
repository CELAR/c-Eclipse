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
package eu.celar.infosystem.model.base;

import java.net.URI;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudResource;
import eu.celar.core.model.impl.AbstractCloudElement;
import eu.celar.core.reporting.ProblemException;


/**
 * @author nickl
 *
 */
public class VMI extends AbstractCloudElement implements ICloudResource {
  
  private ICloudContainer parent;
  private VirtualMachineImage vmi;
  
  public VMI (final ICloudContainer parent,
              final VirtualMachineImage vmi){
    this.parent = parent;
    this.vmi = vmi;
    
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
    return this.vmi.getName();
  }
  
  public String getUID(){
    return this.vmi.getUID();    
  }
  
  public String getURL(){
    return this.vmi.getURL();
  }
  
  public String getDescription(){
    return this.vmi.getDescription();
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getPath()
   */
  @Override
  public IPath getPath() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    return this.parent;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return false;
  }

  @Override
  public IFileStore getFileStore() {
    return null;
  }

  @Override
  public IResource getResource() {
    return null;
  }

  @Override
  public void share() throws ProblemException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public URI getURI() throws ProblemException {
    return null;
  }
}
