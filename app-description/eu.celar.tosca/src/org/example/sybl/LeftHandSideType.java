/**
 */
package org.example.sybl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Left Hand Side Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.sybl.LeftHandSideType#getMetric <em>Metric</em>}</li>
 *   <li>{@link org.example.sybl.LeftHandSideType#getNumber <em>Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.sybl.SyblPackage#getLeftHandSideType()
 * @model extendedMetaData="name='LeftHandSide_._type' kind='elementOnly'"
 * @generated
 */
public interface LeftHandSideType extends EObject
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
   * @see org.example.sybl.SyblPackage#getLeftHandSideType_Metric()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' name='Metric'"
   * @generated
   */
  String getMetric();

  /**
   * Sets the value of the '{@link org.example.sybl.LeftHandSideType#getMetric <em>Metric</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metric</em>' attribute.
   * @see #getMetric()
   * @generated
   */
  void setMetric(String value);

  /**
   * Returns the value of the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number</em>' attribute.
   * @see #setNumber(String)
   * @see org.example.sybl.SyblPackage#getLeftHandSideType_Number()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' name='Number'"
   * @generated
   */
  String getNumber();

  /**
   * Sets the value of the '{@link org.example.sybl.LeftHandSideType#getNumber <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' attribute.
   * @see #getNumber()
   * @generated
   */
  void setNumber(String value);

} // LeftHandSideType
