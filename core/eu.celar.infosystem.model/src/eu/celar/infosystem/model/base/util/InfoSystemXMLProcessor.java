/**
 */
package eu.celar.infosystem.model.base.util;

import eu.celar.infosystem.model.base.InfoSystemPackage;

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
public class InfoSystemXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfoSystemXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    InfoSystemPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the InfoSystemResourceFactoryImpl factory.
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
      registrations.put(XML_EXTENSION, new InfoSystemResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new InfoSystemResourceFactoryImpl());
    }
    return registrations;
  }

} //InfoSystemXMLProcessor
