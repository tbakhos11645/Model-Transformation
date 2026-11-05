/**
 */
package jaamsim.util;

import jaamsim.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see jaamsim.JaamsimPackage
 * @generated
 */
public class JaamsimSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JaamsimPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JaamsimSwitch() {
		if (modelPackage == null) {
			modelPackage = JaamsimPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case JaamsimPackage.POINT3_D: {
				Point3D point3D = (Point3D)theEObject;
				T result = casePoint3D(point3D);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.SIMULATION_MODEL: {
				SimulationModel simulationModel = (SimulationModel)theEObject;
				T result = caseSimulationModel(simulationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.SIMULATION: {
				Simulation simulation = (Simulation)theEObject;
				T result = caseSimulation(simulation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.UNIT: {
				Unit unit = (Unit)theEObject;
				T result = caseUnit(unit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.ATTRIBUTE: {
				Attribute attribute = (Attribute)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.CUSTOM_OUTPUT: {
				CustomOutput customOutput = (CustomOutput)theEObject;
				T result = caseCustomOutput(customOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.ENTITY: {
				Entity entity = (Entity)theEObject;
				T result = caseEntity(entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.DISPLAY_ENTITY: {
				DisplayEntity displayEntity = (DisplayEntity)theEObject;
				T result = caseDisplayEntity(displayEntity);
				if (result == null) result = caseEntity(displayEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.COMPONENT: {
				Component component = (Component)theEObject;
				T result = caseComponent(component);
				if (result == null) result = caseDisplayEntity(component);
				if (result == null) result = caseEntity(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.LINKED_COMPONENT: {
				LinkedComponent linkedComponent = (LinkedComponent)theEObject;
				T result = caseLinkedComponent(linkedComponent);
				if (result == null) result = caseComponent(linkedComponent);
				if (result == null) result = caseDisplayEntity(linkedComponent);
				if (result == null) result = caseEntity(linkedComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.SIM_ENTITY: {
				SimEntity simEntity = (SimEntity)theEObject;
				T result = caseSimEntity(simEntity);
				if (result == null) result = caseDisplayEntity(simEntity);
				if (result == null) result = caseEntity(simEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.PROCESS_COMPONENT: {
				ProcessComponent processComponent = (ProcessComponent)theEObject;
				T result = caseProcessComponent(processComponent);
				if (result == null) result = caseLinkedComponent(processComponent);
				if (result == null) result = caseComponent(processComponent);
				if (result == null) result = caseDisplayEntity(processComponent);
				if (result == null) result = caseEntity(processComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.ENTITY_GENERATOR: {
				EntityGenerator entityGenerator = (EntityGenerator)theEObject;
				T result = caseEntityGenerator(entityGenerator);
				if (result == null) result = caseProcessComponent(entityGenerator);
				if (result == null) result = caseLinkedComponent(entityGenerator);
				if (result == null) result = caseComponent(entityGenerator);
				if (result == null) result = caseDisplayEntity(entityGenerator);
				if (result == null) result = caseEntity(entityGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.QUEUE: {
				Queue queue = (Queue)theEObject;
				T result = caseQueue(queue);
				if (result == null) result = caseProcessComponent(queue);
				if (result == null) result = caseLinkedComponent(queue);
				if (result == null) result = caseComponent(queue);
				if (result == null) result = caseDisplayEntity(queue);
				if (result == null) result = caseEntity(queue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.ENTITY_CONVEYOR: {
				EntityConveyor entityConveyor = (EntityConveyor)theEObject;
				T result = caseEntityConveyor(entityConveyor);
				if (result == null) result = caseProcessComponent(entityConveyor);
				if (result == null) result = caseLinkedComponent(entityConveyor);
				if (result == null) result = caseComponent(entityConveyor);
				if (result == null) result = caseDisplayEntity(entityConveyor);
				if (result == null) result = caseEntity(entityConveyor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.SERVER: {
				Server server = (Server)theEObject;
				T result = caseServer(server);
				if (result == null) result = caseProcessComponent(server);
				if (result == null) result = caseLinkedComponent(server);
				if (result == null) result = caseComponent(server);
				if (result == null) result = caseDisplayEntity(server);
				if (result == null) result = caseEntity(server);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.ENTITY_SINK: {
				EntitySink entitySink = (EntitySink)theEObject;
				T result = caseEntitySink(entitySink);
				if (result == null) result = caseProcessComponent(entitySink);
				if (result == null) result = caseLinkedComponent(entitySink);
				if (result == null) result = caseComponent(entitySink);
				if (result == null) result = caseDisplayEntity(entitySink);
				if (result == null) result = caseEntity(entitySink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.BRANCH: {
				Branch branch = (Branch)theEObject;
				T result = caseBranch(branch);
				if (result == null) result = caseProcessComponent(branch);
				if (result == null) result = caseLinkedComponent(branch);
				if (result == null) result = caseComponent(branch);
				if (result == null) result = caseDisplayEntity(branch);
				if (result == null) result = caseEntity(branch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = caseDisplayEntity(resource);
				if (result == null) result = caseEntity(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.RESOURCE_UNIT: {
				ResourceUnit resourceUnit = (ResourceUnit)theEObject;
				T result = caseResourceUnit(resourceUnit);
				if (result == null) result = caseDisplayEntity(resourceUnit);
				if (result == null) result = caseEntity(resourceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.RESOURCE_POOL: {
				ResourcePool resourcePool = (ResourcePool)theEObject;
				T result = caseResourcePool(resourcePool);
				if (result == null) result = caseDisplayEntity(resourcePool);
				if (result == null) result = caseEntity(resourcePool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.SEIZE: {
				Seize seize = (Seize)theEObject;
				T result = caseSeize(seize);
				if (result == null) result = caseProcessComponent(seize);
				if (result == null) result = caseLinkedComponent(seize);
				if (result == null) result = caseComponent(seize);
				if (result == null) result = caseDisplayEntity(seize);
				if (result == null) result = caseEntity(seize);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.RELEASE: {
				Release release = (Release)theEObject;
				T result = caseRelease(release);
				if (result == null) result = caseProcessComponent(release);
				if (result == null) result = caseLinkedComponent(release);
				if (result == null) result = caseComponent(release);
				if (result == null) result = caseDisplayEntity(release);
				if (result == null) result = caseEntity(release);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.DISTRIBUTION: {
				Distribution distribution = (Distribution)theEObject;
				T result = caseDistribution(distribution);
				if (result == null) result = caseEntity(distribution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.DISTRIBUTION_PARAMETER: {
				DistributionParameter distributionParameter = (DistributionParameter)theEObject;
				T result = caseDistributionParameter(distributionParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.REGION: {
				Region region = (Region)theEObject;
				T result = caseRegion(region);
				if (result == null) result = caseEntity(region);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.DISPLAY_MODEL: {
				DisplayModel displayModel = (DisplayModel)theEObject;
				T result = caseDisplayModel(displayModel);
				if (result == null) result = caseEntity(displayModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.VIEW: {
				View view = (View)theEObject;
				T result = caseView(view);
				if (result == null) result = caseEntity(view);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.SUB_MODEL: {
				SubModel subModel = (SubModel)theEObject;
				T result = caseSubModel(subModel);
				if (result == null) result = caseDisplayEntity(subModel);
				if (result == null) result = caseEntity(subModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.SUB_MODEL_START: {
				SubModelStart subModelStart = (SubModelStart)theEObject;
				T result = caseSubModelStart(subModelStart);
				if (result == null) result = caseProcessComponent(subModelStart);
				if (result == null) result = caseLinkedComponent(subModelStart);
				if (result == null) result = caseComponent(subModelStart);
				if (result == null) result = caseDisplayEntity(subModelStart);
				if (result == null) result = caseEntity(subModelStart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JaamsimPackage.SUB_MODEL_END: {
				SubModelEnd subModelEnd = (SubModelEnd)theEObject;
				T result = caseSubModelEnd(subModelEnd);
				if (result == null) result = caseProcessComponent(subModelEnd);
				if (result == null) result = caseLinkedComponent(subModelEnd);
				if (result == null) result = caseComponent(subModelEnd);
				if (result == null) result = caseDisplayEntity(subModelEnd);
				if (result == null) result = caseEntity(subModelEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point3 D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point3 D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePoint3D(Point3D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simulation Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simulation Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimulationModel(SimulationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simulation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simulation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimulation(Simulation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomOutput(CustomOutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Display Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Display Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisplayEntity(DisplayEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linked Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linked Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkedComponent(LinkedComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sim Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sim Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimEntity(SimEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessComponent(ProcessComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityGenerator(EntityGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Queue</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Queue</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueue(Queue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Conveyor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Conveyor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityConveyor(EntityConveyor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Server</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServer(Server object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Sink</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Sink</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitySink(EntitySink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBranch(Branch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceUnit(ResourceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourcePool(ResourcePool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Seize</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Seize</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeize(Seize object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Release</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Release</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelease(Release object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Distribution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDistribution(Distribution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Distribution Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Distribution Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDistributionParameter(DistributionParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegion(Region object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Display Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Display Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisplayModel(DisplayModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseView(View object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubModel(SubModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Model Start</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Model Start</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubModelStart(SubModelStart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Model End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Model End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubModelEnd(SubModelEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //JaamsimSwitch
