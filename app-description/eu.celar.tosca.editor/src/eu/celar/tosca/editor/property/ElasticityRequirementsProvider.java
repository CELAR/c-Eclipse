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

import eu.celar.tosca.editor.dialog.GlobalElasticityRequirement;

// This class provides the content and label providers for table viewers related
// to elasticity requirements
public class ElasticityRequirementsProvider {

  GlobalElasticityRequirementsContentProvider ERContentProvider;
  GlobalElasticityRequirementsContentLabelProvider ERContentLabelProvider;

  public ElasticityRequirementsProvider() {
    this.ERContentProvider = new GlobalElasticityRequirementsContentProvider();
    this.ERContentLabelProvider = new GlobalElasticityRequirementsContentLabelProvider();
  }
  class GlobalElasticityRequirementsContentProvider
    implements IStructuredContentProvider
  {

    @Override
    public void dispose() {
      // TODO Auto-generated method stub
    }

    @Override
    public void inputChanged( final Viewer viewer, final Object oldInput, final Object newInput )
    {
      // TODO Auto-generated method stub
    }

    @Override
    public Object[] getElements( Object inputElement ) {
      GlobalElasticityRequirement[] elements = new GlobalElasticityRequirement[ 0 ];
      elements = ( eu.celar.tosca.editor.dialog.GlobalElasticityRequirement[] )( ( List )inputElement ).toArray( new GlobalElasticityRequirement[ 0 ] );
      return elements;
    }
  }
  class GlobalElasticityRequirementsContentLabelProvider extends LabelProvider
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
        GlobalElasticityRequirement var = ( GlobalElasticityRequirement )element;
        switch( columnIndex ) {
          case 0:
            // TODO type, value must not be public
            result = var.type;
          break;
          case 1:
            result = var.value;
          break;
        }
      }
      return result;
    }
  }
}
