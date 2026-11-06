# Build reproducibility

Version: **2026.11.06-161447-CET**  
Recorded: 6 November 2026, 16:14:47 Europe/Paris (CET, UTC+01:00).

This revision provides a pinned, portable **Windows x64 offline build**. It removes the regular build's dependence on whichever Eclipse plugins happen to be installed and on existing compiled project classes. The source repository plus the matching toolchain kit are required; this is not an internet bootstrap from an empty machine.

## What changed and why

### 1. Exact dependency lock

Previously `verify.ps1` scanned the local `.p2` pool and selected the newest jar for each name. A plugin update could silently change the compiler or dependencies. `build/toolchain.lock.json` now records exact paths and SHA-256 hashes for 2,131 dependency files, an ordered 390-jar compiler classpath, and 46 runtime bundle IDs. These include:

- The existing Eclipse Adoptium/JustJ Java 25.0.5 runtime, including its compiler and jar-tool modules.
- Eclipse JDT, ATL/EMFTVM, Xtend/Xtext and EMF dependencies used by the verified build.
- Explicit Equinox, declarative-services, service-loader and JNA runtime dependencies.
- The native JaamSim test source/resource snapshot, its two required jars and LICENSE. The source checkout reports commit `f17b71837c2ef80e2cd83d2371803c89b7a23d06`; individual file hashes are authoritative for the snapshot.

Every verification entry point checks the locked files before executing Java. Missing or modified files fail with a named dependency diagnostic. Dependency upgrades require an intentional lock update and rerunning verification; ordinary builds never refresh the lock automatically.

### 2. Portable offline toolchain

`scripts/prepare-toolchain.ps1` copies hash-matching files from an existing plugin pool and JaamSim checkout into a portable directory. It does not install software globally, modify Eclipse, or download a replacement version when an expected dependency is absent. The Java runtime inside the kit supplies the jar tool as well, removing the old separate `C:/Program Files/Java/jdk-17` requirement.

After preparation, the normal build can run with the original Eclipse and JaamSim source locations unavailable. Another machine needs the same kit, not matching user-profile paths. Preserve the kit's included license files when copying it.

### 3. Source compilation and stale-build checks

`verify.ps1` clears its compiled output directories inside `.build` and compiles the model Java sources, Xtend-generated Java, application sources and tests. Model sources use Java 21 compliance to match their bundle; application/test sources use Java 17 compliance. Both are compiled by the locked JDT compiler running on the locked Java runtime. Native JaamSim sources use the existing Java 8 compliance setting.

ATL is compiled by the regression harness; BPSim.ecore is regenerated from the supplied XSD. The Eclipse verifier now packages fresh model classes from `.build/model-classes`, not `com.yourorg.models/bin`. Checked-in generated model Java remains a source input; this does not regenerate those Java interfaces from Jaamsim.genmodel.

A successful verification writes `.build/verified-build.json` with the lock hash, source fingerprint and whether native tests ran. The Eclipse verifier rejects a missing stamp, changed source/manifest/lock inputs, or a native verification request following a non-native build. The stamp is not a signed attestation or protection against manual changes to compiled outputs.

### 4. Isolated Eclipse packaging

`verify-eclipse.ps1` builds its runtime configuration from the lock rather than reading an installed Eclipse `bundles.info`. Only the required runtime set is installed, with explicit startup levels for its services. Four project jars are rebuilt from source-build outputs and project manifests. Jar-entry timestamps use a fixed date so packaging time does not alter their contents. The application still loads metamodels and rules from the supplied source checkout; these jars are verification bundles, not a standalone packaged product.

The verifier's own temporary jar files live under `.build/eclipse-test/tmp`. It does not need to move jar-tool temporaries from an external Windows sandbox directory. Existing installed Eclipse configurations and user workspaces are untouched.

### 5. Two independent source-only builds

`verify-reproducibility.ps1` enumerates tracked and untracked non-ignored source files through Git, then creates two fresh copies under a unique `.build/repro-check/<id>/` directory. It excludes `bin`, `xtend-gen`, `.build`, `target`, class files and compiled ATL artifacts. This tests the current authored work, including uncommitted changes, rather than only HEAD.

Each copy runs the standalone verifier and isolated Eclipse verifier. With `-Native`, each also compiles and runs the native JaamSim harness. The script compares SHA-256 hashes of generated CFGs, JaamSim XMI, BPSim.ecore, compiled ATL, application/model/native class files and the four packaged project jars. It requires equal file counts and byte-identical contents. A JSON result records the compared paths and hashes.

