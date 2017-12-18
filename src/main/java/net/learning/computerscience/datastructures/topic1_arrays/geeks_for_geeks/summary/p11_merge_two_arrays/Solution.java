package net.learning.computerscience.datastructures.topic1_arrays.geeks_for_geeks.summary.p11_merge_two_arrays;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
 */
public class Solution {

    public static void main(String[] args) {
        int arrN[] = {5, 7, 9, 25};
        int arrM[] = {2, 8, 13, 15, 20};
        int n = arrN.length;
        int m = arrM.length;
        System.out.println(Arrays.toString(mergeArrays(arrN, arrM, 0, 0, new int[n + m], 0)));
    }

    static int[] mergeArrays(int[] arrN, int[] arrM, int n, int m, int[] mergedArr, int i) {
        if (i == mergedArr.length) return mergedArr;
        if (n == arrN.length) return insertRemainingValues(arrM, mergedArr, m, i);
        if (m == arrM.length) return insertRemainingValues(arrN, mergedArr, n, i);
        if (arrN[n] <= arrM[m]) {
            mergedArr[i] = arrN[n];
            return mergeArrays(arrN, arrM, ++n, m, mergedArr, ++i);
        } else {
            mergedArr[i] = arrM[m];
            return mergeArrays(arrN, arrM, n, ++m, mergedArr, ++i);
        }
    }

    private static int[] insertRemainingValues(int[] arr, int[] mergedArr, int size, int i) {
        if (size == arr.length) return mergedArr;
        mergedArr[i] = arr[size];
        return insertRemainingValues(arr, mergedArr, ++size, ++i);
    }

}
