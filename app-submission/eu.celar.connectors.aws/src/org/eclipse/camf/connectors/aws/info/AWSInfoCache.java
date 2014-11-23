/**
 * 
 */
package org.eclipse.camf.connectors.aws.info;

import java.util.ArrayList;

import org.eclipse.camf.connectors.aws.internal.Activator;
import org.eclipse.camf.core.model.ICloudInfoService;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.infosystem.model.base.AbstractInfoCache;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;


/**
 * @author nickl
 *
 */
public class AWSInfoCache extends AbstractInfoCache {

  public AWSInfoCache( final ArrayList<ICloudProvider> providers ) {
    super( providers );
  }

  @Override
  public void setProviderList( ArrayList<ICloudProvider> providers ) {
    for (ICloudProvider cp : providers){
      try {
        ArrayList<String> awsCPList = null;
        ICloudInfoService infoService = cp.getInfoService();
        if( ( infoService != null ) && ( infoService instanceof AWSInfoService ) )
        {
          if (awsCPList == null) {
            awsCPList = new ArrayList<String>();
          }
          awsCPList.add( cp.getName() );
        }
      } catch( ProblemException e ) {
        IStatus status = new Status( IStatus.ERROR,
                                     Activator.PLUGIN_ID,
                                     IStatus.OK,
                                     null,
                                     e );
        Activator.getDefault().getLog().log( status );
      }
    }
  }
}
