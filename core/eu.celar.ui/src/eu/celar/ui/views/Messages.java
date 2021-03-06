/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.views;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * @author Nicholas Loulloudes
 *
 */
public class Messages {
  private static final String BUNDLE_NAME = "eu.celar.ui.views.messages"; //$NON-NLS-1$
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle( BUNDLE_NAME );

  /**
   * Returns a localised version of a message.
   *
   * @param key key for the message.
   * @return the localised string.
   */
 public static String getString( final String key ) {
    String resultString = '!' + key + '!';
    try {
      resultString = RESOURCE_BUNDLE.getString( key );
    } catch( MissingResourceException mrEx ) {
      // Nothing to do here
    }
    return resultString;
  }

 private Messages() {
  // empty implementation
}

}
