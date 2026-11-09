/**
 */
package jaamsim.impl;

import jaamsim.Branch;
import jaamsim.Distribution;
import org.eclipse.emf.ecore.InternalEObject;
import jaamsim.JaamsimPackage;

import jaamsim.ProcessComponent;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.BranchImpl#getNextComponentList <em>Next Component List</em>}</li>
 *   <li>{@link jaamsim.impl.BranchImpl#getChoice <em>Choice</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BranchImpl extends ProcessComponentImpl implements Branch {
	/**
	 * The cached value of the '{@link #getNextComponentList() <em>Next Component List</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextComponentList()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessComponent> nextComponentList;
	/**
	 * The default value of the '{@link #getChoice() <em>Choice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoice()
	 * @generated
	 * @ordered
	 */
	protected static final String CHOICE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getChoice() <em>Choice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoice()
	 * @generated
	 * @ordered
	 */
	protected String choice = CHOICE_EDEFAULT;
	protected Distribution choiceDistribution;

	@Override
	public Distribution getChoiceDistribution() {
		if (choiceDistribution != null && choiceDistribution.eIsProxy()) {
			InternalEObject old = (InternalEObject)choiceDistribution;
			choiceDistribution = (Distribution)eResolveProxy(old);
			if (choiceDistribution != old && eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					JaamsimPackage.BRANCH__CHOICE_DISTRIBUTION, old, choiceDistribution));
		}
		return choiceDistribution;
	}

	@Override
	public void setChoiceDistribution(Distribution value) {
		Distribution old = choiceDistribution;
		choiceDistribution = value;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				JaamsimPackage.BRANCH__CHOICE_DISTRIBUTION, old, value));
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.BRANCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ProcessComponent> getNextComponentList() {
		if (nextComponentList == null) {
			nextComponentList = new EObjectResolvingEList<ProcessComponent>(ProcessComponent.class, this, JaamsimPackage.BRANCH__NEXT_COMPONENT_LIST);
		}
		return nextComponentList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getChoice() {
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setChoice(String newChoice) {
		String oldChoice = choice;
		choice = newChoice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.BRANCH__CHOICE, oldChoice, choice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.BRANCH__NEXT_COMPONENT_LIST:
				return getNextComponentList();
			case JaamsimPackage.BRANCH__CHOICE:
				return getChoice();
			case JaamsimPackage.BRANCH__CHOICE_DISTRIBUTION:
				return resolve ? getChoiceDistribution() : choiceDistribution;
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
			case JaamsimPackage.BRANCH__NEXT_COMPONENT_LIST:
				getNextComponentList().clear();
				getNextComponentList().addAll((Collection<? extends ProcessComponent>)newValue);
				return;
			case JaamsimPackage.BRANCH__CHOICE:
				setChoice((String)newValue);
				return;
			case JaamsimPackage.BRANCH__CHOICE_DISTRIBUTION:
				setChoiceDistribution((Distribution)newValue);
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
			case JaamsimPackage.BRANCH__NEXT_COMPONENT_LIST:
				getNextComponentList().clear();
				return;
			case JaamsimPackage.BRANCH__CHOICE:
				setChoice(CHOICE_EDEFAULT);
				return;
			case JaamsimPackage.BRANCH__CHOICE_DISTRIBUTION:
				setChoiceDistribution(null);
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
			case JaamsimPackage.BRANCH__NEXT_COMPONENT_LIST:
				return nextComponentList != null && !nextComponentList.isEmpty();
			case JaamsimPackage.BRANCH__CHOICE:
				return CHOICE_EDEFAULT == null ? choice != null : !CHOICE_EDEFAULT.equals(choice);
			case JaamsimPackage.BRANCH__CHOICE_DISTRIBUTION:
				return choiceDistribution != null;
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
		result.append(" (choice: ");
		result.append(choice);
		result.append(')');
		return result.toString();
	}

} //BranchImpl
