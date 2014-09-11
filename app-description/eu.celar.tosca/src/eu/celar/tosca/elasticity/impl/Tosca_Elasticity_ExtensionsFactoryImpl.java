/**
 */
package eu.celar.tosca.elasticity.impl;

import eu.celar.tosca.elasticity.*;

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
public class Tosca_Elasticity_ExtensionsFactoryImpl extends EFactoryImpl implements Tosca_Elasticity_ExtensionsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Tosca_Elasticity_ExtensionsFactory init()
  {
    try
    {
      Tosca_Elasticity_ExtensionsFactory theTosca_Elasticity_ExtensionsFactory = (Tosca_Elasticity_ExtensionsFactory)EPackage.Registry.INSTANCE.getEFactory(Tosca_Elasticity_ExtensionsPackage.eNS_URI);
      if (theTosca_Elasticity_ExtensionsFactory != null)
      {
        return theTosca_Elasticity_ExtensionsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Tosca_Elasticity_ExtensionsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_Elasticity_ExtensionsFactoryImpl()
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
      case Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1: return createDataHintsType1();
      case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT: return createDocumentRoot();
      case Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE: return createImageArtifactPropertiesType();
      case Tosca_Elasticity_ExtensionsPackage.LOAD_HINTS_TYPE1: return createLoadHintsType1();
      case Tosca_Elasticity_ExtensionsPackage.MONITORING_PROBES_TYPE1: return createMonitoringProbesType1();
      case Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE: return createNodePropertiesType();
      case Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION: return createTBoundaryDefinitionsExtension();
      case Tosca_Elasticity_ExtensionsPackage.TDATA_HINT: return createTDataHint();
      case Tosca_Elasticity_ExtensionsPackage.TLOAD_HINT: return createTLoadHint();
      case Tosca_Elasticity_ExtensionsPackage.TMONITORING_PROBE: return createTMonitoringProbe();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION: return createTNodeTemplateExtension();
      case Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION: return createTServiceTemplateExtension();
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
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY:
        return createApplicationComponentElasticityRequirementCategoryFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_POLICY_CATEGORY:
        return createApplicationPolicyCategoryFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.DATA_HINT_CATEGORY:
        return createDataHintCategoryFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.ELASTICITY_REQUIREMENT_CATEGORY:
        return createElasticityRequirementCategoryFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.LOAD_HINT_CATEGORY:
        return createLoadHintCategoryFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT:
        return createApplicationComponentElasticityRequirementCategoryObjectFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_POLICY_CATEGORY_OBJECT:
        return createApplicationPolicyCategoryObjectFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.DATA_HINT_CATEGORY_OBJECT:
        return createDataHintCategoryObjectFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.ELASTICITY_REQUIREMENT_CATEGORY_OBJECT:
        return createElasticityRequirementCategoryObjectFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.LOAD_HINT_CATEGORY_OBJECT:
        return createLoadHintCategoryObjectFromString(eDataType, initialValue);
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
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY:
        return convertApplicationComponentElasticityRequirementCategoryToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_POLICY_CATEGORY:
        return convertApplicationPolicyCategoryToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.DATA_HINT_CATEGORY:
        return convertDataHintCategoryToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.ELASTICITY_REQUIREMENT_CATEGORY:
        return convertElasticityRequirementCategoryToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.LOAD_HINT_CATEGORY:
        return convertLoadHintCategoryToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT:
        return convertApplicationComponentElasticityRequirementCategoryObjectToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_POLICY_CATEGORY_OBJECT:
        return convertApplicationPolicyCategoryObjectToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.DATA_HINT_CATEGORY_OBJECT:
        return convertDataHintCategoryObjectToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.ELASTICITY_REQUIREMENT_CATEGORY_OBJECT:
        return convertElasticityRequirementCategoryObjectToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.LOAD_HINT_CATEGORY_OBJECT:
        return convertLoadHintCategoryObjectToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataHintsType1 createDataHintsType1()
  {
    DataHintsType1Impl dataHintsType1 = new DataHintsType1Impl();
    return dataHintsType1;
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
  public ImageArtifactPropertiesType createImageArtifactPropertiesType()
  {
    ImageArtifactPropertiesTypeImpl imageArtifactPropertiesType = new ImageArtifactPropertiesTypeImpl();
    return imageArtifactPropertiesType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoadHintsType1 createLoadHintsType1()
  {
    LoadHintsType1Impl loadHintsType1 = new LoadHintsType1Impl();
    return loadHintsType1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MonitoringProbesType1 createMonitoringProbesType1()
  {
    MonitoringProbesType1Impl monitoringProbesType1 = new MonitoringProbesType1Impl();
    return monitoringProbesType1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodePropertiesType createNodePropertiesType()
  {
    NodePropertiesTypeImpl nodePropertiesType = new NodePropertiesTypeImpl();
    return nodePropertiesType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TBoundaryDefinitionsExtension createTBoundaryDefinitionsExtension()
  {
    TBoundaryDefinitionsExtensionImpl tBoundaryDefinitionsExtension = new TBoundaryDefinitionsExtensionImpl();
    return tBoundaryDefinitionsExtension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TDataHint createTDataHint()
  {
    TDataHintImpl tDataHint = new TDataHintImpl();
    return tDataHint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TLoadHint createTLoadHint()
  {
    TLoadHintImpl tLoadHint = new TLoadHintImpl();
    return tLoadHint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TMonitoringProbe createTMonitoringProbe()
  {
    TMonitoringProbeImpl tMonitoringProbe = new TMonitoringProbeImpl();
    return tMonitoringProbe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TNodeTemplateExtension createTNodeTemplateExtension()
  {
    TNodeTemplateExtensionImpl tNodeTemplateExtension = new TNodeTemplateExtensionImpl();
    return tNodeTemplateExtension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TServiceTemplateExtension createTServiceTemplateExtension()
  {
    TServiceTemplateExtensionImpl tServiceTemplateExtension = new TServiceTemplateExtensionImpl();
    return tServiceTemplateExtension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationComponentElasticityRequirementCategory createApplicationComponentElasticityRequirementCategoryFromString(EDataType eDataType, String initialValue)
  {
    ApplicationComponentElasticityRequirementCategory result = ApplicationComponentElasticityRequirementCategory.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertApplicationComponentElasticityRequirementCategoryToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationPolicyCategory createApplicationPolicyCategoryFromString(EDataType eDataType, String initialValue)
  {
    ApplicationPolicyCategory result = ApplicationPolicyCategory.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertApplicationPolicyCategoryToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataHintCategory createDataHintCategoryFromString(EDataType eDataType, String initialValue)
  {
    DataHintCategory result = DataHintCategory.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDataHintCategoryToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElasticityRequirementCategory createElasticityRequirementCategoryFromString(EDataType eDataType, String initialValue)
  {
    ElasticityRequirementCategory result = ElasticityRequirementCategory.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertElasticityRequirementCategoryToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoadHintCategory createLoadHintCategoryFromString(EDataType eDataType, String initialValue)
  {
    LoadHintCategory result = LoadHintCategory.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLoadHintCategoryToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationComponentElasticityRequirementCategory createApplicationComponentElasticityRequirementCategoryObjectFromString(EDataType eDataType, String initialValue)
  {
    return createApplicationComponentElasticityRequirementCategoryFromString(Tosca_Elasticity_ExtensionsPackage.Literals.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertApplicationComponentElasticityRequirementCategoryObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertApplicationComponentElasticityRequirementCategoryToString(Tosca_Elasticity_ExtensionsPackage.Literals.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationPolicyCategory createApplicationPolicyCategoryObjectFromString(EDataType eDataType, String initialValue)
  {
    return createApplicationPolicyCategoryFromString(Tosca_Elasticity_ExtensionsPackage.Literals.APPLICATION_POLICY_CATEGORY, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertApplicationPolicyCategoryObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertApplicationPolicyCategoryToString(Tosca_Elasticity_ExtensionsPackage.Literals.APPLICATION_POLICY_CATEGORY, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataHintCategory createDataHintCategoryObjectFromString(EDataType eDataType, String initialValue)
  {
    return createDataHintCategoryFromString(Tosca_Elasticity_ExtensionsPackage.Literals.DATA_HINT_CATEGORY, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDataHintCategoryObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertDataHintCategoryToString(Tosca_Elasticity_ExtensionsPackage.Literals.DATA_HINT_CATEGORY, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElasticityRequirementCategory createElasticityRequirementCategoryObjectFromString(EDataType eDataType, String initialValue)
  {
    return createElasticityRequirementCategoryFromString(Tosca_Elasticity_ExtensionsPackage.Literals.ELASTICITY_REQUIREMENT_CATEGORY, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertElasticityRequirementCategoryObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertElasticityRequirementCategoryToString(Tosca_Elasticity_ExtensionsPackage.Literals.ELASTICITY_REQUIREMENT_CATEGORY, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoadHintCategory createLoadHintCategoryObjectFromString(EDataType eDataType, String initialValue)
  {
    return createLoadHintCategoryFromString(Tosca_Elasticity_ExtensionsPackage.Literals.LOAD_HINT_CATEGORY, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLoadHintCategoryObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertLoadHintCategoryToString(Tosca_Elasticity_ExtensionsPackage.Literals.LOAD_HINT_CATEGORY, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_Elasticity_ExtensionsPackage getTosca_Elasticity_ExtensionsPackage()
  {
    return (Tosca_Elasticity_ExtensionsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Tosca_Elasticity_ExtensionsPackage getPackage()
  {
    return Tosca_Elasticity_ExtensionsPackage.eINSTANCE;
  }

} //Tosca_Elasticity_ExtensionsFactoryImpl
