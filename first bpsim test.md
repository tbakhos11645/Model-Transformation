# First BPSim test

Version: **2026.11.06-111201-CET**
Recorded: 6 November 2026, 11:12:01 Europe/Paris (UTC+01:00).

## Objective and result

Verify a permanent Start → Task → End example through BPMN XMI + BPSim XML → ATL → JaamSim XMI → Xtend → JaamSim CFG → native simulation. Also verify the registered Eclipse application entry point.

All checks passed. The native simulator observed the following times:

| Entity | Expected arrival (s) | Observed arrival (s) | Expected completion (s) | Observed completion (s) |
| --- | --- | --- | --- | --- |
| 1 | 6 | 6 | 8 | 8 |
| 2 | 12 | 12 | 14 | 14 |
| 3 | 18 | 18 | 20 | 20 |

There were exactly three generated entities and three sink arrivals. The run ended at 60 simulated seconds, with no input warnings or errors and no runtime errors.

## Permanent inputs

- `com.yourorg.main/sample_in/first-bpsim-test.xmi`: process with stable IDs Start, Work, End, ToWork and ToEnd. No legacy timing attributes supply simulation values.
- `com.yourorg.main/sample_in/first-bpsim-test.bpsim.xml`: scenario `baseline`, referenced by BPMN element IDs.

InterTriggerTimer is 0.1 with no explicit unit. This intentionally tests BPSim's default minutes: 0.1 minutes = 6 seconds. TriggerCount is 3. Work.ProcessingTime is explicitly 2 seconds, testing a local unit override. One entity is generated per trigger; the task is faster than the arrival interval, so no waiting accumulates.

## Transformation and behavior checks

`scripts/verify.ps1` now transforms this permanent input pair on every run. The existing regression suite still passes all 267 assertions. With a local JaamSim source checkout supplied, the script also runs the permanent example and the 13 existing native smoke cases.

`tests/FirstBpsimObserver.java` observes actual generator and sink counter changes during native JaamSim event-trace callbacks. It records the simulation time at each change and asserts the complete arrival/completion lists, including their lengths. It does not change routing or substitute a mock simulator. `tests/JaamSimSmokeTest.java` enables this observer for the first-bpsim-test CFG.

The generated CFG uses FirstArrivalTime=6 s, InterArrivalTime=6 s, MaxNumber=3 and ServiceTime=2 s. Incoming conveyors feed Queue_Work; Work draws from that queue. Conveyors have zero travel time.

## Eclipse launch verification

Added `com.yourorg.main/First BPSim Test.launch`, selecting `com.yourorg.main.application` with the permanent example arguments. After building, this provides a reusable Eclipse Application launch configuration.

Added `scripts/verify-eclipse.ps1` to package local plugin bundles and launch the application through an isolated Equinox configuration/workspace under `.build/eclipse-test`. The test used the installed Eclipse Modeling runtime and its plugin registry, without modifying the installed Eclipse configuration or the active workspace.

Observed RunnerApplication.start(), successful output generation, RunnerApplication.end(), and exit code 0. The Eclipse-generated CFG was identical to the standalone CFG. This confirms application registration and argument forwarding in an actual Equinox run; it is not a claim that the interactive Eclipse Run dialog was operated.

## Reproduction

From the repository root:

```powershell
./scripts/verify.ps1 -JaamSimSourceDirectory 'C:/path/to/jaamsim'
./scripts/verify-eclipse.ps1
```

The first command requires Eclipse ATL/EMFTVM/Xtend/XSD dependencies and a JaamSim source checkout with its bundled graphics libraries. Without JaamSimSourceDirectory, transformation/regression tests still run but the native timeline check is skipped.

The Eclipse verifier accepts `-EclipseDirectory`, `-PluginDirectory` and `-JarExecutable` for other installations. Run the verification build first so `.build` contains fresh application/exporter classes and Rules.emftvm exists. The default paths match this machine's Eclipse Modeling installation.

For Main or the Eclipse Application launch, the six program arguments are:

```text
"com.yourorg.main/sample_in/first-bpsim-test.xmi" ".build/first-bpsim-test" "C:/path/to/Model Transformation" "60" "com.yourorg.main/sample_in/first-bpsim-test.bpsim.xml" "baseline"
```

## Generated outputs and limits

- `.build/first-bpsim-test.jaamsim.xmi` and `.build/first-bpsim-test.cfg`: standalone outputs.
- `.build/first-bpsim-eclipse.jaamsim.xmi` and `.build/first-bpsim-eclipse.cfg`: Eclipse outputs.
- All generated verification outputs are ignored by Git.

This baseline validates constant arrivals, trigger counts, processing time, unit conversion, queue wiring and both launch paths. It does not add scenario Duration/Warmup/seed handling, XPath/probability routing, distributions, calendars, resources or parallel synchronization. Those remain the next implementation milestones. No commit or push was performed.

## Follow-up: connected display geometry — 2026.11.06-131926-CET

Recorded 6 November 2026 at 13:19:26 Europe/Paris. The original behavioral tests passed, but they did not check the displayed conveyor geometry. The exporter placed objects in file order and did not supply conveyor Points, so visual paths could look detached even when NextComponent references were correct.

The exporter now places components along the execution graph (including Queue to Server via WaitQueue), draws each conveyor from its predecessor to its destination through a layout waypoint, enables Simulation ShowEntityFlow, and adjusts the view to the model bounds. Explicit intermediate-model positions remain supported. The SimEntity prototype is a template and intentionally sits above the process chain.

For this example the route remains Start → Conveyor_ToWork → Queue_Work → Work → Conveyor_ToEnd → End. A Server takes entities from its WaitQueue; the queue therefore does not need a NextComponent setting. Both conveyors have zero travel time, so entities traverse them instantly; service still takes two seconds.

Validation: 285 regression assertions, all 14 native simulations, native conveyor endpoint checks, unchanged arrival/completion times, and an actual Equinox launch with identical CFG output all passed. This verifies native geometry data and behavior, not a visual screenshot review of the JaamSim GUI. Basic placement is not a crossing-free layout for arbitrary branching/cyclic models and does not import BPMN diagram coordinates.

Reopen .build/first-bpsim-test.cfg or .build/first-bpsim-eclipse.cfg in JaamSim to load the regenerated geometry. Previously opened models do not automatically reload files. Pre-regeneration CFGs, including manual layout edits, are preserved in .build/cfg-backup-20261106-131647. The original first-test routing was correct; other reported incorrect connections still require the specific failing CFG and intended edge to diagnose.
