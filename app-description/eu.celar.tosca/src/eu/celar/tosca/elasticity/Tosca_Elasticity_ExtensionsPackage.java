/**
 */
package eu.celar.tosca.elasticity;

import eu.celar.tosca.ToscaPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * <!-- begin-model-doc -->
 * 
 *    <div xmlns="http://www.w3.org/1999/xhtml">
 *     <h1>About the XML namespace</h1>
 * 
 *     <div class="bodytext">
 *      <p>
 *       This schema document describes the XML namespace, in a form
 *       suitable for import by other schema documents.
 *      </p>
 *      <p>
 *       See <a href="http://www.w3.org/XML/1998/namespace.html">
 *       http://www.w3.org/XML/1998/namespace.html</a> and
 *       <a href="http://www.w3.org/TR/REC-xml">
 *       http://www.w3.org/TR/REC-xml</a> for information 
 *       about this namespace.
 *      </p>
 *      <p>
 *       Note that local names in this namespace are intended to be
 *       defined only by the World Wide Web Consortium or its subgroups.
 *       The names currently defined in this namespace are listed below.
 *       They should not be used with conflicting semantics by any Working
 *       Group, specification, or document instance.
 *      </p>
 *      <p>   
 *       See further below in this document for more information about <a href="#usage">how to refer to this schema document from your own
 *       XSD schema documents</a> and about <a href="#nsversioning">the
 *       namespace-versioning policy governing this schema document</a>.
 *      </p>
 *     </div>
 *    </div>
 *   
 * 
 *    <div xmlns="http://www.w3.org/1999/xhtml">
 *    
 *     <h3>Father (in any context at all)</h3> 
 * 
 *     <div class="bodytext">
 *      <p>
 *       denotes Jon Bosak, the chair of 
 *       the original XML Working Group.  This name is reserved by 
 *       the following decision of the W3C XML Plenary and 
 *       XML Coordination groups:
 *      </p>
 *      <blockquote>
 *        <p>
 * 	In appreciation for his vision, leadership and
 * 	dedication the W3C XML Plenary on this 10th day of
 * 	February, 2000, reserves for Jon Bosak in perpetuity
 * 	the XML name "xml:Father".
 *        </p>
 *      </blockquote>
 *     </div>
 *    </div>
 *   
 * 
 *    <div xmlns="http://www.w3.org/1999/xhtml" id="usage" xml:id="usage">
 *     <h2>
 *       <a name="usage">About this schema document</a>
 *     </h2>
 * 
 *     <div class="bodytext">
 *      <p>
 *       This schema defines attributes and an attribute group suitable
 *       for use by schemas wishing to allow <code>xml:base</code>,
 *       <code>xml:lang</code>, <code>xml:space</code> or
 *       <code>xml:id</code> attributes on elements they define.
 *      </p>
 *      <p>
 *       To enable this, such a schema must import this schema for
 *       the XML namespace, e.g. as follows:
 *      </p>
 *      <pre>
 *           &lt;schema . . .&gt;
 *            . . .
 *            &lt;import namespace="http://www.w3.org/XML/1998/namespace"
 *                       schemaLocation="http://www.w3.org/2001/xml.xsd"/&gt;
 *      </pre>
 *      <p>
 *       or
 *      </p>
 *      <pre>
 *            &lt;import namespace="http://www.w3.org/XML/1998/namespace"
 *                       schemaLocation="http://www.w3.org/2009/01/xml.xsd"/&gt;
 *      </pre>
 *      <p>
 *       Subsequently, qualified reference to any of the attributes or the
 *       group defined below will have the desired effect, e.g.
 *      </p>
 *      <pre>
 *           &lt;type . . .&gt;
 *            . . .
 *            &lt;attributeGroup ref="xml:specialAttrs"/&gt;
 *      </pre>
 *      <p>
 *       will define a type which will schema-validate an instance element
 *       with any of those attributes.
 *      </p>
 *     </div>
 *    </div>
 *   
 * 
 *    <div xmlns="http://www.w3.org/1999/xhtml" id="nsversioning" xml:id="nsversioning">
 *     <h2>
 *       <a name="nsversioning">Versioning policy for this schema document</a>
 *     </h2>
 *     <div class="bodytext">
 *      <p>
 *       In keeping with the XML Schema WG's standard versioning
 *       policy, this schema document will persist at
 *       <a href="http://www.w3.org/2009/01/xml.xsd">
 *        http://www.w3.org/2009/01/xml.xsd</a>.
 *      </p>
 *      <p>
 *       At the date of issue it can also be found at
 *       <a href="http://www.w3.org/2001/xml.xsd">
 *        http://www.w3.org/2001/xml.xsd</a>.
 *      </p>
 *      <p>
 *       The schema document at that URI may however change in the future,
 *       in order to remain compatible with the latest version of XML
 *       Schema itself, or with the XML namespace itself.  In other words,
 *       if the XML Schema or XML namespaces change, the version of this
 *       document at <a href="http://www.w3.org/2001/xml.xsd">
 *        http://www.w3.org/2001/xml.xsd 
 *       </a> 
 *       will change accordingly; the version at 
 *       <a href="http://www.w3.org/2009/01/xml.xsd">
 *        http://www.w3.org/2009/01/xml.xsd 
 *       </a> 
 *       will not change.
 *      </p>
 *      <p>
 *       Previous dated (and unchanging) versions of this schema 
 *       document are at:
 *      </p>
 *      <ul>
 *       <li>
 *           <a href="http://www.w3.org/2009/01/xml.xsd">
 * 	http://www.w3.org/2009/01/xml.xsd</a>
 *         </li>
 *       <li>
 *           <a href="http://www.w3.org/2007/08/xml.xsd">
 * 	http://www.w3.org/2007/08/xml.xsd</a>
 *         </li>
 *       <li>
 *           <a href="http://www.w3.org/2004/10/xml.xsd">
 * 	http://www.w3.org/2004/10/xml.xsd</a>
 *         </li>
 *       <li>
 *           <a href="http://www.w3.org/2001/03/xml.xsd">
 * 	http://www.w3.org/2001/03/xml.xsd</a>
 *         </li>
 *      </ul>
 *     </div>
 *    </div>
 *   
 * <!-- end-model-doc -->
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory
 * @model kind="package"
 * @generated
 */
