package com.test;

import java.util.List;
import java.util.Map;

public interface Graph {

    Map<Vertex, List<Vertex>> getGraph();

    void addVertex(Vertex vertex);

    void addEdge(Vertex vertex1, Vertex vertex2);

    List<Vertex> getRelatedVertex(Vertex vertex);

}
