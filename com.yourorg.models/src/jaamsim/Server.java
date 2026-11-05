/**
 */
package jaamsim;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.Server#getServiceTime <em>Service Time</em>}</li>
 *   <li>{@link jaamsim.Server#getWaitQueue <em>Wait Queue</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getServer()
 * @model
 * @generated
 */
public interface Server extends ProcessComponent {
	/**
	 * Returns the value of the '<em><b>Service Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Time</em>' attribute.
	 * @see #setServiceTime(double)
	 * @see jaamsim.JaamsimPackage#getServer_ServiceTime()
	 * @model
	 * @generated
	 */
	double getServiceTime();

	/**
	 * Sets the value of the '{@link jaamsim.Server#getServiceTime <em>Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Time</em>' attribute.
	 * @see #getServiceTime()
	 * @generated
	 */
	void setServiceTime(double value);

	/**
	 * Returns the value of the '<em><b>Wait Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait Queue</em>' reference.
	 * @see #setWaitQueue(Queue)
	 * @see jaamsim.JaamsimPackage#getServer_WaitQueue()
	 * @model
	 * @generated
	 */
	Queue getWaitQueue();

	/**
	 * Sets the value of the '{@link jaamsim.Server#getWaitQueue <em>Wait Queue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait Queue</em>' reference.
	 * @see #getWaitQueue()
	 * @generated
	 */
	void setWaitQueue(Queue value);

} // Server
