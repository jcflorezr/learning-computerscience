package net.learning.computerscience.datastructures.arrays.geeks_for_geeks.set2_rearrangement.p1_rearrange_positive_and_negative_numbers;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        arr = groupNumbers(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
        arr = rearrangeNumbers(arr, 1, 2);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {14, 23, -3, 6, -2, 5, -80};
        arr = groupNumbers(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
        arr = rearrangeNumbers(arr, 1, 2);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {-14, -23, -3, -6, -2, -5, 80};
        arr = groupNumbers(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
        arr = rearrangeNumbers(arr, 1, 2);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {14, -23, -3, -6, -2, -5, 80};
        arr = groupNumbers(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
        arr = rearrangeNumbers(arr, 1, 2);
        System.out.println(Arrays.toString(arr));
    }

    static int[] groupNumbers(int[] arr, int current, int next) {
        if (next == arr.length) return arr;
        if (arr[current] < 0) return groupNumbers(arr, current + 1, next + 1);
        if (arr[next] > 0) return groupNumbers(arr, current, next + 1);
        int temp = arr[current];
        arr[current] = arr[next];
        arr[next] = temp;
        return groupNumbers(arr, current + 1, current + 2);
    }

    static int[] rearrangeNumbers(int[] arr, int current, int next) {
        if (current == arr.length || next == arr.length) return arr;
        if (arr[next] < 0) return rearrangeNumbers(arr, current, next + 1);
        int temp = arr[current];
        arr[current] = arr[next];
        arr[next] = temp;
        return rearrangeNumbers(arr, current + 2, next + 1);
    }

}
