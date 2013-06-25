/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capability Definitions Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.CapabilityDefinitionsType#getCapabilityDefinition <em>Capability Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getCapabilityDefinitionsType()
 * @model extendedMetaData="name='CapabilityDefinitions_._type' kind='elementOnly'"
 * @generated
 */
public interface CapabilityDefinitionsType extends EObject
{
  /**
   * Returns the value of the '<em><b>Capability Definition</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TCapabilityDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capability Definition</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capability Definition</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getCapabilityDefinitionsType_CapabilityDefinition()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='CapabilityDefinition' namespace='##targetNamespace'"
   * @generated
   */
  EList<TCapabilityDefinition> getCapabilityDefinition();

} // CapabilityDefinitionsType
