"""Propose reviewed process data via OpenRouter; compile approved data to BPMN XMI and BPSim XML."""
import argparse
import hashlib
import json
import math
import os
from pathlib import Path
import re
import sys
from urllib.error import HTTPError
from urllib.request import Request, urlopen
import xml.etree.ElementTree as ET

PROMPT = Path(__file__).with_name("contract.txt")
BPMN = "http://www.omg.org/spec/BPMN/20100524/MODEL-XMI"
XMI = "http://www.omg.org/XMI"
XSI = "http://www.w3.org/2001/XMLSchema-instance"
BPSIM = "http://www.bpsim.org/schemas/2.0"
KINDS = {"start":"StartEvent", "task":"Task", "xor":"ExclusiveGateway", "end":"EndEvent"}

def require(ok, message):
    if not ok:
        raise ValueError(message)

def parse(text):
    def fields(pairs):
        out = {}
        for k,v in pairs:
            require(k not in out, "Duplicate JSON field: "+k)
            out[k] = v
        return out
    return json.loads(text, object_pairs_hook=fields)

def keys(obj, names, what):
    require(isinstance(obj,dict) and set(obj)==set(names.split()), f"Invalid fields in {what}")

def identifier(s):
    return isinstance(s,str) and re.fullmatch(r"[A-Za-z_][A-Za-z0-9_]{0,79}",s)

def number(x):
    return type(x) in (int,float) and abs(x) <= 1e12 and math.isfinite(x)

def validate(spec):
    require(isinstance(spec,dict),"Expected a JSON object")
    if spec.get("status") in ("needs_clarification","unsupported"):
        keys(spec,"status issues","block")
        issues=spec["issues"]
        require(isinstance(issues,list) and bool(issues) and all(
            isinstance(q,str) and q.strip() for q in issues),"Expected a list of issues")
        return None
    keys(spec,"status nodes flows scenario","specification")
    require(spec["status"]=="ready","Unknown status")
    settings=spec["scenario"]
    keys(settings,"interval_seconds count duration_seconds","scenario")
    interval, count, horizon = (settings[k] for k in ("interval_seconds","count","duration_seconds"))
    require(number(interval) and interval>0 and number(horizon) and horizon>=interval,
            "Interval must be positive and horizon must include the first arrival")
    require(type(count) is int and 1<=count<=2147483647,"Count must be a positive JaamSim integer")
    require(isinstance(spec["nodes"],list) and 2<=len(spec["nodes"])<=500,"Invalid node list")
    require(isinstance(spec["flows"],list) and 1<=len(spec["flows"])<=2000,"Invalid flow list")
    nodes={}; ids={"Definitions","Process"}
    incoming={}; outgoing={}
    for n in spec["nodes"]:
        require(isinstance(n,dict) and isinstance(n.get("kind"),str) and n["kind"] in KINDS,"Unsupported node")
        keys(n,"id kind seconds" if n["kind"]=="task" else "id kind","node")
        k=n["id"]
        require(identifier(k) and k not in ids,"Invalid or duplicate node id")
        if n["kind"]=="task":
            require(number(n["seconds"]) and n["seconds"]>0,"Tasks require positive durations in seconds")
        ids.add(k); nodes[k]=n; incoming[k]=[]; outgoing[k]=[]
    for f in spec["flows"]:
        require(isinstance(f,dict),"Invalid flow")
        keys(f,"id from to probability" if "probability" in f else "id from to","flow")
        k=f["id"]
        require(identifier(k) and k not in ids,"Invalid or duplicate flow id")
        require(all(identifier(f[x]) and f[x] in nodes for x in ("from","to")),"Unknown flow endpoint")
        ids.add(k); outgoing[f["from"]].append(f); incoming[f["to"]].append(f)
    starts=[n for n in nodes if nodes[n]["kind"]=="start"]
    ends=[n for n in nodes if nodes[n]["kind"]=="end"]
    require(len(starts)==1 and bool(ends),"Expected one start and at least one end")
    for k,n in nodes.items():
        ins,outs,kind=incoming[k],outgoing[k],n["kind"]
        require(bool(ins)==(kind!="start"),"Invalid incoming flows at "+k)
        require((len(outs)==0 if kind=="end" else len(outs)>=1 if kind=="xor" else len(outs)==1),
                "Invalid outgoing flows at "+k)
        if kind=="xor" and len(outs)>1:
            weights=[f.get("probability") for f in outs]
            require(all(number(v) and 0<=v<=1 for v in weights),"Missing or invalid probability at "+k)
            require(abs(math.fsum(weights)-1)<=1e-9,"Probabilities must sum to 1 at "+k)
        else:
            require(all("probability" not in f for f in outs),"Probability outside exclusive split at "+k)
    def closure(seed, edges, neighbor):
        seen=set(seed); pending=list(seed)
        while pending:
            for f in edges[pending.pop()]:
                dest=f[neighbor]
                if dest not in seen:
                    seen.add(dest); pending.append(dest)
        return seen
    require(closure(starts,outgoing,"to")==set(nodes),"Unreachable nodes")
    require(closure(ends,incoming,"from")==set(nodes),"Nodes with no structural path to an end")
    return nodes,incoming,outgoing,starts[0]

