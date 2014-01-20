/**
 */
package eu.celar.tosca.hrequirements;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage
 * @generated
 */
public interface Tosca_HRequirements_ExtensionsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Tosca_HRequirements_ExtensionsFactory eINSTANCE = eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Document Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Document Root</em>'.
   * @generated
   */
  DocumentRoot createDocumentRoot();

  /**
   * Returns a new object of class '<em>TCPU Requirement Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TCPU Requirement Properties</em>'.
   * @generated
   */
  TCPURequirementProperties createTCPURequirementProperties();

  /**
   * Returns a new object of class '<em>TMemory Requirement Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TMemory Requirement Properties</em>'.
   * @generated
   */
  TMemoryRequirementProperties createTMemoryRequirementProperties();

  /**
   * Returns a new object of class '<em>TNetwork Requirement Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TNetwork Requirement Properties</em>'.
   * @generated
   */
  TNetworkRequirementProperties createTNetworkRequirementProperties();

  /**
   * Returns a new object of class '<em>TStorage Requirement Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TStorage Requirement Properties</em>'.
   * @generated
   */
  TStorageRequirementProperties createTStorageRequirementProperties();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Tosca_HRequirements_ExtensionsPackage getTosca_HRequirements_ExtensionsPackage();

} //Tosca_HRequirements_ExtensionsFactory
