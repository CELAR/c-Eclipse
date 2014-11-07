package eu.celar.connectors.aws.operation;

import java.util.List;

import org.jclouds.ec2.domain.Image;



/**
 * This base class provides some common functionality for classes wanting to
 * fetch the list or available AMIs.
 * 
 * @author Nicholas Loulloudes
 */
public abstract class AbstractEC2OpDescribeImages implements IOperation {

  /** The resulting list of AMIs */
  private List<Image> result;

  /** Any exception which came up during the inquiry. */
  private Exception exception;

  abstract public void run();

  public List<Image> getResult() {
    return this.result;
  }

  public Exception getException() {
    return this.exception;
  }

  /**
   * A setter for {@link #result}.
   * 
   * @param describeImagesByOwner the param to set
   */
  protected void setResult( final List<Image> describeImages )
  {
    this.result = describeImages;
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
