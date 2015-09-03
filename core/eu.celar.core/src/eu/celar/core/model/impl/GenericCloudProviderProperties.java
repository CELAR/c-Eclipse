package eu.celar.core.model.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

import eu.celar.core.ICoreProblems;
import eu.celar.core.internal.Activator;
import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudElementCreator;
import eu.celar.core.model.ISerializableElement;
import eu.celar.core.reporting.ProblemException;


/**
 * Properties for the {@link GenericCloudProvider}.
 */
public class GenericCloudProviderProperties
    extends AbstractCloudElement
    implements ISerializableElement {
  
  /**
   * Name to reference the properties.
   */
  public static final String NAME = ".generic_cp_properties"; //$NON-NLS-1$

  private static final String FIELD_SEPARATOR = " "; //$NON-NLS-1$
  
  private GenericCloudProvider cp;
  
  GenericCloudProviderProperties( final GenericCloudProvider cp ) {
    this.cp = cp;
  }

  public IFileStore getFileStore() {
    return getParent().getFileStore().getChild( getName() );
  }

  public String getName() {
    return NAME;
  }

  public ICloudContainer getParent() {
    return this.cp;
  }

  public IPath getPath() {
    return getParent().getPath().append( getName() );
  }

  public IResource getResource() {
    return null;
  }

  public boolean isLocal() {
    return true;
  }
  
  public void deserialize() throws ProblemException {
    
    IFileStore fileStore = getFileStore();
    
    try {
      InputStream iStream = fileStore.openInputStream( EFS.NONE, null );
      InputStreamReader isReader = new InputStreamReader( iStream );
      BufferedReader bReader = new BufferedReader( isReader );
      
      String line;
      for ( ; ; ) {
        line = bReader.readLine();
        
        if ( line == null ) {
          break;
        }
        
        String[] parts = line.split( FIELD_SEPARATOR );

        if ( parts.length == 2 ) {
          String serviceType = parts[ 0 ];
          URI serviceURI = new URI( parts[ 1 ] );
          ICloudElementCreator creator = CloudModel.getCreatorRegistry().getCreator( serviceURI, serviceType );
          if ( creator != null ) {
            this.cp.create( creator );
          }
        } else if ( parts.length == 3 ){
          this.cp.setName( parts[0] );
          this.cp.setUri( parts[1] );
          this.cp.setPort( parts[2] );
        }
      }
    } catch ( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    } catch ( IOException ioExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  ioExc,
                                  Activator.PLUGIN_ID );
    } catch ( URISyntaxException uriExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  uriExc,
                                  Activator.PLUGIN_ID );
    }
    
  }
  
  public void serialize() throws ProblemException {
    
    IFileStore fileStore = getFileStore();
    ICloudElement[] children = this.cp.getChildren( null );
    
    try {
      
      OutputStream oStream = fileStore.openOutputStream( EFS.NONE, null );
      OutputStreamWriter osWriter = new OutputStreamWriter( oStream );
      BufferedWriter bWriter = new BufferedWriter( osWriter );
      bWriter.write( this.cp.getName() + FIELD_SEPARATOR );
      bWriter.write( this.cp.getUri() + FIELD_SEPARATOR );
      bWriter.write( this.cp.getPort() );
      
      for ( ICloudElement child : children ) {
//        if ( child instanceof IGridService ) {
//          URI uri = ( ( IGridService ) child ).getURI();
//          bWriter.newLine();
//          bWriter.write( child.getClass().getName() + FIELD_SEPARATOR );
//          bWriter.write( uri.toString() );
//        }
      }
      
      bWriter.close();
      
    } catch ( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    } catch ( IOException ioExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED,
                                  ioExc,
                                  Activator.PLUGIN_ID );
    }
    
  }

}
