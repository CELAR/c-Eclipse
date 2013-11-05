/**
 */
package eu.celar.tosca.elasticity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Load Hint Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getLoadHintCategory()
 * @model extendedMetaData="name='LoadHintCategory'"
 * @generated
 */
public enum LoadHintCategory implements Enumerator
{
  /**
	 * The '<em><b>Read Heavy</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #READ_HEAVY_VALUE
	 * @generated
	 * @ordered
	 */
  READ_HEAVY(0, "ReadHeavy", "Read Heavy"),

  /**
	 * The '<em><b>Write Heavy</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WRITE_HEAVY_VALUE
	 * @generated
	 * @ordered
	 */
  WRITE_HEAVY(1, "WriteHeavy", "Write Heavy");

  /**
	 * The '<em><b>Read Heavy</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Read Heavy</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #READ_HEAVY
	 * @model name="ReadHeavy" literal="Read Heavy"
	 * @generated
	 * @ordered
	 */
  public static final int READ_HEAVY_VALUE = 0;

  /**
	 * The '<em><b>Write Heavy</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Write Heavy</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WRITE_HEAVY
	 * @model name="WriteHeavy" literal="Write Heavy"
	 * @generated
	 * @ordered
	 */
  public static final int WRITE_HEAVY_VALUE = 1;

  /**
	 * An array of all the '<em><b>Load Hint Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final LoadHintCategory[] VALUES_ARRAY =
    new LoadHintCategory[] {
			READ_HEAVY,
			WRITE_HEAVY,
		};

  /**
	 * A public read-only list of all the '<em><b>Load Hint Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<LoadHintCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Load Hint Category</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static LoadHintCategory get(String literal)
  {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LoadHintCategory result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Load Hint Category</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static LoadHintCategory getByName(String name)
  {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LoadHintCategory result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Load Hint Category</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static LoadHintCategory get(int value)
  {
		switch (value) {
			case READ_HEAVY_VALUE: return READ_HEAVY;
			case WRITE_HEAVY_VALUE: return WRITE_HEAVY;
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
  private LoadHintCategory(int value, String name, String literal)
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
  
} //LoadHintCategory
