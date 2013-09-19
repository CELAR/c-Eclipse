/************************************************************
 * Copyright (C), 2013 CELAR Consortium 
 * http://www.celarcloud.eu
 * 
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.property;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

import eu.celar.tosca.TPolicy;

// This class provides the content and label providers for table viewers related
// to elasticity actions
public class ResizingActionsProvider {

  ResizingActionsContentProvider RAContentProvider;
  ResizingActionsContentLabelProvider RAContentLabelProvider;

  public ResizingActionsProvider() {
    this.RAContentProvider = new ResizingActionsContentProvider();
    this.RAContentLabelProvider = new ResizingActionsContentLabelProvider();
  }
  class ResizingActionsContentProvider implements IStructuredContentProvider {

    @Override
    public void dispose() {
      // TODO Auto-generated method stub
    }

    @Override
    public void inputChanged( Viewer viewer, Object oldInput, Object newInput )
    {
      // TODO Auto-generated method stub
    }

    @Override
    public Object[] getElements( Object inputElement ) {
      return ((List<TPolicy>) inputElement).toArray();
    }
  }
  class ResizingActionsContentLabelProvider extends LabelProvider
    implements ITableLabelProvider
  {

    @Override
    public Image getColumnImage( Object element, int columnIndex ) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public String getColumnText( Object element, int columnIndex ) {
      String result = null;
      if( element != null ) {
        TPolicy var = ( TPolicy )element;
        switch( columnIndex ) {
          case 0:
            result = var.getName();
          break;
          
        }
      }
      return result;
    }
  }
}
