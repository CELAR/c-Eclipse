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
package eu.celar.core.internal.model;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudProject;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.IWrappedElement;
import eu.celar.core.model.impl.AbstractCloudContainer;
import eu.celar.core.reporting.ProblemException;


/**
 * Wrapper of a VO in order to map the VO from the manager to a
 * project.
 */
public class ProjectCloudProvider extends AbstractCloudContainer
  implements ICloudProvider, IWrappedElement
{
  
  private ICloudProject project;
  
  private String providerName;
  
  protected ProjectCloudProvider (final ICloudProject project,
                                  final ICloudProvider cloudProvider) {
    super();
    this.project = project;
    this.providerName = cloudProvider.getName();
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudContainer#isLazy()
   */
  @Override
  public boolean isLazy() {    
    return false;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    return getProject().getFileStore().getChild( getName() );
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getPath()
   */
  @Override
  public IPath getPath() {
    return this.project.getPath().append( getName() );
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return null;
  }
  
  @Override
  public ICloudProject getProject() {
    return this.project;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return true;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ISerializableElement#serialize()
   */
  @Override
  public void serialize() throws ProblemException {
    // TODO Auto-generated method stub
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ISerializableElement#deserialize()
   */
  @Override
  public void deserialize() throws ProblemException {
    // TODO Auto-generated method stub
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.IWrappedElement#getWrappedElement()
   */
  @Override
  public ICloudElement getWrappedElement() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProvider#getName()
   */
  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProvider#getId()
   */
  @Override
  public String getId() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProvider#getDescription()
   */
  @Override
  public String getDescription() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProvider#getTypeName()
   */
  @Override
  public String getTypeName() {
    // TODO Auto-generated method stub
    return null;
  }
}
