# BPSim integration — main changes

Updated: 2026.11.06-154042-CET (6 November 2026, 15:40:42 Europe/Paris). Initial integration: 2026.11.06-092452-CET.

## What is implemented

- `BPSim.ecore` is generated directly from the supplied BPSim 2.0 XSD using EMF XSDEcoreBuilder. It represents the complete schema, including scenarios, parameter value types, distributions, calendars, results and vendor extensions. Extended XML metadata is retained.
- A separate BPSim XML file can now accompany the BPMN XMI. The file is XSD-validated, and a scenario is selected by its ID.
- The execution adapter supports constant task ProcessingTime, start InterTriggerTimer and TriggerCount. Numeric and floating times honor local units and the scenario base unit (minutes if omitted); constant ISO durations are accepted.
- Constant scenario Duration and Warmup are now executed. BPSim Duration includes warmup; JaamSim receives InitializationDuration=Warmup and RunDuration=total-Warmup. Scenario Duration overrides the CLI duration; absent Duration uses the CLI/default total. Require total > 0 and 0 <= Warmup < total; equality is rejected because the target requires a positive measurement interval.
- BPSim values are adapted into the existing ATL input features in memory. Existing BPMN files and the legacy pipeline remain usable. The custom Ecore attributes are compatibility fields, not a claim of BPSim conformity.
- In BPSim mode, task times default to zero, conveyor delays are zero, starts emit one entity per trigger, missing trigger counts are unlimited, and first arrivals occur after the configured interval. Missing intervals and explicit zero counts are rejected rather than changed to legacy defaults.
- The parser disables external XML entities and schema access. Unsupported execution features fail before output is written.

## Running

After `./scripts/verify.ps1`, pass six arguments to Main:

```text
input.xmi output-prefix repository-root run-seconds scenario.xml scenario-id
```

Legacy mode keeps its previous argument meanings. In BPSim mode the fourth argument is the fallback total duration; a scenario Duration takes precedence. The BPSim file is separate XML; this version does not load embedded BPSim data from BPMN extension elements.

Example BPSim XML (the BPMN elements must have IDs Start and Work):

```xml
<BPSimData xmlns="http://www.bpsim.org/schemas/2.0">
  <Scenario id="baseline">
    <ElementParameters elementRef="Start">
      <ControlParameters>
        <InterTriggerTimer><FloatingParameter value="0.1"/></InterTriggerTimer>
        <TriggerCount><NumericParameter value="3"/></TriggerCount>
      </ControlParameters>
    </ElementParameters>
    <ElementParameters elementRef="Work">
      <TimeParameters>
        <ProcessingTime><FloatingParameter value="2" timeUnit="s"/></ProcessingTime>
      </TimeParameters>
    </ElementParameters>
  </Scenario>
</BPSimData>
```

This yields arrivals every six seconds and two seconds of processing per task.

## Current execution limits

Schema representation is broader than execution support. XPath conditions, probabilistic routing, distributions, calendars, inheritance, resource/cost/priority/property execution, result requests, vendor extensions and scenario settings other than baseTimeUnit, Duration, Warmup, seed and replication are rejected when selected for execution. Scenario Start remains unsupported. Seed and replication default to 1 when omitted; each replication exports a separate CFG using seed + index - 1. Seed/substream values must fit 0..2147483647 across the batch and replication count must be 1..1000. These are target/exporter limits, not restrictions of the BPSim XSD. BPSim mode permits unconditional XOR merges/pass-throughs with exactly one outgoing flow, normalizing Choice to 1. Each incoming entity proceeds independently. Splits and outgoing conditions remain rejected, so legacy Choice expressions are not reused as BPSim conditions. Legacy splits retain their previous behavior; conditional single-output gateways now fail explicitly. See [fourth bpsim test.md](fourth%20bpsim%20test.md).

Zero arrival intervals, zero trigger counts, counts exceeding the target EInt range, year units and conflicting BPMN event definitions are also rejected explicitly. These are target limitations; they are not declarations that those values/features are invalid BPSim.

The generated Ecore is available for EMF tooling; the current execution adapter reads and validates standard XML directly. Generic BPSim XML round-trip export and retirement of the compatibility attributes remain future work. This is an initial executable subset, not full BPSim conformance.

## Verification

The verification script regenerates BPSim.ecore and compiles Xtend, Java and ATL. The suite now passes 316 regression assertions. Native tests verify the first example's exact timeline and the second example's entity identities, FIFO order, waiting times, congestion, sink counts and warmup statistics. Both examples and the warmup variant also pass through the isolated Eclipse launcher, with identical CFGs and native behavioral checks. See second bpsim test.md and third bpsim test.md for reproduction, per-fix breakdowns and version scope. The third example verifies three distinct configured seeds, repeatable exports and native RNG probes. Main generates the replication CFGs and a .runs.txt list; it does not launch JaamSim automatically.
