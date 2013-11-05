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
 *    <div id="usage" xml:id="usage" xmlns="http://www.w3.org/1999/xhtml">
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
 *    <div id="nsversioning" xml:id="nsversioning" xmlns="http://www.w3.org/1999/xhtml">
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
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.DataHintsType1Impl <em>Data Hints Type1</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.impl.DataHintsType1Impl
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getDataHintsType1()
	 * @generated
	 */
  int DATA_HINTS_TYPE1 = 0;

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
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.LoadHintsType1Impl <em>Load Hints Type1</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.impl.LoadHintsType1Impl
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getLoadHintsType1()
	 * @generated
	 */
  int LOAD_HINTS_TYPE1 = 1;

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
  int MONITORING_PROBES_TYPE1 = 2;

  /**
	 * The feature id for the '<em><b>Monitoring Probes</b></em>' containment reference list.
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
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TBoundaryDefinitionsExtensionImpl <em>TBoundary Definitions Extension</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.impl.TBoundaryDefinitionsExtensionImpl
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTBoundaryDefinitionsExtension()
	 * @generated
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION = 3;

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
	 * The feature id for the '<em><b>Monitoring Probes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES = ToscaPackage.TBOUNDARY_DEFINITIONS_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>TBoundary Definitions Extension</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION_FEATURE_COUNT = ToscaPackage.TBOUNDARY_DEFINITIONS_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TDataHintImpl <em>TData Hint</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.impl.TDataHintImpl
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTDataHint()
	 * @generated
	 */
  int TDATA_HINT = 4;

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
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TLoadHintImpl <em>TLoad Hint</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.impl.TLoadHintImpl
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTLoadHint()
	 * @generated
	 */
  int TLOAD_HINT = 5;

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
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TMonitoringProbeImpl <em>TMonitoring Probe</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.impl.TMonitoringProbeImpl
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTMonitoringProbe()
	 * @generated
	 */
  int TMONITORING_PROBE = 6;

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
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl <em>TNode Template Extension</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTNodeTemplateExtension()
	 * @generated
	 */
  int TNODE_TEMPLATE_EXTENSION = 7;

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
	 * The feature id for the '<em><b>Casmulti</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNODE_TEMPLATE_EXTENSION__CASMULTI = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 0;

		/**
	 * The feature id for the '<em><b>Init Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 1;

		/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNODE_TEMPLATE_EXTENSION__X = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 2;

		/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNODE_TEMPLATE_EXTENSION__Y = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 3;

		/**
	 * The feature id for the '<em><b>Ycsbmulti</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNODE_TEMPLATE_EXTENSION__YCSBMULTI = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 4;

		/**
	 * The number of structural features of the '<em>TNode Template Extension</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION_FEATURE_COUNT = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 5;

  /**
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory <em>Application Component Elasticity Requirement Category</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationComponentElasticityRequirementCategory()
	 * @generated
	 */
  int APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY = 8;

  /**
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.ApplicationPolicyCategory <em>Application Policy Category</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.ApplicationPolicyCategory
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationPolicyCategory()
	 * @generated
	 */
  int APPLICATION_POLICY_CATEGORY = 9;

  /**
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.DataHintCategory <em>Data Hint Category</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.DataHintCategory
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getDataHintCategory()
	 * @generated
	 */
  int DATA_HINT_CATEGORY = 10;

  /**
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.ElasticityRequirementCategory <em>Elasticity Requirement Category</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.ElasticityRequirementCategory
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getElasticityRequirementCategory()
	 * @generated
	 */
  int ELASTICITY_REQUIREMENT_CATEGORY = 11;

  /**
	 * The meta object id for the '{@link eu.celar.tosca.elasticity.LoadHintCategory <em>Load Hint Category</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.LoadHintCategory
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getLoadHintCategory()
	 * @generated
	 */
  int LOAD_HINT_CATEGORY = 12;

  /**
	 * The meta object id for the '<em>Application Component Elasticity Requirement Category Object</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationComponentElasticityRequirementCategoryObject()
	 * @generated
	 */
  int APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT = 13;

  /**
	 * The meta object id for the '<em>Application Policy Category Object</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.ApplicationPolicyCategory
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationPolicyCategoryObject()
	 * @generated
	 */
  int APPLICATION_POLICY_CATEGORY_OBJECT = 14;

  /**
	 * The meta object id for the '<em>Data Hint Category Object</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.DataHintCategory
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getDataHintCategoryObject()
	 * @generated
	 */
  int DATA_HINT_CATEGORY_OBJECT = 15;

  /**
	 * The meta object id for the '<em>Elasticity Requirement Category Object</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.ElasticityRequirementCategory
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getElasticityRequirementCategoryObject()
	 * @generated
	 */
  int ELASTICITY_REQUIREMENT_CATEGORY_OBJECT = 16;

  /**
	 * The meta object id for the '<em>Load Hint Category Object</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see eu.celar.tosca.elasticity.LoadHintCategory
	 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getLoadHintCategoryObject()
	 * @generated
	 */
  int LOAD_HINT_CATEGORY_OBJECT = 17;


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
	 * Returns the meta object for the containment reference list '{@link eu.celar.tosca.elasticity.MonitoringProbesType1#getMonitoringProbes <em>Monitoring Probes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Monitoring Probes</em>'.
	 * @see eu.celar.tosca.elasticity.MonitoringProbesType1#getMonitoringProbes()
	 * @see #getMonitoringProbesType1()
	 * @generated
	 */
  EReference getMonitoringProbesType1_MonitoringProbes();

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
	 * Returns the meta object for class '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension <em>TNode Template Extension</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TNode Template Extension</em>'.
	 * @see eu.celar.tosca.elasticity.TNodeTemplateExtension
	 * @generated
	 */
  EClass getTNodeTemplateExtension();

  /**
	 * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getCasmulti <em>Casmulti</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Casmulti</em>'.
	 * @see eu.celar.tosca.elasticity.TNodeTemplateExtension#getCasmulti()
	 * @see #getTNodeTemplateExtension()
	 * @generated
	 */
	EAttribute getTNodeTemplateExtension_Casmulti();

		/**
	 * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getInitInstances <em>Init Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init Instances</em>'.
	 * @see eu.celar.tosca.elasticity.TNodeTemplateExtension#getInitInstances()
	 * @see #getTNodeTemplateExtension()
	 * @generated
	 */
	EAttribute getTNodeTemplateExtension_InitInstances();

		/**
	 * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see eu.celar.tosca.elasticity.TNodeTemplateExtension#getX()
	 * @see #getTNodeTemplateExtension()
	 * @generated
	 */
	EAttribute getTNodeTemplateExtension_X();

		/**
	 * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see eu.celar.tosca.elasticity.TNodeTemplateExtension#getY()
	 * @see #getTNodeTemplateExtension()
	 * @generated
	 */
	EAttribute getTNodeTemplateExtension_Y();

		/**
	 * Returns the meta object for the attribute '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getYcsbmulti <em>Ycsbmulti</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ycsbmulti</em>'.
	 * @see eu.celar.tosca.elasticity.TNodeTemplateExtension#getYcsbmulti()
	 * @see #getTNodeTemplateExtension()
	 * @generated
	 */
	EAttribute getTNodeTemplateExtension_Ycsbmulti();

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
	 * Returns the meta object for enum '{@link eu.celar.tosca.elasticity.ApplicationPolicyCategory <em>Application Policy Category</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Application Policy Category</em>'.
	 * @see eu.celar.tosca.elasticity.ApplicationPolicyCategory
	 * @generated
	 */
  EEnum getApplicationPolicyCategory();

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
	 * Returns the meta object for enum '{@link eu.celar.tosca.elasticity.ElasticityRequirementCategory <em>Elasticity Requirement Category</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Elasticity Requirement Category</em>'.
	 * @see eu.celar.tosca.elasticity.ElasticityRequirementCategory
	 * @generated
	 */
  EEnum getElasticityRequirementCategory();

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
	 * Returns the meta object for data type '{@link eu.celar.tosca.elasticity.ApplicationPolicyCategory <em>Application Policy Category Object</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Application Policy Category Object</em>'.
	 * @see eu.celar.tosca.elasticity.ApplicationPolicyCategory
	 * @model instanceClass="eu.celar.tosca.elasticity.ApplicationPolicyCategory"
	 *        extendedMetaData="name='ApplicationPolicyCategory:Object' baseType='ApplicationPolicyCategory'"
	 * @generated
	 */
  EDataType getApplicationPolicyCategoryObject();

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
	 * Returns the meta object for data type '{@link eu.celar.tosca.elasticity.ElasticityRequirementCategory <em>Elasticity Requirement Category Object</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Elasticity Requirement Category Object</em>'.
	 * @see eu.celar.tosca.elasticity.ElasticityRequirementCategory
	 * @model instanceClass="eu.celar.tosca.elasticity.ElasticityRequirementCategory"
	 *        extendedMetaData="name='ElasticityRequirementCategory:Object' baseType='ElasticityRequirementCategory'"
	 * @generated
	 */
  EDataType getElasticityRequirementCategoryObject();

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
		 * The meta object literal for the '<em><b>Monitoring Probes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MONITORING_PROBES_TYPE1__MONITORING_PROBES = eINSTANCE.getMonitoringProbesType1_MonitoringProbes();

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
		 * The meta object literal for the '{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl <em>TNode Template Extension</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl
		 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTNodeTemplateExtension()
		 * @generated
		 */
    EClass TNODE_TEMPLATE_EXTENSION = eINSTANCE.getTNodeTemplateExtension();

    /**
		 * The meta object literal for the '<em><b>Casmulti</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TNODE_TEMPLATE_EXTENSION__CASMULTI = eINSTANCE.getTNodeTemplateExtension_Casmulti();

				/**
		 * The meta object literal for the '<em><b>Init Instances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES = eINSTANCE.getTNodeTemplateExtension_InitInstances();

				/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TNODE_TEMPLATE_EXTENSION__X = eINSTANCE.getTNodeTemplateExtension_X();

				/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TNODE_TEMPLATE_EXTENSION__Y = eINSTANCE.getTNodeTemplateExtension_Y();

				/**
		 * The meta object literal for the '<em><b>Ycsbmulti</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TNODE_TEMPLATE_EXTENSION__YCSBMULTI = eINSTANCE.getTNodeTemplateExtension_Ycsbmulti();

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
		 * The meta object literal for the '{@link eu.celar.tosca.elasticity.ApplicationPolicyCategory <em>Application Policy Category</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see eu.celar.tosca.elasticity.ApplicationPolicyCategory
		 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationPolicyCategory()
		 * @generated
		 */
    EEnum APPLICATION_POLICY_CATEGORY = eINSTANCE.getApplicationPolicyCategory();

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
		 * The meta object literal for the '{@link eu.celar.tosca.elasticity.ElasticityRequirementCategory <em>Elasticity Requirement Category</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see eu.celar.tosca.elasticity.ElasticityRequirementCategory
		 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getElasticityRequirementCategory()
		 * @generated
		 */
    EEnum ELASTICITY_REQUIREMENT_CATEGORY = eINSTANCE.getElasticityRequirementCategory();

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
		 * The meta object literal for the '<em>Application Policy Category Object</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see eu.celar.tosca.elasticity.ApplicationPolicyCategory
		 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getApplicationPolicyCategoryObject()
		 * @generated
		 */
    EDataType APPLICATION_POLICY_CATEGORY_OBJECT = eINSTANCE.getApplicationPolicyCategoryObject();

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
		 * The meta object literal for the '<em>Elasticity Requirement Category Object</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see eu.celar.tosca.elasticity.ElasticityRequirementCategory
		 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getElasticityRequirementCategoryObject()
		 * @generated
		 */
    EDataType ELASTICITY_REQUIREMENT_CATEGORY_OBJECT = eINSTANCE.getElasticityRequirementCategoryObject();

    /**
		 * The meta object literal for the '<em>Load Hint Category Object</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see eu.celar.tosca.elasticity.LoadHintCategory
		 * @see eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getLoadHintCategoryObject()
		 * @generated
		 */
    EDataType LOAD_HINT_CATEGORY_OBJECT = eINSTANCE.getLoadHintCategoryObject();

  }

} //Tosca_Elasticity_ExtensionsPackage
