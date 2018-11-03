package net.learning.computerscience.datastructures.topic_7_graphs.p6_kruskals_minimum_spanning_tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void kruskalsMinimumSpanningTree1() {

        int[][] adjacencies = new int[][]{
            {0,2,6,0,5,10,0},
            {2,0,0,3,3,0,0},
            {6,0,0,1,0,2,0},
            {0,3,1,0,4,0,5},
            {5,3,0,4,0,0,0},
            {10,0,2,0,0,0,5},
            {0,0,0,5,0,5,0}
        };

        List<Edge> expectedSpanningTree = new ArrayList<>();
        expectedSpanningTree.add(new Edge(new Vertex('d'), new Vertex('c'), 1));
        expectedSpanningTree.add(new Edge(new Vertex('a'), new Vertex('b'), 2));
        expectedSpanningTree.add(new Edge(new Vertex('f'), new Vertex('c'), 2));
        expectedSpanningTree.add(new Edge(new Vertex('d'), new Vertex('b'), 3));
        expectedSpanningTree.add(new Edge(new Vertex('e'), new Vertex('b'), 3));
        expectedSpanningTree.add(new Edge(new Vertex('f'), new Vertex('g'), 5));

        List<Edge> actualSpanningTree = Solution.kruskalsMinimumSpanningTree(adjacencies);

        for (int i = 0; i < expectedSpanningTree.size(); i++) {
            assertEquals(expectedSpanningTree.get(i).getFirst().getName(),
                actualSpanningTree.get(i).getFirst().getName());
            assertEquals(expectedSpanningTree.get(i).getSecond().getName(),
                actualSpanningTree.get(i).getSecond().getName());
            assertEquals(expectedSpanningTree.get(i).getWeight(),
                actualSpanningTree.get(i).getWeight());
        }
    }
}