/**
 */
package jaamsim.impl;

import jaamsim.Attribute;
import jaamsim.CustomOutput;
import jaamsim.DisplayModel;
import jaamsim.Entity;
import jaamsim.JaamsimPackage;
import jaamsim.Point3D;
import jaamsim.Region;

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
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jaamsim.impl.EntityImpl#getName <em>Name</em>}</li>
 *   <li>{@link jaamsim.impl.EntityImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link jaamsim.impl.EntityImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link jaamsim.impl.EntityImpl#getSize <em>Size</em>}</li>
 *   <li>{@link jaamsim.impl.EntityImpl#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link jaamsim.impl.EntityImpl#isMovable <em>Movable</em>}</li>
 *   <li>{@link jaamsim.impl.EntityImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link jaamsim.impl.EntityImpl#getCustomOutputs <em>Custom Outputs</em>}</li>
 *   <li>{@link jaamsim.impl.EntityImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link jaamsim.impl.EntityImpl#getDisplayModel <em>Display Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EntityImpl extends MinimalEObjectImpl.Container implements Entity {
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
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected Point3D position;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected Point3D size;

	/**
	 * The cached value of the '{@link #getOrientation() <em>Orientation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrientation()
	 * @generated
	 * @ordered
	 */
	protected Point3D orientation;

	/**
	 * The default value of the '{@link #isMovable() <em>Movable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMovable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MOVABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMovable() <em>Movable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMovable()
	 * @generated
	 * @ordered
	 */
	protected boolean movable = MOVABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getCustomOutputs() <em>Custom Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<CustomOutput> customOutputs;

	/**
	 * The cached value of the '{@link #getRegion() <em>Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected Region region;

	/**
	 * The cached value of the '{@link #getDisplayModel() <em>Display Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayModel()
	 * @generated
	 * @ordered
	 */
	protected DisplayModel displayModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaamsimPackage.Literals.ENTITY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Point3D getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPosition(Point3D newPosition, NotificationChain msgs) {
		Point3D oldPosition = position;
		position = newPosition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY__POSITION, oldPosition, newPosition);
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
	public void setPosition(Point3D newPosition) {
		if (newPosition != position) {
			NotificationChain msgs = null;
			if (position != null)
				msgs = ((InternalEObject)position).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.ENTITY__POSITION, null, msgs);
			if (newPosition != null)
				msgs = ((InternalEObject)newPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.ENTITY__POSITION, null, msgs);
			msgs = basicSetPosition(newPosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY__POSITION, newPosition, newPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Point3D getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSize(Point3D newSize, NotificationChain msgs) {
		Point3D oldSize = size;
		size = newSize;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY__SIZE, oldSize, newSize);
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
	public void setSize(Point3D newSize) {
		if (newSize != size) {
			NotificationChain msgs = null;
			if (size != null)
				msgs = ((InternalEObject)size).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.ENTITY__SIZE, null, msgs);
			if (newSize != null)
				msgs = ((InternalEObject)newSize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.ENTITY__SIZE, null, msgs);
			msgs = basicSetSize(newSize, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY__SIZE, newSize, newSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Point3D getOrientation() {
		return orientation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrientation(Point3D newOrientation, NotificationChain msgs) {
		Point3D oldOrientation = orientation;
		orientation = newOrientation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY__ORIENTATION, oldOrientation, newOrientation);
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
	public void setOrientation(Point3D newOrientation) {
		if (newOrientation != orientation) {
			NotificationChain msgs = null;
			if (orientation != null)
				msgs = ((InternalEObject)orientation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.ENTITY__ORIENTATION, null, msgs);
			if (newOrientation != null)
				msgs = ((InternalEObject)newOrientation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JaamsimPackage.ENTITY__ORIENTATION, null, msgs);
			msgs = basicSetOrientation(newOrientation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY__ORIENTATION, newOrientation, newOrientation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMovable() {
		return movable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMovable(boolean newMovable) {
		boolean oldMovable = movable;
		movable = newMovable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY__MOVABLE, oldMovable, movable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, JaamsimPackage.ENTITY__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CustomOutput> getCustomOutputs() {
		if (customOutputs == null) {
			customOutputs = new EObjectContainmentEList<CustomOutput>(CustomOutput.class, this, JaamsimPackage.ENTITY__CUSTOM_OUTPUTS);
		}
		return customOutputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Region getRegion() {
		if (region != null && region.eIsProxy()) {
			InternalEObject oldRegion = (InternalEObject)region;
			region = (Region)eResolveProxy(oldRegion);
			if (region != oldRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JaamsimPackage.ENTITY__REGION, oldRegion, region));
			}
		}
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region basicGetRegion() {
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRegion(Region newRegion) {
		Region oldRegion = region;
		region = newRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY__REGION, oldRegion, region));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DisplayModel getDisplayModel() {
		if (displayModel != null && displayModel.eIsProxy()) {
			InternalEObject oldDisplayModel = (InternalEObject)displayModel;
			displayModel = (DisplayModel)eResolveProxy(oldDisplayModel);
			if (displayModel != oldDisplayModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JaamsimPackage.ENTITY__DISPLAY_MODEL, oldDisplayModel, displayModel));
			}
		}
		return displayModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DisplayModel basicGetDisplayModel() {
		return displayModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplayModel(DisplayModel newDisplayModel) {
		DisplayModel oldDisplayModel = displayModel;
		displayModel = newDisplayModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaamsimPackage.ENTITY__DISPLAY_MODEL, oldDisplayModel, displayModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JaamsimPackage.ENTITY__POSITION:
				return basicSetPosition(null, msgs);
			case JaamsimPackage.ENTITY__SIZE:
				return basicSetSize(null, msgs);
			case JaamsimPackage.ENTITY__ORIENTATION:
				return basicSetOrientation(null, msgs);
			case JaamsimPackage.ENTITY__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case JaamsimPackage.ENTITY__CUSTOM_OUTPUTS:
				return ((InternalEList<?>)getCustomOutputs()).basicRemove(otherEnd, msgs);
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
			case JaamsimPackage.ENTITY__NAME:
				return getName();
			case JaamsimPackage.ENTITY__DESCRIPTION:
				return getDescription();
			case JaamsimPackage.ENTITY__POSITION:
				return getPosition();
			case JaamsimPackage.ENTITY__SIZE:
				return getSize();
			case JaamsimPackage.ENTITY__ORIENTATION:
				return getOrientation();
			case JaamsimPackage.ENTITY__MOVABLE:
				return isMovable();
			case JaamsimPackage.ENTITY__ATTRIBUTES:
				return getAttributes();
			case JaamsimPackage.ENTITY__CUSTOM_OUTPUTS:
				return getCustomOutputs();
			case JaamsimPackage.ENTITY__REGION:
				if (resolve) return getRegion();
				return basicGetRegion();
			case JaamsimPackage.ENTITY__DISPLAY_MODEL:
				if (resolve) return getDisplayModel();
				return basicGetDisplayModel();
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
			case JaamsimPackage.ENTITY__NAME:
				setName((String)newValue);
				return;
			case JaamsimPackage.ENTITY__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case JaamsimPackage.ENTITY__POSITION:
				setPosition((Point3D)newValue);
				return;
			case JaamsimPackage.ENTITY__SIZE:
				setSize((Point3D)newValue);
				return;
			case JaamsimPackage.ENTITY__ORIENTATION:
				setOrientation((Point3D)newValue);
				return;
			case JaamsimPackage.ENTITY__MOVABLE:
				setMovable((Boolean)newValue);
				return;
			case JaamsimPackage.ENTITY__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case JaamsimPackage.ENTITY__CUSTOM_OUTPUTS:
				getCustomOutputs().clear();
				getCustomOutputs().addAll((Collection<? extends CustomOutput>)newValue);
				return;
			case JaamsimPackage.ENTITY__REGION:
				setRegion((Region)newValue);
				return;
			case JaamsimPackage.ENTITY__DISPLAY_MODEL:
				setDisplayModel((DisplayModel)newValue);
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
			case JaamsimPackage.ENTITY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JaamsimPackage.ENTITY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case JaamsimPackage.ENTITY__POSITION:
				setPosition((Point3D)null);
				return;
			case JaamsimPackage.ENTITY__SIZE:
				setSize((Point3D)null);
				return;
			case JaamsimPackage.ENTITY__ORIENTATION:
				setOrientation((Point3D)null);
				return;
			case JaamsimPackage.ENTITY__MOVABLE:
				setMovable(MOVABLE_EDEFAULT);
				return;
			case JaamsimPackage.ENTITY__ATTRIBUTES:
				getAttributes().clear();
				return;
			case JaamsimPackage.ENTITY__CUSTOM_OUTPUTS:
				getCustomOutputs().clear();
				return;
			case JaamsimPackage.ENTITY__REGION:
				setRegion((Region)null);
				return;
			case JaamsimPackage.ENTITY__DISPLAY_MODEL:
				setDisplayModel((DisplayModel)null);
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
			case JaamsimPackage.ENTITY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JaamsimPackage.ENTITY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case JaamsimPackage.ENTITY__POSITION:
				return position != null;
			case JaamsimPackage.ENTITY__SIZE:
				return size != null;
			case JaamsimPackage.ENTITY__ORIENTATION:
				return orientation != null;
			case JaamsimPackage.ENTITY__MOVABLE:
				return movable != MOVABLE_EDEFAULT;
			case JaamsimPackage.ENTITY__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case JaamsimPackage.ENTITY__CUSTOM_OUTPUTS:
				return customOutputs != null && !customOutputs.isEmpty();
			case JaamsimPackage.ENTITY__REGION:
				return region != null;
			case JaamsimPackage.ENTITY__DISPLAY_MODEL:
				return displayModel != null;
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
		result.append(", movable: ");
		result.append(movable);
		result.append(')');
		return result.toString();
	}

} //EntityImpl