Path-bearing `.runs.txt`, compiler argument files, build stamps, logs, temporary workspaces and Xtend trace metadata are intentionally outside byte-comparison scope. The run lists contain absolute paths and therefore differ between copies. The check also proves that a corrupted dependency is rejected and that changing Main.java makes Eclipse verification reject a stale build.

### 6. Generated-artifact hygiene

`.gitignore` now excludes new `bin`, `xtend-gen` and class outputs in addition to `.build`. Previously tracked binaries were not removed from Git in this revision. The build and source-only verification do not consume them. Removing historical tracked build products can be a separate repository cleanup.

## How to build

Prerequisites: Windows x64, 64-bit PowerShell 7 and a source checkout. Git is additionally needed for the source-only reproducibility comparison. No installed Eclipse or system Java is required once the kit exists.

On the current machine, prepare the kit once:

```powershell
./scripts/prepare-toolchain.ps1 -JaamSimSourceDirectory C:/Users/antoine.bakhos/tmp-jaamsim-ref/jaamsim
```

It defaults to the current user's `.p2/pool/plugins`. Use `-PluginDirectory` and `-Destination` for other source/output locations. The source files must match the lock exactly.

Alternatively, obtain the matching portable archive, then extract it at the repository root:

```powershell
Expand-Archive -LiteralPath C:/path/to/reproducible-toolchain-windows-x64-v1.zip -DestinationPath .build/toolchain
```

Build and verify:

```powershell
./scripts/verify.ps1 -Native
./scripts/verify-eclipse.ps1 -Native
./scripts/verify-reproducibility.ps1 -Native
```

An external kit directory also works:

```powershell
./scripts/verify.ps1 -ToolchainDirectory C:/build-tools/model-transformation -Native
./scripts/verify-eclipse.ps1 -ToolchainDirectory C:/build-tools/model-transformation -Native
./scripts/verify-reproducibility.ps1 -ToolchainDirectory C:/build-tools/model-transformation -Native
```

Run standalone verification before Eclipse verification. Omit `-Native` for the faster transformation/Eclipse checks. The old `-JavaHome`, `-JavaExecutable`, `-EclipseDirectory` and `-JaamSimSourceDirectory` verification overrides are replaced by the locked kit and `-Native`; `-JaamSimSourceDirectory` is now used only during kit preparation.

The rebuild clears compiled files under `.build/com`, `.build/model-classes`, `.build/xtend-gen`, `.build/jaamsim`, and top-level `.build/*.class`. Eclipse verification recreates `.build/eclipse-test`. The toolchain and existing CFG files are not deleted during that cleanup; test outputs with the same names are regenerated. Save manually edited test CFGs elsewhere before rerunning tests.

## Distribution and limits

The toolchain archive is generated under `.build` and is not committed. A fresh clone alone therefore cannot provision dependencies. Keep the archive with a controlled artifact store or release asset when sharing the repository. No upload, public dependency hosting or hosted GitHub Actions run was performed in this task. Hosted CI still needs a way to obtain this exact kit.

The lock fixes Java/dependency/native-source bytes. PowerShell and Windows themselves are not bundled. Verification demonstrates two source-only builds on this Windows machine; it does not establish cross-operating-system or cross-machine identity. No Linux/macOS support or new simulation semantics are introduced.

## Verification evidence and archive

The command `./scripts/verify-reproducibility.ps1 -Native` passed. Both isolated source copies independently passed 316 regression assertions, 19 standalone native CFG runs, four Equinox launches, and six native runs of the Eclipse-produced CFGs. The comparison found **1,487 byte-identical artifacts**. No installed Eclipse bundle inventory or precompiled project bin directory was used by these source-only builds. Corrupted dependency and stale-source rejection probes also passed.

The local machine-readable artifact hash report is:

```text
.build/repro-check/1abf6f7a024c4f868a056e5db3b3740b/result.json
```

The detailed local log is `.build/reproducibility.log`. These evidence files are generated outputs and are not committed. The script produces a new report directory on every invocation.

The prepared portable archive is `.build/reproducible-toolchain-windows-x64-v1.zip`, 253,357,933 bytes. SHA-256 for this archive:

```text
CC7C1FFBB8A44C4FAF3E4F75A405F02FE01AFA65999BF973ADE9A3FA3588BCF8
```

The archive's member files are checked against the repository lock before use; the archive itself is a convenience distribution, not one of the byte-comparison build outputs. Archive timestamps can change its checksum when repackaged without changing member contents. No artifact has been uploaded and no commit or push was performed.

The archive was also extracted into a separate directory and all 2,131 locked member hashes passed verification. The working checkout was subsequently rebuilt and verified through both launch paths with native tests, leaving a current successful build stamp.
