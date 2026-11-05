/**
 */
package jaamsim;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.View#getCameraPosition <em>Camera Position</em>}</li>
 *   <li>{@link jaamsim.View#getCameraTarget <em>Camera Target</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getView()
 * @model
 * @generated
 */
public interface View extends Entity {
	/**
	 * Returns the value of the '<em><b>Camera Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Camera Position</em>' containment reference.
	 * @see #setCameraPosition(Point3D)
	 * @see jaamsim.JaamsimPackage#getView_CameraPosition()
	 * @model containment="true"
	 * @generated
	 */
	Point3D getCameraPosition();

	/**
	 * Sets the value of the '{@link jaamsim.View#getCameraPosition <em>Camera Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Camera Position</em>' containment reference.
	 * @see #getCameraPosition()
	 * @generated
	 */
	void setCameraPosition(Point3D value);

	/**
	 * Returns the value of the '<em><b>Camera Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Camera Target</em>' containment reference.
	 * @see #setCameraTarget(Point3D)
	 * @see jaamsim.JaamsimPackage#getView_CameraTarget()
	 * @model containment="true"
	 * @generated
	 */
	Point3D getCameraTarget();

	/**
	 * Sets the value of the '{@link jaamsim.View#getCameraTarget <em>Camera Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Camera Target</em>' containment reference.
	 * @see #getCameraTarget()
	 * @generated
	 */
	void setCameraTarget(Point3D value);

} // View
