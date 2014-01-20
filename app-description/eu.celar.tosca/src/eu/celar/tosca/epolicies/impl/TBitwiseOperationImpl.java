/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.BitwiseLeftHandSideType;
import eu.celar.tosca.epolicies.BitwiseRightHandSideType;
import eu.celar.tosca.epolicies.TBitwiseOperation;
import eu.celar.tosca.epolicies.TBitwiseOperationType;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TBitwise Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TBitwiseOperationImpl#getBitwiseLeftHandSide <em>Bitwise Left Hand Side</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TBitwiseOperationImpl#getBitwiseRightHandSide <em>Bitwise Right Hand Side</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TBitwiseOperationImpl#getBitwiseOperator <em>Bitwise Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TBitwiseOperationImpl extends EObjectImpl implements TBitwiseOperation
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
   * The default value of the '{@link #getBitwiseOperator() <em>Bitwise Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBitwiseOperator()
   * @generated
   * @ordered
   */
  protected static final TBitwiseOperationType BITWISE_OPERATOR_EDEFAULT = TBitwiseOperationType.AND;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TBitwiseOperationImpl()
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.TBITWISE_OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseLeftHandSideType getBitwiseLeftHandSide()
  {
    return (BitwiseLeftHandSideType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBitwiseLeftHandSide(BitwiseLeftHandSideType newBitwiseLeftHandSide, NotificationChain msgs)
  {
    Object oldBitwiseLeftHandSide = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE, newBitwiseLeftHandSide);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE, oldBitwiseLeftHandSide == EVIRTUAL_NO_VALUE ? null : oldBitwiseLeftHandSide, newBitwiseLeftHandSide);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBitwiseLeftHandSide(BitwiseLeftHandSideType newBitwiseLeftHandSide)
  {
    BitwiseLeftHandSideType bitwiseLeftHandSide = (BitwiseLeftHandSideType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE);
    if (newBitwiseLeftHandSide != bitwiseLeftHandSide)
    {
      NotificationChain msgs = null;
      if (bitwiseLeftHandSide != null)
        msgs = ((InternalEObject)bitwiseLeftHandSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE, null, msgs);
      if (newBitwiseLeftHandSide != null)
        msgs = ((InternalEObject)newBitwiseLeftHandSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE, null, msgs);
      msgs = basicSetBitwiseLeftHandSide(newBitwiseLeftHandSide, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE, newBitwiseLeftHandSide, newBitwiseLeftHandSide));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseRightHandSideType getBitwiseRightHandSide()
  {
    return (BitwiseRightHandSideType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBitwiseRightHandSide(BitwiseRightHandSideType newBitwiseRightHandSide, NotificationChain msgs)
  {
    Object oldBitwiseRightHandSide = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE, newBitwiseRightHandSide);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE, oldBitwiseRightHandSide == EVIRTUAL_NO_VALUE ? null : oldBitwiseRightHandSide, newBitwiseRightHandSide);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBitwiseRightHandSide(BitwiseRightHandSideType newBitwiseRightHandSide)
  {
    BitwiseRightHandSideType bitwiseRightHandSide = (BitwiseRightHandSideType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE);
    if (newBitwiseRightHandSide != bitwiseRightHandSide)
    {
      NotificationChain msgs = null;
      if (bitwiseRightHandSide != null)
        msgs = ((InternalEObject)bitwiseRightHandSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE, null, msgs);
      if (newBitwiseRightHandSide != null)
        msgs = ((InternalEObject)newBitwiseRightHandSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE, null, msgs);
      msgs = basicSetBitwiseRightHandSide(newBitwiseRightHandSide, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE, newBitwiseRightHandSide, newBitwiseRightHandSide));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TBitwiseOperationType getBitwiseOperator()
  {
    return (TBitwiseOperationType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR, BITWISE_OPERATOR_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBitwiseOperator(TBitwiseOperationType newBitwiseOperator)
  {
    TBitwiseOperationType bitwiseOperator = newBitwiseOperator == null ? BITWISE_OPERATOR_EDEFAULT : newBitwiseOperator;
    Object oldBitwiseOperator = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR, bitwiseOperator);
    boolean isSetChange = oldBitwiseOperator == EVIRTUAL_NO_VALUE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR, isSetChange ? BITWISE_OPERATOR_EDEFAULT : oldBitwiseOperator, bitwiseOperator, isSetChange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBitwiseOperator()
  {
    Object oldBitwiseOperator = eVirtualUnset(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR);
    boolean isSetChange = oldBitwiseOperator != EVIRTUAL_NO_VALUE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR, isSetChange ? oldBitwiseOperator : BITWISE_OPERATOR_EDEFAULT, BITWISE_OPERATOR_EDEFAULT, isSetChange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBitwiseOperator()
  {
    return eVirtualIsSet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR);
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
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE:
        return basicSetBitwiseLeftHandSide(null, msgs);
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE:
        return basicSetBitwiseRightHandSide(null, msgs);
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
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE:
        return getBitwiseLeftHandSide();
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE:
        return getBitwiseRightHandSide();
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR:
        return getBitwiseOperator();
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
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE:
        setBitwiseLeftHandSide((BitwiseLeftHandSideType)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE:
        setBitwiseRightHandSide((BitwiseRightHandSideType)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR:
        setBitwiseOperator((TBitwiseOperationType)newValue);
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
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE:
        setBitwiseLeftHandSide((BitwiseLeftHandSideType)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE:
        setBitwiseRightHandSide((BitwiseRightHandSideType)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR:
        unsetBitwiseOperator();
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
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE) != null;
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE) != null;
      case Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR:
        return isSetBitwiseOperator();
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

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (bitwiseOperator: ");
    if (eVirtualIsSet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR)) result.append(eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TBITWISE_OPERATION__BITWISE_OPERATOR)); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //TBitwiseOperationImpl
