package eu.celar.connectors.openstack.operation;

import java.util.ArrayList;
import java.util.Set;

import org.jclouds.compute.ComputeService;
import org.jclouds.openstack.nova.v2_0.domain.KeyPair;
import org.jclouds.openstack.nova.v2_0.extensions.KeyPairApi;

import eu.celar.connectors.openstack.OpenStackClient;

/**
 * This {@link IOperation} implementation uses the {@link ComputeService} to send a query
 * to the Amazon Webservice. It fetches all executable amazon machine images,
 * which we can be execute
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackOpDescribeKeyPairs extends AbstractOpenStackOpKeyPairs {

  private final KeyPairApi keyApi;
  /**
   * Creates a new {@link OpenStackOpDescribeKeyPairs} with the given owners as
   * parameter.
   * 
   * @param computeService the {@link ComputeService} to obtain data from
   */
  public OpenStackOpDescribeKeyPairs( ) {
    this.keyApi = OpenStackClient.getInstance().getKeyPairApi();
  }
 

  @Override
  public void run() {
    setResult( null );
    setException( null );
    try {
      
      Set<KeyPair> keypairs = this.keyApi.list().toSet();
    
    setResult( new ArrayList<KeyPair>(keypairs) );
    } catch( Exception ex ) {
      setException( ex );
    }

  }

}
