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

BPSim mode also supports unconditional XOR merges/pass-throughs with exactly one outgoing flow. Each incoming entity proceeds independently. BPSim splits, conditional/probabilistic routing, distributions and resources remain unsupported. See [fourth bpsim test.md](fourth%20bpsim%20test.md) for the ATL contract and topology checks, and [second bpsim test.md](second%20bpsim%20test.md) for measured FIFO/waiting-time results.

BPSim ScenarioParameters now accepts `seed` and `replication`. Main generates one CFG/XMI pair per replication: the first keeps the requested prefix, then `-replication-002`, `-replication-003`, etc. Each uses substream `seed + replicationIndex - 1`; omitted seed/count default to 1. The current batch is listed in `<prefix>.runs.txt` (tab-separated index, seed, absolute CFG path). Main generates files; it does not launch JaamSim. Execute each listed CFG once. Opening the first CFG alone does not run the remaining replications.

Supported seed/substream values are 0..2147483647 with no overflow across the batch; replication count is limited to 1..1000. Old surplus outputs are preserved when reducing count but removed from the current run list. See [third bpsim test.md](third%20bpsim%20test.md) for the per-fix breakdown and replication verification.
