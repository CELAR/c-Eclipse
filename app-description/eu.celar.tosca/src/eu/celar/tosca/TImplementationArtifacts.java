/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TImplementation Artifacts</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TImplementationArtifacts#getImplementationArtifact <em>Implementation Artifact</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTImplementationArtifacts()
 * @model extendedMetaData="name='tImplementationArtifacts' kind='elementOnly'"
 * @generated
 */
public interface TImplementationArtifacts extends EObject
{
  /**
   * Returns the value of the '<em><b>Implementation Artifact</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.ImplementationArtifactType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Implementation Artifact</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implementation Artifact</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getTImplementationArtifacts_ImplementationArtifact()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='ImplementationArtifact' namespace='##targetNamespace'"
   * @generated
   */
  EList<ImplementationArtifactType> getImplementationArtifact();

} // TImplementationArtifacts
