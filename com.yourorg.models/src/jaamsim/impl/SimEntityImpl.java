/**
 */
package jaamsim.impl;

import jaamsim.JaamsimPackage;
import jaamsim.SimEntity;
import jaamsim.SimEntityState;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sim Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.SimEntityImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link jaamsim.impl.SimEntityImpl#getDefaultStates <em>Default States</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimEntityImpl extends DisplayEntityImpl implements SimEntity {
	/**
	 * The default value of the '{@link #getInitialState() <em>Initial State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected static final SimEntityState INITIAL_STATE_EDEFAULT = SimEntityState.IDLE;

	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected SimEntityState initialState = INITIAL_STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultStates() <em>Default States</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultStates()
	 * @generated
	 * @ordered
	 */
	protected EList<SimEntityState> defaultStates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.SIM_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimEntityState getInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitialState(SimEntityState newInitialState) {
		SimEntityState oldInitialState = initialState;
		initialState = newInitialState == null ? INITIAL_STATE_EDEFAULT : newInitialState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.SIM_ENTITY__INITIAL_STATE, oldInitialState, initialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SimEntityState> getDefaultStates() {
		if (defaultStates == null) {
			defaultStates = new EDataTypeUniqueEList<SimEntityState>(SimEntityState.class, this, JaamsimPackage.SIM_ENTITY__DEFAULT_STATES);
		}
		return defaultStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.SIM_ENTITY__INITIAL_STATE:
				return getInitialState();
			case JaamsimPackage.SIM_ENTITY__DEFAULT_STATES:
				return getDefaultStates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JaamsimPackage.SIM_ENTITY__INITIAL_STATE:
				setInitialState((SimEntityState)newValue);
				return;
			case JaamsimPackage.SIM_ENTITY__DEFAULT_STATES:
				getDefaultStates().clear();
				getDefaultStates().addAll((Collection<? extends SimEntityState>)newValue);
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
			case JaamsimPackage.SIM_ENTITY__INITIAL_STATE:
				setInitialState(INITIAL_STATE_EDEFAULT);
				return;
			case JaamsimPackage.SIM_ENTITY__DEFAULT_STATES:
				getDefaultStates().clear();
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
			case JaamsimPackage.SIM_ENTITY__INITIAL_STATE:
				return initialState != INITIAL_STATE_EDEFAULT;
			case JaamsimPackage.SIM_ENTITY__DEFAULT_STATES:
				return defaultStates != null && !defaultStates.isEmpty();
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
		result.append(" (initialState: ");
		result.append(initialState);
		result.append(", defaultStates: ");
		result.append(defaultStates);
		result.append(')');
		return result.toString();
	}

} //SimEntityImpl