public interface Tosca_Elasticity_ExtensionsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "elasticity";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.example.org/NewXMLSchema";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "elasticity";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Tosca_Elasticity_ExtensionsPackage eINSTANCE = eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl.init();

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.ApplicationComponentElasticityRequirementsType1Impl <em>Application Component Elasticity Requirements Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.ApplicationComponentElasticityRequirementsType1Impl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationComponentElasticityRequirementsType1()
   * @generated
   */
  int APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1 = 0;

  /**
   * The feature id for the '<em><b>Application Component Elasticity Requirements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS = 0;

  /**
   * The number of structural features of the '<em>Application Component Elasticity Requirements Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.DataHintsType1Impl <em>Data Hints Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.DataHintsType1Impl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getDataHintsType1()
   * @generated
   */
  int DATA_HINTS_TYPE1 = 1;

  /**
   * The feature id for the '<em><b>Data Hints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_HINTS_TYPE1__DATA_HINTS = 0;

  /**
   * The number of structural features of the '<em>Data Hints Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_HINTS_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.GlobalElasticityRequirementsType1Impl <em>Global Elasticity Requirements Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.GlobalElasticityRequirementsType1Impl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getGlobalElasticityRequirementsType1()
   * @generated
   */
  int GLOBAL_ELASTICITY_REQUIREMENTS_TYPE1 = 2;

  /**
   * The feature id for the '<em><b>Global Elasticity Requirements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_ELASTICITY_REQUIREMENTS_TYPE1__GLOBAL_ELASTICITY_REQUIREMENTS = 0;

  /**
   * The number of structural features of the '<em>Global Elasticity Requirements Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_ELASTICITY_REQUIREMENTS_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.LoadHintsType1Impl <em>Load Hints Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.LoadHintsType1Impl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getLoadHintsType1()
   * @generated
   */
  int LOAD_HINTS_TYPE1 = 3;

  /**
   * The feature id for the '<em><b>Load Hints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_HINTS_TYPE1__LOAD_HINTS = 0;

  /**
   * The number of structural features of the '<em>Load Hints Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_HINTS_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.MonitoringProbesType1Impl <em>Monitoring Probes Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.MonitoringProbesType1Impl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getMonitoringProbesType1()
   * @generated
   */
  int MONITORING_PROBES_TYPE1 = 4;

  /**
   * The feature id for the '<em><b>Monitoring Probes</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONITORING_PROBES_TYPE1__MONITORING_PROBES = 0;

  /**
   * The number of structural features of the '<em>Monitoring Probes Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONITORING_PROBES_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TApplicationComponentElasticityRequirementImpl <em>TApplication Component Elasticity Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.TApplicationComponentElasticityRequirementImpl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTApplicationComponentElasticityRequirement()
   * @generated
   */
  int TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT = 5;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT__DOCUMENTATION = ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT__ANY = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT__ANY_ATTRIBUTE = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT__NAME = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT__VALUE = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>TApplication Component Elasticity Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_FEATURE_COUNT = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TBoundaryDefinitionsExtensionImpl <em>TBoundary Definitions Extension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.TBoundaryDefinitionsExtensionImpl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTBoundaryDefinitionsExtension()
   * @generated
   */
  int TBOUNDARY_DEFINITIONS_EXTENSION = 6;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS_EXTENSION__PROPERTIES = ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTIES;

  /**
   * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS_EXTENSION__PROPERTY_CONSTRAINTS = ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS_EXTENSION__REQUIREMENTS = ToscaPackage.TBOUNDARY_DEFINITIONS__REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Capabilities</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS_EXTENSION__CAPABILITIES = ToscaPackage.TBOUNDARY_DEFINITIONS__CAPABILITIES;

  /**
   * The feature id for the '<em><b>Policies</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS_EXTENSION__POLICIES = ToscaPackage.TBOUNDARY_DEFINITIONS__POLICIES;

  /**
   * The feature id for the '<em><b>Interfaces</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS_EXTENSION__INTERFACES = ToscaPackage.TBOUNDARY_DEFINITIONS__INTERFACES;

  /**
   * The feature id for the '<em><b>Global Elasticity Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS_EXTENSION__GLOBAL_ELASTICITY_REQUIREMENTS = ToscaPackage.TBOUNDARY_DEFINITIONS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Monitoring Probes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES = ToscaPackage.TBOUNDARY_DEFINITIONS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>TBoundary Definitions Extension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS_EXTENSION_FEATURE_COUNT = ToscaPackage.TBOUNDARY_DEFINITIONS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TDataHintImpl <em>TData Hint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.TDataHintImpl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTDataHint()
   * @generated
   */
  int TDATA_HINT = 7;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDATA_HINT__DOCUMENTATION = ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDATA_HINT__ANY = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDATA_HINT__ANY_ATTRIBUTE = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDATA_HINT__NAME = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDATA_HINT__VALUE = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>TData Hint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDATA_HINT_FEATURE_COUNT = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TGlobalElasticityRequirementImpl <em>TGlobal Elasticity Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.TGlobalElasticityRequirementImpl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTGlobalElasticityRequirement()
   * @generated
   */
  int TGLOBAL_ELASTICITY_REQUIREMENT = 8;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TGLOBAL_ELASTICITY_REQUIREMENT__DOCUMENTATION = ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TGLOBAL_ELASTICITY_REQUIREMENT__ANY = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TGLOBAL_ELASTICITY_REQUIREMENT__ANY_ATTRIBUTE = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TGLOBAL_ELASTICITY_REQUIREMENT__NAME = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TGLOBAL_ELASTICITY_REQUIREMENT__VALUE = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>TGlobal Elasticity Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TGLOBAL_ELASTICITY_REQUIREMENT_FEATURE_COUNT = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TLoadHintImpl <em>TLoad Hint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.TLoadHintImpl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTLoadHint()
   * @generated
   */
  int TLOAD_HINT = 9;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TLOAD_HINT__DOCUMENTATION = ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TLOAD_HINT__ANY = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TLOAD_HINT__ANY_ATTRIBUTE = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TLOAD_HINT__NAME = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TLOAD_HINT__VALUE = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>TLoad Hint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TLOAD_HINT_FEATURE_COUNT = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl <em>TNode Template Extension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTNodeTemplateExtension()
   * @generated
   */
  int TNODE_TEMPLATE_EXTENSION = 11;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory <em>Application Component Elasticity Requirement Category</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationComponentElasticityRequirementCategory()
   * @generated
   */
  int APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY = 12;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.DataHintCategory <em>Data Hint Category</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.DataHintCategory
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getDataHintCategory()
   * @generated
   */
  int DATA_HINT_CATEGORY = 13;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory <em>Global Elasticity Requirement Category</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getGlobalElasticityRequirementCategory()
   * @generated
   */
  int GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY = 14;

  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.LoadHintCategory <em>Load Hint Category</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.LoadHintCategory
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getLoadHintCategory()
   * @generated
   */
  int LOAD_HINT_CATEGORY = 15;

  /**
   * The meta object id for the '<em>Application Component Elasticity Requirement Category Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationComponentElasticityRequirementCategoryObject()
   * @generated
   */
  int APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT = 16;

  /**
   * The meta object id for the '<em>Data Hint Category Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.DataHintCategory
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getDataHintCategoryObject()
   * @generated
   */
  int DATA_HINT_CATEGORY_OBJECT = 17;

  /**
   * The meta object id for the '<em>Global Elasticity Requirement Category Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getGlobalElasticityRequirementCategoryObject()
   * @generated
   */
  int GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT = 18;


  /**
   * The meta object id for the '<em>Load Hint Category Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.LoadHintCategory
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getLoadHintCategoryObject()
   * @generated
   */
  int LOAD_HINT_CATEGORY_OBJECT = 19;


  /**
   * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TMonitoringProbeImpl <em>TMonitoring Probe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.elasticity.impl.TMonitoringProbeImpl
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTMonitoringProbe()
   * @generated
   */
  int TMONITORING_PROBE = 10;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMONITORING_PROBE__DOCUMENTATION = ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMONITORING_PROBE__ANY = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMONITORING_PROBE__ANY_ATTRIBUTE = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMONITORING_PROBE__NAME = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>TMonitoring Probe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMONITORING_PROBE_FEATURE_COUNT = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__DOCUMENTATION = ToscaPackage.TNODE_TEMPLATE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__ANY = ToscaPackage.TNODE_TEMPLATE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__ANY_ATTRIBUTE = ToscaPackage.TNODE_TEMPLATE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__PROPERTIES = ToscaPackage.TNODE_TEMPLATE__PROPERTIES;

  /**
   * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__PROPERTY_CONSTRAINTS = ToscaPackage.TNODE_TEMPLATE__PROPERTY_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__ID = ToscaPackage.TNODE_TEMPLATE__ID;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__TYPE = ToscaPackage.TNODE_TEMPLATE__TYPE;

  /**
   * The feature id for the '<em><b>Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__REQUIREMENTS = ToscaPackage.TNODE_TEMPLATE__REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Capabilities</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__CAPABILITIES = ToscaPackage.TNODE_TEMPLATE__CAPABILITIES;

  /**
   * The feature id for the '<em><b>Policies</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__POLICIES = ToscaPackage.TNODE_TEMPLATE__POLICIES;

  /**
   * The feature id for the '<em><b>Deployment Artifacts</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__DEPLOYMENT_ARTIFACTS = ToscaPackage.TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS;

  /**
   * The feature id for the '<em><b>Max Instances</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__MAX_INSTANCES = ToscaPackage.TNODE_TEMPLATE__MAX_INSTANCES;

  /**
   * The feature id for the '<em><b>Min Instances</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__MIN_INSTANCES = ToscaPackage.TNODE_TEMPLATE__MIN_INSTANCES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__NAME = ToscaPackage.TNODE_TEMPLATE__NAME;

  /**
   * The feature id for the '<em><b>Application Component Elasticity Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Application Component Data Hints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Application Component Load Hints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Application Component Monitoring Probes</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_MONITORING_PROBES = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Application Component Resizing Actions</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_RESIZING_ACTIONS = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Application Component VMI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_VMI = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>TNode Template Extension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_EXTENSION_FEATURE_COUNT = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '<em>TVirtual Machine Image</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTVirtualMachineImage()
   * @generated
   */
  int TVIRTUAL_MACHINE_IMAGE = 20;


  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1 <em>Application Component Elasticity Requirements Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Application Component Elasticity Requirements Type1</em>'.
   * @see eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1
   * @generated
   */
  EClass getApplicationComponentElasticityRequirementsType1();

  /**
   * Returns the meta object for the containment reference list '{@link eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1#getApplicationComponentElasticityRequirements <em>Application Component Elasticity Requirements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Application Component Elasticity Requirements</em>'.
   * @see eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1#getApplicationComponentElasticityRequirements()
   * @see #getApplicationComponentElasticityRequirementsType1()
   * @generated
   */
  EReference getApplicationComponentElasticityRequirementsType1_ApplicationComponentElasticityRequirements();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.DataHintsType1 <em>Data Hints Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Hints Type1</em>'.
   * @see eu.celar.tosca.elasticity.DataHintsType1
   * @generated
   */
  EClass getDataHintsType1();

  /**
   * Returns the meta object for the containment reference list '{@link eu.celar.tosca.elasticity.DataHintsType1#getDataHints <em>Data Hints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Data Hints</em>'.
   * @see eu.celar.tosca.elasticity.DataHintsType1#getDataHints()
   * @see #getDataHintsType1()
   * @generated
   */
  EReference getDataHintsType1_DataHints();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.GlobalElasticityRequirementsType1 <em>Global Elasticity Requirements Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Global Elasticity Requirements Type1</em>'.
   * @see eu.celar.tosca.elasticity.GlobalElasticityRequirementsType1
   * @generated
   */
  EClass getGlobalElasticityRequirementsType1();

  /**
   * Returns the meta object for the containment reference list '{@link eu.celar.tosca.elasticity.GlobalElasticityRequirementsType1#getGlobalElasticityRequirements <em>Global Elasticity Requirements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Global Elasticity Requirements</em>'.
   * @see eu.celar.tosca.elasticity.GlobalElasticityRequirementsType1#getGlobalElasticityRequirements()
   * @see #getGlobalElasticityRequirementsType1()
   * @generated
   */
  EReference getGlobalElasticityRequirementsType1_GlobalElasticityRequirements();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.LoadHintsType1 <em>Load Hints Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Load Hints Type1</em>'.
   * @see eu.celar.tosca.elasticity.LoadHintsType1
   * @generated
   */
  EClass getLoadHintsType1();

  /**
   * Returns the meta object for the containment reference list '{@link eu.celar.tosca.elasticity.LoadHintsType1#getLoadHints <em>Load Hints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Load Hints</em>'.
   * @see eu.celar.tosca.elasticity.LoadHintsType1#getLoadHints()
   * @see #getLoadHintsType1()
   * @generated
   */
  EReference getLoadHintsType1_LoadHints();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.MonitoringProbesType1 <em>Monitoring Probes Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Monitoring Probes Type1</em>'.
   * @see eu.celar.tosca.elasticity.MonitoringProbesType1
   * @generated
   */
  EClass getMonitoringProbesType1();

  /**
   * Returns the meta object for the attribute list '{@link eu.celar.tosca.elasticity.MonitoringProbesType1#getMonitoringProbes <em>Monitoring Probes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Monitoring Probes</em>'.
   * @see eu.celar.tosca.elasticity.MonitoringProbesType1#getMonitoringProbes()
   * @see #getMonitoringProbesType1()
   * @generated
   */
  EAttribute getMonitoringProbesType1_MonitoringProbes();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement <em>TApplication Component Elasticity Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TApplication Component Elasticity Requirement</em>'.
   * @see eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement
   * @generated
   */
  EClass getTApplicationComponentElasticityRequirement();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement#getName()
   * @see #getTApplicationComponentElasticityRequirement()
   * @generated
   */
  EAttribute getTApplicationComponentElasticityRequirement_Name();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement#getValue()
   * @see #getTApplicationComponentElasticityRequirement()
   * @generated
   */
  EAttribute getTApplicationComponentElasticityRequirement_Value();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension <em>TBoundary Definitions Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TBoundary Definitions Extension</em>'.
   * @see eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension
   * @generated
   */
  EClass getTBoundaryDefinitionsExtension();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension#getGlobalElasticityRequirements <em>Global Elasticity Requirements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Global Elasticity Requirements</em>'.
   * @see eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension#getGlobalElasticityRequirements()
   * @see #getTBoundaryDefinitionsExtension()
   * @generated
   */
  EReference getTBoundaryDefinitionsExtension_GlobalElasticityRequirements();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension#getMonitoringProbes <em>Monitoring Probes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Monitoring Probes</em>'.
   * @see eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension#getMonitoringProbes()
   * @see #getTBoundaryDefinitionsExtension()
   * @generated
   */
  EReference getTBoundaryDefinitionsExtension_MonitoringProbes();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.TDataHint <em>TData Hint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TData Hint</em>'.
   * @see eu.celar.tosca.elasticity.TDataHint
   * @generated
   */
  EClass getTDataHint();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TDataHint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.celar.tosca.elasticity.TDataHint#getName()
   * @see #getTDataHint()
   * @generated
   */
  EAttribute getTDataHint_Name();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TDataHint#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.celar.tosca.elasticity.TDataHint#getValue()
   * @see #getTDataHint()
   * @generated
   */
  EAttribute getTDataHint_Value();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.TGlobalElasticityRequirement <em>TGlobal Elasticity Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TGlobal Elasticity Requirement</em>'.
   * @see eu.celar.tosca.elasticity.TGlobalElasticityRequirement
   * @generated
   */
  EClass getTGlobalElasticityRequirement();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TGlobalElasticityRequirement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.celar.tosca.elasticity.TGlobalElasticityRequirement#getName()
   * @see #getTGlobalElasticityRequirement()
   * @generated
   */
  EAttribute getTGlobalElasticityRequirement_Name();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TGlobalElasticityRequirement#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.celar.tosca.elasticity.TGlobalElasticityRequirement#getValue()
   * @see #getTGlobalElasticityRequirement()
   * @generated
   */
  EAttribute getTGlobalElasticityRequirement_Value();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.TLoadHint <em>TLoad Hint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TLoad Hint</em>'.
   * @see eu.celar.tosca.elasticity.TLoadHint
   * @generated
   */
  EClass getTLoadHint();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TLoadHint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.celar.tosca.elasticity.TLoadHint#getName()
   * @see #getTLoadHint()
   * @generated
   */
  EAttribute getTLoadHint_Name();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TLoadHint#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.celar.tosca.elasticity.TLoadHint#getValue()
   * @see #getTLoadHint()
   * @generated
   */
  EAttribute getTLoadHint_Value();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension <em>TNode Template Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TNode Template Extension</em>'.
   * @see eu.celar.tosca.elasticity.TNodeTemplateExtension
   * @generated
   */
  EClass getTNodeTemplateExtension();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentElasticityRequirements <em>Application Component Elasticity Requirements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Application Component Elasticity Requirements</em>'.
   * @see eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentElasticityRequirements()
   * @see #getTNodeTemplateExtension()
   * @generated
   */
  EReference getTNodeTemplateExtension_ApplicationComponentElasticityRequirements();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentDataHints <em>Application Component Data Hints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Application Component Data Hints</em>'.
   * @see eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentDataHints()
   * @see #getTNodeTemplateExtension()
   * @generated
   */
  EReference getTNodeTemplateExtension_ApplicationComponentDataHints();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentLoadHints <em>Application Component Load Hints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Application Component Load Hints</em>'.
   * @see eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentLoadHints()
   * @see #getTNodeTemplateExtension()
   * @generated
   */
  EReference getTNodeTemplateExtension_ApplicationComponentLoadHints();

  /**
   * Returns the meta object for the attribute list '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentMonitoringProbes <em>Application Component Monitoring Probes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Application Component Monitoring Probes</em>'.
   * @see eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentMonitoringProbes()
   * @see #getTNodeTemplateExtension()
   * @generated
   */
  EAttribute getTNodeTemplateExtension_ApplicationComponentMonitoringProbes();

  /**
   * Returns the meta object for the attribute list '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentResizingActions <em>Application Component Resizing Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Application Component Resizing Actions</em>'.
   * @see eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentResizingActions()
   * @see #getTNodeTemplateExtension()
   * @generated
   */
  EAttribute getTNodeTemplateExtension_ApplicationComponentResizingActions();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentVMI <em>Application Component VMI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Application Component VMI</em>'.
   * @see eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentVMI()
   * @see #getTNodeTemplateExtension()
   * @generated
   */
  EAttribute getTNodeTemplateExtension_ApplicationComponentVMI();

  /**
   * Returns the meta object for enum '{@link eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory <em>Application Component Elasticity Requirement Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Application Component Elasticity Requirement Category</em>'.
   * @see eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory
   * @generated
   */
  EEnum getApplicationComponentElasticityRequirementCategory();

  /**
   * Returns the meta object for enum '{@link eu.celar.tosca.elasticity.DataHintCategory <em>Data Hint Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Data Hint Category</em>'.
   * @see eu.celar.tosca.elasticity.DataHintCategory
   * @generated
   */
  EEnum getDataHintCategory();

  /**
   * Returns the meta object for enum '{@link eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory <em>Global Elasticity Requirement Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Global Elasticity Requirement Category</em>'.
   * @see eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory
   * @generated
   */
  EEnum getGlobalElasticityRequirementCategory();

  /**
   * Returns the meta object for enum '{@link eu.celar.tosca.elasticity.LoadHintCategory <em>Load Hint Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Load Hint Category</em>'.
   * @see eu.celar.tosca.elasticity.LoadHintCategory
   * @generated
   */
  EEnum getLoadHintCategory();

  /**
   * Returns the meta object for data type '{@link eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory <em>Application Component Elasticity Requirement Category Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Application Component Elasticity Requirement Category Object</em>'.
   * @see eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory
   * @model instanceClass="eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory"
   *        extendedMetaData="name='ApplicationComponentElasticityRequirementCategory:Object' baseType='ApplicationComponentElasticityRequirementCategory'"
   * @generated
   */
  EDataType getApplicationComponentElasticityRequirementCategoryObject();

  /**
   * Returns the meta object for data type '{@link eu.celar.tosca.elasticity.DataHintCategory <em>Data Hint Category Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Data Hint Category Object</em>'.
   * @see eu.celar.tosca.elasticity.DataHintCategory
   * @model instanceClass="eu.celar.tosca.elasticity.DataHintCategory"
   *        extendedMetaData="name='DataHintCategory:Object' baseType='DataHintCategory'"
   * @generated
   */
  EDataType getDataHintCategoryObject();

  /**
   * Returns the meta object for data type '{@link eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory <em>Global Elasticity Requirement Category Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Global Elasticity Requirement Category Object</em>'.
   * @see eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory
   * @model instanceClass="eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory"
   *        extendedMetaData="name='GlobalElasticityRequirementCategory:Object' baseType='GlobalElasticityRequirementCategory'"
   * @generated
   */
  EDataType getGlobalElasticityRequirementCategoryObject();

  /**
   * Returns the meta object for data type '{@link eu.celar.tosca.elasticity.LoadHintCategory <em>Load Hint Category Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Load Hint Category Object</em>'.
   * @see eu.celar.tosca.elasticity.LoadHintCategory
   * @model instanceClass="eu.celar.tosca.elasticity.LoadHintCategory"
   *        extendedMetaData="name='LoadHintCategory:Object' baseType='LoadHintCategory'"
   * @generated
   */
  EDataType getLoadHintCategoryObject();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.elasticity.TMonitoringProbe <em>TMonitoring Probe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TMonitoring Probe</em>'.
   * @see eu.celar.tosca.elasticity.TMonitoringProbe
   * @generated
   */
  EClass getTMonitoringProbe();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TMonitoringProbe#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.celar.tosca.elasticity.TMonitoringProbe#getName()
   * @see #getTMonitoringProbe()
   * @generated
   */
  EAttribute getTMonitoringProbe_Name();

  /**
   * Returns the meta object for data type '{@link java.lang.String <em>TVirtual Machine Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>TVirtual Machine Image</em>'.
   * @see java.lang.String
   * @model instanceClass="java.lang.String"
   *        extendedMetaData="name='TVirtualMachineImage' baseType='http://www.eclipse.org/emf/2003/XMLType#string'"
   * @generated
   */
  EDataType getTVirtualMachineImage();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Tosca_Elasticity_ExtensionsFactory getTosca_Elasticity_ExtensionsFactory();

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
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.ApplicationComponentElasticityRequirementsType1Impl <em>Application Component Elasticity Requirements Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.ApplicationComponentElasticityRequirementsType1Impl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationComponentElasticityRequirementsType1()
     * @generated
     */
    EClass APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1 = eINSTANCE.getApplicationComponentElasticityRequirementsType1();

    /**
     * The meta object literal for the '<em><b>Application Component Elasticity Requirements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS = eINSTANCE.getApplicationComponentElasticityRequirementsType1_ApplicationComponentElasticityRequirements();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.DataHintsType1Impl <em>Data Hints Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.DataHintsType1Impl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getDataHintsType1()
     * @generated
     */
    EClass DATA_HINTS_TYPE1 = eINSTANCE.getDataHintsType1();

    /**
     * The meta object literal for the '<em><b>Data Hints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_HINTS_TYPE1__DATA_HINTS = eINSTANCE.getDataHintsType1_DataHints();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.GlobalElasticityRequirementsType1Impl <em>Global Elasticity Requirements Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.GlobalElasticityRequirementsType1Impl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getGlobalElasticityRequirementsType1()
     * @generated
     */
    EClass GLOBAL_ELASTICITY_REQUIREMENTS_TYPE1 = eINSTANCE.getGlobalElasticityRequirementsType1();

    /**
     * The meta object literal for the '<em><b>Global Elasticity Requirements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GLOBAL_ELASTICITY_REQUIREMENTS_TYPE1__GLOBAL_ELASTICITY_REQUIREMENTS = eINSTANCE.getGlobalElasticityRequirementsType1_GlobalElasticityRequirements();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.LoadHintsType1Impl <em>Load Hints Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.LoadHintsType1Impl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getLoadHintsType1()
     * @generated
     */
    EClass LOAD_HINTS_TYPE1 = eINSTANCE.getLoadHintsType1();

    /**
     * The meta object literal for the '<em><b>Load Hints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOAD_HINTS_TYPE1__LOAD_HINTS = eINSTANCE.getLoadHintsType1_LoadHints();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.MonitoringProbesType1Impl <em>Monitoring Probes Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.MonitoringProbesType1Impl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getMonitoringProbesType1()
     * @generated
     */
    EClass MONITORING_PROBES_TYPE1 = eINSTANCE.getMonitoringProbesType1();

    /**
     * The meta object literal for the '<em><b>Monitoring Probes</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONITORING_PROBES_TYPE1__MONITORING_PROBES = eINSTANCE.getMonitoringProbesType1_MonitoringProbes();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.TApplicationComponentElasticityRequirementImpl <em>TApplication Component Elasticity Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.TApplicationComponentElasticityRequirementImpl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTApplicationComponentElasticityRequirement()
     * @generated
     */
    EClass TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT = eINSTANCE.getTApplicationComponentElasticityRequirement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT__NAME = eINSTANCE.getTApplicationComponentElasticityRequirement_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT__VALUE = eINSTANCE.getTApplicationComponentElasticityRequirement_Value();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.TBoundaryDefinitionsExtensionImpl <em>TBoundary Definitions Extension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.TBoundaryDefinitionsExtensionImpl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTBoundaryDefinitionsExtension()
     * @generated
     */
    EClass TBOUNDARY_DEFINITIONS_EXTENSION = eINSTANCE.getTBoundaryDefinitionsExtension();

    /**
     * The meta object literal for the '<em><b>Global Elasticity Requirements</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TBOUNDARY_DEFINITIONS_EXTENSION__GLOBAL_ELASTICITY_REQUIREMENTS = eINSTANCE.getTBoundaryDefinitionsExtension_GlobalElasticityRequirements();

    /**
     * The meta object literal for the '<em><b>Monitoring Probes</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES = eINSTANCE.getTBoundaryDefinitionsExtension_MonitoringProbes();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.TDataHintImpl <em>TData Hint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.TDataHintImpl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTDataHint()
     * @generated
     */
    EClass TDATA_HINT = eINSTANCE.getTDataHint();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDATA_HINT__NAME = eINSTANCE.getTDataHint_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDATA_HINT__VALUE = eINSTANCE.getTDataHint_Value();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.TGlobalElasticityRequirementImpl <em>TGlobal Elasticity Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.TGlobalElasticityRequirementImpl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTGlobalElasticityRequirement()
     * @generated
     */
    EClass TGLOBAL_ELASTICITY_REQUIREMENT = eINSTANCE.getTGlobalElasticityRequirement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TGLOBAL_ELASTICITY_REQUIREMENT__NAME = eINSTANCE.getTGlobalElasticityRequirement_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TGLOBAL_ELASTICITY_REQUIREMENT__VALUE = eINSTANCE.getTGlobalElasticityRequirement_Value();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.TLoadHintImpl <em>TLoad Hint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.TLoadHintImpl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTLoadHint()
     * @generated
     */
    EClass TLOAD_HINT = eINSTANCE.getTLoadHint();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TLOAD_HINT__NAME = eINSTANCE.getTLoadHint_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TLOAD_HINT__VALUE = eINSTANCE.getTLoadHint_Value();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl <em>TNode Template Extension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTNodeTemplateExtension()
     * @generated
     */
    EClass TNODE_TEMPLATE_EXTENSION = eINSTANCE.getTNodeTemplateExtension();

    /**
     * The meta object literal for the '<em><b>Application Component Elasticity Requirements</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS = eINSTANCE.getTNodeTemplateExtension_ApplicationComponentElasticityRequirements();

    /**
     * The meta object literal for the '<em><b>Application Component Data Hints</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS = eINSTANCE.getTNodeTemplateExtension_ApplicationComponentDataHints();

    /**
     * The meta object literal for the '<em><b>Application Component Load Hints</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS = eINSTANCE.getTNodeTemplateExtension_ApplicationComponentLoadHints();

    /**
     * The meta object literal for the '<em><b>Application Component Monitoring Probes</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_MONITORING_PROBES = eINSTANCE.getTNodeTemplateExtension_ApplicationComponentMonitoringProbes();

    /**
     * The meta object literal for the '<em><b>Application Component Resizing Actions</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_RESIZING_ACTIONS = eINSTANCE.getTNodeTemplateExtension_ApplicationComponentResizingActions();

    /**
     * The meta object literal for the '<em><b>Application Component VMI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_VMI = eINSTANCE.getTNodeTemplateExtension_ApplicationComponentVMI();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory <em>Application Component Elasticity Requirement Category</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationComponentElasticityRequirementCategory()
     * @generated
     */
    EEnum APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY = eINSTANCE.getApplicationComponentElasticityRequirementCategory();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.DataHintCategory <em>Data Hint Category</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.DataHintCategory
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getDataHintCategory()
     * @generated
     */
    EEnum DATA_HINT_CATEGORY = eINSTANCE.getDataHintCategory();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory <em>Global Elasticity Requirement Category</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getGlobalElasticityRequirementCategory()
     * @generated
     */
    EEnum GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY = eINSTANCE.getGlobalElasticityRequirementCategory();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.LoadHintCategory <em>Load Hint Category</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.LoadHintCategory
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getLoadHintCategory()
     * @generated
     */
    EEnum LOAD_HINT_CATEGORY = eINSTANCE.getLoadHintCategory();

    /**
     * The meta object literal for the '<em>Application Component Elasticity Requirement Category Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationComponentElasticityRequirementCategoryObject()
     * @generated
     */
    EDataType APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT = eINSTANCE.getApplicationComponentElasticityRequirementCategoryObject();

    /**
     * The meta object literal for the '<em>Data Hint Category Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.DataHintCategory
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getDataHintCategoryObject()
     * @generated
     */
    EDataType DATA_HINT_CATEGORY_OBJECT = eINSTANCE.getDataHintCategoryObject();

    /**
     * The meta object literal for the '<em>Global Elasticity Requirement Category Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getGlobalElasticityRequirementCategoryObject()
     * @generated
     */
    EDataType GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT = eINSTANCE.getGlobalElasticityRequirementCategoryObject();

    /**
     * The meta object literal for the '<em>Load Hint Category Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.LoadHintCategory
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getLoadHintCategoryObject()
     * @generated
     */
    EDataType LOAD_HINT_CATEGORY_OBJECT = eINSTANCE.getLoadHintCategoryObject();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.TMonitoringProbeImpl <em>TMonitoring Probe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.elasticity.impl.TMonitoringProbeImpl
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTMonitoringProbe()
     * @generated
     */
    EClass TMONITORING_PROBE = eINSTANCE.getTMonitoringProbe();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TMONITORING_PROBE__NAME = eINSTANCE.getTMonitoringProbe_Name();

    /**
     * The meta object literal for the '<em>TVirtual Machine Image</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTVirtualMachineImage()
     * @generated
     */
    EDataType TVIRTUAL_MACHINE_IMAGE = eINSTANCE.getTVirtualMachineImage();

  }

} //Tosca_Elasticity_ExtensionsPackage
