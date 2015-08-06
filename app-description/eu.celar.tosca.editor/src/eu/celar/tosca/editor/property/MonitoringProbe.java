package eu.celar.tosca.editor.property;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import eu.celar.tosca.TDeploymentArtifact;
import eu.celar.tosca.ToscaFactory;
import eu.celar.tosca.editor.diagram.ToscaFeatureProvider;
import eu.celar.tosca.editor.features.CreateMonitorProbeFeature;

/**
 * @author Nicholas Loulloudes
 */
public class MonitoringProbe {

  private File filename;
  private String probeName;
  private boolean importExistingProbe;
  private IJavaProject monitoringProbeProject;
  private IProject project; 

  /**
   * @param probeName
   * @param importProbe
   */
  public MonitoringProbe( final String probeName, final boolean importProbe ) {
    this.filename = new File( probeName );
    this.probeName = getProbeName(probeName);
    this.importExistingProbe = importProbe;
  }
  
  private String getProbeName( final String probeName ) {
    String name;
    name = probeName.substring( probeName.lastIndexOf( File.separator ) + 1,
                                     probeName.length() );
    return name;
  }

  /**
   * @throws JavaModelException
   * @throws PartInitException
   * @throws IOException
   */
  public void createProbeProject()
    throws JavaModelException, PartInitException, IOException
  {
    // Create java project
    IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
    this.project = workspaceRoot.getProject( "MonitoringProbe" ); //$NON-NLS-1$
    IPackageFragmentRoot root = null;
    try {
      if( !this.project.exists() ) {
        // Create Project
        IProjectDescription description;
        try {
          this.project.create( null );
          this.project.open( null );
          description = this.project.getDescription();
          description.setNatureIds( new String[]{
            JavaCore.NATURE_ID
          } );
          this.project.setDescription( description, null );
        } catch( CoreException e ) {
          e.printStackTrace();
        }
        
        this.monitoringProbeProject = JavaCore.create( this.project );
        
        // Create Bin folder
        if( !this.project.getFolder( "bin" ).exists() ) { //$NON-NLS-1$
          IFolder binFolder = this.project.getFolder( "bin" ); //$NON-NLS-1$
          try {
            binFolder.create( false, true, null );
            this.monitoringProbeProject.setOutputLocation( binFolder.getFullPath(),
                                                      null );
          } catch( CoreException e3 ) {
            e3.printStackTrace();
          }
        }
        
        // Set Libraries in Classpath
        List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
        IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
        LibraryLocation[] locations = JavaRuntime.getLibraryLocations( vmInstall );
        for( LibraryLocation element : locations ) {
          entries.add( JavaCore.newLibraryEntry( element.getSystemLibraryPath(),
                                                 null,
                                                 null ) );
        }
        
        // Add probes.jar
        IPath probeJarPath = new Path( "/home/nickl/Desktop/ProbePack.jar" ); //$NON-NLS-1$
        if( probeJarPath != null && probeJarPath.toFile().exists() ) {
          LibraryLocation probeJarLocation = new LibraryLocation( probeJarPath,
                                                                  Path.EMPTY,
                                                                  Path.EMPTY );
          entries.add( JavaCore.newLibraryEntry( probeJarLocation.getSystemLibraryPath(),
                                                 null,
                                                 null ) );
        }
        
        // add libs to project class path
        try {
          this.monitoringProbeProject.setRawClasspath( entries.toArray( new IClasspathEntry[ entries.size() ] ),
                                                  null );
        } catch( JavaModelException e3 ) {
          e3.printStackTrace();
        }
        
        IFolder sourceFolder = null;
        
        if( !this.project.getFolder( "src" ).exists() ) { //$NON-NLS-1$
          sourceFolder = this.project.getFolder( "src" ); //$NON-NLS-1$
          try {
            sourceFolder.create( false, true, null );
          } catch( CoreException e3 ) {
            e3.printStackTrace();
          }
        }
        
        if( sourceFolder != null ) {
          root = this.monitoringProbeProject.getPackageFragmentRoot( sourceFolder );
        }
        
        IClasspathEntry[] oldEntries = null;
        try {
          oldEntries = this.monitoringProbeProject.getRawClasspath();
        } catch( JavaModelException e3 ) {
          e3.printStackTrace();
        }
        
        IClasspathEntry[] newEntries = new IClasspathEntry[ oldEntries.length + 1 ];
        System.arraycopy( oldEntries, 0, newEntries, 0, oldEntries.length );
        newEntries[ oldEntries.length ] = JavaCore.newSourceEntry( root.getPath() );
        try {
          this.monitoringProbeProject.setRawClasspath( newEntries, null );
        } catch( JavaModelException e3 ) {
          e3.printStackTrace();
        }
        
      } else {
        if( this.project.exists() && this.project.hasNature( JavaCore.NATURE_ID ) ) {
          this.monitoringProbeProject = JavaCore.create( this.project );
          if( this.project.getFolder( "src" ).exists() ) { //$NON-NLS-1$
            root = this.monitoringProbeProject.getPackageFragmentRoot( this.project.getFolder( "src" ) ); //$NON-NLS-1$
          }
        }
      }
    } catch( CoreException e ) {
      e.printStackTrace();
    }
    // try {
    // project.create( null );
    // project.open( null );
    // } catch( CoreException e3 ) {
    // // TODO Auto-generated catch block
    // e3.printStackTrace();
    // }
    // IProjectDescription description;
    // try {
    // description = project.getDescription();
    // description.setNatureIds( new String[]{
    // JavaCore.NATURE_ID
    // } );
    // project.setDescription( description, null );
    // } catch( CoreException e3 ) {
    // // TODO Auto-generated catch block
    // e3.printStackTrace();
    // }
    // IJavaProject javaProject = JavaCore.create( project );
    //      IFolder binFolder = project.getFolder( "bin" ); //$NON-NLS-1$
    // try {
    // binFolder.create( false, true, null );
    // javaProject.setOutputLocation( binFolder.getFullPath(), null );
    // } catch( CoreException e3 ) {
    // // TODO Auto-generated catch block
    // e3.printStackTrace();
    // }
    // List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
    // IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
    // LibraryLocation[] locations = JavaRuntime.getLibraryLocations( vmInstall
    // );
    // for( LibraryLocation element : locations ) {
    // entries.add( JavaCore.newLibraryEntry( element.getSystemLibraryPath(),
    // null,
    // null ) );
    // }
    // // Add probes.jar
    //      IPath probeJarPath = new Path( "C:\\Users\\stalo.cs8526\\Desktop\\ProbePack.jar" ); //$NON-NLS-1$
    // LibraryLocation probeJarLocation = new LibraryLocation( probeJarPath,
    // Path.EMPTY,
    // Path.EMPTY );
    // entries.add( JavaCore.newLibraryEntry(
    // probeJarLocation.getSystemLibraryPath(),
    // null,
    // null ) );
    // // add libs to project class path
    // try {
    // javaProject.setRawClasspath( entries.toArray( new IClasspathEntry[
    // entries.size() ] ),
    // null );
    // } catch( JavaModelException e3 ) {
    // // TODO Auto-generated catch block
    // e3.printStackTrace();
    // }
    //      IFolder sourceFolder = project.getFolder( "src" ); //$NON-NLS-1$
    // try {
    // sourceFolder.create( false, true, null );
    // } catch( CoreException e3 ) {
    // e3.printStackTrace();
    // }
    //
    // IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(
    // sourceFolder );
    //
    // IClasspathEntry[] oldEntries = null;
    // try {
    // oldEntries = javaProject.getRawClasspath();
    // } catch( JavaModelException e3 ) {
    // // TODO Auto-generated catch block
    // e3.printStackTrace();
    // }
    // IClasspathEntry[] newEntries = new IClasspathEntry[ oldEntries.length + 1
    // ];
    // System.arraycopy( oldEntries, 0, newEntries, 0, oldEntries.length );
    // newEntries[ oldEntries.length ] = JavaCore.newSourceEntry( root.getPath()
    // );
    // try {
    // javaProject.setRawClasspath( newEntries, null );
    // } catch( JavaModelException e3 ) {
    // // TODO Auto-generated catch block
    // e3.printStackTrace();
    // }
    if( root != null ) {
      createProbeClass( root );
    }
  }
  
