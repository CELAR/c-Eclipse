/**
 */
package eu.celar.tosca;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TNode Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TNodeType#getRequirementDefinitions <em>Requirement Definitions</em>}</li>
 *   <li>{@link eu.celar.tosca.TNodeType#getCapabilityDefinitions <em>Capability Definitions</em>}</li>
 *   <li>{@link eu.celar.tosca.TNodeType#getInstanceStates <em>Instance States</em>}</li>
 *   <li>{@link eu.celar.tosca.TNodeType#getInterfaces <em>Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTNodeType()
 * @model extendedMetaData="name='tNodeType' kind='elementOnly'"
 * @generated
 */
public interface TNodeType extends TEntityType
{
  /**
   * Returns the value of the '<em><b>Requirement Definitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement Definitions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement Definitions</em>' containment reference.
   * @see #setRequirementDefinitions(RequirementDefinitionsType)
   * @see eu.celar.tosca.ToscaPackage#getTNodeType_RequirementDefinitions()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='RequirementDefinitions' namespace='##targetNamespace'"
   * @generated
   */
  RequirementDefinitionsType getRequirementDefinitions();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TNodeType#getRequirementDefinitions <em>Requirement Definitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requirement Definitions</em>' containment reference.
   * @see #getRequirementDefinitions()
   * @generated
   */
  void setRequirementDefinitions(RequirementDefinitionsType value);

  /**
   * Returns the value of the '<em><b>Capability Definitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capability Definitions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capability Definitions</em>' containment reference.
   * @see #setCapabilityDefinitions(CapabilityDefinitionsType)
   * @see eu.celar.tosca.ToscaPackage#getTNodeType_CapabilityDefinitions()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='CapabilityDefinitions' namespace='##targetNamespace'"
   * @generated
   */
  CapabilityDefinitionsType getCapabilityDefinitions();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TNodeType#getCapabilityDefinitions <em>Capability Definitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Capability Definitions</em>' containment reference.
   * @see #getCapabilityDefinitions()
   * @generated
   */
  void setCapabilityDefinitions(CapabilityDefinitionsType value);

  /**
   * Returns the value of the '<em><b>Instance States</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instance States</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance States</em>' containment reference.
   * @see #setInstanceStates(TTopologyElementInstanceStates)
   * @see eu.celar.tosca.ToscaPackage#getTNodeType_InstanceStates()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='InstanceStates' namespace='##targetNamespace'"
   * @generated
   */
  TTopologyElementInstanceStates getInstanceStates();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TNodeType#getInstanceStates <em>Instance States</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance States</em>' containment reference.
   * @see #getInstanceStates()
   * @generated
   */
  void setInstanceStates(TTopologyElementInstanceStates value);

  /**
   * Returns the value of the '<em><b>Interfaces</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interfaces</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interfaces</em>' containment reference.
   * @see #setInterfaces(InterfacesType)
   * @see eu.celar.tosca.ToscaPackage#getTNodeType_Interfaces()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Interfaces' namespace='##targetNamespace'"
   * @generated
   */
  InterfacesType getInterfaces();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TNodeType#getInterfaces <em>Interfaces</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interfaces</em>' containment reference.
   * @see #getInterfaces()
   * @generated
   */
  void setInterfaces(InterfacesType value);

} // TNodeType
