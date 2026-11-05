# JaamSim Metamodel — Element Catalog & BPMN Mapping

Source: `com.yourorg.models/model/Jaamsim.ecore`
Package: `jaamsim` — nsURI `http://www.example.org/jaamsim` — nsPrefix `jaamsim`

**Contents:** 3 EEnums · 144 EClasses (14 abstract, 130 concrete) = 147 classifiers.

**Classification legend**
- *Kind*: `EEnum` or `EClass`
- *Abstract*: yes/no
- *Super*: inheritance chain (transitive attributes inherited from these)
- *Category*: functional role in the simulation metamodel
- BPMN candidates reference classes from `BPMN20.ecore` (plus `BPMNDI.ecore`/`DC.ecore` for graphical elements, marked `[DI]`).

---

## 1. Enumerations (EEnum)

| Element | Classification | Literals | Potential BPMN mapping |
|---|---|---|---|
| `UnitType` | EEnum | TIME, DISTANCE, SPEED, ACCELERATION, MASS, VOLUME, OTHER, AREA, ANGLE, ENERGY, POWER, FORCE, FLOW, DIMENSIONLESS | — (no unit concept in BPMN); weakly `ItemDefinition` (can carry a unit reference) |
| `SimEntityState` | EEnum | IDLE, WAITING, PROCESSING, FINISHED, OTHER | Token/instance lifecycle: IDLE→`StartEvent` (ready), WAITING→`IntermediateCatchEvent`, PROCESSING→`Task` (in progress), FINISHED→`EndEvent`; states can be carried via `CategoryValue`/`Monitoring` |
| `DistributionKind` | EEnum | UNIFORM, TRIANGULAR, NORMAL, EXPONENTIAL, ERLANG, GAMMA, BETA, WEIBULL, LOGNORMAL, LOGLOGISTIC, DISCRETE, CONTINUOUS, POISSON, BINOMIAL, NEGATIVE_BINOMIAL, GEOMETRIC, STUDENT_T, CHI_SQUARED, F_DISTRIBUTION, PEARSON3, GUMBEL, BERNOULLI, CHOICE | — (stochastic durations not natively modeled); used to parameterize `TimerEventDefinition` (`timeDuration`/`timeCycle`) values |

---

## 2. Root & Configuration

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `SimulationModel` | EClass · concrete · *(root)* | name, description : EString; refs: simulation→Simulation[0..1], units→Unit[*], entities→Entity[*], components→Component[*], distributions→Distribution[*], resources→Resource[*], views→View[*], subModels→SubModel[*] (all containment) | `Definitions` (root container of the BPMN document) |
| `Simulation` | EClass · concrete | runDuration : EDouble; initializationDuration : EDouble; exitAtStop : EBoolean; globalSubstreamSeed : EInt | — (global run configuration has no counterpart); weakly `Definitions`/`Process` attributes or `Monitoring` |
| `Unit` | EClass · concrete | name : EString; type : UnitType; conversionFactorToSI : EDouble | — ; weakly `ItemDefinition` (unit of a data item) |
| `Expression` | EClass · concrete | body : EString | `Expression` / `FormalExpression` (direct counterpart) |
| `Attribute` | EClass · concrete | name : EString; ref: initValue→Expression[0..1] (containment) | `Property` + `Assignment` (init value ≈ initial data assignment) |
| `CustomOutput` | EClass · concrete | name : EString; unit : UnitType; ref: exp→Expression[0..1] | `Monitoring` (observed metric); weakly `Property` |
| `Point3D` | EClass · concrete | x, y, z : EDouble | `[DI]` `dc:Point` / `dc:Bounds` coordinates (BPMNDI/DC) |

