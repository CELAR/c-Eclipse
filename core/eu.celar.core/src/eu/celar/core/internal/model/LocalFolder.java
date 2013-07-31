/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.internal.model;

import org.eclipse.core.resources.IFolder;

import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.impl.ResourceCloudContainer;


/**
 * @author Nicholas Loulloudes
 *
 */
public class LocalFolder extends ResourceCloudContainer {
  /**
   * Construct a new local folder with the specified parent and the specified
   * corresponding <code>IFolder</code>.
   * 
   * @param parent The parent element of this folder.
   * @param folder The corresponding <code>IFolder</code>.
   */
  LocalFolder( final IFolder folder ) {
    super( folder );
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.impl.AbstractCloudContainer#canContain(eu.celar.core.model.ICloudElement)
   */
  @Override
  public boolean canContain( final ICloudElement element ) {
    return true;
  }

  /**
   * Convenience method that returns the <code>IFolder</code> out of the
   * resource.
   * 
   * @return The corresponding <code>IFolder</code>.
   */
  public IFolder getFolder() {
    return ( IFolder )getResource();
  }
}
