/**
 */
package eu.celar.tosca.elasticity.util;

import eu.celar.tosca.TBoundaryDefinitions;
import eu.celar.tosca.TEntityTemplate;
import eu.celar.tosca.TExtensibleElements;

import eu.celar.tosca.TNodeTemplate;
import eu.celar.tosca.elasticity.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage
 * @generated
 */
public class Tosca_Elasticity_ExtensionsAdapterFactory extends AdapterFactoryImpl
{
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static Tosca_Elasticity_ExtensionsPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Tosca_Elasticity_ExtensionsAdapterFactory()
  {
		if (modelPackage == null) {
			modelPackage = Tosca_Elasticity_ExtensionsPackage.eINSTANCE;
		}
	}

  /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object object)
  {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

  /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected Tosca_Elasticity_ExtensionsSwitch<Adapter> modelSwitch =
    new Tosca_Elasticity_ExtensionsSwitch<Adapter>() {
			@Override
			public Adapter caseDataHintsType1(DataHintsType1 object) {
				return createDataHintsType1Adapter();
			}
			@Override
			public Adapter caseLoadHintsType1(LoadHintsType1 object) {
				return createLoadHintsType1Adapter();
			}
			@Override
			public Adapter caseMonitoringProbesType1(MonitoringProbesType1 object) {
				return createMonitoringProbesType1Adapter();
			}
			@Override
			public Adapter caseTBoundaryDefinitionsExtension(TBoundaryDefinitionsExtension object) {
				return createTBoundaryDefinitionsExtensionAdapter();
			}
			@Override
			public Adapter caseTDataHint(TDataHint object) {
				return createTDataHintAdapter();
			}
			@Override
			public Adapter caseTLoadHint(TLoadHint object) {
				return createTLoadHintAdapter();
			}
			@Override
			public Adapter caseTMonitoringProbe(TMonitoringProbe object) {
				return createTMonitoringProbeAdapter();
			}
			@Override
			public Adapter caseTNodeTemplateExtension(TNodeTemplateExtension object) {
				return createTNodeTemplateExtensionAdapter();
			}
			@Override
			public Adapter caseTBoundaryDefinitions(TBoundaryDefinitions object) {
				return createTBoundaryDefinitionsAdapter();
			}
			@Override
			public Adapter caseTExtensibleElements(TExtensibleElements object) {
				return createTExtensibleElementsAdapter();
			}
			@Override
			public Adapter caseTEntityTemplate(TEntityTemplate object) {
				return createTEntityTemplateAdapter();
			}
			@Override
			public Adapter caseTNodeTemplate(TNodeTemplate object) {
				return createTNodeTemplateAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

  /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
  @Override
  public Adapter createAdapter(Notifier target)
  {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.elasticity.DataHintsType1 <em>Data Hints Type1</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.elasticity.DataHintsType1
	 * @generated
	 */
  public Adapter createDataHintsType1Adapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.elasticity.LoadHintsType1 <em>Load Hints Type1</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.elasticity.LoadHintsType1
	 * @generated
	 */
  public Adapter createLoadHintsType1Adapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.elasticity.MonitoringProbesType1 <em>Monitoring Probes Type1</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.elasticity.MonitoringProbesType1
	 * @generated
	 */
  public Adapter createMonitoringProbesType1Adapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension <em>TBoundary Definitions Extension</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.elasticity.TBoundaryDefinitionsExtension
	 * @generated
	 */
  public Adapter createTBoundaryDefinitionsExtensionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.elasticity.TDataHint <em>TData Hint</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.elasticity.TDataHint
	 * @generated
	 */
  public Adapter createTDataHintAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.elasticity.TLoadHint <em>TLoad Hint</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.elasticity.TLoadHint
	 * @generated
	 */
  public Adapter createTLoadHintAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.elasticity.TMonitoringProbe <em>TMonitoring Probe</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.elasticity.TMonitoringProbe
	 * @generated
	 */
  public Adapter createTMonitoringProbeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.elasticity.TNodeTemplateExtension <em>TNode Template Extension</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.elasticity.TNodeTemplateExtension
	 * @generated
	 */
  public Adapter createTNodeTemplateExtensionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.TBoundaryDefinitions <em>TBoundary Definitions</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.TBoundaryDefinitions
	 * @generated
	 */
  public Adapter createTBoundaryDefinitionsAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.TExtensibleElements <em>TExtensible Elements</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.TExtensibleElements
	 * @generated
	 */
  public Adapter createTExtensibleElementsAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.TEntityTemplate <em>TEntity Template</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.TEntityTemplate
	 * @generated
	 */
  public Adapter createTEntityTemplateAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link eu.celar.tosca.TNodeTemplate <em>TNode Template</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.celar.tosca.TNodeTemplate
	 * @generated
	 */
  public Adapter createTNodeTemplateAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
  public Adapter createEObjectAdapter()
  {
		return null;
	}

} //Tosca_Elasticity_ExtensionsAdapterFactory
