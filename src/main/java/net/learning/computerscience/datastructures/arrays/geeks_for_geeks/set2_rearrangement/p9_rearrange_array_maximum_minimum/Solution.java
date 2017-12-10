package net.learning.computerscience.datastructures.arrays.geeks_for_geeks.set2_rearrangement.p9_rearrange_array_maximum_minimum;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int maxElement = arr[arr.length - 1] + 1;
        arr = rearrangeArray(arr, maxElement, 0, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElement;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * min index = 0
     * max index = n - 1
     * max maxElement = arr[n - 1] + 1
     */
    static int[] rearrangeArray(int[] arr, int maxElement, int idx, int minIdx, int maxIdx) {
        if (idx == arr.length) return arr;
        if (idx % 2 == 0) {
            arr[idx] += (arr[maxIdx] % maxElement) * maxElement;
            return rearrangeArray(arr, maxElement, idx + 1, minIdx, maxIdx - 1);
        } else {
            arr[idx] += (arr[minIdx] % maxElement) * maxElement;
            return rearrangeArray(arr, maxElement, idx + 1, minIdx + 1, maxIdx);
        }
    }

}
