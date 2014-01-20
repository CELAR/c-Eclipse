/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TAction Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.TActionParameterType#getParameterName <em>Parameter Name</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.TActionParameterType#getParameterValue <em>Parameter Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTActionParameterType()
 * @model extendedMetaData="name='tActionParameterType' kind='empty'"
 * @generated
 */
public interface TActionParameterType extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameter Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter Name</em>' attribute.
   * @see #setParameterName(String)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTActionParameterType_ParameterName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='attribute' name='ParameterName'"
   * @generated
   */
  String getParameterName();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TActionParameterType#getParameterName <em>Parameter Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter Name</em>' attribute.
   * @see #getParameterName()
   * @generated
   */
  void setParameterName(String value);

  /**
   * Returns the value of the '<em><b>Parameter Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter Value</em>' attribute.
   * @see #setParameterValue(String)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getTActionParameterType_ParameterValue()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='attribute' name='ParameterValue'"
   * @generated
   */
  String getParameterValue();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.TActionParameterType#getParameterValue <em>Parameter Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter Value</em>' attribute.
   * @see #getParameterValue()
   * @generated
   */
  void setParameterValue(String value);

} // TActionParameterType
