/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.connectors.openstack.operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.jclouds.compute.ComputeService;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.domain.KeyPair;
import org.jclouds.openstack.nova.v2_0.domain.ServerCreated;
import org.jclouds.openstack.nova.v2_0.extensions.KeyPairApi;
import org.jclouds.openstack.nova.v2_0.features.ServerApi;
import org.jclouds.openstack.nova.v2_0.options.CreateServerOptions;

import com.google.common.collect.FluentIterable;

import eu.celar.connectors.openstack.OpenStackClient;
import eu.celar.core.model.ICloudProject;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.TTopologyTemplate;
import eu.celar.tosca.core.TOSCAModel;
import eu.celar.tosca.core.TOSCAResource;



/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenStackOpDeployApplication extends AbstractOpenStackOpDeployApplication {
  
  private final ComputeService computeService;
  private final TOSCAResource toscaResource;
  private final ICloudProject project;
  
  
  public OpenStackOpDeployApplication(final OpenStackClient client, final TOSCAResource tosca ) {
    this.computeService =client.getComputeService();
    this.toscaResource = tosca;
    this.project = this.toscaResource.getProject();
  }

  /* (non-Javadoc)
   * @see eu.celar.connectors.aws.operation.AbstractEC2OpDeployApplication#run()
   */
  @Override
  public void run() {
    setResult( null );
    setException( null );
    try {
 
      NovaApi nova = OpenStackClient.getInstance().getNova();
      //TODO - Hack for Nephelae. Only one region there. Fix it for other providers with more zones.
      String zone = "RegionOne";
      ServerApi serverApi = nova.getServerApiForZone( zone );
      KeyPairApi keyPairApi = nova.getKeyPairExtensionForZone( zone ).get();      
      
      TOSCAModel toscaModel = this.toscaResource.getTOSCAModel();
      TServiceTemplate serviceTemplate = toscaModel.getServiceTemplate();
      if( serviceTemplate != null ) {
        TTopologyTemplate topologyTemplate = serviceTemplate.getTopologyTemplate();
        if( topologyTemplate != null ) {
          EList<TNodeTemplate> nodeTemplateList = topologyTemplate.getNodeTemplate();
          if( nodeTemplateList != null ) {
            // Instantiate each node in the topology
            for( TNodeTemplate node : nodeTemplateList ) {


              
              int minCount = node.getMinInstances();
              int maxCount =  ((BigInteger) node.getMaxInstances()).intValue();
              // Get Deployment Artifacts
              TDeploymentArtifacts deploymentArtifacts = node.getDeploymentArtifacts();
              
              String amiID = null;
              String keyPairArtifact = null;
              String keypairName = null;
              KeyPair keyPair = null;
              boolean keyPairExists = false;
              
                        
              for( TDeploymentArtifact artifact : deploymentArtifacts.getDeploymentArtifact() )
              {
                // Find the VMI or Keypair artifacts 
                String artifactType = artifact.getArtifactType().toString();
                if( artifactType.equals( "VMI" ) ) { //$NON-NLS-1$
                  amiID = artifact.getName();
                } else if( artifactType.equals( "KeyPair" ) ) { //$NON-NLS-1$
                  keyPairArtifact = artifact.getName();
                }
                
                if (keyPairArtifact != null) {
                  String encodedPublicKey = importKeyPair(keyPairArtifact, this.project); 
                                    
                  //Strip extension. - Get file name only
                  keypairName = keyPairArtifact.substring( 0, keyPairArtifact.indexOf( "." ) ); //$NON-NLS-1$
                  keyPairExists = keyPairExists( keyPairApi, keypairName );
                  if (!keyPairExists){
                    keyPair = keyPairApi.createWithPublicKey( keypairName, encodedPublicKey );
                  } 
                  
                }
                
              }
              
              CreateServerOptions sv = CreateServerOptions.Builder.adminPass("nickl"); //$NON-NLS-1$
              
              if (!keyPairExists) {
                if (keyPair != null) {
                  sv.keyPairName( keypairName );
                }  
              } else {
                sv.keyPairName( keypairName );
              }
              
              
              ServerCreated newServer = serverApi.create(node.getName(), amiID, "1", sv);              
              

            }
          }
        }
      }

    } catch (Exception ex) {
      this.setException( ex );
      ex.printStackTrace();
    }
  }
  
  
  public Object getResult() {
    return null;
  }
  
  private static boolean keyPairExists(final KeyPairApi keyPairApi, final String keyPairName ){
    if (keyPairApi != null && keyPairName != null ){
      FluentIterable<? extends KeyPair> list = keyPairApi.list();                  
      Iterator<? extends KeyPair> iterator = list.iterator();
      
      while (iterator.hasNext()) {
        KeyPair keypair = iterator.next();
        if (keypair.getName().equals( keyPairName )){
          return true;
        }      
      }
    }
    return false;
  }
  
  /**
   * @param project 
   * @param ec2 
   * @param keyp
   * @throws IOException 
   */
  private static String importKeyPair( final String publicKeyFile, final ICloudProject project) throws IOException {    
    /* Read Public Key */
    String encodedPublicKey = null;
    BufferedReader br = null;
    try {
     
//      ICloudElement element = CloudModel.getRoot().findChildWithResource( publicKeyFile );
      
      // For now get the File 
      // TODO - Incorporate Keypairs in CloudModel
      File file = new File(Platform.getLocation() + "/" + project.getName() + "/Artifacts/Deployment Scripts/" + publicKeyFile); //$NON-NLS-1$ //$NON-NLS-2$
           
      br = new BufferedReader( new FileReader( file ) );
      encodedPublicKey = br.readLine();
      
    } catch (IOException ioe) {
        throw ioe;
    } finally {
        if (br != null) {
            try {
                br.close();
                br = null;
            } catch (IOException ioe) {
                throw ioe;
            }
        }
    }
    return encodedPublicKey.trim();
  }
}
