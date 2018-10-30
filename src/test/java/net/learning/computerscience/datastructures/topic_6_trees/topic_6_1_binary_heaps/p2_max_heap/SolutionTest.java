package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_binary_heaps.p2_max_heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getElementsFromMaxToMin() {
        Integer[] elements = {54,1,90,23,45,87,4,67,101,45,90,45};
        List<Integer> expected = Arrays.asList(101,90,90,87,67,54,45,45,45,23,4,1);
        List<Integer> actual = new ArrayList<>();
        MaxHeap<Integer> maxHeap = Solution.getElementsFromMaxToMin(elements);
        while (!maxHeap.isEmpty()) {
            actual.add(maxHeap.poll());
        }
        assertEquals(expected, actual);
        maxHeap = Solution.getElementsFromMaxToMin(elements);
        maxHeap.update(45, 55);
        expected = Arrays.asList(101,90,90,87,67,55,54,45,45,23,4,1);
        actual = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            actual.add(maxHeap.poll());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getElementsFromMaxToMin2() {
        Integer[] elements = {7,19,25,100,1,17,36,25,2,3};
        List<Integer> expected = Arrays.asList(100,36,25,25,19,17,7,3,2,1);
        List<Integer> actual = new ArrayList<>();
        MaxHeap<Integer> maxHeap = Solution.getElementsFromMaxToMin(elements);
        while (!maxHeap.isEmpty()) {
            actual.add(maxHeap.poll());
        }
        assertEquals(expected, actual);
        maxHeap = Solution.getElementsFromMaxToMin(elements);
        maxHeap.update(25, -5);
        expected = Arrays.asList(100,36,25,19,17,7,3,2,1,-5);
        actual = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            actual.add(maxHeap.poll());
        }
        assertEquals(expected, actual);
    }
}