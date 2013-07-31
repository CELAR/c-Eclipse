/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.internal.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.service.prefs.Preferences;

import eu.celar.core.model.impl.ResourceCloudElement;


/**
 * @author Nicholas Loulloudes
 *
 */
public class LocalFile extends ResourceCloudElement {
  
  LocalFile (final IFile file) {
    super (file);
  }
  
  public boolean isProjectFoldersProperties() {
    return isPropertiesFile( CloudProject.PROJECT_FOLDER_NODE );
  }
  
  public boolean isProjectProperties() {
    return isPropertiesFile( CloudProject.PROJECT_NODE );
  }
  
  /**
   * Convenience method that returns the <code>IFile</code> out
   * of the resource.
   * 
   * @return The corresponding <code>IFile</code>.
   */
  protected IFile getFile() {
    return ( IFile ) getResource();
  }
  
  private boolean isPropertiesFile( final String nodeName ) {
    
    IPath folderPath = getPath();
    IPath folderComparePath = folderPath.removeFileExtension();
    
    IPath propertiesPath = getPropertiesPath( nodeName );
    IPath propertiesComparePath = new Path( getProject().getName() );
    propertiesComparePath = propertiesComparePath.append( ".settings" ); //$NON-NLS-1$
    propertiesComparePath.append( propertiesPath.lastSegment() );

    return folderComparePath.equals( propertiesComparePath );
    
  }
  
  private IPath getPropertiesPath( @SuppressWarnings("unused")
                                   final String node ) {
    IProject project = ( IProject ) getProject().getResource();
    ProjectScope projectScope = new ProjectScope( project );
    Preferences folderNode = projectScope.getNode( CloudProject.PROJECT_FOLDER_NODE );
    return new Path( folderNode.absolutePath() );
  }
  
}
