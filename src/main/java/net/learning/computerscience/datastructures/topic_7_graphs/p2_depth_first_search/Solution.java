package net.learning.computerscience.datastructures.topic_7_graphs.p2_depth_first_search;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> depthFirstSearch(int[][] graphMatrix, int startingNodeIdx) {
        Graph graph = new Graph(graphMatrix.length);
        for (int[] row : graphMatrix) {
            graph.insertNode(row);
        }

        return null;
    }

}

class Graph {
    Node[] nodes;
    int currentKey;

    public Graph(int numNodes) {
        nodes = new Node[numNodes];
    }

    public void insertNode(int[] row) {
        if (nodes[currentKey] == null) {
            nodes[currentKey] = new Node(currentKey);
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                Node adjacentNode = nodes[i] != null ? nodes[i] : new Node(i);
                nodes[currentKey].setAdjacentNode(adjacentNode);
            }
        }
        currentKey++;
    }
}

class Node {
    private int data;
    private List<Node> adjacentNodes;
    private boolean visited;

    public Node(int data) {
        this.data = data;
        this.adjacentNodes = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNode(Node adjacentNode) {
        this.adjacentNodes.add(adjacentNode);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }
}