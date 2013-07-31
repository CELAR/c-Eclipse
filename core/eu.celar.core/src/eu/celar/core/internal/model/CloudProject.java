/*****************************************************************************
 * Copyright (c) 2006, 2007 g-Eclipse Consortium 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the
 * g-Eclipse project founded by European Union
 * project number: FP6-IST-034327  http://www.geclipse.eu/
 *
 * Contributors:
 *    Mathias Stuempert - initial API and implementation
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package eu.celar.core.internal.model;

import java.util.List;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.osgi.framework.Bundle;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

import eu.celar.core.ExtensionManager;
import eu.celar.core.Extensions;
import eu.celar.core.internal.Activator;
import eu.celar.core.internal.model.notify.CloudModelEvent;
import eu.celar.core.internal.model.notify.CloudNotificationService;
import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudModelEvent;
import eu.celar.core.model.ICloudProject;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.impl.ResourceCloudContainer;
import eu.celar.core.project.CloudProjectNature;
import eu.celar.core.reporting.ProblemException;


/**
 * This is the cloud model class that represents any project in the
 * workspace. This has not to be necessarily a cloud project. Use the
 * {@link #hasCloudNature()} method to determine if this is really a
 * cloud project.
 */
public class CloudProject extends ResourceCloudContainer implements ICloudProject {
  
  /**
   * ID of the preference node for cloud projects.
   */
  public static final String PROJECT_NODE = "eu.celar.core"; //$NON-NLS-1$
  
  /**
   * ID of the preference folder node for cloud projects.
   */
  public static final String PROJECT_FOLDER_NODE = "eu.celar.core.folders"; //$NON-NLS-1$
  
  private static final String CLOUD_PROVIDER_ATTRIBUTE = "cloud-provider"; //$NON-NLS-1$
  
  private static final QualifiedName PROJECT_FOLDER_ID_QN
    = new QualifiedName( Activator.PLUGIN_ID, "cloud.project.folder.id" ); //$NON-NLS-1$
  
  private ProjectCloudProvider cloudProvider;
  
  protected CloudProject (final IProject project) {
    super( project );
    loadProjectProperties (project);
  }
  
