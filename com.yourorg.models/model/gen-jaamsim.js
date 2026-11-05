// gen-jaamsim.js - single source of truth for the JaamSim Ecore metamodel.
// Emits Jaamsim.ecore and Jaamsim.genmodel so the two stay consistent.
//
// Structure:
//   PART A - enums (names preserved: UnitType, SimEntityState, DistributionKind)
//   PART B - CORE classes: the pipeline contract consumed by Rules.atl and M2T.xtend.
//            Feature names here MUST NOT change (ATL/M2T/instances depend on them).
//   PART C - EXPANSION classes: the rest of the real JaamSim object catalog,
//            with attributes derived from the JaamSim @Keyword inputs.
const fs = require('fs');
const path = require('path');

const OUT_DIR = __dirname;
const NSURI = 'http://www.example.org/jaamsim';
const NSPREFIX = 'jaamsim';
const ROOT_EXTENDS = 'org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container';

const EDT = (n) => `ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//${n}`;
const DT_STRING = EDT('EString');
const DT_DOUBLE = EDT('EDouble');
const DT_INT = EDT('EInt');
const DT_BOOL = EDT('EBoolean');
const ENUM = (n) => `#//${n}`;

// ================= PART A - enums =================
const enums = {
  UnitType: ['TIME','DISTANCE','SPEED','ACCELERATION','MASS','VOLUME','OTHER',
             'AREA','ANGLE','ENERGY','POWER','FORCE','FLOW','DIMENSIONLESS'],
  SimEntityState: ['IDLE','WAITING','PROCESSING','FINISHED','OTHER'],
  DistributionKind: ['UNIFORM','TRIANGULAR','NORMAL','EXPONENTIAL','ERLANG','GAMMA','BETA',
                     'WEIBULL','LOGNORMAL','LOGLOGISTIC','DISCRETE','CONTINUOUS',
                     'POISSON','BINOMIAL','NEGATIVE_BINOMIAL','GEOMETRIC','STUDENT_T',
                     'CHI_SQUARED','F_DISTRIBUTION','PEARSON3','GUMBEL','BERNOULLI','CHOICE'],
};

// ================= class registry =================
const classes = {};
const order = [];
function def(name, sup, attrs, refs, abstract) {
  if (classes[name]) throw new Error('duplicate class ' + name);
  classes[name] = { name, sup: sup || null, attrs: attrs || [], refs: refs || [], abstract: !!abstract };
  order.push(name);
}
// abstract base classes (never instantiated by the ATL producer or M2T consumer)
function defAbs(name, sup, attrs, refs) { def(name, sup, attrs, refs, true); }
// attrs: [name, kind]  kind: S=String, D=Double, I=Int, B=Boolean, E:EnumName
// refs:  [name, target, upper]   upper: 1 single, -1 many

// ================= PART B - CORE (pipeline contract) =================
def('Point3D', null, [['x','D'],['y','D'],['z','D']], []);

def('SimulationModel', null,
  [['name','S'],['description','S']],
  [['simulation','Simulation',1],['units','Unit',-1],['entities','Entity',-1],
   ['components','Component',-1],['distributions','Distribution',-1],['resources','Resource',-1],
   ['views','View',-1],['subModels','SubModel',-1]]);

def('Simulation', null,
  [['runDuration','D'],['initializationDuration','D'],['exitAtStop','B'],['globalSubstreamSeed','I']], []);

def('Unit', null,
  [['name','S'],['type','E:UnitType'],['conversionFactorToSI','D']], []);

def('Expression', null, [['body','S']], []);

def('Attribute', null, [['name','S']], [['initValue','Expression',1]]);

def('CustomOutput', null, [['name','S'],['unit','E:UnitType']], [['exp','Expression',1]]);

def('Entity', null,
  [['name','S'],['description','S'],['movable','B']],
  [['position','Point3D',1],['size','Point3D',1],['orientation','Point3D',1],
   ['attributes','Attribute',-1],['customOutputs','CustomOutput',-1],
   ['region','Region',1],['displayModel','DisplayModel',1]]);

def('DisplayEntity', 'Entity', [], []);
defAbs('Component', 'DisplayEntity', [], [['incoming','Component',-1],['outgoing','Component',-1]]);
defAbs('LinkedComponent', 'Component', [], [['nextComponent','Component',1]]);

def('SimEntity', 'DisplayEntity',
  [['initialState','E:SimEntityState'],['defaultStates','E:SimEntityState']], []);

defAbs('ProcessComponent', 'LinkedComponent', [], []);

