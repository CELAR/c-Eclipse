package eu.celar.core.model;

import eu.celar.core.reporting.ProblemException;


/**
 * A configurable element creator is an element creator that is able to create
 * a grid model element from an {@link IConfiguration}. Since
 * {@link IConfiguration} can be saved to and loaded from XML files this
 * can be used to restore an element from a corresponding XML.
 */
public interface IConfigurableElementCreator
    extends ICloudElementCreator {

  /**
   * Create a model element from the specified {@link IConfiguration}.
   * 
   * @param parent The parent element of the newly created model element.
   * @param configuration The {@link IConfiguration} from which to create the
   * element.
   * @return The newly created element.
   * @throws ProblemException If the creation of the element failed.
   */
  public ICloudElement create( final ICloudContainer parent,
                              final IConfiguration configuration )
      throws ProblemException;
  
  /**
   * Get the {@link IConfiguration} that was formerly set as source for this
   * creator of <code>null</code> if the source was either not yet set or is not
   * an {@link IConfiguration}.
   * 
   * @return The {@link IConfiguration} which acts as source for this creator.
   */
  public IConfiguration getConfiguration();
  
  /**
   * Set the specified {@link IConfiguration} as source for this creator.
   * 
   * @param configuration The {@link IConfiguration} to be the new source for
   * this creator.
   */
  public void setConfiguration( final IConfiguration configuration );
  
}
