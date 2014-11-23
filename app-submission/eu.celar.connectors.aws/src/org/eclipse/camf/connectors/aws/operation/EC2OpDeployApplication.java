/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package org.eclipse.camf.connectors.aws.operation;




/**
 * @author Nicholas Loulloudes
 *
 */
//public class EC2OpDeployApplication extends AbstractEC2OpDeployApplication {
//  
//  private final AmazonEC2 ec2;
//  private final TOSCAResource toscaResource;
//  private final ICloudProject project;
//  private RunInstancesResult result;
//  
//  
//  public EC2OpDeployApplication(final AmazonEC2 ec2, final TOSCAResource tosca ) {
//    this.ec2 = ec2;
//    this.toscaResource = tosca;
//    this.project = this.toscaResource.getProject();
//  }
//
//  /* (non-Javadoc)
//   * @see org.eclipse.camf.connectors.aws.operation.AbstractEC2OpDeployApplication#run()
//   */
//  @Override
//  public void run() {
//    setResult( null );
//    setException( null );
//    try {
// 
//      TOSCAModel toscaModel = this.toscaResource.getTOSCAModel();
//      TServiceTemplate serviceTemplate = toscaModel.getServiceTemplate();
//      if( serviceTemplate != null ) {
//        TTopologyTemplate topologyTemplate = serviceTemplate.getTopologyTemplate();
//        if( topologyTemplate != null ) {
//          EList<TNodeTemplate> nodeTemplateList = topologyTemplate.getNodeTemplate();
//          if( nodeTemplateList != null ) {
//            // Instantiate each node in the topology
//            for( TNodeTemplate node : nodeTemplateList ) {              
//              RunInstancesRequest runRequest = new RunInstancesRequest();
//              
//              int minCount = node.getMinInstances();
//              int maxCount =  ((BigInteger) node.getMaxInstances()).intValue();
//              // Get Deployment Artifacts
//              TDeploymentArtifacts deploymentArtifacts = node.getDeploymentArtifacts();
//              
//              String amiID = null;
//              String keypair = null;
//              String keypairName = null;
//              
//                        
//              for( TDeploymentArtifact artifact : deploymentArtifacts.getDeploymentArtifact() )
//              {
//                // Find the VMI or Keypair artifacts 
//                String artifactType = artifact.getArtifactType().toString();
//                if( artifactType.equals( "VMI" ) ) { //$NON-NLS-1$
//                  amiID = artifact.getName();
//                } else if( artifactType.equals( "KeyPair" ) ) { //$NON-NLS-1$
//                  keypair = artifact.getName();
//                }
//                
//                if (keypair != null) {
//                  String encodedPublicKey = importKeyPair(keypair, this.project);         
//                  //Strip extension. - Get file name only
//                  keypairName = keypair.substring( 0, keypair.indexOf( "." ) ); //$NON-NLS-1$
//                  try {
//                    /* Get current key pair in Amazon */
//                    DescribeKeyPairsRequest describeKeyPairsRequest = new DescribeKeyPairsRequest();
//                    DescribeKeyPairsResult describeKeyPairsResult = this.ec2.describeKeyPairs( describeKeyPairsRequest.withKeyNames( keypairName ) );
//
//                    if (describeKeyPairsResult.getKeyPairs().size() == 0) {
//                      ImportKeyPairRequest importKeyRequest = new ImportKeyPairRequest( keypairName, encodedPublicKey );
//                      this.ec2.importKeyPair( importKeyRequest );    
//                    }
//                    
//                  } catch( AmazonServiceException ase ) {
//                    throw ase;
//                  }
//                  
//                }
//                
//              }
//              
//              runRequest.withImageId( amiID );              
//              runRequest.withInstanceType( InstanceType.C1Medium );
//              runRequest.withMinCount( Integer.valueOf( minCount ) );
//              runRequest.withMaxCount( Integer.valueOf( maxCount ) );
//              runRequest.withAdditionalInfo( node.getName() );
//              if( keypairName != null ) {
//                runRequest.withKeyName( keypairName );
//              }
//              
//              this.result = this.ec2.runInstances(runRequest);
//              
//            }
//          }
//        }
//      }
//
//    } catch (AmazonServiceException aws) {
//      this.setException( aws );
//      aws.printStackTrace();
//    } catch( Exception e ) {
//      e.printStackTrace();
//    } 
//
//  }
//  
//  
//  public RunInstancesResult getResult() {
//    return this.result;
//  }
//  
//  /**
//   * @param project 
//   * @param ec2 
//   * @param keyp
//   * @throws IOException 
//   */
//  private static String importKeyPair( final String publicKeyFile, final ICloudProject project) throws IOException {    
//    /* Read Public Key */
//    String encodedPublicKey = null;
//    BufferedReader br = null;
//    try {
//     
////      ICloudElement element = CloudModel.getRoot().findChildWithResource( publicKeyFile );
//      
//      // For now get the File 
//      // TODO - Incorporate Keypairs in CloudModel
//      File file = new File(Platform.getLocation() + "/" + project.getName() + "/Artifacts/Deployment Scripts/" + publicKeyFile); //$NON-NLS-1$ //$NON-NLS-2$
//           
//      br = new BufferedReader( new FileReader( file ) );
//      encodedPublicKey = br.readLine();
//      
//    } catch (IOException ioe) {
//        throw ioe;
//    } finally {
//        if (br != null) {
//            try {
//                br.close();
//                br = null;
//            } catch (IOException ioe) {
//                throw ioe;
//            }
//        }
//    }
//    return encodedPublicKey.trim();
//  }
//}
