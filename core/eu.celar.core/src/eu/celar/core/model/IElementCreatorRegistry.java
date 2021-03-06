/*****************************************************************************
 * Copyright (c) 2008 g-Eclipse Consortium 
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

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;

import eu.celar.core.reporting.ProblemException;


/**
 * The element creator registry keeps track of all currently registered
 * extensions of the <code>eu.celar.core.cloudElementCreator</code> extension
 * point. The g-Eclipse core provides an internal implementation of this
 * interface that can be accessed with {@link CloudModel#getCreatorRegistry()}.
 */
public interface IElementCreatorRegistry {
  
  /**
   * Get a list of {@link IConfigurationElement}s for all element creators that
   * are defined as extensions of the
   * <code>eu.celar.core.cloudElementCreator</code> extension point.
   * 
   * @return All defined element creators.
   */
  public List<IConfigurationElement> getConfigurations();

  /**
   * Get a list of {@link IConfigurationElement} representing creators that are
   * able to create an element of the specified type from the specified object.
   * 
   * @param source The object from which to create the element.
   * @param target The type of the element to be created.
   * @return A list of {@link IConfigurationElement}s representing appropriate
   * element creators. If no such creators are currently registered an empty
   * list is returned.
   */
  public List<IConfigurationElement> getConfigurations( final Class<? extends Object> source,
                                                        final Class<? extends ICloudElement> target );

  /**
   * Get a list of all element creators that are defined as extensions
   * of the <code>eu.celar.core.cloudElementCreator</code> extension
   * point.
   * 
   * @return All defined element creators.
   */
  public List<ICloudElementCreator> getCreators();
  
  /**
   * Get the first {@link ICloudElementCreator} that is able to create an
   * element of the specified type from the specified object. If such a creator
   * could be found and a source object was specified the creator's source
   * objects will be initialised by calling
   * {@link ICloudElementCreator#setSource(Object)}.
   * 
   * @param source The object from which to create the element.
   * @param target The type of the element to be created.
   * @return An appropriate element creator or <code>null</code> if no such
   * creator is currently registered.
   */
  public ICloudElementCreator getCreator( final Object source,
                                         final Class< ? extends ICloudElement > target );
  
  public ICloudElementCreator getCreator( final Object source,
                                         final String targetClassName ) throws ProblemException;
  /**
   * Get the first {@link ICloudElementCreator} that is able to create an
   * element of the specified type from the specified object type.
   * 
   * @param source The object type from which to create the element.
   * @param target The type of the element to be created.
   * @return An appropriate element creator or <code>null</code> if no such
   * creator is currently registered.
   */
  public ICloudElementCreator getCreator( final Class< ? extends Object > source,
                                         final Class< ? extends ICloudElement > target );
  
  /**
   * Get a list of {@link ICloudElementCreator} that are able to create an
   * element of the specified type from the specified object. If such creators
   * could be found and a source object was specified the creators' source
   * objects will be initialized by calling
   * {@link ICloudElementCreator#setSource(Object)}.
   * 
   * @param source The object from which to create the element.
   * @param target The type of the element to be created.
   * @return A list of appropriate element creators. If no such creators are
   * currently registered an empty list is returned.
   */
  public List< ICloudElementCreator > getCreators( final Object source,
                                                  final Class< ? extends ICloudElement > target );
  /**
   * Get a list of {@link ICloudElementCreator} that are able to create an
   * element of the specified type from the specified object type.
   * 
   * @param source The object type from which to create the element.
   * @param target The type of the element to be created.
   * @return A list of appropriate element creators. If no such creators are
   * currently registered an empty list is returned.
   */
  public List< ICloudElementCreator > getCreators( final Class< ? extends Object > source,
                                                  final Class< ? extends ICloudElement > target );
}
