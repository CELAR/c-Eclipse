package eu.celar.ui.internal.preference;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import eu.celar.ui.internal.Activator;


/**
 * This class represents a preference page that is contributed to the
 * PreferenceConstants dialog. By subclassing <samp>FieldEditorPreferencePage</samp>,
 * we can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */
public class CEclipsePreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

  /**
   * Construct a new <code>GEclipsePreferencePage</code>.
   */
  public CEclipsePreferencePage() {
    super();
    IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
    setPreferenceStore( Activator.getDefault().getPreferenceStore() );
    // setDescription("A demonstration of a preference page implementation");
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createContents( final Composite parent ) {
    
    initializeDialogUnits( parent );
    noDefaultAndApplyButton();
    Display display = Display.getCurrent();
    
    GridData gData;
    GridLayout layout;
    
    layout = new GridLayout( 2, false );
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    parent.setLayout( layout );
    
    Composite imgComp = new Composite( parent, SWT.NONE );
    layout = new GridLayout( 1, false );
    layout.marginTop = 8;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    imgComp.setLayout( layout );
    imgComp.setBackground( new Color( display, 255, 255, 255 ) );
    gData = new GridData( GridData.FILL_VERTICAL );
    gData.grabExcessVerticalSpace = true;
    imgComp.setLayoutData( gData );

    ImageRegistry imgReg = Activator.getDefault().getImageRegistry();
    Image logo = imgReg.get( "geclipse_logo_prefs" ); //$NON-NLS-1$
    Label logoLabel = new Label( imgComp, SWT.TOP );
    logoLabel.setImage( logo );
    logoLabel.setBackground( new Color( display, 255, 255, 255 ) );
    gData = new GridData();
    gData.horizontalAlignment = GridData.CENTER;
    gData.verticalAlignment = GridData.BEGINNING;
    logoLabel.setLayoutData( gData );
    
    Composite infoComp = new Composite( parent, SWT.NONE );
    gData = new GridData( GridData.FILL_BOTH );
    gData.grabExcessHorizontalSpace = true;
    gData.grabExcessVerticalSpace = true;
    infoComp.setLayoutData( gData );
    
    layout = new GridLayout( 1, false );
    infoComp.setLayout( layout );
    
    Label infoLabel1 = new Label( infoComp, SWT.LEFT );
    infoLabel1.setText( "These are the preferences for the c-Eclipse plugin" ); //$NON-NLS-1$
    infoLabel1.setFont( new Font( display, "Arial", 10, SWT.BOLD ) ); //$NON-NLS-1$
    gData = new GridData();
    gData.verticalAlignment = GridData.BEGINNING;
    gData.verticalIndent = 24;
    infoLabel1.setLayoutData( gData );
    
    Label infoLabel2 = new Label( infoComp, SWT.LEFT );
    infoLabel2.setText( "To change specific preferences of c-Eclipse\nchoose from the tree on the left." ); //$NON-NLS-1$
    gData = new GridData( GridData.FILL_VERTICAL );
    gData.verticalAlignment = GridData.BEGINNING;
    gData.verticalIndent = 12;
    gData.grabExcessVerticalSpace = true;
    infoLabel2.setLayoutData( gData );
    
    Link geclLink = new Link( infoComp, SWT.LEFT );
    geclLink.setText( "Find us at <a href=\"http://www.celarcloud.eu\">www.celarcloud.eu</a>." ); //$NON-NLS-1$
    gData = new GridData();
    gData.verticalAlignment = GridData.END;
    gData.verticalIndent = 12;
    geclLink.setLayoutData( gData );
    geclLink.addSelectionListener( new SelectionAdapter() {
      @Override
      public void widgetSelected( final SelectionEvent e ) {
        String href = e.text;
        Program.launch( href );
      }
    } );

    return parent;
    
  }

  /* (non-Javadoc)
   * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
   */
  public void init( final IWorkbench workbench ) {
    // Nothing to do here
  }

}