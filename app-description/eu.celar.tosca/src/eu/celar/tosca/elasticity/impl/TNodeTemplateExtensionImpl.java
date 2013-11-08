/**
 */
package eu.celar.tosca.elasticity.impl;

import eu.celar.tosca.elasticity.TNodeTemplateExtension;
import eu.celar.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;

import eu.celar.tosca.impl.TNodeTemplateImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TNode Template Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getCasmulti <em>Casmulti</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getInitInstances <em>Init Instances</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getX <em>X</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getY <em>Y</em>}</li>
 *   <li>{@link eu.celar.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getYcsbmulti <em>Ycsbmulti</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TNodeTemplateExtensionImpl extends TNodeTemplateImpl implements TNodeTemplateExtension
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
   * The default value of the '{@link #getCasmulti() <em>Casmulti</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getCasmulti()
   * @generated
   * @ordered
   */
	protected static final int CASMULTI_EDEFAULT = 0;

		/**
   * The cached value of the '{@link #getCasmulti() <em>Casmulti</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getCasmulti()
   * @generated
   * @ordered
   */
	protected int casmulti = CASMULTI_EDEFAULT;

		/**
   * This is true if the Casmulti attribute has been set.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	protected boolean casmultiESet;

		/**
   * The default value of the '{@link #getInitInstances() <em>Init Instances</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getInitInstances()
   * @generated
   * @ordered
   */
	protected static final int INIT_INSTANCES_EDEFAULT = 0;

		/**
   * The cached value of the '{@link #getInitInstances() <em>Init Instances</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getInitInstances()
   * @generated
   * @ordered
   */
	protected int initInstances = INIT_INSTANCES_EDEFAULT;

		/**
   * This is true if the Init Instances attribute has been set.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	protected boolean initInstancesESet;

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
   * The default value of the '{@link #getYcsbmulti() <em>Ycsbmulti</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getYcsbmulti()
   * @generated
   * @ordered
   */
	protected static final int YCSBMULTI_EDEFAULT = 0;

		/**
   * The cached value of the '{@link #getYcsbmulti() <em>Ycsbmulti</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getYcsbmulti()
   * @generated
   * @ordered
   */
	protected int ycsbmulti = YCSBMULTI_EDEFAULT;

		/**
   * This is true if the Ycsbmulti attribute has been set.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	protected boolean ycsbmultiESet;

		/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TNodeTemplateExtensionImpl()
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
    return Tosca_Elasticity_ExtensionsPackage.Literals.TNODE_TEMPLATE_EXTENSION;
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public int getCasmulti() {
    return casmulti;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setCasmulti(int newCasmulti) {
    int oldCasmulti = casmulti;
    casmulti = newCasmulti;
    boolean oldCasmultiESet = casmultiESet;
    casmultiESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__CASMULTI, oldCasmulti, casmulti, !oldCasmultiESet));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void unsetCasmulti() {
    int oldCasmulti = casmulti;
    boolean oldCasmultiESet = casmultiESet;
    casmulti = CASMULTI_EDEFAULT;
    casmultiESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__CASMULTI, oldCasmulti, CASMULTI_EDEFAULT, oldCasmultiESet));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public boolean isSetCasmulti() {
    return casmultiESet;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public int getInitInstances() {
    return initInstances;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setInitInstances(int newInitInstances) {
    int oldInitInstances = initInstances;
    initInstances = newInitInstances;
    boolean oldInitInstancesESet = initInstancesESet;
    initInstancesESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES, oldInitInstances, initInstances, !oldInitInstancesESet));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void unsetInitInstances() {
    int oldInitInstances = initInstances;
    boolean oldInitInstancesESet = initInstancesESet;
    initInstances = INIT_INSTANCES_EDEFAULT;
    initInstancesESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES, oldInitInstances, INIT_INSTANCES_EDEFAULT, oldInitInstancesESet));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public boolean isSetInitInstances() {
    return initInstancesESet;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public int getX() {
    return x;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setX(int newX) {
    int oldX = x;
    x = newX;
    boolean oldXESet = xESet;
    xESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X, oldX, x, !oldXESet));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void unsetX() {
    int oldX = x;
    boolean oldXESet = xESet;
    x = X_EDEFAULT;
    xESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X, oldX, X_EDEFAULT, oldXESet));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public boolean isSetX() {
    return xESet;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public int getY() {
    return y;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setY(int newY) {
    int oldY = y;
    y = newY;
    boolean oldYESet = yESet;
    yESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y, oldY, y, !oldYESet));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void unsetY() {
    int oldY = y;
    boolean oldYESet = yESet;
    y = Y_EDEFAULT;
    yESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y, oldY, Y_EDEFAULT, oldYESet));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public boolean isSetY() {
    return yESet;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public int getYcsbmulti() {
    return ycsbmulti;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setYcsbmulti(int newYcsbmulti) {
    int oldYcsbmulti = ycsbmulti;
    ycsbmulti = newYcsbmulti;
    boolean oldYcsbmultiESet = ycsbmultiESet;
    ycsbmultiESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__YCSBMULTI, oldYcsbmulti, ycsbmulti, !oldYcsbmultiESet));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void unsetYcsbmulti() {
    int oldYcsbmulti = ycsbmulti;
    boolean oldYcsbmultiESet = ycsbmultiESet;
    ycsbmulti = YCSBMULTI_EDEFAULT;
    ycsbmultiESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__YCSBMULTI, oldYcsbmulti, YCSBMULTI_EDEFAULT, oldYcsbmultiESet));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public boolean isSetYcsbmulti() {
    return ycsbmultiESet;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__CASMULTI:
        return getCasmulti();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES:
        return getInitInstances();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X:
        return getX();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y:
        return getY();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__YCSBMULTI:
        return getYcsbmulti();
    }
    return super.eGet(featureID, resolve, coreType);
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__CASMULTI:
        setCasmulti((Integer)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES:
        setInitInstances((Integer)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X:
        setX((Integer)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y:
        setY((Integer)newValue);
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__YCSBMULTI:
        setYcsbmulti((Integer)newValue);
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
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__CASMULTI:
        unsetCasmulti();
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES:
        unsetInitInstances();
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X:
        unsetX();
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y:
        unsetY();
        return;
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__YCSBMULTI:
        unsetYcsbmulti();
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
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__CASMULTI:
        return isSetCasmulti();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES:
        return isSetInitInstances();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X:
        return isSetX();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y:
        return isSetY();
      case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__YCSBMULTI:
        return isSetYcsbmulti();
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
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (casmulti: ");
    if (casmultiESet) result.append(casmulti); else result.append("<unset>");
    result.append(", initInstances: ");
    if (initInstancesESet) result.append(initInstances); else result.append("<unset>");
    result.append(", x: ");
    if (xESet) result.append(x); else result.append("<unset>");
    result.append(", y: ");
    if (yESet) result.append(y); else result.append("<unset>");
    result.append(", ycsbmulti: ");
    if (ycsbmultiESet) result.append(ycsbmulti); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //TNodeTemplateExtensionImpl
