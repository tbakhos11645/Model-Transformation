/**
 */
package jaamsim;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Seize</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.Seize#getRequiredUnits <em>Required Units</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getSeize()
 * @model
 * @generated
 */
public interface Seize extends ProcessComponent {
	/**
	 * Returns the value of the '<em><b>Required Units</b></em>' reference list.
	 * The list contents are of type {@link jaamsim.ResourceUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Units</em>' reference list.
	 * @see jaamsim.JaamsimPackage#getSeize_RequiredUnits()
	 * @model
	 * @generated
	 */
	EList<ResourceUnit> getRequiredUnits();

} // Seize
