/**
 */
package eu.celar.tosca.hrequirements.impl;

import eu.celar.tosca.ToscaPackage;

import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

import eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl;

import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

import eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl;

import eu.celar.tosca.hrequirements.DocumentRoot;
import eu.celar.tosca.hrequirements.TCPURequirementProperties;
import eu.celar.tosca.hrequirements.TMemoryRequirementProperties;
import eu.celar.tosca.hrequirements.TNetworkRequirementProperties;
import eu.celar.tosca.hrequirements.TStorageRequirementProperties;
import eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsFactory;
import eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Tosca_HRequirements_ExtensionsPackageImpl extends EPackageImpl implements Tosca_HRequirements_ExtensionsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass documentRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tcpuRequirementPropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tMemoryRequirementPropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tNetworkRequirementPropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tStorageRequirementPropertiesEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Tosca_HRequirements_ExtensionsPackageImpl()
  {
    super(eNS_URI, Tosca_HRequirements_ExtensionsFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link Tosca_HRequirements_ExtensionsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Tosca_HRequirements_ExtensionsPackage init()
  {
    if (isInited) return (Tosca_HRequirements_ExtensionsPackage)EPackage.Registry.INSTANCE.getEPackage(Tosca_HRequirements_ExtensionsPackage.eNS_URI);

    // Obtain or create and register package
    Tosca_HRequirements_ExtensionsPackageImpl theTosca_HRequirements_ExtensionsPackage = (Tosca_HRequirements_ExtensionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Tosca_HRequirements_ExtensionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Tosca_HRequirements_ExtensionsPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    ToscaPackage.eINSTANCE.eClass();
    XMLTypePackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    Tosca_EPolicy_ExtensionsPackageImpl theTosca_EPolicy_ExtensionsPackage = (Tosca_EPolicy_ExtensionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Tosca_EPolicy_ExtensionsPackage.eNS_URI) instanceof Tosca_EPolicy_ExtensionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Tosca_EPolicy_ExtensionsPackage.eNS_URI) : Tosca_EPolicy_ExtensionsPackage.eINSTANCE);
    Tosca_Elasticity_ExtensionsPackageImpl theTosca_Elasticity_ExtensionsPackage = (Tosca_Elasticity_ExtensionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Tosca_Elasticity_ExtensionsPackage.eNS_URI) instanceof Tosca_Elasticity_ExtensionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Tosca_Elasticity_ExtensionsPackage.eNS_URI) : Tosca_Elasticity_ExtensionsPackage.eINSTANCE);

    // Create package meta-data objects
    theTosca_HRequirements_ExtensionsPackage.createPackageContents();
    theTosca_EPolicy_ExtensionsPackage.createPackageContents();
    theTosca_Elasticity_ExtensionsPackage.createPackageContents();

    // Initialize created meta-data
    theTosca_HRequirements_ExtensionsPackage.initializePackageContents();
    theTosca_EPolicy_ExtensionsPackage.initializePackageContents();
    theTosca_Elasticity_ExtensionsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTosca_HRequirements_ExtensionsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Tosca_HRequirements_ExtensionsPackage.eNS_URI, theTosca_HRequirements_ExtensionsPackage);
    return theTosca_HRequirements_ExtensionsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDocumentRoot()
  {
    return documentRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDocumentRoot_Mixed()
  {
    return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_XMLNSPrefixMap()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_XSISchemaLocation()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_CPURequirementProperties()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_MemoryRequirementProperties()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_NetworkRequirementProperties()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_StorageRequiremetProperties()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTCPURequirementProperties()
  {
    return tcpuRequirementPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTCPURequirementProperties_NumCPUs()
  {
    return (EAttribute)tcpuRequirementPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTMemoryRequirementProperties()
  {
    return tMemoryRequirementPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTMemoryRequirementProperties_Memory()
  {
    return (EAttribute)tMemoryRequirementPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTNetworkRequirementProperties()
  {
    return tNetworkRequirementPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTNetworkRequirementProperties_Network()
  {
    return (EAttribute)tNetworkRequirementPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTNetworkRequirementProperties_Unit()
  {
    return (EAttribute)tNetworkRequirementPropertiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTStorageRequirementProperties()
  {
    return tStorageRequirementPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTStorageRequirementProperties_DiskSpace()
  {
    return (EAttribute)tStorageRequirementPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTStorageRequirementProperties_Unit()
  {
    return (EAttribute)tStorageRequirementPropertiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_HRequirements_ExtensionsFactory getTosca_HRequirements_ExtensionsFactory()
  {
    return (Tosca_HRequirements_ExtensionsFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    documentRootEClass = createEClass(DOCUMENT_ROOT);
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    createEReference(documentRootEClass, DOCUMENT_ROOT__CPU_REQUIREMENT_PROPERTIES);
    createEReference(documentRootEClass, DOCUMENT_ROOT__MEMORY_REQUIREMENT_PROPERTIES);
    createEReference(documentRootEClass, DOCUMENT_ROOT__NETWORK_REQUIREMENT_PROPERTIES);
    createEReference(documentRootEClass, DOCUMENT_ROOT__STORAGE_REQUIREMET_PROPERTIES);

    tcpuRequirementPropertiesEClass = createEClass(TCPU_REQUIREMENT_PROPERTIES);
    createEAttribute(tcpuRequirementPropertiesEClass, TCPU_REQUIREMENT_PROPERTIES__NUM_CP_US);

    tMemoryRequirementPropertiesEClass = createEClass(TMEMORY_REQUIREMENT_PROPERTIES);
    createEAttribute(tMemoryRequirementPropertiesEClass, TMEMORY_REQUIREMENT_PROPERTIES__MEMORY);

    tNetworkRequirementPropertiesEClass = createEClass(TNETWORK_REQUIREMENT_PROPERTIES);
    createEAttribute(tNetworkRequirementPropertiesEClass, TNETWORK_REQUIREMENT_PROPERTIES__NETWORK);
    createEAttribute(tNetworkRequirementPropertiesEClass, TNETWORK_REQUIREMENT_PROPERTIES__UNIT);

    tStorageRequirementPropertiesEClass = createEClass(TSTORAGE_REQUIREMENT_PROPERTIES);
    createEAttribute(tStorageRequirementPropertiesEClass, TSTORAGE_REQUIREMENT_PROPERTIES__DISK_SPACE);
    createEAttribute(tStorageRequirementPropertiesEClass, TSTORAGE_REQUIREMENT_PROPERTIES__UNIT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_CPURequirementProperties(), this.getTCPURequirementProperties(), null, "cPURequirementProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_MemoryRequirementProperties(), this.getTMemoryRequirementProperties(), null, "memoryRequirementProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_NetworkRequirementProperties(), this.getTNetworkRequirementProperties(), null, "networkRequirementProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_StorageRequiremetProperties(), this.getTStorageRequirementProperties(), null, "storageRequiremetProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    initEClass(tcpuRequirementPropertiesEClass, TCPURequirementProperties.class, "TCPURequirementProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTCPURequirementProperties_NumCPUs(), theXMLTypePackage.getInt(), "numCPUs", null, 1, 1, TCPURequirementProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tMemoryRequirementPropertiesEClass, TMemoryRequirementProperties.class, "TMemoryRequirementProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTMemoryRequirementProperties_Memory(), theXMLTypePackage.getInt(), "memory", null, 1, 1, TMemoryRequirementProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tNetworkRequirementPropertiesEClass, TNetworkRequirementProperties.class, "TNetworkRequirementProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTNetworkRequirementProperties_Network(), theXMLTypePackage.getBoolean(), "network", null, 1, 1, TNetworkRequirementProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTNetworkRequirementProperties_Unit(), theXMLTypePackage.getString(), "unit", null, 1, 1, TNetworkRequirementProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tStorageRequirementPropertiesEClass, TStorageRequirementProperties.class, "TStorageRequirementProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTStorageRequirementProperties_DiskSpace(), theXMLTypePackage.getInt(), "diskSpace", null, 1, 1, TStorageRequirementProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTStorageRequirementProperties_Unit(), theXMLTypePackage.getString(), "unit", null, 1, 1, TStorageRequirementProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createExtendedMetaDataAnnotations()
  {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
    addAnnotation
      (documentRootEClass, 
       source, 
       new String[] 
       {
       "name", "",
       "kind", "mixed"
       });		
    addAnnotation
      (getDocumentRoot_Mixed(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });		
    addAnnotation
      (getDocumentRoot_XMLNSPrefixMap(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xmlns:prefix"
       });		
    addAnnotation
      (getDocumentRoot_XSISchemaLocation(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xsi:schemaLocation"
       });		
    addAnnotation
      (getDocumentRoot_CPURequirementProperties(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "CPURequirementProperties",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_MemoryRequirementProperties(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "MemoryRequirementProperties",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_NetworkRequirementProperties(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "NetworkRequirementProperties",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_StorageRequiremetProperties(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "StorageRequiremetProperties",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (tcpuRequirementPropertiesEClass, 
       source, 
       new String[] 
       {
       "name", "tCPURequirementProperties",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTCPURequirementProperties_NumCPUs(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "NumCPUs"
       });		
    addAnnotation
      (tMemoryRequirementPropertiesEClass, 
       source, 
       new String[] 
       {
       "name", "tMemoryRequirementProperties",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTMemoryRequirementProperties_Memory(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Memory"
       });		
    addAnnotation
      (tNetworkRequirementPropertiesEClass, 
       source, 
       new String[] 
       {
       "name", "tNetworkRequirementProperties",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTNetworkRequirementProperties_Network(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Network"
       });		
    addAnnotation
      (getTNetworkRequirementProperties_Unit(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Unit"
       });		
    addAnnotation
      (tStorageRequirementPropertiesEClass, 
       source, 
       new String[] 
       {
       "name", "tStorageRequirementProperties",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTStorageRequirementProperties_DiskSpace(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "DiskSpace"
       });		
    addAnnotation
      (getTStorageRequirementProperties_Unit(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Unit"
       });
  }

} //Tosca_HRequirements_ExtensionsPackageImpl
