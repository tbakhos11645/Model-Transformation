/**
 */
package jaamsim.impl;

import jaamsim.JaamsimPackage;
import jaamsim.Queue;
import jaamsim.Server;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.ServerImpl#getServiceTime <em>Service Time</em>}</li>
 *   <li>{@link jaamsim.impl.ServerImpl#getWaitQueue <em>Wait Queue</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServerImpl extends ProcessComponentImpl implements Server {
	/**
	 * The default value of the '{@link #getServiceTime() <em>Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceTime()
	 * @generated
	 * @ordered
	 */
	protected static final double SERVICE_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getServiceTime() <em>Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceTime()
	 * @generated
	 * @ordered
	 */
	protected double serviceTime = SERVICE_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWaitQueue() <em>Wait Queue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitQueue()
	 * @generated
	 * @ordered
	 */
	protected Queue waitQueue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.SERVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getServiceTime() {
		return serviceTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setServiceTime(double newServiceTime) {
		double oldServiceTime = serviceTime;
		serviceTime = newServiceTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.SERVER__SERVICE_TIME, oldServiceTime, serviceTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Queue getWaitQueue() {
		if (waitQueue != null && waitQueue.eIsProxy()) {
			InternalEObject oldWaitQueue = (InternalEObject)waitQueue;
			waitQueue = (Queue)eResolveProxy(oldWaitQueue);
			if (waitQueue != oldWaitQueue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JaamsimPackage.SERVER__WAIT_QUEUE, oldWaitQueue, waitQueue));
			}
		}
		return waitQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Queue basicGetWaitQueue() {
		return waitQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWaitQueue(Queue newWaitQueue) {
		Queue oldWaitQueue = waitQueue;
		waitQueue = newWaitQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.SERVER__WAIT_QUEUE, oldWaitQueue, waitQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.SERVER__SERVICE_TIME:
				return getServiceTime();
			case JaamsimPackage.SERVER__WAIT_QUEUE:
				if (resolve) return getWaitQueue();
				return basicGetWaitQueue();
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
			case JaamsimPackage.SERVER__SERVICE_TIME:
				setServiceTime((Double)newValue);
				return;
			case JaamsimPackage.SERVER__WAIT_QUEUE:
				setWaitQueue((Queue)newValue);
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
			case JaamsimPackage.SERVER__SERVICE_TIME:
				setServiceTime(SERVICE_TIME_EDEFAULT);
				return;
			case JaamsimPackage.SERVER__WAIT_QUEUE:
				setWaitQueue((Queue)null);
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
			case JaamsimPackage.SERVER__SERVICE_TIME:
				return serviceTime != SERVICE_TIME_EDEFAULT;
			case JaamsimPackage.SERVER__WAIT_QUEUE:
				return waitQueue != null;
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
		result.append(" (serviceTime: ");
		result.append(serviceTime);
		result.append(')');
		return result.toString();
	}

} //ServerImpl
