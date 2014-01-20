/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bitwise Right Hand Side Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.BitwiseRightHandSideType#getRightSimpleCondition <em>Right Simple Condition</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.BitwiseRightHandSideType#getRightCompexCondition <em>Right Compex Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getBitwiseRightHandSideType()
 * @model extendedMetaData="name='BitwiseRightHandSide_._type' kind='elementOnly'"
 * @generated
 */
public interface BitwiseRightHandSideType extends EObject
{
  /**
   * Returns the value of the '<em><b>Right Simple Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Simple Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Simple Condition</em>' containment reference.
   * @see #setRightSimpleCondition(TRelationOperation)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getBitwiseRightHandSideType_RightSimpleCondition()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='RightSimpleCondition'"
   * @generated
   */
  TRelationOperation getRightSimpleCondition();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.BitwiseRightHandSideType#getRightSimpleCondition <em>Right Simple Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Simple Condition</em>' containment reference.
   * @see #getRightSimpleCondition()
   * @generated
   */
  void setRightSimpleCondition(TRelationOperation value);

  /**
   * Returns the value of the '<em><b>Right Compex Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Compex Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Compex Condition</em>' containment reference.
   * @see #setRightCompexCondition(TBitwiseOperation)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getBitwiseRightHandSideType_RightCompexCondition()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='RightCompexCondition'"
   * @generated
   */
  TBitwiseOperation getRightCompexCondition();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.BitwiseRightHandSideType#getRightCompexCondition <em>Right Compex Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Compex Condition</em>' containment reference.
   * @see #getRightCompexCondition()
   * @generated
   */
  void setRightCompexCondition(TBitwiseOperation value);

} // BitwiseRightHandSideType
