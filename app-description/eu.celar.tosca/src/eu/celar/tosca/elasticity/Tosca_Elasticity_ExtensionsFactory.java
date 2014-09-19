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
   * Returns a new object of class '<em>Document Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Document Root</em>'.
   * @generated
   */
  DocumentRoot createDocumentRoot();

  /**
   * Returns a new object of class '<em>Image Artifact Properties Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Image Artifact Properties Type</em>'.
   * @generated
   */
  ImageArtifactPropertiesType createImageArtifactPropertiesType();

  /**
   * Returns a new object of class '<em>Monitoring Probes Type1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Monitoring Probes Type1</em>'.
   * @generated
   */
  MonitoringProbesType1 createMonitoringProbesType1();

  /**
   * Returns a new object of class '<em>Node Properties Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Properties Type</em>'.
   * @generated
   */
  NodePropertiesType createNodePropertiesType();

  /**
   * Returns a new object of class '<em>Script Artifact Properties Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Script Artifact Properties Type</em>'.
   * @generated
   */
  ScriptArtifactPropertiesType createScriptArtifactPropertiesType();

  /**
   * Returns a new object of class '<em>Service Properties Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Service Properties Type</em>'.
   * @generated
   */
  ServicePropertiesType createServicePropertiesType();

  /**
   * Returns a new object of class '<em>TBoundary Definitions Extension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TBoundary Definitions Extension</em>'.
   * @generated
   */
  TBoundaryDefinitionsExtension createTBoundaryDefinitionsExtension();

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
   * Returns a new object of class '<em>TService Template Extension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TService Template Extension</em>'.
   * @generated
   */
  TServiceTemplateExtension createTServiceTemplateExtension();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Tosca_Elasticity_ExtensionsPackage getTosca_Elasticity_ExtensionsPackage();

} //Tosca_Elasticity_ExtensionsFactory
