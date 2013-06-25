/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.tosca.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ToscaDiagramEditorInput extends DiagramEditorInput {
  
  private IFile diagramFile = null;
  private IFile toscaFile = null;

  public ToscaDiagramEditorInput( final URI diagramUri, final String providerId ) {
    super( diagramUri, providerId );
  }

  public IFile getDiagramFile() {
    return this.diagramFile;
  }

  public void setDiagramFile( final IFile diagramFile ) {
    this.diagramFile = diagramFile;
  }

  public IFile getToscaFile() {
    return this.toscaFile;
  }

  public void setToscaFile( final IFile toscaFile ) {
    this.toscaFile = toscaFile;
  }
  
  @Override
  public boolean equals(final Object obj) {
    boolean result = false;

    if (obj == null) {
      return result;
    }

    if (obj instanceof ToscaDiagramEditorInput) {
      final ToscaDiagramEditorInput otherInput = (ToscaDiagramEditorInput) obj;

      if (this.diagramFile.equals(otherInput.diagramFile)) {
        result = true;
      }
    }

    return result;
  }
  
}
