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
package eu.celar.connectors.openstack.internal;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * This class uses the bundle mechanism with the message.properties file located
 * in the root of the project.
 * 
 * @author Nicholas Loulloudes
 */
public class Messages {

  /** Name of the bundle file in the project root */
  private static final String BUNDLE_NAME = "eu.celar.connectors.openstack.internal.messages"; //$NON-NLS-1$

  /** Bundle to work with. */
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle( Messages.BUNDLE_NAME );

  /**
   * Hidden constructor
   */
  private Messages() {
    // nothing to do here
  }

  /**
   * Get the value for the string key.
   * 
   * @param key the key for the value
   * @return the value
   */
  public static String getString( final String key ) {
    try {
      return Messages.RESOURCE_BUNDLE.getString( key );
    } catch( MissingResourceException e ) {
      return '!' + key + '!';
    }
  }
}
