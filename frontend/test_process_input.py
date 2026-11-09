from copy import deepcopy
import json
from pathlib import Path
import tempfile
import unittest
import xml.etree.ElementTree as ET

from process_input import BPSIM, compile_models, parse

HERE=Path(__file__).resolve().parent

class ExportTest(unittest.TestCase):
    def setUp(self):
        self.spec=json.loads((HERE/"manufacturing.reviewed.json").read_text())
        self.tmp=tempfile.TemporaryDirectory()
        self.addCleanup(self.tmp.cleanup)
        self.out=Path(self.tmp.name)/"out"

    def test_flow_association_and_schedule(self):
        # Permuting outgoing flow order does not permute destination probabilities.
        self.spec["flows"].reverse()
        compile_models(self.spec,self.out,3001,311)
        x=ET.parse(self.out/"process.xmi")
        flows={e.get("id"):e for e in x.findall(".//flowElements")}
        self.assertEqual(flows["InspectBranch"].get("outgoing"),"failed passed")
        self.assertEqual(flows["retry"].get("targetRef"),"InspectionServer")
        b=ET.parse(self.out/"scenario.bpsim.xml")
        ns={"b":BPSIM}
        cfg=b.find(".//b:ScenarioParameters",ns)
        self.assertEqual((cfg.get("seed"),cfg.get("replication")),("3001","311"))
        self.assertEqual(cfg.find(".//b:FloatingParameter",ns).get("value"),"72000")
        for k,v in [("passed","0.8"),("failed","0.2")]:
            elt=b.find(f".//b:ElementParameters[@elementRef='{k}']//b:Probability/b:FloatingParameter",ns)
            self.assertEqual(elt.get("value"),v)
        g=b.find(".//b:InterTriggerTimer/b:FloatingParameter",ns)
        self.assertEqual(g.get("value"),"600")

    def test_blocked_and_incomplete_inputs_do_not_export(self):
        partial=deepcopy(self.spec)
        del partial["flows"][2]["probability"]
        for candidate in (partial,
                          {"status":"needs_clarification","issues":["What is the rework time?"]},
                          {"status":"unsupported","issues":["Visit-dependent routing"]}):
            with self.assertRaises(ValueError):
                compile_models(candidate,self.out,1,1)
            self.assertFalse(self.out.exists())

    def test_duplicate_json_key(self):
        with self.assertRaisesRegex(ValueError,"Duplicate JSON field"):
            parse('{"status":"ready","status":"unsupported"}')

if __name__=="__main__":
    unittest.main()
