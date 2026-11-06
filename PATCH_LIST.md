# Transformation fixes — GitHub patch list

**Patch version:** `2026.11.06-141654-CET`
**Recorded:** 2026-11-06 at 14:16:54, Europe/Paris (CET, UTC+01:00)
**Status:** Local working-tree patch; not committed or published.

## Change history

| Version | Recorded (Europe/Paris) | Changes |
| --- | --- | --- |
| `2026.11.06-141654-CET` | 2026-11-06 14:16:54 CET | Second BPSim congestion/FIFO test, constant scenario Duration/Warmup execution, native verification through standalone and Eclipse launch paths. |
| `2026.11.06-134211-CET` | 2026-11-06 13:42:11 CET | Verify corrected queue/server/sink display and full run in installed JaamSim 2025-04; documentation only. |
| `2026.11.06-131926-CET` | 2026-11-06 13:19:26 CET | Flow-based layout, conveyor paths, visible flow arrows, fitted view and native endpoint regression checks. |
| `2026.11.06-111201-CET` | 2026-11-06 11:12:01 CET | Permanent first BPSim example, native timeline assertions, actual Equinox application launch and separate test breakdown. |
| `2026.11.06-095128-CET` | 2026-11-06 09:51:28 CET | Fix Eclipse application extension ID placement in main plugin.xml. |
| `2026.11.06-092452-CET` | 2026-11-06 09:24:52 CET | Schema-derived BPSim model and initial constant timing/count scenario adapter; see revision breakdown below. |
| `2026.11.06-091146-CET` | 2026-11-06 09:11:46 CET | Initial versioned patch: task/queue routing, timing, XOR and timer normalization, dynamic EMF export, launcher fixes, validation and regression/native simulation checks. |

For each future update, assign a new version using `YYYY.MM.DD-HHmmss-ZONE` from the current Europe/Paris time (`CET` or `CEST`). Update the version and recorded time above, then prepend a history row describing that update. Preserve earlier rows so changes remain traceable. These timestamps identify patch revisions; Git commit hashes and tags can additionally identify committed releases.

This patch makes the supported BPMN execution subset transform through **BPMN XMI → dynamic JaamSim XMI → JaamSim CFG**. It also rejects unsupported execution semantics before producing output. It does not implement every potential equivalence in the Excel catalog.

## Files to include

| File | Patch |
| --- | --- |
| `com.yourorg.atl/Rules/Rules.atl` | Consistent task subtype checks; task entry is the queue; separate containment of servers; explicit FIFO; source arrival inputs; zero/default transport time; first arrival; safe missing-feature lookup; stable fallback names; preserved outgoing-flow order. |
| `com.your.m2t/src/com/your/m2t/M2T.xtend` | Reflective export for dynamic/generated EMF objects; inherited-feature lookup; unique/reserved-safe names; reset state per export; explicit zero times; declared-reference checks; unsupported-class rejection; simulation settings; geometry; URIConverter output. |
| `com.yourorg.main/src/com/yourorg/main/BpmnPreflight.java` | New validation and normalization before ATL: graph consistency, timing, supported constructs, XOR merge/split policy, conditions/default flow, constant start timers, reachability and structural paths to an end. |
| `com.yourorg.main/src/com/yourorg/main/Main.java` | One portable pipeline using checkout-relative file paths and dynamic packages; correct `Jaamsim` registration; EMFTVM resource factory; input validation; missing/stale module detection; configured run duration. |
| `com.yourorg.main/src/com/yourorg/main/AtlRunner.java` | Delegate to the same pipeline instead of a separate hardcoded configuration and incorrect `Rules 2` module name. |
| `com.yourorg.main/src/com/yourorg/main/RunXtend.java` | Command-line XMI/CFG paths; reload the checkout's dynamic Ecore package instead of stale generated JaamSim Java. |
| `com.yourorg.main/src/com/yourorg/main/RunnerApplication.java` | Forward Eclipse application arguments to Main. |
| `com.yourorg.models/model/BPMN20.ecore` | Three optional simulation extension attributes, described below. Existing `FormalExpression.body` is unchanged. |
| `scripts/verify.ps1` | Compile Xtend, Java and EMFTVM; execute regression tests; optionally compile a local JaamSim checkout and run native simulation checks. |
| `tests/TransformationSmokeTest.java` | Integration assertions for examples, queues, containment, task subtypes, arrival inputs, zero durations, dynamic reload, repeated export, names, XOR, timers and rejection paths. |
| `tests/JaamSimSmokeTest.java` | Optional native JaamSim input validation and timed execution; checks warnings/errors and runtime failures. |
| `.gitignore` | Ignore `.build/` verification output and generated `.emftvm` modules. |
| `README.md` | Build/run instructions and link to this patch list. |
| `PATCH_LIST.md` | This change list, contracts, validation and limitations. |

