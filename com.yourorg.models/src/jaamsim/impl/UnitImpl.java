/**
 */
package jaamsim.impl;

import jaamsim.JaamsimPackage;
import jaamsim.Unit;
import jaamsim.UnitType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.UnitImpl#getName <em>Name</em>}</li>
 *   <li>{@link jaamsim.impl.UnitImpl#getType <em>Type</em>}</li>
 *   <li>{@link jaamsim.impl.UnitImpl#getConversionFactorToSI <em>Conversion Factor To SI</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnitImpl extends MinimalEObjectImpl.Container implements Unit {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final UnitType TYPE_EDEFAULT = UnitType.TIME;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected UnitType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConversionFactorToSI() <em>Conversion Factor To SI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConversionFactorToSI()
	 * @generated
	 * @ordered
	 */
	protected static final double CONVERSION_FACTOR_TO_SI_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getConversionFactorToSI() <em>Conversion Factor To SI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConversionFactorToSI()
	 * @generated
	 * @ordered
	 */
	protected double conversionFactorToSI = CONVERSION_FACTOR_TO_SI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.UNIT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnitType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(UnitType newType) {
		UnitType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.UNIT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getConversionFactorToSI() {
		return conversionFactorToSI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConversionFactorToSI(double newConversionFactorToSI) {
		double oldConversionFactorToSI = conversionFactorToSI;
		conversionFactorToSI = newConversionFactorToSI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.UNIT__CONVERSION_FACTOR_TO_SI, oldConversionFactorToSI, conversionFactorToSI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.UNIT__NAME:
				return getName();
			case JaamsimPackage.UNIT__TYPE:
				return getType();
			case JaamsimPackage.UNIT__CONVERSION_FACTOR_TO_SI:
				return getConversionFactorToSI();
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
		switch (featureID) {
			case JaamsimPackage.UNIT__NAME:
				setName((String)newValue);
				return;
			case JaamsimPackage.UNIT__TYPE:
				setType((UnitType)newValue);
				return;
			case JaamsimPackage.UNIT__CONVERSION_FACTOR_TO_SI:
				setConversionFactorToSI((Double)newValue);
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
		switch (featureID) {
			case JaamsimPackage.UNIT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JaamsimPackage.UNIT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case JaamsimPackage.UNIT__CONVERSION_FACTOR_TO_SI:
				setConversionFactorToSI(CONVERSION_FACTOR_TO_SI_EDEFAULT);
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
		switch (featureID) {
			case JaamsimPackage.UNIT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JaamsimPackage.UNIT__TYPE:
				return type != TYPE_EDEFAULT;
			case JaamsimPackage.UNIT__CONVERSION_FACTOR_TO_SI:
				return conversionFactorToSI != CONVERSION_FACTOR_TO_SI_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", conversionFactorToSI: ");
		result.append(conversionFactorToSI);
		result.append(')');
		return result.toString();
	}

} //UnitImpl
