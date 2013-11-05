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
	 * The '<em><b>Response Time</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RESPONSE_TIME_VALUE
	 * @generated
	 * @ordered
	 */
  RESPONSE_TIME(0, "ResponseTime", "ResponseTime"),

  /**
	 * The '<em><b>Cost</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #COST_VALUE
	 * @generated
	 * @ordered
	 */
  COST(1, "Cost", "Cost"),

  /**
	 * The '<em><b>Throughput</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #THROUGHPUT_VALUE
	 * @generated
	 * @ordered
	 */
  THROUGHPUT(2, "Throughput", "Throughput");

  /**
	 * The '<em><b>Response Time</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Response Time</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #RESPONSE_TIME
	 * @model name="ResponseTime"
	 * @generated
	 * @ordered
	 */
  public static final int RESPONSE_TIME_VALUE = 0;

  /**
	 * The '<em><b>Cost</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Cost</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #COST
	 * @model name="Cost"
	 * @generated
	 * @ordered
	 */
  public static final int COST_VALUE = 1;

  /**
	 * The '<em><b>Throughput</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Throughput</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #THROUGHPUT
	 * @model name="Throughput"
	 * @generated
	 * @ordered
	 */
  public static final int THROUGHPUT_VALUE = 2;

  /**
	 * An array of all the '<em><b>Application Component Elasticity Requirement Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final ApplicationComponentElasticityRequirementCategory[] VALUES_ARRAY =
    new ApplicationComponentElasticityRequirementCategory[] {
			RESPONSE_TIME,
			COST,
			THROUGHPUT,
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
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ApplicationComponentElasticityRequirementCategory result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
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
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ApplicationComponentElasticityRequirementCategory result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
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
		switch (value) {
			case RESPONSE_TIME_VALUE: return RESPONSE_TIME;
			case COST_VALUE: return COST;
			case THROUGHPUT_VALUE: return THROUGHPUT;
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
