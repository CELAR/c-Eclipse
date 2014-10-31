package eu.celar.connectors.openstack.operation;

import java.util.ArrayList;
import java.util.Set;

import org.jclouds.compute.ComputeService;
import org.jclouds.openstack.neutron.v2.NeutronApi;
import org.jclouds.openstack.neutron.v2.domain.Network;
import org.jclouds.openstack.neutron.v2.features.NetworkApi;

import eu.celar.connectors.openstack.OpenStackClient;

/**
 * This {@link IOperation} implementation uses the {@link ComputeService} to
 * send a query to OpenStack. It fetches all executable amazon machine images,
 * which we can be execute
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackOpDescribeNetworks extends AbstractOpenStackOpDescribeNetworks {
  
  
  private final NeutronApi neutronApi;  
  
  /**
   * Creates a new {@link OpenStackOpDescribeNetworks} with the given owners as
   * parameter.
   * 
   * @param computeService the {@link ComputeService} to obtain data from
   */
  public OpenStackOpDescribeNetworks() {
    this.neutronApi = OpenStackClient.getInstance().getNetworkApi();
  }
 

  @Override
  public void run() {
    setResult( null );
    setException( null );
    try {
      NetworkApi network = this.neutronApi.getNetworkApi( "regionOne" );
      Set<Network> netSet = network.list().concat().toSet();
      setResult( new ArrayList<Network>( netSet ) );
    } catch( Exception ex ) {
      setException( ex );
    }
  }

}
