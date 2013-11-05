/**
 */
package eu.celar.tosca.elasticity;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage
 * @generated
 */
public interface Tosca_Elasticity_ExtensionsFactory extends EFactory
{
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  Tosca_Elasticity_ExtensionsFactory eINSTANCE = eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Data Hints Type1</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Hints Type1</em>'.
	 * @generated
	 */
  DataHintsType1 createDataHintsType1();

  /**
	 * Returns a new object of class '<em>Load Hints Type1</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Load Hints Type1</em>'.
	 * @generated
	 */
  LoadHintsType1 createLoadHintsType1();

  /**
	 * Returns a new object of class '<em>Monitoring Probes Type1</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Monitoring Probes Type1</em>'.
	 * @generated
	 */
  MonitoringProbesType1 createMonitoringProbesType1();

  /**
	 * Returns a new object of class '<em>TBoundary Definitions Extension</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>TBoundary Definitions Extension</em>'.
	 * @generated
	 */
  TBoundaryDefinitionsExtension createTBoundaryDefinitionsExtension();

  /**
	 * Returns a new object of class '<em>TData Hint</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>TData Hint</em>'.
	 * @generated
	 */
  TDataHint createTDataHint();

  /**
	 * Returns a new object of class '<em>TLoad Hint</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>TLoad Hint</em>'.
	 * @generated
	 */
  TLoadHint createTLoadHint();

  /**
	 * Returns a new object of class '<em>TMonitoring Probe</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>TMonitoring Probe</em>'.
	 * @generated
	 */
  TMonitoringProbe createTMonitoringProbe();

  /**
	 * Returns a new object of class '<em>TNode Template Extension</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>TNode Template Extension</em>'.
	 * @generated
	 */
  TNodeTemplateExtension createTNodeTemplateExtension();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  Tosca_Elasticity_ExtensionsPackage getTosca_Elasticity_ExtensionsPackage();

} //Tosca_Elasticity_ExtensionsFactory