def('EntityGenerator', 'ProcessComponent',
  [['firstArrivalTime','D'],['interArrivalTime','D'],['entitiesPerArrival','I'],['maxNumber','I']],
  [['prototype','SimEntity',1]]);

def('Queue', 'ProcessComponent',
  [['capacity','I'],['priority','S'],['match','S'],['fifo','B'],
   ['renegeTime','D'],['renegeCondition','S'],['maxValidLength','I']],
  [['renegeDestination','ProcessComponent',1]]);

def('EntityConveyor', 'ProcessComponent', [['travelTime','D']], []);
def('Server', 'ProcessComponent', [['serviceTime','D']], [['waitQueue','Queue',1]]);
def('EntitySink', 'ProcessComponent', [], []);

def('Branch', 'ProcessComponent', [['choice','S']], [['nextComponentList','ProcessComponent',-1]]);
def('BranchCondition', null, [], [['condition','Expression',1],['target','ProcessComponent',1]]);

def('Resource', 'DisplayEntity', [['capacity','I']], [['units','ResourceUnit',-1]]);
def('ResourceUnit', 'DisplayEntity', [['available','B']], [['assignedTo','SimEntity',1]]);
def('ResourcePool', 'DisplayEntity', [], [['resources','ResourceUnit',-1]]);

def('Seize', 'ProcessComponent', [], [['requiredUnits','ResourceUnit',-1]]);
def('Release', 'ProcessComponent', [], [['releasedUnits','ResourceUnit',-1]]);

def('Distribution', 'Entity',
  [['kind','E:DistributionKind']], [['parameters','DistributionParameter',-1]]);
def('DistributionParameter', null, [['name','S'],['value','D'],['unit','E:UnitType']], []);

def('Region', 'Entity', [], []);
def('DisplayModel', 'Entity', [], []);
def('View', 'Entity', [], [['cameraPosition','Point3D',1],['cameraTarget','Point3D',1]]);
def('SubModel', 'DisplayEntity', [], [['components','ProcessComponent',-1]]);
def('SubModelStart', 'ProcessComponent', [], []);
def('SubModelEnd', 'ProcessComponent', [], []);

// ================= PART C - EXPANSION (full JaamSim catalog) =================

// --- Graphics ---
defAbs('AbstractShape', 'DisplayEntity',
  [['lineColour','S'],['lineWidth','I'],['fillColour','S'],['filled','B'],['lineStyle','S']], []);
def('Shape', 'AbstractShape', [['shapeType','S']], []);
def('Polyline', 'AbstractShape', [['points','S'],['closed','B']], []);
def('Arrow', 'DisplayEntity', [['points','S'],['lineColour','S'],['lineWidth','I']], []);
def('Image', 'AbstractShape', [['imageFile','S'],['transparent','B']], []);
defAbs('TextBasics', 'AbstractShape',
  [['text','S'],['textColour','S'],['fontName','S'],['textHeight','D']], []);
def('Text', 'TextBasics', [], []);
def('EntityLabel', 'TextBasics', [['entity','S'],['format','S']], []);
defAbs('OverlayEntity', 'DisplayEntity', [], []);
def('OverlayText', 'OverlayEntity', [['text','S'],['textColour','S'],['textHeight','D']], []);
def('OverlayClock', 'OverlayText', [['format','S']], []);
def('OverlayImage', 'OverlayEntity', [['imageFile','S']], []);
def('BillboardText', 'Text', [], []);
def('MimicEntity', 'DisplayEntity', [], [['mimicEntityRef','DisplayEntity',1]]);
defAbs('AbstractGraph', 'DisplayEntity',
  [['xLabel','S'],['yLabel','S'],['graphTitle','S'],['points','S']], []);
def('Graph', 'AbstractGraph', [], []);
def('XYGraph', 'AbstractGraph', [], []);
def('BarGauge', 'DisplayEntity', [['expression','S'],['minValue','D'],['maxValue','D']], []);
def('BooleanIndicator', 'DisplayEntity',
  [['state','B'],['trueColour','S'],['falseColour','S']], []);
def('VideoRecorder', 'DisplayEntity', [['fileName','S'],['startTime','D'],['endTime','D']], []);
def('InputBox', 'TextBasics', [['inputValue','S']], []);

// --- ProcessFlow (additional components) ---
def('EntityLauncher', 'ProcessComponent',
  [['firstArrivalTime','D'],['interArrivalTime','D'],['maxNumber','I']], []);
