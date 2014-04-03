/************************************************************
 * Copyright (C), 2014 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.views;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


/**
 * @author Nicholas Loulloudes
 *
 */
public class DeploymentLabelProvider extends LabelProvider implements ITableLabelProvider {



  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
   */
  @Override
  public Image getColumnImage( Object element, int columnIndex ) {
    Image image = null;
    if( columnIndex == 0 ) {
      image = getImage( element );
    }
    return image;
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
   */
  @Override
  public String getColumnText( Object element, int columnIndex ) {
    String text = ""; //$NON-NLS-1$
    if( element instanceof Deployment ) {
      Deployment deployment = ( Deployment )element;
      switch( columnIndex ) {            
        case 1: {
          String status = deployment.getStatus();
          if( status != null ) {
            text = status;
          }
          break;
        }
        case 2: {
          String ip = deployment.getID();
          if( ip != null ) {
            text = ip;
          }
          break;
        }
        case 3: {
          String ip = deployment.getIP();
          if( ip != null ) {
            text = ip;
          }
          break;
        }
        case 4:
          text = "test";            
          break;
      }
    }
    
    if( text == null ) {
      text = ""; //$NON-NLS-1$
    }
    
    return text;
  }

}