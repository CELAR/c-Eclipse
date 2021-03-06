/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.providers;

import java.io.Serializable;
import java.util.Comparator;

import eu.celar.core.model.ICloudContainer;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudProvider;


/**
 * @author Nicholas Loulloudes
 *
 */
public class CloudModelComparator implements Comparator<Object>, Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -7285814327905029832L;

  /* (non-Javadoc)
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare( final Object o1, final Object o2 ) {
    int result = 0;
    if ( ( o1 instanceof ICloudElement ) && ( o2 instanceof ICloudElement ) ) {
      result = compare( ( ICloudElement ) o1, ( ICloudElement ) o2 );
    } else {
      result = o1.toString().compareTo( o2.toString() );
    }
    return result;
  }

  /**
   * Compare the specified elements.
   * 
   * @param e1 The first element.
   * @param e2 The second element.
   * @return The return value is calculated in order to prefer folders
   * before files. If both elements are either folders or files the names
   * of the elements are compared.
   */
  public int compare( final ICloudElement e1,
                      final ICloudElement e2 ) {
    int value = getValue( e1 ) - getValue( e2 );
    if ( value == 0 ) {
      value = e1.getName().compareTo( e2.getName() );
    }
    return value;
  }
  
  private int getValue( final ICloudElement e ) {
    int result = 0;
    if ( e instanceof ICloudProvider ) {
      result = 10;
    } else if ( e instanceof ICloudContainer ) {
      result = 1;
    } else {
      result = 2;
    }
    return result;
  }
}
