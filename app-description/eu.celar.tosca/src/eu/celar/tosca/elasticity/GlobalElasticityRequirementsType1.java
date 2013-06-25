/**
 */
package eu.celar.tosca.elasticity;

import eu.celar.tosca.TBoundaryDefinitions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Elasticity Requirements Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.GlobalElasticityRequirementsType1#getGlobalElasticityRequirements <em>Global Elasticity Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getGlobalElasticityRequirementsType1()
 * @model extendedMetaData="name='GlobalElasticityRequirementsType1' kind='elementOnly'"
 * @generated
 */
public interface GlobalElasticityRequirementsType1 extends EObject
{
  /**
   * Returns the value of the '<em><b>Global Elasticity Requirements</b></em>' containment reference list.
   * The list contents are of type {@link eu.celar.tosca.elasticity.TGlobalElasticityRequirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Global Elasticity Requirements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Global Elasticity Requirements</em>' containment reference list.
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getGlobalElasticityRequirementsType1_GlobalElasticityRequirements()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='globalElasticityRequirements' namespace='##targetNamespace'"
   * @generated
   */
  EList<TGlobalElasticityRequirement> getGlobalElasticityRequirements();

} // GlobalElasticityRequirementsType1
