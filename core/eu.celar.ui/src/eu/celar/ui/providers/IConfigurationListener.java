package eu.celar.ui.providers;

/**
 * Interface for listeners that want to listen to changes of
 * {@link ConfigurableContentProvider}s.
 */
public interface IConfigurationListener {
  
  /**
   * Called whenever the mode of the {@link ConfigurableContentProvider}
   * changes.
   * 
   * @param source The {@link ConfigurableContentProvider} where the change
   * occurred.
   */
  public void configurationChanged( final ConfigurableContentProvider source );
  
}