def('EntityDelay', 'ProcessComponent', [['duration','D']], []);
def('EntityProcessor', 'ProcessComponent', [['duration','D'],['numberEntities','I']], []);
def('Assign', 'ProcessComponent', [['attribute','S'],['value','S']], []);
def('Duplicate', 'ProcessComponent', [['number','I']], []);
def('Combine', 'ProcessComponent', [['numberToCombine','I'],['duration','D']], []);
def('Assemble', 'ProcessComponent', [['numberToAssemble','I'],['duration','D']], []);
def('Pack', 'ProcessComponent', [['numberToPack','I']], []);
def('Unpack', 'ProcessComponent', [['numberToUnpack','I']], []);
def('AddTo', 'ProcessComponent', [['numberToAdd','I']], []);
def('RemoveFrom', 'ProcessComponent', [['numberToRemove','I']], []);
def('EntityContainer', 'SimEntity', [['capacity','I'],['numberOfEntities','I']], []);
def('EntityGate', 'ProcessComponent', [['open','B'],['condition','S']], []);
def('EntitySignal', 'ProcessComponent', [], [['signalRef','EntitySignal',1]]);
def('SetGraphics', 'ProcessComponent', [['displayModel','S'],['graphics','S']], []);
def('EntityLogger', 'ProcessComponent',
  [['fileName','S'],['format','S'],['interval','D']], []);
def('Statistics', 'ProcessComponent', [['attribute','S'],['statistic','S']], []);
def('SimShape', 'SimEntity', [['shapeType','S'],['lineColour','S'],['fillColour','S']], []);

// --- Resource objects ---
defAbs('AbstractResourceProvider', 'DisplayEntity',
  [['capacity','I'],['numberOfUnits','I']], []);

// --- Basic objects ---
def('Group', 'Entity', [['groupDescription','S']], []);
def('ScriptEntity', 'Entity', [['time','D'],['script','S']], []);
def('OutputMethod', 'Entity', [['method','S'],['arguments','S']], []);
def('Controller', 'DisplayEntity', [['interval','D'],['action','S']], []);
def('InputValue', 'TextBasics', [['value','D'],['unitType','E:UnitType']], []);
def('ToggleButton', 'DisplayEntity', [['state','B'],['toggleAction','S']], []);
def('ExpressionEntity', 'DisplayEntity', [['expression','S'],['unitType','E:UnitType']], []);
def('ExpressionStatistics', 'DisplayEntity', [['expression','S'],['statistic','S']], []);
def('ExpressionLogger', 'DisplayEntity',
  [['expressions','S'],['fileName','S'],['interval','D']], []);
def('EntitlementSelector', 'DisplayEntity', [['proportions','S'],['index','I']], []);
def('EventSchedule', 'DisplayEntity', [['timeList','S'],['cycleTime','D']], []);
def('ValueSequence', 'DisplayEntity', [['valueList','S'],['repeat','B']], []);
def('DowntimeEntity', 'DisplayEntity',
  [['firstDowntime','D'],['interval','D'],['duration','D'],['concurrent','B'],['maintenance','S']], []);
def('EntitySystem', 'DisplayEntity', [['state','S']], []);
defAbs('FileToArray', 'ProcessComponent',
  [['fileName','S'],['columnIndex','I'],['skipLines','I']], []);
def('FileToVector', 'FileToArray', [], []);
def('FileToMatrix', 'FileToArray', [], []);
def('FileToHashMap', 'FileToArray', [], []);
defAbs('AbstractExternalProgram', 'ProcessComponent',
  [['program','S'],['arguments','S'],['workingDirectory','S']], []);
def('ExternalProgram', 'AbstractExternalProgram', [], []);
def('ExternalProgramServer', 'AbstractExternalProgram', [['port','I']], []);

// --- Thresholds ---
defAbs('Threshold', 'DisplayEntity', [['condition','S']], []);
def('ExpressionThreshold', 'Threshold', [['expression','S']], []);
def('TimeSeriesThreshold', 'Threshold', [], [['timeSeriesRef','TimeSeries',1]]);
def('SignalThreshold', 'Threshold', [], [['signalRef','EntitySignal',1]]);

// --- Samples ---
def('SampleConstant', 'Entity', [['value','D']], []);
def('SampleExpression', 'Entity', [['expression','S']], []);
def('TimeSeries', 'DisplayEntity',
  [['timeList','S'],['valueList','S'],['cycleTime','D'],['interpolation','S']], []);

// --- Calculation objects ---
defAbs('CalculationEntity', 'DisplayEntity', [['unitType','E:UnitType']], []);
defAbs('DoubleCalculation', 'CalculationEntity', [['input','S']], []);
def('Differentiator', 'DoubleCalculation', [], []);
def('Integrator', 'DoubleCalculation', [['initialValue','D']], []);
def('Lag', 'DoubleCalculation', [['timeConstant','D']], []);
def('MovingAverage', 'DoubleCalculation', [['windowLength','D']], []);
def('PIDController', 'DoubleCalculation',
  [['setPoint','D'],['proportionalGain','D'],['integralGain','D'],['derivativeGain','D']], []);
