/*******************************************************************************
 * Copyright (c) 2014 CELAR Consortium.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 * 	Nicholas Loulloudes - Initial Implementation
 ******************************************************************************/
package eu.celar.ui.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.dialogs.WizardExportResourcesPage;


/**
 * @author nickl
 *
 */
public class ApplicationDescriptionExportWizard extends WizardExportResourcesPage {

  protected ApplicationDescriptionExportWizard( final String pageName,
                                                final IStructuredSelection selection )
  {
    super( pageName, selection );
  }

  /* (non-Javadoc)
   * @see org.eclipse.ui.dialogs.WizardExportPage#createDestinationGroup(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createDestinationGroup( Composite parent ) {
    // TODO Auto-generated method stub
  }

  @Override
  public void handleEvent( Event event ) {
    // TODO Auto-generated method stub
    
  }
}
