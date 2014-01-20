/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.ActionType;
import eu.celar.tosca.epolicies.TBitwiseOperation;
import eu.celar.tosca.epolicies.TConstraintStatus;
import eu.celar.tosca.epolicies.TElasticityStrategyProperties;
import eu.celar.tosca.epolicies.TRelationOperation;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TElasticity Strategy Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TElasticityStrategyPropertiesImpl#getSimpleCondition <em>Simple Condition</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TElasticityStrategyPropertiesImpl#getComplexCondition <em>Complex Condition</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TElasticityStrategyPropertiesImpl#getConstraintBasedCondition <em>Constraint Based Condition</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TElasticityStrategyPropertiesImpl#getAction <em>Action</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.TElasticityStrategyPropertiesImpl#getStrategyId <em>Strategy Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TElasticityStrategyPropertiesImpl extends EObjectImpl implements TElasticityStrategyProperties
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
   * The default value of the '{@link #getStrategyId() <em>Strategy Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrategyId()
   * @generated
   * @ordered
   */
  protected static final String STRATEGY_ID_EDEFAULT = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TElasticityStrategyPropertiesImpl()
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.TELASTICITY_STRATEGY_PROPERTIES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRelationOperation getSimpleCondition()
  {
    return (TRelationOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSimpleCondition(TRelationOperation newSimpleCondition, NotificationChain msgs)
  {
    Object oldSimpleCondition = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION, newSimpleCondition);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION, oldSimpleCondition == EVIRTUAL_NO_VALUE ? null : oldSimpleCondition, newSimpleCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSimpleCondition(TRelationOperation newSimpleCondition)
  {
    TRelationOperation simpleCondition = (TRelationOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION);
    if (newSimpleCondition != simpleCondition)
    {
      NotificationChain msgs = null;
      if (simpleCondition != null)
        msgs = ((InternalEObject)simpleCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION, null, msgs);
      if (newSimpleCondition != null)
        msgs = ((InternalEObject)newSimpleCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION, null, msgs);
      msgs = basicSetSimpleCondition(newSimpleCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION, newSimpleCondition, newSimpleCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TBitwiseOperation getComplexCondition()
  {
    return (TBitwiseOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetComplexCondition(TBitwiseOperation newComplexCondition, NotificationChain msgs)
  {
    Object oldComplexCondition = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION, newComplexCondition);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION, oldComplexCondition == EVIRTUAL_NO_VALUE ? null : oldComplexCondition, newComplexCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComplexCondition(TBitwiseOperation newComplexCondition)
  {
    TBitwiseOperation complexCondition = (TBitwiseOperation)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION);
    if (newComplexCondition != complexCondition)
    {
      NotificationChain msgs = null;
      if (complexCondition != null)
        msgs = ((InternalEObject)complexCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION, null, msgs);
      if (newComplexCondition != null)
        msgs = ((InternalEObject)newComplexCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION, null, msgs);
      msgs = basicSetComplexCondition(newComplexCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION, newComplexCondition, newComplexCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TConstraintStatus getConstraintBasedCondition()
  {
    return (TConstraintStatus)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstraintBasedCondition(TConstraintStatus newConstraintBasedCondition, NotificationChain msgs)
  {
    Object oldConstraintBasedCondition = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION, newConstraintBasedCondition);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION, oldConstraintBasedCondition == EVIRTUAL_NO_VALUE ? null : oldConstraintBasedCondition, newConstraintBasedCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstraintBasedCondition(TConstraintStatus newConstraintBasedCondition)
  {
    TConstraintStatus constraintBasedCondition = (TConstraintStatus)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION);
    if (newConstraintBasedCondition != constraintBasedCondition)
    {
      NotificationChain msgs = null;
      if (constraintBasedCondition != null)
        msgs = ((InternalEObject)constraintBasedCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION, null, msgs);
      if (newConstraintBasedCondition != null)
        msgs = ((InternalEObject)newConstraintBasedCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION, null, msgs);
      msgs = basicSetConstraintBasedCondition(newConstraintBasedCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION, newConstraintBasedCondition, newConstraintBasedCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionType getAction()
  {
    return (ActionType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAction(ActionType newAction, NotificationChain msgs)
  {
    Object oldAction = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION, newAction);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION, oldAction == EVIRTUAL_NO_VALUE ? null : oldAction, newAction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAction(ActionType newAction)
  {
    ActionType action = (ActionType)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION);
    if (newAction != action)
    {
      NotificationChain msgs = null;
      if (action != null)
        msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION, null, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION, null, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION, newAction, newAction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStrategyId()
  {
    return (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID, STRATEGY_ID_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStrategyId(String newStrategyId)
  {
    String strategyId = newStrategyId;
    Object oldStrategyId = eVirtualSet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID, strategyId);
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID, oldStrategyId == EVIRTUAL_NO_VALUE ? STRATEGY_ID_EDEFAULT : oldStrategyId, strategyId));
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
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION:
        return basicSetSimpleCondition(null, msgs);
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION:
        return basicSetComplexCondition(null, msgs);
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION:
        return basicSetConstraintBasedCondition(null, msgs);
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION:
        return basicSetAction(null, msgs);
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
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION:
        return getSimpleCondition();
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION:
        return getComplexCondition();
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION:
        return getConstraintBasedCondition();
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION:
        return getAction();
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID:
        return getStrategyId();
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
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION:
        setSimpleCondition((TRelationOperation)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION:
        setComplexCondition((TBitwiseOperation)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION:
        setConstraintBasedCondition((TConstraintStatus)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION:
        setAction((ActionType)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID:
        setStrategyId((String)newValue);
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
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION:
        setSimpleCondition((TRelationOperation)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION:
        setComplexCondition((TBitwiseOperation)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION:
        setConstraintBasedCondition((TConstraintStatus)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION:
        setAction((ActionType)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID:
        setStrategyId(STRATEGY_ID_EDEFAULT);
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
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION) != null;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION) != null;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION) != null;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION:
        return eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__ACTION) != null;
      case Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID:
        String strategyId = (String)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID, STRATEGY_ID_EDEFAULT);
        return STRATEGY_ID_EDEFAULT == null ? strategyId != null : !STRATEGY_ID_EDEFAULT.equals(strategyId);
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
    result.append(" (strategyId: ");
    result.append(eVirtualGet(Tosca_EPolicy_ExtensionsPackage.TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID, STRATEGY_ID_EDEFAULT));
    result.append(')');
    return result.toString();
  }

} //TElasticityStrategyPropertiesImpl
