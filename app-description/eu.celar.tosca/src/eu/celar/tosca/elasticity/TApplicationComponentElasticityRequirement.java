/**
 */
package eu.celar.tosca.elasticity;

import eu.celar.tosca.TExtensibleElements;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TApplication Component Elasticity Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement#getName <em>Name</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTApplicationComponentElasticityRequirement()
 * @model extendedMetaData="name='TApplicationComponentElasticityRequirement' kind='elementOnly'"
 * @generated
 */
public interface TApplicationComponentElasticityRequirement extends TExtensibleElements
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTApplicationComponentElasticityRequirement_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='Name'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTApplicationComponentElasticityRequirement_Value()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='Value'"
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // TApplicationComponentElasticityRequirement
