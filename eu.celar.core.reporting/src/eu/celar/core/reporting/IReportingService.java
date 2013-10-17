/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.reporting;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface IReportingService {
  
  public IProblem createProblem( final String description, final Throwable exception,
                                 final String mailto, final String pluginID );
  
  public IProblem getProblem( final String problemID, final String description,
                              final Throwable exception, final String pluginID );
  
  public ISolution createSolution( final String description, final ISolver solver );
  
  public ISolution getSolution( final String solutionID, final String description );
}
