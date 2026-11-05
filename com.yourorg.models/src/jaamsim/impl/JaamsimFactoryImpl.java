/**
 */
package jaamsim.impl;

import jaamsim.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JaamsimFactoryImpl extends EFactoryImpl implements JaamsimFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JaamsimFactory init() {
		try {
			JaamsimFactory theJaamsimFactory = (JaamsimFactory)EPackage.Registry.INSTANCE.getEFactory(JaamsimPackage.eNS_URI);
			if (theJaamsimFactory != null) {
				return theJaamsimFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JaamsimFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JaamsimFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JaamsimPackage.POINT3_D: return createPoint3D();
			case JaamsimPackage.SIMULATION_MODEL: return createSimulationModel();
			case JaamsimPackage.SIMULATION: return createSimulation();
			case JaamsimPackage.UNIT: return createUnit();
			case JaamsimPackage.EXPRESSION: return createExpression();
			case JaamsimPackage.ATTRIBUTE: return createAttribute();
			case JaamsimPackage.CUSTOM_OUTPUT: return createCustomOutput();
			case JaamsimPackage.SIM_ENTITY: return createSimEntity();
			case JaamsimPackage.ENTITY_GENERATOR: return createEntityGenerator();
			case JaamsimPackage.QUEUE: return createQueue();
			case JaamsimPackage.ENTITY_CONVEYOR: return createEntityConveyor();
			case JaamsimPackage.SERVER: return createServer();
			case JaamsimPackage.ENTITY_SINK: return createEntitySink();
			case JaamsimPackage.BRANCH: return createBranch();
			case JaamsimPackage.RESOURCE: return createResource();
			case JaamsimPackage.RESOURCE_UNIT: return createResourceUnit();
			case JaamsimPackage.RESOURCE_POOL: return createResourcePool();
			case JaamsimPackage.SEIZE: return createSeize();
			case JaamsimPackage.RELEASE: return createRelease();
			case JaamsimPackage.DISTRIBUTION: return createDistribution();
			case JaamsimPackage.DISTRIBUTION_PARAMETER: return createDistributionParameter();
			case JaamsimPackage.REGION: return createRegion();
			case JaamsimPackage.DISPLAY_MODEL: return createDisplayModel();
			case JaamsimPackage.VIEW: return createView();
			case JaamsimPackage.SUB_MODEL: return createSubModel();
			case JaamsimPackage.SUB_MODEL_START: return createSubModelStart();
			case JaamsimPackage.SUB_MODEL_END: return createSubModelEnd();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case JaamsimPackage.UNIT_TYPE:
				return createUnitTypeFromString(eDataType, initialValue);
			case JaamsimPackage.SIM_ENTITY_STATE:
				return createSimEntityStateFromString(eDataType, initialValue);
			case JaamsimPackage.DISTRIBUTION_KIND:
				return createDistributionKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case JaamsimPackage.UNIT_TYPE:
				return convertUnitTypeToString(eDataType, instanceValue);
			case JaamsimPackage.SIM_ENTITY_STATE:
				return convertSimEntityStateToString(eDataType, instanceValue);
			case JaamsimPackage.DISTRIBUTION_KIND:
				return convertDistributionKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Point3D createPoint3D() {
		Point3DImpl point3D = new Point3DImpl();
		return point3D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimulationModel createSimulationModel() {
		SimulationModelImpl simulationModel = new SimulationModelImpl();
		return simulationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Simulation createSimulation() {
		SimulationImpl simulation = new SimulationImpl();
		return simulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Unit createUnit() {
		UnitImpl unit = new UnitImpl();
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CustomOutput createCustomOutput() {
		CustomOutputImpl customOutput = new CustomOutputImpl();
		return customOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimEntity createSimEntity() {
		SimEntityImpl simEntity = new SimEntityImpl();
		return simEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntityGenerator createEntityGenerator() {
		EntityGeneratorImpl entityGenerator = new EntityGeneratorImpl();
		return entityGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Queue createQueue() {
		QueueImpl queue = new QueueImpl();
		return queue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntityConveyor createEntityConveyor() {
		EntityConveyorImpl entityConveyor = new EntityConveyorImpl();
		return entityConveyor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Server createServer() {
		ServerImpl server = new ServerImpl();
		return server;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntitySink createEntitySink() {
		EntitySinkImpl entitySink = new EntitySinkImpl();
		return entitySink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Branch createBranch() {
		BranchImpl branch = new BranchImpl();
		return branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceUnit createResourceUnit() {
		ResourceUnitImpl resourceUnit = new ResourceUnitImpl();
		return resourceUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourcePool createResourcePool() {
		ResourcePoolImpl resourcePool = new ResourcePoolImpl();
		return resourcePool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Seize createSeize() {
		SeizeImpl seize = new SeizeImpl();
		return seize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Release createRelease() {
		ReleaseImpl release = new ReleaseImpl();
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Distribution createDistribution() {
		DistributionImpl distribution = new DistributionImpl();
		return distribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DistributionParameter createDistributionParameter() {
		DistributionParameterImpl distributionParameter = new DistributionParameterImpl();
		return distributionParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Region createRegion() {
		RegionImpl region = new RegionImpl();
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DisplayModel createDisplayModel() {
		DisplayModelImpl displayModel = new DisplayModelImpl();
		return displayModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public View createView() {
		ViewImpl view = new ViewImpl();
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubModel createSubModel() {
		SubModelImpl subModel = new SubModelImpl();
		return subModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubModelStart createSubModelStart() {
		SubModelStartImpl subModelStart = new SubModelStartImpl();
		return subModelStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubModelEnd createSubModelEnd() {
		SubModelEndImpl subModelEnd = new SubModelEndImpl();
		return subModelEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitType createUnitTypeFromString(EDataType eDataType, String initialValue) {
		UnitType result = UnitType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnitTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimEntityState createSimEntityStateFromString(EDataType eDataType, String initialValue) {
		SimEntityState result = SimEntityState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSimEntityStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistributionKind createDistributionKindFromString(EDataType eDataType, String initialValue) {
		DistributionKind result = DistributionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDistributionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JaamsimPackage getJaamsimPackage() {
		return (JaamsimPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JaamsimPackage getPackage() {
		return JaamsimPackage.eINSTANCE;
	}

} //JaamsimFactoryImpl
