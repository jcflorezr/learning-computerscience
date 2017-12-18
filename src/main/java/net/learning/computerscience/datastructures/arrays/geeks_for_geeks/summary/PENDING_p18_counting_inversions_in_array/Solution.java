package net.learning.computerscience.datastructures.arrays.geeks_for_geeks.summary.PENDING_p18_counting_inversions_in_array;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/counting-inversions/
 * I HAVE NOT FOUND A WAY TO RETURN THE 'COUNT' VALUE INSTEAD OF
 * THE SORTED ARRAY
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 4, 8, 10, 2, 6, 9, 12, 11, 3, 7};
        System.out.println(countInversions(arr, 0, arr.length - 1, 0));
    }

    private static int[] countInversions(int[] arr, int low, int high, Integer count) {
        if (Math.abs(low - high) <= 1) return sort(Arrays.copyOfRange(arr, low, high + 1), count);
        int mid = (low + high) / 2;
        int[] arr1 = countInversions(arr, low, mid, count);
        int[] arr2 = countInversions(arr, mid + 1, high, count);
        int[] arrrrr = merge(arr1, arr2, count);
        return arrrrr;
    }

    private static int[] merge(int[] arr1, int[] arr2, Integer count) {
        return merge(arr1, arr2, 0, 0, count, new int[arr1.length + arr2.length], 0);
    }

    private static int[] merge(int[] arr1, int[] arr2, int i, int j, Integer count, int[] mergedArray, int idxMergedArray) {
        if (idxMergedArray == mergedArray.length) return mergedArray;
        if (i == arr1.length) {
            mergedArray[idxMergedArray] = arr2[j++];
        } else if (j == arr2.length) {
            mergedArray[idxMergedArray] = arr1[i++];
        } else {
            if (arr1[i] <= arr2[j]) mergedArray[idxMergedArray] = arr1[i++];
            else {
                mergedArray[idxMergedArray] = arr2[j++];
                count+=1;
            }
        }
        return merge(arr1, arr2, i, j, count, mergedArray, ++idxMergedArray);
    }

    private static int[] sort(int[] arr, Integer count) {
        if (arr.length == 2 && arr[0] > arr[1]) {
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
            count+=1;
        }
        return arr;
    }

}
