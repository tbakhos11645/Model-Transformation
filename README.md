# Model Transformation

Transforms the supported BPMN XMI subset to JaamSim XMI and a runnable JaamSim CFG using ATL EMFTVM and Xtend.

Builds use the exact dependencies in `build/toolchain.lock.json` and require 64-bit PowerShell 7 on Windows. Extract the matching portable toolchain into `.build/toolchain`, or prepare it once from the existing dependency installation:

```powershell
./scripts/prepare-toolchain.ps1 -JaamSimSourceDirectory C:/path/to/jaamsim
./scripts/verify.ps1 -Native
./scripts/verify-eclipse.ps1 -Native
./scripts/verify-reproducibility.ps1 -Native
```

The preparation script accepts `-PluginDirectory`; it copies only exact hash-matching files. Once prepared, builds do not use the installed Eclipse, `.p2` pool or system Java. Pass `-ToolchainDirectory C:/path/to/toolchain` to use a kit outside the checkout. Omit `-Native` to skip native JaamSim tests. The reproducibility check requires Git and compares outputs from two isolated source-only copies. See [BUILD_REPRODUCIBILITY.md](BUILD_REPRODUCIBILITY.md) for setup, verification evidence and limitations. These commands replace the older verification-script parameters shown in historical test reports.

Launch `com.yourorg.main.Main` or the Eclipse `RunnerApplication` with:

```text
"com.yourorg.main/sample_in/Ex1_BPMN.xmi" "com.yourorg.main/out/sample" "C:/path/to/Model Transformation" "3600"
```

The arguments specify input XMI, output prefix, repository root and simulation run duration in seconds. Compile `Rules.atl` using the EMFTVM compiler before running. The runtime rejects a missing or stale `Rules.emftvm`.

Supported execution covers none/timer starts, timed tasks and supported task subclasses, exclusive split/merge gateways and none ends. Unsupported execution features fail with diagnostics.

See [PATCH_LIST.md](PATCH_LIST.md) for the exact changes, custom timing/expression attributes, validation results, build instructions and remaining scope.

For BPSim, append a separate scenario XML file and scenario ID. For example:

```text
"com.yourorg.main/sample_in/second-bpsim-test.xmi" ".build/second-bpsim-test" "C:/path/to/Model Transformation" "60" "com.yourorg.main/sample_in/second-bpsim-test.bpsim.xml" "congested"
```

BPSim mode supports constant task processing, arrival intervals/counts, and scenario Duration/Warmup. A supplied scenario Duration takes precedence over the command-line duration; otherwise that argument is the total duration. Warmup is included in that total. The `congested` scenario runs for 30 seconds despite the 60-second fallback. Select `warmed` to exclude the first nine seconds from statistics while keeping the same 30-second total.

BPSim mode supports constant routing probabilities on all outgoing sequence flows of an exclusive split. Use a dimensionless ControlParameters/Probability for each flow; the weights must lie in [0, 1] and sum to 1. Probability routing cannot be combined with BPMN conditions, a default flow, or a legacy Choice expression on the same split. Export preserves the association with each destination even when the flow order changes. Other distributions and resource behavior remain unsupported.

The first BPSim arrival occurs one InterTriggerTimer interval after simulation time zero. The manufacturing fixture in tests/fixtures/ therefore generates its first arrival at 600 s and its last at 60000 s. See [second bpsim test.md](second%20bpsim%20test.md) for the existing FIFO/waiting-time results.

BPSim ScenarioParameters now accepts `seed` and `replication`. Main generates one CFG/XMI pair per replication: the first keeps the requested prefix, then `-replication-002`, `-replication-003`, etc. Each uses substream `seed + replicationIndex - 1`; omitted seed/count default to 1. The current batch is listed in `<prefix>.runs.txt` (tab-separated index, seed, absolute CFG path). Main generates files; it does not launch JaamSim. Execute each listed CFG once. Opening the first CFG alone does not run the remaining replications.

Supported seed/substream values are 0..2147483647 with no overflow across the batch; replication count is limited to 1..1000. Old surplus outputs are preserved when reducing count but removed from the current run list. See [third bpsim test.md](third%20bpsim%20test.md) for the per-fix breakdown and replication verification.

## Reviewed process text front end

The optional Python 3.10+ front end separates language extraction from model
construction. To try extraction with a model that supports JSON output, set
OPENROUTER_API_KEY in your local environment, then run:

    python frontend/process_input.py propose process.txt --model provider/model --out proposal

Review the proposed JSON against the original text and any clarifications.
Use the reviewed file (or the bundled manually reviewed example) to create
the two pipeline inputs:

    python frontend/process_input.py export frontend/manufacturing.reviewed.json --out reviewed-process

Run Main with reviewed-process/process.xmi, the chosen output prefix, the
repository root, the fallback duration, reviewed-process/scenario.bpsim.xml,
and scenario ID process. The export command refuses clarification and
unsupported responses; it never invents missing parameters. Provider access
is only used by the explicit propose command.
