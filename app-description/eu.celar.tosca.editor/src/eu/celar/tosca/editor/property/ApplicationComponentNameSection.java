/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.property;

import java.math.BigInteger;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;

// Application Component Properties - Main Tab
public class ApplicationComponentNameSection extends GFPropertySection
  implements ITabbedPropertyConstants, ModifyListener
{

  private Text nameText;
  private Text imageText;
  private Text minInstancesText;
  private Text maxInstancesText;
  private CCombo cmbImageSize;

  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    // Application Component Properties Section
    Section section = toolkit.createSection( parent, Section.TITLE_BAR );
    section.setText( "Application Component Properties" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( section, SWT.WRAP );
    GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    layout.marginTop = 15;
    layout.verticalSpacing = 15;
    layout.marginWidth = 2;
    layout.marginHeight = 2;
    client.setLayout( layout );
    GridData gd;
    CLabel valueLabel = factory.createCLabel( client, "Name:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    valueLabel.setLayoutData( gd );
    nameText = factory.createText( client, "" ); //$NON-NLS-1$
    nameText.setEditable( true );
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 140;
    nameText.setLayoutData( gd );
    CLabel imageLabel = factory.createCLabel( client, "VM Image:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    imageLabel.setLayoutData( gd );
    imageText = factory.createText( client, "" ); //$NON-NLS-1$
    imageText.setEditable( true );
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 140;
    imageText.setLayoutData( gd );
    // VM Image Flavor
    CLabel vmImageLabel = factory.createCLabel( client, "VM Image Flavor:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    vmImageLabel.setLayoutData( gd );
    // Combo - VM Image Flavor
    this.cmbImageSize = new CCombo( client, SWT.BORDER );
    this.cmbImageSize.setEnabled( true );
    this.cmbImageSize.add( "Small" );
    this.cmbImageSize.add( "Medium" );
    this.cmbImageSize.add( "Large" );
    this.cmbImageSize.setEditable( false );
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 140;
    this.cmbImageSize.setLayoutData( gd );
    // Add section components to the toolkit
    toolkit.adapt( vmImageLabel, true, true );
    toolkit.adapt( cmbImageSize, true, true );
    toolkit.adapt( valueLabel, true, true );
    toolkit.adapt( nameText, true, true );
    toolkit.adapt( imageLabel, true, true );
    toolkit.adapt( imageText, true, true );
    section.setClient( client );
    // Application Component Instances Section
    Section sectionInstances = toolkit.createSection( parent, Section.TITLE_BAR );
    sectionInstances.setText( "Number of Instances" ); //$NON-NLS-1$
    Composite clientInstances = toolkit.createComposite( sectionInstances,
                                                         SWT.WRAP );
    GridLayout layoutInstances = new GridLayout();
    layoutInstances.numColumns = 2;
    layoutInstances.marginTop = 15;
    layoutInstances.verticalSpacing = 15;
    layoutInstances.marginWidth = 2;
    layoutInstances.marginHeight = 2;
    clientInstances.setLayout( layoutInstances );
    GridData gdInstances;
    CLabel minInstancesLabel = factory.createCLabel( clientInstances, "Min:" ); //$NON-NLS-1$
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    minInstancesLabel.setLayoutData( gdInstances );
    minInstancesText = factory.createText( clientInstances, "" ); //$NON-NLS-1$
    minInstancesText.setEditable( true );
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gdInstances.widthHint = 140;
    minInstancesText.setText( "1" );
    minInstancesText.setLayoutData( gdInstances );
    minInstancesText.addModifyListener( this );
    CLabel maxInstancesLabel = factory.createCLabel( clientInstances, "Max:" ); //$NON-NLS-1$
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    maxInstancesLabel.setLayoutData( gdInstances );
    maxInstancesText = factory.createText( clientInstances, "" ); //$NON-NLS-1$
    maxInstancesText.setEditable( true );
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gdInstances.widthHint = 140;
    maxInstancesText.setText( "1" );
    maxInstancesText.setLayoutData( gdInstances );
    maxInstancesText.addModifyListener( this );
    // Add section components to the toolkit
    toolkit.adapt( valueLabel, true, true );
    toolkit.adapt( nameText, true, true );
    toolkit.adapt( imageLabel, true, true );
    toolkit.adapt( imageText, true, true );
    section.setClient( client );
    toolkit.adapt( minInstancesLabel, true, true );
    toolkit.adapt( maxInstancesLabel, true, true );
    toolkit.adapt( minInstancesText, true, true );
    toolkit.adapt( maxInstancesText, true, true );
    sectionInstances.setClient( clientInstances );
  }

  // Refresh values of max and min instances
  void refreshInstances() {
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      if( bo == null )
        return;
      String minInstances = ( ( Integer )( ( TNodeTemplate )bo ).getMinInstances() ).toString();
      String maxInstances = ( ( ( TNodeTemplate )bo ).getMaxInstances() ).toString();
      if( minInstances.compareTo( "1" ) == 0
          && maxInstances.compareTo( "1" ) == 0 )
      {
        return;
      }
      minInstancesText.setText( minInstances ); //$NON-NLS-1$
      maxInstancesText.setText( maxInstances ); //$NON-NLS-1$
    }
  }

  // Refresh Tab
  @Override
  public void refresh() {
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      final Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      // the filter assured, that it is a EClass
      if( bo == null || ( ( TNodeTemplate )bo ).getName() == null )
        return;
      TNodeTemplate appComponent = ( TNodeTemplate )bo;
      String name = appComponent.getName();
      nameText.setText( name == null
                                    ? "" : name ); //$NON-NLS-1$
      // set Image Artifact
      String imageName = null;
      TDeploymentArtifacts deploymentArtifacts = appComponent.getDeploymentArtifacts();
      if( deploymentArtifacts == null )
        return;
      for( TDeploymentArtifact artifact : deploymentArtifacts.getDeploymentArtifact() )
      {
        if( artifact.getArtifactType().toString().compareTo( "VMI" ) == 0 )
          imageName = artifact.getName();
        break;
      }
      imageText.setText( imageName == null
                                          ? "" : imageName ); //$NON-NLS-1$
    }
    refreshInstances();
  }

  // Updates Application name or number of instances according the triggered
  // listener
  @Override
  public void modifyText( ModifyEvent e ) {
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      final Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      // the filter assured, that it is a TNodeTemplate
      if( bo == null )
        return;
      final TNodeTemplate nodeTemplate = ( TNodeTemplate )bo;
      // nameText Listener
      if( e.widget == this.nameText ) {
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            protected void doExecute() {
              nodeTemplate.setName( nameText.getText() );
            }
          } );
      }
      // minInstancesText Listener
      else if( e.widget == this.minInstancesText ) {
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            protected void doExecute() {
              nodeTemplate.setMinInstances( Integer.parseInt( minInstancesText.getText() ) );
            }
          } );
      }
      // maxInstancesText Listener
      else if( e.widget == this.maxInstancesText ) {
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            protected void doExecute() {
              nodeTemplate.setMaxInstances( ( BigInteger )BigInteger.valueOf( Integer.parseInt( maxInstancesText.getText() ) ) );
            }
          } );
      }
    }
  }
}
