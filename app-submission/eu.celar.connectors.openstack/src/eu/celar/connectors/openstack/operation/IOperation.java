/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.connectors.openstack.operation;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface IOperation extends Runnable {
  
  /**
   * Returns the result of the operation executed in the {@link Runnable#run()}
   * method of this {@link IOperation}.
   * 
   * @return the result of the operation or <code>null</code> if an error
   *         occurred
   */
  public Object getResult();

  /**
   * Returns any exception which came up during the execution of the
   * {@link Runnable#run()} method.
   * 
   * @return the exception which might have come up or <code>null</code> if no
   *         error occurred
   */
  public Exception getException();
}
