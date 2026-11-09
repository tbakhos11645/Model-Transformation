# Text inputs for the manufacturing case

Use only the selected input in the model prompt. Keep the expected values and
scripted clarification answers separate until scoring or a relevant question.

## A. Complete

Release 100 components, one every 10 minutes starting at minute 10. Inspect
each component for two minutes. If it passes, pack it for one minute and
mark it complete. If it fails, rework it for four minutes and return it to
the same inspection queue. Each inspection, including any reinspection,
independently passes with probability 0.80. Use one FIFO server per activity,
start with an empty system, transfer immediately, do not abandon components,
and stop at 1200 minutes.

## B. Faithful paraphrase

The system starts empty. At minute 10 the first of 100 components enters,
followed by one new component every ten minutes until all 100 have entered.
Process each arrival at a single inspection station for two minutes. If it
clears inspection, the packing station spends one minute packing it and then
the component leaves. Otherwise a separate rework station works on that same
component for four minutes, and the component joins the original inspection
queue again. On every visit, the chance of passing is 80 percent, independently
of earlier visits and of other components. Each station serves one component
at a time in arrival order. Moving between stations takes no time. Components
never leave a queue early. The run ends at minute 1200.

## C. Missing required information

Release 100 components, one every 10 minutes starting at minute 10. Inspect
each component for two minutes. If it passes, pack it for one minute and
mark it complete. If it fails, rework it and return it to the same inspection
queue. Use one FIFO server per activity, start with an empty system, transfer
immediately, do not abandon components, and stop at 1200 minutes.

Only after a targeted question, give the corresponding answer:

- Rework duration: “Rework takes four minutes per visit.”
- Routing: “Each inspection, including reinspection, independently passes
  with probability 0.80.”

Without those answers or explicitly approved assumptions, expect a block
before executable export. A block is correct behavior, not a failed extraction.

## D. Behavior outside the first implementation's declared subset

Release 100 components, one every 10 minutes starting at minute 10. Inspect
each component for two minutes. If it passes, pack it for one minute and
mark it complete. If it fails, rework it for four minutes and return it to
the same inspection queue. A component passes its first inspection with
probability 0.80 and each later inspection with probability 0.95. Use one
FIFO server per activity, start with an empty system, transfer immediately,
do not abandon components, and stop at 1200 minutes.

Under the paper's first implementation scope (constant routing by outcome),
expect the validator to identify the visit-dependent probability and block
export. A flat 0.80 or 0.95 is not equivalent. If a later revision expressly
supports visit-dependent routing, verify that behavior separately; do not
score it against the nominal fixture.

## Reference and scoring

For A, B, and resolved C, require the path Start → Inspect → XOR;
pass → Pack → End; fail → Rework → the same Inspect. Track whether the
accepted model binds 120 s to Inspect, 240 s to Rework, 60 s to Pack,
0.80 to the pass destination and 0.20 to the fail destination, and retains
the arrival, capacity, queue, and stopping settings. Equivalent time units
and harmless identifier differences are allowed. Score the bindings against
this reference, not against visual resemblance.

Capture model/provider, prompt revision, sampling settings, raw response,
validation messages, clarification exchanges, accepted specification,
BPMN XML or EMF XMI as appropriate, JaamSim XMI, generated CFG, and test
report. Exclude credentials from the record. Report extraction, acceptance,
transform, load, and execution as separate outcomes; include failures in
the relevant denominator.