  private ICompilationUnit probeTemplate( final IPackageFragmentRoot root,
                                          final ICompilationUnit icu,
                                          final String className )
  {
    ICompilationUnit icuNew = icu;
    String source = "public class " + className + " extends Probe{} "; //$NON-NLS-1$ //$NON-NLS-2$
    StringBuffer buffer = new StringBuffer();
    buffer.append( source );
    try {
      icuNew = root.getPackageFragment( "" ) //$NON-NLS-1$
        .createCompilationUnit( className + ".java", //$NON-NLS-1$
                                buffer.toString(),
                                false,
                                null );
    } catch( JavaModelException e3 ) {
      e3.printStackTrace();
    }
    try {
      icuNew.createImport( "java.util.HashMap", null, null ); //$NON-NLS-1$
      icuNew.createImport( "eu.celarcloud.jcatascopia.probepack.Probe", null, null ); //$NON-NLS-1$
      icuNew.createImport( "eu.celarcloud.jcatascopia.probepack.ProbeMetric", //$NON-NLS-1$
                        null,
                        null );
      icuNew.createImport( "eu.celarcloud.jcatascopia.probepack.ProbePropertyType", //$NON-NLS-1$
                        null,
                        null );
      IType probeType = icuNew.getAllTypes()[ 0 ];
      probeType.createField( "private static int DEFAULT_SAMPLING_PERIOD = 20;", //$NON-NLS-1$
                             null,
                             false,
                             null );
      probeType.createField( "private static String DEFAULT_PROBE_NAME = " //$NON-NLS-1$
                             + "\"" //$NON-NLS-1$
                             + className
                             + "\"" //$NON-NLS-1$
                             + ";", null, false, null ); //$NON-NLS-1$
      String constructorComments = "\n" //$NON-NLS-1$
                                   + "/* define metrics that will be collected as ProbeProperties." //$NON-NLS-1$
                                   + "\n" //$NON-NLS-1$
                                   + " * addProbeProperty (int id, String name, ProbePropertyType type,String units, String description)" //$NON-NLS-1$
                                   + "\n" //$NON-NLS-1$
                                   + " * e.g. addProbeProperty(0,\"cpuUsage\",ProbePropertyType.DOUBLE,\"%\",\"Current system cpu usage\");" //$NON-NLS-1$
                                   + "\n" //$NON-NLS-1$
                                   + "*/"; //$NON-NLS-1$
      probeType.createMethod( "public " + className + "(String name, int freq) {super(name, freq);" //$NON-NLS-1$ //$NON-NLS-2$
                                  + constructorComments
                                  + "\n" //$NON-NLS-1$
                                  + "}", //$NON-NLS-1$
                              null,
                              false,
                              null );
      probeType.createMethod( "public " + className + "() {this(DEFAULT_PROBE_NAME, DEFAULT_SAMPLING_PERIOD);}", //$NON-NLS-1$ //$NON-NLS-2$
                              null,
                              false,
                              null );
      probeType.createMethod( "@Override public ProbeMetric collect() { HashMap<Integer,Object> values = new HashMap<Integer,Object>();" //$NON-NLS-1$
                                  + "/* add to HashMap the values for each defined metric e.g. values.put(0,71.32) */" //$NON-NLS-1$
                                  + "return new ProbeMetric(values);}", //$NON-NLS-1$
                              null,
                              false,
                              null );
      probeType.createMethod( "@Override public String getDescription() {return \"Probe description\";}", //$NON-NLS-1$
                              null,
                              false,
                              null );
      probeType.createMethod( "public static void main(String[] args) { " + className + " p = new " + className + "(); p.activate();}", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                              null,
                              false,
                              null );
    } catch( JavaModelException e2 ) {
      e2.printStackTrace();
    }
    try {
      formatCode( icuNew );
    } catch( PartInitException e ) {
      e.printStackTrace();
    } catch( JavaModelException e ) {
      e.printStackTrace();
    }
    return icuNew;
  }
  
