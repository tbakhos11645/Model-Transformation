/**
 */
package jaamsim;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Conveyor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.EntityConveyor#getTravelTime <em>Travel Time</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getEntityConveyor()
 * @model
 * @generated
 */
public interface EntityConveyor extends ProcessComponent {
	/**
	 * Returns the value of the '<em><b>Travel Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Travel Time</em>' attribute.
	 * @see #setTravelTime(double)
	 * @see jaamsim.JaamsimPackage#getEntityConveyor_TravelTime()
	 * @model
	 * @generated
	 */
	double getTravelTime();

	/**
	 * Sets the value of the '{@link jaamsim.EntityConveyor#getTravelTime <em>Travel Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Travel Time</em>' attribute.
	 * @see #getTravelTime()
	 * @generated
	 */
	void setTravelTime(double value);

} // EntityConveyor
