/**
 */
package eu.celar.tosca.hrequirements.impl;

import eu.celar.tosca.hrequirements.*;

import org.eclipse.emf.ecore.EClass;
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
public class Tosca_HRequirements_ExtensionsFactoryImpl extends EFactoryImpl implements Tosca_HRequirements_ExtensionsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Tosca_HRequirements_ExtensionsFactory init()
  {
    try
    {
      Tosca_HRequirements_ExtensionsFactory theTosca_HRequirements_ExtensionsFactory = (Tosca_HRequirements_ExtensionsFactory)EPackage.Registry.INSTANCE.getEFactory(Tosca_HRequirements_ExtensionsPackage.eNS_URI);
      if (theTosca_HRequirements_ExtensionsFactory != null)
      {
        return theTosca_HRequirements_ExtensionsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Tosca_HRequirements_ExtensionsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_HRequirements_ExtensionsFactoryImpl()
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
      case Tosca_HRequirements_ExtensionsPackage.DOCUMENT_ROOT: return createDocumentRoot();
      case Tosca_HRequirements_ExtensionsPackage.TCPU_REQUIREMENT_PROPERTIES: return createTCPURequirementProperties();
      case Tosca_HRequirements_ExtensionsPackage.TMEMORY_REQUIREMENT_PROPERTIES: return createTMemoryRequirementProperties();
      case Tosca_HRequirements_ExtensionsPackage.TNETWORK_REQUIREMENT_PROPERTIES: return createTNetworkRequirementProperties();
      case Tosca_HRequirements_ExtensionsPackage.TSTORAGE_REQUIREMENT_PROPERTIES: return createTStorageRequirementProperties();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DocumentRoot createDocumentRoot()
  {
    DocumentRootImpl documentRoot = new DocumentRootImpl();
    return documentRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TCPURequirementProperties createTCPURequirementProperties()
  {
    TCPURequirementPropertiesImpl tcpuRequirementProperties = new TCPURequirementPropertiesImpl();
    return tcpuRequirementProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TMemoryRequirementProperties createTMemoryRequirementProperties()
  {
    TMemoryRequirementPropertiesImpl tMemoryRequirementProperties = new TMemoryRequirementPropertiesImpl();
    return tMemoryRequirementProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TNetworkRequirementProperties createTNetworkRequirementProperties()
  {
    TNetworkRequirementPropertiesImpl tNetworkRequirementProperties = new TNetworkRequirementPropertiesImpl();
    return tNetworkRequirementProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TStorageRequirementProperties createTStorageRequirementProperties()
  {
    TStorageRequirementPropertiesImpl tStorageRequirementProperties = new TStorageRequirementPropertiesImpl();
    return tStorageRequirementProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_HRequirements_ExtensionsPackage getTosca_HRequirements_ExtensionsPackage()
  {
    return (Tosca_HRequirements_ExtensionsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Tosca_HRequirements_ExtensionsPackage getPackage()
  {
    return Tosca_HRequirements_ExtensionsPackage.eINSTANCE;
  }

} //Tosca_HRequirements_ExtensionsFactoryImpl
