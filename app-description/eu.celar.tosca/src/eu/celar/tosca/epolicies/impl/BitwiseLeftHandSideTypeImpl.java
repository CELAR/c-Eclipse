/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.BitwiseLeftHandSideType;
import eu.celar.tosca.epolicies.TBitwiseOperation;
import eu.celar.tosca.epolicies.TRelationOperation;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bitwise Left Hand Side Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.impl.BitwiseLeftHandSideTypeImpl#getLeftSimpleCondition <em>Left Simple Condition</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.BitwiseLeftHandSideTypeImpl#getLeftCompexCondition <em>Left Compex Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BitwiseLeftHandSideTypeImpl extends EObjectImpl implements BitwiseLeftHandSideType
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
  protected BitwiseLeftHandSideTypeImpl()
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.BITWISE_LEFT_HAND_SIDE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRelationOperation getLeftSimpleCondition()
  {
    return (TRelationOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeftSimpleCondition(TRelationOperation newLeftSimpleCondition, NotificationChain msgs)
  {
    Object oldLeftSimpleCondition = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION, newLeftSimpleCondition);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION, oldLeftSimpleCondition == EVIRTUAL_NO_VALUE ? null : oldLeftSimpleCondition, newLeftSimpleCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeftSimpleCondition(TRelationOperation newLeftSimpleCondition)
  {
    TRelationOperation leftSimpleCondition = (TRelationOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION);
    if (newLeftSimpleCondition != leftSimpleCondition)
    {
      NotificationChain msgs = null;
      if (leftSimpleCondition != null)
        msgs = ((InternalEObject)leftSimpleCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION, null, msgs);
      if (newLeftSimpleCondition != null)
        msgs = ((InternalEObject)newLeftSimpleCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION, null, msgs);
      msgs = basicSetLeftSimpleCondition(newLeftSimpleCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION, newLeftSimpleCondition, newLeftSimpleCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TBitwiseOperation getLeftCompexCondition()
  {
    return (TBitwiseOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeftCompexCondition(TBitwiseOperation newLeftCompexCondition, NotificationChain msgs)
  {
    Object oldLeftCompexCondition = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION, newLeftCompexCondition);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION, oldLeftCompexCondition == EVIRTUAL_NO_VALUE ? null : oldLeftCompexCondition, newLeftCompexCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeftCompexCondition(TBitwiseOperation newLeftCompexCondition)
  {
    TBitwiseOperation leftCompexCondition = (TBitwiseOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION);
    if (newLeftCompexCondition != leftCompexCondition)
    {
      NotificationChain msgs = null;
      if (leftCompexCondition != null)
        msgs = ((InternalEObject)leftCompexCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION, null, msgs);
      if (newLeftCompexCondition != null)
        msgs = ((InternalEObject)newLeftCompexCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION, null, msgs);
      msgs = basicSetLeftCompexCondition(newLeftCompexCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION, newLeftCompexCondition, newLeftCompexCondition));
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
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION:
        return basicSetLeftSimpleCondition(null, msgs);
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION:
        return basicSetLeftCompexCondition(null, msgs);
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
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION:
        return getLeftSimpleCondition();
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION:
        return getLeftCompexCondition();
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
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION:
        setLeftSimpleCondition((TRelationOperation)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION:
        setLeftCompexCondition((TBitwiseOperation)newValue);
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
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION:
        setLeftSimpleCondition((TRelationOperation)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION:
        setLeftCompexCondition((TBitwiseOperation)null);
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
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION) != null;
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION) != null;
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

} //BitwiseLeftHandSideTypeImpl
