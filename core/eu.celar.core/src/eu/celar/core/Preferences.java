/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import eu.celar.core.internal.Activator;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.impl.GenericCloudProvider;


/**
 * This class gives easy access to the core preferences of c-Eclipse.
 * 
 * @authors Nicholas Loulloudes, Stalo Sofokleous
 */
public class Preferences {
  
  /**
   * Add a new Cloud Provider.
   * 
   * @param newCloudProvider The new Cloud Provider.
   */
  static public void addCloudProvider(final ICloudProvider newCloudProvider){
    JSONObject provider = null;
    try {
      provider =  new JSONObject();
      provider.put("name", ((GenericCloudProvider)newCloudProvider).getName() );
      provider.put( "uri", ((GenericCloudProvider)newCloudProvider).getUri() );
      provider.put( "port",((GenericCloudProvider)newCloudProvider).getPort() );
    } catch( JSONException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();

    JSONArray providersArray = null;
    String providerString = preferenceStore.getString( PreferenceConstants.DEFINED_CPS_ID );
    if (providerString.equals( "" )){
      providersArray = new JSONArray();
    }
    else{
      try {
        providersArray = new JSONArray( providerString );
      } catch( JSONException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
        
    
    JSONObject tempProvider;
    for (int i=0; i<providersArray.length(); i++){
      try {
        tempProvider = providersArray.getJSONObject( i );
        if (tempProvider.getString( "name" ).compareTo( newCloudProvider.getName() )==0){
          tempProvider.put( "uri", ((GenericCloudProvider) newCloudProvider).getUri() );
          tempProvider.put( "port", ((GenericCloudProvider) newCloudProvider).getPort() );
          preferenceStore.setValue( PreferenceConstants.DEFINED_CPS_ID, providersArray.toString() );
          return;
        }
      } catch( JSONException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

    providersArray.put( provider );
    preferenceStore.setValue( PreferenceConstants.DEFINED_CPS_ID, providersArray.toString() );
    save();
    
  }
  
  
  /**
   * Remove Cloud Provider.
   * 
   * @param removedCloudProvider The Cloud Provider to be removed.
   */
  static public void removeCloudProvider(final ICloudProvider removedCloudProvider){
    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();

    JSONArray providersArray = null;
    String providerString = preferenceStore.getString( PreferenceConstants.DEFINED_CPS_ID );
    try {
      providersArray = new JSONArray( providerString );
    } catch( JSONException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    JSONObject tempProvider;
    for (int i=0; i<providersArray.length(); i++){
      try {
        tempProvider = providersArray.getJSONObject( i );
        if (tempProvider.getString( "name" ).compareTo( removedCloudProvider.getName() )==0){
          providersArray.remove( i );
          break;
        }
      } catch( JSONException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    preferenceStore.setValue( PreferenceConstants.DEFINED_CPS_ID, providersArray.toString() );
    save();
  }
  
  
  /**
   * Get the name of the current default Cloud Provider.
   * 
   * @return The name of the default Cloud Provider.
   */
  static public String getDefinedCloudProviders() {
    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
    String cloudProviders = preferenceStore.getString( PreferenceConstants.DEFINED_CPS_ID );
    return cloudProviders;
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
