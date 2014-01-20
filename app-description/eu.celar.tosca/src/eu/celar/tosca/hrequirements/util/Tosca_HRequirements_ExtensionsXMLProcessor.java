/**
 */
package eu.celar.tosca.hrequirements.util;

import eu.celar.tosca.hrequirements.Tosca_HRequirements_ExtensionsPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Tosca_HRequirements_ExtensionsXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tosca_HRequirements_ExtensionsXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    Tosca_HRequirements_ExtensionsPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the Tosca_HRequirements_ExtensionsResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
    if (registrations == null)
    {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new Tosca_HRequirements_ExtensionsResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new Tosca_HRequirements_ExtensionsResourceFactoryImpl());
    }
    return registrations;
  }

} //Tosca_HRequirements_ExtensionsXMLProcessor
