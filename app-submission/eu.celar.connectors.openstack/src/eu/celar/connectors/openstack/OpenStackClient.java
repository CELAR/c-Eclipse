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
import org.jclouds.openstack.neutron.v2.NeutronApi;
import org.jclouds.openstack.neutron.v2.NeutronApiMetadata;
import org.jclouds.openstack.neutron.v2.features.NetworkApi;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.NovaApiMetadata;
import org.jclouds.openstack.nova.v2_0.domain.KeyPair;
import org.jclouds.openstack.nova.v2_0.extensions.KeyPairApi;

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
  private static String network_provider = "openstack-neutron";
  private static NovaApi nova = null;
  private static NeutronApi neutron = null;
  private static ContextBuilder contextBuilder = null;
  private static ContextBuilder networkBuilder = null;
  private static ComputeService computeService;
  private static final String zone = "regionOne";
  
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
      
      if( networkBuilder != null ) {
        neutron = networkBuilder.buildApi( NeutronApi.class );
      }
    }
  }
  
  private static ContextBuilder getContextBuilder()  {
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
          builder = ContextBuilder.newBuilder( new NovaApiMetadata() )
              .endpoint( endpoint.toString() )
              .credentials( openStackAuthTokenDesc.getOpenStackAccessId(), openStackAuthTokenDesc.getOpenStackSecretId())
              .modules( modules );
          
          networkBuilder = ContextBuilder.newBuilder( new NeutronApiMetadata() )
            .endpoint( endpoint.toString() )
            .credentials( openStackAuthTokenDesc.getOpenStackAccessId(),
                          openStackAuthTokenDesc.getOpenStackSecretId() )
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
  
  public NeutronApi getNetworkApi(){
    return OpenStackClient.neutron;
  }
  
  public KeyPairApi getKeyPairApi(){
    return OpenStackClient.nova.getKeyPairExtensionForZone( zone ).get();
  }
}
