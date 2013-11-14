/**
 */
package eu.celar.tosca.elasticity;

import eu.celar.tosca.TServiceTemplate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TService Template Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.TServiceTemplateExtension#getX <em>X</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TServiceTemplateExtension#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTServiceTemplateExtension()
 * @model extendedMetaData="name='TServiceTemplateExtension' kind='elementOnly'"
 * @generated
 */
public interface TServiceTemplateExtension extends TServiceTemplate
{
  /**
   * Returns the value of the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>X</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>X</em>' attribute.
   * @see #isSetX()
   * @see #unsetX()
   * @see #setX(int)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTServiceTemplateExtension_X()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='x'"
   * @generated
   */
  int getX();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TServiceTemplateExtension#getX <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>X</em>' attribute.
   * @see #isSetX()
   * @see #unsetX()
   * @see #getX()
   * @generated
   */
  void setX(int value);

  /**
   * Unsets the value of the '{@link eu.celar.tosca.elasticity.TServiceTemplateExtension#getX <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetX()
   * @see #getX()
   * @see #setX(int)
   * @generated
   */
  void unsetX();

  /**
   * Returns whether the value of the '{@link eu.celar.tosca.elasticity.TServiceTemplateExtension#getX <em>X</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>X</em>' attribute is set.
   * @see #unsetX()
   * @see #getX()
   * @see #setX(int)
   * @generated
   */
  boolean isSetX();

  /**
   * Returns the value of the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Y</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Y</em>' attribute.
   * @see #isSetY()
   * @see #unsetY()
   * @see #setY(int)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTServiceTemplateExtension_Y()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='y'"
   * @generated
   */
  int getY();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TServiceTemplateExtension#getY <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Y</em>' attribute.
   * @see #isSetY()
   * @see #unsetY()
   * @see #getY()
   * @generated
   */
  void setY(int value);

  /**
   * Unsets the value of the '{@link eu.celar.tosca.elasticity.TServiceTemplateExtension#getY <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetY()
   * @see #getY()
   * @see #setY(int)
   * @generated
   */
  void unsetY();

  /**
   * Returns whether the value of the '{@link eu.celar.tosca.elasticity.TServiceTemplateExtension#getY <em>Y</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Y</em>' attribute is set.
   * @see #unsetY()
   * @see #getY()
   * @see #setY(int)
   * @generated
   */
  boolean isSetY();

} // TServiceTemplateExtension
