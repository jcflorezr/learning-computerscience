package net.learning.computerscience.datastructures.topic_2_matrices.geeks_for_geeks.summary.p4_print_unique_rows_in_boolean_matrix;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * https://www.geeksforgeeks.org/print-unique-rows/
 */
public class Solution {

    public static void main(String[] args) {
        int mat[][] = {{0, 1, 0, 0, 1},
                       {1, 0, 1, 1, 0},
                       {0, 1, 0, 0, 1},
                       {1, 1, 1, 0, 0}};
        TreeMap<Integer, Integer> treeMap = getUniqueRows(mat, new TreeMap<>(), 0);
        treeMap.forEach((key, value) -> System.out.println(Arrays.toString(mat[key])));
    }

    private static TreeMap<Integer, Integer> getUniqueRows(int[][] mat, TreeMap<Integer, Integer> treeMap, int i) {
        if (i == mat.length) return treeMap;
        int sumRow = getSumOfElementsInRow(mat[i], 0, 0);
        if (!treeMap.containsValue(sumRow)) {
            treeMap.put(i, sumRow);
        }
        return getUniqueRows(mat, treeMap, ++i);
    }

    private static int getSumOfElementsInRow(int[] row, int j, int sum) {
        if(j == row.length) return sum;
        return getSumOfElementsInRow(row, j + 1, sum + row[j]);
    }

}
