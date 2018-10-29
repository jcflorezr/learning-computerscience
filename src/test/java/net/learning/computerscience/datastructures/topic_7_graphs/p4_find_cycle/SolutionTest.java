package net.learning.computerscience.datastructures.topic_7_graphs.p4_find_cycle;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void hasCycle1() {
        int[][] adjacencies = new int[][]{
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0},
            {1,0,0,0,0,0,1,0},
            {0,1,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0},
            {0,0,0,1,0,0,0,1},
            {0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0}
        };
        assertTrue(Solution.hasCycle(adjacencies));
    }

    @Test
    public void hasCycle2() {
        int[][] adjacencies = new int[][]{
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,1,0},
            {0,1,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0},
            {0,0,0,1,0,0,0,1},
            {0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0}
        };
        assertFalse(Solution.hasCycle(adjacencies));
    }

    @Test
    public void hasCycle3() {
        int[][] adjacencies = new int[][]{
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,1,0},
            {0,1,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0},
            {0,0,0,1,0,0,0,1},
            {0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,1,0}
        };
        assertTrue(Solution.hasCycle(adjacencies));
    }

}