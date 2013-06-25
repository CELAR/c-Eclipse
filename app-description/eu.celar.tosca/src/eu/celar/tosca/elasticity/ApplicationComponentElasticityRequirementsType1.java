/**
 */
package eu.celar.tosca.elasticity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Component Elasticity Requirements Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1#getApplicationComponentElasticityRequirements <em>Application Component Elasticity Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getApplicationComponentElasticityRequirementsType1()
 * @model extendedMetaData="name='ApplicationComponentElasticityRequirementsType1' kind='elementOnly'"
 * @generated
 */
public interface ApplicationComponentElasticityRequirementsType1 extends EObject
{
  /**
   * Returns the value of the '<em><b>Application Component Elasticity Requirements</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application Component Elasticity Requirements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Application Component Elasticity Requirements</em>' containment reference list.
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getApplicationComponentElasticityRequirementsType1_ApplicationComponentElasticityRequirements()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='applicationComponentElasticityRequirements' namespace='##targetNamespace'"
   * @generated
   */
  EList<TApplicationComponentElasticityRequirement> getApplicationComponentElasticityRequirements();

} // ApplicationComponentElasticityRequirementsType1
