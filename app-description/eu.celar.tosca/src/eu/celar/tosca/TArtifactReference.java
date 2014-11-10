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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TArtifact Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TArtifactReference#getGroup <em>Group</em>}</li>
 *   <li>{@link eu.celar.tosca.TArtifactReference#getInclude <em>Include</em>}</li>
 *   <li>{@link eu.celar.tosca.TArtifactReference#getExclude <em>Exclude</em>}</li>
 *   <li>{@link eu.celar.tosca.TArtifactReference#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTArtifactReference()
 * @model extendedMetaData="name='tArtifactReference' kind='elementOnly'"
 * @generated
 */
public interface TArtifactReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Group</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' attribute list.
   * @see eu.celar.tosca.ToscaPackage#getTArtifactReference_Group()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='group' name='group:0'"
   * @generated
   */
  FeatureMap getGroup();

  /**
   * Returns the value of the '<em><b>Include</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.IncludeType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Include</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Include</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getTArtifactReference_Include()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='Include' namespace='##targetNamespace' group='#group:0'"
   * @generated
   */
  EList<IncludeType> getInclude();

  /**
   * Returns the value of the '<em><b>Exclude</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.ExcludeType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exclude</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exclude</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getTArtifactReference_Exclude()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='Exclude' namespace='##targetNamespace' group='#group:0'"
   * @generated
   */
  EList<ExcludeType> getExclude();

  /**
   * Returns the value of the '<em><b>Reference</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' attribute.
   * @see #setReference(String)
   * @see eu.celar.tosca.ToscaPackage#getTArtifactReference_Reference()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" required="true"
   *        extendedMetaData="kind='attribute' name='reference'"
   * @generated
   */
  String getReference();

  /**
   * Sets the value of the '{@link eu.celar.tosca.TArtifactReference#getReference <em>Reference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' attribute.
   * @see #getReference()
   * @generated
   */
  void setReference(String value);

} // TArtifactReference