## 3. Core Entity Hierarchy (the things that flow / exist in the model)

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `Entity` | EClass · concrete · *(base)* | name, description : EString; movable : EBoolean; refs: position, size, orientation→Point3D[0..1]; attributes→Attribute[*]; customOutputs→CustomOutput[*]; region→Region[0..1]; displayModel→DisplayModel[0..1] | `FlowElement` (base abstraction for everything placeable in a process) |
| `DisplayEntity` | EClass · **abstract** · Entity | *(inherited only)* | `FlowNode` / `Artifact` (anything visually represented on the canvas) |
| `SimEntity` | EClass · concrete · DisplayEntity | initialState : SimEntityState; defaultStates : SimEntityState | The *flowing token / process instance* — no direct BPMN element; closest: `Message` or `DataObject` moving through flow |
| `EntityContainer` | EClass · concrete · SimEntity | capacity : EInt; numberOfEntities : EInt | `DataStore` / `DataStoreReference` (holding items); weakly `SubProcess` (holding tokens) |
| `SimShape` | EClass · concrete · SimEntity | shapeType : EString; lineColour : EString; fillColour : EString | — (purely visual); `[DI]` shape styling |
| `Component` | EClass · **abstract** · DisplayEntity | refs: incoming→Component[*], outgoing→Component[*] | `FlowNode` (incoming/outgoing flow — same connectable concept) |
| `LinkedComponent` | EClass · **abstract** · Component | ref: nextComponent→Component[0..1] | `FlowNode` with a single outgoing `SequenceFlow` |
| `ProcessComponent` | EClass · **abstract** · LinkedComponent | *(inherited only)* | `Activity` / `FlowNode` (generic step in a process flow) |
| `SubModel` | EClass · concrete · DisplayEntity | ref: components→ProcessComponent[*] (containment) | `SubProcess` (embedded) or `CallActivity` (reusable) |
| `SubModelStart` | EClass · concrete · ProcessComponent | *(inherited only)* | `StartEvent` (inside SubProcess) |
| `SubModelEnd` | EClass · concrete · ProcessComponent | *(inherited only)* | `EndEvent` (inside SubProcess) |
| `Region` | EClass · concrete · Entity | *(inherited only)* | `Participant` (pool) / `Lane` (spatial partition); visually `Group` |
| `DisplayModel` | EClass · concrete · Entity | *(inherited only)* | — ; loosely `[DI]` `bpmndi:Diagram` |
| `View` | EClass · concrete · Entity | refs: cameraPosition→Point3D[0..1], cameraTarget→Point3D[0..1] (containment) | — ; loosely `[DI]` diagram viewport |
| `Group` | EClass · concrete · Entity | groupDescription : EString | `Group` (BPMN grouping artifact — same name/purpose) |
| `MimicEntity` | EClass · concrete · DisplayEntity | ref: mimicEntityRef→DisplayEntity[0..1] | — (visual aliasing has no BPMN counterpart) |

## 4. Process Flow — Generation & Input

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `EntityGenerator` | EClass · concrete · ProcessComponent | firstArrivalTime : EDouble; interArrivalTime : EDouble; entitiesPerArrival : EInt; maxNumber : EInt; ref: prototype→SimEntity[0..1] | `StartEvent` + `TimerEventDefinition` (timeCycle ≈ interArrivalTime); entitiesPerArrival → `MultiInstanceLoopCharacteristics`; prototype → `DataObject`/`Message` template |
| `EntityLauncher` | EClass · concrete · ProcessComponent | firstArrivalTime : EDouble; interArrivalTime : EDouble; maxNumber : EInt | `StartEvent` + `TimerEventDefinition` (timeDuration for first, timeCycle for repeats) |
| `FileToArray` | EClass · **abstract** · ProcessComponent | fileName : EString; columnIndex : EInt; skipLines : EInt | `DataStoreReference` (external data) + `DataInputAssociation`; step reads via `Task`/`ServiceTask` |
| `FileToVector` | EClass · concrete · FileToArray | *(inherited only)* | `DataStoreReference` → `DataObject` (read data into flow) |
| `FileToMatrix` | EClass · concrete · FileToArray | *(inherited only)* | `DataStoreReference` + `DataInputAssociation` (structured read) |
| `FileToHashMap` | EClass · concrete · FileToArray | *(inherited only)* | `DataStoreReference` + `DataAssociation` (key-value read) |

