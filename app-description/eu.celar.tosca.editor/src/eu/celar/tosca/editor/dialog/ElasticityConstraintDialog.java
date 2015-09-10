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
    shell.setSize( 300, 180 );
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
    typeLabel.setText( "Type" ); //$NON-NLS-1$
    GridData gd = new GridData( 50, 20 );
    typeLabel.setLayoutData( gd );
    // Combo - GlobalElasticityReq
    this.cmbGlobalElasticityReq = new CCombo( typeComposite, SWT.BORDER );
    this.cmbGlobalElasticityReq.setEnabled( true );
    gd = new GridData( 212, 20 );
    this.cmbGlobalElasticityReq.setLayoutData( gd );
    ArrayList<MonitoringProbe> mps = getMetrics();
    for( MonitoringProbe mp : mps ) {
      String metricsString = mp.getDescription();
      if( metricsString.equals( "" ) == false ) {
        metricsString = metricsString.substring( 2, metricsString.length() - 2 );
        metricsString = metricsString.replace( "\"", "" );
        String[] metrics = metricsString.split( "," );
        for( String metric : metrics )
          this.cmbGlobalElasticityReq.add( metric );
      } else {
        this.cmbGlobalElasticityReq.add( mp.getName() );
      }
    }
    this.cmbGlobalElasticityReq.add( "CostPerHour ($)" );
    this.cmbGlobalElasticityReq.add( "Response Time" );
    Composite valueComposite = new Composite( composite, SWT.NONE );
    gLayout = new GridLayout( 3, false );
    valueComposite.setLayout( gLayout );
    Label valueLabel = new Label( valueComposite, SWT.LEAD );
    valueLabel.setText( "Value" ); //$NON-NLS-1$
    gd = new GridData( 50, 20 );
    valueLabel.setLayoutData( gd );
    // Combo - Operator
    this.cmbOperator = new CCombo( valueComposite, SWT.BORDER );
    this.cmbOperator.setEnabled( true );
    gd = new GridData( 40, 20 );
    this.cmbOperator.setLayoutData( gd );
    this.cmbOperator.add( "=" ); //$NON-NLS-1$
    this.cmbOperator.add( "<" ); //$NON-NLS-1$
    this.cmbOperator.add( ">" ); //$NON-NLS-1$
    this.cmbOperator.setText( this.cmbOperator.getItem( 0 ) );
    this.valueText = new Text( valueComposite, SWT.BORDER );
    gd = new GridData( 154, 20 );
    this.valueText.setLayoutData( gd );
    return composite;
  }

  public ArrayList<MonitoringProbe> getMetrics() {
    ArrayList<MonitoringProbe> mps = MockUpInfoSystem.getInstance()
      .getMonitoringProbes();
    @SuppressWarnings("unchecked")
    ArrayList<MonitoringProbe> mpsCopy = ( ArrayList<MonitoringProbe> )mps.clone();
    IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
    IProject monitoringProbesProject = workspaceRoot.getProject( "MonitoringProbe" );
    if( monitoringProbesProject.exists() ) {
      IFolder srcFolder = monitoringProbesProject.getFolder( "src" );
      IResource[] artifactsResource = null;
      try {
        artifactsResource = srcFolder.members();
      } catch( CoreException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      
      }
      String[] properties = {"queueLength", "avgCpuUsage", "avgMemoryUsage", "workerUtilisation", "rewardLostToQueueing",
      "rewardLostToSmallWorkers", "totalReward"};
      
      for (int i=0; i<properties.length; i++) {
        String s = properties[i];
        MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
        mp.setUID( s );
        mp.setName( s );
        mp.setDescription( "" );
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

  public String getElasticityConstraint() {
    return ElasticityConstraintDialog.this.elasticityRequirement;
  }

  @SuppressWarnings("boxing")
  @Override
  protected void okPressed() {
    ElasticityConstraintDialog.this.elasticityRequirement = this.cmbGlobalElasticityReq.getText()
                                                            + this.cmbOperator.getText()
                                                            + this.valueText.getText();
    super.okPressed();
  }
}
