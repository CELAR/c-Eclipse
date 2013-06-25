/**
 */
package eu.celar.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTopology Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.TTopologyTemplate#getGroup <em>Group</em>}</li>
 *   <li>{@link eu.celar.tosca.TTopologyTemplate#getNodeTemplate <em>Node Template</em>}</li>
 *   <li>{@link eu.celar.tosca.TTopologyTemplate#getRelationshipTemplate <em>Relationship Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.ToscaPackage#getTTopologyTemplate()
 * @model extendedMetaData="name='tTopologyTemplate' kind='elementOnly'"
 * @generated
 */
public interface TTopologyTemplate extends TExtensibleElements
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
   * @see eu.celar.tosca.ToscaPackage#getTTopologyTemplate_Group()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='group' name='group:3'"
   * @generated
   */
  FeatureMap getGroup();

  /**
   * Returns the value of the '<em><b>Node Template</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TNodeTemplate}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node Template</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node Template</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getTTopologyTemplate_NodeTemplate()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='NodeTemplate' namespace='##targetNamespace' group='#group:3'"
   * @generated
   */
  EList<TNodeTemplate> getNodeTemplate();

  /**
   * Returns the value of the '<em><b>Relationship Template</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.TRelationshipTemplate}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relationship Template</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relationship Template</em>' containment reference list.
   * @see eu.celar.tosca.ToscaPackage#getTTopologyTemplate_RelationshipTemplate()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='RelationshipTemplate' namespace='##targetNamespace' group='#group:3'"
   * @generated
   */
  EList<TRelationshipTemplate> getRelationshipTemplate();

} // TTopologyTemplate
