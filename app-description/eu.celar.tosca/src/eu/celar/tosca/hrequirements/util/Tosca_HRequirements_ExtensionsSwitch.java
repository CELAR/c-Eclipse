/**
 */
package eu.celar.tosca.hrequirements.util;

import eu.celar.tosca.hrequirements.*;

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
 * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage
 * @generated
 */
public class Tosca_HRequirements_ExtensionsSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Tosca_HRequirements_ExtensionsPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_HRequirements_ExtensionsSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = Tosca_HRequirements_ExtensionsPackage.eINSTANCE;
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
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT:
      {
        DocumentRoot documentRoot = (DocumentRoot)theEObject;
        T result = caseDocumentRoot(documentRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_HRequirements_ExtensionsPackage.TCPU_REQUIREMENT_PROPERTIES:
      {
        TCPURequirementProperties tcpuRequirementProperties = (TCPURequirementProperties)theEObject;
        T result = caseTCPURequirementProperties(tcpuRequirementProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_HRequirements_ExtensionsPackage.TMEMORY_REQUIREMENT_PROPERTIES:
      {
        TMemoryRequirementProperties tMemoryRequirementProperties = (TMemoryRequirementProperties)theEObject;
        T result = caseTMemoryRequirementProperties(tMemoryRequirementProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_HRequirements_ExtensionsPackage.TNETWORK_REQUIREMENT_PROPERTIES:
      {
        TNetworkRequirementProperties tNetworkRequirementProperties = (TNetworkRequirementProperties)theEObject;
        T result = caseTNetworkRequirementProperties(tNetworkRequirementProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES:
      {
        TStorageRequirementProperties tStorageRequirementProperties = (TStorageRequirementProperties)theEObject;
        T result = caseTStorageRequirementProperties(tStorageRequirementProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
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
   * Returns the result of interpreting the object as an instance of '<em>TCPU Requirement Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TCPU Requirement Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTCPURequirementProperties(TCPURequirementProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TMemory Requirement Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TMemory Requirement Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTMemoryRequirementProperties(TMemoryRequirementProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TNetwork Requirement Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TNetwork Requirement Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTNetworkRequirementProperties(TNetworkRequirementProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TStorage Requirement Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TStorage Requirement Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTStorageRequirementProperties(TStorageRequirementProperties object)
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

} //Tosca_HRequirements_ExtensionsSwitch
