/**
 */
package eu.celar.tosca.elasticity.impl;

import eu.celar.tosca.ToscaPackage;

import eu.celar.tosca.elasticity.ApplicationComponentElasticityRequirementCategory;
import eu.celar.tosca.elasticity.ApplicationPolicyCategory;
import eu.celar.tosca.elasticity.DataHintCategory;
import eu.celar.tosca.elasticity.DataHintsType1;
import eu.celar.tosca.elasticity.ElasticityRequirementCategory;
import eu.celar.tosca.elasticity.LoadHintCategory;
import eu.celar.tosca.elasticity.LoadHintsType1;
import eu.celar.tosca.elasticity.MonitoringProbesType1;
import eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension;
import eu.celar.tosca.elasticity.TDataHint;
import eu.celar.tosca.elasticity.TLoadHint;
import eu.celar.tosca.elasticity.TMonitoringProbe;
import eu.celar.tosca.elasticity.TNodeTemplateExtension;
import eu.celar.tosca.elasticity.TServiceTemplateExtension;
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
  private EClass dataHintsType1EClass = null;

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
  private EClass monitoringProbesType1EClass = null;

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
  private EClass tLoadHintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tMonitoringProbeEClass = null;

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
  private EClass tServiceTemplateExtensionEClass = null;

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
  private EEnum applicationPolicyCategoryEEnum = null;

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
  private EEnum elasticityRequirementCategoryEEnum = null;

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
  private EDataType applicationPolicyCategoryObjectEDataType = null;

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
  private EDataType elasticityRequirementCategoryObjectEDataType = null;

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
  public EClass getMonitoringProbesType1()
  {
    return monitoringProbesType1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMonitoringProbesType1_MonitoringProbes()
  {
    return (EReference)monitoringProbesType1EClass.getEStructuralFeatures().get(0);
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
  public EReference getTBoundaryDefinitionsExtension_MonitoringProbes()
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
  public EClass getTMonitoringProbe()
  {
    return tMonitoringProbeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTMonitoringProbe_Name()
  {
    return (EAttribute)tMonitoringProbeEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getTNodeTemplateExtension_Casmulti() {
    return (EAttribute)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(0);
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getTNodeTemplateExtension_InitInstances() {
    return (EAttribute)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(1);
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getTNodeTemplateExtension_X() {
    return (EAttribute)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(2);
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getTNodeTemplateExtension_Y() {
    return (EAttribute)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(3);
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getTNodeTemplateExtension_Ycsbmulti() {
    return (EAttribute)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(4);
  }

		/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTServiceTemplateExtension()
  {
    return tServiceTemplateExtensionEClass;
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTServiceTemplateExtension_X()
  {
    return (EAttribute)tServiceTemplateExtensionEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTServiceTemplateExtension_Y()
  {
    return (EAttribute)tServiceTemplateExtensionEClass.getEStructuralFeatures().get(1);
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
  public EEnum getApplicationPolicyCategory()
  {
    return applicationPolicyCategoryEEnum;
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
  public EEnum getElasticityRequirementCategory()
  {
    return elasticityRequirementCategoryEEnum;
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
  public EDataType getApplicationPolicyCategoryObject()
  {
    return applicationPolicyCategoryObjectEDataType;
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
  public EDataType getElasticityRequirementCategoryObject()
  {
    return elasticityRequirementCategoryObjectEDataType;
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
    dataHintsType1EClass = createEClass(DATA_HINTS_TYPE1);
    createEReference(dataHintsType1EClass, DATA_HINTS_TYPE1__DATA_HINTS);

    loadHintsType1EClass = createEClass(LOAD_HINTS_TYPE1);
    createEReference(loadHintsType1EClass, LOAD_HINTS_TYPE1__LOAD_HINTS);

    monitoringProbesType1EClass = createEClass(MONITORING_PROBES_TYPE1);
    createEReference(monitoringProbesType1EClass, MONITORING_PROBES_TYPE1__MONITORING_PROBES);

    tBoundaryDefinitionsExtensionEClass = createEClass(TBOUNDARY_DEFINITIONS_EXTENSION);
    createEReference(tBoundaryDefinitionsExtensionEClass, TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES);

    tDataHintEClass = createEClass(TDATA_HINT);
    createEAttribute(tDataHintEClass, TDATA_HINT__NAME);
    createEAttribute(tDataHintEClass, TDATA_HINT__VALUE);

    tLoadHintEClass = createEClass(TLOAD_HINT);
    createEAttribute(tLoadHintEClass, TLOAD_HINT__NAME);
    createEAttribute(tLoadHintEClass, TLOAD_HINT__VALUE);

    tMonitoringProbeEClass = createEClass(TMONITORING_PROBE);
    createEAttribute(tMonitoringProbeEClass, TMONITORING_PROBE__NAME);

    tNodeTemplateExtensionEClass = createEClass(TNODE_TEMPLATE_EXTENSION);
    createEAttribute(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__CASMULTI);
    createEAttribute(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES);
    createEAttribute(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__X);
    createEAttribute(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__Y);
    createEAttribute(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__YCSBMULTI);

    tServiceTemplateExtensionEClass = createEClass(TSERVICE_TEMPLATE_EXTENSION);
    createEAttribute(tServiceTemplateExtensionEClass, TSERVICE_TEMPLATE_EXTENSION__X);
    createEAttribute(tServiceTemplateExtensionEClass, TSERVICE_TEMPLATE_EXTENSION__Y);

    // Create enums
    applicationComponentElasticityRequirementCategoryEEnum = createEEnum(APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY);
    applicationPolicyCategoryEEnum = createEEnum(APPLICATION_POLICY_CATEGORY);
    dataHintCategoryEEnum = createEEnum(DATA_HINT_CATEGORY);
    elasticityRequirementCategoryEEnum = createEEnum(ELASTICITY_REQUIREMENT_CATEGORY);
    loadHintCategoryEEnum = createEEnum(LOAD_HINT_CATEGORY);

    // Create data types
    applicationComponentElasticityRequirementCategoryObjectEDataType = createEDataType(APPLICATION_COMPONENT_ELASTICITY_REQUIREMENT_CATEGORY_OBJECT);
    applicationPolicyCategoryObjectEDataType = createEDataType(APPLICATION_POLICY_CATEGORY_OBJECT);
    dataHintCategoryObjectEDataType = createEDataType(DATA_HINT_CATEGORY_OBJECT);
    elasticityRequirementCategoryObjectEDataType = createEDataType(ELASTICITY_REQUIREMENT_CATEGORY_OBJECT);
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
    tBoundaryDefinitionsExtensionEClass.getESuperTypes().add(theToscaPackage.getTBoundaryDefinitions());
    tDataHintEClass.getESuperTypes().add(theToscaPackage.getTExtensibleElements());
    tLoadHintEClass.getESuperTypes().add(theToscaPackage.getTExtensibleElements());
    tMonitoringProbeEClass.getESuperTypes().add(theToscaPackage.getTExtensibleElements());
    tNodeTemplateExtensionEClass.getESuperTypes().add(theToscaPackage.getTNodeTemplate());
    tServiceTemplateExtensionEClass.getESuperTypes().add(theToscaPackage.getTServiceTemplate());

    // Initialize classes and features; add operations and parameters
    initEClass(dataHintsType1EClass, DataHintsType1.class, "DataHintsType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDataHintsType1_DataHints(), this.getTDataHint(), null, "dataHints", null, 1, -1, DataHintsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loadHintsType1EClass, LoadHintsType1.class, "LoadHintsType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLoadHintsType1_LoadHints(), this.getTLoadHint(), null, "loadHints", null, 1, -1, LoadHintsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(monitoringProbesType1EClass, MonitoringProbesType1.class, "MonitoringProbesType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMonitoringProbesType1_MonitoringProbes(), this.getTMonitoringProbe(), null, "monitoringProbes", null, 1, -1, MonitoringProbesType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tBoundaryDefinitionsExtensionEClass, TBoundaryDefinitionsExtension.class, "TBoundaryDefinitionsExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTBoundaryDefinitionsExtension_MonitoringProbes(), this.getMonitoringProbesType1(), null, "monitoringProbes", null, 0, 1, TBoundaryDefinitionsExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tDataHintEClass, TDataHint.class, "TDataHint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTDataHint_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TDataHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTDataHint_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, TDataHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tLoadHintEClass, TLoadHint.class, "TLoadHint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTLoadHint_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TLoadHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTLoadHint_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, TLoadHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tMonitoringProbeEClass, TMonitoringProbe.class, "TMonitoringProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTMonitoringProbe_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TMonitoringProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tNodeTemplateExtensionEClass, TNodeTemplateExtension.class, "TNodeTemplateExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTNodeTemplateExtension_Casmulti(), theXMLTypePackage.getInt(), "casmulti", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTNodeTemplateExtension_InitInstances(), theXMLTypePackage.getInt(), "initInstances", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTNodeTemplateExtension_X(), theXMLTypePackage.getInt(), "x", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTNodeTemplateExtension_Y(), theXMLTypePackage.getInt(), "y", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTNodeTemplateExtension_Ycsbmulti(), theXMLTypePackage.getInt(), "ycsbmulti", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tServiceTemplateExtensionEClass, TServiceTemplateExtension.class, "TServiceTemplateExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTServiceTemplateExtension_X(), theXMLTypePackage.getInt(), "x", null, 0, 1, TServiceTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTServiceTemplateExtension_Y(), theXMLTypePackage.getInt(), "y", null, 0, 1, TServiceTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(applicationComponentElasticityRequirementCategoryEEnum, ApplicationComponentElasticityRequirementCategory.class, "ApplicationComponentElasticityRequirementCategory");
    addEEnumLiteral(applicationComponentElasticityRequirementCategoryEEnum, ApplicationComponentElasticityRequirementCategory.RESPONSE_TIME);
    addEEnumLiteral(applicationComponentElasticityRequirementCategoryEEnum, ApplicationComponentElasticityRequirementCategory.COST);
    addEEnumLiteral(applicationComponentElasticityRequirementCategoryEEnum, ApplicationComponentElasticityRequirementCategory.THROUGHPUT);

    initEEnum(applicationPolicyCategoryEEnum, ApplicationPolicyCategory.class, "ApplicationPolicyCategory");
    addEEnumLiteral(applicationPolicyCategoryEEnum, ApplicationPolicyCategory.MINIMIZE_COST);
    addEEnumLiteral(applicationPolicyCategoryEEnum, ApplicationPolicyCategory.MAXIMIZE_THROUGHPUT);

    initEEnum(dataHintCategoryEEnum, DataHintCategory.class, "DataHintCategory");
    addEEnumLiteral(dataHintCategoryEEnum, DataHintCategory.JSON);
    addEEnumLiteral(dataHintCategoryEEnum, DataHintCategory.XML);

    initEEnum(elasticityRequirementCategoryEEnum, ElasticityRequirementCategory.class, "ElasticityRequirementCategory");
    addEEnumLiteral(elasticityRequirementCategoryEEnum, ElasticityRequirementCategory.COST);
    addEEnumLiteral(elasticityRequirementCategoryEEnum, ElasticityRequirementCategory.THROUGHPUT);
    addEEnumLiteral(elasticityRequirementCategoryEEnum, ElasticityRequirementCategory.LATENCY);
    addEEnumLiteral(elasticityRequirementCategoryEEnum, ElasticityRequirementCategory.RESPONSE_TIME);
    addEEnumLiteral(elasticityRequirementCategoryEEnum, ElasticityRequirementCategory.BANDWIDTH);

    initEEnum(loadHintCategoryEEnum, LoadHintCategory.class, "LoadHintCategory");
    addEEnumLiteral(loadHintCategoryEEnum, LoadHintCategory.READ_HEAVY);
    addEEnumLiteral(loadHintCategoryEEnum, LoadHintCategory.WRITE_HEAVY);

    // Initialize data types
    initEDataType(applicationComponentElasticityRequirementCategoryObjectEDataType, ApplicationComponentElasticityRequirementCategory.class, "ApplicationComponentElasticityRequirementCategoryObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
    initEDataType(applicationPolicyCategoryObjectEDataType, ApplicationPolicyCategory.class, "ApplicationPolicyCategoryObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
    initEDataType(dataHintCategoryObjectEDataType, DataHintCategory.class, "DataHintCategoryObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
    initEDataType(elasticityRequirementCategoryObjectEDataType, ElasticityRequirementCategory.class, "ElasticityRequirementCategoryObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
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
      (applicationPolicyCategoryEEnum, 
       source, 
       new String[] 
       {
       "name", "ApplicationPolicyCategory"
       });		
    addAnnotation
      (applicationPolicyCategoryObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "ApplicationPolicyCategory:Object",
       "baseType", "ApplicationPolicyCategory"
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
      (elasticityRequirementCategoryEEnum, 
       source, 
       new String[] 
       {
       "name", "ElasticityRequirementCategory"
       });		
    addAnnotation
      (elasticityRequirementCategoryObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "ElasticityRequirementCategory:Object",
       "baseType", "ElasticityRequirementCategory"
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
      (monitoringProbesType1EClass, 
       source, 
       new String[] 
       {
       "name", "MonitoringProbesType1",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getMonitoringProbesType1_MonitoringProbes(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "monitoringProbes",
       "namespace", "##targetNamespace"
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
      (getTBoundaryDefinitionsExtension_MonitoringProbes(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "monitoringProbes",
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
      (tMonitoringProbeEClass, 
       source, 
       new String[] 
       {
       "name", "TMonitoringProbe",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTMonitoringProbe_Name(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "Name"
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
      (getTNodeTemplateExtension_Casmulti(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "casmulti"
       });		
    addAnnotation
      (getTNodeTemplateExtension_InitInstances(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "initInstances"
       });		
    addAnnotation
      (getTNodeTemplateExtension_X(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "x"
       });		
    addAnnotation
      (getTNodeTemplateExtension_Y(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "y"
       });		
    addAnnotation
      (getTNodeTemplateExtension_Ycsbmulti(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "ycsbmulti"
       });		
    addAnnotation
      (tServiceTemplateExtensionEClass, 
       source, 
       new String[] 
       {
       "name", "TServiceTemplateExtension",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTServiceTemplateExtension_X(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "x"
       });		
    addAnnotation
      (getTServiceTemplateExtension_Y(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "y"
       });
  }

} //Tosca_Elasticity_ExtensionsPackageImpl
