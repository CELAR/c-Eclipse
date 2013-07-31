/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.ui.internal.actions;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Nicholas Loulloudes
 */
public class Messages {

  private static final String BUNDLE_NAME = "eu.celar.ui.internal.actions.messages"; //$NON-NLS-1$
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle( BUNDLE_NAME );

  private Messages() {
    // empty implementation
  }

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

  /**
   * Returns a localised version of a message (Containing one argument).
   * 
   * @param key key for the message.
   * @param arg0 argument to insert.
   * @return the localised string.
   */
  public static String formatMessage( final String key, final Object arg0 ) {
    String messageString = getString( key );
    MessageFormat mf = new MessageFormat( messageString );
    Object[] args = new Object[ 1 ];
    args[ 0 ] = arg0;
    return mf.format( args );
  }
}
