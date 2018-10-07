package net.learning.computerscience.algorithms.sorting.merge_sort;

import java.util.Arrays;

public class Solution {

    public static int[] mergeSort(int[] elements) {
        return divide(elements);
    }

    private static int[] divide(int[] elements) {
        int from = 0;
        int to = elements.length - 1;
        if ((to - from) <= 1) {
            return sort(elements);
        }
        int mid = (to - from) / 2;
        int[] first = divide(Arrays.copyOfRange(elements, from, mid + 1));
        int[] second = divide(Arrays.copyOfRange(elements, mid + 1, to + 1));
        return merge(first, second);
    }

    private static int[] merge(int[] first, int[] second) {
        int lastIndexFirst = first.length;
        int lastIndexSecond = second.length;
        int[] mergedElements = new int[lastIndexFirst + lastIndexSecond];
        for (int i = 0, j = 0; i < lastIndexFirst || j < lastIndexSecond; ) {
            int currentFirst = i < lastIndexFirst ? first[i] : Integer.MAX_VALUE;
            int currentSecond = j < lastIndexSecond ? second[j] : Integer.MAX_VALUE;
            mergedElements[i + j] = (currentFirst <= currentSecond) ? first[i++] : second[j++];
        }
        return mergedElements;
    }

    private static int[] sort(int[] elements) {
        if (elements.length < 2) {
            return elements;
        } else {
            if (elements[0] > elements[1]) {
                int temp = elements[0];
                elements[0] = elements[1];
                elements[1] = temp;
            }
            return elements;
        }
    }

}
