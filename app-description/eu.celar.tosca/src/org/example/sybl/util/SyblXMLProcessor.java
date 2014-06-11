/**
 */
package org.example.sybl.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.example.sybl.SyblPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SyblXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SyblXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    SyblPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the SyblResourceFactoryImpl factory.
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
      registrations.put(XML_EXTENSION, new SyblResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new SyblResourceFactoryImpl());
    }
    return registrations;
  }

} //SyblXMLProcessor
