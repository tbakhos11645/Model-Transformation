param([string]$ToolchainDirectory, [switch]$Native)
$ErrorActionPreference='Stop'
$repo=Split-Path $PSScriptRoot -Parent
. "$PSScriptRoot/toolchain.ps1"
$kit=Get-LockedToolchain $repo $ToolchainDirectory
$stampPath=Join-Path $repo '.build/verified-build.json'
if(!(Test-Path -LiteralPath $stampPath)){throw 'Run scripts/verify.ps1 first'}
$stamp=Get-Content -LiteralPath $stampPath -Raw | ConvertFrom-Json
if($stamp.lockHash -ne $kit.LockHash -or $stamp.sourceHash -ne (Get-BuildSourceHash $repo)){throw 'Build is stale: run scripts/verify.ps1 again'}
if($Native -and !$stamp.native){throw 'Run scripts/verify.ps1 -Native first'}
$runtime=Join-Path $repo '.build/eclipse-test'
Remove-BuildDirectory (Join-Path $repo '.build') 'eclipse-test'
New-Item -ItemType Directory -Force "$runtime/configuration/org.eclipse.equinox.simpleconfigurator","$runtime/plugins","$runtime/tmp" | Out-Null
$java=$kit.Java
$JaamSimSourceDirectory=if($Native){Join-Path $kit.Root 'jaamsim'}else{$null}
$bundles=@('#encoding=UTF-8','#version=1')
$autoStart=@{'org.apache.felix.scr'=2;'org.apache.aries.spifly.dynamic.bundle'=2;'org.eclipse.core.runtime'=4;'org.eclipse.equinox.common'=2;'org.eclipse.equinox.event'=2;'slf4j.simple'=2}
foreach($bundle in $kit.Lock.bundles | Where-Object {$_.id -in $kit.Lock.runtimeBundles}){
 $bundleUri=([uri](Join-Path $kit.Root $bundle.path)).AbsoluteUri
 $level=4; $start='false'
 if($autoStart.ContainsKey($bundle.id)){$level=$autoStart[$bundle.id];$start='true'}
 $bundles+="$($bundle.id),$($bundle.version),$bundleUri,$level,$start"
}
foreach($entry in @(@('Models','com.yourorg.models','.build/model-classes','jaamsim'),@('com.yourorg.atl','com.yourorg.atl','',''),@('com.your.m2t','com.your.m2t','.build','com/your/m2t'),@('com.yourorg.main','com.yourorg.main','.build','com/yourorg/main'))) {
 $bundle=$entry[0];$project=$entry[1];$jar="$runtime/plugins/$bundle.jar"
 $arguments=@('--create','--date=2026-01-01T00:00:00Z','--file',$jar,'--manifest',"$repo/$project/META-INF/MANIFEST.MF")
 if($entry[2]){$arguments+=@('-C',"$repo/$($entry[2])",$entry[3])}
 if(Test-Path "$repo/$project/plugin.xml"){$arguments+=@('-C',"$repo/$project",'plugin.xml')}
 & $java "-Djava.io.tmpdir=$runtime/tmp" -m jdk.jartool/sun.tools.jar.Main @arguments
 if($LASTEXITCODE -ne 0){throw 'Bundle packaging failed'}
 $bundles+="$bundle,1.0.0.qualifier,$(([uri]$jar).AbsoluteUri),4,false"
}
$bundles | Set-Content "$runtime/configuration/org.eclipse.equinox.simpleconfigurator/bundles.info"
$osgi=Join-Path $kit.Root ($kit.Lock.bundles | Where-Object id -eq 'org.eclipse.osgi').path
$simple=Join-Path $kit.Root ($kit.Lock.bundles | Where-Object id -eq 'org.eclipse.equinox.simpleconfigurator').path
$launcher=Join-Path $kit.Root ($kit.Lock.bundles | Where-Object id -eq 'org.eclipse.equinox.launcher').path
@("osgi.framework=$(([uri]$osgi).AbsoluteUri)","osgi.bundles=reference:$(([uri]$simple).AbsoluteUri)@1:start",'osgi.bundles.defaultStartLevel=4','org.eclipse.equinox.simpleconfigurator.configUrl=file:org.eclipse.equinox.simpleconfigurator/bundles.info') | Set-Content "$runtime/configuration/config.ini"
foreach($case in @(@('third-bpsim-test','third-bpsim-eclipse','third-bpsim-test','replicated'),@('first-bpsim-test','first-bpsim-eclipse','first-bpsim-test','baseline'),@('second-bpsim-test','second-bpsim-eclipse','second-bpsim-test','congested'),@('second-bpsim-test','second-bpsim-warmup-eclipse','second-bpsim-warmup','warmed'))) {
 & $java '-Djava.awt.headless=true' -jar $launcher -nosplash -consoleLog -configuration "$runtime/configuration" -data "$runtime/workspace" -application com.yourorg.main.application "com.yourorg.main/sample_in/$($case[0]).xmi" ".build/$($case[1])" $repo '60' "com.yourorg.main/sample_in/$($case[0]).bpsim.xml" $case[3]
 if($LASTEXITCODE -ne 0){throw "Eclipse application failed ($LASTEXITCODE)"}
 if(!(Test-Path "$repo/.build/$($case[1]).cfg")){throw 'Eclipse output missing'}
 if((Get-Content "$repo/.build/$($case[1]).cfg" -Raw) -ne (Get-Content "$repo/.build/$($case[2]).cfg" -Raw)){throw 'Eclipse and standalone CFG outputs differ'}
 if($case[0] -eq 'third-bpsim-test') {
  foreach($suffix in @('-replication-002','-replication-003')) {
   if((Get-Content "$repo/.build/$($case[1])$suffix.cfg" -Raw) -ne (Get-Content "$repo/.build/$($case[2])$suffix.cfg" -Raw)){throw 'Replicated Eclipse CFG differs'}
  }
  if((Get-Content "$repo/.build/$($case[1]).runs.txt").Count -ne 4){throw 'Expected three Eclipse replications'}
 }
 Write-Output "PASS: Eclipse launch and standalone CFG equality: $($case[1])"
}
if ($JaamSimSourceDirectory) {
 $jaamRoot=(Resolve-Path -LiteralPath $JaamSimSourceDirectory).Path
 if(!(Test-Path "$repo/.build/SecondBpsimObserver.class")){throw 'Run verify.ps1 with -JaamSimSourceDirectory first'}
 $nativeClasspath=@("$repo/.build","$repo/.build/jaamsim","$jaamRoot/jar/jogl-all.jar","$jaamRoot/jar/gluegen-rt.jar","$jaamRoot/src/main/resources") -join [IO.Path]::PathSeparator
 & $java '-Djava.awt.headless=true' -cp $nativeClasspath JaamSimSmokeTest "$repo/.build/third-bpsim-eclipse.cfg" "$repo/.build/third-bpsim-eclipse-replication-002.cfg" "$repo/.build/third-bpsim-eclipse-replication-003.cfg" "$repo/.build/first-bpsim-eclipse.cfg" "$repo/.build/second-bpsim-eclipse.cfg" "$repo/.build/second-bpsim-warmup-eclipse.cfg"
 if($LASTEXITCODE -ne 0){throw 'Native Eclipse-output verification failed'}
}
