package org.eclipse.camf.connectors.aws;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICreatorSourceMatcher;
import org.eclipse.camf.core.model.impl.AbstractCloudElementCreator;
import org.eclipse.camf.core.reporting.ProblemException;

/**
 * @author Nicholas Loulloudes
 *
 */
public class AWSDeploymentServiceCreator extends AbstractCloudElementCreator implements ICreatorSourceMatcher {

  public ICloudElement create( final ICloudContainer parent )
    throws ProblemException
  {
    AWSApplicationDeploymentService result = null;
    Object object = getSource();
    result = new AWSApplicationDeploymentService( parent );
    return result;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICreatorSourceMatcher#canCreate(java.lang.Object)
   */
  @Override
  public boolean canCreate( Object source ) {
    return false;
  }

}