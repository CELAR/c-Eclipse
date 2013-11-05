/**
 */
package eu.celar.tosca.elasticity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Elasticity Requirement Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getElasticityRequirementCategory()
 * @model extendedMetaData="name='ElasticityRequirementCategory'"
 * @generated
 */
public enum ElasticityRequirementCategory implements Enumerator
{
  /**
	 * The '<em><b>Cost</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #COST_VALUE
	 * @generated
	 * @ordered
	 */
  COST(0, "Cost", "Cost"),

  /**
	 * The '<em><b>Throughput</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #THROUGHPUT_VALUE
	 * @generated
	 * @ordered
	 */
  THROUGHPUT(1, "Throughput", "Throughput"),

  /**
	 * The '<em><b>Latency</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LATENCY_VALUE
	 * @generated
	 * @ordered
	 */
  LATENCY(2, "Latency", "Latency"),

  /**
	 * The '<em><b>Response Time</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RESPONSE_TIME_VALUE
	 * @generated
	 * @ordered
	 */
  RESPONSE_TIME(3, "ResponseTime", "ResponseTime"),

  /**
	 * The '<em><b>Bandwidth</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #BANDWIDTH_VALUE
	 * @generated
	 * @ordered
	 */
  BANDWIDTH(4, "Bandwidth", "Bandwidth");

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
  public static final int COST_VALUE = 0;

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
  public static final int THROUGHPUT_VALUE = 1;

  /**
	 * The '<em><b>Latency</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Latency</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LATENCY
	 * @model name="Latency"
	 * @generated
	 * @ordered
	 */
  public static final int LATENCY_VALUE = 2;

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
  public static final int RESPONSE_TIME_VALUE = 3;

  /**
	 * The '<em><b>Bandwidth</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Bandwidth</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #BANDWIDTH
	 * @model name="Bandwidth"
	 * @generated
	 * @ordered
	 */
  public static final int BANDWIDTH_VALUE = 4;

  /**
	 * An array of all the '<em><b>Elasticity Requirement Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final ElasticityRequirementCategory[] VALUES_ARRAY =
    new ElasticityRequirementCategory[] {
			COST,
			THROUGHPUT,
			LATENCY,
			RESPONSE_TIME,
			BANDWIDTH,
		};

  /**
	 * A public read-only list of all the '<em><b>Elasticity Requirement Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<ElasticityRequirementCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Elasticity Requirement Category</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ElasticityRequirementCategory get(String literal)
  {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ElasticityRequirementCategory result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Elasticity Requirement Category</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ElasticityRequirementCategory getByName(String name)
  {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ElasticityRequirementCategory result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Elasticity Requirement Category</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ElasticityRequirementCategory get(int value)
  {
		switch (value) {
			case COST_VALUE: return COST;
			case THROUGHPUT_VALUE: return THROUGHPUT;
			case LATENCY_VALUE: return LATENCY;
			case RESPONSE_TIME_VALUE: return RESPONSE_TIME;
			case BANDWIDTH_VALUE: return BANDWIDTH;
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
  private ElasticityRequirementCategory(int value, String name, String literal)
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
  
} //ElasticityRequirementCategory
