package eu.celar.core.model.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudElementCreator;
import eu.celar.core.model.ICreatorSourceMatcher;
import eu.celar.core.reporting.ProblemException;

/**
 * Cloud element creator for the {@link GenericCloudProvider}.
 */
public class GenericCloudProviderCreator
    extends AbstractCloudElementCreator
    implements ICreatorSourceMatcher {
  
  /**
   * The creators extension ID.
   */
  private static final String EXTENSION_ID = "eu.celar.core.genericCPCreator"; //$NON-NLS-1$
  
  private String cpName;
  private String cpURI;
  private String cpPort;
  
  private List< ICloudElementCreator > serviceCreators
    = new ArrayList< ICloudElementCreator >();


  
//  private List<ICloudService> serviceMaintainers = new ArrayList<ICloudService>();
  
  public void createService( final ICloudElementCreator creator,
                             final URI fromURI )
      throws ProblemException {
    creator.setSource( fromURI );
    this.serviceCreators.add( creator );
  }
  
//  public void maintainService( final ICloudService service ) {
//    this.serviceMaintainers.add( service );
//  }
//  
  /**
   * Apply this creators settings to the specified VO.
   * 
   * @param cp The {@link GenericCloudProvider} to which to
   * apply this creators settings.
   * @throws ProblemException 
   */
  public void apply( final GenericCloudProvider cp ) throws ProblemException {
    
    ICloudElement[] children = cp.getChildren( null );
    
    for ( ICloudElement child : children ) {
//      if ( ( child instanceof ICloudService ) && ! this.serviceMaintainers.contains( child ) ) {
//        cp.delete( child );
//      }
    }
    
    for ( ICloudElementCreator serviceCreator : this.serviceCreators ) {
      cp.create( serviceCreator );
    }

  }

  public boolean canCreate( final Object source ) {
    
    boolean result = false;
    
    if ( source instanceof IFileStore ) {
      IFileStore propertiesStore = ( ( IFileStore ) source ).getChild( GenericCloudProviderProperties.NAME );
      IFileInfo propertiesInfo = propertiesStore.fetchInfo();
      result = propertiesInfo.exists();
    }
    
    return result;
    
  }
  
  public ICloudElement create( final ICloudContainer parent ) throws ProblemException {
    GenericCloudProvider cp = null;
    Object source = getSource();
    if ( source == null ) {
      cp = new GenericCloudProvider( this );
    } else if ( source instanceof IFileStore ) {
      IFileStore fileStore = ( IFileStore ) source;
      cp = new GenericCloudProvider( fileStore );
    }
    return cp;
  }
  
  /**
   * @return
   */
  public String getExtensionID() {
    return EXTENSION_ID;
  }

  /**
   * Get the VO's name.
   * 
   * @return The unique name of the VO.
   */
  public String getVoName() {
    return this.cpName;
  }
  
  /**
   * @return The Cloud Provider URI
   */
  public String getVoURI() {
    return this.cpURI;
  }
  
  /**
   * @return The Cloud Provider listening Port
   */
  public String getVoPort() {
    return this.cpPort;
  }
  
  /**
   * Set the VO's name.
   * 
   * @param name The unique name of the VO.
   */
  public void setVoName( final String name ) {
    this.cpName = name;
  }
  
  /**
   * @param uri
   */
  public void setVoURI( final String uri ) {
    this.cpURI = uri;
  }
  
  /**
   * @param port
   */
  public void setVoPort( final String port ) {
    this.cpPort = port;
  }

}
