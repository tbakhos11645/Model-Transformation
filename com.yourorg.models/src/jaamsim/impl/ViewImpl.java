/**
 */
package jaamsim.impl;

import jaamsim.JaamsimPackage;
import jaamsim.Point3D;
import jaamsim.View;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.ViewImpl#getCameraPosition <em>Camera Position</em>}</li>
 *   <li>{@link jaamsim.impl.ViewImpl#getCameraTarget <em>Camera Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewImpl extends EntityImpl implements View {
	/**
	 * The cached value of the '{@link #getCameraPosition() <em>Camera Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCameraPosition()
	 * @generated
	 * @ordered
	 */
	protected Point3D cameraPosition;

	/**
	 * The cached value of the '{@link #getCameraTarget() <em>Camera Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCameraTarget()
	 * @generated
	 * @ordered
	 */
	protected Point3D cameraTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Point3D getCameraPosition() {
		return cameraPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCameraPosition(Point3D newCameraPosition, NotificationChain msgs) {
		Point3D oldCameraPosition = cameraPosition;
		cameraPosition = newCameraPosition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JaamsimPackage.VIEW__CAMERA_POSITION, oldCameraPosition, newCameraPosition);
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
	public void setCameraPosition(Point3D newCameraPosition) {
		if (newCameraPosition != cameraPosition) {
			NotificationChain msgs = null;
			if (cameraPosition != null)
				msgs = ((InternalEObject)cameraPosition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.VIEW__CAMERA_POSITION, null, msgs);
			if (newCameraPosition != null)
				msgs = ((InternalEObject)newCameraPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.VIEW__CAMERA_POSITION, null, msgs);
			msgs = basicSetCameraPosition(newCameraPosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.VIEW__CAMERA_POSITION, newCameraPosition, newCameraPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Point3D getCameraTarget() {
		return cameraTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCameraTarget(Point3D newCameraTarget, NotificationChain msgs) {
		Point3D oldCameraTarget = cameraTarget;
		cameraTarget = newCameraTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JaamsimPackage.VIEW__CAMERA_TARGET, oldCameraTarget, newCameraTarget);
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
	public void setCameraTarget(Point3D newCameraTarget) {
		if (newCameraTarget != cameraTarget) {
			NotificationChain msgs = null;
			if (cameraTarget != null)
				msgs = ((InternalEObject)cameraTarget).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.VIEW__CAMERA_TARGET, null, msgs);
			if (newCameraTarget != null)
				msgs = ((InternalEObject)newCameraTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.VIEW__CAMERA_TARGET, null, msgs);
			msgs = basicSetCameraTarget(newCameraTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.VIEW__CAMERA_TARGET, newCameraTarget, newCameraTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JaamsimPackage.VIEW__CAMERA_POSITION:
				return basicSetCameraPosition(null, msgs);
			case JaamsimPackage.VIEW__CAMERA_TARGET:
				return basicSetCameraTarget(null, msgs);
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
			case JaamsimPackage.VIEW__CAMERA_POSITION:
				return getCameraPosition();
			case JaamsimPackage.VIEW__CAMERA_TARGET:
				return getCameraTarget();
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
			case JaamsimPackage.VIEW__CAMERA_POSITION:
				setCameraPosition((Point3D)newValue);
				return;
			case JaamsimPackage.VIEW__CAMERA_TARGET:
				setCameraTarget((Point3D)newValue);
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
			case JaamsimPackage.VIEW__CAMERA_POSITION:
				setCameraPosition((Point3D)null);
				return;
			case JaamsimPackage.VIEW__CAMERA_TARGET:
				setCameraTarget((Point3D)null);
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
			case JaamsimPackage.VIEW__CAMERA_POSITION:
				return cameraPosition != null;
			case JaamsimPackage.VIEW__CAMERA_TARGET:
				return cameraTarget != null;
		}
		return super.eIsSet(featureID);
	}

} //ViewImpl
