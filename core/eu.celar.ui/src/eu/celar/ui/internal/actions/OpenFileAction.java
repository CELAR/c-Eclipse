/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.internal.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;

import eu.celar.ui.dialogs.ProblemDialog;


/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenFileAction extends SelectionListenerAction {
  
  /**
   * The workbench page.
   */
  protected IWorkbenchPage workbenchPage;
  
  /**
   * Optional editor descriptor. 
   */
  private IEditorDescriptor editorDescriptor;
  
  /**
   * Create a new action without a dedicated editor descriptor.
   * 
   * @param page The workbench page.
   */
  public OpenFileAction( final IWorkbenchPage page ) {
    this( page, null );
  }

  /**
   * Create a new action with the specified editor descriptor.
   * 
   * @param page The workbench page.
   * @param descriptor The editor descriptor.
   */
  public OpenFileAction( final IWorkbenchPage page, final IEditorDescriptor descriptor ) {
    super( Messages.getString("OpenFileAction.action_label") ); //$NON-NLS-1$
    this.workbenchPage = page;
    this.editorDescriptor = descriptor;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    Iterator< ? > iter = getStructuredSelection().iterator();
    while ( iter.hasNext() ) {
      Object next = iter.next();
      if ( next instanceof IAdaptable ) {
        IResource resource = ( IResource ) ( ( IAdaptable ) next ).getAdapter( IResource.class );
        if ( resource instanceof IFile ) {
          openFile( ( IFile ) resource );
        }
      }
    }
  }
  
  /**
   * Open the specified file.
   * 
   * @param file The file to open.
   */
  protected void openFile( final IFile file ) {
    try {
      boolean activate = OpenStrategy.activateOnOpen();
      if ( this.editorDescriptor == null ) {
        IDE.openEditor( this.workbenchPage, file, activate );
      } else {
        this.workbenchPage.openEditor(
            new FileEditorInput(file),
            this.editorDescriptor.getId(),
            activate
        );
      }
    } catch ( PartInitException piExc ) {
      ProblemDialog.openProblem(
          this.workbenchPage.getWorkbenchWindow().getShell(),
          Messages.getString("OpenFileAction.open_failed_title"), //$NON-NLS-1$
          String.format( Messages.getString("OpenFileAction.open_failed_text"), file.getName() ), //$NON-NLS-1$
          piExc
      );
    }
  }  

}
