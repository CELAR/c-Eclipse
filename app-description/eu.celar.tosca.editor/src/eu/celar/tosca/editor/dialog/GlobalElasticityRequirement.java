/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation 
 ************************************************************/
package eu.celar.tosca.editor.dialog;


/**
 * @author stalo
 *
 */
public class GlobalElasticityRequirement {
  
  //TODO remove from public
  
  public String type;
  public String value;
  
  public GlobalElasticityRequirement(String type, String value){
    this.type=type;
    this.value=value;
  }

}
