/**
 */
package jaamsim;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sim Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.SimEntity#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link jaamsim.SimEntity#getDefaultStates <em>Default States</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getSimEntity()
 * @model
 * @generated
 */
public interface SimEntity extends DisplayEntity {
	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' attribute.
	 * The literals are from the enumeration {@link jaamsim.SimEntityState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' attribute.
	 * @see jaamsim.SimEntityState
	 * @see #setInitialState(SimEntityState)
	 * @see jaamsim.JaamsimPackage#getSimEntity_InitialState()
	 * @model
	 * @generated
	 */
	SimEntityState getInitialState();

	/**
	 * Sets the value of the '{@link jaamsim.SimEntity#getInitialState <em>Initial State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' attribute.
	 * @see jaamsim.SimEntityState
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(SimEntityState value);

	/**
	 * Returns the value of the '<em><b>Default States</b></em>' attribute list.
	 * The list contents are of type {@link jaamsim.SimEntityState}.
	 * The literals are from the enumeration {@link jaamsim.SimEntityState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default States</em>' attribute list.
	 * @see jaamsim.SimEntityState
	 * @see jaamsim.JaamsimPackage#getSimEntity_DefaultStates()
	 * @model
	 * @generated
	 */
	EList<SimEntityState> getDefaultStates();

} // SimEntity
