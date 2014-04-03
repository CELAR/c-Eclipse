package eu.celar.connectors.openstack.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jclouds.compute.ComputeService;
import org.jclouds.compute.domain.Image;

import eu.celar.connectors.openstack.OpenStackClient;

/**
 * This {@link IOperation} implementation uses the {@link ComputeService} to send a query
 * to the Amazon Webservice. It fetches all executable amazon machine images,
 * which we can be execute
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackOpDescribeImages extends AbstractOpenStackOpDescribeImages {

  private final ComputeService computeService;
  /**
   * Creates a new {@link OpenStackOpDescribeImages} with the given owners as
   * parameter.
   * 
   * @param computeService the {@link ComputeService} to obtain data from
   */
  public OpenStackOpDescribeImages( final ComputeService computeService ) {
    this.computeService = computeService;
  }
 

  @Override
  public void run() {
    setResult( null );
    setException( null );
    try {

      Set<Image> images = ( Set<Image> )this.computeService.listImages();
      setResult( new ArrayList<Image>(images) );
    } catch( Exception ex ) {
      setException( ex );
    }

  }

}
