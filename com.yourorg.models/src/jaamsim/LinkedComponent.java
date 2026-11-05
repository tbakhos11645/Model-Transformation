/**
 */
package jaamsim;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Linked Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.LinkedComponent#getNextComponent <em>Next Component</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getLinkedComponent()
 * @model abstract="true"
 * @generated
 */
public interface LinkedComponent extends Component {
	/**
	 * Returns the value of the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Component</em>' reference.
	 * @see #setNextComponent(Component)
	 * @see jaamsim.JaamsimPackage#getLinkedComponent_NextComponent()
	 * @model
	 * @generated
	 */
	Component getNextComponent();

	/**
	 * Sets the value of the '{@link jaamsim.LinkedComponent#getNextComponent <em>Next Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Component</em>' reference.
	 * @see #getNextComponent()
	 * @generated
	 */
	void setNextComponent(Component value);

} // LinkedComponent
