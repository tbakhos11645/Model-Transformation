/**
 */
package jaamsim;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.Component#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link jaamsim.Component#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getComponent()
 * @model abstract="true"
 * @generated
 */
public interface Component extends DisplayEntity {
	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link jaamsim.Component}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see jaamsim.JaamsimPackage#getComponent_Incoming()
	 * @model
	 * @generated
	 */
	EList<Component> getIncoming();

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link jaamsim.Component}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see jaamsim.JaamsimPackage#getComponent_Outgoing()
	 * @model
	 * @generated
	 */
	EList<Component> getOutgoing();

} // Component
