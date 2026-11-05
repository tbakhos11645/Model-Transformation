/**
 */
package jaamsim;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see jaamsim.JaamsimFactory
 * @model kind="package"
 * @generated
 */
public interface JaamsimPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "jaamsim";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/jaamsim";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jaamsim";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JaamsimPackage eINSTANCE = jaamsim.impl.JaamsimPackageImpl.init();

	/**
	 * The meta object id for the '{@link jaamsim.impl.Point3DImpl <em>Point3 D</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.Point3DImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getPoint3D()
	 * @generated
	 */
	int POINT3_D = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT3_D__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT3_D__Y = 1;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT3_D__Z = 2;

	/**
	 * The number of structural features of the '<em>Point3 D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT3_D_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Point3 D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT3_D_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.SimulationModelImpl <em>Simulation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.SimulationModelImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getSimulationModel()
	 * @generated
	 */
	int SIMULATION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Simulation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__SIMULATION = 2;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__UNITS = 3;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__ENTITIES = 4;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__COMPONENTS = 5;

	/**
	 * The feature id for the '<em><b>Distributions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__DISTRIBUTIONS = 6;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__RESOURCES = 7;

	/**
	 * The feature id for the '<em><b>Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__VIEWS = 8;

	/**
	 * The feature id for the '<em><b>Sub Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__SUB_MODELS = 9;

	/**
	 * The number of structural features of the '<em>Simulation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Simulation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.SimulationImpl <em>Simulation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.SimulationImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getSimulation()
	 * @generated
	 */
	int SIMULATION = 2;

	/**
	 * The feature id for the '<em><b>Run Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION__RUN_DURATION = 0;

	/**
	 * The feature id for the '<em><b>Initialization Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION__INITIALIZATION_DURATION = 1;

	/**
	 * The feature id for the '<em><b>Exit At Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION__EXIT_AT_STOP = 2;

	/**
	 * The feature id for the '<em><b>Global Substream Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION__GLOBAL_SUBSTREAM_SEED = 3;

	/**
	 * The number of structural features of the '<em>Simulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Simulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.UnitImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Conversion Factor To SI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__CONVERSION_FACTOR_TO_SI = 2;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.ExpressionImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__BODY = 0;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.AttributeImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__INIT_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.CustomOutputImpl <em>Custom Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.CustomOutputImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getCustomOutput()
	 * @generated
	 */
	int CUSTOM_OUTPUT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OUTPUT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OUTPUT__EXP = 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OUTPUT__UNIT = 2;

	/**
	 * The number of structural features of the '<em>Custom Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OUTPUT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Custom Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OUTPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.EntityImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__POSITION = 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__SIZE = 3;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ORIENTATION = 4;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__MOVABLE = 5;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ATTRIBUTES = 6;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__CUSTOM_OUTPUTS = 7;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__REGION = 8;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__DISPLAY_MODEL = 9;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.DisplayEntityImpl <em>Display Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.DisplayEntityImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getDisplayEntity()
	 * @generated
	 */
	int DISPLAY_ENTITY = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY__DESCRIPTION = ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY__POSITION = ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY__SIZE = ENTITY__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY__ORIENTATION = ENTITY__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY__MOVABLE = ENTITY__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY__ATTRIBUTES = ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY__CUSTOM_OUTPUTS = ENTITY__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY__REGION = ENTITY__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY__DISPLAY_MODEL = ENTITY__DISPLAY_MODEL;

	/**
	 * The number of structural features of the '<em>Display Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Display Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_ENTITY_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.ComponentImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = DISPLAY_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__DESCRIPTION = DISPLAY_ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__POSITION = DISPLAY_ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SIZE = DISPLAY_ENTITY__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ORIENTATION = DISPLAY_ENTITY__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__MOVABLE = DISPLAY_ENTITY__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ATTRIBUTES = DISPLAY_ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__CUSTOM_OUTPUTS = DISPLAY_ENTITY__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__REGION = DISPLAY_ENTITY__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__DISPLAY_MODEL = DISPLAY_ENTITY__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INCOMING = DISPLAY_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OUTGOING = DISPLAY_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = DISPLAY_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = DISPLAY_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.LinkedComponentImpl <em>Linked Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.LinkedComponentImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getLinkedComponent()
	 * @generated
	 */
	int LINKED_COMPONENT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__DESCRIPTION = COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__POSITION = COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__SIZE = COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__ORIENTATION = COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__MOVABLE = COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__ATTRIBUTES = COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__CUSTOM_OUTPUTS = COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__REGION = COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__DISPLAY_MODEL = COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__INCOMING = COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__OUTGOING = COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT__NEXT_COMPONENT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Linked Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Linked Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKED_COMPONENT_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.SimEntityImpl <em>Sim Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.SimEntityImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getSimEntity()
	 * @generated
	 */
	int SIM_ENTITY = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__NAME = DISPLAY_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__DESCRIPTION = DISPLAY_ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__POSITION = DISPLAY_ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__SIZE = DISPLAY_ENTITY__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__ORIENTATION = DISPLAY_ENTITY__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__MOVABLE = DISPLAY_ENTITY__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__ATTRIBUTES = DISPLAY_ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__CUSTOM_OUTPUTS = DISPLAY_ENTITY__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__REGION = DISPLAY_ENTITY__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__DISPLAY_MODEL = DISPLAY_ENTITY__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__INITIAL_STATE = DISPLAY_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default States</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY__DEFAULT_STATES = DISPLAY_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sim Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY_FEATURE_COUNT = DISPLAY_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sim Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_ENTITY_OPERATION_COUNT = DISPLAY_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.ProcessComponentImpl <em>Process Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.ProcessComponentImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getProcessComponent()
	 * @generated
	 */
	int PROCESS_COMPONENT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__NAME = LINKED_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__DESCRIPTION = LINKED_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__POSITION = LINKED_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__SIZE = LINKED_COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__ORIENTATION = LINKED_COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__MOVABLE = LINKED_COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__ATTRIBUTES = LINKED_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__CUSTOM_OUTPUTS = LINKED_COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__REGION = LINKED_COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__DISPLAY_MODEL = LINKED_COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__INCOMING = LINKED_COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__OUTGOING = LINKED_COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT__NEXT_COMPONENT = LINKED_COMPONENT__NEXT_COMPONENT;

	/**
	 * The number of structural features of the '<em>Process Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT_FEATURE_COUNT = LINKED_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Process Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_COMPONENT_OPERATION_COUNT = LINKED_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.EntityGeneratorImpl <em>Entity Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.EntityGeneratorImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getEntityGenerator()
	 * @generated
	 */
	int ENTITY_GENERATOR = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__NAME = PROCESS_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__POSITION = PROCESS_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__SIZE = PROCESS_COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__ORIENTATION = PROCESS_COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__MOVABLE = PROCESS_COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__ATTRIBUTES = PROCESS_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__CUSTOM_OUTPUTS = PROCESS_COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__REGION = PROCESS_COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__DISPLAY_MODEL = PROCESS_COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__INCOMING = PROCESS_COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__OUTGOING = PROCESS_COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__NEXT_COMPONENT = PROCESS_COMPONENT__NEXT_COMPONENT;

	/**
	 * The feature id for the '<em><b>First Arrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__FIRST_ARRIVAL_TIME = PROCESS_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inter Arrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__INTER_ARRIVAL_TIME = PROCESS_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Entities Per Arrival</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__ENTITIES_PER_ARRIVAL = PROCESS_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__MAX_NUMBER = PROCESS_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR__PROTOTYPE = PROCESS_COMPONENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Entity Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Entity Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_GENERATOR_OPERATION_COUNT = PROCESS_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.QueueImpl <em>Queue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.QueueImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getQueue()
	 * @generated
	 */
	int QUEUE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__NAME = PROCESS_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__POSITION = PROCESS_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__SIZE = PROCESS_COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__ORIENTATION = PROCESS_COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__MOVABLE = PROCESS_COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__ATTRIBUTES = PROCESS_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__CUSTOM_OUTPUTS = PROCESS_COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__REGION = PROCESS_COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__DISPLAY_MODEL = PROCESS_COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__INCOMING = PROCESS_COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__OUTGOING = PROCESS_COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__NEXT_COMPONENT = PROCESS_COMPONENT__NEXT_COMPONENT;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__PRIORITY = PROCESS_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__MATCH = PROCESS_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fifo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__FIFO = PROCESS_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Renege Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__RENEGE_TIME = PROCESS_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Renege Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__RENEGE_CONDITION = PROCESS_COMPONENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Renege Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__RENEGE_DESTINATION = PROCESS_COMPONENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Max Valid Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__MAX_VALID_LENGTH = PROCESS_COMPONENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Queue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Queue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE_OPERATION_COUNT = PROCESS_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.EntityConveyorImpl <em>Entity Conveyor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.EntityConveyorImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getEntityConveyor()
	 * @generated
	 */
	int ENTITY_CONVEYOR = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__NAME = PROCESS_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__POSITION = PROCESS_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__SIZE = PROCESS_COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__ORIENTATION = PROCESS_COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__MOVABLE = PROCESS_COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__ATTRIBUTES = PROCESS_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__CUSTOM_OUTPUTS = PROCESS_COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__REGION = PROCESS_COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__DISPLAY_MODEL = PROCESS_COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__INCOMING = PROCESS_COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__OUTGOING = PROCESS_COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__NEXT_COMPONENT = PROCESS_COMPONENT__NEXT_COMPONENT;

	/**
	 * The feature id for the '<em><b>Travel Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR__TRAVEL_TIME = PROCESS_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Conveyor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Entity Conveyor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONVEYOR_OPERATION_COUNT = PROCESS_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.ServerImpl <em>Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.ServerImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getServer()
	 * @generated
	 */
	int SERVER = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__NAME = PROCESS_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__POSITION = PROCESS_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__SIZE = PROCESS_COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__ORIENTATION = PROCESS_COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__MOVABLE = PROCESS_COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__ATTRIBUTES = PROCESS_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__CUSTOM_OUTPUTS = PROCESS_COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__REGION = PROCESS_COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__DISPLAY_MODEL = PROCESS_COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__INCOMING = PROCESS_COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__OUTGOING = PROCESS_COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__NEXT_COMPONENT = PROCESS_COMPONENT__NEXT_COMPONENT;

	/**
	 * The feature id for the '<em><b>Service Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__SERVICE_TIME = PROCESS_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Wait Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__WAIT_QUEUE = PROCESS_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_OPERATION_COUNT = PROCESS_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.EntitySinkImpl <em>Entity Sink</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.EntitySinkImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getEntitySink()
	 * @generated
	 */
	int ENTITY_SINK = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__NAME = PROCESS_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__POSITION = PROCESS_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__SIZE = PROCESS_COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__ORIENTATION = PROCESS_COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__MOVABLE = PROCESS_COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__ATTRIBUTES = PROCESS_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__CUSTOM_OUTPUTS = PROCESS_COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__REGION = PROCESS_COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__DISPLAY_MODEL = PROCESS_COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__INCOMING = PROCESS_COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__OUTGOING = PROCESS_COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK__NEXT_COMPONENT = PROCESS_COMPONENT__NEXT_COMPONENT;

	/**
	 * The number of structural features of the '<em>Entity Sink</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entity Sink</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SINK_OPERATION_COUNT = PROCESS_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.BranchImpl <em>Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.BranchImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getBranch()
	 * @generated
	 */
	int BRANCH = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__NAME = PROCESS_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__POSITION = PROCESS_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__SIZE = PROCESS_COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__ORIENTATION = PROCESS_COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__MOVABLE = PROCESS_COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__ATTRIBUTES = PROCESS_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__CUSTOM_OUTPUTS = PROCESS_COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__REGION = PROCESS_COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__DISPLAY_MODEL = PROCESS_COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__INCOMING = PROCESS_COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__OUTGOING = PROCESS_COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__NEXT_COMPONENT = PROCESS_COMPONENT__NEXT_COMPONENT;

	/**
	 * The feature id for the '<em><b>Next Component List</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__NEXT_COMPONENT_LIST = PROCESS_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Choice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__CHOICE = PROCESS_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_OPERATION_COUNT = PROCESS_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.ResourceImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = DISPLAY_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DESCRIPTION = DISPLAY_ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__POSITION = DISPLAY_ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__SIZE = DISPLAY_ENTITY__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ORIENTATION = DISPLAY_ENTITY__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__MOVABLE = DISPLAY_ENTITY__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ATTRIBUTES = DISPLAY_ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__CUSTOM_OUTPUTS = DISPLAY_ENTITY__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__REGION = DISPLAY_ENTITY__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DISPLAY_MODEL = DISPLAY_ENTITY__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__CAPACITY = DISPLAY_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__UNITS = DISPLAY_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = DISPLAY_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = DISPLAY_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.ResourceUnitImpl <em>Resource Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.ResourceUnitImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getResourceUnit()
	 * @generated
	 */
	int RESOURCE_UNIT = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__NAME = DISPLAY_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__DESCRIPTION = DISPLAY_ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__POSITION = DISPLAY_ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__SIZE = DISPLAY_ENTITY__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__ORIENTATION = DISPLAY_ENTITY__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__MOVABLE = DISPLAY_ENTITY__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__ATTRIBUTES = DISPLAY_ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__CUSTOM_OUTPUTS = DISPLAY_ENTITY__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__REGION = DISPLAY_ENTITY__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__DISPLAY_MODEL = DISPLAY_ENTITY__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__AVAILABLE = DISPLAY_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assigned To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT__ASSIGNED_TO = DISPLAY_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT_FEATURE_COUNT = DISPLAY_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Resource Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UNIT_OPERATION_COUNT = DISPLAY_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.ResourcePoolImpl <em>Resource Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.ResourcePoolImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getResourcePool()
	 * @generated
	 */
	int RESOURCE_POOL = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL__NAME = DISPLAY_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL__DESCRIPTION = DISPLAY_ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL__POSITION = DISPLAY_ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL__SIZE = DISPLAY_ENTITY__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL__ORIENTATION = DISPLAY_ENTITY__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL__MOVABLE = DISPLAY_ENTITY__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL__ATTRIBUTES = DISPLAY_ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL__CUSTOM_OUTPUTS = DISPLAY_ENTITY__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL__REGION = DISPLAY_ENTITY__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL__DISPLAY_MODEL = DISPLAY_ENTITY__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL__RESOURCES = DISPLAY_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL_FEATURE_COUNT = DISPLAY_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resource Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_POOL_OPERATION_COUNT = DISPLAY_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.SeizeImpl <em>Seize</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.SeizeImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getSeize()
	 * @generated
	 */
	int SEIZE = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__NAME = PROCESS_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__POSITION = PROCESS_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__SIZE = PROCESS_COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__ORIENTATION = PROCESS_COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__MOVABLE = PROCESS_COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__ATTRIBUTES = PROCESS_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__CUSTOM_OUTPUTS = PROCESS_COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__REGION = PROCESS_COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__DISPLAY_MODEL = PROCESS_COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__INCOMING = PROCESS_COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__OUTGOING = PROCESS_COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__NEXT_COMPONENT = PROCESS_COMPONENT__NEXT_COMPONENT;

	/**
	 * The feature id for the '<em><b>Required Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE__REQUIRED_UNITS = PROCESS_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Seize</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Seize</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIZE_OPERATION_COUNT = PROCESS_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.ReleaseImpl <em>Release</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.ReleaseImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getRelease()
	 * @generated
	 */
	int RELEASE = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__NAME = PROCESS_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__POSITION = PROCESS_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__SIZE = PROCESS_COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__ORIENTATION = PROCESS_COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__MOVABLE = PROCESS_COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__ATTRIBUTES = PROCESS_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__CUSTOM_OUTPUTS = PROCESS_COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__REGION = PROCESS_COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__DISPLAY_MODEL = PROCESS_COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__INCOMING = PROCESS_COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__OUTGOING = PROCESS_COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__NEXT_COMPONENT = PROCESS_COMPONENT__NEXT_COMPONENT;

	/**
	 * The feature id for the '<em><b>Released Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__RELEASED_UNITS = PROCESS_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_OPERATION_COUNT = PROCESS_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.DistributionImpl <em>Distribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.DistributionImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getDistribution()
	 * @generated
	 */
	int DISTRIBUTION = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__DESCRIPTION = ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__POSITION = ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__SIZE = ENTITY__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__ORIENTATION = ENTITY__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__MOVABLE = ENTITY__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__ATTRIBUTES = ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__CUSTOM_OUTPUTS = ENTITY__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__REGION = ENTITY__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__DISPLAY_MODEL = ENTITY__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__KIND = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__PARAMETERS = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Distribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Distribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.DistributionParameterImpl <em>Distribution Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.DistributionParameterImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getDistributionParameter()
	 * @generated
	 */
	int DISTRIBUTION_PARAMETER = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_PARAMETER__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_PARAMETER__UNIT = 2;

	/**
	 * The number of structural features of the '<em>Distribution Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Distribution Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.RegionImpl <em>Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.RegionImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__DESCRIPTION = ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__POSITION = ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__SIZE = ENTITY__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__ORIENTATION = ENTITY__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__MOVABLE = ENTITY__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__ATTRIBUTES = ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__CUSTOM_OUTPUTS = ENTITY__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__REGION = ENTITY__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__DISPLAY_MODEL = ENTITY__DISPLAY_MODEL;

	/**
	 * The number of structural features of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.DisplayModelImpl <em>Display Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.DisplayModelImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getDisplayModel()
	 * @generated
	 */
	int DISPLAY_MODEL = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL__DESCRIPTION = ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL__POSITION = ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL__SIZE = ENTITY__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL__ORIENTATION = ENTITY__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL__MOVABLE = ENTITY__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL__ATTRIBUTES = ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL__CUSTOM_OUTPUTS = ENTITY__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL__REGION = ENTITY__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL__DISPLAY_MODEL = ENTITY__DISPLAY_MODEL;

	/**
	 * The number of structural features of the '<em>Display Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Display Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_MODEL_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.ViewImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getView()
	 * @generated
	 */
	int VIEW = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__DESCRIPTION = ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__POSITION = ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__SIZE = ENTITY__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__ORIENTATION = ENTITY__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__MOVABLE = ENTITY__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__ATTRIBUTES = ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__CUSTOM_OUTPUTS = ENTITY__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__REGION = ENTITY__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__DISPLAY_MODEL = ENTITY__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Camera Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__CAMERA_POSITION = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Camera Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__CAMERA_TARGET = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.SubModelImpl <em>Sub Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.SubModelImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getSubModel()
	 * @generated
	 */
	int SUB_MODEL = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL__NAME = DISPLAY_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL__DESCRIPTION = DISPLAY_ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL__POSITION = DISPLAY_ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL__SIZE = DISPLAY_ENTITY__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL__ORIENTATION = DISPLAY_ENTITY__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL__MOVABLE = DISPLAY_ENTITY__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL__ATTRIBUTES = DISPLAY_ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL__CUSTOM_OUTPUTS = DISPLAY_ENTITY__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL__REGION = DISPLAY_ENTITY__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL__DISPLAY_MODEL = DISPLAY_ENTITY__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL__COMPONENTS = DISPLAY_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sub Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_FEATURE_COUNT = DISPLAY_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sub Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_OPERATION_COUNT = DISPLAY_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.SubModelStartImpl <em>Sub Model Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.SubModelStartImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getSubModelStart()
	 * @generated
	 */
	int SUB_MODEL_START = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__NAME = PROCESS_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__POSITION = PROCESS_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__SIZE = PROCESS_COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__ORIENTATION = PROCESS_COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__MOVABLE = PROCESS_COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__ATTRIBUTES = PROCESS_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__CUSTOM_OUTPUTS = PROCESS_COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__REGION = PROCESS_COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__DISPLAY_MODEL = PROCESS_COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__INCOMING = PROCESS_COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__OUTGOING = PROCESS_COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START__NEXT_COMPONENT = PROCESS_COMPONENT__NEXT_COMPONENT;

	/**
	 * The number of structural features of the '<em>Sub Model Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sub Model Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_START_OPERATION_COUNT = PROCESS_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.impl.SubModelEndImpl <em>Sub Model End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.impl.SubModelEndImpl
	 * @see jaamsim.impl.JaamsimPackageImpl#getSubModelEnd()
	 * @generated
	 */
	int SUB_MODEL_END = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__NAME = PROCESS_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__POSITION = PROCESS_COMPONENT__POSITION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__SIZE = PROCESS_COMPONENT__SIZE;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__ORIENTATION = PROCESS_COMPONENT__ORIENTATION;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__MOVABLE = PROCESS_COMPONENT__MOVABLE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__ATTRIBUTES = PROCESS_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Custom Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__CUSTOM_OUTPUTS = PROCESS_COMPONENT__CUSTOM_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__REGION = PROCESS_COMPONENT__REGION;

	/**
	 * The feature id for the '<em><b>Display Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__DISPLAY_MODEL = PROCESS_COMPONENT__DISPLAY_MODEL;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__INCOMING = PROCESS_COMPONENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__OUTGOING = PROCESS_COMPONENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Next Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END__NEXT_COMPONENT = PROCESS_COMPONENT__NEXT_COMPONENT;

	/**
	 * The number of structural features of the '<em>Sub Model End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sub Model End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MODEL_END_OPERATION_COUNT = PROCESS_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link jaamsim.UnitType <em>Unit Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.UnitType
	 * @see jaamsim.impl.JaamsimPackageImpl#getUnitType()
	 * @generated
	 */
	int UNIT_TYPE = 32;

	/**
	 * The meta object id for the '{@link jaamsim.SimEntityState <em>Sim Entity State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.SimEntityState
	 * @see jaamsim.impl.JaamsimPackageImpl#getSimEntityState()
	 * @generated
	 */
	int SIM_ENTITY_STATE = 33;

	/**
	 * The meta object id for the '{@link jaamsim.DistributionKind <em>Distribution Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jaamsim.DistributionKind
	 * @see jaamsim.impl.JaamsimPackageImpl#getDistributionKind()
	 * @generated
	 */
	int DISTRIBUTION_KIND = 34;


	/**
	 * Returns the meta object for class '{@link jaamsim.Point3D <em>Point3 D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point3 D</em>'.
	 * @see jaamsim.Point3D
	 * @generated
	 */
	EClass getPoint3D();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Point3D#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see jaamsim.Point3D#getX()
	 * @see #getPoint3D()
	 * @generated
	 */
	EAttribute getPoint3D_X();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Point3D#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see jaamsim.Point3D#getY()
	 * @see #getPoint3D()
	 * @generated
	 */
	EAttribute getPoint3D_Y();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Point3D#getZ <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Z</em>'.
	 * @see jaamsim.Point3D#getZ()
	 * @see #getPoint3D()
	 * @generated
	 */
	EAttribute getPoint3D_Z();

	/**
	 * Returns the meta object for class '{@link jaamsim.SimulationModel <em>Simulation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Model</em>'.
	 * @see jaamsim.SimulationModel
	 * @generated
	 */
	EClass getSimulationModel();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.SimulationModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jaamsim.SimulationModel#getName()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EAttribute getSimulationModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.SimulationModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see jaamsim.SimulationModel#getDescription()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EAttribute getSimulationModel_Description();

	/**
	 * Returns the meta object for the containment reference '{@link jaamsim.SimulationModel#getSimulation <em>Simulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simulation</em>'.
	 * @see jaamsim.SimulationModel#getSimulation()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_Simulation();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.SimulationModel#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see jaamsim.SimulationModel#getUnits()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_Units();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.SimulationModel#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see jaamsim.SimulationModel#getEntities()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_Entities();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.SimulationModel#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see jaamsim.SimulationModel#getComponents()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.SimulationModel#getDistributions <em>Distributions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Distributions</em>'.
	 * @see jaamsim.SimulationModel#getDistributions()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_Distributions();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.SimulationModel#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see jaamsim.SimulationModel#getResources()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_Resources();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.SimulationModel#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Views</em>'.
	 * @see jaamsim.SimulationModel#getViews()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_Views();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.SimulationModel#getSubModels <em>Sub Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Models</em>'.
	 * @see jaamsim.SimulationModel#getSubModels()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_SubModels();

	/**
	 * Returns the meta object for class '{@link jaamsim.Simulation <em>Simulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation</em>'.
	 * @see jaamsim.Simulation
	 * @generated
	 */
	EClass getSimulation();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Simulation#getRunDuration <em>Run Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Run Duration</em>'.
	 * @see jaamsim.Simulation#getRunDuration()
	 * @see #getSimulation()
	 * @generated
	 */
	EAttribute getSimulation_RunDuration();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Simulation#getInitializationDuration <em>Initialization Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialization Duration</em>'.
	 * @see jaamsim.Simulation#getInitializationDuration()
	 * @see #getSimulation()
	 * @generated
	 */
	EAttribute getSimulation_InitializationDuration();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Simulation#isExitAtStop <em>Exit At Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exit At Stop</em>'.
	 * @see jaamsim.Simulation#isExitAtStop()
	 * @see #getSimulation()
	 * @generated
	 */
	EAttribute getSimulation_ExitAtStop();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Simulation#getGlobalSubstreamSeed <em>Global Substream Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Global Substream Seed</em>'.
	 * @see jaamsim.Simulation#getGlobalSubstreamSeed()
	 * @see #getSimulation()
	 * @generated
	 */
	EAttribute getSimulation_GlobalSubstreamSeed();

	/**
	 * Returns the meta object for class '{@link jaamsim.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see jaamsim.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Unit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jaamsim.Unit#getName()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_Name();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Unit#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see jaamsim.Unit#getType()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_Type();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Unit#getConversionFactorToSI <em>Conversion Factor To SI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conversion Factor To SI</em>'.
	 * @see jaamsim.Unit#getConversionFactorToSI()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_ConversionFactorToSI();

	/**
	 * Returns the meta object for class '{@link jaamsim.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see jaamsim.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Expression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see jaamsim.Expression#getBody()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Body();

	/**
	 * Returns the meta object for class '{@link jaamsim.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see jaamsim.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jaamsim.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the containment reference '{@link jaamsim.Attribute#getInitValue <em>Init Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Value</em>'.
	 * @see jaamsim.Attribute#getInitValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_InitValue();

	/**
	 * Returns the meta object for class '{@link jaamsim.CustomOutput <em>Custom Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Output</em>'.
	 * @see jaamsim.CustomOutput
	 * @generated
	 */
	EClass getCustomOutput();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.CustomOutput#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jaamsim.CustomOutput#getName()
	 * @see #getCustomOutput()
	 * @generated
	 */
	EAttribute getCustomOutput_Name();

	/**
	 * Returns the meta object for the containment reference '{@link jaamsim.CustomOutput#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp</em>'.
	 * @see jaamsim.CustomOutput#getExp()
	 * @see #getCustomOutput()
	 * @generated
	 */
	EReference getCustomOutput_Exp();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.CustomOutput#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see jaamsim.CustomOutput#getUnit()
	 * @see #getCustomOutput()
	 * @generated
	 */
	EAttribute getCustomOutput_Unit();

	/**
	 * Returns the meta object for class '{@link jaamsim.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see jaamsim.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Entity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jaamsim.Entity#getName()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Name();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Entity#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see jaamsim.Entity#getDescription()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Description();

	/**
	 * Returns the meta object for the containment reference '{@link jaamsim.Entity#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Position</em>'.
	 * @see jaamsim.Entity#getPosition()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Position();

	/**
	 * Returns the meta object for the containment reference '{@link jaamsim.Entity#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Size</em>'.
	 * @see jaamsim.Entity#getSize()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Size();

	/**
	 * Returns the meta object for the containment reference '{@link jaamsim.Entity#getOrientation <em>Orientation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Orientation</em>'.
	 * @see jaamsim.Entity#getOrientation()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Orientation();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Entity#isMovable <em>Movable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Movable</em>'.
	 * @see jaamsim.Entity#isMovable()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Movable();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.Entity#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see jaamsim.Entity#getAttributes()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.Entity#getCustomOutputs <em>Custom Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Custom Outputs</em>'.
	 * @see jaamsim.Entity#getCustomOutputs()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_CustomOutputs();

	/**
	 * Returns the meta object for the reference '{@link jaamsim.Entity#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Region</em>'.
	 * @see jaamsim.Entity#getRegion()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Region();

	/**
	 * Returns the meta object for the reference '{@link jaamsim.Entity#getDisplayModel <em>Display Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Display Model</em>'.
	 * @see jaamsim.Entity#getDisplayModel()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_DisplayModel();

	/**
	 * Returns the meta object for class '{@link jaamsim.DisplayEntity <em>Display Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Entity</em>'.
	 * @see jaamsim.DisplayEntity
	 * @generated
	 */
	EClass getDisplayEntity();

	/**
	 * Returns the meta object for class '{@link jaamsim.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see jaamsim.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the reference list '{@link jaamsim.Component#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see jaamsim.Component#getIncoming()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Incoming();

	/**
	 * Returns the meta object for the reference list '{@link jaamsim.Component#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see jaamsim.Component#getOutgoing()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Outgoing();

	/**
	 * Returns the meta object for class '{@link jaamsim.LinkedComponent <em>Linked Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linked Component</em>'.
	 * @see jaamsim.LinkedComponent
	 * @generated
	 */
	EClass getLinkedComponent();

	/**
	 * Returns the meta object for the reference '{@link jaamsim.LinkedComponent#getNextComponent <em>Next Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Component</em>'.
	 * @see jaamsim.LinkedComponent#getNextComponent()
	 * @see #getLinkedComponent()
	 * @generated
	 */
	EReference getLinkedComponent_NextComponent();

	/**
	 * Returns the meta object for class '{@link jaamsim.SimEntity <em>Sim Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sim Entity</em>'.
	 * @see jaamsim.SimEntity
	 * @generated
	 */
	EClass getSimEntity();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.SimEntity#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial State</em>'.
	 * @see jaamsim.SimEntity#getInitialState()
	 * @see #getSimEntity()
	 * @generated
	 */
	EAttribute getSimEntity_InitialState();

	/**
	 * Returns the meta object for the attribute list '{@link jaamsim.SimEntity#getDefaultStates <em>Default States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Default States</em>'.
	 * @see jaamsim.SimEntity#getDefaultStates()
	 * @see #getSimEntity()
	 * @generated
	 */
	EAttribute getSimEntity_DefaultStates();

	/**
	 * Returns the meta object for class '{@link jaamsim.ProcessComponent <em>Process Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Component</em>'.
	 * @see jaamsim.ProcessComponent
	 * @generated
	 */
	EClass getProcessComponent();

	/**
	 * Returns the meta object for class '{@link jaamsim.EntityGenerator <em>Entity Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Generator</em>'.
	 * @see jaamsim.EntityGenerator
	 * @generated
	 */
	EClass getEntityGenerator();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.EntityGenerator#getFirstArrivalTime <em>First Arrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Arrival Time</em>'.
	 * @see jaamsim.EntityGenerator#getFirstArrivalTime()
	 * @see #getEntityGenerator()
	 * @generated
	 */
	EAttribute getEntityGenerator_FirstArrivalTime();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.EntityGenerator#getInterArrivalTime <em>Inter Arrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inter Arrival Time</em>'.
	 * @see jaamsim.EntityGenerator#getInterArrivalTime()
	 * @see #getEntityGenerator()
	 * @generated
	 */
	EAttribute getEntityGenerator_InterArrivalTime();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.EntityGenerator#getEntitiesPerArrival <em>Entities Per Arrival</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entities Per Arrival</em>'.
	 * @see jaamsim.EntityGenerator#getEntitiesPerArrival()
	 * @see #getEntityGenerator()
	 * @generated
	 */
	EAttribute getEntityGenerator_EntitiesPerArrival();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.EntityGenerator#getMaxNumber <em>Max Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Number</em>'.
	 * @see jaamsim.EntityGenerator#getMaxNumber()
	 * @see #getEntityGenerator()
	 * @generated
	 */
	EAttribute getEntityGenerator_MaxNumber();

	/**
	 * Returns the meta object for the reference '{@link jaamsim.EntityGenerator#getPrototype <em>Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prototype</em>'.
	 * @see jaamsim.EntityGenerator#getPrototype()
	 * @see #getEntityGenerator()
	 * @generated
	 */
	EReference getEntityGenerator_Prototype();

	/**
	 * Returns the meta object for class '{@link jaamsim.Queue <em>Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Queue</em>'.
	 * @see jaamsim.Queue
	 * @generated
	 */
	EClass getQueue();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Queue#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see jaamsim.Queue#getPriority()
	 * @see #getQueue()
	 * @generated
	 */
	EAttribute getQueue_Priority();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Queue#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Match</em>'.
	 * @see jaamsim.Queue#getMatch()
	 * @see #getQueue()
	 * @generated
	 */
	EAttribute getQueue_Match();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Queue#isFifo <em>Fifo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fifo</em>'.
	 * @see jaamsim.Queue#isFifo()
	 * @see #getQueue()
	 * @generated
	 */
	EAttribute getQueue_Fifo();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Queue#getRenegeTime <em>Renege Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Renege Time</em>'.
	 * @see jaamsim.Queue#getRenegeTime()
	 * @see #getQueue()
	 * @generated
	 */
	EAttribute getQueue_RenegeTime();

	/**
	 * Returns the meta object for the containment reference '{@link jaamsim.Queue#getRenegeCondition <em>Renege Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Renege Condition</em>'.
	 * @see jaamsim.Queue#getRenegeCondition()
	 * @see #getQueue()
	 * @generated
	 */
	EReference getQueue_RenegeCondition();

	/**
	 * Returns the meta object for the reference '{@link jaamsim.Queue#getRenegeDestination <em>Renege Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Renege Destination</em>'.
	 * @see jaamsim.Queue#getRenegeDestination()
	 * @see #getQueue()
	 * @generated
	 */
	EReference getQueue_RenegeDestination();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Queue#getMaxValidLength <em>Max Valid Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Valid Length</em>'.
	 * @see jaamsim.Queue#getMaxValidLength()
	 * @see #getQueue()
	 * @generated
	 */
	EAttribute getQueue_MaxValidLength();

	/**
	 * Returns the meta object for class '{@link jaamsim.EntityConveyor <em>Entity Conveyor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Conveyor</em>'.
	 * @see jaamsim.EntityConveyor
	 * @generated
	 */
	EClass getEntityConveyor();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.EntityConveyor#getTravelTime <em>Travel Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Travel Time</em>'.
	 * @see jaamsim.EntityConveyor#getTravelTime()
	 * @see #getEntityConveyor()
	 * @generated
	 */
	EAttribute getEntityConveyor_TravelTime();

	/**
	 * Returns the meta object for class '{@link jaamsim.Server <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server</em>'.
	 * @see jaamsim.Server
	 * @generated
	 */
	EClass getServer();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Server#getServiceTime <em>Service Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Time</em>'.
	 * @see jaamsim.Server#getServiceTime()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_ServiceTime();

	/**
	 * Returns the meta object for the reference '{@link jaamsim.Server#getWaitQueue <em>Wait Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wait Queue</em>'.
	 * @see jaamsim.Server#getWaitQueue()
	 * @see #getServer()
	 * @generated
	 */
	EReference getServer_WaitQueue();

	/**
	 * Returns the meta object for class '{@link jaamsim.EntitySink <em>Entity Sink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Sink</em>'.
	 * @see jaamsim.EntitySink
	 * @generated
	 */
	EClass getEntitySink();

	/**
	 * Returns the meta object for class '{@link jaamsim.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch</em>'.
	 * @see jaamsim.Branch
	 * @generated
	 */
	EClass getBranch();

	/**
	 * Returns the meta object for the reference list '{@link jaamsim.Branch#getNextComponentList <em>Next Component List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Next Component List</em>'.
	 * @see jaamsim.Branch#getNextComponentList()
	 * @see #getBranch()
	 * @generated
	 */
	EReference getBranch_NextComponentList();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Branch#getChoice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Choice</em>'.
	 * @see jaamsim.Branch#getChoice()
	 * @see #getBranch()
	 * @generated
	 */
	EAttribute getBranch_Choice();

	/**
	 * Returns the meta object for class '{@link jaamsim.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see jaamsim.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Resource#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see jaamsim.Resource#getCapacity()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Capacity();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.Resource#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see jaamsim.Resource#getUnits()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Units();

	/**
	 * Returns the meta object for class '{@link jaamsim.ResourceUnit <em>Resource Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Unit</em>'.
	 * @see jaamsim.ResourceUnit
	 * @generated
	 */
	EClass getResourceUnit();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.ResourceUnit#isAvailable <em>Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Available</em>'.
	 * @see jaamsim.ResourceUnit#isAvailable()
	 * @see #getResourceUnit()
	 * @generated
	 */
	EAttribute getResourceUnit_Available();

	/**
	 * Returns the meta object for the reference '{@link jaamsim.ResourceUnit#getAssignedTo <em>Assigned To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assigned To</em>'.
	 * @see jaamsim.ResourceUnit#getAssignedTo()
	 * @see #getResourceUnit()
	 * @generated
	 */
	EReference getResourceUnit_AssignedTo();

	/**
	 * Returns the meta object for class '{@link jaamsim.ResourcePool <em>Resource Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Pool</em>'.
	 * @see jaamsim.ResourcePool
	 * @generated
	 */
	EClass getResourcePool();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.ResourcePool#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see jaamsim.ResourcePool#getResources()
	 * @see #getResourcePool()
	 * @generated
	 */
	EReference getResourcePool_Resources();

	/**
	 * Returns the meta object for class '{@link jaamsim.Seize <em>Seize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Seize</em>'.
	 * @see jaamsim.Seize
	 * @generated
	 */
	EClass getSeize();

	/**
	 * Returns the meta object for the reference list '{@link jaamsim.Seize#getRequiredUnits <em>Required Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required Units</em>'.
	 * @see jaamsim.Seize#getRequiredUnits()
	 * @see #getSeize()
	 * @generated
	 */
	EReference getSeize_RequiredUnits();

	/**
	 * Returns the meta object for class '{@link jaamsim.Release <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release</em>'.
	 * @see jaamsim.Release
	 * @generated
	 */
	EClass getRelease();

	/**
	 * Returns the meta object for the reference list '{@link jaamsim.Release#getReleasedUnits <em>Released Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Released Units</em>'.
	 * @see jaamsim.Release#getReleasedUnits()
	 * @see #getRelease()
	 * @generated
	 */
	EReference getRelease_ReleasedUnits();

	/**
	 * Returns the meta object for class '{@link jaamsim.Distribution <em>Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distribution</em>'.
	 * @see jaamsim.Distribution
	 * @generated
	 */
	EClass getDistribution();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.Distribution#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see jaamsim.Distribution#getKind()
	 * @see #getDistribution()
	 * @generated
	 */
	EAttribute getDistribution_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.Distribution#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see jaamsim.Distribution#getParameters()
	 * @see #getDistribution()
	 * @generated
	 */
	EReference getDistribution_Parameters();

	/**
	 * Returns the meta object for class '{@link jaamsim.DistributionParameter <em>Distribution Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distribution Parameter</em>'.
	 * @see jaamsim.DistributionParameter
	 * @generated
	 */
	EClass getDistributionParameter();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.DistributionParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jaamsim.DistributionParameter#getName()
	 * @see #getDistributionParameter()
	 * @generated
	 */
	EAttribute getDistributionParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.DistributionParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see jaamsim.DistributionParameter#getValue()
	 * @see #getDistributionParameter()
	 * @generated
	 */
	EAttribute getDistributionParameter_Value();

	/**
	 * Returns the meta object for the attribute '{@link jaamsim.DistributionParameter#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see jaamsim.DistributionParameter#getUnit()
	 * @see #getDistributionParameter()
	 * @generated
	 */
	EAttribute getDistributionParameter_Unit();

	/**
	 * Returns the meta object for class '{@link jaamsim.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region</em>'.
	 * @see jaamsim.Region
	 * @generated
	 */
	EClass getRegion();

	/**
	 * Returns the meta object for class '{@link jaamsim.DisplayModel <em>Display Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Model</em>'.
	 * @see jaamsim.DisplayModel
	 * @generated
	 */
	EClass getDisplayModel();

	/**
	 * Returns the meta object for class '{@link jaamsim.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see jaamsim.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the containment reference '{@link jaamsim.View#getCameraPosition <em>Camera Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Camera Position</em>'.
	 * @see jaamsim.View#getCameraPosition()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_CameraPosition();

	/**
	 * Returns the meta object for the containment reference '{@link jaamsim.View#getCameraTarget <em>Camera Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Camera Target</em>'.
	 * @see jaamsim.View#getCameraTarget()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_CameraTarget();

	/**
	 * Returns the meta object for class '{@link jaamsim.SubModel <em>Sub Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Model</em>'.
	 * @see jaamsim.SubModel
	 * @generated
	 */
	EClass getSubModel();

	/**
	 * Returns the meta object for the containment reference list '{@link jaamsim.SubModel#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see jaamsim.SubModel#getComponents()
	 * @see #getSubModel()
	 * @generated
	 */
	EReference getSubModel_Components();

	/**
	 * Returns the meta object for class '{@link jaamsim.SubModelStart <em>Sub Model Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Model Start</em>'.
	 * @see jaamsim.SubModelStart
	 * @generated
	 */
	EClass getSubModelStart();

	/**
	 * Returns the meta object for class '{@link jaamsim.SubModelEnd <em>Sub Model End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Model End</em>'.
	 * @see jaamsim.SubModelEnd
	 * @generated
	 */
	EClass getSubModelEnd();

	/**
	 * Returns the meta object for enum '{@link jaamsim.UnitType <em>Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unit Type</em>'.
	 * @see jaamsim.UnitType
	 * @generated
	 */
	EEnum getUnitType();

	/**
	 * Returns the meta object for enum '{@link jaamsim.SimEntityState <em>Sim Entity State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sim Entity State</em>'.
	 * @see jaamsim.SimEntityState
	 * @generated
	 */
	EEnum getSimEntityState();

	/**
	 * Returns the meta object for enum '{@link jaamsim.DistributionKind <em>Distribution Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Distribution Kind</em>'.
	 * @see jaamsim.DistributionKind
	 * @generated
	 */
	EEnum getDistributionKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JaamsimFactory getJaamsimFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link jaamsim.impl.Point3DImpl <em>Point3 D</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.Point3DImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getPoint3D()
		 * @generated
		 */
		EClass POINT3_D = eINSTANCE.getPoint3D();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT3_D__X = eINSTANCE.getPoint3D_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT3_D__Y = eINSTANCE.getPoint3D_Y();

		/**
		 * The meta object literal for the '<em><b>Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT3_D__Z = eINSTANCE.getPoint3D_Z();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.SimulationModelImpl <em>Simulation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.SimulationModelImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getSimulationModel()
		 * @generated
		 */
		EClass SIMULATION_MODEL = eINSTANCE.getSimulationModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_MODEL__NAME = eINSTANCE.getSimulationModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_MODEL__DESCRIPTION = eINSTANCE.getSimulationModel_Description();

		/**
		 * The meta object literal for the '<em><b>Simulation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__SIMULATION = eINSTANCE.getSimulationModel_Simulation();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__UNITS = eINSTANCE.getSimulationModel_Units();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__ENTITIES = eINSTANCE.getSimulationModel_Entities();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__COMPONENTS = eINSTANCE.getSimulationModel_Components();

		/**
		 * The meta object literal for the '<em><b>Distributions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__DISTRIBUTIONS = eINSTANCE.getSimulationModel_Distributions();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__RESOURCES = eINSTANCE.getSimulationModel_Resources();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__VIEWS = eINSTANCE.getSimulationModel_Views();

		/**
		 * The meta object literal for the '<em><b>Sub Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__SUB_MODELS = eINSTANCE.getSimulationModel_SubModels();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.SimulationImpl <em>Simulation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.SimulationImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getSimulation()
		 * @generated
		 */
		EClass SIMULATION = eINSTANCE.getSimulation();

		/**
		 * The meta object literal for the '<em><b>Run Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION__RUN_DURATION = eINSTANCE.getSimulation_RunDuration();

		/**
		 * The meta object literal for the '<em><b>Initialization Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION__INITIALIZATION_DURATION = eINSTANCE.getSimulation_InitializationDuration();

		/**
		 * The meta object literal for the '<em><b>Exit At Stop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION__EXIT_AT_STOP = eINSTANCE.getSimulation_ExitAtStop();

		/**
		 * The meta object literal for the '<em><b>Global Substream Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION__GLOBAL_SUBSTREAM_SEED = eINSTANCE.getSimulation_GlobalSubstreamSeed();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.UnitImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__NAME = eINSTANCE.getUnit_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__TYPE = eINSTANCE.getUnit_Type();

		/**
		 * The meta object literal for the '<em><b>Conversion Factor To SI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__CONVERSION_FACTOR_TO_SI = eINSTANCE.getUnit_ConversionFactorToSI();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.ExpressionImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__BODY = eINSTANCE.getExpression_Body();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.AttributeImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Init Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__INIT_VALUE = eINSTANCE.getAttribute_InitValue();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.CustomOutputImpl <em>Custom Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.CustomOutputImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getCustomOutput()
		 * @generated
		 */
		EClass CUSTOM_OUTPUT = eINSTANCE.getCustomOutput();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_OUTPUT__NAME = eINSTANCE.getCustomOutput_Name();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOM_OUTPUT__EXP = eINSTANCE.getCustomOutput_Exp();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_OUTPUT__UNIT = eINSTANCE.getCustomOutput_Unit();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.EntityImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__DESCRIPTION = eINSTANCE.getEntity_Description();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__POSITION = eINSTANCE.getEntity_Position();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__SIZE = eINSTANCE.getEntity_Size();

		/**
		 * The meta object literal for the '<em><b>Orientation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__ORIENTATION = eINSTANCE.getEntity_Orientation();

		/**
		 * The meta object literal for the '<em><b>Movable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__MOVABLE = eINSTANCE.getEntity_Movable();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__ATTRIBUTES = eINSTANCE.getEntity_Attributes();

		/**
		 * The meta object literal for the '<em><b>Custom Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__CUSTOM_OUTPUTS = eINSTANCE.getEntity_CustomOutputs();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__REGION = eINSTANCE.getEntity_Region();

		/**
		 * The meta object literal for the '<em><b>Display Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__DISPLAY_MODEL = eINSTANCE.getEntity_DisplayModel();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.DisplayEntityImpl <em>Display Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.DisplayEntityImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getDisplayEntity()
		 * @generated
		 */
		EClass DISPLAY_ENTITY = eINSTANCE.getDisplayEntity();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.ComponentImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__INCOMING = eINSTANCE.getComponent_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__OUTGOING = eINSTANCE.getComponent_Outgoing();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.LinkedComponentImpl <em>Linked Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.LinkedComponentImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getLinkedComponent()
		 * @generated
		 */
		EClass LINKED_COMPONENT = eINSTANCE.getLinkedComponent();

		/**
		 * The meta object literal for the '<em><b>Next Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINKED_COMPONENT__NEXT_COMPONENT = eINSTANCE.getLinkedComponent_NextComponent();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.SimEntityImpl <em>Sim Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.SimEntityImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getSimEntity()
		 * @generated
		 */
		EClass SIM_ENTITY = eINSTANCE.getSimEntity();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_ENTITY__INITIAL_STATE = eINSTANCE.getSimEntity_InitialState();

		/**
		 * The meta object literal for the '<em><b>Default States</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_ENTITY__DEFAULT_STATES = eINSTANCE.getSimEntity_DefaultStates();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.ProcessComponentImpl <em>Process Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.ProcessComponentImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getProcessComponent()
		 * @generated
		 */
		EClass PROCESS_COMPONENT = eINSTANCE.getProcessComponent();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.EntityGeneratorImpl <em>Entity Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.EntityGeneratorImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getEntityGenerator()
		 * @generated
		 */
		EClass ENTITY_GENERATOR = eINSTANCE.getEntityGenerator();

		/**
		 * The meta object literal for the '<em><b>First Arrival Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_GENERATOR__FIRST_ARRIVAL_TIME = eINSTANCE.getEntityGenerator_FirstArrivalTime();

		/**
		 * The meta object literal for the '<em><b>Inter Arrival Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_GENERATOR__INTER_ARRIVAL_TIME = eINSTANCE.getEntityGenerator_InterArrivalTime();

		/**
		 * The meta object literal for the '<em><b>Entities Per Arrival</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_GENERATOR__ENTITIES_PER_ARRIVAL = eINSTANCE.getEntityGenerator_EntitiesPerArrival();

		/**
		 * The meta object literal for the '<em><b>Max Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_GENERATOR__MAX_NUMBER = eINSTANCE.getEntityGenerator_MaxNumber();

		/**
		 * The meta object literal for the '<em><b>Prototype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_GENERATOR__PROTOTYPE = eINSTANCE.getEntityGenerator_Prototype();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.QueueImpl <em>Queue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.QueueImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getQueue()
		 * @generated
		 */
		EClass QUEUE = eINSTANCE.getQueue();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUEUE__PRIORITY = eINSTANCE.getQueue_Priority();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUEUE__MATCH = eINSTANCE.getQueue_Match();

		/**
		 * The meta object literal for the '<em><b>Fifo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUEUE__FIFO = eINSTANCE.getQueue_Fifo();

		/**
		 * The meta object literal for the '<em><b>Renege Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUEUE__RENEGE_TIME = eINSTANCE.getQueue_RenegeTime();

		/**
		 * The meta object literal for the '<em><b>Renege Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUEUE__RENEGE_CONDITION = eINSTANCE.getQueue_RenegeCondition();

		/**
		 * The meta object literal for the '<em><b>Renege Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUEUE__RENEGE_DESTINATION = eINSTANCE.getQueue_RenegeDestination();

		/**
		 * The meta object literal for the '<em><b>Max Valid Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUEUE__MAX_VALID_LENGTH = eINSTANCE.getQueue_MaxValidLength();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.EntityConveyorImpl <em>Entity Conveyor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.EntityConveyorImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getEntityConveyor()
		 * @generated
		 */
		EClass ENTITY_CONVEYOR = eINSTANCE.getEntityConveyor();

		/**
		 * The meta object literal for the '<em><b>Travel Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_CONVEYOR__TRAVEL_TIME = eINSTANCE.getEntityConveyor_TravelTime();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.ServerImpl <em>Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.ServerImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getServer()
		 * @generated
		 */
		EClass SERVER = eINSTANCE.getServer();

		/**
		 * The meta object literal for the '<em><b>Service Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__SERVICE_TIME = eINSTANCE.getServer_ServiceTime();

		/**
		 * The meta object literal for the '<em><b>Wait Queue</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER__WAIT_QUEUE = eINSTANCE.getServer_WaitQueue();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.EntitySinkImpl <em>Entity Sink</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.EntitySinkImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getEntitySink()
		 * @generated
		 */
		EClass ENTITY_SINK = eINSTANCE.getEntitySink();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.BranchImpl <em>Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.BranchImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getBranch()
		 * @generated
		 */
		EClass BRANCH = eINSTANCE.getBranch();

		/**
		 * The meta object literal for the '<em><b>Next Component List</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH__NEXT_COMPONENT_LIST = eINSTANCE.getBranch_NextComponentList();

		/**
		 * The meta object literal for the '<em><b>Choice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BRANCH__CHOICE = eINSTANCE.getBranch_Choice();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.ResourceImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__CAPACITY = eINSTANCE.getResource_Capacity();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__UNITS = eINSTANCE.getResource_Units();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.ResourceUnitImpl <em>Resource Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.ResourceUnitImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getResourceUnit()
		 * @generated
		 */
		EClass RESOURCE_UNIT = eINSTANCE.getResourceUnit();

		/**
		 * The meta object literal for the '<em><b>Available</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_UNIT__AVAILABLE = eINSTANCE.getResourceUnit_Available();

		/**
		 * The meta object literal for the '<em><b>Assigned To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_UNIT__ASSIGNED_TO = eINSTANCE.getResourceUnit_AssignedTo();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.ResourcePoolImpl <em>Resource Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.ResourcePoolImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getResourcePool()
		 * @generated
		 */
		EClass RESOURCE_POOL = eINSTANCE.getResourcePool();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_POOL__RESOURCES = eINSTANCE.getResourcePool_Resources();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.SeizeImpl <em>Seize</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.SeizeImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getSeize()
		 * @generated
		 */
		EClass SEIZE = eINSTANCE.getSeize();

		/**
		 * The meta object literal for the '<em><b>Required Units</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEIZE__REQUIRED_UNITS = eINSTANCE.getSeize_RequiredUnits();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.ReleaseImpl <em>Release</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.ReleaseImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getRelease()
		 * @generated
		 */
		EClass RELEASE = eINSTANCE.getRelease();

		/**
		 * The meta object literal for the '<em><b>Released Units</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELEASE__RELEASED_UNITS = eINSTANCE.getRelease_ReleasedUnits();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.DistributionImpl <em>Distribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.DistributionImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getDistribution()
		 * @generated
		 */
		EClass DISTRIBUTION = eINSTANCE.getDistribution();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTRIBUTION__KIND = eINSTANCE.getDistribution_Kind();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTRIBUTION__PARAMETERS = eINSTANCE.getDistribution_Parameters();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.DistributionParameterImpl <em>Distribution Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.DistributionParameterImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getDistributionParameter()
		 * @generated
		 */
		EClass DISTRIBUTION_PARAMETER = eINSTANCE.getDistributionParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTRIBUTION_PARAMETER__NAME = eINSTANCE.getDistributionParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTRIBUTION_PARAMETER__VALUE = eINSTANCE.getDistributionParameter_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTRIBUTION_PARAMETER__UNIT = eINSTANCE.getDistributionParameter_Unit();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.RegionImpl <em>Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.RegionImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getRegion()
		 * @generated
		 */
		EClass REGION = eINSTANCE.getRegion();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.DisplayModelImpl <em>Display Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.DisplayModelImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getDisplayModel()
		 * @generated
		 */
		EClass DISPLAY_MODEL = eINSTANCE.getDisplayModel();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.ViewImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Camera Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__CAMERA_POSITION = eINSTANCE.getView_CameraPosition();

		/**
		 * The meta object literal for the '<em><b>Camera Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__CAMERA_TARGET = eINSTANCE.getView_CameraTarget();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.SubModelImpl <em>Sub Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.SubModelImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getSubModel()
		 * @generated
		 */
		EClass SUB_MODEL = eINSTANCE.getSubModel();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_MODEL__COMPONENTS = eINSTANCE.getSubModel_Components();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.SubModelStartImpl <em>Sub Model Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.SubModelStartImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getSubModelStart()
		 * @generated
		 */
		EClass SUB_MODEL_START = eINSTANCE.getSubModelStart();

		/**
		 * The meta object literal for the '{@link jaamsim.impl.SubModelEndImpl <em>Sub Model End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.impl.SubModelEndImpl
		 * @see jaamsim.impl.JaamsimPackageImpl#getSubModelEnd()
		 * @generated
		 */
		EClass SUB_MODEL_END = eINSTANCE.getSubModelEnd();

		/**
		 * The meta object literal for the '{@link jaamsim.UnitType <em>Unit Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.UnitType
		 * @see jaamsim.impl.JaamsimPackageImpl#getUnitType()
		 * @generated
		 */
		EEnum UNIT_TYPE = eINSTANCE.getUnitType();

		/**
		 * The meta object literal for the '{@link jaamsim.SimEntityState <em>Sim Entity State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.SimEntityState
		 * @see jaamsim.impl.JaamsimPackageImpl#getSimEntityState()
		 * @generated
		 */
		EEnum SIM_ENTITY_STATE = eINSTANCE.getSimEntityState();

		/**
		 * The meta object literal for the '{@link jaamsim.DistributionKind <em>Distribution Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jaamsim.DistributionKind
		 * @see jaamsim.impl.JaamsimPackageImpl#getDistributionKind()
		 * @generated
		 */
		EEnum DISTRIBUTION_KIND = eINSTANCE.getDistributionKind();

	}

} //JaamsimPackage