## 5. Process Flow — Buffering, Waiting & Processing

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `Queue` | EClass · concrete · ProcessComponent | capacity : EInt; priority : EString; match : EString; fifo : EBoolean; renegeTime : EDouble; renegeCondition : EString; maxValidLength : EInt; ref: renegeDestination→ProcessComponent[0..1] | `IntermediateCatchEvent` (+`MessageEventDefinition`) = waiting; renegeTime → `BoundaryEvent` + `TimerEventDefinition` with cancel path to renegeDestination; renege condition → `ConditionalEventDefinition`; alternative choice → `EventBasedGateway`; capacity → (no native limit; `AdHocSubProcess`/validation) |
| `EntityConveyor` | EClass · concrete · ProcessComponent | travelTime : EDouble | `Task`/`ServiceTask` (duration); transport time is not a BPMN concept on `SequenceFlow` |
| `Server` | EClass · concrete · ProcessComponent | serviceTime : EDouble; ref: waitQueue→Queue[0..1] | `Task` — `ServiceTask`/`UserTask`/`ManualTask` by resource type; resource usage → `ResourceAssignmentExpression`/`Performer`; waitQueue → preceding `IntermediateCatchEvent` |
| `EntityDelay` | EClass · concrete · ProcessComponent | duration : EDouble | `IntermediateCatchEvent` + `TimerEventDefinition` (timeDuration) — strong match |
| `EntityProcessor` | EClass · concrete · ProcessComponent | duration : EDouble; numberEntities : EInt | `Task`/`SubProcess`; numberEntities → `MultiInstanceLoopCharacteristics` (parallel/sequential cardinality) |
| `EntitySink` | EClass · concrete · ProcessComponent | *(inherited only)* | `EndEvent` — strong match |

## 6. Process Flow — Routing & Branching

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `Branch` | EClass · concrete · ProcessComponent | choice : EString; ref: nextComponentList→ProcessComponent[*] | `ExclusiveGateway` (XOR, choice) or `InclusiveGateway`; conditions on outgoing `SequenceFlow` |
| `BranchCondition` | EClass · concrete · *(helper)* | ref: condition→Expression[0..1]; target→ProcessComponent[0..1] | `SequenceFlow` with `conditionExpression` (FormalExpression); target = `targetRef` |
| `EntityGate` | EClass · concrete · ProcessComponent | open : EBoolean; condition : EString | `ConditionalEventDefinition` (pass-when-condition); alternatively `InclusiveGateway`/`ExclusiveGateway` with condition |
| `EntitySignal` | EClass · concrete · ProcessComponent | ref: signalRef→EntitySignal[0..1] | `Signal` + `SignalEventDefinition` (throw/catch) — strong match |
| `EntitlementSelector` | EClass · concrete · DisplayEntity | proportions : EString; index : EInt | `ComplexGateway` (weighted/custom branching ≈ proportions); weakly `InclusiveGateway` |

## 7. Process Flow — Entity Manipulation

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `Assign` | EClass · concrete · ProcessComponent | attribute : EString; value : EString | `Assignment` (inside `DataAssociation`) — direct counterpart; also `ScriptTask` |
| `Duplicate` | EClass · concrete · ProcessComponent | number : EInt | `ParallelGateway` (1→N fan-out); cardinality → `MultiInstanceLoopCharacteristics` |
| `Combine` | EClass · concrete · ProcessComponent | numberToCombine : EInt; duration : EDouble | `ParallelGateway` (N→1 join/synchronize) + `Task` (duration) |
| `Assemble` | EClass · concrete · ProcessComponent | numberToAssemble : EInt; duration : EDouble | `ParallelGateway` (converging join) wrapped in `SubProcess` |
| `Pack` | EClass · concrete · ProcessComponent | numberToPack : EInt | `SubProcess` (packaging step) producing a `DataObject` |
| `Unpack` | EClass · concrete · ProcessComponent | numberToUnpack : EInt | `Task` + `DataOutputAssociation` (extracting items) |
| `AddTo` | EClass · concrete · ProcessComponent | numberToAdd : EInt | `DataInputAssociation` (accumulate into collection); weakly `MultiInstanceLoopCharacteristics` |
| `RemoveFrom` | EClass · concrete · ProcessComponent | numberToRemove : EInt | `DataOutputAssociation` (remove from collection); weakly `MultiInstanceLoopCharacteristics` |

## 8. Resource Management

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `Resource` | EClass · concrete · DisplayEntity | capacity : EInt; ref: units→ResourceUnit[*] (containment) | `Resource` (BPMN resource element); aggregate view → `Participant` (pool) / `Lane` |
| `ResourceUnit` | EClass · concrete · DisplayEntity | available : EBoolean; ref: assignedTo→SimEntity[0..1] | `Resource` (single unit) + `ResourceParameter`; allocation → `Performer`/`HumanPerformer`/`PotentialOwner` |
| `ResourcePool` | EClass · concrete · DisplayEntity | ref: resources→ResourceUnit[*] | `Participant` (pool) with multiple `Lane`s; or `Resource` |
| `AbstractResourceProvider` | EClass · **abstract** · DisplayEntity | capacity : EInt; numberOfUnits : EInt | `Resource` / `ResourceRole` (provider abstraction) |
| `Seize` | EClass · concrete · ProcessComponent | ref: requiredUnits→ResourceUnit[*] | `UserTask`/`Activity` + `ResourceAssignmentExpression` (claim); the *waiting* aspect → `IntermediateCatchEvent`/`EventBasedGateway` |
| `Release` | EClass · concrete · ProcessComponent | ref: releasedUnits→ResourceUnit[*] | — (implicit at Activity completion); weakly `Assignment` |

