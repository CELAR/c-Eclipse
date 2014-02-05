/**
 */
package eu.celar.infosystem.model.base.impl;

import eu.celar.infosystem.model.base.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfoSystemFactoryImpl extends EFactoryImpl implements InfoSystemFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static InfoSystemFactory init()
  {
    try
    {
      InfoSystemFactory theInfoSystemFactory = (InfoSystemFactory)EPackage.Registry.INSTANCE.getEFactory(InfoSystemPackage.eNS_URI);
      if (theInfoSystemFactory != null)
      {
        return theInfoSystemFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new InfoSystemFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfoSystemFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case InfoSystemPackage.MONITORING_PROBE: return createMonitoringProbe();
      case InfoSystemPackage.RESIZING_ACTION: return createResizingAction();
      case InfoSystemPackage.SOFTWARE_DEPENDENCY: return createSoftwareDependency();
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE: return createVirtualMachineImage();
      case InfoSystemPackage.USER_APPLICATION: return createUserApplication();
      case InfoSystemPackage.KEY_PAIR: return createKeyPair();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_TYPE:
        return createVirtualMachineImageTypeFromString(eDataType, initialValue);
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_TYPE_OBJECT:
        return createVirtualMachineImageTypeObjectFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_TYPE:
        return convertVirtualMachineImageTypeToString(eDataType, instanceValue);
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_TYPE_OBJECT:
        return convertVirtualMachineImageTypeObjectToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MonitoringProbe createMonitoringProbe()
  {
    MonitoringProbeImpl monitoringProbe = new MonitoringProbeImpl();
    return monitoringProbe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResizingAction createResizingAction()
  {
    ResizingActionImpl resizingAction = new ResizingActionImpl();
    return resizingAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SoftwareDependency createSoftwareDependency()
  {
    SoftwareDependencyImpl softwareDependency = new SoftwareDependencyImpl();
    return softwareDependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VirtualMachineImage createVirtualMachineImage()
  {
    VirtualMachineImageImpl virtualMachineImage = new VirtualMachineImageImpl();
    return virtualMachineImage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UserApplication createUserApplication()
  {
    UserApplicationImpl userApplication = new UserApplicationImpl();
    return userApplication;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeyPair createKeyPair()
  {
    KeyPairImpl keyPair = new KeyPairImpl();
    return keyPair;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VirtualMachineImageType createVirtualMachineImageTypeFromString(EDataType eDataType, String initialValue)
  {
    VirtualMachineImageType result = VirtualMachineImageType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVirtualMachineImageTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VirtualMachineImageType createVirtualMachineImageTypeObjectFromString(EDataType eDataType, String initialValue)
  {
    return createVirtualMachineImageTypeFromString(InfoSystemPackage.Literals.VIRTUAL_MACHINE_IMAGE_TYPE, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVirtualMachineImageTypeObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertVirtualMachineImageTypeToString(InfoSystemPackage.Literals.VIRTUAL_MACHINE_IMAGE_TYPE, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfoSystemPackage getInfoSystemPackage()
  {
    return (InfoSystemPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static InfoSystemPackage getPackage()
  {
    return InfoSystemPackage.eINSTANCE;
  }

} //InfoSystemFactoryImpl
