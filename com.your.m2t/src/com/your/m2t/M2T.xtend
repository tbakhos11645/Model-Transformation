package com.your.m2t

import jaamsim.Branch
import jaamsim.EntityConveyor
import jaamsim.EntityGenerator
import jaamsim.EntitySink
import jaamsim.Queue
import jaamsim.Server
import jaamsim.SimEntity
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import java.io.File
import java.io.FileWriter
import java.util.LinkedHashMap
import java.util.List

class M2T {

  val nameMap = new LinkedHashMap<EObject, String>
  val counters = new LinkedHashMap<String, Integer>

  def void exportToConfig(Resource model, URI outputUri) {
    val out = new FileWriter(new File(outputUri.toFileString))
    try {
      val all = model.allContents.toIterable.filter(EObject).toList

      // Collect by type (Queues may be under <components>, still found by allContents)
      val conveyors  = all.filter(EntityConveyor).toList
      val generators = all.filter(EntityGenerator).toList
      val sinks      = all.filter(EntitySink).toList
      val queues     = all.filter(Queue).toList
      val servers    = all.filter(Server).toList
      val branches   = all.filter(Branch).toList
      val simEnts    = all.filter(SimEntity).toList

      // Build names first (so references resolve)
      simEnts.forEach    [e | nameMap.put(e, exportName(e))]
      generators.forEach [e | nameMap.put(e, exportName(e))]
      conveyors.forEach  [e | nameMap.put(e, exportName(e))]
      branches.forEach   [e | nameMap.put(e, exportName(e))]
      queues.forEach     [e | nameMap.put(e, exportName(e))]
      servers.forEach    [e | nameMap.put(e, exportName(e))]
      sinks.forEach      [e | nameMap.put(e, exportName(e))]

      // Header
      out.write("RecordEdits\n\n")

      // Defines (ordering close to your sample CFG)
      writeDefine(out, "Branch", branches)
      writeDefine(out, "EntityConveyor", conveyors)
      writeDefine(out, "EntityGenerator", generators)
      writeDefine(out, "EntitySink", sinks)
      writeDefine(out, "Queue", queues)
      writeDefine(out, "Server", servers)
      writeDefine(out, "SimEntity", simEnts)

      // Default UI Define block
      out.write("Define ColladaModel { Axis  Grid100x100 }\n")
      out.write("Define DisplayEntity { XY-Grid  XYZ-Axis }\n")
      out.write("Define OverlayClock { Clock }\n")
      out.write("Define OverlayText { Title }\n")
      out.write("Define View { View1 }\n\n")

      out.write("Simulation Description { 'Simulation run control inputs' }\n\n")

      // *** Branch ***
      if (!branches.empty) {
        out.write("# *** Branch ***\n\n")
        for (b : branches) {
          val bName = nameMap.get(b)

          // nextComponentList: list of references
          val ncl = getIfSet(b, "nextComponentList")
          val refs = refList(ncl)
          if (refs !== null && !refs.empty)
            out.write(bName + " NextComponentList { " + refs + " }\n")

          // choice: expression stored as string attribute
          val choice = getIfSet(b, "choice")
          if (choice !== null && !choice.toString.trim.empty)
            out.write(bName + " Choice { " + quote(choice.toString) + " }\n")

          out.write("\n")
        }
      }

      // *** EntityConveyor ***
      if (!conveyors.empty) {
        out.write("# *** EntityConveyor ***\n\n")
        for (c : conveyors) {
          val cName = nameMap.get(c)

          if (c.nextComponent !== null)
            out.write(cName + " NextComponent { " + refName(c.nextComponent) + " }\n")

          val tt = timeSec(c, "travelTime")
          if (tt !== null)
            out.write(cName + " TravelTime { " + tt + " }\n")

          out.write("\n")
        }
      }

      // *** EntityGenerator ***
      if (!generators.empty) {
        out.write("# *** EntityGenerator ***\n\n")
        for (g : generators) {
          val gName = nameMap.get(g)

          if (g.nextComponent !== null)
            out.write(gName + " NextComponent { " + refName(g.nextComponent) + " }\n")

          val iat = timeSec(g, "interArrivalTime")
          if (iat !== null)
            out.write(gName + " InterArrivalTime { " + iat + " }\n")

          if (g.entitiesPerArrival > 0)
            out.write(gName + " EntitiesPerArrival { " + g.entitiesPerArrival + " }\n")

          if (g.prototype !== null)
            out.write(gName + " PrototypeEntity { " + refName(g.prototype) + " }\n")

          if (g.maxNumber > 0)
            out.write(gName + " MaxNumber { " + g.maxNumber + " }\n")

          out.write("\n")
        }
      }

      // *** Queue ***
      if (!queues.empty) {
        out.write("# *** Queue ***\n\n")
        for (q : queues) {
          val qName = nameMap.get(q)

          // print only what exists in XMI
          val pr = getIfSet(q, "priority")
          if (pr !== null) out.write(qName + " Priority { " + pr + " }\n")

          val m = getIfSet(q, "match")
          if (m !== null && !m.toString.trim.empty) out.write(qName + " Match { " + m + " }\n")

          val fifo = getIfSet(q, "fifo")
          if (fifo !== null) out.write(qName + " FIFO { " + boolUpper(fifo) + " }\n")

          val rt = timeSecIfSet(q, "renegeTime")
          if (rt !== null) out.write(qName + " RenegeTime { " + rt + " }\n")

          val rc = getIfSet(q, "renegeCondition")
          if (rc !== null) out.write(qName + " RenegeCondition { " + rc + " }\n")

          val rd = getIfSet(q, "renegeDestination")
          if (rd instanceof EObject) out.write(qName + " RenegeDestination { " + refName(rd as EObject) + " }\n")

          val mvl = getIfSet(q, "maxValidLength")
          if (mvl !== null) out.write(qName + " MaxValidLength { " + mvl + " }\n")

          out.write("\n")
        }
      }

      // *** Server ***
      if (!servers.empty) {
        out.write("# *** Server ***\n\n")
        for (s : servers) {
          val sName = nameMap.get(s)

          if (s.nextComponent !== null)
            out.write(sName + " NextComponent { " + refName(s.nextComponent) + " }\n")

          if (s.waitQueue !== null)
            out.write(sName + " WaitQueue { " + refName(s.waitQueue) + " }\n")

          val st = timeSecIfSet(s, "serviceTime")
          if (st !== null)
            out.write(sName + " ServiceTime { " + st + " }\n")

          out.write("\n")
        }
      }

      // *** GRAPHICS INPUTS ***
      out.write("# *** GRAPHICS INPUTS ***\n\n")
      out.write("Simulation RealTime { TRUE }\n")
      out.write("Simulation SnapToGrid { TRUE }\n")
      out.write("Simulation ShowLabels { TRUE }\n")
      out.write("Simulation ShowSubModels { TRUE }\n")
      out.write("Simulation ShowReferences { FALSE }\n")
      out.write("Simulation ShowEntityFlow { TRUE }\n")
      out.write("Simulation ShowModelBuilder { TRUE }\n")
      out.write("Simulation ShowObjectSelector { TRUE }\n")
      out.write("Simulation ShowInputEditor { TRUE }\n")
      out.write("Simulation ShowOutputViewer { TRUE }\n")
      out.write("Simulation ShowPropertyViewer { FALSE }\n")
      out.write("Simulation ShowLogViewer { FALSE }\n\n")

      // Incremental positions for ALL objects (simple layout)
      var idx = 0
      val step = 2.0
      for (e : nameMap.keySet) {
        val n = nameMap.get(e)
        val x = idx * step
        out.write(n + " Position { " + x + "  0.0  0.0  m }\n\n")
        idx = idx + 1
      }

      out.write(staticUiBlock)

    } finally {
      out.close
    }
  }