def('UnitDelay', 'DoubleCalculation', [['initialValue','D']], []);
def('Polynomial', 'DisplayEntity', [['coefficients','S']], []);
def('WeightedSum', 'DisplayEntity', [['input','S'],['weights','S']], []);
defAbs('WaveGenerator', 'DisplayEntity',
  [['amplitude','D'],['frequency','D'],['phase','D']], []);
def('SineWave', 'WaveGenerator', [], []);
def('SquareWave', 'WaveGenerator', [], []);

// --- Probability distributions ---
const dists = {
  UniformDistribution:['minValue','maxValue'],
  TriangularDistribution:['minValue','mode','maxValue'],
  NormalDistribution:['mean','standardDeviation'],
  ExponentialDistribution:['mean'],
  ErlangDistribution:['mean','shape'],
  GammaDistribution:['mean','shape'],
  BetaDistribution:['alpha','beta'],
  WeibullDistribution:['shape','scale'],
  LogNormalDistribution:['mean','standardDeviation'],
  LogLogisticDistribution:['mean','scale'],
  DiscreteDistribution:['valueList','probabilityList'],
  ContinuousDistribution:['valueList','cumulativeProbabilityList'],
  PoissonDistribution:['mean'],
  BinomialDistribution:['probability','numberOfTrials'],
  NegativeBinomialDistribution:['probability','numberOfSuccesses'],
  GeometricDistribution:['probability'],
  StudentTDistribution:['degreesOfFreedom'],
  ChiSquaredDistribution:['degreesOfFreedom'],
  FDistribution:['numeratorDOF','denominatorDOF'],
  Pearson3Distribution:['mean','standardDeviation','skewness'],
  GumbelDistribution:['location','scale'],
  BernoulliDistribution:['probability'],
  ChoiceDistribution:['valueList','probabilityList'],
};
for (const [n, ps] of Object.entries(dists)) def(n, 'DisplayEntity', ps.map(p => [p,'D']), []);

// --- SubModels / fluid ---
def('FluidContainer', 'DisplayEntity', [['capacity','D'],['volume','D'],['level','D']], []);
def('FluidPipe', 'ProcessComponent', [['flowRate','D'],['resistance','D'],['length','D']], []);
def('FluidPump', 'ProcessComponent', [['flowRate','D'],['pressure','D']], []);
def('FluidValve', 'ProcessComponent', [['open','B'],['flowCoefficient','D']], []);
def('FluidTank', 'FluidContainer', [], []);
def('FluidSource', 'ProcessComponent', [['flowRate','D'],['fluid','S']], []);
def('FluidSink', 'ProcessComponent', [['flowRate','D']], []);

// ------------------------------------------------------------------
// strip features that collide with inherited ones (EMF forbids a feature
// name appearing in both a class and any of its supertypes)
// ------------------------------------------------------------------
function ancestors(n) { const r = []; let s = classes[n].sup; while (s) { r.push(s); s = classes[s].sup; } return r; }
for (const n of order) {
  const inherited = new Set();
  ancestors(n).forEach(a => {
    classes[a].attrs.forEach(x => inherited.add(x[0]));
    classes[a].refs.forEach(x => inherited.add(x[0]));
  });
  classes[n].attrs = classes[n].attrs.filter(x => !inherited.has(x[0]));
  classes[n].refs = classes[n].refs.filter(x => !inherited.has(x[0]));
}

// ------------------------------------------------------------------
// mark composition (containment) references — owned children.
// Required so the pipeline XMI nests members inline (//@entities.N) as in
// Ex1_Jaam.xmi, and so EMF accepts the model without dangling cross-refs.
// ------------------------------------------------------------------
const containment = {
  SimulationModel: ['simulation','units','entities','components','distributions','resources','views','subModels'],
  Entity: ['position','size','orientation','attributes','customOutputs'],
  Attribute: ['initValue'],
  CustomOutput: ['exp'],
  BranchCondition: ['condition'],
  Resource: ['units'],
  Distribution: ['parameters'],
  SubModel: ['components'],
  View: ['cameraPosition','cameraTarget'],
};
for (const [cn, rs] of Object.entries(containment)) {
  const c = classes[cn];
  if (!c) throw new Error('containment: unknown class ' + cn);
  for (const r of rs) {
    const f = c.refs.find(x => x[0] === r);
    if (!f) throw new Error('containment: unknown ref ' + cn + '.' + r);
    f[3] = 'C';
  }
}

