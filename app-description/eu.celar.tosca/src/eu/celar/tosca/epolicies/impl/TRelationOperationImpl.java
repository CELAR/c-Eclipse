/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.RelationLeftHandSideType;
import eu.celar.tosca.epolicies.RelationRightHandSideType;
import eu.celar.tosca.epolicies.TRelationOperation;
import eu.celar.tosca.epolicies.TRelationOperationType;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TRelation Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TRelationOperationImpl#getRelationLeftHandSide <em>Relation Left Hand Side</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TRelationOperationImpl#getRelationRightHandSide <em>Relation Right Hand Side</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TRelationOperationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TRelationOperationImpl extends EObjectImpl implements TRelationOperation
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
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final TRelationOperationType TYPE_EDEFAULT = TRelationOperationType.LESS_THAN;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TRelationOperationImpl()
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.TRELATION_OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationLeftHandSideType getRelationLeftHandSide()
  {
    return (RelationLeftHandSideType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRelationLeftHandSide(RelationLeftHandSideType newRelationLeftHandSide, NotificationChain msgs)
  {
    Object oldRelationLeftHandSide = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE, newRelationLeftHandSide);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE, oldRelationLeftHandSide == EVIRTUAL_NO_VALUE ? null : oldRelationLeftHandSide, newRelationLeftHandSide);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRelationLeftHandSide(RelationLeftHandSideType newRelationLeftHandSide)
  {
    RelationLeftHandSideType relationLeftHandSide = (RelationLeftHandSideType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE);
    if (newRelationLeftHandSide != relationLeftHandSide)
    {
      NotificationChain msgs = null;
      if (relationLeftHandSide != null)
        msgs = ((InternalEObject)relationLeftHandSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE, null, msgs);
      if (newRelationLeftHandSide != null)
        msgs = ((InternalEObject)newRelationLeftHandSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE, null, msgs);
      msgs = basicSetRelationLeftHandSide(newRelationLeftHandSide, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE, newRelationLeftHandSide, newRelationLeftHandSide));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationRightHandSideType getRelationRightHandSide()
  {
    return (RelationRightHandSideType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRelationRightHandSide(RelationRightHandSideType newRelationRightHandSide, NotificationChain msgs)
  {
    Object oldRelationRightHandSide = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE, newRelationRightHandSide);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE, oldRelationRightHandSide == EVIRTUAL_NO_VALUE ? null : oldRelationRightHandSide, newRelationRightHandSide);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRelationRightHandSide(RelationRightHandSideType newRelationRightHandSide)
  {
    RelationRightHandSideType relationRightHandSide = (RelationRightHandSideType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE);
    if (newRelationRightHandSide != relationRightHandSide)
    {
      NotificationChain msgs = null;
      if (relationRightHandSide != null)
        msgs = ((InternalEObject)relationRightHandSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE, null, msgs);
      if (newRelationRightHandSide != null)
        msgs = ((InternalEObject)newRelationRightHandSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE, null, msgs);
      msgs = basicSetRelationRightHandSide(newRelationRightHandSide, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE, newRelationRightHandSide, newRelationRightHandSide));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRelationOperationType getType()
  {
    return (TRelationOperationType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE, TYPE_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TRelationOperationType newType)
  {
    TRelationOperationType type = newType == null ? TYPE_EDEFAULT : newType;
    Object oldType = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE, type);
    boolean isSetChange = oldType == EVIRTUAL_NO_VALUE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE, isSetChange ? TYPE_EDEFAULT : oldType, type, isSetChange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetType()
  {
    Object oldType = eVirtualUnset(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE);
    boolean isSetChange = oldType != EVIRTUAL_NO_VALUE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE, isSetChange ? oldType : TYPE_EDEFAULT, TYPE_EDEFAULT, isSetChange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetType()
  {
    return eVirtualIsSet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE);
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
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE:
        return basicSetRelationLeftHandSide(null, msgs);
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE:
        return basicSetRelationRightHandSide(null, msgs);
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
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE:
        return getRelationLeftHandSide();
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE:
        return getRelationRightHandSide();
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE:
        return getType();
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
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE:
        setRelationLeftHandSide((RelationLeftHandSideType)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE:
        setRelationRightHandSide((RelationRightHandSideType)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE:
        setType((TRelationOperationType)newValue);
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
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE:
        setRelationLeftHandSide((RelationLeftHandSideType)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE:
        setRelationRightHandSide((RelationRightHandSideType)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE:
        unsetType();
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
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE) != null;
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE) != null;
      case Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE:
        return isSetType();
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
    result.append(" (type: ");
    if (eVirtualIsSet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE)) result.append(eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TRELATION_OPERATION__TYPE)); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //TRelationOperationImpl
