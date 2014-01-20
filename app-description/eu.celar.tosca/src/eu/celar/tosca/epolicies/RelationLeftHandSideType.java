/**
 */
package eu.celar.tosca.epolicies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Left Hand Side Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.RelationLeftHandSideType#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getRelationLeftHandSideType()
 * @model extendedMetaData="name='RelationLeftHandSide_._type' kind='elementOnly'"
 * @generated
 */
public interface RelationLeftHandSideType extends EObject
{
  /**
   * Returns the value of the '<em><b>Metric</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metric</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metric</em>' attribute.
   * @see #setMetric(String)
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#getRelationLeftHandSideType_Metric()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Metric'"
   * @generated
   */
  String getMetric();

  /**
   * Sets the value of the '{@link eu.celar.tosca.epolicies.RelationLeftHandSideType#getMetric <em>Metric</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metric</em>' attribute.
   * @see #getMetric()
   * @generated
   */
  void setMetric(String value);

} // RelationLeftHandSideType
