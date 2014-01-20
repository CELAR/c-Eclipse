/**
 */
package eu.celar.tosca.hrequirements;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCPU Requirement Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.hrequirements.TCPURequirementProperties#getNumCPUs <em>Num CP Us</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getTCPURequirementProperties()
 * @model extendedMetaData="name='tCPURequirementProperties' kind='elementOnly'"
 * @generated
 */
public interface TCPURequirementProperties extends EObject
{
  /**
   * Returns the value of the '<em><b>Num CP Us</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Num CP Us</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num CP Us</em>' attribute.
   * @see #isSetNumCPUs()
   * @see #unsetNumCPUs()
   * @see #setNumCPUs(int)
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getTCPURequirementProperties_NumCPUs()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
   *        extendedMetaData="kind='element' name='NumCPUs'"
   * @generated
   */
  int getNumCPUs();

  /**
   * Sets the value of the '{@link eu.celar.tosca.hrequirements.TCPURequirementProperties#getNumCPUs <em>Num CP Us</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num CP Us</em>' attribute.
   * @see #isSetNumCPUs()
   * @see #unsetNumCPUs()
   * @see #getNumCPUs()
   * @generated
   */
  void setNumCPUs(int value);

  /**
   * Unsets the value of the '{@link eu.celar.tosca.hrequirements.TCPURequirementProperties#getNumCPUs <em>Num CP Us</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetNumCPUs()
   * @see #getNumCPUs()
   * @see #setNumCPUs(int)
   * @generated
   */
  void unsetNumCPUs();

  /**
   * Returns whether the value of the '{@link eu.celar.tosca.hrequirements.TCPURequirementProperties#getNumCPUs <em>Num CP Us</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Num CP Us</em>' attribute is set.
   * @see #unsetNumCPUs()
   * @see #getNumCPUs()
   * @see #setNumCPUs(int)
   * @generated
   */
  boolean isSetNumCPUs();

} // TCPURequirementProperties
