/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.connectors.openstack;

import java.net.URI;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.jclouds.ContextBuilder;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.logging.slf4j.config.SLF4JLoggingModule;
import org.jclouds.openstack.nova.v2_0.NovaApi;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Module;

import eu.celar.connectors.openstack.auth.OpenStackAuthToken;
import eu.celar.connectors.openstack.auth.OpenStackAuthTokenDescription;
import eu.celar.core.auth.AbstractAuthTokenProvider;
import eu.celar.core.auth.AuthTokenRequest;
import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudProviderManager;
import eu.celar.core.reporting.ProblemException;

/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenStackClient {
  
  private static OpenStackClient instance = null;
  private static String provider = "openstack-nova"; //$NON-NLS-1$
  private static NovaApi nova = null;
  private static ContextBuilder contextBuilder = null;
  private static ComputeService computeService;
  
  public static OpenStackClient getInstance() {
    if (instance == null) {
      instance = new OpenStackClient();
    }    
    return instance;
  }
  
  private OpenStackClient() {
    if ( contextBuilder == null) {
      contextBuilder = getContextBuilder();
      if( contextBuilder != null ) {
        computeService = contextBuilder.buildView( ComputeServiceContext.class ).getComputeService();
        nova = contextBuilder.buildApi(NovaApi.class);        
      }
    }
  }
  
  private static ContextBuilder getContextBuilder()  {
//    ComputeServiceContext context = null;
    ContextBuilder builder = null;
    ICloudProviderManager cpManager = CloudModel.getCloudProviderManager();
    ICloudElement[] children;
    try {
      children = cpManager.getChildren( new NullProgressMonitor() );
      String accessId = null;
      URI endpoint = null;
      for( ICloudElement CloudElement : children ) {
        if( CloudElement instanceof OpenStackCloudProvider ) {
          OpenStackCloudProvider opCp = ( OpenStackCloudProvider )CloudElement;
          accessId = opCp.getProperties().getOpenStackAccessId();
          endpoint = opCp.getProperties().getOpenStackEndpoint();
        }
      }
      if( accessId != null ) {
        // get the auth token
        OpenStackAuthTokenDescription openStackAuthTokenDesc = new OpenStackAuthTokenDescription( accessId, endpoint );
        AuthTokenRequest request = new AuthTokenRequest( openStackAuthTokenDesc,
                                                         "OpenStackFetch", //$NON-NLS-1$
                                                         "Fectch OpenStack Info" ); //$NON-NLS-1$
        OpenStackAuthToken openStackAuthToken = ( OpenStackAuthToken )AbstractAuthTokenProvider.staticRequestToken( request );
        if( openStackAuthToken != null ) {
          Iterable<Module> modules = ImmutableSet.<Module> of(new SLF4JLoggingModule());          
          builder = ContextBuilder.newBuilder( provider )
              .endpoint( endpoint.toString() )
              .credentials( openStackAuthTokenDesc.getOpenStackAccessId(), openStackAuthTokenDesc.getOpenStackSecretId())
              .modules( modules );
        }
      }
    } catch( ProblemException e ) {
      e.printStackTrace();
    }

    
    return builder;
  }
  
  
  public NovaApi getNova(){
    return OpenStackClient.nova;
  }
  
  public ComputeService getComputeService(){
    return OpenStackClient.computeService;
  }
}
