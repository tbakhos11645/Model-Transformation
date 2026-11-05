/**
 */
package jaamsim.impl;

import jaamsim.EntityGenerator;
import jaamsim.JaamsimPackage;
import jaamsim.SimEntity;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.EntityGeneratorImpl#getFirstArrivalTime <em>First Arrival Time</em>}</li>
 *   <li>{@link jaamsim.impl.EntityGeneratorImpl#getInterArrivalTime <em>Inter Arrival Time</em>}</li>
 *   <li>{@link jaamsim.impl.EntityGeneratorImpl#getEntitiesPerArrival <em>Entities Per Arrival</em>}</li>
 *   <li>{@link jaamsim.impl.EntityGeneratorImpl#getMaxNumber <em>Max Number</em>}</li>
 *   <li>{@link jaamsim.impl.EntityGeneratorImpl#getPrototype <em>Prototype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityGeneratorImpl extends ProcessComponentImpl implements EntityGenerator {
	/**
	 * The default value of the '{@link #getFirstArrivalTime() <em>First Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected static final double FIRST_ARRIVAL_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFirstArrivalTime() <em>First Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected double firstArrivalTime = FIRST_ARRIVAL_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterArrivalTime() <em>Inter Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected static final double INTER_ARRIVAL_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInterArrivalTime() <em>Inter Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected double interArrivalTime = INTER_ARRIVAL_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEntitiesPerArrival() <em>Entities Per Arrival</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntitiesPerArrival()
	 * @generated
	 * @ordered
	 */
	protected static final int ENTITIES_PER_ARRIVAL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEntitiesPerArrival() <em>Entities Per Arrival</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntitiesPerArrival()
	 * @generated
	 * @ordered
	 */
	protected int entitiesPerArrival = ENTITIES_PER_ARRIVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxNumber() <em>Max Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxNumber() <em>Max Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNumber()
	 * @generated
	 * @ordered
	 */
	protected int maxNumber = MAX_NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrototype() <em>Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrototype()
	 * @generated
	 * @ordered
	 */
	protected SimEntity prototype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.ENTITY_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFirstArrivalTime() {
		return firstArrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstArrivalTime(double newFirstArrivalTime) {
		double oldFirstArrivalTime = firstArrivalTime;
		firstArrivalTime = newFirstArrivalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY_GENERATOR__FIRST_ARRIVAL_TIME, oldFirstArrivalTime, firstArrivalTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getInterArrivalTime() {
		return interArrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterArrivalTime(double newInterArrivalTime) {
		double oldInterArrivalTime = interArrivalTime;
		interArrivalTime = newInterArrivalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY_GENERATOR__INTER_ARRIVAL_TIME, oldInterArrivalTime, interArrivalTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getEntitiesPerArrival() {
		return entitiesPerArrival;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEntitiesPerArrival(int newEntitiesPerArrival) {
		int oldEntitiesPerArrival = entitiesPerArrival;
		entitiesPerArrival = newEntitiesPerArrival;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY_GENERATOR__ENTITIES_PER_ARRIVAL, oldEntitiesPerArrival, entitiesPerArrival));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMaxNumber() {
		return maxNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxNumber(int newMaxNumber) {
		int oldMaxNumber = maxNumber;
		maxNumber = newMaxNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY_GENERATOR__MAX_NUMBER, oldMaxNumber, maxNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimEntity getPrototype() {
		if (prototype != null && prototype.eIsProxy()) {
			InternalEObject oldPrototype = (InternalEObject)prototype;
			prototype = (SimEntity)eResolveProxy(oldPrototype);
			if (prototype != oldPrototype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JaamsimPackage.ENTITY_GENERATOR__PROTOTYPE, oldPrototype, prototype));
			}
		}
		return prototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimEntity basicGetPrototype() {
		return prototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrototype(SimEntity newPrototype) {
		SimEntity oldPrototype = prototype;
		prototype = newPrototype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY_GENERATOR__PROTOTYPE, oldPrototype, prototype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.ENTITY_GENERATOR__FIRST_ARRIVAL_TIME:
				return getFirstArrivalTime();
			case JaamsimPackage.ENTITY_GENERATOR__INTER_ARRIVAL_TIME:
				return getInterArrivalTime();
			case JaamsimPackage.ENTITY_GENERATOR__ENTITIES_PER_ARRIVAL:
				return getEntitiesPerArrival();
			case JaamsimPackage.ENTITY_GENERATOR__MAX_NUMBER:
				return getMaxNumber();
			case JaamsimPackage.ENTITY_GENERATOR__PROTOTYPE:
				if (resolve) return getPrototype();
				return basicGetPrototype();
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
			case JaamsimPackage.ENTITY_GENERATOR__FIRST_ARRIVAL_TIME:
				setFirstArrivalTime((Double)newValue);
				return;
			case JaamsimPackage.ENTITY_GENERATOR__INTER_ARRIVAL_TIME:
				setInterArrivalTime((Double)newValue);
				return;
			case JaamsimPackage.ENTITY_GENERATOR__ENTITIES_PER_ARRIVAL:
				setEntitiesPerArrival((Integer)newValue);
				return;
			case JaamsimPackage.ENTITY_GENERATOR__MAX_NUMBER:
				setMaxNumber((Integer)newValue);
				return;
			case JaamsimPackage.ENTITY_GENERATOR__PROTOTYPE:
				setPrototype((SimEntity)newValue);
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
			case JaamsimPackage.ENTITY_GENERATOR__FIRST_ARRIVAL_TIME:
				setFirstArrivalTime(FIRST_ARRIVAL_TIME_EDEFAULT);
				return;
			case JaamsimPackage.ENTITY_GENERATOR__INTER_ARRIVAL_TIME:
				setInterArrivalTime(INTER_ARRIVAL_TIME_EDEFAULT);
				return;
			case JaamsimPackage.ENTITY_GENERATOR__ENTITIES_PER_ARRIVAL:
				setEntitiesPerArrival(ENTITIES_PER_ARRIVAL_EDEFAULT);
				return;
			case JaamsimPackage.ENTITY_GENERATOR__MAX_NUMBER:
				setMaxNumber(MAX_NUMBER_EDEFAULT);
				return;
			case JaamsimPackage.ENTITY_GENERATOR__PROTOTYPE:
				setPrototype((SimEntity)null);
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
			case JaamsimPackage.ENTITY_GENERATOR__FIRST_ARRIVAL_TIME:
				return firstArrivalTime != FIRST_ARRIVAL_TIME_EDEFAULT;
			case JaamsimPackage.ENTITY_GENERATOR__INTER_ARRIVAL_TIME:
				return interArrivalTime != INTER_ARRIVAL_TIME_EDEFAULT;
			case JaamsimPackage.ENTITY_GENERATOR__ENTITIES_PER_ARRIVAL:
				return entitiesPerArrival != ENTITIES_PER_ARRIVAL_EDEFAULT;
			case JaamsimPackage.ENTITY_GENERATOR__MAX_NUMBER:
				return maxNumber != MAX_NUMBER_EDEFAULT;
			case JaamsimPackage.ENTITY_GENERATOR__PROTOTYPE:
				return prototype != null;
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
		result.append(" (firstArrivalTime: ");
		result.append(firstArrivalTime);
		result.append(", interArrivalTime: ");
		result.append(interArrivalTime);
		result.append(", entitiesPerArrival: ");
		result.append(entitiesPerArrival);
		result.append(", maxNumber: ");
		result.append(maxNumber);
		result.append(')');
		return result.toString();
	}

} //EntityGeneratorImpl
