/*******************************************************************************
 * Copyright (c) 2014 CELAR Consortium.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package eu.celar.connectors.openstack.operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.domain.Flavor;
import org.jclouds.openstack.nova.v2_0.domain.KeyPair;
import org.jclouds.openstack.nova.v2_0.domain.ServerCreated;
import org.jclouds.openstack.nova.v2_0.extensions.KeyPairApi;
import org.jclouds.openstack.nova.v2_0.features.FlavorApi;
import org.jclouds.openstack.nova.v2_0.features.ServerApi;
import org.jclouds.openstack.nova.v2_0.options.CreateServerOptions;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Ordering;

import eu.celar.connectors.openstack.OpenStackClient;
import eu.celar.core.model.ICloudProject;
import eu.celar.tosca.PropertiesType;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.TTopologyTemplate;
import eu.celar.tosca.core.TOSCAModel;
import eu.celar.tosca.core.TOSCAResource;
import eu.celar.tosca.elasticity.NodePropertiesType;



/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenStackOpDeployApplication extends AbstractOpenStackOpDeployApplication {
  
  private final TOSCAResource toscaResource;
  private final ICloudProject project;
  
  
  public OpenStackOpDeployApplication(final OpenStackClient client, final TOSCAResource tosca ) {
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
      String zone = "regionOne";
      KeyPairApi keyPairApi = nova.getKeyPairExtensionForZone( zone ).get();      
      ServerApi serverApi = nova.getServerApiForZone( zone );      
            
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
              
              PropertiesType properties = node.getProperties();
              String nodeFlavor = null;
              
              FeatureMap propFeatMap = properties.getAny();
              for (Entry entry : propFeatMap){
            	  if (entry instanceof NodePropertiesType)
            		    nodeFlavor = ((NodePropertiesType) entry).getFlavor();
              }

              
              
              // Get Deployment Artifacts
              TDeploymentArtifacts deploymentArtifacts = node.getDeploymentArtifacts();
              
              String amiID = null;
              String flavorID = null;
              String keyPairArtifact = null;
              String keypairName = null;
              KeyPair keyPair = null;
              boolean keyPairExists = false;
              String networks = null;
              String script = null;
              
                        
              for( TDeploymentArtifact artifact : deploymentArtifacts.getDeploymentArtifact() )
              {
                // Find the VMI or Keypair artifacts 
                String artifactType = artifact.getArtifactType().toString();
                if( artifactType.equals( "VMI" ) ) { //$NON-NLS-1$
                  amiID = artifact.getName();
                } else if( artifactType.equals( "KeyPair" ) ) { //$NON-NLS-1$
                  keyPairArtifact = artifact.getName();
                } else if (artifactType.equals( "Network" )) {
                  networks = artifact.getName() ;
                } else if (artifactType.equals("Script")){
                	script = artifact.getName();
                }
                
                if (keyPairArtifact != null) {
                  String encodedPublicKey = importKeyPair(keyPairArtifact, this.project); 
                                    
                  //Strip extension. - Get file name only
                  if (encodedPublicKey != null) {
                    keypairName = keyPairArtifact.substring( 0, keyPairArtifact.indexOf( "." ) ); //$NON-NLS-1$
                  } else {
                    keypairName = keyPairArtifact;
                  }
                  keyPairExists = keyPairExists( keyPairApi, keypairName );
                  if (!keyPairExists){
                    keyPair = keyPairApi.createWithPublicKey( keypairName, encodedPublicKey );
                  } 
                  
                }
                
                if (nodeFlavor != null) {
                	flavorID = flavorRefForRegion(nova, zone);
                } else {
                	flavorID = "1";
                }
                
                String statements = null;
                if (script != null) {
                	 statements = importScript(script, this.project);
                	
                }
                
              }
              
        	  CreateServerOptions sv;
        	  if (networks != null)
        		  sv = CreateServerOptions.Builder.adminPass("test").networks( networks ); //$NON-NLS-1$
        	  else
        		  sv = CreateServerOptions.Builder.adminPass("test"); //$NON-NLS-1$
            
              
              if (!keyPairExists) {
                if (keyPair != null) {
                  sv.keyPairName( keypairName );
                }  
              } else {
                sv.keyPairName( keypairName );
              }
              
              for( int i = 1; i <= maxCount; i++ ) {
                ServerCreated newServer = serverApi.create( node.getName()
                                                            + "_"
                                                            + i, amiID, "3", sv );
              }
  
            }
          }
        }
      }

    } catch (Exception ex) {
      this.setException( ex );
      ex.printStackTrace();
    }
  }
  
  protected String flavorRefForRegion(NovaApi api, String regionId) {
    FlavorApi flavorApi = api.getFlavorApiForZone(regionId);
    return DEFAULT_FLAVOR_ORDERING.min(flavorApi.listInDetail().concat()).getId();
 }
  
  static final Ordering<Flavor> DEFAULT_FLAVOR_ORDERING = new Ordering<Flavor>() {
    public int compare(Flavor left, Flavor right) {
       return ComparisonChain.start().compare(left.getVcpus(), right.getVcpus()).compare(left.getRam(), right.getRam())
             .compare(left.getDisk(), right.getDisk()).result();
    }
 };
  
  
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
  private static String importKeyPair( final String publicKeyFile,
                                       final ICloudProject project )
    throws IOException
  {
    /* Read Public Key */
    String encodedPublicKey = null;
    BufferedReader br = null;
    try {
      // ICloudElement element = CloudModel.getRoot().findChildWithResource(
      // publicKeyFile );
      // For now get the File
      // TODO - Incorporate Keypairs in CloudModel
      File file = new File( Platform.getLocation()
                            + "/" + project.getName() + "/Artifacts/Deployment Scripts/" + publicKeyFile ); //$NON-NLS-1$ //$NON-NLS-2$
      if( file.exists() ) {
        br = new BufferedReader( new FileReader( file ) );
        encodedPublicKey = br.readLine();
        encodedPublicKey.trim();
      }
    } catch( IOException ioe ) {
      throw ioe;
    } finally {
      if( br != null ) {
        try {
          br.close();
          br = null;
        } catch( IOException ioe ) {
          throw ioe;
        }
      }
    }
    return encodedPublicKey;
  }
  
  
	private static String importScript(final String scriptFile,
			final ICloudProject project) throws IOException {
		
		/* Read Script */
		String scriptContent = null;
		BufferedReader br = null;
		try {
			// ICloudElement element =
			// CloudModel.getRoot().findChildWithResource(
			// publicKeyFile );
			// For now get the File
			// TODO - Incorporate Keypairs in CloudModel
			File file = new File(
					Platform.getLocation()
							+ "/" + project.getName() + "/Artifacts/Deployment Scripts/" + scriptFile	); //$NON-NLS-1$ //$NON-NLS-2$
			if (file.exists()) {
				br = new BufferedReader(new FileReader(file));
				scriptContent = br.readLine();
				scriptContent.trim();
			}
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
		return scriptContent;
	}
}
