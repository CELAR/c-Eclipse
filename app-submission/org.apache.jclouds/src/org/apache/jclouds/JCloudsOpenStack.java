package org.apache.jclouds;

import java.util.Set;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;

import org.jclouds.Context;
import org.jclouds.ContextBuilder;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.compute.domain.ComputeMetadata;
import org.jclouds.openstack.nova.v2_0.features.ImageApi;
import org.jclouds.openstack.nova.v2_0.features.ServerApi;
import org.jclouds.openstack.nova.v2_0.compute.NovaComputeService;
import org.jclouds.openstack.nova.v2_0.domain.Image;
import org.jclouds.openstack.nova.v2_0.domain.Server;
import org.jclouds.rest.RestContext;
import org.jclouds.openstack.nova.*;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.NovaAsyncApi;
import org.jclouds.logging.slf4j.config.SLF4JLoggingModule;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.FluentIterable;
import com.google.inject.Module;
 
public class JCloudsOpenStack {
  private ComputeService compute;
  
  private ContextBuilder contextBuilder;
  
//  private RestContext<NovaApi, NovaAsyncApi> nova;
  private Set<String> zones;
  private NovaApi novaAPI;
 
  public static void main(String[] args) {    
    JCloudsOpenStack jCloudsOpenStack = new JCloudsOpenStack();
    jCloudsOpenStack.init();
    jCloudsOpenStack.listImages();
    jCloudsOpenStack.listServers();
    jCloudsOpenStack.close();
  }
 
  private void init() {
    Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
      public void uncaughtException(Thread t, Throwable e) {
        if (JCloudsOpenStack.this.compute != null) close();
        e.printStackTrace();
        System.exit(1);
      }
    });
 
    Iterable<Module> modules = ImmutableSet.<Module> of(
      new SLF4JLoggingModule());
 
    String provider = "openstack-nova";
    String identity = "nephelae_vms_project:nickl"; // tenantName:userName
    String password = "nickl_123_nickl";
    String endpoint = "http://10.16.3.3:5000/v2.0/";
    
    this.contextBuilder = ContextBuilder.newBuilder(provider).endpoint( endpoint ).credentials(identity, password).modules(modules);
 
//    ComputeServiceContext context = ContextBuilder.newBuilder(provider)
//      .credentials(identity, password)
//      .modules(modules)
//      .buildView(ComputeServiceContext.class);
//    context = this.contextBuilder.buildView( ComputeServiceContext.class );
    
    
    this.novaAPI = this.contextBuilder.buildApi(NovaApi.class);
    
//    ContextBuilder#buildApi(NovaApi.class)
//    nova = context.unwrap();
//    zones = nova.getApi().getConfiguredZones();
  }
 
  private void listImages() {
    this.zones = this.novaAPI.getConfiguredZones();
    for (String zone: this.zones) {
      System.out.println("ZONE: " + zone);
      ImageApi imageApi = this.novaAPI.getImageApiForZone(zone);
      
      System.out.println("Calling listImages for " + zone + ":");
      
      FluentIterable<? extends Image> images = imageApi.listInDetail().concat();
    
      for (Image image: images) {
        System.out.println("\t" + image.getName() );
      }
    }
  }
  
  private void listServers() {
    for (String zone: zones) {
       ServerApi serverApi = this.novaAPI.getServerApiForZone(zone);
              
       System.out.println("Servers in " + zone);

       for (Server server: serverApi.listInDetail().concat()) {
          System.out.println("  " + server);
       }
    }
 }
  
  private void close() {
    try {
      this.novaAPI.close();
      if (this.compute != null)
        this.compute.getContext().close();

    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}