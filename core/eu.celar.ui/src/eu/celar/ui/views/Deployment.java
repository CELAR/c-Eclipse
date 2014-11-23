/*******************************************************************************
 * Copyright (c) 2013 CELAR Consortium.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 *   Nicholas Loulloudes - initial API and implementation
 *   Stalo Sofokleous
 *   
 *******************************************************************************/
package eu.celar.ui.views;

class Deployment {
  
  public static final String AWS = "Amazon Elastic Cloud"; //$NON-NLS-1$
  public static final String OPENSTACK = "OpenStack"; //$NON-NLS-1$
  String name;
  String cp;
  String ip;
  String id;
  Deployment parent;
  Deployment[] children = new Deployment[ 0 ];

  // constructors
  public Deployment( String name, String cp, String ip,  String id) {
    this.name = name;
    this.cp = cp;
    this.ip = ip;
    this.id = id;

  }
  
  public Deployment (String name, String ip, String id ) {
    this.name = name;
    this.cp = null;
    this.ip = ip;
    this.id = id;
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
      status = "RUNNING"; //$NON-NLS-1$
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

  public Deployment( String name, String cp, Deployment[] children ) {
    this.name = name;
    this.cp = cp;
    this.children = children;
    for( Deployment child : children ) {
      child.setParent( this );
    }
  }
  
  public String toString(){
    return this.getName();
  }
}