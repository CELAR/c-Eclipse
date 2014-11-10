/*******************************************************************************
 * Copyright (c) 2013, 2014 CELAR Consortium.
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
package eu.celar.tosca.elasticity;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Properties Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.NodePropertiesType#getFlavor <em>Flavor</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getNodePropertiesType()
 * @model extendedMetaData="name='NodePropertiesType' kind='elementOnly'"
 * @generated
 */
public interface NodePropertiesType extends EObject
{
  /**
   * Returns the value of the '<em><b>Flavor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Flavor</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Flavor</em>' attribute.
   * @see #setFlavor(String)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getNodePropertiesType_Flavor()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Flavor' namespace='##targetNamespace'"
   * @generated
   */
  String getFlavor();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.NodePropertiesType#getFlavor <em>Flavor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Flavor</em>' attribute.
   * @see #getFlavor()
   * @generated
   */
  void setFlavor(String value);

} // NodePropertiesType
