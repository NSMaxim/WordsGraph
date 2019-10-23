package com.test;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterGraph implements Graph {

    private Logger log = Logger.getLogger(getClass().getName());

    private Map<Vertex, List<Vertex>> characterGraph = new HashMap<>();

    public Map<Vertex, List<Vertex>> getGraph() {
        return characterGraph;
    }

    public void addVertex(Vertex vertex) {
        log.debug(String.format("Adding %s", vertex.toString()));
        characterGraph.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        log.debug(String.format("Adding edge for %s and %s", vertex1.toString(), vertex2.toString()));

        characterGraph.putIfAbsent(vertex1, new ArrayList<>());
        characterGraph.putIfAbsent(vertex2, new ArrayList<>());

        characterGraph.get(vertex1).add(vertex2);
        characterGraph.get(vertex2).add(vertex1);
    }

    public List<Vertex> getRelatedVertex(Vertex vertex) {
        if (characterGraph.get(vertex) == null) {
            throw new IllegalArgumentException(String.format("Failed to find %s in graph", vertex.toString()));
        }
        return characterGraph.get(vertex);
    }

    @Override
    public String toString() {
        return "CharacterGraph{" +
                "characterGraph=" + characterGraph +
                '}';
    }

}
