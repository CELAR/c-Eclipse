/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import eu.celar.core.internal.Activator;
import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.ICloudProviderManager;
import eu.celar.core.model.impl.GenericCloudProvider;
import eu.celar.core.model.impl.GenericCloudProviderCreator;
import eu.celar.core.reporting.ProblemException;

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
    
    ICloudProviderManager manager = CloudModel.getCloudProviderManager();
    GenericCloudProviderCreator creator = null;
    
    creator = new GenericCloudProviderCreator();
    creator.setVoName( ((GenericCloudProvider)newCloudProvider).getName());
    creator.setVoURI( ((GenericCloudProvider)newCloudProvider).getUri());
    creator.setVoPort( ((GenericCloudProvider)newCloudProvider).getPort());
    
    GenericCloudProvider cp = createVo( creator );
    try {
      manager.addElement( cp );
    } catch( ProblemException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
    
    
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
    
    ICloudProviderManager manager = CloudModel.getCloudProviderManager();
    manager.removeElement( removedCloudProvider );
    
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
  static public String getDefinedCloudProvidersString() {
    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
    String cloudProviders = preferenceStore.getString( PreferenceConstants.DEFINED_CPS_ID );
    return cloudProviders;
  }
  
  /**
   * Get the name of the current default Cloud Provider.
   * 
   * @return The name of the default Cloud Provider.
   */
  static public String getDeploymentsStatus() {
    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
    String deployments = preferenceStore.getString( PreferenceConstants.DEPLOYMENTS );
    return deployments;
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
  
  /**
   * Creates the Cloud Provider objects from the json string and adds them to the CloudProviderManager
   * 
   * @return The array with the defined Cloud Providers 
   */
  static public ICloudElement[] getDefinedCloudProviders() {
    ICloudElement[] result = null;

      ICloudProviderManager manager = CloudModel.getCloudProviderManager();

      try {
        result = manager.getChildren( null );
        
        if (result.length == 0){
          
          String providerName = getDefinedCloudProvidersString();
          if (providerName.equals( "" )){
            return result;
          }
          
          JSONArray providersArray = null;
          JSONObject provider = null;
          GenericCloudProviderCreator creator = null;
          try {
            //Get Cloud providers from Preference Store
            providersArray = new JSONArray(Preferences.getDefinedCloudProvidersString());
            for (int i=0; i<providersArray.length();i++){
              provider = providersArray.getJSONObject( i );
              creator = new GenericCloudProviderCreator();
              creator.setVoName( provider.getString( "name" ));
              creator.setVoURI( provider.getString( "uri" ));
              creator.setVoPort( provider.getString( "port" ));
              
              GenericCloudProvider cp = createVo( creator );
              manager.addElement( cp );
            }

          } catch( JSONException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          

          result = manager.getChildren( null );
        }
        
        Arrays.sort( result, new Comparator< ICloudElement >() {
          public int compare( final ICloudElement vo1,
                              final ICloudElement vo2 ) {
            return vo1.getName().compareTo( vo2.getName() );
          }
        } );
      } catch ( ProblemException pExc ) {
        pExc.printStackTrace();
      }
    
    return result;
  }
  
  // Method from class GenericCloudProviderWizard
  private static GenericCloudProvider createVo( final GenericCloudProviderCreator creator ) {
    
    IStatus result = Status.OK_STATUS;
    
    GenericCloudProvider vo = null;
    ICloudProviderManager manager = CloudModel.getCloudProviderManager();
    
    try {
      
        vo = ( GenericCloudProvider ) manager.create( creator );
      
    } catch ( ProblemException pExc ) {
      result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, pExc.getLocalizedMessage(), pExc );
    }
    
    if ( ! result.isOK() && ( vo != null ) ) {
      try {
        manager.delete( vo );
      } catch ( ProblemException pExc ) {
        Activator.logException( pExc );
      }
    }
    
    return vo;
    
  }


//  @Override
//  public void initializeDefaultPreferences() {
//    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
//    String providerString = "[{\"port\"\\:\"8443\",\"name\"\\:\"Flexiant\",\"uri\"\\:\"https\\://83.212.122.157\"},{\"port\"\\:\"8443\",\"name\"\\:\"Okeanos\",\"uri\"\\:\"https\\://83.212.122.157\"}]";
//    preferenceStore.setDefault( PreferenceConstants.DEFINED_CPS_ID, providerString);
//    
//  }
//  
}
