/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Mappings Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.PropertyMappingsType#getPropertyMapping <em>Property Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getPropertyMappingsType()
 * @model extendedMetaData="name='PropertyMappings_._type' kind='elementOnly'"
 * @generated
 */
public interface PropertyMappingsType extends EObject
{
  /**
   * Returns the value of the '<em><b>Property Mapping</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TPropertyMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Mapping</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Mapping</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getPropertyMappingsType_PropertyMapping()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='PropertyMapping' namespace='##targetNamespace'"
   * @generated
   */
  EList<TPropertyMapping> getPropertyMapping();

} // PropertyMappingsType
