/**
 */
package eu.celar.tosca.elasticity;

import eu.celar.tosca.TBoundaryDefinitions;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TBoundary Definitions Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension#getGlobalElasticityRequirements <em>Global Elasticity Requirements</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension#getMonitoringProbes <em>Monitoring Probes</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTBoundaryDefinitionsExtension()
 * @model extendedMetaData="name='TBoundaryDefinitionsExtension' kind='elementOnly'"
 * @generated
 */
public interface TBoundaryDefinitionsExtension extends TBoundaryDefinitions
{
  /**
   * Returns the value of the '<em><b>Global Elasticity Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Global Elasticity Requirements</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Global Elasticity Requirements</em>' containment reference.
   * @see #setGlobalElasticityRequirements(GlobalElasticityRequirementsType1)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTBoundaryDefinitionsExtension_GlobalElasticityRequirements()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='globalElasticityRequirements' namespace='##targetNamespace'"
   * @generated
   */
  GlobalElasticityRequirementsType1 getGlobalElasticityRequirements();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension#getGlobalElasticityRequirements <em>Global Elasticity Requirements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Global Elasticity Requirements</em>' containment reference.
   * @see #getGlobalElasticityRequirements()
   * @generated
   */
  void setGlobalElasticityRequirements(GlobalElasticityRequirementsType1 value);

  /**
   * Returns the value of the '<em><b>Monitoring Probes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Monitoring Probes</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Monitoring Probes</em>' containment reference.
   * @see #setMonitoringProbes(MonitoringProbesType1)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTBoundaryDefinitionsExtension_MonitoringProbes()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='monitoringProbes' namespace='##targetNamespace'"
   * @generated
   */
  MonitoringProbesType1 getMonitoringProbes();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension#getMonitoringProbes <em>Monitoring Probes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Monitoring Probes</em>' containment reference.
   * @see #getMonitoringProbes()
   * @generated
   */
  void setMonitoringProbes(MonitoringProbesType1 value);

} // TBoundaryDefinitionsExtension
