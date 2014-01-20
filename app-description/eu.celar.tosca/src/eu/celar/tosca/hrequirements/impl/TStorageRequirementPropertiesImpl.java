/**
 */
package eu.celar.tosca.hrequirements.impl;

import eu.celar.tosca.hrequirements.TStorageRequirementProperties;
import eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TStorage Requirement Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.hrequirements.impl.TStorageRequirementPropertiesImpl#getDiskSpace <em>Disk Space</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.impl.TStorageRequirementPropertiesImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TStorageRequirementPropertiesImpl extends EObjectImpl implements TStorageRequirementProperties
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
   * The default value of the '{@link #getDiskSpace() <em>Disk Space</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDiskSpace()
   * @generated
   * @ordered
   */
  protected static final int DISK_SPACE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDiskSpace() <em>Disk Space</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDiskSpace()
   * @generated
   * @ordered
   */
  protected int diskSpace = DISK_SPACE_EDEFAULT;

  /**
   * This is true if the Disk Space attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean diskSpaceESet;

  /**
   * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnit()
   * @generated
   * @ordered
   */
  protected static final String UNIT_EDEFAULT = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TStorageRequirementPropertiesImpl()
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
    return Tosca_HRequirements_ExtensionsPackage.Literals.TSTORAGE_REQUIREMENT_PROPERTIES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDiskSpace()
  {
    return diskSpace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDiskSpace(int newDiskSpace)
  {
    int oldDiskSpace = diskSpace;
    diskSpace = newDiskSpace;
    boolean oldDiskSpaceESet = diskSpaceESet;
    diskSpaceESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__DISK_SPACE, oldDiskSpace, diskSpace, !oldDiskSpaceESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDiskSpace()
  {
    int oldDiskSpace = diskSpace;
    boolean oldDiskSpaceESet = diskSpaceESet;
    diskSpace = DISK_SPACE_EDEFAULT;
    diskSpaceESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__DISK_SPACE, oldDiskSpace, DISK_SPACE_EDEFAULT, oldDiskSpaceESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDiskSpace()
  {
    return diskSpaceESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUnit()
  {
    return (String)eVirtualGet(Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__UNIT, UNIT_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnit(String newUnit)
  {
    String unit = newUnit;
    Object oldUnit = eVirtualSet(Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__UNIT, unit);
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__UNIT, oldUnit == EVIRTUAL_NO_VALUE ? UNIT_EDEFAULT : oldUnit, unit));
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
      case Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__DISK_SPACE:
        return getDiskSpace();
      case Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__UNIT:
        return getUnit();
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
      case Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__DISK_SPACE:
        setDiskSpace((Integer)newValue);
        return;
      case Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__UNIT:
        setUnit((String)newValue);
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
      case Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__DISK_SPACE:
        unsetDiskSpace();
        return;
      case Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__UNIT:
        setUnit(UNIT_EDEFAULT);
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
      case Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__DISK_SPACE:
        return isSetDiskSpace();
      case Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__UNIT:
        String unit = (String)eVirtualGet(Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__UNIT, UNIT_EDEFAULT);
        return UNIT_EDEFAULT == null ? unit != null : !UNIT_EDEFAULT.equals(unit);
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
    result.append(" (diskSpace: ");
    if (diskSpaceESet) result.append(diskSpace); else result.append("<unset>");
    result.append(", unit: ");
    result.append(eVirtualGet(Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES__UNIT, UNIT_EDEFAULT));
    result.append(')');
    return result.toString();
  }

} //TStorageRequirementPropertiesImpl
