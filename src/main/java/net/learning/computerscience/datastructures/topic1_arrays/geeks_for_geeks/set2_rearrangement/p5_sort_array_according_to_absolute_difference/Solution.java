package net.learning.computerscience.datastructures.topic1_arrays.geeks_for_geeks.set2_rearrangement.p5_sort_array_according_to_absolute_difference;

import java.util.Map;
import java.util.TreeMap;

/**
 * http://www.geeksforgeeks.org/sort-an-array-according-to-absolute-difference-with-given-value/
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = {10, 5, 3, 9, 2};
        int x = 7;
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            int absolute = Math.abs(array[i] - x);
            int current = array[i];
            String s = map.computeIfPresent(absolute, (key, existing) -> existing + "-" + current);
            if (s != null) {
                map.put(absolute, s);
            } else {
                map.put(absolute, String.valueOf(current));
            }
        }
        System.out.println(map.toString());
    }

}
