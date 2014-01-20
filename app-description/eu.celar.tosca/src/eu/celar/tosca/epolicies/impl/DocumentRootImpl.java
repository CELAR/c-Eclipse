/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.epolicies.DocumentRoot;
import eu.celar.tosca.epolicies.TElasticityConstraintProperties;
import eu.celar.tosca.epolicies.TElasticityStrategyProperties;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

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
 *   <li>{@link eu.celar.tosca.epolicies.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.DocumentRootImpl#getElasticityConstraintProperties <em>Elasticity Constraint Properties</em>}</li>
 *   <li>{@link eu.celar.tosca.epolicies.impl.DocumentRootImpl#getElasticityStrategyProperties <em>Elasticity Strategy Properties</em>}</li>
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
    return Tosca_EPolicy_ExtensionsPackage.Literals.DOCUMENT_ROOT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureMap getMixed()
  {
    FeatureMap mixed = (FeatureMap)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__MIXED);
    if (mixed == null)
    {
      eVirtualSet(Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__MIXED, mixed = new BasicFeatureMap(this, Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__MIXED));
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
    EMap<String, String> xMLNSPrefixMap = (EMap<String, String>)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    if (xMLNSPrefixMap == null)
    {
      eVirtualSet(Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP, xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP));
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
    EMap<String, String> xSISchemaLocation = (EMap<String, String>)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    if (xSISchemaLocation == null)
    {
      eVirtualSet(Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION, xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION));
    }
    return xSISchemaLocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TElasticityConstraintProperties getElasticityConstraintProperties()
  {
    return (TElasticityConstraintProperties)getMixed().get(Tosca_EPolicy_ExtensionsPackage.Literals.DOCUMENT_ROOT__ELASTICITY_CONSTRAINT_PROPERTIES, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElasticityConstraintProperties(TElasticityConstraintProperties newElasticityConstraintProperties, NotificationChain msgs)
  {
    return ((FeatureMap.Internal)getMixed()).basicAdd(Tosca_EPolicy_ExtensionsPackage.Literals.DOCUMENT_ROOT__ELASTICITY_CONSTRAINT_PROPERTIES, newElasticityConstraintProperties, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElasticityConstraintProperties(TElasticityConstraintProperties newElasticityConstraintProperties)
  {
    ((FeatureMap.Internal)getMixed()).set(Tosca_EPolicy_ExtensionsPackage.Literals.DOCUMENT_ROOT__ELASTICITY_CONSTRAINT_PROPERTIES, newElasticityConstraintProperties);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TElasticityStrategyProperties getElasticityStrategyProperties()
  {
    return (TElasticityStrategyProperties)getMixed().get(Tosca_EPolicy_ExtensionsPackage.Literals.DOCUMENT_ROOT__ELASTICITY_STRATEGY_PROPERTIES, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElasticityStrategyProperties(TElasticityStrategyProperties newElasticityStrategyProperties, NotificationChain msgs)
  {
    return ((FeatureMap.Internal)getMixed()).basicAdd(Tosca_EPolicy_ExtensionsPackage.Literals.DOCUMENT_ROOT__ELASTICITY_STRATEGY_PROPERTIES, newElasticityStrategyProperties, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElasticityStrategyProperties(TElasticityStrategyProperties newElasticityStrategyProperties)
  {
    ((FeatureMap.Internal)getMixed()).set(Tosca_EPolicy_ExtensionsPackage.Literals.DOCUMENT_ROOT__ELASTICITY_STRATEGY_PROPERTIES, newElasticityStrategyProperties);
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
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
        return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__ELASTICITY_CONSTRAINT_PROPERTIES:
        return basicSetElasticityConstraintProperties(null, msgs);
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__ELASTICITY_STRATEGY_PROPERTIES:
        return basicSetElasticityStrategyProperties(null, msgs);
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
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
        if (coreType) return getMixed();
        return ((FeatureMap.Internal)getMixed()).getWrapper();
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        if (coreType) return getXMLNSPrefixMap();
        else return getXMLNSPrefixMap().map();
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        if (coreType) return getXSISchemaLocation();
        else return getXSISchemaLocation().map();
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__ELASTICITY_CONSTRAINT_PROPERTIES:
        return getElasticityConstraintProperties();
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__ELASTICITY_STRATEGY_PROPERTIES:
        return getElasticityStrategyProperties();
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
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
        ((FeatureMap.Internal)getMixed()).set(newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        ((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        ((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__ELASTICITY_CONSTRAINT_PROPERTIES:
        setElasticityConstraintProperties((TElasticityConstraintProperties)newValue);
        return;
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__ELASTICITY_STRATEGY_PROPERTIES:
        setElasticityStrategyProperties((TElasticityStrategyProperties)newValue);
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
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
        getMixed().clear();
        return;
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        getXMLNSPrefixMap().clear();
        return;
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        getXSISchemaLocation().clear();
        return;
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__ELASTICITY_CONSTRAINT_PROPERTIES:
        setElasticityConstraintProperties((TElasticityConstraintProperties)null);
        return;
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__ELASTICITY_STRATEGY_PROPERTIES:
        setElasticityStrategyProperties((TElasticityStrategyProperties)null);
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
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
        FeatureMap mixed = (FeatureMap)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__MIXED);
        return mixed != null && !mixed.isEmpty();
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        EMap<String, String> xMLNSPrefixMap = (EMap<String, String>)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        EMap<String, String> xSISchemaLocation = (EMap<String, String>)eVirtualGet(Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__ELASTICITY_CONSTRAINT_PROPERTIES:
        return getElasticityConstraintProperties() != null;
      case Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__ELASTICITY_STRATEGY_PROPERTIES:
        return getElasticityStrategyProperties() != null;
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
    result.append(eVirtualGet(Tosca_EPolicy_ExtensionsPackage.DOCUMENT_ROOT__MIXED));
    result.append(')');
    return result.toString();
  }

} //DocumentRootImpl
