package com.rvm.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CloneGraph {
    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Node, Node> memo = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (memo.get(node) != null) {
            return memo.get(node);
        }
        ArrayList<Node> _neighbors = new ArrayList<>();
        System.out.println(node.val);
        Node clonedNode = new Node(node.val, _neighbors);
        memo.put(node, clonedNode);
        for (Node neighbor : node.neighbors) {
            _neighbors.add(cloneGraph(neighbor));
            System.out.println(neighbor.val);
        }
        return clonedNode;
    }
}