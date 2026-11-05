/**
 */
package jaamsim;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.EntityGenerator#getFirstArrivalTime <em>First Arrival Time</em>}</li>
 *   <li>{@link jaamsim.EntityGenerator#getInterArrivalTime <em>Inter Arrival Time</em>}</li>
 *   <li>{@link jaamsim.EntityGenerator#getEntitiesPerArrival <em>Entities Per Arrival</em>}</li>
 *   <li>{@link jaamsim.EntityGenerator#getMaxNumber <em>Max Number</em>}</li>
 *   <li>{@link jaamsim.EntityGenerator#getPrototype <em>Prototype</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getEntityGenerator()
 * @model
 * @generated
 */
public interface EntityGenerator extends ProcessComponent {
	/**
	 * Returns the value of the '<em><b>First Arrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Arrival Time</em>' attribute.
	 * @see #setFirstArrivalTime(double)
	 * @see jaamsim.JaamsimPackage#getEntityGenerator_FirstArrivalTime()
	 * @model
	 * @generated
	 */
	double getFirstArrivalTime();

	/**
	 * Sets the value of the '{@link jaamsim.EntityGenerator#getFirstArrivalTime <em>First Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Arrival Time</em>' attribute.
	 * @see #getFirstArrivalTime()
	 * @generated
	 */
	void setFirstArrivalTime(double value);

	/**
	 * Returns the value of the '<em><b>Inter Arrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inter Arrival Time</em>' attribute.
	 * @see #setInterArrivalTime(double)
	 * @see jaamsim.JaamsimPackage#getEntityGenerator_InterArrivalTime()
	 * @model
	 * @generated
	 */
	double getInterArrivalTime();

	/**
	 * Sets the value of the '{@link jaamsim.EntityGenerator#getInterArrivalTime <em>Inter Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inter Arrival Time</em>' attribute.
	 * @see #getInterArrivalTime()
	 * @generated
	 */
	void setInterArrivalTime(double value);

	/**
	 * Returns the value of the '<em><b>Entities Per Arrival</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities Per Arrival</em>' attribute.
	 * @see #setEntitiesPerArrival(int)
	 * @see jaamsim.JaamsimPackage#getEntityGenerator_EntitiesPerArrival()
	 * @model
	 * @generated
	 */
	int getEntitiesPerArrival();

	/**
	 * Sets the value of the '{@link jaamsim.EntityGenerator#getEntitiesPerArrival <em>Entities Per Arrival</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entities Per Arrival</em>' attribute.
	 * @see #getEntitiesPerArrival()
	 * @generated
	 */
	void setEntitiesPerArrival(int value);

	/**
	 * Returns the value of the '<em><b>Max Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Number</em>' attribute.
	 * @see #setMaxNumber(int)
	 * @see jaamsim.JaamsimPackage#getEntityGenerator_MaxNumber()
	 * @model
	 * @generated
	 */
	int getMaxNumber();

	/**
	 * Sets the value of the '{@link jaamsim.EntityGenerator#getMaxNumber <em>Max Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Number</em>' attribute.
	 * @see #getMaxNumber()
	 * @generated
	 */
	void setMaxNumber(int value);

	/**
	 * Returns the value of the '<em><b>Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prototype</em>' reference.
	 * @see #setPrototype(SimEntity)
	 * @see jaamsim.JaamsimPackage#getEntityGenerator_Prototype()
	 * @model
	 * @generated
	 */
	SimEntity getPrototype();

	/**
	 * Sets the value of the '{@link jaamsim.EntityGenerator#getPrototype <em>Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prototype</em>' reference.
	 * @see #getPrototype()
	 * @generated
	 */
	void setPrototype(SimEntity value);

} // EntityGenerator
