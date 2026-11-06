package com.your.m2t;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Reflective exporter: accepts both generated and dynamic EMF objects.
 */
@SuppressWarnings("all")
public class M2T {
  private final LinkedHashMap<EObject, String> nameMap = new LinkedHashMap<EObject, String>();

  private final LinkedHashSet<String> usedNames = new LinkedHashSet<String>();

  private final List<String> types = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("SimEntity", "EntityGenerator", "EntityConveyor", "Branch", "Queue", "Server", "EntitySink"));

  public void exportToConfig(final Resource model, final URI outputUri) {
    try {
      this.nameMap.clear();
      this.usedNames.clear();
      this.usedNames.addAll(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Simulation", "Axis", "Grid100x100", "XY-Grid", "XYZ-Axis", "Clock", "Title", "View1")));
      final List<EObject> all = IterableExtensions.<EObject>toList(IteratorExtensions.<EObject>toIterable(model.getAllContents()));
      final Function1<EObject, Boolean> _function = (EObject it) -> {
        String _name = it.eClass().getName();
        return Boolean.valueOf(Objects.equals(_name, "SimulationModel"));
      };
      final List<EObject> roots = IterableExtensions.<EObject>toList(IterableExtensions.<EObject>filter(all, _function));
      int _size = roots.size();
      boolean _notEquals = (_size != 1);
      if (_notEquals) {
        throw new IllegalArgumentException("Expected one SimulationModel");
      }
      for (final EObject e : all) {
        if (((!this.types.contains(e.eClass().getName())) && (!Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("SimulationModel", "Simulation", "Point3D")).contains(e.eClass().getName())))) {
          String _name = e.eClass().getName();
          String _plus = ("No CFG handler for " + _name);
          throw new IllegalArgumentException(_plus);
        }
      }
      final Function1<EObject, Boolean> _function_1 = (EObject it) -> {
        return Boolean.valueOf(this.types.contains(it.eClass().getName()));
      };
      final List<EObject> entities = IterableExtensions.<EObject>toList(IterableExtensions.<EObject>filter(all, _function_1));
      for (final EObject e_1 : entities) {
        this.nameMap.put(e_1, this.exportName(e_1));
      }
      for (final EObject e_2 : entities) {
        this.validate(e_2);
      }
      final LinkedHashMap<EObject, List<Double>> positions = this.layout(entities);
      final StringBuilder text = new StringBuilder("RecordEdits\n\n");
      for (final String type : this.types) {
        {
          final Function1<EObject, Boolean> _function_2 = (EObject it) -> {
            String _name_1 = it.eClass().getName();
            return Boolean.valueOf(Objects.equals(_name_1, type));
          };
          final List<EObject> elements = IterableExtensions.<EObject>toList(IterableExtensions.<EObject>filter(entities, _function_2));
          boolean _isEmpty = elements.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            final Function1<EObject, String> _function_3 = (EObject it) -> {
              return this.nameMap.get(it);
            };
            String _join = IterableExtensions.join(ListExtensions.<EObject, String>map(elements, _function_3), "  ");
            String _plus_1 = ((("Define " + type) + " { ") + _join);
            String _plus_2 = (_plus_1 + " }\n");
            text.append(_plus_2);
          }
        }
      }
      text.append("Define ColladaModel { Axis Grid100x100 }\n");
      text.append("Define DisplayEntity { XY-Grid XYZ-Axis }\n");
      text.append("Define OverlayClock { Clock }\nDefine OverlayText { Title }\nDefine View { View1 }\n\n");
      final Object simulation = this.value(IterableExtensions.<EObject>head(roots), "simulation");
      if ((simulation instanceof EObject)) {
        final EObject s = ((EObject)simulation);
        this.duration(text, s, "runDuration", "RunDuration", "Simulation");
        this.duration(text, s, "initializationDuration", "InitializationDuration", "Simulation");
        this.line(text, "Simulation", "ExitAtStop", this.bool(this.value(s, "exitAtStop")));
        this.line(text, "Simulation", "GlobalSubstreamSeed", this.value(s, "globalSubstreamSeed"));
      }
      this.line(text, "Simulation", "ShowEntityFlow", "TRUE");
      for (final EObject e_3 : entities) {
        {
          final String name = this.nameMap.get(e_3);
          String _name_1 = e_3.eClass().getName();
          String _plus_1 = ("\n# " + _name_1);
          String _plus_2 = (_plus_1 + "\n");
          text.append(_plus_2);
          String _name_2 = e_3.eClass().getName();
          if (_name_2 != null) {
            switch (_name_2) {
              case "EntityGenerator":
                this.reference(text, e_3, "nextComponent", "NextComponent");
                this.reference(text, e_3, "prototype", "PrototypeEntity");
                this.duration(text, e_3, "firstArrivalTime", "FirstArrivalTime", name);
                this.duration(text, e_3, "interArrivalTime", "InterArrivalTime", name);
                this.line(text, name, "EntitiesPerArrival", this.value(e_3, "entitiesPerArrival"));
                double _number = this.number(e_3, "maxNumber");
                boolean _greaterThan = (_number > 0);
                if (_greaterThan) {
                  this.line(text, name, "MaxNumber", this.value(e_3, "maxNumber"));
                }
                break;
              case "EntityConveyor":
                this.reference(text, e_3, "nextComponent", "NextComponent");
                this.duration(text, e_3, "travelTime", "TravelTime", name);
                break;
              case "Server":
                this.reference(text, e_3, "nextComponent", "NextComponent");
                this.reference(text, e_3, "waitQueue", "WaitQueue");
                this.duration(text, e_3, "serviceTime", "ServiceTime", name);
                break;
              case "Branch":
                Object _value = this.value(e_3, "nextComponentList");
                final List<?> targets = ((List<?>) _value);
                final Function1<Object, String> _function_2 = (Object it) -> {
                  return this.refName(it);
                };
                this.line(text, name, "NextComponentList", IterableExtensions.join(ListExtensions.map(targets, _function_2), "  "));
                this.line(text, name, "Choice", this.quote(this.value(e_3, "choice").toString()));
                break;
              case "Queue":
                this.optional(text, e_3, "priority", "Priority");
                this.optional(text, e_3, "match", "Match");
                this.line(text, name, "FIFO", this.bool(this.value(e_3, "fifo")));
                boolean _isSet = this.isSet(e_3, "renegeTime");
                if (_isSet) {
                  this.duration(text, e_3, "renegeTime", "RenegeTime", name);
                }
                this.optional(text, e_3, "renegeCondition", "RenegeCondition");
                Object _value_1 = this.value(e_3, "renegeDestination");
                boolean _tripleNotEquals = (_value_1 != null);
                if (_tripleNotEquals) {
                  this.reference(text, e_3, "renegeDestination", "RenegeDestination");
                }
                this.optional(text, e_3, "maxValidLength", "MaxValidLength");
                double _number_1 = this.number(e_3, "capacity");
                boolean _notEquals_1 = (_number_1 != 0);
                if (_notEquals_1) {
                  throw new IllegalArgumentException("Queue.capacity has no implemented JaamSim CFG equivalent; use maxValidLength explicitly");
                }
                break;
            }
          }
          String _name_3 = e_3.eClass().getName();
          boolean _equals = Objects.equals(_name_3, "EntityConveyor");
          if (_equals) {
            final Function1<EObject, Boolean> _function_3 = (EObject it) -> {
              return Boolean.valueOf(this.successors(it, entities).contains(e_3));
            };
            final EObject source = IterableExtensions.<EObject>findFirst(entities, _function_3);
            Object _value_2 = this.value(e_3, "nextComponent");
            final EObject target = ((EObject) _value_2);
            List<Double> _xifexpression = null;
            if ((source == null)) {
              _xifexpression = positions.get(e_3);
            } else {
              _xifexpression = positions.get(source);
            }
            final List<Double> start = _xifexpression;
            final List<Double> end = positions.get(target);
            String _xyz = this.xyz(start);
            String _plus_3 = ("{ " + _xyz);
            String _plus_4 = (_plus_3 + " } { ");
            String _xyz_1 = this.xyz(positions.get(e_3));
            String _plus_5 = (_plus_4 + _xyz_1);
            String _plus_6 = (_plus_5 + " } { ");
            String _xyz_2 = this.xyz(end);
            String _plus_7 = (_plus_6 + _xyz_2);
            String _plus_8 = (_plus_7 + " }");
            this.line(text, name, "Points", _plus_8);
          } else {
            this.line(text, name, "Position", this.xyz(positions.get(e_3)));
          }
          for (final String feature : Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("size", "orientation"))) {
            {
              final Object point = this.value(e_3, feature);
              if ((point instanceof EObject)) {
                String _xifexpression_1 = null;
                boolean _equals_1 = Objects.equals(feature, "size");
                if (_equals_1) {
                  _xifexpression_1 = "Size";
                } else {
                  _xifexpression_1 = "Orientation";
                }
                double _coordinate = this.coordinate(((EObject)point), "x");
                String _plus_9 = (Double.valueOf(_coordinate) + " ");
                double _coordinate_1 = this.coordinate(((EObject)point), "y");
                String _plus_10 = (_plus_9 + Double.valueOf(_coordinate_1));
                String _plus_11 = (_plus_10 + " ");
                double _coordinate_2 = this.coordinate(((EObject)point), "z");
                String _plus_12 = (_plus_11 + Double.valueOf(_coordinate_2));
                String _xifexpression_2 = null;
                boolean _equals_2 = Objects.equals(feature, "size");
                if (_equals_2) {
                  _xifexpression_2 = " m";
                } else {
                  _xifexpression_2 = " deg";
                }
                String _plus_13 = (_plus_12 + _xifexpression_2);
                this.line(text, name, _xifexpression_1, _plus_13);
              }
            }
          }
        }
      }
      text.append("\nAxis ColladaFile { <res>/shapes/axis_text.dae }\n");
      text.append("Grid100x100 ColladaFile { <res>/shapes/grid100x100.dae }\n");
      text.append("XY-Grid DisplayModel { Grid100x100 }\nXY-Grid Show { FALSE }\n");
      text.append("XYZ-Axis DisplayModel { Axis }\nXYZ-Axis Show { FALSE }\n");
      text.append("Clock ScreenPosition { 15 15 }\nClock DateFormat { \'yyyy-MMM-dd HH:mm:ss.SSS\' }\n");
      text.append("Title ScreenPosition { 15 40 }\nTitle Format { \'BPMN Simulation\' }\n");
      Double _xifexpression = null;
      boolean _isEmpty = positions.isEmpty();
      if (_isEmpty) {
        _xifexpression = Double.valueOf(0.0);
      } else {
        final Function1<List<Double>, Double> _function_2 = (List<Double> it) -> {
          return it.get(0);
        };
        _xifexpression = IterableExtensions.<Double>min(IterableExtensions.<List<Double>, Double>map(positions.values(), _function_2));
      }
      final Double minX = _xifexpression;
      Double _xifexpression_1 = null;
      boolean _isEmpty_1 = positions.isEmpty();
      if (_isEmpty_1) {
        _xifexpression_1 = Double.valueOf(0.0);
      } else {
        final Function1<List<Double>, Double> _function_3 = (List<Double> it) -> {
          return it.get(0);
        };
        _xifexpression_1 = IterableExtensions.<Double>max(IterableExtensions.<List<Double>, Double>map(positions.values(), _function_3));
      }
      final Double maxX = _xifexpression_1;
      Double _xifexpression_2 = null;
      boolean _isEmpty_2 = positions.isEmpty();
      if (_isEmpty_2) {
        _xifexpression_2 = Double.valueOf(0.0);
      } else {
        final Function1<List<Double>, Double> _function_4 = (List<Double> it) -> {
          return it.get(1);
        };
        _xifexpression_2 = IterableExtensions.<Double>min(IterableExtensions.<List<Double>, Double>map(positions.values(), _function_4));
      }
      final Double minY = _xifexpression_2;
      Double _xifexpression_3 = null;
      boolean _isEmpty_3 = positions.isEmpty();
      if (_isEmpty_3) {
        _xifexpression_3 = Double.valueOf(0.0);
      } else {
        final Function1<List<Double>, Double> _function_5 = (List<Double> it) -> {
          return it.get(1);
        };
        _xifexpression_3 = IterableExtensions.<Double>max(IterableExtensions.<List<Double>, Double>map(positions.values(), _function_5));
      }
      final Double maxY = _xifexpression_3;
      double _plus_1 = DoubleExtensions.operator_plus(minX, maxX);
      double _divide = (_plus_1 / 2);
      String _plus_2 = (Double.valueOf(_divide) + " ");
      double _plus_3 = DoubleExtensions.operator_plus(minY, maxY);
      double _divide_1 = (_plus_3 / 2);
      final String center = (_plus_2 + Double.valueOf(_divide_1));
      this.line(text, "View1", "ViewCenter", (center + " 0 m"));
      double _minus = DoubleExtensions.operator_minus(maxX, minX);
      double _minus_1 = DoubleExtensions.operator_minus(maxY, minY);
      double _max = Math.max(_minus, _minus_1);
      double _multiply = (_max * 2);
      double _max_1 = Math.max(20.0, _multiply);
      String _plus_4 = ((center + " ") + Double.valueOf(_max_1));
      String _plus_5 = (_plus_4 + " m");
      this.line(text, "View1", "ViewPosition", _plus_5);
      text.append("View1 ShowWindow { TRUE }\nView1 Lock2D { TRUE }\n");
      final OutputStream out = model.getResourceSet().getURIConverter().createOutputStream(outputUri);
      try {
        out.write(text.toString().getBytes(StandardCharsets.UTF_8));
      } finally {
        out.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Breadth-first placement follows execution edges, including queue-to-server pulls.
   * A visited set bounds loops; explicit model positions take precedence.
   */
  private LinkedHashMap<EObject, List<Double>> layout(final List<EObject> entities) {
    LinkedHashMap<EObject, List<Double>> _xblockexpression = null;
    {
      final LinkedHashMap<EObject, Integer> depth = new LinkedHashMap<EObject, Integer>();
      final ArrayList<EObject> pending = new ArrayList<EObject>();
      final Function1<EObject, Boolean> _function = (EObject it) -> {
        String _name = it.eClass().getName();
        return Boolean.valueOf(Objects.equals(_name, "EntityGenerator"));
      };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(entities, _function);
      for (final EObject e : _filter) {
        {
          depth.put(e, Integer.valueOf(0));
          pending.add(e);
        }
      }
      int cursor = 0;
      while ((cursor < pending.size())) {
        {
          final EObject e_1 = pending.get(cursor);
          List<EObject> _successors = this.successors(e_1, entities);
          for (final EObject next : _successors) {
            boolean _containsKey = depth.containsKey(next);
            boolean _not = (!_containsKey);
            if (_not) {
              Integer _get = depth.get(e_1);
              int _plus = ((_get).intValue() + 1);
              depth.put(next, Integer.valueOf(_plus));
              pending.add(next);
            }
          }
          cursor++;
        }
      }
      final LinkedHashMap<Integer, Integer> lanes = new LinkedHashMap<Integer, Integer>();
      final LinkedHashMap<EObject, List<Double>> positions = new LinkedHashMap<EObject, List<Double>>();
      for (final EObject e_1 : entities) {
        {
          Integer _xifexpression = null;
          boolean _containsKey = depth.containsKey(e_1);
          if (_containsKey) {
            _xifexpression = depth.get(e_1);
          } else {
            _xifexpression = Integer.valueOf(0);
          }
          final Integer d = _xifexpression;
          Integer _xifexpression_1 = null;
          boolean _containsKey_1 = lanes.containsKey(d);
          if (_containsKey_1) {
            _xifexpression_1 = lanes.get(d);
          } else {
            _xifexpression_1 = Integer.valueOf(0);
          }
          final Integer lane = _xifexpression_1;
          String _name = e_1.eClass().getName();
          boolean _notEquals = (!Objects.equals(_name, "SimEntity"));
          if (_notEquals) {
            lanes.put(d, Integer.valueOf(((lane).intValue() + 1)));
          }
          final Object p = this.value(e_1, "position");
          List<Double> _xifexpression_2 = null;
          if ((p instanceof EObject)) {
            double _coordinate = this.coordinate(((EObject)p), "x");
            double _coordinate_1 = this.coordinate(((EObject)p), "y");
            double _coordinate_2 = this.coordinate(((EObject)p), "z");
            _xifexpression_2 = Collections.<Double>unmodifiableList(CollectionLiterals.<Double>newArrayList(Double.valueOf(_coordinate), Double.valueOf(_coordinate_1), Double.valueOf(_coordinate_2)));
          } else {
            double _xifexpression_3 = (double) 0;
            String _name_1 = e_1.eClass().getName();
            boolean _equals = Objects.equals(_name_1, "SimEntity");
            if (_equals) {
              _xifexpression_3 = 4.0;
            } else {
              _xifexpression_3 = ((-(lane).intValue()) * 3.0);
            }
            _xifexpression_2 = Collections.<Double>unmodifiableList(CollectionLiterals.<Double>newArrayList(Double.valueOf(((d).intValue() * 3.0)), Double.valueOf(_xifexpression_3), Double.valueOf(0.0)));
          }
          positions.put(e_1, _xifexpression_2);
        }
      }
      _xblockexpression = positions;
    }
    return _xblockexpression;
  }

  private List<EObject> successors(final EObject e, final List<EObject> entities) {
    ArrayList<EObject> _xblockexpression = null;
    {
      final ArrayList<EObject> result = new ArrayList<EObject>();
      final Object next = this.value(e, "nextComponent");
      if ((next instanceof EObject)) {
        result.add(((EObject)next));
      }
      String _name = e.eClass().getName();
      boolean _equals = Objects.equals(_name, "Branch");
      if (_equals) {
        Object _value = this.value(e, "nextComponentList");
        for (final Object target : ((List<?>) _value)) {
          result.add(((EObject) target));
        }
      }
      String _name_1 = e.eClass().getName();
      boolean _equals_1 = Objects.equals(_name_1, "Queue");
      if (_equals_1) {
        final Function1<EObject, Boolean> _function = (EObject it) -> {
          return Boolean.valueOf((Objects.equals(it.eClass().getName(), "Server") && (this.value(it, "waitQueue") == e)));
        };
        result.addAll(IterableExtensions.<EObject>toList(IterableExtensions.<EObject>filter(entities, _function)));
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  private String xyz(final List<Double> p) {
    Double _get = p.get(0);
    String _plus = (_get + " ");
    Double _get_1 = p.get(1);
    String _plus_1 = (_plus + _get_1);
    String _plus_2 = (_plus_1 + " ");
    Double _get_2 = p.get(2);
    String _plus_3 = (_plus_2 + _get_2);
    return (_plus_3 + " m");
  }

  private Object value(final EObject e, final String feature) {
    Object _xblockexpression = null;
    {
      final EStructuralFeature f = e.eClass().getEStructuralFeature(feature);
      Object _xifexpression = null;
      if ((f == null)) {
        _xifexpression = null;
      } else {
        _xifexpression = e.eGet(f);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  private boolean isSet(final EObject e, final String feature) {
    boolean _xblockexpression = false;
    {
      final EStructuralFeature f = e.eClass().getEStructuralFeature(feature);
      _xblockexpression = ((f != null) && e.eIsSet(f));
    }
    return _xblockexpression;
  }

  private double number(final EObject e, final String feature) {
    double _xblockexpression = (double) 0;
    {
      final double n = this.coordinate(e, feature);
      if ((n < 0)) {
        throw new IllegalArgumentException(((("Invalid " + feature) + ": ") + Double.valueOf(n)));
      }
      _xblockexpression = n;
    }
    return _xblockexpression;
  }

  private double coordinate(final EObject e, final String feature) {
    double _xblockexpression = (double) 0;
    {
      final Object v = this.value(e, feature);
      if ((!(v instanceof Number))) {
        throw new IllegalArgumentException(("Missing numeric feature " + feature));
      }
      final double n = ((Number) v).doubleValue();
      boolean _isFinite = Double.isFinite(n);
      boolean _not = (!_isFinite);
      if (_not) {
        throw new IllegalArgumentException(((("Invalid " + feature) + ": ") + Double.valueOf(n)));
      }
      _xblockexpression = n;
    }
    return _xblockexpression;
  }

  private String bool(final Object value) {
    String _xifexpression = null;
    boolean _equals = Objects.equals(Boolean.TRUE, value);
    if (_equals) {
      _xifexpression = "TRUE";
    } else {
      _xifexpression = "FALSE";
    }
    return _xifexpression;
  }

  private void line(final StringBuilder text, final String name, final String keyword, final Object value) {
    if ((value != null)) {
      text.append((((((name + " ") + keyword) + " { ") + value) + " }\n"));
    }
  }

  private void duration(final StringBuilder text, final EObject e, final String feature, final String keyword, final String name) {
    double _number = this.number(e, feature);
    String _plus = (Double.valueOf(_number) + " s");
    this.line(text, name, keyword, _plus);
  }

  private void reference(final StringBuilder text, final EObject e, final String feature, final String keyword) {
    this.line(text, this.nameMap.get(e), keyword, this.refName(this.value(e, feature)));
  }

  private void optional(final StringBuilder text, final EObject e, final String feature, final String keyword) {
    boolean _isSet = this.isSet(e, feature);
    if (_isSet) {
      this.line(text, this.nameMap.get(e), keyword, this.value(e, feature));
    }
  }

  private String refName(final Object ref) {
    String _xblockexpression = null;
    {
      final String name = this.nameMap.get(ref);
      if ((name == null)) {
        throw new IllegalArgumentException(("Reference has no exported declaration: " + ref));
      }
      _xblockexpression = name;
    }
    return _xblockexpression;
  }

  private String exportName(final EObject e) {
    String _xblockexpression = null;
    {
      final Object raw = this.value(e, "name");
      String _xifexpression = null;
      if ((raw == null)) {
        _xifexpression = e.eClass().getName();
      } else {
        _xifexpression = raw.toString().trim().replaceAll("[^A-Za-z0-9_]", "_");
      }
      String base = _xifexpression;
      boolean _isEmpty = base.isEmpty();
      if (_isEmpty) {
        base = e.eClass().getName();
      }
      boolean _matches = base.substring(0, 1).matches("[A-Za-z_]");
      boolean _not = (!_matches);
      if (_not) {
        base = ("E_" + base);
      }
      String candidate = base;
      int suffix = 2;
      while ((!this.usedNames.add(candidate))) {
        {
          candidate = ((base + "_") + Integer.valueOf(suffix));
          suffix = (suffix + 1);
        }
      }
      _xblockexpression = candidate;
    }
    return _xblockexpression;
  }

  private String quote(final String text) {
    String _xblockexpression = null;
    {
      if (((((text.contains("\'") || text.contains("\n")) || text.contains("\r")) || text.contains("{")) || text.contains("}"))) {
        throw new IllegalArgumentException(("Expression contains unsupported CFG delimiters: " + text));
      }
      _xblockexpression = (("\'" + text) + "\'");
    }
    return _xblockexpression;
  }

  private void validate(final EObject e) {
    String _name = e.eClass().getName();
    if (_name != null) {
      switch (_name) {
        case "EntityGenerator":
          this.refName(this.value(e, "prototype"));
          this.refName(this.value(e, "nextComponent"));
          if (((this.number(e, "interArrivalTime") <= 0) || (this.number(e, "entitiesPerArrival") <= 0))) {
            throw new IllegalArgumentException("Generator requires positive interArrivalTime and entitiesPerArrival");
          }
          break;
        case "Server":
          final Object queue = this.value(e, "waitQueue");
          this.refName(queue);
          if (((!(queue instanceof EObject)) || (!Objects.equals(((EObject) queue).eClass().getName(), "Queue")))) {
            throw new IllegalArgumentException("Server.waitQueue must reference a Queue");
          }
          this.refName(this.value(e, "nextComponent"));
          break;
        case "EntityConveyor":
          this.refName(this.value(e, "nextComponent"));
          break;
        case "Branch":
          Object _value = this.value(e, "nextComponentList");
          final List<?> targets = ((List<?>) _value);
          if (((targets == null) || targets.isEmpty())) {
            throw new IllegalArgumentException("Branch requires destinations");
          }
          final Consumer<Object> _function = (Object it) -> {
            this.refName(it);
          };
          targets.forEach(_function);
          final Object choice = this.value(e, "choice");
          if (((choice == null) || choice.toString().trim().isEmpty())) {
            throw new IllegalArgumentException("Branch requires Choice");
          }
          this.quote(choice.toString());
          break;
      }
    }
  }
}
