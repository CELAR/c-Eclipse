/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.property;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

// This class provides the content and label providers for table viewers related
// to monitoring probes
public class MonitoringProbesProvider {

  MonitoringProbesContentProvider MPContentProvider;
  MonitoringProbesContentLabelProvider MPContentLabelProvider;

  public MonitoringProbesProvider() {
    this.MPContentProvider = new MonitoringProbesContentProvider();
    this.MPContentLabelProvider = new MonitoringProbesContentLabelProvider();
  }
  class MonitoringProbesContentProvider implements IStructuredContentProvider {

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
      String[] elements = new String[ 0 ];
      elements = ( String[] )( ( List )inputElement ).toArray( new String[ 0 ] );
      return elements;
    }
  }
  class MonitoringProbesContentLabelProvider extends LabelProvider
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
        String var = ( String )element;
        switch( columnIndex ) {
          case 0:
            result = var;
          break;
        }
      }
      return result;
    }
  }
}
