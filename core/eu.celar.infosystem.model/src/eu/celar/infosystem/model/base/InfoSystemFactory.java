/**
 */
package eu.celar.infosystem.model.base;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.celar.infosystem.model.base.InfoSystemPackage
 * @generated
 */
public interface InfoSystemFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  InfoSystemFactory eINSTANCE = eu.celar.infosystem.model.base.impl.InfoSystemFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Monitoring Probe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Monitoring Probe</em>'.
   * @generated
   */
  MonitoringProbe createMonitoringProbe();

  /**
   * Returns a new object of class '<em>Resizing Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Resizing Action</em>'.
   * @generated
   */
  ResizingAction createResizingAction();

  /**
   * Returns a new object of class '<em>Software Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Software Dependency</em>'.
   * @generated
   */
  SoftwareDependency createSoftwareDependency();

  /**
   * Returns a new object of class '<em>Virtual Machine Image</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Virtual Machine Image</em>'.
   * @generated
   */
  VirtualMachineImage createVirtualMachineImage();

  /**
   * Returns a new object of class '<em>User Application</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>User Application</em>'.
   * @generated
   */
  UserApplication createUserApplication();

  /**
   * Returns a new object of class '<em>Key Pair</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Key Pair</em>'.
   * @generated
   */
  KeyPair createKeyPair();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  InfoSystemPackage getInfoSystemPackage();

} //InfoSystemFactory
