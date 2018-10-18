package net.learning.computerscience.datastructures.topic_7_graphs;

import java.util.ArrayList;

public class CompleteGraph1 {

    public static Graph createGraph(int[][] adjacencies) {
        Graph graph = new Graph(adjacencies.length);
        for (int row = 0; row < adjacencies.length; row++) {
            for (int column = 0; column < adjacencies[row].length; column++) {
                if (adjacencies[row][column] == 1) {
                    graph.insertNode(row, column);
                }
            }
        }
        return graph;
    }

}

class Graph {
    Node[] vertices;

    public Graph(int size) {
        vertices = new Node[size];
    }

    void insertNode(int row, int column) {
        if (vertices[row] == null) {
            vertices[row] = new Node(row);
        }
        Node node = vertices[row];
        if (vertices[column] == null) {
            vertices[column] = new Node(column);
        }
        node.neighbors.add(vertices[column]);
    }
}

class Node {
    int data;
    boolean visited;
    ArrayList<Node> neighbors = new ArrayList<>();

    public Node(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        String s = this.data + " -> {";
        for (Node neighbor : neighbors) {
            s += neighbor.data + ",";
        }
        s += "}";
        return s;
    }
}