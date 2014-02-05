package eu.celar.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;

import eu.celar.core.model.ICloudApplicationDescription;

/**
 * Wrapper class for all initialization data that has to be passed to
 * {@link NewDeploymentWizard} objects. This class contains
 * {@link ICloudApplicationDescription}s to submit and list of names and location where
 * applications should be created.
 */
public class WrapperInitObject {

  private List<ICloudApplicationDescription> applicationDescriptions = new ArrayList<ICloudApplicationDescription>();
  private List<String> applicationNames = new ArrayList<String>();
  private IResource destinationFolder;

  WrapperInitObject( final List<ICloudApplicationDescription> applicationDescriptions,
                     final List<String> applicationNames,
                     final IResource destinationFolder )
  {
    this.applicationDescriptions = applicationDescriptions;
    this.applicationNames = applicationNames;
    this.destinationFolder = destinationFolder;
  }

  /**
   * Method to access list of application descriptions to submit.
   * 
   * @return list of application descriptions to submit
   */
  public List<ICloudApplicationDescription> getApplicationDescriptions() {
    return this.applicationDescriptions;
  }

  /**
   * Method to access list of names under which newly created applications (after
   * submission) should be saved. This list is ordered in a way that it reflects
   * sequence of application descriptions objects (returned by
   * {@link WrapperInitObject#getApplicationDescriptions()} (it is guaranteed that 1st
   * name in this list is name for 1st on application description list, 2nd name is for
   * 2nd application description, and so on...)
   * 
   * @return list of names under which application descriptions at corresponding position in list
   */
  public List<String> getapplicationNames() {
    return this.applicationNames;
  }

  public IResource getDestinationFolder() {
    return this.destinationFolder;
  }
}
