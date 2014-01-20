/**
 */
package eu.celar.tosca.hrequirements.impl;

import eu.celar.tosca.hrequirements.TCPURequirementProperties;
import eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCPU Requirement Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.hrequirements.impl.TCPURequirementPropertiesImpl#getNumCPUs <em>Num CP Us</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCPURequirementPropertiesImpl extends EObjectImpl implements TCPURequirementProperties
{
  /**
   * The default value of the '{@link #getNumCPUs() <em>Num CP Us</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumCPUs()
   * @generated
   * @ordered
   */
  protected static final int NUM_CP_US_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNumCPUs() <em>Num CP Us</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumCPUs()
   * @generated
   * @ordered
   */
  protected int numCPUs = NUM_CP_US_EDEFAULT;

  /**
   * This is true if the Num CP Us attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean numCPUsESet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TCPURequirementPropertiesImpl()
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
    return Tosca_HRequirements_ExtensionsPackage.Literals.TCPU_REQUIREMENT_PROPERTIES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getNumCPUs()
  {
    return numCPUs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNumCPUs(int newNumCPUs)
  {
    int oldNumCPUs = numCPUs;
    numCPUs = newNumCPUs;
    boolean oldNumCPUsESet = numCPUsESet;
    numCPUsESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_HRequirements_ExtensionsPackage.TCPU_REQUIREMENT_PROPERTIES__NUM_CP_US, oldNumCPUs, numCPUs, !oldNumCPUsESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetNumCPUs()
  {
    int oldNumCPUs = numCPUs;
    boolean oldNumCPUsESet = numCPUsESet;
    numCPUs = NUM_CP_US_EDEFAULT;
    numCPUsESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_HRequirements_ExtensionsPackage.TCPU_REQUIREMENT_PROPERTIES__NUM_CP_US, oldNumCPUs, NUM_CP_US_EDEFAULT, oldNumCPUsESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetNumCPUs()
  {
    return numCPUsESet;
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
      case Tosca_HRequirements_ExtensionsPackage.TCPU_REQUIREMENT_PROPERTIES__NUM_CP_US:
        return getNumCPUs();
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
      case Tosca_HRequirements_ExtensionsPackage.TCPU_REQUIREMENT_PROPERTIES__NUM_CP_US:
        setNumCPUs((Integer)newValue);
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
      case Tosca_HRequirements_ExtensionsPackage.TCPU_REQUIREMENT_PROPERTIES__NUM_CP_US:
        unsetNumCPUs();
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
      case Tosca_HRequirements_ExtensionsPackage.TCPU_REQUIREMENT_PROPERTIES__NUM_CP_US:
        return isSetNumCPUs();
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
    result.append(" (numCPUs: ");
    if (numCPUsESet) result.append(numCPUs); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //TCPURequirementPropertiesImpl
