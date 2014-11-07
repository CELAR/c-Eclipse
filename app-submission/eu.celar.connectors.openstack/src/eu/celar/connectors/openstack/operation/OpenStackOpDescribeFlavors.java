package eu.celar.connectors.openstack.operation;

import java.util.ArrayList;
import java.util.Set;

import org.jclouds.compute.ComputeService;
import org.jclouds.openstack.nova.v2_0.features.FlavorApi;
import org.jclouds.openstack.v2_0.domain.Resource;

import eu.celar.connectors.openstack.OpenStackClient;

/**
 * This {@link IOperation} implementation uses the {@link ComputeService} to send a query
 * to the Amazon Webservice. It fetches all executable amazon machine images,
 * which we can be execute
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackOpDescribeFlavors extends AbstractOpenStackOpFlavors {

  private final FlavorApi flavorApi;
  /**
   * Creates a new {@link OpenStackOpDescribeFlavors} with the given owners as
   * parameter.
   * 
   */
  public OpenStackOpDescribeFlavors() {
    this.flavorApi = OpenStackClient.getInstance().getFlavorApi();
  }
 

	@Override
	public void run() {
		setResult(null);
		setException(null);
		try {

			Set<Resource> flavors = this.flavorApi.list().concat().toSet();

			setResult(new ArrayList<Resource>(flavors));
		} catch (Exception ex) {
			setException(ex);
		}

	}

}
