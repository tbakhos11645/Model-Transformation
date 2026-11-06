param([string]$EclipseDirectory="$env:USERPROFILE/eclipse/modeling-2026-09/eclipse",
      [string]$PluginDirectory="$env:USERPROFILE/.p2/pool/plugins",
      [string]$JarExecutable='C:/Program Files/Java/jdk-17/bin/jar.exe',
      [string]$JaamSimSourceDirectory)
$ErrorActionPreference='Stop'
$repo=Split-Path $PSScriptRoot -Parent
$runtime=Join-Path $repo '.build/eclipse-test'
New-Item -ItemType Directory -Force "$runtime/configuration/org.eclipse.equinox.simpleconfigurator","$runtime/plugins" | Out-Null
$bundles=Get-Content "$EclipseDirectory/configuration/org.eclipse.equinox.simpleconfigurator/bundles.info"
foreach($entry in @(@('Models','com.yourorg.models','com.yourorg.models/bin','jaamsim'),@('com.yourorg.atl','com.yourorg.atl','',''),@('com.your.m2t','com.your.m2t','.build','com/your/m2t'),@('com.yourorg.main','com.yourorg.main','.build','com/yourorg/main'))) {
 $bundle=$entry[0];$project=$entry[1];$jar="$runtime/plugins/$bundle.jar"
 $arguments=@('--create','--file',$jar,'--manifest',"$repo/$project/META-INF/MANIFEST.MF")
 if($entry[2]){$arguments+=@('-C',"$repo/$($entry[2])",$entry[3])}
 if(Test-Path "$repo/$project/plugin.xml"){$arguments+=@('-C',"$repo/$project",'plugin.xml')}
 & $JarExecutable @arguments
 if($LASTEXITCODE -ne 0){throw 'Bundle packaging failed'}
 $bundles+="$bundle,1.0.0.qualifier,$(([uri]$jar).AbsoluteUri),4,false"
}
$bundles | Set-Content "$runtime/configuration/org.eclipse.equinox.simpleconfigurator/bundles.info"
$osgi=(Get-ChildItem "$PluginDirectory/org.eclipse.osgi_*.jar" | Select-Object -Last 1).FullName
$simple=(Get-ChildItem "$PluginDirectory/org.eclipse.equinox.simpleconfigurator_*.jar" | Select-Object -Last 1).FullName
@("osgi.framework=$(([uri]$osgi).AbsoluteUri)","osgi.bundles=reference:$(([uri]$simple).AbsoluteUri)@1:start",'osgi.bundles.defaultStartLevel=4','org.eclipse.equinox.simpleconfigurator.configUrl=file:org.eclipse.equinox.simpleconfigurator/bundles.info') | Set-Content "$runtime/configuration/config.ini"
$java=(Get-ChildItem "$PluginDirectory/org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_*/jre/bin/java.exe" | Select-Object -Last 1).FullName
$launcher=(Get-ChildItem "$PluginDirectory/org.eclipse.equinox.launcher_*.jar" | Select-Object -Last 1).FullName
foreach($case in @(@('first-bpsim-test','first-bpsim-eclipse','first-bpsim-test','baseline'),@('second-bpsim-test','second-bpsim-eclipse','second-bpsim-test','congested'),@('second-bpsim-test','second-bpsim-warmup-eclipse','second-bpsim-warmup','warmed'))) {
 & $java '-Djava.awt.headless=true' -jar $launcher -nosplash -consoleLog -configuration "$runtime/configuration" -data "$runtime/workspace" -application com.yourorg.main.application "com.yourorg.main/sample_in/$($case[0]).xmi" ".build/$($case[1])" $repo '60' "com.yourorg.main/sample_in/$($case[0]).bpsim.xml" $case[3]
 if($LASTEXITCODE -ne 0){throw "Eclipse application failed ($LASTEXITCODE)"}
 if(!(Test-Path "$repo/.build/$($case[1]).cfg")){throw 'Eclipse output missing'}
 if((Get-Content "$repo/.build/$($case[1]).cfg" -Raw) -ne (Get-Content "$repo/.build/$($case[2]).cfg" -Raw)){throw 'Eclipse and standalone CFG outputs differ'}
 Write-Output "PASS: Eclipse launch and standalone CFG equality: $($case[1])"
}
if ($JaamSimSourceDirectory) {
 $jaamRoot=(Resolve-Path -LiteralPath $JaamSimSourceDirectory).Path
 if(!(Test-Path "$repo/.build/SecondBpsimObserver.class")){throw 'Run verify.ps1 with -JaamSimSourceDirectory first'}
 $nativeClasspath=@("$repo/.build","$repo/.build/jaamsim","$jaamRoot/jar/jogl-all.jar","$jaamRoot/jar/gluegen-rt.jar","$jaamRoot/src/main/resources") -join [IO.Path]::PathSeparator
 & $java '-Djava.awt.headless=true' -cp $nativeClasspath JaamSimSmokeTest "$repo/.build/first-bpsim-eclipse.cfg" "$repo/.build/second-bpsim-eclipse.cfg" "$repo/.build/second-bpsim-warmup-eclipse.cfg"
 if($LASTEXITCODE -ne 0){throw 'Native Eclipse-output verification failed'}
}
