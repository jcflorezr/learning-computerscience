package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_binary_heaps.p2_max_heap;

import java.lang.reflect.Array;

public class MaxHeap<T extends Comparable<T>> {

    private int currentIndex = -1;
    private T[] heapElements;

    public MaxHeap(Class<T> clazz, int numOfElements) {
        this.heapElements = (T[]) Array.newInstance(clazz, numOfElements);
    }

    public void insert(T element) {
        if (++currentIndex == heapElements.length) {
            throw new RuntimeException("MinHeap is already full");
        }
        heapElements[currentIndex] = element;
        heapify();
    }

    public void update(int index, T element, T newElement) {
        if (element.equals(newElement)) return;
        if (!element.equals(heapElements[index])) {
            throw new RuntimeException("element " + element + " was not found in the Heap");
        }
        heapElements[index] = newElement;
        heapifyDown(index);
    }

    public void update(T element, T newElement) {
        if (element.equals(newElement)) return;
        int i = 0;
        for (; i < currentIndex; i++) {
            if (element.equals(heapElements[i])) {
                update(i, element, newElement);
                break;
            }
        }
        if (i == currentIndex) {
            throw new RuntimeException("element " + element + " was not found in the Heap");
        }
    }

    private void heapify() {
        heapify(currentIndex);
    }

    private void heapify(int index) {
        int parentIndex = (index % 2 == 0) ? (index / 2) - 1 : (index / 2);
        heapify(index, parentIndex);
    }

    private void heapify(int currentIndex, int parentIndex) {
        if (currentIndex == 0) return;
        T currentElement = heapElements[currentIndex];
        T parentElement = heapElements[parentIndex];
        if (currentElement.compareTo(parentElement) <= 0) return;
        T temp = heapElements[currentIndex];
        heapElements[currentIndex] = heapElements[parentIndex];
        heapElements[parentIndex] = temp;
        currentIndex = parentIndex;
        parentIndex = (currentIndex % 2 == 0) ? (currentIndex / 2) - 1 : (currentIndex / 2);
        heapify(currentIndex, parentIndex);
    }

    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("MinHeap is empty");
        }
        T maxElement = heapElements[0];
        heapElements[0] = heapElements[currentIndex];
        heapElements[currentIndex--] = null;
        heapifyDown(0);
        return maxElement;
    }

    private void heapifyDown(int currentIndex) {
        if (currentIndex >= this.currentIndex) return;
        T current = heapElements[currentIndex];
        int leftChildIndex = (2 * currentIndex) + 1;
        int rightChildIndex = (2 * currentIndex) + 2;
        T leftChild = leftChildIndex <= this.currentIndex ? heapElements[leftChildIndex] : current;
        T rightChild = rightChildIndex <= this.currentIndex ? heapElements[rightChildIndex] : current;

        T temp = current;
        if (current.compareTo(leftChild) < 0 || current.compareTo(rightChild) < 0) {
            if (leftChild.compareTo(rightChild) > 0) {
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
