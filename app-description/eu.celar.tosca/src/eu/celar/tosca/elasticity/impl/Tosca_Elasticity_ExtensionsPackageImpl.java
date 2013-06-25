/**
 */
package eu.celar.tosca.elasticity.impl;

import eu.celar.tosca.ToscaPackage;

import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory;
import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementsType1;
import eu.celar.tosca.elasticity.DataHintCategory;
import eu.celar.tosca.elasticity.DataHintsType1;
import eu.celar.tosca.elasticity.GlobalElasticityRequirementCategory;
import eu.celar.tosca.elasticity.GlobalElasticityRequirementsType1;
import eu.celar.tosca.elasticity.LoadHintCategory;
import eu.celar.tosca.elasticity.LoadHintsType1;
import eu.celar.tosca.elasticity.TApplicationComponentElasticityRequirement;
import eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension;
import eu.celar.tosca.elasticity.TDataHint;
import eu.celar.tosca.elasticity.TGlobalElasticityRequirement;
import eu.celar.tosca.elasticity.TLoadHint;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Tosca_Elasticity_ExtensionsPackageImpl extends EPackageImpl implements Tosca_Elasticity_ExtensionsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass applicationComponentElasticityRequirementsType1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataHintsType1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass globalElasticityRequirementsType1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loadHintsType1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tApplicationComponentElasticityRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tBoundaryDefinitionsExtensionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tDataHintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tGlobalElasticityRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tLoadHintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tNodeTemplateExtensionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum applicationComponentElasticityRequirementCategoryEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum dataHintCategoryEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum globalElasticityRequirementCategoryEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum loadHintCategoryEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType applicationComponentElasticityRequirementCategoryObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType dataHintCategoryObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType globalElasticityRequirementCategoryObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType loadHintCategoryObjectEDataType = null;

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
   * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Tosca_Elasticity_ExtensionsPackageImpl()
  {
    super(eNS_URI, Tosca_Elasticity_ExtensionsFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Tosca_Elasticity_ExtensionsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Tosca_Elasticity_ExtensionsPackage init()
  {
    if (isInited) return (Tosca_Elasticity_ExtensionsPackage)EPackage.Registry.INSTANCE.getEPackage(Tosca_Elasticity_ExtensionsPackage.eNS_URI);

    // Obtain or create and register package
    Tosca_Elasticity_ExtensionsPackageImpl theTosca_Elasticity_ExtensionsPackage = (Tosca_Elasticity_ExtensionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Tosca_Elasticity_ExtensionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Tosca_Elasticity_ExtensionsPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    ToscaPackage.eINSTANCE.eClass();
    XMLTypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theTosca_Elasticity_ExtensionsPackage.createPackageContents();

    // Initialize created meta-data
    theTosca_Elasticity_ExtensionsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTosca_Elasticity_ExtensionsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Tosca_Elasticity_ExtensionsPackage.eNS_URI, theTosca_Elasticity_ExtensionsPackage);
    return theTosca_Elasticity_ExtensionsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getApplicationComponentElasticityRequirementsType1()
  {
    return applicationComponentElasticityRequirementsType1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getApplicationComponentElasticityRequirementsType1_ApplicationComponentElasticityRequirements()
  {
    return (EReference)applicationComponentElasticityRequirementsType1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataHintsType1()
  {
    return dataHintsType1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataHintsType1_DataHints()
  {
    return (EReference)dataHintsType1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGlobalElasticityRequirementsType1()
  {
    return globalElasticityRequirementsType1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGlobalElasticityRequirementsType1_GlobalElasticityRequirements()
  {
    return (EReference)globalElasticityRequirementsType1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoadHintsType1()
  {
    return loadHintsType1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoadHintsType1_LoadHints()
  {
    return (EReference)loadHintsType1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTApplicationComponentElasticityRequirement()
  {
    return tApplicationComponentElasticityRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTApplicationComponentElasticityRequirement_Name()
  {
    return (EAttribute)tApplicationComponentElasticityRequirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTApplicationComponentElasticityRequirement_Value()
  {
    return (EAttribute)tApplicationComponentElasticityRequirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTBoundaryDefinitionsExtension()
  {
    return tBoundaryDefinitionsExtensionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTBoundaryDefinitionsExtension_GlobalElasticityRequirements()
  {
    return (EReference)tBoundaryDefinitionsExtensionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTDataHint()
  {
    return tDataHintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTDataHint_Name()
  {
    return (EAttribute)tDataHintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTDataHint_Value()
  {
    return (EAttribute)tDataHintEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTGlobalElasticityRequirement()
  {
    return tGlobalElasticityRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTGlobalElasticityRequirement_Name()
  {
    return (EAttribute)tGlobalElasticityRequirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTGlobalElasticityRequirement_Value()
  {
    return (EAttribute)tGlobalElasticityRequirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTLoadHint()
  {
    return tLoadHintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTLoadHint_Name()
  {
    return (EAttribute)tLoadHintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTLoadHint_Value()
  {
    return (EAttribute)tLoadHintEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTNodeTemplateExtension()
  {
    return tNodeTemplateExtensionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTNodeTemplateExtension_ApplicationComponentElasticityRequirements()
  {
    return (EReference)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTNodeTemplateExtension_ApplicationComponentDataHints()
  {
    return (EReference)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTNodeTemplateExtension_ApplicationComponentLoadHints()
  {
    return (EReference)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getApplicationComponentElasticityRequirementCategory()
  {
    return applicationComponentElasticityRequirementCategoryEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getDataHintCategory()
  {
    return dataHintCategoryEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getGlobalElasticityRequirementCategory()
  {
    return globalElasticityRequirementCategoryEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getLoadHintCategory()
  {
    return loadHintCategoryEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getApplicationComponentElasticityRequirementCategoryObject()
  {
    return applicationComponentElasticityRequirementCategoryObjectEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getDataHintCategoryObject()
  {
    return dataHintCategoryObjectEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getGlobalElasticityRequirementCategoryObject()
  {
    return globalElasticityRequirementCategoryObjectEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getLoadHintCategoryObject()
  {
    return loadHintCategoryObjectEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_Elasticity_ExtensionsFactory getTosca_Elasticity_ExtensionsFactory()
  {
    return (Tosca_Elasticity_ExtensionsFactory)getEFactoryInstance();
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
    applicationComponentElasticityRequirementsType1EClass = createEClass(APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1);
    createEReference(applicationComponentElasticityRequirementsType1EClass, APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS_TYPE1__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS);

    dataHintsType1EClass = createEClass(DATA_HINTS_TYPE1);
    createEReference(dataHintsType1EClass, DATA_HINTS_TYPE1__DATA_HINTS);

    globalElasticityRequirementsType1EClass = createEClass(GLOBAL_ELASTICITY_REQUIREMENTS_TYPE1);
    createEReference(globalElasticityRequirementsType1EClass, GLOBAL_ELASTICITY_REQUIREMENTS_TYPE1__GLOBAL_ELASTICITY_REQUIREMENTS);

    loadHintsType1EClass = createEClass(LOAD_HINTS_TYPE1);
    createEReference(loadHintsType1EClass, LOAD_HINTS_TYPE1__LOAD_HINTS);

    tApplicationComponentElasticityRequirementEClass = createEClass(TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT);
    createEAttribute(tApplicationComponentElasticityRequirementEClass, TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT__NAME);
    createEAttribute(tApplicationComponentElasticityRequirementEClass, TAPPLICATION_COMPONENT_ELASTICITY_REQUIREMENT__VALUE);

    tBoundaryDefinitionsExtensionEClass = createEClass(TBOUNDARY_DEFINITIONS_EXTENSION);
    createEReference(tBoundaryDefinitionsExtensionEClass, TBOUNDARY_DEFINITIONS_EXTENSION__GLOBAL_ELASTICITY_REQUIREMENTS);

    tDataHintEClass = createEClass(TDATA_HINT);
    createEAttribute(tDataHintEClass, TDATA_HINT__NAME);
    createEAttribute(tDataHintEClass, TDATA_HINT__VALUE);

    tGlobalElasticityRequirementEClass = createEClass(TGLOBAL_ELASTICITY_REQUIREMENT);
    createEAttribute(tGlobalElasticityRequirementEClass, TGLOBAL_ELASTICITY_REQUIREMENT__NAME);
    createEAttribute(tGlobalElasticityRequirementEClass, TGLOBAL_ELASTICITY_REQUIREMENT__VALUE);

    tLoadHintEClass = createEClass(TLOAD_HINT);
    createEAttribute(tLoadHintEClass, TLOAD_HINT__NAME);
    createEAttribute(tLoadHintEClass, TLOAD_HINT__VALUE);

    tNodeTemplateExtensionEClass = createEClass(TNODE_TEMPLATE_EXTENSION);
    createEReference(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_ELASTICITY_REQUIREMENTS);
    createEReference(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_DATA_HINTS);
    createEReference(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__APPLICATION_COMPONENT_LOAD_HINTS);

    // Create enums
    applicationComponentElasticityRequirementCategoryEEnum = createEEnum(APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY);
    dataHintCategoryEEnum = createEEnum(DATA_HINT_CATEGORY);
    globalElasticityRequirementCategoryEEnum = createEEnum(GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY);
    loadHintCategoryEEnum = createEEnum(LOAD_HINT_CATEGORY);

    // Create data types
    applicationComponentElasticityRequirementCategoryObjectEDataType = createEDataType(APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT);
    dataHintCategoryObjectEDataType = createEDataType(DATA_HINT_CATEGORY_OBJECT);
    globalElasticityRequirementCategoryObjectEDataType = createEDataType(GLOBAL_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT);
    loadHintCategoryObjectEDataType = createEDataType(LOAD_HINT_CATEGORY_OBJECT);
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
    ToscaPackage theToscaPackage = (ToscaPackage)EPackage.Registry.INSTANCE.getEPackage(ToscaPackage.eNS_URI);
    XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    tApplicationComponentElasticityRequirementEClass.getESuperTypes().add(theToscaPackage.getTExtensibleElements());
    tBoundaryDefinitionsExtensionEClass.getESuperTypes().add(theToscaPackage.getTBoundaryDefinitions());
    tDataHintEClass.getESuperTypes().add(theToscaPackage.getTExtensibleElements());
    tGlobalElasticityRequirementEClass.getESuperTypes().add(theToscaPackage.getTExtensibleElements());
    tLoadHintEClass.getESuperTypes().add(theToscaPackage.getTExtensibleElements());
    tNodeTemplateExtensionEClass.getESuperTypes().add(theToscaPackage.getTNodeTemplate());

    // Initialize classes and features; add operations and parameters
    initEClass(applicationComponentElasticityRequirementsType1EClass, ApplicationComponentElasticityRequirementsType1.class, "ApplicationComponentElasticityRequirementsType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getApplicationComponentElasticityRequirementsType1_ApplicationComponentElasticityRequirements(), this.getTApplicationComponentElasticityRequirement(), null, "applicationComponentElasticityRequirements", null, 1, -1, ApplicationComponentElasticityRequirementsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataHintsType1EClass, DataHintsType1.class, "DataHintsType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDataHintsType1_DataHints(), this.getTDataHint(), null, "dataHints", null, 1, -1, DataHintsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(globalElasticityRequirementsType1EClass, GlobalElasticityRequirementsType1.class, "GlobalElasticityRequirementsType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGlobalElasticityRequirementsType1_GlobalElasticityRequirements(), this.getTGlobalElasticityRequirement(), null, "globalElasticityRequirements", null, 1, -1, GlobalElasticityRequirementsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loadHintsType1EClass, LoadHintsType1.class, "LoadHintsType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLoadHintsType1_LoadHints(), this.getTLoadHint(), null, "loadHints", null, 1, -1, LoadHintsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tApplicationComponentElasticityRequirementEClass, TApplicationComponentElasticityRequirement.class, "TApplicationComponentElasticityRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTApplicationComponentElasticityRequirement_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TApplicationComponentElasticityRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTApplicationComponentElasticityRequirement_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, TApplicationComponentElasticityRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tBoundaryDefinitionsExtensionEClass, TBoundaryDefinitionsExtension.class, "TBoundaryDefinitionsExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTBoundaryDefinitionsExtension_GlobalElasticityRequirements(), this.getGlobalElasticityRequirementsType1(), null, "globalElasticityRequirements", null, 0, 1, TBoundaryDefinitionsExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tDataHintEClass, TDataHint.class, "TDataHint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTDataHint_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TDataHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTDataHint_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, TDataHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tGlobalElasticityRequirementEClass, TGlobalElasticityRequirement.class, "TGlobalElasticityRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTGlobalElasticityRequirement_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TGlobalElasticityRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTGlobalElasticityRequirement_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, TGlobalElasticityRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tLoadHintEClass, TLoadHint.class, "TLoadHint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTLoadHint_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TLoadHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTLoadHint_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, TLoadHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tNodeTemplateExtensionEClass, TNodeTemplateExtension.class, "TNodeTemplateExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTNodeTemplateExtension_ApplicationComponentElasticityRequirements(), this.getApplicationComponentElasticityRequirementsType1(), null, "applicationComponentElasticityRequirements", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTNodeTemplateExtension_ApplicationComponentDataHints(), this.getDataHintsType1(), null, "applicationComponentDataHints", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTNodeTemplateExtension_ApplicationComponentLoadHints(), this.getLoadHintsType1(), null, "applicationComponentLoadHints", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(applicationComponentElasticityRequirementCategoryEEnum, ApplicationComponentElasticityRequirementCategory.class, "ApplicationComponentElasticityRequirementCategory");
    addEEnumLiteral(applicationComponentElasticityRequirementCategoryEEnum, ApplicationComponentElasticityRequirementCategory.MINIMUM_RESPONSE_TIME);
    addEEnumLiteral(applicationComponentElasticityRequirementCategoryEEnum, ApplicationComponentElasticityRequirementCategory.MINIMUN_COST);
    addEEnumLiteral(applicationComponentElasticityRequirementCategoryEEnum, ApplicationComponentElasticityRequirementCategory.MAXIMUM_COST);

    initEEnum(dataHintCategoryEEnum, DataHintCategory.class, "DataHintCategory");
    addEEnumLiteral(dataHintCategoryEEnum, DataHintCategory.JSON);
    addEEnumLiteral(dataHintCategoryEEnum, DataHintCategory.XML);

    initEEnum(globalElasticityRequirementCategoryEEnum, GlobalElasticityRequirementCategory.class, "GlobalElasticityRequirementCategory");
    addEEnumLiteral(globalElasticityRequirementCategoryEEnum, GlobalElasticityRequirementCategory.MINIMUM_RESPONSE_TIME);
    addEEnumLiteral(globalElasticityRequirementCategoryEEnum, GlobalElasticityRequirementCategory.BANDWIDTH);
    addEEnumLiteral(globalElasticityRequirementCategoryEEnum, GlobalElasticityRequirementCategory.MINIMUN_COST);
    addEEnumLiteral(globalElasticityRequirementCategoryEEnum, GlobalElasticityRequirementCategory.MAXIMUM_COST);

    initEEnum(loadHintCategoryEEnum, LoadHintCategory.class, "LoadHintCategory");
    addEEnumLiteral(loadHintCategoryEEnum, LoadHintCategory.READ_HEAVY);
    addEEnumLiteral(loadHintCategoryEEnum, LoadHintCategory.WRITE_HEAVY);

    // Initialize data types
    initEDataType(applicationComponentElasticityRequirementCategoryObjectEDataType, ApplicationComponentElasticityRequirementCategory.class, "ApplicationComponentElasticityRequirementCategoryObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
    initEDataType(dataHintCategoryObjectEDataType, DataHintCategory.class, "DataHintCategoryObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
    initEDataType(globalElasticityRequirementCategoryObjectEDataType, GlobalElasticityRequirementCategory.class, "GlobalElasticityRequirementCategoryObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
    initEDataType(loadHintCategoryObjectEDataType, LoadHintCategory.class, "LoadHintCategoryObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

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
      (applicationComponentElasticityRequirementCategoryEEnum, 
       source, 
       new String[] 
       {
       "name", "ApplicationComponentElasticityRequirementCategory"
       });		
    addAnnotation
      (applicationComponentElasticityRequirementCategoryObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "ApplicationComponentElasticityRequirementCategory:Object",
       "baseType", "ApplicationComponentElasticityRequirementCategory"
       });		
    addAnnotation
      (applicationComponentElasticityRequirementsType1EClass, 
       source, 
       new String[] 
       {
       "name", "ApplicationComponentElasticityRequirementsType1",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getApplicationComponentElasticityRequirementsType1_ApplicationComponentElasticityRequirements(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "applicationComponentElasticityRequirements",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (dataHintCategoryEEnum, 
       source, 
       new String[] 
       {
       "name", "DataHintCategory"
       });		
    addAnnotation
      (dataHintCategoryObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "DataHintCategory:Object",
       "baseType", "DataHintCategory"
       });		
    addAnnotation
      (dataHintsType1EClass, 
       source, 
       new String[] 
       {
       "name", "DataHintsType1",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getDataHintsType1_DataHints(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "dataHints",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (globalElasticityRequirementCategoryEEnum, 
       source, 
       new String[] 
       {
       "name", "GlobalElasticityRequirementCategory"
       });		
    addAnnotation
      (globalElasticityRequirementCategoryObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "GlobalElasticityRequirementCategory:Object",
       "baseType", "GlobalElasticityRequirementCategory"
       });		
    addAnnotation
      (globalElasticityRequirementsType1EClass, 
       source, 
       new String[] 
       {
       "name", "GlobalElasticityRequirementsType1",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getGlobalElasticityRequirementsType1_GlobalElasticityRequirements(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "globalElasticityRequirements",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (loadHintCategoryEEnum, 
       source, 
       new String[] 
       {
       "name", "LoadHintCategory"
       });		
    addAnnotation
      (loadHintCategoryObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "LoadHintCategory:Object",
       "baseType", "LoadHintCategory"
       });		
    addAnnotation
      (loadHintsType1EClass, 
       source, 
       new String[] 
       {
       "name", "LoadHintsType1",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getLoadHintsType1_LoadHints(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "loadHints",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (tApplicationComponentElasticityRequirementEClass, 
       source, 
       new String[] 
       {
       "name", "TApplicationComponentElasticityRequirement",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTApplicationComponentElasticityRequirement_Name(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "Name"
       });		
    addAnnotation
      (getTApplicationComponentElasticityRequirement_Value(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "Value"
       });		
    addAnnotation
      (tBoundaryDefinitionsExtensionEClass, 
       source, 
       new String[] 
       {
       "name", "TBoundaryDefinitionsExtension",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTBoundaryDefinitionsExtension_GlobalElasticityRequirements(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "globalElasticityRequirements",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (tDataHintEClass, 
       source, 
       new String[] 
       {
       "name", "TDataHint",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTDataHint_Name(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "Name"
       });		
    addAnnotation
      (getTDataHint_Value(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "Value"
       });		
    addAnnotation
      (tGlobalElasticityRequirementEClass, 
       source, 
       new String[] 
       {
       "name", "TGlobalElasticityRequirement",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTGlobalElasticityRequirement_Name(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "Name"
       });		
    addAnnotation
      (getTGlobalElasticityRequirement_Value(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "Value"
       });		
    addAnnotation
      (tLoadHintEClass, 
       source, 
       new String[] 
       {
       "name", "TLoadHint",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTLoadHint_Name(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "Name"
       });		
    addAnnotation
      (getTLoadHint_Value(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "Value"
       });		
    addAnnotation
      (tNodeTemplateExtensionEClass, 
       source, 
       new String[] 
       {
       "name", "TNodeTemplateExtension",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTNodeTemplateExtension_ApplicationComponentElasticityRequirements(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "applicationComponentElasticityRequirements",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getTNodeTemplateExtension_ApplicationComponentDataHints(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "applicationComponentDataHints",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getTNodeTemplateExtension_ApplicationComponentLoadHints(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "applicationComponentLoadHints",
       "namespace", "##targetNamespace"
       });
  }

} //Tosca_Elasticity_ExtensionsPackageImpl
