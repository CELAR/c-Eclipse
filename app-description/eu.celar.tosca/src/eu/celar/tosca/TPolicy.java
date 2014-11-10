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

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPolicy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TPolicy#getName <em>Name</em>}</li>
 *   <li>{@link eu.celar.tosca.TPolicy#getPolicyRef <em>Policy Ref</em>}</li>
 *   <li>{@link eu.celar.tosca.TPolicy#getPolicyType <em>Policy Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTPolicy()
 * @model extendedMetaData="name='tPolicy' kind='elementOnly'"
 * @generated
 */
public interface TPolicy extends TExtensibleElements
{
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
   * @see eu.celar.tosca.ToscaPackage#getTPolicy_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='name'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TPolicy#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Policy Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Policy Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Policy Ref</em>' attribute.
   * @see #setPolicyRef(QName)
   * @see eu.celar.tosca.ToscaPackage#getTPolicy_PolicyRef()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
   *        extendedMetaData="kind='attribute' name='policyRef'"
   * @generated
   */
  QName getPolicyRef();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TPolicy#getPolicyRef <em>Policy Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Policy Ref</em>' attribute.
   * @see #getPolicyRef()
   * @generated
   */
  void setPolicyRef(QName value);

  /**
   * Returns the value of the '<em><b>Policy Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Policy Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Policy Type</em>' attribute.
   * @see #setPolicyType(QName)
   * @see eu.celar.tosca.ToscaPackage#getTPolicy_PolicyType()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
   *        extendedMetaData="kind='attribute' name='policyType'"
   * @generated
   */
  QName getPolicyType();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TPolicy#getPolicyType <em>Policy Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Policy Type</em>' attribute.
   * @see #getPolicyType()
   * @generated
   */
  void setPolicyType(QName value);

} // TPolicy
