/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.reporting;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import eu.celar.core.reporting.internal.ReportingService;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ReportingPlugin extends Plugin {

  // The shared instance
  private static ReportingPlugin plugin;
  
  private IReportingService reportingService;

  /**
   * The constructor
   */
  public ReportingPlugin() {
    this.reportingService = ReportingService.getService();
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance.
   *
   * @return the shared instance.
   */
  public static ReportingPlugin getPlugin() {
    return plugin;
  }
  
  /**
   * Get the reporting service.
   * 
   * @return The {@link IReportingService} that is provided
   * by the reporting plug-in.
   */
  public static IReportingService getReportingService() {
    return getPlugin().reportingService;
  }
  
}
