/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Policies Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.PoliciesType#getPolicy <em>Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getPoliciesType()
 * @model extendedMetaData="name='Policies_._type' kind='elementOnly'"
 * @generated
 */
public interface PoliciesType extends EObject
{
  /**
   * Returns the value of the '<em><b>Policy</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TPolicy}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Policy</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Policy</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getPoliciesType_Policy()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='Policy' namespace='##targetNamespace'"
   * @generated
   */
  EList<TPolicy> getPolicy();

} // PoliciesType
