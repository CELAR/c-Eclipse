/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirements Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.RequirementsType1#getRequirement <em>Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getRequirementsType1()
 * @model extendedMetaData="name='Requirements_._1_._type' kind='elementOnly'"
 * @generated
 */
public interface RequirementsType1 extends EObject
{
  /**
   * Returns the value of the '<em><b>Requirement</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TRequirementRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getRequirementsType1_Requirement()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='Requirement' namespace='##targetNamespace'"
   * @generated
   */
  EList<TRequirementRef> getRequirement();

} // RequirementsType1