## 9. Distributions (Randomness)

Base: `Distribution` (EClass · concrete · Entity) — kind : DistributionKind; parameters→DistributionParameter[*] (containment).
Helper: `DistributionParameter` (name : EString; value : EDouble; unit : UnitType) — BPMN: —; weakly `ItemDefinition`.

The 23 concrete distribution classes are all `EClass · concrete · DisplayEntity` (standalone sampling inputs). BPMN has no stochastic constructs — every mapping below is a *weak* association: the sampled value parameterizes a `TimerEventDefinition` (`timeDuration`/`timeCycle`) or a condition expression.

| Element | Attributes (beyond inherited) | Potential BPMN mapping |
|---|---|---|
| `UniformDistribution` | minValue, maxValue : EDouble | `TimerEventDefinition` (uniform duration sampling) |
| `TriangularDistribution` | minValue, mode, maxValue : EDouble | `TimerEventDefinition` (weak) |
| `NormalDistribution` | mean, standardDeviation : EDouble | `TimerEventDefinition` (weak) |
| `ExponentialDistribution` | mean : EDouble | `TimerEventDefinition` (exponential inter-arrival ≈ `timeCycle` of a `StartEvent`) |
| `ErlangDistribution` | mean, shape : EDouble | `TimerEventDefinition` (weak) |
| `GammaDistribution` | mean, shape : EDouble | `TimerEventDefinition` (weak) |
| `BetaDistribution` | alpha, beta : EDouble | `TimerEventDefinition` (weak) |
| `WeibullDistribution` | shape, scale : EDouble | `TimerEventDefinition` (weak) |
| `LogNormalDistribution` | mean, standardDeviation : EDouble | `TimerEventDefinition` (weak) |
| `LogLogisticDistribution` | mean, scale : EDouble | `TimerEventDefinition` (weak) |
| `DiscreteDistribution` | valueList, probabilityList : EDouble | — ; parameterizes conditions on `SequenceFlow` |
| `ContinuousDistribution` | valueList, cumulativeProbabilityList : EDouble | — ; parameterizes `TimerEventDefinition` |
| `PoissonDistribution` | mean : EDouble | `TimerEventDefinition` (event counts ≈ timeCycle) |
| `BinomialDistribution` | probability, numberOfTrials : EDouble | — ; parameterizes `ExclusiveGateway` branching probabilities |
| `NegativeBinomialDistribution` | probability, numberOfSuccesses : EDouble | — (as above) |
| `GeometricDistribution` | probability : EDouble | — (as above) |
| `StudentTDistribution` | degreesOfFreedom : EDouble | — |
| `ChiSquaredDistribution` | degreesOfFreedom : EDouble | — |
| `FDistribution` | numeratorDOF, denominatorDOF : EDouble | — |
| `Pearson3Distribution` | mean, standardDeviation, skewness : EDouble | `TimerEventDefinition` (weak) |
| `GumbelDistribution` | location, scale : EDouble | `TimerEventDefinition` (weak) |
| `BernoulliDistribution` | probability : EDouble | `ExclusiveGateway` (binary branch with probability) |
| `ChoiceDistribution` | valueList, probabilityList : EDouble | `ExclusiveGateway`/`InclusiveGateway` (weighted branching) |

