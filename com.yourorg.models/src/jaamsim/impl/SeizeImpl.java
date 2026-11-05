/**
 */
package jaamsim.impl;

import jaamsim.JaamsimPackage;
import jaamsim.ResourceUnit;
import jaamsim.Seize;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Seize</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.SeizeImpl#getRequiredUnits <em>Required Units</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SeizeImpl extends ProcessComponentImpl implements Seize {
	/**
	 * The cached value of the '{@link #getRequiredUnits() <em>Required Units</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceUnit> requiredUnits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeizeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.SEIZE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ResourceUnit> getRequiredUnits() {
		if (requiredUnits == null) {
			requiredUnits = new EObjectResolvingEList<ResourceUnit>(ResourceUnit.class, this, JaamsimPackage.SEIZE__REQUIRED_UNITS);
		}
		return requiredUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.SEIZE__REQUIRED_UNITS:
				return getRequiredUnits();
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
			case JaamsimPackage.SEIZE__REQUIRED_UNITS:
				getRequiredUnits().clear();
				getRequiredUnits().addAll((Collection<? extends ResourceUnit>)newValue);
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
			case JaamsimPackage.SEIZE__REQUIRED_UNITS:
				getRequiredUnits().clear();
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
			case JaamsimPackage.SEIZE__REQUIRED_UNITS:
				return requiredUnits != null && !requiredUnits.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SeizeImpl
