package eu.celar.connectors.aws.operation;

import java.util.List;

import org.jclouds.cloudwatch.domain.Metric;


/**
 * This base class provides some common functionality for classes wanting to
 * fetch the list or available CloudWatch Metrics.
 * 
 * @author Nicholas Loulloudes
 */
public abstract class AbstractEC2OpDescribeMetrics implements IOperation {

  /** The resulting list of AMIs */
  private List<Metric> result;

  /** Any exception which came up during the inquiry. */
  private Exception exception;

  abstract public void run();

  public List<Metric> getResult() {
    return this.result;
  }

  public Exception getException() {
    return this.exception;
  }

  /**
   * A setter for {@link #result}.
   * 
   * @param describeMetrics the param to set
   */
  protected void setResult( final List<Metric> describeMetrics )
  {
    this.result = describeMetrics;
  }

  /**
   * A setter for {@link #exception}.
   * 
   * @param ex the exception to set
   */
  protected void setException( final Exception ex ) {
    this.exception = ex;
  }
}
