/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Definitions Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.RequirementDefinitionsType#getRequirementDefinition <em>Requirement Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getRequirementDefinitionsType()
 * @model extendedMetaData="name='RequirementDefinitions_._type' kind='elementOnly'"
 * @generated
 */
public interface RequirementDefinitionsType extends EObject
{
  /**
   * Returns the value of the '<em><b>Requirement Definition</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TRequirementDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement Definition</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement Definition</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getRequirementDefinitionsType_RequirementDefinition()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='RequirementDefinition' namespace='##targetNamespace'"
   * @generated
   */
  EList<TRequirementDefinition> getRequirementDefinition();

} // RequirementDefinitionsType
