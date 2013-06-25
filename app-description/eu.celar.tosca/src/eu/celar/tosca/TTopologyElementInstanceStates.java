/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTopology Element Instance States</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TTopologyElementInstanceStates#getInstanceState <em>Instance State</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTTopologyElementInstanceStates()
 * @model extendedMetaData="name='tTopologyElementInstanceStates' kind='elementOnly'"
 * @generated
 */
public interface TTopologyElementInstanceStates extends EObject
{
  /**
   * Returns the value of the '<em><b>Instance State</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.InstanceStateType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instance State</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance State</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getTTopologyElementInstanceStates_InstanceState()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='InstanceState' namespace='##targetNamespace'"
   * @generated
   */
  EList<InstanceStateType> getInstanceState();

} // TTopologyElementInstanceStates
