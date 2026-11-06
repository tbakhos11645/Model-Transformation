# Model Transformation

Transforms the supported BPMN XMI subset to JaamSim XMI and a runnable JaamSim CFG using ATL EMFTVM and Xtend.

Run `./scripts/verify.ps1` from the repository root to compile the transformation and execute regression tests. This requires installed Eclipse ATL/EMFTVM and Xtend plugin jars and a compatible Java runtime. The script accepts `-PluginDirectory` and `-JavaExecutable` for another installation.

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

XOR support described above applies to legacy mode; BPSim routing, seeds, replications, distributions and resources remain unsupported. See [second bpsim test.md](second%20bpsim%20test.md) for measured FIFO/waiting-time results, native verification commands and generated outputs.
