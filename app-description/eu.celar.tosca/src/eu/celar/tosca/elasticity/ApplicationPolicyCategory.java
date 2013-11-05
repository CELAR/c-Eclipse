/**
 */
package eu.celar.tosca.elasticity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Application Policy Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getApplicationPolicyCategory()
 * @model extendedMetaData="name='ApplicationPolicyCategory'"
 * @generated
 */
public enum ApplicationPolicyCategory implements Enumerator
{
  /**
	 * The '<em><b>Minimize Cost</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MINIMIZE_COST_VALUE
	 * @generated
	 * @ordered
	 */
  MINIMIZE_COST(0, "MinimizeCost", "Minimize Cost"),

  /**
	 * The '<em><b>Maximize Throughput</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MAXIMIZE_THROUGHPUT_VALUE
	 * @generated
	 * @ordered
	 */
  MAXIMIZE_THROUGHPUT(1, "MaximizeThroughput", "Maximize Throughput");

  /**
	 * The '<em><b>Minimize Cost</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Minimize Cost</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MINIMIZE_COST
	 * @model name="MinimizeCost" literal="Minimize Cost"
	 * @generated
	 * @ordered
	 */
  public static final int MINIMIZE_COST_VALUE = 0;

  /**
	 * The '<em><b>Maximize Throughput</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Maximize Throughput</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MAXIMIZE_THROUGHPUT
	 * @model name="MaximizeThroughput" literal="Maximize Throughput"
	 * @generated
	 * @ordered
	 */
  public static final int MAXIMIZE_THROUGHPUT_VALUE = 1;

  /**
	 * An array of all the '<em><b>Application Policy Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final ApplicationPolicyCategory[] VALUES_ARRAY =
    new ApplicationPolicyCategory[] {
			MINIMIZE_COST,
			MAXIMIZE_THROUGHPUT,
		};

  /**
	 * A public read-only list of all the '<em><b>Application Policy Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<ApplicationPolicyCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Application Policy Category</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ApplicationPolicyCategory get(String literal)
  {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ApplicationPolicyCategory result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Application Policy Category</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ApplicationPolicyCategory getByName(String name)
  {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ApplicationPolicyCategory result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Application Policy Category</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ApplicationPolicyCategory get(int value)
  {
		switch (value) {
			case MINIMIZE_COST_VALUE: return MINIMIZE_COST;
			case MAXIMIZE_THROUGHPUT_VALUE: return MAXIMIZE_THROUGHPUT;
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
  private ApplicationPolicyCategory(int value, String name, String literal)
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
  
} //ApplicationPolicyCategory
