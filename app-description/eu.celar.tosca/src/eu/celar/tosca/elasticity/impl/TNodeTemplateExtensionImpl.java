/**
 */
package eu.celar.tosca.elasticity.impl;

import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1;
import eu.celar.tosca.elasticity.DataHintsType1;
import eu.celar.tosca.elasticity.LoadHintsType1;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

import eu.celar.tosca.impl.TNodeTemplateImpl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

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
 *   <li>{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getApplicationComponentMonitoringProbes <em>Application Component Monitoring Probes</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getApplicationComponentResizingActions <em>Application Component Resizing Actions</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getApplicationComponentVMI <em>Application Component VMI</em>}</li>
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
   * The default value of the '{@link #getApplicationComponentVMI() <em>Application Component VMI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplicationComponentVMI()
   * @generated
   * @ordered
   */
  protected static final String APPLICATION_COMPONENT_VMI_EDEFAULT = null;

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
  @SuppressWarnings("unchecked")
  public EList<String> getApplicationComponentMonitoringProbes()
  {
    EList<String> applicationComponentMonitoringProbes = (EList<String>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_MONITORING_PROBES);
    if (applicationComponentMonitoringProbes == null)
    {
      eVirtualSet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_MONITORING_PROBES, applicationComponentMonitoringProbes = new EDataTypeEList<String>(String.class, this, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_MONITORING_PROBES));
    }
    return applicationComponentMonitoringProbes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<String> getApplicationComponentResizingActions()
  {
    EList<String> applicationComponentResizingActions = (EList<String>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_RESIZING_ACTIONS);
    if (applicationComponentResizingActions == null)
    {
      eVirtualSet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_RESIZING_ACTIONS, applicationComponentResizingActions = new EDataTypeEList<String>(String.class, this, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_RESIZING_ACTIONS));
    }
    return applicationComponentResizingActions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getApplicationComponentVMI()
  {
    return (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_VMI, APPLICATION_COMPONENT_VMI_EDEFAULT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplicationComponentVMI(String newApplicationComponentVMI)
  {
    String applicationComponentVMI = newApplicationComponentVMI;
    Object oldApplicationComponentVMI = eVirtualSet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_VMI, applicationComponentVMI);
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_VMI, oldApplicationComponentVMI == EVIRTUAL_NO_VALUE ? APPLICATION_COMPONENT_VMI_EDEFAULT : oldApplicationComponentVMI, applicationComponentVMI));
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
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_MONITORING_PROBES:
        return getApplicationComponentMonitoringProbes();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_RESIZING_ACTIONS:
        return getApplicationComponentResizingActions();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_VMI:
        return getApplicationComponentVMI();
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
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        setApplicationComponentElasticityRequirements((ApplicationComponentElasticityRequirementsType1)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS:
        setApplicationComponentDataHints((DataHintsType1)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS:
        setApplicationComponentLoadHints((LoadHintsType1)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_MONITORING_PROBES:
        getApplicationComponentMonitoringProbes().clear();
        getApplicationComponentMonitoringProbes().addAll((Collection<? extends String>)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_RESIZING_ACTIONS:
        getApplicationComponentResizingActions().clear();
        getApplicationComponentResizingActions().addAll((Collection<? extends String>)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_VMI:
        setApplicationComponentVMI((String)newValue);
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
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_MONITORING_PROBES:
        getApplicationComponentMonitoringProbes().clear();
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_RESIZING_ACTIONS:
        getApplicationComponentResizingActions().clear();
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_VMI:
        setApplicationComponentVMI(APPLICATION_COMPONENT_VMI_EDEFAULT);
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
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS:
        return eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS) != null;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS:
        return eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS) != null;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS:
        return eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS) != null;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_MONITORING_PROBES:
        EList<String> applicationComponentMonitoringProbes = (EList<String>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_MONITORING_PROBES);
        return applicationComponentMonitoringProbes != null && !applicationComponentMonitoringProbes.isEmpty();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_RESIZING_ACTIONS:
        EList<String> applicationComponentResizingActions = (EList<String>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_RESIZING_ACTIONS);
        return applicationComponentResizingActions != null && !applicationComponentResizingActions.isEmpty();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_VMI:
        String applicationComponentVMI = (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_VMI, APPLICATION_COMPONENT_VMI_EDEFAULT);
        return APPLICATION_COMPONENT_VMI_EDEFAULT == null ? applicationComponentVMI != null : !APPLICATION_COMPONENT_VMI_EDEFAULT.equals(applicationComponentVMI);
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
    result.append(" (applicationComponentMonitoringProbes: ");
    result.append(eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_MONITORING_PROBES));
    result.append(", applicationComponentResizingActions: ");
    result.append(eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_RESIZING_ACTIONS));
    result.append(", applicationComponentVMI: ");
    result.append(eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_VMI, APPLICATION_COMPONENT_VMI_EDEFAULT));
    result.append(')');
    return result.toString();
  }

} //TNodeTemplateExtensionImpl
