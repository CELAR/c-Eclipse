/**
 */
package eu.celar.tosca.epolicies.impl;

import eu.celar.tosca.ToscaPackage;

import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

import eu.celar.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl;

import eu.celar.tosca.epolicies.ActionType;
import eu.celar.tosca.epolicies.BitwiseLeftHandSideType;
import eu.celar.tosca.epolicies.BitwiseRightHandSideType;
import eu.celar.tosca.epolicies.DocumentRoot;
import eu.celar.tosca.epolicies.PriorityType;
import eu.celar.tosca.epolicies.RelationLeftHandSideType;
import eu.celar.tosca.epolicies.RelationRightHandSideType;
import eu.celar.tosca.epolicies.TActionParameterType;
import eu.celar.tosca.epolicies.TBitwiseOperation;
import eu.celar.tosca.epolicies.TBitwiseOperationType;
import eu.celar.tosca.epolicies.TConstraintStatus;
import eu.celar.tosca.epolicies.TElasticityConstraintProperties;
import eu.celar.tosca.epolicies.TElasticityStrategyProperties;
import eu.celar.tosca.epolicies.TFulfilledConstraint;
import eu.celar.tosca.epolicies.TPriorityType;
import eu.celar.tosca.epolicies.TRelationOperation;
import eu.celar.tosca.epolicies.TRelationOperationType;
import eu.celar.tosca.epolicies.TViolatedConstraint;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsFactory;
import eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage;

import eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage;

