/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core;

import eu.celar.core.internal.Activator;


/**
 * This class gives easy access to the core preferences of c-Eclipse.
 * 
 * @author Nicholas Loulloudes
 */
public class Preferences {
  
  /**
   * Set the name of the current default Cloud Provider.
   * 
   * @param defaultCloudProviderName The name of the default Cloud Provider.
   */
  static public void setDefaultCloudProviderName( final String defaultCloudProviderName ) {
    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
    preferenceStore.setValue( PreferenceConstants.DEFAULT_CLOUD_PROVIDER_ID, defaultCloudProviderName );
  }
  
  /**
   * Get the name of the current default Cloud Provider.
   * 
   * @return The name of the default Cloud Provider.
   */
  static public String getDefaultVoName() {
    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
    String defaultVoName = preferenceStore.getString( PreferenceConstants.DEFAULT_CLOUD_PROVIDER_ID );
    return defaultVoName;
  }
  
  /**
   * Save these preferences to the preference store. This method just calls
   * <code>Activator.getDefault().savePluginPreferences();</code>.
   */
  static public void save() {
    Activator.getDefault().savePluginPreferences();
  }
  
  /**
   * Get the preference store of the core preferences.
   * 
   * @return The preference store 
   */
  static protected org.eclipse.core.runtime.Preferences getPreferenceStore() {
    org.eclipse.core.runtime.Preferences preferenceStore = null;
    Activator activator = Activator.getDefault();
    if ( activator != null ) {
      preferenceStore = activator.getPluginPreferences();
    }
    return preferenceStore;
  }
  
}
