package com.your.m2t

import java.nio.charset.StandardCharsets
import java.util.LinkedHashMap
import java.util.LinkedHashSet
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource

/** Reflective exporter: accepts both generated and dynamic EMF objects. */
class M2T {
  val nameMap = new LinkedHashMap<EObject, String>
  val usedNames = new LinkedHashSet<String>
  val types = #["SimEntity", "EntityGenerator", "EntityConveyor", "Branch", "Queue", "Server", "EntitySink"]

  def void exportToConfig(Resource model, URI outputUri) {
    nameMap.clear
    usedNames.clear
    usedNames.addAll(#["Simulation", "Axis", "Grid100x100", "XY-Grid", "XYZ-Axis", "Clock", "Title", "View1"])
    val all = model.allContents.toIterable.toList
    val roots = all.filter[eClass.name == "SimulationModel"].toList
    if (roots.size != 1) throw new IllegalArgumentException("Expected one SimulationModel")
    // Reject unsupported semantic objects before opening/truncating the destination.
    for (e : all) {
      if (!types.contains(e.eClass.name) && !#["SimulationModel", "Simulation", "Point3D"].contains(e.eClass.name))
        throw new IllegalArgumentException("No CFG handler for " + e.eClass.name)
    }
    val entities = all.filter[types.contains(eClass.name)].toList
    for (e : entities) nameMap.put(e, exportName(e))
    for (e : entities) validate(e)
    val text = new StringBuilder("RecordEdits\n\n")
    for (type : types) {
      val elements = entities.filter[eClass.name == type].toList
      if (!elements.empty) text.append("Define " + type + " { " + elements.map[nameMap.get(it)].join("  ") + " }\n")
    }
    text.append("Define ColladaModel { Axis Grid100x100 }\n")
    text.append("Define DisplayEntity { XY-Grid XYZ-Axis }\n")
    text.append("Define OverlayClock { Clock }\nDefine OverlayText { Title }\nDefine View { View1 }\n\n")
    val simulation = value(roots.head, "simulation")
    if (simulation instanceof EObject) {
      val s = simulation
      duration(text, s, "runDuration", "RunDuration", "Simulation")
      duration(text, s, "initializationDuration", "InitializationDuration", "Simulation")
      line(text, "Simulation", "ExitAtStop", bool(value(s, "exitAtStop")))
      line(text, "Simulation", "GlobalSubstreamSeed", value(s, "globalSubstreamSeed"))
    }
    var index = 0
    for (e : entities) {
      val name = nameMap.get(e)
      text.append("\n# " + e.eClass.name + "\n")
      switch e.eClass.name {
        case "EntityGenerator": {
          reference(text, e, "nextComponent", "NextComponent")
          reference(text, e, "prototype", "PrototypeEntity")
          duration(text, e, "firstArrivalTime", "FirstArrivalTime", name)
          duration(text, e, "interArrivalTime", "InterArrivalTime", name)
          line(text, name, "EntitiesPerArrival", value(e, "entitiesPerArrival"))
          // Repository convention: maxNumber=0 means unlimited.
          if (number(e, "maxNumber") > 0) line(text, name, "MaxNumber", value(e, "maxNumber"))
        }
        case "EntityConveyor": {
          reference(text, e, "nextComponent", "NextComponent")
          duration(text, e, "travelTime", "TravelTime", name)
        }
        case "Server": {
          reference(text, e, "nextComponent", "NextComponent")
          reference(text, e, "waitQueue", "WaitQueue")
          duration(text, e, "serviceTime", "ServiceTime", name)
        }
        case "Branch": {
          val targets = value(e, "nextComponentList") as List<?>
          line(text, name, "NextComponentList", targets.map[refName(it)].join("  "))
          line(text, name, "Choice", quote(value(e, "choice").toString))
        }
        case "Queue": {
          optional(text, e, "priority", "Priority")
          optional(text, e, "match", "Match")
          // Emit false too: eIsSet cannot distinguish an explicit default-valued false.
          line(text, name, "FIFO", bool(value(e, "fifo")))
          if (isSet(e, "renegeTime")) duration(text, e, "renegeTime", "RenegeTime", name)
          optional(text, e, "renegeCondition", "RenegeCondition")
          if (value(e, "renegeDestination") !== null) reference(text, e, "renegeDestination", "RenegeDestination")
          optional(text, e, "maxValidLength", "MaxValidLength")
          if (number(e, "capacity") != 0)
            throw new IllegalArgumentException("Queue.capacity has no implemented JaamSim CFG equivalent; use maxValidLength explicitly")
        }
      }
      val position = value(e, "position")
      if (position instanceof EObject) {
        val p = position
        line(text, name, "Position", coordinate(p, "x") + " " + coordinate(p, "y") + " " + coordinate(p, "z") + " m")
      } else line(text, name, "Position", (index * 2.0) + " 0 0 m")
      for (feature : #["size", "orientation"]) {
        val point = value(e, feature)
        if (point instanceof EObject)
          line(text, name, if (feature == "size") "Size" else "Orientation",
            coordinate(point, "x") + " " + coordinate(point, "y") + " " + coordinate(point, "z") + if (feature == "size") " m" else " deg")
      }
      index = index + 1
    }
    text.append("\nAxis ColladaFile { <res>/shapes/axis_text.dae }\n")
    text.append("Grid100x100 ColladaFile { <res>/shapes/grid100x100.dae }\n")
    text.append("XY-Grid DisplayModel { Grid100x100 }\nXY-Grid Show { FALSE }\n")
    text.append("XYZ-Axis DisplayModel { Axis }\nXYZ-Axis Show { FALSE }\n")
    text.append("Clock ScreenPosition { 15 15 }\nClock DateFormat { 'yyyy-MMM-dd HH:mm:ss.SSS' }\n")
    text.append("Title ScreenPosition { 15 40 }\nTitle Format { 'BPMN Simulation' }\n")
    text.append("View1 ViewCenter { 5 0 0 m }\nView1 ViewPosition { 5 0 20 m }\nView1 ShowWindow { TRUE }\nView1 Lock2D { TRUE }\n")
    // URIConverter supports file:/ and Eclipse platform:/resource/ destinations.
    val out = model.resourceSet.URIConverter.createOutputStream(outputUri)
    try { out.write(text.toString.getBytes(StandardCharsets.UTF_8)) } finally { out.close }
  }

  private def Object value(EObject e, String feature) {
    val f = e.eClass.getEStructuralFeature(feature)
    if (f === null) null else e.eGet(f)
  }
  private def boolean isSet(EObject e, String feature) {
    val f = e.eClass.getEStructuralFeature(feature)
    f !== null && e.eIsSet(f)
  }
  private def double number(EObject e, String feature) {
    val n = coordinate(e, feature)
    if (n < 0) throw new IllegalArgumentException("Invalid " + feature + ": " + n)
    n
  }
  private def double coordinate(EObject e, String feature) {
    val v = value(e, feature)
    if (!(v instanceof Number)) throw new IllegalArgumentException("Missing numeric feature " + feature)
    val n = (v as Number).doubleValue
    if (!Double.isFinite(n)) throw new IllegalArgumentException("Invalid " + feature + ": " + n)
    n
  }
  private def String bool(Object value) { if (Boolean.TRUE == value) "TRUE" else "FALSE" }
  private def void line(StringBuilder text, String name, String keyword, Object value) {
    if (value !== null) text.append(name + " " + keyword + " { " + value + " }\n")
  }
  private def void duration(StringBuilder text, EObject e, String feature, String keyword, String name) {
    line(text, name, keyword, number(e, feature) + " s")
  }
  private def void reference(StringBuilder text, EObject e, String feature, String keyword) {
    line(text, nameMap.get(e), keyword, refName(value(e, feature)))
  }
  private def void optional(StringBuilder text, EObject e, String feature, String keyword) {
    if (isSet(e, feature)) line(text, nameMap.get(e), keyword, value(e, feature))
  }
  private def String refName(Object ref) {
    val name = nameMap.get(ref)
    if (name === null) throw new IllegalArgumentException("Reference has no exported declaration: " + ref)
    name
  }
  private def String exportName(EObject e) {
    val raw = value(e, "name")
    var base = if (raw === null) e.eClass.name else raw.toString.trim.replaceAll("[^A-Za-z0-9_]", "_")
    if (base.empty) base = e.eClass.name
    if (!base.substring(0, 1).matches("[A-Za-z_]")) base = "E_" + base
    var candidate = base
    var suffix = 2
    while (!usedNames.add(candidate)) {
      candidate = base + "_" + suffix
      suffix = suffix + 1
    }
    candidate
  }
  private def String quote(String text) {
    if (text.contains("'") || text.contains("\n") || text.contains("\r") || text.contains("{") || text.contains("}"))
      throw new IllegalArgumentException("Expression contains unsupported CFG delimiters: " + text)
    "'" + text + "'"
  }
  private def void validate(EObject e) {
    switch e.eClass.name {
      case "EntityGenerator": {
        refName(value(e, "prototype"))
        refName(value(e, "nextComponent"))
        if (number(e, "interArrivalTime") <= 0 || number(e, "entitiesPerArrival") <= 0)
          throw new IllegalArgumentException("Generator requires positive interArrivalTime and entitiesPerArrival")
      }
      case "Server": {
        val queue = value(e, "waitQueue")
        refName(queue)
        if (!(queue instanceof EObject) || (queue as EObject).eClass.name != "Queue")
          throw new IllegalArgumentException("Server.waitQueue must reference a Queue")
        refName(value(e, "nextComponent"))
      }
      case "EntityConveyor": refName(value(e, "nextComponent"))
      case "Branch": {
        val targets = value(e, "nextComponentList") as List<?>
        if (targets === null || targets.empty) throw new IllegalArgumentException("Branch requires destinations")
        targets.forEach[refName(it)]
        val choice = value(e, "choice")
        if (choice === null || choice.toString.trim.empty) throw new IllegalArgumentException("Branch requires Choice")
        quote(choice.toString)
      }
    }
  }
}
