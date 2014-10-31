package eu.celar.infosystem;

import java.util.ArrayList;

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudInfoService;
import eu.celar.core.model.ICloudProject;
import eu.celar.core.reporting.ProblemException;
import eu.celar.infosystem.internal.Activator;


/**
 * This class is responsible for returning existing information services.
 * 
 * @author tnikos
 */
public class InfoServiceFactory {
  
  
  /**
   * Returns existing information services.
   * @return An array with all the different kind of information services found
   * in the projects. Only one of each type is returned, the first that is found
   * by browsing the grid projects. 
   */
  public ArrayList<ICloudInfoService> getAllExistingInfoService()
  {
    ArrayList<ICloudInfoService> infoServiceArray = new ArrayList<ICloudInfoService>();
    ICloudInfoService infoService = null;
 
    ICloudElement[] projectElements;
    try {
      projectElements = CloudModel.getRoot().getChildren( null );
      for (int i=0; projectElements != null && i<projectElements.length; i++)
      {
        ICloudProject igp = (ICloudProject)projectElements[i];
        if (igp != null && !igp.isHidden() && igp.getCloudProvider() != null)
        {
          infoService = igp.getCloudProvider().getInfoService();
          if (infoService != null && !exists(infoServiceArray, infoService))
            infoServiceArray.add( infoService );
        }
      }
    } catch ( ProblemException e ) {
      Activator.logException( e );
    } catch ( Exception e ) {
      Activator.logException( e );
    }
    
    return infoServiceArray;
  }
  
  private boolean exists(final ArrayList<ICloudInfoService> infoServiceArray,
                         final ICloudInfoService infoService)
  {
    boolean result = false;
    for (int i=0; infoServiceArray!= null 
                  && i<infoServiceArray.size()
                  && !result; i++)
    {
      if (infoServiceArray.get( i ).getClass().equals( infoService.getClass() ))
        result = true;
    }
    
    return result;
  }
}