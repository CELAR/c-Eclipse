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
      Tosca_Elasticity_ExtensionsFactory theTosca_Elasticity_ExtensionsFactory = (Tosca_Elasticity_ExtensionsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.example.org/NewXMLSchema"); 
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
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1: return createApplicationComponentElasticityRequirementsType1();
      case Tosca_Elasticity_ExtensionsPackage.DATA_HINTS_TYPE1: return createDataHintsType1();
      case Tosca_Elasticity_ExtensionsPackage.GLOBAL_ELASTICITY_REQUIREMENTS_TYPE1: return createGlobalElasticityRequirementsType1();
      case Tosca_Elasticity_ExtensionsPackage.LOAD_HINTS_TYPE1: return createLoadHintsType1();
      case Tosca_Elasticity_ExtensionsPackage.TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT: return createTApplicationComponentElasticityRequirement();
      case Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION: return createTBoundaryDefinitionsExtension();
      case Tosca_Elasticity_ExtensionsPackage.TDATA_HINT: return createTDataHint();
      case Tosca_Elasticity_ExtensionsPackage.TGLOBAL_ELASTICITY_REQUIREMENT: return createTGlobalElasticityRequirement();
      case Tosca_Elasticity_ExtensionsPackage.TLOAD_HINT: return createTLoadHint();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION: return createTNodeTemplateExtension();
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
      case Tosca_Elasticity_ExtensionsPackage.DATA_HINT_CATEGORY:
        return createDataHintCategoryFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY:
        return createGlobalElasticityRequirementCategoryFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.LOAD_HINT_CATEGORY:
        return createLoadHintCategoryFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT:
        return createApplicationComponentElasticityRequirementCategoryObjectFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.DATA_HINT_CATEGORY_OBJECT:
        return createDataHintCategoryObjectFromString(eDataType, initialValue);
      case Tosca_Elasticity_ExtensionsPackage.GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT:
        return createGlobalElasticityRequirementCategoryObjectFromString(eDataType, initialValue);
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
      case Tosca_Elasticity_ExtensionsPackage.DATA_HINT_CATEGORY:
        return convertDataHintCategoryToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY:
        return convertGlobalElasticityRequirementCategoryToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.LOAD_HINT_CATEGORY:
        return convertLoadHintCategoryToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT:
        return convertApplicationComponentElasticityRequirementCategoryObjectToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.DATA_HINT_CATEGORY_OBJECT:
        return convertDataHintCategoryObjectToString(eDataType, instanceValue);
      case Tosca_Elasticity_ExtensionsPackage.GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT:
        return convertGlobalElasticityRequirementCategoryObjectToString(eDataType, instanceValue);
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
  public ApplicationComponentElasticityRequirementsType1 createApplicationComponentElasticityRequirementsType1()
  {
    ApplicationComponentElasticityRequirementsType1Impl applicationComponentElasticityRequirementsType1 = new ApplicationComponentElasticityRequirementsType1Impl();
    return applicationComponentElasticityRequirementsType1;
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
  public GlobalElasticityRequirementsType1 createGlobalElasticityRequirementsType1()
  {
    GlobalElasticityRequirementsType1Impl globalElasticityRequirementsType1 = new GlobalElasticityRequirementsType1Impl();
    return globalElasticityRequirementsType1;
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
  public TApplicationComponentElasticityRequirement createTApplicationComponentElasticityRequirement()
  {
    TApplicationComponentElasticityRequirementImpl tApplicationComponentElasticityRequirement = new TApplicationComponentElasticityRequirementImpl();
    return tApplicationComponentElasticityRequirement;
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
  public TGlobalElasticityRequirement createTGlobalElasticityRequirement()
  {
    TGlobalElasticityRequirementImpl tGlobalElasticityRequirement = new TGlobalElasticityRequirementImpl();
    return tGlobalElasticityRequirement;
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
  public GlobalElasticityRequirementCategory createGlobalElasticityRequirementCategoryFromString(EDataType eDataType, String initialValue)
  {
    GlobalElasticityRequirementCategory result = GlobalElasticityRequirementCategory.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertGlobalElasticityRequirementCategoryToString(EDataType eDataType, Object instanceValue)
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
  public GlobalElasticityRequirementCategory createGlobalElasticityRequirementCategoryObjectFromString(EDataType eDataType, String initialValue)
  {
    return createGlobalElasticityRequirementCategoryFromString(Tosca_Elasticity_ExtensionsPackage.Literals.GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertGlobalElasticityRequirementCategoryObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertGlobalElasticityRequirementCategoryToString(Tosca_Elasticity_ExtensionsPackage.Literals.GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY, instanceValue);
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
