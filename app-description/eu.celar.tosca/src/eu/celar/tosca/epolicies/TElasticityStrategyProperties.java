/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TElasticity Strategy Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getSimpleCondition <em>Simple Condition</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getComplexCondition <em>Complex Condition</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getConstraintBasedCondition <em>Constraint Based Condition</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getAction <em>Action</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getStrategyId <em>Strategy Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTElasticityStrategyProperties()
 * @model extendedMetaData="name='tElasticityStrategyProperties' kind='elementOnly'"
 * @generated
 */
public interface TElasticityStrategyProperties extends EObject
{
  /**
   * Returns the value of the '<em><b>Simple Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simple Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simple Condition</em>' containment reference.
   * @see #setSimpleCondition(TRelationOperation)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTElasticityStrategyProperties_SimpleCondition()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='SimpleCondition'"
   * @generated
   */
  TRelationOperation getSimpleCondition();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getSimpleCondition <em>Simple Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Simple Condition</em>' containment reference.
   * @see #getSimpleCondition()
   * @generated
   */
  void setSimpleCondition(TRelationOperation value);

  /**
   * Returns the value of the '<em><b>Complex Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Complex Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Complex Condition</em>' containment reference.
   * @see #setComplexCondition(TBitwiseOperation)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTElasticityStrategyProperties_ComplexCondition()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='ComplexCondition'"
   * @generated
   */
  TBitwiseOperation getComplexCondition();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getComplexCondition <em>Complex Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Complex Condition</em>' containment reference.
   * @see #getComplexCondition()
   * @generated
   */
  void setComplexCondition(TBitwiseOperation value);

  /**
   * Returns the value of the '<em><b>Constraint Based Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint Based Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint Based Condition</em>' containment reference.
   * @see #setConstraintBasedCondition(TConstraintStatus)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTElasticityStrategyProperties_ConstraintBasedCondition()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='ConstraintBasedCondition'"
   * @generated
   */
  TConstraintStatus getConstraintBasedCondition();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getConstraintBasedCondition <em>Constraint Based Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint Based Condition</em>' containment reference.
   * @see #getConstraintBasedCondition()
   * @generated
   */
  void setConstraintBasedCondition(TConstraintStatus value);

  /**
   * Returns the value of the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' containment reference.
   * @see #setAction(ActionType)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTElasticityStrategyProperties_Action()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='Action'"
   * @generated
   */
  ActionType getAction();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getAction <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' containment reference.
   * @see #getAction()
   * @generated
   */
  void setAction(ActionType value);

  /**
   * Returns the value of the '<em><b>Strategy Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Strategy Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Strategy Id</em>' attribute.
   * @see #setStrategyId(String)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTElasticityStrategyProperties_StrategyId()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='attribute' name='StrategyId'"
   * @generated
   */
  String getStrategyId();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getStrategyId <em>Strategy Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Strategy Id</em>' attribute.
   * @see #getStrategyId()
   * @generated
   */
  void setStrategyId(String value);

} // TElasticityStrategyProperties
