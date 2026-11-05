/**
 */
package jaamsim;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.Entity#getName <em>Name</em>}</li>
 *   <li>{@link jaamsim.Entity#getDescription <em>Description</em>}</li>
 *   <li>{@link jaamsim.Entity#getPosition <em>Position</em>}</li>
 *   <li>{@link jaamsim.Entity#getSize <em>Size</em>}</li>
 *   <li>{@link jaamsim.Entity#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link jaamsim.Entity#isMovable <em>Movable</em>}</li>
 *   <li>{@link jaamsim.Entity#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link jaamsim.Entity#getCustomOutputs <em>Custom Outputs</em>}</li>
 *   <li>{@link jaamsim.Entity#getRegion <em>Region</em>}</li>
 *   <li>{@link jaamsim.Entity#getDisplayModel <em>Display Model</em>}</li>
 * </ul>
 *
 * @see jaamsim.JaamsimPackage#getEntity()
 * @model abstract="true"
 * @generated
 */
public interface Entity extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see jaamsim.JaamsimPackage#getEntity_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jaamsim.Entity#getName <em>Name</em>}' attribute.
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
	 * @see jaamsim.JaamsimPackage#getEntity_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link jaamsim.Entity#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' containment reference.
	 * @see #setPosition(Point3D)
	 * @see jaamsim.JaamsimPackage#getEntity_Position()
	 * @model containment="true"
	 * @generated
	 */
	Point3D getPosition();

	/**
	 * Sets the value of the '{@link jaamsim.Entity#getPosition <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' containment reference.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Point3D value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' containment reference.
	 * @see #setSize(Point3D)
	 * @see jaamsim.JaamsimPackage#getEntity_Size()
	 * @model containment="true"
	 * @generated
	 */
	Point3D getSize();

	/**
	 * Sets the value of the '{@link jaamsim.Entity#getSize <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' containment reference.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Point3D value);

	/**
	 * Returns the value of the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientation</em>' containment reference.
	 * @see #setOrientation(Point3D)
	 * @see jaamsim.JaamsimPackage#getEntity_Orientation()
	 * @model containment="true"
	 * @generated
	 */
	Point3D getOrientation();

	/**
	 * Sets the value of the '{@link jaamsim.Entity#getOrientation <em>Orientation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation</em>' containment reference.
	 * @see #getOrientation()
	 * @generated
	 */
	void setOrientation(Point3D value);

	/**
	 * Returns the value of the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movable</em>' attribute.
	 * @see #setMovable(boolean)
	 * @see jaamsim.JaamsimPackage#getEntity_Movable()
	 * @model
	 * @generated
	 */
	boolean isMovable();

	/**
	 * Sets the value of the '{@link jaamsim.Entity#isMovable <em>Movable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Movable</em>' attribute.
	 * @see #isMovable()
	 * @generated
	 */
	void setMovable(boolean value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.Attribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getEntity_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link jaamsim.CustomOutput}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Outputs</em>' containment reference list.
	 * @see jaamsim.JaamsimPackage#getEntity_CustomOutputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<CustomOutput> getCustomOutputs();

	/**
	 * Returns the value of the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' reference.
	 * @see #setRegion(Region)
	 * @see jaamsim.JaamsimPackage#getEntity_Region()
	 * @model
	 * @generated
	 */
	Region getRegion();

	/**
	 * Sets the value of the '{@link jaamsim.Entity#getRegion <em>Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' reference.
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(Region value);

	/**
	 * Returns the value of the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Model</em>' reference.
	 * @see #setDisplayModel(DisplayModel)
	 * @see jaamsim.JaamsimPackage#getEntity_DisplayModel()
	 * @model
	 * @generated
	 */
	DisplayModel getDisplayModel();

	/**
	 * Sets the value of the '{@link jaamsim.Entity#getDisplayModel <em>Display Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Model</em>' reference.
	 * @see #getDisplayModel()
	 * @generated
	 */
	void setDisplayModel(DisplayModel value);

} // Entity
