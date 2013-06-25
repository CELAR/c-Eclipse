/**
 */
package eu.celar.tosca;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Properties Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.PropertiesType1#getAny <em>Any</em>}</li>
 *   <li>{@link eu.celar.tosca.PropertiesType1#getPropertyMappings <em>Property Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getPropertiesType1()
 * @model extendedMetaData="name='Properties_._1_._type' kind='elementOnly'"
 * @generated
 */
public interface PropertiesType1 extends EObject
{
  /**
   * Returns the value of the '<em><b>Any</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any</em>' attribute list.
   * @see eu.celar.tosca.ToscaPackage#getPropertiesType1_Any()
   * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" required="true" many="false"
   *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':0' processing='strict'"
   * @generated
   */
  FeatureMap getAny();

  /**
   * Returns the value of the '<em><b>Property Mappings</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Mappings</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Mappings</em>' containment reference.
   * @see #setPropertyMappings(PropertyMappingsType)
   * @see eu.celar.tosca.ToscaPackage#getPropertiesType1_PropertyMappings()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='PropertyMappings' namespace='##targetNamespace'"
   * @generated
   */
  PropertyMappingsType getPropertyMappings();

  /**
   * Sets the value of the '{@link eu.celar.tosca.PropertiesType1#getPropertyMappings <em>Property Mappings</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Mappings</em>' containment reference.
   * @see #getPropertyMappings()
   * @generated
   */
  void setPropertyMappings(PropertyMappingsType value);

} // PropertiesType1
