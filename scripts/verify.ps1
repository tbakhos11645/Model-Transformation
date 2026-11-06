param([string]$ToolchainDirectory, [switch]$Native)
$ErrorActionPreference = 'Stop'
$repoRoot = Split-Path $PSScriptRoot -Parent
. "$PSScriptRoot/toolchain.ps1"
$kit=Get-LockedToolchain $repoRoot $ToolchainDirectory
$build=Join-Path $repoRoot '.build'
New-Item -ItemType Directory -Force $build | Out-Null
foreach($name in @('com','xtend-gen','jaamsim','model-classes')){Remove-BuildDirectory $build $name}
Get-ChildItem -LiteralPath $build -Filter '*.class' -File | Remove-Item -Force
$stamp=Join-Path $build 'verified-build.json'
if(Test-Path -LiteralPath $stamp){Remove-Item -LiteralPath $stamp -Force}
$classpath=($kit.Lock.classpath | ForEach-Object {Join-Path $kit.Root $_}) -join [IO.Path]::PathSeparator
$JavaExecutable=$kit.Java
$JaamSimSourceDirectory=if($Native){Join-Path $kit.Root 'jaamsim'}else{$null}
function Invoke-JavaTool([string]$Tool, [string[]]$Arguments) {
    $argFile = Join-Path $build "$Tool.args"
    $quoted = $Arguments | ForEach-Object { '"' + $_.Replace('\', '/').Replace('"', '\"') + '"' }
    [IO.File]::WriteAllLines($argFile, $quoted, [Text.UTF8Encoding]::new($false))
    $executable = if ($Tool -eq 'java') { $JavaExecutable } else { Join-Path $kit.Root "java/bin/$Tool.exe" }
    & $executable "@$argFile"
    if ($LASTEXITCODE -ne 0) { throw "$Tool failed ($LASTEXITCODE)" }
}
# Build model classes from source, never Eclipse bin/.
$modelSources=@(Get-ChildItem (Join-Path $repoRoot 'com.yourorg.models/src') -Recurse -Filter '*.java' | Sort-Object FullName | ForEach-Object FullName)
Invoke-JavaTool 'java' (@('-cp', $classpath, 'org.eclipse.jdt.internal.compiler.batch.Main', '-21', '-encoding', 'UTF-8', '-cp', $classpath, '-d', (Join-Path $build 'model-classes')) + $modelSources)
# Compile Xtend from source so stale checked-in generated Java cannot hide errors.
Invoke-JavaTool 'java' @('-cp', $classpath, 'org.eclipse.xtend.core.compiler.batch.Main',
    '-d', (Join-Path $build 'xtend-gen'), '-cp', $classpath, (Join-Path $repoRoot 'com.your.m2t/src'))
$sources = @(Get-ChildItem (Join-Path $build 'xtend-gen') -Recurse -Filter '*.java' | Sort-Object FullName | ForEach-Object FullName)
$sources += @(Get-ChildItem (Join-Path $repoRoot 'com.yourorg.main/src') -Recurse -Filter '*.java' | Sort-Object FullName | ForEach-Object FullName)
$sources += Join-Path $repoRoot 'tests/TransformationSmokeTest.java'
$sources += Join-Path $repoRoot 'tests/GenerateBpsim.java'
Invoke-JavaTool 'java' (@('-cp', $classpath, 'org.eclipse.jdt.internal.compiler.batch.Main', '-17', '-encoding', 'UTF-8', '-cp', $classpath, '-d', $build) + $sources)
Invoke-JavaTool 'java' @('-cp', ($build + [IO.Path]::PathSeparator + $classpath), 'GenerateBpsim', $repoRoot)
Invoke-JavaTool 'java' @('-cp', ($build + [IO.Path]::PathSeparator + $classpath), 'TransformationSmokeTest', $repoRoot)
Invoke-JavaTool 'java' @('-cp', ($build + [IO.Path]::PathSeparator + $classpath), 'com.yourorg.main.Main', 'com.yourorg.main/sample_in/first-bpsim-test.xmi', '.build/first-bpsim-test', $repoRoot, '60', 'com.yourorg.main/sample_in/first-bpsim-test.bpsim.xml', 'baseline')
foreach ($case in @(@('second-bpsim-test','congested'),@('second-bpsim-warmup','warmed'))) {
    Invoke-JavaTool 'java' @('-cp', ($build + [IO.Path]::PathSeparator + $classpath), 'com.yourorg.main.Main', 'com.yourorg.main/sample_in/second-bpsim-test.xmi', ('.build/' + $case[0]), $repoRoot, '60', 'com.yourorg.main/sample_in/second-bpsim-test.bpsim.xml', $case[1])
}
Invoke-JavaTool 'java' @('-cp', ($build + [IO.Path]::PathSeparator + $classpath), 'com.yourorg.main.Main', 'com.yourorg.main/sample_in/third-bpsim-test.xmi', '.build/third-bpsim-test', $repoRoot, '60', 'com.yourorg.main/sample_in/third-bpsim-test.bpsim.xml', 'replicated')
if ($JaamSimSourceDirectory) {
    $jaamRoot = (Resolve-Path -LiteralPath $JaamSimSourceDirectory).Path
    $jaamClasses = Join-Path $build 'jaamsim'
    New-Item -ItemType Directory -Force $jaamClasses | Out-Null
    $jaamLibraries = (Join-Path $jaamRoot 'jar/jogl-all.jar') + [IO.Path]::PathSeparator + (Join-Path $jaamRoot 'jar/gluegen-rt.jar')
    $jaamSources = @(Get-ChildItem (Join-Path $jaamRoot 'src/main/java') -Recurse -Filter '*.java' | Sort-Object FullName | ForEach-Object FullName)
    Invoke-JavaTool 'java' (@('-cp', $classpath, 'org.eclipse.jdt.internal.compiler.batch.Main', '-8', '-nowarn', '-encoding', 'UTF-8', '-cp', $jaamLibraries, '-d', $jaamClasses) + $jaamSources)
    $jaamClasspath = $jaamClasses + [IO.Path]::PathSeparator + $jaamLibraries
    Invoke-JavaTool 'java' @('-cp', $classpath, 'org.eclipse.jdt.internal.compiler.batch.Main', '-17', '-cp', $jaamClasspath, '-d', $build, (Join-Path $repoRoot 'tests/JaamSimSmokeTest.java'), (Join-Path $repoRoot 'tests/FirstBpsimObserver.java'), (Join-Path $repoRoot 'tests/SecondBpsimObserver.java'))
    $jaamClasspath = $build + [IO.Path]::PathSeparator + $jaamClasspath + [IO.Path]::PathSeparator + (Join-Path $jaamRoot 'src/main/resources')
    $configs = @('third-bpsim-test', 'third-bpsim-test-replication-002', 'third-bpsim-test-replication-003', 'first-bpsim-test', 'second-bpsim-test', 'second-bpsim-warmup', 'ex1', 'ex2', 'conditional', 'timer', 'duration', 'collision', 'merge', 'subtype-Task', 'subtype-UserTask', 'subtype-ServiceTask', 'subtype-ManualTask', 'subtype-ScriptTask', 'subtype-BusinessRuleTask') | ForEach-Object { Join-Path $build "${_}.cfg" }
    Invoke-JavaTool 'java' (@('-Djava.awt.headless=true', '-cp', $jaamClasspath, 'JaamSimSmokeTest') + $configs)
}
# Stamp only a fully successful build.
@{lockHash=$kit.LockHash;sourceHash=(Get-BuildSourceHash $repoRoot);native=[bool]$Native} | ConvertTo-Json | Set-Content -LiteralPath $stamp
