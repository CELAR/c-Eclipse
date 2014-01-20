/**
 */
package eu.celar.tosca.hrequirements.impl;

import eu.celar.tosca.hrequirements.TMemoryRequirementProperties;
import eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TMemory Requirement Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.hrequirements.impl.TMemoryRequirementPropertiesImpl#getMemory <em>Memory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TMemoryRequirementPropertiesImpl extends EObjectImpl implements TMemoryRequirementProperties
{
  /**
   * The default value of the '{@link #getMemory() <em>Memory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMemory()
   * @generated
   * @ordered
   */
  protected static final int MEMORY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMemory() <em>Memory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMemory()
   * @generated
   * @ordered
   */
  protected int memory = MEMORY_EDEFAULT;

  /**
   * This is true if the Memory attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean memoryESet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TMemoryRequirementPropertiesImpl()
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
    return Tosca_HRequirements_ExtensionsPackage.Literals.TMEMORY_REQUIREMENT_PROPERTIES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMemory()
  {
    return memory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMemory(int newMemory)
  {
    int oldMemory = memory;
    memory = newMemory;
    boolean oldMemoryESet = memoryESet;
    memoryESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_HRequirements_ExtensionsPackage.TMEMORY_REQUIREMENT_PROPERTIES__MEMORY, oldMemory, memory, !oldMemoryESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMemory()
  {
    int oldMemory = memory;
    boolean oldMemoryESet = memoryESet;
    memory = MEMORY_EDEFAULT;
    memoryESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_HRequirements_ExtensionsPackage.TMEMORY_REQUIREMENT_PROPERTIES__MEMORY, oldMemory, MEMORY_EDEFAULT, oldMemoryESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMemory()
  {
    return memoryESet;
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
      case Tosca_HRequirements_ExtensionsPackage.TMEMORY_REQUIREMENT_PROPERTIES__MEMORY:
        return getMemory();
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
      case Tosca_HRequirements_ExtensionsPackage.TMEMORY_REQUIREMENT_PROPERTIES__MEMORY:
        setMemory((Integer)newValue);
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
      case Tosca_HRequirements_ExtensionsPackage.TMEMORY_REQUIREMENT_PROPERTIES__MEMORY:
        unsetMemory();
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
      case Tosca_HRequirements_ExtensionsPackage.TMEMORY_REQUIREMENT_PROPERTIES__MEMORY:
        return isSetMemory();
    }
    return super.eIsSet(featureID);
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
    result.append(" (memory: ");
    if (memoryESet) result.append(memory); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //TMemoryRequirementPropertiesImpl
