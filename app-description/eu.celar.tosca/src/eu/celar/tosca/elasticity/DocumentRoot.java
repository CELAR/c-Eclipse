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
 *   <li>{@link eu.celar.tosca.elasticity.DocumentRoot#getImageArtifactProperties <em>Image Artifact Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.DocumentRoot#getNodeProperties <em>Node Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.DocumentRoot#getScriptArtifactProperties <em>Script Artifact Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.DocumentRoot#getServiceProperties <em>Service Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot()
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
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_Mixed()
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
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_XMLNSPrefixMap()
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
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_XSISchemaLocation()
   * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
   *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
   * @generated
   */
  EMap<String, String> getXSISchemaLocation();

  /**
   * Returns the value of the '<em><b>Image Artifact Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Image Artifact Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Image Artifact Properties</em>' containment reference.
   * @see #setImageArtifactProperties(ImageArtifactPropertiesType)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_ImageArtifactProperties()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='ImageArtifactProperties' namespace='##targetNamespace'"
   * @generated
   */
  ImageArtifactPropertiesType getImageArtifactProperties();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.DocumentRoot#getImageArtifactProperties <em>Image Artifact Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Image Artifact Properties</em>' containment reference.
   * @see #getImageArtifactProperties()
   * @generated
   */
  void setImageArtifactProperties(ImageArtifactPropertiesType value);

  /**
   * Returns the value of the '<em><b>Node Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node Properties</em>' containment reference.
   * @see #setNodeProperties(NodePropertiesType)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_NodeProperties()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='NodeProperties' namespace='##targetNamespace'"
   * @generated
   */
  NodePropertiesType getNodeProperties();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.DocumentRoot#getNodeProperties <em>Node Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node Properties</em>' containment reference.
   * @see #getNodeProperties()
   * @generated
   */
  void setNodeProperties(NodePropertiesType value);

  /**
   * Returns the value of the '<em><b>Script Artifact Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Script Artifact Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Script Artifact Properties</em>' containment reference.
   * @see #setScriptArtifactProperties(ScriptArtifactPropertiesType)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_ScriptArtifactProperties()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='ScriptArtifactProperties' namespace='##targetNamespace'"
   * @generated
   */
  ScriptArtifactPropertiesType getScriptArtifactProperties();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.DocumentRoot#getScriptArtifactProperties <em>Script Artifact Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Script Artifact Properties</em>' containment reference.
   * @see #getScriptArtifactProperties()
   * @generated
   */
  void setScriptArtifactProperties(ScriptArtifactPropertiesType value);

  /**
   * Returns the value of the '<em><b>Service Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Service Properties</em>' containment reference.
   * @see #setServiceProperties(ServicePropertiesType)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_ServiceProperties()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='ServiceProperties' namespace='##targetNamespace'"
   * @generated
   */
  ServicePropertiesType getServiceProperties();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.DocumentRoot#getServiceProperties <em>Service Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Service Properties</em>' containment reference.
   * @see #getServiceProperties()
   * @generated
   */
  void setServiceProperties(ServicePropertiesType value);

} // DocumentRoot
