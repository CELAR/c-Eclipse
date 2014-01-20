/**
 */
package eu.celar.tosca.hrequirements;

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
 *   <li>{@link eu.celar.tosca.hrequirements.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.DocumentRoot#getCPURequirementProperties <em>CPU Requirement Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.DocumentRoot#getMemoryRequirementProperties <em>Memory Requirement Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.DocumentRoot#getNetworkRequirementProperties <em>Network Requirement Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.DocumentRoot#getStorageRequiremetProperties <em>Storage Requiremet Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getDocumentRoot()
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
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getDocumentRoot_Mixed()
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
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getDocumentRoot_XMLNSPrefixMap()
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
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getDocumentRoot_XSISchemaLocation()
   * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
   *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
   * @generated
   */
  EMap<String, String> getXSISchemaLocation();

  /**
   * Returns the value of the '<em><b>CPU Requirement Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>CPU Requirement Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>CPU Requirement Properties</em>' containment reference.
   * @see #setCPURequirementProperties(TCPURequirementProperties)
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getDocumentRoot_CPURequirementProperties()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='CPURequirementProperties' namespace='##targetNamespace'"
   * @generated
   */
  TCPURequirementProperties getCPURequirementProperties();

  /**
   * Sets the value of the '{@link eu.celar.tosca.hrequirements.DocumentRoot#getCPURequirementProperties <em>CPU Requirement Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>CPU Requirement Properties</em>' containment reference.
   * @see #getCPURequirementProperties()
   * @generated
   */
  void setCPURequirementProperties(TCPURequirementProperties value);

  /**
   * Returns the value of the '<em><b>Memory Requirement Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Memory Requirement Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Memory Requirement Properties</em>' containment reference.
   * @see #setMemoryRequirementProperties(TMemoryRequirementProperties)
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getDocumentRoot_MemoryRequirementProperties()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='MemoryRequirementProperties' namespace='##targetNamespace'"
   * @generated
   */
  TMemoryRequirementProperties getMemoryRequirementProperties();

  /**
   * Sets the value of the '{@link eu.celar.tosca.hrequirements.DocumentRoot#getMemoryRequirementProperties <em>Memory Requirement Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Memory Requirement Properties</em>' containment reference.
   * @see #getMemoryRequirementProperties()
   * @generated
   */
  void setMemoryRequirementProperties(TMemoryRequirementProperties value);

  /**
   * Returns the value of the '<em><b>Network Requirement Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Network Requirement Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Network Requirement Properties</em>' containment reference.
   * @see #setNetworkRequirementProperties(TNetworkRequirementProperties)
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getDocumentRoot_NetworkRequirementProperties()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='NetworkRequirementProperties' namespace='##targetNamespace'"
   * @generated
   */
  TNetworkRequirementProperties getNetworkRequirementProperties();

  /**
   * Sets the value of the '{@link eu.celar.tosca.hrequirements.DocumentRoot#getNetworkRequirementProperties <em>Network Requirement Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Network Requirement Properties</em>' containment reference.
   * @see #getNetworkRequirementProperties()
   * @generated
   */
  void setNetworkRequirementProperties(TNetworkRequirementProperties value);

  /**
   * Returns the value of the '<em><b>Storage Requiremet Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Storage Requiremet Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Storage Requiremet Properties</em>' containment reference.
   * @see #setStorageRequiremetProperties(TStorageRequirementProperties)
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getDocumentRoot_StorageRequiremetProperties()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='StorageRequiremetProperties' namespace='##targetNamespace'"
   * @generated
   */
  TStorageRequirementProperties getStorageRequiremetProperties();

  /**
   * Sets the value of the '{@link eu.celar.tosca.hrequirements.DocumentRoot#getStorageRequiremetProperties <em>Storage Requiremet Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Storage Requiremet Properties</em>' containment reference.
   * @see #getStorageRequiremetProperties()
   * @generated
   */
  void setStorageRequiremetProperties(TStorageRequirementProperties value);

} // DocumentRoot
