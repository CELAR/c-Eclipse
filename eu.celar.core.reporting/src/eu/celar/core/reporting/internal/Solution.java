/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.reporting.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import eu.celar.core.reporting.IConfigurableSolver;
import eu.celar.core.reporting.ISolution;
import eu.celar.core.reporting.ISolver;


/**
 * @author Nicholas Loulloudes
 *
 */
public class Solution implements ISolution, IConfigurableSolver {

  /**
   * The solution's ID in case this is a descriptively defined
   * solution.
   */
  private String id;
  
  /**
   * The solution's description.
   */
  private String description;
  
  /**
   * The solution's optional solver.
   */
  private ISolver solver;
  
  /**
   * Create a new solution with the specified id, description
   * and solver.
   * 
   * @param id The unique ID of the solution if this is
   * a descriptively defined solution. <code>null</code> id this
   * is a programmatically defined solution.
   * @param description The description of the solution.
   * @param solver An optional solver for this solution.
   */
  public Solution( final String id,
                   final String description,
                   final ISolver solver ) {
    this.id = id;
    this.description = description;
    this.solver = solver;
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.reporting.ISolution#getDescription()
   */
  public String getDescription() {
    return this.description;
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.reporting.ISolution#getID()
   */
  public String getID() {
    return this.id;
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.reporting.ISolution#isActive()
   */
  public boolean isActive() {
    return this.solver != null;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement,
   *                                                                          java.lang.String, java.lang.Object)
   */
  public void setInitializationData( final IConfigurationElement config,
                                     final String propertyName,
                                     final Object data )
      throws CoreException {
    if ( this.solver instanceof IConfigurableSolver ) {
      ( ( IConfigurableSolver ) this.solver ).setInitializationData( config, propertyName, data );
    }
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.reporting.ISolver#solve()
   */
  public void solve() throws InvocationTargetException {
    if ( this.solver != null ) {
      this.solver.solve();
    }
  }

  @Override
  public boolean equals( final Object obj ) {
    boolean result = false;
    if ( obj instanceof ISolution ) {
      result = getID().equals( ( ( ISolution )obj ).getID() );
    }
    return result;
  }

  @Override
  public int hashCode() {
    return getID().hashCode();
  }
}
