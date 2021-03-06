package net.learning.computerscience.datastructures.topic_7_graphs;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class CompleteGraph1Test {

    @Test
    public void graph1() {

        int[][] adjacencies = {
            {0,1,0,1,1,0,0,0},
            {1,0,0,1,0,1,0,0},
            {0,0,0,0,0,0,1,0},
            {1,1,0,0,0,0,0,0},
            {1,0,0,0,0,0,1,1},
            {0,1,0,0,0,0,0,1},
            {0,0,1,0,1,0,0,0},
            {0,0,0,0,1,1,0,0},
        };

        Graph actualGraph = CompleteGraph1.createGraph(adjacencies);
        assertEquals(asList(0,1,3,4,5,6,7,2), breadthFirstSearch(actualGraph, 0));

        actualGraph = CompleteGraph1.createGraph(adjacencies);
        assertEquals(asList(3,2,6,4,7,5,1,0), depthFirstSearch(actualGraph, 0));
    }

    @Test
    public void graph2() {

        int[][] adjacencies = {
            {0,1,0,1,1,0,0,0},
            {1,0,0,1,0,1,0,0},
            {0,0,0,0,0,0,1,0},
            {1,1,0,0,0,0,0,0},
            {1,0,0,0,0,0,1,1},
            {0,1,0,0,0,0,0,1},
            {0,0,1,0,1,0,0,0},
            {0,0,0,0,1,1,0,0},
        };

        Graph actualGraph = CompleteGraph1.createGraph(adjacencies);
        assertEquals(asList(2,6,4,0,7,1,3,5), breadthFirstSearch(actualGraph, 2));

        actualGraph = CompleteGraph1.createGraph(adjacencies);
        assertEquals(asList(3,7,5,1,0,4,6,2), depthFirstSearch(actualGraph, 2));
    }

    @Test
    public void graph3() {

        int[][] adjacencies = {
            {0,1,0,1,1,0,0,0},
            {1,0,0,1,0,1,0,0},
            {0,0,0,0,0,0,1,0},
            {1,1,0,0,0,0,0,0},
            {1,0,0,0,0,0,1,1},
            {0,1,0,0,0,0,0,1},
            {0,0,1,0,1,0,0,0},
            {0,0,0,0,1,1,0,0},
        };

        Graph actualGraph = CompleteGraph1.createGraph(adjacencies);
        assertEquals(asList(5,1,7,0,3,4,6,2), breadthFirstSearch(actualGraph, 5));

        actualGraph = CompleteGraph1.createGraph(adjacencies);
        assertEquals(asList(3,2,6,7,4,0,1,5), depthFirstSearch(actualGraph, 5));
    }

    private List<Integer> breadthFirstSearch(Graph graph, int startingPoint) {
        Node initial = graph.vertices[startingPoint];
        ArrayList<Integer> bfs = new ArrayList<>();
        ArrayDeque<Node> neighbors = new ArrayDeque<>();
        initial.setVisited(true);
        neighbors.push(initial);
        while (!neighbors.isEmpty()) {
            Node current = neighbors.pollLast();
            current.neighbors.stream().filter(neighbor -> !neighbor.isVisited())
                .forEach(neighbor -> {
                    neighbor.setVisited(true);
                    neighbors.push(neighbor);
                });
            bfs.add(current.data);
        }
        return bfs;
    }

    private List<Integer> depthFirstSearch(Graph graph, int startingPoint) {
        Node initial = graph.vertices[startingPoint];
        List<Integer> elements = new ArrayList<>();
        depthFirstSearch(initial, elements);
        return elements;
    }

    private void depthFirstSearch(Node current, List<Integer> elements) {
        current.setVisited(true);
        for (Node neighbor : current.neighbors) {
            if (!neighbor.isVisited()) {
                depthFirstSearch(neighbor, elements);
            }
        }
        elements.add(current.data);
    }

}