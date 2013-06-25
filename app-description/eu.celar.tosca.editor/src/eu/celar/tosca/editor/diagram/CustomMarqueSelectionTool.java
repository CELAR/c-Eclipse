package eu.celar.tosca.editor.diagram;

import org.eclipse.gef.tools.MarqueeSelectionTool;
import org.eclipse.graphiti.palette.IToolEntry;


public class CustomMarqueSelectionTool extends MarqueeSelectionTool implements IToolEntry{
  
  public CustomMarqueSelectionTool(){
    setMarqueeBehavior(BEHAVIOR_NODES_TOUCHED_AND_RELATED_CONNECTIONS);
  }

  @Override
  public String getLabel() {
    // TODO Auto-generated method stub
    return "Grouping Tool";
  }

  @Override
  public String getIconId() {
    // TODO Auto-generated method stub
    return null;
  }
}
