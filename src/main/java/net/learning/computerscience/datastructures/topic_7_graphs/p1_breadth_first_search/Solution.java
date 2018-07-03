package net.learning.computerscience.datastructures.topic_7_graphs.p1_breadth_first_search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> breadthFirstSearch(int[][] graphMatrix, int startingNodeIdx) {
        Graph graph = new Graph(graphMatrix.length);
        for (int[] row : graphMatrix) {
            graph.insertNode(row);
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        Node startingNode = graph.getStartingNode(startingNodeIdx);
        queue.push(startingNode);
        List<Integer> bfsElements = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node currentNode = queue.pollLast();
            for (Node adjacentNode : currentNode.getAdjacentNodes()) {
                if (!adjacentNode.isVisited()) {
                    queue.push(adjacentNode);
                }
            }
            if (!currentNode.isVisited()) {
                bfsElements.add(currentNode.getData());
                currentNode.setVisited();
            }
        }
        return bfsElements;
    }

}

class Graph {
    private Node[] nodes;
    private int currentKey;

    public Graph(int length) {
        nodes = new Node[length];
    }

    public void insertNode(int[] adjacencyNodes) {
        if (nodes[currentKey] == null) {
            nodes[currentKey] = new Node(currentKey);
        }
        for (int i = 0; i < adjacencyNodes.length; i++) {
            if (adjacencyNodes[i] != 1) continue;
            if (nodes[i] == null) {
                nodes[i] = new Node(i);
            }
            nodes[currentKey].setAdjacentNodes(nodes[i]);
        }
        currentKey++;
    }

    public Node getStartingNode(int startingNode) {
        return nodes[startingNode];
    }
}

class Node {
    private int data;
    private boolean visited;
    private List<Node> adjacentNodes;

    public Node(int data) {
        this.data = data;
        adjacentNodes = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        visited = true;
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Node adjacentNode) {
        adjacentNodes.add(adjacentNode);
    }
}
