/**
 */
package eu.celar.tosca.epolicies.util;

import eu.celar.tosca.epolicies.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage
 * @generated
 */
public class Tosca_EPolicy_ExtensionsSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Tosca_EPolicy_ExtensionsPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_EPolicy_ExtensionsSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = Tosca_EPolicy_ExtensionsPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE:
      {
        ActionType actionType = (ActionType)theEObject;
        T result = caseActionType(actionType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE:
      {
        BitwiseLeftHandSideType bitwiseLeftHandSideType = (BitwiseLeftHandSideType)theEObject;
        T result = caseBitwiseLeftHandSideType(bitwiseLeftHandSideType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE:
      {
        BitwiseRightHandSideType bitwiseRightHandSideType = (BitwiseRightHandSideType)theEObject;
        T result = caseBitwiseRightHandSideType(bitwiseRightHandSideType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT:
      {
        DocumentRoot documentRoot = (DocumentRoot)theEObject;
        T result = caseDocumentRoot(documentRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE:
      {
        PriorityType priorityType = (PriorityType)theEObject;
        T result = casePriorityType(priorityType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.RELATION_LEFT_HAND_SIDE_TYPE:
      {
        RelationLeftHandSideType relationLeftHandSideType = (RelationLeftHandSideType)theEObject;
        T result = caseRelationLeftHandSideType(relationLeftHandSideType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.RELATION_RIGHT_HAND_SIDE_TYPE:
      {
        RelationRightHandSideType relationRightHandSideType = (RelationRightHandSideType)theEObject;
        T result = caseRelationRightHandSideType(relationRightHandSideType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE:
      {
        TActionParameterType tActionParameterType = (TActionParameterType)theEObject;
        T result = caseTActionParameterType(tActionParameterType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION:
      {
        TBitwiseOperation tBitwiseOperation = (TBitwiseOperation)theEObject;
        T result = caseTBitwiseOperation(tBitwiseOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS:
      {
        TConstraintStatus tConstraintStatus = (TConstraintStatus)theEObject;
        T result = caseTConstraintStatus(tConstraintStatus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES:
      {
        TElasticityConstraintProperties tElasticityConstraintProperties = (TElasticityConstraintProperties)theEObject;
        T result = caseTElasticityConstraintProperties(tElasticityConstraintProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES:
      {
        TElasticityStrategyProperties tElasticityStrategyProperties = (TElasticityStrategyProperties)theEObject;
        T result = caseTElasticityStrategyProperties(tElasticityStrategyProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.TFULFILLED_CONSTRAINT:
      {
        TFulfilledConstraint tFulfilledConstraint = (TFulfilledConstraint)theEObject;
        T result = caseTFulfilledConstraint(tFulfilledConstraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION:
      {
        TRelationOperation tRelationOperation = (TRelationOperation)theEObject;
        T result = caseTRelationOperation(tRelationOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_EPolicy_ExtensionsPackage.TVIOLATED_CONSTRAINT:
      {
        TViolatedConstraint tViolatedConstraint = (TViolatedConstraint)theEObject;
        T result = caseTViolatedConstraint(tViolatedConstraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActionType(ActionType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bitwise Left Hand Side Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bitwise Left Hand Side Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBitwiseLeftHandSideType(BitwiseLeftHandSideType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bitwise Right Hand Side Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bitwise Right Hand Side Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBitwiseRightHandSideType(BitwiseRightHandSideType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDocumentRoot(DocumentRoot object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Priority Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Priority Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePriorityType(PriorityType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relation Left Hand Side Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relation Left Hand Side Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationLeftHandSideType(RelationLeftHandSideType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relation Right Hand Side Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relation Right Hand Side Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationRightHandSideType(RelationRightHandSideType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TAction Parameter Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TAction Parameter Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTActionParameterType(TActionParameterType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TBitwise Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TBitwise Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTBitwiseOperation(TBitwiseOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TConstraint Status</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TConstraint Status</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTConstraintStatus(TConstraintStatus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TElasticity Constraint Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TElasticity Constraint Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTElasticityConstraintProperties(TElasticityConstraintProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TElasticity Strategy Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TElasticity Strategy Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTElasticityStrategyProperties(TElasticityStrategyProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TFulfilled Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TFulfilled Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTFulfilledConstraint(TFulfilledConstraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TRelation Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TRelation Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTRelationOperation(TRelationOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TViolated Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TViolated Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTViolatedConstraint(TViolatedConstraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //Tosca_EPolicy_ExtensionsSwitch
