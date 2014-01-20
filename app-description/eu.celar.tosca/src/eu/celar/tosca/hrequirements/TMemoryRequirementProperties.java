/**
 */
package eu.celar.tosca.hrequirements;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TMemory Requirement Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.hrequirements.TMemoryRequirementProperties#getMemory <em>Memory</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getTMemoryRequirementProperties()
 * @model extendedMetaData="name='tMemoryRequirementProperties' kind='elementOnly'"
 * @generated
 */
public interface TMemoryRequirementProperties extends EObject
{
  /**
   * Returns the value of the '<em><b>Memory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Memory</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Memory</em>' attribute.
   * @see #isSetMemory()
   * @see #unsetMemory()
   * @see #setMemory(int)
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getTMemoryRequirementProperties_Memory()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
   *        extendedMetaData="kind='element' name='Memory'"
   * @generated
   */
  int getMemory();

  /**
   * Sets the value of the '{@link eu.celar.tosca.hrequirements.TMemoryRequirementProperties#getMemory <em>Memory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Memory</em>' attribute.
   * @see #isSetMemory()
   * @see #unsetMemory()
   * @see #getMemory()
   * @generated
   */
  void setMemory(int value);

  /**
   * Unsets the value of the '{@link eu.celar.tosca.hrequirements.TMemoryRequirementProperties#getMemory <em>Memory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMemory()
   * @see #getMemory()
   * @see #setMemory(int)
   * @generated
   */
  void unsetMemory();

  /**
   * Returns whether the value of the '{@link eu.celar.tosca.hrequirements.TMemoryRequirementProperties#getMemory <em>Memory</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Memory</em>' attribute is set.
   * @see #unsetMemory()
   * @see #getMemory()
   * @see #setMemory(int)
   * @generated
   */
  boolean isSetMemory();

} // TMemoryRequirementProperties
