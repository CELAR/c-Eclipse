/**
 */
package eu.celar.tosca.elasticity.util;

import eu.celar.tosca.TBoundaryDefinitions;
import eu.celar.tosca.TEntityTemplate;
import eu.celar.tosca.TExtensibleElements;

import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.elasticity.*;

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
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage
 * @generated
 */
public class Tosca_Elasticity_ExtensionsSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Tosca_Elasticity_ExtensionsPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_Elasticity_ExtensionsSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = Tosca_Elasticity_ExtensionsPackage.eINSTANCE;
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
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1:
      {
        ApplicationComponentElasticityRequirementsType1 applicationComponentElasticityRequirementsType1 = (ApplicationComponentElasticityRequirementsType1)theEObject;
        T result = caseApplicationComponentElasticityRequirementsType1(applicationComponentElasticityRequirementsType1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1:
      {
        DataHintsType1 dataHintsType1 = (DataHintsType1)theEObject;
        T result = caseDataHintsType1(dataHintsType1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_Elasticity_ExtensionsPackage.GLOBAL_ELASTICITY_REQUIREMENTS_TYPE1:
      {
        GlobalElasticityRequirementsType1 globalElasticityRequirementsType1 = (GlobalElasticityRequirementsType1)theEObject;
        T result = caseGlobalElasticityRequirementsType1(globalElasticityRequirementsType1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_Elasticity_ExtensionsPackage.LOAD_HINTS_TYPE1:
      {
        LoadHintsType1 loadHintsType1 = (LoadHintsType1)theEObject;
        T result = caseLoadHintsType1(loadHintsType1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_Elasticity_ExtensionsPackage.TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT:
      {
        TApplicationComponentElasticityRequirement tApplicationComponentElasticityRequirement = (TApplicationComponentElasticityRequirement)theEObject;
        T result = caseTApplicationComponentElasticityRequirement(tApplicationComponentElasticityRequirement);
        if (result == null) result = caseTExtensibleElements(tApplicationComponentElasticityRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION:
      {
        TBoundaryDefinitionsExtension tBoundaryDefinitionsExtension = (TBoundaryDefinitionsExtension)theEObject;
        T result = caseTBoundaryDefinitionsExtension(tBoundaryDefinitionsExtension);
        if (result == null) result = caseTBoundaryDefinitions(tBoundaryDefinitionsExtension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_Elasticity_ExtensionsPackage.TDATA_HINT:
      {
        TDataHint tDataHint = (TDataHint)theEObject;
        T result = caseTDataHint(tDataHint);
        if (result == null) result = caseTExtensibleElements(tDataHint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT:
      {
        TGlobalElasticityRequirement tGlobalElasticityRequirement = (TGlobalElasticityRequirement)theEObject;
        T result = caseTGlobalElasticityRequirement(tGlobalElasticityRequirement);
        if (result == null) result = caseTExtensibleElements(tGlobalElasticityRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_Elasticity_ExtensionsPackage.TLOAD_HINT:
      {
        TLoadHint tLoadHint = (TLoadHint)theEObject;
        T result = caseTLoadHint(tLoadHint);
        if (result == null) result = caseTExtensibleElements(tLoadHint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION:
      {
        TNodeTemplateExtension tNodeTemplateExtension = (TNodeTemplateExtension)theEObject;
        T result = caseTNodeTemplateExtension(tNodeTemplateExtension);
        if (result == null) result = caseTNodeTemplate(tNodeTemplateExtension);
        if (result == null) result = caseTEntityTemplate(tNodeTemplateExtension);
        if (result == null) result = caseTExtensibleElements(tNodeTemplateExtension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Application Component Elasticity Requirements Type1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Application Component Elasticity Requirements Type1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseApplicationComponentElasticityRequirementsType1(ApplicationComponentElasticityRequirementsType1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Hints Type1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Hints Type1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataHintsType1(DataHintsType1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Global Elasticity Requirements Type1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Global Elasticity Requirements Type1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGlobalElasticityRequirementsType1(GlobalElasticityRequirementsType1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Load Hints Type1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Load Hints Type1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoadHintsType1(LoadHintsType1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TApplication Component Elasticity Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TApplication Component Elasticity Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTApplicationComponentElasticityRequirement(TApplicationComponentElasticityRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TBoundary Definitions Extension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TBoundary Definitions Extension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTBoundaryDefinitionsExtension(TBoundaryDefinitionsExtension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TData Hint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TData Hint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTDataHint(TDataHint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TGlobal Elasticity Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TGlobal Elasticity Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTGlobalElasticityRequirement(TGlobalElasticityRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TLoad Hint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TLoad Hint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTLoadHint(TLoadHint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TNode Template Extension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TNode Template Extension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTNodeTemplateExtension(TNodeTemplateExtension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TBoundary Definitions</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TBoundary Definitions</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTBoundaryDefinitions(TBoundaryDefinitions object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TEntity Template</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TEntity Template</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTEntityTemplate(TEntityTemplate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TNode Template</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TNode Template</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTNodeTemplate(TNodeTemplate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TExtensible Elements</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TExtensible Elements</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTExtensibleElements(TExtensibleElements object)
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

} //Tosca_Elasticity_ExtensionsSwitch
