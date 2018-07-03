package net.learning.computerscience.datastructures.topic_7_graphs.p1_breadth_first_search;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    private int[][] graph;

    @Before
    public void setUp() {
        graph = new int[8][8];
        graph[0][3] = 1;
        graph[0][4] = 1;

        graph[1][2] = 1;
        graph[1][3] = 1;
        graph[1][5] = 1;
        graph[1][6] = 1;

        graph[2][1] = 1;
        graph[2][5] = 1;

        graph[3][0] = 1;
        graph[3][1] = 1;
        graph[3][7] = 1;

        graph[4][0] = 1;

        graph[5][1] = 1;
        graph[5][2] = 1;
        graph[5][6] = 1;

        graph[6][1] = 1;
        graph[6][5] = 1;

        graph[7][3] = 1;
    }

    @Test
    public void breadthFirstSearch() {
        assertThat(Solution.breadthFirstSearch(graph, 0), is(equalTo(Arrays.asList(0,3,4,1,7,2,5,6))));
    }

    @Test
    public void breadthFirstSearch2() {
        assertThat(Solution.breadthFirstSearch(graph, 4), is(equalTo(Arrays.asList(4,0,3,1,7,2,5,6))));
    }

    @Test
    public void breadthFirstSearch3() {
        assertThat(Solution.breadthFirstSearch(graph, 2), is(equalTo(Arrays.asList(2,1,5,3,6,0,7,4))));
    }

}