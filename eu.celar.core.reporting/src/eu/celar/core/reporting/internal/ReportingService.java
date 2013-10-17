/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.reporting.internal;

import eu.celar.core.reporting.IProblem;
import eu.celar.core.reporting.IReportingService;
import eu.celar.core.reporting.ISolution;
import eu.celar.core.reporting.ISolver;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ReportingService implements IReportingService {

  /**
   * The singleton instance.
   */
  private static ReportingService singleton;
  
  /**
   * Private constructor
   */
  private ReportingService() {
    // empty implementation
  }
  
  /**
   * Get the singleton instance.
   * 
   * @return The service's singleton instance.
   */
  public static ReportingService getService() {
    if ( singleton == null ) {
      singleton = new ReportingService();
    }
    return singleton;
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.reporting.IReportingService#createProblem(java.lang.String, java.lang.Throwable,
   *                                                                 java.lang.String, java.lang.String)
   */
  public IProblem createProblem( final String description,
                                 final Throwable exception,
                                 final String mailto,
                                 final String pluginID ) {
    return new Problem( null, description, exception, mailto, pluginID );
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.reporting.IReportingService#getProblem(java.lang.String, java.lang.String,
   *                                                              java.lang.Throwable, java.lang.String)
   */
  public IProblem getProblem( final String problemID,
                              final String description,
                              final Throwable exception,
                              final String pluginID ) {
    return ProblemFactory.getFactory().getProblem( problemID, description, exception, pluginID );
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.reporting.IReportingService#createSolution(java.lang.String,
   *                                                                  eu.geclipse.core.reporting.ISolver)
   */
  public ISolution createSolution( final String description,
                                   final ISolver solver ) {
    return new Solution( null, description, solver );
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.reporting.IReportingService#getSolution(java.lang.String, java.lang.String)
   */
  public ISolution getSolution( final String solutionID,
                                final String description ) {
    return SolutionFactory.getFactory().getSolution( solutionID, description );
  }
}
