package net.learning.computerscience.exercises.q_4_product_array_puzzle;

/**
 * from: http://www.geeksforgeeks.org/a-product-array-puzzle/
 *
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size)
 * such that prod[i] is equal to the product of all the elements of arr[] except arr[i].
 * Solve it without division operator and in O(n).
 * Example:
 * arr[] = {10, 3, 5, 6, 2}
 * prod[] = {180, 600, 360, 300, 900}
 *
 */
public class ProductArrayPuzzle {

    public static void main(String[] args) {
        int arr[] = {10, 3, 5, 6, 2};
        int n = arr.length;
        System.out.println("The product array is : ");
        productArray(arr, n);
    }

    private static void productArray(int[] arr, int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        int[] prod = new int[n];

        int i, j;
        left[0] = 1;
        right[n-1] = 1;

        for (i = 1; i < n; i++) {
            left[i] = arr[i - 1] * left[i - 1];
        }

        for (j = n - 2; j >= 0; j--) {
            right[j] = arr[j + 1] * right[j + 1];
        }

        for (i = 0; i < n; i++) {
            prod[i] = left[i] * right[i];
        }

        for (i = 0; i < n; i++) {
            System.out.print(prod[i] + " ");
        }
        return;
    }

}
