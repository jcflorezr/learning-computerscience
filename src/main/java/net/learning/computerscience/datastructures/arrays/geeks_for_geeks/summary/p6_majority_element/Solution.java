package net.learning.computerscience.datastructures.arrays.geeks_for_geeks.summary.p6_majority_element;

/**
 * http://www.geeksforgeeks.org/majority-element/
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int candidate = findCandidate(arr, 1, 0, 0);
        System.out.println(isMajority(arr, 0, candidate, 0) ? candidate : -1);

        arr = new int[]{3, 3, 2, 4, 4, 2, 4, 3};
        candidate = findCandidate(arr, 1, 0, 0);
        System.out.println(isMajority(arr, 0, candidate, 0) ? candidate : -1);
    }

    static int findCandidate(int[] arr, int idx, int majorityIdx, int count) {
        if (idx == arr.length) return arr[majorityIdx];
        if (arr[idx] == arr[majorityIdx]) return findCandidate(arr, ++idx, majorityIdx, ++count);
        else {
            if (--count == 0) {
                majorityIdx = idx;
                count++;
            }
            return findCandidate(arr, ++idx, majorityIdx, count);
        }
    }

    private static boolean isMajority(int[] arr, int idx, int candidate, int count) {
        if (idx == arr.length) return count > arr.length / 2 ? true : false;
        if (arr[idx] == candidate) count++;
        return isMajority(arr, ++idx, candidate, count);
    }

}
