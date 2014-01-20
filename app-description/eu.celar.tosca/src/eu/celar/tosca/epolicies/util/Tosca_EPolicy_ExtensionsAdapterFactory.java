/**
 */
package eu.celar.tosca.epolicies.util;

import eu.celar.tosca.epolicies.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage
 * @generated
 */
public class Tosca_EPolicy_ExtensionsAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Tosca_EPolicy_ExtensionsPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_EPolicy_ExtensionsAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = Tosca_EPolicy_ExtensionsPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Tosca_EPolicy_ExtensionsSwitch<Adapter> modelSwitch =
    new Tosca_EPolicy_ExtensionsSwitch<Adapter>()
    {
      @Override
      public Adapter caseActionType(ActionType object)
      {
        return createActionTypeAdapter();
      }
      @Override
      public Adapter caseBitwiseLeftHandSideType(BitwiseLeftHandSideType object)
      {
        return createBitwiseLeftHandSideTypeAdapter();
      }
      @Override
      public Adapter caseBitwiseRightHandSideType(BitwiseRightHandSideType object)
      {
        return createBitwiseRightHandSideTypeAdapter();
      }
      @Override
      public Adapter caseDocumentRoot(DocumentRoot object)
      {
        return createDocumentRootAdapter();
      }
      @Override
      public Adapter casePriorityType(PriorityType object)
      {
        return createPriorityTypeAdapter();
      }
      @Override
      public Adapter caseRelationLeftHandSideType(RelationLeftHandSideType object)
      {
        return createRelationLeftHandSideTypeAdapter();
      }
      @Override
      public Adapter caseRelationRightHandSideType(RelationRightHandSideType object)
      {
        return createRelationRightHandSideTypeAdapter();
      }
      @Override
      public Adapter caseTActionParameterType(TActionParameterType object)
      {
        return createTActionParameterTypeAdapter();
      }
      @Override
      public Adapter caseTBitwiseOperation(TBitwiseOperation object)
      {
        return createTBitwiseOperationAdapter();
      }
      @Override
      public Adapter caseTConstraintStatus(TConstraintStatus object)
      {
        return createTConstraintStatusAdapter();
      }
      @Override
      public Adapter caseTElasticityConstraintProperties(TElasticityConstraintProperties object)
      {
        return createTElasticityConstraintPropertiesAdapter();
      }
      @Override
      public Adapter caseTElasticityStrategyProperties(TElasticityStrategyProperties object)
      {
        return createTElasticityStrategyPropertiesAdapter();
      }
      @Override
      public Adapter caseTFulfilledConstraint(TFulfilledConstraint object)
      {
        return createTFulfilledConstraintAdapter();
      }
      @Override
      public Adapter caseTRelationOperation(TRelationOperation object)
      {
        return createTRelationOperationAdapter();
      }
      @Override
      public Adapter caseTViolatedConstraint(TViolatedConstraint object)
      {
        return createTViolatedConstraintAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.ActionType <em>Action Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.ActionType
   * @generated
   */
  public Adapter createActionTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.BitwiseLeftHandSideType <em>Bitwise Left Hand Side Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.BitwiseLeftHandSideType
   * @generated
   */
  public Adapter createBitwiseLeftHandSideTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.BitwiseRightHandSideType <em>Bitwise Right Hand Side Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.BitwiseRightHandSideType
   * @generated
   */
  public Adapter createBitwiseRightHandSideTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.DocumentRoot <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.DocumentRoot
   * @generated
   */
  public Adapter createDocumentRootAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.PriorityType <em>Priority Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.PriorityType
   * @generated
   */
  public Adapter createPriorityTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.RelationLeftHandSideType <em>Relation Left Hand Side Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.RelationLeftHandSideType
   * @generated
   */
  public Adapter createRelationLeftHandSideTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.RelationRightHandSideType <em>Relation Right Hand Side Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.RelationRightHandSideType
   * @generated
   */
  public Adapter createRelationRightHandSideTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.TActionParameterType <em>TAction Parameter Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.TActionParameterType
   * @generated
   */
  public Adapter createTActionParameterTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.TBitwiseOperation <em>TBitwise Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.TBitwiseOperation
   * @generated
   */
  public Adapter createTBitwiseOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.TConstraintStatus <em>TConstraint Status</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.TConstraintStatus
   * @generated
   */
  public Adapter createTConstraintStatusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.TElasticityConstraintProperties <em>TElasticity Constraint Properties</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.TElasticityConstraintProperties
   * @generated
   */
  public Adapter createTElasticityConstraintPropertiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.TElasticityStrategyProperties <em>TElasticity Strategy Properties</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.TElasticityStrategyProperties
   * @generated
   */
  public Adapter createTElasticityStrategyPropertiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.TFulfilledConstraint <em>TFulfilled Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.TFulfilledConstraint
   * @generated
   */
  public Adapter createTFulfilledConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.TRelationOperation <em>TRelation Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.TRelationOperation
   * @generated
   */
  public Adapter createTRelationOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.tosca.epolicies.TViolatedConstraint <em>TViolated Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.tosca.epolicies.TViolatedConstraint
   * @generated
   */
  public Adapter createTViolatedConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //Tosca_EPolicy_ExtensionsAdapterFactory
