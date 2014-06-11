/************************************************************
 * Copyright (C), 2013 CELAR Consortium 
 * http://www.celarcloud.eu
 * 
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.property;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.xml.namespace.QName;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.internal.filesystem.local.LocalFile;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.celar.core.model.CloudModel;
import eu.celar.core.reporting.ProblemException;
import eu.celar.infosystem.mockup.info.MockUpInfoSystem;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ToscaDiagramEditorInput;
import eu.celar.tosca.editor.diagram.ToscaFeatureProvider;
import eu.celar.tosca.editor.features.CreateVMIFeature;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;

/**
 *  Application Component Properties - Main Tab
 *
 */
public class ApplicationComponentNameSection extends GFPropertySection
  implements ITabbedPropertyConstants, ModifyListener, SelectionListener
{

  private Text nameText;
  private Text descrText;
  private Text imageText;
  private Text keypairText;
  private Text initialInstancesText;
  private Text minInstancesText;
  private Text maxInstancesText;
  private CCombo cmbImageSize;
  private Button uploadImage;
  private Button keypairSelect;
    
  @Override
  public void createControls( final Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    
    // Application Component Properties Section\
    
    // Application Name label
    Section section = toolkit.createSection( parent, Section.TITLE_BAR );
    section.setText( "Application Component Properties" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( section, SWT.WRAP );
    GridLayout layout = new GridLayout();
    layout.numColumns = 3;
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
    gd.widthHint = 80;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    valueLabel.setLayoutData( gd );
    
    // Application Name text    
    this.nameText = factory.createText( client, "" ); //$NON-NLS-1$
    this.nameText.setEditable( true );   
    gd = new GridData();
    gd.horizontalSpan = 2;
    gd.widthHint = 160;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    this.nameText.setLayoutData( gd );
    
    // Application VM label
    CLabel imageLabel = factory.createCLabel( client, "VM Image:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 80;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    imageLabel.setLayoutData( gd );
    this.imageText = factory.createText( client, "" ); //$NON-NLS-1$
    this.imageText.setEditable( true );
    gd = new GridData();
    gd.widthHint = 160;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;    
    
    // Application VM text
    this.imageText.setLayoutData( gd );
    this.imageText.addModifyListener( this );
    
    // VM Upload Image Button
    this.uploadImage = new Button( client, SWT.PUSH );
    this.uploadImage.setText( " Add Image... " ); //$NON-NLS-1$
    gd = new GridData();
    gd.widthHint = 80;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.uploadImage.setLayoutData( gd );
    // Listener for Add button
    this.uploadImage.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        
        
        FileDialog dialog = new FileDialog(parent.getShell(), SWT.OPEN);
        dialog.setText( "Select Image File" ); //$NON-NLS-1$
        //dialog.setFilterExtensions(new String [] {"*.html"});
        //dialog.setFilterPath("c:\\temp");
        String result = dialog.open();
        if (result != null){
           
          CreateVMIFeature createImageFeature = new CreateVMIFeature( new ToscaFeatureProvider(getDiagramTypeProvider()) );
          
          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( dialog.getFileName() );
          deploymentArtifact.setArtifactType( new QName( "VMI" ) ); //$NON-NLS-1$
          
          createImageFeature.setContextObject( deploymentArtifact );
          
          CreateContext createContext = new CreateContext();
          createContext.setTargetContainer( (ContainerShape) getSelectedPictogramElement() );
          
          if ( createImageFeature.canCreate( createContext ))
            createImageFeature.create( createContext );
          
          refresh();
                    
          // Add uploaded image to Project Artifacts folder
          IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
          IEditorInput input = activePage.getActiveEditor().getEditorInput();
          
          IFile file = null;
          if ( input instanceof ToscaDiagramEditorInput ){
            file = ((ToscaDiagramEditorInput) input).getToscaFile();
          }
                    
          IProject project = file.getProject();
          
          String targetPath =  Platform.getLocation() + "/" + project.getName() + "/Artifacts/Virtual Machine Images/" +  dialog.getFileName(); //$NON-NLS-1$ //$NON-NLS-2$
          File tmp = new File( targetPath );
          try {
            tmp.createNewFile();
          } catch( IOException e1 ) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }

          IProgressMonitor monitor = null;
          try {
            CloudModel.getRoot().refresh( monitor );
          } catch( ProblemException e2 ) {
            e2.printStackTrace();
          }
          
          // Refresh Palette Compartments
          getDiagramTypeProvider().getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refreshPalette();
          
        }
      }

      @Override
      public void widgetDefaultSelected( final SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    
    
    //VM Description Label
    CLabel vmDecsrLabel = factory.createCLabel( client, "VM Description:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 80;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    
    // VM Description text
    valueLabel.setLayoutData( gd );
    this.descrText = factory.createText( client, "" ); //$NON-NLS-1$
    this.descrText.setEditable( false );   
    gd = new GridData();
    gd.horizontalSpan = 2;
    gd.widthHint = 160;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;       
    this.descrText.setLayoutData( gd );
    
    // VM Image Flavor label
    CLabel vmImageLabel = factory.createCLabel( client, "VM Type:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 80;
    vmImageLabel.setLayoutData( gd );
    
    // Combo - VM Image Flavor
    this.cmbImageSize = new CCombo( client, SWT.BORDER );
    this.cmbImageSize.setEnabled( true );
    
    // TODO - nickl For now use Amazon Flavors - get them from IS 
    ArrayList<String> instanceTypes = MockUpInfoSystem.getInstance().getInstanceTypes();
    for (String type : instanceTypes )
      this.cmbImageSize.add(type);
    
//    this.cmbImageSize.add( "Small" ); //$NON-NLS-1$
//    this.cmbImageSize.add( "Medium" ); //$NON-NLS-1$
//    this.cmbImageSize.add( "Large" ); //$NON-NLS-1$
    this.cmbImageSize.setEditable( false );
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    gd.horizontalSpan = 2;
    gd.widthHint = 160;
    this.cmbImageSize.setLayoutData( gd );
    this.cmbImageSize.addSelectionListener( this );
    
    
    // KeyPair Label
    CLabel keypairLabel = factory.createCLabel( client, "Keypair:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 80;
    keypairLabel.setLayoutData( gd );
    
    // KeyPair text
    this.keypairText = factory.createText( client, "" ); //$NON-NLS-1$
    this.keypairText.setEditable( true );
    gd = new GridData();
    gd.widthHint = 160;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;        
    this.keypairText.setLayoutData( gd );
    this.keypairText.addModifyListener( this );
    
    // Select KeyPair Button
    this.keypairSelect = new Button( client, SWT.PUSH );
    this.keypairSelect.setText( " Select... " ); //$NON-NLS-1$
    gd = new GridData();
    gd.widthHint = 80;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.keypairSelect.setLayoutData( gd );
    // Listener for Add button
    this.keypairSelect.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( final SelectionEvent e ) {
        
        
        FileDialog dialog = new FileDialog(parent.getShell(), SWT.OPEN);
        dialog.setText( "Select Keypair " ); //$NON-NLS-1$
        dialog.setFilterExtensions(new String [] {"*.pub"}); // filter only pub keys //$NON-NLS-1$
        //dialog.setFilterPath("c:\\temp");
        String result = dialog.open();
        if (result != null){
          
          CreateVMIFeature createImageFeature = new CreateVMIFeature( new ToscaFeatureProvider(getDiagramTypeProvider()) );
          
          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( dialog.getFileName() );
          deploymentArtifact.setArtifactType( new QName( "KeyPair" ) );           //$NON-NLS-1$
          createImageFeature.setContextObject( deploymentArtifact );
          
          CreateContext createContext = new CreateContext();
          createContext.setTargetContainer( (ContainerShape) getSelectedPictogramElement() );
          
          if ( createImageFeature.canCreate( createContext ))
            createImageFeature.create( createContext );
          
          refresh();
                    
          // Add uploaded image to Project Artifacts folder
          IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
          IEditorInput input = activePage.getActiveEditor().getEditorInput();
          
          IFile file = null;
          if ( input instanceof ToscaDiagramEditorInput ){
            file = ((ToscaDiagramEditorInput) input).getToscaFile();
          }
                    
          IProject project = file.getProject();                    
          String target =  Platform.getLocation() + "/" + project.getName() + "/Artifacts/Deployment Scripts/" +  dialog.getFileName(); //$NON-NLS-1$ //$NON-NLS-2$
          
          String source = dialog.getFilterPath() + System.getProperty( "file.separator" ) + dialog.getFileName(); //$NON-NLS-1$
               
          File targetFile = new File( target );
          if (!targetFile.exists()){
            try {
              new LocalFile(new File(source)).copy(new LocalFile(new File(target)), EFS.NONE, null);
            } catch( CoreException e1 ) {
              e1.printStackTrace();
            }  
          }
          
//          File tmp = new File( targetPath );
//          try {
//            tmp.createNewFile();
//            tmp.
//          } catch( IOException e1 ) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//          }

          IProgressMonitor monitor = null;
          try {            
            CloudModel.getRoot().refresh( monitor );
          } catch( ProblemException e2 ) {
            e2.printStackTrace();
          }
          
          // Refresh Palette Compartments
          getDiagramTypeProvider().getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refreshPalette();
          ApplicationComponentNameSection.this.keypairText.setText( dialog.getFileName() );
        }
      }

      @Override
      public void widgetDefaultSelected( final SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    
    
    // Add section components to the toolkit
    toolkit.adapt( vmImageLabel, true, true );
    toolkit.adapt( this.cmbImageSize, true, true );
    toolkit.adapt( valueLabel, true, true );
    toolkit.adapt( this.nameText, true, true );
    toolkit.adapt( imageLabel, true, true );
    toolkit.adapt( this.imageText, true, true );
    toolkit.adapt( keypairLabel, true, true );
    toolkit.adapt( this.keypairText, true, true );
    
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
    
    
    
    CLabel initialInstancesLabel = factory.createCLabel( clientInstances, "Initial:" ); //$NON-NLS-1$
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    initialInstancesLabel.setLayoutData( gdInstances );
    this.initialInstancesText = factory.createText( clientInstances, "1" ); //$NON-NLS-1$
    this.initialInstancesText.setEditable( true );
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gdInstances.widthHint = 160;
    this.initialInstancesText.setLayoutData( gdInstances );
    this.initialInstancesText.addModifyListener( this );
    
    
    CLabel minInstancesLabel = factory.createCLabel( clientInstances, "Min:" ); //$NON-NLS-1$
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    minInstancesLabel.setLayoutData( gdInstances );
    this.minInstancesText = factory.createText( clientInstances, "" ); //$NON-NLS-1$
    this.minInstancesText.setEditable( true );
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gdInstances.widthHint = 160;
    this.minInstancesText.setLayoutData( gdInstances );
    this.minInstancesText.addModifyListener( this );
    
    CLabel maxInstancesLabel = factory.createCLabel( clientInstances, "Max:" ); //$NON-NLS-1$
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    maxInstancesLabel.setLayoutData( gdInstances );
    this.maxInstancesText = factory.createText( clientInstances, "" ); //$NON-NLS-1$
    this.maxInstancesText.setEditable( true );
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gdInstances.widthHint = 160;
    this.maxInstancesText.setLayoutData( gdInstances );
    this.maxInstancesText.addModifyListener( this );
    
    // Add section components to the toolkit
    toolkit.adapt( valueLabel, true, true );
    toolkit.adapt( this.nameText, true, true );
    toolkit.adapt( imageLabel, true, true );
    toolkit.adapt( this.imageText, true, true );
    section.setClient( client );
    toolkit.adapt( minInstancesLabel, true, true );
    toolkit.adapt( maxInstancesLabel, true, true );
    toolkit.adapt( this.minInstancesText, true, true );
    toolkit.adapt( this.maxInstancesText, true, true );
    sectionInstances.setClient( clientInstances );
  }

  /*
   *  Refresh values of max and min instances
   */
  void refreshInstances() {
    
    PictogramElement pe = getSelectedPictogramElement();
    
    if( pe != null ) {
      Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      if( bo == null )
        return;
      
      TNodeTemplateExtension appComponent;
      
      if ( bo instanceof TDeploymentArtifact ){
        PictogramElement parentPE = Graphiti.getPeService().getPictogramElementParent( pe );
        
        appComponent =  ( TNodeTemplateExtension ) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement( parentPE );
      }
      else { // bo instanceof TNodeTemplate
        appComponent = ( TNodeTemplateExtension )bo;
      }
      
      String initInstances =  Integer.toString( appComponent.getInitInstances() );
      this.initialInstancesText.setText( initInstances );
      
      String minInstances = Integer.toString( appComponent.getMinInstances() );
      String maxInstances = ( (BigInteger)appComponent.getMaxInstances()).toString();
      
      // Node has just been created
//      if (appComponent.getName() == null)
//        return;
      
//      if( minInstances.compareTo( "-1" ) == 0 //$NON-NLS-1$
//          && maxInstances.compareTo( "-1" ) == 0 //$NON-NLS-1$
//          && this.nameText.getText().compareTo( "" ) == 0) //$NON-NLS-1$
//      {
//        return;
//      }
      
      if( minInstances.compareTo( "-1" ) == 0 ) //$NON-NLS-1$
        minInstances = ""; //$NON-NLS-1$
      if( maxInstances.compareTo( "-1" ) == 0 ) //$NON-NLS-1$
        maxInstances = ""; //$NON-NLS-1$

      this.minInstancesText.setText( minInstances );
      this.maxInstancesText.setText( maxInstances ); 
    }
  }

  // Refresh Tab
  @Override
  public void refresh() {
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      final Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      
      if ( bo == null )
        return;
      
      TNodeTemplate appComponent;
     
      if ( bo instanceof TDeploymentArtifact ){
        PictogramElement parentPE = Graphiti.getPeService().getPictogramElementParent( pe );
        
        appComponent =  ( TNodeTemplate ) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement( parentPE );
      }
      else { // bo instanceof TNodeTemplate
        appComponent = ( TNodeTemplate )bo;
      }

      String name = appComponent.getName();
      
      this.nameText.setText( name == null
                                    ? "" : name ); //$NON-NLS-1$
      // set Image Artifact
      String imageName = null;
      TDeploymentArtifacts deploymentArtifacts = appComponent.getDeploymentArtifacts();
      if( deploymentArtifacts != null ){
          
          for( TDeploymentArtifact artifact : deploymentArtifacts.getDeploymentArtifact() )
          {
            if( artifact.getArtifactType().toString().equals( "VMI" )){ //$NON-NLS-1$
              imageName = artifact.getName();
              break;
            } 
          }

      }
      this.imageText.setText( imageName == null
          ? "" : imageName ); //$NON-NLS-1$

      
      if (!(bo instanceof TDeploymentArtifact))
        refreshInstances();
    }

  }

  // Updates Application name or number of instances according the triggered
  // listener
  @Override
  public void modifyText( final ModifyEvent e ) {
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      final Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      // the filter assured, that it is a TNodeTemplate
      if( bo == null )
        return;
      
      final TNodeTemplateExtension nodeTemplate;
     
      if ( bo instanceof TDeploymentArtifact ){
        PictogramElement parentPE = Graphiti.getPeService().getPictogramElementParent( pe );
        
        nodeTemplate =  ( TNodeTemplateExtension ) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement( parentPE );
      }
      else { // bo instanceof TNodeTemplate
        nodeTemplate = ( TNodeTemplateExtension )bo;
      }
      
      
      // nameText Listener
      if( e.widget == this.nameText ) {
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            protected void doExecute() {
              nodeTemplate.setName( ApplicationComponentNameSection.this.nameText.getText() );
            }
          } );
      }
      
      // minInstancesText Listener
      else if( e.widget == this.minInstancesText ) {
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            protected void doExecute() {
              if (nodeTemplate != null) {
              	if ( ApplicationComponentNameSection.this.minInstancesText.getText().equals( "" ) ){ //$NON-NLS-1$
              		//nodeTemplate.setMinInstances( -1 ); 
              	}
              	else
              		nodeTemplate.setMinInstances( Integer.parseInt( ApplicationComponentNameSection.this.minInstancesText.getText() ) );
              }
            }              
          } );
      }
      // maxInstancesText Listener
      else if( e.widget == this.maxInstancesText ) {
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            protected void doExecute() {
            	if ( ApplicationComponentNameSection.this.maxInstancesText.getText().compareTo("")==0 ){ //$NON-NLS-1$
            		//nodeTemplate.setMaxInstances( ( BigInteger )BigInteger.valueOf(-1) );
            	}
            	else
            		nodeTemplate.setMaxInstances( ( BigInteger )BigInteger.valueOf( Integer.parseInt( ApplicationComponentNameSection.this.maxInstancesText.getText() ) ) );
            }
          } );
      }
      // initialInstancesText Listener
      else if( e.widget == this.initialInstancesText ) {
    	  
    	  if ( ApplicationComponentNameSection.this.initialInstancesText.getText().compareTo("")==0 ){ //$NON-NLS-1$
  	        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
  	        editingDomain.getCommandStack()
  	          .execute( new RecordingCommand( editingDomain ) {

  	            protected void doExecute() {
  	            	nodeTemplate.setInitInstances( 1 );
  	            }
  	          } );
    	  }
    		  
    	  else if ( nodeTemplate.getInitInstances() != Integer.parseInt(ApplicationComponentNameSection.this.initialInstancesText.getText() )){
    	        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
    	        editingDomain.getCommandStack()
    	          .execute( new RecordingCommand( editingDomain ) {

    	            protected void doExecute() {
    	            	nodeTemplate.setInitInstances( Integer.parseInt(ApplicationComponentNameSection.this.initialInstancesText.getText()) );
    	            }
    	          } );
    	  }
    	  
    	  
    	  TransactionalEditingDomain editingDomain;
        if ( nodeTemplate.getName()!=null && nodeTemplate.getName().toLowerCase().contains("ycsb") && nodeTemplate.getYcsbmulti()!=nodeTemplate.getInitInstances()){ //$NON-NLS-1$
            editingDomain = TransactionUtil.getEditingDomain( bo );
            editingDomain.getCommandStack()
              .execute( new RecordingCommand( editingDomain ) {

                protected void doExecute() {
              
            		 nodeTemplate.setYcsbmulti( nodeTemplate.getInitInstances() );

            	
                }
              } );
        }
        else if ( nodeTemplate.getName()!=null && nodeTemplate.getName().toLowerCase().contains("cassandra") && nodeTemplate.getCasmulti()!=nodeTemplate.getInitInstances()){ //$NON-NLS-1$
            editingDomain = TransactionUtil.getEditingDomain( bo );
            editingDomain.getCommandStack()
              .execute( new RecordingCommand( editingDomain ) {

                protected void doExecute() {
              
                	nodeTemplate.setCasmulti( nodeTemplate.getInitInstances() );
            	  
            	
                }
              } );
        }
        

      }
    }
  }

  /* (non-Javadoc)
   * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
   */
  @Override
  public void widgetSelected( final SelectionEvent e ) {

    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      final Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      // the filter assured, that it is a TNodeTemplate
      if( bo == null )
        return;
          
      final TDeploymentArtifact deploymentArtifact;
      
      if( bo instanceof TDeploymentArtifact ) {
        deploymentArtifact = (TDeploymentArtifact) bo;
        
        // nameText Listener
        if( e.widget == this.cmbImageSize ) {
          TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
          editingDomain.getCommandStack()
            .execute( new RecordingCommand( editingDomain ) {

              protected void doExecute() {
                deploymentArtifact.setArtifactType( QName.valueOf( ApplicationComponentNameSection.this.cmbImageSize.getText() ) );
              }
            } );
        }
      }

    }
  }

  /* (non-Javadoc)
   * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
   */
  @Override
  public void widgetDefaultSelected( final SelectionEvent e ) {
    // TODO Auto-generated method stub
    
  }
}
