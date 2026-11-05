package com.your.m2t;

import com.google.common.collect.Iterables;
import jaamsim.Branch;
import jaamsim.Component;
import jaamsim.EntityConveyor;
import jaamsim.EntityGenerator;
import jaamsim.EntitySink;
import jaamsim.Queue;
import jaamsim.Server;
import jaamsim.SimEntity;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class M2T {
  private final LinkedHashMap<EObject, String> nameMap = new LinkedHashMap<EObject, String>();

  private final LinkedHashMap<String, Integer> counters = new LinkedHashMap<String, Integer>();

  public void exportToConfig(final Resource model, final URI outputUri) {
    try {
      String _fileString = outputUri.toFileString();
      File _file = new File(_fileString);
      final FileWriter out = new FileWriter(_file);
      try {
        final List<EObject> all = IterableExtensions.<EObject>toList(Iterables.<EObject>filter(IteratorExtensions.<EObject>toIterable(model.getAllContents()), EObject.class));
        final List<EntityConveyor> conveyors = IterableExtensions.<EntityConveyor>toList(Iterables.<EntityConveyor>filter(all, EntityConveyor.class));
        final List<EntityGenerator> generators = IterableExtensions.<EntityGenerator>toList(Iterables.<EntityGenerator>filter(all, EntityGenerator.class));
        final List<EntitySink> sinks = IterableExtensions.<EntitySink>toList(Iterables.<EntitySink>filter(all, EntitySink.class));
        final List<Queue> queues = IterableExtensions.<Queue>toList(Iterables.<Queue>filter(all, Queue.class));
        final List<Server> servers = IterableExtensions.<Server>toList(Iterables.<Server>filter(all, Server.class));
        final List<Branch> branches = IterableExtensions.<Branch>toList(Iterables.<Branch>filter(all, Branch.class));
        final List<SimEntity> simEnts = IterableExtensions.<SimEntity>toList(Iterables.<SimEntity>filter(all, SimEntity.class));
        final Consumer<SimEntity> _function = (SimEntity e) -> {
          this.nameMap.put(e, this.exportName(e));
        };
        simEnts.forEach(_function);
        final Consumer<EntityGenerator> _function_1 = (EntityGenerator e) -> {
          this.nameMap.put(e, this.exportName(e));
        };
        generators.forEach(_function_1);
        final Consumer<EntityConveyor> _function_2 = (EntityConveyor e) -> {
          this.nameMap.put(e, this.exportName(e));
        };
        conveyors.forEach(_function_2);
        final Consumer<Branch> _function_3 = (Branch e) -> {
          this.nameMap.put(e, this.exportName(e));
        };
        branches.forEach(_function_3);
        final Consumer<Queue> _function_4 = (Queue e) -> {
          this.nameMap.put(e, this.exportName(e));
        };
        queues.forEach(_function_4);
        final Consumer<Server> _function_5 = (Server e) -> {
          this.nameMap.put(e, this.exportName(e));
        };
        servers.forEach(_function_5);
        final Consumer<EntitySink> _function_6 = (EntitySink e) -> {
          this.nameMap.put(e, this.exportName(e));
        };
        sinks.forEach(_function_6);
        out.write("RecordEdits\n\n");
        this.writeDefine(out, "Branch", branches);
        this.writeDefine(out, "EntityConveyor", conveyors);
        this.writeDefine(out, "EntityGenerator", generators);
        this.writeDefine(out, "EntitySink", sinks);
        this.writeDefine(out, "Queue", queues);
        this.writeDefine(out, "Server", servers);
        this.writeDefine(out, "SimEntity", simEnts);
        out.write("Define ColladaModel { Axis  Grid100x100 }\n");
        out.write("Define DisplayEntity { XY-Grid  XYZ-Axis }\n");
        out.write("Define OverlayClock { Clock }\n");
        out.write("Define OverlayText { Title }\n");
        out.write("Define View { View1 }\n\n");
        out.write("Simulation Description { \'Simulation run control inputs\' }\n\n");
        boolean _isEmpty = branches.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          out.write("# *** Branch ***\n\n");
          for (final Branch b : branches) {
            {
              final String bName = this.nameMap.get(b);
              final Object ncl = this.getIfSet(b, "nextComponentList");
              final String refs = this.refList(ncl);
              if (((refs != null) && (!refs.isEmpty()))) {
                out.write((((bName + " NextComponentList { ") + refs) + " }\n"));
              }
              final Object choice = this.getIfSet(b, "choice");
              if (((choice != null) && (!choice.toString().trim().isEmpty()))) {
                String _quote = this.quote(choice.toString());
                String _plus = ((bName + " Choice { ") + _quote);
                String _plus_1 = (_plus + " }\n");
                out.write(_plus_1);
              }
              out.write("\n");
            }
          }
        }
        boolean _isEmpty_1 = conveyors.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          out.write("# *** EntityConveyor ***\n\n");
          for (final EntityConveyor c : conveyors) {
            {
              final String cName = this.nameMap.get(c);
              Component _nextComponent = c.getNextComponent();
              boolean _tripleNotEquals = (_nextComponent != null);
              if (_tripleNotEquals) {
                String _refName = this.refName(c.getNextComponent());
                String _plus = ((cName + " NextComponent { ") + _refName);
                String _plus_1 = (_plus + " }\n");
                out.write(_plus_1);
              }
              final String tt = this.timeSec(c, "travelTime");
              if ((tt != null)) {
                out.write((((cName + " TravelTime { ") + tt) + " }\n"));
              }
              out.write("\n");
            }
          }
        }
        boolean _isEmpty_2 = generators.isEmpty();
        boolean _not_2 = (!_isEmpty_2);
        if (_not_2) {
          out.write("# *** EntityGenerator ***\n\n");
          for (final EntityGenerator g : generators) {
            {
              final String gName = this.nameMap.get(g);
              Component _nextComponent = g.getNextComponent();
              boolean _tripleNotEquals = (_nextComponent != null);
              if (_tripleNotEquals) {
                String _refName = this.refName(g.getNextComponent());
                String _plus = ((gName + " NextComponent { ") + _refName);
                String _plus_1 = (_plus + " }\n");
                out.write(_plus_1);
              }
              final String iat = this.timeSec(g, "interArrivalTime");
              if ((iat != null)) {
                out.write((((gName + " InterArrivalTime { ") + iat) + " }\n"));
              }
              int _entitiesPerArrival = g.getEntitiesPerArrival();
              boolean _greaterThan = (_entitiesPerArrival > 0);
              if (_greaterThan) {
                int _entitiesPerArrival_1 = g.getEntitiesPerArrival();
                String _plus_2 = ((gName + " EntitiesPerArrival { ") + Integer.valueOf(_entitiesPerArrival_1));
                String _plus_3 = (_plus_2 + " }\n");
                out.write(_plus_3);
              }
              SimEntity _prototype = g.getPrototype();
              boolean _tripleNotEquals_1 = (_prototype != null);
              if (_tripleNotEquals_1) {
                String _refName_1 = this.refName(g.getPrototype());
                String _plus_4 = ((gName + " PrototypeEntity { ") + _refName_1);
                String _plus_5 = (_plus_4 + " }\n");
                out.write(_plus_5);
              }
              int _maxNumber = g.getMaxNumber();
              boolean _greaterThan_1 = (_maxNumber > 0);
              if (_greaterThan_1) {
                int _maxNumber_1 = g.getMaxNumber();
                String _plus_6 = ((gName + " MaxNumber { ") + Integer.valueOf(_maxNumber_1));
                String _plus_7 = (_plus_6 + " }\n");
                out.write(_plus_7);
              }
              out.write("\n");
            }
          }
        }
        boolean _isEmpty_3 = queues.isEmpty();
        boolean _not_3 = (!_isEmpty_3);
        if (_not_3) {
          out.write("# *** Queue ***\n\n");
          for (final Queue q : queues) {
            {
              final String qName = this.nameMap.get(q);
              final Object pr = this.getIfSet(q, "priority");
              if ((pr != null)) {
                out.write((((qName + " Priority { ") + pr) + " }\n"));
              }
              final Object m = this.getIfSet(q, "match");
              if (((m != null) && (!m.toString().trim().isEmpty()))) {
                out.write((((qName + " Match { ") + m) + " }\n"));
              }
              final Object fifo = this.getIfSet(q, "fifo");
              if ((fifo != null)) {
                String _boolUpper = this.boolUpper(fifo);
                String _plus = ((qName + " FIFO { ") + _boolUpper);
                String _plus_1 = (_plus + " }\n");
                out.write(_plus_1);
              }
              final String rt = this.timeSecIfSet(q, "renegeTime");
              if ((rt != null)) {
                out.write((((qName + " RenegeTime { ") + rt) + " }\n"));
              }
              final Object rc = this.getIfSet(q, "renegeCondition");
              if ((rc != null)) {
                out.write((((qName + " RenegeCondition { ") + rc) + " }\n"));
              }
              final Object rd = this.getIfSet(q, "renegeDestination");
              if ((rd instanceof EObject)) {
                String _refName = this.refName(((EObject) rd));
                String _plus_2 = ((qName + " RenegeDestination { ") + _refName);
                String _plus_3 = (_plus_2 + " }\n");
                out.write(_plus_3);
              }
              final Object mvl = this.getIfSet(q, "maxValidLength");
              if ((mvl != null)) {
                out.write((((qName + " MaxValidLength { ") + mvl) + " }\n"));
              }
              out.write("\n");
            }
          }
        }
        boolean _isEmpty_4 = servers.isEmpty();
        boolean _not_4 = (!_isEmpty_4);
        if (_not_4) {
          out.write("# *** Server ***\n\n");
          for (final Server s : servers) {
            {
              final String sName = this.nameMap.get(s);
              Component _nextComponent = s.getNextComponent();
              boolean _tripleNotEquals = (_nextComponent != null);
              if (_tripleNotEquals) {
                String _refName = this.refName(s.getNextComponent());
                String _plus = ((sName + " NextComponent { ") + _refName);
                String _plus_1 = (_plus + " }\n");
                out.write(_plus_1);
              }
              Queue _waitQueue = s.getWaitQueue();
              boolean _tripleNotEquals_1 = (_waitQueue != null);
              if (_tripleNotEquals_1) {
                String _refName_1 = this.refName(s.getWaitQueue());
                String _plus_2 = ((sName + " WaitQueue { ") + _refName_1);
                String _plus_3 = (_plus_2 + " }\n");
                out.write(_plus_3);
              }
              final String st = this.timeSecIfSet(s, "serviceTime");
              if ((st != null)) {
                out.write((((sName + " ServiceTime { ") + st) + " }\n"));
              }
              out.write("\n");
            }
          }
        }
        out.write("# *** GRAPHICS INPUTS ***\n\n");
        out.write("Simulation RealTime { TRUE }\n");
        out.write("Simulation SnapToGrid { TRUE }\n");
        out.write("Simulation ShowLabels { TRUE }\n");
        out.write("Simulation ShowSubModels { TRUE }\n");
        out.write("Simulation ShowReferences { FALSE }\n");
        out.write("Simulation ShowEntityFlow { TRUE }\n");
        out.write("Simulation ShowModelBuilder { TRUE }\n");
        out.write("Simulation ShowObjectSelector { TRUE }\n");
        out.write("Simulation ShowInputEditor { TRUE }\n");
        out.write("Simulation ShowOutputViewer { TRUE }\n");
        out.write("Simulation ShowPropertyViewer { FALSE }\n");
        out.write("Simulation ShowLogViewer { FALSE }\n\n");
        int idx = 0;
        final double step = 2.0;
        Set<EObject> _keySet = this.nameMap.keySet();
        for (final EObject e : _keySet) {
          {
            final String n = this.nameMap.get(e);
            final double x = (idx * step);
            out.write((((n + " Position { ") + Double.valueOf(x)) + "  0.0  0.0  m }\n\n"));
            idx = (idx + 1);
          }
        }
        out.write(this.staticUiBlock());
      } finally {
        out.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private void writeDefine(final FileWriter out, final String typeName, final Iterable<? extends EObject> elements) {
    try {
      boolean _isEmpty = IterableExtensions.isEmpty(elements);
      boolean _not = (!_isEmpty);
      if (_not) {
        final Function1<EObject, String> _function = (EObject e) -> {
          return this.nameMap.get(e);
        };
        final String names = IterableExtensions.join(IterableExtensions.map(elements, _function), "  ");
        out.write((((("Define " + typeName) + " { ") + names) + " }\n"));
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private String exportName(final EObject e) {
    final String rawName = this.tryGetName(e);
    if (((rawName != null) && (!rawName.trim().isEmpty()))) {
      final String normalized = this.normalizeName(rawName.trim());
      boolean _isEmpty = normalized.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        return normalized;
      }
    }
    final String type = e.eClass().getName();
    Integer _elvis = null;
    Integer _get = this.counters.get(type);
    if (_get != null) {
      _elvis = _get;
    } else {
      _elvis = Integer.valueOf(0);
    }
    final int next = ((_elvis).intValue() + 1);
    this.counters.put(type, Integer.valueOf(next));
    return (type + Integer.valueOf(next));
  }

  private String normalizeName(final String s) {
    return s.replaceAll("[^A-Za-z0-9]", "");
  }

  private String refName(final Object ref) {
    if ((ref instanceof EObject)) {
      final EObject eo = ((EObject) ref);
      String n = this.nameMap.get(eo);
      if ((n == null)) {
        n = this.exportName(eo);
        this.nameMap.put(eo, n);
      }
      return n;
    }
    return ref.toString();
  }

  private String tryGetName(final EObject e) {
    String _xblockexpression = null;
    {
      final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equals(_name, "name"));
      };
      final EStructuralFeature f = IterableExtensions.<EStructuralFeature>findFirst(e.eClass().getEStructuralFeatures(), _function);
      if ((f == null)) {
        return null;
      }
      final Object v = e.eGet(f);
      String _xifexpression = null;
      if ((v == null)) {
        _xifexpression = null;
      } else {
        _xifexpression = v.toString();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  private String timeSec(final EObject e, final String featureName) {
    String _xblockexpression = null;
    {
      final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equals(_name, featureName));
      };
      final EStructuralFeature f = IterableExtensions.<EStructuralFeature>findFirst(e.eClass().getEStructuralFeatures(), _function);
      if ((f == null)) {
        return null;
      }
      final Object v = e.eGet(f);
      if ((v == null)) {
        return null;
      }
      final String txt = v.toString().trim();
      boolean _isEmpty = txt.isEmpty();
      if (_isEmpty) {
        return null;
      }
      _xblockexpression = (txt + "  s");
    }
    return _xblockexpression;
  }

  private Object getIfSet(final EObject e, final String featureName) {
    Object _xblockexpression = null;
    {
      final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equals(_name, featureName));
      };
      final EStructuralFeature f = IterableExtensions.<EStructuralFeature>findFirst(e.eClass().getEStructuralFeatures(), _function);
      if ((f == null)) {
        return null;
      }
      boolean _eIsSet = e.eIsSet(f);
      boolean _not = (!_eIsSet);
      if (_not) {
        return null;
      }
      _xblockexpression = e.eGet(f);
    }
    return _xblockexpression;
  }

  private String timeSecIfSet(final EObject e, final String featureName) {
    String _xblockexpression = null;
    {
      final Object v = this.getIfSet(e, featureName);
      if ((v == null)) {
        return null;
      }
      final String txt = v.toString().trim();
      boolean _isEmpty = txt.isEmpty();
      if (_isEmpty) {
        return null;
      }
      _xblockexpression = (txt + "  s");
    }
    return _xblockexpression;
  }

  private String boolUpper(final Object v) {
    String _xblockexpression = null;
    {
      if ((v == null)) {
        return null;
      }
      if ((v instanceof Boolean)) {
        String _xifexpression = null;
        if ((((Boolean) v)).booleanValue()) {
          _xifexpression = "TRUE";
        } else {
          _xifexpression = "FALSE";
        }
        return _xifexpression;
      }
      final String t = v.toString().trim().toLowerCase();
      String _xifexpression_1 = null;
      boolean _equals = Objects.equals(t, "true");
      if (_equals) {
        _xifexpression_1 = "TRUE";
      } else {
        String _xifexpression_2 = null;
        boolean _equals_1 = Objects.equals(t, "false");
        if (_equals_1) {
          _xifexpression_2 = "FALSE";
        } else {
          _xifexpression_2 = v.toString();
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xblockexpression = _xifexpression_1;
    }
    return _xblockexpression;
  }

  private String refList(final Object v) {
    Object _xblockexpression = null;
    {
      if ((v == null)) {
        return null;
      }
      if ((v instanceof List<?>)) {
        final List<?> lst = ((List<?>) v);
        final Function1<EObject, String> _function = (EObject eo) -> {
          return this.refName(((EObject) eo));
        };
        final String names = IterableExtensions.join(IterableExtensions.<EObject, String>map(Iterables.<EObject>filter(lst, EObject.class), _function), "  ");
        return names;
      }
      if ((v instanceof EObject)) {
        return this.refName(((EObject) v));
      }
      _xblockexpression = null;
    }
    return ((String)_xblockexpression);
  }

  private String quote(final String s) {
    String _xblockexpression = null;
    {
      final String esc = s.replace("\'", "\\\'");
      _xblockexpression = (("\'" + esc) + "\'");
    }
    return _xblockexpression;
  }

  private String staticUiBlock() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("# *** ColladaModel ***");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Axis ColladaFile { <res>/shapes/axis_text.dae }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Grid100x100 ColladaFile { <res>/shapes/grid100x100.dae }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("# *** DisplayEntity ***");
    _builder.newLine();
    _builder.newLine();
    _builder.append("XY-Grid Description { \'Grid for the X-Y plane (100 m x 100 m)\' }");
    _builder.newLine();
    _builder.append("XY-Grid Size { 100  100  m }");
    _builder.newLine();
    _builder.append("XY-Grid DisplayModel { Grid100x100 }");
    _builder.newLine();
    _builder.append("XY-Grid Show { FALSE }");
    _builder.newLine();
    _builder.append("XY-Grid Movable { FALSE }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("XYZ-Axis Description { \'Unit vectors\' }");
    _builder.newLine();
    _builder.append("XYZ-Axis Alignment { -0.4393409  -0.4410096  -0.4394292 }");
    _builder.newLine();
    _builder.append("XYZ-Axis Size { 1.125000  1.1568242  1.1266404  m }");
    _builder.newLine();
    _builder.append("XYZ-Axis DisplayModel { Axis }");
    _builder.newLine();
    _builder.append("XYZ-Axis Show { FALSE }");
    _builder.newLine();
    _builder.append("XYZ-Axis Movable { FALSE }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("# *** OverlayClock ***");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Clock Description { \'Simulation date and time\' }");
    _builder.newLine();
    _builder.append("Clock ScreenPosition { 15  15 }");
    _builder.newLine();
    _builder.append("Clock AlignBottom { TRUE }");
    _builder.newLine();
    _builder.append("Clock TextHeight { 10 }");
    _builder.newLine();
    _builder.append("Clock FontColour { gray20 }");
    _builder.newLine();
    _builder.append("Clock FontStyle { ITALIC }");
    _builder.newLine();
    _builder.append("Clock DateFormat { \'yyyy-MMM-dd HH:mm:ss.SSS\' }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("# *** OverlayText ***");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Title Description { \'Title for the simulation model\' }");
    _builder.newLine();
    _builder.append("Title ScreenPosition { 15  15 }");
    _builder.newLine();
    _builder.append("Title Format { \'Model Title\' }");
    _builder.newLine();
    _builder.append("Title TextHeight { 18 }");
    _builder.newLine();
    _builder.append("Title FontColour { 150  23  46 }");
    _builder.newLine();
    _builder.append("Title FontStyle { BOLD }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("# *** View ***");
    _builder.newLine();
    _builder.newLine();
    _builder.append("View1 Description { \'Default view window\' }");
    _builder.newLine();
    _builder.append("View1 ViewCenter { 1.3  -0.7  0.0  m }");
    _builder.newLine();
    _builder.append("View1 ViewPosition { 1.3  -0.7  17.320508  m }");
    _builder.newLine();
    _builder.append("View1 ShowWindow { TRUE }");
    _builder.newLine();
    _builder.append("View1 Lock2D { TRUE }");
    _builder.newLine();
    _builder.append("View1 SkyboxImage { <res>/images/sky_map_2048x1024.jpg }");
    _builder.newLine();
    return _builder.toString();
  }
}
