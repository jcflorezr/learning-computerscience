package net.learning.computerscience.algorithms.backtracking.p2_n_queens_problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void placeQueens() {
        Pair[] expectedPositions = {
            new Pair(0,0),
            new Pair(4,1),
            new Pair(7,2),
            new Pair(5,3),
            new Pair(2,4),
            new Pair(6,5),
            new Pair(1,6),
            new Pair(3,7)
        };
        Pair[] actualPositions = Solution.placeQueens(expectedPositions.length);
        assertArrayEquals(expectedPositions, actualPositions);
    }

    @Test
    public void placeQueens2() {
        Pair[] expectedPositions = {
                new Pair(1,0),
                new Pair(3,1),
                new Pair(0,2),
                new Pair(2,3)
        };
        Pair[] actualPositions = Solution.placeQueens(expectedPositions.length);
        assertArrayEquals(expectedPositions, actualPositions);
    }

    @Test
    public void placeQueens3() {
        Pair[] expectedPositions = {
                new Pair(0,0),
                new Pair(2,1),
                new Pair(4,2),
                new Pair(1,3),
                new Pair(3,4)
        };
        Pair[] actualPositions = Solution.placeQueens(expectedPositions.length);
        assertArrayEquals(expectedPositions, actualPositions);
    }

    @Test
    public void placeQueens4() {
        Pair[] expectedPositions = {
                new Pair(1,0),
                new Pair(3,1),
                new Pair(5,2),
                new Pair(0,3),
                new Pair(2,4),
                new Pair(4,5)
        };
        Pair[] actualPositions = Solution.placeQueens(expectedPositions.length);
        assertArrayEquals(expectedPositions, actualPositions);
    }
}