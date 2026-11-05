/**
 */
package jaamsim;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.ResourceUnit#isAvailable <em>Available</em>}</li>
 *   <li>{@link jaamsim.ResourceUnit#getAssignedTo <em>Assigned To</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getResourceUnit()
 * @model
 * @generated
 */
public interface ResourceUnit extends DisplayEntity {
	/**
	 * Returns the value of the '<em><b>Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available</em>' attribute.
	 * @see #setAvailable(boolean)
	 * @see jaamsim.JaamsimPackage#getResourceUnit_Available()
	 * @model
	 * @generated
	 */
	boolean isAvailable();

	/**
	 * Sets the value of the '{@link jaamsim.ResourceUnit#isAvailable <em>Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available</em>' attribute.
	 * @see #isAvailable()
	 * @generated
	 */
	void setAvailable(boolean value);

	/**
	 * Returns the value of the '<em><b>Assigned To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned To</em>' reference.
	 * @see #setAssignedTo(SimEntity)
	 * @see jaamsim.JaamsimPackage#getResourceUnit_AssignedTo()
	 * @model
	 * @generated
	 */
	SimEntity getAssignedTo();

	/**
	 * Sets the value of the '{@link jaamsim.ResourceUnit#getAssignedTo <em>Assigned To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assigned To</em>' reference.
	 * @see #getAssignedTo()
	 * @generated
	 */
	void setAssignedTo(SimEntity value);

} // ResourceUnit
