package com.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordsMakerTest {

    private CharacterGraph characterGraph = CharacterGraphTest.createTestGraph();
    private WordsMaker wordsMaker = new WordsMaker(characterGraph);

    @Test
    public void getAllCombinationsForAVertex() {
        Vertex startVert = new Vertex(7, 'c');

        assertEquals("[cpoproc, cporpn, cpopr, cpoprn, cpopro, cpopn, cporp, cco, cpooc, ccoop, ccoor, ccoopr, ccorpn, cpop, cc, cpo, cpoo, ccooprn, ccoopn, cporoc, ccorn, ccoorn, ccorp, cp, ccor, ccoo, cpoc, cporo, cporn, cpor]", wordsMaker.getAllPossibleWordsForVertex(startVert).toString());
        assertEquals(30, wordsMaker.getAllPossibleWordsForVertex(startVert).size());
        assertEquals(wordsMaker.getAllPossibleWordsForVertex(startVert), wordsMaker.getAllPossibleWordsForVertex(startVert));
    }

    @Test
    public void getAllCombinationsForGraph() {
        assertEquals("[pr, oprop, popc, popn, popo, ccpopn, nprocc, cco, popro, ccp, poprn, oproc, nropc, orocc, poropc, npopoc, ccooprn, pooc, oorn, nropo, nroocc, popcc, opcc, ccpopr, rn, ro, rp, cporpn, poc, poro, porp, poropcc, ccporn, porn, pop, ccpop, poo, por, ccpor, rpopoc, cc, co, cp, ccor, ccoo, popocc, ccpo, oocc, popr, npropcc, nrooc, ooc, cpopr, cpoprn, ropocc, cpopro, nproc, cpopn, nrocc, oop, oor, nprop, nrop, nroo, propcc, ooprn, ropoc, oopcc, opc, ccoopn, rpop, rpoo, nroc, pocc, porocc, pro, opn, prn, opo, opr, poproc, oroc, ropc, cporp, ropo, npopcc, pcc, ccoopr, rooc, orn, ccoorn, orp, npo, oro, poocc, npr, cporo, cporn, nporopc, ropcc, cooprn, occ, npop, npoo, npoocc, coopc, orpn, npor, nropoc, ccorpn, cpop, cpoo, porop, nro, ccorn, ccorp, cpoc, orop, poroc, cpor, propc, opoc, npro, npopocc, cpooc, prop, coorn, opropcc, coor, proc, coopr, coop, coopn, rocc, copc, oprocc, cpoproc, oropcc, coo, corp, cop, corn, cor, nropocc, oropc, ccoop, procc, ccoor, nporocc, rpoocc, opropc, cpo, corpn, npropc, nporo, nporoc, cporoc, poprocc, ccpoprn, popoc, np, npooc, nr, roc, roocc, rpopo, porpn, rop, roo, oc, nporop, oopr, rpopcc, opocc, rpopc, oo, op, npopc, or, rpopocc, oopc, oprn, oopn, nropcc, opro, npopo, rpo, rpn, pc, nporopcc, pn, rpooc, po]", wordsMaker.getAllPossibleWordsForGraph().toString());
        assertEquals(193, wordsMaker.getAllPossibleWordsForGraph().size());
    }

    @Test
    public void checkWordsAccordingToVocabulary() {
        assertEquals("[porn, pop, corp, cop, corn]", wordsMaker.wordsFromVocabulary().toString());
    }

}

