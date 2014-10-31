/**
 */
package eu.celar.infosystem.model.base.impl;

import eu.celar.infosystem.model.base.InfoSystemFactory;
import eu.celar.infosystem.model.base.InfoSystemPackage;
import eu.celar.infosystem.model.base.KeyPair;
import eu.celar.infosystem.model.base.MonitoringProbe;
import eu.celar.infosystem.model.base.ResizingAction;
import eu.celar.infosystem.model.base.SoftwareDependency;
import eu.celar.infosystem.model.base.UserApplication;
import eu.celar.infosystem.model.base.VirtualMachineImage;
import eu.celar.infosystem.model.base.VirtualMachineImageFlavor;
import eu.celar.infosystem.model.base.VirtualMachineImageType;

import eu.celar.infosystem.model.base.VirtualNetwork;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfoSystemPackageImpl extends EPackageImpl implements InfoSystemPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass monitoringProbeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resizingActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass softwareDependencyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass virtualMachineImageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass userApplicationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass keyPairEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass virtualMachineImageFlavorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass virtualNetworkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum virtualMachineImageTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType virtualMachineImageTypeObjectEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see eu.celar.infosystem.model.base.InfoSystemPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private InfoSystemPackageImpl()
  {
    super(eNS_URI, InfoSystemFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link InfoSystemPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static InfoSystemPackage init()
  {
    if (isInited) return (InfoSystemPackage)EPackage.Registry.INSTANCE.getEPackage(InfoSystemPackage.eNS_URI);

    // Obtain or create and register package
    InfoSystemPackageImpl theInfoSystemPackage = (InfoSystemPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InfoSystemPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InfoSystemPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XMLTypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theInfoSystemPackage.createPackageContents();

    // Initialize created meta-data
    theInfoSystemPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theInfoSystemPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(InfoSystemPackage.eNS_URI, theInfoSystemPackage);
    return theInfoSystemPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMonitoringProbe()
  {
    return monitoringProbeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMonitoringProbe_UID()
  {
    return (EAttribute)monitoringProbeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMonitoringProbe_Name()
  {
    return (EAttribute)monitoringProbeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMonitoringProbe_Description()
  {
    return (EAttribute)monitoringProbeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMonitoringProbe_URL()
  {
    return (EAttribute)monitoringProbeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResizingAction()
  {
    return resizingActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResizingAction_UID()
  {
    return (EAttribute)resizingActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResizingAction_Name()
  {
    return (EAttribute)resizingActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResizingAction_Description()
  {
    return (EAttribute)resizingActionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResizingAction_URL()
  {
    return (EAttribute)resizingActionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSoftwareDependency()
  {
    return softwareDependencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSoftwareDependency_UID()
  {
    return (EAttribute)softwareDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSoftwareDependency_Name()
  {
    return (EAttribute)softwareDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSoftwareDependency_Description()
  {
    return (EAttribute)softwareDependencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSoftwareDependency_URL()
  {
    return (EAttribute)softwareDependencyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSoftwareDependency_Type()
  {
    return (EAttribute)softwareDependencyEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVirtualMachineImage()
  {
    return virtualMachineImageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImage_UID()
  {
    return (EAttribute)virtualMachineImageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImage_Name()
  {
    return (EAttribute)virtualMachineImageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImage_Description()
  {
    return (EAttribute)virtualMachineImageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImage_Type()
  {
    return (EAttribute)virtualMachineImageEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImage_URL()
  {
    return (EAttribute)virtualMachineImageEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUserApplication()
  {
    return userApplicationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUserApplication_UID()
  {
    return (EAttribute)userApplicationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUserApplication_Name()
  {
    return (EAttribute)userApplicationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUserApplication_Description()
  {
    return (EAttribute)userApplicationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUserApplication_URL()
  {
    return (EAttribute)userApplicationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUserApplication_Type()
  {
    return (EAttribute)userApplicationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKeyPair()
  {
    return keyPairEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyPair_UID()
  {
    return (EAttribute)keyPairEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyPair_Name()
  {
    return (EAttribute)keyPairEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyPair_Description()
  {
    return (EAttribute)keyPairEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyPair_URL()
  {
    return (EAttribute)keyPairEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVirtualMachineImageFlavor()
  {
    return virtualMachineImageFlavorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImageFlavor_Name()
  {
    return (EAttribute)virtualMachineImageFlavorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImageFlavor_UID()
  {
    return (EAttribute)virtualMachineImageFlavorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVirtualNetwork()
  {
    return virtualNetworkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualNetwork_UID()
  {
    return (EAttribute)virtualNetworkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualNetwork_Name()
  {
    return (EAttribute)virtualNetworkEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualNetwork_Description()
  {
    return (EAttribute)virtualNetworkEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualNetwork_URL()
  {
    return (EAttribute)virtualNetworkEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getVirtualMachineImageType()
  {
    return virtualMachineImageTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getVirtualMachineImageTypeObject()
  {
    return virtualMachineImageTypeObjectEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfoSystemFactory getInfoSystemFactory()
  {
    return (InfoSystemFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    monitoringProbeEClass = createEClass(MONITORING_PROBE);
    createEAttribute(monitoringProbeEClass, MONITORING_PROBE__UID);
    createEAttribute(monitoringProbeEClass, MONITORING_PROBE__NAME);
    createEAttribute(monitoringProbeEClass, MONITORING_PROBE__DESCRIPTION);
    createEAttribute(monitoringProbeEClass, MONITORING_PROBE__URL);

    resizingActionEClass = createEClass(RESIZING_ACTION);
    createEAttribute(resizingActionEClass, RESIZING_ACTION__UID);
    createEAttribute(resizingActionEClass, RESIZING_ACTION__NAME);
    createEAttribute(resizingActionEClass, RESIZING_ACTION__DESCRIPTION);
    createEAttribute(resizingActionEClass, RESIZING_ACTION__URL);

    softwareDependencyEClass = createEClass(SOFTWARE_DEPENDENCY);
    createEAttribute(softwareDependencyEClass, SOFTWARE_DEPENDENCY__UID);
    createEAttribute(softwareDependencyEClass, SOFTWARE_DEPENDENCY__NAME);
    createEAttribute(softwareDependencyEClass, SOFTWARE_DEPENDENCY__DESCRIPTION);
    createEAttribute(softwareDependencyEClass, SOFTWARE_DEPENDENCY__URL);
    createEAttribute(softwareDependencyEClass, SOFTWARE_DEPENDENCY__TYPE);

    virtualMachineImageEClass = createEClass(VIRTUAL_MACHINE_IMAGE);
    createEAttribute(virtualMachineImageEClass, VIRTUAL_MACHINE_IMAGE__UID);
    createEAttribute(virtualMachineImageEClass, VIRTUAL_MACHINE_IMAGE__NAME);
    createEAttribute(virtualMachineImageEClass, VIRTUAL_MACHINE_IMAGE__DESCRIPTION);
    createEAttribute(virtualMachineImageEClass, VIRTUAL_MACHINE_IMAGE__TYPE);
    createEAttribute(virtualMachineImageEClass, VIRTUAL_MACHINE_IMAGE__URL);

    userApplicationEClass = createEClass(USER_APPLICATION);
    createEAttribute(userApplicationEClass, USER_APPLICATION__UID);
    createEAttribute(userApplicationEClass, USER_APPLICATION__NAME);
    createEAttribute(userApplicationEClass, USER_APPLICATION__DESCRIPTION);
    createEAttribute(userApplicationEClass, USER_APPLICATION__URL);
    createEAttribute(userApplicationEClass, USER_APPLICATION__TYPE);

    keyPairEClass = createEClass(KEY_PAIR);
    createEAttribute(keyPairEClass, KEY_PAIR__UID);
    createEAttribute(keyPairEClass, KEY_PAIR__NAME);
    createEAttribute(keyPairEClass, KEY_PAIR__DESCRIPTION);
    createEAttribute(keyPairEClass, KEY_PAIR__URL);

    virtualMachineImageFlavorEClass = createEClass(VIRTUAL_MACHINE_IMAGE_FLAVOR);
    createEAttribute(virtualMachineImageFlavorEClass, VIRTUAL_MACHINE_IMAGE_FLAVOR__NAME);
    createEAttribute(virtualMachineImageFlavorEClass, VIRTUAL_MACHINE_IMAGE_FLAVOR__UID);

    virtualNetworkEClass = createEClass(VIRTUAL_NETWORK);
    createEAttribute(virtualNetworkEClass, VIRTUAL_NETWORK__UID);
    createEAttribute(virtualNetworkEClass, VIRTUAL_NETWORK__NAME);
    createEAttribute(virtualNetworkEClass, VIRTUAL_NETWORK__DESCRIPTION);
    createEAttribute(virtualNetworkEClass, VIRTUAL_NETWORK__URL);

    // Create enums
    virtualMachineImageTypeEEnum = createEEnum(VIRTUAL_MACHINE_IMAGE_TYPE);

    // Create data types
    virtualMachineImageTypeObjectEDataType = createEDataType(VIRTUAL_MACHINE_IMAGE_TYPE_OBJECT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(monitoringProbeEClass, MonitoringProbe.class, "MonitoringProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMonitoringProbe_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, MonitoringProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMonitoringProbe_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, MonitoringProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMonitoringProbe_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, MonitoringProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMonitoringProbe_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, MonitoringProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resizingActionEClass, ResizingAction.class, "ResizingAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResizingAction_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, ResizingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResizingAction_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ResizingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResizingAction_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, ResizingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResizingAction_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, ResizingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(softwareDependencyEClass, SoftwareDependency.class, "SoftwareDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSoftwareDependency_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, SoftwareDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSoftwareDependency_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, SoftwareDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSoftwareDependency_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, SoftwareDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSoftwareDependency_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, SoftwareDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSoftwareDependency_Type(), theXMLTypePackage.getString(), "type", "", 1, 1, SoftwareDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(virtualMachineImageEClass, VirtualMachineImage.class, "VirtualMachineImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVirtualMachineImage_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, VirtualMachineImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImage_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, VirtualMachineImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImage_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, VirtualMachineImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImage_Type(), this.getVirtualMachineImageType(), "type", null, 1, 1, VirtualMachineImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImage_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, VirtualMachineImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(userApplicationEClass, UserApplication.class, "UserApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUserApplication_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, UserApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUserApplication_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, UserApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUserApplication_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, UserApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUserApplication_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, UserApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUserApplication_Type(), theXMLTypePackage.getString(), "type", "", 1, 1, UserApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(keyPairEClass, KeyPair.class, "KeyPair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getKeyPair_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, KeyPair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getKeyPair_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, KeyPair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getKeyPair_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, KeyPair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getKeyPair_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, KeyPair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(virtualMachineImageFlavorEClass, VirtualMachineImageFlavor.class, "VirtualMachineImageFlavor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVirtualMachineImageFlavor_Name(), ecorePackage.getEString(), "name", null, 1, 1, VirtualMachineImageFlavor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImageFlavor_UID(), ecorePackage.getEString(), "uID", null, 1, 1, VirtualMachineImageFlavor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(virtualNetworkEClass, VirtualNetwork.class, "VirtualNetwork", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVirtualNetwork_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, VirtualNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualNetwork_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, VirtualNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualNetwork_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, VirtualNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualNetwork_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, VirtualNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(virtualMachineImageTypeEEnum, VirtualMachineImageType.class, "VirtualMachineImageType");
    addEEnumLiteral(virtualMachineImageTypeEEnum, VirtualMachineImageType.BASE_IMAGE);
    addEEnumLiteral(virtualMachineImageTypeEEnum, VirtualMachineImageType.CUSTOM_IMAGE);

    // Initialize data types
    initEDataType(virtualMachineImageTypeObjectEDataType, VirtualMachineImageType.class, "VirtualMachineImageTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createExtendedMetaDataAnnotations()
  {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
    addAnnotation
      (monitoringProbeEClass, 
       source, 
       new String[] 
       {
       "name", "MonitoringProbe",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getMonitoringProbe_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getMonitoringProbe_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getMonitoringProbe_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getMonitoringProbe_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (resizingActionEClass, 
       source, 
       new String[] 
       {
       "name", "ResizingAction",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getResizingAction_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getResizingAction_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getResizingAction_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getResizingAction_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (softwareDependencyEClass, 
       source, 
       new String[] 
       {
       "name", "SoftwareDependency",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getSoftwareDependency_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSoftwareDependency_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSoftwareDependency_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSoftwareDependency_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSoftwareDependency_Type(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Type",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (virtualMachineImageEClass, 
       source, 
       new String[] 
       {
       "name", "VirtualMachineImage",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getVirtualMachineImage_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualMachineImage_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualMachineImage_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualMachineImage_Type(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Type",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualMachineImage_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (virtualMachineImageTypeEEnum, 
       source, 
       new String[] 
       {
       "name", "VirtualMachineImageType"
       });	
    addAnnotation
      (virtualMachineImageTypeObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "VirtualMachineImageType:Object",
       "baseType", "VirtualMachineImageType"
       });	
    addAnnotation
      (userApplicationEClass, 
       source, 
       new String[] 
       {
       "name", "SoftwareDependency",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getUserApplication_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getUserApplication_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getUserApplication_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getUserApplication_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getUserApplication_Type(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Type",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (keyPairEClass, 
       source, 
       new String[] 
       {
       "name", "KeyPair",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getKeyPair_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getKeyPair_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getKeyPair_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getKeyPair_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (virtualNetworkEClass, 
       source, 
       new String[] 
       {
       "name", "VirtualMachineImage",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getVirtualNetwork_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualNetwork_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualNetwork_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualNetwork_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });
  }

} //InfoSystemPackageImpl
