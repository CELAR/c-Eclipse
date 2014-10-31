/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.infosystem.ui.internal;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Returns the localised messages for this package.
 * @author nickl
 *
 */
public class Messages {
  private static final String BUNDLE_NAME = "eu.celar.infosystem.ui.internal"; //$NON-NLS-1$
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle( BUNDLE_NAME );

  private Messages() {
    // not instanceable
  }

  /**
   * Returns a localised version of a message.
   * 
   * @param key key for the message.
   * @return the localised string.
   */
  public static String getString( final String key ) {
    String message;
    try {
      message = RESOURCE_BUNDLE.getString( key );
    } catch( final MissingResourceException exception ) {
      message = '!' + key + '!';
    }
    return message;
  }
}