Eclipse also regenerated the already tracked `com.your.m2t/xtend-gen/com/your/m2t/M2T.java` and `com.yourorg.atl/Rules/Rules.asm`. Include those if preserving this repository's existing generated-source convention. The runtime uses **Rules.emftvm**, not Rules.asm. Rebuild generated code from source after checkout; do not rely on committed `.class`, trace or `.xtendbin` files.

## Behavioral changes

1. **Task connections:** conveyors arriving at a Task or supported Task subtype now target its Queue. Server.WaitQueue references that Queue; the Server forwards completed entities to the next conveyor. Both queue and server are contained in SimulationModel.components. Only the prototype is placed in entities.
2. **Task subclasses:** Task, UserTask, ServiceTask, ManualTask, an empty ScriptTask and BusinessRuleTask use the same timed-service abstraction. External work, human interactions and rule execution are not performed. ScriptTask with script text and SendTask/ReceiveTask are rejected.
3. **Timing:** Task.Time becomes service time in seconds, including zero. StartEvent.InterArrivalTime and EntitiesPerArrival are used when positive; zero/unset uses documented defaults of 1 second and 1 entity. Negative/nonfinite values are rejected. No pseudo-random delays remain. SequenceFlow.TravelTime defaults to zero.
4. **Generator limits:** the existing repository convention is preserved: StartEvent.MaxNumber=0 means unlimited, so MaxNumber is omitted in CFG. Positive values are exported. FirstArrivalTime defaults to zero for none starts.
5. **XOR ordering:** Choice indices refer to persisted gateway.outgoing order. Explicit nonblank Choice takes precedence over conditions/default routing. This is an intentional simulation override. Integer constants are range-checked; JaamSim checks general expressions at load/run time.
6. **XOR merge:** a gateway with one outgoing flow uses Choice=1, including a converging merge. Multiple incoming tokens are passed independently; this is not a synchronizing join.
7. **Conditional XOR:** without custom Choice, a split needs a default flow. Every other outgoing flow must provide a JaamSim-language condition. Preflight builds nested ternary expressions, preserving the same outgoing order used by NextComponentList. It never treats a flow name or an EObject.toString() result as executable code.
8. **Input rejection:** unsupported flow elements, nested processes, resource allocation, loop/multi-instance characteristics, compensation, script execution, unsupported event definitions, bad/mismatched flow references, duplicate IDs, unreachable nodes, negative/nonfinite timing and missing end paths produce diagnostic errors before ATL runs.
9. **Export validation:** unknown target classes and references without declarations fail before the destination stream is opened. The output is assembled in memory first. Existing CFG files survive semantic validation failures. This does not guarantee atomic replacement if an I/O failure occurs while writing.
10. **Runtime model:** both ATL output and exporter use the same dynamically loaded Ecore packages. Regenerating the old JaamSim Java classes is therefore not a prerequisite for this path. Generated Java interfaces remain stale for other consumers and should be regenerated separately if those consumers use new JaamSim classes.
11. **Run control:** Main creates Simulation settings with run duration from its fourth argument (default 3600 seconds), initialization duration 0, ExitAtStop=false and seed 1. Xtend exports those settings, first arrival, timing and optional position/size/orientation.

## Added BPMN simulation extensions

