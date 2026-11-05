/**
 */
package jaamsim;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Queue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.Queue#getPriority <em>Priority</em>}</li>
 *   <li>{@link jaamsim.Queue#getMatch <em>Match</em>}</li>
 *   <li>{@link jaamsim.Queue#isFifo <em>Fifo</em>}</li>
 *   <li>{@link jaamsim.Queue#getRenegeTime <em>Renege Time</em>}</li>
 *   <li>{@link jaamsim.Queue#getRenegeCondition <em>Renege Condition</em>}</li>
 *   <li>{@link jaamsim.Queue#getRenegeDestination <em>Renege Destination</em>}</li>
 *   <li>{@link jaamsim.Queue#getMaxValidLength <em>Max Valid Length</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getQueue()
 * @model
 * @generated
 */
public interface Queue extends ProcessComponent {
	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see jaamsim.JaamsimPackage#getQueue_Priority()
	 * @model
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link jaamsim.Queue#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' attribute.
	 * @see #setMatch(String)
	 * @see jaamsim.JaamsimPackage#getQueue_Match()
	 * @model
	 * @generated
	 */
	String getMatch();

	/**
	 * Sets the value of the '{@link jaamsim.Queue#getMatch <em>Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match</em>' attribute.
	 * @see #getMatch()
	 * @generated
	 */
	void setMatch(String value);

	/**
	 * Returns the value of the '<em><b>Fifo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fifo</em>' attribute.
	 * @see #setFifo(boolean)
	 * @see jaamsim.JaamsimPackage#getQueue_Fifo()
	 * @model
	 * @generated
	 */
	boolean isFifo();

	/**
	 * Sets the value of the '{@link jaamsim.Queue#isFifo <em>Fifo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fifo</em>' attribute.
	 * @see #isFifo()
	 * @generated
	 */
	void setFifo(boolean value);

	/**
	 * Returns the value of the '<em><b>Renege Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renege Time</em>' attribute.
	 * @see #setRenegeTime(double)
	 * @see jaamsim.JaamsimPackage#getQueue_RenegeTime()
	 * @model
	 * @generated
	 */
	double getRenegeTime();

	/**
	 * Sets the value of the '{@link jaamsim.Queue#getRenegeTime <em>Renege Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Renege Time</em>' attribute.
	 * @see #getRenegeTime()
	 * @generated
	 */
	void setRenegeTime(double value);

	/**
	 * Returns the value of the '<em><b>Renege Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renege Condition</em>' containment reference.
	 * @see #setRenegeCondition(Expression)
	 * @see jaamsim.JaamsimPackage#getQueue_RenegeCondition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getRenegeCondition();

	/**
	 * Sets the value of the '{@link jaamsim.Queue#getRenegeCondition <em>Renege Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Renege Condition</em>' containment reference.
	 * @see #getRenegeCondition()
	 * @generated
	 */
	void setRenegeCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Renege Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renege Destination</em>' reference.
	 * @see #setRenegeDestination(ProcessComponent)
	 * @see jaamsim.JaamsimPackage#getQueue_RenegeDestination()
	 * @model
	 * @generated
	 */
	ProcessComponent getRenegeDestination();

	/**
	 * Sets the value of the '{@link jaamsim.Queue#getRenegeDestination <em>Renege Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Renege Destination</em>' reference.
	 * @see #getRenegeDestination()
	 * @generated
	 */
	void setRenegeDestination(ProcessComponent value);

	/**
	 * Returns the value of the '<em><b>Max Valid Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Valid Length</em>' attribute.
	 * @see #setMaxValidLength(int)
	 * @see jaamsim.JaamsimPackage#getQueue_MaxValidLength()
	 * @model
	 * @generated
	 */
	int getMaxValidLength();

	/**
	 * Sets the value of the '{@link jaamsim.Queue#getMaxValidLength <em>Max Valid Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Valid Length</em>' attribute.
	 * @see #getMaxValidLength()
	 * @generated
	 */
	void setMaxValidLength(int value);

} // Queue
