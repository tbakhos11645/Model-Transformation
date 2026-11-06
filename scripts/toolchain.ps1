# Shared pinned-toolchain validation. Dot-source from build scripts.
function Get-LockedToolchain([string]$Repo, [string]$Directory) {
    if (!$Directory) { $Directory = Join-Path $Repo '.build/toolchain' }
    $Directory = [IO.Path]::GetFullPath($Directory)
    $lockPath = Join-Path $Repo 'build/toolchain.lock.json'
    $lock = Get-Content -LiteralPath $lockPath -Raw | ConvertFrom-Json
    if (!$IsWindows -or ![Environment]::Is64BitProcess) { throw 'This lock targets Windows x64; use 64-bit PowerShell 7.' }
    foreach ($entry in $lock.files) {
        $path = Join-Path $Directory $entry.path
        if (!(Test-Path -LiteralPath $path -PathType Leaf)) { throw "Missing locked dependency: $path. Run scripts/prepare-toolchain.ps1 or copy the matching portable toolchain." }
        if ((Get-FileHash -LiteralPath $path -Algorithm SHA256).Hash -ne $entry.sha256) { throw "Dependency hash mismatch: $path" }
    }
    [pscustomobject]@{ Root=$Directory; Lock=$lock; LockHash=(Get-FileHash $lockPath).Hash; Java=(Join-Path $Directory 'java/bin/java.exe') }
}

function Get-BuildSourceHash([string]$Repo) {
    $paths = @('com.yourorg.main/src','com.yourorg.models/src','com.your.m2t/src','com.yourorg.models/model','scripts','tests')
    $files = foreach($path in $paths) { Get-ChildItem -LiteralPath (Join-Path $Repo $path) -Recurse -File | Where-Object { $_.Extension -in '.java','.xtend','.ecore','.xsd','.ps1' } }
    $files += Get-Item (Join-Path $Repo 'com.yourorg.atl/Rules/Rules.atl')
    foreach($project in @('com.yourorg.main','com.yourorg.models','com.your.m2t','com.yourorg.atl')) {
        $files += Get-Item (Join-Path $Repo "$project/META-INF/MANIFEST.MF")
        $plugin=Join-Path $Repo "$project/plugin.xml"
        if(Test-Path -LiteralPath $plugin){$files+=Get-Item -LiteralPath $plugin}
    }
    $lines = foreach($file in $files | Sort-Object FullName) { [IO.Path]::GetRelativePath($Repo,$file.FullName).Replace('\','/') + ':' + (Get-FileHash $file.FullName).Hash }
    $bytes=[Text.Encoding]::UTF8.GetBytes(($lines -join "`n"))
    [Convert]::ToHexString([Security.Cryptography.SHA256]::HashData($bytes))
}

function Remove-BuildDirectory([string]$Build, [string]$Name) {
    $base=[IO.Path]::GetFullPath($Build).TrimEnd('\','/') + [IO.Path]::DirectorySeparatorChar
    $path=[IO.Path]::GetFullPath((Join-Path $Build $Name))
    if (!$path.StartsWith($base,[StringComparison]::OrdinalIgnoreCase)) { throw "Refusing cleanup outside build directory: $path" }
    if(Test-Path -LiteralPath $path) { Remove-Item -LiteralPath $path -Recurse -Force }
}