| EClass | Attribute | Type/default | Meaning |
| --- | --- | --- |
| `2026.11.06-111201-CET` | 2026-11-06 11:12:01 CET | Permanent first BPSim example, native timeline assertions, actual Equinox application launch and separate test breakdown. |
| `2026.11.06-095128-CET` | 2026-11-06 09:51:28 CET | Fix Eclipse application extension ID placement in main plugin.xml. |
| `2026.11.06-092452-CET` | 2026-11-06 09:24:52 CET | Schema-derived BPSim model and initial constant timing/count scenario adapter; see revision breakdown below. | --- |
| SequenceFlow | TravelTime | EDouble / 0 | Optional transport delay in seconds. |
| StartEvent | FirstArrivalTime | EDouble / 0 | Initial arrival offset in seconds. |
| FormalExpression | JaamSimExpression | EString / unset | Explicit expression text, avoiding the EObject-valued body. |

These are custom attributes of this repository's BPMN Ecore, like its existing Time, Choice and MaxNumber attributes. They are not standard BPMN serialization features. The metamodel's standard FormalExpression.body reference and its multiplicity have not been changed; these extensions do not make the example models fully BPMN-schema conformant.

A conditional outgoing flow can contain:

```xml
<conditionExpression xsi:type="bpmn:FormalExpression"
    language="JaamSim"
    JaamSimExpression="this.NumberProcessed &lt;= 5"/>
```

Mark another outgoing SequenceFlow as the gateway's default. Alternatively retain the existing gateway `Choice="this.NumberProcessed &lt;= 5 ? 1 : 2"` convention. Enter expression text without surrounding CFG quotes. General XPath, JavaScript, OCL, FEEL and arbitrary expression-body objects are rejected rather than translated automatically. Expressions must refer to actual exported JaamSim names; object-name references embedded in expressions are not automatically renamed.

Timer starts support one local TimerEventDefinition with either timeCycle or timeDuration. Put constant text in the expression's JaamSimExpression attribute:

- `timeCycle`: a positive number of seconds, `5 s`, `PT5S` or `R/PT5S`. Arrivals begin after that interval unless FirstArrivalTime is explicitly configured. Custom MaxNumber still limits the generator.
- `timeDuration`: nonnegative seconds or an ISO duration. This sets the first-arrival delay. If MaxNumber is zero/unset, it is normalized to 1 for a single delayed start; an explicit positive MaxNumber overrides that behavior.
- An explicit timing attribute and a timer expression controlling the same timing are rejected as conflicting.
- Absolute dates, finite repetition syntax such as R5/PT5S, calendar durations, stochastic timers and general expression-valued timers are unsupported.

## Build and run

Run PowerShell from the repository root:

```powershell
./scripts/verify.ps1
```

The script reads installed Eclipse plugin jars from `$env:USERPROFILE/.p2/pool/plugins` and uses an embedded JustJ Java runtime when present. Supply `-PluginDirectory` and `-JavaExecutable` for another installation. Current Xtend 2.44 requires Java 21+; the installed Eclipse Java 25 runtime was used for verification. `-JavaHome` supplies a fallback Java executable if no embedded runtime is found. Use a compatible Eclipse Modeling installation with ATL EMFTVM compiler, Xtend and their dependencies.

Verification regenerates Rules.emftvm in `com.yourorg.atl/Rules` and writes fixtures/results only under `.build`. The script compiles Java at language level 17 using the Eclipse compiler. Current dependencies can require a newer runtime despite that source level.

For native JaamSim checks, point to an existing source checkout with `src/main/java`, resources and JOGL libraries; no download is performed:

```powershell
./scripts/verify.ps1 -JaamSimSourceDirectory 'C:/path/to/jaamsim'
```

In Eclipse, clean/build the Xtend and Java projects, then compile Rules.atl with the **EMFTVM** compiler. Supply these arguments to Main or RunnerApplication:

```text
"com.yourorg.main/sample_in/Ex1_BPMN.xmi" "com.yourorg.main/out/sample" "C:/path/to/Model Transformation" "3600"
```

