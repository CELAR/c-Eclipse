/************************************************************
 * Copyright (C), 2014 DHBW Mannheim 
 *
 * Contributors:
 *      Harald Kornmayer - initial API and implementation 
 ************************************************************/
package eu.celar.ui.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {

	private static final String PROJECT_VIEW_ID = "eu.celar.ui.views.CloudProjectView";
	private static final String CLOUD_AUTH_ID = "eu.celar.ui.views.authenticationTokenView";
	private static final String CLOUD_DEPLOY_ID = "eu.celar.ui.views.deploymentview";
	private static final String CLOUD_INFORMATION = "eu.celar.infosystem.ui.InfoSystemView";

	private static final String TOPLEFT = "topleft";
	private static final String RIGHT = "right";
	private static final String BOTTOM = "bottom";

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();

		IFolderLayout topleftFolder = layout.createFolder(TOPLEFT,
				IPageLayout.LEFT, 0.2f, editorArea);
		topleftFolder.addView(PROJECT_VIEW_ID);
		topleftFolder.addPlaceholder(IPageLayout.ID_PROJECT_EXPLORER);

		IFolderLayout bottomFolder = layout.createFolder(BOTTOM,
				IPageLayout.BOTTOM, 0.66f, editorArea);

		bottomFolder.addView(IPageLayout.ID_PROP_SHEET);
		bottomFolder.addView(CLOUD_AUTH_ID);
		bottomFolder.addView(CLOUD_DEPLOY_ID);

		IFolderLayout rightFolder = layout.createFolder(RIGHT, IPageLayout.RIGHT,
				0.33f, editorArea);

		rightFolder.addView(CLOUD_INFORMATION);
	}

}
