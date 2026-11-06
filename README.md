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
