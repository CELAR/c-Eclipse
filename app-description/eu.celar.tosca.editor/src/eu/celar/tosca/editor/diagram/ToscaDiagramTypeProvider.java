/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Nicholas Loulloudes - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class ToscaDiagramTypeProvider extends AbstractDiagramTypeProvider {

  private IToolBehaviorProvider[] toolBehaviorProviders;

  public ToscaDiagramTypeProvider() {
    super();
    setFeatureProvider( new ToscaFeatureProvider( this ) );
  }

  @Override
  public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
    if( this.toolBehaviorProviders == null ) {
      this.toolBehaviorProviders = new IToolBehaviorProvider[]{
        new ToscaToolBehaviorProvider( this )
      };
    }
    return this.toolBehaviorProviders;
  }
}