def compile_models(spec, out, seed, replications):
    checked=validate(spec)
    require(checked is not None,"Blocked responses are not executable")
    nodes,ins,outs,start=checked
    require(1<=replications<=1000 and 0<=seed<=2147483647-(replications-1),"Invalid seed or replication range")
    for p,u in (("bpmn",BPMN),("xmi",XMI),("xsi",XSI)):
        ET.register_namespace(p,u)
    root=ET.Element(f"{{{BPMN}}}Definitions",{f"{{{XMI}}}version":"2.0","id":"Definitions",
                                              "targetNamespace":"urn:reviewed-process"})
    process=ET.SubElement(root,"rootElements",{f"{{{XSI}}}type":"bpmn:Process","id":"Process"})
    for k,n in nodes.items():
        attrib={f"{{{XSI}}}type":"bpmn:"+KINDS[n["kind"]],"id":k,"name":k}
        if ins[k]: attrib["incoming"]=" ".join(f["id"] for f in ins[k])
        if outs[k]: attrib["outgoing"]=" ".join(f["id"] for f in outs[k])
        ET.SubElement(process,"flowElements",attrib)
    for f in spec["flows"]:
        ET.SubElement(process,"flowElements",{f"{{{XSI}}}type":"bpmn:SequenceFlow","id":f["id"],
                                              "sourceRef":f["from"],"targetRef":f["to"]})
    doc=ET.Element("BPSimData",xmlns=BPSIM)
    scenario=ET.SubElement(doc,"Scenario",id="process")
    setup=ET.SubElement(scenario,"ScenarioParameters",baseTimeUnit="s",seed=str(seed),replication=str(replications))
    def param(group,tag,n,kind="FloatingParameter"):
        ET.SubElement(ET.SubElement(group,tag),kind,value=str(n))
    def group_for(k,name):
        return ET.SubElement(ET.SubElement(scenario,"ElementParameters",elementRef=k),name)
    s=spec["scenario"]
    param(setup,"Duration",s["duration_seconds"])
    g=group_for(start,"ControlParameters")
    param(g,"InterTriggerTimer",s["interval_seconds"])
    param(g,"TriggerCount",s["count"],"NumericParameter")
    for k,n in nodes.items():
        if n["kind"]=="task": param(group_for(k,"TimeParameters"),"ProcessingTime",n["seconds"])
    for f in spec["flows"]:
        if "probability" in f: param(group_for(f["id"],"ControlParameters"),"Probability",f["probability"])
    out.mkdir(parents=True,exist_ok=False)
    for tree,name in ((root,"process.xmi"),(doc,"scenario.bpsim.xml")):
        ET.indent(tree)
        ET.ElementTree(tree).write(out/name,encoding="utf-8",xml_declaration=True)
    (out/"accepted.json").write_text(json.dumps(spec,indent=2)+"\n",encoding="utf-8")

def propose(path, model, out):
    key=os.environ.get("OPENROUTER_API_KEY")
    require(bool(key),"Set OPENROUTER_API_KEY in your local environment")
    prompt=PROMPT.read_bytes()
    text=path.read_text(encoding="utf-8")
    data={"model":model,"temperature":0,"response_format":{"type":"json_object"},
          "messages":[{"role":"system","content":prompt.decode()},
                      {"role":"user","content":text}]}
    req=Request("https://openrouter.ai/api/v1/chat/completions",json.dumps(data).encode(),
                {"Authorization":"Bearer "+key,"Content-Type":"application/json"})
    try:
        with urlopen(req,timeout=90) as response: packet=json.load(response)
    except HTTPError as e:
        raise ValueError(f"OpenRouter returned HTTP {e.code}; check model, access and JSON output support") from e
    raw=packet["choices"][0]["message"]["content"]
    require(isinstance(raw,str),"Provider returned no textual proposal")
    out.mkdir(parents=True,exist_ok=False)
    (out/"proposed.json").write_text(raw+"\n",encoding="utf-8")
    (out/"metadata.json").write_text(json.dumps({"provider":"OpenRouter","requested_model":model,
        "reported_model":packet.get("model"),"response_id":packet.get("id"),
        "temperature":0,"prompt_sha256":hashlib.sha256(prompt).hexdigest(),
        "input_sha256":hashlib.sha256(text.encode()).hexdigest()},indent=2)+"\n",encoding="utf-8")
    validate(parse(raw))

def main():
    p=argparse.ArgumentParser(description=__doc__)
    sub=p.add_subparsers(dest="cmd",required=True)
    q=sub.add_parser("propose"); q.add_argument("text",type=Path); q.add_argument("--model",required=True); q.add_argument("--out",type=Path,required=True)
    q=sub.add_parser("export"); q.add_argument("reviewed",type=Path); q.add_argument("--out",type=Path,required=True)
    q.add_argument("--seed",type=int,default=1);q.add_argument("--replications",type=int,default=1)
    a=p.parse_args()
    if a.cmd=="propose": propose(a.text,a.model,a.out)
    else: compile_models(parse(a.reviewed.read_text(encoding="utf-8")),a.out,a.seed,a.replications)

if __name__=="__main__":
    try: main()
    except (ValueError,OSError,KeyError,IndexError,TypeError) as exc:
        sys.exit(str(exc))
