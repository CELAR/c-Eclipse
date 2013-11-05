/**
 */
package eu.celar.tosca.elasticity.impl;

import eu.celar.tosca.elasticity.DataHintsType1;
import eu.celar.tosca.elasticity.TDataHint;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

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
 * An implementation of the model object '<em><b>Data Hints Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.impl.DataHintsType1Impl#getDataHints <em>Data Hints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataHintsType1Impl extends EObjectImpl implements DataHintsType1
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
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DataHintsType1Impl()
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
		return Tosca_Elasticity_ExtensionsPackage.Literals.DATA_HINTS_TYPE1;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  public EList<TDataHint> getDataHints()
  {
		EList<TDataHint> dataHints = (EList<TDataHint>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1__DATA_HINTS);
		if (dataHints == null) {
			eVirtualSet(Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1__DATA_HINTS, dataHints = new EObjectContainmentEList<TDataHint>(TDataHint.class, this, Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1__DATA_HINTS));
		}
		return dataHints;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1__DATA_HINTS:
				return ((InternalEList<?>)getDataHints()).basicRemove(otherEnd, msgs);
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
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1__DATA_HINTS:
				return getDataHints();
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
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1__DATA_HINTS:
				getDataHints().clear();
				getDataHints().addAll((Collection<? extends TDataHint>)newValue);
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
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1__DATA_HINTS:
				getDataHints().clear();
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
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1__DATA_HINTS:
				EList<TDataHint> dataHints = (EList<TDataHint>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1__DATA_HINTS);
				return dataHints != null && !dataHints.isEmpty();
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
		switch (offset) {
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
		switch (offset) {
			case 0 :
				eVirtualIndexBits0 = newIndexBits;
				break;
			default :
				throw new IndexOutOfBoundsException();
		}
	}

} //DataHintsType1Impl