import eu.celar.tosca.hrequirements.impl.Tosca_HRequirements_ExtensionsPackageImpl;

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
public class Tosca_EPolicy_ExtensionsPackageImpl extends EPackageImpl implements Tosca_EPolicy_ExtensionsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actionTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitwiseLeftHandSideTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitwiseRightHandSideTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass documentRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass priorityTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationLeftHandSideTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationRightHandSideTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tActionParameterTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tBitwiseOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tConstraintStatusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tElasticityConstraintPropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tElasticityStrategyPropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tFulfilledConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tRelationOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tViolatedConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum tBitwiseOperationTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum tPriorityTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum tRelationOperationTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType tBitwiseOperationTypeObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType tPriorityTypeObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType tRelationOperationTypeObjectEDataType = null;

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
   * @see eu.celar.tosca.epolicies.Tosca_EPolicy_ExtensionsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Tosca_EPolicy_ExtensionsPackageImpl()
  {
    super(eNS_URI, Tosca_EPolicy_ExtensionsFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Tosca_EPolicy_ExtensionsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Tosca_EPolicy_ExtensionsPackage init()
  {
    if (isInited) return (Tosca_EPolicy_ExtensionsPackage)EPackage.Registry.INSTANCE.getEPackage(Tosca_EPolicy_ExtensionsPackage.eNS_URI);

    // Obtain or create and register package
    Tosca_EPolicy_ExtensionsPackageImpl theTosca_EPolicy_ExtensionsPackage = (Tosca_EPolicy_ExtensionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Tosca_EPolicy_ExtensionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Tosca_EPolicy_ExtensionsPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    ToscaPackage.eINSTANCE.eClass();
    XMLTypePackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    Tosca_HRequirements_ExtensionsPackageImpl theTosca_HRequirements_ExtensionsPackage = (Tosca_HRequirements_ExtensionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Tosca_HRequirements_ExtensionsPackage.eNS_URI) instanceof Tosca_HRequirements_ExtensionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Tosca_HRequirements_ExtensionsPackage.eNS_URI) : Tosca_HRequirements_ExtensionsPackage.eINSTANCE);
    Tosca_Elasticity_ExtensionsPackageImpl theTosca_Elasticity_ExtensionsPackage = (Tosca_Elasticity_ExtensionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Tosca_Elasticity_ExtensionsPackage.eNS_URI) instanceof Tosca_Elasticity_ExtensionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Tosca_Elasticity_ExtensionsPackage.eNS_URI) : Tosca_Elasticity_ExtensionsPackage.eINSTANCE);

    // Create package meta-data objects
    theTosca_EPolicy_ExtensionsPackage.createPackageContents();
    theTosca_HRequirements_ExtensionsPackage.createPackageContents();
    theTosca_Elasticity_ExtensionsPackage.createPackageContents();

    // Initialize created meta-data
    theTosca_EPolicy_ExtensionsPackage.initializePackageContents();
    theTosca_HRequirements_ExtensionsPackage.initializePackageContents();
    theTosca_Elasticity_ExtensionsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTosca_EPolicy_ExtensionsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Tosca_EPolicy_ExtensionsPackage.eNS_URI, theTosca_EPolicy_ExtensionsPackage);
    return theTosca_EPolicy_ExtensionsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActionType()
  {
    return actionTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActionType_ActionParameter()
  {
    return (EReference)actionTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActionType_ActionName()
  {
    return (EAttribute)actionTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitwiseLeftHandSideType()
  {
    return bitwiseLeftHandSideTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseLeftHandSideType_LeftSimpleCondition()
  {
    return (EReference)bitwiseLeftHandSideTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseLeftHandSideType_LeftCompexCondition()
  {
    return (EReference)bitwiseLeftHandSideTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitwiseRightHandSideType()
  {
    return bitwiseRightHandSideTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseRightHandSideType_RightSimpleCondition()
  {
    return (EReference)bitwiseRightHandSideTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseRightHandSideType_RightCompexCondition()
  {
    return (EReference)bitwiseRightHandSideTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDocumentRoot()
  {
    return documentRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDocumentRoot_Mixed()
  {
    return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_XMLNSPrefixMap()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_XSISchemaLocation()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_ElasticityConstraintProperties()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_ElasticityStrategyProperties()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPriorityType()
  {
    return priorityTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPriorityType_ConstraintId()
  {
    return (EAttribute)priorityTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPriorityType_PriorityType()
  {
    return (EAttribute)priorityTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelationLeftHandSideType()
  {
    return relationLeftHandSideTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelationLeftHandSideType_Metric()
  {
    return (EAttribute)relationLeftHandSideTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelationRightHandSideType()
  {
    return relationRightHandSideTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelationRightHandSideType_Number()
  {
    return (EAttribute)relationRightHandSideTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTActionParameterType()
  {
    return tActionParameterTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTActionParameterType_ParameterName()
  {
    return (EAttribute)tActionParameterTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTActionParameterType_ParameterValue()
  {
    return (EAttribute)tActionParameterTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTBitwiseOperation()
  {
    return tBitwiseOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTBitwiseOperation_BitwiseLeftHandSide()
  {
    return (EReference)tBitwiseOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTBitwiseOperation_BitwiseRightHandSide()
  {
    return (EReference)tBitwiseOperationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTBitwiseOperation_BitwiseOperator()
  {
    return (EAttribute)tBitwiseOperationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTConstraintStatus()
  {
    return tConstraintStatusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTConstraintStatus_Violated()
  {
    return (EReference)tConstraintStatusEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTConstraintStatus_Fulfilled()
  {
    return (EReference)tConstraintStatusEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTElasticityConstraintProperties()
  {
    return tElasticityConstraintPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTElasticityConstraintProperties_ToEnforceSimpleConstraint()
  {
    return (EReference)tElasticityConstraintPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTElasticityConstraintProperties_ToEnforceComplexConstraint()
  {
    return (EReference)tElasticityConstraintPropertiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTElasticityConstraintProperties_Priority()
  {
    return (EReference)tElasticityConstraintPropertiesEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTElasticityConstraintProperties_ConstraintId()
  {
    return (EAttribute)tElasticityConstraintPropertiesEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTElasticityStrategyProperties()
  {
    return tElasticityStrategyPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTElasticityStrategyProperties_SimpleCondition()
  {
    return (EReference)tElasticityStrategyPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTElasticityStrategyProperties_ComplexCondition()
  {
    return (EReference)tElasticityStrategyPropertiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTElasticityStrategyProperties_ConstraintBasedCondition()
  {
    return (EReference)tElasticityStrategyPropertiesEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTElasticityStrategyProperties_Action()
  {
    return (EReference)tElasticityStrategyPropertiesEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTElasticityStrategyProperties_StrategyId()
  {
    return (EAttribute)tElasticityStrategyPropertiesEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTFulfilledConstraint()
  {
    return tFulfilledConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTFulfilledConstraint_ConstraintId()
  {
    return (EAttribute)tFulfilledConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTRelationOperation()
  {
    return tRelationOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTRelationOperation_RelationLeftHandSide()
  {
    return (EReference)tRelationOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTRelationOperation_RelationRightHandSide()
  {
    return (EReference)tRelationOperationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTRelationOperation_Type()
  {
    return (EAttribute)tRelationOperationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTViolatedConstraint()
  {
    return tViolatedConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTViolatedConstraint_ConstraintId()
  {
    return (EAttribute)tViolatedConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTBitwiseOperationType()
  {
    return tBitwiseOperationTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTPriorityType()
  {
    return tPriorityTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTRelationOperationType()
  {
    return tRelationOperationTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getTBitwiseOperationTypeObject()
  {
    return tBitwiseOperationTypeObjectEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getTPriorityTypeObject()
  {
    return tPriorityTypeObjectEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getTRelationOperationTypeObject()
  {
    return tRelationOperationTypeObjectEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_EPolicy_ExtensionsFactory getTosca_EPolicy_ExtensionsFactory()
  {
    return (Tosca_EPolicy_ExtensionsFactory)getEFactoryInstance();
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
    actionTypeEClass = createEClass(ACTION_TYPE);
    createEReference(actionTypeEClass, ACTION_TYPE__ACTION_PARAMETER);
    createEAttribute(actionTypeEClass, ACTION_TYPE__ACTION_NAME);

    bitwiseLeftHandSideTypeEClass = createEClass(BITWISE_LEFT_HAND_SIDE_TYPE);
    createEReference(bitwiseLeftHandSideTypeEClass, BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_SIMPLE_CONDITION);
    createEReference(bitwiseLeftHandSideTypeEClass, BITWISE_LEFT_HAND_SIDE_TYPE__LEFT_COMPEX_CONDITION);

    bitwiseRightHandSideTypeEClass = createEClass(BITWISE_RIGHT_HAND_SIDE_TYPE);
    createEReference(bitwiseRightHandSideTypeEClass, BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_SIMPLE_CONDITION);
    createEReference(bitwiseRightHandSideTypeEClass, BITWISE_RIGHT_HAND_SIDE_TYPE__RIGHT_COMPEX_CONDITION);

    documentRootEClass = createEClass(DOCUMENT_ROOT);
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    createEReference(documentRootEClass, DOCUMENT_ROOT__ELASTICITY_CONSTRAINT_PROPERTIES);
    createEReference(documentRootEClass, DOCUMENT_ROOT__ELASTICITY_STRATEGY_PROPERTIES);

    priorityTypeEClass = createEClass(PRIORITY_TYPE);
    createEAttribute(priorityTypeEClass, PRIORITY_TYPE__CONSTRAINT_ID);
    createEAttribute(priorityTypeEClass, PRIORITY_TYPE__PRIORITY_TYPE);

    relationLeftHandSideTypeEClass = createEClass(RELATION_LEFT_HAND_SIDE_TYPE);
    createEAttribute(relationLeftHandSideTypeEClass, RELATION_LEFT_HAND_SIDE_TYPE__METRIC);

    relationRightHandSideTypeEClass = createEClass(RELATION_RIGHT_HAND_SIDE_TYPE);
    createEAttribute(relationRightHandSideTypeEClass, RELATION_RIGHT_HAND_SIDE_TYPE__NUMBER);

    tActionParameterTypeEClass = createEClass(TACTION_PARAMETER_TYPE);
    createEAttribute(tActionParameterTypeEClass, TACTION_PARAMETER_TYPE__PARAMETER_NAME);
    createEAttribute(tActionParameterTypeEClass, TACTION_PARAMETER_TYPE__PARAMETER_VALUE);

    tBitwiseOperationEClass = createEClass(TBITWISE_OPERATION);
    createEReference(tBitwiseOperationEClass, TBITWISE_OPERATION__BITWISE_LEFT_HAND_SIDE);
    createEReference(tBitwiseOperationEClass, TBITWISE_OPERATION__BITWISE_RIGHT_HAND_SIDE);
    createEAttribute(tBitwiseOperationEClass, TBITWISE_OPERATION__BITWISE_OPERATOR);

    tConstraintStatusEClass = createEClass(TCONSTRAINT_STATUS);
    createEReference(tConstraintStatusEClass, TCONSTRAINT_STATUS__VIOLATED);
    createEReference(tConstraintStatusEClass, TCONSTRAINT_STATUS__FULFILLED);

    tElasticityConstraintPropertiesEClass = createEClass(TELASTICITY_CONSTRAINT_PROPERTIES);
    createEReference(tElasticityConstraintPropertiesEClass, TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_SIMPLE_CONSTRAINT);
    createEReference(tElasticityConstraintPropertiesEClass, TELASTICITY_CONSTRAINT_PROPERTIES__TO_ENFORCE_COMPLEX_CONSTRAINT);
    createEReference(tElasticityConstraintPropertiesEClass, TELASTICITY_CONSTRAINT_PROPERTIES__PRIORITY);
    createEAttribute(tElasticityConstraintPropertiesEClass, TELASTICITY_CONSTRAINT_PROPERTIES__CONSTRAINT_ID);

    tElasticityStrategyPropertiesEClass = createEClass(TELASTICITY_STRATEGY_PROPERTIES);
    createEReference(tElasticityStrategyPropertiesEClass, TELASTICITY_STRATEGY_PROPERTIES__SIMPLE_CONDITION);
    createEReference(tElasticityStrategyPropertiesEClass, TELASTICITY_STRATEGY_PROPERTIES__COMPLEX_CONDITION);
    createEReference(tElasticityStrategyPropertiesEClass, TELASTICITY_STRATEGY_PROPERTIES__CONSTRAINT_BASED_CONDITION);
    createEReference(tElasticityStrategyPropertiesEClass, TELASTICITY_STRATEGY_PROPERTIES__ACTION);
    createEAttribute(tElasticityStrategyPropertiesEClass, TELASTICITY_STRATEGY_PROPERTIES__STRATEGY_ID);

    tFulfilledConstraintEClass = createEClass(TFULFILLED_CONSTRAINT);
    createEAttribute(tFulfilledConstraintEClass, TFULFILLED_CONSTRAINT__CONSTRAINT_ID);

    tRelationOperationEClass = createEClass(TRELATION_OPERATION);
    createEReference(tRelationOperationEClass, TRELATION_OPERATION__RELATION_LEFT_HAND_SIDE);
    createEReference(tRelationOperationEClass, TRELATION_OPERATION__RELATION_RIGHT_HAND_SIDE);
    createEAttribute(tRelationOperationEClass, TRELATION_OPERATION__TYPE);

    tViolatedConstraintEClass = createEClass(TVIOLATED_CONSTRAINT);
    createEAttribute(tViolatedConstraintEClass, TVIOLATED_CONSTRAINT__CONSTRAINT_ID);

    // Create enums
    tBitwiseOperationTypeEEnum = createEEnum(TBITWISE_OPERATION_TYPE);
    tPriorityTypeEEnum = createEEnum(TPRIORITY_TYPE);
    tRelationOperationTypeEEnum = createEEnum(TRELATION_OPERATION_TYPE);

    // Create data types
    tBitwiseOperationTypeObjectEDataType = createEDataType(TBITWISE_OPERATION_TYPE_OBJECT);
    tPriorityTypeObjectEDataType = createEDataType(TPRIORITY_TYPE_OBJECT);
    tRelationOperationTypeObjectEDataType = createEDataType(TRELATION_OPERATION_TYPE_OBJECT);
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
    initEClass(actionTypeEClass, ActionType.class, "ActionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActionType_ActionParameter(), this.getTActionParameterType(), null, "actionParameter", null, 0, -1, ActionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getActionType_ActionName(), theXMLTypePackage.getString(), "actionName", null, 1, 1, ActionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitwiseLeftHandSideTypeEClass, BitwiseLeftHandSideType.class, "BitwiseLeftHandSideType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBitwiseLeftHandSideType_LeftSimpleCondition(), this.getTRelationOperation(), null, "leftSimpleCondition", null, 0, 1, BitwiseLeftHandSideType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBitwiseLeftHandSideType_LeftCompexCondition(), this.getTBitwiseOperation(), null, "leftCompexCondition", null, 0, 1, BitwiseLeftHandSideType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitwiseRightHandSideTypeEClass, BitwiseRightHandSideType.class, "BitwiseRightHandSideType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBitwiseRightHandSideType_RightSimpleCondition(), this.getTRelationOperation(), null, "rightSimpleCondition", null, 0, 1, BitwiseRightHandSideType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBitwiseRightHandSideType_RightCompexCondition(), this.getTBitwiseOperation(), null, "rightCompexCondition", null, 0, 1, BitwiseRightHandSideType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_ElasticityConstraintProperties(), this.getTElasticityConstraintProperties(), null, "elasticityConstraintProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_ElasticityStrategyProperties(), this.getTElasticityStrategyProperties(), null, "elasticityStrategyProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    initEClass(priorityTypeEClass, PriorityType.class, "PriorityType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPriorityType_ConstraintId(), theXMLTypePackage.getString(), "constraintId", null, 1, 1, PriorityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPriorityType_PriorityType(), this.getTPriorityType(), "priorityType", null, 1, 1, PriorityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationLeftHandSideTypeEClass, RelationLeftHandSideType.class, "RelationLeftHandSideType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRelationLeftHandSideType_Metric(), theXMLTypePackage.getString(), "metric", null, 1, 1, RelationLeftHandSideType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationRightHandSideTypeEClass, RelationRightHandSideType.class, "RelationRightHandSideType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRelationRightHandSideType_Number(), theXMLTypePackage.getString(), "number", null, 1, 1, RelationRightHandSideType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tActionParameterTypeEClass, TActionParameterType.class, "TActionParameterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTActionParameterType_ParameterName(), theXMLTypePackage.getString(), "parameterName", null, 1, 1, TActionParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTActionParameterType_ParameterValue(), theXMLTypePackage.getString(), "parameterValue", null, 1, 1, TActionParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tBitwiseOperationEClass, TBitwiseOperation.class, "TBitwiseOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTBitwiseOperation_BitwiseLeftHandSide(), this.getBitwiseLeftHandSideType(), null, "bitwiseLeftHandSide", null, 0, 1, TBitwiseOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTBitwiseOperation_BitwiseRightHandSide(), this.getBitwiseRightHandSideType(), null, "bitwiseRightHandSide", null, 1, 1, TBitwiseOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTBitwiseOperation_BitwiseOperator(), this.getTBitwiseOperationType(), "bitwiseOperator", null, 1, 1, TBitwiseOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tConstraintStatusEClass, TConstraintStatus.class, "TConstraintStatus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTConstraintStatus_Violated(), this.getTViolatedConstraint(), null, "violated", null, 0, 1, TConstraintStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTConstraintStatus_Fulfilled(), this.getTFulfilledConstraint(), null, "fulfilled", null, 0, 1, TConstraintStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tElasticityConstraintPropertiesEClass, TElasticityConstraintProperties.class, "TElasticityConstraintProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTElasticityConstraintProperties_ToEnforceSimpleConstraint(), this.getTRelationOperation(), null, "toEnforceSimpleConstraint", null, 0, 1, TElasticityConstraintProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTElasticityConstraintProperties_ToEnforceComplexConstraint(), this.getTBitwiseOperation(), null, "toEnforceComplexConstraint", null, 0, 1, TElasticityConstraintProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTElasticityConstraintProperties_Priority(), this.getPriorityType(), null, "priority", null, 0, -1, TElasticityConstraintProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTElasticityConstraintProperties_ConstraintId(), theXMLTypePackage.getString(), "constraintId", null, 1, 1, TElasticityConstraintProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tElasticityStrategyPropertiesEClass, TElasticityStrategyProperties.class, "TElasticityStrategyProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTElasticityStrategyProperties_SimpleCondition(), this.getTRelationOperation(), null, "simpleCondition", null, 0, 1, TElasticityStrategyProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTElasticityStrategyProperties_ComplexCondition(), this.getTBitwiseOperation(), null, "complexCondition", null, 0, 1, TElasticityStrategyProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTElasticityStrategyProperties_ConstraintBasedCondition(), this.getTConstraintStatus(), null, "constraintBasedCondition", null, 0, 1, TElasticityStrategyProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTElasticityStrategyProperties_Action(), this.getActionType(), null, "action", null, 1, 1, TElasticityStrategyProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTElasticityStrategyProperties_StrategyId(), theXMLTypePackage.getString(), "strategyId", null, 1, 1, TElasticityStrategyProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tFulfilledConstraintEClass, TFulfilledConstraint.class, "TFulfilledConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTFulfilledConstraint_ConstraintId(), theXMLTypePackage.getString(), "constraintId", null, 1, 1, TFulfilledConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tRelationOperationEClass, TRelationOperation.class, "TRelationOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTRelationOperation_RelationLeftHandSide(), this.getRelationLeftHandSideType(), null, "relationLeftHandSide", null, 1, 1, TRelationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTRelationOperation_RelationRightHandSide(), this.getRelationRightHandSideType(), null, "relationRightHandSide", null, 1, 1, TRelationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTRelationOperation_Type(), this.getTRelationOperationType(), "type", null, 1, 1, TRelationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tViolatedConstraintEClass, TViolatedConstraint.class, "TViolatedConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTViolatedConstraint_ConstraintId(), theXMLTypePackage.getString(), "constraintId", null, 1, 1, TViolatedConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(tBitwiseOperationTypeEEnum, TBitwiseOperationType.class, "TBitwiseOperationType");
    addEEnumLiteral(tBitwiseOperationTypeEEnum, TBitwiseOperationType.AND);
    addEEnumLiteral(tBitwiseOperationTypeEEnum, TBitwiseOperationType.OR);
    addEEnumLiteral(tBitwiseOperationTypeEEnum, TBitwiseOperationType.XOR);
    addEEnumLiteral(tBitwiseOperationTypeEEnum, TBitwiseOperationType.NOT);

    initEEnum(tPriorityTypeEEnum, TPriorityType.class, "TPriorityType");
    addEEnumLiteral(tPriorityTypeEEnum, TPriorityType.LESS_THAN);
    addEEnumLiteral(tPriorityTypeEEnum, TPriorityType.GREATER_THAN);

    initEEnum(tRelationOperationTypeEEnum, TRelationOperationType.class, "TRelationOperationType");
    addEEnumLiteral(tRelationOperationTypeEEnum, TRelationOperationType.LESS_THAN);
    addEEnumLiteral(tRelationOperationTypeEEnum, TRelationOperationType.GREATER_THAN);
    addEEnumLiteral(tRelationOperationTypeEEnum, TRelationOperationType.EQUAL);
    addEEnumLiteral(tRelationOperationTypeEEnum, TRelationOperationType.NOT_EQUAL);

    // Initialize data types
    initEDataType(tBitwiseOperationTypeObjectEDataType, TBitwiseOperationType.class, "TBitwiseOperationTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
    initEDataType(tPriorityTypeObjectEDataType, TPriorityType.class, "TPriorityTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
    initEDataType(tRelationOperationTypeObjectEDataType, TRelationOperationType.class, "TRelationOperationTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

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
      (actionTypeEClass, 
       source, 
       new String[] 
       {
       "name", "Action_._type",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getActionType_ActionParameter(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "ActionParameter"
       });		
    addAnnotation
      (getActionType_ActionName(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "ActionName"
       });		
    addAnnotation
      (bitwiseLeftHandSideTypeEClass, 
       source, 
       new String[] 
       {
       "name", "BitwiseLeftHandSide_._type",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getBitwiseLeftHandSideType_LeftSimpleCondition(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "LeftSimpleCondition"
       });		
    addAnnotation
      (getBitwiseLeftHandSideType_LeftCompexCondition(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "LeftCompexCondition"
       });		
    addAnnotation
      (bitwiseRightHandSideTypeEClass, 
       source, 
       new String[] 
       {
       "name", "BitwiseRightHandSide_._type",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getBitwiseRightHandSideType_RightSimpleCondition(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "RightSimpleCondition"
       });		
    addAnnotation
      (getBitwiseRightHandSideType_RightCompexCondition(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "RightCompexCondition"
       });		
    addAnnotation
      (documentRootEClass, 
       source, 
       new String[] 
       {
       "name", "",
       "kind", "mixed"
       });		
    addAnnotation
      (getDocumentRoot_Mixed(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });		
    addAnnotation
      (getDocumentRoot_XMLNSPrefixMap(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xmlns:prefix"
       });		
    addAnnotation
      (getDocumentRoot_XSISchemaLocation(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xsi:schemaLocation"
       });		
    addAnnotation
      (getDocumentRoot_ElasticityConstraintProperties(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "ElasticityConstraintProperties",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_ElasticityStrategyProperties(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "ElasticityStrategyProperties",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (priorityTypeEClass, 
       source, 
       new String[] 
       {
       "name", "Priority_._type",
       "kind", "empty"
       });		
    addAnnotation
      (getPriorityType_ConstraintId(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "ConstraintId"
       });		
    addAnnotation
      (getPriorityType_PriorityType(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "PriorityType"
       });		
    addAnnotation
      (relationLeftHandSideTypeEClass, 
       source, 
       new String[] 
       {
       "name", "RelationLeftHandSide_._type",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getRelationLeftHandSideType_Metric(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Metric"
       });		
    addAnnotation
      (relationRightHandSideTypeEClass, 
       source, 
       new String[] 
       {
       "name", "RelationRightHandSide_._type",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getRelationRightHandSideType_Number(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Number"
       });		
    addAnnotation
      (tActionParameterTypeEClass, 
       source, 
       new String[] 
       {
       "name", "tActionParameterType",
       "kind", "empty"
       });		
    addAnnotation
      (getTActionParameterType_ParameterName(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "ParameterName"
       });		
    addAnnotation
      (getTActionParameterType_ParameterValue(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "ParameterValue"
       });		
    addAnnotation
      (tBitwiseOperationEClass, 
       source, 
       new String[] 
       {
       "name", "tBitwiseOperation",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTBitwiseOperation_BitwiseLeftHandSide(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "BitwiseLeftHandSide"
       });		
    addAnnotation
      (getTBitwiseOperation_BitwiseRightHandSide(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "BitwiseRightHandSide"
       });		
    addAnnotation
      (getTBitwiseOperation_BitwiseOperator(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "BitwiseOperator"
       });		
    addAnnotation
      (tBitwiseOperationTypeEEnum, 
       source, 
       new String[] 
       {
       "name", "tBitwiseOperationType"
       });		
    addAnnotation
      (tBitwiseOperationTypeObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "tBitwiseOperationType:Object",
       "baseType", "tBitwiseOperationType"
       });		
    addAnnotation
      (tConstraintStatusEClass, 
       source, 
       new String[] 
       {
       "name", "tConstraintStatus",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTConstraintStatus_Violated(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Violated"
       });		
    addAnnotation
      (getTConstraintStatus_Fulfilled(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Fulfilled"
       });		
    addAnnotation
      (tElasticityConstraintPropertiesEClass, 
       source, 
       new String[] 
       {
       "name", "tElasticityConstraintProperties",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTElasticityConstraintProperties_ToEnforceSimpleConstraint(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "ToEnforceSimpleConstraint"
       });		
    addAnnotation
      (getTElasticityConstraintProperties_ToEnforceComplexConstraint(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "ToEnforceComplexConstraint"
       });		
    addAnnotation
      (getTElasticityConstraintProperties_Priority(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Priority"
       });		
    addAnnotation
      (getTElasticityConstraintProperties_ConstraintId(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "ConstraintId"
       });		
    addAnnotation
      (tElasticityStrategyPropertiesEClass, 
       source, 
       new String[] 
       {
       "name", "tElasticityStrategyProperties",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTElasticityStrategyProperties_SimpleCondition(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "SimpleCondition"
       });		
    addAnnotation
      (getTElasticityStrategyProperties_ComplexCondition(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "ComplexCondition"
       });		
    addAnnotation
      (getTElasticityStrategyProperties_ConstraintBasedCondition(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "ConstraintBasedCondition"
       });		
    addAnnotation
      (getTElasticityStrategyProperties_Action(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Action"
       });		
    addAnnotation
      (getTElasticityStrategyProperties_StrategyId(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "StrategyId"
       });		
    addAnnotation
      (tFulfilledConstraintEClass, 
       source, 
       new String[] 
       {
       "name", "tFulfilledConstraint",
       "kind", "empty"
       });		
    addAnnotation
      (getTFulfilledConstraint_ConstraintId(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "ConstraintId"
       });		
    addAnnotation
      (tPriorityTypeEEnum, 
       source, 
       new String[] 
       {
       "name", "tPriorityType"
       });		
    addAnnotation
      (tPriorityTypeObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "tPriorityType:Object",
       "baseType", "tPriorityType"
       });		
    addAnnotation
      (tRelationOperationEClass, 
       source, 
       new String[] 
       {
       "name", "tRelationOperation",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTRelationOperation_RelationLeftHandSide(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "RelationLeftHandSide"
       });		
    addAnnotation
      (getTRelationOperation_RelationRightHandSide(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "RelationRightHandSide"
       });		
    addAnnotation
      (getTRelationOperation_Type(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "Type"
       });		
    addAnnotation
      (tRelationOperationTypeEEnum, 
       source, 
       new String[] 
       {
       "name", "tRelationOperationType"
       });		
    addAnnotation
      (tRelationOperationTypeObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "tRelationOperationType:Object",
       "baseType", "tRelationOperationType"
       });		
    addAnnotation
      (tViolatedConstraintEClass, 
       source, 
       new String[] 
       {
       "name", "tViolatedConstraint",
       "kind", "empty"
       });		
    addAnnotation
      (getTViolatedConstraint_ConstraintId(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "ConstraintId"
       });
  }

} //Tosca_EPolicy_ExtensionsPackageImpl
