/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

// Provides icons for directed and bidirected relationships
public class ImageProvider extends AbstractImageProvider {

  // The prefix for all identifiers of this image provider
  protected static final String PREFIX = "eu.celar.tosca.editor."; //$NON-NLS-1$
  // The image identifier for an EReference.
  public static final String IMG_EREFERENCE = PREFIX + "ereference"; //$NON-NLS-1$
  // The image identifier for an EReference.
  public static final String IMG_EREFERENCE2 = PREFIX + "ereference2"; //$NON-NLS-1$

  @Override
  protected void addAvailableImages() {
    // register the path for each image identifier
    addImageFilePath( IMG_EREFERENCE, "icons/ereference.gif" ); //$NON-NLS-1$
    addImageFilePath( IMG_EREFERENCE2, "icons/ereference2.gif" ); //$NON-NLS-1$
  }
}
