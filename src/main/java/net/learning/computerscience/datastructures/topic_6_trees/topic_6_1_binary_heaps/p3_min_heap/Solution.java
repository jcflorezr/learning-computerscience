package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_binary_heaps.p3_min_heap;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> getElementsFromMinToMax(int[] elements) {
        List<Integer> sortedElements = new ArrayList<>();
        Heap minHeap = new Heap(elements.length);
        for (int element : elements) {
            minHeap.insert(element);
        }
        while (!minHeap.isEmpty()) {
            sortedElements.add(minHeap.poll());
        }
        return sortedElements;
    }

}

class Heap {

    private int currentIndex = -1;
    private Integer[] heapElements;

    public Heap(int numOfElements) {
        this.heapElements = new Integer[numOfElements];
    }

    public void insert(int element) {
        if (++currentIndex == heapElements.length) {
            throw new RuntimeException("Heap is already full");
        }
        heapElements[currentIndex] = element;
        heapify();
    }

    private void heapify() {
        int parentIndex = (currentIndex % 2 == 0) ? (currentIndex / 2) - 1 : (currentIndex / 2);
        heapify(currentIndex, parentIndex);
    }

    private void heapify(int currentIndex, int parentIndex) {
        if (currentIndex == 0) return;
        int currentElement = heapElements[currentIndex];
        int parentElement = heapElements[parentIndex];
        if (currentElement >= parentElement) return;
        int temp = heapElements[currentIndex];
        heapElements[currentIndex] = heapElements[parentIndex];
        heapElements[parentIndex] = temp;
        currentIndex = parentIndex;
        parentIndex = (currentIndex % 2 == 0) ? (currentIndex / 2) - 1 : (currentIndex / 2);
        heapify(currentIndex, parentIndex);
    }

    public Integer poll() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        Integer maxElement = heapElements[0];
        heapElements[0] = heapElements[currentIndex];
        heapElements[currentIndex--] = null;
        heapifyDown(0);
        return maxElement;
    }

    private void heapifyDown(int currentIndex) {
        if (currentIndex >= this.currentIndex) return;
        int current = heapElements[currentIndex];
        int leftChildIndex = (2 * currentIndex) + 1;
        int rightChildIndex = (2 * currentIndex) + 2;
        Integer leftChild = leftChildIndex <= this.currentIndex ? heapElements[leftChildIndex] : Integer.MAX_VALUE;
        Integer rightChild = rightChildIndex <= this.currentIndex ? heapElements[rightChildIndex] : Integer.MAX_VALUE;

        int temp = current;
        if (current > leftChild || current > rightChild) {
            if (leftChild < rightChild) {
                heapElements[currentIndex] = leftChild;
                heapElements[leftChildIndex] = temp;
                heapifyDown(leftChildIndex);
            } else {
                heapElements[currentIndex] = rightChild;
                heapElements[rightChildIndex] = temp;
                heapifyDown(rightChildIndex);
            }
        }

    }

    public boolean isEmpty() {
        return currentIndex == -1;
    }
}

