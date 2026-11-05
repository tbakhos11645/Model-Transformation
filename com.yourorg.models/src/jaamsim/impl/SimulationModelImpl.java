/**
 */
package jaamsim.impl;

import jaamsim.Component;
import jaamsim.Distribution;
import jaamsim.Entity;
import jaamsim.JaamsimPackage;
import jaamsim.Resource;
import jaamsim.Simulation;
import jaamsim.SimulationModel;
import jaamsim.SubModel;
import jaamsim.Unit;
import jaamsim.View;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.SimulationModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationModelImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationModelImpl#getSimulation <em>Simulation</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationModelImpl#getUnits <em>Units</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationModelImpl#getEntities <em>Entities</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationModelImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationModelImpl#getDistributions <em>Distributions</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationModelImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationModelImpl#getViews <em>Views</em>}</li>
 *   <li>{@link jaamsim.impl.SimulationModelImpl#getSubModels <em>Sub Models</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimulationModelImpl extends MinimalEObjectImpl.Container implements SimulationModel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSimulation() <em>Simulation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulation()
	 * @generated
	 * @ordered
	 */
	protected Simulation simulation;

	/**
	 * The cached value of the '{@link #getUnits() <em>Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<Unit> units;

	/**
	 * The cached value of the '{@link #getEntities() <em>Entities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity> entities;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> components;

	/**
	 * The cached value of the '{@link #getDistributions() <em>Distributions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributions()
	 * @generated
	 * @ordered
	 */
	protected EList<Distribution> distributions;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resources;

	/**
	 * The cached value of the '{@link #getViews() <em>Views</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViews()
	 * @generated
	 * @ordered
	 */
	protected EList<View> views;

	/**
	 * The cached value of the '{@link #getSubModels() <em>Sub Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubModels()
	 * @generated
	 * @ordered
	 */
	protected EList<SubModel> subModels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.SIMULATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.SIMULATION_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.SIMULATION_MODEL__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Simulation getSimulation() {
		return simulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimulation(Simulation newSimulation, NotificationChain msgs) {
		Simulation oldSimulation = simulation;
		simulation = newSimulation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JaamsimPackage.SIMULATION_MODEL__SIMULATION, oldSimulation, newSimulation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSimulation(Simulation newSimulation) {
		if (newSimulation != simulation) {
			NotificationChain msgs = null;
			if (simulation != null)
				msgs = ((InternalEObject)simulation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.SIMULATION_MODEL__SIMULATION, null, msgs);
			if (newSimulation != null)
				msgs = ((InternalEObject)newSimulation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.SIMULATION_MODEL__SIMULATION, null, msgs);
			msgs = basicSetSimulation(newSimulation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.SIMULATION_MODEL__SIMULATION, newSimulation, newSimulation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Unit> getUnits() {
		if (units == null) {
			units = new EObjectContainmentEList<Unit>(Unit.class, this, JaamsimPackage.SIMULATION_MODEL__UNITS);
		}
		return units;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Entity> getEntities() {
		if (entities == null) {
			entities = new EObjectContainmentEList<Entity>(Entity.class, this, JaamsimPackage.SIMULATION_MODEL__ENTITIES);
		}
		return entities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Component> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList<Component>(Component.class, this, JaamsimPackage.SIMULATION_MODEL__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Distribution> getDistributions() {
		if (distributions == null) {
			distributions = new EObjectContainmentEList<Distribution>(Distribution.class, this, JaamsimPackage.SIMULATION_MODEL__DISTRIBUTIONS);
		}
		return distributions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Resource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<Resource>(Resource.class, this, JaamsimPackage.SIMULATION_MODEL__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<View> getViews() {
		if (views == null) {
			views = new EObjectContainmentEList<View>(View.class, this, JaamsimPackage.SIMULATION_MODEL__VIEWS);
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubModel> getSubModels() {
		if (subModels == null) {
			subModels = new EObjectContainmentEList<SubModel>(SubModel.class, this, JaamsimPackage.SIMULATION_MODEL__SUB_MODELS);
		}
		return subModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JaamsimPackage.SIMULATION_MODEL__SIMULATION:
				return basicSetSimulation(null, msgs);
			case JaamsimPackage.SIMULATION_MODEL__UNITS:
				return ((InternalEList<?>)getUnits()).basicRemove(otherEnd, msgs);
			case JaamsimPackage.SIMULATION_MODEL__ENTITIES:
				return ((InternalEList<?>)getEntities()).basicRemove(otherEnd, msgs);
			case JaamsimPackage.SIMULATION_MODEL__COMPONENTS:
				return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
			case JaamsimPackage.SIMULATION_MODEL__DISTRIBUTIONS:
				return ((InternalEList<?>)getDistributions()).basicRemove(otherEnd, msgs);
			case JaamsimPackage.SIMULATION_MODEL__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
			case JaamsimPackage.SIMULATION_MODEL__VIEWS:
				return ((InternalEList<?>)getViews()).basicRemove(otherEnd, msgs);
			case JaamsimPackage.SIMULATION_MODEL__SUB_MODELS:
				return ((InternalEList<?>)getSubModels()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaamsimPackage.SIMULATION_MODEL__NAME:
				return getName();
			case JaamsimPackage.SIMULATION_MODEL__DESCRIPTION:
				return getDescription();
			case JaamsimPackage.SIMULATION_MODEL__SIMULATION:
				return getSimulation();
			case JaamsimPackage.SIMULATION_MODEL__UNITS:
				return getUnits();
			case JaamsimPackage.SIMULATION_MODEL__ENTITIES:
				return getEntities();
			case JaamsimPackage.SIMULATION_MODEL__COMPONENTS:
				return getComponents();
			case JaamsimPackage.SIMULATION_MODEL__DISTRIBUTIONS:
				return getDistributions();
			case JaamsimPackage.SIMULATION_MODEL__RESOURCES:
				return getResources();
			case JaamsimPackage.SIMULATION_MODEL__VIEWS:
				return getViews();
			case JaamsimPackage.SIMULATION_MODEL__SUB_MODELS:
				return getSubModels();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JaamsimPackage.SIMULATION_MODEL__NAME:
				setName((String)newValue);
				return;
			case JaamsimPackage.SIMULATION_MODEL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case JaamsimPackage.SIMULATION_MODEL__SIMULATION:
				setSimulation((Simulation)newValue);
				return;
			case JaamsimPackage.SIMULATION_MODEL__UNITS:
				getUnits().clear();
				getUnits().addAll((Collection<? extends Unit>)newValue);
				return;
			case JaamsimPackage.SIMULATION_MODEL__ENTITIES:
				getEntities().clear();
				getEntities().addAll((Collection<? extends Entity>)newValue);
				return;
			case JaamsimPackage.SIMULATION_MODEL__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case JaamsimPackage.SIMULATION_MODEL__DISTRIBUTIONS:
				getDistributions().clear();
				getDistributions().addAll((Collection<? extends Distribution>)newValue);
				return;
			case JaamsimPackage.SIMULATION_MODEL__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends Resource>)newValue);
				return;
			case JaamsimPackage.SIMULATION_MODEL__VIEWS:
				getViews().clear();
				getViews().addAll((Collection<? extends View>)newValue);
				return;
			case JaamsimPackage.SIMULATION_MODEL__SUB_MODELS:
				getSubModels().clear();
				getSubModels().addAll((Collection<? extends SubModel>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JaamsimPackage.SIMULATION_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JaamsimPackage.SIMULATION_MODEL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case JaamsimPackage.SIMULATION_MODEL__SIMULATION:
				setSimulation((Simulation)null);
				return;
			case JaamsimPackage.SIMULATION_MODEL__UNITS:
				getUnits().clear();
				return;
			case JaamsimPackage.SIMULATION_MODEL__ENTITIES:
				getEntities().clear();
				return;
			case JaamsimPackage.SIMULATION_MODEL__COMPONENTS:
				getComponents().clear();
				return;
			case JaamsimPackage.SIMULATION_MODEL__DISTRIBUTIONS:
				getDistributions().clear();
				return;
			case JaamsimPackage.SIMULATION_MODEL__RESOURCES:
				getResources().clear();
				return;
			case JaamsimPackage.SIMULATION_MODEL__VIEWS:
				getViews().clear();
				return;
			case JaamsimPackage.SIMULATION_MODEL__SUB_MODELS:
				getSubModels().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JaamsimPackage.SIMULATION_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JaamsimPackage.SIMULATION_MODEL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case JaamsimPackage.SIMULATION_MODEL__SIMULATION:
				return simulation != null;
			case JaamsimPackage.SIMULATION_MODEL__UNITS:
				return units != null && !units.isEmpty();
			case JaamsimPackage.SIMULATION_MODEL__ENTITIES:
				return entities != null && !entities.isEmpty();
			case JaamsimPackage.SIMULATION_MODEL__COMPONENTS:
				return components != null && !components.isEmpty();
			case JaamsimPackage.SIMULATION_MODEL__DISTRIBUTIONS:
				return distributions != null && !distributions.isEmpty();
			case JaamsimPackage.SIMULATION_MODEL__RESOURCES:
				return resources != null && !resources.isEmpty();
			case JaamsimPackage.SIMULATION_MODEL__VIEWS:
				return views != null && !views.isEmpty();
			case JaamsimPackage.SIMULATION_MODEL__SUB_MODELS:
				return subModels != null && !subModels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //SimulationModelImpl
