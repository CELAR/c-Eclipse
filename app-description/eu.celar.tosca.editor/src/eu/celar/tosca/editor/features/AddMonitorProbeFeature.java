/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.tosca.editor.features;


import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import eu.celar.infosystem.model.base.MonitoringProbe;


/**
 * @author Nicholas Loulloudes
 *
 */
public class AddMonitorProbeFeature extends AbstractFeature
  implements IAddFeature
{

  private static final IColorConstant E_CLASS_TEXT_FOREGROUND = IColorConstant.BLACK;  
  private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant( 98, 131, 167 );
  private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant( 187, 218, 220 );
  
  /**
   * @param fp
   */
  public AddMonitorProbeFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  /* (non-Javadoc)
   * @see org.eclipse.graphiti.func.IAdd#canAdd(org.eclipse.graphiti.features.context.IAddContext)
   */
  public boolean canAdd( final IAddContext context ) {
    boolean result = false;
    boolean isDiagramInstance = context.getTargetContainer() instanceof Diagram ? true : false;

    if (context.getNewObject() instanceof MonitoringProbe && !isDiagramInstance )
    {
      result = true;
    }
    
    return result;
}

  /* (non-Javadoc)
   * @see org.eclipse.graphiti.func.IAdd#add(org.eclipse.graphiti.features.context.IAddContext)
   */
  @Override
public PictogramElement add( final IAddContext context ) {
    
    MonitoringProbe addedClass = (MonitoringProbe) context.getNewObject();
    ContainerShape targetDiagram = context.getTargetContainer();

    // CONTAINER SHAPE WITH ROUNDED RECTANGLE
    IPeCreateService peCreateService = Graphiti.getPeCreateService();
    ContainerShape containerShape =
         peCreateService.createContainerShape(targetDiagram, true);

    // check whether the context has a size (e.g. from a create feature)
    // otherwise define a default size for the shape
    final int width = context.getWidth() <= 0 ? 100 : context.getWidth();
    final int height = context.getHeight() <= 0 ? 50 : context.getHeight();
    IGaService gaService = Graphiti.getGaService();
    RoundedRectangle roundedRectangle; // need to access it later

    {
        // create and set graphics algorithm
        roundedRectangle =
            gaService.createRoundedRectangle(containerShape, 5, 5);
        roundedRectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
        roundedRectangle.setBackground(manageColor(E_CLASS_BACKGROUND));
        roundedRectangle.setLineWidth(2);
        gaService.setLocationAndSize(roundedRectangle,
            context.getX(), context.getY(), width, height);

        // if added Class has no resource we add it to the resource 
        // of the diagram
        // in a real scenario the business model would have its own resource
        if (addedClass.eResource() == null) {
                 getDiagram().eResource().getContents().add(addedClass);
        }
        // create link and wire it        
        link(containerShape, addedClass);
    }

    // SHAPE WITH LINE
    {
        // create shape for line
        Shape shape = peCreateService.createShape(containerShape, false);

        // create and set graphics algorithm
        Polyline polyline =
            gaService.createPolyline(shape, new int[] { 0, 20, width, 20 });
        polyline.setForeground(manageColor(E_CLASS_FOREGROUND));
        polyline.setLineWidth(2);
    }

    // SHAPE WITH TEXT
    {
        // create shape for text
        Shape shape = peCreateService.createShape(containerShape, false);
        // create and set text graphics algorithm
        Text text = gaService.createText(shape, addedClass.getName());
        text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
        text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER ); 
        // vertical alignment has as default value "center"
        text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
        gaService.setLocationAndSize(text, 0, 0, width, 20);

        // create link and wire it
        link(shape, addedClass);
    }

    return containerShape;
  }

  /* (non-Javadoc)
   * @see org.eclipse.graphiti.features.IFeature#canExecute(org.eclipse.graphiti.features.context.IContext)
   */
  @Override
  public boolean canExecute( final IContext context ) {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see org.eclipse.graphiti.features.IFeature#execute(org.eclipse.graphiti.features.context.IContext)
   */
  @Override
  public void execute( final IContext context ) {
    // TODO Auto-generated method stub
  }
}
