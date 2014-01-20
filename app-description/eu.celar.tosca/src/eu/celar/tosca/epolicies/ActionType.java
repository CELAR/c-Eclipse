/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.ActionType#getActionParameter <em>Action Parameter</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.ActionType#getActionName <em>Action Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getActionType()
 * @model extendedMetaData="name='Action_._type' kind='elementOnly'"
 * @generated
 */
public interface ActionType extends EObject
{
  /**
   * Returns the value of the '<em><b>Action Parameter</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.epolicies.TActionParameterType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action Parameter</em>' containment reference list.
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getActionType_ActionParameter()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='ActionParameter'"
   * @generated
   */
  EList<TActionParameterType> getActionParameter();

  /**
   * Returns the value of the '<em><b>Action Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action Name</em>' attribute.
   * @see #setActionName(String)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getActionType_ActionName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='attribute' name='ActionName'"
   * @generated
   */
  String getActionName();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.ActionType#getActionName <em>Action Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action Name</em>' attribute.
   * @see #getActionName()
   * @generated
   */
  void setActionName(String value);

} // ActionType