// ------------------------------------------------------------------
// serialise
// ------------------------------------------------------------------
let ecore = '';
ecore += '<?xml version="1.0" encoding="UTF-8"?>\n';
ecore += '<ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"\n';
ecore += '    xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" name="' + NSPREFIX + '" nsURI="' + NSURI + '" nsPrefix="' + NSPREFIX + '">\n';

for (const [en, lits] of Object.entries(enums)) {
  ecore += '  <eClassifiers xsi:type="ecore:EEnum" name="' + en + '">\n';
  lits.forEach((l, i) => { ecore += '    <eLiterals name="' + l + '" value="' + i + '"/>\n'; });
  ecore += '  </eClassifiers>\n';
}

for (const name of order) {
  const c = classes[name];
  ecore += '  <eClassifiers xsi:type="ecore:EClass" name="' + name + '"';
  if (c.sup) ecore += ' eSuperTypes="#//' + c.sup + '"';
  if (c.abstract) ecore += ' abstract="true"';
  ecore += '>\n';
  for (const [an, ak] of c.attrs) {
    let type;
    if (ak === 'S') type = DT_STRING;
    else if (ak === 'D') type = DT_DOUBLE;
    else if (ak === 'I') type = DT_INT;
    else if (ak === 'B') type = DT_BOOL;
    else if (ak.startsWith('E:')) type = ENUM(ak.slice(2));
    ecore += '    <eStructuralFeatures xsi:type="ecore:EAttribute" name="' + an + '" eType="' + type + '"/>\n';
  }
  for (const [rn, rt, ru, role] of c.refs) {
    const upper = ru === -1 ? '-1' : String(ru);
    const cont = role === 'C' ? ' containment="true"' : '';
    ecore += '    <eStructuralFeatures xsi:type="ecore:EReference" name="' + rn + '" upperBound="' + upper + '"' + cont + ' eType="#//' + rt + '"/>\n';
  }
  ecore += '  </eClassifiers>\n';
}
ecore += '</ecore:EPackage>\n';
fs.writeFileSync(path.join(OUT_DIR, 'Jaamsim.ecore'), ecore, 'utf8');

// ---- genmodel ----
let gm = '';
gm += '<?xml version="1.0" encoding="UTF-8"?>\n';
gm += '<genmodel:GenModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore"\n';
gm += '    xmlns:genmodel="http://www.eclipse.org/emf/2002/GenModel" modelDirectory="com.yourorg.models/src" modelPluginID="Models"\n';
gm += '    modelName="Jaamsim" rootExtendsClass="' + ROOT_EXTENDS + '"\n';
gm += '    importerID="org.eclipse.emf.importer.ecore" complianceLevel="21.0" copyrightFields="false"\n';
gm += '    operationReflection="true" importOrganizing="true">\n';
gm += '  <foreignModel>Jaamsim.ecore</foreignModel>\n';
gm += '  <genPackages prefix="Jaamsim" disposableProviderFactory="true" ecorePackage="Jaamsim.ecore#/">\n';
for (const [en, lits] of Object.entries(enums)) {
  gm += '    <genEnums typeSafeEnumCompatible="false" ecoreEnum="Jaamsim.ecore#//' + en + '">\n';
  lits.forEach(l => { gm += '      <genEnumLiterals ecoreEnumLiteral="Jaamsim.ecore#//' + en + '/' + l + '"/>\n'; });
  gm += '    </genEnums>\n';
}
for (const name of order) {
  gm += '    <genClasses ecoreClass="Jaamsim.ecore#//' + name + '">\n';
  const c = classes[name];
  for (const [an] of c.attrs) gm += '      <genFeatures createChild="false" ecoreFeature="ecore:EAttribute Jaamsim.ecore#//' + name + '/' + an + '"/>\n';
  for (const [rn, , , role] of c.refs) {
    const attrs = role === 'C' ? 'notify="true" createChild="true"' : 'notify="false" createChild="false"';
    gm += '      <genFeatures ' + attrs + ' ecoreFeature="ecore:EReference Jaamsim.ecore#//' + name + '/' + rn + '"/>\n';
  }
  gm += '    </genClasses>\n';
}
gm += '  </genPackages>\n';
gm += '</genmodel:GenModel>\n';
fs.writeFileSync(path.join(OUT_DIR, 'Jaamsim.genmodel'), gm, 'utf8');

console.log('Classes: ' + order.length + ', Enums: ' + Object.keys(enums).length);
console.log('Wrote Jaamsim.ecore and Jaamsim.genmodel');
