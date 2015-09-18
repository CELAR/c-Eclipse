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
    
    ArrayList<MonitoringProbe> mps = getMetrics();
    for( MonitoringProbe mp : mps ) {
      String metricsString = mp.getDescription();
      if( metricsString.equals( "" ) == false ) { //$NON-NLS-1$
        metricsString = metricsString.substring( 2, metricsString.length() - 2 );
        metricsString = metricsString.replace( "\"", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        String[] metrics = metricsString.split( "," ); //$NON-NLS-1$
        for( String metric : metrics )
          this.cmbGlobalElasticityReq.add( metric, idx );
          idx++;
      } else {
        this.cmbGlobalElasticityReq.add( mp.getName(), idx );
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

  public ArrayList<MonitoringProbe> getMetrics() {
    ArrayList<MonitoringProbe> mps = MockUpInfoSystem.getInstance()
      .getMonitoringProbes();
    @SuppressWarnings("unchecked")
    ArrayList<MonitoringProbe> mpsCopy = ( ArrayList<MonitoringProbe> )mps.clone();
    IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
    IProject monitoringProbesProject = workspaceRoot.getProject( "MonitoringProbe" ); //$NON-NLS-1$
    if( monitoringProbesProject.exists() ) {
      IFolder srcFolder = monitoringProbesProject.getFolder( "src" ); //$NON-NLS-1$
      IResource[] artifactsResource = null;
      try {
        artifactsResource = srcFolder.members();
      } catch( CoreException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      
      }
      String[] properties = {"queueLength", "avgCpuUsage", "avgMemoryUsage", "workerUtilisation", "rewardLostToQueueing", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
      "rewardLostToSmallWorkers", "totalReward"}; //$NON-NLS-1$ //$NON-NLS-2$
      
      for (int i=0; i<properties.length; i++) {
        String s = properties[i];
        MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
        mp.setUID( s );
        mp.setName( s );
        mp.setDescription( "" ); //$NON-NLS-1$
        mpsCopy.add( mp );
      }
      
      
//      for( IResource tempResource : artifactsResource ) {
//        if( tempResource instanceof IFile ) {
//          MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
//          mp.setUID( tempResource.getName().replaceFirst( ".java", "" ) );
//          mp.setName( tempResource.getName().replaceFirst( ".java", "" ) );
//          mp.setDescription( "" );
//          // add new probe to monitoring list
//          mpsCopy.add( 0, mp );
//        }
//      }
//    }
    return mpsCopy;
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
