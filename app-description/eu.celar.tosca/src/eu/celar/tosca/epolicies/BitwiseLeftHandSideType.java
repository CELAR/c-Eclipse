/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bitwise Left Hand Side Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.BitwiseLeftHandSideType#getLeftSimpleCondition <em>Left Simple Condition</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.BitwiseLeftHandSideType#getLeftCompexCondition <em>Left Compex Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getBitwiseLeftHandSideType()
 * @model extendedMetaData="name='BitwiseLeftHandSide_._type' kind='elementOnly'"
 * @generated
 */
public interface BitwiseLeftHandSideType extends EObject
{
  /**
   * Returns the value of the '<em><b>Left Simple Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Simple Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Simple Condition</em>' containment reference.
   * @see #setLeftSimpleCondition(TRelationOperation)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getBitwiseLeftHandSideType_LeftSimpleCondition()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='LeftSimpleCondition'"
   * @generated
   */
  TRelationOperation getLeftSimpleCondition();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.BitwiseLeftHandSideType#getLeftSimpleCondition <em>Left Simple Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Simple Condition</em>' containment reference.
   * @see #getLeftSimpleCondition()
   * @generated
   */
  void setLeftSimpleCondition(TRelationOperation value);

  /**
   * Returns the value of the '<em><b>Left Compex Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Compex Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Compex Condition</em>' containment reference.
   * @see #setLeftCompexCondition(TBitwiseOperation)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getBitwiseLeftHandSideType_LeftCompexCondition()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='LeftCompexCondition'"
   * @generated
   */
  TBitwiseOperation getLeftCompexCondition();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.BitwiseLeftHandSideType#getLeftCompexCondition <em>Left Compex Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Compex Condition</em>' containment reference.
   * @see #getLeftCompexCondition()
   * @generated
   */
  void setLeftCompexCondition(TBitwiseOperation value);

} // BitwiseLeftHandSideType
