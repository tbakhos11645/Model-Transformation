# Third BPSim test — seed and replication changes

Version: **2026.11.06-154042-CET**  
Recorded: 6 November 2026, 15:40:42 Europe/Paris (CET, UTC+01:00).

This revision implements BPSim seed selection and generation of separate replication configurations. Main remains a transformation application: it creates runnable CFGs, not a simulation batch executor. The verification scripts execute all three replication files in this example.

## Fix 1: honor scenario seed

Previously seed was rejected by BpsimInput and Main always assigned 1. ScenarioSettings now carries the supplied seed to Main, which writes it to the existing JaamSim globalSubstreamSeed field and CFG keyword. No Ecore, ATL or Xtend changes are needed. An omitted seed retains the project's reproducible default of 1.

The [BPSim 2.0 specification, section 6.1.3](https://www.bpsim.org/specifications/2.0/WFMC-BPSWG-2016-01.pdf) defines seed for reproducibility and replication as the requested repetition count. The exact mapping to consecutive JaamSim substreams is this project's implementation policy, not a requirement of BPSim. Reproducibility is scoped to the same model, transformation and simulator versions.

## Fix 2: generate the requested replications

Previously replication was rejected and only one configuration was emitted. Main now writes one independent CFG/XMI pair per replication. For a base seed S, replication i uses S+i-1. This avoids giving every replication the same random substream.

The first pair retains the requested output prefix for compatibility. Later pairs append `-replication-002`, `-replication-003`, and so on. Each CFG describes one run; it does not use JaamSim NumberOfReplications. Opening the first CFG does not automatically execute the other files. Duration, warmup and process configuration are preserved in every pair.

## Fix 3: reject unsupported ranges without silent conversion

BPSim seed is a long, while the target substream is an integer. The adapter rejects negative seeds, values above 2147483647 and batches whose last substream would exceed that maximum. Seed zero is supported. The entire batch range is validated before output generation.

Replication defaults to 1. Counts below 1 or above 1000 are rejected; 1000 is an explicit exporter fan-out limit to bound file generation, not an XSD restriction. Regression tests verify rejection leaves the existing first CFG intact. No claim of atomic multi-file output is made for later filesystem failures.

## Fix 4: identify the current batch without deleting old outputs

Every Main export now writes `<prefix>.runs.txt`, including legacy and single-run exports. Its first line is a comment; each subsequent line contains a tab-separated replication index, seed and absolute CFG path. It is replaced after successful export.

If a later export reduces replication count, previously generated surplus CFGs are retained because they may have been edited. Only files in the latest run list belong to the current batch. The regression test checks this reduction behavior. Consumers should require successful transformation completion before using the run list; a failed export may leave earlier output artifacts.

## Fix 5: permanent example and broader verification

New files:

- `com.yourorg.main/sample_in/third-bpsim-test.xmi`: the simple Start → Work → End process.
- `com.yourorg.main/sample_in/third-bpsim-test.bpsim.xml`: scenario `replicated`, seed 41 and replication count 3, with six-second arrivals, three entities and two-second service.
- `com.yourorg.main/Third BPSim Test.launch`: Eclipse configuration for this example.

The regression suite checks matching CFG/XMI seeds, three run-list entries, identical exports on repeat, boundary/default values, invalid ranges and stale-output handling. The native harness loads each replica, verifies its actual substream number, and checks arrivals [6,12,18] and completions [8,14,20].

The separate RNG probe initializes JaamSim MRG1999a using each loaded substream: 32 draws from repeated initializations match exactly, while the adjacent substream differs. This is a native RNG check, not a stochastic BPSim process test. All supported process timings remain constant, so these three process timelines are intentionally identical. Distribution transformation remains future work.

The Eclipse verifier now launches the third example, compares all three CFGs against standalone counterparts, checks run-list cardinality and executes all three CFGs when native verification is enabled. README and BPSIM_CHANGES were updated to describe this workflow and its limits.

## Reproduce

Run from the repository root, adjusting the source location if needed:

```powershell
./scripts/verify.ps1 -JaamSimSourceDirectory C:/Users/antoine.bakhos/tmp-jaamsim-ref/jaamsim
./scripts/verify-eclipse.ps1 -JaamSimSourceDirectory C:/Users/antoine.bakhos/tmp-jaamsim-ref/jaamsim
```

Run the first command before the second to compile fresh application/native classes. Omitting JaamSimSourceDirectory skips native checks. Existing local Eclipse/JDK dependencies are still required.

Main arguments for manual generation:

```text
com.yourorg.main/sample_in/third-bpsim-test.xmi .build/third-bpsim-test "C:/path/to/Model Transformation" 60 com.yourorg.main/sample_in/third-bpsim-test.bpsim.xml replicated
```

## Outputs

| Replication | Seed | Standalone CFG |
| --- | --- | --- |
| 1 | 41 | `.build/third-bpsim-test.cfg` |
| 2 | 42 | `.build/third-bpsim-test-replication-002.cfg` |
| 3 | 43 | `.build/third-bpsim-test-replication-003.cfg` |

The standalone run list is `.build/third-bpsim-test.runs.txt`. Eclipse uses the same naming pattern with prefix `third-bpsim-eclipse`. Each CFG has a corresponding `.jaamsim.xmi`; all generated outputs are ignored by Git.

## Remaining scope

This does not implement BPSim distributions, routing, resources, result aggregation, a general simulation batch runner, pinned dependency builds or CI. The existing local source checkout is used for native tests; this revision does not claim a GUI check in installed JaamSim 2025-04. No commits or pushes are performed.

## Recorded verification result

316 regression assertions passed. The native suite completed 19 standalone CFGs and six Eclipse-output CFGs without configuration warnings/errors or runtime failures. Four actual Equinox launches generated six CFGs matching their standalone counterparts. Native seeds 41, 42 and 43 and the constant arrival/completion timelines passed for every replica, together with the repeatable/distinct-substream RNG probes. Existing first-test, congestion and warmup behavior remained valid.
