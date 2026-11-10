# Fourth BPSim test — ATL normalization and topology

Patch revision: `2026.11.10-150323-CET` (2026-11-10 15:03:23 Europe/Paris).

## Fix 1: explicit ATL input contract

`Rules.atl` documents that Main runs BpsimInput and BpmnPreflight before transformation. ATL maps normalized process structure and timing; Main applies scenario duration, warmup, seeds and replications; Xtend exports names and layout. Task inputs still reach the task's Queue, with Server.WaitQueue referencing that Queue.

The StartEvent rule now copies InterArrivalTime and EntitiesPerArrival directly. Their fallback logic moved to preflight, so validation and defaults have one owner. Legacy zero/unset values still mean one second and one entity because the existing non-unsettable Ecore fields do not reliably distinguish explicit zero from omission. Negative/nonfinite values remain errors. BPSim instantaneous arrivals remain rejected before legacy defaults can apply. Staged timer values are preserved, and failed preflight does not apply staged defaults.

Tests cover omitted and explicit-zero legacy values, repeated normalization of none starts, invalid-input mutation protection, and existing timer/positive-arrival behavior.

## Fix 2: execute unconditional BPSim XOR merges

BpsimInput now permits an ExclusiveGateway with exactly one outgoing flow and no outgoing condition. It normalizes Choice to `1`, replacing any stale legacy expression. Multiple incoming entities proceed independently; the merge does not wait for another input. Splits and conditional single-output gateways are rejected. Preflight also rejects conditional single-output gateways in legacy mode rather than silently discarding the condition.

The permanent `fourth-bpsim-test.xmi` has StartA and StartB feeding Merge, then Work and End. The companion BPSim scenario `merge` sets StartA to two arrivals at 10-second intervals, StartB to two at 15-second intervals, and Work to two seconds per entity. Both sequence-flow travel times and warmup are zero.

| Event | Expected seconds |
| --- | --- |
| StartA arrivals | 10, 20 |
| StartB arrivals | 15, 30 |
| End completions | 12, 17, 22, 32 |

The native observer checks all four End completion times. Completion at 12 seconds, before StartB's first arrival at 15, distinguishes an independent merge from a synchronizing join. Adapter tests also cover stale Choice replacement, two actual incoming references, rejection of conditions/splits without partial arrival updates, and zero BPSim intervals.

## Fix 3: cover task chains and independent processes

The consecutive-task fixture routes Start → Work1 → Work2 → End, with service times two and three seconds. It checks the conveyor-to-Queue_Work2 reference, Work2.WaitQueue, and native completions at 15, 25 and 35 seconds.

The multiple-process fixture contains two processes under one Definitions root. It checks one target SimulationModel, two generators, two servers, separate destinations, and native EndA completions at 1, 2, 3 seconds and EndB completions at 2, 4, 6 seconds. Reference checks require unique declarations and declared targets in each generated CFG.

## Rebuild and outputs

With the locked toolchain prepared, run from the repository root:

```powershell
./scripts/verify.ps1 -Native
./scripts/verify-eclipse.ps1 -Native
```

The first command generates `.build/fourth-bpsim-test.cfg` and its `.jaamsim.xmi`, plus `.build/topology-consecutive.cfg` and `.build/topology-processes.cfg`. The second generates `.build/fourth-bpsim-eclipse.cfg`, compares it with the standalone CFG and runs it in native JaamSim. `com.yourorg.main/Fourth BPSim Test.launch` runs the permanent example in Eclipse and writes `.build/fourth-bpsim-test.cfg`.

Generated files under `.build` are local outputs, not patch source files. Eclipse may regenerate the tracked Rules.asm; production execution uses the source-compiled Rules.emftvm.

## Verification

Both commands passed on 2026-11-10 using the locked toolchain:

- Standalone: 420 transformation assertions and 22 native JaamSim runs, with zero configuration warnings or errors.
- Eclipse: five application launches, all seven CFGs (including replications) equal to standalone output, and seven successful native runs.
- Native topology observer confirmed all timelines above, including the fourth example through both launch paths.
- `git diff --check` passed.

Local logs: `.build/atl-update.log` and `.build/atl-eclipse-update.log`.

## Remaining work

Source-to-target trace records, BPSim distributions and probabilistic/conditional splits remain separate follow-up work. This revision does not rerun the two-copy byte-for-byte reproducibility comparison; it uses the existing locked build and standalone/Equinox checks.
