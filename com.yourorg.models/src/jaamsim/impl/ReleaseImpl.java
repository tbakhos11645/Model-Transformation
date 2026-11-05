/**
 */
package jaamsim.impl;

import jaamsim.JaamsimPackage;
import jaamsim.Release;
import jaamsim.ResourceUnit;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Release</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.ReleaseImpl#getReleasedUnits <em>Released Units</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReleaseImpl extends ProcessComponentImpl implements Release {
	/**
	 * The cached value of the '{@link #getReleasedUnits() <em>Released Units</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleasedUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceUnit> releasedUnits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReleaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.RELEASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ResourceUnit> getReleasedUnits() {
		if (releasedUnits == null) {
			releasedUnits = new EObjectResolvingEList<ResourceUnit>(ResourceUnit.class, this, JaamsimPackage.RELEASE__RELEASED_UNITS);
		}
		return releasedUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.RELEASE__RELEASED_UNITS:
				return getReleasedUnits();
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
			case JaamsimPackage.RELEASE__RELEASED_UNITS:
				getReleasedUnits().clear();
				getReleasedUnits().addAll((Collection<? extends ResourceUnit>)newValue);
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
			case JaamsimPackage.RELEASE__RELEASED_UNITS:
				getReleasedUnits().clear();
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
			case JaamsimPackage.RELEASE__RELEASED_UNITS:
				return releasedUnits != null && !releasedUnits.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ReleaseImpl
