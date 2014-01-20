/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.BitwiseRightHandSideType;
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
 * An implementation of the model object '<em><b>Bitwise Right Hand Side Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.impl.BitwiseRightHandSideTypeImpl#getRightSimpleCondition <em>Right Simple Condition</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.BitwiseRightHandSideTypeImpl#getRightCompexCondition <em>Right Compex Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BitwiseRightHandSideTypeImpl extends EObjectImpl implements BitwiseRightHandSideType
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
  protected BitwiseRightHandSideTypeImpl()
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.BITWISE_RIGHT_HAND_SIDE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRelationOperation getRightSimpleCondition()
  {
    return (TRelationOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRightSimpleCondition(TRelationOperation newRightSimpleCondition, NotificationChain msgs)
  {
    Object oldRightSimpleCondition = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION, newRightSimpleCondition);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION, oldRightSimpleCondition == EVIRTUAL_NO_VALUE ? null : oldRightSimpleCondition, newRightSimpleCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightSimpleCondition(TRelationOperation newRightSimpleCondition)
  {
    TRelationOperation rightSimpleCondition = (TRelationOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION);
    if (newRightSimpleCondition != rightSimpleCondition)
    {
      NotificationChain msgs = null;
      if (rightSimpleCondition != null)
        msgs = ((InternalEObject)rightSimpleCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION, null, msgs);
      if (newRightSimpleCondition != null)
        msgs = ((InternalEObject)newRightSimpleCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION, null, msgs);
      msgs = basicSetRightSimpleCondition(newRightSimpleCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION, newRightSimpleCondition, newRightSimpleCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TBitwiseOperation getRightCompexCondition()
  {
    return (TBitwiseOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRightCompexCondition(TBitwiseOperation newRightCompexCondition, NotificationChain msgs)
  {
    Object oldRightCompexCondition = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION, newRightCompexCondition);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION, oldRightCompexCondition == EVIRTUAL_NO_VALUE ? null : oldRightCompexCondition, newRightCompexCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightCompexCondition(TBitwiseOperation newRightCompexCondition)
  {
    TBitwiseOperation rightCompexCondition = (TBitwiseOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION);
    if (newRightCompexCondition != rightCompexCondition)
    {
      NotificationChain msgs = null;
      if (rightCompexCondition != null)
        msgs = ((InternalEObject)rightCompexCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION, null, msgs);
      if (newRightCompexCondition != null)
        msgs = ((InternalEObject)newRightCompexCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION, null, msgs);
      msgs = basicSetRightCompexCondition(newRightCompexCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION, newRightCompexCondition, newRightCompexCondition));
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
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION:
        return basicSetRightSimpleCondition(null, msgs);
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION:
        return basicSetRightCompexCondition(null, msgs);
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
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION:
        return getRightSimpleCondition();
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION:
        return getRightCompexCondition();
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
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION:
        setRightSimpleCondition((TRelationOperation)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION:
        setRightCompexCondition((TBitwiseOperation)newValue);
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
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION:
        setRightSimpleCondition((TRelationOperation)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION:
        setRightCompexCondition((TBitwiseOperation)null);
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
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION) != null;
      case Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION) != null;
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

} //BitwiseRightHandSideTypeImpl
