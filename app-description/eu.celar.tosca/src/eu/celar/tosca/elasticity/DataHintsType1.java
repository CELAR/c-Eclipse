/**
 */
package eu.celar.tosca.elasticity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Hints Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.DataHintsType1#getDataHints <em>Data Hints</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDataHintsType1()
 * @model extendedMetaData="name='DataHintsType1' kind='elementOnly'"
 * @generated
 */
public interface DataHintsType1 extends EObject
{
  /**
	 * Returns the value of the '<em><b>Data Hints</b></em>' containment reference list.
	 * The list contents are of type {@link eu.celar.tosca.elasticity.TDataHint}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Hints</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Hints</em>' containment reference list.
	 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDataHintsType1_DataHints()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='dataHints' namespace='##targetNamespace'"
	 * @generated
	 */
  EList<TDataHint> getDataHints();

} // DataHintsType1
