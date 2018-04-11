package net.learning.computerscience.datastructures.topic_1_arrays.geeks_for_geeks.set1_rotations.p11_find_minimum_in_sorted_and_rotated_array;

/**
 * http://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        System.out.println("minimum -- > " + findMinimum(arr, 0, arr.length - 1));

        arr = new int[]{5, 6, 1, 2, 3, 4};
        System.out.println("minimum -- > " + findMinimum(arr, 0, arr.length - 1));

        arr = new int[]{21, 6, 12, 15, 16, 17, 18, 19, 20};
        System.out.println("minimum -- > " + findMinimum(arr, 0, arr.length - 1));

        arr = new int[]{21, 22, 3, 6, 12, 15, 16, 17, 18, 19, 20};
        System.out.println("minimum -- > " + findMinimum(arr, 0, arr.length - 1));

        arr = new int[]{12, 15, 16, 17, 18, 19, 20, 21, 22};
        System.out.println("minimum -- > " + findMinimum(arr, 0, arr.length - 1));

        arr = new int[]{19, 20, 21, 22, 16, 17, 18};
        System.out.println("minimum -- > " + findMinimum(arr, 0, arr.length - 1));

        arr = new int[]{20, 21, 22, 2, 3, 6, 12, 15, 16, 17, 18, 19};
        System.out.println("minimum -- > " + findMinimum(arr, 0, arr.length - 1));

        arr = new int[]{17, 18, 19, 20, 21, 22};
        System.out.println("minimum -- > " + findMinimum(arr, 0, arr.length - 1));

    }

    static int findMinimum(int[] arr, int from, int to) {
        int diff = to - from;
        if (diff == 1) return arr[to];

        int middle = (to + from) / 2;
        if (arr[middle] < arr[from]) return findMinimum(arr, from, middle);
        if (arr[middle] > arr[to]) return findMinimum(arr, middle, to);
        return arr[from];
    }

}
