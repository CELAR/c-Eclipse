/**
 */
package eu.celar.infosystem.model.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.celar.infosystem.model.base.InfoSystemFactory
 * @model kind="package"
 * @generated
 */
public interface InfoSystemPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "base";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.example.org/InfoSystem";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "base";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  InfoSystemPackage eINSTANCE = eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl.init();

  /**
   * The meta object id for the '{@link eu.celar.infosystem.model.base.impl.MonitoringProbeImpl <em>Monitoring Probe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.infosystem.model.base.impl.MonitoringProbeImpl
   * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getMonitoringProbe()
   * @generated
   */
  int MONITORING_PROBE = 0;

  /**
   * The feature id for the '<em><b>UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONITORING_PROBE__UID = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONITORING_PROBE__NAME = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONITORING_PROBE__DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>URL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONITORING_PROBE__URL = 3;

  /**
   * The number of structural features of the '<em>Monitoring Probe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONITORING_PROBE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link eu.celar.infosystem.model.base.impl.ResizingActionImpl <em>Resizing Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.infosystem.model.base.impl.ResizingActionImpl
   * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getResizingAction()
   * @generated
   */
  int RESIZING_ACTION = 1;

  /**
   * The feature id for the '<em><b>UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESIZING_ACTION__UID = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESIZING_ACTION__NAME = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESIZING_ACTION__DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>URL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESIZING_ACTION__URL = 3;

  /**
   * The number of structural features of the '<em>Resizing Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESIZING_ACTION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link eu.celar.infosystem.model.base.impl.SoftwareDependencyImpl <em>Software Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.infosystem.model.base.impl.SoftwareDependencyImpl
   * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getSoftwareDependency()
   * @generated
   */
  int SOFTWARE_DEPENDENCY = 2;

  /**
   * The feature id for the '<em><b>UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_DEPENDENCY__UID = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_DEPENDENCY__NAME = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_DEPENDENCY__DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>URL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_DEPENDENCY__URL = 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_DEPENDENCY__TYPE = 4;

  /**
   * The number of structural features of the '<em>Software Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_DEPENDENCY_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link eu.celar.infosystem.model.base.impl.VirtualMachineImageImpl <em>Virtual Machine Image</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.infosystem.model.base.impl.VirtualMachineImageImpl
   * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImage()
   * @generated
   */
  int VIRTUAL_MACHINE_IMAGE = 3;

  /**
   * The feature id for the '<em><b>UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIRTUAL_MACHINE_IMAGE__UID = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIRTUAL_MACHINE_IMAGE__NAME = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIRTUAL_MACHINE_IMAGE__DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIRTUAL_MACHINE_IMAGE__TYPE = 3;

  /**
   * The feature id for the '<em><b>URL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIRTUAL_MACHINE_IMAGE__URL = 4;

  /**
   * The number of structural features of the '<em>Virtual Machine Image</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIRTUAL_MACHINE_IMAGE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link eu.celar.infosystem.model.base.impl.UserApplicationImpl <em>User Application</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.infosystem.model.base.impl.UserApplicationImpl
   * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getUserApplication()
   * @generated
   */
  int USER_APPLICATION = 4;

  /**
   * The feature id for the '<em><b>UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_APPLICATION__UID = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_APPLICATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_APPLICATION__DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>URL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_APPLICATION__URL = 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_APPLICATION__TYPE = 4;

  /**
   * The number of structural features of the '<em>User Application</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_APPLICATION_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link eu.celar.infosystem.model.base.impl.KeyPairImpl <em>Key Pair</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.infosystem.model.base.impl.KeyPairImpl
   * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getKeyPair()
   * @generated
   */
  int KEY_PAIR = 5;

  /**
   * The feature id for the '<em><b>UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_PAIR__UID = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_PAIR__NAME = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_PAIR__DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>URL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_PAIR__URL = 3;

  /**
   * The number of structural features of the '<em>Key Pair</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_PAIR_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link eu.celar.infosystem.model.base.VirtualMachineImageType <em>Virtual Machine Image Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.infosystem.model.base.VirtualMachineImageType
   * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImageType()
   * @generated
   */
  int VIRTUAL_MACHINE_IMAGE_TYPE = 6;

  /**
   * The meta object id for the '<em>Virtual Machine Image Type Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.celar.infosystem.model.base.VirtualMachineImageType
   * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImageTypeObject()
   * @generated
   */
  int VIRTUAL_MACHINE_IMAGE_TYPE_OBJECT = 7;


  /**
   * Returns the meta object for class '{@link eu.celar.infosystem.model.base.MonitoringProbe <em>Monitoring Probe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Monitoring Probe</em>'.
   * @see eu.celar.infosystem.model.base.MonitoringProbe
   * @generated
   */
  EClass getMonitoringProbe();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.MonitoringProbe#getUID <em>UID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>UID</em>'.
   * @see eu.celar.infosystem.model.base.MonitoringProbe#getUID()
   * @see #getMonitoringProbe()
   * @generated
   */
  EAttribute getMonitoringProbe_UID();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.MonitoringProbe#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.celar.infosystem.model.base.MonitoringProbe#getName()
   * @see #getMonitoringProbe()
   * @generated
   */
  EAttribute getMonitoringProbe_Name();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.MonitoringProbe#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see eu.celar.infosystem.model.base.MonitoringProbe#getDescription()
   * @see #getMonitoringProbe()
   * @generated
   */
  EAttribute getMonitoringProbe_Description();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.MonitoringProbe#getURL <em>URL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>URL</em>'.
   * @see eu.celar.infosystem.model.base.MonitoringProbe#getURL()
   * @see #getMonitoringProbe()
   * @generated
   */
  EAttribute getMonitoringProbe_URL();

  /**
   * Returns the meta object for class '{@link eu.celar.infosystem.model.base.ResizingAction <em>Resizing Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Resizing Action</em>'.
   * @see eu.celar.infosystem.model.base.ResizingAction
   * @generated
   */
  EClass getResizingAction();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.ResizingAction#getUID <em>UID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>UID</em>'.
   * @see eu.celar.infosystem.model.base.ResizingAction#getUID()
   * @see #getResizingAction()
   * @generated
   */
  EAttribute getResizingAction_UID();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.ResizingAction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.celar.infosystem.model.base.ResizingAction#getName()
   * @see #getResizingAction()
   * @generated
   */
  EAttribute getResizingAction_Name();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.ResizingAction#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see eu.celar.infosystem.model.base.ResizingAction#getDescription()
   * @see #getResizingAction()
   * @generated
   */
  EAttribute getResizingAction_Description();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.ResizingAction#getURL <em>URL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>URL</em>'.
   * @see eu.celar.infosystem.model.base.ResizingAction#getURL()
   * @see #getResizingAction()
   * @generated
   */
  EAttribute getResizingAction_URL();

  /**
   * Returns the meta object for class '{@link eu.celar.infosystem.model.base.SoftwareDependency <em>Software Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Software Dependency</em>'.
   * @see eu.celar.infosystem.model.base.SoftwareDependency
   * @generated
   */
  EClass getSoftwareDependency();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.SoftwareDependency#getUID <em>UID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>UID</em>'.
   * @see eu.celar.infosystem.model.base.SoftwareDependency#getUID()
   * @see #getSoftwareDependency()
   * @generated
   */
  EAttribute getSoftwareDependency_UID();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.SoftwareDependency#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.celar.infosystem.model.base.SoftwareDependency#getName()
   * @see #getSoftwareDependency()
   * @generated
   */
  EAttribute getSoftwareDependency_Name();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.SoftwareDependency#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see eu.celar.infosystem.model.base.SoftwareDependency#getDescription()
   * @see #getSoftwareDependency()
   * @generated
   */
  EAttribute getSoftwareDependency_Description();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.SoftwareDependency#getURL <em>URL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>URL</em>'.
   * @see eu.celar.infosystem.model.base.SoftwareDependency#getURL()
   * @see #getSoftwareDependency()
   * @generated
   */
  EAttribute getSoftwareDependency_URL();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.SoftwareDependency#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see eu.celar.infosystem.model.base.SoftwareDependency#getType()
   * @see #getSoftwareDependency()
   * @generated
   */
  EAttribute getSoftwareDependency_Type();

  /**
   * Returns the meta object for class '{@link eu.celar.infosystem.model.base.VirtualMachineImage <em>Virtual Machine Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Virtual Machine Image</em>'.
   * @see eu.celar.infosystem.model.base.VirtualMachineImage
   * @generated
   */
  EClass getVirtualMachineImage();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getUID <em>UID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>UID</em>'.
   * @see eu.celar.infosystem.model.base.VirtualMachineImage#getUID()
   * @see #getVirtualMachineImage()
   * @generated
   */
  EAttribute getVirtualMachineImage_UID();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.celar.infosystem.model.base.VirtualMachineImage#getName()
   * @see #getVirtualMachineImage()
   * @generated
   */
  EAttribute getVirtualMachineImage_Name();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see eu.celar.infosystem.model.base.VirtualMachineImage#getDescription()
   * @see #getVirtualMachineImage()
   * @generated
   */
  EAttribute getVirtualMachineImage_Description();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see eu.celar.infosystem.model.base.VirtualMachineImage#getType()
   * @see #getVirtualMachineImage()
   * @generated
   */
  EAttribute getVirtualMachineImage_Type();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.VirtualMachineImage#getURL <em>URL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>URL</em>'.
   * @see eu.celar.infosystem.model.base.VirtualMachineImage#getURL()
   * @see #getVirtualMachineImage()
   * @generated
   */
  EAttribute getVirtualMachineImage_URL();

  /**
   * Returns the meta object for class '{@link eu.celar.infosystem.model.base.UserApplication <em>User Application</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>User Application</em>'.
   * @see eu.celar.infosystem.model.base.UserApplication
   * @generated
   */
  EClass getUserApplication();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.UserApplication#getUID <em>UID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>UID</em>'.
   * @see eu.celar.infosystem.model.base.UserApplication#getUID()
   * @see #getUserApplication()
   * @generated
   */
  EAttribute getUserApplication_UID();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.UserApplication#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.celar.infosystem.model.base.UserApplication#getName()
   * @see #getUserApplication()
   * @generated
   */
  EAttribute getUserApplication_Name();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.UserApplication#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see eu.celar.infosystem.model.base.UserApplication#getDescription()
   * @see #getUserApplication()
   * @generated
   */
  EAttribute getUserApplication_Description();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.UserApplication#getURL <em>URL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>URL</em>'.
   * @see eu.celar.infosystem.model.base.UserApplication#getURL()
   * @see #getUserApplication()
   * @generated
   */
  EAttribute getUserApplication_URL();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.UserApplication#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see eu.celar.infosystem.model.base.UserApplication#getType()
   * @see #getUserApplication()
   * @generated
   */
  EAttribute getUserApplication_Type();

  /**
   * Returns the meta object for class '{@link eu.celar.infosystem.model.base.KeyPair <em>Key Pair</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key Pair</em>'.
   * @see eu.celar.infosystem.model.base.KeyPair
   * @generated
   */
  EClass getKeyPair();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.KeyPair#getUID <em>UID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>UID</em>'.
   * @see eu.celar.infosystem.model.base.KeyPair#getUID()
   * @see #getKeyPair()
   * @generated
   */
  EAttribute getKeyPair_UID();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.KeyPair#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.celar.infosystem.model.base.KeyPair#getName()
   * @see #getKeyPair()
   * @generated
   */
  EAttribute getKeyPair_Name();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.KeyPair#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see eu.celar.infosystem.model.base.KeyPair#getDescription()
   * @see #getKeyPair()
   * @generated
   */
  EAttribute getKeyPair_Description();

  /**
   * Returns the meta object for the attribute '{@link eu.celar.infosystem.model.base.KeyPair#getURL <em>URL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>URL</em>'.
   * @see eu.celar.infosystem.model.base.KeyPair#getURL()
   * @see #getKeyPair()
   * @generated
   */
  EAttribute getKeyPair_URL();

  /**
   * Returns the meta object for enum '{@link eu.celar.infosystem.model.base.VirtualMachineImageType <em>Virtual Machine Image Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Virtual Machine Image Type</em>'.
   * @see eu.celar.infosystem.model.base.VirtualMachineImageType
   * @generated
   */
  EEnum getVirtualMachineImageType();

  /**
   * Returns the meta object for data type '{@link eu.celar.infosystem.model.base.VirtualMachineImageType <em>Virtual Machine Image Type Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Virtual Machine Image Type Object</em>'.
   * @see eu.celar.infosystem.model.base.VirtualMachineImageType
   * @model instanceClass="eu.celar.infosystem.model.base.VirtualMachineImageType"
   *        extendedMetaData="name='VirtualMachineImageType:Object' baseType='VirtualMachineImageType'"
   * @generated
   */
  EDataType getVirtualMachineImageTypeObject();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  InfoSystemFactory getInfoSystemFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link eu.celar.infosystem.model.base.impl.MonitoringProbeImpl <em>Monitoring Probe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.infosystem.model.base.impl.MonitoringProbeImpl
     * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getMonitoringProbe()
     * @generated
     */
    EClass MONITORING_PROBE = eINSTANCE.getMonitoringProbe();

    /**
     * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONITORING_PROBE__UID = eINSTANCE.getMonitoringProbe_UID();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONITORING_PROBE__NAME = eINSTANCE.getMonitoringProbe_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONITORING_PROBE__DESCRIPTION = eINSTANCE.getMonitoringProbe_Description();

    /**
     * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONITORING_PROBE__URL = eINSTANCE.getMonitoringProbe_URL();

    /**
     * The meta object literal for the '{@link eu.celar.infosystem.model.base.impl.ResizingActionImpl <em>Resizing Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.infosystem.model.base.impl.ResizingActionImpl
     * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getResizingAction()
     * @generated
     */
    EClass RESIZING_ACTION = eINSTANCE.getResizingAction();

    /**
     * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESIZING_ACTION__UID = eINSTANCE.getResizingAction_UID();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESIZING_ACTION__NAME = eINSTANCE.getResizingAction_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESIZING_ACTION__DESCRIPTION = eINSTANCE.getResizingAction_Description();

    /**
     * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESIZING_ACTION__URL = eINSTANCE.getResizingAction_URL();

    /**
     * The meta object literal for the '{@link eu.celar.infosystem.model.base.impl.SoftwareDependencyImpl <em>Software Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.infosystem.model.base.impl.SoftwareDependencyImpl
     * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getSoftwareDependency()
     * @generated
     */
    EClass SOFTWARE_DEPENDENCY = eINSTANCE.getSoftwareDependency();

    /**
     * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOFTWARE_DEPENDENCY__UID = eINSTANCE.getSoftwareDependency_UID();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOFTWARE_DEPENDENCY__NAME = eINSTANCE.getSoftwareDependency_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOFTWARE_DEPENDENCY__DESCRIPTION = eINSTANCE.getSoftwareDependency_Description();

    /**
     * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOFTWARE_DEPENDENCY__URL = eINSTANCE.getSoftwareDependency_URL();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOFTWARE_DEPENDENCY__TYPE = eINSTANCE.getSoftwareDependency_Type();

    /**
     * The meta object literal for the '{@link eu.celar.infosystem.model.base.impl.VirtualMachineImageImpl <em>Virtual Machine Image</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.infosystem.model.base.impl.VirtualMachineImageImpl
     * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImage()
     * @generated
     */
    EClass VIRTUAL_MACHINE_IMAGE = eINSTANCE.getVirtualMachineImage();

    /**
     * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VIRTUAL_MACHINE_IMAGE__UID = eINSTANCE.getVirtualMachineImage_UID();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VIRTUAL_MACHINE_IMAGE__NAME = eINSTANCE.getVirtualMachineImage_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VIRTUAL_MACHINE_IMAGE__DESCRIPTION = eINSTANCE.getVirtualMachineImage_Description();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VIRTUAL_MACHINE_IMAGE__TYPE = eINSTANCE.getVirtualMachineImage_Type();

    /**
     * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VIRTUAL_MACHINE_IMAGE__URL = eINSTANCE.getVirtualMachineImage_URL();

    /**
     * The meta object literal for the '{@link eu.celar.infosystem.model.base.impl.UserApplicationImpl <em>User Application</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.infosystem.model.base.impl.UserApplicationImpl
     * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getUserApplication()
     * @generated
     */
    EClass USER_APPLICATION = eINSTANCE.getUserApplication();

    /**
     * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute USER_APPLICATION__UID = eINSTANCE.getUserApplication_UID();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute USER_APPLICATION__NAME = eINSTANCE.getUserApplication_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute USER_APPLICATION__DESCRIPTION = eINSTANCE.getUserApplication_Description();

    /**
     * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute USER_APPLICATION__URL = eINSTANCE.getUserApplication_URL();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute USER_APPLICATION__TYPE = eINSTANCE.getUserApplication_Type();

    /**
     * The meta object literal for the '{@link eu.celar.infosystem.model.base.impl.KeyPairImpl <em>Key Pair</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.infosystem.model.base.impl.KeyPairImpl
     * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getKeyPair()
     * @generated
     */
    EClass KEY_PAIR = eINSTANCE.getKeyPair();

    /**
     * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY_PAIR__UID = eINSTANCE.getKeyPair_UID();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY_PAIR__NAME = eINSTANCE.getKeyPair_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY_PAIR__DESCRIPTION = eINSTANCE.getKeyPair_Description();

    /**
     * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY_PAIR__URL = eINSTANCE.getKeyPair_URL();

    /**
     * The meta object literal for the '{@link eu.celar.infosystem.model.base.VirtualMachineImageType <em>Virtual Machine Image Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.infosystem.model.base.VirtualMachineImageType
     * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImageType()
     * @generated
     */
    EEnum VIRTUAL_MACHINE_IMAGE_TYPE = eINSTANCE.getVirtualMachineImageType();

    /**
     * The meta object literal for the '<em>Virtual Machine Image Type Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.celar.infosystem.model.base.VirtualMachineImageType
     * @see eu.celar.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImageTypeObject()
     * @generated
     */
    EDataType VIRTUAL_MACHINE_IMAGE_TYPE_OBJECT = eINSTANCE.getVirtualMachineImageTypeObject();

  }

} //InfoSystemPackage
