/**
 */
package jaamsim.impl;

import jaamsim.JaamsimPackage;
import jaamsim.Simulation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.SimulationImpl#getRunDuration <em>Run Duration</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationImpl#getInitializationDuration <em>Initialization Duration</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationImpl#isExitAtStop <em>Exit At Stop</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationImpl#getGlobalSubstreamSeed <em>Global Substream Seed</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimulationImpl extends MinimalEObjectImpl.Container implements Simulation {
	/**
	 * The default value of the '{@link #getRunDuration() <em>Run Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunDuration()
	 * @generated
	 * @ordered
	 */
	protected static final double RUN_DURATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRunDuration() <em>Run Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunDuration()
	 * @generated
	 * @ordered
	 */
	protected double runDuration = RUN_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitializationDuration() <em>Initialization Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializationDuration()
	 * @generated
	 * @ordered
	 */
	protected static final double INITIALIZATION_DURATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInitializationDuration() <em>Initialization Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializationDuration()
	 * @generated
	 * @ordered
	 */
	protected double initializationDuration = INITIALIZATION_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isExitAtStop() <em>Exit At Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExitAtStop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXIT_AT_STOP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExitAtStop() <em>Exit At Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExitAtStop()
	 * @generated
	 * @ordered
	 */
	protected boolean exitAtStop = EXIT_AT_STOP_EDEFAULT;

	/**
	 * The default value of the '{@link #getGlobalSubstreamSeed() <em>Global Substream Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalSubstreamSeed()
	 * @generated
	 * @ordered
	 */
	protected static final int GLOBAL_SUBSTREAM_SEED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getGlobalSubstreamSeed() <em>Global Substream Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalSubstreamSeed()
	 * @generated
	 * @ordered
	 */
	protected int globalSubstreamSeed = GLOBAL_SUBSTREAM_SEED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.SIMULATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRunDuration() {
		return runDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRunDuration(double newRunDuration) {
		double oldRunDuration = runDuration;
		runDuration = newRunDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.SIMULATION__RUN_DURATION, oldRunDuration, runDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getInitializationDuration() {
		return initializationDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitializationDuration(double newInitializationDuration) {
		double oldInitializationDuration = initializationDuration;
		initializationDuration = newInitializationDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.SIMULATION__INITIALIZATION_DURATION, oldInitializationDuration, initializationDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isExitAtStop() {
		return exitAtStop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExitAtStop(boolean newExitAtStop) {
		boolean oldExitAtStop = exitAtStop;
		exitAtStop = newExitAtStop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.SIMULATION__EXIT_AT_STOP, oldExitAtStop, exitAtStop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getGlobalSubstreamSeed() {
		return globalSubstreamSeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGlobalSubstreamSeed(int newGlobalSubstreamSeed) {
		int oldGlobalSubstreamSeed = globalSubstreamSeed;
		globalSubstreamSeed = newGlobalSubstreamSeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.SIMULATION__GLOBAL_SUBSTREAM_SEED, oldGlobalSubstreamSeed, globalSubstreamSeed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.SIMULATION__RUN_DURATION:
				return getRunDuration();
			case JaamsimPackage.SIMULATION__INITIALIZATION_DURATION:
				return getInitializationDuration();
			case JaamsimPackage.SIMULATION__EXIT_AT_STOP:
				return isExitAtStop();
			case JaamsimPackage.SIMULATION__GLOBAL_SUBSTREAM_SEED:
				return getGlobalSubstreamSeed();
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
			case JaamsimPackage.SIMULATION__RUN_DURATION:
				setRunDuration((Double)newValue);
				return;
			case JaamsimPackage.SIMULATION__INITIALIZATION_DURATION:
				setInitializationDuration((Double)newValue);
				return;
			case JaamsimPackage.SIMULATION__EXIT_AT_STOP:
				setExitAtStop((Boolean)newValue);
				return;
			case JaamsimPackage.SIMULATION__GLOBAL_SUBSTREAM_SEED:
				setGlobalSubstreamSeed((Integer)newValue);
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
			case JaamsimPackage.SIMULATION__RUN_DURATION:
				setRunDuration(RUN_DURATION_EDEFAULT);
				return;
			case JaamsimPackage.SIMULATION__INITIALIZATION_DURATION:
				setInitializationDuration(INITIALIZATION_DURATION_EDEFAULT);
				return;
			case JaamsimPackage.SIMULATION__EXIT_AT_STOP:
				setExitAtStop(EXIT_AT_STOP_EDEFAULT);
				return;
			case JaamsimPackage.SIMULATION__GLOBAL_SUBSTREAM_SEED:
				setGlobalSubstreamSeed(GLOBAL_SUBSTREAM_SEED_EDEFAULT);
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
			case JaamsimPackage.SIMULATION__RUN_DURATION:
				return runDuration != RUN_DURATION_EDEFAULT;
			case JaamsimPackage.SIMULATION__INITIALIZATION_DURATION:
				return initializationDuration != INITIALIZATION_DURATION_EDEFAULT;
			case JaamsimPackage.SIMULATION__EXIT_AT_STOP:
				return exitAtStop != EXIT_AT_STOP_EDEFAULT;
			case JaamsimPackage.SIMULATION__GLOBAL_SUBSTREAM_SEED:
				return globalSubstreamSeed != GLOBAL_SUBSTREAM_SEED_EDEFAULT;
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
		result.append(" (runDuration: ");
		result.append(runDuration);
		result.append(", initializationDuration: ");
		result.append(initializationDuration);
		result.append(", exitAtStop: ");
		result.append(exitAtStop);
		result.append(", globalSubstreamSeed: ");
		result.append(globalSubstreamSeed);
		result.append(')');
		return result.toString();
	}

} //SimulationImpl
