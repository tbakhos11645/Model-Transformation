/**
 */
package jaamsim;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.Distribution#getKind <em>Kind</em>}</li>
 *   <li>{@link jaamsim.Distribution#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getDistribution()
 * @model
 * @generated
 */
public interface Distribution extends Entity {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link jaamsim.DistributionKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see jaamsim.DistributionKind
	 * @see #setKind(DistributionKind)
	 * @see jaamsim.JaamsimPackage#getDistribution_Kind()
	 * @model
	 * @generated
	 */
	DistributionKind getKind();

	/**
	 * Sets the value of the '{@link jaamsim.Distribution#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see jaamsim.DistributionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(DistributionKind value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.DistributionParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getDistribution_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<DistributionParameter> getParameters();

} // Distribution
