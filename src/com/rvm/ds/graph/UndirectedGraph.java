package com.rvm.ds.graph;

import java.util.LinkedList;

/*
 * 
 */
public class UndirectedGraph {

    private LinkedList<Integer>[] adjMatrix;
    private int nodes;
    private int edges;

    public UndirectedGraph(int nodes) {
        this.nodes = nodes;
        this.edges = 0;
        this.adjMatrix = new LinkedList[nodes];

        for (int i = 0; i < nodes; i++) {
            this.adjMatrix[i] = new LinkedList<>();
        }
    }

    public void addEdge(int nodeA, int nodeB) {
        this.adjMatrix[nodeA].add(nodeB);
        this.adjMatrix[nodeB].add(nodeA);
        this.edges++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nodes : ").append(this.nodes).append("\n");
        sb.append("edges : ").append(this.edges).append("\n");

        sb.append("\n");

        for (int i = 0; i < this.nodes; i++) {
            sb.append(" ==> ");
            for (int j : this.adjMatrix[i]) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        System.out.print(graph.toString());
    }

}
