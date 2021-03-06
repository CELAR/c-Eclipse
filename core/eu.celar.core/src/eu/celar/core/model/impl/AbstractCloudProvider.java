package eu.celar.core.model.impl;

/*****************************************************************************
 * Copyright (c) 2006-2009 g-Eclipse Consortium 
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
 *    Ariel Garcia      - updated to new problem reporting
 *****************************************************************************/



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

import eu.celar.core.ICoreProblems;
import eu.celar.core.internal.Activator;
import eu.celar.core.internal.model.CloudProviderManager;
import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudDeploymentService;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudInfoService;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.ICloudResource;
import eu.celar.core.model.ICloudResourceCategory;
import eu.celar.core.model.ICloudService;
import eu.celar.core.model.ISerializableElement;
import eu.celar.core.reporting.ProblemException;



/**
 * Abstract implementation of the
 * {@link eu.celar.core.model.ICloudProvider} interface.
 */
public abstract class AbstractCloudProvider
    extends AbstractCloudContainer
    implements ICloudProvider {
  
  /**
   * Create a new VO.
   */
  protected AbstractCloudProvider() {
    super();
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.impl.AbstractCloudContainer#canContain(eu.geclipse.core.model.ICloudElement)
   */
  @Override
  public boolean canContain( final ICloudElement element ) {
    return ( element instanceof ICloudService );
  }
  
  @Override
  public void dispose() {
    IFileStore fileStore = getFileStore();
    try {
      fileStore.delete( EFS.NONE, null );
    } catch ( CoreException cExc ) {
      Activator.logException( cExc );
    }
  }
  
  
  /* (non-Javadoc)
   * @see eu.celar.core.model.impl.AbstractCloudElement#getFileStore()
   */
  public IFileStore getFileStore() {
    IFileStore fileStore = CloudProviderManager.getVoManagerStore().getChild( getName() );
    IFileInfo fileInfo = fileStore.fetchInfo();
    if ( !fileInfo.exists() ) {
      try {
        fileStore.mkdir( EFS.NONE, null );
      } catch ( CoreException cExc ) {
        Activator.logException( cExc );
      }
    }
    return fileStore;
  }
  
  public ICloudResourceCategory[] getSupportedCategories() {
//    return ProjectCloudProvider.standardCategories;
    return null;
  }
  
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.impl.AbstractCloudElement#getParent()
   */
  public ICloudContainer getParent() {
    return CloudProviderManager.getManager();
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.impl.AbstractCloudElement#getPath()
   */
  public IPath getPath() {
    IPath path = new Path( CloudProviderManager.NAME );
    return path.append( getName() );
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.ICloudElement#getResource()
   */
  public IResource getResource() {
    return null;
  }

  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.ICloudElement#isLocal()
   */
  public boolean isLocal() {
    return true;
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.ISerializableElement#deserialize()
   */
  public void deserialize() throws ProblemException {
    deleteAll();
    IFileStore fileStore = getFileStore();
    try {
      IFileStore[] childStores = fileStore.childStores( EFS.NONE, null );
      for ( IFileStore child : childStores ) {
        ICloudElement element = loadChild( child.getName() );
        if ( element != null ) {
          addElement( element );
        }
      }
    } catch ( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    }
  }
  
  public void refreshResources( final ICloudResourceCategory category,
                                final IProgressMonitor monitor )
      throws ProblemException {
    // TODO mathias may this stay to be a noop?
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IStorableElement#save()
   */
  public void serialize() throws ProblemException {
    
    ICloudElement[] children = getChildren( null );
    for ( ICloudElement child : children ) {
      if ( child instanceof ISerializableElement ) {
        ( ( ISerializableElement ) child ).serialize();
      } else {
        saveChild( child );
      }
    }
    
    // Below is experimental code for saving VOs in XML format
    /*
    try {
      
      IFileStore fileStore = getFileStore();
      IFileStore voIdFile = fileStore.getChild( ".id" );
      OutputStream voIdOStream = voIdFile.openOutputStream( EFS.NONE, null );
      voIdOStream.write( getClass().getName().getBytes() );
      voIdOStream.close();
      
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setValidating( true );
      factory.setNamespaceAware( true );
      
      DocumentBuilder builder = factory.newDocumentBuilder();
      
      Document document = builder.newDocument();
      
      Element voNode = document.createElement( "vo" );
      voNode.setAttribute( "name", getName() );
      voNode.setAttribute( "id", getId() );
      document.appendChild( voNode );
      
      Hashtable< String, String > props = getStaticProperties();
      if ( ( props != null ) && ! props.isEmpty() ) {
        Element propsNode = document.createElement( "properties" );
        voNode.appendChild( propsNode );
        for ( String key : props.keySet() ) {
          String value = props.get( key );
          Element keyNode = document.createElement( "property" );
          keyNode.setAttribute( "key", key );
          keyNode.setAttribute( "value", value );
          propsNode.appendChild( keyNode );
        }
      }
      
      List< ICloudService > services = getStaticServices();
      if ( ( services != null ) && ! services.isEmpty() ) {
        Element servicesNode = document.createElement( "services" );
        voNode.appendChild( servicesNode );
        for ( ICloudService service : services ) {
          Element serviceNode = document.createElement( "service" );
          serviceNode.setAttribute( "type", service.getClass().getName() );
          serviceNode.setAttribute( "endpoint", service.getURI().toString() );
          servicesNode.appendChild( serviceNode );
        }
      }
      
      Element specElement = document.createElement( "specific" );
      if ( createSpecificPart( specElement ) ) {
        voNode.appendChild( specElement );
      }

      File file = fileStore.getChild( "vo.xml" ).toLocalFile( EFS.NONE, null );
      FileOutputStream foStream = new FileOutputStream( file );
      
      DOMSource domSource = new DOMSource( document );
      StreamResult streamResult = new StreamResult( foStream );
      
      TransformerFactory tFactory = TransformerFactory.newInstance();
      Transformer transformer = tFactory.newTransformer();
      transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
      transformer.transform( domSource, streamResult );
      
    } catch ( ParserConfigurationException pcExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED, pcExc, Activator.PLUGIN_ID );
    } catch ( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED, cExc, Activator.PLUGIN_ID );
    } catch ( IOException ioExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED, ioExc, Activator.PLUGIN_ID );
    } catch ( TransformerConfigurationException tcExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED, tcExc, Activator.PLUGIN_ID );
    } catch ( TransformerException tExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED, tExc, Activator.PLUGIN_ID );
      
    }
    */
  }
  
  /*
  protected boolean createSpecificPart( final Element specElement ) {
    return false;
  }
  
  protected Hashtable< String, String > getStaticProperties() {
    return null;
  }
  
  protected List< ICloudService > getStaticServices() {
    return null;
  }
  */
  
  /**
   * Load a child with the given name.
   * 
   * @param childName The child's name.
   * @return The element that was loaded or null if no such element
   * could be loaded.
   */
  protected abstract ICloudElement loadChild( final String childName );
  
  protected void saveChild( @SuppressWarnings("unused")
                            final ICloudElement child ) {
    // empty implementation
  }
  
  
  public ICloudDeploymentService[] getDeploymentServices( final IProgressMonitor monitor ) throws ProblemException {
    ICloudResource[] resources = null;
    
    ICloudInfoService infoService = getInfoService();
    if ( infoService != null ) {
      resources = infoService.fetchResources( this,
                                              this,
                                              CloudResourceCategoryFactory
                                              .getCategory( CloudResourceCategoryFactory.ID_DEPLOYMENT_SERVICES ),
                                              false,
                                              ICloudDeploymentService.class,
                                              monitor );
    }
    //add local services
    Set<ICloudResource> resourcesSet = new HashSet<ICloudResource>();
    if (resources != null) resourcesSet.addAll( Arrays.asList( resources ) );
    ICloudElement[] children = getChildren( null );
    for ( ICloudElement child : children ) {
      if ( child instanceof ICloudDeploymentService ) {
        resourcesSet.add( ( ICloudResource )child );
      }
    }
    return resourcesSet.toArray( new ICloudDeploymentService[resourcesSet.size()] );    
  }
  
  public ICloudInfoService getInfoService()
      throws ProblemException {
    ICloudInfoService infoService = null;
    ICloudElement[] children = getChildren( null );
    for ( ICloudElement child : children ) {
      if ( child instanceof ICloudInfoService ) {
        infoService = ( ICloudInfoService ) child;
        break;
      }
    }
    return infoService;
  }
  
}
