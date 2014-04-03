package eu.celar.core.model;

/**
 * Interface for listener called when job status is updated
 */
public interface ICloudDeploymentStatusListener {

  /**
   * Called when job status is changed. Warning! Can be called from working
   * thread, so please from statusChanged() don't call SWT methods directly. 
   * Rather use:
   * use: 
   *    display.syncExec ( new Runnable () { 
   *        public void run () { } 
   *        } );
   * 
   * @param deployment
   */
  public void statusChanged( ICloudDeployment deployment );
  
  /**
   * Called after every update of job status, even if status wasn't changed
   * during update. <br>
   * Warning: now this method is called only for listeners, which listen for
   * changes of all jobs registered using method
   * {@link JobManager#addJobStatusListener(ICloudDeploymentStatusListener)}
   * 
   * @param deployment for which, status has been updated
   */
  public void statusUpdated( ICloudDeployment deployment );
  
}
