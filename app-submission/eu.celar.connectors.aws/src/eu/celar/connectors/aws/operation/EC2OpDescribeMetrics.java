package eu.celar.connectors.aws.operation;

import java.util.List;

import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.model.ListMetricsRequest;
import com.amazonaws.services.cloudwatch.model.ListMetricsResult;
import com.amazonaws.services.cloudwatch.model.Metric;
import com.amazonaws.services.ec2.AmazonEC2;

import eu.celar.connectors.aws.EC2Client;

/**
 * This {@link IOperation} implementation uses the {@link EC2} to send a query
 * to the Amazon CloudWatch. It fetches a list of all the Monitoring metrics
 * 
 * 
 * 
 */
public class EC2OpDescribeMetrics extends AbstractEC2OpDescribeMetrics {

  private final AmazonEC2 ec2;
  private final AmazonCloudWatch cloudWatch;
  /**
   * Creates a new {@link EC2OpDescribeMetrics} with the given owners as
   * parameter.
   * 
   * @param ec2 the {@link AmazonEC2} to obtain data from
   */
  public EC2OpDescribeMetrics( final AmazonEC2 ec2 ) {
    this.ec2 = ec2;
    this.cloudWatch = new AmazonCloudWatchClient( EC2Client.getCredentials() );
    this.cloudWatch.setRegion( RegionUtils.getRegion( "eu-west-1" ) );
  }
 

  @Override
  public void run() {
    setResult( null );
    setException( null );
    try {

     ListMetricsRequest request = new ListMetricsRequest();
     request.setNamespace( "AWS/EC2");
     ListMetricsResult listMetrics = this.cloudWatch.listMetrics( request );
     List<Metric> metrics = listMetrics.getMetrics();
      
      setResult( metrics );
    } catch( Exception ex ) {
      setException( ex );
    }

  }

}
