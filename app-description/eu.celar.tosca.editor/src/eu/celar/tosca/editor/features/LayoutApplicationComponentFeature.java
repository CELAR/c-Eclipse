/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.editor.StyleUtil;


public class LayoutApplicationComponentFeature extends AbstractLayoutFeature {

	private static final int MIN_HEIGHT = StyleUtil.APP_COMPONENT_HEIGHT;

	public LayoutApplicationComponentFeature(final IFeatureProvider fp) {
		super(fp);
	}

	@Override
  public boolean canLayout(final ILayoutContext context) {
		// return true, if pictogram element is linked to a NodeTemplate
		PictogramElement pe = context.getPictogramElement();
		if (!(pe instanceof ContainerShape))
			return false;
		EList<EObject> businessObjects = pe.getLink().getBusinessObjects();
		return businessObjects.size() == 1 && businessObjects.get(0) instanceof TNodeTemplate;
	}

	@Override
  public boolean layout(final ILayoutContext context) {
		boolean anythingChanged = false;
		ContainerShape containerShape = (ContainerShape) context.getPictogramElement();
		GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();
		// the containerGa is the invisible rectangle
		// containing the visible rectangle as its (first and only) child
		GraphicsAlgorithm rectangle = containerGa.getGraphicsAlgorithmChildren().get(0);

		// height of invisible rectangle
		if (containerGa.getHeight() < MIN_HEIGHT) {
			containerGa.setHeight(MIN_HEIGHT);
			anythingChanged = true;
		}

		// height of visible rectangle (same as invisible rectangle)
		if (rectangle.getHeight() != containerGa.getHeight()) {
			rectangle.setHeight(containerGa.getHeight());
			anythingChanged = true;
		}

		// image artifact
		for (Shape shape : containerShape.getChildren()) {
			IGaService gaService = Graphiti.getGaService();
			if ((shape.getLink()!=null) && (shape.getLink().getBusinessObjects().get( 0 ) instanceof TDeploymentArtifact)){
			  TDeploymentArtifact deploymentArtifact = (TDeploymentArtifact) shape.getLink().getBusinessObjects().get( 0 );
			  if (deploymentArtifact.getArtifactType().toString().compareTo( "VMI" )==0){
			    gaService.setLocation( shape.getGraphicsAlgorithm(),
	                                    0,
	                                    rectangle.getHeight() - 20  );
			    anythingChanged = true;
			  }
			}
		}

		return anythingChanged;
	}
}
