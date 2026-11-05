/**
 */
package jaamsim;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.SubModel#getComponents <em>Components</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getSubModel()
 * @model
 * @generated
 */
public interface SubModel extends DisplayEntity {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.ProcessComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getSubModel_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProcessComponent> getComponents();

} // SubModel
