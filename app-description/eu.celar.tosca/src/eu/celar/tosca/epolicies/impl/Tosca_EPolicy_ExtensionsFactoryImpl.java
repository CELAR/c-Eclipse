/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Tosca_EPolicy_ExtensionsFactoryImpl extends EFactoryImpl implements Tosca_EPolicy_ExtensionsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Tosca_EPolicy_ExtensionsFactory init()
  {
    try
    {
      Tosca_EPolicy_ExtensionsFactory theTosca_EPolicy_ExtensionsFactory = (Tosca_EPolicy_ExtensionsFactory)EPackage.Registry.INSTANCE.getEFactory(Tosca_EPolicy_ExtensionsPackage.eNS_URI);
      if (theTosca_EPolicy_ExtensionsFactory != null)
      {
        return theTosca_EPolicy_ExtensionsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Tosca_EPolicy_ExtensionsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_EPolicy_ExtensionsFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE: return createActionType();
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE: return createBitwiseLeftHandSideType();
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE: return createBitwiseRightHandSideType();
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT: return createDocumentRoot();
      case Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE: return createPriorityType();
      case Tosca_EPolicy_ExtensionsPackage.RELATION_LEFT_HAND_SIDE_TYPE: return createRelationLeftHandSideType();
      case Tosca_EPolicy_ExtensionsPackage.RELATION_RIGHT_HAND_SIDE_TYPE: return createRelationRightHandSideType();
      case Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE: return createTActionParameterType();
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION: return createTBitwiseOperation();
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS: return createTConstraintStatus();
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES: return createTElasticityConstraintProperties();
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES: return createTElasticityStrategyProperties();
      case Tosca_EPolicy_ExtensionsPackage.TFULFILLED_CONSTRAINT: return createTFulfilledConstraint();
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION: return createTRelationOperation();
      case Tosca_EPolicy_ExtensionsPackage.TVIOLATED_CONSTRAINT: return createTViolatedConstraint();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION_TYPE:
        return createTBitwiseOperationTypeFromString(eDataType, initialValue);
      case Tosca_EPolicy_ExtensionsPackage.TPRIORITY_TYPE:
        return createTPriorityTypeFromString(eDataType, initialValue);
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION_TYPE:
        return createTRelationOperationTypeFromString(eDataType, initialValue);
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION_TYPE_OBJECT:
        return createTBitwiseOperationTypeObjectFromString(eDataType, initialValue);
      case Tosca_EPolicy_ExtensionsPackage.TPRIORITY_TYPE_OBJECT:
        return createTPriorityTypeObjectFromString(eDataType, initialValue);
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION_TYPE_OBJECT:
        return createTRelationOperationTypeObjectFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION_TYPE:
        return convertTBitwiseOperationTypeToString(eDataType, instanceValue);
      case Tosca_EPolicy_ExtensionsPackage.TPRIORITY_TYPE:
        return convertTPriorityTypeToString(eDataType, instanceValue);
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION_TYPE:
        return convertTRelationOperationTypeToString(eDataType, instanceValue);
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION_TYPE_OBJECT:
        return convertTBitwiseOperationTypeObjectToString(eDataType, instanceValue);
      case Tosca_EPolicy_ExtensionsPackage.TPRIORITY_TYPE_OBJECT:
        return convertTPriorityTypeObjectToString(eDataType, instanceValue);
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION_TYPE_OBJECT:
        return convertTRelationOperationTypeObjectToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionType createActionType()
  {
    ActionTypeImpl actionType = new ActionTypeImpl();
    return actionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseLeftHandSideType createBitwiseLeftHandSideType()
  {
    BitwiseLeftHandSideTypeImpl bitwiseLeftHandSideType = new BitwiseLeftHandSideTypeImpl();
    return bitwiseLeftHandSideType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseRightHandSideType createBitwiseRightHandSideType()
  {
    BitwiseRightHandSideTypeImpl bitwiseRightHandSideType = new BitwiseRightHandSideTypeImpl();
    return bitwiseRightHandSideType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DocumentRoot createDocumentRoot()
  {
    DocumentRootImpl documentRoot = new DocumentRootImpl();
    return documentRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PriorityType createPriorityType()
  {
    PriorityTypeImpl priorityType = new PriorityTypeImpl();
    return priorityType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationLeftHandSideType createRelationLeftHandSideType()
  {
    RelationLeftHandSideTypeImpl relationLeftHandSideType = new RelationLeftHandSideTypeImpl();
    return relationLeftHandSideType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationRightHandSideType createRelationRightHandSideType()
  {
    RelationRightHandSideTypeImpl relationRightHandSideType = new RelationRightHandSideTypeImpl();
    return relationRightHandSideType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TActionParameterType createTActionParameterType()
  {
    TActionParameterTypeImpl tActionParameterType = new TActionParameterTypeImpl();
    return tActionParameterType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TBitwiseOperation createTBitwiseOperation()
  {
    TBitwiseOperationImpl tBitwiseOperation = new TBitwiseOperationImpl();
    return tBitwiseOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TConstraintStatus createTConstraintStatus()
  {
    TConstraintStatusImpl tConstraintStatus = new TConstraintStatusImpl();
    return tConstraintStatus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TElasticityConstraintProperties createTElasticityConstraintProperties()
  {
    TElasticityConstraintPropertiesImpl tElasticityConstraintProperties = new TElasticityConstraintPropertiesImpl();
    return tElasticityConstraintProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TElasticityStrategyProperties createTElasticityStrategyProperties()
  {
    TElasticityStrategyPropertiesImpl tElasticityStrategyProperties = new TElasticityStrategyPropertiesImpl();
    return tElasticityStrategyProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TFulfilledConstraint createTFulfilledConstraint()
  {
    TFulfilledConstraintImpl tFulfilledConstraint = new TFulfilledConstraintImpl();
    return tFulfilledConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRelationOperation createTRelationOperation()
  {
    TRelationOperationImpl tRelationOperation = new TRelationOperationImpl();
    return tRelationOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TViolatedConstraint createTViolatedConstraint()
  {
    TViolatedConstraintImpl tViolatedConstraint = new TViolatedConstraintImpl();
    return tViolatedConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TBitwiseOperationType createTBitwiseOperationTypeFromString(EDataType eDataType, String initialValue)
  {
    TBitwiseOperationType result = TBitwiseOperationType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTBitwiseOperationTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TPriorityType createTPriorityTypeFromString(EDataType eDataType, String initialValue)
  {
    TPriorityType result = TPriorityType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTPriorityTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRelationOperationType createTRelationOperationTypeFromString(EDataType eDataType, String initialValue)
  {
    TRelationOperationType result = TRelationOperationType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTRelationOperationTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TBitwiseOperationType createTBitwiseOperationTypeObjectFromString(EDataType eDataType, String initialValue)
  {
    return createTBitwiseOperationTypeFromString(Tosca_EPolicy_ExtensionsPackage.Literals.TBITWISE_OPERATION_TYPE, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTBitwiseOperationTypeObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertTBitwiseOperationTypeToString(Tosca_EPolicy_ExtensionsPackage.Literals.TBITWISE_OPERATION_TYPE, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TPriorityType createTPriorityTypeObjectFromString(EDataType eDataType, String initialValue)
  {
    return createTPriorityTypeFromString(Tosca_EPolicy_ExtensionsPackage.Literals.TPRIORITY_TYPE, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTPriorityTypeObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertTPriorityTypeToString(Tosca_EPolicy_ExtensionsPackage.Literals.TPRIORITY_TYPE, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRelationOperationType createTRelationOperationTypeObjectFromString(EDataType eDataType, String initialValue)
  {
    return createTRelationOperationTypeFromString(Tosca_EPolicy_ExtensionsPackage.Literals.TRELATION_OPERATION_TYPE, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTRelationOperationTypeObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertTRelationOperationTypeToString(Tosca_EPolicy_ExtensionsPackage.Literals.TRELATION_OPERATION_TYPE, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_EPolicy_ExtensionsPackage getTosca_EPolicy_ExtensionsPackage()
  {
    return (Tosca_EPolicy_ExtensionsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Tosca_EPolicy_ExtensionsPackage getPackage()
  {
    return Tosca_EPolicy_ExtensionsPackage.eINSTANCE;
  }

} //Tosca_EPolicy_ExtensionsFactoryImpl
