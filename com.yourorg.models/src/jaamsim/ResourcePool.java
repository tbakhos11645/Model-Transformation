/**
 */
package jaamsim;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Pool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.ResourcePool#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getResourcePool()
 * @model
 * @generated
 */
public interface ResourcePool extends DisplayEntity {
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.ResourceUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getResourcePool_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResourceUnit> getResources();

} // ResourcePool
