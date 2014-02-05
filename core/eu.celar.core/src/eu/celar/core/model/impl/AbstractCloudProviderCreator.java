package eu.celar.core.model.impl;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.IConfigurableElementCreator;
import eu.celar.core.model.IConfiguration;
import eu.celar.core.reporting.ProblemException;

/**
 * Abstract implementation for VO creators adding the possibility to create VOs
 * from an {@link IConfiguration}.
 */
public abstract class AbstractCloudProviderCreator
    extends AbstractCloudElementCreator
    implements IConfigurableElementCreator {

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IConfigurableElementCreator#create(eu.geclipse.core.model.ICloudContainer, eu.geclipse.core.config.IConfiguration)
   */
  public ICloudElement create( final ICloudContainer parent,
                              final IConfiguration configuration )
      throws ProblemException {
    setConfiguration( configuration );
    return create( parent );
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IConfigurableElementCreator#getConfiguration()
   */
  public IConfiguration getConfiguration() {
    Object source = getSource();
    return source instanceof IConfiguration
      ? ( IConfiguration ) source
      : null;
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IConfigurableElementCreator#setConfiguration(eu.geclipse.core.config.IConfiguration)
   */
  public void setConfiguration( final IConfiguration configuration ) {
    setSource( configuration );
  }

}
