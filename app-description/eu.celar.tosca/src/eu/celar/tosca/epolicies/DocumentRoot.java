/**
 */
package eu.celar.tosca.epolicies;

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
 *   <li>{@link eu.celar.tosca.epolicies.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.DocumentRoot#getElasticityConstraintProperties <em>Elasticity Constraint Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.DocumentRoot#getElasticityStrategyProperties <em>Elasticity Strategy Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getDocumentRoot()
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
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getDocumentRoot_Mixed()
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
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getDocumentRoot_XMLNSPrefixMap()
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
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getDocumentRoot_XSISchemaLocation()
   * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
   *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
   * @generated
   */
  EMap<String, String> getXSISchemaLocation();

  /**
   * Returns the value of the '<em><b>Elasticity Constraint Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elasticity Constraint Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elasticity Constraint Properties</em>' containment reference.
   * @see #setElasticityConstraintProperties(TElasticityConstraintProperties)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getDocumentRoot_ElasticityConstraintProperties()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='ElasticityConstraintProperties' namespace='##targetNamespace'"
   * @generated
   */
  TElasticityConstraintProperties getElasticityConstraintProperties();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.DocumentRoot#getElasticityConstraintProperties <em>Elasticity Constraint Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Elasticity Constraint Properties</em>' containment reference.
   * @see #getElasticityConstraintProperties()
   * @generated
   */
  void setElasticityConstraintProperties(TElasticityConstraintProperties value);

  /**
   * Returns the value of the '<em><b>Elasticity Strategy Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elasticity Strategy Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elasticity Strategy Properties</em>' containment reference.
   * @see #setElasticityStrategyProperties(TElasticityStrategyProperties)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getDocumentRoot_ElasticityStrategyProperties()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='ElasticityStrategyProperties' namespace='##targetNamespace'"
   * @generated
   */
  TElasticityStrategyProperties getElasticityStrategyProperties();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.DocumentRoot#getElasticityStrategyProperties <em>Elasticity Strategy Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Elasticity Strategy Properties</em>' containment reference.
   * @see #getElasticityStrategyProperties()
   * @generated
   */
  void setElasticityStrategyProperties(TElasticityStrategyProperties value);

} // DocumentRoot
