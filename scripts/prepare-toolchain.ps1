# Copy an existing dependency installation into a portable, hash-locked kit.
param([string]$PluginDirectory="$env:USERPROFILE/.p2/pool/plugins",
      [Parameter(Mandatory=$true)][string]$JaamSimSourceDirectory,
      [string]$Destination)
$ErrorActionPreference='Stop'
$repo=Split-Path $PSScriptRoot -Parent
if(!$Destination){$Destination=Join-Path $repo '.build/toolchain'}
$lock=Get-Content "$repo/build/toolchain.lock.json" -Raw | ConvertFrom-Json
foreach($entry in $lock.files) {
    if($entry.source.StartsWith('plugins/')) {$source=Join-Path $PluginDirectory $entry.source.Substring(8)}
    else {$source=Join-Path $JaamSimSourceDirectory $entry.source.Substring(8)}
    $target=Join-Path $Destination $entry.path
    if(Test-Path -LiteralPath $target -PathType Leaf) {
        if((Get-FileHash -LiteralPath $target).Hash -eq $entry.sha256){continue}
    }
    if(!(Test-Path -LiteralPath $source -PathType Leaf) -or (Get-FileHash -LiteralPath $source).Hash -ne $entry.sha256){throw "Source does not match lock: $source"}
    New-Item -ItemType Directory -Force (Split-Path $target -Parent) | Out-Null
    Copy-Item -LiteralPath $source -Destination $target -Force
}
. "$PSScriptRoot/toolchain.ps1"
$kit=Get-LockedToolchain $repo $Destination
Write-Output "Prepared verified portable toolchain: $($kit.Root)"
