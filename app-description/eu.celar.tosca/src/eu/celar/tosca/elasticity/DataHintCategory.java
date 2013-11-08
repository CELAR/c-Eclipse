/**
 */
package eu.celar.tosca.elasticity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Data Hint Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDataHintCategory()
 * @model extendedMetaData="name='DataHintCategory'"
 * @generated
 */
public enum DataHintCategory implements Enumerator
{
  /**
   * The '<em><b>JSON</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #JSON_VALUE
   * @generated
   * @ordered
   */
  JSON(0, "JSON", "JSON"),

  /**
   * The '<em><b>XML</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #XML_VALUE
   * @generated
   * @ordered
   */
  XML(1, "XML", "XML");

  /**
   * The '<em><b>JSON</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>JSON</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #JSON
   * @model
   * @generated
   * @ordered
   */
  public static final int JSON_VALUE = 0;

  /**
   * The '<em><b>XML</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>XML</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #XML
   * @model
   * @generated
   * @ordered
   */
  public static final int XML_VALUE = 1;

  /**
   * An array of all the '<em><b>Data Hint Category</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final DataHintCategory[] VALUES_ARRAY =
    new DataHintCategory[]
    {
      JSON,
      XML,
    };

  /**
   * A public read-only list of all the '<em><b>Data Hint Category</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<DataHintCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Data Hint Category</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DataHintCategory get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      DataHintCategory result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Data Hint Category</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DataHintCategory getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      DataHintCategory result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Data Hint Category</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DataHintCategory get(int value)
  {
    switch (value)
    {
      case JSON_VALUE: return JSON;
      case XML_VALUE: return XML;
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
  private DataHintCategory(int value, String name, String literal)
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
  
} //DataHintCategory
