package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_binary_heaps.p3_min_heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getElementsFromMinToMax1() {
        int[] elements = {54,1,90,23,45,87,4,67,101,45,90,45};
        List<Integer> expected = Arrays.asList(1,4,23,45,45,45,54,67,87,90,90,101);
        assertEquals(expected, Solution.getElementsFromMinToMax(elements));
    }

    @Test
    public void getElementsFromMinToMax2() {
        int[] elements = {7,19,25,100,1,17,36,25,2,3};
        List<Integer> expected = Arrays.asList(1,2,3,7,17,19,25,25,36,100);
        assertEquals(expected, Solution.getElementsFromMinToMax(elements));
    }
}