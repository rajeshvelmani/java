package com.rvm.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0)
            return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> adjList = graph.get(prerequisites[i][0]);
            adjList.add(prerequisites[i][1]);
        }
        // System.out.println(graph);

        boolean[] visited = new boolean[numCourses];
        for (int[] prerequest : prerequisites) {
            if (!dfs(graph, prerequest[0], visited))
                return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        if (graph.get(node).isEmpty())
            return true;
        if (visited[node])
            return false;
        visited[node] = true;
        for (Integer adjnode : graph.get(node)) {
            if (!dfs(graph, adjnode, visited)) {
                // System.out.println(node + " _ " + adjnode);
                return false;
            }
        }
        // we are finishing visit to this node so we set it to false;
        visited[node] = false;
        // we are set empty list for since it dont have cyclic connection, so we not dfs
        // its adj node repeatedly
        graph.put(node, new ArrayList<>());
        // System.out.println(node);
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();

        int[][] prerequisites = {
                { 0, 1 },
                { 0, 2 },
                { 1, 3 },
                { 1, 4 },
                { 3, 4 }
        };
        boolean canFinish = courseSchedule.canFinish(5, prerequisites);
        System.out.println(canFinish);

        // int[][] prerequisites =;
        canFinish = courseSchedule.canFinish(20, new int[][] {
                { 0, 10 },
                { 3, 18 },
                { 5, 3 },
                { 11, 14 },
                { 3, 4 }
        });
        System.out.println(canFinish);
    }

}
