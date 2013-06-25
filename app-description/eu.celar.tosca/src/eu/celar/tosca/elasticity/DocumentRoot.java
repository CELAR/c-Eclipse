/**
 */
package eu.celar.tosca.elasticity;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.DocumentRoot#getGlobalElasticityRequirementsType1 <em>Global Elasticity Requirements Type1</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.DocumentRoot#getTBoundaryDefinitionsExtension <em>TBoundary Definitions Extension</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.DocumentRoot#getTGlobalElasticityRequirement <em>TGlobal Elasticity Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.ToscaElasticityExtensionsPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject
{
  /**
   * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mixed</em>' attribute list.
   * @see eu.celar.tosca.elasticity.ToscaElasticityExtensionsPackage#getDocumentRoot_Mixed()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='elementWildcard' name=':mixed'"
   * @generated
   */
  FeatureMap getMixed();

  /**
   * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
   * The key is of type {@link java.lang.String},
   * and the value is of type {@link java.lang.String},
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>XMLNS Prefix Map</em>' map.
   * @see eu.celar.tosca.elasticity.ToscaElasticityExtensionsPackage#getDocumentRoot_XMLNSPrefixMap()
   * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
   *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
   * @generated
   */
  EMap<String, String> getXMLNSPrefixMap();

  /**
   * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
   * The key is of type {@link java.lang.String},
   * and the value is of type {@link java.lang.String},
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>XSI Schema Location</em>' map.
   * @see eu.celar.tosca.elasticity.ToscaElasticityExtensionsPackage#getDocumentRoot_XSISchemaLocation()
   * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
   *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
   * @generated
   */
  EMap<String, String> getXSISchemaLocation();

  /**
   * Returns the value of the '<em><b>Global Elasticity Requirements Type1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Global Elasticity Requirements Type1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Global Elasticity Requirements Type1</em>' containment reference.
   * @see #setGlobalElasticityRequirementsType1(GlobalElasticityRequirementsType1)
   * @see eu.celar.tosca.elasticity.ToscaElasticityExtensionsPackage#getDocumentRoot_GlobalElasticityRequirementsType1()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='GlobalElasticityRequirementsType1' namespace='##targetNamespace'"
   * @generated
   */
  GlobalElasticityRequirementsType1 getGlobalElasticityRequirementsType1();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.DocumentRoot#getGlobalElasticityRequirementsType1 <em>Global Elasticity Requirements Type1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Global Elasticity Requirements Type1</em>' containment reference.
   * @see #getGlobalElasticityRequirementsType1()
   * @generated
   */
  void setGlobalElasticityRequirementsType1(GlobalElasticityRequirementsType1 value);

  /**
   * Returns the value of the '<em><b>TBoundary Definitions Extension</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>TBoundary Definitions Extension</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>TBoundary Definitions Extension</em>' containment reference.
   * @see #setTBoundaryDefinitionsExtension(TBoundaryDefinitionsExtension)
   * @see eu.celar.tosca.elasticity.ToscaElasticityExtensionsPackage#getDocumentRoot_TBoundaryDefinitionsExtension()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='TBoundaryDefinitionsExtension' namespace='##targetNamespace'"
   * @generated
   */
  TBoundaryDefinitionsExtension getTBoundaryDefinitionsExtension();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.DocumentRoot#getTBoundaryDefinitionsExtension <em>TBoundary Definitions Extension</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>TBoundary Definitions Extension</em>' containment reference.
   * @see #getTBoundaryDefinitionsExtension()
   * @generated
   */
  void setTBoundaryDefinitionsExtension(TBoundaryDefinitionsExtension value);

  /**
   * Returns the value of the '<em><b>TGlobal Elasticity Requirement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>TGlobal Elasticity Requirement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>TGlobal Elasticity Requirement</em>' containment reference.
   * @see #setTGlobalElasticityRequirement(TGlobalElasticityRequirement)
   * @see eu.celar.tosca.elasticity.ToscaElasticityExtensionsPackage#getDocumentRoot_TGlobalElasticityRequirement()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='TGlobalElasticityRequirement' namespace='##targetNamespace'"
   * @generated
   */
  TGlobalElasticityRequirement getTGlobalElasticityRequirement();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.DocumentRoot#getTGlobalElasticityRequirement <em>TGlobal Elasticity Requirement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>TGlobal Elasticity Requirement</em>' containment reference.
   * @see #getTGlobalElasticityRequirement()
   * @generated
   */
  void setTGlobalElasticityRequirement(TGlobalElasticityRequirement value);

} // DocumentRoot
