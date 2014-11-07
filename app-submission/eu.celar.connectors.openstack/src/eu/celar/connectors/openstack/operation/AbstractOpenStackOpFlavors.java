package eu.celar.connectors.openstack.operation;

import java.util.List;

import org.jclouds.openstack.v2_0.domain.Resource;


/**
 * This base class provides some common functionality for classes wanting to
 * fetch the list or available VM flavors.
 * 
 * @author Nicholas Loulloudes
 */
public abstract class AbstractOpenStackOpFlavors implements IOperation {

  /** The resulting list of Flavors */
  private List<Resource> result;

  /** Any exception which came up during the inquiry. */
  private Exception exception;

  abstract public void run();

  public List<Resource> getResult() {
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
  protected void setResult( final List<Resource> describedFlavors )
  {
    this.result = describedFlavors;
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
