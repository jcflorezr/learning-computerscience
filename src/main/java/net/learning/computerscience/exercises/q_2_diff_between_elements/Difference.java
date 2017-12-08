package net.learning.computerscience.exercises.q_2_diff_between_elements;

import java.util.Arrays;

/**
 * from: http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 *
 * Given an arrays arr[] of integers, find out the difference between any two elements
 * such that larger element appears after the smaller number in arr[].
 * Examples: If arrays is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2).
 * If arrays is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
 */
public class Difference {

    public static void main(String[] args) {
        int[] array = new int[] {7,9,5,6,3,2};
        int min = array[0];
        int difference = 0;
        for (int i = 1; i < array.length - 1 ; i++) {
            if (array[i] > array[i - 1]) {
                int tempMin = array[i - 1];
                min = (tempMin < min) ? tempMin : min;
                int tempDifference = array[i] - min;
                difference = (difference < tempDifference) ? tempDifference : difference;
            }
        }
        System.out.println(difference);
    }

}
