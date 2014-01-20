/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TElasticity Constraint Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties#getToEnforceSimpleConstraint <em>To Enforce Simple Constraint</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties#getToEnforceComplexConstraint <em>To Enforce Complex Constraint</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties#getPriority <em>Priority</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties#getConstraintId <em>Constraint Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTElasticityConstraintProperties()
 * @model extendedMetaData="name='tElasticityConstraintProperties' kind='elementOnly'"
 * @generated
 */
public interface TElasticityConstraintProperties extends EObject
{
  /**
   * Returns the value of the '<em><b>To Enforce Simple Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Enforce Simple Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Enforce Simple Constraint</em>' containment reference.
   * @see #setToEnforceSimpleConstraint(TRelationOperation)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTElasticityConstraintProperties_ToEnforceSimpleConstraint()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='ToEnforceSimpleConstraint'"
   * @generated
   */
  TRelationOperation getToEnforceSimpleConstraint();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties#getToEnforceSimpleConstraint <em>To Enforce Simple Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Enforce Simple Constraint</em>' containment reference.
   * @see #getToEnforceSimpleConstraint()
   * @generated
   */
  void setToEnforceSimpleConstraint(TRelationOperation value);

  /**
   * Returns the value of the '<em><b>To Enforce Complex Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Enforce Complex Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Enforce Complex Constraint</em>' containment reference.
   * @see #setToEnforceComplexConstraint(TBitwiseOperation)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTElasticityConstraintProperties_ToEnforceComplexConstraint()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='ToEnforceComplexConstraint'"
   * @generated
   */
  TBitwiseOperation getToEnforceComplexConstraint();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties#getToEnforceComplexConstraint <em>To Enforce Complex Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Enforce Complex Constraint</em>' containment reference.
   * @see #getToEnforceComplexConstraint()
   * @generated
   */
  void setToEnforceComplexConstraint(TBitwiseOperation value);

  /**
   * Returns the value of the '<em><b>Priority</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.epolicies.PriorityType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority</em>' containment reference list.
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTElasticityConstraintProperties_Priority()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Priority'"
   * @generated
   */
  EList<PriorityType> getPriority();

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
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTElasticityConstraintProperties_ConstraintId()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='attribute' name='ConstraintId'"
   * @generated
   */
  String getConstraintId();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties#getConstraintId <em>Constraint Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint Id</em>' attribute.
   * @see #getConstraintId()
   * @generated
   */
  void setConstraintId(String value);

} // TElasticityConstraintProperties