  private final String readProbeFile (final String filename) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader(filename));
    String content;
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        content = sb.toString();
    } finally {
        br.close();
    }
    
    return content;
  }
  
  private ICompilationUnit importProbe( final IPackageFragmentRoot root,
                                       final ICompilationUnit icu,
                                       final String className )
  {
    ICompilationUnit icuNew = icu;
    String content = "";
    if (this.filename.exists())
    {
      try {
        content = readProbeFile( this.filename.getAbsolutePath() );
      } catch( IOException e ) {
        e.printStackTrace();
      }
    }
    
    try {
      icuNew = root.getPackageFragment( "" ) //$NON-NLS-1$
        .createCompilationUnit( className + ".java", //$NON-NLS-1$
                                content,
                                false,
                                null );
    } catch( JavaModelException e3 ) {
      e3.printStackTrace();
    }
   
    try {
      formatCode( icuNew );
    } catch( PartInitException e ) {
      e.printStackTrace();
    } catch( JavaModelException e ) {
      e.printStackTrace();
    }
    return icuNew;
  }

  private void createProbeClass( final IPackageFragmentRoot root ) {
    String className;
    
    if( this.probeName.endsWith( ".java" ) ) { //$NON-NLS-1$
      className = this.probeName.substring( 0, this.probeName.lastIndexOf( '.' ) );
    } else {
      className = this.probeName;
    }
    // Make sure the first letter of the class name is Upper case.
    className = Character.toUpperCase( className.charAt( 0 ) )
                + ( className.length() > 1
                                          ? className.substring( 1 )
                                          : "" ); //$NON-NLS-1$
    ICompilationUnit icu = null;
    // Check if probe name is already used
    ICompilationUnit[] compilationUnits = null;
    try {
      compilationUnits = root.getPackageFragment( "" ).getCompilationUnits(); //$NON-NLS-1$
    } catch( JavaModelException e4 ) {
      // TODO Auto-generated catch block
      e4.printStackTrace();
    }
    boolean exists = false;
    for( ICompilationUnit cu : compilationUnits ) {
      if( cu.getElementName().equals( className ) ) {
        icu = root.getPackageFragment( "" ).getCompilationUnit( className ); //$NON-NLS-1$
        exists = true;
        break;
      }
    }
    if( exists ) {
      IFile probeFile = ( IFile )icu.getResource();
      IWorkbenchPage page = PlatformUI.getWorkbench()
        .getActiveWorkbenchWindow()
        .getActivePage();
      IEditorDescriptor desc = PlatformUI.getWorkbench()
        .getEditorRegistry()
        .getDefaultEditor( probeFile.getName() );
      try {
        page.openEditor( new FileEditorInput( probeFile ), desc.getId() );
      } catch( PartInitException e1 ) {
        e1.printStackTrace();
      }
      return;
    }

    if (this.importExistingProbe == false) {
      icu = probeTemplate( root, icu, className );
    } else {
      icu = importProbe ( root, icu, className );
    }
    
    IFile probeFile = ( IFile )icu.getResource();
    IWorkbenchPage page = PlatformUI.getWorkbench()
      .getActiveWorkbenchWindow()
      .getActivePage();
    IEditorDescriptor desc = PlatformUI.getWorkbench()
      .getEditorRegistry()
      .getDefaultEditor( probeFile.getName() );
    try {
      page.openEditor( new FileEditorInput( probeFile ), desc.getId() );
    } catch( PartInitException e1 ) {
      e1.printStackTrace();
    }
  }

  void formatCode( final ICompilationUnit unit )
    throws JavaModelException, PartInitException
  {
    // Create working copy of the ICompilationUnit
    unit.becomeWorkingCopy( null );
    // Format
    // take default Eclipse formatting options
    Map<String, String> options = DefaultCodeFormatterConstants.getEclipseDefaultSettings();
    // initialize the compiler settings to be able to format 1.5 code
    options.put( JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_6 );
    options.put( JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM,
                 JavaCore.VERSION_1_6 );
    options.put( JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_6 );
    CodeFormatter formatter = ToolFactory.createCodeFormatter( options );
    ISourceRange range = unit.getSourceRange();
    TextEdit formatEdit = formatter.format( CodeFormatter.K_COMPILATION_UNIT,
                                            unit.getSource(),
                                            range.getOffset(),
                                            range.getLength(),
                                            0,
                                            null );
    if( formatEdit != null && formatEdit.hasChildren() ) {
      unit.applyTextEdit( formatEdit, null );
    } else {
      // monitor.done();
    }
    unit.commitWorkingCopy( true, null );
    // JavaUI.openInEditor(unit);
  }

  //
  // public void addProbeToCloudProject( String probeName, IProject cloudProject
  // ){
  //
  // // Add a file for the newly created probe to Monitoring folder
  //
  // IProject project = cloudProject;
  //
  // String targetPath = Platform.getLocation() + "/" + project.getName() +
  // "/Monitoring/" + probeName;
  // File tmp = new File( targetPath );
  // try {
  // tmp.createNewFile();
  // } catch( IOException e1 ) {
  // // TODO Auto-generated catch block
  // e1.printStackTrace();
  // }
  //
  // IProgressMonitor monitor = null;
  // try {
  // CloudModel.getRoot().refresh( monitor );
  // } catch( ProblemException e2 ) {
  // e2.printStackTrace();
  // }
  // }
  public void addProbeToMonitoringTable( String probeName,
                                         ContainerShape pictogramElement,
                                         IDiagramTypeProvider diagramTypeProvider )
  {
    CreateMonitorProbeFeature createMonitoringProbeFeature = new CreateMonitorProbeFeature( new ToscaFeatureProvider( diagramTypeProvider ) );
    TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
    deploymentArtifact.setName( probeName );
    deploymentArtifact.setArtifactType( new QName( "MonitoringProbe" ) ); //$NON-NLS-1$
    createMonitoringProbeFeature.setContextObject( deploymentArtifact );
    CreateContext createContext = new CreateContext();
    createContext.setTargetContainer( pictogramElement );
    if( createMonitoringProbeFeature.canCreate( createContext ) )
      createMonitoringProbeFeature.create( createContext );
  }
}
