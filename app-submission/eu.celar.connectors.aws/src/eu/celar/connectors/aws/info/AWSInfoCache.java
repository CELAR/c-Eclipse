/**
 * 
 */
package eu.celar.connectors.aws.info;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import eu.celar.connectors.aws.internal.Activator;
import eu.celar.core.model.ICloudInfoService;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.reporting.ProblemException;
import eu.celar.infosystem.model.base.AbstractInfoCache;


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
