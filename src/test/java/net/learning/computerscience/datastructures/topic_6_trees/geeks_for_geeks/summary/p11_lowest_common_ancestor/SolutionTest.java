package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p11_lowest_common_ancestor;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lowestCommonAncestor() {
        int[] elements = {6,7,2,0,3,1,5,9,4,8,10};
        assertEquals(2, Solution.lowestCommonAncestor(elements, 5, 1));
    }

    @Test
    public void lowestCommonAncestor2() {
        int[] elements = {6,7,2,0,3,1,5,9,4,8,10};
        assertEquals(5, Solution.lowestCommonAncestor(elements, 5, 4));
    }

    @Test
    public void lowestCommonAncestor3() {
        int[] elements = {6,7,2,0,3,1,5,9,4,8,10};
        assertEquals(9, Solution.lowestCommonAncestor(elements, 8, 10));
    }

    @Test
    public void lowestCommonAncestor4() {
        int[] elements = {6,7,2,0,3,1,5,9,4,8,10};
        assertEquals(6, Solution.lowestCommonAncestor(elements, 4, 7));
    }

}