package eu.celar.infosystem.model.base;

import java.util.Hashtable;


public class InfoCloudProvider {
  
  private String name = null;
  private Hashtable<String, String> images = null;

  public InfoCloudProvider( final String name ) {
    this.name = name;
    this.images = new Hashtable<String, String>();
  }
    
  public Hashtable<String, String> getImages(){
    return this.images;
  }
  
  
}
