/**
 */
package eu.celar.tosca.elasticity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Load Hints Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.LoadHintsType1#getLoadHints <em>Load Hints</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getLoadHintsType1()
 * @model extendedMetaData="name='LoadHintsType1' kind='elementOnly'"
 * @generated
 */
public interface LoadHintsType1 extends EObject
{
  /**
	 * Returns the value of the '<em><b>Load Hints</b></em>' containment reference list.
	 * The list contents are of type {@link eu.celar.tosca.elasticity.TLoadHint}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Load Hints</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Load Hints</em>' containment reference list.
	 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getLoadHintsType1_LoadHints()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='loadHints' namespace='##targetNamespace'"
	 * @generated
	 */
  EList<TLoadHint> getLoadHints();

} // LoadHintsType1
