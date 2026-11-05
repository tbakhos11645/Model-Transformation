/**
 */
package jaamsim;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.SimulationModel#getName <em>Name</em>}</li>
 *   <li>{@link jaamsim.SimulationModel#getDescription <em>Description</em>}</li>
 *   <li>{@link jaamsim.SimulationModel#getSimulation <em>Simulation</em>}</li>
 *   <li>{@link jaamsim.SimulationModel#getUnits <em>Units</em>}</li>
 *   <li>{@link jaamsim.SimulationModel#getEntities <em>Entities</em>}</li>
 *   <li>{@link jaamsim.SimulationModel#getComponents <em>Components</em>}</li>
 *   <li>{@link jaamsim.SimulationModel#getDistributions <em>Distributions</em>}</li>
 *   <li>{@link jaamsim.SimulationModel#getResources <em>Resources</em>}</li>
 *   <li>{@link jaamsim.SimulationModel#getViews <em>Views</em>}</li>
 *   <li>{@link jaamsim.SimulationModel#getSubModels <em>Sub Models</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getSimulationModel()
 * @model
 * @generated
 */
public interface SimulationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see jaamsim.JaamsimPackage#getSimulationModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jaamsim.SimulationModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see jaamsim.JaamsimPackage#getSimulationModel_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link jaamsim.SimulationModel#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Simulation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulation</em>' containment reference.
	 * @see #setSimulation(Simulation)
	 * @see jaamsim.JaamsimPackage#getSimulationModel_Simulation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Simulation getSimulation();

	/**
	 * Sets the value of the '{@link jaamsim.SimulationModel#getSimulation <em>Simulation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulation</em>' containment reference.
	 * @see #getSimulation()
	 * @generated
	 */
	void setSimulation(Simulation value);

	/**
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.Unit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getSimulationModel_Units()
	 * @model containment="true"
	 * @generated
	 */
	EList<Unit> getUnits();

	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.Entity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getSimulationModel_Entities()
	 * @model containment="true"
	 * @generated
	 */
	EList<Entity> getEntities();

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.Component}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getSimulationModel_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Distributions</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.Distribution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distributions</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getSimulationModel_Distributions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Distribution> getDistributions();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.Resource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getSimulationModel_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<Resource> getResources();

	/**
	 * Returns the value of the '<em><b>Views</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.View}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getSimulationModel_Views()
	 * @model containment="true"
	 * @generated
	 */
	EList<View> getViews();

	/**
	 * Returns the value of the '<em><b>Sub Models</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.SubModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Models</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getSimulationModel_SubModels()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubModel> getSubModels();

} // SimulationModel
