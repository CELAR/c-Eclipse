/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2005, 2012 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    SAP AG - initial API, implementation and documentation
 *    cbrand - Bug 377475 - Fix AbstractCustomFeature.execute and canExecute
 *
 * </copyright>
 *
 *******************************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.editor.diagram.DialogUtil;

public class RenameApplicationComponentFeature extends AbstractCustomFeature {

	private boolean hasDoneChanges = false;

	public RenameApplicationComponentFeature(final IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Re&name Application Component"; //$NON-NLS-1$
	}

	@Override
	public String getDescription() {
		return "Change the name of the Application Component"; //$NON-NLS-1$
	}

	@Override
	public boolean canExecute(final ICustomContext context) {
		// allow rename if exactly one pictogram element
		// representing an EClass is selected
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof TNodeTemplate) {
				ret = true;
			}
		}
		return ret;
	}

	@Override
  public void execute(final ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof TNodeTemplate) {
			  TNodeTemplate tNode = (TNodeTemplate) bo;
				String currentName = tNode.getName();
				// ask user for a new class name
				String newName = DialogUtil.askString("Rename Application Component", getDescription(), currentName); //$NON-NLS-1$
				if (newName != null && !newName.equals(currentName)) {
					this.hasDoneChanges = true;
					tNode.setName(newName);
					updatePictogramElement(pes[0]);
				}
			}
		}
	}

	@Override
	public boolean hasDoneChanges() {
		return this.hasDoneChanges;
	}
}
