/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.ActionType;
import eu.celar.tosca.epolicies.TActionParameterType;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.impl.ActionTypeImpl#getActionParameter <em>Action Parameter</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.ActionTypeImpl#getActionName <em>Action Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionTypeImpl extends EObjectImpl implements ActionType
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
   * The default value of the '{@link #getActionName() <em>Action Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActionName()
   * @generated
   * @ordered
   */
  protected static final String ACTION_NAME_EDEFAULT = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActionTypeImpl()
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.ACTION_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<TActionParameterType> getActionParameter()
  {
    EList<TActionParameterType> actionParameter = (EList<TActionParameterType>)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_PARAMETER);
    if (actionParameter == null)
    {
      eVirtualSet(Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_PARAMETER, actionParameter = new EObjectContainmentEList<TActionParameterType>(TActionParameterType.class, this, Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_PARAMETER));
    }
    return actionParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getActionName()
  {
    return (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_NAME, ACTION_NAME_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActionName(String newActionName)
  {
    String actionName = newActionName;
    Object oldActionName = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_NAME, actionName);
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_NAME, oldActionName == EVIRTUAL_NO_VALUE ? ACTION_NAME_EDEFAULT : oldActionName, actionName));
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
      case Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_PARAMETER:
        return ((InternalEList<?>)getActionParameter()).basicRemove(otherEnd, msgs);
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
      case Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_PARAMETER:
        return getActionParameter();
      case Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_NAME:
        return getActionName();
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
      case Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_PARAMETER:
        getActionParameter().clear();
        getActionParameter().addAll((Collection<? extends TActionParameterType>)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_NAME:
        setActionName((String)newValue);
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
      case Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_PARAMETER:
        getActionParameter().clear();
        return;
      case Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_NAME:
        setActionName(ACTION_NAME_EDEFAULT);
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
      case Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_PARAMETER:
        EList<TActionParameterType> actionParameter = (EList<TActionParameterType>)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_PARAMETER);
        return actionParameter != null && !actionParameter.isEmpty();
      case Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_NAME:
        String actionName = (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_NAME, ACTION_NAME_EDEFAULT);
        return ACTION_NAME_EDEFAULT == null ? actionName != null : !ACTION_NAME_EDEFAULT.equals(actionName);
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
    result.append(" (actionName: ");
    result.append(eVirtualGet(Tosca_EPolicy_ExtensionsPackage.ACTION_TYPE__ACTION_NAME, ACTION_NAME_EDEFAULT));
    result.append(')');
    return result.toString();
  }

} //ActionTypeImpl
