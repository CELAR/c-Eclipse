/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.PriorityType;
import eu.celar.tosca.epolicies.TBitwiseOperation;
import eu.celar.tosca.epolicies.TElasticityConstraintProperties;
import eu.celar.tosca.epolicies.TRelationOperation;
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
 * An implementation of the model object '<em><b>TElasticity Constraint Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TElasticityConstraintPropertiesImpl#getToEnforceSimpleConstraint <em>To Enforce Simple Constraint</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TElasticityConstraintPropertiesImpl#getToEnforceComplexConstraint <em>To Enforce Complex Constraint</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TElasticityConstraintPropertiesImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TElasticityConstraintPropertiesImpl#getConstraintId <em>Constraint Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TElasticityConstraintPropertiesImpl extends EObjectImpl implements TElasticityConstraintProperties
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
  protected TElasticityConstraintPropertiesImpl()
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.TELASTICITY_CONSTRAINT_PROPERTIES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRelationOperation getToEnforceSimpleConstraint()
  {
    return (TRelationOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetToEnforceSimpleConstraint(TRelationOperation newToEnforceSimpleConstraint, NotificationChain msgs)
  {
    Object oldToEnforceSimpleConstraint = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT, newToEnforceSimpleConstraint);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT, oldToEnforceSimpleConstraint == EVIRTUAL_NO_VALUE ? null : oldToEnforceSimpleConstraint, newToEnforceSimpleConstraint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToEnforceSimpleConstraint(TRelationOperation newToEnforceSimpleConstraint)
  {
    TRelationOperation toEnforceSimpleConstraint = (TRelationOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT);
    if (newToEnforceSimpleConstraint != toEnforceSimpleConstraint)
    {
      NotificationChain msgs = null;
      if (toEnforceSimpleConstraint != null)
        msgs = ((InternalEObject)toEnforceSimpleConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT, null, msgs);
      if (newToEnforceSimpleConstraint != null)
        msgs = ((InternalEObject)newToEnforceSimpleConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT, null, msgs);
      msgs = basicSetToEnforceSimpleConstraint(newToEnforceSimpleConstraint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT, newToEnforceSimpleConstraint, newToEnforceSimpleConstraint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TBitwiseOperation getToEnforceComplexConstraint()
  {
    return (TBitwiseOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetToEnforceComplexConstraint(TBitwiseOperation newToEnforceComplexConstraint, NotificationChain msgs)
  {
    Object oldToEnforceComplexConstraint = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT, newToEnforceComplexConstraint);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT, oldToEnforceComplexConstraint == EVIRTUAL_NO_VALUE ? null : oldToEnforceComplexConstraint, newToEnforceComplexConstraint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToEnforceComplexConstraint(TBitwiseOperation newToEnforceComplexConstraint)
  {
    TBitwiseOperation toEnforceComplexConstraint = (TBitwiseOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT);
    if (newToEnforceComplexConstraint != toEnforceComplexConstraint)
    {
      NotificationChain msgs = null;
      if (toEnforceComplexConstraint != null)
        msgs = ((InternalEObject)toEnforceComplexConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT, null, msgs);
      if (newToEnforceComplexConstraint != null)
        msgs = ((InternalEObject)newToEnforceComplexConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT, null, msgs);
      msgs = basicSetToEnforceComplexConstraint(newToEnforceComplexConstraint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT, newToEnforceComplexConstraint, newToEnforceComplexConstraint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<PriorityType> getPriority()
  {
    EList<PriorityType> priority = (EList<PriorityType>)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY);
    if (priority == null)
    {
      eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY, priority = new EObjectContainmentEList<PriorityType>(PriorityType.class, this, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY));
    }
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getConstraintId()
  {
    return (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID, CONSTRAINT_ID_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstraintId(String newConstraintId)
  {
    String constraintId = newConstraintId;
    Object oldConstraintId = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID, constraintId);
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID, oldConstraintId == EVIRTUAL_NO_VALUE ? CONSTRAINT_ID_EDEFAULT : oldConstraintId, constraintId));
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
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT:
        return basicSetToEnforceSimpleConstraint(null, msgs);
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT:
        return basicSetToEnforceComplexConstraint(null, msgs);
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY:
        return ((InternalEList<?>)getPriority()).basicRemove(otherEnd, msgs);
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
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT:
        return getToEnforceSimpleConstraint();
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT:
        return getToEnforceComplexConstraint();
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY:
        return getPriority();
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID:
        return getConstraintId();
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
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT:
        setToEnforceSimpleConstraint((TRelationOperation)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT:
        setToEnforceComplexConstraint((TBitwiseOperation)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY:
        getPriority().clear();
        getPriority().addAll((Collection<? extends PriorityType>)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID:
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
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT:
        setToEnforceSimpleConstraint((TRelationOperation)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT:
        setToEnforceComplexConstraint((TBitwiseOperation)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY:
        getPriority().clear();
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID:
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
  @SuppressWarnings("unchecked")
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT) != null;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT) != null;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY:
        EList<PriorityType> priority = (EList<PriorityType>)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY);
        return priority != null && !priority.isEmpty();
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID:
        String constraintId = (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID, CONSTRAINT_ID_EDEFAULT);
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
    result.append(eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID, CONSTRAINT_ID_EDEFAULT));
    result.append(')');
    return result.toString();
  }

} //TElasticityConstraintPropertiesImpl
