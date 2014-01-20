/**
 */
package eu.celar.tosca.hrequirements.impl;

import eu.celar.tosca.hrequirements.DocumentRoot;
import eu.celar.tosca.hrequirements.TCPURequirementProperties;
import eu.celar.tosca.hrequirements.TMemoryRequirementProperties;
import eu.celar.tosca.hrequirements.TNetworkRequirementProperties;
import eu.celar.tosca.hrequirements.TStorageRequirementProperties;
import eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.hrequirements.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.impl.DocumentRootImpl#getCPURequirementProperties <em>CPU Requirement Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.impl.DocumentRootImpl#getMemoryRequirementProperties <em>Memory Requirement Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.impl.DocumentRootImpl#getNetworkRequirementProperties <em>Network Requirement Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.hrequirements.impl.DocumentRootImpl#getStorageRequiremetProperties <em>Storage Requiremet Properties</em>}</li>
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
    return Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureMap getMixed()
  {
    FeatureMap mixed = (FeatureMap)eVirtualGet(Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MIXED);
    if (mixed == null)
    {
      eVirtualSet(Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MIXED, mixed = new BasicFeatureMap(this, Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MIXED));
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
    EMap<String, String> xMLNSPrefixMap = (EMap<String, String>)eVirtualGet(Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    if (xMLNSPrefixMap == null)
    {
      eVirtualSet(Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP, xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP));
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
    EMap<String, String> xSISchemaLocation = (EMap<String, String>)eVirtualGet(Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    if (xSISchemaLocation == null)
    {
      eVirtualSet(Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION, xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION));
    }
    return xSISchemaLocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TCPURequirementProperties getCPURequirementProperties()
  {
    return (TCPURequirementProperties)getMixed().get(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__CPU_REQUIREMENT_PROPERTIES, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCPURequirementProperties(TCPURequirementProperties newCPURequirementProperties, NotificationChain msgs)
  {
    return ((FeatureMap.Internal)getMixed()).basicAdd(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__CPU_REQUIREMENT_PROPERTIES, newCPURequirementProperties, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCPURequirementProperties(TCPURequirementProperties newCPURequirementProperties)
  {
    ((FeatureMap.Internal)getMixed()).set(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__CPU_REQUIREMENT_PROPERTIES, newCPURequirementProperties);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TMemoryRequirementProperties getMemoryRequirementProperties()
  {
    return (TMemoryRequirementProperties)getMixed().get(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__MEMORY_REQUIREMENT_PROPERTIES, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMemoryRequirementProperties(TMemoryRequirementProperties newMemoryRequirementProperties, NotificationChain msgs)
  {
    return ((FeatureMap.Internal)getMixed()).basicAdd(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__MEMORY_REQUIREMENT_PROPERTIES, newMemoryRequirementProperties, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMemoryRequirementProperties(TMemoryRequirementProperties newMemoryRequirementProperties)
  {
    ((FeatureMap.Internal)getMixed()).set(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__MEMORY_REQUIREMENT_PROPERTIES, newMemoryRequirementProperties);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TNetworkRequirementProperties getNetworkRequirementProperties()
  {
    return (TNetworkRequirementProperties)getMixed().get(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__NETWORK_REQUIREMENT_PROPERTIES, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNetworkRequirementProperties(TNetworkRequirementProperties newNetworkRequirementProperties, NotificationChain msgs)
  {
    return ((FeatureMap.Internal)getMixed()).basicAdd(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__NETWORK_REQUIREMENT_PROPERTIES, newNetworkRequirementProperties, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNetworkRequirementProperties(TNetworkRequirementProperties newNetworkRequirementProperties)
  {
    ((FeatureMap.Internal)getMixed()).set(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__NETWORK_REQUIREMENT_PROPERTIES, newNetworkRequirementProperties);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TStorageRequirementProperties getStorageRequiremetProperties()
  {
    return (TStorageRequirementProperties)getMixed().get(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__STORAGE_REQUIREMET_PROPERTIES, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStorageRequiremetProperties(TStorageRequirementProperties newStorageRequiremetProperties, NotificationChain msgs)
  {
    return ((FeatureMap.Internal)getMixed()).basicAdd(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__STORAGE_REQUIREMET_PROPERTIES, newStorageRequiremetProperties, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStorageRequiremetProperties(TStorageRequirementProperties newStorageRequiremetProperties)
  {
    ((FeatureMap.Internal)getMixed()).set(Tosca_HRequirements_ExtensionsPackage.Literals.DOCUMENT_ROOT__STORAGE_REQUIREMET_PROPERTIES, newStorageRequiremetProperties);
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
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
        return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__CPU_REQUIREMENT_PROPERTIES:
        return basicSetCPURequirementProperties(null, msgs);
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MEMORY_REQUIREMENT_PROPERTIES:
        return basicSetMemoryRequirementProperties(null, msgs);
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__NETWORK_REQUIREMENT_PROPERTIES:
        return basicSetNetworkRequirementProperties(null, msgs);
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__STORAGE_REQUIREMET_PROPERTIES:
        return basicSetStorageRequiremetProperties(null, msgs);
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
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
        if (coreType) return getMixed();
        return ((FeatureMap.Internal)getMixed()).getWrapper();
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        if (coreType) return getXMLNSPrefixMap();
        else return getXMLNSPrefixMap().map();
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        if (coreType) return getXSISchemaLocation();
        else return getXSISchemaLocation().map();
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__CPU_REQUIREMENT_PROPERTIES:
        return getCPURequirementProperties();
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MEMORY_REQUIREMENT_PROPERTIES:
        return getMemoryRequirementProperties();
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__NETWORK_REQUIREMENT_PROPERTIES:
        return getNetworkRequirementProperties();
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__STORAGE_REQUIREMET_PROPERTIES:
        return getStorageRequiremetProperties();
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
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
        ((FeatureMap.Internal)getMixed()).set(newValue);
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        ((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        ((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__CPU_REQUIREMENT_PROPERTIES:
        setCPURequirementProperties((TCPURequirementProperties)newValue);
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MEMORY_REQUIREMENT_PROPERTIES:
        setMemoryRequirementProperties((TMemoryRequirementProperties)newValue);
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__NETWORK_REQUIREMENT_PROPERTIES:
        setNetworkRequirementProperties((TNetworkRequirementProperties)newValue);
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__STORAGE_REQUIREMET_PROPERTIES:
        setStorageRequiremetProperties((TStorageRequirementProperties)newValue);
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
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
        getMixed().clear();
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        getXMLNSPrefixMap().clear();
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        getXSISchemaLocation().clear();
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__CPU_REQUIREMENT_PROPERTIES:
        setCPURequirementProperties((TCPURequirementProperties)null);
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MEMORY_REQUIREMENT_PROPERTIES:
        setMemoryRequirementProperties((TMemoryRequirementProperties)null);
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__NETWORK_REQUIREMENT_PROPERTIES:
        setNetworkRequirementProperties((TNetworkRequirementProperties)null);
        return;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__STORAGE_REQUIREMET_PROPERTIES:
        setStorageRequiremetProperties((TStorageRequirementProperties)null);
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
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
        FeatureMap mixed = (FeatureMap)eVirtualGet(Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MIXED);
        return mixed != null && !mixed.isEmpty();
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        EMap<String, String> xMLNSPrefixMap = (EMap<String, String>)eVirtualGet(Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        EMap<String, String> xSISchemaLocation = (EMap<String, String>)eVirtualGet(Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__CPU_REQUIREMENT_PROPERTIES:
        return getCPURequirementProperties() != null;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MEMORY_REQUIREMENT_PROPERTIES:
        return getMemoryRequirementProperties() != null;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__NETWORK_REQUIREMENT_PROPERTIES:
        return getNetworkRequirementProperties() != null;
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__STORAGE_REQUIREMET_PROPERTIES:
        return getStorageRequiremetProperties() != null;
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
    result.append(eVirtualGet(Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT__MIXED));
    result.append(')');
    return result.toString();
  }

} //DocumentRootImpl
