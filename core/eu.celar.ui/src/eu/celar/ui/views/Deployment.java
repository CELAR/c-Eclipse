/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.views;

class Deployment {
  
  public static final String AWS = "Amazon Elastic Cloud"; //$NON-NLS-1$
  public static final String OPENSTACK = "OpenStack"; //$NON-NLS-1$
  public static final String OKEANOS = "Okeanos"; //$NON-NLS-1$
  public static final String FLEXISCALE = "Flexiant Cloud"; //$NON-NLS-1$
  
  String name;
  String cp;
  String ip;
  String id;
  
  String status;
  String imageId;
  String flavorId;
  String keyPair;
  
  Deployment parent;
  Deployment[] children = new Deployment[ 0 ];

  // constructors
  
  //Deployment
  public Deployment( String name, String cp, String status, String id) {
    this.name = name;
    this.cp = cp;
    this.status = status;
    this.id = id;

  }
  
  //Module
  public Deployment (String name, String status, String id ) {
    this.name = name;
    this.status = status;
    this.id = id;
  }
  
  //Instance
  public Deployment (String name, String id, String imageId, String flavorId, String keyPair ) {
    this.name = name;
    this.id = id;
    this.imageId = imageId;
    this.flavorId = flavorId;
    this.keyPair = keyPair;
  }

  public String getName() {
    return this.name;
  }
  
  public String getID(){
    return this.id;
  }

  public void setName( String name ) {
    this.name = name;
  }
  
  public String getStatus(){
    String status;
    if (this.cp == null){
      if (this.imageId != null)
        status = "RUNNING"; //$NON-NLS-1$
      else
        status = null;
    } else {
      status = "DEPLOYED"; //$NON-NLS-1$
    }
    return status;
  }
  
  public String getIP(){
    return this.ip;
  }
  
  public String getCloudProvider() {
    return this.cp;
  }
  
  public String getImageId(){
    return this.imageId;
  }
  
  public String getFlavorId(){
    return this.flavorId;
  }
  
  public String getKeyPair(){
    return this.keyPair;
  }
    
  public void setCloudProvider( String cp) {
    this.cp = cp;
  }

  public Deployment getParent() {
    return this.parent;
  }

  public void setParent( Deployment parent ) {
    this.parent = parent;
  }

  public Deployment[] getChildren() {
    return this.children;
  }

  public void setChildren( Deployment[] children ) {
    this.children = children;
  }

  public Deployment( String name, String cp, String status, String id, Deployment[] children ) {
    this.name = name;
    this.cp = cp;
    this.status = status;
    this.children = children;
    for( Deployment child : children ) {
      child.setParent( this );
    }
  }
  
  public String toString(){
    return this.getName();
  }
}