## 10. Data, Sampling & Calculation

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `SampleConstant` | EClass · concrete · Entity | value : EDouble | `Assignment` (constant data); weakly `ItemDefinition` |
| `SampleExpression` | EClass · concrete · Entity | expression : EString | `Expression` / `FormalExpression` |
| `TimeSeries` | EClass · concrete · DisplayEntity | timeList : EString; valueList : EString; cycleTime : EDouble; interpolation : EString | `TimerEventDefinition` (timeCycle schedule of values); weakly `DataObject` (time-stamped data) |
| `EventSchedule` | EClass · concrete · DisplayEntity | timeList : EString; cycleTime : EDouble | `TimerEventDefinition` (`timeCycle` — repeating time schedule) — strong match |
| `ValueSequence` | EClass · concrete · DisplayEntity | valueList : EString; repeat : EBoolean | `MultiInstanceLoopCharacteristics` iterating a collection; weakly `Assignment` |
| `InputValue` | EClass · concrete · TextBasics | value : EDouble; unitType : UnitType | `Property` (model input); weakly `DataObject` |
| `ExpressionEntity` | EClass · concrete · DisplayEntity | expression : EString; unitType : UnitType | `Expression` |
| `CalculationEntity` | EClass · **abstract** · DisplayEntity | unitType : UnitType | `Expression` (computed value abstraction) |
| `DoubleCalculation` | EClass · **abstract** · CalculationEntity | input : EString | `FormalExpression` (single-input computation) |
| `Differentiator` | EClass · concrete · DoubleCalculation | *(inherited only)* | `Expression` (derivative formula) — weak |
| `Integrator` | EClass · concrete · DoubleCalculation | initialValue : EDouble | `Expression` (accumulation) — weak |
| `Lag` | EClass · concrete · DoubleCalculation | timeConstant : EDouble | `Expression`; delay aspect → `TimerEventDefinition` (weak) |
| `MovingAverage` | EClass · concrete · DoubleCalculation | windowLength : EDouble | `Expression` — weak |
| `PIDController` | EClass · concrete · DoubleCalculation | setPoint, proportionalGain, integralGain, derivativeGain : EDouble | `BusinessRuleTask` (control logic) — weak |
| `UnitDelay` | EClass · concrete · DoubleCalculation | initialValue : EDouble | `Expression` — weak |
| `Polynomial` | EClass · concrete · DisplayEntity | coefficients : EString | `Expression` / `FormalExpression` |
| `WeightedSum` | EClass · concrete · DisplayEntity | input : EString; weights : EString | `Expression`; weighted branching → `ComplexGateway` |
| `WaveGenerator` | EClass · **abstract** · DisplayEntity | amplitude, frequency, phase : EDouble | `TimerEventDefinition` (cyclic pattern) — weak |
| `SineWave` | EClass · concrete · WaveGenerator | *(inherited only)* | `TimerEventDefinition` (timeCycle) — weak |
| `SquareWave` | EClass · concrete · WaveGenerator | *(inherited only)* | `TimerEventDefinition` (timeCycle) — weak |

## 11. Thresholds, Signals & Reliability

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `Threshold` | EClass · **abstract** · DisplayEntity | condition : EString | `ConditionalEventDefinition` — strong match |
| `ExpressionThreshold` | EClass · concrete · Threshold | expression : EString | `ConditionalEventDefinition` (expression-triggered) |
| `TimeSeriesThreshold` | EClass · concrete · Threshold | ref: timeSeriesRef→TimeSeries[0..1] | `ConditionalEventDefinition` + `TimerEventDefinition` (scheduled check) |
| `SignalThreshold` | EClass · concrete · Threshold | ref: signalRef→EntitySignal[0..1] | `SignalEventDefinition` (signal-triggered condition) — strong match |
| `DowntimeEntity` | EClass · concrete · DisplayEntity | firstDowntime : EDouble; interval : EDouble; duration : EDouble; concurrent : EBoolean; maintenance : EString | `BoundaryEvent` + `TimerEventDefinition` (unavailability period on an `Activity`); recurring → `Interrupting` timer cycle |

## 12. Logging & Statistics

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `Statistics` | EClass · concrete · ProcessComponent | attribute : EString; statistic : EString | `Monitoring` (metric observation) — best match |
| `ExpressionStatistics` | EClass · concrete · DisplayEntity | expression : EString; statistic : EString | `Monitoring` |
| `EntityLogger` | EClass · concrete · ProcessComponent | fileName : EString; format : EString; interval : EDouble | `Monitoring`; log output → `DataStore`/`DataStoreReference` |
| `ExpressionLogger` | EClass · concrete · DisplayEntity | expressions : EString; fileName : EString; interval : EDouble | `Monitoring` + `DataStore` (log file) |
| `EntityLogger`/`ExpressionLogger` interval | — | — | `TimerEventDefinition` (periodic sampling) |
| `Controller` | EClass · concrete · DisplayEntity | interval : EDouble; action : EString | `TimerEventDefinition` (interval) triggering `ScriptTask` (action) |

