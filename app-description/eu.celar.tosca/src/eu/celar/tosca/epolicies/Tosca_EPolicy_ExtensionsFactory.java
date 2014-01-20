/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage
 * @generated
 */
public interface Tosca_EPolicy_ExtensionsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Tosca_EPolicy_ExtensionsFactory eINSTANCE = eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Action Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action Type</em>'.
   * @generated
   */
  ActionType createActionType();

  /**
   * Returns a new object of class '<em>Bitwise Left Hand Side Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bitwise Left Hand Side Type</em>'.
   * @generated
   */
  BitwiseLeftHandSideType createBitwiseLeftHandSideType();

  /**
   * Returns a new object of class '<em>Bitwise Right Hand Side Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bitwise Right Hand Side Type</em>'.
   * @generated
   */
  BitwiseRightHandSideType createBitwiseRightHandSideType();

  /**
   * Returns a new object of class '<em>Document Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Document Root</em>'.
   * @generated
   */
  DocumentRoot createDocumentRoot();

  /**
   * Returns a new object of class '<em>Priority Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Priority Type</em>'.
   * @generated
   */
  PriorityType createPriorityType();

  /**
   * Returns a new object of class '<em>Relation Left Hand Side Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relation Left Hand Side Type</em>'.
   * @generated
   */
  RelationLeftHandSideType createRelationLeftHandSideType();

  /**
   * Returns a new object of class '<em>Relation Right Hand Side Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relation Right Hand Side Type</em>'.
   * @generated
   */
  RelationRightHandSideType createRelationRightHandSideType();

  /**
   * Returns a new object of class '<em>TAction Parameter Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TAction Parameter Type</em>'.
   * @generated
   */
  TActionParameterType createTActionParameterType();

  /**
   * Returns a new object of class '<em>TBitwise Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TBitwise Operation</em>'.
   * @generated
   */
  TBitwiseOperation createTBitwiseOperation();

  /**
   * Returns a new object of class '<em>TConstraint Status</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TConstraint Status</em>'.
   * @generated
   */
  TConstraintStatus createTConstraintStatus();

  /**
   * Returns a new object of class '<em>TElasticity Constraint Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TElasticity Constraint Properties</em>'.
   * @generated
   */
  TElasticityConstraintProperties createTElasticityConstraintProperties();

  /**
   * Returns a new object of class '<em>TElasticity Strategy Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TElasticity Strategy Properties</em>'.
   * @generated
   */
  TElasticityStrategyProperties createTElasticityStrategyProperties();

  /**
   * Returns a new object of class '<em>TFulfilled Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TFulfilled Constraint</em>'.
   * @generated
   */
  TFulfilledConstraint createTFulfilledConstraint();

  /**
   * Returns a new object of class '<em>TRelation Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TRelation Operation</em>'.
   * @generated
   */
  TRelationOperation createTRelationOperation();

  /**
   * Returns a new object of class '<em>TViolated Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TViolated Constraint</em>'.
   * @generated
   */
  TViolatedConstraint createTViolatedConstraint();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Tosca_EPolicy_ExtensionsPackage getTosca_EPolicy_ExtensionsPackage();

} //Tosca_EPolicy_ExtensionsFactory
