/**
 */
package eu.celar.tosca.elasticity;

import eu.celar.tosca.TNodeTemplate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TNode Template Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getCasmulti <em>Casmulti</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getInitInstances <em>Init Instances</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getX <em>X</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getY <em>Y</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getYcsbmulti <em>Ycsbmulti</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension()
 * @model extendedMetaData="name='TNodeTemplateExtension' kind='elementOnly'"
 * @generated
 */
public interface TNodeTemplateExtension extends TNodeTemplate
{

	/**
   * Returns the value of the '<em><b>Casmulti</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Casmulti</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Casmulti</em>' attribute.
   * @see #isSetCasmulti()
   * @see #unsetCasmulti()
   * @see #setCasmulti(int)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_Casmulti()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='casmulti'"
   * @generated
   */
	int getCasmulti();

	/**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getCasmulti <em>Casmulti</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Casmulti</em>' attribute.
   * @see #isSetCasmulti()
   * @see #unsetCasmulti()
   * @see #getCasmulti()
   * @generated
   */
	void setCasmulti(int value);

	/**
   * Unsets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getCasmulti <em>Casmulti</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isSetCasmulti()
   * @see #getCasmulti()
   * @see #setCasmulti(int)
   * @generated
   */
	void unsetCasmulti();

	/**
   * Returns whether the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getCasmulti <em>Casmulti</em>}' attribute is set.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return whether the value of the '<em>Casmulti</em>' attribute is set.
   * @see #unsetCasmulti()
   * @see #getCasmulti()
   * @see #setCasmulti(int)
   * @generated
   */
	boolean isSetCasmulti();

	/**
   * Returns the value of the '<em><b>Init Instances</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Init Instances</em>' attribute.
   * @see #isSetInitInstances()
   * @see #unsetInitInstances()
   * @see #setInitInstances(int)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_InitInstances()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='initInstances'"
   * @generated
   */
	int getInitInstances();

	/**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getInitInstances <em>Init Instances</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init Instances</em>' attribute.
   * @see #isSetInitInstances()
   * @see #unsetInitInstances()
   * @see #getInitInstances()
   * @generated
   */
	void setInitInstances(int value);

	/**
   * Unsets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getInitInstances <em>Init Instances</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isSetInitInstances()
   * @see #getInitInstances()
   * @see #setInitInstances(int)
   * @generated
   */
	void unsetInitInstances();

	/**
   * Returns whether the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getInitInstances <em>Init Instances</em>}' attribute is set.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return whether the value of the '<em>Init Instances</em>' attribute is set.
   * @see #unsetInitInstances()
   * @see #getInitInstances()
   * @see #setInitInstances(int)
   * @generated
   */
	boolean isSetInitInstances();

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
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_X()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='x'"
   * @generated
   */
	int getX();

	/**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getX <em>X</em>}' attribute.
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
   * Unsets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getX <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isSetX()
   * @see #getX()
   * @see #setX(int)
   * @generated
   */
	void unsetX();

	/**
   * Returns whether the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getX <em>X</em>}' attribute is set.
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
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_Y()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='y'"
   * @generated
   */
	int getY();

	/**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getY <em>Y</em>}' attribute.
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
   * Unsets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getY <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isSetY()
   * @see #getY()
   * @see #setY(int)
   * @generated
   */
	void unsetY();

	/**
   * Returns whether the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getY <em>Y</em>}' attribute is set.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return whether the value of the '<em>Y</em>' attribute is set.
   * @see #unsetY()
   * @see #getY()
   * @see #setY(int)
   * @generated
   */
	boolean isSetY();

	/**
   * Returns the value of the '<em><b>Ycsbmulti</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ycsbmulti</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Ycsbmulti</em>' attribute.
   * @see #isSetYcsbmulti()
   * @see #unsetYcsbmulti()
   * @see #setYcsbmulti(int)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_Ycsbmulti()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='ycsbmulti'"
   * @generated
   */
	int getYcsbmulti();

	/**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getYcsbmulti <em>Ycsbmulti</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ycsbmulti</em>' attribute.
   * @see #isSetYcsbmulti()
   * @see #unsetYcsbmulti()
   * @see #getYcsbmulti()
   * @generated
   */
	void setYcsbmulti(int value);

	/**
   * Unsets the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getYcsbmulti <em>Ycsbmulti</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isSetYcsbmulti()
   * @see #getYcsbmulti()
   * @see #setYcsbmulti(int)
   * @generated
   */
	void unsetYcsbmulti();

	/**
   * Returns whether the value of the '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension#getYcsbmulti <em>Ycsbmulti</em>}' attribute is set.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return whether the value of the '<em>Ycsbmulti</em>' attribute is set.
   * @see #unsetYcsbmulti()
   * @see #getYcsbmulti()
   * @see #setYcsbmulti(int)
   * @generated
   */
	boolean isSetYcsbmulti();
} // TNodeTemplateExtension
