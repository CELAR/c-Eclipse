/**
 */
package eu.celar.tosca.elasticity;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Artifact Properties Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.ImageArtifactPropertiesType#getDescription <em>Description</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.ImageArtifactPropertiesType#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getImageArtifactPropertiesType()
 * @model extendedMetaData="name='ImageArtifactPropertiesType' kind='elementOnly'"
 * @generated
 */
public interface ImageArtifactPropertiesType extends EObject
{
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
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getImageArtifactPropertiesType_Description()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Description' namespace='##targetNamespace'"
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.ImageArtifactPropertiesType#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getImageArtifactPropertiesType_Id()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Id' namespace='##targetNamespace'"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link eu.celar.tosca.elasticity.ImageArtifactPropertiesType#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

} // ImageArtifactPropertiesType
