package eu.celar.connectors.aws.operation;

import java.util.List;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeImagesRequest;
import com.amazonaws.services.ec2.model.DescribeImagesResult;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.services.ec2.model.Image;

/**
 * This {@link IOperation} implementation uses the {@link EC2} to send a query
 * to the Amazon Webservice. It fetches all executable amazon machine images,
 * which we can be execute
 * 
 * @author Moritz Post
 */
public class EC2OpDescribeImages extends AbstractEC2OpDescribeImages {

  private final AmazonEC2 ec2;
  /**
   * Creates a new {@link EC2OpDescribeImages} with the given owners as
   * parameter.
   * 
   * @param ec2 the {@link AmazonEC2} to obtain data from
   */
  public EC2OpDescribeImages( final AmazonEC2 ec2 ) {
    this.ec2 = ec2;
  }
 

  @Override
  public void run() {
    setResult( null );
    setException( null );
    try {

      Filter[] filters = new Filter[2];
      filters[0] = new Filter().withName( "name" ).withValues( "*apache*" );  
      filters[1] = new Filter().withName( "name" ).withValues( "*ubuntu*" );
      
     
      DescribeImagesRequest request = new DescribeImagesRequest().withFilters( filters );
      DescribeImagesResult imageResult = this.ec2.describeImages(request);
      List<Image> images = imageResult.getImages();
      setResult( images );
    } catch( Exception ex ) {
      setException( ex );
    }

  }

}
