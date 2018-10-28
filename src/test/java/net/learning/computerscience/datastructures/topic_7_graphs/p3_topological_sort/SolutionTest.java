package net.learning.computerscience.datastructures.topic_7_graphs.p3_topological_sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class SolutionTest {

    private int[][] dependencies;

    @Before
    public void setUp() {
        dependencies = new int[][]{
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,1},
            {0,0,0,0,0,1,0,0,1},
            {0,0,1,0,0,1,0,0,0},
            {0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,1,0,0}
        };
    }

    @Test
    public void topologicalSort1() {
        Deque<Node> expectedOrder = new ArrayDeque<>();
        expectedOrder.addLast(new Node("socks"));
        expectedOrder.addLast(new Node("shorts"));
        expectedOrder.addLast(new Node("pants"));
        expectedOrder.addLast(new Node("shoes"));
        expectedOrder.addLast(new Node("shirt"));
        expectedOrder.addLast(new Node("belt"));
        expectedOrder.addLast(new Node("tie"));
        expectedOrder.addLast(new Node("jacket"));
        expectedOrder.addLast(new Node("watch"));
        Deque<Node> actualOrder = Solution.topologicalSort(dependencies, 0);
        assertEquals(expectedOrder.size(), actualOrder.size());
        while (!actualOrder.isEmpty()) {
            assertEquals(expectedOrder.pop().getGarment(), actualOrder.pop().getGarment());
        }
    }

    @Test
    public void topologicalSort2() {
        Deque<Node> expectedOrder = new ArrayDeque<>();
        expectedOrder.addLast(new Node("shorts"));
        expectedOrder.addLast(new Node("pants"));
        expectedOrder.addLast(new Node("shirt"));
        expectedOrder.addLast(new Node("watch"));
        expectedOrder.addLast(new Node("belt"));
        expectedOrder.addLast(new Node("socks"));
        expectedOrder.addLast(new Node("shoes"));
        expectedOrder.addLast(new Node("tie"));
        expectedOrder.addLast(new Node("jacket"));
        Deque<Node> actualOrder = Solution.topologicalSort(dependencies, 4);
        assertEquals(expectedOrder.size(), actualOrder.size());
        while (!actualOrder.isEmpty()) {
            assertEquals(expectedOrder.pop().getGarment(), actualOrder.pop().getGarment());
        }
    }

    @Test
    public void topologicalSort3() {
        Deque<Node> expectedOrder = new ArrayDeque<>();
        expectedOrder.addLast(new Node("shorts"));
        expectedOrder.addLast(new Node("pants"));
        expectedOrder.addLast(new Node("shirt"));
        expectedOrder.addLast(new Node("tie"));
        expectedOrder.addLast(new Node("watch"));
        expectedOrder.addLast(new Node("belt"));
        expectedOrder.addLast(new Node("jacket"));
        expectedOrder.addLast(new Node("socks"));
        expectedOrder.addLast(new Node("shoes"));
        Deque<Node> actualOrder = Solution.topologicalSort(dependencies, 7);
        assertEquals(expectedOrder.size(), actualOrder.size());
        while (!actualOrder.isEmpty()) {
            assertEquals(expectedOrder.pop().getGarment(), actualOrder.pop().getGarment());
        }
    }
}