/**
 */
package jaamsim;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.Simulation#getRunDuration <em>Run Duration</em>}</li>
 *   <li>{@link jaamsim.Simulation#getInitializationDuration <em>Initialization Duration</em>}</li>
 *   <li>{@link jaamsim.Simulation#isExitAtStop <em>Exit At Stop</em>}</li>
 *   <li>{@link jaamsim.Simulation#getGlobalSubstreamSeed <em>Global Substream Seed</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getSimulation()
 * @model
 * @generated
 */
public interface Simulation extends EObject {
	/**
	 * Returns the value of the '<em><b>Run Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run Duration</em>' attribute.
	 * @see #setRunDuration(double)
	 * @see jaamsim.JaamsimPackage#getSimulation_RunDuration()
	 * @model
	 * @generated
	 */
	double getRunDuration();

	/**
	 * Sets the value of the '{@link jaamsim.Simulation#getRunDuration <em>Run Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run Duration</em>' attribute.
	 * @see #getRunDuration()
	 * @generated
	 */
	void setRunDuration(double value);

	/**
	 * Returns the value of the '<em><b>Initialization Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialization Duration</em>' attribute.
	 * @see #setInitializationDuration(double)
	 * @see jaamsim.JaamsimPackage#getSimulation_InitializationDuration()
	 * @model
	 * @generated
	 */
	double getInitializationDuration();

	/**
	 * Sets the value of the '{@link jaamsim.Simulation#getInitializationDuration <em>Initialization Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialization Duration</em>' attribute.
	 * @see #getInitializationDuration()
	 * @generated
	 */
	void setInitializationDuration(double value);

	/**
	 * Returns the value of the '<em><b>Exit At Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit At Stop</em>' attribute.
	 * @see #setExitAtStop(boolean)
	 * @see jaamsim.JaamsimPackage#getSimulation_ExitAtStop()
	 * @model
	 * @generated
	 */
	boolean isExitAtStop();

	/**
	 * Sets the value of the '{@link jaamsim.Simulation#isExitAtStop <em>Exit At Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit At Stop</em>' attribute.
	 * @see #isExitAtStop()
	 * @generated
	 */
	void setExitAtStop(boolean value);

	/**
	 * Returns the value of the '<em><b>Global Substream Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Substream Seed</em>' attribute.
	 * @see #setGlobalSubstreamSeed(int)
	 * @see jaamsim.JaamsimPackage#getSimulation_GlobalSubstreamSeed()
	 * @model
	 * @generated
	 */
	int getGlobalSubstreamSeed();

	/**
	 * Sets the value of the '{@link jaamsim.Simulation#getGlobalSubstreamSeed <em>Global Substream Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Substream Seed</em>' attribute.
	 * @see #getGlobalSubstreamSeed()
	 * @generated
	 */
	void setGlobalSubstreamSeed(int value);

} // Simulation
