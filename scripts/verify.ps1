param([string]$PluginDirectory = "$env:USERPROFILE/.p2/pool/plugins",
      [string]$JavaHome = 'C:/Program Files/Java/jdk-17',
      [string]$JavaExecutable,
      [string]$JaamSimSourceDirectory)
$ErrorActionPreference = 'Stop'
$repoRoot = Split-Path $PSScriptRoot -Parent
$build = Join-Path $repoRoot '.build'
New-Item -ItemType Directory -Force $build | Out-Null
$jars = Get-ChildItem -LiteralPath $PluginDirectory -Filter '*.jar' | Where-Object {
    $_.Name -notmatch '\.(source|doc)_' -and
    $_.Name -match '^(org\.eclipse\.(emf\.|m2m\.atl\.|xtend\.(core|lib)|xtext[._]|jdt\.core|core\.|equinox\.|osgi_|text_)|org\.osgi\.|org\.antlr|org\.apache\.log4j|org\.apache\.logging|org\.ow2\.asm|org\.objectweb\.asm|com\.google\.|jakarta\.inject|javax\.inject|aopalliance|org\.aopalliance|slf4j\.api|slf4j\.simple)'
}
$jars = $jars | Group-Object { $_.Name -replace '_[^_]+\.jar$', '' } | ForEach-Object { $_.Group | Sort-Object Name -Descending | Select-Object -First 1 }
if (!$jars) { throw 'Pass -PluginDirectory with Eclipse ATL/EMFTVM/Xtend plugin jars' }
$classpath = ($jars.FullName -join [IO.Path]::PathSeparator)
if (!$JavaExecutable) {
    $embeddedJava = Get-ChildItem "$PluginDirectory/org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_*/jre/bin/java.exe" | Sort-Object FullName | Select-Object -Last 1
    $JavaExecutable = if ($embeddedJava) { $embeddedJava.FullName } else { Join-Path $JavaHome 'bin/java.exe' }
}
function Invoke-JavaTool([string]$Tool, [string[]]$Arguments) {
    $argFile = Join-Path $build "$Tool.args"
    $quoted = $Arguments | ForEach-Object { '"' + $_.Replace('\', '/').Replace('"', '\"') + '"' }
    [IO.File]::WriteAllLines($argFile, $quoted, [Text.UTF8Encoding]::new($false))
    $executable = if ($Tool -eq 'java') { $JavaExecutable } else { Join-Path $JavaHome "bin/$Tool.exe" }
    & $executable "@$argFile"
    if ($LASTEXITCODE -ne 0) { throw "$Tool failed ($LASTEXITCODE)" }
}
# Compile Xtend from source so stale checked-in generated Java cannot hide errors.
Invoke-JavaTool 'java' @('-cp', $classpath, 'org.eclipse.xtend.core.compiler.batch.Main',
    '-d', (Join-Path $build 'xtend-gen'), '-cp', $classpath, (Join-Path $repoRoot 'com.your.m2t/src'))
$sources = @(Get-ChildItem (Join-Path $build 'xtend-gen') -Recurse -Filter '*.java' | ForEach-Object FullName)
$sources += @(Get-ChildItem (Join-Path $repoRoot 'com.yourorg.main/src') -Recurse -Filter '*.java' | ForEach-Object FullName)
$sources += Join-Path $repoRoot 'tests/TransformationSmokeTest.java'
Invoke-JavaTool 'java' (@('-cp', $classpath, 'org.eclipse.jdt.internal.compiler.batch.Main', '-17', '-encoding', 'UTF-8', '-cp', $classpath, '-d', $build) + $sources)
Invoke-JavaTool 'java' @('-cp', ($build + [IO.Path]::PathSeparator + $classpath), 'TransformationSmokeTest', $repoRoot)
if ($JaamSimSourceDirectory) {
    $jaamRoot = (Resolve-Path -LiteralPath $JaamSimSourceDirectory).Path
    $jaamClasses = Join-Path $build 'jaamsim'
    New-Item -ItemType Directory -Force $jaamClasses | Out-Null
    $jaamLibraries = (Join-Path $jaamRoot 'jar/jogl-all.jar') + [IO.Path]::PathSeparator + (Join-Path $jaamRoot 'jar/gluegen-rt.jar')
    $jaamSources = @(Get-ChildItem (Join-Path $jaamRoot 'src/main/java') -Recurse -Filter '*.java' | ForEach-Object FullName)
    Invoke-JavaTool 'java' (@('-cp', $classpath, 'org.eclipse.jdt.internal.compiler.batch.Main', '-8', '-nowarn', '-encoding', 'UTF-8', '-cp', $jaamLibraries, '-d', $jaamClasses) + $jaamSources)
    $jaamClasspath = $jaamClasses + [IO.Path]::PathSeparator + $jaamLibraries
    Invoke-JavaTool 'java' @('-cp', $classpath, 'org.eclipse.jdt.internal.compiler.batch.Main', '-17', '-cp', $jaamClasspath, '-d', $build, (Join-Path $repoRoot 'tests/JaamSimSmokeTest.java'))
    $jaamClasspath = $build + [IO.Path]::PathSeparator + $jaamClasspath + [IO.Path]::PathSeparator + (Join-Path $jaamRoot 'src/main/resources')
    $configs = @('ex1', 'ex2', 'conditional', 'timer', 'duration', 'collision', 'merge', 'subtype-Task', 'subtype-UserTask', 'subtype-ServiceTask', 'subtype-ManualTask', 'subtype-ScriptTask', 'subtype-BusinessRuleTask') | ForEach-Object { Join-Path $build "${_}.cfg" }
    Invoke-JavaTool 'java' (@('-Djava.awt.headless=true', '-cp', $jaamClasspath, 'JaamSimSmokeTest') + $configs)
}
