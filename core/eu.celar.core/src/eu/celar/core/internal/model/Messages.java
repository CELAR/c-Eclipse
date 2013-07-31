/*****************************************************************************
 * Copyright (c) 2006, 2007 g-Eclipse Consortium 
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

import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * Auto generated class.
 */
public class Messages {
  private static final String BUNDLE_NAME = "eu.celar.core.internal.model.messages"; //$NON-NLS-1$
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle( BUNDLE_NAME );

  private Messages() {
    // empty implementation
  }

  /**
   * Auto-generated method.
   * 
   * @param key The key.
   * @return The value.
   */
  public static String getString( final String key ) {
    String result = '!' + key + '!';
    try {
      result = RESOURCE_BUNDLE.getString( key );
    } catch( MissingResourceException e ) {
      // Nothing to do;
    }
    return result;
  }
}
