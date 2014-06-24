/**
 */
package org.example.sybl.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.example.sybl.DocumentRoot;
import org.example.sybl.SyblElasticityRequirementsDescription;
import org.example.sybl.SyblPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.sybl.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.example.sybl.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.example.sybl.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.example.sybl.impl.DocumentRootImpl#getSYBLElasticityRequirementsDescription <em>SYBL Elasticity Requirements Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot
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
  protected DocumentRootImpl()
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
    return SyblPackage.Literals.DOCUMENT_ROOT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureMap getMixed()
  {
    FeatureMap mixed = (FeatureMap)eVirtualGet(SyblPackage.DOCUMENT_ROOT__MIXED);
    if (mixed == null)
    {
      eVirtualSet(SyblPackage.DOCUMENT_ROOT__MIXED, mixed = new BasicFeatureMap(this, SyblPackage.DOCUMENT_ROOT__MIXED));
    }
    return mixed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EMap<String, String> getXMLNSPrefixMap()
  {
    EMap<String, String> xMLNSPrefixMap = (EMap<String, String>)eVirtualGet(SyblPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    if (xMLNSPrefixMap == null)
    {
      eVirtualSet(SyblPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP, xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, SyblPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP));
    }
    return xMLNSPrefixMap;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EMap<String, String> getXSISchemaLocation()
  {
    EMap<String, String> xSISchemaLocation = (EMap<String, String>)eVirtualGet(SyblPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    if (xSISchemaLocation == null)
    {
      eVirtualSet(SyblPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION, xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, SyblPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION));
    }
    return xSISchemaLocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SyblElasticityRequirementsDescription getSYBLElasticityRequirementsDescription()
  {
    return (SyblElasticityRequirementsDescription)getMixed().get(SyblPackage.Literals.DOCUMENT_ROOT__SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSYBLElasticityRequirementsDescription(SyblElasticityRequirementsDescription newSYBLElasticityRequirementsDescription, NotificationChain msgs)
  {
    return ((FeatureMap.Internal)getMixed()).basicAdd(SyblPackage.Literals.DOCUMENT_ROOT__SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION, newSYBLElasticityRequirementsDescription, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSYBLElasticityRequirementsDescription(SyblElasticityRequirementsDescription newSYBLElasticityRequirementsDescription)
  {
    ((FeatureMap.Internal)getMixed()).set(SyblPackage.Literals.DOCUMENT_ROOT__SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION, newSYBLElasticityRequirementsDescription);
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
      case SyblPackage.DOCUMENT_ROOT__MIXED:
        return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
      case SyblPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
      case SyblPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
      case SyblPackage.DOCUMENT_ROOT__SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION:
        return basicSetSYBLElasticityRequirementsDescription(null, msgs);
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
      case SyblPackage.DOCUMENT_ROOT__MIXED:
        if (coreType) return getMixed();
        return ((FeatureMap.Internal)getMixed()).getWrapper();
      case SyblPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        if (coreType) return getXMLNSPrefixMap();
        else return getXMLNSPrefixMap().map();
      case SyblPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        if (coreType) return getXSISchemaLocation();
        else return getXSISchemaLocation().map();
      case SyblPackage.DOCUMENT_ROOT__SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION:
        return getSYBLElasticityRequirementsDescription();
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
      case SyblPackage.DOCUMENT_ROOT__MIXED:
        ((FeatureMap.Internal)getMixed()).set(newValue);
        return;
      case SyblPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        ((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
        return;
      case SyblPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        ((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
        return;
      case SyblPackage.DOCUMENT_ROOT__SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION:
        setSYBLElasticityRequirementsDescription((SyblElasticityRequirementsDescription)newValue);
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
      case SyblPackage.DOCUMENT_ROOT__MIXED:
        getMixed().clear();
        return;
      case SyblPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        getXMLNSPrefixMap().clear();
        return;
      case SyblPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        getXSISchemaLocation().clear();
        return;
      case SyblPackage.DOCUMENT_ROOT__SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION:
        setSYBLElasticityRequirementsDescription((SyblElasticityRequirementsDescription)null);
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
      case SyblPackage.DOCUMENT_ROOT__MIXED:
        FeatureMap mixed = (FeatureMap)eVirtualGet(SyblPackage.DOCUMENT_ROOT__MIXED);
        return mixed != null && !mixed.isEmpty();
      case SyblPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        EMap<String, String> xMLNSPrefixMap = (EMap<String, String>)eVirtualGet(SyblPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
      case SyblPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        EMap<String, String> xSISchemaLocation = (EMap<String, String>)eVirtualGet(SyblPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
      case SyblPackage.DOCUMENT_ROOT__SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION:
        return getSYBLElasticityRequirementsDescription() != null;
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
    result.append(" (mixed: ");
    result.append(eVirtualGet(SyblPackage.DOCUMENT_ROOT__MIXED));
    result.append(')');
    return result.toString();
  }

} //DocumentRootImpl