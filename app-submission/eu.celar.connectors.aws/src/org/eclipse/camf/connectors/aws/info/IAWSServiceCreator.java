/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package org.eclipse.camf.connectors.aws.info;

import org.eclipse.camf.core.model.ICloudElementCreator;

/**
 * @author nickl
 *
 */
public interface IAWSServiceCreator extends ICloudElementCreator {

	public void setName(String name);

	public String getName();

	/**
	 * Set the url the service interacts with.
	 * 
	 * @param url
	 * the url to set
	 */
	public void setServiceURL(String url);

	/**
	 * Gets the service url of the service to be created.
	 * 
	 * @return the service url to get
	 */
	public String getServiceURL();

}
