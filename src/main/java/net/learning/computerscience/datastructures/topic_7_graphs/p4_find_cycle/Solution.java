package net.learning.computerscience.datastructures.topic_7_graphs.p4_find_cycle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static boolean hasCycle(int[][] adjacencies) {
        Graph graph = new Graph(adjacencies);
        for (Node vertex : graph.vertices) {
            if (detectCycle(vertex)) return true;
        }
        return false;
    }

    private static boolean detectCycle(Node current) {
        if (current.isVisited()) return false;
        if (current.isBeingVisited()) return true;
        boolean hasCycle = false;
        current.setBeingVisited(true);
        for (Node adjacency : current.adjacencies) {
            hasCycle = detectCycle(adjacency);
            if (hasCycle) break;
        }
        current.setVisited(true);
        return hasCycle;
    }


}

class Graph {
    Node[] vertices;

    public Graph(int[][] adjacencies) {
        vertices = new Node[adjacencies.length];
        createGraph(adjacencies);
    }

    private void createGraph(int[][] adjacencies) {
        for (int i = 0; i < adjacencies.length; i++) {
            vertices[i] = vertices[i] == null ? new Node(i) : vertices[i];
            createAdjacencies(adjacencies[i], vertices[i]);
        }
    }

    private void createAdjacencies(int[] adjacencies, Node current) {
        for (int i = 0; i < adjacencies.length; i++) {
            if (adjacencies[i] == 1) {
                vertices[i] = vertices[i] == null ? new Node(i) : vertices[i];
                current.adjacencies.add(vertices[i]);
            }
        }
    }
}

class Node {
    int data;
    private boolean beingVisited;
    private boolean visited;
    List<Node> adjacencies;

    public Node(int data) {
        this.data = data;
        adjacencies = new ArrayList<>();
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "{" + data + "}";
    }
}