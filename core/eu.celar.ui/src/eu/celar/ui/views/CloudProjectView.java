/************************************************************
 * Copyright (C), 2013 CELAR Consortium
 * http://www.celarcloud.eu
 *
 * Contributors:
 *      Nicholas Loulloudes - initial API and implementation 
 ************************************************************/
package eu.celar.ui.views;

import org.eclipse.jface.viewers.DecoratingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.ui.internal.actions.ActionGroupManager;
import eu.celar.ui.internal.actions.EditorActions;
import eu.celar.ui.internal.actions.NewWizardActions;
import eu.celar.ui.providers.CloudModelContentProvider;


/**
 * @author Nicholas Loulloudes
 *
 */
public class CloudProjectView extends TreeControlViewPart  {
  
  private EditorActions editorActions;
  
  private IPartListener2 partListener;
  
  /* (non-Javadoc)
   * @see eu.celar.ui.views.CloudModelViewPart#createPartControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public void createPartControl( final Composite parent ) {
    
    super.createPartControl( parent );
    
    this.partListener = new CloudProjectPartListener( this.editorActions );
    getSite().getPage().addPartListener( this.partListener );   
  }
  
  /* (non-Javadoc)
   * @see eu.celar.ui.views.CloudModelViewPart#dispose()
   */
  @Override
  public void dispose() {
    getSite().getPage().removePartListener( this.partListener );
  }
  
  /* (non-Javadoc)
   * @see eu.celar.ui.views.CloudModelViewPart#isDragSource(eu.celar.core.model.ICloudElement)
   */
  @Override
  public boolean isDragSource( final ICloudElement element ) {
    return super.isDragSource( element );
  }
  
  
  /* (non-Javadoc)
   * @see eu.celar.ui.views.CloudModelViewPart#contributeAdditionalActions(eu.celar.ui.internal.actions.ActionGroupManager)
   */
  @Override
  protected void contributeAdditionalActions( final ActionGroupManager groups ) {
    
    super.contributeAdditionalActions( groups );
    
    IWorkbenchPartSite site = getSite();
    IWorkbenchWindow window = site.getWorkbenchWindow();
    
    NewWizardActions newWizardActions = new NewWizardActions( window );
    groups.addGroup( newWizardActions );
    
    ProjectActions projectActions = new ProjectActions( site );
    groups.addGroup( projectActions );
    
    BuildActions buildActions = new BuildActions( site );
    groups.addGroup( buildActions );
    
    this.editorActions = new EditorActions( this );
    groups.addGroup( this.editorActions );
    
  }

  /* (non-Javadoc)
   * @see eu.celar.ui.views.CloudModelViewPart#createContentProvider()
   */
  @Override
  protected IContentProvider createContentProvider() {
    IContentProvider contentProvider = new CloudModelContentProvider();
    return contentProvider;
  }

  /* (non-Javadoc)
   * @see eu.celar.ui.views.CloudModelViewPart#createLabelProvider()
   */
  @Override
  protected IBaseLabelProvider createLabelProvider() {
    CloudModelLabelProvider provider = new CloudModelLabelProvider();
    ILabelDecorator decorator = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
    DecoratingStyledCellLabelProvider result = new DecoratingStyledCellLabelProvider( provider, decorator, null );
    return result;
  }

  /* (non-Javadoc)
   * @see eu.celar.ui.views.CloudModelViewPart#createViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected StructuredViewer createViewer( final Composite parent ) {
    StructuredViewer sViewer = new TreeViewer( parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL );
    return sViewer;
  }
  
  /* (non-Javadoc)
   * @see eu.celar.ui.views.CloudModelViewPart#getRootElement()
   */
  @Override
  protected ICloudElement getRootElement() {
    ICloudElement rootElement = CloudModel.getRoot();
    return rootElement;
  }
  
}