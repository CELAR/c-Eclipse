package eu.celar.connectors.openstack.operation;

import java.util.List;

import org.jclouds.openstack.neutron.v2.domain.Network;



/**
 * This base class provides some common functionality for classes wanting to
 * fetch the list or available AMIs.
 * 
 * @author Nicholas Loulloudes
 */
public abstract class AbstractOpenStackOpDescribeNetworks implements IOperation {

  /** The resulting list of AMIs */
  private List<Network> result;

  /** Any exception which came up during the inquiry. */
  private Exception exception;

  abstract public void run();

  public List<Network> getResult() {
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
  protected void setResult( final List<Network> describeNetworks )
  {
    this.result = describeNetworks;
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