Main arguments are input XMI, output prefix, repository root and run seconds. File arguments can also be absolute. With no arguments, run from the repository root; Ex1_BPMN.xmi is the default input. The prefix produces `<prefix>.jaamsim.xmi` and `<prefix>.cfg`. Main rejects a missing or older-than-source Rules.emftvm file.

For export only, RunXtend arguments are input JaamSim XMI, output CFG and optional repository root. This path loads the updated dynamic metamodel and validates the export too.

If your existing launch configuration runs the original ATL VM or uses generated JaamSim packages, update it to this pipeline. Calling Rules.atl directly bypasses the required BpmnPreflight normalization/validation; use Main.

## Validation

- Xtend source compilation, Java compilation and ATL-to-EMFTVM compilation pass.
- The regression suite passes 263 assertions, including both original examples and generated fixtures.
- Native JaamSim checks load, validate and simulate the generated fixtures to 60 seconds, checking zero input warnings, zero input errors and no runtime error. Native verification uses the locally available JaamSim 2026-05 source checkout.
- CFG/XMI reload is checked to reproduce the same export; repeated calls on one exporter also reproduce it.
- `git diff --check` is part of the final patch review.
- These are execution smoke tests and structural regression tests, not proof of behavioral equivalence for every BPMN process.

## Remaining scope

Parallel/inclusive/event-based/complex gateways, synchronizing joins, subprocess/call activity execution, resource seize/release, boundary/intermediate events, messages/signals, compensation, data assignments, BPSim input, distributions and continuous/fluid/calculation mappings are not implemented. Unsupported target classes are rejected by the exporter; unsupported source execution features are rejected by preflight. Adding any of these requires its semantics, ATL construction, containment/references, exporter handler and tests together.

The workbook remains a catalog of possible mappings, not an executable transformation specification. Its JaamSim mappings are unchanged by these BPMN-side extension attributes. No spreadsheet or existing sample input was modified.

## Suggested commit message

```text
Fix BPMN-to-JaamSim routing, dynamic export and execution validation

Route task inputs through contained FIFO queues, preserve task subclasses,
use explicit timing inputs and normalize XOR/default and constant timer logic.
Unify launchers around dynamic Ecore packages and EMFTVM, and make CFG export
validate names/references before writing. Add repeatable integration and
optional native JaamSim smoke checks with documented supported semantics.
```

The working tree changes are ready for review; no commit or push is performed. Include the files above when updating GitHub. Exclude verification outputs, binary build caches and unrelated files you are adding separately.

## Revision 2026.11.06-092452-CET — BPSim integration

Recorded 2026-11-06 09:24:52 Europe/Paris (UTC+01:00). This revision adds an initial executable BPSim subset; full execution of the catalogue remains pending. See BPSIM_CHANGES.md for the separate main-change breakdown and usage example.

| File | Change in this revision |
| --- | --- |
| com.yourorg.models/model/BPSim.ecore | New complete schema-derived metamodel, generated with XML metadata from the existing BPSim-2.0.xsd. |
| tests/GenerateBpsim.java | Reproducible XSD-to-Ecore generator. |
| com.yourorg.main/src/com/yourorg/main/BpsimInput.java | New secure, XSD-validating scenario adapter; constant timing/count conversion; element reference resolution; explicit unsupported-feature diagnostics. |
| com.yourorg.main/src/com/yourorg/main/Main.java | Optional fifth/sixth arguments select a separate BPSim XML file and scenario ID before preflight/ATL. |
| scripts/verify.ps1 | Include XSD libraries, compile and run the metamodel generator before regression tests. |
| tests/TransformationSmokeTest.java | Add BPSim integration and regression assertions for time units, counts and zero rejection. |
| BPSIM_CHANGES.md | Separate main-change breakdown, example, instructions and precise execution limitations. |
| PATCH_LIST.md | New timestamped revision and history entry; previous revision retained. |

BPMN20.ecore custom attributes remain as an in-memory compatibility bridge. No schema or catalogue changes were made. Eclipse may automatically regenerate tracked class files when source files change; those binary build products are not authored patch content. Existing unrelated working-tree changes are outside this revision.


