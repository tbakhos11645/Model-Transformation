/**
 */
package jaamsim.impl;

import jaamsim.Expression;
import jaamsim.JaamsimPackage;
import jaamsim.ProcessComponent;
import jaamsim.Queue;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Queue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.QueueImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link jaamsim.impl.QueueImpl#getMatch <em>Match</em>}</li>
 *   <li>{@link jaamsim.impl.QueueImpl#isFifo <em>Fifo</em>}</li>
 *   <li>{@link jaamsim.impl.QueueImpl#getRenegeTime <em>Renege Time</em>}</li>
 *   <li>{@link jaamsim.impl.QueueImpl#getRenegeCondition <em>Renege Condition</em>}</li>
 *   <li>{@link jaamsim.impl.QueueImpl#getRenegeDestination <em>Renege Destination</em>}</li>
 *   <li>{@link jaamsim.impl.QueueImpl#getMaxValidLength <em>Max Valid Length</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QueueImpl extends ProcessComponentImpl implements Queue {
	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMatch() <em>Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatch()
	 * @generated
	 * @ordered
	 */
	protected static final String MATCH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMatch() <em>Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatch()
	 * @generated
	 * @ordered
	 */
	protected String match = MATCH_EDEFAULT;

	/**
	 * The default value of the '{@link #isFifo() <em>Fifo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFifo()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FIFO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFifo() <em>Fifo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFifo()
	 * @generated
	 * @ordered
	 */
	protected boolean fifo = FIFO_EDEFAULT;

	/**
	 * The default value of the '{@link #getRenegeTime() <em>Renege Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenegeTime()
	 * @generated
	 * @ordered
	 */
	protected static final double RENEGE_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRenegeTime() <em>Renege Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenegeTime()
	 * @generated
	 * @ordered
	 */
	protected double renegeTime = RENEGE_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRenegeCondition() <em>Renege Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenegeCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression renegeCondition;

	/**
	 * The cached value of the '{@link #getRenegeDestination() <em>Renege Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenegeDestination()
	 * @generated
	 * @ordered
	 */
	protected ProcessComponent renegeDestination;

	/**
	 * The default value of the '{@link #getMaxValidLength() <em>Max Valid Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValidLength()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_VALID_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxValidLength() <em>Max Valid Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValidLength()
	 * @generated
	 * @ordered
	 */
	protected int maxValidLength = MAX_VALID_LENGTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.QUEUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.QUEUE__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMatch() {
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatch(String newMatch) {
		String oldMatch = match;
		match = newMatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.QUEUE__MATCH, oldMatch, match));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFifo() {
		return fifo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFifo(boolean newFifo) {
		boolean oldFifo = fifo;
		fifo = newFifo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.QUEUE__FIFO, oldFifo, fifo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRenegeTime() {
		return renegeTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRenegeTime(double newRenegeTime) {
		double oldRenegeTime = renegeTime;
		renegeTime = newRenegeTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.QUEUE__RENEGE_TIME, oldRenegeTime, renegeTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getRenegeCondition() {
		return renegeCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRenegeCondition(Expression newRenegeCondition, NotificationChain msgs) {
		Expression oldRenegeCondition = renegeCondition;
		renegeCondition = newRenegeCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JaamsimPackage.QUEUE__RENEGE_CONDITION, oldRenegeCondition, newRenegeCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRenegeCondition(Expression newRenegeCondition) {
		if (newRenegeCondition != renegeCondition) {
			NotificationChain msgs = null;
			if (renegeCondition != null)
				msgs = ((InternalEObject)renegeCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.QUEUE__RENEGE_CONDITION, null, msgs);
			if (newRenegeCondition != null)
				msgs = ((InternalEObject)newRenegeCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.QUEUE__RENEGE_CONDITION, null, msgs);
			msgs = basicSetRenegeCondition(newRenegeCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.QUEUE__RENEGE_CONDITION, newRenegeCondition, newRenegeCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessComponent getRenegeDestination() {
		if (renegeDestination != null && renegeDestination.eIsProxy()) {
			InternalEObject oldRenegeDestination = (InternalEObject)renegeDestination;
			renegeDestination = (ProcessComponent)eResolveProxy(oldRenegeDestination);
			if (renegeDestination != oldRenegeDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JaamsimPackage.QUEUE__RENEGE_DESTINATION, oldRenegeDestination, renegeDestination));
			}
		}
		return renegeDestination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessComponent basicGetRenegeDestination() {
		return renegeDestination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRenegeDestination(ProcessComponent newRenegeDestination) {
		ProcessComponent oldRenegeDestination = renegeDestination;
		renegeDestination = newRenegeDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.QUEUE__RENEGE_DESTINATION, oldRenegeDestination, renegeDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMaxValidLength() {
		return maxValidLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxValidLength(int newMaxValidLength) {
		int oldMaxValidLength = maxValidLength;
		maxValidLength = newMaxValidLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.QUEUE__MAX_VALID_LENGTH, oldMaxValidLength, maxValidLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JaamsimPackage.QUEUE__RENEGE_CONDITION:
				return basicSetRenegeCondition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.QUEUE__PRIORITY:
				return getPriority();
			case JaamsimPackage.QUEUE__MATCH:
				return getMatch();
			case JaamsimPackage.QUEUE__FIFO:
				return isFifo();
			case JaamsimPackage.QUEUE__RENEGE_TIME:
				return getRenegeTime();
			case JaamsimPackage.QUEUE__RENEGE_CONDITION:
				return getRenegeCondition();
			case JaamsimPackage.QUEUE__RENEGE_DESTINATION:
				if (resolve) return getRenegeDestination();
				return basicGetRenegeDestination();
			case JaamsimPackage.QUEUE__MAX_VALID_LENGTH:
				return getMaxValidLength();
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
			case JaamsimPackage.QUEUE__PRIORITY:
				setPriority((Integer)newValue);
				return;
			case JaamsimPackage.QUEUE__MATCH:
				setMatch((String)newValue);
				return;
			case JaamsimPackage.QUEUE__FIFO:
				setFifo((Boolean)newValue);
				return;
			case JaamsimPackage.QUEUE__RENEGE_TIME:
				setRenegeTime((Double)newValue);
				return;
			case JaamsimPackage.QUEUE__RENEGE_CONDITION:
				setRenegeCondition((Expression)newValue);
				return;
			case JaamsimPackage.QUEUE__RENEGE_DESTINATION:
				setRenegeDestination((ProcessComponent)newValue);
				return;
			case JaamsimPackage.QUEUE__MAX_VALID_LENGTH:
				setMaxValidLength((Integer)newValue);
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
			case JaamsimPackage.QUEUE__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case JaamsimPackage.QUEUE__MATCH:
				setMatch(MATCH_EDEFAULT);
				return;
			case JaamsimPackage.QUEUE__FIFO:
				setFifo(FIFO_EDEFAULT);
				return;
			case JaamsimPackage.QUEUE__RENEGE_TIME:
				setRenegeTime(RENEGE_TIME_EDEFAULT);
				return;
			case JaamsimPackage.QUEUE__RENEGE_CONDITION:
				setRenegeCondition((Expression)null);
				return;
			case JaamsimPackage.QUEUE__RENEGE_DESTINATION:
				setRenegeDestination((ProcessComponent)null);
				return;
			case JaamsimPackage.QUEUE__MAX_VALID_LENGTH:
				setMaxValidLength(MAX_VALID_LENGTH_EDEFAULT);
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
			case JaamsimPackage.QUEUE__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case JaamsimPackage.QUEUE__MATCH:
				return MATCH_EDEFAULT == null ? match != null : !MATCH_EDEFAULT.equals(match);
			case JaamsimPackage.QUEUE__FIFO:
				return fifo != FIFO_EDEFAULT;
			case JaamsimPackage.QUEUE__RENEGE_TIME:
				return renegeTime != RENEGE_TIME_EDEFAULT;
			case JaamsimPackage.QUEUE__RENEGE_CONDITION:
				return renegeCondition != null;
			case JaamsimPackage.QUEUE__RENEGE_DESTINATION:
				return renegeDestination != null;
			case JaamsimPackage.QUEUE__MAX_VALID_LENGTH:
				return maxValidLength != MAX_VALID_LENGTH_EDEFAULT;
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
		result.append(" (priority: ");
		result.append(priority);
		result.append(", match: ");
		result.append(match);
		result.append(", fifo: ");
		result.append(fifo);
		result.append(", renegeTime: ");
		result.append(renegeTime);
		result.append(", maxValidLength: ");
		result.append(maxValidLength);
		result.append(')');
		return result.toString();
	}

} //QueueImpl
