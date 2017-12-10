package net.learning.computerscience.datastructures.arrays.geeks_for_geeks.set2_rearrangement.p4_arrange_positive_and_negative_numbers_in_linear_space;

import java.util.Arrays;

/**
 *  http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/
 *
 *  QUADRATIC SOLUTION... IT SHOULD BE IMPROVED
 *  (IT IS ONLY POSSIBLE TO ACHIEVE LOGARITHMIC SPACE)
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println(Arrays.toString(groupNumbers(arr, 0, 0)));

        arr = new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9};
        System.out.println(Arrays.toString(groupNumbers(arr, 0, 0)));

        arr = new int[] {14, 23, -3, 6, -2, 5, -80};
        System.out.println(Arrays.toString(groupNumbers(arr, 0, 0)));

        arr = new int[] {-14, -23, -3, -6, -2, -5, 80};
        System.out.println(Arrays.toString(groupNumbers(arr, 0, 0)));

        arr = new int[] {14, -23, -3, -6, -2, -5, 80};
        System.out.println(Arrays.toString(groupNumbers(arr, 0, 0)));
    }

    static int[] groupNumbers(int[] arr, int current, int numNegatives) {
        if (current == arr.length) return arr;
        if (arr[current] < 0) {
            rearrangeNegative(arr, current, numNegatives);
            numNegatives += 1;
        }
        return groupNumbers(arr, current + 1, numNegatives);
    }

    static int[] rearrangeNegative(int[] arr, int current, int until) {
        if (current == until) return arr;
        int temp = arr[current];
        arr[current] = arr[current - 1];
        arr[current - 1] = temp;
        return rearrangeNegative(arr, current - 1, until);
    }

}
