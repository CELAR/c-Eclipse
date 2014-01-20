/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsFactory
 * @model kind="package"
 * @generated
 */
public interface Tosca_EPolicy_ExtensionsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "epolicies";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.example.org/PolicyProperties";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "epolicies";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Tosca_EPolicy_ExtensionsPackage eINSTANCE = eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl.init();

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.ActionTypeImpl <em>Action Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.ActionTypeImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getActionType()
   * @generated
   */
  int ACTION_TYPE = 0;

  /**
   * The feature id for the '<em><b>Action Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_TYPE__ACTION_PARAMETER = 0;

  /**
   * The feature id for the '<em><b>Action Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_TYPE__ACTION_NAME = 1;

  /**
   * The number of structural features of the '<em>Action Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.BitwiseLeftHandSideTypeImpl <em>Bitwise Left Hand Side Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.BitwiseLeftHandSideTypeImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getBitwiseLeftHandSideType()
   * @generated
   */
  int BITWISE_LEFT_HAND_SIDE_TYPE = 1;

  /**
   * The feature id for the '<em><b>Left Simple Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION = 0;

  /**
   * The feature id for the '<em><b>Left Compex Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION = 1;

  /**
   * The number of structural features of the '<em>Bitwise Left Hand Side Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_LEFT_HAND_SIDE_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.BitwiseRightHandSideTypeImpl <em>Bitwise Right Hand Side Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.BitwiseRightHandSideTypeImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getBitwiseRightHandSideType()
   * @generated
   */
  int BITWISE_RIGHT_HAND_SIDE_TYPE = 2;

  /**
   * The feature id for the '<em><b>Right Simple Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION = 0;

  /**
   * The feature id for the '<em><b>Right Compex Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION = 1;

  /**
   * The number of structural features of the '<em>Bitwise Right Hand Side Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_RIGHT_HAND_SIDE_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.DocumentRootImpl <em>Document Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.DocumentRootImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getDocumentRoot()
   * @generated
   */
  int DOCUMENT_ROOT = 3;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__MIXED = 0;

  /**
   * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

  /**
   * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

  /**
   * The feature id for the '<em><b>Elasticity Constraint Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__ELASTICITY_CONSTRAINT_PROPERTIES = 3;

  /**
   * The feature id for the '<em><b>Elasticity Strategy Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__ELASTICITY_STRATEGY_PROPERTIES = 4;

  /**
   * The number of structural features of the '<em>Document Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.PriorityTypeImpl <em>Priority Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.PriorityTypeImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getPriorityType()
   * @generated
   */
  int PRIORITY_TYPE = 4;

  /**
   * The feature id for the '<em><b>Constraint Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIORITY_TYPE__CONSTRAINT_ID = 0;

  /**
   * The feature id for the '<em><b>Priority Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIORITY_TYPE__PRIORITY_TYPE = 1;

  /**
   * The number of structural features of the '<em>Priority Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIORITY_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.RelationLeftHandSideTypeImpl <em>Relation Left Hand Side Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.RelationLeftHandSideTypeImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getRelationLeftHandSideType()
   * @generated
   */
  int RELATION_LEFT_HAND_SIDE_TYPE = 5;

  /**
   * The feature id for the '<em><b>Metric</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_LEFT_HAND_SIDE_TYPE__METRIC = 0;

  /**
   * The number of structural features of the '<em>Relation Left Hand Side Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_LEFT_HAND_SIDE_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.RelationRightHandSideTypeImpl <em>Relation Right Hand Side Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.RelationRightHandSideTypeImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getRelationRightHandSideType()
   * @generated
   */
  int RELATION_RIGHT_HAND_SIDE_TYPE = 6;

  /**
   * The feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_RIGHT_HAND_SIDE_TYPE__NUMBER = 0;

  /**
   * The number of structural features of the '<em>Relation Right Hand Side Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_RIGHT_HAND_SIDE_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.TActionParameterTypeImpl <em>TAction Parameter Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.TActionParameterTypeImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTActionParameterType()
   * @generated
   */
  int TACTION_PARAMETER_TYPE = 7;

  /**
   * The feature id for the '<em><b>Parameter Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TACTION_PARAMETER_TYPE__PARAMETER_NAME = 0;

  /**
   * The feature id for the '<em><b>Parameter Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TACTION_PARAMETER_TYPE__PARAMETER_VALUE = 1;

  /**
   * The number of structural features of the '<em>TAction Parameter Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TACTION_PARAMETER_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.TBitwiseOperationImpl <em>TBitwise Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.TBitwiseOperationImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTBitwiseOperation()
   * @generated
   */
  int TBITWISE_OPERATION = 8;

  /**
   * The feature id for the '<em><b>Bitwise Left Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE = 0;

  /**
   * The feature id for the '<em><b>Bitwise Right Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE = 1;

  /**
   * The feature id for the '<em><b>Bitwise Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBITWISE_OPERATION__BITWISE_OPERATOR = 2;

  /**
   * The number of structural features of the '<em>TBitwise Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBITWISE_OPERATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.TConstraintStatusImpl <em>TConstraint Status</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.TConstraintStatusImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTConstraintStatus()
   * @generated
   */
  int TCONSTRAINT_STATUS = 9;

  /**
   * The feature id for the '<em><b>Violated</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONSTRAINT_STATUS__VIOLATED = 0;

  /**
   * The feature id for the '<em><b>Fulfilled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONSTRAINT_STATUS__FULFILLED = 1;

  /**
   * The number of structural features of the '<em>TConstraint Status</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONSTRAINT_STATUS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.TElasticityConstraintPropertiesImpl <em>TElasticity Constraint Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.TElasticityConstraintPropertiesImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTElasticityConstraintProperties()
   * @generated
   */
  int TELASTICITY_CONSTRAINT_PROPERTIES = 10;

  /**
   * The feature id for the '<em><b>To Enforce Simple Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT = 0;

  /**
   * The feature id for the '<em><b>To Enforce Complex Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT = 1;

  /**
   * The feature id for the '<em><b>Priority</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY = 2;

  /**
   * The feature id for the '<em><b>Constraint Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID = 3;

  /**
   * The number of structural features of the '<em>TElasticity Constraint Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TELASTICITY_CONSTRAINT_PROPERTIES_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.TElasticityStrategyPropertiesImpl <em>TElasticity Strategy Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.TElasticityStrategyPropertiesImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTElasticityStrategyProperties()
   * @generated
   */
  int TELASTICITY_STRATEGY_PROPERTIES = 11;

  /**
   * The feature id for the '<em><b>Simple Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION = 0;

  /**
   * The feature id for the '<em><b>Complex Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION = 1;

  /**
   * The feature id for the '<em><b>Constraint Based Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION = 2;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TELASTICITY_STRATEGY_PROPERTIES__ACTION = 3;

  /**
   * The feature id for the '<em><b>Strategy Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID = 4;

  /**
   * The number of structural features of the '<em>TElasticity Strategy Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TELASTICITY_STRATEGY_PROPERTIES_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.TFulfilledConstraintImpl <em>TFulfilled Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.TFulfilledConstraintImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTFulfilledConstraint()
   * @generated
   */
  int TFULFILLED_CONSTRAINT = 12;

  /**
   * The feature id for the '<em><b>Constraint Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TFULFILLED_CONSTRAINT__CONSTRAINT_ID = 0;

  /**
   * The number of structural features of the '<em>TFulfilled Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TFULFILLED_CONSTRAINT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.TRelationOperationImpl <em>TRelation Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.TRelationOperationImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTRelationOperation()
   * @generated
   */
  int TRELATION_OPERATION = 13;

  /**
   * The feature id for the '<em><b>Relation Left Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE = 0;

  /**
   * The feature id for the '<em><b>Relation Right Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATION_OPERATION__TYPE = 2;

  /**
   * The number of structural features of the '<em>TRelation Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATION_OPERATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.impl.TViolatedConstraintImpl <em>TViolated Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.impl.TViolatedConstraintImpl
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTViolatedConstraint()
   * @generated
   */
  int TVIOLATED_CONSTRAINT = 14;

  /**
   * The feature id for the '<em><b>Constraint Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TVIOLATED_CONSTRAINT__CONSTRAINT_ID = 0;

  /**
   * The number of structural features of the '<em>TViolated Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TVIOLATED_CONSTRAINT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.TBitwiseOperationType <em>TBitwise Operation Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.TBitwiseOperationType
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTBitwiseOperationType()
   * @generated
   */
  int TBITWISE_OPERATION_TYPE = 15;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.TPriorityType <em>TPriority Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.TPriorityType
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTPriorityType()
   * @generated
   */
  int TPRIORITY_TYPE = 16;

  /**
   * The meta object id for the '{@link eu.celar.tosca.epolicies.TRelationOperationType <em>TRelation Operation Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.TRelationOperationType
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTRelationOperationType()
   * @generated
   */
  int TRELATION_OPERATION_TYPE = 17;

  /**
   * The meta object id for the '<em>TBitwise Operation Type Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.TBitwiseOperationType
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTBitwiseOperationTypeObject()
   * @generated
   */
  int TBITWISE_OPERATION_TYPE_OBJECT = 18;

  /**
   * The meta object id for the '<em>TPriority Type Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.TPriorityType
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTPriorityTypeObject()
   * @generated
   */
  int TPRIORITY_TYPE_OBJECT = 19;

  /**
   * The meta object id for the '<em>TRelation Operation Type Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.tosca.epolicies.TRelationOperationType
   * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTRelationOperationTypeObject()
   * @generated
   */
  int TRELATION_OPERATION_TYPE_OBJECT = 20;


  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.ActionType <em>Action Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action Type</em>'.
   * @see eu.celar.tosca.epolicies.ActionType
   * @generated
   */
  EClass getActionType();

  /**
   * Returns the meta object for the containment reference list '{@link eu.celar.tosca.epolicies.ActionType#getActionParameter <em>Action Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Action Parameter</em>'.
   * @see eu.celar.tosca.epolicies.ActionType#getActionParameter()
   * @see #getActionType()
   * @generated
   */
  EReference getActionType_ActionParameter();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.ActionType#getActionName <em>Action Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Action Name</em>'.
   * @see eu.celar.tosca.epolicies.ActionType#getActionName()
   * @see #getActionType()
   * @generated
   */
  EAttribute getActionType_ActionName();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.BitwiseLeftHandSideType <em>Bitwise Left Hand Side Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bitwise Left Hand Side Type</em>'.
   * @see eu.celar.tosca.epolicies.BitwiseLeftHandSideType
   * @generated
   */
  EClass getBitwiseLeftHandSideType();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.BitwiseLeftHandSideType#getLeftSimpleCondition <em>Left Simple Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Simple Condition</em>'.
   * @see eu.celar.tosca.epolicies.BitwiseLeftHandSideType#getLeftSimpleCondition()
   * @see #getBitwiseLeftHandSideType()
   * @generated
   */
  EReference getBitwiseLeftHandSideType_LeftSimpleCondition();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.BitwiseLeftHandSideType#getLeftCompexCondition <em>Left Compex Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Compex Condition</em>'.
   * @see eu.celar.tosca.epolicies.BitwiseLeftHandSideType#getLeftCompexCondition()
   * @see #getBitwiseLeftHandSideType()
   * @generated
   */
  EReference getBitwiseLeftHandSideType_LeftCompexCondition();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.BitwiseRightHandSideType <em>Bitwise Right Hand Side Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bitwise Right Hand Side Type</em>'.
   * @see eu.celar.tosca.epolicies.BitwiseRightHandSideType
   * @generated
   */
  EClass getBitwiseRightHandSideType();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.BitwiseRightHandSideType#getRightSimpleCondition <em>Right Simple Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Simple Condition</em>'.
   * @see eu.celar.tosca.epolicies.BitwiseRightHandSideType#getRightSimpleCondition()
   * @see #getBitwiseRightHandSideType()
   * @generated
   */
  EReference getBitwiseRightHandSideType_RightSimpleCondition();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.BitwiseRightHandSideType#getRightCompexCondition <em>Right Compex Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Compex Condition</em>'.
   * @see eu.celar.tosca.epolicies.BitwiseRightHandSideType#getRightCompexCondition()
   * @see #getBitwiseRightHandSideType()
   * @generated
   */
  EReference getBitwiseRightHandSideType_RightCompexCondition();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.DocumentRoot <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document Root</em>'.
   * @see eu.celar.tosca.epolicies.DocumentRoot
   * @generated
   */
  EClass getDocumentRoot();

  /**
   * Returns the meta object for the attribute list '{@link eu.celar.tosca.epolicies.DocumentRoot#getMixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mixed</em>'.
   * @see eu.celar.tosca.epolicies.DocumentRoot#getMixed()
   * @see #getDocumentRoot()
   * @generated
   */
  EAttribute getDocumentRoot_Mixed();

  /**
   * Returns the meta object for the map '{@link eu.celar.tosca.epolicies.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
   * @see eu.celar.tosca.epolicies.DocumentRoot#getXMLNSPrefixMap()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_XMLNSPrefixMap();

  /**
   * Returns the meta object for the map '{@link eu.celar.tosca.epolicies.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XSI Schema Location</em>'.
   * @see eu.celar.tosca.epolicies.DocumentRoot#getXSISchemaLocation()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_XSISchemaLocation();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.DocumentRoot#getElasticityConstraintProperties <em>Elasticity Constraint Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Elasticity Constraint Properties</em>'.
   * @see eu.celar.tosca.epolicies.DocumentRoot#getElasticityConstraintProperties()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_ElasticityConstraintProperties();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.DocumentRoot#getElasticityStrategyProperties <em>Elasticity Strategy Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Elasticity Strategy Properties</em>'.
   * @see eu.celar.tosca.epolicies.DocumentRoot#getElasticityStrategyProperties()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_ElasticityStrategyProperties();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.PriorityType <em>Priority Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Priority Type</em>'.
   * @see eu.celar.tosca.epolicies.PriorityType
   * @generated
   */
  EClass getPriorityType();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.PriorityType#getConstraintId <em>Constraint Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint Id</em>'.
   * @see eu.celar.tosca.epolicies.PriorityType#getConstraintId()
   * @see #getPriorityType()
   * @generated
   */
  EAttribute getPriorityType_ConstraintId();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.PriorityType#getPriorityType <em>Priority Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priority Type</em>'.
   * @see eu.celar.tosca.epolicies.PriorityType#getPriorityType()
   * @see #getPriorityType()
   * @generated
   */
  EAttribute getPriorityType_PriorityType();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.RelationLeftHandSideType <em>Relation Left Hand Side Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relation Left Hand Side Type</em>'.
   * @see eu.celar.tosca.epolicies.RelationLeftHandSideType
   * @generated
   */
  EClass getRelationLeftHandSideType();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.RelationLeftHandSideType#getMetric <em>Metric</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Metric</em>'.
   * @see eu.celar.tosca.epolicies.RelationLeftHandSideType#getMetric()
   * @see #getRelationLeftHandSideType()
   * @generated
   */
  EAttribute getRelationLeftHandSideType_Metric();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.RelationRightHandSideType <em>Relation Right Hand Side Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relation Right Hand Side Type</em>'.
   * @see eu.celar.tosca.epolicies.RelationRightHandSideType
   * @generated
   */
  EClass getRelationRightHandSideType();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.RelationRightHandSideType#getNumber <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number</em>'.
   * @see eu.celar.tosca.epolicies.RelationRightHandSideType#getNumber()
   * @see #getRelationRightHandSideType()
   * @generated
   */
  EAttribute getRelationRightHandSideType_Number();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.TActionParameterType <em>TAction Parameter Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TAction Parameter Type</em>'.
   * @see eu.celar.tosca.epolicies.TActionParameterType
   * @generated
   */
  EClass getTActionParameterType();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.TActionParameterType#getParameterName <em>Parameter Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parameter Name</em>'.
   * @see eu.celar.tosca.epolicies.TActionParameterType#getParameterName()
   * @see #getTActionParameterType()
   * @generated
   */
  EAttribute getTActionParameterType_ParameterName();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.TActionParameterType#getParameterValue <em>Parameter Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parameter Value</em>'.
   * @see eu.celar.tosca.epolicies.TActionParameterType#getParameterValue()
   * @see #getTActionParameterType()
   * @generated
   */
  EAttribute getTActionParameterType_ParameterValue();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.TBitwiseOperation <em>TBitwise Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TBitwise Operation</em>'.
   * @see eu.celar.tosca.epolicies.TBitwiseOperation
   * @generated
   */
  EClass getTBitwiseOperation();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseLeftHandSide <em>Bitwise Left Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bitwise Left Hand Side</em>'.
   * @see eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseLeftHandSide()
   * @see #getTBitwiseOperation()
   * @generated
   */
  EReference getTBitwiseOperation_BitwiseLeftHandSide();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseRightHandSide <em>Bitwise Right Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bitwise Right Hand Side</em>'.
   * @see eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseRightHandSide()
   * @see #getTBitwiseOperation()
   * @generated
   */
  EReference getTBitwiseOperation_BitwiseRightHandSide();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseOperator <em>Bitwise Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bitwise Operator</em>'.
   * @see eu.celar.tosca.epolicies.TBitwiseOperation#getBitwiseOperator()
   * @see #getTBitwiseOperation()
   * @generated
   */
  EAttribute getTBitwiseOperation_BitwiseOperator();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.TConstraintStatus <em>TConstraint Status</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TConstraint Status</em>'.
   * @see eu.celar.tosca.epolicies.TConstraintStatus
   * @generated
   */
  EClass getTConstraintStatus();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TConstraintStatus#getViolated <em>Violated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Violated</em>'.
   * @see eu.celar.tosca.epolicies.TConstraintStatus#getViolated()
   * @see #getTConstraintStatus()
   * @generated
   */
  EReference getTConstraintStatus_Violated();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TConstraintStatus#getFulfilled <em>Fulfilled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fulfilled</em>'.
   * @see eu.celar.tosca.epolicies.TConstraintStatus#getFulfilled()
   * @see #getTConstraintStatus()
   * @generated
   */
  EReference getTConstraintStatus_Fulfilled();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties <em>TElasticity Constraint Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TElasticity Constraint Properties</em>'.
   * @see eu.celar.tosca.epolicies.TElasticityConstraintProperties
   * @generated
   */
  EClass getTElasticityConstraintProperties();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties#getToEnforceSimpleConstraint <em>To Enforce Simple Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>To Enforce Simple Constraint</em>'.
   * @see eu.celar.tosca.epolicies.TElasticityConstraintProperties#getToEnforceSimpleConstraint()
   * @see #getTElasticityConstraintProperties()
   * @generated
   */
  EReference getTElasticityConstraintProperties_ToEnforceSimpleConstraint();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties#getToEnforceComplexConstraint <em>To Enforce Complex Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>To Enforce Complex Constraint</em>'.
   * @see eu.celar.tosca.epolicies.TElasticityConstraintProperties#getToEnforceComplexConstraint()
   * @see #getTElasticityConstraintProperties()
   * @generated
   */
  EReference getTElasticityConstraintProperties_ToEnforceComplexConstraint();

  /**
   * Returns the meta object for the containment reference list '{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties#getPriority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Priority</em>'.
   * @see eu.celar.tosca.epolicies.TElasticityConstraintProperties#getPriority()
   * @see #getTElasticityConstraintProperties()
   * @generated
   */
  EReference getTElasticityConstraintProperties_Priority();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties#getConstraintId <em>Constraint Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint Id</em>'.
   * @see eu.celar.tosca.epolicies.TElasticityConstraintProperties#getConstraintId()
   * @see #getTElasticityConstraintProperties()
   * @generated
   */
  EAttribute getTElasticityConstraintProperties_ConstraintId();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties <em>TElasticity Strategy Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TElasticity Strategy Properties</em>'.
   * @see eu.celar.tosca.epolicies.TElasticityStrategyProperties
   * @generated
   */
  EClass getTElasticityStrategyProperties();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getSimpleCondition <em>Simple Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Simple Condition</em>'.
   * @see eu.celar.tosca.epolicies.TElasticityStrategyProperties#getSimpleCondition()
   * @see #getTElasticityStrategyProperties()
   * @generated
   */
  EReference getTElasticityStrategyProperties_SimpleCondition();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getComplexCondition <em>Complex Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Complex Condition</em>'.
   * @see eu.celar.tosca.epolicies.TElasticityStrategyProperties#getComplexCondition()
   * @see #getTElasticityStrategyProperties()
   * @generated
   */
  EReference getTElasticityStrategyProperties_ComplexCondition();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getConstraintBasedCondition <em>Constraint Based Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraint Based Condition</em>'.
   * @see eu.celar.tosca.epolicies.TElasticityStrategyProperties#getConstraintBasedCondition()
   * @see #getTElasticityStrategyProperties()
   * @generated
   */
  EReference getTElasticityStrategyProperties_ConstraintBasedCondition();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see eu.celar.tosca.epolicies.TElasticityStrategyProperties#getAction()
   * @see #getTElasticityStrategyProperties()
   * @generated
   */
  EReference getTElasticityStrategyProperties_Action();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties#getStrategyId <em>Strategy Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Strategy Id</em>'.
   * @see eu.celar.tosca.epolicies.TElasticityStrategyProperties#getStrategyId()
   * @see #getTElasticityStrategyProperties()
   * @generated
   */
  EAttribute getTElasticityStrategyProperties_StrategyId();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.TFulfilledConstraint <em>TFulfilled Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TFulfilled Constraint</em>'.
   * @see eu.celar.tosca.epolicies.TFulfilledConstraint
   * @generated
   */
  EClass getTFulfilledConstraint();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.TFulfilledConstraint#getConstraintId <em>Constraint Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint Id</em>'.
   * @see eu.celar.tosca.epolicies.TFulfilledConstraint#getConstraintId()
   * @see #getTFulfilledConstraint()
   * @generated
   */
  EAttribute getTFulfilledConstraint_ConstraintId();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.TRelationOperation <em>TRelation Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TRelation Operation</em>'.
   * @see eu.celar.tosca.epolicies.TRelationOperation
   * @generated
   */
  EClass getTRelationOperation();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TRelationOperation#getRelationLeftHandSide <em>Relation Left Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Relation Left Hand Side</em>'.
   * @see eu.celar.tosca.epolicies.TRelationOperation#getRelationLeftHandSide()
   * @see #getTRelationOperation()
   * @generated
   */
  EReference getTRelationOperation_RelationLeftHandSide();

  /**
   * Returns the meta object for the containment reference '{@link eu.celar.tosca.epolicies.TRelationOperation#getRelationRightHandSide <em>Relation Right Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Relation Right Hand Side</em>'.
   * @see eu.celar.tosca.epolicies.TRelationOperation#getRelationRightHandSide()
   * @see #getTRelationOperation()
   * @generated
   */
  EReference getTRelationOperation_RelationRightHandSide();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.TRelationOperation#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see eu.celar.tosca.epolicies.TRelationOperation#getType()
   * @see #getTRelationOperation()
   * @generated
   */
  EAttribute getTRelationOperation_Type();

  /**
   * Returns the meta object for class '{@link eu.celar.tosca.epolicies.TViolatedConstraint <em>TViolated Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TViolated Constraint</em>'.
   * @see eu.celar.tosca.epolicies.TViolatedConstraint
   * @generated
   */
  EClass getTViolatedConstraint();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.tosca.epolicies.TViolatedConstraint#getConstraintId <em>Constraint Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint Id</em>'.
   * @see eu.celar.tosca.epolicies.TViolatedConstraint#getConstraintId()
   * @see #getTViolatedConstraint()
   * @generated
   */
  EAttribute getTViolatedConstraint_ConstraintId();

  /**
   * Returns the meta object for enum '{@link eu.celar.tosca.epolicies.TBitwiseOperationType <em>TBitwise Operation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>TBitwise Operation Type</em>'.
   * @see eu.celar.tosca.epolicies.TBitwiseOperationType
   * @generated
   */
  EEnum getTBitwiseOperationType();

  /**
   * Returns the meta object for enum '{@link eu.celar.tosca.epolicies.TPriorityType <em>TPriority Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>TPriority Type</em>'.
   * @see eu.celar.tosca.epolicies.TPriorityType
   * @generated
   */
  EEnum getTPriorityType();

  /**
   * Returns the meta object for enum '{@link eu.celar.tosca.epolicies.TRelationOperationType <em>TRelation Operation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>TRelation Operation Type</em>'.
   * @see eu.celar.tosca.epolicies.TRelationOperationType
   * @generated
   */
  EEnum getTRelationOperationType();

  /**
   * Returns the meta object for data type '{@link eu.celar.tosca.epolicies.TBitwiseOperationType <em>TBitwise Operation Type Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>TBitwise Operation Type Object</em>'.
   * @see eu.celar.tosca.epolicies.TBitwiseOperationType
   * @model instanceClass="eu.celar.tosca.epolicies.TBitwiseOperationType"
   *        extendedMetaData="name='tBitwiseOperationType:Object' baseType='tBitwiseOperationType'"
   * @generated
   */
  EDataType getTBitwiseOperationTypeObject();

  /**
   * Returns the meta object for data type '{@link eu.celar.tosca.epolicies.TPriorityType <em>TPriority Type Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>TPriority Type Object</em>'.
   * @see eu.celar.tosca.epolicies.TPriorityType
   * @model instanceClass="eu.celar.tosca.epolicies.TPriorityType"
   *        extendedMetaData="name='tPriorityType:Object' baseType='tPriorityType'"
   * @generated
   */
  EDataType getTPriorityTypeObject();

  /**
   * Returns the meta object for data type '{@link eu.celar.tosca.epolicies.TRelationOperationType <em>TRelation Operation Type Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>TRelation Operation Type Object</em>'.
   * @see eu.celar.tosca.epolicies.TRelationOperationType
   * @model instanceClass="eu.celar.tosca.epolicies.TRelationOperationType"
   *        extendedMetaData="name='tRelationOperationType:Object' baseType='tRelationOperationType'"
   * @generated
   */
  EDataType getTRelationOperationTypeObject();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Tosca_EPolicy_ExtensionsFactory getTosca_EPolicy_ExtensionsFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.ActionTypeImpl <em>Action Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.ActionTypeImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getActionType()
     * @generated
     */
    EClass ACTION_TYPE = eINSTANCE.getActionType();

    /**
     * The meta object literal for the '<em><b>Action Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION_TYPE__ACTION_PARAMETER = eINSTANCE.getActionType_ActionParameter();

    /**
     * The meta object literal for the '<em><b>Action Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTION_TYPE__ACTION_NAME = eINSTANCE.getActionType_ActionName();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.BitwiseLeftHandSideTypeImpl <em>Bitwise Left Hand Side Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.BitwiseLeftHandSideTypeImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getBitwiseLeftHandSideType()
     * @generated
     */
    EClass BITWISE_LEFT_HAND_SIDE_TYPE = eINSTANCE.getBitwiseLeftHandSideType();

    /**
     * The meta object literal for the '<em><b>Left Simple Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION = eINSTANCE.getBitwiseLeftHandSideType_LeftSimpleCondition();

    /**
     * The meta object literal for the '<em><b>Left Compex Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION = eINSTANCE.getBitwiseLeftHandSideType_LeftCompexCondition();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.BitwiseRightHandSideTypeImpl <em>Bitwise Right Hand Side Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.BitwiseRightHandSideTypeImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getBitwiseRightHandSideType()
     * @generated
     */
    EClass BITWISE_RIGHT_HAND_SIDE_TYPE = eINSTANCE.getBitwiseRightHandSideType();

    /**
     * The meta object literal for the '<em><b>Right Simple Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION = eINSTANCE.getBitwiseRightHandSideType_RightSimpleCondition();

    /**
     * The meta object literal for the '<em><b>Right Compex Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION = eINSTANCE.getBitwiseRightHandSideType_RightCompexCondition();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.DocumentRootImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getDocumentRoot()
     * @generated
     */
    EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

    /**
     * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

    /**
     * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

    /**
     * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

    /**
     * The meta object literal for the '<em><b>Elasticity Constraint Properties</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__ELASTICITY_CONSTRAINT_PROPERTIES = eINSTANCE.getDocumentRoot_ElasticityConstraintProperties();

    /**
     * The meta object literal for the '<em><b>Elasticity Strategy Properties</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__ELASTICITY_STRATEGY_PROPERTIES = eINSTANCE.getDocumentRoot_ElasticityStrategyProperties();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.PriorityTypeImpl <em>Priority Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.PriorityTypeImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getPriorityType()
     * @generated
     */
    EClass PRIORITY_TYPE = eINSTANCE.getPriorityType();

    /**
     * The meta object literal for the '<em><b>Constraint Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIORITY_TYPE__CONSTRAINT_ID = eINSTANCE.getPriorityType_ConstraintId();

    /**
     * The meta object literal for the '<em><b>Priority Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIORITY_TYPE__PRIORITY_TYPE = eINSTANCE.getPriorityType_PriorityType();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.RelationLeftHandSideTypeImpl <em>Relation Left Hand Side Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.RelationLeftHandSideTypeImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getRelationLeftHandSideType()
     * @generated
     */
    EClass RELATION_LEFT_HAND_SIDE_TYPE = eINSTANCE.getRelationLeftHandSideType();

    /**
     * The meta object literal for the '<em><b>Metric</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION_LEFT_HAND_SIDE_TYPE__METRIC = eINSTANCE.getRelationLeftHandSideType_Metric();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.RelationRightHandSideTypeImpl <em>Relation Right Hand Side Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.RelationRightHandSideTypeImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getRelationRightHandSideType()
     * @generated
     */
    EClass RELATION_RIGHT_HAND_SIDE_TYPE = eINSTANCE.getRelationRightHandSideType();

    /**
     * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION_RIGHT_HAND_SIDE_TYPE__NUMBER = eINSTANCE.getRelationRightHandSideType_Number();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.TActionParameterTypeImpl <em>TAction Parameter Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.TActionParameterTypeImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTActionParameterType()
     * @generated
     */
    EClass TACTION_PARAMETER_TYPE = eINSTANCE.getTActionParameterType();

    /**
     * The meta object literal for the '<em><b>Parameter Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TACTION_PARAMETER_TYPE__PARAMETER_NAME = eINSTANCE.getTActionParameterType_ParameterName();

    /**
     * The meta object literal for the '<em><b>Parameter Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TACTION_PARAMETER_TYPE__PARAMETER_VALUE = eINSTANCE.getTActionParameterType_ParameterValue();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.TBitwiseOperationImpl <em>TBitwise Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.TBitwiseOperationImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTBitwiseOperation()
     * @generated
     */
    EClass TBITWISE_OPERATION = eINSTANCE.getTBitwiseOperation();

    /**
     * The meta object literal for the '<em><b>Bitwise Left Hand Side</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE = eINSTANCE.getTBitwiseOperation_BitwiseLeftHandSide();

    /**
     * The meta object literal for the '<em><b>Bitwise Right Hand Side</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE = eINSTANCE.getTBitwiseOperation_BitwiseRightHandSide();

    /**
     * The meta object literal for the '<em><b>Bitwise Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TBITWISE_OPERATION__BITWISE_OPERATOR = eINSTANCE.getTBitwiseOperation_BitwiseOperator();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.TConstraintStatusImpl <em>TConstraint Status</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.TConstraintStatusImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTConstraintStatus()
     * @generated
     */
    EClass TCONSTRAINT_STATUS = eINSTANCE.getTConstraintStatus();

    /**
     * The meta object literal for the '<em><b>Violated</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TCONSTRAINT_STATUS__VIOLATED = eINSTANCE.getTConstraintStatus_Violated();

    /**
     * The meta object literal for the '<em><b>Fulfilled</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TCONSTRAINT_STATUS__FULFILLED = eINSTANCE.getTConstraintStatus_Fulfilled();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.TElasticityConstraintPropertiesImpl <em>TElasticity Constraint Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.TElasticityConstraintPropertiesImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTElasticityConstraintProperties()
     * @generated
     */
    EClass TELASTICITY_CONSTRAINT_PROPERTIES = eINSTANCE.getTElasticityConstraintProperties();

    /**
     * The meta object literal for the '<em><b>To Enforce Simple Constraint</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT = eINSTANCE.getTElasticityConstraintProperties_ToEnforceSimpleConstraint();

    /**
     * The meta object literal for the '<em><b>To Enforce Complex Constraint</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT = eINSTANCE.getTElasticityConstraintProperties_ToEnforceComplexConstraint();

    /**
     * The meta object literal for the '<em><b>Priority</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY = eINSTANCE.getTElasticityConstraintProperties_Priority();

    /**
     * The meta object literal for the '<em><b>Constraint Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID = eINSTANCE.getTElasticityConstraintProperties_ConstraintId();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.TElasticityStrategyPropertiesImpl <em>TElasticity Strategy Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.TElasticityStrategyPropertiesImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTElasticityStrategyProperties()
     * @generated
     */
    EClass TELASTICITY_STRATEGY_PROPERTIES = eINSTANCE.getTElasticityStrategyProperties();

    /**
     * The meta object literal for the '<em><b>Simple Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION = eINSTANCE.getTElasticityStrategyProperties_SimpleCondition();

    /**
     * The meta object literal for the '<em><b>Complex Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION = eINSTANCE.getTElasticityStrategyProperties_ComplexCondition();

    /**
     * The meta object literal for the '<em><b>Constraint Based Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION = eINSTANCE.getTElasticityStrategyProperties_ConstraintBasedCondition();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TELASTICITY_STRATEGY_PROPERTIES__ACTION = eINSTANCE.getTElasticityStrategyProperties_Action();

    /**
     * The meta object literal for the '<em><b>Strategy Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID = eINSTANCE.getTElasticityStrategyProperties_StrategyId();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.TFulfilledConstraintImpl <em>TFulfilled Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.TFulfilledConstraintImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTFulfilledConstraint()
     * @generated
     */
    EClass TFULFILLED_CONSTRAINT = eINSTANCE.getTFulfilledConstraint();

    /**
     * The meta object literal for the '<em><b>Constraint Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TFULFILLED_CONSTRAINT__CONSTRAINT_ID = eINSTANCE.getTFulfilledConstraint_ConstraintId();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.TRelationOperationImpl <em>TRelation Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.TRelationOperationImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTRelationOperation()
     * @generated
     */
    EClass TRELATION_OPERATION = eINSTANCE.getTRelationOperation();

    /**
     * The meta object literal for the '<em><b>Relation Left Hand Side</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE = eINSTANCE.getTRelationOperation_RelationLeftHandSide();

    /**
     * The meta object literal for the '<em><b>Relation Right Hand Side</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE = eINSTANCE.getTRelationOperation_RelationRightHandSide();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRELATION_OPERATION__TYPE = eINSTANCE.getTRelationOperation_Type();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.impl.TViolatedConstraintImpl <em>TViolated Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.impl.TViolatedConstraintImpl
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTViolatedConstraint()
     * @generated
     */
    EClass TVIOLATED_CONSTRAINT = eINSTANCE.getTViolatedConstraint();

    /**
     * The meta object literal for the '<em><b>Constraint Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TVIOLATED_CONSTRAINT__CONSTRAINT_ID = eINSTANCE.getTViolatedConstraint_ConstraintId();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.TBitwiseOperationType <em>TBitwise Operation Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.TBitwiseOperationType
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTBitwiseOperationType()
     * @generated
     */
    EEnum TBITWISE_OPERATION_TYPE = eINSTANCE.getTBitwiseOperationType();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.TPriorityType <em>TPriority Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.TPriorityType
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTPriorityType()
     * @generated
     */
    EEnum TPRIORITY_TYPE = eINSTANCE.getTPriorityType();

    /**
     * The meta object literal for the '{@link eu.celar.tosca.epolicies.TRelationOperationType <em>TRelation Operation Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.TRelationOperationType
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTRelationOperationType()
     * @generated
     */
    EEnum TRELATION_OPERATION_TYPE = eINSTANCE.getTRelationOperationType();

    /**
     * The meta object literal for the '<em>TBitwise Operation Type Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.TBitwiseOperationType
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTBitwiseOperationTypeObject()
     * @generated
     */
    EDataType TBITWISE_OPERATION_TYPE_OBJECT = eINSTANCE.getTBitwiseOperationTypeObject();

    /**
     * The meta object literal for the '<em>TPriority Type Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.TPriorityType
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTPriorityTypeObject()
     * @generated
     */
    EDataType TPRIORITY_TYPE_OBJECT = eINSTANCE.getTPriorityTypeObject();

    /**
     * The meta object literal for the '<em>TRelation Operation Type Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.tosca.epolicies.TRelationOperationType
     * @see eu.celar.tosca.epolicies.impl.Tosca_EPolicy_ExtensionsPackageImpl#getTRelationOperationTypeObject()
     * @generated
     */
    EDataType TRELATION_OPERATION_TYPE_OBJECT = eINSTANCE.getTRelationOperationTypeObject();

  }

} //Tosca_EPolicy_ExtensionsPackage
