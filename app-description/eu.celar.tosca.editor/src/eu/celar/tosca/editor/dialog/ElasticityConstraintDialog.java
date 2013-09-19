/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.dialog;

/**
 * @author stalo
 */
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory;
import eu.celar.tosca.elasticity.ElasticityRequirementCategory;

public class ElasticityConstraintDialog extends Dialog {

  protected Text typeText;
  protected Text valueText;
  protected boolean editMode = false;
  protected boolean addMode = false;
  protected String newType;
  protected String elasticityRequirement;
  private CCombo cmbGlobalElasticityReq;
  private CCombo cmbOperator;
  private String component;
  private Label unitLabel;

  private String unit;
  
  /**
   * @param parentShell
   */
  public ElasticityConstraintDialog( final Shell parentShell, String component )
  {
    super( parentShell );
    this.elasticityRequirement = null;
    this.addMode = true;
    this.component = component;
  }

  @Override
  protected void configureShell( final Shell shell ) {
    super.configureShell( shell );
    shell.setText( "Global Elasticity Requirements" );
    shell.setSize( 300, 170 );
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
    typeLabel.setText( "Type" );
    GridData gd = new GridData( 50, 20 );
    typeLabel.setLayoutData( gd );
    // Combo - GlobalElasticityReq
    this.cmbGlobalElasticityReq = new CCombo( typeComposite, SWT.BORDER );
    this.cmbGlobalElasticityReq.setEnabled( true );
    gd = new GridData( 212, 20 );
    this.cmbGlobalElasticityReq.setLayoutData( gd );
    if( this.component.compareTo( "Application" ) == 0 ) {
      List<ElasticityRequirementCategory> categories = ElasticityRequirementCategory.VALUES;
      for( ElasticityRequirementCategory tempCat : categories ) {
        this.cmbGlobalElasticityReq.add( tempCat.toString() );
      }
    } 
    else if( this.component.compareTo( "Application Component" ) == 0 ) {
      List<ApplicationComponentElasticityRequirementCategory> categories = ApplicationComponentElasticityRequirementCategory.VALUES;
      for( ApplicationComponentElasticityRequirementCategory tempCat : categories )
      {
        this.cmbGlobalElasticityReq.add( tempCat.toString() );
      }
    }

    Composite valueComposite = new Composite( composite, SWT.NONE );
    gLayout = new GridLayout( 4, false );
    valueComposite.setLayout( gLayout );
    
    Label valueLabel = new Label( valueComposite, SWT.LEAD );
    valueLabel.setText( "Value" );
    gd = new GridData( 50, 20 );
    valueLabel.setLayoutData( gd );
    
    // Combo - Operator
    this.cmbOperator = new CCombo( valueComposite, SWT.BORDER );
    this.cmbOperator.setEnabled( true );
    gd = new GridData( 40, 20 );
    this.cmbOperator.setLayoutData( gd );
    this.cmbOperator.add( "=" );
    this.cmbOperator.add( "<" );
    this.cmbOperator.add( ">" ); 
    this.cmbOperator.setText( this.cmbOperator.getItem( 0 ) );  
    
    this.valueText = new Text( valueComposite, SWT.BORDER );
    gd = new GridData( 112, 20 );
    this.valueText.setLayoutData( gd );
    // metric unit label
    unitLabel = new Label( valueComposite, SWT.NONE );
    gd = new GridData( GridData.FILL_HORIZONTAL, 20 );
    unitLabel.setLayoutData( gd );

    this.cmbGlobalElasticityReq.setEditable( false );
    this.cmbGlobalElasticityReq.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        ElasticityConstraintDialog.this.newType = ElasticityConstraintDialog.this.cmbGlobalElasticityReq.getText();
        // set metric unit
        ElasticityConstraintDialog.this.unit = "";
        if( ElasticityConstraintDialog.this.newType.compareTo( "Minimum Response Time" ) == 0 )
        {
          ElasticityConstraintDialog.this.unit = "s";
        } else if( ElasticityConstraintDialog.this.newType.compareTo( "Bandwidth" ) == 0 )
        {
          ElasticityConstraintDialog.this.unit = "MB/s";
        } else if( ElasticityConstraintDialog.this.newType.compareTo( "Cost" ) == 0 )
        {
          ElasticityConstraintDialog.this.unit = "$";
        } else if( ElasticityConstraintDialog.this.newType.compareTo( "Latency" ) == 0 )
        {
          ElasticityConstraintDialog.this.unit = "s";
        } else if( ElasticityConstraintDialog.this.newType.compareTo( "Throughput" ) == 0 )
        {
          ElasticityConstraintDialog.this.unit = "s";
        } else {
          ElasticityConstraintDialog.this.unit = "other";
        }
        String unitLabelText = "  ( " + ElasticityConstraintDialog.this.unit + " )";
        ElasticityConstraintDialog.this.unitLabel.setText( unitLabelText );
      }
    } );
  

    return composite;
  }

  public String getElasticityConstraint() {
    return ElasticityConstraintDialog.this.elasticityRequirement;
  }

  @SuppressWarnings("boxing")
  @Override
  protected void okPressed() {
 
    ElasticityConstraintDialog.this.elasticityRequirement = this.cmbGlobalElasticityReq.getText() + " " + this.cmbOperator.getText() + " " + this.valueText.getText() + " " + this.unit;
                                                                                             
    super.okPressed();
  }
}

