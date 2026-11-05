/**
 */
package jaamsim;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.Unit#getName <em>Name</em>}</li>
 *   <li>{@link jaamsim.Unit#getType <em>Type</em>}</li>
 *   <li>{@link jaamsim.Unit#getConversionFactorToSI <em>Conversion Factor To SI</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getUnit()
 * @model
 * @generated
 */
public interface Unit extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see jaamsim.JaamsimPackage#getUnit_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jaamsim.Unit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link jaamsim.UnitType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see jaamsim.UnitType
	 * @see #setType(UnitType)
	 * @see jaamsim.JaamsimPackage#getUnit_Type()
	 * @model
	 * @generated
	 */
	UnitType getType();

	/**
	 * Sets the value of the '{@link jaamsim.Unit#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see jaamsim.UnitType
	 * @see #getType()
	 * @generated
	 */
	void setType(UnitType value);

	/**
	 * Returns the value of the '<em><b>Conversion Factor To SI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conversion Factor To SI</em>' attribute.
	 * @see #setConversionFactorToSI(double)
	 * @see jaamsim.JaamsimPackage#getUnit_ConversionFactorToSI()
	 * @model
	 * @generated
	 */
	double getConversionFactorToSI();

	/**
	 * Sets the value of the '{@link jaamsim.Unit#getConversionFactorToSI <em>Conversion Factor To SI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conversion Factor To SI</em>' attribute.
	 * @see #getConversionFactorToSI()
	 * @generated
	 */
	void setConversionFactorToSI(double value);

} // Unit
