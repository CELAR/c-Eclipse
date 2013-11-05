/**
 */
package eu.celar.tosca.elasticity.util;

import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

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
public class Tosca_Elasticity_ExtensionsXMLProcessor extends XMLProcessor
{

  /**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Tosca_Elasticity_ExtensionsXMLProcessor()
  {
		super((EPackage.Registry.INSTANCE));
		Tosca_Elasticity_ExtensionsPackage.eINSTANCE.eClass();
	}
  
  /**
	 * Register for "*" and "xml" file extensions the Tosca_Elasticity_ExtensionsResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new Tosca_Elasticity_ExtensionsResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new Tosca_Elasticity_ExtensionsResourceFactoryImpl());
		}
		return registrations;
	}

} //Tosca_Elasticity_ExtensionsXMLProcessor
