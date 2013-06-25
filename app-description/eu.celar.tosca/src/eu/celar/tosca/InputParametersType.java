/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Parameters Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.InputParametersType#getInputParameter <em>Input Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getInputParametersType()
 * @model extendedMetaData="name='InputParameters_._type' kind='elementOnly'"
 * @generated
 */
public interface InputParametersType extends EObject
{
  /**
   * Returns the value of the '<em><b>Input Parameter</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Input Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input Parameter</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getInputParametersType_InputParameter()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='InputParameter' namespace='##targetNamespace'"
   * @generated
   */
  EList<TParameter> getInputParameter();

} // InputParametersType
