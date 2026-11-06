param([string]$EclipseDirectory="$env:USERPROFILE/eclipse/modeling-2026-09/eclipse",
      [string]$PluginDirectory="$env:USERPROFILE/.p2/pool/plugins",
      [string]$JarExecutable='C:/Program Files/Java/jdk-17/bin/jar.exe')
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
& $java '-Djava.awt.headless=true' -jar $launcher -nosplash -consoleLog -configuration "$runtime/configuration" -data "$runtime/workspace" -application com.yourorg.main.application 'com.yourorg.main/sample_in/first-bpsim-test.xmi' '.build/first-bpsim-eclipse' $repo '60' 'com.yourorg.main/sample_in/first-bpsim-test.bpsim.xml' 'baseline'
if($LASTEXITCODE -ne 0){throw "Eclipse application failed ($LASTEXITCODE)"}
if(!(Test-Path "$repo/.build/first-bpsim-eclipse.cfg")){throw 'Eclipse output missing'}
if((Get-Content "$repo/.build/first-bpsim-eclipse.cfg" -Raw) -ne (Get-Content "$repo/.build/first-bpsim-test.cfg" -Raw)){throw 'Eclipse and standalone CFG outputs differ'}
Write-Output 'PASS: Eclipse registered application launch and standalone CFG equality'
