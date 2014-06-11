/**
 */
package org.example.sybl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Elasticity Requirements Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.sybl.SyblElasticityRequirementsDescription#getSYBLSpecification <em>SYBL Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.sybl.SyblPackage#getSyblElasticityRequirementsDescription()
 * @model extendedMetaData="name='syblElasticityRequirementsDescription' kind='elementOnly'"
 * @generated
 */
public interface SyblElasticityRequirementsDescription extends EObject
{
  /**
   * Returns the value of the '<em><b>SYBL Specification</b></em>' containment reference list.
   * The list contents are of type {@link org.example.sybl.SYBLSpecificationType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>SYBL Specification</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>SYBL Specification</em>' containment reference list.
   * @see org.example.sybl.SyblPackage#getSyblElasticityRequirementsDescription_SYBLSpecification()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='SYBLSpecification'"
   * @generated
   */
  EList<SYBLSpecificationType> getSYBLSpecification();

} // SyblElasticityRequirementsDescription
