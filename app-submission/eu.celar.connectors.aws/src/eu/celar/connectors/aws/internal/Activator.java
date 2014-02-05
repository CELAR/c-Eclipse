package eu.celar.connectors.aws.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "eu.celar.connectors.amazon"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
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
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	

	  /**
	   * Log the exception via an {@link IStatus}.
	   * 
	   * @param e the exception to log
	   */
	  public static void log( final Exception e ) {
	    Activator.log( e.getLocalizedMessage(), e );
	  }

	  /**
	   * Log the exception via an {@link IStatus}.
	   * 
	   * @param description a more descriptive text of the exception
	   */
	  public static void log( final String description ) {
	    if( description != null ) {
	      IStatus status = new Status( IStatus.ERROR,
	                                   Activator.PLUGIN_ID,
	                                   description );
	      Activator.getDefault().getLog().log( status );
	    }
	  }

	  /**
	   * Create a log entry with the given description and exception.
	   * 
	   * @param description a more descriptive text of the exception
	   * @param e the exception to log
	   */
	  public static void log( String description, final Exception e ) {
	    if( description == null ) {
	      description = e.getClass().getName();
	    }
	    IStatus status = new Status( IStatus.ERROR,
	                                 Activator.PLUGIN_ID,
	                                 IStatus.OK,
	                                 description,
	                                 e );
	    Activator.getDefault().getLog().log( status );
	  }
}
