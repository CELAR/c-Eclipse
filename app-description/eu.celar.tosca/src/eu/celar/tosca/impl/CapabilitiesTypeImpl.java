/**
 */
package eu.celar.tosca.impl;

import eu.celar.tosca.CapabilitiesType;
import eu.celar.tosca.TCapability;
import eu.celar.tosca.ToscaPackage;

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
 * An implementation of the model object '<em><b>Capabilities Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.impl.CapabilitiesTypeImpl#getCapability <em>Capability</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CapabilitiesTypeImpl extends EObjectImpl implements CapabilitiesType
{
  /**
   * The cached value of the '{@link #getCapability() <em>Capability</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCapability()
   * @generated
   * @ordered
   */
  protected EList<TCapability> capability;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CapabilitiesTypeImpl()
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
    return ToscaPackage.Literals.CAPABILITIES_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TCapability> getCapability()
  {
    if (capability == null)
    {
      capability = new EObjectContainmentEList<TCapability>(TCapability.class, this, ToscaPackage.CAPABILITIES_TYPE__CAPABILITY);
    }
    return capability;
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
      case ToscaPackage.CAPABILITIES_TYPE__CAPABILITY:
        return ((InternalEList<?>)getCapability()).basicRemove(otherEnd, msgs);
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
      case ToscaPackage.CAPABILITIES_TYPE__CAPABILITY:
        return getCapability();
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
      case ToscaPackage.CAPABILITIES_TYPE__CAPABILITY:
        getCapability().clear();
        getCapability().addAll((Collection<? extends TCapability>)newValue);
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
      case ToscaPackage.CAPABILITIES_TYPE__CAPABILITY:
        getCapability().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ToscaPackage.CAPABILITIES_TYPE__CAPABILITY:
        return capability != null && !capability.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CapabilitiesTypeImpl
