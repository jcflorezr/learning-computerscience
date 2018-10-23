package net.learning.computerscience.algorithms.backtracking.p1_rat_in_a_maze;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class SolutionTest {

    private char[][] maze;

    @Before
    public void setUp() {
        maze = new char[][]
        {
            {'o','o','o','o','x'},
            {'o','x','x','x','x'},
            {'o','o','o','o','x'},
            {'x','x','x','o','o'},
            {'o','o','o','o','x'},
        };
    }

    @Test
    public void getMazePath() {
        Deque<Pair> expectedPath = new ArrayDeque<>();
        expectedPath.addFirst(new Pair(0,0));
        expectedPath.addFirst(new Pair(1,0));
        expectedPath.addFirst(new Pair(2,0));
        expectedPath.addFirst(new Pair(2,1));
        expectedPath.addFirst(new Pair(2,2));
        expectedPath.addFirst(new Pair(2,3));
        expectedPath.addFirst(new Pair(3,3));
        expectedPath.addFirst(new Pair(4,3));
        expectedPath.addFirst(new Pair(4,2));
        expectedPath.addFirst(new Pair(4,1));
        expectedPath.addFirst(new Pair(4,0));

        Deque<Pair> actualPath = Solution.getMazePath(maze, new Pair(0, 0), new Pair(4, 0));

        while (expectedPath.peekFirst() != null) {
            assertEquals(expectedPath.pollFirst(), actualPath.pollFirst());
        }
        assertTrue(expectedPath.isEmpty() && actualPath.isEmpty());
    }

    @Test
    public void getMazePath2() {
        Deque<Pair> expectedPath = new ArrayDeque<>();
        expectedPath.addFirst(new Pair(3,4));
        expectedPath.addFirst(new Pair(3,3));
        expectedPath.addFirst(new Pair(2,3));
        expectedPath.addFirst(new Pair(2,2));
        expectedPath.addFirst(new Pair(2,1));
        expectedPath.addFirst(new Pair(2,0));
        expectedPath.addFirst(new Pair(1,0));
        expectedPath.addFirst(new Pair(0,0));

        Deque<Pair> actualPath = Solution.getMazePath(maze, new Pair(3, 4), new Pair(0, 0));

        while (expectedPath.peekFirst() != null) {
            assertEquals(expectedPath.pollFirst(), actualPath.pollFirst());
        }
        assertTrue(expectedPath.isEmpty() && actualPath.isEmpty());
    }

    @Test
    public void getMazePath3() {
        Deque<Pair> expectedPath = new ArrayDeque<>();
        expectedPath.addFirst(new Pair(2,0));
        expectedPath.addFirst(new Pair(2,1));
        expectedPath.addFirst(new Pair(2,2));
        expectedPath.addFirst(new Pair(2,3));
        expectedPath.addFirst(new Pair(3,3));
        expectedPath.addFirst(new Pair(4,3));

        Deque<Pair> actualPath = Solution.getMazePath(maze, new Pair(2, 0), new Pair(4, 3));

        while (expectedPath.peekFirst() != null) {
            assertEquals(expectedPath.pollFirst(), actualPath.pollFirst());
        }
        assertTrue(expectedPath.isEmpty() && actualPath.isEmpty());
    }

    @Test
    public void getMazePath4() {
        Deque<Pair> expectedPath = new ArrayDeque<>();
        expectedPath.addFirst(new Pair(0,3));
        expectedPath.addFirst(new Pair(0,2));
        expectedPath.addFirst(new Pair(0,1));
        expectedPath.addFirst(new Pair(0,0));
        expectedPath.addFirst(new Pair(1,0));
        expectedPath.addFirst(new Pair(2,0));
        expectedPath.addFirst(new Pair(2,1));
        expectedPath.addFirst(new Pair(2,2));
        expectedPath.addFirst(new Pair(2,3));
        expectedPath.addFirst(new Pair(3,3));
        expectedPath.addFirst(new Pair(4,3));
        expectedPath.addFirst(new Pair(4,2));
        expectedPath.addFirst(new Pair(4,1));
        expectedPath.addFirst(new Pair(4,0));

        Deque<Pair> actualPath = Solution.getMazePath(maze, new Pair(0, 3), new Pair(4, 0));

        while (expectedPath.peekFirst() != null) {
            assertEquals(expectedPath.pollFirst(), actualPath.pollFirst());
        }
        assertTrue(expectedPath.isEmpty() && actualPath.isEmpty());
    }
}