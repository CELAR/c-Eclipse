/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import eu.celar.tosca.TServiceTemplate;
import eu.celar.tosca.editor.StyleUtil;


public class LayoutServiceTemplateFeature extends AbstractLayoutFeature {

    private static final int MIN_HEIGHT = StyleUtil.APP_COMPONENT_WIDTH * 2;

    private static final int MIN_WIDTH = StyleUtil.APP_COMPONENT_WIDTH * 3;
    
    private String serviceTemplateName = null;

    public LayoutServiceTemplateFeature(final IFeatureProvider fp) {
        super(fp);
    }

    @Override
  public boolean canLayout(final ILayoutContext context) {
        // return true, if pictogram element is linked to a ServiceTemplate
        PictogramElement pe = context.getPictogramElement();
        if (!(pe instanceof ContainerShape))
            return false;
        EList<EObject> businessObjects = pe.getLink().getBusinessObjects();
        
        if (businessObjects.size() == 1)
          if (businessObjects.get(0) instanceof TServiceTemplate){
            serviceTemplateName = ((TServiceTemplate) businessObjects.get(0)).getName();
            return true;
          }
            
        return false;
    }

    @Override
  public boolean layout(final ILayoutContext context) {
        boolean anythingChanged = false;
        ContainerShape containerShape = (ContainerShape) context.getPictogramElement();
        GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();
        // the containerGa is the rectangle
        // containing the text as its (first and only) child

        // height of rectangle
        if (containerGa.getHeight() < StyleUtil.APP_COMPONENT_WIDTH * 1.5) {
            containerGa.setHeight(MIN_HEIGHT);
            anythingChanged = true;
        }

        // width of rectangle
        if (containerGa.getWidth() < MIN_WIDTH) {
            containerGa.setWidth(MIN_WIDTH);
            anythingChanged = true;
        }

        // width of text and line (same as visible rectangle)
        for (Shape shape : containerShape.getChildren()) {
            GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
            IGaService gaService = Graphiti.getGaService();
            IDimension size = gaService.calculateSize(graphicsAlgorithm);
            if (containerGa.getWidth() != size.getWidth()) {
                if (graphicsAlgorithm instanceof Polyline) {
                    Polyline polyline = (Polyline) graphicsAlgorithm;
                    Point secondPoint = polyline.getPoints().get(1);
                    Point newSecondPoint = gaService.createPoint(containerGa.getWidth(), secondPoint.getY());
                    polyline.getPoints().set(1, newSecondPoint);
                    anythingChanged = true;
                } 
                if (graphicsAlgorithm instanceof Text) {
                  Text text = (Text) graphicsAlgorithm;
                  if (text.getValue().equals( serviceTemplateName )){
                    gaService.setWidth(graphicsAlgorithm, containerGa.getWidth());
                    anythingChanged = true;
                  }
              }

            }
        }

        return anythingChanged;
    }
}
