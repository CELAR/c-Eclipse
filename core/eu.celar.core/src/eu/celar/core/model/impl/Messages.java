/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.model.impl;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * @author Nicholas Loulloudes
 *
 */
public class Messages {
  private static final String BUNDLE_NAME = "eu.celar.core.model.impl.messages"; //$NON-NLS-1$
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
