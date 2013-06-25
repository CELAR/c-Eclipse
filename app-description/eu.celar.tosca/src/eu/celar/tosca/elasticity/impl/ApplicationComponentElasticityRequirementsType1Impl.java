/**
 */
package eu.celar.tosca.elasticity.impl;

import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1;
import eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Component Elasticity Requirements Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.impl.ApplicationComponentElasticityRequirementsType1Impl#getApplicationComponentElasticityRequirements <em>Application Component Elasticity Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationComponentElasticityRequirementsType1Impl extends EObjectImpl implements ApplicationComponentElasticityRequirementsType1
{
  /**
   * An array of objects representing the values of non-primitive features.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Object[] eVirtualValues;

  /**
   * A bit field representing the indices of non-primitive feature values.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected int eVirtualIndexBits0;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ApplicationComponentElasticityRequirementsType1Impl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return Tosca_Elasticity_ExtensionsPackage.Literals.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<TApplicationComponentElasticityRequirement> getApplicationComponentElasticityRequirements()
  {
    EList<TApplicationComponentElasticityRequirement> applicationComponentElasticityRequirements = (EList<TApplicationComponentElasticityRequirement>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS);
    if (applicationComponentElasticityRequirements == null)
    {
      eVirtualSet(Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS, applicationComponentElasticityRequirements = new EObjectContainmentEList<TApplicationComponentElasticityRequirement>(TApplicationComponentElasticityRequirement.class, this, Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS));
    }
    return applicationComponentElasticityRequirements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        return ((InternalEList<?>)getApplicationComponentElasticityRequirements()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        return getApplicationComponentElasticityRequirements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        getApplicationComponentElasticityRequirements().clear();
        getApplicationComponentElasticityRequirements().addAll((Collection<? extends TApplicationComponentElasticityRequirement>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        getApplicationComponentElasticityRequirements().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        EList<TApplicationComponentElasticityRequirement> applicationComponentElasticityRequirements = (EList<TApplicationComponentElasticityRequirement>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS);
        return applicationComponentElasticityRequirements != null && !applicationComponentElasticityRequirements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Object[] eVirtualValues()
  {
    return eVirtualValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void eSetVirtualValues(Object[] newValues)
  {
    eVirtualValues = newValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected int eVirtualIndexBits(int offset)
  {
    switch (offset)
    {
      case 0 :
        return eVirtualIndexBits0;
      default :
        throw new IndexOutOfBoundsException();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void eSetVirtualIndexBits(int offset, int newIndexBits)
  {
    switch (offset)
    {
      case 0 :
        eVirtualIndexBits0 = newIndexBits;
        break;
      default :
        throw new IndexOutOfBoundsException();
    }
  }

} //ApplicationComponentElasticityRequirementsType1Impl
