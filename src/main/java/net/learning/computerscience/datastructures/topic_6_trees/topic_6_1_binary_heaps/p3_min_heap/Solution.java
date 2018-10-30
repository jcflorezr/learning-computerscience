package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_binary_heaps.p3_min_heap;

public class Solution {

    public static <T extends Comparable<T>> MinHeap<T> getElementsFromMinToMax(T[] elements) {
        MinHeap<T> minHeap = new MinHeap(elements[0].getClass(), elements.length);
        for (T element : elements) {
            minHeap.insert(element);
        }
        return minHeap;
    }

}

