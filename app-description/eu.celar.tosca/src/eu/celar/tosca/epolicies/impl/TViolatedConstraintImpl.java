/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.TViolatedConstraint;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TViolated Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TViolatedConstraintImpl#getConstraintId <em>Constraint Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TViolatedConstraintImpl extends EObjectImpl implements TViolatedConstraint
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TViolatedConstraintImpl()
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.TVIOLATED_CONSTRAINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getConstraintId()
  {
    return (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TVIOLATED_CONSTRAINT__CONSTRAINT_ID, CONSTRAINT_ID_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstraintId(String newConstraintId)
  {
    String constraintId = newConstraintId;
    Object oldConstraintId = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TVIOLATED_CONSTRAINT__CONSTRAINT_ID, constraintId);
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TVIOLATED_CONSTRAINT__CONSTRAINT_ID, oldConstraintId == EVIRTUAL_NO_VALUE ? CONSTRAINT_ID_EDEFAULT : oldConstraintId, constraintId));
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
      case Tosca_EPolicy_ExtensionsPackage.TVIOLATED_CONSTRAINT__CONSTRAINT_ID:
        return getConstraintId();
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
      case Tosca_EPolicy_ExtensionsPackage.TVIOLATED_CONSTRAINT__CONSTRAINT_ID:
        setConstraintId((String)newValue);
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
      case Tosca_EPolicy_ExtensionsPackage.TVIOLATED_CONSTRAINT__CONSTRAINT_ID:
        setConstraintId(CONSTRAINT_ID_EDEFAULT);
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
      case Tosca_EPolicy_ExtensionsPackage.TVIOLATED_CONSTRAINT__CONSTRAINT_ID:
        String constraintId = (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TVIOLATED_CONSTRAINT__CONSTRAINT_ID, CONSTRAINT_ID_EDEFAULT);
        return CONSTRAINT_ID_EDEFAULT == null ? constraintId != null : !CONSTRAINT_ID_EDEFAULT.equals(constraintId);
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
    result.append(eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TVIOLATED_CONSTRAINT__CONSTRAINT_ID, CONSTRAINT_ID_EDEFAULT));
    result.append(')');
    return result.toString();
  }

} //TViolatedConstraintImpl
