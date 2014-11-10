/*******************************************************************************
 * Copyright (c) 2013 CELAR Consortium.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 * 	Stalo Sofokleous - initial API and implementation
 * 	Nicholas Loulloudes - implementation extensions
 *******************************************************************************/
/**
 */
package eu.celar.tosca;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TBoundary Definitions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TBoundaryDefinitions#getProperties <em>Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.TBoundaryDefinitions#getPropertyConstraints <em>Property Constraints</em>}</li>
 *   <li>{@link eu.celar.tosca.TBoundaryDefinitions#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link eu.celar.tosca.TBoundaryDefinitions#getCapabilities <em>Capabilities</em>}</li>
 *   <li>{@link eu.celar.tosca.TBoundaryDefinitions#getPolicies <em>Policies</em>}</li>
 *   <li>{@link eu.celar.tosca.TBoundaryDefinitions#getInterfaces <em>Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTBoundaryDefinitions()
 * @model extendedMetaData="name='tBoundaryDefinitions' kind='elementOnly'"
 * @generated
 */
public interface TBoundaryDefinitions extends EObject
{
  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference.
   * @see #setProperties(PropertiesType1)
   * @see eu.celar.tosca.ToscaPackage#getTBoundaryDefinitions_Properties()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Properties' namespace='##targetNamespace'"
   * @generated
   */
  PropertiesType1 getProperties();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TBoundaryDefinitions#getProperties <em>Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Properties</em>' containment reference.
   * @see #getProperties()
   * @generated
   */
  void setProperties(PropertiesType1 value);

  /**
   * Returns the value of the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Constraints</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Constraints</em>' containment reference.
   * @see #setPropertyConstraints(PropertyConstraintsType1)
   * @see eu.celar.tosca.ToscaPackage#getTBoundaryDefinitions_PropertyConstraints()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='PropertyConstraints' namespace='##targetNamespace'"
   * @generated
   */
  PropertyConstraintsType1 getPropertyConstraints();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TBoundaryDefinitions#getPropertyConstraints <em>Property Constraints</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Constraints</em>' containment reference.
   * @see #getPropertyConstraints()
   * @generated
   */
  void setPropertyConstraints(PropertyConstraintsType1 value);

  /**
   * Returns the value of the '<em><b>Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirements</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirements</em>' containment reference.
   * @see #setRequirements(RequirementsType1)
   * @see eu.celar.tosca.ToscaPackage#getTBoundaryDefinitions_Requirements()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Requirements' namespace='##targetNamespace'"
   * @generated
   */
  RequirementsType1 getRequirements();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TBoundaryDefinitions#getRequirements <em>Requirements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requirements</em>' containment reference.
   * @see #getRequirements()
   * @generated
   */
  void setRequirements(RequirementsType1 value);

  /**
   * Returns the value of the '<em><b>Capabilities</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capabilities</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capabilities</em>' containment reference.
   * @see #setCapabilities(CapabilitiesType1)
   * @see eu.celar.tosca.ToscaPackage#getTBoundaryDefinitions_Capabilities()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Capabilities' namespace='##targetNamespace'"
   * @generated
   */
  CapabilitiesType1 getCapabilities();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TBoundaryDefinitions#getCapabilities <em>Capabilities</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Capabilities</em>' containment reference.
   * @see #getCapabilities()
   * @generated
   */
  void setCapabilities(CapabilitiesType1 value);

  /**
   * Returns the value of the '<em><b>Policies</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Policies</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Policies</em>' containment reference.
   * @see #setPolicies(PoliciesType1)
   * @see eu.celar.tosca.ToscaPackage#getTBoundaryDefinitions_Policies()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Policies' namespace='##targetNamespace'"
   * @generated
   */
  PoliciesType1 getPolicies();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TBoundaryDefinitions#getPolicies <em>Policies</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Policies</em>' containment reference.
   * @see #getPolicies()
   * @generated
   */
  void setPolicies(PoliciesType1 value);

  /**
   * Returns the value of the '<em><b>Interfaces</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interfaces</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interfaces</em>' containment reference.
   * @see #setInterfaces(InterfacesType1)
   * @see eu.celar.tosca.ToscaPackage#getTBoundaryDefinitions_Interfaces()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Interfaces' namespace='##targetNamespace'"
   * @generated
   */
  InterfacesType1 getInterfaces();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TBoundaryDefinitions#getInterfaces <em>Interfaces</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interfaces</em>' containment reference.
   * @see #getInterfaces()
   * @generated
   */
  void setInterfaces(InterfacesType1 value);

} // TBoundaryDefinitions
