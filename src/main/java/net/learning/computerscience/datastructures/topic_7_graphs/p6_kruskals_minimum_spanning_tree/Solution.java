package net.learning.computerscience.datastructures.topic_7_graphs.p6_kruskals_minimum_spanning_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static List<Edge> kruskalsMinimumSpanningTree(int[][] adjacencies) {
        Graph graph = new Graph(adjacencies);
        Queue<Edge> edges = saveEdges(graph);
        DisjointSets disjointSets = new DisjointSets(graph.vertices);
        return getMinimumSpanningTree(edges, disjointSets);
    }

    private static List<Edge> getMinimumSpanningTree(Queue<Edge> edges, DisjointSets disjointSets) {
        List<Edge> minimumEdges = new ArrayList<>();
        while (!edges.isEmpty()) {
            Edge currentEdge = edges.poll();
            Node vertexSet1 = disjointSets.getVertexSet(currentEdge.getFirst());
            Node vertexSet2 = disjointSets.getVertexSet(currentEdge.getSecond());
            if (!vertexSet1.equals(vertexSet2)) {
                disjointSets.union(vertexSet1, vertexSet2);
                minimumEdges.add(currentEdge);
            }
        }
        return minimumEdges;
    }

    private static Queue<Edge> saveEdges(Graph graph) {
        Queue<Edge> edgeQueue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        Deque<Vertex> vertexDeque = new ArrayDeque<>();
        vertexDeque.offer(graph.vertices[0]);
        while (!vertexDeque.isEmpty()) {
            Vertex current = vertexDeque.pollLast();
            current.setVisited();
            for (Neighbour neighbour : current.getNeighbours()) {
                Vertex pointedVertex = neighbour.getPointedVertex();
                if (!pointedVertex.isVisited()) {
                    edgeQueue.offer(new Edge(current, pointedVertex, neighbour.getWeight()));

                    vertexDeque.offer(pointedVertex);
                }
            }
        }
        return edgeQueue;
    }

}

class Edge {
    private Vertex first;
    private Vertex second;
    private int weight;

    public Edge(Vertex first, Vertex second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    public Vertex getFirst() {
        return first;
    }

    public Vertex getSecond() {
        return second;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "{" + first + " -> " + second + ", " + weight + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight &&
                Objects.equals(first, edge.first) &&
                Objects.equals(second, edge.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, weight);
    }
}

class Graph {
    Vertex[] vertices;

    public Graph(int[][] adjacencies) {
        vertices = new Vertex[adjacencies.length];
        createGraph(adjacencies);
    }

    private void createGraph(int[][] adjacencies) {
        for (int i = 0; i < adjacencies.length; i++) {
            vertices[i] = vertices[i] == null ? new Vertex((char) (i + 'a')) : vertices[i];
            createNeighbours(vertices[i], adjacencies[i]);
        }
    }

    private void createNeighbours(Vertex current, int[] neighbours) {
        for (int i = 0; i < neighbours.length; i++) {
            if (neighbours[i] > 0) {
                vertices[i] = vertices[i] == null ? new Vertex((char) (i + 'a')) : vertices[i];
                current.setNeighbour(new Neighbour(vertices[i], neighbours[i]));
            }
        }
    }
}

class Vertex {
    private Character name;
    private boolean isVisited;
    private List<Neighbour> neighbours;

    public Vertex(Character name) {
        this.name = name;
        neighbours = new ArrayList<>();
    }

    public Character getName() {
        return name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited() {
        isVisited = true;
    }

    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    public void setNeighbour(Neighbour neighbour) {
        this.neighbours.add(neighbour);
    }

    @Override
    public String toString() {
        return "(" + name + "," + isVisited + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return isVisited == vertex.isVisited &&
                Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isVisited);
    }
}

class Neighbour {
    private Vertex pointedVertex;
    private int weight;

    public Neighbour(Vertex pointedVertex, int weight) {
        this.pointedVertex = pointedVertex;
        this.weight = weight;
    }

    public Vertex getPointedVertex() {
        return pointedVertex;
    }

    public int getWeight() {
        return weight;
    }
}

class DisjointSets {
    private Map<Vertex, Node> elements;

    public DisjointSets(Vertex[] vertices) {
        elements = new HashMap<>();
        for (Vertex vertex : vertices) {
            // makeSet
            elements.put(vertex, new Node(vertex));
        }
    }

    public Node getVertexSet(Vertex vertex) {
        Node node = elements.get(vertex);
        return findRepresentative(node);
    }

    public void union(Node node1, Node node2) {
        Node representative1 = findRepresentative(node1);
        Node representative2 = findRepresentative(node2);
        if (!representative1.equals(representative2)) {
            representative2.setParent(representative1);
        }
    }

    private Node findRepresentative(Node node) {
        return (node == node.getParent()) ? node : findRepresentative(node.getParent());
    }

}

class Node {
    private Node parent;
    private Vertex vertex;

    public Node(Vertex vertex) {
        this.parent = this;
        this.vertex = vertex;
    }

    public Node(Node parent, Vertex vertex) {
        this.parent = parent;
        this.vertex = vertex;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node newParent) {
        this.parent = newParent;
    }
}