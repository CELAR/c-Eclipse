/**
 */
package eu.celar.tosca.hrequirements;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TNetwork Requirement Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.hrequirements.TNetworkRequirementProperties#isNetwork <em>Network</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.TNetworkRequirementProperties#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getTNetworkRequirementProperties()
 * @model extendedMetaData="name='tNetworkRequirementProperties' kind='elementOnly'"
 * @generated
 */
public interface TNetworkRequirementProperties extends EObject
{
  /**
   * Returns the value of the '<em><b>Network</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Network</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Network</em>' attribute.
   * @see #isSetNetwork()
   * @see #unsetNetwork()
   * @see #setNetwork(boolean)
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getTNetworkRequirementProperties_Network()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
   *        extendedMetaData="kind='element' name='Network'"
   * @generated
   */
  boolean isNetwork();

  /**
   * Sets the value of the '{@link eu.celar.tosca.hrequirements.TNetworkRequirementProperties#isNetwork <em>Network</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Network</em>' attribute.
   * @see #isSetNetwork()
   * @see #unsetNetwork()
   * @see #isNetwork()
   * @generated
   */
  void setNetwork(boolean value);

  /**
   * Unsets the value of the '{@link eu.celar.tosca.hrequirements.TNetworkRequirementProperties#isNetwork <em>Network</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetNetwork()
   * @see #isNetwork()
   * @see #setNetwork(boolean)
   * @generated
   */
  void unsetNetwork();

  /**
   * Returns whether the value of the '{@link eu.celar.tosca.hrequirements.TNetworkRequirementProperties#isNetwork <em>Network</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Network</em>' attribute is set.
   * @see #unsetNetwork()
   * @see #isNetwork()
   * @see #setNetwork(boolean)
   * @generated
   */
  boolean isSetNetwork();

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
   * @see eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage#getTNetworkRequirementProperties_Unit()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Unit'"
   * @generated
   */
  String getUnit();

  /**
   * Sets the value of the '{@link eu.celar.tosca.hrequirements.TNetworkRequirementProperties#getUnit <em>Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' attribute.
   * @see #getUnit()
   * @generated
   */
  void setUnit(String value);

} // TNetworkRequirementProperties
