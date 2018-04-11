package net.learning.computerscience.datastructures.topic_2_matrices.geeks_for_geeks.summary.p1_search_in_row_wise_and_column_wise_sorted_matrix;

/**
 * http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 */
public class Solution {

    public static void main(String[] args) {
        int[][] mat =
               {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        int element = 29;
        System.out.println(findElement(mat, 0, mat[0].length - 1, element));
        element = 100;
        System.out.println(findElement(mat, 0, mat[0].length - 1, element));
        element = 9;
        System.out.println(findElement(mat, 0, mat[0].length - 1, element));
        element = 37;
        System.out.println(findElement(mat, 0, mat[0].length - 1, element));
    }

    private static String findElement(int[][] mat, int i, int j, int element) {
        if ((i < 0 || j < 0) || (i == mat.length || j == mat[0].length)) return "not found";
        if (element < mat[i][j]) return findElement(mat, i, --j, element);
        if (element > mat[i][j]) return findElement(mat, ++i, j, element);
        return "Found at: (" + i + ", " + j + ")";
    }

}