## Revision 2026.11.06-095128-CET — Eclipse application registration

Changed com.yourorg.main/plugin.xml: added id=application to the extension element and removed the unsupported id from its application child. With bundle symbolic name com.yourorg.main, the launch ID is com.yourorg.main.application. Verified XML parsing and declaration structure against Eclipse's applications extension-point documentation. No runtime transformation changes. If Eclipse retains the old marker, refresh the project and run Project > Clean; select com.yourorg.main.application in the Eclipse Application launch configuration.



## Revision 2026.11.06-111201-CET — First BPSim behavioral baseline

| File | Change |
| --- | --- |
| com.yourorg.main/sample_in/first-bpsim-test.xmi | Permanent Start → Task → End input with stable BPMN IDs and no legacy timing inputs. |
| com.yourorg.main/sample_in/first-bpsim-test.bpsim.xml | Permanent baseline scenario: 0.1-minute arrivals, three triggers and two-second service. |
| com.yourorg.main/First BPSim Test.launch | Reusable Eclipse Application launch using the corrected extension ID and six arguments. |
| tests/FirstBpsimObserver.java | Observe actual native generator/sink counter transitions and assert arrivals [6,12,18] and completions [8,14,20]. |
| tests/JaamSimSmokeTest.java | Attach the timeline observer for the permanent first BPSim case and verify its observations. |
| scripts/verify.ps1 | Transform the permanent example; compile its observer; include its CFG in native tests. |
| scripts/verify-eclipse.ps1 | Package and launch the application in isolated Equinox; check successful output and equality with standalone CFG. |
| first bpsim test.md | Requested separate breakdown of work, measured results, reproduction steps and scope. |
| PATCH_LIST.md | Update version/history and record every authored change in this revision. |

Validation: 267 regression assertions passed. All 14 native JaamSim cases completed to 60 seconds with zero warnings/errors. The new case additionally passed exact arrival/completion timeline assertions. An actual isolated Eclipse/Equinox launch ran RunnerApplication and generated a CFG identical to the standalone output. Verification artifacts are under .build and are excluded from the patch. No application semantics changed in this revision.

## Revision 2026.11.06-131926-CET — Connected CFG geometry

The exporter previously placed entities in containment order and emitted conveyor Position without Points. Logical NextComponent/WaitQueue links could execute correctly while the display looked disconnected. This revision changes display generation; ATL routing and BPSim timing semantics are unchanged.

| File | Change |
| --- | --- |
| com.your.m2t/src/com/your/m2t/M2T.xtend | Place entities by breadth-first execution order, include queue-to-server pull links, bound traversal of cycles, retain explicit positions, separate objects at the same depth, emit conveyor Points from actual predecessor through conveyor position to destination, enable ShowEntityFlow and fit View1 to layout bounds. |
| tests/TransformationSmokeTest.java | Add 18 assertions across six task types for execution-order placement, conveyor endpoints and visible flow arrows. |
| tests/FirstBpsimObserver.java | Inspect the native model's loaded conveyor endpoints against actual source/destination positions before simulation. |
| first bpsim test.md | Add diagnosis, changes, validation and CFG backup location. |
| PATCH_LIST.md | Update timestamp/history and record this revision. |

Validation: 285 regression assertions and all 14 native JaamSim cases passed. Native first-test conveyor endpoints matched, and arrivals [6,12,18]/completions [8,14,20] remained unchanged. Isolated Equinox launch passed and produced the same CFG as standalone. Both first-test CFGs were regenerated. Existing CFGs, including manual edits, were copied to .build/cfg-backup-20261106-131647 before regeneration.

Eclipse also regenerated tracked M2T.java, trace, xtendbin and class artifacts under com.your.m2t/xtend-gen and bin; these are generated derivatives, not additional authored fixes. Review according to the repository's generated-artifact policy. No commit or push performed.

