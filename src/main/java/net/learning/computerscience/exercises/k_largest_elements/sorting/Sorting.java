package net.learning.computerscience.exercises.k_largest_elements.sorting;

import java.util.*;

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
