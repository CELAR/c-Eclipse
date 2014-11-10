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
 * 	Stalo Sofokleous - initial API and implementation
 * 	Nicholas Loulloudes - implementation extensions
 *******************************************************************************/

package eu.celar.tosca.core;

import org.eclipse.core.resources.IFile;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.impl.AbstractCloudElementCreator;
import eu.celar.core.reporting.ProblemException;
import eu.celar.tosca.core.TOSCAResource;

public class TOSCACreator extends AbstractCloudElementCreator {

  @Override
  public ICloudElement create( ICloudContainer parent ) throws ProblemException
  {
    
    ICloudElement result = null;
    IFile file = ( IFile )getSource();
    // if ( file != null && !file.isLinked() ) {
    if( file != null ) {
      result = new TOSCAResource( file );
    }
    return result;
  }


}
