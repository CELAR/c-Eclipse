package eu.celar.core.project;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScope;

/**
 * Project scope for the Cloud project that manages project related
 * settings and preferences.
 */
public class CloudProjectScope implements IScope {

  /* (non-Javadoc)
   * @see org.eclipse.core.runtime.preferences.IScope#create(org.eclipse.core.runtime.preferences.IEclipsePreferences, java.lang.String)
   */
  public IEclipsePreferences create( final IEclipsePreferences parent,
                                     final String name ) {
    IEclipsePreferences node
      = ( IEclipsePreferences ) parent.node( name );
    return node;
  }
  
}
