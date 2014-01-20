/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TRelation Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.TRelationOperation#getRelationLeftHandSide <em>Relation Left Hand Side</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TRelationOperation#getRelationRightHandSide <em>Relation Right Hand Side</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TRelationOperation#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTRelationOperation()
 * @model extendedMetaData="name='tRelationOperation' kind='elementOnly'"
 * @generated
 */
public interface TRelationOperation extends EObject
{
  /**
   * Returns the value of the '<em><b>Relation Left Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relation Left Hand Side</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relation Left Hand Side</em>' containment reference.
   * @see #setRelationLeftHandSide(RelationLeftHandSideType)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTRelationOperation_RelationLeftHandSide()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='RelationLeftHandSide'"
   * @generated
   */
  RelationLeftHandSideType getRelationLeftHandSide();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TRelationOperation#getRelationLeftHandSide <em>Relation Left Hand Side</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relation Left Hand Side</em>' containment reference.
   * @see #getRelationLeftHandSide()
   * @generated
   */
  void setRelationLeftHandSide(RelationLeftHandSideType value);

  /**
   * Returns the value of the '<em><b>Relation Right Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relation Right Hand Side</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relation Right Hand Side</em>' containment reference.
   * @see #setRelationRightHandSide(RelationRightHandSideType)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTRelationOperation_RelationRightHandSide()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='RelationRightHandSide'"
   * @generated
   */
  RelationRightHandSideType getRelationRightHandSide();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TRelationOperation#getRelationRightHandSide <em>Relation Right Hand Side</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relation Right Hand Side</em>' containment reference.
   * @see #getRelationRightHandSide()
   * @generated
   */
  void setRelationRightHandSide(RelationRightHandSideType value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link eu.celar.tosca.epolicies.TRelationOperationType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see eu.celar.tosca.epolicies.TRelationOperationType
   * @see #isSetType()
   * @see #unsetType()
   * @see #setType(TRelationOperationType)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTRelationOperation_Type()
   * @model unsettable="true" required="true"
   *        extendedMetaData="kind='attribute' name='Type'"
   * @generated
   */
  TRelationOperationType getType();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TRelationOperation#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see eu.celar.tosca.epolicies.TRelationOperationType
   * @see #isSetType()
   * @see #unsetType()
   * @see #getType()
   * @generated
   */
  void setType(TRelationOperationType value);

  /**
   * Unsets the value of the '{@link eu.celar.tosca.epolicies.TRelationOperation#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetType()
   * @see #getType()
   * @see #setType(TRelationOperationType)
   * @generated
   */
  void unsetType();

  /**
   * Returns whether the value of the '{@link eu.celar.tosca.epolicies.TRelationOperation#getType <em>Type</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Type</em>' attribute is set.
   * @see #unsetType()
   * @see #getType()
   * @see #setType(TRelationOperationType)
   * @generated
   */
  boolean isSetType();

} // TRelationOperation
