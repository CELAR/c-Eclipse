/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.TActionParameterType;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TAction Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TActionParameterTypeImpl#getParameterName <em>Parameter Name</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TActionParameterTypeImpl#getParameterValue <em>Parameter Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TActionParameterTypeImpl extends EObjectImpl implements TActionParameterType
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
   * The default value of the '{@link #getParameterName() <em>Parameter Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterName()
   * @generated
   * @ordered
   */
  protected static final String PARAMETER_NAME_EDEFAULT = null;

  /**
   * The default value of the '{@link #getParameterValue() <em>Parameter Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterValue()
   * @generated
   * @ordered
   */
  protected static final String PARAMETER_VALUE_EDEFAULT = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TActionParameterTypeImpl()
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.TACTION_PARAMETER_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getParameterName()
  {
    return (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_NAME, PARAMETER_NAME_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameterName(String newParameterName)
  {
    String parameterName = newParameterName;
    Object oldParameterName = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_NAME, parameterName);
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_NAME, oldParameterName == EVIRTUAL_NO_VALUE ? PARAMETER_NAME_EDEFAULT : oldParameterName, parameterName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getParameterValue()
  {
    return (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_VALUE, PARAMETER_VALUE_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameterValue(String newParameterValue)
  {
    String parameterValue = newParameterValue;
    Object oldParameterValue = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_VALUE, parameterValue);
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_VALUE, oldParameterValue == EVIRTUAL_NO_VALUE ? PARAMETER_VALUE_EDEFAULT : oldParameterValue, parameterValue));
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
      case Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_NAME:
        return getParameterName();
      case Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_VALUE:
        return getParameterValue();
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
      case Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_NAME:
        setParameterName((String)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_VALUE:
        setParameterValue((String)newValue);
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
      case Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_NAME:
        setParameterName(PARAMETER_NAME_EDEFAULT);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_VALUE:
        setParameterValue(PARAMETER_VALUE_EDEFAULT);
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
      case Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_NAME:
        String parameterName = (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_NAME, PARAMETER_NAME_EDEFAULT);
        return PARAMETER_NAME_EDEFAULT == null ? parameterName != null : !PARAMETER_NAME_EDEFAULT.equals(parameterName);
      case Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_VALUE:
        String parameterValue = (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_VALUE, PARAMETER_VALUE_EDEFAULT);
        return PARAMETER_VALUE_EDEFAULT == null ? parameterValue != null : !PARAMETER_VALUE_EDEFAULT.equals(parameterValue);
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
    result.append(" (parameterName: ");
    result.append(eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_NAME, PARAMETER_NAME_EDEFAULT));
    result.append(", parameterValue: ");
    result.append(eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TACTION_PARAMETER_TYPE__PARAMETER_VALUE, PARAMETER_VALUE_EDEFAULT));
    result.append(')');
    return result.toString();
  }

} //TActionParameterTypeImpl
