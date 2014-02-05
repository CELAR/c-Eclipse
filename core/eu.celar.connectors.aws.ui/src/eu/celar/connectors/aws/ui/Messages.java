package eu.celar.connectors.aws.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * This class uses the bundle mechanism with the message.properties file located
 * in the root of the project for i18n.
 * 
 * @author Moritz Post
 */
public class Messages {

  /** Name of the bundle file in the project root */
  private static final String BUNDLE_NAME = "eu.celar.connectors.aws.ui.messages"; //$NON-NLS-1$

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
