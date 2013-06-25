/**
 */
package eu.celar.tosca;

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TRequirement Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TRequirementDefinition#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link eu.celar.tosca.TRequirementDefinition#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link eu.celar.tosca.TRequirementDefinition#getName <em>Name</em>}</li>
 *   <li>{@link eu.celar.tosca.TRequirementDefinition#getRequirementType <em>Requirement Type</em>}</li>
 *   <li>{@link eu.celar.tosca.TRequirementDefinition#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTRequirementDefinition()
 * @model extendedMetaData="name='tRequirementDefinition' kind='elementOnly'"
 * @generated
 */
public interface TRequirementDefinition extends TExtensibleElements
{
  /**
   * Returns the value of the '<em><b>Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraints</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraints</em>' containment reference.
   * @see #setConstraints(ConstraintsType1)
   * @see eu.celar.tosca.ToscaPackage#getTRequirementDefinition_Constraints()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Constraints' namespace='##targetNamespace'"
   * @generated
   */
  ConstraintsType1 getConstraints();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TRequirementDefinition#getConstraints <em>Constraints</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraints</em>' containment reference.
   * @see #getConstraints()
   * @generated
   */
  void setConstraints(ConstraintsType1 value);

  /**
   * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower Bound</em>' attribute.
   * @see #isSetLowerBound()
   * @see #unsetLowerBound()
   * @see #setLowerBound(int)
   * @see eu.celar.tosca.ToscaPackage#getTRequirementDefinition_LowerBound()
   * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='lowerBound'"
   * @generated
   */
  int getLowerBound();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TRequirementDefinition#getLowerBound <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Bound</em>' attribute.
   * @see #isSetLowerBound()
   * @see #unsetLowerBound()
   * @see #getLowerBound()
   * @generated
   */
  void setLowerBound(int value);

  /**
   * Unsets the value of the '{@link eu.celar.tosca.TRequirementDefinition#getLowerBound <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLowerBound()
   * @see #getLowerBound()
   * @see #setLowerBound(int)
   * @generated
   */
  void unsetLowerBound();

  /**
   * Returns whether the value of the '{@link eu.celar.tosca.TRequirementDefinition#getLowerBound <em>Lower Bound</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Lower Bound</em>' attribute is set.
   * @see #unsetLowerBound()
   * @see #getLowerBound()
   * @see #setLowerBound(int)
   * @generated
   */
  boolean isSetLowerBound();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see eu.celar.tosca.ToscaPackage#getTRequirementDefinition_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='attribute' name='name'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TRequirementDefinition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Requirement Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement Type</em>' attribute.
   * @see #setRequirementType(QName)
   * @see eu.celar.tosca.ToscaPackage#getTRequirementDefinition_RequirementType()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
   *        extendedMetaData="kind='attribute' name='requirementType'"
   * @generated
   */
  QName getRequirementType();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TRequirementDefinition#getRequirementType <em>Requirement Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requirement Type</em>' attribute.
   * @see #getRequirementType()
   * @generated
   */
  void setRequirementType(QName value);

  /**
   * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper Bound</em>' attribute.
   * @see #isSetUpperBound()
   * @see #unsetUpperBound()
   * @see #setUpperBound(Object)
   * @see eu.celar.tosca.ToscaPackage#getTRequirementDefinition_UpperBound()
   * @model default="1" unsettable="true" dataType="eu.celar.tosca.UpperBoundType1"
   *        extendedMetaData="kind='attribute' name='upperBound'"
   * @generated
   */
  Object getUpperBound();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TRequirementDefinition#getUpperBound <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Bound</em>' attribute.
   * @see #isSetUpperBound()
   * @see #unsetUpperBound()
   * @see #getUpperBound()
   * @generated
   */
  void setUpperBound(Object value);

  /**
   * Unsets the value of the '{@link eu.celar.tosca.TRequirementDefinition#getUpperBound <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetUpperBound()
   * @see #getUpperBound()
   * @see #setUpperBound(Object)
   * @generated
   */
  void unsetUpperBound();

  /**
   * Returns whether the value of the '{@link eu.celar.tosca.TRequirementDefinition#getUpperBound <em>Upper Bound</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Upper Bound</em>' attribute is set.
   * @see #unsetUpperBound()
   * @see #getUpperBound()
   * @see #setUpperBound(Object)
   * @generated
   */
  boolean isSetUpperBound();

} // TRequirementDefinition
