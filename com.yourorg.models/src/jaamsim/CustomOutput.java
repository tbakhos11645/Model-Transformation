/**
 */
package jaamsim;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.CustomOutput#getName <em>Name</em>}</li>
 *   <li>{@link jaamsim.CustomOutput#getExp <em>Exp</em>}</li>
 *   <li>{@link jaamsim.CustomOutput#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getCustomOutput()
 * @model
 * @generated
 */
public interface CustomOutput extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see jaamsim.JaamsimPackage#getCustomOutput_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jaamsim.CustomOutput#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp</em>' containment reference.
	 * @see #setExp(Expression)
	 * @see jaamsim.JaamsimPackage#getCustomOutput_Exp()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExp();

	/**
	 * Sets the value of the '{@link jaamsim.CustomOutput#getExp <em>Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp</em>' containment reference.
	 * @see #getExp()
	 * @generated
	 */
	void setExp(Expression value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * The literals are from the enumeration {@link jaamsim.UnitType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see jaamsim.UnitType
	 * @see #setUnit(UnitType)
	 * @see jaamsim.JaamsimPackage#getCustomOutput_Unit()
	 * @model
	 * @generated
	 */
	UnitType getUnit();

	/**
	 * Sets the value of the '{@link jaamsim.CustomOutput#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see jaamsim.UnitType
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(UnitType value);

} // CustomOutput