  private def void writeDefine(FileWriter out, String typeName, Iterable<? extends EObject> elements) {
    if (!elements.empty) {
      val names = elements.map[e | nameMap.get(e)].join("  ")
      out.write("Define " + typeName + " { " + names + " }\n")
    }
  }

  // Unified naming: if name exists -> normalized; else -> <EClassName><n>
  private def String exportName(EObject e) {
    val rawName = tryGetName(e)
    if (rawName !== null && !rawName.trim.empty) {
      val normalized = normalizeName(rawName.trim)
      if (!normalized.empty) return normalized
    }

    val type = e.eClass.name
    val next = (counters.get(type) ?: 0) + 1
    counters.put(type, next)
    return type + next
  }

  private def String normalizeName(String s) {
    s.replaceAll("[^A-Za-z0-9]", "")
  }

  private def String refName(Object ref) {
    if (ref instanceof EObject) {
      val eo = ref as EObject
      var n = nameMap.get(eo)
      if (n === null) {
        n = exportName(eo)
        nameMap.put(eo, n)
      }
      return n
    }
    return ref.toString
  }

  private def String tryGetName(EObject e) {
    val f = e.eClass.EStructuralFeatures.findFirst[it.name == "name"]
    if (f === null) return null
    val v = e.eGet(f)
    if (v === null) null else v.toString
  }

