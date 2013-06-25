/**
 */
package eu.celar.tosca.impl;

import eu.celar.tosca.InputParametersType;
import eu.celar.tosca.TParameter;
import eu.celar.tosca.ToscaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Parameters Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.impl.InputParametersTypeImpl#getInputParameter <em>Input Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputParametersTypeImpl extends EObjectImpl implements InputParametersType
{
  /**
   * The cached value of the '{@link #getInputParameter() <em>Input Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputParameter()
   * @generated
   * @ordered
   */
  protected EList<TParameter> inputParameter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InputParametersTypeImpl()
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
    return ToscaPackage.Literals.INPUT_PARAMETERS_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TParameter> getInputParameter()
  {
    if (inputParameter == null)
    {
      inputParameter = new EObjectContainmentEList<TParameter>(TParameter.class, this, ToscaPackage.INPUT_PARAMETERS_TYPE__INPUT_PARAMETER);
    }
    return inputParameter;
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
      case ToscaPackage.INPUT_PARAMETERS_TYPE__INPUT_PARAMETER:
        return ((InternalEList<?>)getInputParameter()).basicRemove(otherEnd, msgs);
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
      case ToscaPackage.INPUT_PARAMETERS_TYPE__INPUT_PARAMETER:
        return getInputParameter();
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
      case ToscaPackage.INPUT_PARAMETERS_TYPE__INPUT_PARAMETER:
        getInputParameter().clear();
        getInputParameter().addAll((Collection<? extends TParameter>)newValue);
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
      case ToscaPackage.INPUT_PARAMETERS_TYPE__INPUT_PARAMETER:
        getInputParameter().clear();
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
      case ToscaPackage.INPUT_PARAMETERS_TYPE__INPUT_PARAMETER:
        return inputParameter != null && !inputParameter.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InputParametersTypeImpl
