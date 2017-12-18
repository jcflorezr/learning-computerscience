package net.learning.computerscience.datastructures.topic1_arrays.geeks_for_geeks.set2_rearrangement.p7_partitioning_array_in_3_range_groups;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/
 *
 * IT SEEMS DUTCH NATIONAL FLAG ALGORITHM DOES NOT WORK FOR A RANGE OF NUMBERS...
 * CHECK SECOND TEST CASE...
 *
 */
public class Solution {

    public static void main(String[] args) {
        int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        int lowVal = 14;
        int highVal = 20;

        System.out.println(Arrays.toString(partitioningArray(arr, 0, 0, arr.length - 1, lowVal, highVal)));

        arr = new int[]{1, 5, 14, 19, 4, 25};
        lowVal = 14;
        highVal = 24;

        System.out.println(Arrays.toString(partitioningArray(arr, 0, 0, arr.length - 1, lowVal, highVal)));

    }

    private static int[] partitioningArray(int[] arr, int low, int mid, int high, int lowVal, int highVal) {
        if (mid > high) return arr;
        int temp = 0;
        if (arr[mid] < lowVal) {
            temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;
            return partitioningArray(arr, low + 1, mid + 1, high, lowVal, highVal);
        } else if (arr[mid] >= lowVal && arr[mid] <= highVal) {
            return partitioningArray(arr, low, mid + 1, high, lowVal, highVal);
        } else {
            temp = arr[high];
            arr[high] = arr[mid];
            arr[mid] = temp;
            return partitioningArray(arr, low, mid, high - 1, lowVal, highVal);
        }
    }

}
