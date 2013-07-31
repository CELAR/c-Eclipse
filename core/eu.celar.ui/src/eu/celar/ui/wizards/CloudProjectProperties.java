/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.ui.wizards;

import java.util.Hashtable;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

/**
 * @author Nicholas Loulloudes
 */
public class CloudProjectProperties {

  private String projectName;
  private IPath projectLocation;
  // private ICloudProvider cloudProvider;
  private IProject[] referencesProjects;
  private Hashtable<String, String> projectFolders = new Hashtable<String, String>();

  /**
   * return project name
   * 
   * @return
   */
  public String getProjectName() {
    return this.projectName;
  }

  /**
   * set the ProjectName()
   * 
   * @param projectName
   */
  public void setProjectName( final String projectName ) {
    this.projectName = projectName;
  }

  /**
   * set ProjectLocation
   * 
   * @return
   */
  public IPath getProjectLocation() {
    return this.projectLocation;
  }

  /**
   * get ProjectLocation
   * 
   * @param projectLocation
   */
  public void setProjectLocation( final IPath projectLocation ) {
    this.projectLocation = projectLocation;
  }

  /**
   * get Cloud Provider related to the Project
   * 
   * @return
   */
  // public ICloudProvider getCloudProvider() {
  // return this.cloudProvider;
  // }
  /**
   * set the Cloud Provider of the Project
   * 
   * @param cloudProvider
   */
  // public void setCloudProvider( final ICloudProvider cloudProvider ) {
  // this.cloudProvider = cloudProvider;
  // }
  /**
   * Get the list of reference projects
   * 
   * @return The referenced projects or <code>null</code>.
   */
  public IProject[] getReferencesProjects() {
    IProject[] result = null;
    if( ( this.referencesProjects != null )
        && ( this.referencesProjects.length > 0 ) )
    {
      result = new IProject[ this.referencesProjects.length ];
      System.arraycopy( this.referencesProjects, 0, result, 0, result.length );
    }
    return result;
  }

  /**
   * Set the list of references projects.
   * 
   * @param referencesProjects The referenced projects.
   */
  public void setReferencesProjects( final IProject[] referencesProjects ) {
    this.referencesProjects = referencesProjects;
  }

  /**
   * add a folder to the projects structure
   * 
   * @param id
   * @param label
   */
  public void addProjectFolder( final String id, final String label ) {
    this.projectFolders.put( id, label );
  }

  /**
   * adds a list of project folders
   * 
   * @param folders
   */
  public void addProjectFolders( final Hashtable<String, String> folders ) {
    for( String key : folders.keySet() ) {
      this.projectFolders.put( key, folders.get( key ) );
    }
  }

  /**
   * Get the list of project folders.
   * 
   * @return The list of project folders.
   */
  public Hashtable<String, String> getProjectFolders() {
    return new Hashtable<String, String>( this.projectFolders );
  }
}
