/**
 */
package eu.celar.tosca.elasticity;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Properties Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.ServicePropertiesType#getVersion <em>Version</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.ServicePropertiesType#getHostingEnvironment <em>Hosting Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getServicePropertiesType()
 * @model extendedMetaData="name='ServicePropertiesType' kind='elementOnly'"
 * @generated
 */
public interface ServicePropertiesType extends EObject
{
  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(String)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getServicePropertiesType_Version()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Version' namespace='##targetNamespace'"
   * @generated
   */
  String getVersion();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.ServicePropertiesType#getVersion <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' attribute.
   * @see #getVersion()
   * @generated
   */
  void setVersion(String value);

  /**
   * Returns the value of the '<em><b>Hosting Environment</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hosting Environment</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hosting Environment</em>' attribute list.
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getServicePropertiesType_HostingEnvironment()
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='HostingEnvironment' namespace='##targetNamespace'"
   * @generated
   */
  EList<String> getHostingEnvironment();

} // ServicePropertiesType