Limits: this is a basic graph layout, not BPMN DI reproduction or crossing-free routing. Queue/server arrows use JaamSim's flow display; the prototype is intentionally separate from the process chain. No incorrect semantic edge was reproduced in the first BPSim test; a specific failing CFG and expected connection are needed to investigate other reported wiring cases.

## Revision 2026.11.06-134211-CET — Installed JaamSim visual verification

Documentation-only update to PATCH_LIST.md and first bpsim test.md. Opened the corrected .build/first-bpsim-eclipse.cfg in the user's installed JaamSim 2025-04, observed the connected queue/server/sink display and ran to 100% at 60 seconds without an error dialog. The standalone and Eclipse CFG SHA-256 hashes match (6EFD5B80BF3FDF8642B91AB256DB6B96CBD838F27AF0FF3F3EFECFEB9575ADB6). No further exporter, ATL, BPSim or CFG edits were needed. This GUI check supplements the earlier native endpoint/timeline assertions; it does not independently measure individual entity completion times in version 2025-04.

## Revision 2026.11.06-141654-CET — Second BPSim test and scenario timing

| File | Change |
| --- | --- |
| com.yourorg.main/sample_in/second-bpsim-test.xmi | Permanent Start → Work → End input for congestion tests. |
| com.yourorg.main/sample_in/second-bpsim-test.bpsim.xml | Congested and warmed scenarios: four arrivals every two seconds, five-second service, 30-second total, optional nine-second warmup. |
| com.yourorg.main/Second BPSim Test.launch | Reusable Eclipse launch selecting the congested scenario. |
| com.yourorg.main/src/com/yourorg/main/BpsimInput.java | Return ScenarioSettings; parse constant Duration/Warmup using existing unit conversion; enforce positive total and warmup smaller than total; map measurement interval as total minus warmup. |
| com.yourorg.main/src/com/yourorg/main/Main.java | Apply scenario settings to Simulation; scenario Duration overrides CLI fallback total; log selected timing/precedence; update usage documentation. |
| tests/SecondBpsimObserver.java | Observe actual entity identities, queue arrivals, service starts, completions, waiting times, peak/final queue length, lifetime counts and warmup-filtered sink statistics. |
| tests/JaamSimSmokeTest.java | Attach first/second observers for standalone and Eclipse filenames; assert 30-second totals for second scenarios. |
| tests/TransformationSmokeTest.java | Nine added assertions for scenario settings, CLI precedence/fallback, default units, zero warmup, invalid durations/warmups and preservation of prior output on rejection. |
| scripts/verify.ps1 | Generate both second-test variants, compile the new observer and run 16 native cases when requested. |
| scripts/verify-eclipse.ps1 | Launch all three permanent cases, compare CFGs with standalone outputs, optionally execute their native behavioral checks using -JaamSimSourceDirectory. |
| README.md | Explain BPSim invocation, scenario precedence and current execution support; link second-test report. |
| BPSIM_CHANGES.md | Update implemented settings, remaining limitations and current verification evidence. |
| second bpsim test.md | New requested breakdown: observed timeline, scenario mapping, file locations, reproducible commands and limitations. |
| PATCH_LIST.md | Update revision/time/history and record all authored changes. |

Validation: 294 regression assertions passed. All 16 standalone native cases and three Eclipse-output native cases passed. Actual Equinox launches produced identical standalone/Eclipse CFGs for all three permanent cases. Second-test FIFO identities matched; arrivals [2,4,6,8], service starts [2,7,12,17], waits [0,3,6,9], completions [7,12,17,22], peak queue 2 and final queue 0. Both scenarios stopped at 30 seconds. Measured sink count was 4 without warmup and 3 with nine-second warmup; lifetime completions remained 4.

No ATL, Xtend or Ecore changes were required. Native verification used the existing local JaamSim source checkout; no new installed-2025 GUI claim is made. Scenario seed/replications, Start, routing and distributions remain unsupported. Earlier uncommitted first-test documentation was preserved. Eclipse regenerated the tracked com.yourorg.main/bin/com/yourorg/main/Main.class; it is a build derivative, not a separate authored fix. Generated .build outputs are not patch content. No commit or push performed.
