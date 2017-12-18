package net.learning.computerscience.datastructures.topic1_arrays.geeks_for_geeks.set2_rearrangement.p2_reverse_array;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[] {4, 5, 1, 2};
        System.out.println(Arrays.toString(reverseArray(arr, 0, arr.length - 1)));

        arr = new int[] {4, 5, 1, 2, 32, 6, 65, 32, 1, 1};
        System.out.println(Arrays.toString(reverseArray(arr, 0, arr.length - 1)));

        arr = new int[] {1, 2, 3, 6, 5, 4, 7, 8, 9};
        System.out.println(Arrays.toString(reverseArray(arr, 0, arr.length - 1)));
    }

    static int[] reverseArray(int[] arr, int low, int high) {
        if (low == high || low > high) return arr;
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        return reverseArray(arr, low + 1, high - 1);
    }

}
