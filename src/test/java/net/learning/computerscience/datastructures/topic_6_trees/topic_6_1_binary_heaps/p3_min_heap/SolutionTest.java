package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_binary_heaps.p3_min_heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getElementsFromMinToMax1() {
        Integer[] elements = {54,1,90,23,45,87,4,67,101,45,90,45};
        List<Integer> expected = Arrays.asList(1,4,23,45,45,45,54,67,87,90,90,101);
        List<Integer> actual = new ArrayList<>();
        MinHeap<Integer> minHeap = Solution.getElementsFromMinToMax(elements);
        while (!minHeap.isEmpty()) {
            actual.add(minHeap.poll());
        }
        assertEquals(expected, actual);
        minHeap = Solution.getElementsFromMinToMax(elements);
        minHeap.update(45, 55);
        expected = Arrays.asList(1,4,23,45,45,54,55,67,87,90,90,101);
        actual = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            actual.add(minHeap.poll());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getElementsFromMinToMax2() {
        Integer[] elements = {7,19,25,100,1,17,36,25,2,3};
        List<Integer> expected = Arrays.asList(1,2,3,7,17,19,25,25,36,100);
        List<Integer> actual = new ArrayList<>();
        MinHeap<Integer> minHeap = Solution.getElementsFromMinToMax(elements);
        while (!minHeap.isEmpty()) {
            actual.add(minHeap.poll());
        }
        assertEquals(expected, actual);
        minHeap = Solution.getElementsFromMinToMax(elements);
        minHeap.update(25, -5);
        expected = Arrays.asList(-5,1,2,3,7,17,19,25,36,100);
        actual = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            actual.add(minHeap.poll());
        }
        assertEquals(expected, actual);
    }
}