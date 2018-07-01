package net.learning.computerscience.datastructures.topic_6_trees.topic_7_binary_heaps.p1_heapsort;

/**
 * https://www.geeksforgeeks.org/heap-sort/
 */
public class Solution {
    public static int[] heapSort(int[] elements) {
        Heap heap = new Heap(elements.length);
        for (int element : elements) {
            heap.insert(element);
        }
        int[] sortedElements = new int[elements.length];
        for (int i = sortedElements.length - 1; i >= 0; i--) {
            sortedElements[i] = heap.getElement();
        }
        return sortedElements;
    }
}

class Heap {
    private Integer[] elements;
    private int currentKey;
    private int lastKey;

    public Heap(int length) {
        elements = new Integer[length];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = Integer.MIN_VALUE;
        }
        lastKey = elements.length - 1;
    }

    public void insert(int element) {
        elements[currentKey] = element;
        heapify();
        currentKey++;
    }

    private void heapify() {
        int parentKey = getParentKey(currentKey);
        int key = currentKey;
        while ((parentKey < elements.length && key < elements.length) && elements[parentKey].compareTo(elements[key]) < 0) {
            key = swapToUp(parentKey, key);
            parentKey = getParentKey(key);
        }
    }

    private void heapifyToDown(int key) {
        int greaterChildKey = getGreaterChildKey(key);
        while ((greaterChildKey < lastKey + 1 && key < lastKey + 1) && elements[greaterChildKey].compareTo(elements[key]) > 0) {
            key = swapToDown(key, greaterChildKey);
            greaterChildKey = getGreaterChildKey(key);
        }
    }

    private int getGreaterChildKey(int key) {
        int leftChildKey = (key * 2) + 1;
        leftChildKey = leftChildKey > lastKey ? lastKey + 1 : leftChildKey;
        int rightChildKey = (key * 2) + 2;
        rightChildKey = rightChildKey > lastKey ? lastKey + 1 : rightChildKey;
        int greaterChildKey = elements[leftChildKey].compareTo(elements[rightChildKey]) > 0 ? leftChildKey : rightChildKey;
        return greaterChildKey < 0 ? 0 : greaterChildKey;
    }

    private int swapToDown(int parentKey, int currentKey) {
        return swap(parentKey, currentKey, true);
    }

    private int swapToUp(int parentKey, int currentKey) {
        return swap(parentKey, currentKey, false);
    }

    private int swap(int parentKey, int currentKey, boolean toDown) {
        int aux = elements[parentKey];
        elements[parentKey] = elements[currentKey];
        elements[currentKey] = aux;
        return toDown ? currentKey : parentKey;
    }

    private int getParentKey(int currentKey) {
        int parentKey = currentKey % 2 == 0 ? (currentKey / 2) - 1 : (currentKey / 2);
        return parentKey < 0 ? 0 : parentKey;
    }

    public int peek() {
        return elements[0];
    }

    public int getElement() {
        int element = elements[0];
        elements[0] = elements[lastKey];
        elements[lastKey] = Integer.MIN_VALUE;
        lastKey--;
        heapifyToDown(0);
        return element;
    }
}
