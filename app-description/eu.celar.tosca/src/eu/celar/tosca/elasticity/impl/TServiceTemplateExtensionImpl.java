/**
 */
package eu.celar.tosca.elasticity.impl;

import eu.celar.tosca.elasticity.TServiceTemplateExtension;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

import eu.celar.tosca.impl.TServiceTemplateImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TService Template Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TServiceTemplateExtensionImpl#getX <em>X</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TServiceTemplateExtensionImpl#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TServiceTemplateExtensionImpl extends TServiceTemplateImpl implements TServiceTemplateExtension
{
  /**
   * An array of objects representing the values of non-primitive features.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Object[] eVirtualValues;

  /**
   * A bit field representing the indices of non-primitive feature values.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected int eVirtualIndexBits0;

  /**
   * The default value of the '{@link #getX() <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX()
   * @generated
   * @ordered
   */
  protected static final int X_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getX() <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX()
   * @generated
   * @ordered
   */
  protected int x = X_EDEFAULT;

  /**
   * This is true if the X attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean xESet;

  /**
   * The default value of the '{@link #getY() <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY()
   * @generated
   * @ordered
   */
  protected static final int Y_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY()
   * @generated
   * @ordered
   */
  protected int y = Y_EDEFAULT;

  /**
   * This is true if the Y attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean yESet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TServiceTemplateExtensionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return Tosca_Elasticity_ExtensionsPackage.Literals.TSERVICE_TEMPLATE_EXTENSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getX()
  {
    return x;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX(int newX)
  {
    int oldX = x;
    x = newX;
    boolean oldXESet = xESet;
    xESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__X, oldX, x, !oldXESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetX()
  {
    int oldX = x;
    boolean oldXESet = xESet;
    x = X_EDEFAULT;
    xESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__X, oldX, X_EDEFAULT, oldXESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetX()
  {
    return xESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getY()
  {
    return y;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setY(int newY)
  {
    int oldY = y;
    y = newY;
    boolean oldYESet = yESet;
    yESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__Y, oldY, y, !oldYESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetY()
  {
    int oldY = y;
    boolean oldYESet = yESet;
    y = Y_EDEFAULT;
    yESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__Y, oldY, Y_EDEFAULT, oldYESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetY()
  {
    return yESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__X:
        return getX();
      case Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__Y:
        return getY();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__X:
        setX((Integer)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__Y:
        setY((Integer)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__X:
        unsetX();
        return;
      case Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__Y:
        unsetY();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__X:
        return isSetX();
      case Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION__Y:
        return isSetY();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Object[] eVirtualValues()
  {
    return eVirtualValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void eSetVirtualValues(Object[] newValues)
  {
    eVirtualValues = newValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected int eVirtualIndexBits(int offset)
  {
    switch (offset)
    {
      case 0 :
        return eVirtualIndexBits0;
      default :
        throw new IndexOutOfBoundsException();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void eSetVirtualIndexBits(int offset, int newIndexBits)
  {
    switch (offset)
    {
      case 0 :
        eVirtualIndexBits0 = newIndexBits;
        break;
      default :
        throw new IndexOutOfBoundsException();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (x: ");
    if (xESet) result.append(x); else result.append("<unset>");
    result.append(", y: ");
    if (yESet) result.append(y); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //TServiceTemplateExtensionImpl
