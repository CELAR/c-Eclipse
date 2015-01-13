package eu.celar.ui.internal.preference;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import eu.celar.core.Preferences;
import eu.celar.core.model.CloudModel;
import eu.celar.core.model.ICloudElement;
import eu.celar.core.model.ICloudModelEvent;
import eu.celar.core.model.ICloudModelListener;
import eu.celar.core.model.ICloudProject;
import eu.celar.core.model.ICloudProvider;
import eu.celar.core.model.ICloudProviderManager;
import eu.celar.core.model.impl.GenericCloudProvider;
import eu.celar.core.model.impl.GenericCloudProviderCreator;
import eu.celar.core.reporting.ProblemException;
import eu.celar.ui.comparators.TableColumnComparator;
import eu.celar.ui.dialogs.ProblemDialog;
import eu.celar.ui.internal.Activator;
import eu.celar.ui.listeners.TableColumnListener;
import eu.celar.ui.wizards.GenericCloudProviderWizard;
import eu.celar.ui.wizards.wizardselection.ExtPointWizardSelectionListPage;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * The VO preferences page which allows add, remove and edit the available VOs.
 */
public class CloudProviderPreferencePage
    extends PreferencePage
    implements IWorkbenchPreferencePage, ICloudModelListener {
  
  /**
   * Content provider for the {@link CloudProviderPreferencePage}.
   */
  static class VoContentProvider
      implements IStructuredContentProvider {
    
    /**
     * The shell of the input.
     */
    private Shell shell;

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements( final Object inputElement ) {
      
      return Preferences.getDefinedCloudProviders();
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    public void dispose() {
      // empty implementation
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
    public void inputChanged( final Viewer viewer,
                              final Object oldInput,
                              final Object newInput ) {
      if ( viewer != null ) {
        this.shell = viewer.getControl().getShell();
      }
    }
    
  }
  
  /**
   * Label provider for the {@link CloudProviderPreferencePage}.
   */
  static class VoLabelProvider
      extends LabelProvider
      implements ITableLabelProvider {

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
     */
    public Image getColumnImage( final Object element, final int columnIndex ) {
      return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
     */
    public String getColumnText( final Object element,
                                 final int columnIndex ) {
      String text = null;
      if ( element instanceof ICloudProvider ) {
        switch ( columnIndex ) {
          case 0:
            text = ( ( ICloudProvider ) element ).getName();
            break;
          case 1:
            text = ( ( ICloudProvider ) element ).getTypeName();
            break;
        }
      }
      return text;
    }
    
  }

  /**
   * The table viewer used to display the VOs.
   *   Package visibility to avoid warning about synthetic accessor
   *   performance issue.
   */
  TableViewer cpViewer;
  
  /**
   * The button that triggers the creation of a new VO.
   */
  private Button addButton;
  
  /**
   * The button that triggers the deletion of an existing VO.
   */
  private Button removeButton;
  
  /**
   * The button that triggers the editing of an existing VO.
   */
  private Button editButton;
  
  /**
   * Standard constructor for the VO preference page.
   */
  public CloudProviderPreferencePage() {
    super();
    setDescription( Messages.getString("CloudProviderPreferencePage.description") ); //$NON-NLS-1$
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.dialogs.DialogPage#dispose()
   */
  @Override
  public void dispose() {
    CloudModel.getCloudProviderManager().removeCloudModelListener( this );
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
   */
  public void init( final IWorkbench workbench ) {
    setPreferenceStore( Activator.getDefault().getPreferenceStore() );
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createContents( final Composite parent ) {
    
    initializeDialogUnits( parent );
    noDefaultAndApplyButton();
    
    GridData gData;
    GridLayout layout= new GridLayout( 2, false );
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    parent.setLayout( layout );
    
    Label voLabel = new Label( parent, SWT.NONE );
    voLabel.setText( Messages.getString("CloudProviderPreferencePage.vo_list_label") ); //$NON-NLS-1$
    gData = new GridData();
    gData.horizontalSpan = 2;
    gData.grabExcessHorizontalSpace = true;
    voLabel.setLayoutData( gData );
    
    Table voTable = new Table( parent, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION );
    voTable.setHeaderVisible( true );
    voTable.setLinesVisible( true );
    gData = new GridData( GridData.FILL_BOTH );
    gData.horizontalSpan = 1;
    gData.grabExcessHorizontalSpace = true;
    gData.grabExcessVerticalSpace = true;
    gData.widthHint = 200;
    gData.heightHint = 100;
    voTable.setLayoutData( gData );
    voTable.addMouseListener( new MouseAdapter() {
      @Override
      public void mouseDoubleClick( final MouseEvent e ) {
        ICloudProvider selectedVo = getSelectedVo();
        if ( selectedVo != null ) {
          editVO( selectedVo );
        }
      }
    } );
    voTable.addKeyListener( new KeyAdapter() {
      @Override
      public void keyPressed( final KeyEvent event ) {
        if (event.character == SWT.DEL && event.stateMask == 0) {
          removeSelectedVOs();
        }
      }
    }); 
    
    TableColumn nameColumn = new TableColumn( voTable, SWT.LEFT );
    nameColumn.setText( Messages.getString("CloudProviderPreferencePage.name_column_text") ); //$NON-NLS-1$
    nameColumn.setWidth( 100 );
    TableColumn typeColumn = new TableColumn( voTable, SWT.CENTER );
    typeColumn.setText( Messages.getString("CloudProviderPreferencePage.type_column_text") ); //$NON-NLS-1$
    typeColumn.setWidth( 100 );
    
    final ICloudProviderManager manager = CloudModel.getCloudProviderManager();
    this.cpViewer = new TableViewer( voTable );
    this.cpViewer.setLabelProvider( new VoLabelProvider() );
    this.cpViewer.setContentProvider( new VoContentProvider() );
    
    TableColumnListener columnListener = new TableColumnListener( this.cpViewer );
    nameColumn.addSelectionListener( columnListener );
    typeColumn.addSelectionListener( columnListener );
    
    // Initially we sort the VOs by name, ascending
    voTable.setSortColumn( nameColumn );
    voTable.setSortDirection( SWT.UP );
    this.cpViewer.setComparator( new TableColumnComparator( nameColumn ) );
    
    this.cpViewer.setInput( manager );
    this.cpViewer.addSelectionChangedListener( new ISelectionChangedListener() {
      public void selectionChanged( final SelectionChangedEvent event ) {
        updateButtons();
      }
    } );
    manager.addCloudModelListener( this );
    
    Composite buttons = new Composite( parent, SWT.NULL );
    gData = new GridData( GridData.VERTICAL_ALIGN_BEGINNING );
    gData.horizontalSpan = 1;
    buttons.setLayoutData( gData );
    GridLayout gLayout = new GridLayout( 1, false );
    gLayout.marginHeight = 0;
    gLayout.marginWidth = 0;
    buttons.setLayout( gLayout );
    
    this.addButton = new Button( buttons, SWT.PUSH );
    this.addButton.setText( Messages.getString("CloudProviderPreferencePage.add_button") ); //$NON-NLS-1$
    gData = new GridData( GridData.FILL_HORIZONTAL );
    this.addButton.setLayoutData( gData );
    this.editButton = new Button( buttons, SWT.PUSH );
    this.editButton.setText( Messages.getString("CloudProviderPreferencePage.edit_button") ); //$NON-NLS-1$
    gData = new GridData( GridData.FILL_HORIZONTAL );
    this.editButton.setLayoutData( gData );
    this.removeButton = new Button( buttons, SWT.PUSH );
    this.removeButton.setText( Messages.getString("CloudProviderPreferencePage.remove_button") ); //$NON-NLS-1$
    gData = new GridData( GridData.FILL_HORIZONTAL );
    this.removeButton.setLayoutData( gData );
    
    Label separator = new Label(buttons, SWT.NONE);
    separator.setVisible(false);
    gData = new GridData();
    gData.horizontalAlignment= GridData.FILL;
    gData.heightHint= 4;
    separator.setLayoutData(gData);
    
    this.addButton.addSelectionListener( new SelectionAdapter() {
      @Override
      public void widgetSelected( final SelectionEvent e ) {
        editVO( null );
      }
    } );
    this.editButton.addSelectionListener( new SelectionAdapter() {
      @Override
      public void widgetSelected( final SelectionEvent e ) {
        ICloudProvider selectedVo = getSelectedVo();
        if ( selectedVo != null ) {
          editVO( selectedVo );
        }
      }
    } );
    this.removeButton.addSelectionListener( new SelectionAdapter() {
      @Override
      public void widgetSelected( final SelectionEvent e ) {
        removeSelectedVOs();
      }
    } );
    
    updateButtons();
    
    return parent;

  }
  
  /**
   * Get the currently selected VO.
   * 
   * @return The VO that is currently selected in the table control.
   */
  public ICloudProvider getSelectedVo() {
    ICloudProvider selectedVo = null;
    IStructuredSelection selection
      = ( IStructuredSelection ) this.cpViewer.getSelection();
    Object obj = selection.getFirstElement();
    if ( obj instanceof  ICloudProvider ) {
      selectedVo = ( ICloudProvider ) obj;
    }
    return selectedVo;
  }
  
  /**
   * Get the currently selected VOs.
   * 
   * @return The VOs that are currently selected in the table control.
   */
  public List< ICloudProvider > getSelectedVos() {
    IStructuredSelection selection 
      = ( IStructuredSelection ) this.cpViewer.getSelection();
    List< ? > selectionList = selection.toList();
    List< ICloudProvider > result = new ArrayList< ICloudProvider >();
    for ( Object element : selectionList ) {
      if ( element instanceof ICloudProvider ) {
        ICloudProvider vo = ( ICloudProvider ) element;
        result.add( vo );
      }
    }
    return result;
  }
  
  /**
   * Trigger the new VO wizard to pop up in order to create a new VO if vo
   * parameter is null or edit existing vo if vo parameter is specified.
   * 
   * @param cp To {@link ICloudProvider} to be edited. 
   */
  protected void editVO( final ICloudProvider cp ) {
    URL imgUrl = Activator.getDefault().getBundle().getEntry( "icons/wizban/vo_wiz.gif" ); //$NON-NLS-1$
    Wizard wizard = new Wizard() {
      @Override
      public void addPages() {
        ExtPointWizardSelectionListPage page = new ExtPointWizardSelectionListPage(
            "pagename", //$NON-NLS-1$
            "eu.celar.ui.newCloudProviderWizards", //$NON-NLS-1$
            Messages.getString("CloudProviderPreferencePage.create_new_vo"), //$NON-NLS-1$
            Messages.getString("CloudProviderPreferencePage.create_new_vo_long"), //$NON-NLS-1$
            Messages.getString("CloudProviderPreferencePage.no_vo_providers") ); //$NON-NLS-1$
        page.setInitData( cp );
        if ( cp != null ) {
          page.setPreselectedId( cp.getWizardId(), true );
        }
        addPage( page );
      }
      
      @Override
      public boolean performFinish() {
        return false;
      }
    };
    wizard.setForcePreviousAndNextButtons( true );
    wizard.setNeedsProgressMonitor( true );
    wizard.setWindowTitle( Messages.getString("CloudProviderPreferencePage.create_new_vo") ); //$NON-NLS-1$
    wizard.setDefaultPageImageDescriptor( ImageDescriptor.createFromURL( imgUrl ) );
    WizardDialog dialog = new WizardDialog( this.getShell(), wizard );
    dialog.open();
    
   
    GenericCloudProvider newGenericCloudProvider = GenericCloudProviderWizard.getNewCloudProvider();
    if (newGenericCloudProvider != null){
      Preferences.addCloudProvider( newGenericCloudProvider );
    }
    
    /*
     * If no VOs were present before calling the wizard, there is now a default
     * VO to mark as checked.
     */
    //checkDefaultVo();
  
  }
  
  /**
   * Remove all VOs that are currently selected in the table control.
   */
  protected void removeSelectedVOs() {
    
    List< ICloudProvider > vos = getSelectedVos();
    
    if ( ! vos.isEmpty() ) {
      boolean confirm = MessageDialog.openConfirm( getShell(),
                                                   Messages.getString("CloudProviderPreferencePage.delete_vos"), //$NON-NLS-1$
                                                   Messages.getString("CloudProviderPreferencePage.really_delete_vos") ); //$NON-NLS-1$
      if ( confirm ) {
        ICloudElement[] projectElements = {};
        
        // Collect a list of children of the CloudRoot
        try {
          projectElements = CloudModel.getRoot().getChildren( null );
        } catch ( ProblemException pExc ) {
          // CloudRoot is not a lazy container
        }
        
        ICloudProviderManager manager = CloudModel.getCloudProviderManager();
        ICloudProject igp = null;
        
        for ( ICloudProvider vo : vos ) {
          
          Preferences.removeCloudProvider( vo );
          
          try {
          manager.delete( vo );
        } catch ( ProblemException pExc ) {
          ProblemDialog.openProblem( this.getShell(),
                                     Messages.getString("CloudProviderPreferencePage.error"), //$NON-NLS-1$
                                     Messages.getString("CloudProviderPreferencePage.delete_vo_failed") //$NON-NLS-1$
                                       + " " + vo.getName(), //$NON-NLS-1$
                                     pExc );
        }
          
//          // Check if the given VO is used by some CloudProject on the WS
//          boolean used = false;
//          for ( ICloudElement element : projectElements ) {
//            igp = ( ICloudProject ) element;
//            
//            // Projects have a ProjectVO wrapper, not the real VO
//            ICloudProvider realCp = null;
//            ICloudProvider projectCp = igp.getCloudProvider();
//            // HiddenProject doesn't have a VO
//            if ( projectCp != null ) {
//              realCp = ( ICloudProvider ) projectCp.getAdapter( ICloudProvider.class );
//              if ( ( realCp != null ) && ( vo == realCp ) ) {
//                used = true;
//                break;
//              }
//            }
//          }
//          
//          if ( used ) {
//            MessageDialog.openError( this.getShell(),
//                                     Messages.getString("CloudProviderPreferencePage.error"), //$NON-NLS-1$
//                                     String.format( Messages.getString("CloudProviderPreferencePage.vo_in_use"), //$NON-NLS-1$
//                                                    vo.getName(),
//                                                    igp.getName() ) );
//          } else {
//            try {
//              manager.delete( vo );
//            } catch ( ProblemException pExc ) {
//              ProblemDialog.openProblem( this.getShell(),
//                                         Messages.getString("CloudProviderPreferencePage.error"), //$NON-NLS-1$
//                                         Messages.getString("CloudProviderPreferencePage.delete_vo_failed") //$NON-NLS-1$
//                                           + " " + vo.getName(), //$NON-NLS-1$
//                                         pExc );
//            }
//          }
        }
        
        updateButtons();
      }
    }
  }
  
  
  /**
   * Update the enabled state of the button controls.
   */
  protected void updateButtons() {
    
    ISelection selection = this.cpViewer.getSelection();
    boolean selectionAvailable = !selection.isEmpty();
    
    this.addButton.setEnabled( true );
    this.removeButton.setEnabled( selectionAvailable );
    this.editButton.setEnabled( selectionAvailable );
    
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.compare.IContentChangeListener#contentChanged(org.eclipse.compare.IContentChangeNotifier)
   */
  public void modelChanged( final ICloudModelEvent source ) {
    this.cpViewer.refresh();
    updateButtons();
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.preference.PreferencePage#performOk()
   */
  @Override
  public boolean performOk() {
    try {
      CloudModel.getCloudProviderManager().serializeElements();
    } catch ( ProblemException pExc ) {
      // TODO mathias
      Activator.logException( pExc );
    }
    return super.performOk();
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
   */
  @Override
  protected void performDefaults() {
    try {
      CloudModel.getCloudProviderManager().deserializeElements();
    } catch ( ProblemException pExc ) {
      // TODO mathias
      Activator.logException( pExc );
    }
    super.performDefaults();
  }
  
}
