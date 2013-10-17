/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.core.reporting;

import java.lang.reflect.InvocationTargetException;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ISolver {
  
  public void solve() throws InvocationTargetException;
}
