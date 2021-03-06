/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Parameters Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.OutputParametersType#getOutputParameter <em>Output Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getOutputParametersType()
 * @model extendedMetaData="name='OutputParameters_._type' kind='elementOnly'"
 * @generated
 */
public interface OutputParametersType extends EObject
{
  /**
   * Returns the value of the '<em><b>Output Parameter</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output Parameter</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getOutputParametersType_OutputParameter()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='OutputParameter' namespace='##targetNamespace'"
   * @generated
   */
  EList<TParameter> getOutputParameter();

} // OutputParametersType
