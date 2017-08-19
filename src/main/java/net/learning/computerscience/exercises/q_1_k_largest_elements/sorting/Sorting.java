package net.learning.computerscience.exercises.q_1_k_largest_elements.sorting;

import java.util.*;

/*
    from: http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 */
public class Sorting {

    public static void main(String[] args) {
        int[] array = new int[] {1,23,12,9,30,2,50};
        int k = 3;
        Arrays.sort(array);
        for (int i = array.length - 1; i > (array.length - k) - 1 ; i--) {
            System.out.println(array[i]);
        }
    }

}
