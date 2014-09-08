/**
 */
package org.example.sybl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.sybl.ConditionType1#getBinaryRestrictionsConjunction <em>Binary Restrictions Conjunction</em>}</li>
 *   <li>{@link org.example.sybl.ConditionType1#getUnaryRestrictionsConjunction <em>Unary Restrictions Conjunction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.sybl.SyblPackage#getConditionType1()
 * @model extendedMetaData="name='Condition_._type' kind='elementOnly'"
 * @generated
 */
public interface ConditionType1 extends EObject
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
   * @see org.example.sybl.SyblPackage#getConditionType1_BinaryRestrictionsConjunction()
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
   * @see org.example.sybl.SyblPackage#getConditionType1_UnaryRestrictionsConjunction()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='UnaryRestrictionsConjunction'"
   * @generated
   */
  EList<UnaryRestriction> getUnaryRestrictionsConjunction();

} // ConditionType1
