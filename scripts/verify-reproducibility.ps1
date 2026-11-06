param([string]$ToolchainDirectory, [switch]$Native)
$ErrorActionPreference='Stop'
$repo=Split-Path $PSScriptRoot -Parent
. "$PSScriptRoot/toolchain.ps1"
$kit=Get-LockedToolchain $repo $ToolchainDirectory
$session=Join-Path $repo ('.build/repro-check/' + [guid]::NewGuid().ToString('N'))
# A modified dependency must be rejected before executing any Java code.
$badKit=Join-Path $session 'bad-kit'
$badPath=Join-Path $badKit $kit.Lock.files[0].path
New-Item -ItemType Directory -Force (Split-Path $badPath -Parent) | Out-Null
[IO.File]::WriteAllText($badPath,'deliberately invalid dependency')
try { Get-LockedToolchain $repo $badKit | Out-Null; throw 'Accepted corrupted dependency' }
catch { if($_.Exception.Message -notlike 'Dependency hash mismatch:*'){throw} }
# Include current authored changes, but never old compiled outputs or .git state.
$files=@(& git -C $repo ls-files --cached --others --exclude-standard)
if($LASTEXITCODE -ne 0){throw 'Cannot enumerate repository sources'}
$files=$files | Sort-Object -Unique | Where-Object { $_ -notmatch '(^|/)(bin|xtend-gen|\.build|target)/|\.(class|asm|emftvm|xtendbin)$' }
$roots=@()
foreach($name in @('a','b')) {
 $copy=Join-Path $session $name
 $roots+=$copy
 foreach($file in $files) {
  $source=Join-Path $repo $file
  if(!(Test-Path -LiteralPath $source -PathType Leaf)){continue}
  $destination=Join-Path $copy $file
  New-Item -ItemType Directory -Force (Split-Path $destination -Parent) | Out-Null
  Copy-Item -LiteralPath $source -Destination $destination
 }
 & "$copy/scripts/verify.ps1" -ToolchainDirectory $kit.Root -Native:$Native
 & "$copy/scripts/verify-eclipse.ps1" -ToolchainDirectory $kit.Root -Native:$Native
}
function Get-Artifacts([string]$Root) {
 $items=@(Get-ChildItem "$Root/.build" -File | Where-Object {$_.Name -match '\.(cfg|jaamsim\.xmi)$'})
 foreach($dir in @('com','model-classes','jaamsim','eclipse-test/plugins')) {
  if(Test-Path "$Root/.build/$dir"){$items+=Get-ChildItem "$Root/.build/$dir" -Recurse -File | Where-Object {$_.Extension -in '.class','.jar'}}
 }
 $items+=Get-Item "$Root/com.yourorg.atl/Rules/Rules.emftvm","$Root/com.yourorg.models/model/BPSim.ecore"
 $result=@{}
 foreach($item in $items){$result[[IO.Path]::GetRelativePath($Root,$item.FullName).Replace('\','/')]=(Get-FileHash $item.FullName).Hash}
 return $result
}
$a=Get-Artifacts $roots[0]
$b=Get-Artifacts $roots[1]
if($a.Count -ne $b.Count){throw 'Artifact counts differ'}
foreach($path in $a.Keys){if($a[$path] -ne $b[$path]){throw "Non-reproducible artifact: $path"}}
# Verify stale-source protection in a disposable copy, restoring it afterward.
$source=Join-Path $roots[0] 'com.yourorg.main/src/com/yourorg/main/Main.java'
$original=[IO.File]::ReadAllBytes($source)
try {
 [IO.File]::AppendAllText($source,"`n// Stale-build rejection probe`n")
 try { & "$($roots[0])/scripts/verify-eclipse.ps1" -ToolchainDirectory $kit.Root; throw 'Accepted stale build' }
 catch { if($_.Exception.Message -notlike 'Build is stale:*'){throw} }
} finally { [IO.File]::WriteAllBytes($source,$original) }
@{lockHash=$kit.LockHash;artifactCount=$a.Count;first=$roots[0];second=$roots[1];hashes=$a;native=[bool]$Native} |
 ConvertTo-Json -Depth 4 | Set-Content "$session/result.json"
Write-Output "PASS: $($a.Count) byte-identical artifacts from two source-only builds. Report: $session/result.json"
