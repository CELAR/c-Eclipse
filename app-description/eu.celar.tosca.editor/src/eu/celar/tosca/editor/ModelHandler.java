/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.tosca.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;


/**
 * @author Nicholas Loulloudes
 * Operations for handling the TOSCA model
 */
public class ModelHandler {
  private static Map<URI, ToscaModelLayer> modelMap = new HashMap<URI, ToscaModelLayer>();
  
  public static void addModel(final URI uri, final ToscaModelLayer model) {
      modelMap.put(uri, model);
  }
  
  public static ToscaModelLayer getModel(final URI uri) {
      return modelMap.get(uri);
  }
  
  public static void removeModel(URI uri) {
      modelMap.remove(uri);
  }
  
  public static List<String> getModelURIList() {
      List<String> modelURIList = new ArrayList<String>();
      for(ToscaModelLayer model : modelMap.values()) {
          modelURIList.add(model.getModelFile().getRawLocationURI().toString());
      }
      return modelURIList;
  }
}
