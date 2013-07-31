/**
 */
package eu.celar.tosca.elasticity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monitoring Probes Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.MonitoringProbesType1#getMonitoringProbes <em>Monitoring Probes</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getMonitoringProbesType1()
 * @model extendedMetaData="name='MonitoringProbesType1' kind='elementOnly'"
 * @generated
 */
public interface MonitoringProbesType1 extends EObject
{
  /**
   * Returns the value of the '<em><b>Monitoring Probes</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Monitoring Probes</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Monitoring Probes</em>' attribute list.
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getMonitoringProbesType1_MonitoringProbes()
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='monitoringProbes' namespace='##targetNamespace'"
   * @generated
   */
  EList<String> getMonitoringProbes();

} // MonitoringProbesType1
