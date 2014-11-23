package org.eclipse.camf.connectors.aws.operation;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.camf.connectors.aws.EC2Client;
import org.jclouds.ec2.domain.Image;
import org.jclouds.ec2.features.AMIApi;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;

/**
 * This {@link IOperation} implementation uses the {@link EC2} to send a query
 * to the Amazon Webservice. It fetches all executable amazon machine images,
 * which we can be execute
 * 
 * @author Moritz Post
 */
public class EC2OpDescribeImages extends AbstractEC2OpDescribeImages {

  private final EC2Client ec2;
  /**
   * Creates a new {@link EC2OpDescribeImages} with the given owners as
   * parameter.
   * 
   * @param ec2 the {@link AmazonEC2} to obtain data from
   */
  public EC2OpDescribeImages( final EC2Client ec2 ) {
    this.ec2 = ec2;
  }
 

  @Override
  public void run() {
    setResult( null );
    setException( null );
    try {
//    	List<Image> images = null;
    	
    	Optional<? extends AMIApi> amiApi = ec2.getEC2Api().getAMIApi();
    	Builder<String, String> filter = ImmutableMultimap.<String, String>builder();
//    	filter.put("name","ubuntu");
    	filter.put("name","*apache*");
    	
			Set<? extends Image> images = amiApi.get()
					.describeImagesInRegionWithFilter(ec2.getRegion(),
							filter.build());
    	
//      Filter[] filters = new Filter[2];
//      filters[0] = new Filter().withName( "name" ).withValues( "*apache*" );  
//      filters[1] = new Filter().withName( "name" ).withValues( "*ubuntu*" );
//           
//      DescribeImagesRequest request = new DescribeImagesRequest().withFilters( filters );
//      DescribeImagesResult imageResult = this.ec2.describeImages(request);
//      List<Image> images = imageResult.getImages();

      setResult( new ArrayList<Image>(images) );
    } catch( Exception ex ) {
      setException( ex );
    }

  }

}
