/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TFulfilled Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.TFulfilledConstraint#getConstraintId <em>Constraint Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTFulfilledConstraint()
 * @model extendedMetaData="name='tFulfilledConstraint' kind='empty'"
 * @generated
 */
public interface TFulfilledConstraint extends EObject
{
  /**
   * Returns the value of the '<em><b>Constraint Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint Id</em>' attribute.
   * @see #setConstraintId(String)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTFulfilledConstraint_ConstraintId()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='attribute' name='ConstraintId'"
   * @generated
   */
  String getConstraintId();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TFulfilledConstraint#getConstraintId <em>Constraint Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint Id</em>' attribute.
   * @see #getConstraintId()
   * @generated
   */
  void setConstraintId(String value);

} // TFulfilledConstraint
