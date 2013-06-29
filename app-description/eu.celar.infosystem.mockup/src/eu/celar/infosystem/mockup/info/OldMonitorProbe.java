/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.infosystem.mockup.info;

import java.net.URI;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudMonitorProbe;


/**
 * @author Nicholas Loulloudes
 *
 */
public class OldMonitorProbe extends ApplicationComponent implements ICloudMonitorProbe
{
  
  private String uid;
  private URI uri;
  private String name;
  private String description;
  private String type;
  private int refreshInterval;
  private int alertInterval;
    
  public OldMonitorProbe( final ICloudContainer parent ) {
    super( parent );
  }

  @Override
  public String getDescription() {
    return this.description;
  }
  
  public void setType( final String type ) {
    this.type = type;
  }
  
  public String getType () {
    return this.type;
  }

  @Override
  public String getUID() {
    return this.uid;
  }

  public void setUID( final String uid ) {
    this.uid = uid;
  }

  public URI getURI() {
    return this.uri;
  }

  public void setURI( final URI uri ) {
    this.uri = uri;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

  public String getName() {
    return this.name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  @Override
  public int getRefreshInterval() {
    return this.refreshInterval;
  }
  
  public void setRefreshInterval (final int interval){
    this.refreshInterval = interval;
  }

  @Override
  public int getAlertInterval() {
    return this.alertInterval;
  }
  
  public void setAlertInterval( final int interval ) {
    this.alertInterval = interval;
  }

  @Override
  public boolean isCustomProbe() {
    return false;
  }
  

}
