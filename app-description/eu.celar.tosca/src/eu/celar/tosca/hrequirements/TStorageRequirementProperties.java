/**
 */
package eu.celar.tosca.hrequirements;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TStorage Requirement Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.hrequirements.TStorageRequirementProperties#getDiskSpace <em>Disk Space</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.TStorageRequirementProperties#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getTStorageRequirementProperties()
 * @model extendedMetaData="name='tStorageRequirementProperties' kind='elementOnly'"
 * @generated
 */
public interface TStorageRequirementProperties extends EObject
{
  /**
   * Returns the value of the '<em><b>Disk Space</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Disk Space</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Disk Space</em>' attribute.
   * @see #isSetDiskSpace()
   * @see #unsetDiskSpace()
   * @see #setDiskSpace(int)
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getTStorageRequirementProperties_DiskSpace()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
   *        extendedMetaData="kind='element' name='DiskSpace'"
   * @generated
   */
  int getDiskSpace();

  /**
   * Sets the value of the '{@link eu.celar.tosca.hrequirements.TStorageRequirementProperties#getDiskSpace <em>Disk Space</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Disk Space</em>' attribute.
   * @see #isSetDiskSpace()
   * @see #unsetDiskSpace()
   * @see #getDiskSpace()
   * @generated
   */
  void setDiskSpace(int value);

  /**
   * Unsets the value of the '{@link eu.celar.tosca.hrequirements.TStorageRequirementProperties#getDiskSpace <em>Disk Space</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDiskSpace()
   * @see #getDiskSpace()
   * @see #setDiskSpace(int)
   * @generated
   */
  void unsetDiskSpace();

  /**
   * Returns whether the value of the '{@link eu.celar.tosca.hrequirements.TStorageRequirementProperties#getDiskSpace <em>Disk Space</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Disk Space</em>' attribute is set.
   * @see #unsetDiskSpace()
   * @see #getDiskSpace()
   * @see #setDiskSpace(int)
   * @generated
   */
  boolean isSetDiskSpace();

  /**
   * Returns the value of the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' attribute.
   * @see #setUnit(String)
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getTStorageRequirementProperties_Unit()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Unit'"
   * @generated
   */
  String getUnit();

  /**
   * Sets the value of the '{@link eu.celar.tosca.hrequirements.TStorageRequirementProperties#getUnit <em>Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' attribute.
   * @see #getUnit()
   * @generated
   */
  void setUnit(String value);

} // TStorageRequirementProperties
