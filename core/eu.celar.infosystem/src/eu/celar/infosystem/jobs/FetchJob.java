/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.infosystem.jobs;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudInfoService;
import eu.celar.core.model.ICloudProject;
import eu.celar.core.reporting.ProblemException;
import eu.celar.infosystem.InfoServiceFactory;
import eu.celar.infosystem.internal.Activator;

/**
 * @author nickl
 *
 */
public class FetchJob extends Job {
	
	private static FetchJob instance = null;
	
	public FetchJob (final String name) {
		super ( name );
	}
	
	public static FetchJob getInstance( final String name ) {
		if (instance == null){
			instance = new FetchJob( name );
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		
		IProgressMonitor localMonitor
	    = ( monitor != null )
	      ? monitor
	      : new NullProgressMonitor();
		
		ArrayList<ICloudInfoService> infoServicesArray = null;
	    InfoServiceFactory myInfoServiceFactory = new InfoServiceFactory();
	    infoServicesArray = myInfoServiceFactory.getAllExistingInfoService();
	    
	    // Get the number of projects. The number is used in the monitor.
	    int gridProjectNumbers = 0;
	    ICloudElement[] projectElements;
	    try {
	      projectElements = CloudModel.getRoot().getChildren( null );
	      for (int i=0; projectElements != null && i<projectElements.length; i++)
	      {
	        ICloudProject igp = (ICloudProject)projectElements[i];
	        if (igp != null && !igp.isHidden() && igp.getCloudProvider() != null)
	        {
	          gridProjectNumbers++;
	        }
	      }
	    } catch ( ProblemException e ) {
	      Activator.logException( e );
	    }
	    
	    localMonitor.beginTask( "Retrieving information", gridProjectNumbers * 10 ); //$NON-NLS-1$
	    
	    localMonitor.done();
	    Status status = new Status( IStatus.OK,
	                         "eu.celar.infosystem", //$NON-NLS-1$
	                         "Information data fetched successfully." ); //$NON-NLS-1$
	    return status;

	}

}
