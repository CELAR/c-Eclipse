/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TRequired Container Features</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TRequiredContainerFeatures#getRequiredContainerFeature <em>Required Container Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTRequiredContainerFeatures()
 * @model extendedMetaData="name='tRequiredContainerFeatures' kind='elementOnly'"
 * @generated
 */
public interface TRequiredContainerFeatures extends EObject
{
  /**
   * Returns the value of the '<em><b>Required Container Feature</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TRequiredContainerFeature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Container Feature</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Container Feature</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getTRequiredContainerFeatures_RequiredContainerFeature()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='RequiredContainerFeature' namespace='##targetNamespace'"
   * @generated
   */
  EList<TRequiredContainerFeature> getRequiredContainerFeature();

} // TRequiredContainerFeatures
