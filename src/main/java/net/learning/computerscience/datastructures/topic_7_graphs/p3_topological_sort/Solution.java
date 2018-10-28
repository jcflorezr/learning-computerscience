package net.learning.computerscience.datastructures.topic_7_graphs.p3_topological_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public static Deque<Node> topologicalSort(int[][] dependencies, int initial) {
        Graph graph = new Graph(dependencies);
        Deque<Node> order = new ArrayDeque<>();
        for (int i = 0; i < graph.nodes.length; i++) {
            int curIdx = (initial + i) % graph.nodes.length;
            topologicalSort(graph.nodes[curIdx], order);
        }
        return order;
    }

    private static void topologicalSort(Node current, Deque<Node> order) {
        if (current.isVisited()) return;
        for (Node dependency : current.dependencies) {
            topologicalSort(dependency, order);
        }
        order.push(current);
        current.setVisited(true);
    }

}

class Graph {
    Node[] nodes;
    private String[] garments = {"watch", "shirt", "pants", "shorts", "tie", "shoes", "jacket", "socks", "belt"};

    public Graph(int[][] dependencies) {
        this.nodes = new Node[dependencies.length];
        createGraph(dependencies);
    }

    private void createGraph(int[][] dependencies) {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = nodes[i] == null ? new Node(garments[i]) : nodes[i];
            insertDependencies(nodes[i], dependencies[i]);
        }
    }

    private void insertDependencies(Node current, int[] currentDependencies) {
        for (int i = 0; i < currentDependencies.length; i++) {
            if (currentDependencies[i] == 1) {
                nodes[i] = nodes[i] == null ? new Node(garments[i]) : nodes[i];
                current.dependencies.add(nodes[i]);
            }
        }
    }
}

class Node {
    private String garment;
    private boolean visited;
    List<Node> dependencies;

    public Node(String garment) {
        this.garment = garment;
        dependencies = new ArrayList<>();
    }

    public String getGarment() {
        return garment;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "{" + garment + "}";
    }
}