  // Always seconds unit, keep numeric text
  private def String timeSec(EObject e, String featureName) {
    val f = e.eClass.EStructuralFeatures.findFirst[it.name == featureName]
    if (f === null) return null
    val v = e.eGet(f)
    if (v === null) return null
    val txt = v.toString.trim
    if (txt.empty) return null
    txt + "  s"
  }

  private def Object getIfSet(EObject e, String featureName) {
    val f = e.eClass.EStructuralFeatures.findFirst[it.name == featureName]
    if (f === null) return null
    if (!e.eIsSet(f)) return null
    e.eGet(f)
  }

  private def String timeSecIfSet(EObject e, String featureName) {
    val v = getIfSet(e, featureName)
    if (v === null) return null
    val txt = v.toString.trim
    if (txt.empty) return null
    txt + "  s"
  }

  private def String boolUpper(Object v) {
    if (v === null) return null
    if (v instanceof Boolean) return (v as Boolean) ? "TRUE" : "FALSE"
    val t = v.toString.trim.toLowerCase
    if (t == "true") "TRUE" else if (t == "false") "FALSE" else v.toString
  }

  // Branch nextComponentList helper
  private def String refList(Object v) {
    if (v === null) return null
    if (v instanceof List<?>) {
      val lst = v as List<?>
      val names = lst.filter(EObject).map[eo | refName(eo as EObject)].join("  ")
      return names
    }
    // if somehow single value
    if (v instanceof EObject) return refName(v as EObject)
    null
  }

  // Quote branch choice like your CFG sample: Choice { '...' }
  private def String quote(String s) {
    val esc = s.replace("'", "\\'")
    "'" + esc + "'"
  }

  private def String staticUiBlock() '''
# *** ColladaModel ***

Axis ColladaFile { <res>/shapes/axis_text.dae }

Grid100x100 ColladaFile { <res>/shapes/grid100x100.dae }

# *** DisplayEntity ***

XY-Grid Description { 'Grid for the X-Y plane (100 m x 100 m)' }
XY-Grid Size { 100  100  m }
XY-Grid DisplayModel { Grid100x100 }
XY-Grid Show { FALSE }
XY-Grid Movable { FALSE }

XYZ-Axis Description { 'Unit vectors' }
XYZ-Axis Alignment { -0.4393409  -0.4410096  -0.4394292 }
XYZ-Axis Size { 1.125000  1.1568242  1.1266404  m }
XYZ-Axis DisplayModel { Axis }
XYZ-Axis Show { FALSE }
XYZ-Axis Movable { FALSE }

# *** OverlayClock ***

Clock Description { 'Simulation date and time' }
Clock ScreenPosition { 15  15 }
Clock AlignBottom { TRUE }
Clock TextHeight { 10 }
Clock FontColour { gray20 }
Clock FontStyle { ITALIC }
Clock DateFormat { 'yyyy-MMM-dd HH:mm:ss.SSS' }

# *** OverlayText ***

Title Description { 'Title for the simulation model' }
Title ScreenPosition { 15  15 }
Title Format { 'Model Title' }
Title TextHeight { 18 }
Title FontColour { 150  23  46 }
Title FontStyle { BOLD }

# *** View ***

View1 Description { 'Default view window' }
View1 ViewCenter { 1.3  -0.7  0.0  m }
View1 ViewPosition { 1.3  -0.7  17.320508  m }
View1 ShowWindow { TRUE }
View1 Lock2D { TRUE }
View1 SkyboxImage { <res>/images/sky_map_2048x1024.jpg }
'''
}
