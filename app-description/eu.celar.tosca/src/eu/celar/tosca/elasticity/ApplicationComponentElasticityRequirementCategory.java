/**
 */
package eu.celar.tosca.elasticity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Application Component Elasticity Requirement Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getApplicationComponentElasticityRequirementCategory()
 * @model extendedMetaData="name='ApplicationComponentElasticityRequirementCategory'"
 * @generated
 */
public enum ApplicationComponentElasticityRequirementCategory implements Enumerator
{
  /**
   * The '<em><b>Minimum Response Time</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MINIMUM_RESPONSE_TIME_VALUE
   * @generated
   * @ordered
   */
  MINIMUM_RESPONSE_TIME(0, "MinimumResponseTime", "Minimum Response Time"),

  /**
   * The '<em><b>Minimun Cost</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MINIMUN_COST_VALUE
   * @generated
   * @ordered
   */
  MINIMUN_COST(1, "MinimunCost", "Minimun Cost"),

  /**
   * The '<em><b>Maximum Cost</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MAXIMUM_COST_VALUE
   * @generated
   * @ordered
   */
  MAXIMUM_COST(2, "MaximumCost", "Maximum Cost");

  /**
   * The '<em><b>Minimum Response Time</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Minimum Response Time</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MINIMUM_RESPONSE_TIME
   * @model name="MinimumResponseTime" literal="Minimum Response Time"
   * @generated
   * @ordered
   */
  public static final int MINIMUM_RESPONSE_TIME_VALUE = 0;

  /**
   * The '<em><b>Minimun Cost</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Minimun Cost</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MINIMUN_COST
   * @model name="MinimunCost" literal="Minimun Cost"
   * @generated
   * @ordered
   */
  public static final int MINIMUN_COST_VALUE = 1;

  /**
   * The '<em><b>Maximum Cost</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Maximum Cost</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MAXIMUM_COST
   * @model name="MaximumCost" literal="Maximum Cost"
   * @generated
   * @ordered
   */
  public static final int MAXIMUM_COST_VALUE = 2;

  /**
   * An array of all the '<em><b>Application Component Elasticity Requirement Category</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ApplicationComponentElasticityRequirementCategory[] VALUES_ARRAY =
    new ApplicationComponentElasticityRequirementCategory[]
    {
      MINIMUM_RESPONSE_TIME,
      MINIMUN_COST,
      MAXIMUM_COST,
    };

  /**
   * A public read-only list of all the '<em><b>Application Component Elasticity Requirement Category</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ApplicationComponentElasticityRequirementCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Application Component Elasticity Requirement Category</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ApplicationComponentElasticityRequirementCategory get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ApplicationComponentElasticityRequirementCategory result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Application Component Elasticity Requirement Category</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ApplicationComponentElasticityRequirementCategory getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ApplicationComponentElasticityRequirementCategory result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Application Component Elasticity Requirement Category</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ApplicationComponentElasticityRequirementCategory get(int value)
  {
    switch (value)
    {
      case MINIMUM_RESPONSE_TIME_VALUE: return MINIMUM_RESPONSE_TIME;
      case MINIMUN_COST_VALUE: return MINIMUN_COST;
      case MAXIMUM_COST_VALUE: return MAXIMUM_COST;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private ApplicationComponentElasticityRequirementCategory(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //ApplicationComponentElasticityRequirementCategory
