package net.learning.computerscience.datastructures.topic1_arrays.geeks_for_geeks.summary.p16_max_sum_subsequence_non_adjacent;

/**
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        System.out.println(findSumMaxSubsequence(arr, 0, 0, 0));
        arr = new int[]{4, 1, 1, 4, 2, 1};
        System.out.println(findSumMaxSubsequence(arr, 0, 0, 0));
        arr = new int[]{1, 2, 3};
        System.out.println(findSumMaxSubsequence(arr, 0, 0, 0));
        arr = new int[]{1, 20, 3};
        System.out.println(findSumMaxSubsequence(arr, 0, 0, 0));
    }

    private static int findSumMaxSubsequence(int[] arr, int i, int inclusive, int exclusive) {
        if (i == arr.length) return inclusive;
        return findSumMaxSubsequence(arr, i + 1, Math.max(exclusive + arr[i], inclusive), inclusive);
    }

}
