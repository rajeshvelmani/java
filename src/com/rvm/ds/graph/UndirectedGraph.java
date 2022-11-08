package com.rvm.ds.graph;

public class UndirectedGraph {

    private final int[][] adjMatrix;
    private final int nodes;
    private final int edges;

    public UndirectedGraph(int nodes) {
        this.nodes = nodes;
        this.edges = 0;
        this.adjMatrix = new int[nodes][nodes];
    }



}
