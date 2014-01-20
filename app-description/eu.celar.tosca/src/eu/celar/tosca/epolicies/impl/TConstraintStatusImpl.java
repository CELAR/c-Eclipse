/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.TConstraintStatus;
import eu.celar.tosca.epolicies.TFulfilledConstraint;
import eu.celar.tosca.epolicies.TViolatedConstraint;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TConstraint Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TConstraintStatusImpl#getViolated <em>Violated</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TConstraintStatusImpl#getFulfilled <em>Fulfilled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TConstraintStatusImpl extends EObjectImpl implements TConstraintStatus
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
  protected TConstraintStatusImpl()
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.TCONSTRAINT_STATUS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TViolatedConstraint getViolated()
  {
    return (TViolatedConstraint)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetViolated(TViolatedConstraint newViolated, NotificationChain msgs)
  {
    Object oldViolated = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED, newViolated);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED, oldViolated == EVIRTUAL_NO_VALUE ? null : oldViolated, newViolated);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setViolated(TViolatedConstraint newViolated)
  {
    TViolatedConstraint violated = (TViolatedConstraint)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED);
    if (newViolated != violated)
    {
      NotificationChain msgs = null;
      if (violated != null)
        msgs = ((InternalEObject)violated).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED, null, msgs);
      if (newViolated != null)
        msgs = ((InternalEObject)newViolated).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED, null, msgs);
      msgs = basicSetViolated(newViolated, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED, newViolated, newViolated));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TFulfilledConstraint getFulfilled()
  {
    return (TFulfilledConstraint)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFulfilled(TFulfilledConstraint newFulfilled, NotificationChain msgs)
  {
    Object oldFulfilled = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED, newFulfilled);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED, oldFulfilled == EVIRTUAL_NO_VALUE ? null : oldFulfilled, newFulfilled);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFulfilled(TFulfilledConstraint newFulfilled)
  {
    TFulfilledConstraint fulfilled = (TFulfilledConstraint)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED);
    if (newFulfilled != fulfilled)
    {
      NotificationChain msgs = null;
      if (fulfilled != null)
        msgs = ((InternalEObject)fulfilled).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED, null, msgs);
      if (newFulfilled != null)
        msgs = ((InternalEObject)newFulfilled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED, null, msgs);
      msgs = basicSetFulfilled(newFulfilled, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED, newFulfilled, newFulfilled));
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
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED:
        return basicSetViolated(null, msgs);
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED:
        return basicSetFulfilled(null, msgs);
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
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED:
        return getViolated();
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED:
        return getFulfilled();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED:
        setViolated((TViolatedConstraint)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED:
        setFulfilled((TFulfilledConstraint)newValue);
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
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED:
        setViolated((TViolatedConstraint)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED:
        setFulfilled((TFulfilledConstraint)null);
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
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__VIOLATED) != null;
      case Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TCONSTRAINT_STATUS__FULFILLED) != null;
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

} //TConstraintStatusImpl
