/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.reporting;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ProblemException extends CoreException {

  /**
   * The serial version UID 
   */
  private static final long serialVersionUID = 9022969432073811687L;
  
  private IProblem problem;
  
  public ProblemException ( final String problemID, final String pluginID ) {
    this (problemID, null, null, pluginID);
  }
  
  public ProblemException( final String problemID, final Throwable exception, final String pluginID ) {
    this( problemID, null, exception, pluginID );
  }
  
  public ProblemException( final String problemID, final String description, final String pluginID ) {
    this( problemID, description, null, pluginID );
  }
  
  public ProblemException( final String problemID, final String description, 
                           final Throwable exception, final String pluginID ) {
    this( ReportingPlugin.getReportingService().getProblem( problemID, description, exception, pluginID ) );
  }
  
  public IProblem getProblem() {
    return this.problem;
  }
  
  public ProblemException( final IStatus status ) {
    super( status );
  }
  
  public ProblemException( final IProblem problem ) {
    this( problem.getStatus() );
    this.problem = problem;
  } 
  
}
