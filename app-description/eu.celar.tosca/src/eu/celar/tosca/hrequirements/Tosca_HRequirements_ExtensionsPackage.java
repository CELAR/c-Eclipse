/**
 */
package eu.celar.tosca.hrequirements;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsFactory
 * @model kind="package"
 * @generated
 */
public interface Tosca_HRequirements_ExtensionsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "hrequirements";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.example.org/EnvironmentRequirementProperties";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "hrequirements";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Tosca_HRequirements_ExtensionsPackage eINSTANCE = eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl.init();

  /**
   * The meta object id for the '{@link eu.celar.tosca.hrequirements.impl.DocumentRootImpl <em>Document Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.hrequirements.impl.DocumentRootImpl
   * @see eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl#getDocumentRoot()
   * @generated
   */
  int DOCUMENT_ROOT = 0;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__MIXED = 0;

  /**
   * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

  /**
   * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

  /**
   * The feature id for the '<em><b>CPU Requirement Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__CPU_REQUIREMENT_PROPERTIES = 3;

  /**
   * The feature id for the '<em><b>Memory Requirement Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__MEMORY_REQUIREMENT_PROPERTIES = 4;

  /**
   * The feature id for the '<em><b>Network Requirement Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__NETWORK_REQUIREMENT_PROPERTIES = 5;

  /**
   * The feature id for the '<em><b>Storage Requiremet Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__STORAGE_REQUIREMET_PROPERTIES = 6;

  /**
   * The number of structural features of the '<em>Document Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link eu.celar.tosca.hrequirements.impl.TCPURequirementPropertiesImpl <em>TCPU Requirement Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.hrequirements.impl.TCPURequirementPropertiesImpl
   * @see eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl#getTCPURequirementProperties()
   * @generated
   */
  int TCPU_REQUIREMENT_PROPERTIES = 1;

  /**
   * The feature id for the '<em><b>Num CP Us</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCPU_REQUIREMENT_PROPERTIES__NUM_CP_US = 0;

  /**
   * The number of structural features of the '<em>TCPU Requirement Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCPU_REQUIREMENT_PROPERTIES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.celar.tosca.hrequirements.impl.TMemoryRequirementPropertiesImpl <em>TMemory Requirement Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.hrequirements.impl.TMemoryRequirementPropertiesImpl
   * @see eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl#getTMemoryRequirementProperties()
   * @generated
   */
  int TMEMORY_REQUIREMENT_PROPERTIES = 2;

  /**
   * The feature id for the '<em><b>Memory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMEMORY_REQUIREMENT_PROPERTIES__MEMORY = 0;

  /**
   * The number of structural features of the '<em>TMemory Requirement Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMEMORY_REQUIREMENT_PROPERTIES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.celar.tosca.hrequirements.impl.TNetworkRequirementPropertiesImpl <em>TNetwork Requirement Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.hrequirements.impl.TNetworkRequirementPropertiesImpl
   * @see eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl#getTNetworkRequirementProperties()
   * @generated
   */
  int TNETWORK_REQUIREMENT_PROPERTIES = 3;

  /**
   * The feature id for the '<em><b>Network</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNETWORK_REQUIREMENT_PROPERTIES__NETWORK = 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNETWORK_REQUIREMENT_PROPERTIES__UNIT = 1;

  /**
   * The number of structural features of the '<em>TNetwork Requirement Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNETWORK_REQUIREMENT_PROPERTIES_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.hrequirements.impl.TStorageRequirementPropertiesImpl <em>TStorage Requirement Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.hrequirements.impl.TStorageRequirementPropertiesImpl
   * @see eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl#getTStorageRequirementProperties()
   * @generated
   */
  int TSTORAGE_REQUIREMENT_PROPERTIES = 4;

  /**
   * The feature id for the '<em><b>Disk Space</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSTORAGE_REQUIREMENT_PROPERTIES__DISK_SPACE = 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSTORAGE_REQUIREMENT_PROPERTIES__UNIT = 1;

  /**
   * The number of structural features of the '<em>TStorage Requirement Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSTORAGE_REQUIREMENT_PROPERTIES_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link eu.celar.tosca.hrequirements.DocumentRoot <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document Root</em>'.
   * @see eu.celar.tosca.hrequirements.DocumentRoot
   * @generated
   */
  EClass getDocumentRoot();

  /**
   * Returns the meta object for the attribute list '{@link eu.celar.tosca.hrequirements.DocumentRoot#getMixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mixed</em>'.
   * @see eu.celar.tosca.hrequirements.DocumentRoot#getMixed()
   * @see #getDocumentRoot()
   * @generated
   */
  EAttribute getDocumentRoot_Mixed();

  /**
   * Returns the meta object for the map '{@link eu.celar.tosca.hrequirements.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
   * @see eu.celar.tosca.hrequirements.DocumentRoot#getXMLNSPrefixMap()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_XMLNSPrefixMap();

  /**
   * Returns the meta object for the map '{@link eu.celar.tosca.hrequirements.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XSI Schema Location</em>'.
   * @see eu.celar.tosca.hrequirements.DocumentRoot#getXSISchemaLocation()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_XSISchemaLocation();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.hrequirements.DocumentRoot#getCPURequirementProperties <em>CPU Requirement Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>CPU Requirement Properties</em>'.
   * @see eu.celar.tosca.hrequirements.DocumentRoot#getCPURequirementProperties()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_CPURequirementProperties();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.hrequirements.DocumentRoot#getMemoryRequirementProperties <em>Memory Requirement Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Memory Requirement Properties</em>'.
   * @see eu.celar.tosca.hrequirements.DocumentRoot#getMemoryRequirementProperties()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_MemoryRequirementProperties();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.hrequirements.DocumentRoot#getNetworkRequirementProperties <em>Network Requirement Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Network Requirement Properties</em>'.
   * @see eu.celar.tosca.hrequirements.DocumentRoot#getNetworkRequirementProperties()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_NetworkRequirementProperties();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.hrequirements.DocumentRoot#getStorageRequiremetProperties <em>Storage Requiremet Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Storage Requiremet Properties</em>'.
   * @see eu.celar.tosca.hrequirements.DocumentRoot#getStorageRequiremetProperties()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_StorageRequiremetProperties();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.hrequirements.TCPURequirementProperties <em>TCPU Requirement Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TCPU Requirement Properties</em>'.
   * @see eu.celar.tosca.hrequirements.TCPURequirementProperties
   * @generated
   */
  EClass getTCPURequirementProperties();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.hrequirements.TCPURequirementProperties#getNumCPUs <em>Num CP Us</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num CP Us</em>'.
   * @see eu.celar.tosca.hrequirements.TCPURequirementProperties#getNumCPUs()
   * @see #getTCPURequirementProperties()
   * @generated
   */
  EAttribute getTCPURequirementProperties_NumCPUs();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.hrequirements.TMemoryRequirementProperties <em>TMemory Requirement Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TMemory Requirement Properties</em>'.
   * @see eu.celar.tosca.hrequirements.TMemoryRequirementProperties
   * @generated
   */
  EClass getTMemoryRequirementProperties();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.hrequirements.TMemoryRequirementProperties#getMemory <em>Memory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Memory</em>'.
   * @see eu.celar.tosca.hrequirements.TMemoryRequirementProperties#getMemory()
   * @see #getTMemoryRequirementProperties()
   * @generated
   */
  EAttribute getTMemoryRequirementProperties_Memory();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.hrequirements.TNetworkRequirementProperties <em>TNetwork Requirement Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TNetwork Requirement Properties</em>'.
   * @see eu.celar.tosca.hrequirements.TNetworkRequirementProperties
   * @generated
   */
  EClass getTNetworkRequirementProperties();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.hrequirements.TNetworkRequirementProperties#isNetwork <em>Network</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Network</em>'.
   * @see eu.celar.tosca.hrequirements.TNetworkRequirementProperties#isNetwork()
   * @see #getTNetworkRequirementProperties()
   * @generated
   */
  EAttribute getTNetworkRequirementProperties_Network();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.hrequirements.TNetworkRequirementProperties#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see eu.celar.tosca.hrequirements.TNetworkRequirementProperties#getUnit()
   * @see #getTNetworkRequirementProperties()
   * @generated
   */
  EAttribute getTNetworkRequirementProperties_Unit();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.hrequirements.TStorageRequirementProperties <em>TStorage Requirement Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TStorage Requirement Properties</em>'.
   * @see eu.celar.tosca.hrequirements.TStorageRequirementProperties
   * @generated
   */
  EClass getTStorageRequirementProperties();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.hrequirements.TStorageRequirementProperties#getDiskSpace <em>Disk Space</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Disk Space</em>'.
   * @see eu.celar.tosca.hrequirements.TStorageRequirementProperties#getDiskSpace()
   * @see #getTStorageRequirementProperties()
   * @generated
   */
  EAttribute getTStorageRequirementProperties_DiskSpace();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.hrequirements.TStorageRequirementProperties#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see eu.celar.tosca.hrequirements.TStorageRequirementProperties#getUnit()
   * @see #getTStorageRequirementProperties()
   * @generated
   */
  EAttribute getTStorageRequirementProperties_Unit();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Tosca_HRequirements_ExtensionsFactory getTosca_HRequirements_ExtensionsFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link eu.celar.tosca.hrequirements.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.hrequirements.impl.DocumentRootImpl
     * @see eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl#getDocumentRoot()
     * @generated
     */
    EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

    /**
     * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

    /**
     * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

    /**
     * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

    /**
     * The meta object literal for the '<em><b>CPU Requirement Properties</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__CPU_REQUIREMENT_PROPERTIES = eINSTANCE.getDocumentRoot_CPURequirementProperties();

    /**
     * The meta object literal for the '<em><b>Memory Requirement Properties</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__MEMORY_REQUIREMENT_PROPERTIES = eINSTANCE.getDocumentRoot_MemoryRequirementProperties();

    /**
     * The meta object literal for the '<em><b>Network Requirement Properties</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__NETWORK_REQUIREMENT_PROPERTIES = eINSTANCE.getDocumentRoot_NetworkRequirementProperties();

    /**
     * The meta object literal for the '<em><b>Storage Requiremet Properties</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__STORAGE_REQUIREMET_PROPERTIES = eINSTANCE.getDocumentRoot_StorageRequiremetProperties();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.hrequirements.impl.TCPURequirementPropertiesImpl <em>TCPU Requirement Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.hrequirements.impl.TCPURequirementPropertiesImpl
     * @see eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl#getTCPURequirementProperties()
     * @generated
     */
    EClass TCPU_REQUIREMENT_PROPERTIES = eINSTANCE.getTCPURequirementProperties();

    /**
     * The meta object literal for the '<em><b>Num CP Us</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCPU_REQUIREMENT_PROPERTIES__NUM_CP_US = eINSTANCE.getTCPURequirementProperties_NumCPUs();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.hrequirements.impl.TMemoryRequirementPropertiesImpl <em>TMemory Requirement Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.hrequirements.impl.TMemoryRequirementPropertiesImpl
     * @see eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl#getTMemoryRequirementProperties()
     * @generated
     */
    EClass TMEMORY_REQUIREMENT_PROPERTIES = eINSTANCE.getTMemoryRequirementProperties();

    /**
     * The meta object literal for the '<em><b>Memory</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TMEMORY_REQUIREMENT_PROPERTIES__MEMORY = eINSTANCE.getTMemoryRequirementProperties_Memory();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.hrequirements.impl.TNetworkRequirementPropertiesImpl <em>TNetwork Requirement Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.hrequirements.impl.TNetworkRequirementPropertiesImpl
     * @see eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl#getTNetworkRequirementProperties()
     * @generated
     */
    EClass TNETWORK_REQUIREMENT_PROPERTIES = eINSTANCE.getTNetworkRequirementProperties();

    /**
     * The meta object literal for the '<em><b>Network</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNETWORK_REQUIREMENT_PROPERTIES__NETWORK = eINSTANCE.getTNetworkRequirementProperties_Network();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNETWORK_REQUIREMENT_PROPERTIES__UNIT = eINSTANCE.getTNetworkRequirementProperties_Unit();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.hrequirements.impl.TStorageRequirementPropertiesImpl <em>TStorage Requirement Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.hrequirements.impl.TStorageRequirementPropertiesImpl
     * @see eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl#getTStorageRequirementProperties()
     * @generated
     */
    EClass TSTORAGE_REQUIREMENT_PROPERTIES = eINSTANCE.getTStorageRequirementProperties();

    /**
     * The meta object literal for the '<em><b>Disk Space</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TSTORAGE_REQUIREMENT_PROPERTIES__DISK_SPACE = eINSTANCE.getTStorageRequirementProperties_DiskSpace();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TSTORAGE_REQUIREMENT_PROPERTIES__UNIT = eINSTANCE.getTStorageRequirementProperties_Unit();

  }

} //Tosca_HRequirements_ExtensionsPackage