  @Override
  protected ICloudElement addElement( final ICloudElement element ) throws ProblemException {
    
    ICloudElement result = super.addElement( element );
    
    if ( ( result != null ) && ( result instanceof ICloudContainer ) && ! result.isVirtual() ) {
      try {
        CloudNotificationService.getInstance().lock( this );
        boolean updated = updateProjectProperties( ( ICloudContainer ) element );
        if ( ! updated ) {
          updateProjectFolderProperties( ( ICloudContainer ) element );
        }
        CloudNotificationService.getInstance().unlock( this );
      } catch ( CoreException cExc ) {
        Activator.logException( cExc );
      } catch ( BackingStoreException bsExc ) {
        Activator.logException( bsExc );
      }
    }
    
    return result;    
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudContainer#canContain(eu.celar.core.model.ICloudElement)
   */
  @Override
  public boolean canContain( final  ICloudElement element ) {
    return true;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudContainer#getChildCount()
   */
  @Override
  public int getChildCount() {
    int result = 0;
    if ( isOpen() ) {
      result = super.getChildCount();
    }
    return result;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudContainer#getChildren(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudElement[] getChildren( IProgressMonitor monitor ) throws ProblemException {
    ICloudElement[] children = new ICloudElement[0];
    if ( isOpen() ) {
      children = super.getChildren( monitor );
      if ( ! hasCloudProvider( children ) ) {
        loadProjectProperties( ( IProject ) getResource() );
        children = super.getChildren( monitor );
      }
    }
    return children;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getProject()
   */
  @Override
  public ICloudProject getProject() {
    return this;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.IShareableElement#share()
   */
  @Override
  public void share() throws ProblemException {
    // TODO Auto-generated method stub
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProject#getProjectFolder(eu.celar.core.model.ICloudElement)
   */
  @Override
  public ICloudContainer getProjectFolder( final ICloudElement element ) {
    return getProjectFolder( element.getClass() );
  }
  
  private LocalFolder getProjectFolder( final String name ) {
    
    LocalFolder result = null;
    
    ICloudElement child = findChild( name );
    
    if ( child == null ) {
      IProject project = ( IProject ) getResource();
      IFolder folder = project.getFolder( name );
      if ( ! folder.exists() ) {
        try {
          folder.create( IResource.FORCE, true, null );
          result = getProjectFolder( name );
        } catch (CoreException e) {
          // Do nothing, just ignore
        }
      }
    } else if ( child instanceof LocalFolder ) {
      result = ( LocalFolder ) child;
    }
    
    return result;
    
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProject#getProjectFolder(java.lang.Class)
   */
  @Override
  public ICloudContainer getProjectFolder( final Class<? extends ICloudElement> elementType )
  {
    ICloudContainer result = this;
    
    ProjectScope projectScope = new ProjectScope( ( IProject ) getResource() );
    Preferences folderNode = projectScope.getNode( PROJECT_FOLDER_NODE );
    
    ExtensionManager extm = new ExtensionManager();
    List< IConfigurationElement > configurationElements
      = extm.getConfigurationElements( Extensions.PROJECT_FOLDER_POINT, Extensions.PROJECT_FOLDER_ELEMENT );
    
    for( IConfigurationElement element : configurationElements ) {
      
      String id = element.getAttribute( Extensions.PROJECT_FOLDER_ID_ATTRIBUTE );
      String label = folderNode.get( id, null );
      
      if ( label != null ) {
        String className = element.getAttribute( Extensions.PROJECT_FOLDER_ELEMENTCLASS_ATTRIBUTE );
        String contributor = element.getContributor().getName();
        Class<?> elementClass = null;
        Bundle bundle = Platform.getBundle( contributor );    
        try {
           elementClass = bundle.loadClass( className );
        } catch( ClassNotFoundException exception ) {
          try {
            elementClass = Class.forName( className );
          } catch ( ClassNotFoundException cnfExc ) {
            Activator.logException( cnfExc );
          }
        }
        
        if( elementClass != null ) {
          if ( elementClass.equals( elementType ) ) {
            result = getProjectFolder( label );
            break;
          } else if ( elementClass.isAssignableFrom( elementType ) ) {
            result = getProjectFolder( label );
          }
        }
        
      }
      
    }
    
    return result;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProject#getProjectFolderID(eu.celar.core.model.ICloudContainer)
   */
  @Override
  public String getProjectFolderID( final ICloudContainer folder ) {
    String result = null;
    if( folder.getParent() == this ) {
      String name = folder.getName();
      ProjectScope projectScope = new ProjectScope( ( IProject )getResource() );
      Preferences folderNode = projectScope.getNode( PROJECT_FOLDER_NODE );
      try {
        String[] keys = folderNode.keys();
        for( String key : keys ) {
          String label = folderNode.get( key, null );
          if( name.equals( label ) ) {
            result = key;
            break;
          }
        }
      } catch( BackingStoreException bsExc ) {
        Activator.logException( bsExc );
      }
    }
    return result;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProject#getCloudProvider()
   */
  @Override
  public ICloudProvider getCloudProvider() {
    return this.cloudProvider;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProject#isOpen()
   */
  @Override
  public boolean isOpen() {
    return ( ( IProject ) getResource() ).isOpen();
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProject#hasCloudNature()
   */
  @Override
  public boolean hasCloudNature() {
    boolean result = false;
    IProject project = ( IProject ) getResource();
    try {
      result = project.hasNature( CloudProjectNature.getID() );
    } catch( CoreException e ) {
      // Don't do anything here, just return false
    }
    return result;
  }
  
  @Override
  protected IStatus fetchChildren( final IProgressMonitor monitor ) {
    IStatus result = Status.CANCEL_STATUS;
    if ( isOpen() ) {
      result = super.fetchChildren( monitor );
    }
    return result;
  }
  
  private boolean hasCloudProvider( final ICloudElement[] children ) {
    boolean result = false;
    for ( ICloudElement child : children ) {
      if ( child instanceof ProjectCloudProvider ) {
        result = true;
        break;
      }
    }
    return result;
  }
  
  private void loadProjectProperties( final IProject project ) {

    IScopeContext projectScope = new ProjectScope( project );
    Preferences projectNode = projectScope.getNode( PROJECT_NODE );
    
    try {
      
      projectNode.sync();
      String voName = projectNode.get( CLOUD_PROVIDER_ATTRIBUTE, null );
      this.cloudProvider = null;
      CloudProviderManager voManager = CloudProviderManager.getManager();
      if ( voName != null ) {
        ICloudProvider globalVo = ( ICloudProvider ) voManager.findChild( voName );
        if ( globalVo != null ) {
          this.cloudProvider = new ProjectCloudProvider( this, globalVo );
          addElement( this.cloudProvider );
        }
      }
      
    } catch ( BackingStoreException bsExc ) {
      Activator.logException( bsExc );
    } catch ( ProblemException pExc ) {
      Activator.logException( pExc );
    }
    
  }
  
  private boolean updateProjectFolderProperties( final ICloudContainer folder )
      throws CoreException, BackingStoreException {
    
    boolean result = false;
    
    String name = folder.getName();
    
    IScopeContext projectScope = new ProjectScope( ( IProject ) getResource() );
    Preferences folderNode = projectScope.getNode( PROJECT_FOLDER_NODE );
    
    for ( String id : folderNode.keys() ) {
      String label = folderNode.get( id, null );
      if ( name.equals( label ) ) {
        IResource resource = folder.getResource();
        resource.setSessionProperty( PROJECT_FOLDER_ID_QN, id );
        result = true;
      }
    }
    
    if ( result ) {
      CloudModelEvent event = new CloudModelEvent( ICloudModelEvent.PROJECT_FOLDER_CHANGED,
                                                 this,
                                                 new ICloudElement[] { folder } );
      CloudNotificationService.getInstance().queueEvent( event );
    }
    
    return result;    
  }
  
  private boolean updateProjectProperties( final ICloudContainer folder )
      throws CoreException {
    
    boolean result = false;
    
    IResource resource = folder.getResource();
    String id = ( String ) resource.getSessionProperty( PROJECT_FOLDER_ID_QN );
    String name = folder.getName();
    
    if ( id != null ) {
      
      IScopeContext projectScope = new ProjectScope( ( IProject ) getResource() );
      final Preferences folderNode = projectScope.getNode( PROJECT_FOLDER_NODE );
      
      String label = folderNode.get( id, null );
      if ( ! name.equals( label ) ) {
        folderNode.put( id, name );
        Job syncJob = new Job( "syncProjectPreferences@" + getName() ) { //$NON-NLS-1$
          @Override
          protected IStatus run( final IProgressMonitor monitor ) {
            IStatus status = Status.OK_STATUS;
            try {
              folderNode.flush();
            } catch ( BackingStoreException bsExc ) {
              Activator.logException( bsExc );
              status = Status.CANCEL_STATUS;
            }
            return status;
          }
        };
        syncJob.setSystem( true );
        syncJob.schedule();
        result = true;
      }
      
    }
    
    if ( result ) {
      CloudModelEvent event = new CloudModelEvent( ICloudModelEvent.PROJECT_FOLDER_CHANGED,
                                                 this,
                                                 new ICloudElement[] { folder } );
      CloudNotificationService.getInstance().queueEvent( event );
    }
    
    return result;
    
  }
}
