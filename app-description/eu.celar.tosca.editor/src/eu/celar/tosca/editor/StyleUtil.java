/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor;

import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.graphiti.util.PredefinedColoredAreas;

public class StyleUtil {

  private static final IColorConstant T_NODE_TEMPLATE_TEXT_FOREGROUND = new ColorConstant( 0,
                                                                                           0,
                                                                                           0 );
  private static final IColorConstant T_NODE_TEMPLATE_FOREGROUND = new ColorConstant( 98,
                                                                                      131,
                                                                                      167 );
  public static final int APP_COMPONENT_WIDTH = 160;
  public static final int APP_COMPONENT_HEIGHT = 180;
  public static final int SOFT_DEPENDENCIES_COMP_WIDTH = 140;
  public static final int SOFT_DEPENDENCIES_COMP_INIT_HEIGHT = 15;
  public static final int SOFT_DEPENDENCY_WIDTH = SOFT_DEPENDENCIES_COMP_WIDTH - 20;
  public static final int SOFT_DEPENDENCY_HEIGHT = 20;
  public static final int SOFT_DEPENDENCIES_INCREASE = 25;

  public static Style getStyleForCommonValues( Diagram diagram ) {
    final String styleId = "COMMON-VALUES"; //$NON-NLS-1$
    IGaService gaService = Graphiti.getGaService();
    Style style = gaService.findStyle( diagram, styleId );
    if( style == null ) { // style not found - create new style
      style = gaService.createPlainStyle( diagram, styleId );
      setCommonValues( style );
    }
    return style;
  }

  public static Style getStyleForTNodeTemplate( Diagram diagram ) {
    final String styleId = "TNODETEMPLATE"; //$NON-NLS-1$
    IGaService gaService = Graphiti.getGaService();
    Style parentStyle = getStyleForCommonValues( diagram );
    Style style = gaService.findStyle( parentStyle, styleId );
    if( style == null ) { // style not found - create new style
      style = gaService.createPlainStyle( parentStyle, styleId );
      style.setFilled( true );
      style.setForeground( gaService.manageColor( diagram,
                                                  T_NODE_TEMPLATE_FOREGROUND ) );
      gaService.setRenderingStyle( style,
                                   PredefinedColoredAreas.getBlueWhiteGlossAdaptions() );
    }
    return style;
  }

  public static Style getStyleForTNodeTemplateText( Diagram diagram ) {
    final String styleId = "TNODETEMPLATE-TEXT"; //$NON-NLS-1$
    IGaService gaService = Graphiti.getGaService();
    Style parentStyle = getStyleForCommonValues( diagram );
    Style style = gaService.findStyle( parentStyle, styleId );
    if( style == null ) { // style not found - create new style
      style = gaService.createPlainStyle( parentStyle, styleId );
      setCommonTextValues( diagram, gaService, style );
      style.setFont( gaService.manageDefaultFont( diagram, false, true ) );
    }
    return style;
  }

  public static Style getStyleForTextDecorator( Diagram diagram ) {
    final String styleId = "TEXT-DECORATOR-TEXT"; //$NON-NLS-1$
    IGaService gaService = Graphiti.getGaService();
    Style parentStyle = getStyleForCommonValues( diagram );
    Style style = gaService.findStyle( parentStyle, styleId );
    if( style == null ) { // style not found - create new style
      style = gaService.createPlainStyle( parentStyle, styleId );
      setCommonTextValues( diagram, gaService, style );
      style.setFont( gaService.manageDefaultFont( diagram, true, false ) );
    }
    return style;
  }

  private static void setCommonTextValues( Diagram diagram,
                                           IGaService gaService,
                                           Style style )
  {
    style.setFilled( false );
    style.setAngle( 0 );
    style.setHorizontalAlignment( Orientation.ALIGNMENT_CENTER );
    style.setVerticalAlignment( Orientation.ALIGNMENT_CENTER );
    style.setForeground( gaService.manageColor( diagram,
                                                T_NODE_TEMPLATE_TEXT_FOREGROUND ) );
  }

  private static void setCommonValues( Style style ) {
    style.setLineStyle( LineStyle.SOLID );
    style.setLineVisible( true );
    style.setLineWidth( 2 );
    style.setTransparency( 0.0 );
  }
}
