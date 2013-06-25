/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation 
 ************************************************************/

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
