// layout-jaamsim.js - rewrite the notation coordinates inside Jaamsim.aird into a
// hierarchy-structured "layered" layout (a Sugiyama-style leveling).
//
// Background: the Eclipse Ecore diagram editor drops every box at the first free
// grid cell, producing an unreadable downward "staircase" that ignores the class
// hierarchy. Box positions live in the embedded GMF notation model:
//
//   <children xmi:type="notation:Node" ... type="2003" element="<DNodeList uid>">
//     ... <layoutConstraint xmi:type="notation:Bounds" ... x=".." y=".."/>
//
// Layout: inheritance depth -> column (x); within a depth band, classes are
// stacked top-to-bottom in DFS order so a parent's children stay contiguous.
// Only coordinates are rewritten; the rest of the .aird is preserved.
const fs = require('fs');
const path = require('path');
const AIRD  = path.join(__dirname, 'Jaamsim.aird');
const ECORE = path.join(__dirname, 'Jaamsim.ecore');

const BOX_W    = 300;   // rendered box width
const DEPTH_W  = 420;   // horizontal pitch between depth columns
const HEADER_H = 46;    // box header height
const LINE_H   = 16;    // px per feature row
const MIN_H    = 70;    // minimum box height
const ROW_GAP  = 46;    // vertical gap between boxes in a depth band
const ENUM_X   = -DEPTH_W;
const ENUM_Y   = 0;

let aird  = fs.readFileSync(AIRD, 'utf8');
const ecore = fs.readFileSync(ECORE, 'utf8');

// ---- 1. supertypes from the ecore ----
const sup = {};
{
  const re = /<eClassifiers xsi:type="ecore:EClass" name="([^"]+)"([^>]*)>/g;
  let m;
  while ((m = re.exec(ecore))) sup[m[1]] = (m[2].match(/eSuperTypes="#\/\/([^"]+)"/) || [])[1] || null;
}

// ---- 2. DNodeList descriptors: uid -> {name, kind, rows} ----
const dnl = {};
{
  const parts = aird.split('<ownedDiagramElements xmi:type="diagram:DNodeList"');
  for (let i = 1; i < parts.length; i++) {
    const c = parts[i];
    const uid  = (c.match(/^ uid="([^"]+)"/) || [])[1];
    const name = (c.match(/^ uid="[^"]+" name="([^"]*)"/) || [])[1];
    const km   = c.match(/<target xmi:type="ecore:(EEnum|EClass)"/);
    const rows = (c.match(/<ownedElements xmi:type="diagram:DNodeListElement"/g) || []).length;
    if (uid) dnl[uid] = { name, kind: km ? km[1] : null, rows };
  }
}

// ---- 3. notation box -> element(DNodeList) uid ----
const starts = [];
{
  const re = /<children xmi:type="notation:Node" xmi:id="([^"]+)" type="2003" element="([^"]+)">/g;
  let m;
  while ((m = re.exec(aird))) starts.push({ idx: m.index, el: m[2] });
}
const edgesIdx = aird.indexOf('<edges xmi:type="notation:Edge"');
const boundsEl = {};
for (let i = 0; i < starts.length; i++) {
  const end = i + 1 < starts.length ? starts[i + 1].idx : (edgesIdx > 0 ? edgesIdx : aird.length);
  const region = aird.slice(starts[i].idx, end);
  const bm = region.match(/<layoutConstraint xmi:type="notation:Bounds" xmi:id="([^"]+)" x="(-?\d+)" y="(-?\d+)"\/>\s*<\/children>/);
  if (bm) boundsEl[bm[1]] = starts[i].el;
}

// ---- 4. class forest ----
const uidOf = {};
for (const u in dnl) uidOf[dnl[u].name] = u;
const isClass = u => dnl[u] && dnl[u].kind === 'EClass';
const kids = {}, roots = [];
for (const u in dnl) {
  if (!isClass(u)) continue;
  const s = sup[dnl[u].name];
  const su = s ? uidOf[s] : undefined;
  if (su !== undefined && isClass(su)) (kids[su] = kids[su] || []).push(u);
  else roots.push(u);
}
function depth(u) { let d = 0, s = sup[dnl[u].name]; const seen = new Set();
  while (s && !seen.has(s)) { seen.add(s); d++; s = sup[s]; } return d; }
