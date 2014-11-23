/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package org.eclipse.camf.connectors.aws.operation;

import org.eclipse.core.runtime.IProgressMonitor;



/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class AbstractEC2OpDeployApplication implements IOperation {
  
  /** Any exception which came up during the inquiry. */
  private Exception exception;
  
  private Object result;

  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  @Override
  abstract public void run();

  /* (non-Javadoc)
   * @see org.eclipse.camf.connectors.aws.operation.IOperation#getResult()
   */
  @Override
  public Object getResult() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.connectors.aws.operation.IOperation#getException()
   */
  @Override
  public Exception getException() {
    // TODO Auto-generated method stub
    return this.exception;
  }
  
  protected void setException( final Exception ex ) {
    this.exception = ex;
  }
  
  protected void setResult (final Object result) {
    this.result = result;
  }
}
