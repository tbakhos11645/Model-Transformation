# Second BPSim test

Version: **2026.11.06-141654-CET**  
Recorded: 6 November 2026, 14:16:54 Europe/Paris (CET, UTC+01:00).

## Objective

Verify a queue that actually builds up, including individual entity order and waiting times. Implement the next scenario settings: constant Duration and Warmup. Run the examples through standalone Main and the registered Eclipse/Equinox application, then execute both sets of CFGs in native JaamSim.

## Permanent inputs

- `com.yourorg.main/sample_in/second-bpsim-test.xmi`: Start → Work → End BPMN process.
- `com.yourorg.main/sample_in/second-bpsim-test.bpsim.xml`: two explicit scenarios, `congested` and `warmed`; no inheritance is used.
- `com.yourorg.main/Second BPSim Test.launch`: Eclipse launch for `congested`. Change output prefix and scenario ID to run `warmed` interactively.

Both scenarios generate four entities at two-second intervals. Work takes five seconds per entity. The process uses a FIFO queue and zero-time conveyors. Total scenario Duration is 30 seconds. The warmed variant has nine seconds of Warmup.

## Measured behavior

The observer records actual entity identities at queue entry, server receipt and sink receipt through JaamSim event callbacks. It does not change routing or scheduling. FIFO is checked by comparing identities across all three stages, not inferred solely from counters.

| Entity in arrival order | Arrival (s) | Service starts (s) | Wait (s) | Completion (s) |
| --- | --- | --- | --- | --- |
| 1 | 2 | 2 | 0 | 7 |
| 2 | 4 | 7 | 3 | 12 |
| 3 | 6 | 12 | 6 | 17 |
| 4 | 8 | 17 | 9 | 22 |

Expected and observed values matched for both scenarios through both launch paths. The observed queue peaked at two waiting entities and was empty at the end. All four generated entities reached the sink without loss, duplication or reordering.

The congested scenario reports four measured sink arrivals. The warmed scenario still completes all four entities, but reports three measured sink arrivals: the completion at seven seconds falls inside warmup. The backlog and in-service entity survive the statistics reset. Both runs stop at 30 seconds, not 39 seconds.

## Implemented scenario settings

The [BPSim 2.0 specification, section 6.1.3](https://www.bpsim.org/specifications/2.0/WFMC-BPSWG-2016-01.pdf) defines warmup as part of the duration period with statistics excluded. JaamSim's Simulation implementation instead adds InitializationDuration to RunDuration. The adapter therefore maps:

```text
InitializationDuration = Warmup
RunDuration = total Duration - Warmup
```

For the warmed example the generated values are 9 seconds and 21 seconds respectively.

`BpsimInput.apply` now returns a typed ScenarioSettings record while continuing to normalize task/start parameters for ATL. Main applies those settings to the existing JaamSim Simulation object. No ATL, Xtend or Ecore changes were necessary for these settings.

Precedence and validation:

- A supplied BPSim Duration takes precedence over argument four. The example deliberately passes 60 seconds, but runs for its scenario Duration of 30 seconds.
- Without scenario Duration, argument four (or the existing default) supplies the total. Warmup is subtracted from that total.
- Omitted Warmup means zero. Numeric/floating constants use the scenario baseTimeUnit or a local override; the default base unit remains minutes. ISO DurationParameter values are supported.
- Total duration must be positive, and warmup must be nonnegative and strictly less than total. A warmup equal to total is a target limitation: JaamSim requires positive RunDuration.
- Console output identifies the selected total, warmup, measurement interval and duration source. Invalid settings are rejected before output is written; regression checks confirm an existing CFG is preserved.

## Verification

- 294 regression assertions passed after Xtend, Java and EMFTVM compilation.
- 16 standalone native cases passed, including both new scenarios and all prior cases, with zero configuration warnings/errors and no runtime failures.
- Three actual Eclipse/Equinox launches passed: first example, second example and warmed variant. Their CFGs matched the standalone files exactly.
- All three Eclipse-generated CFGs were also run through the native harness. The first timeline and both new identity/timing/statistics checks passed.
- Native execution used the local JaamSim source checkout identified earlier as 2026-05. This revision does not claim GUI verification of the new scenarios in installed JaamSim 2025-04.

Run from the repository root (adjust the JaamSim source location for another machine):

```powershell
./scripts/verify.ps1 -JaamSimSourceDirectory C:/Users/antoine.bakhos/tmp-jaamsim-ref/jaamsim
./scripts/verify-eclipse.ps1 -JaamSimSourceDirectory C:/Users/antoine.bakhos/tmp-jaamsim-ref/jaamsim
```

Run the first command before the second: the Eclipse verifier uses the freshly compiled application and native harness. Omitting JaamSimSourceDirectory skips native tests. Local Eclipse/JDK dependencies remain required; dependency pinning and clean-checkout CI are still future work.

## Generated CFGs

- `.build/second-bpsim-test.cfg`: standalone congested scenario.
- `.build/second-bpsim-warmup.cfg`: standalone warmed scenario.
- `.build/second-bpsim-eclipse.cfg`: Eclipse congested scenario.
- `.build/second-bpsim-warmup-eclipse.cfg`: Eclipse warmed scenario.

Each also has a corresponding `.jaamsim.xmi`. Generated outputs are ignored by Git. Open the desired CFG in JaamSim; for a visible queue demonstration, enable real-time execution and pause around six seconds.

## Remaining work

This revision implements constant Duration/Warmup and a stronger behavioral baseline. Scenario Start, seed, replications, distributions, BPSim XOR routing, shared resources, embedded BPMN XML import and CI are not implemented. The target still uses seed 1. Full BPSim conformance is not claimed. PATCH_LIST.md lists every authored file in this revision; earlier uncommitted first-test documentation was preserved. No commit or push was performed.
