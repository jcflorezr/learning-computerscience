package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_binary_heaps.p2_max_heap;

public class Solution {

    public static <T extends Comparable<T>> MaxHeap<T> getElementsFromMaxToMin(T[] elements) {
        MaxHeap<T> maxHeap = new MaxHeap(elements[0].getClass(), elements.length);
        for (T element : elements) {
            maxHeap.insert(element);
        }
        return maxHeap;
    }

}

