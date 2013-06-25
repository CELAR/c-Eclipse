/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Constraints Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.PropertyConstraintsType1#getPropertyConstraint <em>Property Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getPropertyConstraintsType1()
 * @model extendedMetaData="name='PropertyConstraints_._1_._type' kind='elementOnly'"
 * @generated
 */
public interface PropertyConstraintsType1 extends EObject
{
  /**
   * Returns the value of the '<em><b>Property Constraint</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TPropertyConstraint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Constraint</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Constraint</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getPropertyConstraintsType1_PropertyConstraint()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='PropertyConstraint' namespace='##targetNamespace'"
   * @generated
   */
  EList<TPropertyConstraint> getPropertyConstraint();

} // PropertyConstraintsType1
