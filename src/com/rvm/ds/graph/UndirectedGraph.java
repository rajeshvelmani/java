package com.rvm.ds.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void bfs(int startNode) {
        boolean visited[] = new boolean[this.nodes];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        queue.offer(startNode);
        sb.append("==> BFS <== \n"); //no i18n

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            sb.append("==> ").append(node);
            for (int adjNode : this.adjMatrix[node]) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    queue.offer(adjNode);
                }
            }
        }

        System.out.println(sb.toString());
    }

    public void dfs(int startNode) {
        boolean visited[] = new boolean[this.nodes];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        stack.push(startNode);
        sb.append("==> DFS <== \n");  //no i18n
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                sb.append("==> ").append(node);
                for (int adjNode : this.adjMatrix[node]) {
                    if (!visited[adjNode]) {
                        stack.push(adjNode);
                    }
                }
            }
        }
        
        System.out.println(sb.toString());

    }

    public void dfsR(){
        boolean[] visited = new boolean[this.nodes];
        int[] compIdArr = new int[this.nodes];
        int currentCompId = 0;
        System.out.println("***** DFS Recursive *****");
        for(int i =0 ; i < this.nodes; i++){
            if(!visited[i]){
                dfsR(i, visited, currentCompId, compIdArr);
                currentCompId++;
            }
        }
        System.out.println();
        System.out.println("*** Components ***");

        for(int i =0 ; i < this.nodes; i++){
            System.out.print(i);
        }
        System.out.println();
        for(int i =0 ; i < this.nodes; i++){
            System.out.print(compIdArr[i]);
        }
        System.out.println();
    }

    private void dfsR(int node, boolean[] visited, int currentCompId, int[] compIdArr){
        visited[node] =true;
        System.out.print(" -> " + node);
        compIdArr[node] = currentCompId;
        for(int adjNode : adjMatrix[node]){
            if(!visited[adjNode]){
                dfsR(adjNode, visited, currentCompId, compIdArr);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nodes : ").append(this.nodes).append("\n");
        sb.append("edges : ").append(this.edges).append("\n");

        for (int i = 0; i < this.nodes; i++) {
            sb.append(" ==> ").append(i).append(" :");
            for (int j : this.adjMatrix[i]) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(6);
        /*
        graph.addEdge(3, 0);
        graph.addEdge(0, 1);


        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        graph.addEdge(1, 2);
        */

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);

        graph.addEdge(2, 4);

        System.out.println(graph.toString());

        // bfs
        graph.bfs(0);

        // dfs
        graph.dfs(0);


        // dfs recursive
        graph.dfsR();
    }

}
