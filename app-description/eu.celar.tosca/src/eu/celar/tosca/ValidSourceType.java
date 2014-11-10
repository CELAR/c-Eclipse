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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Valid Source Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.ValidSourceType#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getValidSourceType()
 * @model extendedMetaData="name='ValidSource_._type' kind='empty'"
 * @generated
 */
public interface ValidSourceType extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Ref</em>' attribute.
   * @see #setTypeRef(QName)
   * @see eu.celar.tosca.ToscaPackage#getValidSourceType_TypeRef()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
   *        extendedMetaData="kind='attribute' name='typeRef'"
   * @generated
   */
  QName getTypeRef();

  /**
   * Sets the value of the '{@link eu.celar.tosca.ValidSourceType#getTypeRef <em>Type Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Ref</em>' attribute.
   * @see #getTypeRef()
   * @generated
   */
  void setTypeRef(QName value);

} // ValidSourceType
