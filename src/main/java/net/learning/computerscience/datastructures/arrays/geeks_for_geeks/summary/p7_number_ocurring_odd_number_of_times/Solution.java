package net.learning.computerscience.datastructures.arrays.geeks_for_geeks.summary.p7_number_ocurring_odd_number_of_times;

/**
 * http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        System.out.println(findOddOcurrence(arr, 0, 0));
    }

    private static int findOddOcurrence(int[] arr, int i, int xoredValue) {
        if (i == arr.length) return xoredValue;
        xoredValue = xoredValue ^ arr[i];
        return findOddOcurrence(arr, ++i, xoredValue);
    }

}
