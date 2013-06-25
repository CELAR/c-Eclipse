/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.tosca.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.graphiti.features.IFeatureProvider;

import eu.celar.tosca.DocumentRoot;
import eu.celar.tosca.TTopologyTemplate;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ToscaModelLayer {
  protected IFile modelFile;
  private IFeatureProvider featureProvider;
  private TTopologyTemplate topology;
  private DocumentRoot documentRoot;
  
  public ToscaModelLayer (final IFeatureProvider featureProvider, final IFile modelFile) {
    this.featureProvider = featureProvider;
    this.modelFile = modelFile;
  }
  
  public IFeatureProvider getFeatureProvider() {
    return this.featureProvider;
  }
  
  public void setFeatureProvider(final IFeatureProvider featureProvider) {
    this.featureProvider = featureProvider;
  }
  
  public TTopologyTemplate getTopology() {
    return this.documentRoot.getDefinitions().getServiceTemplate().get( 0 ).getTopologyTemplate();
  }
  
  public void setTopology(final TTopologyTemplate topology) {
    this.topology = topology;
  }
  
  public IFile getModelFile() {
    return this.modelFile;
}

  public DocumentRoot getDocumentRoot() {
    return this.documentRoot;
  }

  public void setDocumentRoot( final DocumentRoot documentRoot ) {
    this.documentRoot = documentRoot;
  }
  
}
