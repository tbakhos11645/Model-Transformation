/**
 */
package jaamsim.impl;

import jaamsim.JaamsimPackage;
import jaamsim.ResourceUnit;
import jaamsim.SimEntity;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.ResourceUnitImpl#isAvailable <em>Available</em>}</li>
 *   <li>{@link jaamsim.impl.ResourceUnitImpl#getAssignedTo <em>Assigned To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceUnitImpl extends DisplayEntityImpl implements ResourceUnit {
	/**
	 * The default value of the '{@link #isAvailable() <em>Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAvailable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AVAILABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAvailable() <em>Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAvailable()
	 * @generated
	 * @ordered
	 */
	protected boolean available = AVAILABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAssignedTo() <em>Assigned To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignedTo()
	 * @generated
	 * @ordered
	 */
	protected SimEntity assignedTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.RESOURCE_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAvailable() {
		return available;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAvailable(boolean newAvailable) {
		boolean oldAvailable = available;
		available = newAvailable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.RESOURCE_UNIT__AVAILABLE, oldAvailable, available));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimEntity getAssignedTo() {
		if (assignedTo != null && assignedTo.eIsProxy()) {
			InternalEObject oldAssignedTo = (InternalEObject)assignedTo;
			assignedTo = (SimEntity)eResolveProxy(oldAssignedTo);
			if (assignedTo != oldAssignedTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JaamsimPackage.RESOURCE_UNIT__ASSIGNED_TO, oldAssignedTo, assignedTo));
			}
		}
		return assignedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimEntity basicGetAssignedTo() {
		return assignedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssignedTo(SimEntity newAssignedTo) {
		SimEntity oldAssignedTo = assignedTo;
		assignedTo = newAssignedTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.RESOURCE_UNIT__ASSIGNED_TO, oldAssignedTo, assignedTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.RESOURCE_UNIT__AVAILABLE:
				return isAvailable();
			case JaamsimPackage.RESOURCE_UNIT__ASSIGNED_TO:
				if (resolve) return getAssignedTo();
				return basicGetAssignedTo();
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
			case JaamsimPackage.RESOURCE_UNIT__AVAILABLE:
				setAvailable((Boolean)newValue);
				return;
			case JaamsimPackage.RESOURCE_UNIT__ASSIGNED_TO:
				setAssignedTo((SimEntity)newValue);
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
			case JaamsimPackage.RESOURCE_UNIT__AVAILABLE:
				setAvailable(AVAILABLE_EDEFAULT);
				return;
			case JaamsimPackage.RESOURCE_UNIT__ASSIGNED_TO:
				setAssignedTo((SimEntity)null);
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
			case JaamsimPackage.RESOURCE_UNIT__AVAILABLE:
				return available != AVAILABLE_EDEFAULT;
			case JaamsimPackage.RESOURCE_UNIT__ASSIGNED_TO:
				return assignedTo != null;
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
		result.append(" (available: ");
		result.append(available);
		result.append(')');
		return result.toString();
	}

} //ResourceUnitImpl
