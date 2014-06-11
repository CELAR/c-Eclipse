/**
 */
package org.example.sybl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>To Enforce Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.sybl.ToEnforceType1#getBinaryRestrictionsConjunction <em>Binary Restrictions Conjunction</em>}</li>
 *   <li>{@link org.example.sybl.ToEnforceType1#getUnaryRestrictionsConjunction <em>Unary Restrictions Conjunction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.sybl.SyblPackage#getToEnforceType1()
 * @model extendedMetaData="name='ToEnforce_._1_._type' kind='elementOnly'"
 * @generated
 */
public interface ToEnforceType1 extends EObject
{
  /**
   * Returns the value of the '<em><b>Binary Restrictions Conjunction</b></em>' containment reference list.
   * The list contents are of type {@link org.example.sybl.BinaryRestriction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Binary Restrictions Conjunction</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Binary Restrictions Conjunction</em>' containment reference list.
   * @see org.example.sybl.SyblPackage#getToEnforceType1_BinaryRestrictionsConjunction()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='BinaryRestrictionsConjunction'"
   * @generated
   */
  EList<BinaryRestriction> getBinaryRestrictionsConjunction();

  /**
   * Returns the value of the '<em><b>Unary Restrictions Conjunction</b></em>' containment reference list.
   * The list contents are of type {@link org.example.sybl.UnaryRestriction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unary Restrictions Conjunction</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unary Restrictions Conjunction</em>' containment reference list.
   * @see org.example.sybl.SyblPackage#getToEnforceType1_UnaryRestrictionsConjunction()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='UnaryRestrictionsConjunction'"
   * @generated
   */
  EList<UnaryRestriction> getUnaryRestrictionsConjunction();

} // ToEnforceType1
