/************************************************************
 * Copyright (C), 2013 CELAR Consortium http://www.celarcloud.eu Contributors:
 * Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.property;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISharedImages;
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
import eu.celar.infosystem.model.base.VirtualMachineImageFlavor;
import eu.celar.tosca.PropertiesType;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.TDeploymentArtifacts;
import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ToscaDiagramEditorInput;
import eu.celar.tosca.editor.diagram.ToscaFeatureProvider;
import eu.celar.tosca.editor.features.CreateVMIFeature;
import eu.celar.tosca.elasticity.NodePropertiesType;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

/**
 * Application Component Properties - Main Tab
 */
public class ApplicationComponentNameSection extends GFPropertySection
  implements ITabbedPropertyConstants, ModifyListener, SelectionListener
{

  protected Spinner minInstancesSpin;
  protected Spinner maxInstancesSpin;
  private Text nameText;
  private Text imageText;
  private Text keypairText;  
  private CCombo cmbImageSize;
  private Button addImageButton;
  private Button keypairButton;

  private String typesPrefix = Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getNsPrefix();
  
  private String typesNamespace = Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getNsURI();
  
  private String imageType = Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getImageArtifactPropertiesType().getName();
  
  @Override
  public void createControls( final Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    Image imageAdd = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD);
    Image imageSelect = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);

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
    
    CLabel valueLabel = factory.createCLabel( client, "Name:"); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 80;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    valueLabel.setLayoutData( gd );
    // Application Name text
    this.nameText = factory.createText( client, "", SWT.BORDER ); //$NON-NLS-1$
    this.nameText.setEditable( true );
    gd = new GridData(GridData.FILL_BOTH);
    gd.horizontalSpan = 2;
    gd.widthHint = 250;
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
    this.imageText = factory.createText( client, "", SWT.BORDER ); //$NON-NLS-1$
    this.imageText.setEditable( true );
    gd = new GridData();
    gd.widthHint = 220;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    // Application VM text
    this.imageText.setLayoutData( gd );
    this.imageText.addModifyListener( this );
    // VM Upload Image Button
    this.addImageButton = new Button( client, SWT.PUSH );    
    this.addImageButton.setToolTipText( "Add Image" ); //$NON-NLS-1$
    this.addImageButton.setImage( imageAdd );    
    gd = new GridData();
    gd.widthHint = 30;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.addImageButton.setLayoutData( gd );
    // Listener for Add button
    this.addImageButton.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        FileDialog dialog = new FileDialog( parent.getShell(), SWT.OPEN );
        dialog.setText( "Select Image File" ); //$NON-NLS-1$
        // dialog.setFilterExtensions(new String [] {"*.html"});
        // dialog.setFilterPath("c:\\temp");
        String result = dialog.open();
        if( result != null ) {
          // Add uploaded image to Project Artifacts folder
          IWorkbenchPage activePage = PlatformUI.getWorkbench()
            .getActiveWorkbenchWindow()
            .getActivePage();
          IEditorInput input = activePage.getActiveEditor().getEditorInput();
          IFile file = null;
          if( input instanceof ToscaDiagramEditorInput ) {
            file = ( ( ToscaDiagramEditorInput )input ).getToscaFile();
          }
          IProject project = file.getProject();

          String targetPath = Platform.getLocation()
                              + System.getProperty( "file.separator" ) + project.getName() + System.getProperty( "file.separator" ) + "Artifacts"+ System.getProperty( "file.separator" ) + "Virtual Machine Images" + System.getProperty( "file.separator" ) + dialog.getFileName(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
          File tmp = new File( targetPath );
          try {
            tmp.createNewFile();
          } catch( IOException e1 ) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
          
          // Get image Id
          BufferedReader reader = null;
          try {
            reader = new BufferedReader( new FileReader (new File(result)));
          } catch( FileNotFoundException e3 ) {
            // TODO Auto-generated catch block
            e3.printStackTrace();
          }
          String         line = null;
          StringBuilder  stringBuilder = new StringBuilder();

          try {
            while( ( line = reader.readLine() ) != null ) {
                stringBuilder.append( line );
            }
          } catch( IOException e1 ) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }

          String imageId = stringBuilder.toString();
          
          copySelectedFileToCloudProject( new File(result), tmp );
          
          IProgressMonitor monitor = null;
          try {
            CloudModel.getRoot().refresh( monitor );
          } catch( ProblemException e2 ) {
            e2.printStackTrace();
          }
//          // Refresh Palette Compartments
//          getDiagramTypeProvider().getFeatureProvider()
//            .getDiagramTypeProvider()
//            .getDiagramBehavior()
//            .refreshPalette();        
          
          
          CreateVMIFeature createImageFeature = new CreateVMIFeature( new ToscaFeatureProvider( getDiagramTypeProvider() ) );
          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( dialog.getFileName());
          //FIXME - nickl: Temporary comment below. Changing 'artifactRef' from QName to String to accommodate Okeanos VM UUID
          deploymentArtifact.setArtifactRef( imageId );
          deploymentArtifact.setArtifactType( new QName( typesNamespace, imageType, typesPrefix ) ); 
          createImageFeature.setContextObject( deploymentArtifact );
          CreateContext createContext = new CreateContext();
          createContext.setTargetContainer( ( ContainerShape )getSelectedPictogramElement() );
          if( createImageFeature.canCreate( createContext ) )
            createImageFeature.create( createContext );
          refresh();

        }
      }

      @Override
      public void widgetDefaultSelected( final SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );

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

    ArrayList<VirtualMachineImageFlavor> instanceTypes =
    MockUpInfoSystem.getInstance().getInstanceTypes();
    
    for (VirtualMachineImageFlavor type : instanceTypes )
      this.cmbImageSize.add( type.getName() );
    
    this.cmbImageSize.setEditable( false );
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    gd.horizontalSpan = 2;
    gd.widthHint = 260;
    this.cmbImageSize.setLayoutData( gd );
    // Listener for Flavor
    this.cmbImageSize.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( final SelectionEvent e ) {
        createNodeFlavorProperties( ApplicationComponentNameSection.this.cmbImageSize.getText() );
      }

      @Override
      public void widgetDefaultSelected( final SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    // KeyPair Label
    CLabel keypairLabel = factory.createCLabel( client, "Keypair:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 80;
    keypairLabel.setLayoutData( gd );
    // KeyPair text
    this.keypairText = factory.createText( client, "", SWT.BORDER ); //$NON-NLS-1$
    this.keypairText.setEditable( true );
    gd = new GridData();
    gd.widthHint = 220;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    this.keypairText.setLayoutData( gd );
    this.keypairText.addModifyListener( this );
    // Select KeyPair Button
    this.keypairButton = new Button( client, SWT.PUSH );
    this.keypairButton.setToolTipText( "Import Public Key" ); //$NON-NLS-1$
    this.keypairButton.setImage( imageSelect );
    gd = new GridData();
    gd.widthHint = 30;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.keypairButton.setLayoutData( gd );
    // Listener for Add button
    this.keypairButton.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( final SelectionEvent e ) {
        FileDialog dialog = new FileDialog( parent.getShell(), SWT.OPEN );
        dialog.setText( "Select Keypair " ); //$NON-NLS-1$
        dialog.setFilterExtensions( new String[]{
          "*.pub"} ); // filter only pub keys //$NON-NLS-1$
        // dialog.setFilterPath("c:\\temp");
        String result = dialog.open();
        if( result != null ) {
          CreateVMIFeature createImageFeature = new CreateVMIFeature( new ToscaFeatureProvider( getDiagramTypeProvider() ) );
          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( dialog.getFileName() );
          deploymentArtifact.setArtifactType( new QName( "KeyPair" ) ); //$NON-NLS-1$
          createImageFeature.setContextObject( deploymentArtifact );
          CreateContext createContext = new CreateContext();
          createContext.setTargetContainer( ( ContainerShape )getSelectedPictogramElement() );
          if( createImageFeature.canCreate( createContext ) )
            createImageFeature.create( createContext );
          refresh();
          // Add uploaded image to Project Artifacts folder
          IWorkbenchPage activePage = PlatformUI.getWorkbench()
            .getActiveWorkbenchWindow()
            .getActivePage();
          IEditorInput input = activePage.getActiveEditor().getEditorInput();
          IFile file = null;
          if( input instanceof ToscaDiagramEditorInput ) {
            file = ( ( ToscaDiagramEditorInput )input ).getToscaFile();
          }
          IProject project = file.getProject();
          String target = Platform.getLocation()
                          + System.getProperty( "file.separator" ) + project.getName() + System.getProperty( "file.separator" ) + "Artifacts" +System.getProperty( "file.separator" )+"Deployment Scripts"+System.getProperty( "file.separator" ) + dialog.getFileName(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
          String source = dialog.getFilterPath()
                          + System.getProperty( "file.separator" ) + dialog.getFileName(); //$NON-NLS-1$
          File targetFile = new File( target );
          if( !targetFile.exists() ) {
            try {
              new LocalFile( new File( source ) ).copy( new LocalFile( new File( target ) ),
                                                        EFS.NONE,
                                                        null );
            } catch( CoreException e1 ) {
              e1.printStackTrace();
            }
          }
          // File tmp = new File( targetPath );
          // try {
          // tmp.createNewFile();
          // tmp.
          // } catch( IOException e1 ) {
          // // TODO Auto-generated catch block
          // e1.printStackTrace();
          // }
          IProgressMonitor monitor = null;
          try {
            CloudModel.getRoot().refresh( monitor );
          } catch( ProblemException e2 ) {
            e2.printStackTrace();
          }
//          // Refresh Palette Compartments
//          getDiagramTypeProvider().getFeatureProvider()
//            .getDiagramTypeProvider()
//            .getDiagramBehavior()
//            .refreshPalette();
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
//    toolkit.adapt( vmDecsrLabel, true, true );
//    toolkit.adapt( this.descrText, true, true);
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
    this.minInstancesSpin = new Spinner( clientInstances, SWT.BORDER );
    this.minInstancesSpin.setMinimum( -1 );
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gdInstances.widthHint = 160;
    this.minInstancesSpin.setLayoutData( gdInstances );
    this.minInstancesSpin.addModifyListener( this );
    
    CLabel maxInstancesLabel = factory.createCLabel( clientInstances, "Max:" ); //$NON-NLS-1$
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    maxInstancesLabel.setLayoutData( gdInstances );
    this.maxInstancesSpin = new Spinner( clientInstances, SWT.BORDER );
    this.maxInstancesSpin.setMinimum( -1 );
    gdInstances = new GridData();
    gdInstances.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdInstances.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gdInstances.widthHint = 160;
    this.maxInstancesSpin.setLayoutData( gdInstances );
    this.maxInstancesSpin.addModifyListener( this );
    // Add section components to the toolkit
    toolkit.adapt( valueLabel, true, true );
    toolkit.adapt( this.nameText, true, true );
    toolkit.adapt( imageLabel, true, true );
    toolkit.adapt( this.imageText, true, true );
    section.setClient( client );
    toolkit.adapt( minInstancesLabel, true, true );
    toolkit.adapt( maxInstancesLabel, true, true );
    toolkit.adapt( this.minInstancesSpin, true, true );
    toolkit.adapt( this.maxInstancesSpin, true, true );
    sectionInstances.setClient( clientInstances );
  }

  /*
   * Refresh values of max and min instances
   */
  void refreshInstances() {
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      if( bo == null )
        return;
      TNodeTemplateExtension appComponent;
      if( bo instanceof TDeploymentArtifact ) {
        PictogramElement parentPE = Graphiti.getPeService()
          .getPictogramElementParent( pe );
        appComponent = ( TNodeTemplateExtension )Graphiti.getLinkService()
          .getBusinessObjectForLinkedPictogramElement( parentPE );
      } else { // bo instanceof TNodeTemplate
        appComponent = ( TNodeTemplateExtension )bo;
      }

      int minInstances = appComponent.getMinInstances() ;
      int maxInstances =  (( BigInteger )appComponent.getMaxInstances()).intValue();
//      if( minInstances == -1.compareTo( "-1" ) == 0 ) //$NON-NLS-1$
//        minInstances = "0"; //$NON-NLS-1$
//      if( maxInstances.compareTo( "-1" ) == 0 ) //$NON-NLS-1$
//        maxInstances = "0"; //$NON-NLS-1$
      this.minInstancesSpin.setSelection( minInstances );
      this.maxInstancesSpin.setSelection( maxInstances );
    }
  }

  // Refresh Tab
  @Override
  public void refresh() {
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      final Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      if( bo == null )
        return;
      TNodeTemplate appComponent;
      if( bo instanceof TDeploymentArtifact ) {
        PictogramElement parentPE = Graphiti.getPeService()
          .getPictogramElementParent( pe );
        appComponent = ( TNodeTemplate )Graphiti.getLinkService()
          .getBusinessObjectForLinkedPictogramElement( parentPE );
      } else { // bo instanceof TNodeTemplate
        appComponent = ( TNodeTemplate )bo;
      }
      String name = appComponent.getName();
      this.nameText.setText( name == null
                                         ? "" : name ); //$NON-NLS-1$
      // set Image Artifact
      String imageName = null;
      TDeploymentArtifacts deploymentArtifacts = appComponent.getDeploymentArtifacts();
      if( deploymentArtifacts != null ) {
        for( TDeploymentArtifact artifact : deploymentArtifacts.getDeploymentArtifact() )
        {
          if( artifact.getArtifactType().getLocalPart().equals( imageType ) ) { //$NON-NLS-1$
            imageName = artifact.getName();
            break;
          }
        }
      }
      this.imageText.setText( imageName == null
                                               ? "" : imageName ); //$NON-NLS-1$
      
      // set VM Flavor
      if ( appComponent.getProperties() != null ){
        NodePropertiesType nodeProperties = (NodePropertiesType) appComponent.getProperties().getAny().get( 0 ).getValue();
        String flavor = nodeProperties.getFlavor();
        this.cmbImageSize.setText( flavor == null
                                           ? "" : flavor ); //$NON-NLS-1$
      }
      else{
        this.cmbImageSize.setText( "" ); //$NON-NLS-1$
      }
      
      if( !( bo instanceof TDeploymentArtifact ) )
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
      
      if( bo instanceof TDeploymentArtifact ) {
        PictogramElement parentPE = Graphiti.getPeService()
          .getPictogramElementParent( pe );
        nodeTemplate = ( TNodeTemplateExtension )Graphiti.getLinkService()
          .getBusinessObjectForLinkedPictogramElement( parentPE );
      } else if (bo instanceof TNodeTemplateExtension) { // bo instanceof TNodeTemplate
        nodeTemplate = ( TNodeTemplateExtension )bo;
      } else {
        nodeTemplate = null;
      }
      
      // nameText Listener
      if( e.widget == this.nameText ) {
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            protected void doExecute() {
              if( nodeTemplate != null ) {
                nodeTemplate.setName( ApplicationComponentNameSection.this.nameText.getText() );
              }
            }
          } );
      }
      // minInstancesText Listener
      else if( e.widget == this.minInstancesSpin ) {
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            @Override
            protected void doExecute() {
              if( nodeTemplate != null ) {
                if (ApplicationComponentNameSection.this.minInstancesSpin.getSelection() != nodeTemplate.getMinInstances()) {
                  nodeTemplate.setMinInstances( ApplicationComponentNameSection.this.minInstancesSpin.getSelection() );      
                }
              }
            }
          } );
      }
      // maxInstancesText Listener
      else if( e.widget == this.maxInstancesSpin ) {
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            @Override
            protected void doExecute() {
              if (nodeTemplate != null) {
                if( ApplicationComponentNameSection.this.maxInstancesSpin.getSelection() != ( ( ( BigInteger )nodeTemplate.getMaxInstances() ).intValue() ) )
                {
                nodeTemplate.setMaxInstances( BigInteger.valueOf( ApplicationComponentNameSection.this.maxInstancesSpin.getSelection() ) );
                }
            }
            }
          } );
      }
    }
  }

  private void createNodeFlavorProperties( String flavor ) {
    PictogramElement pe = getSelectedPictogramElement();
    final TNodeTemplateExtension appComponent;
    Object bo = Graphiti.getLinkService()
      .getBusinessObjectForLinkedPictogramElement( pe );
    if( bo == null )
      return;
    if( bo instanceof TDeploymentArtifact ) {
      PictogramElement parentPE = Graphiti.getPeService()
        .getPictogramElementParent( pe );
      appComponent = ( TNodeTemplateExtension )Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( parentPE );
    } else { // bo instanceof TNodeTemplate
      appComponent = ( TNodeTemplateExtension )bo;
    }
    // Create Flavor Properties
    NodePropertiesType nodeProperties = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createNodePropertiesType();
    nodeProperties.setFlavor( flavor );
    // Set the Properties of the Policy Template
    final PropertiesType properties = ToscaFactory.eINSTANCE.createPropertiesType();
    // Add the SYBL Policy to the FeatureMap of the Policy's Properties element
    Entry e = FeatureMapUtil.createEntry( Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getDocumentRoot_NodeProperties(),
                                          nodeProperties );
    properties.getAny().add( e );
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( appComponent );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          appComponent.setProperties( properties );
        }
      } );
  }

  @Override
  public void widgetSelected( SelectionEvent e ) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void widgetDefaultSelected( SelectionEvent e ) {
    // TODO Auto-generated method stub
    
  }
  
  private void copySelectedFileToCloudProject(File source, File destination){
    
    InputStream selection = null;
    OutputStream output = null;
    try {
      try {
        selection = new FileInputStream(source);
      } catch( FileNotFoundException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    try {
      output = new FileOutputStream(destination);
    } catch( FileNotFoundException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    byte[] buf = new byte[1024];
    int bytesRead;
     try {
      while ((bytesRead = selection.read(buf)) > 0) {
      output.write(buf, 0, bytesRead);
      }
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    } finally {
      try {
        selection.close();
        output.close();
      } catch( IOException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    
    }

  }
}
