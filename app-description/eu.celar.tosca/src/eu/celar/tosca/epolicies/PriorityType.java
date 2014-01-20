/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Priority Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.PriorityType#getConstraintId <em>Constraint Id</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.PriorityType#getPriorityType <em>Priority Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getPriorityType()
 * @model extendedMetaData="name='Priority_._type' kind='empty'"
 * @generated
 */
public interface PriorityType extends EObject
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
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getPriorityType_ConstraintId()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='attribute' name='ConstraintId'"
   * @generated
   */
  String getConstraintId();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.PriorityType#getConstraintId <em>Constraint Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint Id</em>' attribute.
   * @see #getConstraintId()
   * @generated
   */
  void setConstraintId(String value);

  /**
   * Returns the value of the '<em><b>Priority Type</b></em>' attribute.
   * The literals are from the enumeration {@link eu.celar.tosca.epolicies.TPriorityType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority Type</em>' attribute.
   * @see eu.celar.tosca.epolicies.TPriorityType
   * @see #isSetPriorityType()
   * @see #unsetPriorityType()
   * @see #setPriorityType(TPriorityType)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getPriorityType_PriorityType()
   * @model unsettable="true" required="true"
   *        extendedMetaData="kind='attribute' name='PriorityType'"
   * @generated
   */
  TPriorityType getPriorityType();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.PriorityType#getPriorityType <em>Priority Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority Type</em>' attribute.
   * @see eu.celar.tosca.epolicies.TPriorityType
   * @see #isSetPriorityType()
   * @see #unsetPriorityType()
   * @see #getPriorityType()
   * @generated
   */
  void setPriorityType(TPriorityType value);

  /**
   * Unsets the value of the '{@link eu.celar.tosca.epolicies.PriorityType#getPriorityType <em>Priority Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPriorityType()
   * @see #getPriorityType()
   * @see #setPriorityType(TPriorityType)
   * @generated
   */
  void unsetPriorityType();

  /**
   * Returns whether the value of the '{@link eu.celar.tosca.epolicies.PriorityType#getPriorityType <em>Priority Type</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Priority Type</em>' attribute is set.
   * @see #unsetPriorityType()
   * @see #getPriorityType()
   * @see #setPriorityType(TPriorityType)
   * @generated
   */
  boolean isSetPriorityType();

} // PriorityType
