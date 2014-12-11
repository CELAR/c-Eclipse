package eu.celar.core.model.impl;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.IProgressMonitor;

import eu.celar.core.internal.Activator;
import eu.celar.core.model.ICloudDeploymentService;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ISerializableElement;
import eu.celar.core.reporting.ProblemException;


/**
 * This is the g-Eclipse default implementation for the
 * {@link IVirtualOrganization} interface. It is used whenever
 * no middleware dependent VO is available. This be
 * the case if the user has not installed a middleware feature that
 * comes with an own VO implementation. 
 */
public class GenericCloudProvider
    extends AbstractCloudProvider {
  
  /**
   * The type name of this VO implementation
   */
  private static final String VO_TYPE_NAME = "Generic Cloud Provider"; //$NON-NLS-1$
  
  private String name;
  private String uri;
  private String port;
  
  GenericCloudProvider( final GenericCloudProviderCreator creator ) {
    try {
      apply( creator );
    } catch ( ProblemException pExc ) {
      Activator.logException( pExc );
    }
  }
  
  GenericCloudProvider( final IFileStore fileStore ) {
    this.name = fileStore.getName();
    try {
      deserialize();
    } catch ( ProblemException pExc ) {
      Activator.logException( pExc );
    }
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.impl.AbstractVirtualOrganization#canContain(eu.geclipse.core.model.IGridElement)
   */
  @Override
  public boolean canContain( final ICloudElement element ) {
    return
      super.canContain( element )
        || ( element instanceof GenericCloudProviderProperties );
  }
  
  @Override
  public boolean equals( final Object o ) {
    boolean result = false;
    if ( o instanceof GenericCloudProvider ) {
      GenericCloudProvider vo = ( GenericCloudProvider ) o;
      result = getName().equals( vo.getName() );
    }
    return result;
  }
  
  /*
   * If equals() is overridden hashCode() must be also, equal objects
   * must have equal hashes.
   */
  @Override
  public int hashCode() {
    return this.name.hashCode();
  }
  
  /*@Override
  public IGridService[] getServices( final IProgressMonitor monitor )
      throws ProblemException {
    
    List< IGridService > results = new ArrayList< IGridService >();
    
    IGridService[] services = super.getServices( monitor );
    if ( services != null ) {
      for ( IGridService service : services ) {
        results.add( service );
      }
    }
    
    IGridElement[] children = getChildren( null );
    if ( children != null ) {
      for ( IGridElement child : children ) {
        if ( child instanceof IGridService ) {
          results.add( ( IGridService ) child );
        }
      }
    }
    
    return results.toArray( new IGridService[ results.size() ] );
    
  }*/
  
  public String getTypeName() {
    return VO_TYPE_NAME;
  }

  public boolean isLazy() {
    return false;
  }

  public String getName() {
    return this.name;
  }
  
  public String getUri() {
    return this.uri;
  }
  
  public String getPort() {
    return this.port;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setUri(String uri) {
    this.uri = uri;
  }
  
  public void setPort(String port) {
    this.port = port;
  }
  
  @Override
  public void serialize() throws ProblemException {
    ICloudElement[] children = getChildren( null );
    for ( ICloudElement child : children ) {
      if ( child instanceof ISerializableElement ) {
        ( ( ISerializableElement ) child ).serialize();
      } else {
        saveChild( child );
      }
    }
  }
  
  /**
   * Apply the settings of the specified {@link GenericCloudProviderCreator} to
   * this VO.
   * 
   * @param creator The creator to be applied to this VO.
   * @throws ProblemException 
   */
  protected void apply( final GenericCloudProviderCreator creator ) throws ProblemException {
    
    this.name = creator.getVoName();
    this.uri = creator.getVoURI();
    this.port = creator.getVoPort();
    
    GenericCloudProviderProperties properties = new GenericCloudProviderProperties( this );
    addElement( properties );
    
    creator.apply( this );
    
  }
  
  @Override
  protected ICloudElement loadChild( final String childName ) {
    
    ICloudElement child = null;
    
    try {
    
      if ( childName.equals( GenericCloudProviderProperties.NAME ) ) {
        GenericCloudProviderProperties properties = new GenericCloudProviderProperties( this );
        properties.deserialize();
        child = properties;
      }
    
    } catch ( ProblemException pExc ) {
      Activator.logException( pExc );
    }
    
    return child;
    
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IVirtualOrganization#getWizardId()
   */
  public String getWizardId() {
    return "eu.celar.ui.wizards.GenericCloudProviderWizard"; //$NON-NLS-1$
  }

  public String getId() {
    return this.getClass().getName();
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICloudProvider#getDescription()
   */
  @Override
  public String getDescription() {
    // TODO Auto-generated method stub
    return null;
  }
}
