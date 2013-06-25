/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Interfaces Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TargetInterfacesType#getInterface <em>Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTargetInterfacesType()
 * @model extendedMetaData="name='TargetInterfaces_._type' kind='elementOnly'"
 * @generated
 */
public interface TargetInterfacesType extends EObject
{
  /**
   * Returns the value of the '<em><b>Interface</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TInterface}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interface</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interface</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getTargetInterfacesType_Interface()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='Interface' namespace='##targetNamespace'"
   * @generated
   */
  EList<TInterface> getInterface();

} // TargetInterfacesType
