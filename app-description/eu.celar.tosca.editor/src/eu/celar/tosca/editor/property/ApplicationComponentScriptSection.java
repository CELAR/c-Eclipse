/************************************************************
 * Copyright (C), 2013 CELAR Consortium 
 * http://www.celarcloud.eu
 * 
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation
 ************************************************************/
package eu.celar.tosca.editor.property;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.namespace.QName;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
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

import eu.celar.core.model.CloudModel;
import eu.celar.core.reporting.ProblemException;
import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.ToscaDiagramEditor;
import eu.celar.tosca.editor.diagram.ToscaFeatureProvider;
import eu.celar.tosca.editor.features.CreateUserApplicationFeature;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;


/**
 *  Application Component Properties - Custom Scripts Tab
 */
public class ApplicationComponentScriptSection extends GFPropertySection
  implements ITabbedPropertyConstants, ModifyListener
{

  Section section;
  private Text simpleText;

  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    // TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    this.section = toolkit.createSection( parent, Section.TITLE_BAR );
    this.section.setText( "Deployment Script" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( this.section, SWT.WRAP );

    GridLayout layout = new GridLayout();
    layout.numColumns = 1;
    layout.marginTop = 15;
    layout.marginWidth = 2;
    layout.marginHeight = 2;
    client.setLayout( layout );

    TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    
    simpleText = factory.createText(client, "", SWT.V_SCROLL | SWT.H_SCROLL ); //$NON-NLS-1$
    
    GridData gd = new GridData();
    gd.widthHint = 1100;
    gd.heightHint = 150;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;   
    
    this.simpleText.setLayoutData( gd );
    

    simpleText.addModifyListener( this );   

    // Add section components to the toolkit
    toolkit.adapt( this.simpleText, true, true );
    this.section.setClient( client );
  }



  /*
   *  Refresh Tab(non-Javadoc)
   * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
   */
  @Override
  public void refresh() {
    
    
    PictogramElement pe = getSelectedPictogramElement();
    TNodeTemplateExtension appComponent = null;
    if( pe != null ) {
      Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      if( bo == null )
        return;
            
      if ( bo instanceof TDeploymentArtifact ){
        PictogramElement parentPE = Graphiti.getPeService().getPictogramElementParent( pe );
        
        appComponent =  ( TNodeTemplateExtension ) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement( parentPE );
      }
      else { // bo instanceof TNodeTemplate
        appComponent = ( TNodeTemplateExtension )bo;
      }
    }
    
    
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    
    if ( activeProject != null ){
      
      String fileName = appComponent.getName() + " Deployment";
      
      IFile file = activeProject.getFile( new Path("/Artifacts/Deployment Scripts/" +  fileName));
      
      if ( file.exists() == true ){
        //Convert deployment script file to String        
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        
        try {
          br = new BufferedReader(new InputStreamReader(file.getContents()));
        } catch( CoreException e1 ) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }

        try {
          while ((line = br.readLine()) != null) {
              sb.append(line);
          }
        } catch( IOException e1 ) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        
        this.simpleText.setText(sb.toString());
      }
      else{
        this.simpleText.setText( "" );
      }
      }
    
  }

  @Override
  public void modifyText( ModifyEvent e ) {
    
    PictogramElement pe = getSelectedPictogramElement();
    TNodeTemplateExtension appComponent = null;
    if( pe != null ) {
      Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      if( bo == null )
        return;
            
      if ( bo instanceof TDeploymentArtifact ){
        PictogramElement parentPE = Graphiti.getPeService().getPictogramElementParent( pe );
        
        appComponent =  ( TNodeTemplateExtension ) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement( parentPE );
      }
      else { // bo instanceof TNodeTemplate
        appComponent = ( TNodeTemplateExtension )bo;
      }
    }
    
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    
    if ( activeProject != null ){
      
      String fileName = appComponent.getName() + " Deployment";
      
      IFile file = activeProject.getFile( new Path("/Artifacts/Deployment Scripts/" +  fileName));
      
      if ( file.exists() == false ){
        file = createDeploymentScript(activeProject);
      }
      else{
        try {
          file.setContents( new ByteArrayInputStream(this.simpleText.getText().getBytes()), false, false, null );
        } catch( CoreException e1 ) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }

    
    }
    
    
  }
  
  // Creates the Application Deployment file
  public IFile createDeploymentScript(IProject activeProject) {   

    IFile file = null;
    
    PictogramElement pe = getSelectedPictogramElement();
    TNodeTemplateExtension appComponent = null;
    if( pe != null ) {
      Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      if( bo == null )
        return null;
            
      if ( bo instanceof TDeploymentArtifact ){
        PictogramElement parentPE = Graphiti.getPeService().getPictogramElementParent( pe );
        pe = parentPE;
        appComponent =  ( TNodeTemplateExtension ) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement( parentPE );
        
      }
      else { // bo instanceof TNodeTemplate
        appComponent = ( TNodeTemplateExtension )bo;
      }
    }
    
    String fileName = appComponent.getName() + " Deployment";  
        
     file = activeProject.getFile( new Path("/Artifacts/Deployment Scripts/" +  fileName));
     try {
      file.create(new ByteArrayInputStream(this.simpleText.getText().getBytes()), false, null);
      } catch (CoreException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
          return null;
      }
  
    
      IProgressMonitor monitor = null;
      try {
        CloudModel.getRoot().refresh( monitor );
      } catch( ProblemException e ) {
        e.printStackTrace();
      }
 
          
      // Call the Create User Application Feature to create a deployment artifact for the deployment script and add it to the artifacts list 
      CreateUserApplicationFeature createUAFeature = new CreateUserApplicationFeature( new ToscaFeatureProvider(getDiagramTypeProvider()) );
      
      TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
      deploymentArtifact.setName( fileName );
      deploymentArtifact.setArtifactType( new QName( "UA" ) );  
      
      createUAFeature.setContextObject( deploymentArtifact );
      
      CreateContext createContext = new CreateContext();
      createContext.setTargetContainer( (ContainerShape) pe );
      
      if ( createUAFeature.canCreate( createContext ))
        createUAFeature.create( createContext );
   
    return file;
    
  }
}
