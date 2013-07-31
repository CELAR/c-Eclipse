/**
 */
package eu.celar.tosca.elasticity;

import eu.celar.tosca.TNodeTemplate;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TNode Template Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentElasticityRequirements <em>Application Component Elasticity Requirements</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentDataHints <em>Application Component Data Hints</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentLoadHints <em>Application Component Load Hints</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentMonitoringProbes <em>Application Component Monitoring Probes</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentResizingActions <em>Application Component Resizing Actions</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentVMI <em>Application Component VMI</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension()
 * @model extendedMetaData="name='TNodeTemplateExtension' kind='elementOnly'"
 * @generated
 */
public interface TNodeTemplateExtension extends TNodeTemplate
{
  /**
   * Returns the value of the '<em><b>Application Component Elasticity Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application Component Elasticity Requirements</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Application Component Elasticity Requirements</em>' containment reference.
   * @see #setApplicationComponentElasticityRequirements(ApplicationComponentElasticityRequirementsType1)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_ApplicationComponentElasticityRequirements()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='applicationComponentElasticityRequirements' namespace='##targetNamespace'"
   * @generated
   */
  ApplicationComponentElasticityRequirementsType1 getApplicationComponentElasticityRequirements();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentElasticityRequirements <em>Application Component Elasticity Requirements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Application Component Elasticity Requirements</em>' containment reference.
   * @see #getApplicationComponentElasticityRequirements()
   * @generated
   */
  void setApplicationComponentElasticityRequirements(ApplicationComponentElasticityRequirementsType1 value);

  /**
   * Returns the value of the '<em><b>Application Component Data Hints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application Component Data Hints</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Application Component Data Hints</em>' containment reference.
   * @see #setApplicationComponentDataHints(DataHintsType1)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_ApplicationComponentDataHints()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='applicationComponentDataHints' namespace='##targetNamespace'"
   * @generated
   */
  DataHintsType1 getApplicationComponentDataHints();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentDataHints <em>Application Component Data Hints</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Application Component Data Hints</em>' containment reference.
   * @see #getApplicationComponentDataHints()
   * @generated
   */
  void setApplicationComponentDataHints(DataHintsType1 value);

  /**
   * Returns the value of the '<em><b>Application Component Load Hints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application Component Load Hints</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Application Component Load Hints</em>' containment reference.
   * @see #setApplicationComponentLoadHints(LoadHintsType1)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_ApplicationComponentLoadHints()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='applicationComponentLoadHints' namespace='##targetNamespace'"
   * @generated
   */
  LoadHintsType1 getApplicationComponentLoadHints();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentLoadHints <em>Application Component Load Hints</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Application Component Load Hints</em>' containment reference.
   * @see #getApplicationComponentLoadHints()
   * @generated
   */
  void setApplicationComponentLoadHints(LoadHintsType1 value);

  /**
   * Returns the value of the '<em><b>Application Component Monitoring Probes</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application Component Monitoring Probes</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Application Component Monitoring Probes</em>' attribute list.
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_ApplicationComponentMonitoringProbes()
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' name='applicationComponentMonitoringProbes' namespace='##targetNamespace'"
   * @generated
   */
  EList<String> getApplicationComponentMonitoringProbes();

  /**
   * Returns the value of the '<em><b>Application Component Resizing Actions</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application Component Resizing Actions</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Application Component Resizing Actions</em>' attribute list.
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_ApplicationComponentResizingActions()
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' name='applicationComponentResizingActions' namespace='##targetNamespace'"
   * @generated
   */
  EList<String> getApplicationComponentResizingActions();

  /**
   * Returns the value of the '<em><b>Application Component VMI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application Component VMI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Application Component VMI</em>' attribute.
   * @see #setApplicationComponentVMI(String)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_ApplicationComponentVMI()
   * @model dataType="eu.celar.tosca.elasticity.TVirtualMachineImage"
   *        extendedMetaData="kind='element' name='applicationComponentVMI' namespace='##targetNamespace'"
   * @generated
   */
  String getApplicationComponentVMI();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getApplicationComponentVMI <em>Application Component VMI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Application Component VMI</em>' attribute.
   * @see #getApplicationComponentVMI()
   * @generated
   */
  void setApplicationComponentVMI(String value);

} // TNodeTemplateExtension
