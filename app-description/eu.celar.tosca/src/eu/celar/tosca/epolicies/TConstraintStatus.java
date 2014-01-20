/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TConstraint Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.TConstraintStatus#getViolated <em>Violated</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TConstraintStatus#getFulfilled <em>Fulfilled</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTConstraintStatus()
 * @model extendedMetaData="name='tConstraintStatus' kind='elementOnly'"
 * @generated
 */
public interface TConstraintStatus extends EObject
{
  /**
   * Returns the value of the '<em><b>Violated</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Violated</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Violated</em>' containment reference.
   * @see #setViolated(TViolatedConstraint)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTConstraintStatus_Violated()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Violated'"
   * @generated
   */
  TViolatedConstraint getViolated();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TConstraintStatus#getViolated <em>Violated</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Violated</em>' containment reference.
   * @see #getViolated()
   * @generated
   */
  void setViolated(TViolatedConstraint value);

  /**
   * Returns the value of the '<em><b>Fulfilled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fulfilled</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fulfilled</em>' containment reference.
   * @see #setFulfilled(TFulfilledConstraint)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTConstraintStatus_Fulfilled()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Fulfilled'"
   * @generated
   */
  TFulfilledConstraint getFulfilled();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TConstraintStatus#getFulfilled <em>Fulfilled</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fulfilled</em>' containment reference.
   * @see #getFulfilled()
   * @generated
   */
  void setFulfilled(TFulfilledConstraint value);

} // TConstraintStatus
