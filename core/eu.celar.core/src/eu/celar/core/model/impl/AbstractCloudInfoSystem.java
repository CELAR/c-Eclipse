/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudInfoService;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.ICloudResource;
import eu.celar.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class AbstractCloudInfoSystem extends AbstractCloudElement
  implements ICloudInfoService
{
  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudInfoService#fetchResources(eu.celar.core.model.ICloudContainer, eu.celar.core.model.ICloudProvider, org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudResource[] fetchResources( final ICloudContainer parent,
                                          final ICloudProvider cp,
                                          final IProgressMonitor monitor )
    throws ProblemException
  {
    return fetchResources( parent, cp, false, null, monitor );
  }

  protected ICloudResource[] filterResources( final ICloudResource[] resources,
                                             final Class< ? extends ICloudResource > type,
                                             final boolean remove ) {

    List< ICloudResource > resultList = new ArrayList< ICloudResource >();

    for ( ICloudResource resource : resources ) {
      boolean isType = type.isAssignableFrom( resource.getClass() );
      if ( ( remove && ! isType ) || ( ! remove && isType ) ) {
        resultList.add( resource );
      }
    }

    return resultList.toArray( new ICloudResource[ resultList.size() ] );
  }
}