const boxH = u => Math.max(MIN_H, HEADER_H + dnl[u].rows * LINE_H);
const byName = (a, b) => dnl[a].name.localeCompare(dnl[b].name);

// ---- 5. DFS pre-order -> stable within-band ordering (children stay contiguous) ----
const order = [];
roots.sort(byName).forEach(function dfs(u) { order.push(u); (kids[u] || []).slice().sort(byName).forEach(dfs); });
const rank = {}; order.forEach((u, i) => rank[u] = i);

// ---- 6. layered placement ----
// x = depth column; y from a few barycenter iterations so parents sit level with
// their children (straight hierarchy edges) while boxes in a band never overlap.
const band = {};
for (const u of order) (band[depth(u)] = band[depth(u)] || []).push(u);
const maxD = Math.max(...order.map(depth));
const parentOf = {};
for (const u of order) { const s = sup[dnl[u].name]; const su = s ? uidOf[s] : undefined;
  if (su !== undefined && isClass(su)) parentOf[u] = su; }

// top-down single pass: each band is placed once, children centred on their
// already-placed parent, forward pass enforces ordering + min gap (no drift).
const y = {};
for (let d = 0; d <= maxD; d++) {
  const list = (band[d] || []).slice().sort((a, b) => rank[a] - rank[b]);
  const rowH = Math.max(...list.map(boxH)) + ROW_GAP;
  let prev = null;
  list.forEach((u, i) => {
    const pu = parentOf[u];
    let ty = (pu !== undefined && y[pu] !== undefined)
      ? y[pu] + (boxH(pu) - boxH(u)) / 2        // centre-align child to parent
      : i * rowH;                               // roots (and unparented)
    if (prev !== null) ty = Math.max(ty, y[prev] + boxH(prev) + ROW_GAP);
    y[u] = Math.round(ty);
    prev = u;
  });
}

const pos = {};
for (const u of order) pos[u] = { x: depth(u) * DEPTH_W, y: Math.round(y[u]), h: boxH(u) };
{
  let yy = ENUM_Y;
  for (const u in dnl) if (dnl[u].kind === 'EEnum') { pos[u] = { x: ENUM_X, y: yy, h: boxH(u) }; yy += boxH(u) + ROW_GAP; }
}

// ---- 7. rewrite only the matched Bounds (x,y + explicit w,h) ----
let changed = 0, missing = 0;
for (const bid in boundsEl) {
  const p = pos[boundsEl[bid]];
  if (!p) { missing++; continue; }
  const rx = new RegExp('(<layoutConstraint xmi:type="notation:Bounds" xmi:id="' + bid + '") x="-?\\d+" y="-?\\d+"(\\/>)');
  const before = aird;
  aird = aird.replace(rx, '$1 x="' + p.x + '" y="' + p.y + '" width="' + BOX_W + '" height="' + p.h + '"$2');
  if (aird !== before) changed++;
}
fs.writeFileSync(AIRD, aird, 'utf8');

let minx = Infinity, maxx = -Infinity, miny = Infinity, maxy = -Infinity;
for (const u in pos) { minx = Math.min(minx, pos[u].x); maxx = Math.max(maxx, pos[u].x + BOX_W);
  miny = Math.min(miny, pos[u].y); maxy = Math.max(maxy, pos[u].y + pos[u].h); }
console.log('notation boxes: ' + starts.length + ', repositioned: ' + changed + ', unmatched: ' + missing);
console.log('depth bands: ' + Object.keys(band).length + ', classes: ' + order.length);
console.log('canvas: ' + (maxx - minx) + ' x ' + (maxy - miny) + ' px  (x[' + minx + ',' + maxx + '] y[' + miny + ',' + maxy + '])');
