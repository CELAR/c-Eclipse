/**
 */
package eu.celar.tosca;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPolicy Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TPolicyTemplate#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTPolicyTemplate()
 * @model extendedMetaData="name='tPolicyTemplate' kind='elementOnly'"
 * @generated
 */
public interface TPolicyTemplate extends TEntityTemplate
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
   * @see eu.celar.tosca.ToscaPackage#getTPolicyTemplate_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='name'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TPolicyTemplate#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // TPolicyTemplate
