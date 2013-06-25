/**
 */
package eu.celar.tosca;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Valid Target Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.ValidTargetType#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getValidTargetType()
 * @model extendedMetaData="name='ValidTarget_._type' kind='empty'"
 * @generated
 */
public interface ValidTargetType extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Ref</em>' attribute.
   * @see #setTypeRef(QName)
   * @see eu.celar.tosca.ToscaPackage#getValidTargetType_TypeRef()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
   *        extendedMetaData="kind='attribute' name='typeRef'"
   * @generated
   */
  QName getTypeRef();

  /**
   * Sets the value of the '{@link eu.celar.tosca.ValidTargetType#getTypeRef <em>Type Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Ref</em>' attribute.
   * @see #getTypeRef()
   * @generated
   */
  void setTypeRef(QName value);

} // ValidTargetType
