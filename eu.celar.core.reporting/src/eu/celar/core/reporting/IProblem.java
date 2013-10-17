/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.reporting;

import org.eclipse.core.runtime.IStatus;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface IProblem {
  
  public void addReason( final String reason );
    
  public void addSolution( final ISolution solution );
  
  public void addSolution( final String solutionID, final String description );
    
  public String getDescription();
  
  public Throwable getException();
  
  public String getID();
    
  public String getPluginID();
  
  public String[] getReasons();
  
  public ISolution[] getSolutions();
  
  public IStatus getStatus();

  public boolean hasReasons();

  public boolean hasSolutions();

  public void merge( final IProblem problem );
  
  public String getMailTo();
}
