package net.learning.computerscience.datastructures.topic1_arrays.geeks_for_geeks.summary.p13_array_rotation;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/array-rotation/
 */
public class FantasticSolution {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(leftRotateArray(array, 2)));

    }

    static int[] leftRotateArray(int[] array, int numRotations) {
        int n = array.length;
        for(int i = 0; i < n; i++) {
            array[(i + n - numRotations) % n] = array[i];
        }
        return array;
    }

}
