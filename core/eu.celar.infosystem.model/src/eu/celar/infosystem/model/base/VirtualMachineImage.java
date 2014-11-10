/*******************************************************************************
 * Copyright (c) 2014 CELAR Consortium.
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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
/**
 */
package eu.celar.infosystem.model.base;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Machine Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.infosystem.model.base.VirtualMachineImage#getUID <em>UID</em>}</li>
 *   <li>{@link eu.celar.infosystem.model.base.VirtualMachineImage#getName <em>Name</em>}</li>
 *   <li>{@link eu.celar.infosystem.model.base.VirtualMachineImage#getDescription <em>Description</em>}</li>
 *   <li>{@link eu.celar.infosystem.model.base.VirtualMachineImage#getType <em>Type</em>}</li>
 *   <li>{@link eu.celar.infosystem.model.base.VirtualMachineImage#getURL <em>URL</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.infosystem.model.base.InfoSystemPackage#getVirtualMachineImage()
 * @model extendedMetaData="name='VirtualMachineImage' kind='elementOnly'"
 * @generated
 */
public interface VirtualMachineImage extends EObject
{
  /**
   * Returns the value of the '<em><b>UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>UID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>UID</em>' attribute.
   * @see #setUID(String)
   * @see eu.celar.infosystem.model.base.InfoSystemPackage#getVirtualMachineImage_UID()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='UID' namespace='##targetNamespace'"
   * @generated
   */
  String getUID();

  /**
   * Sets the value of the '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getUID <em>UID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>UID</em>' attribute.
   * @see #getUID()
   * @generated
   */
  void setUID(String value);

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
   * @see eu.celar.infosystem.model.base.InfoSystemPackage#getVirtualMachineImage_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Name' namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see eu.celar.infosystem.model.base.InfoSystemPackage#getVirtualMachineImage_Description()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Description' namespace='##targetNamespace'"
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link eu.celar.infosystem.model.base.VirtualMachineImageType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see eu.celar.infosystem.model.base.VirtualMachineImageType
   * @see #isSetType()
   * @see #unsetType()
   * @see #setType(VirtualMachineImageType)
   * @see eu.celar.infosystem.model.base.InfoSystemPackage#getVirtualMachineImage_Type()
   * @model unsettable="true" required="true"
   *        extendedMetaData="kind='element' name='Type' namespace='##targetNamespace'"
   * @generated
   */
  VirtualMachineImageType getType();

  /**
   * Sets the value of the '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see eu.celar.infosystem.model.base.VirtualMachineImageType
   * @see #isSetType()
   * @see #unsetType()
   * @see #getType()
   * @generated
   */
  void setType(VirtualMachineImageType value);

  /**
   * Unsets the value of the '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetType()
   * @see #getType()
   * @see #setType(VirtualMachineImageType)
   * @generated
   */
  void unsetType();

  /**
   * Returns whether the value of the '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getType <em>Type</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Type</em>' attribute is set.
   * @see #unsetType()
   * @see #getType()
   * @see #setType(VirtualMachineImageType)
   * @generated
   */
  boolean isSetType();

  /**
   * Returns the value of the '<em><b>URL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>URL</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>URL</em>' attribute.
   * @see #setURL(String)
   * @see eu.celar.infosystem.model.base.InfoSystemPackage#getVirtualMachineImage_URL()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='URL' namespace='##targetNamespace'"
   * @generated
   */
  String getURL();

  /**
   * Sets the value of the '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getURL <em>URL</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>URL</em>' attribute.
   * @see #getURL()
   * @generated
   */
  void setURL(String value);

} // VirtualMachineImage
