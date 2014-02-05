package eu.celar.ui.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "eu.celar.ui"; //$NON-NLS-1$
  /**
   * The id of the authentication token management view.
   */
  public static final String ID_AUTH_VIEW
    = "eu.celar.ui.views.authenticationTokenView"; //$NON-NLS-1$
  
  /**
   * Image for action Refresh
   */
  public static final String IMG_REFRESH = "refresh"; //$NON-NLS-1$
  
  // The shared instance
  private static Activator plugin;

  /**
   * The constructor
   */
  public Activator() {
  }

  /*
   * (non-Javadoc)
   * @see
   * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
   * )
   */
  public void start( final BundleContext context ) throws Exception {
    super.start( context );
    plugin = this;
  }

  /*
   * (non-Javadoc)
   * @see
   * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
   * )
   */
  public void stop( final BundleContext context ) throws Exception {
    plugin = null;
    super.stop( context );
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

  /**
   * Returns an image descriptor for the image file at the given plug-in
   * relative path
   * 
   * @param path the path
   * @return the image descriptor
   */
  public static ImageDescriptor getImageDescriptor( final String path ) {
    return imageDescriptorFromPlugin( PLUGIN_ID, path );
  }

  public static void logException( final Throwable exc ) {
    String message = exc.getLocalizedMessage();
    if( message == null ) {
      message = exc.getClass().getName();
    }
    IStatus status = new Status( IStatus.ERROR,
                                 PLUGIN_ID,
                                 IStatus.OK,
                                 message,
                                 exc );
    getDefault().getLog().log( status );
  }
  
  /**
   * Logs a status object to the eclipse logger.
   * 
   * @param status The status to be logged.
   */
  public static void logStatus( final IStatus status ) {
    getDefault().getLog().log( status );
  }

  @Override
  protected void initializeImageRegistry( final ImageRegistry reg ) {
    String[][] images = {
      {
        "applicationdescription", "icons/obj16/tosca_file_obj.gif"}, //$NON-NLS-1$ //$NON-NLS-2$
      {
        "cloudprovider", "icons/obj16/cloud_provider_obj.gif"}, //$NON-NLS-1$ //$NON-NLS-2$
      {
        "virtualfile", "icons/obj16/virtual_file_obj.gif"}, //$NON-NLS-1$ //$NON-NLS-2$
      {
        "virtualfolder", "icons/obj16/virtual_folder_obj.gif"}, //$NON-NLS-1$ //$NON-NLS-2$
      {
        "reason", "icons/obj16/ihigh_obj.gif"}, //$NON-NLS-1$ //$NON-NLS-2$
      {
        "refresh", "icons/elcl16/refresh_nav.gif"}, //$NON-NLS-1$ //$NON-NLS-2$
        
      { "activestate", "icons/elcl16/activate.gif" }, //$NON-NLS-1$ //$NON-NLS-2$
      
      { "inactivestate", "icons/elcl16/deactivate.gif" }, //$NON-NLS-1$ //$NON-NLS-2$
      
      { IMG_REFRESH, "icons/eview16/refresh.gif" },  //$NON-NLS-1$


      
    };
    ImageDescriptor imgDsc = null;
    for( String[] image : images ) {
      imgDsc = imageDescriptorFromPlugin( PLUGIN_ID, image[ 1 ] );
      reg.put( image[ 0 ], imgDsc );
    }
  }
}
