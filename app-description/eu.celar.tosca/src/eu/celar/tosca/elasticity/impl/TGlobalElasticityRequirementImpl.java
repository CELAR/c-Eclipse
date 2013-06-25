/**
 */
package eu.celar.tosca.elasticity.impl;

import eu.celar.tosca.elasticity.TGlobalElasticityRequirement;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

import eu.celar.tosca.impl.TExtensibleElementsImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TGlobal Elasticity Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TGlobalElasticityRequirementImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TGlobalElasticityRequirementImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TGlobalElasticityRequirementImpl extends TExtensibleElementsImpl implements TGlobalElasticityRequirement
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
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TGlobalElasticityRequirementImpl()
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
    return Tosca_Elasticity_ExtensionsPackage.Literals.TGLOBAL_ELASTICITY_REQUIREMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__NAME, NAME_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String name = newName;
    Object oldName = eVirtualSet(Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__NAME, name);
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__NAME, oldName == EVIRTUAL_NO_VALUE ? NAME_EDEFAULT : oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__VALUE, VALUE_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String value = newValue;
    Object oldValue = eVirtualSet(Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__VALUE, value);
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__VALUE, oldValue == EVIRTUAL_NO_VALUE ? VALUE_EDEFAULT : oldValue, value));
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
      case Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__NAME:
        return getName();
      case Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__VALUE:
        return getValue();
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
      case Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__NAME:
        setName((String)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__VALUE:
        setValue((String)newValue);
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
      case Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__VALUE:
        setValue(VALUE_EDEFAULT);
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
      case Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__NAME:
        String name = (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__NAME, NAME_EDEFAULT);
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__VALUE:
        String value = (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__VALUE, VALUE_EDEFAULT);
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
    result.append(" (name: ");
    result.append(eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__NAME, NAME_EDEFAULT));
    result.append(", value: ");
    result.append(eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT__VALUE, VALUE_EDEFAULT));
    result.append(')');
    return result.toString();
  }

} //TGlobalElasticityRequirementImpl
