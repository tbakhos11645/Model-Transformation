/**
 */
package jaamsim.impl;

import jaamsim.Component;
import jaamsim.JaamsimPackage;
import jaamsim.LinkedComponent;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linked Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.LinkedComponentImpl#getNextComponent <em>Next Component</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LinkedComponentImpl extends ComponentImpl implements LinkedComponent {
	/**
	 * The cached value of the '{@link #getNextComponent() <em>Next Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextComponent()
	 * @generated
	 * @ordered
	 */
	protected Component nextComponent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkedComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.LINKED_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Component getNextComponent() {
		if (nextComponent != null && nextComponent.eIsProxy()) {
			InternalEObject oldNextComponent = (InternalEObject)nextComponent;
			nextComponent = (Component)eResolveProxy(oldNextComponent);
			if (nextComponent != oldNextComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JaamsimPackage.LINKED_COMPONENT__NEXT_COMPONENT, oldNextComponent, nextComponent));
			}
		}
		return nextComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetNextComponent() {
		return nextComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNextComponent(Component newNextComponent) {
		Component oldNextComponent = nextComponent;
		nextComponent = newNextComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.LINKED_COMPONENT__NEXT_COMPONENT, oldNextComponent, nextComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.LINKED_COMPONENT__NEXT_COMPONENT:
				if (resolve) return getNextComponent();
				return basicGetNextComponent();
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
			case JaamsimPackage.LINKED_COMPONENT__NEXT_COMPONENT:
				setNextComponent((Component)newValue);
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
			case JaamsimPackage.LINKED_COMPONENT__NEXT_COMPONENT:
				setNextComponent((Component)null);
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
			case JaamsimPackage.LINKED_COMPONENT__NEXT_COMPONENT:
				return nextComponent != null;
		}
		return super.eIsSet(featureID);
	}

} //LinkedComponentImpl
