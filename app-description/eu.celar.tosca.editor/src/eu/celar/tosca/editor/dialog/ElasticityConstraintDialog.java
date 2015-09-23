/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.dialog;

/**
 * @author stalo
 */
import java.util.ArrayList;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import eu.celar.infosystem.mockup.info.MockUpInfoSystem;
import eu.celar.infosystem.model.base.InfoSystemFactory;
import eu.celar.infosystem.model.base.MonitoringProbe;

/**
 * @author Nicholas Loulloudes
 *
 */
public class ElasticityConstraintDialog extends Dialog {

  protected Text typeText;
  protected Text valueText;
  protected boolean editMode = false;
  protected boolean addMode = false;
  protected String newType;
  protected String elasticityRequirement;
  private CCombo cmbGlobalElasticityReq;
  private CCombo cmbOperator;

  /**
   * @param parentShell
   */
  public ElasticityConstraintDialog( final Shell parentShell, String component )
  {
    super( parentShell );
    this.elasticityRequirement = null;
    this.addMode = true;
  }

  @Override
  protected void configureShell( final Shell shell ) {
    super.configureShell( shell );
    shell.setText( "Add Elasticity Constraint" ); //$NON-NLS-1$
    shell.setSize( 300, 190 );
  }

  @Override
  protected Control createDialogArea( final Composite parent ) {
    Composite composite = ( Composite )super.createDialogArea( parent );
    composite.setLayout( new GridLayout( 1, false ) );
    composite.setLayoutData( new GridData( GridData.FILL_BOTH ) );
    Composite typeComposite = new Composite( composite, SWT.NONE );
    GridLayout gLayout = new GridLayout( 2, false );
    typeComposite.setLayout( gLayout );
    Label typeLabel = new Label( typeComposite, SWT.LEAD );
    typeLabel.setText( "Type: " ); //$NON-NLS-1$
    GridData gd = new GridData( 50, 20 );
    typeLabel.setLayoutData( gd );
    // Combo - GlobalElasticityReq
    this.cmbGlobalElasticityReq = new CCombo( typeComposite, SWT.BORDER );
    this.cmbGlobalElasticityReq.setEnabled( true );
    gd = new GridData( 212, 20 );
    this.cmbGlobalElasticityReq.setLayoutData( gd );
    this.cmbGlobalElasticityReq.add(  "- Not Specified -", 0 ); //$NON-NLS-1$
    
    int idx = 1;
    
    ArrayList<String> metrics = getMetrics();
    
    if (metrics != null) {
      for( String metric : metrics ) {
        this.cmbGlobalElasticityReq.add( metric, idx );
        idx++;
      }  
    }
    
    this.cmbGlobalElasticityReq.add( "CostPerHour ($)", idx++ ); //$NON-NLS-1$
    this.cmbGlobalElasticityReq.add( "Response Time", idx++ ); //$NON-NLS-1$
    
    this.cmbGlobalElasticityReq.setText( this.cmbGlobalElasticityReq.getItem( 0 ) );
    
    Composite valueComposite = new Composite( composite, SWT.NONE );
    gLayout = new GridLayout( 3, false );
    valueComposite.setLayout( gLayout );
    Label valueLabel = new Label( valueComposite, SWT.LEAD );
    valueLabel.setText( "Value: " ); //$NON-NLS-1$
    gd = new GridData( 50, 20 );
    valueLabel.setLayoutData( gd );
    // Combo - Operator
    this.cmbOperator = new CCombo( valueComposite, SWT.BORDER );
    this.cmbOperator.setEnabled( true );
    gd = new GridData( 50, 25 );
    this.cmbOperator.setLayoutData( gd );
    this.cmbOperator.add( "=" ); //$NON-NLS-1$
    this.cmbOperator.add( "<" ); //$NON-NLS-1$
    this.cmbOperator.add( ">" ); //$NON-NLS-1$
    this.cmbOperator.setText( this.cmbOperator.getItem( 0 ) );
    this.valueText = new Text( valueComposite, SWT.BORDER );
    gd = new GridData( 144, 20 );
    this.valueText.setLayoutData( gd );
    return composite;
  }

  public ArrayList<String> getMetrics() {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<MonitoringProbe> mps = MockUpInfoSystem.getInstance()
      .getMonitoringProbes();
    
    for( MonitoringProbe mp : mps ) {
      String metricsString = mp.getMetrics();
      String metrics = "{\"metrics\":" + metricsString + "}"; //$NON-NLS-1$ //$NON-NLS-2$
      JSONObject obj = null;
      JSONArray metrics_array = null;
      try {
        obj = new JSONObject( metrics );
        metrics_array = obj.getJSONArray( "metrics" ); //$NON-NLS-1$
      } catch( JSONException e ) {
        e.printStackTrace();
      }
      for( int i = 0; i < metrics_array.length(); i++ ) {
        String metricLabel = null;
        String metricDescription = null;
        try {
          metricLabel = metrics_array.getJSONObject( i ).getString( "name" ); //$NON-NLS-1$
          metricDescription = metrics_array.getJSONObject( i )
            .getString( "desc" ); //$NON-NLS-1$
        } catch( JSONException e ) {
          e.printStackTrace();
        }
        result.add( metricLabel );
      }
    }
    
    // ArrayList<MonitoringProbe> mpsCopy = ( ArrayList<MonitoringProbe>
    // )mps.clone();
    //
    // IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
    // IProject monitoringProbesProject = workspaceRoot.getProject(
    // "MonitoringProbe" );
    //
    // if( monitoringProbesProject.exists() ) {
    // IFolder srcFolder = monitoringProbesProject.getFolder( "src" );
    // IResource[] artifactsResource = null;
    // try {
    // artifactsResource = srcFolder.members();
    // } catch( CoreException e ) {
    // e.printStackTrace();
    // }
    // for( IResource tempResource : artifactsResource ) {
    // if( tempResource instanceof IFile ) {
    // MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
    // mp.setUID( tempResource.getName().replaceFirst( ".java", "" ));
    // mp.setName( tempResource.getName().replaceFirst( ".java", "" ));
    // mp.setDescription( "" );
    // // add new probe to monitoring list
    // mpsCopy.add( 0, mp );
    // }
    // }
    // }
    return result;
  }
  /**
   * @return The Elasticity Constraint
   */
  public String getElasticityConstraint() {
    return ElasticityConstraintDialog.this.elasticityRequirement;
  }
  
  @Override
  protected void okPressed() {
    boolean checked = false;
    if( this.cmbGlobalElasticityReq.getSelectionIndex() == 0 ) {
      MessageDialog.openWarning( this.getShell(),
                                 "Warning", "Please select Elasticity Constrain Type." ); //$NON-NLS-1$ //$NON-NLS-2$
      this.cmbGlobalElasticityReq.setFocus();
    } else if (this.valueText.getText().equals( "" )){  //$NON-NLS-1$
      MessageDialog.openWarning( this.getShell(),
                                 "Warning", "Please enter contrain value." ); //$NON-NLS-1$ //$NON-NLS-2$
      this.valueText.setFocus();
    } else {
      ElasticityConstraintDialog.this.elasticityRequirement = this.cmbGlobalElasticityReq.getText()
                                                              + this.cmbOperator.getText()
                                                              + this.valueText.getText();
      checked = true;
    }
    
    if( checked ) {
      super.okPressed();
    }
  }
}