## 13. Display & Visualization (no BPMN process semantics)

These exist only for rendering in JaamSim. BPMN counterparts are purely graphical (`[DI]` = BPMNDI/DC) or documentation artifacts.

| Element | Classification | Attributes (beyond inherited) | Potential BPMN mapping |
|---|---|---|---|
| `AbstractShape` | EClass · **abstract** · DisplayEntity | lineColour : EString; lineWidth : EInt; fillColour : EString; filled : EBoolean; lineStyle : EString | — ; `[DI]` shape styling |
| `Shape` | EClass · concrete · AbstractShape | shapeType : EString | — ; `[DI]` `bpmndi:BPMNShape` |
| `Polyline` | EClass · concrete · AbstractShape | points : EString; closed : EBoolean | — ; visually `Association` (line) `[DI]` |
| `Arrow` | EClass · concrete · DisplayEntity | points : EString; lineColour : EString; lineWidth : EInt | `Association` (directional annotation) — visual only |
| `Image` | EClass · concrete · AbstractShape | imageFile : EString; transparent : EBoolean | — |
| `TextBasics` | EClass · **abstract** · AbstractShape | text, textColour, fontName : EString; textHeight : EDouble | `TextAnnotation` (partial) |
| `Text` | EClass · concrete · TextBasics | *(inherited only)* | `TextAnnotation` |
| `EntityLabel` | EClass · concrete · TextBasics | entity : EString; format : EString | `Documentation` (attached text); visually `TextAnnotation` |
| `BillboardText` | EClass · concrete · Text | *(inherited only)* | `TextAnnotation` |
| `OverlayEntity` | EClass · **abstract** · DisplayEntity | *(inherited only)* | — |
| `OverlayText` | EClass · concrete · OverlayEntity | text : EString; textColour : EString; textHeight : EDouble | `TextAnnotation` — weak |
| `OverlayClock` | EClass · concrete · OverlayText | format : EString | — |
| `OverlayImage` | EClass · concrete · OverlayEntity | imageFile : EString | — |
| `AbstractGraph` | EClass · **abstract** · DisplayEntity | xLabel, yLabel, graphTitle : EString; points : EString | `Monitoring` (observed data view) — weak |
| `Graph` | EClass · concrete · AbstractGraph | *(inherited only)* | `Monitoring` — weak |
| `XYGraph` | EClass · concrete · AbstractGraph | *(inherited only)* | `Monitoring` — weak |
| `BarGauge` | EClass · concrete · DisplayEntity | expression : EString; minValue : EDouble; maxValue : EDouble | `Monitoring` — weak |
| `BooleanIndicator` | EClass · concrete · DisplayEntity | state : EBoolean; trueColour, falseColour : EString | `Monitoring`; state change → `ConditionalEventDefinition` — weak |
| `VideoRecorder` | EClass · concrete · DisplayEntity | fileName : EString; startTime, endTime : EDouble | — |
| `SetGraphics` | EClass · concrete · ProcessComponent | graphics : EString | — (runtime presentation change) |
| `InputBox` | EClass · concrete · TextBasics | inputValue : EString | — (manual data entry ≈ `UserTask` at most) |
| `ToggleButton` | EClass · concrete · DisplayEntity | state : EBoolean; toggleAction : EString | — (interactive control ≈ `UserTask` at most) |

## 14. Scripting, Control & External Integration

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `ScriptEntity` | EClass · concrete · Entity | time : EDouble; script : EString | `ScriptTask` (embedded script); timed → `TimerEventDefinition` |
| `OutputMethod` | EClass · concrete · Entity | method : EString; arguments : EString | `Operation` (in `Interface`) — service call signature |
| `Controller` | EClass · concrete · DisplayEntity | interval : EDouble; action : EString | `TimerEventDefinition` + `ScriptTask` (scheduled action); weakly `BoundaryEvent` (timer) |
| `AbstractExternalProgram` | EClass · **abstract** · ProcessComponent | program : EString; arguments : EString; workingDirectory : EString | `ServiceTask` (external service invocation); interface → `Operation` |
| `ExternalProgram` | EClass · concrete · AbstractExternalProgram | *(inherited only)* | `ServiceTask` — strong match |
| `ExternalProgramServer` | EClass · concrete · AbstractExternalProgram | port : EInt | `ServiceTask`/`SendTask`; port ↔ `MessageFlow` (communication channel) |

