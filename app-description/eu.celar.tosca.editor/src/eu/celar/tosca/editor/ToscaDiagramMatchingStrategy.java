/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.tosca.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.graphiti.ui.editor.DiagramEditorMatchingStrategy;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ToscaDiagramMatchingStrategy implements IEditorMatchingStrategy {

  /* (non-Javadoc)
   * @see org.eclipse.ui.IEditorMatchingStrategy#matches(org.eclipse.ui.IEditorReference, org.eclipse.ui.IEditorInput)
   */
  @Override
  public boolean matches( final IEditorReference editorRef, final IEditorInput input ) {
    try {
      final IFile newDataFile = ToscaFileService.getDataFileForInput(input);
      final IFile openEditorDataFile = ToscaFileService.getDataFileForInput(editorRef.getEditorInput());

      if (null != newDataFile && newDataFile.equals(openEditorDataFile)) {
        return true;
      }
    } catch (PartInitException exception) {
      exception.printStackTrace();
    }

    return new DiagramEditorMatchingStrategy().matches(editorRef, input);
  }
}
