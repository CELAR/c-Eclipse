/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.ui.wizards;

/**
 * @author stalo
 */
public class GlobalElasticityRequirement {

  // TODO remove from public
  public String type;
  public String value;

  GlobalElasticityRequirement( String type, String value ) {
    this.type = type;
    this.value = value;
  }
}