## 15. Fluid Modeling

| Element | Classification | Attributes / References | Potential BPMN mapping |
|---|---|---|---|
| `FluidContainer` | EClass · concrete · DisplayEntity | capacity, volume, level : EDouble | `DataStore` (holding quantity) — weak |
| `FluidTank` | EClass · concrete · FluidContainer | *(inherited only)* | `DataStore`/`DataStoreReference` — weak |
| `FluidPipe` | EClass · concrete · ProcessComponent | flowRate, resistance, length : EDouble | `SequenceFlow` (flow carrier) — conceptual only |
| `FluidPump` | EClass · concrete · ProcessComponent | flowRate, pressure : EDouble | `Task`/`ServiceTask` (active transfer) — weak |
| `FluidValve` | EClass · concrete · ProcessComponent | open : EBoolean; flowCoefficient : EDouble | `ExclusiveGateway`/`InclusiveGateway` (conditional pass); `ConditionalEventDefinition` |
| `FluidSource` | EClass · concrete · ProcessComponent | flowRate : EDouble; fluid : EString | `StartEvent` (+`MessageEventDefinition` for continuous inflow) |
| `FluidSink` | EClass · concrete · ProcessComponent | flowRate : EDouble | `EndEvent` — strong structural match |

---

## 16. Reverse Index — BPMN element → JaamSim elements

Convenience view for ATL rule design (target-side lookup).

| BPMN element | JaamSim elements it could receive from |
|---|---|
| `Definitions` | `SimulationModel` |
| `Process` | `SimulationModel`, `SubModel` (as process body) |
| `StartEvent` | `EntityGenerator`, `EntityLauncher`, `SubModelStart`, `FluidSource` |
| `TimerEventDefinition` | `EntityGenerator`, `EntityLauncher`, `EntityDelay`, `EventSchedule`, `TimeSeries`, `DowntimeEntity`, `Queue.renegeTime` (via `BoundaryEvent`), all 23 distributions, `WaveGenerator`/`SineWave`/`SquareWave`, `Controller`, `TimeSeriesThreshold` |
| `EndEvent` | `EntitySink`, `SubModelEnd`, `FluidSink` |
| `IntermediateCatchEvent` | `Queue` (waiting), `EntityDelay`, `Seize` (waiting for resource) |
| `BoundaryEvent` | `Queue` (renege), `DowntimeEntity` |
| `Task` / `ServiceTask` / `UserTask` / `ManualTask` | `Server`, `EntityProcessor`, `EntityConveyor`, `Seize`+`Release` pair, `FluidPump`, `ExternalProgram`/`ExternalProgramServer` (ServiceTask), `ScriptEntity` → `ScriptTask`, `PIDController` → `BusinessRuleTask` |
| `SubProcess` | `SubModel`, `Pack`, `Assemble` |
| `CallActivity` | `SubModel` (reusable case) |
| `SequenceFlow` | `LinkedComponent.nextComponent`, `Branch`/`BranchCondition` (with `conditionExpression`), `BranchCondition`, `FluidPipe` (conceptual) |
| `ExclusiveGateway` | `Branch`, `EntityGate`, `FluidValve`, `BernoulliDistribution` (binary) |
| `InclusiveGateway` | `Branch`, `EntitlementSelector`, `FluidValve` |
| `ComplexGateway` | `EntitlementSelector` (proportions), `WeightedSum` |
| `ParallelGateway` | `Duplicate` (fan-out), `Combine`, `Assemble` (join) |
| `EventBasedGateway` | `Queue` (renege race), `Seize` (wait for resource) |
| `MultiInstanceLoopCharacteristics` | `EntityProcessor.numberEntities`, `Duplicate.number`, `ValueSequence`, `EntityGenerator.entitiesPerArrival` |
| `Message` / `MessageEventDefinition` | `SimEntity` (flowing item), `Queue` (wait-for-input) |
| `Signal` / `SignalEventDefinition` | `EntitySignal`, `SignalThreshold` |
| `ConditionalEventDefinition` | `Threshold`, `ExpressionThreshold`, `TimeSeriesThreshold`, `SignalThreshold` (signal), `EntityGate`, `FluidValve` |
| `Resource` / `ResourceRole` / `ResourceAssignmentExpression` / `Performer` | `Resource`, `ResourceUnit`, `ResourcePool`, `AbstractResourceProvider`, `Seize`, `Release`, `Server` (resource use) |
| `Participant` (pool) / `Lane` | `Region`, `ResourcePool`, `Resource` |
| `DataObject` / `DataObjectReference` | `SimEntity` (flowing item), prototype of `EntityGenerator`, `Pack` output |
| `DataStore` / `DataStoreReference` | `EntityContainer`, `FileToArray`/`FileToVector`/`FileToMatrix`/`FileToHashMap`, `EntityLogger`, `ExpressionLogger`, `FluidContainer`/`FluidTank` |
| `Property` + `Assignment` / `DataAssociation` | `Attribute`, `Assign`, `AddTo`, `RemoveFrom`, `InputValue`, `SampleConstant` |
| `Expression` / `FormalExpression` | `Expression`, `SampleExpression`, `ExpressionEntity`, `BranchCondition.condition`, `Polynomial`, `CalculationEntity` family |
| `TextAnnotation` | `Text`, `TextBasics`, `EntityLabel`, `BillboardText`, `OverlayText` |
| `Group` | `Group` |
| `Documentation` | `EntityLabel`, `Entity.description`, `SimulationModel.description` |
| `Monitoring` | `Statistics`, `ExpressionStatistics`, `EntityLogger`, `ExpressionLogger`, `CustomOutput`, `AbstractGraph`/`Graph`/`XYGraph`, `BarGauge`, `BooleanIndicator` |
| `Operation` / `Interface` | `OutputMethod`, `AbstractExternalProgram` |
| `ItemDefinition` | `Unit`, `UnitType`, `DistributionParameter`, `SampleConstant` |
| `DataInput`/`DataOutput`/`InputSet`/`OutputSet` | `Seize.requiredUnits`, `Release.releasedUnits`, `FileTo*` reads/writes |
| `[DI]` `bpmndi:BPMNShape`/`BPMNEdge`, `dc:Point`/`dc:Bounds` | `Point3D`, `Entity.position/size/orientation`, `View`, `AbstractShape`, `Shape`, `Polyline`, `Arrow`, `DisplayModel` |

