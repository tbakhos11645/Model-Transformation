/**
 */
package jaamsim;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Release</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.Release#getReleasedUnits <em>Released Units</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getRelease()
 * @model
 * @generated
 */
public interface Release extends ProcessComponent {
	/**
	 * Returns the value of the '<em><b>Released Units</b></em>' reference list.
	 * The list contents are of type {@link jaamsim.ResourceUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Released Units</em>' reference list.
	 * @see jaamsim.JaamsimPackage#getRelease_ReleasedUnits()
	 * @model
	 * @generated
	 */
	EList<ResourceUnit> getReleasedUnits();

} // Release
