/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

import eu.celar.core.model.ICloudProvider;
import eu.celar.core.project.CloudProjectNature;
import eu.celar.ui.internal.Activator;

/**
 * @author Nicholas Loulloudes
 */
public class CloudProjectCreationOperation implements IRunnableWithProgress {

  private CloudProjectProperties properties;
  private IProject cloudProject;

  public CloudProjectCreationOperation( final CloudProjectProperties properties )
  {
    this.properties = properties;
    this.cloudProject = null;
  }

  public void run( final IProgressMonitor monitor )
    throws InvocationTargetException, InterruptedException
  {
    monitor.beginTask( Messages.getString( "CloudProjectCreationOperation.create_task" ), 300 ); //$NON-NLS-1$
    try {
      IProject proj = createProject( this.properties, monitor );
      addProjectNature( proj, monitor );
      this.cloudProject = proj;
    } catch( CoreException cExc ) {
      eu.celar.ui.internal.Activator.logException( cExc );
    } finally {
      monitor.done();
    }
  }

  public IProject getProject() {
    return this.cloudProject;
  }

  private IProject createProject( final CloudProjectProperties props,
                                  final IProgressMonitor monitor )
    throws CoreException
  {
    monitor.subTask( Messages.getString( "CloudProjectCreationOperation.init_task" ) ); //$NON-NLS-1$
    String projectName = props.getProjectName();
    IPath projectPath = props.getProjectLocation();
    IProject[] referencesProjects = props.getReferencesProjects();
    IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
    IProject project = workspaceRoot.getProject( projectName );
    IStatus status = ResourcesPlugin.getWorkspace()
      .validateProjectLocation( project, projectPath );
    if( status.getSeverity() != IStatus.OK ) {
      throw new CoreException( status );
    }
    IProjectDescription desc = project.getWorkspace()
      .newProjectDescription( projectName );
    desc.setLocation( projectPath );
    if( referencesProjects != null ) {
      desc.setReferencedProjects( referencesProjects );
    }
    project.create( desc, new SubProgressMonitor( monitor, 50 ) );
    project.open( new SubProgressMonitor( monitor, 50 ) );
    createProjectStructure( project, props );
    setProjectProperties( project, props );
    if( monitor.isCanceled() ) {
      throw new OperationCanceledException();
    }
    return project;
  }

  private void addProjectNature( final IProject proj,
                                 final IProgressMonitor monitor )
    throws CoreException
  {
    monitor.subTask( Messages.getString( "CloudProjectCreationOperation.nature_task" ) ); //$NON-NLS-1$
    IProjectDescription desc = proj.getDescription();
    String[] natureIDs = desc.getNatureIds();
    String CloudNatureID = CloudProjectNature.getID();
    boolean found = false;
    for( int i = 0; ( i < natureIDs.length ) && ( !found ); i++ ) {
      if( natureIDs[ i ].equals( CloudNatureID ) ) {
        found = true;
      }
    }
    if( !found ) {
      String[] newNatureIDs = new String[ natureIDs.length + 1 ];
      System.arraycopy( natureIDs, 0, newNatureIDs, 1, natureIDs.length );
      newNatureIDs[ 0 ] = CloudNatureID;
      desc.setNatureIds( newNatureIDs );
      proj.setDescription( desc, new SubProgressMonitor( monitor, 100 ) );
    }
    if( monitor.isCanceled() ) {
      throw new OperationCanceledException();
    }
  }

  private void createProjectFolder( final IProject project, final String name )
  {
    if( ( name != null ) && ( name.length() != 0 ) ) {
      IFolder folder = project.getFolder( new Path( name ) );
      if( !folder.exists() ) {
        try {
          folder.create( IResource.FORCE, true, null );
        } catch( CoreException cExc ) {
          Activator.logException( cExc );
        }
      }
    }
  }

  private void createProjectStructure( final IProject project,
                                       final CloudProjectProperties props )
  {
    Hashtable<String, String> projectFolders = props.getProjectFolders();
    for( String label : projectFolders.values() ) {
      createProjectFolder( project, label );
    }
  }

  private void setProjectProperties( final IProject project,
                                     final CloudProjectProperties props )
    throws CoreException
  {
    ICloudProvider cloudProvider = props.getCloudProvider();
    String cloudProviderName = cloudProvider.getName();
    Hashtable<String, String> folders = props.getProjectFolders();
    IScopeContext projectScope = new ProjectScope( project );
    try {
      Preferences projectNode = projectScope.getNode( "eu.celar.core" ); //$NON-NLS-1$
      projectNode.put( "cloud-provider", cloudProviderName ); //$NON-NLS-1$
      projectNode.flush();
      Preferences folderNode = projectScope.getNode( "eu.celar.core.folders" ); //$NON-NLS-1$
      for( String id : folders.keySet() ) {
        String label = folders.get( id );
        folderNode.put( id, label );
      }
      folderNode.flush();
    } catch( BackingStoreException bsExc ) {
      IStatus status = new Status( IStatus.ERROR,
                                   Activator.PLUGIN_ID,
                                   IStatus.CANCEL,
                                   Messages.getString( "CloudProjectCreationOperation.set_preferences_failed" ), //$NON-NLS-1$
                                   bsExc );
      throw new CoreException( status );
    }
  }
}
