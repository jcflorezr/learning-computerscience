package net.learning.computerscience.datastructures.topic1_arrays.geeks_for_geeks.summary.p8_largest_sum_contiguous_subarray;

/**
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class Solution {

    public static void main(String[] args) {
        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(arr, 0, 0, 0));
    }

    static int maxSubArraySum(int[] arr, int i, int maxEndingHere, int maxSoFar) {
        if (i == arr.length) return maxSoFar;
        maxEndingHere += arr[i];
        if (maxEndingHere < 0) maxEndingHere = 0;
        else if (maxEndingHere > maxSoFar) maxSoFar = maxEndingHere;
        return maxSubArraySum(arr, ++i, maxEndingHere, maxSoFar);
    }

}
