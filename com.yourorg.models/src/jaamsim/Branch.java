/**
 */
package jaamsim;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.Branch#getNextComponentList <em>Next Component List</em>}</li>
 *   <li>{@link jaamsim.Branch#getChoice <em>Choice</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getBranch()
 * @model
 * @generated
 */
public interface Branch extends ProcessComponent {
	/**
	 * Returns the value of the '<em><b>Next Component List</b></em>' reference list.
	 * The list contents are of type {@link jaamsim.ProcessComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Component List</em>' reference list.
	 * @see jaamsim.JaamsimPackage#getBranch_NextComponentList()
	 * @model
	 * @generated
	 */
	EList<ProcessComponent> getNextComponentList();

	/**
	 * Returns the value of the '<em><b>Choice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choice</em>' attribute.
	 * @see #setChoice(String)
	 * @see jaamsim.JaamsimPackage#getBranch_Choice()
	 * @model
	 * @generated
	 */
	String getChoice();

	/**
	 * Sets the value of the '{@link jaamsim.Branch#getChoice <em>Choice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Choice</em>' attribute.
	 * @see #getChoice()
	 * @generated
	 */
	void setChoice(String value);

} // Branch