## 17. Mapping strategy notes

1. **Structural backbone is strong:** `Component/LinkedComponent` ≈ `FlowNode`, `nextComponent`/`Branch.nextComponentList` ≈ `SequenceFlow` (`targetRef`), `EntitySink` ≈ `EndEvent`, `EntityGenerator`/`EntityLauncher` ≈ `StartEvent`, `SubModel` ≈ `SubProcess`/`CallActivity`, `Group` ≈ `Group` (same name).
2. **Timing:** any JaamSim duration/arrival/schedule maps onto `TimerEventDefinition` — `interArrivalTime`/`interval`/`cycleTime` → `timeCycle`, `duration`/`serviceTime`/`travelTime` → `timeDuration`.
3. **Stochastic values:** BPMN cannot express distributions; the 23 distribution classes and `Distribution` can only be *associated* with timer/condition elements (their sampled values would appear in `conditionExpression`/`timeDuration`), never represented natively.
4. **Resources:** `Resource`/`ResourceUnit`/`ResourcePool` map to BPMN `Resource`/`ResourceRole`/`ResourceAssignmentExpression`; `Seize`/`Release` have no explicit BPMN counterpart (release is implicit at activity completion) — model as `UserTask` + resource assignment, with queuing as `IntermediateCatchEvent`.
5. **Renege/balking** (`Queue.renegeTime`/`renegeDestination`) is best expressed as an interrupting `BoundaryEvent` with `TimerEventDefinition` on the waiting activity, routed to the renege destination.
6. **Pure visualization** (`AbstractShape`, `Text*`, overlays, graphs, gauges, `View`, `DisplayModel`, `MimicEntity`, `SetGraphics`, `VideoRecorder`, `Point3D` styling use) has no process semantics — map only to BPMNDI/DC graphics or documentation, and consider excluding these from ATL transformation rules.
7. **Fluid and calculation elements** (`Fluid*`, `DoubleCalculation` family, waves) are continuous-system concepts absent from BPMN; keep them out of the BPMN target model or map only their endpoints (`FluidSource`→`StartEvent`, `FluidSink`→`EndEvent`).
