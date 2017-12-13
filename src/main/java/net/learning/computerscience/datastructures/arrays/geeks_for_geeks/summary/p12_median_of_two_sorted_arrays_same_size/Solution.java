package net.learning.computerscience.datastructures.arrays.geeks_for_geeks.summary.p12_median_of_two_sorted_arrays_same_size;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 2, 3, 6};
        int[] arr2 = new int[] {4, 6, 8, 10};
        System.out.println(findMedian(arr1, arr2));

        arr1 = new int[] {1, 12, 15, 26, 38};
        arr2 = new int[] {2, 13, 17, 30, 45};
        System.out.println(findMedian(arr1, arr2));

        arr1 = new int[] {1, 12, 15, 26, 38, 39, 45};
        arr2 = new int[] {2, 13, 17, 30, 45, 47, 50};
        System.out.println(findMedian(arr1, arr2));
    }

    static int findMedian(int[] arr1, int[] arr2) {
        if (arr1.length == 2 && arr2.length == 2)
            return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1])) / 2;
        int midIdx = arr1.length / 2;
        boolean isEven = arr1.length % 2 == 0;
        int m1 = isEven ? (arr1[midIdx - 1] + arr1[midIdx]) / 2 : arr1[midIdx];
        int m2 = isEven ? (arr2[midIdx - 1] + arr2[midIdx]) / 2 : arr2[midIdx];
        if (m1 == m2) return m1;
        if (m1 > m2) return findMedian(Arrays.copyOfRange(arr1, 0, isEven ? midIdx: midIdx + 1),
                                       Arrays.copyOfRange(arr2, midIdx, arr2.length));
        else return findMedian(Arrays.copyOfRange(arr1, midIdx, arr1.length),
                               Arrays.copyOfRange(arr2, 0, isEven ? midIdx : midIdx + 1));
    }

}
