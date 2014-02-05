/**
 */
package eu.celar.infosystem.model.base.util;

import eu.celar.infosystem.model.base.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.celar.infosystem.model.base.InfoSystemPackage
 * @generated
 */
public class InfoSystemAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static InfoSystemPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfoSystemAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = InfoSystemPackage.eINSTANCE;
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
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
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
  protected InfoSystemSwitch<Adapter> modelSwitch =
    new InfoSystemSwitch<Adapter>()
    {
      @Override
      public Adapter caseMonitoringProbe(MonitoringProbe object)
      {
        return createMonitoringProbeAdapter();
      }
      @Override
      public Adapter caseResizingAction(ResizingAction object)
      {
        return createResizingActionAdapter();
      }
      @Override
      public Adapter caseSoftwareDependency(SoftwareDependency object)
      {
        return createSoftwareDependencyAdapter();
      }
      @Override
      public Adapter caseVirtualMachineImage(VirtualMachineImage object)
      {
        return createVirtualMachineImageAdapter();
      }
      @Override
      public Adapter caseUserApplication(UserApplication object)
      {
        return createUserApplicationAdapter();
      }
      @Override
      public Adapter caseKeyPair(KeyPair object)
      {
        return createKeyPairAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
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
   * Creates a new adapter for an object of class '{@link eu.celar.infosystem.model.base.MonitoringProbe <em>Monitoring Probe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.infosystem.model.base.MonitoringProbe
   * @generated
   */
  public Adapter createMonitoringProbeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.infosystem.model.base.ResizingAction <em>Resizing Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.infosystem.model.base.ResizingAction
   * @generated
   */
  public Adapter createResizingActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.infosystem.model.base.SoftwareDependency <em>Software Dependency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.infosystem.model.base.SoftwareDependency
   * @generated
   */
  public Adapter createSoftwareDependencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.infosystem.model.base.VirtualMachineImage <em>Virtual Machine Image</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.infosystem.model.base.VirtualMachineImage
   * @generated
   */
  public Adapter createVirtualMachineImageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.infosystem.model.base.UserApplication <em>User Application</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.infosystem.model.base.UserApplication
   * @generated
   */
  public Adapter createUserApplicationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.celar.infosystem.model.base.KeyPair <em>Key Pair</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.celar.infosystem.model.base.KeyPair
   * @generated
   */
  public Adapter createKeyPairAdapter()
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

} //InfoSystemAdapterFactory
