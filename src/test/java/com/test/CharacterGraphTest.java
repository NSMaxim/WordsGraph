package com.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CharacterGraphTest {

    private CharacterGraph characterGraph = new CharacterGraph();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        this.characterGraph = createTestGraph();
    }

    @Test
    public void baseGraphInit() {
        assertEquals(8, characterGraph.getGraph().size());
        assertEquals("[Vertex{id=1, character=o}, Vertex{id=5, character=o}, Vertex{id=7, character=c}]", characterGraph.getRelatedVertex(new Vertex(4, 'p')).toString());
        assertEquals("CharacterGraph{" +
                "characterGraph={" +
                "Vertex{id=0, character=p}=[Vertex{id=1, character=o}, Vertex{id=2, character=r}, Vertex{id=3, character=n}], " +
                "Vertex{id=2, character=r}=[Vertex{id=0, character=p}, Vertex{id=1, character=o}, Vertex{id=5, character=o}, Vertex{id=3, character=n}], " +
                "Vertex{id=5, character=o}=[Vertex{id=1, character=o}, Vertex{id=2, character=r}, Vertex{id=4, character=p}, Vertex{id=6, character=c}], " +
                "Vertex{id=3, character=n}=[Vertex{id=0, character=p}, Vertex{id=2, character=r}], " +
                "Vertex{id=4, character=p}=[Vertex{id=1, character=o}, Vertex{id=5, character=o}, Vertex{id=7, character=c}], " +
                "Vertex{id=7, character=c}=[Vertex{id=4, character=p}, Vertex{id=6, character=c}], " +
                "Vertex{id=6, character=c}=[Vertex{id=5, character=o}, Vertex{id=7, character=c}], " +
                "Vertex{id=1, character=o}=[Vertex{id=0, character=p}, Vertex{id=2, character=r}, Vertex{id=4, character=p}, Vertex{id=5, character=o}]}}", characterGraph.toString());
    }

    @Test
    public void testAddVertex() {
        Vertex vert = new Vertex(8, 'g');
        characterGraph.addVertex(vert);
        assertEquals(9, characterGraph.getGraph().size());
    }

    @Test
    public void testAddEdge() {
        Vertex vert1 = new Vertex(8, 'g');
        Vertex vert2 = new Vertex(9, 'f');
        characterGraph.addEdge(vert1, vert2);
        assertEquals(10, characterGraph.getGraph().size());
        assertEquals("[" + vert1.toString() + "]", characterGraph.getRelatedVertex(vert2).toString());
    }

    @Test
    public void getRelatedVertex_Exception() throws IllegalArgumentException {
        Vertex vert = new Vertex(72, 'c');

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Failed to find Vertex{id=72, character=c} in graph");
        characterGraph.getRelatedVertex(vert);
    }

    public static CharacterGraph createTestGraph() {
        CharacterGraph characterGraph = new CharacterGraph();

        Vertex vertP = new Vertex(0, 'p');
        Vertex vertO = new Vertex(1, 'o');
        Vertex vertR = new Vertex(2, 'r');
        Vertex vertN = new Vertex(3, 'n');
        Vertex vertP2 = new Vertex(4, 'p');
        Vertex vertO2 = new Vertex(5, 'o');
        Vertex vertC = new Vertex(6, 'c');
        Vertex vertC2 = new Vertex(7, 'c');

        characterGraph.addVertex(vertP);
        characterGraph.addVertex(vertO);
        characterGraph.addVertex(vertR);
        characterGraph.addVertex(vertN);
        characterGraph.addVertex(vertP2);
        characterGraph.addVertex(vertO2);
        characterGraph.addVertex(vertC);
        characterGraph.addVertex(vertC2);

        characterGraph.addEdge(vertP, vertO);
        characterGraph.addEdge(vertP, vertR);
        characterGraph.addEdge(vertP, vertN);
        characterGraph.addEdge(vertO, vertR);
        characterGraph.addEdge(vertO, vertP2);
        characterGraph.addEdge(vertO, vertO2);
        characterGraph.addEdge(vertR, vertO2);
        characterGraph.addEdge(vertR, vertN);
        characterGraph.addEdge(vertP2, vertO2);
        characterGraph.addEdge(vertP2, vertC2);
        characterGraph.addEdge(vertO2, vertC);
        characterGraph.addEdge(vertC, vertC2);
        return characterGraph;
    }

}


