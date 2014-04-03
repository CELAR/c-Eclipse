package eu.celar.connectors.openstack;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICreatorSourceMatcher;
import eu.celar.core.model.impl.AbstractCloudElementCreator;
import eu.celar.core.reporting.ProblemException;

/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenStackDeploymentServiceCreator extends AbstractCloudElementCreator implements ICreatorSourceMatcher {

  public ICloudElement create( final ICloudContainer parent )
    throws ProblemException
  {
    OpenStackApplicationDeploymentService result = null;
    Object object = getSource();
    result = new OpenStackApplicationDeploymentService( parent );
    return result;
  }

  /* (non-Javadoc)
   * @see eu.celar.core.model.ICreatorSourceMatcher#canCreate(java.lang.Object)
   */
  @Override
  public boolean canCreate( Object source ) {
    return false;
  }

}