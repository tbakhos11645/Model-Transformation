/**
 */
package jaamsim;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.BranchCondition#getCondition <em>Condition</em>}</li>
 *   <li>{@link jaamsim.BranchCondition#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getBranchCondition()
 * @model
 * @generated
 */
public interface BranchCondition extends EObject {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see jaamsim.JaamsimPackage#getBranchCondition_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link jaamsim.BranchCondition#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ProcessComponent)
	 * @see jaamsim.JaamsimPackage#getBranchCondition_Target()
	 * @model
	 * @generated
	 */
	ProcessComponent getTarget();

	/**
	 * Sets the value of the '{@link jaamsim.BranchCondition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ProcessComponent value);

} // BranchCondition
