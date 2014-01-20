/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.PriorityType;
import eu.celar.tosca.epolicies.TPriorityType;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Priority Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.impl.PriorityTypeImpl#getConstraintId <em>Constraint Id</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.PriorityTypeImpl#getPriorityType <em>Priority Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PriorityTypeImpl extends EObjectImpl implements PriorityType
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
   * The default value of the '{@link #getConstraintId() <em>Constraint Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintId()
   * @generated
   * @ordered
   */
  protected static final String CONSTRAINT_ID_EDEFAULT = null;

  /**
   * The default value of the '{@link #getPriorityType() <em>Priority Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriorityType()
   * @generated
   * @ordered
   */
  protected static final TPriorityType PRIORITY_TYPE_EDEFAULT = TPriorityType.LESS_THAN;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PriorityTypeImpl()
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.PRIORITY_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getConstraintId()
  {
    return (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__CONSTRAINT_ID, CONSTRAINT_ID_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstraintId(String newConstraintId)
  {
    String constraintId = newConstraintId;
    Object oldConstraintId = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__CONSTRAINT_ID, constraintId);
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__CONSTRAINT_ID, oldConstraintId == EVIRTUAL_NO_VALUE ? CONSTRAINT_ID_EDEFAULT : oldConstraintId, constraintId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TPriorityType getPriorityType()
  {
    return (TPriorityType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE, PRIORITY_TYPE_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriorityType(TPriorityType newPriorityType)
  {
    TPriorityType priorityType = newPriorityType == null ? PRIORITY_TYPE_EDEFAULT : newPriorityType;
    Object oldPriorityType = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE, priorityType);
    boolean isSetChange = oldPriorityType == EVIRTUAL_NO_VALUE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE, isSetChange ? PRIORITY_TYPE_EDEFAULT : oldPriorityType, priorityType, isSetChange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPriorityType()
  {
    Object oldPriorityType = eVirtualUnset(Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE);
    boolean isSetChange = oldPriorityType != EVIRTUAL_NO_VALUE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE, isSetChange ? oldPriorityType : PRIORITY_TYPE_EDEFAULT, PRIORITY_TYPE_EDEFAULT, isSetChange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPriorityType()
  {
    return eVirtualIsSet(Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE);
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
      case Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__CONSTRAINT_ID:
        return getConstraintId();
      case Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE:
        return getPriorityType();
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
      case Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__CONSTRAINT_ID:
        setConstraintId((String)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE:
        setPriorityType((TPriorityType)newValue);
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
      case Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__CONSTRAINT_ID:
        setConstraintId(CONSTRAINT_ID_EDEFAULT);
        return;
      case Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE:
        unsetPriorityType();
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
      case Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__CONSTRAINT_ID:
        String constraintId = (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__CONSTRAINT_ID, CONSTRAINT_ID_EDEFAULT);
        return CONSTRAINT_ID_EDEFAULT == null ? constraintId != null : !CONSTRAINT_ID_EDEFAULT.equals(constraintId);
      case Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE:
        return isSetPriorityType();
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
    result.append(" (constraintId: ");
    result.append(eVirtualGet(Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__CONSTRAINT_ID, CONSTRAINT_ID_EDEFAULT));
    result.append(", priorityType: ");
    if (eVirtualIsSet(Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE)) result.append(eVirtualGet(Tosca_EPolicy_ExtensionsPackage.PRIORITY_TYPE__PRIORITY_TYPE)); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //PriorityTypeImpl
