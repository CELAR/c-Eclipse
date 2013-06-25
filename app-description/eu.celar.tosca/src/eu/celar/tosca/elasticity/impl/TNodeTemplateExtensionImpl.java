/**
 */
package eu.celar.tosca.elasticity.impl;

import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1;
import eu.celar.tosca.elasticity.DataHintsType1;
import eu.celar.tosca.elasticity.LoadHintsType1;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

import eu.celar.tosca.impl.TNodeTemplateImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TNode Template Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getApplicationComponentElasticityRequirements <em>Application Component Elasticity Requirements</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getApplicationComponentDataHints <em>Application Component Data Hints</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getApplicationComponentLoadHints <em>Application Component Load Hints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TNodeTemplateExtensionImpl extends TNodeTemplateImpl implements TNodeTemplateExtension
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
  protected TNodeTemplateExtensionImpl()
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
    return Tosca_Elasticity_ExtensionsPackage.Literals.TNODE_TEMPLATE_EXTENSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationComponentElasticityRequirementsType1 getApplicationComponentElasticityRequirements()
  {
    return (ApplicationComponentElasticityRequirementsType1)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetApplicationComponentElasticityRequirements(ApplicationComponentElasticityRequirementsType1 newApplicationComponentElasticityRequirements, NotificationChain msgs)
  {
    Object oldApplicationComponentElasticityRequirements = eVirtualSet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS, newApplicationComponentElasticityRequirements);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS, oldApplicationComponentElasticityRequirements == EVIRTUAL_NO_VALUE ? null : oldApplicationComponentElasticityRequirements, newApplicationComponentElasticityRequirements);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplicationComponentElasticityRequirements(ApplicationComponentElasticityRequirementsType1 newApplicationComponentElasticityRequirements)
  {
    ApplicationComponentElasticityRequirementsType1 applicationComponentElasticityRequirements = (ApplicationComponentElasticityRequirementsType1)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS);
    if (newApplicationComponentElasticityRequirements != applicationComponentElasticityRequirements)
    {
      NotificationChain msgs = null;
      if (applicationComponentElasticityRequirements != null)
        msgs = ((InternalEObject)applicationComponentElasticityRequirements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS, null, msgs);
      if (newApplicationComponentElasticityRequirements != null)
        msgs = ((InternalEObject)newApplicationComponentElasticityRequirements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS, null, msgs);
      msgs = basicSetApplicationComponentElasticityRequirements(newApplicationComponentElasticityRequirements, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS, newApplicationComponentElasticityRequirements, newApplicationComponentElasticityRequirements));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataHintsType1 getApplicationComponentDataHints()
  {
    return (DataHintsType1)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetApplicationComponentDataHints(DataHintsType1 newApplicationComponentDataHints, NotificationChain msgs)
  {
    Object oldApplicationComponentDataHints = eVirtualSet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS, newApplicationComponentDataHints);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS, oldApplicationComponentDataHints == EVIRTUAL_NO_VALUE ? null : oldApplicationComponentDataHints, newApplicationComponentDataHints);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplicationComponentDataHints(DataHintsType1 newApplicationComponentDataHints)
  {
    DataHintsType1 applicationComponentDataHints = (DataHintsType1)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS);
    if (newApplicationComponentDataHints != applicationComponentDataHints)
    {
      NotificationChain msgs = null;
      if (applicationComponentDataHints != null)
        msgs = ((InternalEObject)applicationComponentDataHints).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS, null, msgs);
      if (newApplicationComponentDataHints != null)
        msgs = ((InternalEObject)newApplicationComponentDataHints).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS, null, msgs);
      msgs = basicSetApplicationComponentDataHints(newApplicationComponentDataHints, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS, newApplicationComponentDataHints, newApplicationComponentDataHints));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoadHintsType1 getApplicationComponentLoadHints()
  {
    return (LoadHintsType1)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetApplicationComponentLoadHints(LoadHintsType1 newApplicationComponentLoadHints, NotificationChain msgs)
  {
    Object oldApplicationComponentLoadHints = eVirtualSet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS, newApplicationComponentLoadHints);
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS, oldApplicationComponentLoadHints == EVIRTUAL_NO_VALUE ? null : oldApplicationComponentLoadHints, newApplicationComponentLoadHints);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplicationComponentLoadHints(LoadHintsType1 newApplicationComponentLoadHints)
  {
    LoadHintsType1 applicationComponentLoadHints = (LoadHintsType1)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS);
    if (newApplicationComponentLoadHints != applicationComponentLoadHints)
    {
      NotificationChain msgs = null;
      if (applicationComponentLoadHints != null)
        msgs = ((InternalEObject)applicationComponentLoadHints).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS, null, msgs);
      if (newApplicationComponentLoadHints != null)
        msgs = ((InternalEObject)newApplicationComponentLoadHints).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS, null, msgs);
      msgs = basicSetApplicationComponentLoadHints(newApplicationComponentLoadHints, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS, newApplicationComponentLoadHints, newApplicationComponentLoadHints));
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
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        return basicSetApplicationComponentElasticityRequirements(null, msgs);
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS:
        return basicSetApplicationComponentDataHints(null, msgs);
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS:
        return basicSetApplicationComponentLoadHints(null, msgs);
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
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        return getApplicationComponentElasticityRequirements();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS:
        return getApplicationComponentDataHints();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS:
        return getApplicationComponentLoadHints();
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
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        setApplicationComponentElasticityRequirements((ApplicationComponentElasticityRequirementsType1)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS:
        setApplicationComponentDataHints((DataHintsType1)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS:
        setApplicationComponentLoadHints((LoadHintsType1)newValue);
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
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        setApplicationComponentElasticityRequirements((ApplicationComponentElasticityRequirementsType1)null);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS:
        setApplicationComponentDataHints((DataHintsType1)null);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS:
        setApplicationComponentLoadHints((LoadHintsType1)null);
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
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        return eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS) != null;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS:
        return eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS) != null;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS:
        return eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS) != null;
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

} //TNodeTemplateExtensionImpl
