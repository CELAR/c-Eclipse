/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TExtensions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TExtensions#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTExtensions()
 * @model extendedMetaData="name='tExtensions' kind='elementOnly'"
 * @generated
 */
public interface TExtensions extends TExtensibleElements
{
  /**
   * Returns the value of the '<em><b>Extension</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TExtension}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extension</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getTExtensions_Extension()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='Extension' namespace='##targetNamespace'"
   * @generated
   */
  EList<TExtension> getExtension();

} // TExtensions
