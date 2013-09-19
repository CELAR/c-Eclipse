/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.ui.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewSubmissionWizardFirstPage extends WizardNewFileCreationPage {

  public NewSubmissionWizardFirstPage( final String pageName,
                                          final IStructuredSelection selection )
  {
    super( pageName, selection );
    setPageComplete( false );
  }

  public void createControl( Composite parent ) {
    super.createControl( parent );
    setFileName( "myApplicationSubmission" );
  }

  @Override
  protected boolean validatePage() {
    boolean result = true;
    if( !super.validatePage() ) {
      result = false;
    }
    if( result ) {
      setPageComplete( true );
      //getContainer().updateButtons();
    }
    return result;
  }
}
