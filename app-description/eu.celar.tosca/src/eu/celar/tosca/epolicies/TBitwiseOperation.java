/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TBitwise Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseLeftHandSide <em>Bitwise Left Hand Side</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseRightHandSide <em>Bitwise Right Hand Side</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseOperator <em>Bitwise Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTBitwiseOperation()
 * @model extendedMetaData="name='tBitwiseOperation' kind='elementOnly'"
 * @generated
 */
public interface TBitwiseOperation extends EObject
{
  /**
   * Returns the value of the '<em><b>Bitwise Left Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bitwise Left Hand Side</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bitwise Left Hand Side</em>' containment reference.
   * @see #setBitwiseLeftHandSide(BitwiseLeftHandSideType)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTBitwiseOperation_BitwiseLeftHandSide()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='BitwiseLeftHandSide'"
   * @generated
   */
  BitwiseLeftHandSideType getBitwiseLeftHandSide();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseLeftHandSide <em>Bitwise Left Hand Side</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bitwise Left Hand Side</em>' containment reference.
   * @see #getBitwiseLeftHandSide()
   * @generated
   */
  void setBitwiseLeftHandSide(BitwiseLeftHandSideType value);

  /**
   * Returns the value of the '<em><b>Bitwise Right Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bitwise Right Hand Side</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bitwise Right Hand Side</em>' containment reference.
   * @see #setBitwiseRightHandSide(BitwiseRightHandSideType)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTBitwiseOperation_BitwiseRightHandSide()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='BitwiseRightHandSide'"
   * @generated
   */
  BitwiseRightHandSideType getBitwiseRightHandSide();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseRightHandSide <em>Bitwise Right Hand Side</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bitwise Right Hand Side</em>' containment reference.
   * @see #getBitwiseRightHandSide()
   * @generated
   */
  void setBitwiseRightHandSide(BitwiseRightHandSideType value);

  /**
   * Returns the value of the '<em><b>Bitwise Operator</b></em>' attribute.
   * The literals are from the enumeration {@link eu.celar.tosca.epolicies.TBitwiseOperationType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bitwise Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bitwise Operator</em>' attribute.
   * @see eu.celar.tosca.epolicies.TBitwiseOperationType
   * @see #isSetBitwiseOperator()
   * @see #unsetBitwiseOperator()
   * @see #setBitwiseOperator(TBitwiseOperationType)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTBitwiseOperation_BitwiseOperator()
   * @model unsettable="true" required="true"
   *        extendedMetaData="kind='attribute' name='BitwiseOperator'"
   * @generated
   */
  TBitwiseOperationType getBitwiseOperator();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseOperator <em>Bitwise Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bitwise Operator</em>' attribute.
   * @see eu.celar.tosca.epolicies.TBitwiseOperationType
   * @see #isSetBitwiseOperator()
   * @see #unsetBitwiseOperator()
   * @see #getBitwiseOperator()
   * @generated
   */
  void setBitwiseOperator(TBitwiseOperationType value);

  /**
   * Unsets the value of the '{@link eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseOperator <em>Bitwise Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBitwiseOperator()
   * @see #getBitwiseOperator()
   * @see #setBitwiseOperator(TBitwiseOperationType)
   * @generated
   */
  void unsetBitwiseOperator();

  /**
   * Returns whether the value of the '{@link eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseOperator <em>Bitwise Operator</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Bitwise Operator</em>' attribute is set.
   * @see #unsetBitwiseOperator()
   * @see #getBitwiseOperator()
   * @see #setBitwiseOperator(TBitwiseOperationType)
   * @generated
   */
  boolean isSetBitwiseOperator();

} // TBitwiseOperation
