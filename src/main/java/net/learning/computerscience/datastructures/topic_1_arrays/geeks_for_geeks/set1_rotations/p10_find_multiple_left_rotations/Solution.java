package net.learning.computerscience.datastructures.topic_1_arrays.geeks_for_geeks.set1_rotations.p10_find_multiple_left_rotations;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/quickly-find-multiple-left-rotations-of-an-array/
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(Arrays.toString(leftRotate(arr, 1)));
        System.out.println(Arrays.toString(leftRotate(arr, 3)));
        System.out.println(Arrays.toString(leftRotate(arr, 4)));
        System.out.println(Arrays.toString(leftRotate(arr, 6)));
        System.out.println(Arrays.toString(leftRotate(arr, 14)));
    }

    static int[] leftRotate(int[] arr, int k) {
        int[] mutatedArray = new int[arr.length];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int finalPos = (n - (k % n)) + i;
            finalPos = finalPos >= n ? finalPos - n : finalPos;
            mutatedArray[finalPos] = arr[i];
        }
        return mutatedArray;
    }

}
